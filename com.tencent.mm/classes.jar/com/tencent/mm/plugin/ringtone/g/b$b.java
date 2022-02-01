package com.tencent.mm.plugin.ringtone.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ringtone.a.b;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/params/RingtoneConstant$RingtonePlayInfo;", "", "soundType", "Lcom/tencent/mm/plugin/ringtone/IPluginRingtone$SoundType;", "streamType", "", "isLoop", "", "(Lcom/tencent/mm/plugin/ringtone/IPluginRingtone$SoundType;IZ)V", "()Z", "setLoop", "(Z)V", "getSoundType", "()Lcom/tencent/mm/plugin/ringtone/IPluginRingtone$SoundType;", "setSoundType", "(Lcom/tencent/mm/plugin/ringtone/IPluginRingtone$SoundType;)V", "getStreamType", "()I", "setStreamType", "(I)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$b
{
  public a.b ODh;
  public boolean oYG;
  public int streamType;
  
  public b$b(a.b paramb, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(272825);
    this.ODh = paramb;
    this.streamType = paramInt;
    this.oYG = paramBoolean;
    AppMethodBeat.o(272825);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof b)) {
        return false;
      }
      paramObject = (b)paramObject;
      if (this.ODh != paramObject.ODh) {
        return false;
      }
      if (this.streamType != paramObject.streamType) {
        return false;
      }
    } while (this.oYG == paramObject.oYG);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(272831);
    String str = "RingtonePlayInfo(soundType=" + this.ODh + ", streamType=" + this.streamType + ", isLoop=" + this.oYG + ')';
    AppMethodBeat.o(272831);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.g.b.b
 * JD-Core Version:    0.7.0.1
 */