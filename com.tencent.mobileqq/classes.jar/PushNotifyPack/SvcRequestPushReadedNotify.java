package PushNotifyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SvcRequestPushReadedNotify
  extends JceStruct
{
  static ArrayList cache_vC2CReadedNotify;
  static ArrayList cache_vDisReadedNotify;
  static ArrayList cache_vGroupReadedNotify;
  public byte cNotifyType;
  public ArrayList vC2CReadedNotify;
  public ArrayList vDisReadedNotify;
  public ArrayList vGroupReadedNotify;
  
  public SvcRequestPushReadedNotify() {}
  
  public SvcRequestPushReadedNotify(byte paramByte, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3)
  {
    this.cNotifyType = paramByte;
    this.vC2CReadedNotify = paramArrayList1;
    this.vGroupReadedNotify = paramArrayList2;
    this.vDisReadedNotify = paramArrayList3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cNotifyType = paramJceInputStream.read(this.cNotifyType, 0, true);
    Object localObject;
    if (cache_vC2CReadedNotify == null)
    {
      cache_vC2CReadedNotify = new ArrayList();
      localObject = new C2CMsgReadedNotify();
      cache_vC2CReadedNotify.add(localObject);
    }
    this.vC2CReadedNotify = ((ArrayList)paramJceInputStream.read(cache_vC2CReadedNotify, 1, false));
    if (cache_vGroupReadedNotify == null)
    {
      cache_vGroupReadedNotify = new ArrayList();
      localObject = new GroupMsgReadedNotify();
      cache_vGroupReadedNotify.add(localObject);
    }
    this.vGroupReadedNotify = ((ArrayList)paramJceInputStream.read(cache_vGroupReadedNotify, 2, false));
    if (cache_vDisReadedNotify == null)
    {
      cache_vDisReadedNotify = new ArrayList();
      localObject = new DisMsgReadedNotify();
      cache_vDisReadedNotify.add(localObject);
    }
    this.vDisReadedNotify = ((ArrayList)paramJceInputStream.read(cache_vDisReadedNotify, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cNotifyType, 0);
    if (this.vC2CReadedNotify != null) {
      paramJceOutputStream.write(this.vC2CReadedNotify, 1);
    }
    if (this.vGroupReadedNotify != null) {
      paramJceOutputStream.write(this.vGroupReadedNotify, 2);
    }
    if (this.vDisReadedNotify != null) {
      paramJceOutputStream.write(this.vDisReadedNotify, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     PushNotifyPack.SvcRequestPushReadedNotify
 * JD-Core Version:    0.7.0.1
 */