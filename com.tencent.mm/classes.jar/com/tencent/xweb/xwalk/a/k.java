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
  String MUQ;
  i MUR;
  private final Object MUT;
  a MUU;
  private Map<String, b> MUV;
  private int MUW;
  private int MUX;
  private int MUY;
  private int MUZ;
  private int MVa;
  boolean MVb;
  
  public k()
  {
    AppMethodBeat.i(154522);
    this.MUT = new Object();
    this.MUU = new a();
    this.MUV = new HashMap();
    this.MUW = 0;
    this.MUX = 0;
    this.MUY = 0;
    this.MUZ = 0;
    this.MVa = 0;
    this.MVb = false;
    this.MUQ = "";
    this.MUR = null;
    AppMethodBeat.o(154522);
  }
  
  private void aY(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(154526);
    if (paramInt2 <= paramInt1)
    {
      Log.i("XWalkPluginUp", "status not changed, return");
      AppMethodBeat.o(154526);
      return;
    }
    Log.i("XWalkPluginUp", "change status from " + paramInt1 + " to " + paramInt2 + " errcode: " + paramInt3);
    if (ghT())
    {
      if ((paramInt1 != 0) || (paramInt2 != 1)) {
        break label192;
      }
      this.MUR.gfc();
    }
    for (;;)
    {
      if (paramInt2 == 5)
      {
        com.tencent.xweb.util.g.dc(15718, this.MUU.errCode + "," + this.MUW + "," + this.MUX + "," + this.MUY + "," + this.MUZ + "," + this.MVa);
        j.ghS();
        this.MVb = true;
      }
      AppMethodBeat.o(154526);
      return;
      label192:
      if ((paramInt1 != 0) && (paramInt2 == 5)) {
        this.MUR.aji(paramInt3);
      }
    }
  }
  
  public final void a(HashMap<String, String> paramHashMap, String paramString, i parami)
  {
    AppMethodBeat.i(207612);
    if (paramHashMap != null)
    {
      paramHashMap = (String)paramHashMap.get("UpdaterCheckType");
      if ((paramHashMap != null) && (paramHashMap.equals("1"))) {
        j.FR(0L);
      }
    }
    this.MUQ = paramString;
    this.MUR = parami;
    AppMethodBeat.o(207612);
  }
  
  final boolean b(int paramInt1, int paramInt2, Map<String, b> paramMap)
  {
    AppMethodBeat.i(154525);
    for (;;)
    {
      Object localObject2;
      synchronized (this.MUT)
      {
        int i = this.MUU.MVd;
        if (paramInt1 > i)
        {
          this.MUU.MVd = paramInt1;
          if (paramInt2 != 1) {
            this.MUU.errCode = paramInt2;
          }
          if (this.MUU.MVd != 4) {
            break label201;
          }
          if (this.MUV.size() == 0)
          {
            this.MUU.MVd = 5;
            continue;
          }
        }
        else
        {
          paramInt1 = this.MUU.MVd;
          paramInt2 = this.MUU.errCode;
          aY(i, paramInt1, paramInt2);
          if (paramInt1 <= i) {
            break;
          }
          AppMethodBeat.o(154525);
          return true;
        }
        paramMap = this.MUV.entrySet().iterator();
        if (!paramMap.hasNext()) {
          continue;
        }
        localObject2 = (b)((Map.Entry)paramMap.next()).getValue();
        if ((localObject2 == null) || (((b)localObject2).ybf)) {
          continue;
        }
        ((b)localObject2).iuD.cancel(true);
      }
      label201:
      if ((this.MUU.MVd == 3) && (paramMap != null))
      {
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Object localObject3 = (Map.Entry)paramMap.next();
          localObject2 = (String)((Map.Entry)localObject3).getKey();
          localObject3 = (b)((Map.Entry)localObject3).getValue();
          this.MUV.put(localObject2, localObject3);
          if (((b)localObject3).type == 1) {
            ((XWalkLibraryLoader.HttpDownloadTask)((b)localObject3).iuD).execute(new Void[0]);
          } else if (((b)localObject3).type == 2) {
            ((XWalkLibraryLoader.WXFileDownloaderTask)((b)localObject3).iuD).execute(new Void[0]);
          } else {
            this.MUV.remove(localObject2);
          }
        }
        this.MUW = this.MUV.size();
      }
    }
    AppMethodBeat.o(154525);
    return false;
  }
  
  final boolean ghT()
  {
    AppMethodBeat.i(154527);
    if ((this.MUQ != null) && (!this.MUQ.isEmpty()) && (this.MUR != null))
    {
      AppMethodBeat.o(154527);
      return true;
    }
    AppMethodBeat.o(154527);
    return false;
  }
  
  public final void hv(String paramString, int paramInt)
  {
    AppMethodBeat.i(154524);
    XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "onNotifyResult: " + paramString + " install retCode: " + paramInt);
    for (;;)
    {
      synchronized (this.MUT)
      {
        if (this.MUU.MVd == 5)
        {
          AppMethodBeat.o(154524);
          return;
        }
        switch (paramInt)
        {
        default: 
          ((b)this.MUV.get(paramString)).ybf = true;
          paramString = this.MUV.entrySet().iterator();
          if (!paramString.hasNext()) {
            break;
          }
          b localb = (b)((Map.Entry)paramString.next()).getValue();
          if ((localb == null) || (localb.ybf)) {
            continue;
          }
          paramInt = 0;
          int i = this.MUU.MVd;
          if (paramInt != 0)
          {
            this.MUV.clear();
            this.MUU.MVd = 5;
            if ((this.MUY > 0) || (this.MUZ > 0)) {
              this.MUU.errCode = -9;
            }
          }
          paramInt = this.MUU.MVd;
          int j = this.MUU.errCode;
          aY(i, paramInt, j);
          AppMethodBeat.o(154524);
          return;
        case -3: 
          this.MUX += 1;
        }
      }
      this.MUY += 1;
      continue;
      this.MUZ += 1;
      continue;
      this.MVa += 1;
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
    public int MVd = 0;
    public int errCode = 0;
  }
  
  public static final class b
  {
    public AsyncTask iuD = null;
    public int type = 1;
    public boolean ybf = false;
  }
  
  public static final class c
    implements XWalkLibraryLoader.DownloadListener
  {
    private k MUS;
    private f MVe;
    private c MVf;
    private boolean MVg;
    
    c(k paramk, f paramf, c paramc)
    {
      AppMethodBeat.i(207611);
      this.MUS = paramk;
      this.MVe = paramf;
      this.MVf = paramc;
      if (paramc != null)
      {
        this.MVg = paramc.MVY;
        AppMethodBeat.o(207611);
        return;
      }
      this.MVg = false;
      AppMethodBeat.o(207611);
    }
    
    public final void onDownloadCancelled()
    {
      AppMethodBeat.i(154519);
      this.MUS.hv(this.MVe.getPluginName(), -3);
      com.tencent.xweb.util.g.dq(this.MVe.getPluginName(), this.MVg);
      a.bdd(this.MVe.getPluginName()).e(null);
      AppMethodBeat.o(154519);
    }
    
    public final void onDownloadCompleted(XWalkLibraryLoader.DownloadInfo paramDownloadInfo)
    {
      AppMethodBeat.i(154520);
      com.tencent.xweb.util.g.dp(this.MVe.getPluginName(), this.MVg);
      a.bdd(this.MVe.getPluginName()).e(null);
      new AsyncTask() {}.execute(new Void[0]);
      AppMethodBeat.o(154520);
    }
    
    public final void onDownloadFailed(XWalkLibraryLoader.DownloadInfo paramDownloadInfo)
    {
      AppMethodBeat.i(154521);
      this.MUS.hv(this.MVe.getPluginName(), -1);
      com.tencent.xweb.util.g.dq(this.MVe.getPluginName(), this.MVg);
      a.bdd(this.MVe.getPluginName()).e(null);
      AppMethodBeat.o(154521);
    }
    
    public final void onDownloadStarted(int paramInt)
    {
      AppMethodBeat.i(154517);
      com.tencent.xweb.util.g.jdMethod_do(this.MVe.getPluginName(), this.MVg);
      AppMethodBeat.o(154517);
    }
    
    public final void onDownloadUpdated(int paramInt)
    {
      AppMethodBeat.i(154518);
      k localk = this.MUS;
      String str = this.MVe.getPluginName();
      if ((localk.MUU.MVd == 3) && (localk.ghT()) && (localk.MUQ.equals(str))) {
        localk.MUR.ajh(paramInt);
      }
      AppMethodBeat.o(154518);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.k
 * JD-Core Version:    0.7.0.1
 */