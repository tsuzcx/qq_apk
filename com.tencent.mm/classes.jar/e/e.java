package e;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class e
  extends JceStruct
  implements Cloneable
{
  static ArrayList<d> aitQ;
  public ArrayList<d> hqL = null;
  
  public final void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(187156);
    if (aitQ == null)
    {
      ArrayList localArrayList = new ArrayList();
      aitQ = localArrayList;
      localArrayList.add(new d());
    }
    this.hqL = ((ArrayList)paramJceInputStream.read(aitQ, 0, true));
    AppMethodBeat.o(187156);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(187147);
    paramJceOutputStream.write(this.hqL, 0);
    AppMethodBeat.o(187147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     e.e
 * JD-Core Version:    0.7.0.1
 */