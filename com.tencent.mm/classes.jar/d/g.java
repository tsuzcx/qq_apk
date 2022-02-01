package d;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends JceStruct
{
  public String SLM = "";
  public String SLN = "";
  public String SLO = "";
  
  public final void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(214845);
    this.SLM = paramJceInputStream.readString(0, true);
    this.SLO = paramJceInputStream.readString(1, true);
    this.SLN = paramJceInputStream.readString(2, false);
    AppMethodBeat.o(214845);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(214844);
    paramJceOutputStream.write(this.SLM, 0);
    paramJceOutputStream.write(this.SLO, 1);
    if (this.SLN != null) {
      paramJceOutputStream.write(this.SLN, 2);
    }
    AppMethodBeat.o(214844);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     d.g
 * JD-Core Version:    0.7.0.1
 */