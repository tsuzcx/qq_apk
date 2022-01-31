package CardPay;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Channel
  extends JceStruct
{
  public String channelDesc = "";
  public String channelName = "";
  public int id;
  public int isLeaf;
  public int isNFC;
  public int pId;
  public String payChannel = "";
  public String payChannelSubId = "";
  public String paySubType = "";
  public String payType = "";
  public String pluginName = "";
  public long pluginSize;
  
  public Channel() {}
  
  public Channel(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt4, String paramString6, String paramString7)
  {
    this.id = paramInt1;
    this.pId = paramInt2;
    this.isLeaf = paramInt3;
    this.payChannel = paramString1;
    this.payChannelSubId = paramString2;
    this.channelName = paramString3;
    this.channelDesc = paramString4;
    this.pluginName = paramString5;
    this.pluginSize = paramLong;
    this.isNFC = paramInt4;
    this.payType = paramString6;
    this.paySubType = paramString7;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.read(this.id, 0, true);
    this.pId = paramJceInputStream.read(this.pId, 1, true);
    this.isLeaf = paramJceInputStream.read(this.isLeaf, 2, true);
    this.payChannel = paramJceInputStream.readString(3, true);
    this.payChannelSubId = paramJceInputStream.readString(4, true);
    this.channelName = paramJceInputStream.readString(5, true);
    this.channelDesc = paramJceInputStream.readString(6, true);
    this.pluginName = paramJceInputStream.readString(7, true);
    this.pluginSize = paramJceInputStream.read(this.pluginSize, 8, true);
    this.isNFC = paramJceInputStream.read(this.isNFC, 9, false);
    this.payType = paramJceInputStream.readString(10, false);
    this.paySubType = paramJceInputStream.readString(11, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.id, 0);
    paramJceOutputStream.write(this.pId, 1);
    paramJceOutputStream.write(this.isLeaf, 2);
    paramJceOutputStream.write(this.payChannel, 3);
    paramJceOutputStream.write(this.payChannelSubId, 4);
    paramJceOutputStream.write(this.channelName, 5);
    paramJceOutputStream.write(this.channelDesc, 6);
    paramJceOutputStream.write(this.pluginName, 7);
    paramJceOutputStream.write(this.pluginSize, 8);
    paramJceOutputStream.write(this.isNFC, 9);
    if (this.payType != null) {
      paramJceOutputStream.write(this.payType, 10);
    }
    if (this.paySubType != null) {
      paramJceOutputStream.write(this.paySubType, 11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     CardPay.Channel
 * JD-Core Version:    0.7.0.1
 */