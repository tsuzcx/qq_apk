package io.flutter.embedding.engine.systemchannels;

import android.os.Build.VERSION;
import android.view.InputDevice;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BasicMessageChannel.Reply;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.JSONMessageCodec;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class KeyEventChannel
{
  private static final String TAG = "KeyEventChannel";
  public final BasicMessageChannel<Object> channel;
  private EventResponseHandler eventResponseHandler;
  
  public KeyEventChannel(BinaryMessenger paramBinaryMessenger)
  {
    AppMethodBeat.i(190161);
    this.channel = new BasicMessageChannel(paramBinaryMessenger, "flutter/keyevent", JSONMessageCodec.INSTANCE);
    AppMethodBeat.o(190161);
  }
  
  private void encodeKeyEvent(FlutterKeyEvent paramFlutterKeyEvent, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(10234);
    paramMap.put("flags", Integer.valueOf(paramFlutterKeyEvent.event.getFlags()));
    paramMap.put("plainCodePoint", Integer.valueOf(paramFlutterKeyEvent.event.getUnicodeChar(0)));
    paramMap.put("codePoint", Integer.valueOf(paramFlutterKeyEvent.event.getUnicodeChar()));
    paramMap.put("keyCode", Integer.valueOf(paramFlutterKeyEvent.event.getKeyCode()));
    paramMap.put("scanCode", Integer.valueOf(paramFlutterKeyEvent.event.getScanCode()));
    paramMap.put("metaState", Integer.valueOf(paramFlutterKeyEvent.event.getMetaState()));
    if (paramFlutterKeyEvent.complexCharacter != null) {
      paramMap.put("character", paramFlutterKeyEvent.complexCharacter.toString());
    }
    paramMap.put("source", Integer.valueOf(paramFlutterKeyEvent.event.getSource()));
    InputDevice localInputDevice = InputDevice.getDevice(paramFlutterKeyEvent.event.getDeviceId());
    int j;
    int i;
    if ((localInputDevice != null) && (Build.VERSION.SDK_INT >= 19))
    {
      j = localInputDevice.getVendorId();
      i = localInputDevice.getProductId();
    }
    for (;;)
    {
      paramMap.put("vendorId", Integer.valueOf(j));
      paramMap.put("productId", Integer.valueOf(i));
      paramMap.put("deviceId", Integer.valueOf(paramFlutterKeyEvent.event.getDeviceId()));
      paramMap.put("repeatCount", Integer.valueOf(paramFlutterKeyEvent.event.getRepeatCount()));
      AppMethodBeat.o(10234);
      return;
      i = 0;
      j = 0;
    }
  }
  
  BasicMessageChannel.Reply<Object> createReplyHandler(final KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(190195);
    paramKeyEvent = new BasicMessageChannel.Reply()
    {
      public void reply(Object paramAnonymousObject)
      {
        AppMethodBeat.i(190206);
        if (KeyEventChannel.this.eventResponseHandler == null)
        {
          AppMethodBeat.o(190206);
          return;
        }
        if (paramAnonymousObject == null) {}
        try
        {
          KeyEventChannel.this.eventResponseHandler.onKeyEventNotHandled(paramKeyEvent);
          AppMethodBeat.o(190206);
          return;
        }
        catch (JSONException paramAnonymousObject)
        {
          Log.e("KeyEventChannel", "Unable to unpack JSON message: ".concat(String.valueOf(paramAnonymousObject)));
          KeyEventChannel.this.eventResponseHandler.onKeyEventNotHandled(paramKeyEvent);
          AppMethodBeat.o(190206);
          return;
        }
        if (((JSONObject)paramAnonymousObject).getBoolean("handled"))
        {
          KeyEventChannel.this.eventResponseHandler.onKeyEventHandled(paramKeyEvent);
          AppMethodBeat.o(190206);
          return;
        }
        KeyEventChannel.this.eventResponseHandler.onKeyEventNotHandled(paramKeyEvent);
        AppMethodBeat.o(190206);
      }
    };
    AppMethodBeat.o(190195);
    return paramKeyEvent;
  }
  
  public void keyDown(FlutterKeyEvent paramFlutterKeyEvent)
  {
    AppMethodBeat.i(190217);
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", "keydown");
    localHashMap.put("keymap", "android");
    encodeKeyEvent(paramFlutterKeyEvent, localHashMap);
    this.channel.send(localHashMap, createReplyHandler(paramFlutterKeyEvent.event));
    AppMethodBeat.o(190217);
  }
  
  public void keyUp(FlutterKeyEvent paramFlutterKeyEvent)
  {
    AppMethodBeat.i(190204);
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", "keyup");
    localHashMap.put("keymap", "android");
    encodeKeyEvent(paramFlutterKeyEvent, localHashMap);
    this.channel.send(localHashMap, createReplyHandler(paramFlutterKeyEvent.event));
    AppMethodBeat.o(190204);
  }
  
  public void setEventResponseHandler(EventResponseHandler paramEventResponseHandler)
  {
    this.eventResponseHandler = paramEventResponseHandler;
  }
  
  public static abstract interface EventResponseHandler
  {
    public abstract void onKeyEventHandled(KeyEvent paramKeyEvent);
    
    public abstract void onKeyEventNotHandled(KeyEvent paramKeyEvent);
  }
  
  public static class FlutterKeyEvent
  {
    public final Character complexCharacter;
    public final KeyEvent event;
    
    public FlutterKeyEvent(KeyEvent paramKeyEvent)
    {
      this(paramKeyEvent, null);
    }
    
    public FlutterKeyEvent(KeyEvent paramKeyEvent, Character paramCharacter)
    {
      AppMethodBeat.i(10254);
      this.event = paramKeyEvent;
      this.complexCharacter = paramCharacter;
      AppMethodBeat.o(10254);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.KeyEventChannel
 * JD-Core Version:    0.7.0.1
 */