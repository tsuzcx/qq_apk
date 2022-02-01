package d;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class d
  extends JceStruct
  implements Cloneable
{
  static ArrayList<a> SLg;
  static ArrayList<b> SLh;
  static c SLi;
  static f SLj;
  static ArrayList<g> SLk;
  static h SLl;
  public String LhD = "";
  public String SLA = "";
  public f SLB = null;
  public ArrayList<g> SLC = null;
  public h SLD = null;
  public String SLm = "";
  public ArrayList<a> SLn = null;
  public String SLo = "";
  public String SLp = "";
  public String SLq = "";
  public ArrayList<b> SLr = null;
  public String SLs = "";
  public long SLt = 0L;
  public String SLu = "";
  public c SLv = null;
  public long SLw = 0L;
  public String SLx = "";
  public String SLy = "";
  public String SLz = "";
  public String dlj = "";
  public String processName = "";
  public String sessionId = "";
  public String threadName = "";
  public String type = "";
  
  public final void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(214839);
    this.SLz = paramJceInputStream.readString(0, true);
    this.SLy = paramJceInputStream.readString(1, false);
    this.dlj = paramJceInputStream.readString(2, false);
    this.SLt = paramJceInputStream.read(this.SLt, 3, true);
    ArrayList localArrayList;
    if (SLh == null)
    {
      localArrayList = new ArrayList();
      SLh = localArrayList;
      localArrayList.add(new b());
    }
    this.SLr = ((ArrayList)paramJceInputStream.read(SLh, 4, true));
    this.threadName = paramJceInputStream.readString(5, false);
    this.SLs = paramJceInputStream.readString(6, false);
    this.SLu = paramJceInputStream.readString(7, false);
    if (SLj == null) {
      SLj = new f();
    }
    this.SLB = ((f)paramJceInputStream.read(SLj, 8, false));
    if (SLl == null) {
      SLl = new h();
    }
    this.SLD = ((h)paramJceInputStream.read(SLl, 9, false));
    if (SLi == null) {
      SLi = new c();
    }
    this.SLv = ((c)paramJceInputStream.read(SLi, 10, false));
    this.SLx = paramJceInputStream.readString(11, false);
    if (SLg == null)
    {
      localArrayList = new ArrayList();
      SLg = localArrayList;
      localArrayList.add(new a());
    }
    this.SLn = ((ArrayList)paramJceInputStream.read(SLg, 12, false));
    this.SLw = paramJceInputStream.read(this.SLw, 13, false);
    this.LhD = paramJceInputStream.readString(14, false);
    this.SLp = paramJceInputStream.readString(15, false);
    this.processName = paramJceInputStream.readString(16, false);
    this.SLo = paramJceInputStream.readString(17, false);
    this.type = paramJceInputStream.readString(18, false);
    this.SLq = paramJceInputStream.readString(19, false);
    this.SLm = paramJceInputStream.readString(20, false);
    if (SLk == null)
    {
      localArrayList = new ArrayList();
      SLk = localArrayList;
      localArrayList.add(new g());
    }
    this.SLC = ((ArrayList)paramJceInputStream.read(SLk, 21, false));
    this.SLA = paramJceInputStream.readString(22, false);
    this.sessionId = paramJceInputStream.readString(23, false);
    AppMethodBeat.o(214839);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(214838);
    paramJceOutputStream.write(this.SLz, 0);
    if (this.SLy != null) {
      paramJceOutputStream.write(this.SLy, 1);
    }
    if (this.dlj != null) {
      paramJceOutputStream.write(this.dlj, 2);
    }
    paramJceOutputStream.write(this.SLt, 3);
    paramJceOutputStream.write(this.SLr, 4);
    if (this.threadName != null) {
      paramJceOutputStream.write(this.threadName, 5);
    }
    if (this.SLs != null) {
      paramJceOutputStream.write(this.SLs, 6);
    }
    if (this.SLu != null) {
      paramJceOutputStream.write(this.SLu, 7);
    }
    if (this.SLB != null) {
      paramJceOutputStream.write(this.SLB, 8);
    }
    if (this.SLD != null) {
      paramJceOutputStream.write(this.SLD, 9);
    }
    if (this.SLv != null) {
      paramJceOutputStream.write(this.SLv, 10);
    }
    if (this.SLx != null) {
      paramJceOutputStream.write(this.SLx, 11);
    }
    if (this.SLn != null) {
      paramJceOutputStream.write(this.SLn, 12);
    }
    paramJceOutputStream.write(this.SLw, 13);
    if (this.LhD != null) {
      paramJceOutputStream.write(this.LhD, 14);
    }
    if (this.SLp != null) {
      paramJceOutputStream.write(this.SLp, 15);
    }
    if (this.processName != null) {
      paramJceOutputStream.write(this.processName, 16);
    }
    if (this.SLo != null) {
      paramJceOutputStream.write(this.SLo, 17);
    }
    if (this.type != null) {
      paramJceOutputStream.write(this.type, 18);
    }
    if (this.SLq != null) {
      paramJceOutputStream.write(this.SLq, 19);
    }
    if (this.SLm != null) {
      paramJceOutputStream.write(this.SLm, 20);
    }
    if (this.SLC != null) {
      paramJceOutputStream.write(this.SLC, 21);
    }
    if (this.SLA != null) {
      paramJceOutputStream.write(this.SLA, 22);
    }
    if (this.sessionId != null) {
      paramJceOutputStream.write(this.sessionId, 23);
    }
    AppMethodBeat.o(214838);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     d.d
 * JD-Core Version:    0.7.0.1
 */