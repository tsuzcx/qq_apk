package com.tencent.xweb.xwalk.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.f;
import com.tencent.xweb.xwalk.b.a;
import com.tencent.xweb.xwalk.b.a.c;
import com.tencent.xweb.xwalk.b.a.d;
import com.tencent.xweb.xwalk.b.b;
import com.tencent.xweb.xwalk.b.g.c;
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
import org.xwalk.core.XWalkLibraryLoader.DownloadListener;
import org.xwalk.core.XWalkLibraryLoader.HttpDownloadTask;
import org.xwalk.core.XWalkLibraryLoader.WXFileDownloaderTask;

public final class h
  extends AsyncTask<String, Integer, Integer>
{
  private int BKA;
  private int BKB;
  private int BKC;
  boolean BKD;
  String BKs;
  g.a BKt;
  private final Object BKv;
  h.a BKw;
  private Map<String, h.b> BKx;
  private int BKy;
  private int BKz;
  
  public h()
  {
    AppMethodBeat.i(85432);
    this.BKv = new Object();
    this.BKw = new h.a();
    this.BKx = new HashMap();
    this.BKy = 0;
    this.BKz = 0;
    this.BKA = 0;
    this.BKB = 0;
    this.BKC = 0;
    this.BKD = false;
    this.BKs = "";
    this.BKt = null;
    AppMethodBeat.o(85432);
  }
  
  private void aM(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(85436);
    if (paramInt2 <= paramInt1)
    {
      Log.i("XWalkPluginUp", "status not changed, return");
      AppMethodBeat.o(85436);
      return;
    }
    Log.i("XWalkPluginUp", "change status from " + paramInt1 + " to " + paramInt2 + " errcode: " + paramInt3);
    if (eau())
    {
      if ((paramInt1 != 0) || (paramInt2 != 1)) {
        break label192;
      }
      this.BKt.eaf();
    }
    for (;;)
    {
      if (paramInt2 == 5)
      {
        f.bW(15718, this.BKw.errCode + "," + this.BKy + "," + this.BKz + "," + this.BKA + "," + this.BKB + "," + this.BKC);
        g.eat();
        this.BKD = true;
      }
      AppMethodBeat.o(85436);
      return;
      label192:
      if ((paramInt1 != 0) && (paramInt2 == 5)) {
        this.BKt.TC(paramInt3);
      }
    }
  }
  
  public final void a(HashMap<String, String> paramHashMap, String paramString, g.a parama)
  {
    AppMethodBeat.i(85433);
    if (paramHashMap != null)
    {
      paramHashMap = (String)paramHashMap.get("UpdaterCheckType");
      if ((paramHashMap != null) && (paramHashMap.equals("1"))) {
        g.pn(0L);
      }
    }
    this.BKs = paramString;
    this.BKt = parama;
    AppMethodBeat.o(85433);
  }
  
  public final boolean a(int paramInt1, int paramInt2, Map<String, h.b> paramMap)
  {
    AppMethodBeat.i(85435);
    for (;;)
    {
      Object localObject2;
      synchronized (this.BKv)
      {
        int i = this.BKw.BKF;
        if (paramInt1 > i)
        {
          this.BKw.BKF = paramInt1;
          if (paramInt2 != 1) {
            this.BKw.errCode = paramInt2;
          }
          if (this.BKw.BKF != 4) {
            break label201;
          }
          if (this.BKx.size() == 0)
          {
            this.BKw.BKF = 5;
            continue;
          }
        }
        else
        {
          paramInt1 = this.BKw.BKF;
          paramInt2 = this.BKw.errCode;
          aM(i, paramInt1, paramInt2);
          if (paramInt1 <= i) {
            break;
          }
          AppMethodBeat.o(85435);
          return true;
        }
        paramMap = this.BKx.entrySet().iterator();
        if (!paramMap.hasNext()) {
          continue;
        }
        localObject2 = (h.b)((Map.Entry)paramMap.next()).getValue();
        if ((localObject2 == null) || (((h.b)localObject2).sOs)) {
          continue;
        }
        ((h.b)localObject2).fVb.cancel(true);
      }
      label201:
      if ((this.BKw.BKF == 3) && (paramMap != null))
      {
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Object localObject3 = (Map.Entry)paramMap.next();
          localObject2 = (String)((Map.Entry)localObject3).getKey();
          localObject3 = (h.b)((Map.Entry)localObject3).getValue();
          this.BKx.put(localObject2, localObject3);
          if (((h.b)localObject3).type == 1) {
            ((XWalkLibraryLoader.HttpDownloadTask)((h.b)localObject3).fVb).execute(new Void[0]);
          } else if (((h.b)localObject3).type == 2) {
            ((XWalkLibraryLoader.WXFileDownloaderTask)((h.b)localObject3).fVb).execute(new Void[0]);
          } else {
            this.BKx.remove(localObject2);
          }
        }
        this.BKy = this.BKx.size();
      }
    }
    AppMethodBeat.o(85435);
    return false;
  }
  
  final boolean eau()
  {
    AppMethodBeat.i(85437);
    if ((this.BKs != null) && (!this.BKs.isEmpty()) && (this.BKt != null))
    {
      AppMethodBeat.o(85437);
      return true;
    }
    AppMethodBeat.o(85437);
    return false;
  }
  
  public final void fm(String paramString, int paramInt)
  {
    AppMethodBeat.i(85434);
    XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "onNotifyResult: " + paramString + " install retCode: " + paramInt);
    for (;;)
    {
      synchronized (this.BKv)
      {
        if (this.BKw.BKF == 5)
        {
          AppMethodBeat.o(85434);
          return;
        }
        switch (paramInt)
        {
        default: 
          ((h.b)this.BKx.get(paramString)).sOs = true;
          paramString = this.BKx.entrySet().iterator();
          if (!paramString.hasNext()) {
            break;
          }
          h.b localb = (h.b)((Map.Entry)paramString.next()).getValue();
          if ((localb == null) || (localb.sOs)) {
            continue;
          }
          paramInt = 0;
          int i = this.BKw.BKF;
          if (paramInt != 0)
          {
            this.BKx.clear();
            this.BKw.BKF = 5;
            if ((this.BKA > 0) || (this.BKB > 0)) {
              this.BKw.errCode = -9;
            }
          }
          paramInt = this.BKw.BKF;
          int j = this.BKw.errCode;
          aM(i, paramInt, j);
          AppMethodBeat.o(85434);
          return;
        case -3: 
          this.BKz += 1;
        }
      }
      this.BKA += 1;
      continue;
      this.BKB += 1;
      continue;
      this.BKC += 1;
      continue;
      paramInt = 1;
    }
  }
  
  protected final void onPreExecute()
  {
    AppMethodBeat.i(85438);
    a(1, 1, null);
    super.onPreExecute();
    AppMethodBeat.o(85438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.h
 * JD-Core Version:    0.7.0.1
 */