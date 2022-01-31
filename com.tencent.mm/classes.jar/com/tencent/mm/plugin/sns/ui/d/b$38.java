package com.tencent.mm.plugin.sns.ui.d;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.tools.MaskImageButton;

final class b$38
  implements View.OnClickListener
{
  b$38(b paramb) {}
  
  public final void onClick(View paramView)
  {
    int m = 6;
    boolean bool = false;
    int k = 1;
    String str = (String)paramView.getTag();
    y.d("MicroMsg.TimelineClickListener", "onCommentClick:" + str);
    Intent localIntent = new Intent();
    Object localObject;
    int j;
    int i;
    if (((paramView instanceof MaskImageButton)) && (((MaskImageButton)paramView).wdF != null))
    {
      paramView = (String)((MaskImageButton)paramView).wdF;
      paramView = af.bDF().OB(paramView);
      if (paramView.yr(32))
      {
        localObject = paramView.bFZ();
        j = this.ppl.source;
        if (this.ppl.source == 0)
        {
          i = 1;
          i.a(new SnsAdClick(j, i, paramView.field_snsId, 1, 0));
          if ((localObject == null) || (((com.tencent.mm.plugin.sns.storage.b)localObject).oAQ != 1) || (bk.bl(((com.tencent.mm.plugin.sns.storage.b)localObject).oAR))) {
            break label312;
          }
          str = ((com.tencent.mm.plugin.sns.storage.b)localObject).oAR;
          y.i("MicroMsg.TimelineClickListener", "headClickParam url " + str + " " + ((com.tencent.mm.plugin.sns.storage.b)localObject).oAS);
          localIntent = new Intent();
          if (((com.tencent.mm.plugin.sns.storage.b)localObject).oAS == 0) {
            bool = true;
          }
          localIntent.putExtra("KsnsViewId", b.a(this.ppl, paramView).fVM);
          localIntent.putExtra("KRightBtn", bool);
          localIntent.putExtra("jsapiargs", new Bundle());
          localIntent.putExtra("rawUrl", str);
          localIntent.putExtra("useJs", true);
          com.tencent.mm.plugin.sns.c.a.eUR.j(localIntent, this.ppl.activity);
        }
      }
    }
    for (;;)
    {
      return;
      i = 2;
      break;
      label312:
      i = 1;
      while (!str.endsWith("@ad"))
      {
        if (paramView != null)
        {
          if (this.ppl.source != 0) {
            break label510;
          }
          if (paramView.yr(32))
          {
            j = 722;
            localObject = com.tencent.mm.modelsns.b.jd(j);
            ((com.tencent.mm.modelsns.b)localObject).ni(i.j(paramView)).jg(paramView.field_type).cb(paramView.yr(32)).ni(paramView.bGM()).ni(str);
            ((com.tencent.mm.modelsns.b)localObject).QX();
          }
        }
        else
        {
          if (i == 0) {
            break label544;
          }
          j = this.ppl.source;
          if (this.ppl.source != 0) {
            break label539;
          }
        }
        label539:
        for (i = 1;; i = 2)
        {
          paramView = new SnsAdClick(j, i, paramView.field_snsId, 1, 0);
          localIntent.putExtra("Contact_User", str);
          localIntent.putExtra("KSnsAdTag", paramView);
          i = k;
          if (this.ppl.source == 0) {
            i = 6;
          }
          localIntent.putExtra("CONTACT_INFO_UI_SOURCE", i);
          com.tencent.mm.plugin.sns.c.a.eUR.d(localIntent, this.ppl.activity);
          return;
          j = 721;
          break;
          label510:
          if (paramView.yr(32)) {}
          for (j = 722;; j = 721)
          {
            localObject = com.tencent.mm.modelsns.b.je(j);
            break;
          }
        }
        label544:
        this.ppl.oOe.bDk().a(paramView, true);
        if (this.ppl.source == 0)
        {
          paramView = com.tencent.mm.modelsns.b.jd(746);
          localObject = q.Gj();
          paramView.ni(str).cb(str.endsWith((String)localObject));
          paramView.b(localIntent, "intent_key_StatisticsOplog");
          if (this.ppl.source != 0) {
            break label668;
          }
        }
        label668:
        for (i = m;; i = 1)
        {
          localIntent.putExtra("CONTACT_INFO_UI_SOURCE", i);
          localIntent.putExtra("Contact_User", str);
          com.tencent.mm.plugin.sns.c.a.eUR.d(localIntent, this.ppl.activity);
          return;
          paramView = com.tencent.mm.modelsns.b.je(746);
          break;
        }
        i = 0;
        continue;
        paramView = null;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.38
 * JD-Core Version:    0.7.0.1
 */