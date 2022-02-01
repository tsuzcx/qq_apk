package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetUsrKeyWordInfoRsp
  extends JceStruct
{
  static ArrayList<OneKeyWordItemClient> cache_vBaseWord = new ArrayList();
  static ArrayList<OneKeyWordItemClient> cache_vVaWord;
  public int iShowEntry = 0;
  public ArrayList<OneKeyWordItemClient> vBaseWord = null;
  public ArrayList<OneKeyWordItemClient> vVaWord = null;
  
  static
  {
    OneKeyWordItemClient localOneKeyWordItemClient = new OneKeyWordItemClient();
    cache_vBaseWord.add(localOneKeyWordItemClient);
    cache_vVaWord = new ArrayList();
    localOneKeyWordItemClient = new OneKeyWordItemClient();
    cache_vVaWord.add(localOneKeyWordItemClient);
  }
  
  public GetUsrKeyWordInfoRsp() {}
  
  public GetUsrKeyWordInfoRsp(ArrayList<OneKeyWordItemClient> paramArrayList1, ArrayList<OneKeyWordItemClient> paramArrayList2, int paramInt)
  {
    this.vBaseWord = paramArrayList1;
    this.vVaWord = paramArrayList2;
    this.iShowEntry = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vBaseWord = ((ArrayList)paramJceInputStream.read(cache_vBaseWord, 0, false));
    this.vVaWord = ((ArrayList)paramJceInputStream.read(cache_vVaWord, 1, false));
    this.iShowEntry = paramJceInputStream.read(this.iShowEntry, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    ArrayList localArrayList = this.vBaseWord;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 0);
    }
    localArrayList = this.vVaWord;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 1);
    }
    paramJceOutputStream.write(this.iShowEntry, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.GetUsrKeyWordInfoRsp
 * JD-Core Version:    0.7.0.1
 */