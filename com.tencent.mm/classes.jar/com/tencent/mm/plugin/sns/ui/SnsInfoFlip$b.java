package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.g.a.ro;
import com.tencent.mm.modelcontrol.c;
import com.tencent.mm.network.ac;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.f;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class SnsInfoFlip$b
  extends BaseAdapter
{
  private Context context;
  private String fnF;
  private boolean kYY;
  private int rEf;
  private boolean rRH;
  Map<String, WeakReference<View>> rRI;
  private String rRJ;
  
  public SnsInfoFlip$b(SnsInfoFlip paramSnsInfoFlip, Context paramContext)
  {
    AppMethodBeat.i(38974);
    this.rEf = 0;
    this.rRH = false;
    this.fnF = "";
    this.kYY = true;
    this.rRI = new HashMap();
    this.context = paramContext;
    this.rRH = f.dDB();
    this.rEf = SnsInfoFlip.j(paramSnsInfoFlip).size();
    c.afT();
    this.kYY = c.afV();
    AppMethodBeat.o(38974);
  }
  
  private void EQ(int paramInt)
  {
    AppMethodBeat.i(38976);
    bcs localbcs = ((com.tencent.mm.plugin.sns.h.b)SnsInfoFlip.j(this.rRB).get(paramInt)).cIc;
    az localaz = az.a(this.rRB.rbm, ((com.tencent.mm.plugin.sns.h.b)SnsInfoFlip.j(this.rRB).get(paramInt)).fDT);
    if (localbcs.jKs != 2)
    {
      AppMethodBeat.o(38976);
      return;
    }
    boolean bool = v.abN(((com.tencent.mm.plugin.sns.h.b)SnsInfoFlip.j(this.rRB).get(paramInt)).rlJ);
    ag.cpc();
    bool = com.tencent.mm.plugin.sns.model.g.a(localbcs, localaz, bool);
    if ((SnsInfoFlip.k(this.rRB)) && (!bool)) {
      SnsInfoFlip.a(this.rRB, localbcs.Id);
    }
    AppMethodBeat.o(38976);
  }
  
  public final void ER(int paramInt)
  {
    AppMethodBeat.i(38980);
    Object localObject1 = (com.tencent.mm.plugin.sns.h.b)SnsInfoFlip.j(this.rRB).get(paramInt);
    if (localObject1 == null)
    {
      ab.w("MicroMsg.SnsInfoFlip", "notify online sight play, but flip item is null.");
      AppMethodBeat.o(38980);
      return;
    }
    String str = ((com.tencent.mm.plugin.sns.h.b)localObject1).rlJ;
    if (bo.isNullOrNil(str))
    {
      ab.w("MicroMsg.SnsInfoFlip", "notify online sight play, but sns local id is null.");
      AppMethodBeat.o(38980);
      return;
    }
    ab.i("MicroMsg.SnsInfoFlip", "notify online sight play pos %s sns local id %s", new Object[] { Integer.valueOf(paramInt), str });
    Object localObject2 = (WeakReference)this.rRI.get(str);
    if (localObject2 == null)
    {
      ab.w("MicroMsg.SnsInfoFlip", "notify online sight play, but view cache is null ");
      this.rRJ = str;
      AppMethodBeat.o(38980);
      return;
    }
    localObject2 = (OnlineVideoView)((WeakReference)localObject2).get();
    if (localObject2 == null)
    {
      ab.w("MicroMsg.SnsInfoFlip", "online sight view is null, do nothing. snsLocalId %s", new Object[] { str });
      this.rRJ = str;
      AppMethodBeat.o(38980);
      return;
    }
    ab.i("MicroMsg.SnsInfoFlip", "%d notify online sight play video %s", new Object[] { Integer.valueOf(localObject2.hashCode()), str });
    this.rRJ = null;
    ((OnlineVideoView)localObject2).ctR();
    ((OnlineVideoView)localObject2).a(((com.tencent.mm.plugin.sns.h.b)localObject1).cIc, ((com.tencent.mm.plugin.sns.h.b)localObject1).rlJ, ((com.tencent.mm.plugin.sns.h.b)localObject1).fDT);
    localObject1 = new ro();
    ((ro)localObject1).cHU.cut = 1;
    ((ro)localObject1).cHU.ctV = str;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
    AppMethodBeat.o(38980);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(38979);
    ab.i("MicroMsg.SnsInfoFlip", "adapter clear.");
    this.rRI.clear();
    AppMethodBeat.o(38979);
  }
  
  public final void cvr()
  {
    AppMethodBeat.i(38981);
    ab.i("MicroMsg.SnsInfoFlip", "notify online sight stop %s", new Object[] { bo.dtY() });
    ro localro = new ro();
    localro.cHU.context = this.context;
    localro.cHU.ctV = this.rRJ;
    localro.cHU.cut = 2;
    com.tencent.mm.sdk.b.a.ymk.l(localro);
    this.rRJ = null;
    AppMethodBeat.o(38981);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(38975);
    if (SnsInfoFlip.j(this.rRB) == null)
    {
      AppMethodBeat.o(38975);
      return 0;
    }
    int i = SnsInfoFlip.j(this.rRB).size();
    AppMethodBeat.o(38975);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(38982);
    if ((paramInt < SnsInfoFlip.j(this.rRB).size()) && (paramInt >= 0))
    {
      Object localObject = SnsInfoFlip.j(this.rRB).get(paramInt);
      AppMethodBeat.o(38982);
      return localObject;
    }
    AppMethodBeat.o(38982);
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(38977);
    if (((com.tencent.mm.plugin.sns.h.b)SnsInfoFlip.j(this.rRB).get(paramInt)).cIc.jKs == 6)
    {
      AppMethodBeat.o(38977);
      return 0;
    }
    AppMethodBeat.o(38977);
    return 1;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(38978);
    boolean bool;
    if (((com.tencent.mm.plugin.sns.h.b)SnsInfoFlip.j(this.rRB).get(paramInt)).cIc.jKs == 6)
    {
      if (paramView == null)
      {
        bool = true;
        ab.d("MicroMsg.SnsInfoFlip", "fill view online sight %d convert view is null %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
        paramViewGroup = (com.tencent.mm.plugin.sns.h.b)SnsInfoFlip.j(this.rRB).get(paramInt);
        if (paramViewGroup != null) {
          break label110;
        }
        ab.w("MicroMsg.SnsInfoFlip", "fill online sight view, but flip item is null.");
      }
      for (;;)
      {
        AppMethodBeat.o(38978);
        return paramView;
        bool = false;
        break;
        label110:
        localObject1 = paramViewGroup.rlJ;
        if (!bo.isNullOrNil((String)localObject1)) {
          break label135;
        }
        ab.w("MicroMsg.SnsInfoFlip", "fill online sight view, but sns local id is null.");
      }
      label135:
      paramView = (WeakReference)this.rRI.get(localObject1);
      if ((paramView != null) && (paramView.get() != null)) {
        paramView = (OnlineVideoView)paramView.get();
      }
      for (;;)
      {
        paramView.aj(null);
        if (bo.isEqual((String)localObject1, this.rRJ)) {
          ER(paramInt);
        }
        ab.i("MicroMsg.SnsInfoFlip", "return online sight view %d parent id %s", new Object[] { Integer.valueOf(paramView.hashCode()), paramViewGroup.rlJ });
        localObject1 = ag.cpf().abv((String)localObject1);
        if (localObject1 != null)
        {
          paramView.setScene(SnsInfoFlip.l(this.rRB));
          localObject2 = new StringBuilder();
          com.tencent.mm.kernel.g.RJ();
          paramView.setSessionId(new p(com.tencent.mm.kernel.a.getUin()).toString() + "_" + bo.aoy());
          paramView.setSessionTimestamp(bo.aoy());
          paramView.setSnsId(i.lq(((com.tencent.mm.plugin.sns.storage.n)localObject1).field_snsId));
          paramView.setFilePath(ar.D(paramViewGroup.cIc));
        }
        break;
        paramView = new OnlineVideoView(this.context);
        this.rRI.put(localObject1, new WeakReference(paramView));
      }
    }
    Object localObject2 = ((com.tencent.mm.plugin.sns.h.b)SnsInfoFlip.j(this.rRB).get(paramInt)).cIc;
    ab.d("MicroMsg.SnsInfoFlip", "gallery position " + paramInt + " " + this.rEf + " " + ((bcs)localObject2).Id);
    az localaz;
    int i;
    label639:
    Object localObject3;
    if (paramView == null)
    {
      paramViewGroup = new SnsInfoFlip.d();
      paramView = View.inflate(this.context, 2130970826, null);
      paramViewGroup.rRK = paramView.findViewById(2131827990);
      paramViewGroup.rRL = ((ProgressBar)paramView.findViewById(2131821246));
      paramViewGroup.nXJ = ((TextView)paramView.findViewById(2131827992));
      paramViewGroup.rRM = ((FrameLayout)paramView.findViewById(2131827991));
      paramViewGroup.cxy = ((ImageView)paramView.findViewById(2131820629));
      paramView.setTag(paramViewGroup);
      paramViewGroup.position = paramInt;
      localaz = az.a(this.rRB.rbm, ((com.tencent.mm.plugin.sns.h.b)SnsInfoFlip.j(this.rRB).get(paramInt)).fDT);
      paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
      paramViewGroup.rRL.setVisibility(8);
      paramViewGroup.nXJ.setVisibility(8);
      paramViewGroup.rRM.setVisibility(0);
      if ((bo.isNullOrNil(SnsInfoFlip.m(this.rRB))) || (!SnsInfoFlip.m(this.rRB).equals(((bcs)localObject2).Id))) {
        break label1295;
      }
      i = 1;
      if ((!((bcs)localObject2).Id.startsWith("Locall_path")) || (bo.isNullOrNil(((com.tencent.mm.plugin.sns.h.b)SnsInfoFlip.j(this.rRB).get(paramInt)).rlJ))) {
        break label1583;
      }
      localObject3 = (com.tencent.mm.plugin.sns.storage.n)SnsInfoFlip.n(this.rRB).get(((com.tencent.mm.plugin.sns.h.b)SnsInfoFlip.j(this.rRB).get(paramInt)).rlJ);
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = ag.cpf().abv(((com.tencent.mm.plugin.sns.h.b)SnsInfoFlip.j(this.rRB).get(paramInt)).rlJ);
        SnsInfoFlip.n(this.rRB).put(((com.tencent.mm.plugin.sns.h.b)SnsInfoFlip.j(this.rRB).get(paramInt)).rlJ, localObject1);
      }
      localObject1 = ((com.tencent.mm.plugin.sns.storage.n)localObject1).csh();
      if (((TimeLineObject)localObject1).xTS.wOa.size() <= ((com.tencent.mm.plugin.sns.h.b)SnsInfoFlip.j(this.rRB).get(paramInt)).rlK) {
        break label1583;
      }
    }
    label1295:
    label1307:
    label1313:
    label1583:
    for (Object localObject1 = (bcs)((TimeLineObject)localObject1).xTS.wOa.get(((com.tencent.mm.plugin.sns.h.b)SnsInfoFlip.j(this.rRB).get(paramInt)).rlK);; localObject1 = localObject2)
    {
      localObject2 = ag.cpc();
      localObject3 = paramViewGroup.cxy;
      int j = this.context.hashCode();
      if (i == 0)
      {
        bool = true;
        label883:
        localObject2 = ((com.tencent.mm.plugin.sns.model.g)localObject2).a((bcs)localObject1, (View)localObject3, j, bool, localaz, v.abN(((com.tencent.mm.plugin.sns.h.b)SnsInfoFlip.j(this.rRB).get(paramInt)).rlJ));
        if ((localObject2 == null) && (SnsInfoFlip.k(this.rRB))) {
          SnsInfoFlip.a(this.rRB, ((bcs)localObject1).Id);
        }
        localObject3 = paramViewGroup.cxy.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = -1;
        ((ViewGroup.LayoutParams)localObject3).height = -1;
        paramViewGroup.cxy.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        if ((localObject2 != null) || (((bcs)localObject1).Id == null) || (((bcs)localObject1).Id.startsWith("pre_temp_extend_pic"))) {
          break label1313;
        }
        ViewGroup.LayoutParams localLayoutParams = paramViewGroup.cxy.getLayoutParams();
        BackwardSupportUtil.b.b(this.context, 160.0F);
        j = BackwardSupportUtil.b.b(this.context, 200.0F);
        BackwardSupportUtil.b.b(this.context, 44.0F);
        localObject2 = ag.cpc().aaj(i.bc(1, ((bcs)localObject1).Id));
        if (!i.b((com.tencent.mm.memory.n)localObject2)) {
          break label1307;
        }
        label1074:
        if (localObject2 != null)
        {
          double d1 = ((com.tencent.mm.memory.n)localObject2).bitmap.getWidth();
          double d2 = ((com.tencent.mm.memory.n)localObject2).bitmap.getHeight();
          if ((d1 > 0.0D) && (d2 > 0.0D)) {
            Math.min(j / d1, j / d2);
          }
        }
        paramViewGroup.cxy.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        paramViewGroup.rRL.setVisibility(0);
        paramViewGroup.cxy.setVisibility(0);
        ag.cpc().dC(paramViewGroup.cxy);
        ag.cpc().b((bcs)localObject1, paramViewGroup.cxy, 2130838011, this.context.hashCode(), localaz);
        SnsInfoFlip.EO(localLayoutParams.width);
        SnsInfoFlip.EP(localLayoutParams.height);
        if (i != 0) {
          paramViewGroup.rRL.setVisibility(8);
        }
      }
      for (;;)
      {
        label1223:
        if ((this.kYY) && (ac.cm(this.context)))
        {
          if (paramInt - 1 >= 0) {
            EQ(paramInt - 1);
          }
          if (paramInt + 1 < SnsInfoFlip.d(this.rRB).getCount()) {
            EQ(paramInt + 1);
          }
        }
        do
        {
          AppMethodBeat.o(38978);
          return paramView;
          paramViewGroup = (SnsInfoFlip.d)paramView.getTag();
          break;
          i = 0;
          break label639;
          bool = false;
          break label883;
          localObject2 = null;
          break label1074;
          if (!this.rRH) {
            break label1510;
          }
          paramViewGroup.rRL.setVisibility(8);
          if (localObject2 == null) {
            break label1223;
          }
        } while (SnsInfoFlip.o(this.rRB));
        ab.i("MicroMsg.SnsInfoFlip", "update view ");
        paramView = new MultiTouchImageView(this.context, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), SnsInfoFlip.p(this.rRB));
        paramView.setEnableHorLongBmpMode(SnsInfoFlip.q(this.rRB));
        paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        ag.cpc().a((bcs)localObject1, paramView, this.context.hashCode(), localaz, v.abN(((com.tencent.mm.plugin.sns.h.b)SnsInfoFlip.j(this.rRB).get(paramInt)).rlJ));
        paramView.setImageBitmap((Bitmap)localObject2);
        ab.d("MicroMsg.SnsInfoFlip", "dancy mediaId: %s, isbigImgLoaded: %s, view: %s", new Object[] { ((bcs)localObject1).Id, SnsInfoFlip.r(this.rRB).get(((bcs)localObject1).Id), Integer.valueOf(paramView.getId()) });
        AppMethodBeat.o(38978);
        return paramView;
        label1510:
        paramViewGroup.rRL.setVisibility(8);
        ag.cpc().a((bcs)localObject1, paramViewGroup.cxy, this.context.hashCode(), localaz, v.abN(((com.tencent.mm.plugin.sns.h.b)SnsInfoFlip.j(this.rRB).get(paramInt)).rlJ));
        paramViewGroup.cxy.setImageBitmap((Bitmap)localObject2);
        paramViewGroup.cxy.setVisibility(0);
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return 2;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(38983);
    this.rEf = SnsInfoFlip.j(this.rRB).size();
    ab.d("MicroMsg.SnsInfoFlip", "items.size:" + SnsInfoFlip.j(this.rRB).size());
    this.rRB.invalidate();
    this.rRB.requestLayout();
    super.notifyDataSetChanged();
    if ((SnsInfoFlip.j(this.rRB).size() <= 0) && (SnsInfoFlip.s(this.rRB) != null)) {
      SnsInfoFlip.s(this.rRB).run();
    }
    AppMethodBeat.o(38983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsInfoFlip.b
 * JD-Core Version:    0.7.0.1
 */