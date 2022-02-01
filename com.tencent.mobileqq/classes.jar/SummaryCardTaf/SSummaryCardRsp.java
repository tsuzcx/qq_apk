package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class SSummaryCardRsp
  extends JceStruct
{
  static ArrayList<Integer> cache_bgtype;
  static SUserLabel cache_label = new SUserLabel();
  static int cache_res;
  static cardDiyComplicatedInfo cache_stDiyComplicated = new cardDiyComplicatedInfo();
  static cardDiyTextInfo cache_stDiyText;
  static STRecommendInfo cache_stRecom;
  static ArrayList<summaryCardWzryInfo> cache_wzryInfo;
  public String aid = "";
  public long bgid = 0L;
  public ArrayList<Integer> bgtype = null;
  public String bgurl = "";
  public int cardType = 0;
  public long cardid = 0L;
  public long color = 0L;
  public int dynamicCardFlag = 0;
  public String emsg = "";
  public String extInfo = "";
  public SUserLabel label = null;
  public int payType = 0;
  public int profileid = 0;
  public int res = 0;
  public cardDiyComplicatedInfo stDiyComplicated = null;
  public cardDiyTextInfo stDiyText = null;
  public STRecommendInfo stRecom = null;
  public String strActiveCardUrl = "";
  public String strDiyDefaultText = "";
  public String strDrawerCard = "";
  public String strWzryHeroUrl = "";
  public String strZipUrl = "";
  public long styleid = 0L;
  public String urlprefix = "";
  public ArrayList<summaryCardWzryInfo> wzryInfo = null;
  
  static
  {
    cache_bgtype = new ArrayList();
    cache_bgtype.add(Integer.valueOf(0));
    cache_stRecom = new STRecommendInfo();
    cache_wzryInfo = new ArrayList();
    summaryCardWzryInfo localsummaryCardWzryInfo = new summaryCardWzryInfo();
    cache_wzryInfo.add(localsummaryCardWzryInfo);
    cache_stDiyText = new cardDiyTextInfo();
  }
  
  public SSummaryCardRsp() {}
  
  public SSummaryCardRsp(int paramInt1, long paramLong1, long paramLong2, String paramString1, long paramLong3, long paramLong4, SUserLabel paramSUserLabel, String paramString2, ArrayList<Integer> paramArrayList, int paramInt2, String paramString3, STRecommendInfo paramSTRecommendInfo, String paramString4, String paramString5, String paramString6, ArrayList<summaryCardWzryInfo> paramArrayList1, cardDiyTextInfo paramcardDiyTextInfo, int paramInt3, String paramString7, String paramString8, int paramInt4, String paramString9, cardDiyComplicatedInfo paramcardDiyComplicatedInfo, String paramString10, int paramInt5)
  {
    this.res = paramInt1;
    this.cardid = paramLong1;
    this.styleid = paramLong2;
    this.bgurl = paramString1;
    this.bgid = paramLong3;
    this.color = paramLong4;
    this.label = paramSUserLabel;
    this.emsg = paramString2;
    this.bgtype = paramArrayList;
    this.dynamicCardFlag = paramInt2;
    this.strZipUrl = paramString3;
    this.stRecom = paramSTRecommendInfo;
    this.strActiveCardUrl = paramString4;
    this.strDrawerCard = paramString5;
    this.strWzryHeroUrl = paramString6;
    this.wzryInfo = paramArrayList1;
    this.stDiyText = paramcardDiyTextInfo;
    this.cardType = paramInt3;
    this.strDiyDefaultText = paramString7;
    this.extInfo = paramString8;
    this.profileid = paramInt4;
    this.urlprefix = paramString9;
    this.stDiyComplicated = paramcardDiyComplicatedInfo;
    this.aid = paramString10;
    this.payType = paramInt5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.res = paramJceInputStream.read(this.res, 0, true);
    this.cardid = paramJceInputStream.read(this.cardid, 1, true);
    this.styleid = paramJceInputStream.read(this.styleid, 2, false);
    this.bgurl = paramJceInputStream.readString(3, false);
    this.bgid = paramJceInputStream.read(this.bgid, 4, false);
    this.color = paramJceInputStream.read(this.color, 5, false);
    this.label = ((SUserLabel)paramJceInputStream.read(cache_label, 6, false));
    this.emsg = paramJceInputStream.readString(7, false);
    this.bgtype = ((ArrayList)paramJceInputStream.read(cache_bgtype, 8, false));
    this.dynamicCardFlag = paramJceInputStream.read(this.dynamicCardFlag, 9, false);
    this.strZipUrl = paramJceInputStream.readString(10, false);
    this.stRecom = ((STRecommendInfo)paramJceInputStream.read(cache_stRecom, 11, false));
    this.strActiveCardUrl = paramJceInputStream.readString(12, false);
    this.strDrawerCard = paramJceInputStream.readString(13, false);
    this.strWzryHeroUrl = paramJceInputStream.readString(14, false);
    this.wzryInfo = ((ArrayList)paramJceInputStream.read(cache_wzryInfo, 15, false));
    this.stDiyText = ((cardDiyTextInfo)paramJceInputStream.read(cache_stDiyText, 16, false));
    this.cardType = paramJceInputStream.read(this.cardType, 17, false);
    this.strDiyDefaultText = paramJceInputStream.readString(18, false);
    this.extInfo = paramJceInputStream.readString(19, false);
    this.profileid = paramJceInputStream.read(this.profileid, 20, false);
    this.urlprefix = paramJceInputStream.readString(21, false);
    this.stDiyComplicated = ((cardDiyComplicatedInfo)paramJceInputStream.read(cache_stDiyComplicated, 22, false));
    this.aid = paramJceInputStream.readString(23, false);
    this.payType = paramJceInputStream.read(this.payType, 24, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.res, 0);
    paramJceOutputStream.write(this.cardid, 1);
    paramJceOutputStream.write(this.styleid, 2);
    Object localObject = this.bgurl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    paramJceOutputStream.write(this.bgid, 4);
    paramJceOutputStream.write(this.color, 5);
    localObject = this.label;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 6);
    }
    localObject = this.emsg;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    localObject = this.bgtype;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 8);
    }
    paramJceOutputStream.write(this.dynamicCardFlag, 9);
    localObject = this.strZipUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 10);
    }
    localObject = this.stRecom;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 11);
    }
    localObject = this.strActiveCardUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 12);
    }
    localObject = this.strDrawerCard;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 13);
    }
    localObject = this.strWzryHeroUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 14);
    }
    localObject = this.wzryInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 15);
    }
    localObject = this.stDiyText;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 16);
    }
    paramJceOutputStream.write(this.cardType, 17);
    localObject = this.strDiyDefaultText;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 18);
    }
    localObject = this.extInfo;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 19);
    }
    paramJceOutputStream.write(this.profileid, 20);
    localObject = this.urlprefix;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 21);
    }
    localObject = this.stDiyComplicated;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 22);
    }
    localObject = this.aid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 23);
    }
    paramJceOutputStream.write(this.payType, 24);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SummaryCardTaf.SSummaryCardRsp
 * JD-Core Version:    0.7.0.1
 */