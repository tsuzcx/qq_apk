package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class ab
  implements com.tencent.mm.ak.f
{
  private a xsg;
  private Map<String, String> xsh;
  private Map<String, String> xsi;
  private Map<String, String> xsj;
  private Map<String, String> xsk;
  private d xsl;
  private c xsm;
  private HashMap<Long, Integer> xsn;
  private HashMap<Long, String> xso;
  private HashMap<String, Integer> xsp;
  private int xsq;
  ArrayList<e> xsr;
  String xss;
  String xst;
  HashMap<String, String> xsu;
  b xsv;
  int xsw;
  private com.tencent.mm.ak.g xsx;
  
  public ab()
  {
    AppMethodBeat.i(122778);
    this.xsh = new HashMap();
    this.xsi = new LinkedHashMap();
    this.xsj = new LinkedHashMap();
    this.xsk = new HashMap();
    this.xsl = null;
    this.xsm = null;
    this.xsn = new HashMap();
    this.xso = new HashMap();
    this.xsp = new HashMap();
    this.xsq = 0;
    this.xsr = new ArrayList();
    this.xss = null;
    this.xst = null;
    this.xsu = new HashMap();
    this.xsw = 0;
    this.xsx = new com.tencent.mm.ak.g()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, n paramAnonymousn)
      {
        AppMethodBeat.i(122776);
        ae.i("MicroMsg.ShareModeMailAppService", "currentSendFile: %s, offset: %d, totalLen: %d, filesInfo.size: %d", new Object[] { ab.this.xss, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(ab.this.xsr.size()) });
        if (paramAnonymousInt1 >= paramAnonymousInt2)
        {
          HashMap localHashMap = ab.this.xsu;
          String str = ab.this.xst;
          paramAnonymousn = (u)paramAnonymousn;
          if (paramAnonymousn.rr != null) {}
          for (paramAnonymousn = (ai)paramAnonymousn.rr.hQE.hQJ;; paramAnonymousn = null)
          {
            localHashMap.put(str, paramAnonymousn.xrj);
            if (ab.this.xsv != null) {
              ab.this.xsr.size();
            }
            if (!ab.this.xsr.isEmpty()) {
              break;
            }
            ae.i("MicroMsg.ShareModeMailAppService", "finished send all files");
            AppMethodBeat.o(122776);
            return;
          }
          ae.i("MicroMsg.ShareModeMailAppService", "finished send one file, continue to send another one");
          paramAnonymousn = (ab.e)ab.this.xsr.remove(0);
          ab.this.xss = paramAnonymousn.fileId;
          ab.this.xst = paramAnonymousn.fileName;
          paramAnonymousn = new u(ab.this.xst, ab.this.xss, this);
          com.tencent.mm.kernel.g.ajQ().gDv.a(paramAnonymousn, 0);
        }
        AppMethodBeat.o(122776);
      }
    };
    com.tencent.mm.kernel.g.ajQ().gDv.a(483, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(484, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(485, this);
    AppMethodBeat.o(122778);
  }
  
  private void a(q paramq)
  {
    AppMethodBeat.i(122790);
    this.xsq += 1;
    ae.i("MicroMsg.ShareModeMailAppService", "processCheckImgStatusSceneEnd, checkTimes: %d", new Object[] { Integer.valueOf(this.xsq) });
    paramq = paramq.dFA().iterator();
    while (paramq.hasNext())
    {
      f localf = (f)paramq.next();
      long l = localf.xri;
      int i = localf.nJb;
      if (this.xsn.containsKey(Long.valueOf(l)))
      {
        ae.i("MicroMsg.ShareModeMailAppService", "msgSvrId: %d, status: %d", new Object[] { Long.valueOf(l), Integer.valueOf(i) });
        if (i == 0)
        {
          this.xsn.remove(Long.valueOf(l));
          if (localf.xrj != null)
          {
            ae.i("MicroMsg.ShareModeMailAppService", "msgSvrId: %d, attachId: %s", new Object[] { Long.valueOf(l), localf.xrj });
            this.xso.put(Long.valueOf(l), localf.xrj);
            this.xsp.put(localf.xrj, Integer.valueOf(localf.FileSize));
          }
        }
        else
        {
          this.xsn.put(Long.valueOf(l), Integer.valueOf(i));
        }
      }
    }
    if (this.xsn.isEmpty())
    {
      ae.i("MicroMsg.ShareModeMailAppService", "all image is in server");
      if (this.xsg != null) {
        new ArrayList();
      }
      AppMethodBeat.o(122790);
      return;
    }
    if (this.xsq < 3)
    {
      ae.i("MicroMsg.ShareModeMailAppService", "checkTime small than limit, doScene again");
      paramq = new q(k(this.xsn));
      com.tencent.mm.kernel.g.ajQ().gDv.a(paramq, 0);
      AppMethodBeat.o(122790);
      return;
    }
    k(this.xsn);
    AppMethodBeat.o(122790);
  }
  
  private static ArrayList<Long> k(HashMap<Long, Integer> paramHashMap)
  {
    AppMethodBeat.i(122789);
    ArrayList localArrayList = new ArrayList();
    paramHashMap = paramHashMap.keySet().iterator();
    while (paramHashMap.hasNext()) {
      localArrayList.add((Long)paramHashMap.next());
    }
    AppMethodBeat.o(122789);
    return localArrayList;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(122786);
    ae.i("MicroMsg.ShareModeMailAppService", "onSceneEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ae.e("MicroMsg.ShareModeMailAppService", "errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramn.getType() == 483)
      {
        a((q)paramn);
        AppMethodBeat.o(122786);
        return;
      }
      if (this.xsm != null) {
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(122775);
            AppMethodBeat.o(122775);
          }
        });
      }
      AppMethodBeat.o(122786);
      return;
    }
    if (paramn.getType() == 483)
    {
      a((q)paramn);
      AppMethodBeat.o(122786);
      return;
    }
    if (paramn.getType() != 484) {
      paramn.getType();
    }
    AppMethodBeat.o(122786);
  }
  
  public static abstract interface a {}
  
  public static abstract interface b {}
  
  public static abstract interface c {}
  
  public static abstract interface d {}
  
  public static final class e
  {
    public String fileId;
    public String fileName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.ab
 * JD-Core Version:    0.7.0.1
 */