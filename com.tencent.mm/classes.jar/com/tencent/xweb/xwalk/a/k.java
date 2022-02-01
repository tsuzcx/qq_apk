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
import com.tencent.xweb.xwalk.updater.i.c;
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
  String MxM;
  i MxN;
  private final Object MxP;
  a MxQ;
  private Map<String, b> MxR;
  private int MxS;
  private int MxT;
  private int MxU;
  private int MxV;
  private int MxW;
  boolean MxX;
  
  public k()
  {
    AppMethodBeat.i(154522);
    this.MxP = new Object();
    this.MxQ = new a();
    this.MxR = new HashMap();
    this.MxS = 0;
    this.MxT = 0;
    this.MxU = 0;
    this.MxV = 0;
    this.MxW = 0;
    this.MxX = false;
    this.MxM = "";
    this.MxN = null;
    AppMethodBeat.o(154522);
  }
  
  private void aX(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(154526);
    if (paramInt2 <= paramInt1)
    {
      Log.i("XWalkPluginUp", "status not changed, return");
      AppMethodBeat.o(154526);
      return;
    }
    Log.i("XWalkPluginUp", "change status from " + paramInt1 + " to " + paramInt2 + " errcode: " + paramInt3);
    if (gdr())
    {
      if ((paramInt1 != 0) || (paramInt2 != 1)) {
        break label192;
      }
      this.MxN.gaA();
    }
    for (;;)
    {
      if (paramInt2 == 5)
      {
        com.tencent.xweb.util.g.dc(15718, this.MxQ.errCode + "," + this.MxS + "," + this.MxT + "," + this.MxU + "," + this.MxV + "," + this.MxW);
        j.gdq();
        this.MxX = true;
      }
      AppMethodBeat.o(154526);
      return;
      label192:
      if ((paramInt1 != 0) && (paramInt2 == 5)) {
        this.MxN.aiz(paramInt3);
      }
    }
  }
  
  public final void a(HashMap<String, String> paramHashMap, String paramString, i parami)
  {
    AppMethodBeat.i(195591);
    if (paramHashMap != null)
    {
      paramHashMap = (String)paramHashMap.get("UpdaterCheckType");
      if ((paramHashMap != null) && (paramHashMap.equals("1"))) {
        j.Fp(0L);
      }
    }
    this.MxM = paramString;
    this.MxN = parami;
    AppMethodBeat.o(195591);
  }
  
  final boolean b(int paramInt1, int paramInt2, Map<String, b> paramMap)
  {
    AppMethodBeat.i(154525);
    for (;;)
    {
      Object localObject2;
      synchronized (this.MxP)
      {
        int i = this.MxQ.MxZ;
        if (paramInt1 > i)
        {
          this.MxQ.MxZ = paramInt1;
          if (paramInt2 != 1) {
            this.MxQ.errCode = paramInt2;
          }
          if (this.MxQ.MxZ != 4) {
            break label201;
          }
          if (this.MxR.size() == 0)
          {
            this.MxQ.MxZ = 5;
            continue;
          }
        }
        else
        {
          paramInt1 = this.MxQ.MxZ;
          paramInt2 = this.MxQ.errCode;
          aX(i, paramInt1, paramInt2);
          if (paramInt1 <= i) {
            break;
          }
          AppMethodBeat.o(154525);
          return true;
        }
        paramMap = this.MxR.entrySet().iterator();
        if (!paramMap.hasNext()) {
          continue;
        }
        localObject2 = (b)((Map.Entry)paramMap.next()).getValue();
        if ((localObject2 == null) || (((b)localObject2).xLk)) {
          continue;
        }
        ((b)localObject2).irJ.cancel(true);
      }
      label201:
      if ((this.MxQ.MxZ == 3) && (paramMap != null))
      {
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Object localObject3 = (Map.Entry)paramMap.next();
          localObject2 = (String)((Map.Entry)localObject3).getKey();
          localObject3 = (b)((Map.Entry)localObject3).getValue();
          this.MxR.put(localObject2, localObject3);
          if (((b)localObject3).type == 1) {
            ((XWalkLibraryLoader.HttpDownloadTask)((b)localObject3).irJ).execute(new Void[0]);
          } else if (((b)localObject3).type == 2) {
            ((XWalkLibraryLoader.WXFileDownloaderTask)((b)localObject3).irJ).execute(new Void[0]);
          } else {
            this.MxR.remove(localObject2);
          }
        }
        this.MxS = this.MxR.size();
      }
    }
    AppMethodBeat.o(154525);
    return false;
  }
  
  final boolean gdr()
  {
    AppMethodBeat.i(154527);
    if ((this.MxM != null) && (!this.MxM.isEmpty()) && (this.MxN != null))
    {
      AppMethodBeat.o(154527);
      return true;
    }
    AppMethodBeat.o(154527);
    return false;
  }
  
  public final void hm(String paramString, int paramInt)
  {
    AppMethodBeat.i(154524);
    XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "onNotifyResult: " + paramString + " install retCode: " + paramInt);
    for (;;)
    {
      synchronized (this.MxP)
      {
        if (this.MxQ.MxZ == 5)
        {
          AppMethodBeat.o(154524);
          return;
        }
        switch (paramInt)
        {
        default: 
          ((b)this.MxR.get(paramString)).xLk = true;
          paramString = this.MxR.entrySet().iterator();
          if (!paramString.hasNext()) {
            break;
          }
          b localb = (b)((Map.Entry)paramString.next()).getValue();
          if ((localb == null) || (localb.xLk)) {
            continue;
          }
          paramInt = 0;
          int i = this.MxQ.MxZ;
          if (paramInt != 0)
          {
            this.MxR.clear();
            this.MxQ.MxZ = 5;
            if ((this.MxU > 0) || (this.MxV > 0)) {
              this.MxQ.errCode = -9;
            }
          }
          paramInt = this.MxQ.MxZ;
          int j = this.MxQ.errCode;
          aX(i, paramInt, j);
          AppMethodBeat.o(154524);
          return;
        case -3: 
          this.MxT += 1;
        }
      }
      this.MxU += 1;
      continue;
      this.MxV += 1;
      continue;
      this.MxW += 1;
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
    public int MxZ = 0;
    public int errCode = 0;
  }
  
  public static final class b
  {
    public AsyncTask irJ = null;
    public int type = 1;
    public boolean xLk = false;
  }
  
  public static final class c
    implements XWalkLibraryLoader.DownloadListener
  {
    private k MxO;
    private f Mya;
    private SchedulerConfig Myb;
    private boolean Myc;
    
    c(k paramk, f paramf, SchedulerConfig paramSchedulerConfig)
    {
      AppMethodBeat.i(195590);
      this.MxO = paramk;
      this.Mya = paramf;
      this.Myb = paramSchedulerConfig;
      if (paramSchedulerConfig != null)
      {
        this.Myc = paramSchedulerConfig.MyT;
        AppMethodBeat.o(195590);
        return;
      }
      this.Myc = false;
      AppMethodBeat.o(195590);
    }
    
    public final void onDownloadCancelled()
    {
      AppMethodBeat.i(154519);
      this.MxO.hm(this.Mya.getPluginName(), -3);
      com.tencent.xweb.util.g.dn(this.Mya.getPluginName(), this.Myc);
      a.bbA(this.Mya.getPluginName()).e(null);
      AppMethodBeat.o(154519);
    }
    
    public final void onDownloadCompleted(XWalkLibraryLoader.DownloadInfo paramDownloadInfo)
    {
      AppMethodBeat.i(154520);
      com.tencent.xweb.util.g.dm(this.Mya.getPluginName(), this.Myc);
      a.bbA(this.Mya.getPluginName()).e(null);
      new AsyncTask() {}.execute(new Void[0]);
      AppMethodBeat.o(154520);
    }
    
    public final void onDownloadFailed(XWalkLibraryLoader.DownloadInfo paramDownloadInfo)
    {
      AppMethodBeat.i(154521);
      this.MxO.hm(this.Mya.getPluginName(), -1);
      com.tencent.xweb.util.g.dn(this.Mya.getPluginName(), this.Myc);
      a.bbA(this.Mya.getPluginName()).e(null);
      AppMethodBeat.o(154521);
    }
    
    public final void onDownloadStarted(int paramInt)
    {
      AppMethodBeat.i(154517);
      com.tencent.xweb.util.g.dl(this.Mya.getPluginName(), this.Myc);
      AppMethodBeat.o(154517);
    }
    
    public final void onDownloadUpdated(int paramInt)
    {
      AppMethodBeat.i(154518);
      k localk = this.MxO;
      String str = this.Mya.getPluginName();
      if ((localk.MxQ.MxZ == 3) && (localk.gdr()) && (localk.MxM.equals(str))) {
        localk.MxN.aiy(paramInt);
      }
      AppMethodBeat.o(154518);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.k
 * JD-Core Version:    0.7.0.1
 */