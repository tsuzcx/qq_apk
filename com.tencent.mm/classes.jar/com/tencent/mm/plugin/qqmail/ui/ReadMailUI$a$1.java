package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.qqmail.b.v;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.Map;

final class ReadMailUI$a$1
  implements Runnable
{
  ReadMailUI$a$1(ReadMailUI.a parama, Map paramMap) {}
  
  public final void run()
  {
    AppMethodBeat.i(68439);
    Object localObject1;
    Object localObject2;
    if (ReadMailUI.b(this.pPh.pOX).equals(ReadMailUI.a(this.pPh.pOX)))
    {
      if (ReadMailUI.c(this.pPh.pOX).getSize() == 0)
      {
        i = bo.getInt((String)this.pPg.get(".Response.result.tolistlen"), 0);
        localObject1 = ReadMailUI.c(this.pPg, ".Response.result.tolist", i);
        ReadMailUI.c(this.pPh.pOX).b((String[])localObject1, true);
      }
      if (ReadMailUI.d(this.pPh.pOX).getSize() == 0)
      {
        i = bo.getInt((String)this.pPg.get(".Response.result.cclistlen"), 0);
        localObject1 = ReadMailUI.c(this.pPg, ".Response.result.cclist", i);
        localObject2 = ReadMailUI.e(this.pPh.pOX);
        if ((localObject1 != null) && (localObject1.length != 0)) {
          break label404;
        }
      }
    }
    label404:
    for (int i = 8;; i = 0)
    {
      ((LinearLayout)localObject2).setVisibility(i);
      ReadMailUI.d(this.pPh.pOX).b((String[])localObject1, true);
      localObject1 = (String)this.pPg.get(".Response.result.content");
      ReadMailUI.a(this.pPh.pOX, this.pPg);
      localObject2 = (String)this.pPg.get(".Response.result.tips.wording");
      if (!bo.isNullOrNil((String)localObject2))
      {
        if ("1".equals((String)this.pPg.get(".Response.result.tips.color")))
        {
          ReadMailUI.f(this.pPh.pOX).setBackgroundColor(-13627);
          ReadMailUI.f(this.pPh.pOX).setTextColor(-7515315);
        }
        ReadMailUI.f(this.pPh.pOX).setText((CharSequence)localObject2);
        ((View)ReadMailUI.f(this.pPh.pOX).getParent()).setVisibility(0);
      }
      localObject1 = "<html style=\"margin-top:" + ReadMailUI.aUG() + "px\">" + (String)localObject1 + "</html>";
      ReadMailUI.g(this.pPh.pOX).loadDataWithBaseURL(v.cdK() + "?pageWidth=" + ReadMailUI.ceD(), (String)localObject1, "text/html", "utf-8", null);
      AppMethodBeat.o(68439);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI.a.1
 * JD-Core Version:    0.7.0.1
 */