package SharpSvrPack;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class SharpVideoMsg
  extends JceStruct
  implements Cloneable
{
  static ArrayList<Long> cache_to_uin;
  static byte[] cache_video_buff;
  public short call_type = 0;
  public int client_state = 0;
  public long from_uin = 0L;
  public long msg_seq = 0L;
  public long msg_time = 0L;
  public long msg_type = 0L;
  public long msg_uid = 0L;
  public ArrayList<Long> to_uin = null;
  public byte type = 0;
  public byte ver = 0;
  public byte[] video_buff = null;
  
  static
  {
    if (!SharpVideoMsg.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public SharpVideoMsg() {}
  
  public SharpVideoMsg(byte paramByte1, byte paramByte2, long paramLong1, ArrayList<Long> paramArrayList, byte[] paramArrayOfByte, long paramLong2, long paramLong3, long paramLong4, long paramLong5, short paramShort, int paramInt)
  {
    this.ver = paramByte1;
    this.type = paramByte2;
    this.from_uin = paramLong1;
    this.to_uin = paramArrayList;
    this.video_buff = paramArrayOfByte;
    this.msg_uid = paramLong2;
    this.msg_seq = paramLong3;
    this.msg_type = paramLong4;
    this.msg_time = paramLong5;
    this.call_type = paramShort;
    this.client_state = paramInt;
  }
  
  public String className()
  {
    return "SharpSvrPack.SharpVideoMsg";
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
    paramStringBuilder.display(this.ver, "ver");
    paramStringBuilder.display(this.type, "type");
    paramStringBuilder.display(this.from_uin, "from_uin");
    paramStringBuilder.display(this.to_uin, "to_uin");
    paramStringBuilder.display(this.video_buff, "video_buff");
    paramStringBuilder.display(this.msg_uid, "msg_uid");
    paramStringBuilder.display(this.msg_seq, "msg_seq");
    paramStringBuilder.display(this.msg_type, "msg_type");
    paramStringBuilder.display(this.msg_time, "msg_time");
    paramStringBuilder.display(this.call_type, "call_type");
    paramStringBuilder.display(this.client_state, "client_state");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.ver, true);
    paramStringBuilder.displaySimple(this.type, true);
    paramStringBuilder.displaySimple(this.from_uin, true);
    paramStringBuilder.displaySimple(this.to_uin, true);
    paramStringBuilder.displaySimple(this.video_buff, true);
    paramStringBuilder.displaySimple(this.msg_uid, true);
    paramStringBuilder.displaySimple(this.msg_seq, true);
    paramStringBuilder.displaySimple(this.msg_type, true);
    paramStringBuilder.displaySimple(this.msg_time, true);
    paramStringBuilder.displaySimple(this.call_type, true);
    paramStringBuilder.displaySimple(this.client_state, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (SharpVideoMsg)paramObject;
    } while ((!JceUtil.equals(this.ver, paramObject.ver)) || (!JceUtil.equals(this.type, paramObject.type)) || (!JceUtil.equals(this.from_uin, paramObject.from_uin)) || (!JceUtil.equals(this.to_uin, paramObject.to_uin)) || (!JceUtil.equals(this.video_buff, paramObject.video_buff)) || (!JceUtil.equals(this.msg_uid, paramObject.msg_uid)) || (!JceUtil.equals(this.msg_seq, paramObject.msg_seq)) || (!JceUtil.equals(this.msg_type, paramObject.msg_type)) || (!JceUtil.equals(this.msg_time, paramObject.msg_time)) || (!JceUtil.equals(this.call_type, paramObject.call_type)) || (!JceUtil.equals(this.client_state, paramObject.client_state)));
    return true;
  }
  
  public String fullClassName()
  {
    return "SharpSvrPack.SharpVideoMsg";
  }
  
  public short getCall_type()
  {
    return this.call_type;
  }
  
  public int getClient_state()
  {
    return this.client_state;
  }
  
  public long getFrom_uin()
  {
    return this.from_uin;
  }
  
  public long getMsg_seq()
  {
    return this.msg_seq;
  }
  
  public long getMsg_time()
  {
    return this.msg_time;
  }
  
  public long getMsg_type()
  {
    return this.msg_type;
  }
  
  public long getMsg_uid()
  {
    return this.msg_uid;
  }
  
  public ArrayList<Long> getTo_uin()
  {
    return this.to_uin;
  }
  
  public byte getType()
  {
    return this.type;
  }
  
  public byte getVer()
  {
    return this.ver;
  }
  
  public byte[] getVideo_buff()
  {
    return this.video_buff;
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
    this.ver = paramJceInputStream.read(this.ver, 0, true);
    this.type = paramJceInputStream.read(this.type, 1, true);
    this.from_uin = paramJceInputStream.read(this.from_uin, 2, true);
    if (cache_to_uin == null)
    {
      cache_to_uin = new ArrayList();
      cache_to_uin.add(Long.valueOf(0L));
    }
    this.to_uin = ((ArrayList)paramJceInputStream.read(cache_to_uin, 3, true));
    if (cache_video_buff == null)
    {
      cache_video_buff = (byte[])new byte[1];
      ((byte[])cache_video_buff)[0] = 0;
    }
    this.video_buff = ((byte[])paramJceInputStream.read(cache_video_buff, 4, true));
    this.msg_uid = paramJceInputStream.read(this.msg_uid, 5, false);
    this.msg_seq = paramJceInputStream.read(this.msg_seq, 6, false);
    this.msg_type = paramJceInputStream.read(this.msg_type, 7, false);
    this.msg_time = paramJceInputStream.read(this.msg_time, 8, false);
    this.call_type = paramJceInputStream.read(this.call_type, 9, false);
    this.client_state = paramJceInputStream.read(this.client_state, 10, false);
  }
  
  public void setCall_type(short paramShort)
  {
    this.call_type = paramShort;
  }
  
  public void setClient_state(int paramInt)
  {
    this.client_state = paramInt;
  }
  
  public void setFrom_uin(long paramLong)
  {
    this.from_uin = paramLong;
  }
  
  public void setMsg_seq(long paramLong)
  {
    this.msg_seq = paramLong;
  }
  
  public void setMsg_time(long paramLong)
  {
    this.msg_time = paramLong;
  }
  
  public void setMsg_type(long paramLong)
  {
    this.msg_type = paramLong;
  }
  
  public void setMsg_uid(long paramLong)
  {
    this.msg_uid = paramLong;
  }
  
  public void setTo_uin(ArrayList<Long> paramArrayList)
  {
    this.to_uin = paramArrayList;
  }
  
  public void setType(byte paramByte)
  {
    this.type = paramByte;
  }
  
  public void setVer(byte paramByte)
  {
    this.ver = paramByte;
  }
  
  public void setVideo_buff(byte[] paramArrayOfByte)
  {
    this.video_buff = paramArrayOfByte;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ver, 0);
    paramJceOutputStream.write(this.type, 1);
    paramJceOutputStream.write(this.from_uin, 2);
    paramJceOutputStream.write(this.to_uin, 3);
    paramJceOutputStream.write(this.video_buff, 4);
    paramJceOutputStream.write(this.msg_uid, 5);
    paramJceOutputStream.write(this.msg_seq, 6);
    paramJceOutputStream.write(this.msg_type, 7);
    paramJceOutputStream.write(this.msg_time, 8);
    paramJceOutputStream.write(this.call_type, 9);
    paramJceOutputStream.write(this.client_state, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     SharpSvrPack.SharpVideoMsg
 * JD-Core Version:    0.7.0.1
 */