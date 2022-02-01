package UserGrowth;

import NS_KING_SOCIALIZE_META.stMetaAddr;
import NS_KING_SOCIALIZE_META.stMetaNumericSys;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stSimpleMetaPerson
  extends JceStruct
{
  static stSchema cache_avatarSchema;
  static stPersonExt cache_extInfo = new stPersonExt();
  static stMetaAddr cache_formatAddr = new stMetaAddr();
  static stLive cache_live;
  static stMetaNumericSys cache_nueric = new stMetaNumericSys();
  public String avatar = "";
  public stSchema avatarSchema = null;
  public String background = "";
  public int createtime = 0;
  public stPersonExt extInfo = null;
  public int followStatus = 0;
  public stMetaAddr formatAddr = null;
  public String id = "";
  public stLive live = null;
  public int medal = 0;
  public String nick = "";
  public stMetaNumericSys nueric = null;
  public String recommendReason = "";
  public int relation_type = 0;
  public String schema_url = "";
  public int sex = 0;
  public String status = "";
  public int type = 0;
  public String uid = "";
  
  static
  {
    cache_avatarSchema = new stSchema();
    cache_live = new stLive();
  }
  
  public stSimpleMetaPerson() {}
  
  public stSimpleMetaPerson(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, int paramInt3, int paramInt4, int paramInt5, stMetaNumericSys paramstMetaNumericSys, String paramString6, int paramInt6, stSchema paramstSchema, stLive paramstLive, stPersonExt paramstPersonExt, String paramString7, stMetaAddr paramstMetaAddr, String paramString8)
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
    this.extInfo = paramstPersonExt;
    this.status = paramString7;
    this.formatAddr = paramstMetaAddr;
    this.background = paramString8;
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
    this.extInfo = ((stPersonExt)paramJceInputStream.read(cache_extInfo, 15, false));
    this.status = paramJceInputStream.readString(16, false);
    this.formatAddr = ((stMetaAddr)paramJceInputStream.read(cache_formatAddr, 17, false));
    this.background = paramJceInputStream.readString(18, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    paramJceOutputStream.write(this.type, 1);
    localObject = this.uid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    paramJceOutputStream.write(this.createtime, 3);
    localObject = this.nick;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.avatar;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.schema_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    paramJceOutputStream.write(this.relation_type, 7);
    paramJceOutputStream.write(this.followStatus, 8);
    paramJceOutputStream.write(this.medal, 9);
    localObject = this.nueric;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 10);
    }
    localObject = this.recommendReason;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 11);
    }
    paramJceOutputStream.write(this.sex, 12);
    localObject = this.avatarSchema;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 13);
    }
    localObject = this.live;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 14);
    }
    localObject = this.extInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 15);
    }
    localObject = this.status;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 16);
    }
    localObject = this.formatAddr;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 17);
    }
    localObject = this.background;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 18);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stSimpleMetaPerson
 * JD-Core Version:    0.7.0.1
 */