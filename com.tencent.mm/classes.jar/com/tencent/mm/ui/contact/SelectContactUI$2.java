package com.tencent.mm.ui.contact;

import android.app.ProgressDialog;
import android.content.Intent;
import com.tencent.mm.R.g;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.as.l;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;

final class SelectContactUI$2
  implements Runnable
{
  SelectContactUI$2(SelectContactUI paramSelectContactUI, ArrayList paramArrayList) {}
  
  public final void run()
  {
    String str = q.Gj();
    Iterator localIterator = this.vND.iterator();
    int i = 0;
    Object localObject1 = null;
    if (localIterator.hasNext())
    {
      Object localObject2 = (String)localIterator.next();
      y.d("MicroMsg.SelectContactUI", "toSend, %s", new Object[] { localObject2 });
      if (s.fn((String)localObject2)) {}
      for (int j = 1;; j = 0)
      {
        localObject2 = new l(4, str, (String)localObject2, this.vNB.getIntent().getStringExtra("shareImagePath"), 0, null, 0, "", (String)localObject1, true, R.g.chat_img_template);
        au.Dk().a((m)localObject2, 0);
        if (((l)localObject2).bFH != null) {
          localObject1 = ((l)localObject2).bFH.field_imgPath;
        }
        i += j;
        break;
      }
    }
    SelectContactUI.f(this.vNB).dismiss();
    localObject1 = new Intent();
    ((Intent)localObject1).putStringArrayListExtra("Select_Contact", this.vND);
    this.vNB.setResult(-1, (Intent)localObject1);
    h.nFQ.f(11048, new Object[] { Integer.valueOf(1), Integer.valueOf(this.vND.size() - i), Integer.valueOf(i) });
    this.vNB.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI.2
 * JD-Core Version:    0.7.0.1
 */