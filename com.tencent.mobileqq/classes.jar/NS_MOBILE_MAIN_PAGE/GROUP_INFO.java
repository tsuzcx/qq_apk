package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GROUP_INFO
  extends JceStruct
{
  public short friendCount;
  public String groupName = "";
  public byte seqId;
  
  public GROUP_INFO() {}
  
  public GROUP_INFO(byte paramByte, String paramString, short paramShort)
  {
    this.seqId = paramByte;
    this.groupName = paramString;
    this.friendCount = paramShort;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.seqId = paramJceInputStream.read(this.seqId, 0, true);
    this.groupName = paramJceInputStream.readString(1, true);
    this.friendCount = paramJceInputStream.read(this.friendCount, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.seqId, 0);
    paramJceOutputStream.write(this.groupName, 1);
    paramJceOutputStream.write(this.friendCount, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.GROUP_INFO
 * JD-Core Version:    0.7.0.1
 */