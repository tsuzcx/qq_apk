package com.tencent.xweb.xwalk.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.ai;
import com.tencent.xweb.internal.a.b;
import com.tencent.xweb.xwalk.p;
import com.tencent.xweb.xwalk.updater.SchedulerConfig;
import com.tencent.xweb.xwalk.updater.a.c;
import com.tencent.xweb.xwalk.updater.a.d;
import com.tencent.xweb.xwalk.updater.a.e;
import com.tencent.xweb.xwalk.updater.c;
import com.tencent.xweb.xwalk.updater.h.c;
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

public final class k
  extends AsyncTask<String, Integer, Integer>
{
  String KHm;
  i KHn;
  private final Object KHp;
  a KHq;
  private Map<String, b> KHr;
  private int KHs;
  private int KHt;
  private int KHu;
  private int KHv;
  private int KHw;
  boolean KHx;
  
  public k()
  {
    AppMethodBeat.i(154522);
    this.KHp = new Object();
    this.KHq = new a();
    this.KHr = new HashMap();
    this.KHs = 0;
    this.KHt = 0;
    this.KHu = 0;
    this.KHv = 0;
    this.KHw = 0;
    this.KHx = false;
    this.KHm = "";
    this.KHn = null;
    AppMethodBeat.o(154522);
  }
  
  private void aW(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(154526);
    if (paramInt2 <= paramInt1)
    {
      Log.i("XWalkPluginUp", "status not changed, return");
      AppMethodBeat.o(154526);
      return;
    }
    Log.i("XWalkPluginUp", "change status from " + paramInt1 + " to " + paramInt2 + " errcode: " + paramInt3);
    if (fLW())
    {
      if ((paramInt1 != 0) || (paramInt2 != 1)) {
        break label192;
      }
      this.KHn.fJe();
    }
    for (;;)
    {
      if (paramInt2 == 5)
      {
        com.tencent.xweb.util.g.cU(15718, this.KHq.errCode + "," + this.KHs + "," + this.KHt + "," + this.KHu + "," + this.KHv + "," + this.KHw);
        j.fLV();
        this.KHx = true;
      }
      AppMethodBeat.o(154526);
      return;
      label192:
      if ((paramInt1 != 0) && (paramInt2 == 5)) {
        this.KHn.afZ(paramInt3);
      }
    }
  }
  
  public final void a(HashMap<String, String> paramHashMap, String paramString, i parami)
  {
    AppMethodBeat.i(208951);
    if (paramHashMap != null)
    {
      paramHashMap = (String)paramHashMap.get("UpdaterCheckType");
      if ((paramHashMap != null) && (paramHashMap.equals("1"))) {
        j.Cn(0L);
      }
    }
    this.KHm = paramString;
    this.KHn = parami;
    AppMethodBeat.o(208951);
  }
  
  final boolean b(int paramInt1, int paramInt2, Map<String, b> paramMap)
  {
    AppMethodBeat.i(154525);
    for (;;)
    {
      Object localObject2;
      synchronized (this.KHp)
      {
        int i = this.KHq.KHz;
        if (paramInt1 > i)
        {
          this.KHq.KHz = paramInt1;
          if (paramInt2 != 1) {
            this.KHq.errCode = paramInt2;
          }
          if (this.KHq.KHz != 4) {
            break label201;
          }
          if (this.KHr.size() == 0)
          {
            this.KHq.KHz = 5;
            continue;
          }
        }
        else
        {
          paramInt1 = this.KHq.KHz;
          paramInt2 = this.KHq.errCode;
          aW(i, paramInt1, paramInt2);
          if (paramInt1 <= i) {
            break;
          }
          AppMethodBeat.o(154525);
          return true;
        }
        paramMap = this.KHr.entrySet().iterator();
        if (!paramMap.hasNext()) {
          continue;
        }
        localObject2 = (b)((Map.Entry)paramMap.next()).getValue();
        if ((localObject2 == null) || (((b)localObject2).wAS)) {
          continue;
        }
        ((b)localObject2).hYn.cancel(true);
      }
      label201:
      if ((this.KHq.KHz == 3) && (paramMap != null))
      {
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Object localObject3 = (Map.Entry)paramMap.next();
          localObject2 = (String)((Map.Entry)localObject3).getKey();
          localObject3 = (b)((Map.Entry)localObject3).getValue();
          this.KHr.put(localObject2, localObject3);
          if (((b)localObject3).type == 1) {
            ((XWalkLibraryLoader.HttpDownloadTask)((b)localObject3).hYn).execute(new Void[0]);
          } else if (((b)localObject3).type == 2) {
            ((XWalkLibraryLoader.WXFileDownloaderTask)((b)localObject3).hYn).execute(new Void[0]);
          } else {
            this.KHr.remove(localObject2);
          }
        }
        this.KHs = this.KHr.size();
      }
    }
    AppMethodBeat.o(154525);
    return false;
  }
  
  final boolean fLW()
  {
    AppMethodBeat.i(154527);
    if ((this.KHm != null) && (!this.KHm.isEmpty()) && (this.KHn != null))
    {
      AppMethodBeat.o(154527);
      return true;
    }
    AppMethodBeat.o(154527);
    return false;
  }
  
  public final void gN(String paramString, int paramInt)
  {
    AppMethodBeat.i(154524);
    XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "onNotifyResult: " + paramString + " install retCode: " + paramInt);
    for (;;)
    {
      synchronized (this.KHp)
      {
        if (this.KHq.KHz == 5)
        {
          AppMethodBeat.o(154524);
          return;
        }
        switch (paramInt)
        {
        default: 
          ((b)this.KHr.get(paramString)).wAS = true;
          paramString = this.KHr.entrySet().iterator();
          if (!paramString.hasNext()) {
            break;
          }
          b localb = (b)((Map.Entry)paramString.next()).getValue();
          if ((localb == null) || (localb.wAS)) {
            continue;
          }
          paramInt = 0;
          int i = this.KHq.KHz;
          if (paramInt != 0)
          {
            this.KHr.clear();
            this.KHq.KHz = 5;
            if ((this.KHu > 0) || (this.KHv > 0)) {
              this.KHq.errCode = -9;
            }
          }
          paramInt = this.KHq.KHz;
          int j = this.KHq.errCode;
          aW(i, paramInt, j);
          AppMethodBeat.o(154524);
          return;
        case -3: 
          this.KHt += 1;
        }
      }
      this.KHu += 1;
      continue;
      this.KHv += 1;
      continue;
      this.KHw += 1;
      continue;
      paramInt = 1;
    }
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
    public int KHz = 0;
    public int errCode = 0;
  }
  
  public static final class b
  {
    public AsyncTask hYn = null;
    public int type = 1;
    public boolean wAS = false;
  }
  
  public static final class c
    implements XWalkLibraryLoader.DownloadListener
  {
    private f KHA;
    private SchedulerConfig KHB;
    private boolean KHC;
    private k KHo;
    
    c(k paramk, f paramf, SchedulerConfig paramSchedulerConfig)
    {
      AppMethodBeat.i(208950);
      this.KHo = paramk;
      this.KHA = paramf;
      this.KHB = paramSchedulerConfig;
      if (paramSchedulerConfig != null)
      {
        this.KHC = paramSchedulerConfig.KIp;
        AppMethodBeat.o(208950);
        return;
      }
      this.KHC = false;
      AppMethodBeat.o(208950);
    }
    
    public final void onDownloadCancelled()
    {
      AppMethodBeat.i(154519);
      this.KHo.gN(this.KHA.getPluginName(), -3);
      com.tencent.xweb.util.g.di(this.KHA.getPluginName(), this.KHC);
      a.aVx(this.KHA.getPluginName()).e(null);
      AppMethodBeat.o(154519);
    }
    
    public final void onDownloadCompleted(XWalkLibraryLoader.DownloadInfo paramDownloadInfo)
    {
      AppMethodBeat.i(154520);
      com.tencent.xweb.util.g.dh(this.KHA.getPluginName(), this.KHC);
      a.aVx(this.KHA.getPluginName()).e(null);
      new AsyncTask() {}.execute(new Void[0]);
      AppMethodBeat.o(154520);
    }
    
    public final void onDownloadFailed(XWalkLibraryLoader.DownloadInfo paramDownloadInfo)
    {
      AppMethodBeat.i(154521);
      this.KHo.gN(this.KHA.getPluginName(), -1);
      com.tencent.xweb.util.g.di(this.KHA.getPluginName(), this.KHC);
      a.aVx(this.KHA.getPluginName()).e(null);
      AppMethodBeat.o(154521);
    }
    
    public final void onDownloadStarted(int paramInt)
    {
      AppMethodBeat.i(154517);
      com.tencent.xweb.util.g.dg(this.KHA.getPluginName(), this.KHC);
      AppMethodBeat.o(154517);
    }
    
    public final void onDownloadUpdated(int paramInt)
    {
      AppMethodBeat.i(154518);
      k localk = this.KHo;
      String str = this.KHA.getPluginName();
      if ((localk.KHq.KHz == 3) && (localk.fLW()) && (localk.KHm.equals(str))) {
        localk.KHn.afY(paramInt);
      }
      AppMethodBeat.o(154518);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.k
 * JD-Core Version:    0.7.0.1
 */