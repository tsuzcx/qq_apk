package d;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class h
  extends JceStruct
{
  static Map<String, String> aanA;
  public Map<String, String> aanG = null;
  public float aanK = 0.0F;
  public float aanL = 0.0F;
  public long aanM = 0L;
  public long aanN = 0L;
  public long aanO = 0L;
  
  public final void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(207453);
    this.aanK = paramJceInputStream.read(this.aanK, 0, true);
    this.aanL = paramJceInputStream.read(this.aanL, 1, true);
    this.aanM = paramJceInputStream.read(this.aanM, 2, true);
    this.aanO = paramJceInputStream.read(this.aanO, 3, true);
    this.aanN = paramJceInputStream.read(this.aanN, 4, true);
    if (aanA == null)
    {
      HashMap localHashMap = new HashMap();
      aanA = localHashMap;
      localHashMap.put("", "");
    }
    this.aanG = ((Map)paramJceInputStream.read(aanA, 5, false));
    AppMethodBeat.o(207453);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(207452);
    paramJceOutputStream.write(this.aanK, 0);
    paramJceOutputStream.write(this.aanL, 1);
    paramJceOutputStream.write(this.aanM, 2);
    paramJceOutputStream.write(this.aanO, 3);
    paramJceOutputStream.write(this.aanN, 4);
    if (this.aanG != null) {
      paramJceOutputStream.write(this.aanG, 5);
    }
    AppMethodBeat.o(207452);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     d.h
 * JD-Core Version:    0.7.0.1
 */