package d;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends JceStruct
{
  public String aamY = "";
  public String aamZ = "";
  public String aana = "";
  public String comment = "";
  public String hDf = "";
  public String qua = "";
  
  public final void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(207434);
    this.aamY = paramJceInputStream.readString(0, true);
    this.aana = paramJceInputStream.readString(1, true);
    this.qua = paramJceInputStream.readString(2, true);
    this.hDf = paramJceInputStream.readString(3, true);
    this.comment = paramJceInputStream.readString(4, true);
    this.aamZ = paramJceInputStream.readString(5, false);
    AppMethodBeat.o(207434);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(207433);
    paramJceOutputStream.write(this.aamY, 0);
    paramJceOutputStream.write(this.aana, 1);
    paramJceOutputStream.write(this.qua, 2);
    paramJceOutputStream.write(this.hDf, 3);
    paramJceOutputStream.write(this.comment, 4);
    if (this.aamZ != null) {
      paramJceOutputStream.write(this.aamZ, 5);
    }
    AppMethodBeat.o(207433);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     d.c
 * JD-Core Version:    0.7.0.1
 */