package Protocol.MConch;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class a
  extends JceStruct
{
  static ArrayList<d> bg = new ArrayList();
  public ArrayList<d> bf = null;
  
  static
  {
    d locald = new d();
    bg.add(locald);
  }
  
  public JceStruct newInit()
  {
    return new a();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bf = ((ArrayList)paramJceInputStream.read(bg, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.bf != null) {
      paramJceOutputStream.write(this.bf, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     Protocol.MConch.a
 * JD-Core Version:    0.7.0.1
 */