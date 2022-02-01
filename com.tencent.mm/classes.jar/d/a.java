package d;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends JceStruct
{
  public String aamT = "";
  public String aamU = "";
  public String aamV = "";
  public String aamW = "";
  
  public final void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(208155);
    this.aamV = paramJceInputStream.readString(0, false);
    this.aamT = paramJceInputStream.readString(1, false);
    this.aamW = paramJceInputStream.readString(2, false);
    this.aamU = paramJceInputStream.readString(3, false);
    AppMethodBeat.o(208155);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(208154);
    if (this.aamV != null) {
      paramJceOutputStream.write(this.aamV, 0);
    }
    if (this.aamT != null) {
      paramJceOutputStream.write(this.aamT, 1);
    }
    if (this.aamW != null) {
      paramJceOutputStream.write(this.aamW, 2);
    }
    if (this.aamU != null) {
      paramJceOutputStream.write(this.aamU, 3);
    }
    AppMethodBeat.o(208154);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     d.a
 * JD-Core Version:    0.7.0.1
 */