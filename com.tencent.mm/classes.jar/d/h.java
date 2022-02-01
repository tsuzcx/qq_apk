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
  static Map<String, String> SLF;
  public Map<String, String> SLL = null;
  public float SLP = 0.0F;
  public float SLQ = 0.0F;
  public long SLR = 0L;
  public long SLS = 0L;
  public long SLT = 0L;
  
  public final void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(214847);
    this.SLP = paramJceInputStream.read(this.SLP, 0, true);
    this.SLQ = paramJceInputStream.read(this.SLQ, 1, true);
    this.SLR = paramJceInputStream.read(this.SLR, 2, true);
    this.SLT = paramJceInputStream.read(this.SLT, 3, true);
    this.SLS = paramJceInputStream.read(this.SLS, 4, true);
    if (SLF == null)
    {
      HashMap localHashMap = new HashMap();
      SLF = localHashMap;
      localHashMap.put("", "");
    }
    this.SLL = ((Map)paramJceInputStream.read(SLF, 5, false));
    AppMethodBeat.o(214847);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(214846);
    paramJceOutputStream.write(this.SLP, 0);
    paramJceOutputStream.write(this.SLQ, 1);
    paramJceOutputStream.write(this.SLR, 2);
    paramJceOutputStream.write(this.SLT, 3);
    paramJceOutputStream.write(this.SLS, 4);
    if (this.SLL != null) {
      paramJceOutputStream.write(this.SLL, 5);
    }
    AppMethodBeat.o(214846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     d.h
 * JD-Core Version:    0.7.0.1
 */