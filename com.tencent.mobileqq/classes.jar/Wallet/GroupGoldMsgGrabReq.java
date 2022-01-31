package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GroupGoldMsgGrabReq
  extends JceStruct
{
  public String authkey = "";
  public String channel = "";
  public String cookie = "";
  public String groupcode = "";
  public String grouptype = "";
  public String groupuin = "";
  public String h_edition = "";
  public String h_model = "";
  public String h_qq_guid = "";
  public String listid = "";
  public String msgno = "";
  public String name = "";
  public String pskey = "";
  public String skey = "";
  public String skey_type = "";
  public String uin = "";
  
  public GroupGoldMsgGrabReq() {}
  
  public GroupGoldMsgGrabReq(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16)
  {
    this.uin = paramString1;
    this.listid = paramString2;
    this.name = paramString3;
    this.authkey = paramString4;
    this.channel = paramString5;
    this.groupuin = paramString6;
    this.groupcode = paramString7;
    this.grouptype = paramString8;
    this.pskey = paramString9;
    this.skey = paramString10;
    this.skey_type = paramString11;
    this.h_model = paramString12;
    this.h_edition = paramString13;
    this.h_qq_guid = paramString14;
    this.cookie = paramString15;
    this.msgno = paramString16;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.readString(0, true);
    this.listid = paramJceInputStream.readString(1, true);
    this.name = paramJceInputStream.readString(2, true);
    this.authkey = paramJceInputStream.readString(3, true);
    this.channel = paramJceInputStream.readString(4, true);
    this.groupuin = paramJceInputStream.readString(5, true);
    this.groupcode = paramJceInputStream.readString(6, false);
    this.grouptype = paramJceInputStream.readString(7, true);
    this.pskey = paramJceInputStream.readString(8, true);
    this.skey = paramJceInputStream.readString(9, true);
    this.skey_type = paramJceInputStream.readString(10, true);
    this.h_model = paramJceInputStream.readString(11, true);
    this.h_edition = paramJceInputStream.readString(12, true);
    this.h_qq_guid = paramJceInputStream.readString(13, true);
    this.cookie = paramJceInputStream.readString(14, false);
    this.msgno = paramJceInputStream.readString(15, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.listid, 1);
    paramJceOutputStream.write(this.name, 2);
    paramJceOutputStream.write(this.authkey, 3);
    paramJceOutputStream.write(this.channel, 4);
    paramJceOutputStream.write(this.groupuin, 5);
    if (this.groupcode != null) {
      paramJceOutputStream.write(this.groupcode, 6);
    }
    paramJceOutputStream.write(this.grouptype, 7);
    paramJceOutputStream.write(this.pskey, 8);
    paramJceOutputStream.write(this.skey, 9);
    paramJceOutputStream.write(this.skey_type, 10);
    paramJceOutputStream.write(this.h_model, 11);
    paramJceOutputStream.write(this.h_edition, 12);
    paramJceOutputStream.write(this.h_qq_guid, 13);
    if (this.cookie != null) {
      paramJceOutputStream.write(this.cookie, 14);
    }
    if (this.msgno != null) {
      paramJceOutputStream.write(this.msgno, 15);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     Wallet.GroupGoldMsgGrabReq
 * JD-Core Version:    0.7.0.1
 */