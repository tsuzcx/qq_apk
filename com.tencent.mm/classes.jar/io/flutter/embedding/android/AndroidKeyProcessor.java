package io.flutter.embedding.android;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel.EventResponseHandler;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel.FlutterKeyEvent;
import io.flutter.plugin.editing.TextInputPlugin;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class AndroidKeyProcessor
{
  private static final String TAG = "AndroidKeyProcessor";
  private int combiningCharacter;
  private EventResponder eventResponder;
  private final KeyEventChannel keyEventChannel;
  private final TextInputPlugin textInputPlugin;
  
  public AndroidKeyProcessor(View paramView, KeyEventChannel paramKeyEventChannel, TextInputPlugin paramTextInputPlugin)
  {
    AppMethodBeat.i(190364);
    this.keyEventChannel = paramKeyEventChannel;
    this.textInputPlugin = paramTextInputPlugin;
    paramTextInputPlugin.setKeyEventProcessor(this);
    this.eventResponder = new EventResponder(paramView, paramTextInputPlugin);
    this.keyEventChannel.setEventResponseHandler(this.eventResponder);
    AppMethodBeat.o(190364);
  }
  
  private Character applyCombiningCharacterToBaseCharacter(int paramInt)
  {
    AppMethodBeat.i(10057);
    if (paramInt == 0)
    {
      AppMethodBeat.o(10057);
      return null;
    }
    char c1 = (char)paramInt;
    int i;
    char c2;
    if ((0x80000000 & paramInt) != 0)
    {
      i = 1;
      if (i == 0) {
        break label89;
      }
      paramInt = 0x7FFFFFFF & paramInt;
      if (this.combiningCharacter == 0) {
        break label79;
      }
      this.combiningCharacter = KeyCharacterMap.getDeadChar(this.combiningCharacter, paramInt);
      c2 = c1;
    }
    for (;;)
    {
      AppMethodBeat.o(10057);
      return Character.valueOf(c2);
      i = 0;
      break;
      label79:
      this.combiningCharacter = paramInt;
      c2 = c1;
      continue;
      label89:
      c2 = c1;
      if (this.combiningCharacter != 0)
      {
        paramInt = KeyCharacterMap.getDeadChar(this.combiningCharacter, paramInt);
        if (paramInt > 0) {
          c1 = (char)paramInt;
        }
        this.combiningCharacter = 0;
        c2 = c1;
      }
    }
  }
  
  public void destroy()
  {
    AppMethodBeat.i(190372);
    this.keyEventChannel.setEventResponseHandler(null);
    AppMethodBeat.o(190372);
  }
  
  public boolean isPendingEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(190385);
    if (EventResponder.access$100(this.eventResponder, paramKeyEvent) != null)
    {
      AppMethodBeat.o(190385);
      return true;
    }
    AppMethodBeat.o(190385);
    return false;
  }
  
  public boolean onKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(190380);
    int i = paramKeyEvent.getAction();
    if ((i != 0) && (i != 1))
    {
      AppMethodBeat.o(190380);
      return false;
    }
    if (isPendingEvent(paramKeyEvent))
    {
      EventResponder.access$000(this.eventResponder, paramKeyEvent);
      AppMethodBeat.o(190380);
      return false;
    }
    KeyEventChannel.FlutterKeyEvent localFlutterKeyEvent = new KeyEventChannel.FlutterKeyEvent(paramKeyEvent, applyCombiningCharacterToBaseCharacter(paramKeyEvent.getUnicodeChar()));
    this.eventResponder.addEvent(paramKeyEvent);
    if (i == 0) {
      this.keyEventChannel.keyDown(localFlutterKeyEvent);
    }
    for (;;)
    {
      AppMethodBeat.o(190380);
      return true;
      this.keyEventChannel.keyUp(localFlutterKeyEvent);
    }
  }
  
  static class EventResponder
    implements KeyEventChannel.EventResponseHandler
  {
    private static final long MAX_PENDING_EVENTS = 1000L;
    final Deque<KeyEvent> pendingEvents;
    private final TextInputPlugin textInputPlugin;
    private final View view;
    
    public EventResponder(View paramView, TextInputPlugin paramTextInputPlugin)
    {
      AppMethodBeat.i(190386);
      this.pendingEvents = new ArrayDeque();
      this.view = paramView;
      this.textInputPlugin = paramTextInputPlugin;
      AppMethodBeat.o(190386);
    }
    
    private KeyEvent findPendingEvent(KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(190400);
      Iterator localIterator = this.pendingEvents.iterator();
      while (localIterator.hasNext())
      {
        KeyEvent localKeyEvent = (KeyEvent)localIterator.next();
        if (localKeyEvent == paramKeyEvent)
        {
          AppMethodBeat.o(190400);
          return localKeyEvent;
        }
      }
      AppMethodBeat.o(190400);
      return null;
    }
    
    private void redispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(190407);
      if ((this.textInputPlugin.getInputMethodManager().isAcceptingText()) && (this.textInputPlugin.getLastInputConnection() != null) && (this.textInputPlugin.getLastInputConnection().sendKeyEvent(paramKeyEvent)))
      {
        removePendingEvent(paramKeyEvent);
        AppMethodBeat.o(190407);
        return;
      }
      if (this.view != null) {
        this.view.getRootView().dispatchKeyEvent(paramKeyEvent);
      }
      AppMethodBeat.o(190407);
    }
    
    private void removePendingEvent(KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(190391);
      this.pendingEvents.remove(paramKeyEvent);
      AppMethodBeat.o(190391);
    }
    
    public void addEvent(KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(190452);
      this.pendingEvents.addLast(paramKeyEvent);
      if (this.pendingEvents.size() > 1000L) {
        Log.e("AndroidKeyProcessor", "There are " + this.pendingEvents.size() + " keyboard events that have not yet received a response. Are responses being sent?");
      }
      AppMethodBeat.o(190452);
    }
    
    public void onKeyEventHandled(KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(190433);
      removePendingEvent(paramKeyEvent);
      AppMethodBeat.o(190433);
    }
    
    public void onKeyEventNotHandled(KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(190443);
      redispatchKeyEvent(findPendingEvent(paramKeyEvent));
      AppMethodBeat.o(190443);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.android.AndroidKeyProcessor
 * JD-Core Version:    0.7.0.1
 */