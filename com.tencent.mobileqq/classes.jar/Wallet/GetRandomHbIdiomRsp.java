package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetRandomHbIdiomRsp
  extends JceStruct
{
  static ArrayList<String> cache_suggestIdioms = new ArrayList();
  public long makeUin = 0L;
  public ArrayList<String> suggestIdioms = null;
  
  static
  {
    cache_suggestIdioms.add("");
  }
  
  public GetRandomHbIdiomRsp() {}
  
  public GetRandomHbIdiomRsp(long paramLong, ArrayList<String> paramArrayList)
  {
    this.makeUin = paramLong;
    this.suggestIdioms = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.makeUin = paramJceInputStream.read(this.makeUin, 0, false);
    this.suggestIdioms = ((ArrayList)paramJceInputStream.read(cache_suggestIdioms, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.makeUin, 0);
    ArrayList localArrayList = this.suggestIdioms;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.GetRandomHbIdiomRsp
 * JD-Core Version:    0.7.0.1
 */