package e;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class d
  extends JceStruct
  implements Cloneable
{
  static ArrayList<a> aits;
  static ArrayList<b> aitt;
  static c aitu;
  static f aitv;
  static ArrayList<g> aitw;
  static h aitx;
  public String ZgW = "";
  public String aitA = "";
  public String aitB = "";
  public String aitC = "";
  public ArrayList<b> aitD = null;
  public String aitE = "";
  public long aitF = 0L;
  public String aitG = "";
  public c aitH = null;
  public long aitI = 0L;
  public String aitJ = "";
  public String aitK = "";
  public String aitL = "";
  public String aitM = "";
  public f aitN = null;
  public ArrayList<g> aitO = null;
  public h aitP = null;
  public String aity = "";
  public ArrayList<a> aitz = null;
  public String cDz = "";
  public String processName = "";
  public String sessionId = "";
  public String threadName = "";
  public String type = "";
  
  public final void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(187201);
    this.aitL = paramJceInputStream.readString(0, true);
    this.aitK = paramJceInputStream.readString(1, false);
    this.cDz = paramJceInputStream.readString(2, false);
    this.aitF = paramJceInputStream.read(this.aitF, 3, true);
    ArrayList localArrayList;
    if (aitt == null)
    {
      localArrayList = new ArrayList();
      aitt = localArrayList;
      localArrayList.add(new b());
    }
    this.aitD = ((ArrayList)paramJceInputStream.read(aitt, 4, true));
    this.threadName = paramJceInputStream.readString(5, false);
    this.aitE = paramJceInputStream.readString(6, false);
    this.aitG = paramJceInputStream.readString(7, false);
    if (aitv == null) {
      aitv = new f();
    }
    this.aitN = ((f)paramJceInputStream.read(aitv, 8, false));
    if (aitx == null) {
      aitx = new h();
    }
    this.aitP = ((h)paramJceInputStream.read(aitx, 9, false));
    if (aitu == null) {
      aitu = new c();
    }
    this.aitH = ((c)paramJceInputStream.read(aitu, 10, false));
    this.aitJ = paramJceInputStream.readString(11, false);
    if (aits == null)
    {
      localArrayList = new ArrayList();
      aits = localArrayList;
      localArrayList.add(new a());
    }
    this.aitz = ((ArrayList)paramJceInputStream.read(aits, 12, false));
    this.aitI = paramJceInputStream.read(this.aitI, 13, false);
    this.ZgW = paramJceInputStream.readString(14, false);
    this.aitB = paramJceInputStream.readString(15, false);
    this.processName = paramJceInputStream.readString(16, false);
    this.aitA = paramJceInputStream.readString(17, false);
    this.type = paramJceInputStream.readString(18, false);
    this.aitC = paramJceInputStream.readString(19, false);
    this.aity = paramJceInputStream.readString(20, false);
    if (aitw == null)
    {
      localArrayList = new ArrayList();
      aitw = localArrayList;
      localArrayList.add(new g());
    }
    this.aitO = ((ArrayList)paramJceInputStream.read(aitw, 21, false));
    this.aitM = paramJceInputStream.readString(22, false);
    this.sessionId = paramJceInputStream.readString(23, false);
    AppMethodBeat.o(187201);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(187176);
    paramJceOutputStream.write(this.aitL, 0);
    if (this.aitK != null) {
      paramJceOutputStream.write(this.aitK, 1);
    }
    if (this.cDz != null) {
      paramJceOutputStream.write(this.cDz, 2);
    }
    paramJceOutputStream.write(this.aitF, 3);
    paramJceOutputStream.write(this.aitD, 4);
    if (this.threadName != null) {
      paramJceOutputStream.write(this.threadName, 5);
    }
    if (this.aitE != null) {
      paramJceOutputStream.write(this.aitE, 6);
    }
    if (this.aitG != null) {
      paramJceOutputStream.write(this.aitG, 7);
    }
    if (this.aitN != null) {
      paramJceOutputStream.write(this.aitN, 8);
    }
    if (this.aitP != null) {
      paramJceOutputStream.write(this.aitP, 9);
    }
    if (this.aitH != null) {
      paramJceOutputStream.write(this.aitH, 10);
    }
    if (this.aitJ != null) {
      paramJceOutputStream.write(this.aitJ, 11);
    }
    if (this.aitz != null) {
      paramJceOutputStream.write(this.aitz, 12);
    }
    paramJceOutputStream.write(this.aitI, 13);
    if (this.ZgW != null) {
      paramJceOutputStream.write(this.ZgW, 14);
    }
    if (this.aitB != null) {
      paramJceOutputStream.write(this.aitB, 15);
    }
    if (this.processName != null) {
      paramJceOutputStream.write(this.processName, 16);
    }
    if (this.aitA != null) {
      paramJceOutputStream.write(this.aitA, 17);
    }
    if (this.type != null) {
      paramJceOutputStream.write(this.type, 18);
    }
    if (this.aitC != null) {
      paramJceOutputStream.write(this.aitC, 19);
    }
    if (this.aity != null) {
      paramJceOutputStream.write(this.aity, 20);
    }
    if (this.aitO != null) {
      paramJceOutputStream.write(this.aitO, 21);
    }
    if (this.aitM != null) {
      paramJceOutputStream.write(this.aitM, 22);
    }
    if (this.sessionId != null) {
      paramJceOutputStream.write(this.sessionId, 23);
    }
    AppMethodBeat.o(187176);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     e.d
 * JD-Core Version:    0.7.0.1
 */