package com.tencent.xweb.xwalk.plugin;

import android.os.AsyncTask;
import com.tencent.xweb.util.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkLibraryLoader.HttpDownloadTask;
import org.xwalk.core.XWalkLibraryLoader.WXFileDownloaderTask;

public final class d
  extends AsyncTask<String, Integer, Integer>
{
  private Map<String, d.b> xmA = new HashMap();
  private int xmB = 0;
  private int xmC = 0;
  private int xmD = 0;
  private int xmE = 0;
  private int xmF = 0;
  boolean xmG = false;
  String xmt = "";
  c.b xmu = null;
  private final Object xmy = new Object();
  d.a xmz = new d.a();
  
  private void aA(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 <= paramInt1) {
      Log.i("XWalkPluginUp", "status not changed, return");
    }
    for (;;)
    {
      return;
      Log.i("XWalkPluginUp", "change status from " + paramInt1 + " to " + paramInt2 + " errcode: " + paramInt3);
      if (cTJ())
      {
        if ((paramInt1 != 0) || (paramInt2 != 1)) {
          break label177;
        }
        this.xmu.cTC();
      }
      while (paramInt2 == 5)
      {
        e.bp(15718, this.xmz.errCode + "," + this.xmB + "," + this.xmC + "," + this.xmD + "," + this.xmE + "," + this.xmF);
        c.cTI();
        this.xmG = true;
        return;
        label177:
        if ((paramInt1 != 0) && (paramInt2 == 5)) {
          this.xmu.KH(paramInt3);
        }
      }
    }
  }
  
  public final boolean a(int paramInt1, int paramInt2, Map<String, d.b> paramMap)
  {
    for (;;)
    {
      Object localObject2;
      synchronized (this.xmy)
      {
        int i = this.xmz.xmI;
        if (paramInt1 > i)
        {
          this.xmz.xmI = paramInt1;
          if (paramInt2 != 1) {
            this.xmz.errCode = paramInt2;
          }
          if (this.xmz.xmI != 4) {
            break label186;
          }
          if (this.xmA.size() == 0)
          {
            this.xmz.xmI = 5;
            continue;
          }
        }
        else
        {
          paramInt1 = this.xmz.xmI;
          paramInt2 = this.xmz.errCode;
          aA(i, paramInt1, paramInt2);
          if (paramInt1 <= i) {
            break;
          }
          return true;
        }
        paramMap = this.xmA.entrySet().iterator();
        if (!paramMap.hasNext()) {
          continue;
        }
        localObject2 = (d.b)((Map.Entry)paramMap.next()).getValue();
        if ((localObject2 == null) || (((d.b)localObject2).xmJ)) {
          continue;
        }
        ((d.b)localObject2).eFk.cancel(true);
      }
      label186:
      if ((this.xmz.xmI == 3) && (paramMap != null))
      {
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Object localObject3 = (Map.Entry)paramMap.next();
          localObject2 = (String)((Map.Entry)localObject3).getKey();
          localObject3 = (d.b)((Map.Entry)localObject3).getValue();
          this.xmA.put(localObject2, localObject3);
          if (((d.b)localObject3).type == 1) {
            ((XWalkLibraryLoader.HttpDownloadTask)((d.b)localObject3).eFk).execute(new Void[0]);
          } else if (((d.b)localObject3).type == 2) {
            ((XWalkLibraryLoader.WXFileDownloaderTask)((d.b)localObject3).eFk).execute(new Void[0]);
          } else {
            this.xmA.remove(localObject2);
          }
        }
        this.xmB = this.xmA.size();
      }
    }
    return false;
  }
  
  final boolean cTJ()
  {
    return (this.xmt != null) && (!this.xmt.isEmpty()) && (this.xmu != null);
  }
  
  public final void ec(String paramString, int paramInt)
  {
    XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "onNotifyResult: " + paramString + " install retCode: " + paramInt);
    for (;;)
    {
      synchronized (this.xmy)
      {
        if (this.xmz.xmI != 5) {
          break label275;
        }
        return;
        ((d.b)this.xmA.get(paramString)).xmJ = true;
        paramString = this.xmA.entrySet().iterator();
        if (!paramString.hasNext()) {
          break label270;
        }
        d.b localb = (d.b)((Map.Entry)paramString.next()).getValue();
        if ((localb == null) || (localb.xmJ)) {
          continue;
        }
        paramInt = 0;
        int i = this.xmz.xmI;
        if (paramInt != 0)
        {
          this.xmA.clear();
          this.xmz.xmI = 5;
          if ((this.xmD > 0) || (this.xmE > 0)) {
            this.xmz.errCode = -9;
          }
        }
        paramInt = this.xmz.xmI;
        int j = this.xmz.errCode;
        aA(i, paramInt, j);
        return;
        this.xmC += 1;
      }
      this.xmD += 1;
      continue;
      this.xmE += 1;
      continue;
      this.xmF += 1;
      continue;
      label270:
      paramInt = 1;
      continue;
      label275:
      switch (paramInt)
      {
      }
    }
  }
  
  protected final void onPreExecute()
  {
    a(1, 1, null);
    super.onPreExecute();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.xweb.xwalk.plugin.d
 * JD-Core Version:    0.7.0.1
 */