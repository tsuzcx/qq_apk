package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.c.a.c;
import com.tencent.mm.protocal.c.btd;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.ui.base.n.d;

public final class i$a
  implements View.OnClickListener
{
  private String dtK;
  private a.c oNj;
  private CharSequence oOa = "";
  private btd oqc;
  
  public i$a(i parami, btd parambtd, String paramString, CharSequence paramCharSequence, a.c paramc)
  {
    this.dtK = paramString;
    this.oqc = parambtd;
    this.oNj = paramc;
    this.oOa = paramCharSequence;
  }
  
  public final void onClick(View paramView)
  {
    int j = 0;
    if (!v.OW(this.oNj.bRV)) {}
    do
    {
      return;
      this.oNj.pmT = paramView;
      if ((this.oqc != null) && (this.oqc.sxM != null) && (this.oqc.sxM.equals(this.oNT.diG))) {
        break;
      }
      new n();
      localObject1 = this.oNT.owd.yy(this.oNj.position);
    } while (((n)localObject1).bDo());
    if (!m.k((n)localObject1))
    {
      com.tencent.mm.plugin.sns.lucky.ui.a.e(this.oNj.pmZ.getContext(), this.oNj.pmZ.yD(0));
      return;
    }
    Object localObject2 = b.jd(742);
    Object localObject3 = aj.q((n)localObject1);
    Object localObject4 = ((b)localObject2).ni(com.tencent.mm.plugin.sns.data.i.j((n)localObject1)).jg(((n)localObject1).field_type).cb(((n)localObject1).yr(32)).ni(((n)localObject1).bGM());
    if (this.oqc.tJu == 0)
    {
      paramView = this.oqc.tJx;
      paramView = ((b)localObject4).ni(paramView).ni(this.oqc.sxM);
      if (localObject3 != null) {
        break label338;
      }
      i = 0;
      label238:
      paramView = paramView.jg(i);
      if (localObject3 != null) {
        break label347;
      }
    }
    label338:
    label347:
    for (int i = j;; i = ((bto)localObject3).tJZ)
    {
      paramView.jg(i);
      ((b)localObject2).QX();
      this.oNT.a(this.oNj, (n)localObject1, i.c(this.oNT).getString(i.j.sns_reply) + this.dtK, this.oqc);
      return;
      paramView = this.oqc.tJu;
      break;
      i = ((bto)localObject3).tJW;
      break label238;
    }
    if (this.oNT.oNG.pkp)
    {
      this.oNT.bHn();
      this.oNT.oNG.pkp = false;
    }
    localObject2 = new com.tencent.mm.ui.widget.b.a(i.c(this.oNT));
    localObject3 = new i.a.1(this);
    localObject4 = new i.a.2(this);
    Object localObject1 = new int[2];
    if ((paramView.getTag(i.f.touch_loc) instanceof int[])) {
      localObject1 = (int[])paramView.getTag(i.f.touch_loc);
    }
    ((com.tencent.mm.ui.widget.b.a)localObject2).a(paramView, (View.OnCreateContextMenuListener)localObject3, (n.d)localObject4, localObject1[0], localObject1[1]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.i.a
 * JD-Core Version:    0.7.0.1
 */