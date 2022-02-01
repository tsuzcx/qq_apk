package com.tencent.thumbplayer.core.common;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class TPAudioPassThroughCapabilities
{
  public static final TPAudioPassThroughCapabilities DEFAULT_AUDIO_CAPABILITIES;
  private static final int DEFAULT_MAX_CHANNEL_COUNT = 8;
  private static final TPAudioPassThroughCapabilities EXTERNAL_SURROUND_SOUND_CAPABILITIES;
  private static final String EXTERNAL_SURROUND_SOUND_KEY = "external_surround_sound_enabled";
  private final int maxChannelCount;
  private final int[] supportedEncodings;
  
  static
  {
    AppMethodBeat.i(227631);
    DEFAULT_AUDIO_CAPABILITIES = new TPAudioPassThroughCapabilities(new int[] { 2 }, 8);
    EXTERNAL_SURROUND_SOUND_CAPABILITIES = new TPAudioPassThroughCapabilities(new int[] { 2, 5, 6 }, 8);
    AppMethodBeat.o(227631);
  }
  
  public TPAudioPassThroughCapabilities(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(227619);
    if (paramArrayOfInt != null)
    {
      this.supportedEncodings = Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length);
      Arrays.sort(this.supportedEncodings);
    }
    for (;;)
    {
      this.maxChannelCount = paramInt;
      AppMethodBeat.o(227619);
      return;
      this.supportedEncodings = new int[0];
    }
  }
  
  public static TPAudioPassThroughCapabilities getCapabilities(Context paramContext)
  {
    AppMethodBeat.i(227591);
    paramContext = getCapabilities(paramContext, paramContext.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    AppMethodBeat.o(227591);
    return paramContext;
  }
  
  static TPAudioPassThroughCapabilities getCapabilities(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(227605);
    if ((paramIntent == null) || (paramIntent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0))
    {
      paramContext = DEFAULT_AUDIO_CAPABILITIES;
      AppMethodBeat.o(227605);
      return paramContext;
    }
    paramContext = new TPAudioPassThroughCapabilities(paramIntent.getIntArrayExtra("android.media.extra.ENCODINGS"), paramIntent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8));
    AppMethodBeat.o(227605);
    return paramContext;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(227666);
    if (this == paramObject)
    {
      AppMethodBeat.o(227666);
      return true;
    }
    if (!(paramObject instanceof TPAudioPassThroughCapabilities))
    {
      AppMethodBeat.o(227666);
      return false;
    }
    paramObject = (TPAudioPassThroughCapabilities)paramObject;
    if ((Arrays.equals(this.supportedEncodings, paramObject.supportedEncodings)) && (this.maxChannelCount == paramObject.maxChannelCount))
    {
      AppMethodBeat.o(227666);
      return true;
    }
    AppMethodBeat.o(227666);
    return false;
  }
  
  public final int getMaxChannelCount()
  {
    return this.maxChannelCount;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(227676);
    int i = this.maxChannelCount;
    int j = Arrays.hashCode(this.supportedEncodings);
    AppMethodBeat.o(227676);
    return i + j * 31;
  }
  
  public final boolean supportsEncoding(int paramInt)
  {
    AppMethodBeat.i(227644);
    if (Arrays.binarySearch(this.supportedEncodings, paramInt) >= 0)
    {
      AppMethodBeat.o(227644);
      return true;
    }
    AppMethodBeat.o(227644);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(227691);
    String str = "AudioCapabilities[maxChannelCount=" + this.maxChannelCount + ", supportedEncodings=" + Arrays.toString(this.supportedEncodings) + "]";
    AppMethodBeat.o(227691);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPAudioPassThroughCapabilities
 * JD-Core Version:    0.7.0.1
 */