package d;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class e
  extends JceStruct
  implements Cloneable
{
  static ArrayList<d> aanz;
  public ArrayList<d> fmA = null;
  
  public final void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(207466);
    if (aanz == null)
    {
      ArrayList localArrayList = new ArrayList();
      aanz = localArrayList;
      localArrayList.add(new d());
    }
    this.fmA = ((ArrayList)paramJceInputStream.read(aanz, 0, true));
    AppMethodBeat.o(207466);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(207464);
    paramJceOutputStream.write(this.fmA, 0);
    AppMethodBeat.o(207464);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     d.e
 * JD-Core Version:    0.7.0.1
 */