package io.flutter.embedding.engine.systemchannels;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.JSONMessageCodec;
import java.util.HashMap;
import java.util.Map;

public class SettingsChannel
{
  private static final String ALWAYS_USE_24_HOUR_FORMAT = "alwaysUse24HourFormat";
  public static final String CHANNEL_NAME = "flutter/settings";
  private static final String PLATFORM_BRIGHTNESS = "platformBrightness";
  private static final String TAG = "SettingsChannel";
  private static final String TEXT_SCALE_FACTOR = "textScaleFactor";
  public final BasicMessageChannel<Object> channel;
  
  public SettingsChannel(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10269);
    this.channel = new BasicMessageChannel(paramDartExecutor, "flutter/settings", JSONMessageCodec.INSTANCE);
    AppMethodBeat.o(10269);
  }
  
  public MessageBuilder startMessage()
  {
    AppMethodBeat.i(10270);
    MessageBuilder localMessageBuilder = new MessageBuilder(this.channel);
    AppMethodBeat.o(10270);
    return localMessageBuilder;
  }
  
  public static class MessageBuilder
  {
    private final BasicMessageChannel<Object> channel;
    private Map<String, Object> message;
    
    MessageBuilder(BasicMessageChannel<Object> paramBasicMessageChannel)
    {
      AppMethodBeat.i(10280);
      this.message = new HashMap();
      this.channel = paramBasicMessageChannel;
      AppMethodBeat.o(10280);
    }
    
    public void send()
    {
      AppMethodBeat.i(10284);
      Log.v("SettingsChannel", "Sending message: \ntextScaleFactor: " + this.message.get("textScaleFactor") + "\nalwaysUse24HourFormat: " + this.message.get("alwaysUse24HourFormat") + "\nplatformBrightness: " + this.message.get("platformBrightness"));
      this.channel.send(this.message);
      AppMethodBeat.o(10284);
    }
    
    public MessageBuilder setPlatformBrightness(SettingsChannel.PlatformBrightness paramPlatformBrightness)
    {
      AppMethodBeat.i(10283);
      this.message.put("platformBrightness", paramPlatformBrightness.name);
      AppMethodBeat.o(10283);
      return this;
    }
    
    public MessageBuilder setTextScaleFactor(float paramFloat)
    {
      AppMethodBeat.i(10281);
      this.message.put("textScaleFactor", Float.valueOf(paramFloat));
      AppMethodBeat.o(10281);
      return this;
    }
    
    public MessageBuilder setUse24HourFormat(boolean paramBoolean)
    {
      AppMethodBeat.i(10282);
      this.message.put("alwaysUse24HourFormat", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(10282);
      return this;
    }
  }
  
  public static enum PlatformBrightness
  {
    public String name;
    
    static
    {
      AppMethodBeat.i(10268);
      light = new PlatformBrightness("light", 0, "light");
      dark = new PlatformBrightness("dark", 1, "dark");
      $VALUES = new PlatformBrightness[] { light, dark };
      AppMethodBeat.o(10268);
    }
    
    private PlatformBrightness(String paramString)
    {
      this.name = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.SettingsChannel
 * JD-Core Version:    0.7.0.1
 */