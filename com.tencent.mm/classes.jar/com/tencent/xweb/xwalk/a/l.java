package com.tencent.xweb.xwalk.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.ak;
import com.tencent.xweb.internal.a.b;
import com.tencent.xweb.xwalk.b.a.c;
import com.tencent.xweb.xwalk.b.a.d;
import com.tencent.xweb.xwalk.b.a.e;
import com.tencent.xweb.xwalk.b.c;
import com.tencent.xweb.xwalk.b.d;
import com.tencent.xweb.xwalk.p;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.xwalk.core.Log;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkLibraryLoader.DownloadInfo;
import org.xwalk.core.XWalkLibraryLoader.DownloadListener;
import org.xwalk.core.XWalkLibraryLoader.HttpDownloadTask;
import org.xwalk.core.XWalkLibraryLoader.WXFileDownloaderTask;

public final class l
  extends AsyncTask<String, Integer, Integer>
{
  String aajP;
  j aajQ;
  private final Object aajS;
  a aajT;
  private Map<String, b> aajU;
  private int aajV;
  private int aajW;
  private int aajX;
  private int aajY;
  private int aajZ;
  boolean aaka;
  
  public l()
  {
    AppMethodBeat.i(154522);
    this.aajS = new Object();
    this.aajT = new a();
    this.aajU = new HashMap();
    this.aajV = 0;
    this.aajW = 0;
    this.aajX = 0;
    this.aajY = 0;
    this.aajZ = 0;
    this.aaka = false;
    this.aajP = "";
    this.aajQ = null;
    AppMethodBeat.o(154522);
  }
  
  private void bj(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(154526);
    if (paramInt2 <= paramInt1)
    {
      Log.i("XWalkPluginUp", "status not changed, return");
      AppMethodBeat.o(154526);
      return;
    }
    Log.i("XWalkPluginUp", "change status from " + paramInt1 + " to " + paramInt2 + " errcode: " + paramInt3);
    if (izp())
    {
      if ((paramInt1 != 0) || (paramInt2 != 1)) {
        break label192;
      }
      this.aajQ.iwb();
    }
    for (;;)
    {
      if (paramInt2 == 5)
      {
        com.tencent.xweb.util.h.dA(15718, this.aajT.errCode + "," + this.aajV + "," + this.aajW + "," + this.aajX + "," + this.aajY + "," + this.aajZ);
        k.izo();
        this.aaka = true;
      }
      AppMethodBeat.o(154526);
      return;
      label192:
      if ((paramInt1 != 0) && (paramInt2 == 5)) {
        this.aajQ.aCI(paramInt3);
      }
    }
  }
  
  public final void a(HashMap<String, String> paramHashMap, String paramString, j paramj)
  {
    AppMethodBeat.i(205777);
    if (paramHashMap != null)
    {
      paramHashMap = (String)paramHashMap.get("UpdaterCheckType");
      if ((paramHashMap != null) && (paramHashMap.equals("1"))) {
        k.Xo(0L);
      }
    }
    this.aajP = paramString;
    this.aajQ = paramj;
    AppMethodBeat.o(205777);
  }
  
  final boolean b(int paramInt1, int paramInt2, Map<String, b> paramMap)
  {
    AppMethodBeat.i(154525);
    for (;;)
    {
      Object localObject2;
      synchronized (this.aajS)
      {
        int i = this.aajT.aakc;
        if (paramInt1 > i)
        {
          this.aajT.aakc = paramInt1;
          if (paramInt2 != 1) {
            this.aajT.errCode = paramInt2;
          }
          if (this.aajT.aakc != 4) {
            break label201;
          }
          if (this.aajU.size() == 0)
          {
            this.aajT.aakc = 5;
            continue;
          }
        }
        else
        {
          paramInt1 = this.aajT.aakc;
          paramInt2 = this.aajT.errCode;
          bj(i, paramInt1, paramInt2);
          if (paramInt1 <= i) {
            break;
          }
          AppMethodBeat.o(154525);
          return true;
        }
        paramMap = this.aajU.entrySet().iterator();
        if (!paramMap.hasNext()) {
          continue;
        }
        localObject2 = (b)((Map.Entry)paramMap.next()).getValue();
        if ((localObject2 == null) || (((b)localObject2).HYw)) {
          continue;
        }
        ((b)localObject2).mfr.cancel(true);
      }
      label201:
      if ((this.aajT.aakc == 3) && (paramMap != null))
      {
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Object localObject3 = (Map.Entry)paramMap.next();
          localObject2 = (String)((Map.Entry)localObject3).getKey();
          localObject3 = (b)((Map.Entry)localObject3).getValue();
          this.aajU.put(localObject2, localObject3);
          if (((b)localObject3).type == 1) {
            ((XWalkLibraryLoader.HttpDownloadTask)((b)localObject3).mfr).execute(new Void[0]);
          } else if (((b)localObject3).type == 2) {
            ((XWalkLibraryLoader.WXFileDownloaderTask)((b)localObject3).mfr).execute(new Void[0]);
          } else {
            this.aajU.remove(localObject2);
          }
        }
        this.aajV = this.aajU.size();
      }
    }
    AppMethodBeat.o(154525);
    return false;
  }
  
  public final void iA(String paramString, int paramInt)
  {
    AppMethodBeat.i(154524);
    XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "onNotifyResult: " + paramString + " install retCode: " + paramInt);
    for (;;)
    {
      synchronized (this.aajS)
      {
        if (this.aajT.aakc == 5)
        {
          AppMethodBeat.o(154524);
          return;
        }
        switch (paramInt)
        {
        default: 
          ((b)this.aajU.get(paramString)).HYw = true;
          paramString = this.aajU.entrySet().iterator();
          if (!paramString.hasNext()) {
            break;
          }
          b localb = (b)((Map.Entry)paramString.next()).getValue();
          if ((localb == null) || (localb.HYw)) {
            continue;
          }
          paramInt = 0;
          int i = this.aajT.aakc;
          if (paramInt != 0)
          {
            this.aajU.clear();
            this.aajT.aakc = 5;
            if ((this.aajX > 0) || (this.aajY > 0)) {
              this.aajT.errCode = -9;
            }
          }
          paramInt = this.aajT.aakc;
          int j = this.aajT.errCode;
          bj(i, paramInt, j);
          AppMethodBeat.o(154524);
          return;
        case -3: 
          this.aajW += 1;
        }
      }
      this.aajX += 1;
      continue;
      this.aajY += 1;
      continue;
      this.aajZ += 1;
      continue;
      paramInt = 1;
    }
  }
  
  final boolean izp()
  {
    AppMethodBeat.i(154527);
    if ((this.aajP != null) && (!this.aajP.isEmpty()) && (this.aajQ != null))
    {
      AppMethodBeat.o(154527);
      return true;
    }
    AppMethodBeat.o(154527);
    return false;
  }
  
  protected final void onPreExecute()
  {
    AppMethodBeat.i(154528);
    b(1, 1, null);
    super.onPreExecute();
    AppMethodBeat.o(154528);
  }
  
  public static final class a
  {
    public int aakc = 0;
    public int errCode = 0;
  }
  
  public static final class b
  {
    public boolean HYw = false;
    public AsyncTask mfr = null;
    public int type = 1;
  }
  
  public static final class c
    implements XWalkLibraryLoader.DownloadListener
  {
    private l aajR;
    private g aakd;
    private d aake;
    private boolean aakf;
    
    c(l paraml, g paramg, d paramd)
    {
      AppMethodBeat.i(205887);
      this.aajR = paraml;
      this.aakd = paramg;
      this.aake = paramd;
      if (paramd != null)
      {
        this.aakf = paramd.aakU;
        AppMethodBeat.o(205887);
        return;
      }
      this.aakf = false;
      AppMethodBeat.o(205887);
    }
    
    public final void onDownloadCancelled()
    {
      AppMethodBeat.i(154519);
      this.aajR.iA(this.aakd.getPluginName(), -3);
      com.tencent.xweb.util.h.dX(this.aakd.getPluginName(), this.aakf);
      a.bFR(this.aakd.getPluginName()).e(null);
      AppMethodBeat.o(154519);
    }
    
    public final void onDownloadCompleted(XWalkLibraryLoader.DownloadInfo paramDownloadInfo)
    {
      AppMethodBeat.i(154520);
      com.tencent.xweb.util.h.dW(this.aakd.getPluginName(), this.aakf);
      a.bFR(this.aakd.getPluginName()).e(null);
      new AsyncTask() {}.execute(new Void[0]);
      AppMethodBeat.o(154520);
    }
    
    public final void onDownloadFailed(XWalkLibraryLoader.DownloadInfo paramDownloadInfo)
    {
      AppMethodBeat.i(154521);
      this.aajR.iA(this.aakd.getPluginName(), -1);
      com.tencent.xweb.util.h.dX(this.aakd.getPluginName(), this.aakf);
      a.bFR(this.aakd.getPluginName()).e(null);
      AppMethodBeat.o(154521);
    }
    
    public final void onDownloadStarted(int paramInt)
    {
      AppMethodBeat.i(154517);
      com.tencent.xweb.util.h.dV(this.aakd.getPluginName(), this.aakf);
      AppMethodBeat.o(154517);
    }
    
    public final void onDownloadUpdated(int paramInt)
    {
      AppMethodBeat.i(154518);
      l locall = this.aajR;
      String str = this.aakd.getPluginName();
      if ((locall.aajT.aakc == 3) && (locall.izp()) && (locall.aajP.equals(str))) {
        locall.aajQ.aCH(paramInt);
      }
      AppMethodBeat.o(154518);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.l
 * JD-Core Version:    0.7.0.1
 */