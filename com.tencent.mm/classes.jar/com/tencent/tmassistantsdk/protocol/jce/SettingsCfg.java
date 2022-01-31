package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.mm.sdk.platformtools.y;

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
    if (!SettingsCfg.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
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
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while ($assertionsDisabled) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.type, "type");
    paramStringBuilder.display(this.cfg, "cfg");
    paramStringBuilder.display(this.revision, "revision");
  }
  
  public final void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.type, true);
    paramStringBuilder.displaySimple(this.cfg, true);
    paramStringBuilder.displaySimple(this.revision, false);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (SettingsCfg)paramObject;
    } while ((!JceUtil.equals(this.type, paramObject.type)) || (!JceUtil.equals(this.cfg, paramObject.cfg)) || (!JceUtil.equals(this.revision, paramObject.revision)));
    return true;
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
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("SettingsCfg", localException, "", new Object[0]);
    }
    return 0;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, true);
    if (cache_cfg == null)
    {
      byte[] arrayOfByte = (byte[])new byte[1];
      cache_cfg = arrayOfByte;
      ((byte[])arrayOfByte)[0] = 0;
    }
    this.cfg = ((byte[])paramJceInputStream.read(cache_cfg, 1, true));
    this.revision = paramJceInputStream.read(this.revision, 2, false);
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
    paramJceOutputStream.write(this.type, 0);
    paramJceOutputStream.write(this.cfg, 1);
    paramJceOutputStream.write(this.revision, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.protocol.jce.SettingsCfg
 * JD-Core Version:    0.7.0.1
 */