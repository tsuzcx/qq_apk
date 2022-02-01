package com.tencent.mm.plugin.sns.model;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.to;
import com.tencent.mm.autogen.a.to.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.o;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

class NetSceneSnsPost$2
  extends IListener<to>
{
  NetSceneSnsPost$2(t paramt, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(309488);
    this.__eventId = to.class.getName().hashCode();
    AppMethodBeat.o(309488);
  }
  
  private boolean a(to paramto)
  {
    AppMethodBeat.i(95608);
    if (!t.a(this.QsK).containsKey(paramto.hXi.filePath))
    {
      Log.e("MicroMsg.NetSceneSnsPost", "recog succ, but not found %s", new Object[] { paramto.hXi.filePath });
      AppMethodBeat.o(95608);
      return false;
    }
    i = ((Integer)t.a(this.QsK).remove(paramto.hXi.filePath)).intValue();
    localObject5 = "";
    localObject2 = "";
    localObject1 = localObject2;
    try
    {
      localObject6 = o.YtW;
      localObject1 = localObject2;
      localObject2 = o.d(paramto);
      localObject1 = localObject2;
      localObject6 = URLEncoder.encode((String)localObject2, "UTF-8");
      localObject1 = localObject6;
      localObject5 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject5;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException1)
    {
      try
      {
        String str1;
        String str2;
        o localo;
        localObject2 = (String)localObject6 + "," + URLEncoder.encode(t.e(this.QsK), "UTF-8");
        Log.i("MicroMsg.NetSceneSnsPost", "androidSystemShareFixed(13717) fileToIndex:%d,  %s", new Object[] { Integer.valueOf(i), localObject2 });
        h.OAn.kvStat(13717, (String)localObject2);
        t.f(this.QsK);
        localObject2 = this.QsK;
        localObject6 = paramto.hXi.filePath;
        if (localObject5 == null) {
          break label451;
        }
        paramto = ((dmz)localObject5).aaTs;
        if (t.a(this.QsK, i) != 1) {
          break label457;
        }
        i = 3;
        t.a((t)localObject2, (String)localObject6, localObject1, paramto, i);
        AppMethodBeat.o(95608);
        return false;
        localUnsupportedEncodingException1 = localUnsupportedEncodingException1;
        Log.printErrStackTrace("MicroMsg.NetSceneSnsPost", localUnsupportedEncodingException1, "", new Object[0]);
        Object localObject3 = localObject5;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        for (;;)
        {
          Object localObject6;
          Log.e("MicroMsg.NetSceneSnsPost", "", new Object[] { localUnsupportedEncodingException2.getMessage() });
          Object localObject4 = localObject6;
          continue;
          paramto = "";
          continue;
          i = 2;
        }
      }
    }
    localObject5 = null;
    if (t.b(this.QsK) != 0)
    {
      localObject5 = (dmz)t.c(this.QsK).get(paramto.hXi.filePath);
      localObject6 = this.QsK;
      str1 = ((dmz)localObject5).aaTy;
      str2 = ((dmz)localObject5).Url;
      localo = o.YtW;
      t.a((t)localObject6, String.format("position=%d&qrUrl=%s&md5=%s&imgUrl=%s&codeType=%d|", new Object[] { Integer.valueOf(i), localObject2, str1, str2, Integer.valueOf(o.e(paramto)) }));
    }
    if (t.d(this.QsK) == 12)
    {
      localObject6 = "2,3,,".concat(String.valueOf(localObject2));
      localObject2 = localObject6;
      if (i != 0) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.NetSceneSnsPost.2
 * JD-Core Version:    0.7.0.1
 */