package MConch;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class NewCommonConchArgs
  extends JceStruct
{
  static ArrayList<String> cache_newParam = new ArrayList();
  public ArrayList<String> newParam = null;
  
  static
  {
    cache_newParam.add("");
  }
  
  public JceStruct newInit()
  {
    return new NewCommonConchArgs();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.newParam = ((ArrayList)paramJceInputStream.read(cache_newParam, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.newParam != null) {
      paramJceOutputStream.write(this.newParam, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     MConch.NewCommonConchArgs
 * JD-Core Version:    0.7.0.1
 */