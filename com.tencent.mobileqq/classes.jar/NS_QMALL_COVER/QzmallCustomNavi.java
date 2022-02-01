package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QzmallCustomNavi
  extends JceStruct
{
  public int iItemId = -1;
  public long lArrowColor;
  public long lBtnTextColor;
  public long lProfileCrossBarBgColor;
  public long lProfileCrossBarSeparatorColor;
  public long lProfileDescTextColor;
  public long lSeparatorColor;
  public String strActiveFeedNaviUrl = "";
  public String strProfileNaviUrl = "";
  
  public QzmallCustomNavi() {}
  
  public QzmallCustomNavi(int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6)
  {
    this.iItemId = paramInt;
    this.strActiveFeedNaviUrl = paramString1;
    this.strProfileNaviUrl = paramString2;
    this.lSeparatorColor = paramLong1;
    this.lBtnTextColor = paramLong2;
    this.lProfileDescTextColor = paramLong3;
    this.lProfileCrossBarBgColor = paramLong4;
    this.lProfileCrossBarSeparatorColor = paramLong5;
    this.lArrowColor = paramLong6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iItemId = paramJceInputStream.read(this.iItemId, 0, true);
    this.strActiveFeedNaviUrl = paramJceInputStream.readString(1, false);
    this.strProfileNaviUrl = paramJceInputStream.readString(2, false);
    this.lSeparatorColor = paramJceInputStream.read(this.lSeparatorColor, 3, false);
    this.lBtnTextColor = paramJceInputStream.read(this.lBtnTextColor, 4, false);
    this.lProfileDescTextColor = paramJceInputStream.read(this.lProfileDescTextColor, 5, false);
    this.lProfileCrossBarBgColor = paramJceInputStream.read(this.lProfileCrossBarBgColor, 6, false);
    this.lProfileCrossBarSeparatorColor = paramJceInputStream.read(this.lProfileCrossBarSeparatorColor, 7, false);
    this.lArrowColor = paramJceInputStream.read(this.lArrowColor, 8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iItemId, 0);
    String str = this.strActiveFeedNaviUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.strProfileNaviUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    paramJceOutputStream.write(this.lSeparatorColor, 3);
    paramJceOutputStream.write(this.lBtnTextColor, 4);
    paramJceOutputStream.write(this.lProfileDescTextColor, 5);
    paramJceOutputStream.write(this.lProfileCrossBarBgColor, 6);
    paramJceOutputStream.write(this.lProfileCrossBarSeparatorColor, 7);
    paramJceOutputStream.write(this.lArrowColor, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QMALL_COVER.QzmallCustomNavi
 * JD-Core Version:    0.7.0.1
 */