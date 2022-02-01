package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ExtraAppInfo
  extends JceStruct
{
  static ArrayList<Integer> cache_usableScene = new ArrayList();
  public String desc = "";
  public int fontType;
  public int specialType;
  public ArrayList<Integer> usableScene;
  
  static
  {
    cache_usableScene.add(Integer.valueOf(0));
  }
  
  public ExtraAppInfo() {}
  
  public ExtraAppInfo(int paramInt1, int paramInt2, String paramString, ArrayList<Integer> paramArrayList)
  {
    this.fontType = paramInt1;
    this.specialType = paramInt2;
    this.desc = paramString;
    this.usableScene = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.fontType = paramJceInputStream.read(this.fontType, 0, false);
    this.specialType = paramJceInputStream.read(this.specialType, 1, false);
    this.desc = paramJceInputStream.readString(2, false);
    this.usableScene = ((ArrayList)paramJceInputStream.read(cache_usableScene, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.fontType, 0);
    paramJceOutputStream.write(this.specialType, 1);
    if (this.desc != null) {
      paramJceOutputStream.write(this.desc, 2);
    }
    if (this.usableScene != null) {
      paramJceOutputStream.write(this.usableScene, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.ExtraAppInfo
 * JD-Core Version:    0.7.0.1
 */