package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class SettingsCfg
  extends JceStruct
  implements Cloneable
{
  private static final String TAG = "SettingsCfg";
  static byte[] cache_cfg;
  public byte[] cfg = null;
  public long revision = 0L;
  public byte type = 0;
  
  static
  {
    AppMethodBeat.i(76133);
    if (!SettingsCfg.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(76133);
      return;
    }
  }
  
  public SettingsCfg() {}
  
  public SettingsCfg(byte paramByte, byte[] paramArrayOfByte, long paramLong)
  {
    this.type = paramByte;
    this.cfg = paramArrayOfByte;
    this.revision = paramLong;
  }
  
  public final String className()
  {
    return "jce.SettingsCfg";
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(76128);
    localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while ($assertionsDisabled) {}
      localObject1 = new AssertionError();
      AppMethodBeat.o(76128);
      throw ((Throwable)localObject1);
    }
    AppMethodBeat.o(76128);
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(76131);
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.type, "type");
    paramStringBuilder.display(this.cfg, "cfg");
    paramStringBuilder.display(this.revision, "revision");
    AppMethodBeat.o(76131);
  }
  
  public final void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(76132);
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.type, true);
    paramStringBuilder.displaySimple(this.cfg, true);
    paramStringBuilder.displaySimple(this.revision, false);
    AppMethodBeat.o(76132);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(76126);
    if (paramObject == null)
    {
      AppMethodBeat.o(76126);
      return false;
    }
    paramObject = (SettingsCfg)paramObject;
    if ((JceUtil.equals(this.type, paramObject.type)) && (JceUtil.equals(this.cfg, paramObject.cfg)) && (JceUtil.equals(this.revision, paramObject.revision)))
    {
      AppMethodBeat.o(76126);
      return true;
    }
    AppMethodBeat.o(76126);
    return false;
  }
  
  public final String fullClassName()
  {
    return "SettingsCfg";
  }
  
  public final byte[] getCfg()
  {
    return this.cfg;
  }
  
  public final long getRevision()
  {
    return this.revision;
  }
  
  public final byte getType()
  {
    return this.type;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(76127);
    try
    {
      Exception localException1 = new Exception("Need define key first!");
      AppMethodBeat.o(76127);
      throw localException1;
    }
    catch (Exception localException2)
    {
      ab.printErrStackTrace("SettingsCfg", localException2, "", new Object[0]);
      AppMethodBeat.o(76127);
    }
    return 0;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(76130);
    this.type = paramJceInputStream.read(this.type, 0, true);
    if (cache_cfg == null)
    {
      byte[] arrayOfByte = (byte[])new byte[1];
      cache_cfg = arrayOfByte;
      ((byte[])arrayOfByte)[0] = 0;
    }
    this.cfg = ((byte[])paramJceInputStream.read(cache_cfg, 1, true));
    this.revision = paramJceInputStream.read(this.revision, 2, false);
    AppMethodBeat.o(76130);
  }
  
  public final void setCfg(byte[] paramArrayOfByte)
  {
    this.cfg = paramArrayOfByte;
  }
  
  public final void setRevision(long paramLong)
  {
    this.revision = paramLong;
  }
  
  public final void setType(byte paramByte)
  {
    this.type = paramByte;
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(76129);
    paramJceOutputStream.write(this.type, 0);
    paramJceOutputStream.write(this.cfg, 1);
    paramJceOutputStream.write(this.revision, 2);
    AppMethodBeat.o(76129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.protocol.jce.SettingsCfg
 * JD-Core Version:    0.7.0.1
 */