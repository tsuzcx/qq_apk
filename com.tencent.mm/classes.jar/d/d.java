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
  static ArrayList<a> aanb;
  static ArrayList<b> aanc;
  static c aand;
  static f aane;
  static ArrayList<g> aanf;
  static h aang;
  public String SiQ = "";
  public String aanh = "";
  public ArrayList<a> aani = null;
  public String aanj = "";
  public String aank = "";
  public String aanl = "";
  public ArrayList<b> aanm = null;
  public String aann = "";
  public long aano = 0L;
  public String aanp = "";
  public c aanq = null;
  public long aanr = 0L;
  public String aans = "";
  public String aant = "";
  public String aanu = "";
  public String aanv = "";
  public f aanw = null;
  public ArrayList<g> aanx = null;
  public h aany = null;
  public String fcP = "";
  public String processName = "";
  public String sessionId = "";
  public String threadName = "";
  public String type = "";
  
  public final void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(208049);
    this.aanu = paramJceInputStream.readString(0, true);
    this.aant = paramJceInputStream.readString(1, false);
    this.fcP = paramJceInputStream.readString(2, false);
    this.aano = paramJceInputStream.read(this.aano, 3, true);
    ArrayList localArrayList;
    if (aanc == null)
    {
      localArrayList = new ArrayList();
      aanc = localArrayList;
      localArrayList.add(new b());
    }
    this.aanm = ((ArrayList)paramJceInputStream.read(aanc, 4, true));
    this.threadName = paramJceInputStream.readString(5, false);
    this.aann = paramJceInputStream.readString(6, false);
    this.aanp = paramJceInputStream.readString(7, false);
    if (aane == null) {
      aane = new f();
    }
    this.aanw = ((f)paramJceInputStream.read(aane, 8, false));
    if (aang == null) {
      aang = new h();
    }
    this.aany = ((h)paramJceInputStream.read(aang, 9, false));
    if (aand == null) {
      aand = new c();
    }
    this.aanq = ((c)paramJceInputStream.read(aand, 10, false));
    this.aans = paramJceInputStream.readString(11, false);
    if (aanb == null)
    {
      localArrayList = new ArrayList();
      aanb = localArrayList;
      localArrayList.add(new a());
    }
    this.aani = ((ArrayList)paramJceInputStream.read(aanb, 12, false));
    this.aanr = paramJceInputStream.read(this.aanr, 13, false);
    this.SiQ = paramJceInputStream.readString(14, false);
    this.aank = paramJceInputStream.readString(15, false);
    this.processName = paramJceInputStream.readString(16, false);
    this.aanj = paramJceInputStream.readString(17, false);
    this.type = paramJceInputStream.readString(18, false);
    this.aanl = paramJceInputStream.readString(19, false);
    this.aanh = paramJceInputStream.readString(20, false);
    if (aanf == null)
    {
      localArrayList = new ArrayList();
      aanf = localArrayList;
      localArrayList.add(new g());
    }
    this.aanx = ((ArrayList)paramJceInputStream.read(aanf, 21, false));
    this.aanv = paramJceInputStream.readString(22, false);
    this.sessionId = paramJceInputStream.readString(23, false);
    AppMethodBeat.o(208049);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(208047);
    paramJceOutputStream.write(this.aanu, 0);
    if (this.aant != null) {
      paramJceOutputStream.write(this.aant, 1);
    }
    if (this.fcP != null) {
      paramJceOutputStream.write(this.fcP, 2);
    }
    paramJceOutputStream.write(this.aano, 3);
    paramJceOutputStream.write(this.aanm, 4);
    if (this.threadName != null) {
      paramJceOutputStream.write(this.threadName, 5);
    }
    if (this.aann != null) {
      paramJceOutputStream.write(this.aann, 6);
    }
    if (this.aanp != null) {
      paramJceOutputStream.write(this.aanp, 7);
    }
    if (this.aanw != null) {
      paramJceOutputStream.write(this.aanw, 8);
    }
    if (this.aany != null) {
      paramJceOutputStream.write(this.aany, 9);
    }
    if (this.aanq != null) {
      paramJceOutputStream.write(this.aanq, 10);
    }
    if (this.aans != null) {
      paramJceOutputStream.write(this.aans, 11);
    }
    if (this.aani != null) {
      paramJceOutputStream.write(this.aani, 12);
    }
    paramJceOutputStream.write(this.aanr, 13);
    if (this.SiQ != null) {
      paramJceOutputStream.write(this.SiQ, 14);
    }
    if (this.aank != null) {
      paramJceOutputStream.write(this.aank, 15);
    }
    if (this.processName != null) {
      paramJceOutputStream.write(this.processName, 16);
    }
    if (this.aanj != null) {
      paramJceOutputStream.write(this.aanj, 17);
    }
    if (this.type != null) {
      paramJceOutputStream.write(this.type, 18);
    }
    if (this.aanl != null) {
      paramJceOutputStream.write(this.aanl, 19);
    }
    if (this.aanh != null) {
      paramJceOutputStream.write(this.aanh, 20);
    }
    if (this.aanx != null) {
      paramJceOutputStream.write(this.aanx, 21);
    }
    if (this.aanv != null) {
      paramJceOutputStream.write(this.aanv, 22);
    }
    if (this.sessionId != null) {
      paramJceOutputStream.write(this.sessionId, 23);
    }
    AppMethodBeat.o(208047);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     d.d
 * JD-Core Version:    0.7.0.1
 */