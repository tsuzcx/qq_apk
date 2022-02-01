package com.tencent.mm.ui.transmit.recent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ck.a.c;
import com.tencent.mm.ck.a.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.base.u.c;
import com.tencent.mm.ui.base.u.f;
import com.tencent.mm.ui.widget.a.f;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/transmit/recent/RecentForwardUtils;", "", "()V", "TAG", "", "initListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateContextMMMenuListener;", "setHeaderView", "", "context", "Landroid/content/Context;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "type", "", "setImageLoader", "overrideAvatarLoader", "Lcom/tencent/mm/ui/base/MMMenuListener$IImageLoader;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b afPU;
  
  static
  {
    AppMethodBeat.i(250915);
    afPU = new b();
    AppMethodBeat.o(250915);
  }
  
  public static void a(Context paramContext, f paramf, int paramInt)
  {
    AppMethodBeat.i(250899);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramf, "sheet");
    if (3 == paramInt)
    {
      paramInt = R.l.gUx;
      if (paramf.ageO == null) {
        paramf.jHJ();
      }
      if (paramf.ageP == null) {
        paramf.ageP = ((TextView)paramf.rootView.findViewById(a.f.zero_menu_title));
      }
      if (paramf.ageP != null)
      {
        paramf.ageP.setVisibility(0);
        paramf.ageP.setText(paramInt);
        if (paramf.VtK)
        {
          paramf.ageP.setTextColor(paramf.mContext.getResources().getColor(a.c.BW_100_Alpha_0_8));
          AppMethodBeat.o(250899);
          return;
        }
        paramf.ageP.setTextColor(paramf.mContext.getResources().getColor(a.c.FG_0));
      }
      AppMethodBeat.o(250899);
      return;
    }
    View localView = af.mU(paramContext).inflate(R.i.gnr, null);
    TextView localTextView;
    if (localView != null)
    {
      localTextView = (TextView)localView.findViewById(R.h.fuS);
      aw.a((Paint)localTextView.getPaint(), 0.8F);
      paramContext.getResources().getDimension(R.f.Edge_6A);
      if (localView != null)
      {
        paramf.Nfh = true;
        if (paramf.ageS != null) {
          paramf.ageS.setVisibility(4);
        }
        if (paramf.VtC != null)
        {
          paramf.VtC.setVisibility(0);
          paramf.VtC.removeAllViews();
          paramf.VtC.setGravity(17);
          paramf.VtC.addView(localView, -1, -2);
        }
      }
    }
    switch (paramInt)
    {
    default: 
      Log.w("MircoMsg.RecentForwardUtils", kotlin.g.b.s.X("invalid type:", Integer.valueOf(paramInt)));
      AppMethodBeat.o(250899);
      return;
    case 1: 
      localTextView.setTextColor(paramContext.getResources().getColor(R.e.FG_0));
      AppMethodBeat.o(250899);
      return;
    }
    localTextView.setTextColor(paramContext.getResources().getColor(R.e.BW_100_Alpha_0_8));
    AppMethodBeat.o(250899);
  }
  
  public static void a(f paramf, u.c paramc)
  {
    AppMethodBeat.i(250883);
    kotlin.g.b.s.u(paramf, "sheet");
    if (paramc != null)
    {
      paramf.agex = paramc;
      AppMethodBeat.o(250883);
      return;
    }
    paramf.agex = b..ExternalSyntheticLambda0.INSTANCE;
    AppMethodBeat.o(250883);
  }
  
  private static final void b(ImageView paramImageView, t paramt)
  {
    AppMethodBeat.i(250908);
    if (!Util.isNullOrNil(paramt.rDm)) {
      a.b.g(paramImageView, paramt.rDm);
    }
    AppMethodBeat.o(250908);
  }
  
  private static final void b(com.tencent.mm.ui.base.s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(250912);
    params.oh(0, R.l.gUC);
    AppMethodBeat.o(250912);
  }
  
  public static u.f jEe()
  {
    return b..ExternalSyntheticLambda1.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.recent.b
 * JD-Core Version:    0.7.0.1
 */