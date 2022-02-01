package e;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends JceStruct
{
  public String aitk = "";
  public String aitl = "";
  public String aitm = "";
  public String aitn = "";
  
  public final void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(187153);
    this.aitm = paramJceInputStream.readString(0, false);
    this.aitk = paramJceInputStream.readString(1, false);
    this.aitn = paramJceInputStream.readString(2, false);
    this.aitl = paramJceInputStream.readString(3, false);
    AppMethodBeat.o(187153);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(187143);
    if (this.aitm != null) {
      paramJceOutputStream.write(this.aitm, 0);
    }
    if (this.aitk != null) {
      paramJceOutputStream.write(this.aitk, 1);
    }
    if (this.aitn != null) {
      paramJceOutputStream.write(this.aitn, 2);
    }
    if (this.aitl != null) {
      paramJceOutputStream.write(this.aitl, 3);
    }
    AppMethodBeat.o(187143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     e.a
 * JD-Core Version:    0.7.0.1
 */