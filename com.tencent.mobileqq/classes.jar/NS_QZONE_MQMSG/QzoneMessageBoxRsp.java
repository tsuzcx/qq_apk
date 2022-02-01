package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class QzoneMessageBoxRsp
  extends JceStruct
{
  static ArrayList<BottomContentItem> cache_bottomVec;
  static UnReadSummaryInfo cache_unread_info = new UnReadSummaryInfo();
  static ArrayList<NewMQMsg> cache_vecNews = new ArrayList();
  public ArrayList<BottomContentItem> bottomVec = null;
  public boolean hasMore = true;
  public int isNewStyle = 0;
  public String more_url = "";
  public long qzone_level = 0L;
  public long registered_days = 0L;
  public String sTraceInfo = "";
  public UnReadSummaryInfo unread_info = null;
  public ArrayList<NewMQMsg> vecNews = null;
  public long visitor_count = 0L;
  
  static
  {
    Object localObject = new NewMQMsg();
    cache_vecNews.add(localObject);
    cache_bottomVec = new ArrayList();
    localObject = new BottomContentItem();
    cache_bottomVec.add(localObject);
  }
  
  public QzoneMessageBoxRsp() {}
  
  public QzoneMessageBoxRsp(ArrayList<NewMQMsg> paramArrayList, String paramString1, boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3, String paramString2, ArrayList<BottomContentItem> paramArrayList1, int paramInt, UnReadSummaryInfo paramUnReadSummaryInfo)
  {
    this.vecNews = paramArrayList;
    this.sTraceInfo = paramString1;
    this.hasMore = paramBoolean;
    this.registered_days = paramLong1;
    this.qzone_level = paramLong2;
    this.visitor_count = paramLong3;
    this.more_url = paramString2;
    this.bottomVec = paramArrayList1;
    this.isNewStyle = paramInt;
    this.unread_info = paramUnReadSummaryInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vecNews = ((ArrayList)paramJceInputStream.read(cache_vecNews, 0, false));
    this.sTraceInfo = paramJceInputStream.readString(1, false);
    this.hasMore = paramJceInputStream.read(this.hasMore, 2, false);
    this.registered_days = paramJceInputStream.read(this.registered_days, 3, false);
    this.qzone_level = paramJceInputStream.read(this.qzone_level, 4, false);
    this.visitor_count = paramJceInputStream.read(this.visitor_count, 5, false);
    this.more_url = paramJceInputStream.readString(6, false);
    this.bottomVec = ((ArrayList)paramJceInputStream.read(cache_bottomVec, 7, false));
    this.isNewStyle = paramJceInputStream.read(this.isNewStyle, 8, false);
    this.unread_info = ((UnReadSummaryInfo)paramJceInputStream.read(cache_unread_info, 9, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.vecNews;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 0);
    }
    localObject = this.sTraceInfo;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    paramJceOutputStream.write(this.hasMore, 2);
    paramJceOutputStream.write(this.registered_days, 3);
    paramJceOutputStream.write(this.qzone_level, 4);
    paramJceOutputStream.write(this.visitor_count, 5);
    localObject = this.more_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.bottomVec;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 7);
    }
    paramJceOutputStream.write(this.isNewStyle, 8);
    localObject = this.unread_info;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QZONE_MQMSG.QzoneMessageBoxRsp
 * JD-Core Version:    0.7.0.1
 */