package e;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class h
  extends JceStruct
{
  static Map<String, String> aitR;
  public Map<String, String> aitX = null;
  public float aiua = 0.0F;
  public float aiub = 0.0F;
  public long aiuc = 0L;
  public long aiud = 0L;
  public long aiue = 0L;
  
  public final void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(187172);
    this.aiua = paramJceInputStream.read(this.aiua, 0, true);
    this.aiub = paramJceInputStream.read(this.aiub, 1, true);
    this.aiuc = paramJceInputStream.read(this.aiuc, 2, true);
    this.aiue = paramJceInputStream.read(this.aiue, 3, true);
    this.aiud = paramJceInputStream.read(this.aiud, 4, true);
    if (aitR == null)
    {
      HashMap localHashMap = new HashMap();
      aitR = localHashMap;
      localHashMap.put("", "");
    }
    this.aitX = ((Map)paramJceInputStream.read(aitR, 5, false));
    AppMethodBeat.o(187172);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(187162);
    paramJceOutputStream.write(this.aiua, 0);
    paramJceOutputStream.write(this.aiub, 1);
    paramJceOutputStream.write(this.aiuc, 2);
    paramJceOutputStream.write(this.aiue, 3);
    paramJceOutputStream.write(this.aiud, 4);
    if (this.aitX != null) {
      paramJceOutputStream.write(this.aitX, 5);
    }
    AppMethodBeat.o(187162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     e.h
 * JD-Core Version:    0.7.0.1
 */