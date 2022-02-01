package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class stDramaFall
  extends JceStruct
{
  static stDrama cache_dramaInfo = new stDrama();
  static ArrayList<String> cache_images = new ArrayList();
  public String bgCover = "";
  public stDrama dramaInfo = null;
  public ArrayList<String> images = null;
  public String titleCover = "";
  
  static
  {
    cache_images.add("");
  }
  
  public stDramaFall() {}
  
  public stDramaFall(stDrama paramstDrama, String paramString1, String paramString2, ArrayList<String> paramArrayList)
  {
    this.dramaInfo = paramstDrama;
    this.bgCover = paramString1;
    this.titleCover = paramString2;
    this.images = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dramaInfo = ((stDrama)paramJceInputStream.read(cache_dramaInfo, 0, false));
    this.bgCover = paramJceInputStream.readString(1, false);
    this.titleCover = paramJceInputStream.readString(2, false);
    this.images = ((ArrayList)paramJceInputStream.read(cache_images, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.dramaInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.bgCover;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.titleCover;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.images;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stDramaFall
 * JD-Core Version:    0.7.0.1
 */