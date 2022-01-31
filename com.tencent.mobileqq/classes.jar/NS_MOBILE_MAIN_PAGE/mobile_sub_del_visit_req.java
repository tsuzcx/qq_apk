package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_sub_del_visit_req
  extends JceStruct
{
  public boolean add_to_hidelist;
  public String contentid = "";
  public long hostUin;
  public byte mod;
  public byte source;
  public long uin;
  public long vtime;
  
  public mobile_sub_del_visit_req() {}
  
  public mobile_sub_del_visit_req(long paramLong1, byte paramByte1, long paramLong2, long paramLong3, byte paramByte2, String paramString, boolean paramBoolean)
  {
    this.uin = paramLong1;
    this.source = paramByte1;
    this.vtime = paramLong2;
    this.hostUin = paramLong3;
    this.mod = paramByte2;
    this.contentid = paramString;
    this.add_to_hidelist = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.source = paramJceInputStream.read(this.source, 1, false);
    this.vtime = paramJceInputStream.read(this.vtime, 2, false);
    this.hostUin = paramJceInputStream.read(this.hostUin, 3, false);
    this.mod = paramJceInputStream.read(this.mod, 4, false);
    this.contentid = paramJceInputStream.readString(5, false);
    this.add_to_hidelist = paramJceInputStream.read(this.add_to_hidelist, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.source, 1);
    paramJceOutputStream.write(this.vtime, 2);
    paramJceOutputStream.write(this.hostUin, 3);
    paramJceOutputStream.write(this.mod, 4);
    if (this.contentid != null) {
      paramJceOutputStream.write(this.contentid, 5);
    }
    paramJceOutputStream.write(this.add_to_hidelist, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_del_visit_req
 * JD-Core Version:    0.7.0.1
 */