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
  static Map<String, String> aanA;
  public String HJL = "";
  public String aamZ = "";
  public String aanB = "";
  public long aanC = 0L;
  public long aanD = 0L;
  public String aanE = "";
  public String aanF = "";
  public Map<String, String> aanG = null;
  public String brand = "";
  public String fzB = "";
  public String guid = "";
  public String model = "";
  
  public final void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(208664);
    this.aanF = paramJceInputStream.readString(0, true);
    this.aamZ = paramJceInputStream.readString(1, false);
    this.guid = paramJceInputStream.readString(2, false);
    this.fzB = paramJceInputStream.readString(3, false);
    this.brand = paramJceInputStream.readString(4, false);
    this.model = paramJceInputStream.readString(5, false);
    this.aanE = paramJceInputStream.readString(6, false);
    this.aanC = paramJceInputStream.read(this.aanC, 7, false);
    this.aanD = paramJceInputStream.read(this.aanD, 8, false);
    this.aanB = paramJceInputStream.readString(9, false);
    this.HJL = paramJceInputStream.readString(10, false);
    if (aanA == null)
    {
      HashMap localHashMap = new HashMap();
      aanA = localHashMap;
      localHashMap.put("", "");
    }
    this.aanG = ((Map)paramJceInputStream.read(aanA, 11, false));
    AppMethodBeat.o(208664);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(208662);
    paramJceOutputStream.write(this.aanF, 0);
    if (this.aamZ != null) {
      paramJceOutputStream.write(this.aamZ, 1);
    }
    if (this.guid != null) {
      paramJceOutputStream.write(this.guid, 2);
    }
    if (this.fzB != null) {
      paramJceOutputStream.write(this.fzB, 3);
    }
    if (this.brand != null) {
      paramJceOutputStream.write(this.brand, 4);
    }
    if (this.model != null) {
      paramJceOutputStream.write(this.model, 5);
    }
    if (this.aanE != null) {
      paramJceOutputStream.write(this.aanE, 6);
    }
    paramJceOutputStream.write(this.aanC, 7);
    paramJceOutputStream.write(this.aanD, 8);
    if (this.aanB != null) {
      paramJceOutputStream.write(this.aanB, 9);
    }
    if (this.HJL != null) {
      paramJceOutputStream.write(this.HJL, 10);
    }
    if (this.aanG != null) {
      paramJceOutputStream.write(this.aanG, 11);
    }
    AppMethodBeat.o(208662);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     d.f
 * JD-Core Version:    0.7.0.1
 */