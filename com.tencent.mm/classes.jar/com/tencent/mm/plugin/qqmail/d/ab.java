package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class ab
  implements i
{
  int BsA;
  private j BsB;
  private a Bsk;
  private Map<String, String> Bsl;
  private Map<String, String> Bsm;
  private Map<String, String> Bsn;
  private Map<String, String> Bso;
  private d Bsp;
  private c Bsq;
  private HashMap<Long, Integer> Bsr;
  private HashMap<Long, String> Bss;
  private HashMap<String, Integer> Bst;
  private int Bsu;
  ArrayList<e> Bsv;
  String Bsw;
  String Bsx;
  HashMap<String, String> Bsy;
  b Bsz;
  
  public ab()
  {
    AppMethodBeat.i(122778);
    this.Bsl = new HashMap();
    this.Bsm = new LinkedHashMap();
    this.Bsn = new LinkedHashMap();
    this.Bso = new HashMap();
    this.Bsp = null;
    this.Bsq = null;
    this.Bsr = new HashMap();
    this.Bss = new HashMap();
    this.Bst = new HashMap();
    this.Bsu = 0;
    this.Bsv = new ArrayList();
    this.Bsw = null;
    this.Bsx = null;
    this.Bsy = new HashMap();
    this.BsA = 0;
    this.BsB = new j()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, com.tencent.mm.ak.q paramAnonymousq)
      {
        AppMethodBeat.i(122776);
        Log.i("MicroMsg.ShareModeMailAppService", "currentSendFile: %s, offset: %d, totalLen: %d, filesInfo.size: %d", new Object[] { ab.this.Bsw, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(ab.this.Bsv.size()) });
        if (paramAnonymousInt1 >= paramAnonymousInt2)
        {
          HashMap localHashMap = ab.this.Bsy;
          String str = ab.this.Bsx;
          paramAnonymousq = (u)paramAnonymousq;
          if (paramAnonymousq.rr != null) {}
          for (paramAnonymousq = (ai)paramAnonymousq.rr.iLL.iLR;; paramAnonymousq = null)
          {
            localHashMap.put(str, paramAnonymousq.Brm);
            if (ab.this.Bsz != null) {
              ab.this.Bsv.size();
            }
            if (!ab.this.Bsv.isEmpty()) {
              break;
            }
            Log.i("MicroMsg.ShareModeMailAppService", "finished send all files");
            AppMethodBeat.o(122776);
            return;
          }
          Log.i("MicroMsg.ShareModeMailAppService", "finished send one file, continue to send another one");
          paramAnonymousq = (ab.e)ab.this.Bsv.remove(0);
          ab.this.Bsw = paramAnonymousq.fileId;
          ab.this.Bsx = paramAnonymousq.fileName;
          paramAnonymousq = new u(ab.this.Bsx, ab.this.Bsw, this);
          g.aAg().hqi.a(paramAnonymousq, 0);
        }
        AppMethodBeat.o(122776);
      }
    };
    g.aAg().hqi.a(483, this);
    g.aAg().hqi.a(484, this);
    g.aAg().hqi.a(485, this);
    AppMethodBeat.o(122778);
  }
  
  private void a(q paramq)
  {
    AppMethodBeat.i(122790);
    this.Bsu += 1;
    Log.i("MicroMsg.ShareModeMailAppService", "processCheckImgStatusSceneEnd, checkTimes: %d", new Object[] { Integer.valueOf(this.Bsu) });
    paramq = paramq.eGp().iterator();
    while (paramq.hasNext())
    {
      f localf = (f)paramq.next();
      long l = localf.Brl;
      int i = localf.oTW;
      if (this.Bsr.containsKey(Long.valueOf(l)))
      {
        Log.i("MicroMsg.ShareModeMailAppService", "msgSvrId: %d, status: %d", new Object[] { Long.valueOf(l), Integer.valueOf(i) });
        if (i == 0)
        {
          this.Bsr.remove(Long.valueOf(l));
          if (localf.Brm != null)
          {
            Log.i("MicroMsg.ShareModeMailAppService", "msgSvrId: %d, attachId: %s", new Object[] { Long.valueOf(l), localf.Brm });
            this.Bss.put(Long.valueOf(l), localf.Brm);
            this.Bst.put(localf.Brm, Integer.valueOf(localf.FileSize));
          }
        }
        else
        {
          this.Bsr.put(Long.valueOf(l), Integer.valueOf(i));
        }
      }
    }
    if (this.Bsr.isEmpty())
    {
      Log.i("MicroMsg.ShareModeMailAppService", "all image is in server");
      if (this.Bsk != null) {
        new ArrayList();
      }
      AppMethodBeat.o(122790);
      return;
    }
    if (this.Bsu < 3)
    {
      Log.i("MicroMsg.ShareModeMailAppService", "checkTime small than limit, doScene again");
      paramq = new q(l(this.Bsr));
      g.aAg().hqi.a(paramq, 0);
      AppMethodBeat.o(122790);
      return;
    }
    l(this.Bsr);
    AppMethodBeat.o(122790);
  }
  
  private static ArrayList<Long> l(HashMap<Long, Integer> paramHashMap)
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
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(122786);
    Log.i("MicroMsg.ShareModeMailAppService", "onSceneEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.ShareModeMailAppService", "errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramq.getType() == 483)
      {
        a((q)paramq);
        AppMethodBeat.o(122786);
        return;
      }
      if (this.Bsq != null) {
        MMHandlerThread.postToMainThread(new Runnable()
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
    if (paramq.getType() == 483)
    {
      a((q)paramq);
      AppMethodBeat.o(122786);
      return;
    }
    if (paramq.getType() != 484) {
      paramq.getType();
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