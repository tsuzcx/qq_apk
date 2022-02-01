package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stMetaReply
  extends JceStruct
{
  static stMetaPerson cache_poster = new stMetaPerson();
  static stMetaPerson cache_receiver = new stMetaPerson();
  public String beReplyReplyId = "";
  public int createtime = 0;
  public String id = "";
  public int mask = 0;
  public stMetaPerson poster = null;
  public stMetaPerson receiver = null;
  public int robotMode = 0;
  public String wording = "";
  
  public stMetaReply() {}
  
  public stMetaReply(String paramString1, String paramString2, stMetaPerson paramstMetaPerson1, stMetaPerson paramstMetaPerson2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    this.id = paramString1;
    this.wording = paramString2;
    this.poster = paramstMetaPerson1;
    this.receiver = paramstMetaPerson2;
    this.createtime = paramInt1;
    this.mask = paramInt2;
    this.robotMode = paramInt3;
    this.beReplyReplyId = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.readString(0, false);
    this.wording = paramJceInputStream.readString(1, false);
    this.poster = ((stMetaPerson)paramJceInputStream.read(cache_poster, 2, false));
    this.receiver = ((stMetaPerson)paramJceInputStream.read(cache_receiver, 3, false));
    this.createtime = paramJceInputStream.read(this.createtime, 4, false);
    this.mask = paramJceInputStream.read(this.mask, 5, false);
    this.robotMode = paramJceInputStream.read(this.robotMode, 6, false);
    this.beReplyReplyId = paramJceInputStream.readString(7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.wording;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.poster;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
    localObject = this.receiver;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    paramJceOutputStream.write(this.createtime, 4);
    paramJceOutputStream.write(this.mask, 5);
    paramJceOutputStream.write(this.robotMode, 6);
    localObject = this.beReplyReplyId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_KING_SOCIALIZE_META.stMetaReply
 * JD-Core Version:    0.7.0.1
 */