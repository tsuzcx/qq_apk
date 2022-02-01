package com.tencent.mm.plugin.sns.model;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.tn;
import com.tencent.mm.autogen.a.tn.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

class NetSceneSnsPost$3
  extends IListener<tn>
{
  NetSceneSnsPost$3(t paramt, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(309493);
    this.__eventId = tn.class.getName().hashCode();
    AppMethodBeat.o(309493);
  }
  
  private boolean a(tn paramtn)
  {
    int i = 2;
    AppMethodBeat.i(95610);
    if (!t.a(this.QsK).containsKey(paramtn.hXh.filePath))
    {
      Log.e("MicroMsg.NetSceneSnsPost", "recog succ, but not found %s", new Object[] { paramtn.hXh.filePath });
      AppMethodBeat.o(95610);
      return false;
    }
    Object localObject1 = (Integer)t.a(this.QsK).remove(paramtn.hXh.filePath);
    if (localObject1 == null)
    {
      AppMethodBeat.o(95610);
      return false;
    }
    int j = ((Integer)localObject1).intValue();
    Object localObject3;
    if (t.d(this.QsK) == 12)
    {
      localObject3 = "2,3,,";
      localObject1 = localObject3;
      if (j != 0) {}
    }
    try
    {
      localObject1 = "2,3,," + "," + URLEncoder.encode(t.e(this.QsK), "UTF-8");
      Log.i("MicroMsg.NetSceneSnsPost", "androidSystemShareFixed(13717) fileToIndex:%d,  %s", new Object[] { Integer.valueOf(j), localObject1 });
      h.OAn.kvStat(13717, (String)localObject1);
      t.f(this.QsK);
      if (t.b(this.QsK) != 0)
      {
        localObject1 = (dmz)t.c(this.QsK).get(paramtn.hXh.filePath);
        localObject3 = this.QsK;
        String str = paramtn.hXh.filePath;
        if (localObject1 != null)
        {
          paramtn = ((dmz)localObject1).aaTs;
          if (t.a(this.QsK, j) == 1) {
            i = 3;
          }
          t.a((t)localObject3, str, null, paramtn, i);
          AppMethodBeat.o(95610);
          return false;
        }
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Log.e("MicroMsg.NetSceneSnsPost", "", new Object[] { localUnsupportedEncodingException.getMessage() });
        Object localObject2 = localObject3;
        continue;
        paramtn = "";
        continue;
        localObject2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.NetSceneSnsPost.3
 * JD-Core Version:    0.7.0.1
 */