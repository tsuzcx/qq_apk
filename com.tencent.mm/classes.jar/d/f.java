package d;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class f
  extends JceStruct
{
  static Map<String, String> SLF;
  public String Gyj = "";
  public String SLG = "";
  public long SLH = 0L;
  public long SLI = 0L;
  public String SLJ = "";
  public String SLK = "";
  public Map<String, String> SLL = null;
  public String SLe = "";
  public String brand = "";
  public String dGL = "";
  public String guid = "";
  public String model = "";
  
  public final void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(214843);
    this.SLK = paramJceInputStream.readString(0, true);
    this.SLe = paramJceInputStream.readString(1, false);
    this.guid = paramJceInputStream.readString(2, false);
    this.dGL = paramJceInputStream.readString(3, false);
    this.brand = paramJceInputStream.readString(4, false);
    this.model = paramJceInputStream.readString(5, false);
    this.SLJ = paramJceInputStream.readString(6, false);
    this.SLH = paramJceInputStream.read(this.SLH, 7, false);
    this.SLI = paramJceInputStream.read(this.SLI, 8, false);
    this.SLG = paramJceInputStream.readString(9, false);
    this.Gyj = paramJceInputStream.readString(10, false);
    if (SLF == null)
    {
      HashMap localHashMap = new HashMap();
      SLF = localHashMap;
      localHashMap.put("", "");
    }
    this.SLL = ((Map)paramJceInputStream.read(SLF, 11, false));
    AppMethodBeat.o(214843);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(214842);
    paramJceOutputStream.write(this.SLK, 0);
    if (this.SLe != null) {
      paramJceOutputStream.write(this.SLe, 1);
    }
    if (this.guid != null) {
      paramJceOutputStream.write(this.guid, 2);
    }
    if (this.dGL != null) {
      paramJceOutputStream.write(this.dGL, 3);
    }
    if (this.brand != null) {
      paramJceOutputStream.write(this.brand, 4);
    }
    if (this.model != null) {
      paramJceOutputStream.write(this.model, 5);
    }
    if (this.SLJ != null) {
      paramJceOutputStream.write(this.SLJ, 6);
    }
    paramJceOutputStream.write(this.SLH, 7);
    paramJceOutputStream.write(this.SLI, 8);
    if (this.SLG != null) {
      paramJceOutputStream.write(this.SLG, 9);
    }
    if (this.Gyj != null) {
      paramJceOutputStream.write(this.Gyj, 10);
    }
    if (this.SLL != null) {
      paramJceOutputStream.write(this.SLL, 11);
    }
    AppMethodBeat.o(214842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     d.f
 * JD-Core Version:    0.7.0.1
 */