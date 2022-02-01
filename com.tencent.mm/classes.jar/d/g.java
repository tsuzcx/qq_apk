package d;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends JceStruct
{
  public String aanH = "";
  public String aanI = "";
  public String aanJ = "";
  
  public final void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(207481);
    this.aanH = paramJceInputStream.readString(0, true);
    this.aanJ = paramJceInputStream.readString(1, true);
    this.aanI = paramJceInputStream.readString(2, false);
    AppMethodBeat.o(207481);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(207479);
    paramJceOutputStream.write(this.aanH, 0);
    paramJceOutputStream.write(this.aanJ, 1);
    if (this.aanI != null) {
      paramJceOutputStream.write(this.aanI, 2);
    }
    AppMethodBeat.o(207479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     d.g
 * JD-Core Version:    0.7.0.1
 */