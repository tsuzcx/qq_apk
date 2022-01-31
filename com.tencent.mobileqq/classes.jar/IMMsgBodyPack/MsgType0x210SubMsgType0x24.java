package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class MsgType0x210SubMsgType0x24
  extends JceStruct
{
  static ArrayList cache_vPluginNumList;
  public ArrayList vPluginNumList;
  
  public MsgType0x210SubMsgType0x24() {}
  
  public MsgType0x210SubMsgType0x24(ArrayList paramArrayList)
  {
    this.vPluginNumList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vPluginNumList == null)
    {
      cache_vPluginNumList = new ArrayList();
      PluginNum localPluginNum = new PluginNum();
      cache_vPluginNumList.add(localPluginNum);
    }
    this.vPluginNumList = ((ArrayList)paramJceInputStream.read(cache_vPluginNumList, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vPluginNumList != null) {
      paramJceOutputStream.write(this.vPluginNumList, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     IMMsgBodyPack.MsgType0x210SubMsgType0x24
 * JD-Core Version:    0.7.0.1
 */