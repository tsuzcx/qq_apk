package UserGrowth;

import NS_KING_SOCIALIZE_META.stMetaNumericSys;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stSimpleMetaPerson
  extends JceStruct
{
  static stSchema cache_avatarSchema = new stSchema();
  static stLive cache_live = new stLive();
  static stMetaNumericSys cache_nueric = new stMetaNumericSys();
  public String avatar = "";
  public stSchema avatarSchema;
  public int createtime;
  public int followStatus;
  public String id = "";
  public stLive live;
  public int medal;
  public String nick = "";
  public stMetaNumericSys nueric;
  public String recommendReason = "";
  public int relation_type;
  public String schema_url = "";
  public int sex;
  public int type;
  public String uid = "";
  
  public stSimpleMetaPerson() {}
  
  public stSimpleMetaPerson(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, int paramInt3, int paramInt4, int paramInt5, stMetaNumericSys paramstMetaNumericSys, String paramString6, int paramInt6, stSchema paramstSchema, stLive paramstLive)
  {
    this.id = paramString1;
    this.type = paramInt1;
    this.uid = paramString2;
    this.createtime = paramInt2;
    this.nick = paramString3;
    this.avatar = paramString4;
    this.schema_url = paramString5;
    this.relation_type = paramInt3;
    this.followStatus = paramInt4;
    this.medal = paramInt5;
    this.nueric = paramstMetaNumericSys;
    this.recommendReason = paramString6;
    this.sex = paramInt6;
    this.avatarSchema = paramstSchema;
    this.live = paramstLive;
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
    this.relation_type = paramJceInputStream.read(this.relation_type, 7, false);
    this.followStatus = paramJceInputStream.read(this.followStatus, 8, false);
    this.medal = paramJceInputStream.read(this.medal, 9, false);
    this.nueric = ((stMetaNumericSys)paramJceInputStream.read(cache_nueric, 10, false));
    this.recommendReason = paramJceInputStream.readString(11, false);
    this.sex = paramJceInputStream.read(this.sex, 12, false);
    this.avatarSchema = ((stSchema)paramJceInputStream.read(cache_avatarSchema, 13, false));
    this.live = ((stLive)paramJceInputStream.read(cache_live, 14, false));
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
    paramJceOutputStream.write(this.relation_type, 7);
    paramJceOutputStream.write(this.followStatus, 8);
    paramJceOutputStream.write(this.medal, 9);
    if (this.nueric != null) {
      paramJceOutputStream.write(this.nueric, 10);
    }
    if (this.recommendReason != null) {
      paramJceOutputStream.write(this.recommendReason, 11);
    }
    paramJceOutputStream.write(this.sex, 12);
    if (this.avatarSchema != null) {
      paramJceOutputStream.write(this.avatarSchema, 13);
    }
    if (this.live != null) {
      paramJceOutputStream.write(this.live, 14);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stSimpleMetaPerson
 * JD-Core Version:    0.7.0.1
 */