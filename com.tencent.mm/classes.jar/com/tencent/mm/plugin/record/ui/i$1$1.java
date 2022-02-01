package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.content.res.Resources;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.a.yd;
import com.tencent.mm.g.a.yd.a;
import com.tencent.mm.plugin.record.b.w;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class i$1$1
  implements Runnable
{
  i$1$1(i.1 param1, String paramString, int paramInt, yd paramyd) {}
  
  public final void run()
  {
    AppMethodBeat.i(27994);
    try
    {
      Object localObject2 = this.BIJ.BIH.Vx(new Integer(this.val$id).intValue());
      if (localObject2 == null)
      {
        AppMethodBeat.o(27994);
        return;
      }
      if (this.qQL == 0)
      {
        ((w)localObject2).BHr = Util.escapeSqlValue(this.BII.eey.eez);
        ((w)localObject2).brand = Util.escapeSqlValue(Util.nullAsNil(this.BII.eey.ecu));
        if (this.BII.eey.ees == null) {}
        final int i;
        int j;
        for (Object localObject1 = new byte[0];; localObject1 = this.BII.eey.ees)
        {
          ((w)localObject2).AqP = new b((byte[])localObject1);
          ((w)localObject2).eeA = this.BII.eey.eeA;
          ((w)localObject2).status = 2;
          this.BIJ.BIH.BIB.notifyDataSetChanged();
          if (!this.BIJ.BIH.BID) {
            break label472;
          }
          i = ((w)localObject2).id + 1;
          j = this.BIJ.BIH.BIC.BHs.size();
          if (i < j) {
            break;
          }
          AppMethodBeat.o(27994);
          return;
        }
        i locali = this.BIJ.BIH;
        localObject2 = ((aml)this.BIJ.BIH.BIC.BHs.get(i)).desc;
        boolean bool = Util.isNullOrNil((String)localObject2);
        if (bool) {
          bool = false;
        }
        while (!bool)
        {
          AppMethodBeat.o(27994);
          return;
          j = ((String)localObject2).indexOf(':');
          localObject1 = localObject2;
          if (j != -1) {
            localObject1 = ((String)localObject2).substring(j + 1);
          }
          if (LocaleUtil.isChineseAppLang()) {
            bool = locali.BIF.matcher((CharSequence)localObject1).find();
          } else {
            bool = locali.BIG.matcher((CharSequence)localObject1).find();
          }
        }
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(232046);
            i.1.1.this.BIJ.BIH.aK(i, false);
            AppMethodBeat.o(232046);
          }
        });
        AppMethodBeat.o(27994);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.TranslateHelper", "translateListener id:%s Exception:%s %s", new Object[] { Util.nullAs(this.val$id, ""), localException.getClass().getSimpleName(), localException.getMessage() });
      AppMethodBeat.o(27994);
      return;
    }
    if (this.qQL == 3) {
      h.cD(this.BIJ.BIH.context, this.BIJ.BIH.context.getResources().getString(2131757544));
    }
    for (;;)
    {
      this.BIJ.BIH.BIB.notifyDataSetChanged();
      label472:
      AppMethodBeat.o(27994);
      return;
      if (this.qQL != 5) {
        h.cD(this.BIJ.BIH.context, this.BIJ.BIH.context.getResources().getString(2131757539));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.i.1.1
 * JD-Core Version:    0.7.0.1
 */