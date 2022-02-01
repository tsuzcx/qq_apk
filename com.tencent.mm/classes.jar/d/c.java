package d;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends JceStruct
{
  public String KJM = "";
  public String SLd = "";
  public String SLe = "";
  public String SLf = "";
  public String fuD = "";
  public String qua = "";
  
  public final void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(214837);
    this.SLd = paramJceInputStream.readString(0, true);
    this.SLf = paramJceInputStream.readString(1, true);
    this.qua = paramJceInputStream.readString(2, true);
    this.fuD = paramJceInputStream.readString(3, true);
    this.KJM = paramJceInputStream.readString(4, true);
    this.SLe = paramJceInputStream.readString(5, false);
    AppMethodBeat.o(214837);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(214836);
    paramJceOutputStream.write(this.SLd, 0);
    paramJceOutputStream.write(this.SLf, 1);
    paramJceOutputStream.write(this.qua, 2);
    paramJceOutputStream.write(this.fuD, 3);
    paramJceOutputStream.write(this.KJM, 4);
    if (this.SLe != null) {
      paramJceOutputStream.write(this.SLe, 5);
    }
    AppMethodBeat.o(214836);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     d.c
 * JD-Core Version:    0.7.0.1
 */