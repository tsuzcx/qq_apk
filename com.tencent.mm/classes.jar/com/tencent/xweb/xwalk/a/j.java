package com.tencent.xweb.xwalk.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.ag;
import com.tencent.xweb.xwalk.o;
import com.tencent.xweb.xwalk.updater.a;
import com.tencent.xweb.xwalk.updater.a.c;
import com.tencent.xweb.xwalk.updater.a.d;
import com.tencent.xweb.xwalk.updater.f.c;
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

public final class j
  extends AsyncTask<String, Integer, Integer>
{
  String IUN;
  i.a IUO;
  private final Object IUQ;
  a IUR;
  private Map<String, b> IUS;
  private int IUT;
  private int IUU;
  private int IUV;
  private int IUW;
  private int IUX;
  boolean IUY;
  
  public j()
  {
    AppMethodBeat.i(154522);
    this.IUQ = new Object();
    this.IUR = new a();
    this.IUS = new HashMap();
    this.IUT = 0;
    this.IUU = 0;
    this.IUV = 0;
    this.IUW = 0;
    this.IUX = 0;
    this.IUY = false;
    this.IUN = "";
    this.IUO = null;
    AppMethodBeat.o(154522);
  }
  
  private void aU(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(154526);
    if (paramInt2 <= paramInt1)
    {
      Log.i("XWalkPluginUp", "status not changed, return");
      AppMethodBeat.o(154526);
      return;
    }
    Log.i("XWalkPluginUp", "change status from " + paramInt1 + " to " + paramInt2 + " errcode: " + paramInt3);
    if (ftp())
    {
      if ((paramInt1 != 0) || (paramInt2 != 1)) {
        break label192;
      }
      this.IUO.fsW();
    }
    for (;;)
    {
      if (paramInt2 == 5)
      {
        com.tencent.xweb.util.g.cR(15718, this.IUR.errCode + "," + this.IUT + "," + this.IUU + "," + this.IUV + "," + this.IUW + "," + this.IUX);
        i.fto();
        this.IUY = true;
      }
      AppMethodBeat.o(154526);
      return;
      label192:
      if ((paramInt1 != 0) && (paramInt2 == 5)) {
        this.IUO.adh(paramInt3);
      }
    }
  }
  
  public final void a(HashMap<String, String> paramHashMap, String paramString, i.a parama)
  {
    AppMethodBeat.i(154523);
    if (paramHashMap != null)
    {
      paramHashMap = (String)paramHashMap.get("UpdaterCheckType");
      if ((paramHashMap != null) && (paramHashMap.equals("1"))) {
        i.xA(0L);
      }
    }
    this.IUN = paramString;
    this.IUO = parama;
    AppMethodBeat.o(154523);
  }
  
  public final boolean b(int paramInt1, int paramInt2, Map<String, b> paramMap)
  {
    AppMethodBeat.i(154525);
    for (;;)
    {
      Object localObject2;
      synchronized (this.IUQ)
      {
        int i = this.IUR.IVa;
        if (paramInt1 > i)
        {
          this.IUR.IVa = paramInt1;
          if (paramInt2 != 1) {
            this.IUR.errCode = paramInt2;
          }
          if (this.IUR.IVa != 4) {
            break label201;
          }
          if (this.IUS.size() == 0)
          {
            this.IUR.IVa = 5;
            continue;
          }
        }
        else
        {
          paramInt1 = this.IUR.IVa;
          paramInt2 = this.IUR.errCode;
          aU(i, paramInt1, paramInt2);
          if (paramInt1 <= i) {
            break;
          }
          AppMethodBeat.o(154525);
          return true;
        }
        paramMap = this.IUS.entrySet().iterator();
        if (!paramMap.hasNext()) {
          continue;
        }
        localObject2 = (b)((Map.Entry)paramMap.next()).getValue();
        if ((localObject2 == null) || (((b)localObject2).vqU)) {
          continue;
        }
        ((b)localObject2).hxM.cancel(true);
      }
      label201:
      if ((this.IUR.IVa == 3) && (paramMap != null))
      {
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Object localObject3 = (Map.Entry)paramMap.next();
          localObject2 = (String)((Map.Entry)localObject3).getKey();
          localObject3 = (b)((Map.Entry)localObject3).getValue();
          this.IUS.put(localObject2, localObject3);
          if (((b)localObject3).type == 1) {
            ((XWalkLibraryLoader.HttpDownloadTask)((b)localObject3).hxM).execute(new Void[0]);
          } else if (((b)localObject3).type == 2) {
            ((XWalkLibraryLoader.WXFileDownloaderTask)((b)localObject3).hxM).execute(new Void[0]);
          } else {
            this.IUS.remove(localObject2);
          }
        }
        this.IUT = this.IUS.size();
      }
    }
    AppMethodBeat.o(154525);
    return false;
  }
  
  final boolean ftp()
  {
    AppMethodBeat.i(154527);
    if ((this.IUN != null) && (!this.IUN.isEmpty()) && (this.IUO != null))
    {
      AppMethodBeat.o(154527);
      return true;
    }
    AppMethodBeat.o(154527);
    return false;
  }
  
  public final void gH(String paramString, int paramInt)
  {
    AppMethodBeat.i(154524);
    XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "onNotifyResult: " + paramString + " install retCode: " + paramInt);
    for (;;)
    {
      synchronized (this.IUQ)
      {
        if (this.IUR.IVa == 5)
        {
          AppMethodBeat.o(154524);
          return;
        }
        switch (paramInt)
        {
        default: 
          ((b)this.IUS.get(paramString)).vqU = true;
          paramString = this.IUS.entrySet().iterator();
          if (!paramString.hasNext()) {
            break;
          }
          b localb = (b)((Map.Entry)paramString.next()).getValue();
          if ((localb == null) || (localb.vqU)) {
            continue;
          }
          paramInt = 0;
          int i = this.IUR.IVa;
          if (paramInt != 0)
          {
            this.IUS.clear();
            this.IUR.IVa = 5;
            if ((this.IUV > 0) || (this.IUW > 0)) {
              this.IUR.errCode = -9;
            }
          }
          paramInt = this.IUR.IVa;
          int j = this.IUR.errCode;
          aU(i, paramInt, j);
          AppMethodBeat.o(154524);
          return;
        case -3: 
          this.IUU += 1;
        }
      }
      this.IUV += 1;
      continue;
      this.IUW += 1;
      continue;
      this.IUX += 1;
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
    public int IVa = 0;
    public int errCode = 0;
  }
  
  public static final class b
  {
    public AsyncTask hxM = null;
    public int type = 1;
    public boolean vqU = false;
  }
  
  public static final class c
    implements XWalkLibraryLoader.DownloadListener
  {
    private j IUP;
    private e IVb;
    private f IVc;
    private boolean IVd;
    
    c(j paramj, e parame, f paramf)
    {
      this.IUP = paramj;
      this.IVb = parame;
      this.IVc = paramf;
      this.IVd = paramf.isPatch;
    }
    
    public final void onDownloadCancelled()
    {
      AppMethodBeat.i(154519);
      this.IUP.gH(this.IVb.getPluginName(), -3);
      com.tencent.xweb.util.g.dd(this.IVb.getPluginName(), this.IVd);
      AppMethodBeat.o(154519);
    }
    
    public final void onDownloadCompleted(XWalkLibraryLoader.DownloadInfo paramDownloadInfo)
    {
      AppMethodBeat.i(154520);
      com.tencent.xweb.util.g.dc(this.IVb.getPluginName(), this.IVd);
      new AsyncTask() {}.execute(new Void[0]);
      AppMethodBeat.o(154520);
    }
    
    public final void onDownloadFailed(XWalkLibraryLoader.DownloadInfo paramDownloadInfo)
    {
      AppMethodBeat.i(154521);
      this.IUP.gH(this.IVb.getPluginName(), -1);
      com.tencent.xweb.util.g.dd(this.IVb.getPluginName(), this.IVd);
      AppMethodBeat.o(154521);
    }
    
    public final void onDownloadStarted(int paramInt)
    {
      AppMethodBeat.i(154517);
      com.tencent.xweb.util.g.db(this.IVb.getPluginName(), this.IVd);
      AppMethodBeat.o(154517);
    }
    
    public final void onDownloadUpdated(int paramInt)
    {
      AppMethodBeat.i(154518);
      j localj = this.IUP;
      String str = this.IVb.getPluginName();
      if ((localj.IUR.IVa == 3) && (localj.ftp()) && (localj.IUN.equals(str))) {
        localj.IUO.adg(paramInt);
      }
      AppMethodBeat.o(154518);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.j
 * JD-Core Version:    0.7.0.1
 */