package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class stRedDotReq
  extends JceStruct
{
  static ArrayList<Integer> cache_exposedType;
  static int cache_reddotAction = 0;
  public ArrayList<Integer> exposedType = null;
  public int reddotAction = 0;
  public int reddotType = 0;
  
  static
  {
    cache_exposedType = new ArrayList();
    cache_exposedType.add(Integer.valueOf(0));
  }
  
  public stRedDotReq() {}
  
  public stRedDotReq(int paramInt1, int paramInt2, ArrayList<Integer> paramArrayList)
  {
    this.reddotType = paramInt1;
    this.reddotAction = paramInt2;
    this.exposedType = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.reddotType = paramJceInputStream.read(this.reddotType, 0, false);
    this.reddotAction = paramJceInputStream.read(this.reddotAction, 1, false);
    this.exposedType = ((ArrayList)paramJceInputStream.read(cache_exposedType, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.reddotType, 0);
    paramJceOutputStream.write(this.reddotAction, 1);
    if (this.exposedType != null) {
      paramJceOutputStream.write(this.exposedType, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stRedDotReq
 * JD-Core Version:    0.7.0.1
 */