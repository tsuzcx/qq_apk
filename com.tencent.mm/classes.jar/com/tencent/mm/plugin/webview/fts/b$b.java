package com.tencent.mm.plugin.webview.fts;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.c.avi;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

final class b$b
{
  String bOE;
  boolean eyC = false;
  String jfE;
  long qZk;
  long qZl;
  private String qZm = null;
  int scene;
  int type;
  
  private b$b(b paramb) {}
  
  final String caz()
  {
    if (this.qZm == null) {
      this.qZm = "";
    }
    try
    {
      JSONArray localJSONArray = new JSONObject(this.bOE).optJSONObject("data").optJSONObject("hotwords").optJSONArray("items");
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < localJSONArray.length())
      {
        localArrayList.add(Uri.encode(localJSONArray.optJSONObject(i).optString("hotword")));
        i += 1;
      }
      this.qZm = TextUtils.join("|", localArrayList);
    }
    catch (Exception localException)
    {
      label93:
      break label93;
    }
    return this.qZm;
  }
  
  final void eD(int paramInt1, int paramInt2)
  {
    avi localavi = new avi();
    au.Hx();
    Object localObject1 = c.FJ();
    Object localObject2 = b.p(paramInt1, paramInt2, false);
    if (!((String)localObject2).equals(b.p(paramInt1, paramInt2, true))) {
      this.eyC = true;
    }
    localObject1 = new File((String)localObject1, (String)localObject2);
    localObject2 = e.c(((File)localObject1).getAbsolutePath(), 0, (int)((File)localObject1).length());
    if (localObject2 != null) {}
    try
    {
      localavi.aH((byte[])localObject2);
      this.scene = localavi.scene;
      this.bOE = localavi.sEb;
      this.qZk = localavi.tqP;
      this.qZl = localavi.tqQ;
      this.jfE = localavi.sFF;
      this.type = localavi.hQR;
      y.i("MicroMsg.FTS.FTSWebViewLogic", "load bizCacheFile %s %d", new Object[] { ((File)localObject1).getAbsolutePath(), Integer.valueOf(localObject2.length) });
      return;
    }
    catch (IOException localIOException) {}
  }
  
  final boolean isAvailable()
  {
    if (this.eyC) {}
    while ((bk.bl(this.bOE)) || (System.currentTimeMillis() / 1000L - this.qZl > this.qZk)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.b.b
 * JD-Core Version:    0.7.0.1
 */