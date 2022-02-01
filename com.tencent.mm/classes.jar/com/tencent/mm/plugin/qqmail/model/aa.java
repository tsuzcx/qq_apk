package com.tencent.mm.plugin.qqmail.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.i;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class aa
  implements com.tencent.mm.am.h
{
  private String Hox;
  private HashMap<String, Integer> NkA;
  private int NkB;
  private ArrayList<f> NkC;
  private String NkD;
  private String NkE;
  private HashMap<String, String> NkF;
  private b NkG;
  private c NkH;
  int NkI;
  private i NkJ;
  private a Nkr;
  private Map<String, String> Nks;
  private Map<String, String> Nkt;
  private Map<String, String> Nku;
  private Map<String, String> Nkv;
  private e Nkw;
  private d Nkx;
  private HashMap<Long, Integer> Nky;
  private HashMap<Long, String> Nkz;
  
  public aa()
  {
    AppMethodBeat.i(122778);
    this.Nks = new HashMap();
    this.Nkt = new LinkedHashMap();
    this.Nku = new LinkedHashMap();
    this.Nkv = new HashMap();
    this.Nkw = null;
    this.Nkx = null;
    this.Nky = new HashMap();
    this.Nkz = new HashMap();
    this.NkA = new HashMap();
    this.NkB = 0;
    this.NkC = new ArrayList();
    this.NkD = null;
    this.NkE = null;
    this.NkF = new HashMap();
    this.NkI = 0;
    this.NkJ = new i()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, com.tencent.mm.am.p paramAnonymousp)
      {
        AppMethodBeat.i(122776);
        Log.i("MicroMsg.ShareModeMailAppService", "currentSendFile: %s, offset: %d, totalLen: %d, filesInfo.size: %d", new Object[] { aa.c(aa.this), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(aa.d(aa.this).size()) });
        if (paramAnonymousInt1 >= paramAnonymousInt2)
        {
          aa.f(aa.this).put(aa.e(aa.this), ((t)paramAnonymousp).gDZ().Njt);
          ((t)paramAnonymousp).gDZ();
          if (aa.g(aa.this) != null)
          {
            aa.g(aa.this);
            aa.d(aa.this).size();
            aa.e(aa.this);
          }
          if (aa.d(aa.this).isEmpty())
          {
            Log.i("MicroMsg.ShareModeMailAppService", "finished send all files");
            if (aa.h(aa.this) != null)
            {
              aa.h(aa.this);
              aa.f(aa.this);
            }
            AppMethodBeat.o(122776);
            return;
          }
          Log.i("MicroMsg.ShareModeMailAppService", "finished send one file, continue to send another one");
          paramAnonymousp = (aa.f)aa.d(aa.this).remove(0);
          aa.a(aa.this, paramAnonymousp.fileId);
          aa.b(aa.this, paramAnonymousp.fileName);
          paramAnonymousp = new t(aa.e(aa.this), aa.c(aa.this), this);
          com.tencent.mm.kernel.h.baD().mCm.a(paramAnonymousp, 0);
        }
        AppMethodBeat.o(122776);
      }
    };
    com.tencent.mm.kernel.h.baD().mCm.a(483, this);
    com.tencent.mm.kernel.h.baD().mCm.a(484, this);
    com.tencent.mm.kernel.h.baD().mCm.a(485, this);
    AppMethodBeat.o(122778);
  }
  
  private void a(p paramp)
  {
    AppMethodBeat.i(122790);
    this.NkB += 1;
    Log.i("MicroMsg.ShareModeMailAppService", "processCheckImgStatusSceneEnd, checkTimes: %d", new Object[] { Integer.valueOf(this.NkB) });
    paramp = paramp.gDY().iterator();
    while (paramp.hasNext())
    {
      e locale = (e)paramp.next();
      long l = locale.Njs;
      int i = locale.vhk;
      if (this.Nky.containsKey(Long.valueOf(l)))
      {
        Log.i("MicroMsg.ShareModeMailAppService", "msgSvrId: %d, status: %d", new Object[] { Long.valueOf(l), Integer.valueOf(i) });
        if (i == 0)
        {
          this.Nky.remove(Long.valueOf(l));
          if (locale.Njt != null)
          {
            Log.i("MicroMsg.ShareModeMailAppService", "msgSvrId: %d, attachId: %s", new Object[] { Long.valueOf(l), locale.Njt });
            this.Nkz.put(Long.valueOf(l), locale.Njt);
            this.NkA.put(locale.Njt, Integer.valueOf(locale.Nju));
          }
        }
        else
        {
          this.Nky.put(Long.valueOf(l), Integer.valueOf(i));
        }
      }
    }
    if (this.Nky.isEmpty())
    {
      Log.i("MicroMsg.ShareModeMailAppService", "all image is in server");
      if (this.Nkr != null) {
        new ArrayList();
      }
      AppMethodBeat.o(122790);
      return;
    }
    if (this.NkB < 3)
    {
      Log.i("MicroMsg.ShareModeMailAppService", "checkTime small than limit, doScene again");
      paramp = new p(r(this.Nky));
      com.tencent.mm.kernel.h.baD().mCm.a(paramp, 0);
      AppMethodBeat.o(122790);
      return;
    }
    r(this.Nky);
    AppMethodBeat.o(122790);
  }
  
  private static ArrayList<Long> r(HashMap<Long, Integer> paramHashMap)
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(122786);
    Log.i("MicroMsg.ShareModeMailAppService", "onSceneEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.ShareModeMailAppService", "errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramp.getType() == 483)
      {
        a((p)paramp);
        AppMethodBeat.o(122786);
        return;
      }
      if (this.Nkx != null) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(122775);
            aa.b(aa.this);
            aa.a(aa.this);
            AppMethodBeat.o(122775);
          }
        });
      }
      AppMethodBeat.o(122786);
      return;
    }
    if (paramp.getType() == 483)
    {
      a((p)paramp);
      AppMethodBeat.o(122786);
      return;
    }
    if (paramp.getType() != 484) {
      paramp.getType();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.model.aa
 * JD-Core Version:    0.7.0.1
 */