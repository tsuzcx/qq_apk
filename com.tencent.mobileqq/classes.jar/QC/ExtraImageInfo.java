package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ExtraImageInfo
  extends JceStruct
{
  static ArrayList<String> cache_images = new ArrayList();
  public ArrayList<String> images = null;
  public int isdynamic = 0;
  
  static
  {
    cache_images.add("");
  }
  
  public ExtraImageInfo() {}
  
  public ExtraImageInfo(int paramInt, ArrayList<String> paramArrayList)
  {
    this.isdynamic = paramInt;
    this.images = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.isdynamic = paramJceInputStream.read(this.isdynamic, 0, false);
    this.images = ((ArrayList)paramJceInputStream.read(cache_images, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.isdynamic, 0);
    ArrayList localArrayList = this.images;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.ExtraImageInfo
 * JD-Core Version:    0.7.0.1
 */