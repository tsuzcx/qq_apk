package com.tencent.xweb.xwalk.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.ai;
import com.tencent.xweb.internal.a.b;
import com.tencent.xweb.xwalk.p;
import com.tencent.xweb.xwalk.updater.Scheduler;
import com.tencent.xweb.xwalk.updater.a.c;
import com.tencent.xweb.xwalk.updater.a.d;
import com.tencent.xweb.xwalk.updater.a.e;
import com.tencent.xweb.xwalk.updater.c;
import com.tencent.xweb.xwalk.updater.j.c;
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
  String SHX;
  j SHY;
  private final Object SIa;
  a SIb;
  private Map<String, b> SIc;
  private int SId;
  private int SIe;
  private int SIf;
  private int SIg;
  private int SIh;
  boolean SIi;
  
  public l()
  {
    AppMethodBeat.i(154522);
    this.SIa = new Object();
    this.SIb = new a();
    this.SIc = new HashMap();
    this.SId = 0;
    this.SIe = 0;
    this.SIf = 0;
    this.SIg = 0;
    this.SIh = 0;
    this.SIi = false;
    this.SHX = "";
    this.SHY = null;
    AppMethodBeat.o(154522);
  }
  
  private void be(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(154526);
    if (paramInt2 <= paramInt1)
    {
      Log.i("XWalkPluginUp", "status not changed, return");
      AppMethodBeat.o(154526);
      return;
    }
    Log.i("XWalkPluginUp", "change status from " + paramInt1 + " to " + paramInt2 + " errcode: " + paramInt3);
    if (hvt())
    {
      if ((paramInt1 != 0) || (paramInt2 != 1)) {
        break label192;
      }
      this.SHY.hst();
    }
    for (;;)
    {
      if (paramInt2 == 5)
      {
        com.tencent.xweb.util.h.dz(15718, this.SIb.errCode + "," + this.SId + "," + this.SIe + "," + this.SIf + "," + this.SIg + "," + this.SIh);
        k.hvs();
        this.SIi = true;
      }
      AppMethodBeat.o(154526);
      return;
      label192:
      if ((paramInt1 != 0) && (paramInt2 == 5)) {
        this.SHY.asR(paramInt3);
      }
    }
  }
  
  public final void a(HashMap<String, String> paramHashMap, String paramString, j paramj)
  {
    AppMethodBeat.i(207345);
    if (paramHashMap != null)
    {
      paramHashMap = (String)paramHashMap.get("UpdaterCheckType");
      if ((paramHashMap != null) && (paramHashMap.equals("1"))) {
        k.OY(0L);
      }
    }
    this.SHX = paramString;
    this.SHY = paramj;
    AppMethodBeat.o(207345);
  }
  
  final boolean b(int paramInt1, int paramInt2, Map<String, b> paramMap)
  {
    AppMethodBeat.i(154525);
    for (;;)
    {
      Object localObject2;
      synchronized (this.SIa)
      {
        int i = this.SIb.SIk;
        if (paramInt1 > i)
        {
          this.SIb.SIk = paramInt1;
          if (paramInt2 != 1) {
            this.SIb.errCode = paramInt2;
          }
          if (this.SIb.SIk != 4) {
            break label201;
          }
          if (this.SIc.size() == 0)
          {
            this.SIb.SIk = 5;
            continue;
          }
        }
        else
        {
          paramInt1 = this.SIb.SIk;
          paramInt2 = this.SIb.errCode;
          be(i, paramInt1, paramInt2);
          if (paramInt1 <= i) {
            break;
          }
          AppMethodBeat.o(154525);
          return true;
        }
        paramMap = this.SIc.entrySet().iterator();
        if (!paramMap.hasNext()) {
          continue;
        }
        localObject2 = (b)((Map.Entry)paramMap.next()).getValue();
        if ((localObject2 == null) || (((b)localObject2).Cch)) {
          continue;
        }
        ((b)localObject2).jpQ.cancel(true);
      }
      label201:
      if ((this.SIb.SIk == 3) && (paramMap != null))
      {
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Object localObject3 = (Map.Entry)paramMap.next();
          localObject2 = (String)((Map.Entry)localObject3).getKey();
          localObject3 = (b)((Map.Entry)localObject3).getValue();
          this.SIc.put(localObject2, localObject3);
          if (((b)localObject3).type == 1) {
            ((XWalkLibraryLoader.HttpDownloadTask)((b)localObject3).jpQ).execute(new Void[0]);
          } else if (((b)localObject3).type == 2) {
            ((XWalkLibraryLoader.WXFileDownloaderTask)((b)localObject3).jpQ).execute(new Void[0]);
          } else {
            this.SIc.remove(localObject2);
          }
        }
        this.SId = this.SIc.size();
      }
    }
    AppMethodBeat.o(154525);
    return false;
  }
  
  public final void hR(String paramString, int paramInt)
  {
    AppMethodBeat.i(154524);
    XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "onNotifyResult: " + paramString + " install retCode: " + paramInt);
    for (;;)
    {
      synchronized (this.SIa)
      {
        if (this.SIb.SIk == 5)
        {
          AppMethodBeat.o(154524);
          return;
        }
        switch (paramInt)
        {
        default: 
          ((b)this.SIc.get(paramString)).Cch = true;
          paramString = this.SIc.entrySet().iterator();
          if (!paramString.hasNext()) {
            break;
          }
          b localb = (b)((Map.Entry)paramString.next()).getValue();
          if ((localb == null) || (localb.Cch)) {
            continue;
          }
          paramInt = 0;
          int i = this.SIb.SIk;
          if (paramInt != 0)
          {
            this.SIc.clear();
            this.SIb.SIk = 5;
            if ((this.SIf > 0) || (this.SIg > 0)) {
              this.SIb.errCode = -9;
            }
          }
          paramInt = this.SIb.SIk;
          int j = this.SIb.errCode;
          be(i, paramInt, j);
          AppMethodBeat.o(154524);
          return;
        case -3: 
          this.SIe += 1;
        }
      }
      this.SIf += 1;
      continue;
      this.SIg += 1;
      continue;
      this.SIh += 1;
      continue;
      paramInt = 1;
    }
  }
  
  final boolean hvt()
  {
    AppMethodBeat.i(154527);
    if ((this.SHX != null) && (!this.SHX.isEmpty()) && (this.SHY != null))
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
    public int SIk = 0;
    public int errCode = 0;
  }
  
  public static final class b
  {
    public boolean Cch = false;
    public AsyncTask jpQ = null;
    public int type = 1;
  }
  
  public static final class c
    implements XWalkLibraryLoader.DownloadListener
  {
    private l SHZ;
    private g SIl;
    private c SIm;
    private boolean SIn;
    
    c(l paraml, g paramg, c paramc)
    {
      AppMethodBeat.i(207344);
      this.SHZ = paraml;
      this.SIl = paramg;
      this.SIm = paramc;
      if (paramc != null)
      {
        this.SIn = paramc.SJc;
        AppMethodBeat.o(207344);
        return;
      }
      this.SIn = false;
      AppMethodBeat.o(207344);
    }
    
    public final void onDownloadCancelled()
    {
      AppMethodBeat.i(154519);
      this.SHZ.hR(this.SIl.getPluginName(), -3);
      com.tencent.xweb.util.h.dL(this.SIl.getPluginName(), this.SIn);
      a.bsQ(this.SIl.getPluginName()).e(null);
      AppMethodBeat.o(154519);
    }
    
    public final void onDownloadCompleted(XWalkLibraryLoader.DownloadInfo paramDownloadInfo)
    {
      AppMethodBeat.i(154520);
      com.tencent.xweb.util.h.dK(this.SIl.getPluginName(), this.SIn);
      a.bsQ(this.SIl.getPluginName()).e(null);
      new AsyncTask() {}.execute(new Void[0]);
      AppMethodBeat.o(154520);
    }
    
    public final void onDownloadFailed(XWalkLibraryLoader.DownloadInfo paramDownloadInfo)
    {
      AppMethodBeat.i(154521);
      this.SHZ.hR(this.SIl.getPluginName(), -1);
      com.tencent.xweb.util.h.dL(this.SIl.getPluginName(), this.SIn);
      a.bsQ(this.SIl.getPluginName()).e(null);
      AppMethodBeat.o(154521);
    }
    
    public final void onDownloadStarted(int paramInt)
    {
      AppMethodBeat.i(154517);
      com.tencent.xweb.util.h.dJ(this.SIl.getPluginName(), this.SIn);
      AppMethodBeat.o(154517);
    }
    
    public final void onDownloadUpdated(int paramInt)
    {
      AppMethodBeat.i(154518);
      l locall = this.SHZ;
      String str = this.SIl.getPluginName();
      if ((locall.SIb.SIk == 3) && (locall.hvt()) && (locall.SHX.equals(str))) {
        locall.SHY.asQ(paramInt);
      }
      AppMethodBeat.o(154518);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.l
 * JD-Core Version:    0.7.0.1
 */