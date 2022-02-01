package NS_KING_INTERFACE;

import NS_KING_SOCIALIZE_META.stMetaComment;
import NS_KING_SOCIALIZE_META.stMetaReportDataItem;
import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class stPostFeedCommentReq
  extends JceStruct
  implements Cloneable
{
  static stMetaComment cache_comment = new stMetaComment();
  static ArrayList<stMetaReportDataItem> cache_data = new ArrayList();
  public stMetaComment comment = null;
  public ArrayList<stMetaReportDataItem> data = null;
  public String feed_id = "";
  public int hadMancheked = 0;
  
  static
  {
    stMetaReportDataItem localstMetaReportDataItem = new stMetaReportDataItem();
    cache_data.add(localstMetaReportDataItem);
  }
  
  public stPostFeedCommentReq() {}
  
  public stPostFeedCommentReq(String paramString, stMetaComment paramstMetaComment)
  {
    this.feed_id = paramString;
    this.comment = paramstMetaComment;
  }
  
  public stPostFeedCommentReq(String paramString, stMetaComment paramstMetaComment, ArrayList<stMetaReportDataItem> paramArrayList, int paramInt)
  {
    this.feed_id = paramString;
    this.comment = paramstMetaComment;
    this.data = paramArrayList;
    this.hadMancheked = paramInt;
  }
  
  public String className()
  {
    return "NS_KING_INTERFACE.stPostFeedCommentReq";
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label7:
      break label7;
    }
    return null;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.feed_id, "feed_id");
    paramStringBuilder.display(this.comment, "comment");
    paramStringBuilder.display(this.data, "data");
    paramStringBuilder.display(this.hadMancheked, "hadMancheked");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.feed_id, true);
    paramStringBuilder.displaySimple(this.comment, true);
    paramStringBuilder.displaySimple(this.data, true);
    paramStringBuilder.displaySimple(this.hadMancheked, false);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (stPostFeedCommentReq)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.feed_id, paramObject.feed_id))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.comment, paramObject.comment))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.data, paramObject.data))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.hadMancheked, paramObject.hadMancheked)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "NS_KING_INTERFACE.stPostFeedCommentReq";
  }
  
  public stMetaComment getComment()
  {
    return this.comment;
  }
  
  public ArrayList<stMetaReportDataItem> getData()
  {
    return this.data;
  }
  
  public String getFeed_id()
  {
    return this.feed_id;
  }
  
  public int getHadMancheked()
  {
    return this.hadMancheked;
  }
  
  public int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.feed_id = paramJceInputStream.readString(0, true);
    this.comment = ((stMetaComment)paramJceInputStream.read(cache_comment, 1, true));
    this.data = ((ArrayList)paramJceInputStream.read(cache_data, 2, false));
    this.hadMancheked = paramJceInputStream.read(this.hadMancheked, 3, false);
  }
  
  public void setComment(stMetaComment paramstMetaComment)
  {
    this.comment = paramstMetaComment;
  }
  
  public void setData(ArrayList<stMetaReportDataItem> paramArrayList)
  {
    this.data = paramArrayList;
  }
  
  public void setFeed_id(String paramString)
  {
    this.feed_id = paramString;
  }
  
  public void setHadMancheked(int paramInt)
  {
    this.hadMancheked = paramInt;
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_KING_INTERFACE.stPostFeedCommentReq
 * JD-Core Version:    0.7.0.1
 */