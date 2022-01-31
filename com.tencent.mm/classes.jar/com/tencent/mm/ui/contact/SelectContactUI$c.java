package com.tencent.mm.ui.contact;

import android.app.ProgressDialog;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.at.l;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

final class SelectContactUI$c
  implements Runnable
{
  private ArrayList<String> Afs;
  private WeakReference<SelectContactUI> bJz;
  
  private SelectContactUI$c(SelectContactUI paramSelectContactUI, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(153972);
    this.bJz = new WeakReference(paramSelectContactUI);
    this.Afs = paramArrayList;
    AppMethodBeat.o(153972);
  }
  
  public final void run()
  {
    AppMethodBeat.i(153973);
    SelectContactUI localSelectContactUI = (SelectContactUI)this.bJz.get();
    if (localSelectContactUI == null)
    {
      AppMethodBeat.o(153973);
      return;
    }
    String str = r.Zn();
    Object localObject1 = null;
    int i = 0;
    Iterator localIterator = this.Afs.iterator();
    if (localIterator.hasNext())
    {
      Object localObject2 = (String)localIterator.next();
      ab.d("MicroMsg.SelectContactUI", "toSend, %s", new Object[] { localObject2 });
      if (t.lA((String)localObject2)) {}
      for (int j = 1;; j = 0)
      {
        localObject2 = new l(4, str, (String)localObject2, localSelectContactUI.getIntent().getStringExtra("shareImagePath"), 0, null, 0, "", (String)localObject1, true, 2130838228);
        aw.Rc().a((m)localObject2, 0);
        if (((l)localObject2).cmQ != null) {
          localObject1 = ((l)localObject2).cmQ.field_imgPath;
        }
        i += j;
        break;
      }
    }
    SelectContactUI.g(localSelectContactUI).dismiss();
    localObject1 = new Intent();
    ((Intent)localObject1).putStringArrayListExtra("Select_Contact", this.Afs);
    localSelectContactUI.setResult(-1, (Intent)localObject1);
    h.qsU.e(11048, new Object[] { Integer.valueOf(1), Integer.valueOf(this.Afs.size() - i), Integer.valueOf(i) });
    localSelectContactUI.finish();
    AppMethodBeat.o(153973);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI.c
 * JD-Core Version:    0.7.0.1
 */