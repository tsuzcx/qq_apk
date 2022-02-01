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
  static ArrayList<d> SLE;
  public ArrayList<d> dtS = null;
  
  public final void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(214841);
    if (SLE == null)
    {
      ArrayList localArrayList = new ArrayList();
      SLE = localArrayList;
      localArrayList.add(new d());
    }
    this.dtS = ((ArrayList)paramJceInputStream.read(SLE, 0, true));
    AppMethodBeat.o(214841);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(214840);
    paramJceOutputStream.write(this.dtS, 0);
    AppMethodBeat.o(214840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     d.e
 * JD-Core Version:    0.7.0.1
 */