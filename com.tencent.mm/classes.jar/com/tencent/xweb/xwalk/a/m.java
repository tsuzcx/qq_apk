package com.tencent.xweb.xwalk.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.ak;
import com.tencent.xweb.internal.b.a;
import com.tencent.xweb.internal.b.d;
import com.tencent.xweb.internal.b.e;
import com.tencent.xweb.internal.b.f;
import com.tencent.xweb.internal.b.g;
import com.tencent.xweb.xwalk.updater.c;
import com.tencent.xweb.xwalk.updater.d;
import com.tencent.xweb.xwalk.updater.j;
import com.tencent.xweb.xwalk.updater.o.c;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.xwalk.core.Log;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializeLog;
import org.xwalk.core.XWalkSharedPreferenceUtil;
import org.xwalk.core.XWebDownloader.DownloadListener;
import org.xwalk.core.XWebDownloader.HttpDownloadTask;
import org.xwalk.core.XWebDownloader.WXFileDownloaderTask;

public final class m
  extends AsyncTask<String, Integer, Integer>
{
  String aipU;
  k aipV;
  private final Object aipX;
  a aipY;
  private Map<String, b> aipZ;
  private int aiqa;
  private int aiqb;
  private int aiqc;
  private int aiqd;
  private int aiqe;
  boolean aiqf;
  private String aiqg;
  
  public m()
  {
    AppMethodBeat.i(213075);
    this.aipX = new Object();
    this.aipY = new a();
    this.aipZ = new HashMap();
    this.aiqa = 0;
    this.aiqb = 0;
    this.aiqc = 0;
    this.aiqd = 0;
    this.aiqe = 0;
    this.aiqf = false;
    this.aipU = "";
    this.aipV = null;
    this.aiqg = "0";
    AppMethodBeat.o(213075);
  }
  
  private void bL(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(213080);
    if (paramInt2 <= paramInt1)
    {
      XWalkInitializeLog.addXWalkInitializeLog("XWalkPluginUpdaterChecker", "status not changed, return");
      AppMethodBeat.o(213080);
      return;
    }
    XWalkInitializeLog.addXWalkInitializeLog("XWalkPluginUpdaterChecker", "change status from " + paramInt1 + " to " + paramInt2 + ", errcode:" + paramInt3);
    if (kjK())
    {
      if ((paramInt1 != 0) || (paramInt2 != 1)) {
        break label192;
      }
      this.aipV.kfs();
    }
    for (;;)
    {
      if (paramInt2 == 5)
      {
        com.tencent.xweb.util.l.ev(15718, this.aipY.errCode + "," + this.aiqa + "," + this.aiqb + "," + this.aiqc + "," + this.aiqd + "," + this.aiqe);
        l.kjJ();
        this.aiqf = true;
      }
      AppMethodBeat.o(213080);
      return;
      label192:
      if ((paramInt1 != 0) && (paramInt2 == 5)) {
        this.aipV.aJv(paramInt3);
      }
    }
  }
  
  public final void a(HashMap<String, String> paramHashMap, String paramString, k paramk)
  {
    AppMethodBeat.i(213095);
    if (paramHashMap != null)
    {
      this.aiqg = ((String)paramHashMap.get("UpdaterCheckType"));
      if ((this.aiqg != null) && (this.aiqg.equals("1"))) {
        l.Bz(0L);
      }
    }
    this.aipU = paramString;
    this.aipV = paramk;
    XWalkInitializeLog.addXWalkInitializeLog("XWalkPluginUpdaterChecker", "create XWalkPluginUpdaterChecker, singlePlugin:" + this.aipU + ", notifyType:" + this.aiqg + " [0:timer/1:notify/2:force/4:embed/5:config]");
    AppMethodBeat.o(213095);
  }
  
  final boolean b(int paramInt1, int paramInt2, Map<String, b> paramMap)
  {
    AppMethodBeat.i(213105);
    for (;;)
    {
      Object localObject2;
      synchronized (this.aipX)
      {
        int i = this.aipY.aiqi;
        if (paramInt1 > i)
        {
          this.aipY.aiqi = paramInt1;
          if (paramInt2 != 1) {
            this.aipY.errCode = paramInt2;
          }
          if (this.aipY.aiqi != 4) {
            break label201;
          }
          if (this.aipZ.size() == 0)
          {
            this.aipY.aiqi = 5;
            continue;
          }
        }
        else
        {
          paramInt1 = this.aipY.aiqi;
          paramInt2 = this.aipY.errCode;
          bL(i, paramInt1, paramInt2);
          if (paramInt1 <= i) {
            break;
          }
          AppMethodBeat.o(213105);
          return true;
        }
        paramMap = this.aipZ.entrySet().iterator();
        if (!paramMap.hasNext()) {
          continue;
        }
        localObject2 = (b)((Map.Entry)paramMap.next()).getValue();
        if ((localObject2 == null) || (((b)localObject2).NVf)) {
          continue;
        }
        ((b)localObject2).oYn.cancel(true);
      }
      label201:
      if ((this.aipY.aiqi == 3) && (paramMap != null))
      {
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Object localObject3 = (Map.Entry)paramMap.next();
          localObject2 = (String)((Map.Entry)localObject3).getKey();
          localObject3 = (b)((Map.Entry)localObject3).getValue();
          this.aipZ.put(localObject2, localObject3);
          if (((b)localObject3).type == 1) {
            ((XWebDownloader.HttpDownloadTask)((b)localObject3).oYn).execute(new Void[0]);
          } else if (((b)localObject3).type == 2) {
            ((XWebDownloader.WXFileDownloaderTask)((b)localObject3).oYn).execute(new Void[0]);
          } else {
            this.aipZ.remove(localObject2);
          }
        }
        this.aiqa = this.aipZ.size();
      }
    }
    AppMethodBeat.o(213105);
    return false;
  }
  
  public final void jL(String paramString, int paramInt)
  {
    AppMethodBeat.i(213099);
    XWalkInitializeLog.addXWalkInitializeLog("XWalkPluginUpdaterChecker", "onNotifyResult: " + paramString + " install retCode: " + paramInt);
    for (;;)
    {
      synchronized (this.aipX)
      {
        if (this.aipY.aiqi == 5)
        {
          AppMethodBeat.o(213099);
          return;
        }
        switch (paramInt)
        {
        default: 
          ((b)this.aipZ.get(paramString)).NVf = true;
          paramString = this.aipZ.entrySet().iterator();
          if (!paramString.hasNext()) {
            break;
          }
          b localb = (b)((Map.Entry)paramString.next()).getValue();
          if ((localb == null) || (localb.NVf)) {
            continue;
          }
          paramInt = 0;
          int i = this.aipY.aiqi;
          if (paramInt != 0)
          {
            this.aipZ.clear();
            this.aipY.aiqi = 5;
            if ((this.aiqc > 0) || (this.aiqd > 0)) {
              this.aipY.errCode = -9;
            }
          }
          paramInt = this.aipY.aiqi;
          int j = this.aipY.errCode;
          bL(i, paramInt, j);
          AppMethodBeat.o(213099);
          return;
        case -3: 
          this.aiqb += 1;
        }
      }
      this.aiqc += 1;
      continue;
      this.aiqd += 1;
      continue;
      this.aiqe += 1;
      continue;
      paramInt = 1;
    }
  }
  
  final boolean kjK()
  {
    AppMethodBeat.i(213107);
    if ((this.aipU != null) && (!this.aipU.isEmpty()) && (this.aipV != null))
    {
      AppMethodBeat.o(213107);
      return true;
    }
    AppMethodBeat.o(213107);
    return false;
  }
  
  protected final void onPreExecute()
  {
    AppMethodBeat.i(213112);
    b(1, 1, null);
    super.onPreExecute();
    AppMethodBeat.o(213112);
  }
  
  public static final class a
  {
    public int aiqi = 0;
    public int errCode = 0;
  }
  
  public static final class b
  {
    public boolean NVf = false;
    public AsyncTask oYn = null;
    public int type = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.m
 * JD-Core Version:    0.7.0.1
 */