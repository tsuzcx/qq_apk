package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.j;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class ab
  implements i
{
  private String BDX;
  private a HmD;
  private Map<String, String> HmE;
  private Map<String, String> HmF;
  private Map<String, String> HmG;
  private Map<String, String> HmH;
  private e HmI;
  private d HmJ;
  private HashMap<Long, Integer> HmK;
  private HashMap<Long, String> HmL;
  private HashMap<String, Integer> HmM;
  private int HmN;
  private ArrayList<f> HmO;
  private String HmP;
  private String HmQ;
  private HashMap<String, String> HmR;
  private b HmS;
  private c HmT;
  int HmU;
  private j HmV;
  
  public ab()
  {
    AppMethodBeat.i(122778);
    this.HmE = new HashMap();
    this.HmF = new LinkedHashMap();
    this.HmG = new LinkedHashMap();
    this.HmH = new HashMap();
    this.HmI = null;
    this.HmJ = null;
    this.HmK = new HashMap();
    this.HmL = new HashMap();
    this.HmM = new HashMap();
    this.HmN = 0;
    this.HmO = new ArrayList();
    this.HmP = null;
    this.HmQ = null;
    this.HmR = new HashMap();
    this.HmU = 0;
    this.HmV = new j()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, com.tencent.mm.an.q paramAnonymousq)
      {
        AppMethodBeat.i(122776);
        Log.i("MicroMsg.ShareModeMailAppService", "currentSendFile: %s, offset: %d, totalLen: %d, filesInfo.size: %d", new Object[] { ab.c(ab.this), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(ab.d(ab.this).size()) });
        if (paramAnonymousInt1 >= paramAnonymousInt2)
        {
          ab.f(ab.this).put(ab.e(ab.this), ((u)paramAnonymousq).fsr().HlF);
          ((u)paramAnonymousq).fsr();
          if (ab.g(ab.this) != null)
          {
            ab.g(ab.this);
            ab.d(ab.this).size();
            ab.e(ab.this);
          }
          if (ab.d(ab.this).isEmpty())
          {
            Log.i("MicroMsg.ShareModeMailAppService", "finished send all files");
            if (ab.h(ab.this) != null)
            {
              ab.h(ab.this);
              ab.f(ab.this);
            }
            AppMethodBeat.o(122776);
            return;
          }
          Log.i("MicroMsg.ShareModeMailAppService", "finished send one file, continue to send another one");
          paramAnonymousq = (ab.f)ab.d(ab.this).remove(0);
          ab.a(ab.this, paramAnonymousq.fileId);
          ab.b(ab.this, paramAnonymousq.fileName);
          paramAnonymousq = new u(ab.e(ab.this), ab.c(ab.this), this);
          h.aHF().kcd.a(paramAnonymousq, 0);
        }
        AppMethodBeat.o(122776);
      }
    };
    h.aHF().kcd.a(483, this);
    h.aHF().kcd.a(484, this);
    h.aHF().kcd.a(485, this);
    AppMethodBeat.o(122778);
  }
  
  private void a(q paramq)
  {
    AppMethodBeat.i(122790);
    this.HmN += 1;
    Log.i("MicroMsg.ShareModeMailAppService", "processCheckImgStatusSceneEnd, checkTimes: %d", new Object[] { Integer.valueOf(this.HmN) });
    paramq = paramq.fsq().iterator();
    while (paramq.hasNext())
    {
      f localf = (f)paramq.next();
      long l = localf.HlE;
      int i = localf.rVU;
      if (this.HmK.containsKey(Long.valueOf(l)))
      {
        Log.i("MicroMsg.ShareModeMailAppService", "msgSvrId: %d, status: %d", new Object[] { Long.valueOf(l), Integer.valueOf(i) });
        if (i == 0)
        {
          this.HmK.remove(Long.valueOf(l));
          if (localf.HlF != null)
          {
            Log.i("MicroMsg.ShareModeMailAppService", "msgSvrId: %d, attachId: %s", new Object[] { Long.valueOf(l), localf.HlF });
            this.HmL.put(Long.valueOf(l), localf.HlF);
            this.HmM.put(localf.HlF, Integer.valueOf(localf.HlG));
          }
        }
        else
        {
          this.HmK.put(Long.valueOf(l), Integer.valueOf(i));
        }
      }
    }
    if (this.HmK.isEmpty())
    {
      Log.i("MicroMsg.ShareModeMailAppService", "all image is in server");
      if (this.HmD != null) {
        new ArrayList();
      }
      AppMethodBeat.o(122790);
      return;
    }
    if (this.HmN < 3)
    {
      Log.i("MicroMsg.ShareModeMailAppService", "checkTime small than limit, doScene again");
      paramq = new q(o(this.HmK));
      h.aHF().kcd.a(paramq, 0);
      AppMethodBeat.o(122790);
      return;
    }
    o(this.HmK);
    AppMethodBeat.o(122790);
  }
  
  private static ArrayList<Long> o(HashMap<Long, Integer> paramHashMap)
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
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
      if (this.HmJ != null) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(122775);
            ab.b(ab.this);
            ab.a(ab.this);
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
  
  public static abstract interface e {}
  
  public static final class f
  {
    public String fileId;
    public String fileName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.ab
 * JD-Core Version:    0.7.0.1
 */