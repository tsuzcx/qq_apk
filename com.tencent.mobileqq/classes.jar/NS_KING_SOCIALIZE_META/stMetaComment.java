package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class stMetaComment
  extends JceStruct
{
  static stMetaPerson cache_poster = new stMetaPerson();
  static stMetaPerson cache_receiver = new stMetaPerson();
  static ArrayList<stMetaReply> cache_replyList = new ArrayList();
  static Map<Integer, String> cache_reserve;
  public String beReplyCommendId = "";
  public int createtime = 0;
  public long dingNum = 0L;
  public int essOpUin = 0;
  public String feedId = "";
  public String feedOwnerId = "";
  public String id = "";
  public int isDing = 0;
  public boolean isTempData = false;
  public int mask = 0;
  public stMetaPerson poster = null;
  public String poster_id = "";
  public stMetaPerson receiver = null;
  public String receiver_id = "";
  public long replyIdNum = 0L;
  public ArrayList<stMetaReply> replyList = null;
  public long replyNum = 0L;
  public Map<Integer, String> reserve = null;
  public int robotMode = 0;
  public String wording = "";
  
  static
  {
    stMetaReply localstMetaReply = new stMetaReply();
    cache_replyList.add(localstMetaReply);
    cache_reserve = new HashMap();
    cache_reserve.put(Integer.valueOf(0), "");
  }
  
  public stMetaComment() {}
  
  public stMetaComment(String paramString1, String paramString2)
  {
    this.wording = paramString1;
    this.poster_id = paramString2;
  }
  
  public stMetaComment(String paramString1, String paramString2, String paramString3, stMetaPerson paramstMetaPerson1, String paramString4, stMetaPerson paramstMetaPerson2, int paramInt1, int paramInt2, int paramInt3, String paramString5, int paramInt4, long paramLong1, int paramInt5, ArrayList<stMetaReply> paramArrayList, long paramLong2, String paramString6, Map<Integer, String> paramMap, String paramString7, long paramLong3)
  {
    this.id = paramString1;
    this.wording = paramString2;
    this.poster_id = paramString3;
    this.poster = paramstMetaPerson1;
    this.receiver_id = paramString4;
    this.receiver = paramstMetaPerson2;
    this.createtime = paramInt1;
    this.mask = paramInt2;
    this.robotMode = paramInt3;
    this.beReplyCommendId = paramString5;
    this.essOpUin = paramInt4;
    this.dingNum = paramLong1;
    this.isDing = paramInt5;
    this.replyList = paramArrayList;
    this.replyNum = paramLong2;
    this.feedOwnerId = paramString6;
    this.reserve = paramMap;
    this.feedId = paramString7;
    this.replyIdNum = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.readString(0, false);
    this.wording = paramJceInputStream.readString(1, false);
    this.poster_id = paramJceInputStream.readString(2, false);
    this.poster = ((stMetaPerson)paramJceInputStream.read(cache_poster, 3, false));
    this.receiver_id = paramJceInputStream.readString(4, false);
    this.receiver = ((stMetaPerson)paramJceInputStream.read(cache_receiver, 5, false));
    this.createtime = paramJceInputStream.read(this.createtime, 6, false);
    this.mask = paramJceInputStream.read(this.mask, 7, false);
    this.robotMode = paramJceInputStream.read(this.robotMode, 8, false);
    this.beReplyCommendId = paramJceInputStream.readString(9, false);
    this.essOpUin = paramJceInputStream.read(this.essOpUin, 10, false);
    this.dingNum = paramJceInputStream.read(this.dingNum, 11, false);
    this.isDing = paramJceInputStream.read(this.isDing, 12, false);
    this.replyList = ((ArrayList)paramJceInputStream.read(cache_replyList, 13, false));
    this.replyNum = paramJceInputStream.read(this.replyNum, 14, false);
    this.feedOwnerId = paramJceInputStream.readString(15, false);
    this.reserve = ((Map)paramJceInputStream.read(cache_reserve, 16, false));
    this.feedId = paramJceInputStream.readString(17, false);
    this.replyIdNum = paramJceInputStream.read(this.replyIdNum, 18, false);
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
    localObject = this.poster_id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.poster;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.receiver_id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.receiver;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 5);
    }
    paramJceOutputStream.write(this.createtime, 6);
    paramJceOutputStream.write(this.mask, 7);
    paramJceOutputStream.write(this.robotMode, 8);
    localObject = this.beReplyCommendId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
    }
    paramJceOutputStream.write(this.essOpUin, 10);
    paramJceOutputStream.write(this.dingNum, 11);
    paramJceOutputStream.write(this.isDing, 12);
    localObject = this.replyList;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 13);
    }
    paramJceOutputStream.write(this.replyNum, 14);
    localObject = this.feedOwnerId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 15);
    }
    localObject = this.reserve;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 16);
    }
    localObject = this.feedId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 17);
    }
    paramJceOutputStream.write(this.replyIdNum, 18);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_KING_SOCIALIZE_META.stMetaComment
 * JD-Core Version:    0.7.0.1
 */