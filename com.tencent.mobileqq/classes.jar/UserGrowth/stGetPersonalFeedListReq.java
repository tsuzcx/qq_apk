package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class stGetPersonalFeedListReq
  extends JceStruct
{
  static ArrayList<String> cache_context_feedids = new ArrayList();
  public String attach_info = "";
  public ArrayList<String> context_feedids;
  public boolean isFirst = true;
  public String personId = "";
  public int scene;
  
  static
  {
    cache_context_feedids.add("");
  }
  
  public stGetPersonalFeedListReq() {}
  
  public stGetPersonalFeedListReq(String paramString1, ArrayList<String> paramArrayList, String paramString2, boolean paramBoolean, int paramInt)
  {
    this.personId = paramString1;
    this.context_feedids = paramArrayList;
    this.attach_info = paramString2;
    this.isFirst = paramBoolean;
    this.scene = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.personId = paramJceInputStream.readString(0, false);
    this.context_feedids = ((ArrayList)paramJceInputStream.read(cache_context_feedids, 1, false));
    this.attach_info = paramJceInputStream.readString(2, false);
    this.isFirst = paramJceInputStream.read(this.isFirst, 3, false);
    this.scene = paramJceInputStream.read(this.scene, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.personId != null) {
      paramJceOutputStream.write(this.personId, 0);
    }
    if (this.context_feedids != null) {
      paramJceOutputStream.write(this.context_feedids, 1);
    }
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 2);
    }
    paramJceOutputStream.write(this.isFirst, 3);
    paramJceOutputStream.write(this.scene, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stGetPersonalFeedListReq
 * JD-Core Version:    0.7.0.1
 */