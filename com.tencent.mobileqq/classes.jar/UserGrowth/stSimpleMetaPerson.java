package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stSimpleMetaPerson
  extends JceStruct
{
  public String avatar = "";
  public int createtime;
  public String id = "";
  public String nick = "";
  public String schema_url = "";
  public int type;
  public String uid = "";
  
  public stSimpleMetaPerson() {}
  
  public stSimpleMetaPerson(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5)
  {
    this.id = paramString1;
    this.type = paramInt1;
    this.uid = paramString2;
    this.createtime = paramInt2;
    this.nick = paramString3;
    this.avatar = paramString4;
    this.schema_url = paramString5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.readString(0, false);
    this.type = paramJceInputStream.read(this.type, 1, false);
    this.uid = paramJceInputStream.readString(2, false);
    this.createtime = paramJceInputStream.read(this.createtime, 3, false);
    this.nick = paramJceInputStream.readString(4, false);
    this.avatar = paramJceInputStream.readString(5, false);
    this.schema_url = paramJceInputStream.readString(6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.id != null) {
      paramJceOutputStream.write(this.id, 0);
    }
    paramJceOutputStream.write(this.type, 1);
    if (this.uid != null) {
      paramJceOutputStream.write(this.uid, 2);
    }
    paramJceOutputStream.write(this.createtime, 3);
    if (this.nick != null) {
      paramJceOutputStream.write(this.nick, 4);
    }
    if (this.avatar != null) {
      paramJceOutputStream.write(this.avatar, 5);
    }
    if (this.schema_url != null) {
      paramJceOutputStream.write(this.schema_url, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stSimpleMetaPerson
 * JD-Core Version:    0.7.0.1
 */