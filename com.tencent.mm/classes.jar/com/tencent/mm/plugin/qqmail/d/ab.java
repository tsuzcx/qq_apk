package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class ab
  implements com.tencent.mm.al.f
{
  ArrayList<e> xcA;
  String xcB;
  String xcC;
  HashMap<String, String> xcD;
  b xcE;
  int xcF;
  private com.tencent.mm.al.g xcG;
  private a xcp;
  private Map<String, String> xcq;
  private Map<String, String> xcr;
  private Map<String, String> xcs;
  private Map<String, String> xct;
  private d xcu;
  private c xcv;
  private HashMap<Long, Integer> xcw;
  private HashMap<Long, String> xcx;
  private HashMap<String, Integer> xcy;
  private int xcz;
  
  public ab()
  {
    AppMethodBeat.i(122778);
    this.xcq = new HashMap();
    this.xcr = new LinkedHashMap();
    this.xcs = new LinkedHashMap();
    this.xct = new HashMap();
    this.xcu = null;
    this.xcv = null;
    this.xcw = new HashMap();
    this.xcx = new HashMap();
    this.xcy = new HashMap();
    this.xcz = 0;
    this.xcA = new ArrayList();
    this.xcB = null;
    this.xcC = null;
    this.xcD = new HashMap();
    this.xcF = 0;
    this.xcG = new com.tencent.mm.al.g()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, n paramAnonymousn)
      {
        AppMethodBeat.i(122776);
        ad.i("MicroMsg.ShareModeMailAppService", "currentSendFile: %s, offset: %d, totalLen: %d, filesInfo.size: %d", new Object[] { ab.this.xcB, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(ab.this.xcA.size()) });
        if (paramAnonymousInt1 >= paramAnonymousInt2)
        {
          HashMap localHashMap = ab.this.xcD;
          String str = ab.this.xcC;
          paramAnonymousn = (u)paramAnonymousn;
          if (paramAnonymousn.rr != null) {}
          for (paramAnonymousn = (ai)paramAnonymousn.rr.hNL.hNQ;; paramAnonymousn = null)
          {
            localHashMap.put(str, paramAnonymousn.xbs);
            if (ab.this.xcE != null) {
              ab.this.xcA.size();
            }
            if (!ab.this.xcA.isEmpty()) {
              break;
            }
            ad.i("MicroMsg.ShareModeMailAppService", "finished send all files");
            AppMethodBeat.o(122776);
            return;
          }
          ad.i("MicroMsg.ShareModeMailAppService", "finished send one file, continue to send another one");
          paramAnonymousn = (ab.e)ab.this.xcA.remove(0);
          ab.this.xcB = paramAnonymousn.fileId;
          ab.this.xcC = paramAnonymousn.fileName;
          paramAnonymousn = new u(ab.this.xcC, ab.this.xcB, this);
          com.tencent.mm.kernel.g.ajB().gAO.a(paramAnonymousn, 0);
        }
        AppMethodBeat.o(122776);
      }
    };
    com.tencent.mm.kernel.g.ajB().gAO.a(483, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(484, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(485, this);
    AppMethodBeat.o(122778);
  }
  
  private void a(q paramq)
  {
    AppMethodBeat.i(122790);
    this.xcz += 1;
    ad.i("MicroMsg.ShareModeMailAppService", "processCheckImgStatusSceneEnd, checkTimes: %d", new Object[] { Integer.valueOf(this.xcz) });
    paramq = paramq.dCj().iterator();
    while (paramq.hasNext())
    {
      f localf = (f)paramq.next();
      long l = localf.xbr;
      int i = localf.nDG;
      if (this.xcw.containsKey(Long.valueOf(l)))
      {
        ad.i("MicroMsg.ShareModeMailAppService", "msgSvrId: %d, status: %d", new Object[] { Long.valueOf(l), Integer.valueOf(i) });
        if (i == 0)
        {
          this.xcw.remove(Long.valueOf(l));
          if (localf.xbs != null)
          {
            ad.i("MicroMsg.ShareModeMailAppService", "msgSvrId: %d, attachId: %s", new Object[] { Long.valueOf(l), localf.xbs });
            this.xcx.put(Long.valueOf(l), localf.xbs);
            this.xcy.put(localf.xbs, Integer.valueOf(localf.FileSize));
          }
        }
        else
        {
          this.xcw.put(Long.valueOf(l), Integer.valueOf(i));
        }
      }
    }
    if (this.xcw.isEmpty())
    {
      ad.i("MicroMsg.ShareModeMailAppService", "all image is in server");
      if (this.xcp != null) {
        new ArrayList();
      }
      AppMethodBeat.o(122790);
      return;
    }
    if (this.xcz < 3)
    {
      ad.i("MicroMsg.ShareModeMailAppService", "checkTime small than limit, doScene again");
      paramq = new q(j(this.xcw));
      com.tencent.mm.kernel.g.ajB().gAO.a(paramq, 0);
      AppMethodBeat.o(122790);
      return;
    }
    j(this.xcw);
    AppMethodBeat.o(122790);
  }
  
  private static ArrayList<Long> j(HashMap<Long, Integer> paramHashMap)
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
    ad.i("MicroMsg.ShareModeMailAppService", "onSceneEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ad.e("MicroMsg.ShareModeMailAppService", "errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramn.getType() == 483)
      {
        a((q)paramn);
        AppMethodBeat.o(122786);
        return;
      }
      if (this.xcv != null) {
        aq.f(new Runnable()
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