package e;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class f
  extends JceStruct
{
  static Map<String, String> aitR;
  public String NGL = "";
  public String aitS = "";
  public long aitT = 0L;
  public long aitU = 0L;
  public String aitV = "";
  public String aitW = "";
  public Map<String, String> aitX = null;
  public String aitq = "";
  public String brand = "";
  public String guid = "";
  public String hEl = "";
  public String model = "";
  
  public final void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(187173);
    this.aitW = paramJceInputStream.readString(0, true);
    this.aitq = paramJceInputStream.readString(1, false);
    this.guid = paramJceInputStream.readString(2, false);
    this.hEl = paramJceInputStream.readString(3, false);
    this.brand = paramJceInputStream.readString(4, false);
    this.model = paramJceInputStream.readString(5, false);
    this.aitV = paramJceInputStream.readString(6, false);
    this.aitT = paramJceInputStream.read(this.aitT, 7, false);
    this.aitU = paramJceInputStream.read(this.aitU, 8, false);
    this.aitS = paramJceInputStream.readString(9, false);
    this.NGL = paramJceInputStream.readString(10, false);
    if (aitR == null)
    {
      HashMap localHashMap = new HashMap();
      aitR = localHashMap;
      localHashMap.put("", "");
    }
    this.aitX = ((Map)paramJceInputStream.read(aitR, 11, false));
    AppMethodBeat.o(187173);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(187159);
    paramJceOutputStream.write(this.aitW, 0);
    if (this.aitq != null) {
      paramJceOutputStream.write(this.aitq, 1);
    }
    if (this.guid != null) {
      paramJceOutputStream.write(this.guid, 2);
    }
    if (this.hEl != null) {
      paramJceOutputStream.write(this.hEl, 3);
    }
    if (this.brand != null) {
      paramJceOutputStream.write(this.brand, 4);
    }
    if (this.model != null) {
      paramJceOutputStream.write(this.model, 5);
    }
    if (this.aitV != null) {
      paramJceOutputStream.write(this.aitV, 6);
    }
    paramJceOutputStream.write(this.aitT, 7);
    paramJceOutputStream.write(this.aitU, 8);
    if (this.aitS != null) {
      paramJceOutputStream.write(this.aitS, 9);
    }
    if (this.NGL != null) {
      paramJceOutputStream.write(this.NGL, 10);
    }
    if (this.aitX != null) {
      paramJceOutputStream.write(this.aitX, 11);
    }
    AppMethodBeat.o(187159);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     e.f
 * JD-Core Version:    0.7.0.1
 */