package Sound;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class UploadReq
  extends JceStruct
  implements Cloneable
{
  static byte[] cache_data;
  static byte[] cache_key_value;
  public int appid = 0;
  public long client_ip = 0L;
  public byte[] data = null;
  public int format = 0;
  public long key_type = 0L;
  public byte[] key_value = null;
  public long server_ip = 0L;
  public long uin = 0L;
  public int voice_length = 0;
  
  static
  {
    if (!UploadReq.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public UploadReq() {}
  
  public UploadReq(long paramLong1, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, int paramInt3, long paramLong2, long paramLong3, long paramLong4, byte[] paramArrayOfByte2)
  {
    this.uin = paramLong1;
    this.format = paramInt1;
    this.appid = paramInt2;
    this.data = paramArrayOfByte1;
    this.voice_length = paramInt3;
    this.client_ip = paramLong2;
    this.server_ip = paramLong3;
    this.key_type = paramLong4;
    this.key_value = paramArrayOfByte2;
  }
  
  public Object clone()
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
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.uin, "uin");
    paramStringBuilder.display(this.format, "format");
    paramStringBuilder.display(this.appid, "appid");
    paramStringBuilder.display(this.data, "data");
    paramStringBuilder.display(this.voice_length, "voice_length");
    paramStringBuilder.display(this.client_ip, "client_ip");
    paramStringBuilder.display(this.server_ip, "server_ip");
    paramStringBuilder.display(this.key_type, "key_type");
    paramStringBuilder.display(this.key_value, "key_value");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (UploadReq)paramObject;
    } while ((!JceUtil.equals(this.uin, paramObject.uin)) || (!JceUtil.equals(this.format, paramObject.format)) || (!JceUtil.equals(this.appid, paramObject.appid)) || (!JceUtil.equals(this.data, paramObject.data)) || (!JceUtil.equals(this.voice_length, paramObject.voice_length)) || (!JceUtil.equals(this.client_ip, paramObject.client_ip)) || (!JceUtil.equals(this.server_ip, paramObject.server_ip)) || (!JceUtil.equals(this.key_type, paramObject.key_type)) || (!JceUtil.equals(this.key_value, paramObject.key_value)));
    return true;
  }
  
  public int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.format = paramJceInputStream.read(this.format, 1, true);
    this.appid = paramJceInputStream.read(this.appid, 2, true);
    if (cache_data == null)
    {
      cache_data = new byte[1];
      cache_data[0] = 0;
    }
    this.data = paramJceInputStream.read(cache_data, 3, true);
    this.voice_length = paramJceInputStream.read(this.voice_length, 4, true);
    this.client_ip = paramJceInputStream.read(this.client_ip, 5, false);
    this.server_ip = paramJceInputStream.read(this.server_ip, 6, false);
    this.key_type = paramJceInputStream.read(this.key_type, 7, false);
    if (cache_key_value == null)
    {
      cache_key_value = new byte[1];
      cache_key_value[0] = 0;
    }
    this.key_value = paramJceInputStream.read(cache_key_value, 8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.format, 1);
    paramJceOutputStream.write(this.appid, 2);
    paramJceOutputStream.write(this.data, 3);
    paramJceOutputStream.write(this.voice_length, 4);
    paramJceOutputStream.write(this.client_ip, 5);
    paramJceOutputStream.write(this.server_ip, 6);
    paramJceOutputStream.write(this.key_type, 7);
    if (this.key_value != null) {
      paramJceOutputStream.write(this.key_value, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     Sound.UploadReq
 * JD-Core Version:    0.7.0.1
 */