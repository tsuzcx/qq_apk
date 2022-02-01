package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.ql;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class j
  extends a
{
  public static float XDQ = Resources.getSystem().getDisplayMetrics().density;
  public static int xxg = Resources.getSystem().getDisplayMetrics().widthPixels;
  public static int xxh = (int)(40.0F * XDQ + 0.5F);
  public WXRTEditText XDO;
  public WXRTEditText XDP;
  public ImageView hIz;
  public LinearLayout pZr;
  public LinearLayout xwT;
  public TextView xwU;
  public TextView xwV;
  public ImageView xwW;
  public View xwX;
  public LinearLayout xwY;
  public LinearLayout xwZ;
  public LinearLayout xxa;
  public LinearLayout xxb;
  public LinearLayout xxc;
  public LinearLayout xxd;
  public LinearLayout xxe;
  public View.OnClickListener xxi = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(30869);
      Object localObject = new b();
      ((b)localObject).cH(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
      if (j.this.XCl.XBx == 2)
      {
        j.this.XCl.XBo.iEC().dvy();
        j.this.XCl.iEo();
      }
      int i = ((RecyclerView.v)paramAnonymousView.getTag()).KJ();
      localObject = new ql();
      if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().avf(i) == null)
      {
        Log.e("Micromsg.NoteOtherItemHolder", "click not response, null == NoteDataManager.getMgr().get(position),position is %d,datalist size = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().size()) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30869);
        return;
      }
      if (com.tencent.mm.plugin.wenote.model.c.iDT().XzB == null)
      {
        Log.e("Micromsg.NoteOtherItemHolder", "getWnNoteBase is null");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30869);
        return;
      }
      Log.i("Micromsg.NoteOtherItemHolder", "click item, type is %d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().avf(i).getType()) });
      ((ql)localObject).hTy.hTA = ((o)com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().avf(i)).xyo;
      ((ql)localObject).hTy.context = paramAnonymousView.getContext();
      ((ql)localObject).hTy.type = 1;
      com.tencent.mm.plugin.wenote.model.c.iDT().XzB.b((ql)localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(30869);
    }
  };
  
  public j(View paramView, k paramk)
  {
    super(paramView, paramk);
    this.hIz = ((ImageView)paramView.findViewById(R.h.fGw));
    this.xwX = paramView.findViewById(R.h.gbs);
    this.xwT = ((LinearLayout)paramView.findViewById(R.h.fRQ));
    this.pZr = ((LinearLayout)paramView.findViewById(R.h.fSm));
    this.xwU = ((TextView)paramView.findViewById(R.h.fRR));
    this.xwV = ((TextView)paramView.findViewById(R.h.fRO));
    this.xwW = ((ImageView)paramView.findViewById(R.h.fRP));
    this.xwU.setTextSize(16.0F);
    this.xwV.setTextSize(12.0F);
    this.xwY = ((LinearLayout)paramView.findViewById(R.h.fSk));
    this.xwY.setVisibility(8);
    this.xxa = ((LinearLayout)paramView.findViewById(R.h.fSf));
    this.xxa.setVisibility(8);
    this.xxb = ((LinearLayout)paramView.findViewById(R.h.fRN));
    this.xxb.setVisibility(8);
    this.xxc = ((LinearLayout)paramView.findViewById(R.h.fSM));
    this.xxc.setBackgroundColor(1347529272);
    this.xxc.setVisibility(8);
    this.xxc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30866);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        e.iEr().dwW();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30866);
      }
    });
    this.xxd = ((LinearLayout)paramView.findViewById(R.h.fSP));
    this.xxd.setBackgroundColor(1347529272);
    this.xxd.setVisibility(4);
    this.xxe = ((LinearLayout)paramView.findViewById(R.h.fSN));
    this.xxe.setBackgroundColor(1347529272);
    this.xxe.setVisibility(4);
    this.xwZ = ((LinearLayout)paramView.findViewById(R.h.fGz));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.xwZ.getLayoutParams();
    localLayoutParams.width = (xxg - xxh);
    localLayoutParams.height = -2;
    this.xwZ.setLayoutParams(localLayoutParams);
    this.XDP = ((WXRTEditText)paramView.findViewById(R.h.fuV));
    this.XDO = ((WXRTEditText)paramView.findViewById(R.h.fuX));
    ((LinearLayout)paramView.findViewById(R.h.fuW)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30867);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        j.this.XDP.dwC();
        j.this.XDP.requestFocus();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30867);
      }
    });
    ((LinearLayout)paramView.findViewById(R.h.fuY)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30868);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        j.this.XDO.dwC();
        j.this.XDO.requestFocus();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30868);
      }
    });
    this.XDP.setEditTextType(2);
    this.XDO.setEditTextType(1);
    this.XDO.xzK = this;
    this.XDP.xzK = this;
    if ((paramk.XBx != 2) || (!this.XCl.XBy))
    {
      this.XDP.setKeyListener(null);
      this.XDP.setEnabled(false);
      this.XDP.setFocusable(false);
      this.XDO.setKeyListener(null);
      this.XDO.setEnabled(false);
      this.XDO.setFocusable(false);
    }
    this.XCl.q(this.XDO);
    this.XCl.q(this.XDP);
  }
  
  public void a(com.tencent.mm.plugin.wenote.model.a.c paramc, int paramInt1, int paramInt2)
  {
    Log.i("Micromsg.NoteOtherItemHolder", "ImageItemHolder position is " + KI());
    this.XDO.setPosInDataList(paramInt1);
    this.XDP.setPosInDataList(paramInt1);
    if (e.isEnabled()) {
      e.iEr().a(this.xxc, this.xxd, this.xxe, paramInt1);
    }
    paramc.XAz = this.XDO;
    paramc.XAA = this.XDP;
    paramc.XAB = null;
    if (paramc.xyb) {
      if (paramc.xyh)
      {
        this.XDO.requestFocus();
        label110:
        if (this.xwT.getVisibility() == 0)
        {
          if (!paramc.xyi) {
            break label325;
          }
          this.xwT.setBackgroundResource(R.g.fpO);
        }
      }
    }
    Context localContext;
    for (;;)
    {
      if (iEJ() != null)
      {
        paramInt1 = dvW();
        paramc = iEJ();
        localContext = paramc.getContext();
      }
      switch (paramInt1)
      {
      case -1: 
      case 0: 
      case 1: 
      default: 
        return;
        this.XDP.requestFocus();
        break label110;
        if (this.XDO.hasFocus()) {
          this.XDO.clearFocus();
        }
        if (!this.XDP.hasFocus()) {
          break label110;
        }
        this.XDP.clearFocus();
        break label110;
        label325:
        this.xwT.setBackgroundResource(R.g.fpN);
      }
    }
    paramc.setContentDescription(localContext.getResources().getString(R.l.gxj));
    localContext.getResources().getString(R.l.gxj);
    return;
    paramc.setContentDescription(localContext.getResources().getString(R.l.gOU));
    localContext.getResources().getString(R.l.gOU);
    return;
    paramc.setContentDescription(localContext.getResources().getString(R.l.gZj));
    localContext.getResources().getString(R.l.gZj);
    return;
    paramc.setContentDescription(localContext.getResources().getString(R.l.gOV));
    localContext.getResources().getString(R.l.gOV);
    return;
    paramc.setContentDescription(localContext.getResources().getString(R.l.gOT));
    localContext.getResources().getString(R.l.gOT);
    return;
    paramc.setContentDescription(localContext.getResources().getString(R.l.gZi));
    localContext.getResources().getString(R.l.gZi);
    return;
    paramc.setContentDescription(localContext.getResources().getString(R.l.gJx));
    localContext.getResources().getString(R.l.gJx);
    return;
    paramc.setContentDescription(localContext.getResources().getString(R.l.gvT));
    localContext.getResources().getString(R.l.gvT);
    return;
    paramc.setContentDescription(localContext.getResources().getString(R.l.gTd));
    localContext.getResources().getString(R.l.gTd);
    return;
    paramc.setContentDescription(localContext.getResources().getString(R.l.gZi));
    localContext.getResources().getString(R.l.gZi);
  }
  
  protected View iEJ()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.j
 * JD-Core Version:    0.7.0.1
 */