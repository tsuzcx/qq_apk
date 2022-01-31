package NS_KING_INTERFACE;

import NS_KING_SOCIALIZE_META.stMetaReportDataItem;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class stPostFeedDingReq
  extends JceStruct
{
  static ArrayList<stMetaReportDataItem> cache_data = new ArrayList();
  public ArrayList<stMetaReportDataItem> data;
  public int dingAction;
  public String feed_id = "";
  
  static
  {
    stMetaReportDataItem localstMetaReportDataItem = new stMetaReportDataItem();
    cache_data.add(localstMetaReportDataItem);
  }
  
  public stPostFeedDingReq() {}
  
  public stPostFeedDingReq(String paramString, ArrayList<stMetaReportDataItem> paramArrayList, int paramInt)
  {
    this.feed_id = paramString;
    this.data = paramArrayList;
    this.dingAction = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.feed_id = paramJceInputStream.readString(1, true);
    this.data = ((ArrayList)paramJceInputStream.read(cache_data, 2, false));
    this.dingAction = paramJceInputStream.read(this.dingAction, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.feed_id, 1);
    if (this.data != null) {
      paramJceOutputStream.write(this.data, 2);
    }
    paramJceOutputStream.write(this.dingAction, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_KING_INTERFACE.stPostFeedDingReq
 * JD-Core Version:    0.7.0.1
 */