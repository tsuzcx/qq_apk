package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class s_yytag
  extends JceStruct
{
  static ArrayList<Integer> cache_beginEndSeconds = new ArrayList();
  public int actiontype = 0;
  public String actionurl = "";
  public ArrayList<Integer> beginEndSeconds = null;
  public String content = "";
  public int displaytype = 0;
  public String logo = "";
  public int scene = 0;
  
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
    Object localObject = this.logo;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.content;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    paramJceOutputStream.write(this.actiontype, 2);
    localObject = this.actionurl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    paramJceOutputStream.write(this.scene, 4);
    paramJceOutputStream.write(this.displaytype, 5);
    localObject = this.beginEndSeconds;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_yytag
 * JD-Core Version:    0.7.0.1
 */