package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.plugin.profile.ui.ContactInfoUI;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.a;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.a.a;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.c;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.d;
import com.tencent.mm.protocal.protobuf.ke;
import com.tencent.mm.protocal.protobuf.kf;
import com.tencent.mm.protocal.protobuf.kg;
import com.tencent.mm.protocal.protobuf.lf;
import com.tencent.mm.protocal.protobuf.uq;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

final class b$3
  implements AbsListView.OnScrollListener
{
  b$3(b paramb, ListView paramListView, int paramInt, ContactInfoUI paramContactInfoUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(153579);
    if (this.pDl.screen != null)
    {
      paramAbsListView = (NewBizInfoHeaderPreference)this.pDl.screen.atx("contact_info_header_newbizinfo");
      if (paramAbsListView != null)
      {
        int[] arrayOfInt = new int[2];
        if (paramAbsListView.pDy == null) {}
        for (paramInt1 = 0; paramInt1 < 0; paramInt1 = arrayOfInt[1])
        {
          paramInt2 = paramAbsListView.pDB.getMeasuredHeight();
          paramInt1 = (int)((1.0F - (paramInt1 + paramInt2 - this.pDn) / paramInt2) * 255.0F);
          this.pDo.setMMTitleColor(paramInt1 << 24);
          AppMethodBeat.o(153579);
          return;
          paramAbsListView.pDy.getLocationInWindow(arrayOfInt);
        }
        if (paramInt1 == 0)
        {
          this.pDo.setMMTitleColor(-16777216);
          AppMethodBeat.o(153579);
          return;
        }
        this.pDo.setMMTitleColor(0);
      }
    }
    AppMethodBeat.o(153579);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(153578);
    ArrayList localArrayList;
    if ((paramInt == 0) && (this.pDl.pDg != null))
    {
      paramAbsListView = this.pDl.pDg;
      paramInt = this.pDm.getFirstVisiblePosition();
      int i = this.pDm.getLastVisiblePosition();
      if (paramAbsListView.ccV().rU(16))
      {
        int j = paramAbsListView.ccU();
        int k = paramAbsListView.pEu;
        localArrayList = new ArrayList();
        if (paramInt <= i) {
          for (;;)
          {
            if (paramAbsListView.BN(paramInt))
            {
              int n = paramInt + (j - k);
              if (paramAbsListView.pEs.BL(n) == a.a.pEj)
              {
                lf locallf = paramAbsListView.pEs.BM(n);
                Object localObject1 = paramAbsListView.pEy.contact;
                a.f.b.j.p(localObject1, "widget.contact");
                localObject1 = ((aq)localObject1).field_username;
                long l = paramAbsListView.pEy.eaj;
                int m = paramAbsListView.pEy.gyR;
                n /= 2;
                if (locallf.wzu.nqW == 49)
                {
                  localObject2 = locallf.wzz.wxG;
                  a.f.b.j.p(localObject2, "bizMessage.AppMsg.DetailInfo");
                  Object localObject3 = (Iterable)localObject2;
                  localObject2 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject3));
                  localObject3 = ((Iterable)localObject3).iterator();
                  Object localObject4;
                  while (((Iterator)localObject3).hasNext())
                  {
                    localObject4 = (kf)((Iterator)localObject3).next();
                    ((Collection)localObject2).add(a.a.j.listOf(new String[] { ((kf)localObject4).wxi, String.valueOf(((kf)localObject4).wqp) }));
                  }
                  localArrayList.addAll((Collection)localObject2);
                  localObject2 = locallf.wzz.wxG;
                  a.f.b.j.p(localObject2, "bizMessage.AppMsg.DetailInfo");
                  localObject2 = ((Iterable)localObject2).iterator();
                  while (((Iterator)localObject2).hasNext())
                  {
                    localObject3 = (kf)((Iterator)localObject2).next();
                    localObject4 = d.pFJ;
                    a.f.b.j.p(localObject1, "userName");
                    d.a((String)localObject1, l, locallf.wzz.wxF.wxe, ((kf)localObject3).wxh, ((kf)localObject3).wqp, n, locallf.wzz.wxF.CreateTime, m);
                  }
                }
                Object localObject2 = d.pFJ;
                a.f.b.j.p(localObject1, "userName");
                d.a((String)localObject1, l, locallf.wzu.pIE, 0, -1, n, locallf.wzu.wMO, m);
              }
            }
            if (paramInt == i) {
              break;
            }
            paramInt += 1;
          }
        }
        if (((Collection)localArrayList).isEmpty()) {
          break label514;
        }
      }
    }
    label514:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        paramAbsListView.ccV().i((List)localArrayList, 126);
      }
      AppMethodBeat.o(153578);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.3
 * JD-Core Version:    0.7.0.1
 */