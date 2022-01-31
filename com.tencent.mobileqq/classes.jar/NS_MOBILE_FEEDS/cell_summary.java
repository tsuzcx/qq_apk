package NS_MOBILE_FEEDS;

import NS_MOBILE_COMM.sparkle_word;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class cell_summary
  extends JceStruct
{
  static Map<String, String> cache_mapExt;
  static Map<String, byte[]> cache_mapProtoExt;
  static sparkle_word cache_sparkleword;
  static ArrayList<s_picdata> cache_summarypic = new ArrayList();
  public int actiontype;
  public String actionurl = "";
  public int hasmore;
  public Map<String, String> mapExt;
  public Map<String, byte[]> mapProtoExt;
  public String more_info = "";
  public sparkle_word sparkleword;
  public String summary = "";
  public ArrayList<s_picdata> summarypic;
  
  static
  {
    Object localObject = new s_picdata();
    cache_summarypic.add(localObject);
    cache_sparkleword = new sparkle_word();
    cache_mapExt = new HashMap();
    cache_mapExt.put("", "");
    cache_mapProtoExt = new HashMap();
    localObject = (byte[])new byte[1];
    ((byte[])localObject)[0] = 0;
    cache_mapProtoExt.put("", localObject);
  }
  
  public cell_summary() {}
  
  public cell_summary(String paramString1, int paramInt1, int paramInt2, ArrayList<s_picdata> paramArrayList, String paramString2, sparkle_word paramsparkle_word, Map<String, String> paramMap, Map<String, byte[]> paramMap1, String paramString3)
  {
    this.summary = paramString1;
    this.hasmore = paramInt1;
    this.actiontype = paramInt2;
    this.summarypic = paramArrayList;
    this.more_info = paramString2;
    this.sparkleword = paramsparkle_word;
    this.mapExt = paramMap;
    this.mapProtoExt = paramMap1;
    this.actionurl = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.summary = paramJceInputStream.readString(0, false);
    this.hasmore = paramJceInputStream.read(this.hasmore, 1, false);
    this.actiontype = paramJceInputStream.read(this.actiontype, 2, false);
    this.summarypic = ((ArrayList)paramJceInputStream.read(cache_summarypic, 3, false));
    this.more_info = paramJceInputStream.readString(4, false);
    this.sparkleword = ((sparkle_word)paramJceInputStream.read(cache_sparkleword, 5, false));
    this.mapExt = ((Map)paramJceInputStream.read(cache_mapExt, 6, false));
    this.mapProtoExt = ((Map)paramJceInputStream.read(cache_mapProtoExt, 7, false));
    this.actionurl = paramJceInputStream.readString(8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.summary != null) {
      paramJceOutputStream.write(this.summary, 0);
    }
    paramJceOutputStream.write(this.hasmore, 1);
    paramJceOutputStream.write(this.actiontype, 2);
    if (this.summarypic != null) {
      paramJceOutputStream.write(this.summarypic, 3);
    }
    if (this.more_info != null) {
      paramJceOutputStream.write(this.more_info, 4);
    }
    if (this.sparkleword != null) {
      paramJceOutputStream.write(this.sparkleword, 5);
    }
    if (this.mapExt != null) {
      paramJceOutputStream.write(this.mapExt, 6);
    }
    if (this.mapProtoExt != null) {
      paramJceOutputStream.write(this.mapProtoExt, 7);
    }
    if (this.actionurl != null) {
      paramJceOutputStream.write(this.actionurl, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_summary
 * JD-Core Version:    0.7.0.1
 */