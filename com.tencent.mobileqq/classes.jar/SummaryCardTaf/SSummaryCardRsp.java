package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SSummaryCardRsp
  extends JceStruct
{
  static ArrayList<Integer> cache_bgtype;
  static SUserLabel cache_label;
  static int cache_res = 0;
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
    cache_label = new SUserLabel();
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
    if (this.bgurl != null) {
      paramJceOutputStream.write(this.bgurl, 3);
    }
    paramJceOutputStream.write(this.bgid, 4);
    paramJceOutputStream.write(this.color, 5);
    if (this.label != null) {
      paramJceOutputStream.write(this.label, 6);
    }
    if (this.emsg != null) {
      paramJceOutputStream.write(this.emsg, 7);
    }
    if (this.bgtype != null) {
      paramJceOutputStream.write(this.bgtype, 8);
    }
    paramJceOutputStream.write(this.dynamicCardFlag, 9);
    if (this.strZipUrl != null) {
      paramJceOutputStream.write(this.strZipUrl, 10);
    }
    if (this.stRecom != null) {
      paramJceOutputStream.write(this.stRecom, 11);
    }
    if (this.strActiveCardUrl != null) {
      paramJceOutputStream.write(this.strActiveCardUrl, 12);
    }
    if (this.strDrawerCard != null) {
      paramJceOutputStream.write(this.strDrawerCard, 13);
    }
    if (this.strWzryHeroUrl != null) {
      paramJceOutputStream.write(this.strWzryHeroUrl, 14);
    }
    if (this.wzryInfo != null) {
      paramJceOutputStream.write(this.wzryInfo, 15);
    }
    if (this.stDiyText != null) {
      paramJceOutputStream.write(this.stDiyText, 16);
    }
    paramJceOutputStream.write(this.cardType, 17);
    if (this.strDiyDefaultText != null) {
      paramJceOutputStream.write(this.strDiyDefaultText, 18);
    }
    if (this.extInfo != null) {
      paramJceOutputStream.write(this.extInfo, 19);
    }
    paramJceOutputStream.write(this.profileid, 20);
    if (this.urlprefix != null) {
      paramJceOutputStream.write(this.urlprefix, 21);
    }
    if (this.stDiyComplicated != null) {
      paramJceOutputStream.write(this.stDiyComplicated, 22);
    }
    if (this.aid != null) {
      paramJceOutputStream.write(this.aid, 23);
    }
    paramJceOutputStream.write(this.payType, 24);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SummaryCardTaf.SSummaryCardRsp
 * JD-Core Version:    0.7.0.1
 */