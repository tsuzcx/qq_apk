package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ModGroupSort
  extends JceStruct
{
  static ArrayList<GroupSort> cache_vMsgGroupSort;
  public ArrayList<GroupSort> vMsgGroupSort;
  
  public ModGroupSort() {}
  
  public ModGroupSort(ArrayList<GroupSort> paramArrayList)
  {
    this.vMsgGroupSort = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vMsgGroupSort == null)
    {
      cache_vMsgGroupSort = new ArrayList();
      GroupSort localGroupSort = new GroupSort();
      cache_vMsgGroupSort.add(localGroupSort);
    }
    this.vMsgGroupSort = ((ArrayList)paramJceInputStream.read(cache_vMsgGroupSort, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vMsgGroupSort != null) {
      paramJceOutputStream.write(this.vMsgGroupSort, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     IMMsgBodyPack.ModGroupSort
 * JD-Core Version:    0.7.0.1
 */