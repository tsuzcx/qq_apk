package e;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends JceStruct
{
  public String aitp = "";
  public String aitq = "";
  public String aitr = "";
  public String comment = "";
  public String kab = "";
  public String qua = "";
  
  public final void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(187155);
    this.aitp = paramJceInputStream.readString(0, true);
    this.aitr = paramJceInputStream.readString(1, true);
    this.qua = paramJceInputStream.readString(2, true);
    this.kab = paramJceInputStream.readString(3, true);
    this.comment = paramJceInputStream.readString(4, true);
    this.aitq = paramJceInputStream.readString(5, false);
    AppMethodBeat.o(187155);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(187145);
    paramJceOutputStream.write(this.aitp, 0);
    paramJceOutputStream.write(this.aitr, 1);
    paramJceOutputStream.write(this.qua, 2);
    paramJceOutputStream.write(this.kab, 3);
    paramJceOutputStream.write(this.comment, 4);
    if (this.aitq != null) {
      paramJceOutputStream.write(this.aitq, 5);
    }
    AppMethodBeat.o(187145);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     e.c
 * JD-Core Version:    0.7.0.1
 */