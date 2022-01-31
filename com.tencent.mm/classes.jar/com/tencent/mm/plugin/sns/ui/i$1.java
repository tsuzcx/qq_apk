package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.ui.c.a.c;
import com.tencent.mm.plugin.sns.ui.c.j;
import com.tencent.mm.plugin.sns.ui.c.j.6;
import com.tencent.mm.plugin.sns.ui.c.j.a;
import com.tencent.mm.plugin.sns.ui.c.j.b;
import com.tencent.mm.plugin.sns.ui.widget.a;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.btd;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.LinkedList;

final class i$1
  extends com.tencent.mm.plugin.sns.ui.d.b
{
  i$1(i parami, Activity paramActivity, ae paramae)
  {
    super(0, paramActivity, paramae);
  }
  
  public final void b(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 >= 0) {
      return;
    }
    new i.1.1(this, paramInt1, paramInt2, paramInt3, paramView).run();
  }
  
  public final void bE(Object paramObject)
  {
    this.oNT.oNH.a((View)paramObject, 1, 0, this.oNT.oNC);
  }
  
  public final void bHo()
  {
    if (this.oNT.owd != null) {
      this.oNT.owd.bJt();
    }
  }
  
  public final void bHp()
  {
    this.oNT.oNN.bHf();
  }
  
  public final void cT(View paramView)
  {
    int j = 0;
    paramView = (a.c)paramView.getTag();
    if (this.oNT.owd.bJq() == null) {}
    n localn;
    do
    {
      return;
      this.oNT.owd.bJq().bHw();
      new n();
      localn = this.oNT.owd.yy(paramView.position);
    } while (!localn.isValid());
    com.tencent.mm.modelsns.b localb1 = com.tencent.mm.modelsns.b.jd(741);
    bto localbto = aj.q(localn);
    com.tencent.mm.modelsns.b localb2 = localb1.ni(com.tencent.mm.plugin.sns.data.i.j(localn)).jg(localn.field_type).cb(localn.yr(32)).ni(localn.bGM()).ni(localn.field_userName);
    if (localbto == null)
    {
      i = 0;
      localb2 = localb2.jg(i);
      if (localbto != null) {
        break label222;
      }
    }
    label222:
    for (int i = j;; i = localbto.tJZ)
    {
      localb2.jg(i);
      localb1.QX();
      if ((!localn.yr(32)) || ((localn.bGe().tNr.sPK & 0x8) == 0)) {
        break label231;
      }
      this.oNT.b(paramView, localn, new btd());
      return;
      i = localbto.tJW;
      break;
    }
    label231:
    this.oNT.c(paramView, localn, new btd());
  }
  
  public final void cU(View paramView)
  {
    int j = 0;
    if ((paramView.getTag() instanceof a.c))
    {
      paramView = (a.c)paramView.getTag();
      if (this.oNT.owd.bJq() != null) {
        break label34;
      }
    }
    label34:
    n localn;
    do
    {
      return;
      this.oNT.owd.bJq().bHw();
      new n();
      localn = this.oNT.owd.yy(paramView.position);
    } while (!localn.isValid());
    com.tencent.mm.modelsns.b localb1 = com.tencent.mm.modelsns.b.jd(741);
    bto localbto = aj.q(localn);
    com.tencent.mm.modelsns.b localb2 = localb1.ni(com.tencent.mm.plugin.sns.data.i.j(localn)).jg(localn.field_type).cb(localn.yr(32)).ni(localn.bGM()).ni(localn.field_userName);
    if (localbto == null)
    {
      i = 0;
      localb2 = localb2.jg(i);
      if (localbto != null) {
        break label205;
      }
    }
    label205:
    for (int i = j;; i = localbto.tJZ)
    {
      localb2.jg(i);
      localb1.QX();
      this.oNT.a(paramView, localn, new btd());
      return;
      i = localbto.tJW;
      break;
    }
  }
  
  public final void cV(View paramView)
  {
    if (this.oNT.owd != null) {
      this.oNT.owd.da(paramView);
    }
  }
  
  public final void cW(View paramView)
  {
    a.c localc = (a.c)paramView.getTag();
    n localn = af.bDF().OB(localc.bJQ);
    if ((localn == null) || (localn.bDo()) || (i.a(this.oNT))) {
      return;
    }
    int j = 0;
    int i = j;
    Object localObject1;
    label349:
    long l;
    if (localn.yr(32))
    {
      i = j;
      if (localn.bGe().tNr.sPI == 27)
      {
        i = j;
        if ((localc.pnA instanceof j))
        {
          localObject1 = (j)localc.pnA;
          Object localObject2 = ((j.b)localc).pom;
          if (((j.a)localObject2).poj == null) {
            break label611;
          }
          Object localObject3 = ((j.a)localObject2).poi;
          localObject2 = ((j.a)localObject2).oUH;
          Object localObject4 = ((a.c)localObject3).plP;
          Object localObject6 = (j.b)localObject3;
          localObject3 = ((j.b)localObject6).pom;
          if ((((bxk)localObject4).tNr.sPI != 27) || (((bxk)localObject4).tNr.sPJ.size() < 2)) {
            break label611;
          }
          j = 0;
          if (((n)localObject2).field_likeFlag != 1) {
            break label594;
          }
          j = 1;
          i = 0;
          Object localObject5 = (awd)((bxk)localObject4).tNr.sPJ.get(j);
          ((bxk)localObject4).tNr.sPJ.get(i);
          localObject4 = ((j.b)localObject6).pok;
          localObject5 = j.m(((j.b)localObject6).pok, j, ((awd)localObject5).hQR);
          localObject6 = j.m(((j.b)localObject6).pok, i, 2);
          int[] arrayOfInt = new int[2];
          ((View)localObject4).getLocationOnScreen(arrayOfInt);
          ((View)localObject4).setPivotY(((j)localObject1).mScreenHeight / 2 - arrayOfInt[1]);
          ((View)localObject4).setCameraDistance(8000.0F);
          float f1 = ((View)localObject4).getWidth() / 2.0F;
          float f2 = ((View)localObject4).getHeight() / 2.0F;
          if (((n)localObject2).field_likeFlag != 1) {
            break label600;
          }
          j = -90;
          i = 90;
          localObject2 = new a(((View)localObject4).getContext(), 0.0F, i, f1, f2, true);
          ((a)localObject2).setDuration(187L);
          ((a)localObject2).setInterpolator(new AccelerateInterpolator());
          ((a)localObject2).setAnimationListener(new j.6((j)localObject1, (View)localObject6, (View)localObject5, (j.a)localObject3, (View)localObject4, j, f1, f2));
          ((View)localObject4).startAnimation((Animation)localObject2);
          i = 374;
          label428:
          if (localn.field_likeFlag == 0) {
            this.oNT.oNB.fH(localc.pmA);
          }
          if ((localn.bGe().tNr.sPJ.size() > ((j.b)localc).pom.index) && (((awd)localn.bGe().tNr.sPJ.get(((j.b)localc).pom.index)).hQR == 6))
          {
            localObject1 = this.oNT.oNB;
            l = localc.pmA;
            if (((j.b)localc).pom.index <= 0) {
              break label617;
            }
          }
        }
      }
    }
    label594:
    label600:
    label611:
    label617:
    for (boolean bool = true;; bool = false)
    {
      ((g)localObject1).t(l, bool);
      i.a(this.oNT, true);
      new ah().postDelayed(new i.1.2(this, localn, localc, paramView), i);
      return;
      i = 1;
      break;
      j = 90;
      i = -90;
      break label349;
      i = 0;
      break label428;
    }
  }
  
  public final void cX(View paramView)
  {
    this.oNT.oNM.bHw();
    this.oNT.oNN.hqp = true;
    this.oNT.oNN.cS(paramView);
  }
  
  public final void cY(View paramView)
  {
    this.oNT.oNN.bEx();
    if (paramView.getTag() != null)
    {
      paramView = (com.tencent.mm.plugin.sns.data.b)paramView.getTag();
      this.oNT.oNB.h(paramView.position, paramView.bJQ, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.i.1
 * JD-Core Version:    0.7.0.1
 */