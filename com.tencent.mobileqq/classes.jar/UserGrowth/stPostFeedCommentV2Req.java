package UserGrowth;

import NS_KING_SOCIALIZE_META.stMetaReportDataItem;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class stPostFeedCommentV2Req
  extends JceStruct
{
  static ArrayList<String> cache_atUserQQ;
  static stSimpleMetaComment cache_comment = new stSimpleMetaComment();
  static ArrayList<stMetaReportDataItem> cache_data = new ArrayList();
  public ArrayList<String> atUserQQ = null;
  public stSimpleMetaComment comment = null;
  public ArrayList<stMetaReportDataItem> data = null;
  public String feed_id = "";
  public int hadMancheked = 0;
  
  static
  {
    stMetaReportDataItem localstMetaReportDataItem = new stMetaReportDataItem();
    cache_data.add(localstMetaReportDataItem);
    cache_atUserQQ = new ArrayList();
    cache_atUserQQ.add("");
  }
  
  public stPostFeedCommentV2Req() {}
  
  public stPostFeedCommentV2Req(String paramString, stSimpleMetaComment paramstSimpleMetaComment)
  {
    this.feed_id = paramString;
    this.comment = paramstSimpleMetaComment;
  }
  
  public stPostFeedCommentV2Req(String paramString, stSimpleMetaComment paramstSimpleMetaComment, ArrayList<stMetaReportDataItem> paramArrayList, int paramInt, ArrayList<String> paramArrayList1)
  {
    this.feed_id = paramString;
    this.comment = paramstSimpleMetaComment;
    this.data = paramArrayList;
    this.hadMancheked = paramInt;
    this.atUserQQ = paramArrayList1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.feed_id = paramJceInputStream.readString(0, true);
    this.comment = ((stSimpleMetaComment)paramJceInputStream.read(cache_comment, 1, true));
    this.data = ((ArrayList)paramJceInputStream.read(cache_data, 2, false));
    this.hadMancheked = paramJceInputStream.read(this.hadMancheked, 3, false);
    this.atUserQQ = ((ArrayList)paramJceInputStream.read(cache_atUserQQ, 4, false));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stPostFeedCommentV2Req{feed_id='");
    localStringBuilder.append(this.feed_id);
    localStringBuilder.append('\'');
    localStringBuilder.append(", comment=");
    localStringBuilder.append(this.comment);
    localStringBuilder.append(", data=");
    localStringBuilder.append(this.data);
    localStringBuilder.append(", hadMancheked=");
    localStringBuilder.append(this.hadMancheked);
    localStringBuilder.append(", atUserQQ=");
    localStringBuilder.append(this.atUserQQ.toString());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.feed_id, 0);
    paramJceOutputStream.write(this.comment, 1);
    ArrayList localArrayList = this.data;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 2);
    }
    paramJceOutputStream.write(this.hadMancheked, 3);
    localArrayList = this.atUserQQ;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stPostFeedCommentV2Req
 * JD-Core Version:    0.7.0.1
 */