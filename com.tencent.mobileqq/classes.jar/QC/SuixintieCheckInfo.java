package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SuixintieCheckInfo
  extends JceStruct
{
  static ArrayList<SuixintieCheckItem> cache_vSuixintieCheckList = new ArrayList();
  public ArrayList<SuixintieCheckItem> vSuixintieCheckList = null;
  
  static
  {
    SuixintieCheckItem localSuixintieCheckItem = new SuixintieCheckItem();
    cache_vSuixintieCheckList.add(localSuixintieCheckItem);
  }
  
  public SuixintieCheckInfo() {}
  
  public SuixintieCheckInfo(ArrayList<SuixintieCheckItem> paramArrayList)
  {
    this.vSuixintieCheckList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vSuixintieCheckList = ((ArrayList)paramJceInputStream.read(cache_vSuixintieCheckList, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vSuixintieCheckList != null) {
      paramJceOutputStream.write(this.vSuixintieCheckList, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.SuixintieCheckInfo
 * JD-Core Version:    0.7.0.1
 */