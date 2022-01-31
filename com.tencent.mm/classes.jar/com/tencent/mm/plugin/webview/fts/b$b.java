package com.tencent.mm.plugin.webview.fts;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.protocal.protobuf.bbt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

final class b$b
{
  String cvV;
  boolean fOq = false;
  private String hRx = null;
  String low;
  int scene;
  int type;
  long uOR;
  long uOS;
  
  private b$b(b paramb) {}
  
  final String daz()
  {
    AppMethodBeat.i(5683);
    if (this.hRx == null) {
      this.hRx = "";
    }
    try
    {
      localObject = new JSONObject(this.cvV).optJSONObject("data").optJSONObject("hotwords").optJSONArray("items");
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        localArrayList.add(Uri.encode(((JSONArray)localObject).optJSONObject(i).optString("hotword")));
        i += 1;
      }
      this.hRx = TextUtils.join("|", localArrayList);
    }
    catch (Exception localException)
    {
      Object localObject;
      label99:
      break label99;
    }
    localObject = this.hRx;
    AppMethodBeat.o(5683);
    return localObject;
  }
  
  final void gH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(5684);
    bbt localbbt = new bbt();
    Object localObject1 = com.tencent.mm.plugin.record.b.YN();
    Object localObject2 = b.s(paramInt1, paramInt2, false);
    if (!((String)localObject2).equals(b.s(paramInt1, paramInt2, true))) {
      this.fOq = true;
    }
    localObject1 = new File((String)localObject1, (String)localObject2);
    localObject2 = e.i(((File)localObject1).getAbsolutePath(), 0, (int)((File)localObject1).length());
    if (localObject2 != null) {
      try
      {
        localbbt.parseFrom((byte[])localObject2);
        this.scene = localbbt.scene;
        this.cvV = localbbt.wAa;
        this.uOR = localbbt.xqP;
        this.uOS = localbbt.xqQ;
        this.low = localbbt.wBZ;
        this.type = localbbt.jKs;
        ab.i("MicroMsg.WebSearch.FTSWebViewLogic", "load bizCacheFile %s %d", new Object[] { ((File)localObject1).getAbsolutePath(), Integer.valueOf(localObject2.length) });
        AppMethodBeat.o(5684);
        return;
      }
      catch (IOException localIOException) {}
    }
    AppMethodBeat.o(5684);
  }
  
  final boolean isAvailable()
  {
    AppMethodBeat.i(5682);
    if (this.fOq)
    {
      AppMethodBeat.o(5682);
      return false;
    }
    if ((bo.isNullOrNil(this.cvV)) || (System.currentTimeMillis() / 1000L - this.uOS > this.uOR))
    {
      AppMethodBeat.o(5682);
      return false;
    }
    AppMethodBeat.o(5682);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.b.b
 * JD-Core Version:    0.7.0.1
 */