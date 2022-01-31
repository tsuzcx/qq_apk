package NS_MOBILE_AD_BANNER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class MultiBanner
  extends JceStruct
{
  static ArrayList<Long> cache_recomUinList = new ArrayList();
  public boolean bNeedPiecewise = true;
  public boolean bNeedSpread;
  public String coverurl = "";
  public long createtime;
  public boolean from_now;
  public String jmpUrl = "";
  public int livetype;
  public int num;
  public ArrayList<Long> recomUinList;
  public String roomid = "";
  public String schemaurl = "";
  public String strNicks = "";
  public int styleType;
  public String summary = "";
  public long uUin;
  public String videoUrl = "";
  
  static
  {
    cache_recomUinList.add(Long.valueOf(0L));
  }
  
  public MultiBanner() {}
  
  public MultiBanner(String paramString1, long paramLong1, String paramString2, long paramLong2, String paramString3, int paramInt1, String paramString4, String paramString5, String paramString6, boolean paramBoolean1, String paramString7, ArrayList<Long> paramArrayList, int paramInt2, int paramInt3, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.strNicks = paramString1;
    this.uUin = paramLong1;
    this.roomid = paramString2;
    this.createtime = paramLong2;
    this.coverurl = paramString3;
    this.num = paramInt1;
    this.summary = paramString4;
    this.schemaurl = paramString5;
    this.jmpUrl = paramString6;
    this.from_now = paramBoolean1;
    this.videoUrl = paramString7;
    this.recomUinList = paramArrayList;
    this.styleType = paramInt2;
    this.livetype = paramInt3;
    this.bNeedPiecewise = paramBoolean2;
    this.bNeedSpread = paramBoolean3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strNicks = paramJceInputStream.readString(0, false);
    this.uUin = paramJceInputStream.read(this.uUin, 1, false);
    this.roomid = paramJceInputStream.readString(2, false);
    this.createtime = paramJceInputStream.read(this.createtime, 3, false);
    this.coverurl = paramJceInputStream.readString(4, false);
    this.num = paramJceInputStream.read(this.num, 5, false);
    this.summary = paramJceInputStream.readString(6, false);
    this.schemaurl = paramJceInputStream.readString(7, false);
    this.jmpUrl = paramJceInputStream.readString(8, false);
    this.from_now = paramJceInputStream.read(this.from_now, 9, false);
    this.videoUrl = paramJceInputStream.readString(10, false);
    this.recomUinList = ((ArrayList)paramJceInputStream.read(cache_recomUinList, 11, false));
    this.styleType = paramJceInputStream.read(this.styleType, 12, false);
    this.livetype = paramJceInputStream.read(this.livetype, 13, false);
    this.bNeedPiecewise = paramJceInputStream.read(this.bNeedPiecewise, 14, false);
    this.bNeedSpread = paramJceInputStream.read(this.bNeedSpread, 15, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.strNicks != null) {
      paramJceOutputStream.write(this.strNicks, 0);
    }
    paramJceOutputStream.write(this.uUin, 1);
    if (this.roomid != null) {
      paramJceOutputStream.write(this.roomid, 2);
    }
    paramJceOutputStream.write(this.createtime, 3);
    if (this.coverurl != null) {
      paramJceOutputStream.write(this.coverurl, 4);
    }
    paramJceOutputStream.write(this.num, 5);
    if (this.summary != null) {
      paramJceOutputStream.write(this.summary, 6);
    }
    if (this.schemaurl != null) {
      paramJceOutputStream.write(this.schemaurl, 7);
    }
    if (this.jmpUrl != null) {
      paramJceOutputStream.write(this.jmpUrl, 8);
    }
    paramJceOutputStream.write(this.from_now, 9);
    if (this.videoUrl != null) {
      paramJceOutputStream.write(this.videoUrl, 10);
    }
    if (this.recomUinList != null) {
      paramJceOutputStream.write(this.recomUinList, 11);
    }
    paramJceOutputStream.write(this.styleType, 12);
    paramJceOutputStream.write(this.livetype, 13);
    paramJceOutputStream.write(this.bNeedPiecewise, 14);
    paramJceOutputStream.write(this.bNeedSpread, 15);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     NS_MOBILE_AD_BANNER.MultiBanner
 * JD-Core Version:    0.7.0.1
 */