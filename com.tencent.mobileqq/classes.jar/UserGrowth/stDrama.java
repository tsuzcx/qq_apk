package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stDrama
  extends JceStruct
{
  static stDramaInfo cache_dramaInfo = new stDramaInfo();
  public String barText = "";
  public stDramaInfo dramaInfo = null;
  public boolean showUpdate = true;
  public String tagIcon = "";
  
  public stDrama() {}
  
  public stDrama(stDramaInfo paramstDramaInfo, String paramString1, boolean paramBoolean, String paramString2)
  {
    this.dramaInfo = paramstDramaInfo;
    this.tagIcon = paramString1;
    this.showUpdate = paramBoolean;
    this.barText = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dramaInfo = ((stDramaInfo)paramJceInputStream.read(cache_dramaInfo, 0, false));
    this.tagIcon = paramJceInputStream.readString(1, false);
    this.showUpdate = paramJceInputStream.read(this.showUpdate, 2, false);
    this.barText = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.dramaInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.tagIcon;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    paramJceOutputStream.write(this.showUpdate, 2);
    localObject = this.barText;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stDrama
 * JD-Core Version:    0.7.0.1
 */