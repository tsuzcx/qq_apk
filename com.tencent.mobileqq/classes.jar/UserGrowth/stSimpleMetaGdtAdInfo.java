package UserGrowth;

import NS_MOBILE_FEEDS.s_button;
import NS_MOBILE_FEEDS.s_droplist_option;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class stSimpleMetaGdtAdInfo
  extends JceStruct
{
  static s_button cache_bottom_button;
  static stFloatingLayerCardStyle cache_floatingLayerCardStyle = new stFloatingLayerCardStyle();
  static stImgReplacement cache_imgReplacements = new stImgReplacement();
  static stNewIconStyle cache_new_icon = new stNewIconStyle();
  static stSimpleMetaPerson cache_poster;
  public String actionUrl;
  public int advPos;
  public String appid;
  public s_button bottomButton;
  public Map<Integer, String> busiParam = null;
  public String canvasData;
  public String cellId = "";
  public Map<Integer, String> cookie;
  public ArrayList<s_droplist_option> customDroplist;
  public int dest_type;
  public String dest_url;
  public stFloatingLayerCardStyle floatingLayerCardStyle = null;
  public String gdtTangramAdJson = "";
  public int hasReportExposure;
  public String impressionUrl;
  public boolean isGdtAdImpressionReport = false;
  public boolean isGdtAdOriginalImpressionReport = false;
  public boolean isGdtAdVidoReport = false;
  public boolean isGdtAdclicked = false;
  public boolean isWeishiGdtTangramAdv;
  public stNewIconStyle left_top_button;
  public Map<Integer, byte[]> mapPassBack = null;
  public int numbersOfGdtAdPlayed = 0;
  public stImgReplacement pictureUrl = null;
  public byte playType;
  public int rankCurrentWithHalfStar;
  public String reportUrl;
  public String schemaPageUrl;
  public Map<Integer, Integer> stMapABTest = null;
  public String summary;
  public stSimpleMetaPerson user;
  public int videoClickType = 0;
  public String videoId;
  public long videoTime;
  public int videoType;
  public String video_url = "";
  
  static
  {
    cache_bottom_button = new s_button();
    cache_poster = new stSimpleMetaPerson();
  }
  
  public stSimpleMetaGdtAdInfo() {}
  
  public stSimpleMetaGdtAdInfo(boolean paramBoolean1, String paramString1, String paramString2, stFloatingLayerCardStyle paramstFloatingLayerCardStyle, Map<Integer, String> paramMap1, String paramString3, s_button params_button, byte paramByte, int paramInt1, long paramLong, stSimpleMetaPerson paramstSimpleMetaPerson, String paramString4, String paramString5, int paramInt2, String paramString6, stImgReplacement paramstImgReplacement, ArrayList<s_droplist_option> paramArrayList, String paramString7, String paramString8, int paramInt3, String paramString9, String paramString10, int paramInt4, String paramString11, stNewIconStyle paramstNewIconStyle, Map<Integer, byte[]> paramMap, Map<Integer, Integer> paramMap2, int paramInt5, Map<Integer, String> paramMap3, int paramInt6, String paramString12, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt7, boolean paramBoolean5)
  {
    this.isWeishiGdtTangramAdv = paramBoolean1;
    this.gdtTangramAdJson = paramString1;
    this.cellId = paramString2;
    this.floatingLayerCardStyle = paramstFloatingLayerCardStyle;
    this.cookie = paramMap1;
    this.appid = paramString3;
    this.bottomButton = params_button;
    this.playType = paramByte;
    this.videoType = paramInt1;
    this.videoTime = paramLong;
    this.user = paramstSimpleMetaPerson;
    this.video_url = paramString4;
    this.videoId = paramString5;
    this.videoClickType = paramInt2;
    this.summary = paramString6;
    this.pictureUrl = paramstImgReplacement;
    this.customDroplist = paramArrayList;
    this.canvasData = paramString7;
    this.dest_url = paramString8;
    this.dest_type = paramInt3;
    this.reportUrl = paramString9;
    this.actionUrl = paramString10;
    this.rankCurrentWithHalfStar = paramInt4;
    this.schemaPageUrl = paramString11;
    this.left_top_button = paramstNewIconStyle;
    this.mapPassBack = paramMap;
    this.stMapABTest = paramMap2;
    this.hasReportExposure = paramInt5;
    this.busiParam = paramMap3;
    this.advPos = paramInt6;
    this.impressionUrl = paramString12;
    this.isGdtAdImpressionReport = paramBoolean2;
    this.isGdtAdVidoReport = paramBoolean3;
    this.isGdtAdclicked = paramBoolean4;
    this.numbersOfGdtAdPlayed = paramInt7;
    this.isGdtAdOriginalImpressionReport = paramBoolean5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.isWeishiGdtTangramAdv = paramJceInputStream.read(this.isWeishiGdtTangramAdv, 0, false);
    this.gdtTangramAdJson = paramJceInputStream.readString(1, false);
    this.cellId = paramJceInputStream.readString(2, false);
    this.floatingLayerCardStyle = ((stFloatingLayerCardStyle)paramJceInputStream.read(cache_floatingLayerCardStyle, 3, false));
    this.cookie = ((Map)paramJceInputStream.read(this.cookie, 4, false));
    this.appid = paramJceInputStream.readString(5, false);
    this.bottomButton = ((s_button)paramJceInputStream.read(cache_new_icon, 6, false));
    this.playType = paramJceInputStream.read(this.playType, 7, false);
    this.videoType = paramJceInputStream.read(this.videoType, 8, false);
    this.videoTime = paramJceInputStream.read(this.videoTime, 9, false);
    this.user = ((stSimpleMetaPerson)paramJceInputStream.read(cache_poster, 10, false));
    this.video_url = paramJceInputStream.readString(11, false);
    this.videoId = paramJceInputStream.readString(12, false);
    this.videoClickType = paramJceInputStream.read(this.videoClickType, 13, false);
    this.summary = paramJceInputStream.readString(14, false);
    this.pictureUrl = ((stImgReplacement)paramJceInputStream.read(cache_imgReplacements, 15, false));
    this.customDroplist = ((ArrayList)paramJceInputStream.read(this.customDroplist, 16, false));
    this.canvasData = paramJceInputStream.readString(17, false);
    this.dest_url = paramJceInputStream.readString(18, false);
    this.dest_type = paramJceInputStream.read(this.dest_type, 19, false);
    this.reportUrl = paramJceInputStream.readString(20, false);
    this.actionUrl = paramJceInputStream.readString(21, false);
    this.rankCurrentWithHalfStar = paramJceInputStream.read(this.rankCurrentWithHalfStar, 22, false);
    this.schemaPageUrl = paramJceInputStream.readString(23, false);
    this.left_top_button = ((stNewIconStyle)paramJceInputStream.read(cache_new_icon, 24, false));
    this.mapPassBack = ((Map)paramJceInputStream.read(this.mapPassBack, 25, false));
    this.stMapABTest = ((Map)paramJceInputStream.read(this.stMapABTest, 26, false));
    this.hasReportExposure = paramJceInputStream.read(this.hasReportExposure, 27, false);
    this.busiParam = ((Map)paramJceInputStream.read(this.stMapABTest, 28, false));
    this.advPos = paramJceInputStream.read(this.advPos, 29, false);
    this.impressionUrl = paramJceInputStream.readString(30, false);
    this.isGdtAdImpressionReport = paramJceInputStream.read(this.isWeishiGdtTangramAdv, 31, false);
    this.isGdtAdVidoReport = paramJceInputStream.read(this.isGdtAdVidoReport, 32, false);
    this.isGdtAdclicked = paramJceInputStream.read(this.isGdtAdclicked, 33, false);
    this.numbersOfGdtAdPlayed = paramJceInputStream.read(this.numbersOfGdtAdPlayed, 34, false);
    this.isGdtAdOriginalImpressionReport = paramJceInputStream.read(this.isGdtAdOriginalImpressionReport, 35, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.isWeishiGdtTangramAdv, 0);
    Object localObject = this.gdtTangramAdJson;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.cellId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.floatingLayerCardStyle;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.cookie;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 4);
    }
    localObject = this.appid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.bottomButton;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 6);
    }
    paramJceOutputStream.write(this.playType, 7);
    paramJceOutputStream.write(this.videoType, 8);
    paramJceOutputStream.write(this.videoTime, 9);
    localObject = this.user;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 10);
    }
    localObject = this.video_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 11);
    }
    localObject = this.videoId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 12);
    }
    paramJceOutputStream.write(this.videoClickType, 13);
    localObject = this.summary;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 14);
    }
    localObject = this.pictureUrl;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 15);
    }
    localObject = this.customDroplist;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 16);
    }
    localObject = this.canvasData;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 17);
    }
    localObject = this.dest_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 18);
    }
    paramJceOutputStream.write(this.dest_type, 19);
    localObject = this.reportUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 20);
    }
    localObject = this.actionUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 21);
    }
    paramJceOutputStream.write(this.rankCurrentWithHalfStar, 22);
    localObject = this.schemaPageUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 23);
    }
    localObject = this.left_top_button;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 24);
    }
    localObject = this.mapPassBack;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 25);
    }
    localObject = this.stMapABTest;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 26);
    }
    paramJceOutputStream.write(this.hasReportExposure, 27);
    localObject = this.busiParam;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 28);
    }
    paramJceOutputStream.write(this.advPos, 29);
    localObject = this.impressionUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 30);
    }
    paramJceOutputStream.write(this.isGdtAdImpressionReport, 31);
    paramJceOutputStream.write(this.isGdtAdVidoReport, 32);
    paramJceOutputStream.write(this.isGdtAdclicked, 33);
    paramJceOutputStream.write(this.numbersOfGdtAdPlayed, 34);
    paramJceOutputStream.write(this.isGdtAdOriginalImpressionReport, 35);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stSimpleMetaGdtAdInfo
 * JD-Core Version:    0.7.0.1
 */