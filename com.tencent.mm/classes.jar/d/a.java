package d;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends JceStruct
{
  public String SKY = "";
  public String SKZ = "";
  public String SLa = "";
  public String SLb = "";
  
  public final void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(214833);
    this.SLa = paramJceInputStream.readString(0, false);
    this.SKY = paramJceInputStream.readString(1, false);
    this.SLb = paramJceInputStream.readString(2, false);
    this.SKZ = paramJceInputStream.readString(3, false);
    AppMethodBeat.o(214833);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(214832);
    if (this.SLa != null) {
      paramJceOutputStream.write(this.SLa, 0);
    }
    if (this.SKY != null) {
      paramJceOutputStream.write(this.SKY, 1);
    }
    if (this.SLb != null) {
      paramJceOutputStream.write(this.SLb, 2);
    }
    if (this.SKZ != null) {
      paramJceOutputStream.write(this.SKZ, 3);
    }
    AppMethodBeat.o(214832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     d.a
 * JD-Core Version:    0.7.0.1
 */