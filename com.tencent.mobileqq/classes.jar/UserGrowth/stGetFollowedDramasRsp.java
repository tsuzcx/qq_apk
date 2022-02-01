package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class stGetFollowedDramasRsp
  extends JceStruct
{
  static ArrayList<stDrama> cache_dramas = new ArrayList();
  public String attachInfo = "";
  public ArrayList<stDrama> dramas = null;
  public boolean isFinished = true;
  public String title = "";
  
  static
  {
    stDrama localstDrama = new stDrama();
    cache_dramas.add(localstDrama);
  }
  
  public stGetFollowedDramasRsp() {}
  
  public stGetFollowedDramasRsp(String paramString1, boolean paramBoolean, ArrayList<stDrama> paramArrayList, String paramString2)
  {
    this.attachInfo = paramString1;
    this.isFinished = paramBoolean;
    this.dramas = paramArrayList;
    this.title = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.attachInfo = paramJceInputStream.readString(0, false);
    this.isFinished = paramJceInputStream.read(this.isFinished, 1, false);
    this.dramas = ((ArrayList)paramJceInputStream.read(cache_dramas, 2, false));
    this.title = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.attachInfo;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    paramJceOutputStream.write(this.isFinished, 1);
    localObject = this.dramas;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
    localObject = this.title;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stGetFollowedDramasRsp
 * JD-Core Version:    0.7.0.1
 */