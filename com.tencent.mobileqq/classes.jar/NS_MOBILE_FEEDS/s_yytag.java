package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class s_yytag
  extends JceStruct
{
  static ArrayList<Integer> cache_beginEndSeconds = new ArrayList();
  public int actiontype;
  public String actionurl = "";
  public ArrayList<Integer> beginEndSeconds;
  public String content = "";
  public int displaytype;
  public String logo = "";
  public int scene;
  
  static
  {
    cache_beginEndSeconds.add(Integer.valueOf(0));
  }
  
  public s_yytag() {}
  
  public s_yytag(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, int paramInt3, ArrayList<Integer> paramArrayList)
  {
    this.logo = paramString1;
    this.content = paramString2;
    this.actiontype = paramInt1;
    this.actionurl = paramString3;
    this.scene = paramInt2;
    this.displaytype = paramInt3;
    this.beginEndSeconds = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.logo = paramJceInputStream.readString(0, false);
    this.content = paramJceInputStream.readString(1, false);
    this.actiontype = paramJceInputStream.read(this.actiontype, 2, false);
    this.actionurl = paramJceInputStream.readString(3, false);
    this.scene = paramJceInputStream.read(this.scene, 4, false);
    this.displaytype = paramJceInputStream.read(this.displaytype, 5, false);
    this.beginEndSeconds = ((ArrayList)paramJceInputStream.read(cache_beginEndSeconds, 6, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.logo != null) {
      paramJceOutputStream.write(this.logo, 0);
    }
    if (this.content != null) {
      paramJceOutputStream.write(this.content, 1);
    }
    paramJceOutputStream.write(this.actiontype, 2);
    if (this.actionurl != null) {
      paramJceOutputStream.write(this.actionurl, 3);
    }
    paramJceOutputStream.write(this.scene, 4);
    paramJceOutputStream.write(this.displaytype, 5);
    if (this.beginEndSeconds != null) {
      paramJceOutputStream.write(this.beginEndSeconds, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_yytag
 * JD-Core Version:    0.7.0.1
 */