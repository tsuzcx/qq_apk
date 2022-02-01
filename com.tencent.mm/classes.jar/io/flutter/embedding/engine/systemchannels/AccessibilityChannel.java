package io.flutter.embedding.engine.systemchannels;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.FlutterJNI.AccessibilityDelegate;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BasicMessageChannel.MessageHandler;
import io.flutter.plugin.common.BasicMessageChannel.Reply;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.view.AccessibilityBridge.Action;
import java.util.HashMap;

public class AccessibilityChannel
{
  private static final String TAG = "AccessibilityChannel";
  public final BasicMessageChannel<Object> channel;
  public final FlutterJNI flutterJNI;
  private AccessibilityMessageHandler handler;
  private final BasicMessageChannel.MessageHandler<Object> parsingMessageHandler;
  
  public AccessibilityChannel(DartExecutor paramDartExecutor, FlutterJNI paramFlutterJNI)
  {
    AppMethodBeat.i(10262);
    this.parsingMessageHandler = new BasicMessageChannel.MessageHandler()
    {
      public void onMessage(Object paramAnonymousObject, BasicMessageChannel.Reply<Object> paramAnonymousReply)
      {
        AppMethodBeat.i(190193);
        if (AccessibilityChannel.this.handler == null)
        {
          AppMethodBeat.o(190193);
          return;
        }
        paramAnonymousObject = (HashMap)paramAnonymousObject;
        String str = (String)paramAnonymousObject.get("type");
        HashMap localHashMap = (HashMap)paramAnonymousObject.get("data");
        Log.v("AccessibilityChannel", "Received " + str + " message.");
        int i;
        switch (str.hashCode())
        {
        default: 
          i = -1;
          label126:
          switch (i)
          {
          }
          break;
        }
        for (;;)
        {
          paramAnonymousReply.reply(null);
          AppMethodBeat.o(190193);
          return;
          if (!str.equals("announce")) {
            break;
          }
          i = 0;
          break label126;
          if (!str.equals("tap")) {
            break;
          }
          i = 1;
          break label126;
          if (!str.equals("longPress")) {
            break;
          }
          i = 2;
          break label126;
          if (!str.equals("tooltip")) {
            break;
          }
          i = 3;
          break label126;
          paramAnonymousObject = (String)localHashMap.get("message");
          if (paramAnonymousObject != null)
          {
            AccessibilityChannel.this.handler.announce(paramAnonymousObject);
            continue;
            paramAnonymousObject = (Integer)paramAnonymousObject.get("nodeId");
            if (paramAnonymousObject != null)
            {
              AccessibilityChannel.this.handler.onTap(paramAnonymousObject.intValue());
              continue;
              paramAnonymousObject = (Integer)paramAnonymousObject.get("nodeId");
              if (paramAnonymousObject != null)
              {
                AccessibilityChannel.this.handler.onLongPress(paramAnonymousObject.intValue());
                continue;
                paramAnonymousObject = (String)localHashMap.get("message");
                if (paramAnonymousObject != null) {
                  AccessibilityChannel.this.handler.onTooltip(paramAnonymousObject);
                }
              }
            }
          }
        }
      }
    };
    this.channel = new BasicMessageChannel(paramDartExecutor, "flutter/accessibility", StandardMessageCodec.INSTANCE);
    this.channel.setMessageHandler(this.parsingMessageHandler);
    this.flutterJNI = paramFlutterJNI;
    AppMethodBeat.o(10262);
  }
  
  public void dispatchSemanticsAction(int paramInt, AccessibilityBridge.Action paramAction)
  {
    AppMethodBeat.i(10263);
    this.flutterJNI.dispatchSemanticsAction(paramInt, paramAction);
    AppMethodBeat.o(10263);
  }
  
  public void dispatchSemanticsAction(int paramInt, AccessibilityBridge.Action paramAction, Object paramObject)
  {
    AppMethodBeat.i(10264);
    this.flutterJNI.dispatchSemanticsAction(paramInt, paramAction, paramObject);
    AppMethodBeat.o(10264);
  }
  
  public void onAndroidAccessibilityDisabled()
  {
    AppMethodBeat.i(190322);
    this.flutterJNI.setSemanticsEnabled(false);
    AppMethodBeat.o(190322);
  }
  
  public void onAndroidAccessibilityEnabled()
  {
    AppMethodBeat.i(190317);
    this.flutterJNI.setSemanticsEnabled(true);
    AppMethodBeat.o(190317);
  }
  
  public void setAccessibilityFeatures(int paramInt)
  {
    AppMethodBeat.i(190329);
    this.flutterJNI.setAccessibilityFeatures(paramInt);
    AppMethodBeat.o(190329);
  }
  
  public void setAccessibilityMessageHandler(AccessibilityMessageHandler paramAccessibilityMessageHandler)
  {
    AppMethodBeat.i(10265);
    this.handler = paramAccessibilityMessageHandler;
    this.flutterJNI.setAccessibilityDelegate(paramAccessibilityMessageHandler);
    AppMethodBeat.o(10265);
  }
  
  public static abstract interface AccessibilityMessageHandler
    extends FlutterJNI.AccessibilityDelegate
  {
    public abstract void announce(String paramString);
    
    public abstract void onLongPress(int paramInt);
    
    public abstract void onTap(int paramInt);
    
    public abstract void onTooltip(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.AccessibilityChannel
 * JD-Core Version:    0.7.0.1
 */