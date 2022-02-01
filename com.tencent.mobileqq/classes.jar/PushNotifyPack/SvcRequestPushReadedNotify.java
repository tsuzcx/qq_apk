package PushNotifyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SvcRequestPushReadedNotify
  extends JceStruct
{
  static ArrayList<C2CMsgReadedNotify> cache_vC2CReadedNotify;
  static ArrayList<DisMsgReadedNotify> cache_vDisReadedNotify;
  static ArrayList<GroupMsgReadedNotify> cache_vGroupReadedNotify;
  public byte cNotifyType = 0;
  public ArrayList<C2CMsgReadedNotify> vC2CReadedNotify = null;
  public ArrayList<DisMsgReadedNotify> vDisReadedNotify = null;
  public ArrayList<GroupMsgReadedNotify> vGroupReadedNotify = null;
  
  public SvcRequestPushReadedNotify() {}
  
  public SvcRequestPushReadedNotify(byte paramByte, ArrayList<C2CMsgReadedNotify> paramArrayList, ArrayList<GroupMsgReadedNotify> paramArrayList1, ArrayList<DisMsgReadedNotify> paramArrayList2)
  {
    this.cNotifyType = paramByte;
    this.vC2CReadedNotify = paramArrayList;
    this.vGroupReadedNotify = paramArrayList1;
    this.vDisReadedNotify = paramArrayList2;
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
    ArrayList localArrayList = this.vC2CReadedNotify;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 1);
    }
    localArrayList = this.vGroupReadedNotify;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 2);
    }
    localArrayList = this.vDisReadedNotify;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     PushNotifyPack.SvcRequestPushReadedNotify
 * JD-Core Version:    0.7.0.1
 */