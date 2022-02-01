package d;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends JceStruct
{
  static byte[] aamX;
  public byte[] data = null;
  public String fileName = "";
  public byte type = 0;
  
  public final void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(208063);
    this.type = paramJceInputStream.read(this.type, 0, true);
    this.fileName = paramJceInputStream.readString(1, false);
    if (aamX == null)
    {
      byte[] arrayOfByte = new byte[1];
      aamX = arrayOfByte;
      arrayOfByte[0] = 0;
    }
    this.data = paramJceInputStream.read(aamX, 2, true);
    AppMethodBeat.o(208063);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(208061);
    paramJceOutputStream.write(this.type, 0);
    if (this.fileName != null) {
      paramJceOutputStream.write(this.fileName, 1);
    }
    paramJceOutputStream.write(this.data, 2);
    AppMethodBeat.o(208061);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     d.b
 * JD-Core Version:    0.7.0.1
 */