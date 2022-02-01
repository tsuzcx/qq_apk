package e;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends JceStruct
{
  public String aitY = "";
  public String aitZ = "";
  public String pluginId = "";
  
  public final void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(187161);
    this.pluginId = paramJceInputStream.readString(0, true);
    this.aitZ = paramJceInputStream.readString(1, true);
    this.aitY = paramJceInputStream.readString(2, false);
    AppMethodBeat.o(187161);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(187152);
    paramJceOutputStream.write(this.pluginId, 0);
    paramJceOutputStream.write(this.aitZ, 1);
    if (this.aitY != null) {
      paramJceOutputStream.write(this.aitY, 2);
    }
    AppMethodBeat.o(187152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     e.g
 * JD-Core Version:    0.7.0.1
 */