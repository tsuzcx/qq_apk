package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.v;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oc;
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
  public static float JKY = Resources.getSystem().getDisplayMetrics().density;
  public static int qOF = Resources.getSystem().getDisplayMetrics().widthPixels;
  public static int qOG = (int)(40.0F * JKY + 0.5F);
  public WXRTEditText JKW;
  public WXRTEditText JKX;
  public ImageView dKU;
  public LinearLayout kmg;
  public LinearLayout qOA;
  public LinearLayout qOB;
  public LinearLayout qOC;
  public LinearLayout qOD;
  public View.OnClickListener qOH = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(30869);
      Object localObject = new b();
      ((b)localObject).bm(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      if (j.this.JJu.JIH == 2)
      {
        j.this.JJu.JIy.gkf().cCA();
        j.this.JJu.gjT();
      }
      int i = ((RecyclerView.v)paramAnonymousView.getTag()).lR();
      localObject = new oc();
      if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ahp(i) == null)
      {
        Log.e("Micromsg.NoteOtherItemHolder", "click not response, null == NoteDataManager.getMgr().get(position),position is %d,datalist size = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().size()) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30869);
        return;
      }
      if (com.tencent.mm.plugin.wenote.model.c.gjz().JGL == null)
      {
        Log.e("Micromsg.NoteOtherItemHolder", "getWnNoteBase is null");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30869);
        return;
      }
      Log.i("Micromsg.NoteOtherItemHolder", "click item, type is %d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ahp(i).getType()) });
      ((oc)localObject).dUe.dUg = ((o)com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ahp(i)).qPN;
      ((oc)localObject).dUe.context = paramAnonymousView.getContext();
      ((oc)localObject).dUe.type = 1;
      com.tencent.mm.plugin.wenote.model.c.gjz().JGL.b((oc)localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(30869);
    }
  };
  public LinearLayout qOs;
  public TextView qOt;
  public TextView qOu;
  public ImageView qOv;
  public View qOw;
  public LinearLayout qOx;
  public LinearLayout qOy;
  public LinearLayout qOz;
  
  public j(View paramView, k paramk)
  {
    super(paramView, paramk);
    this.dKU = ((ImageView)paramView.findViewById(2131299829));
    this.qOw = paramView.findViewById(2131309734);
    this.qOs = ((LinearLayout)paramView.findViewById(2131305504));
    this.kmg = ((LinearLayout)paramView.findViewById(2131305530));
    this.qOt = ((TextView)paramView.findViewById(2131305505));
    this.qOu = ((TextView)paramView.findViewById(2131305502));
    this.qOv = ((ImageView)paramView.findViewById(2131305503));
    this.qOt.setTextSize(16.0F);
    this.qOu.setTextSize(12.0F);
    this.qOx = ((LinearLayout)paramView.findViewById(2131305528));
    this.qOx.setVisibility(8);
    this.qOz = ((LinearLayout)paramView.findViewById(2131305523));
    this.qOz.setVisibility(8);
    this.qOA = ((LinearLayout)paramView.findViewById(2131305501));
    this.qOA.setVisibility(8);
    this.qOB = ((LinearLayout)paramView.findViewById(2131305733));
    this.qOB.setBackgroundColor(1347529272);
    this.qOB.setVisibility(8);
    this.qOB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30866);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        e.gjW().cDY();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30866);
      }
    });
    this.qOC = ((LinearLayout)paramView.findViewById(2131305741));
    this.qOC.setBackgroundColor(1347529272);
    this.qOC.setVisibility(4);
    this.qOD = ((LinearLayout)paramView.findViewById(2131305736));
    this.qOD.setBackgroundColor(1347529272);
    this.qOD.setVisibility(4);
    this.qOy = ((LinearLayout)paramView.findViewById(2131299850));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.qOy.getLayoutParams();
    localLayoutParams.width = (qOF - qOG);
    localLayoutParams.height = -2;
    this.qOy.setLayoutParams(localLayoutParams);
    this.JKX = ((WXRTEditText)paramView.findViewById(2131297817));
    this.JKW = ((WXRTEditText)paramView.findViewById(2131297819));
    ((LinearLayout)paramView.findViewById(2131297818)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30867);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        j.this.JKX.cDF();
        j.this.JKX.requestFocus();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30867);
      }
    });
    ((LinearLayout)paramView.findViewById(2131297820)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30868);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        j.this.JKW.cDF();
        j.this.JKW.requestFocus();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30868);
      }
    });
    this.JKX.setEditTextType(2);
    this.JKW.setEditTextType(1);
    this.JKW.qRh = this;
    this.JKX.qRh = this;
    if ((paramk.JIH != 2) || (!this.JJu.JII))
    {
      this.JKX.setKeyListener(null);
      this.JKX.setEnabled(false);
      this.JKX.setFocusable(false);
      this.JKW.setKeyListener(null);
      this.JKW.setEnabled(false);
      this.JKW.setFocusable(false);
    }
    this.JJu.q(this.JKW);
    this.JJu.q(this.JKX);
  }
  
  public void a(com.tencent.mm.plugin.wenote.model.a.c paramc, int paramInt1, int paramInt2)
  {
    Log.i("Micromsg.NoteOtherItemHolder", "ImageItemHolder position is " + lQ());
    this.JKW.setPosInDataList(paramInt1);
    this.JKX.setPosInDataList(paramInt1);
    if (e.isEnabled()) {
      e.gjW().a(this.qOB, this.qOC, this.qOD, paramInt1);
    }
    paramc.JHJ = this.JKW;
    paramc.JHK = this.JKX;
    paramc.JHL = null;
    if (paramc.qPA) {
      if (paramc.qPG) {
        this.JKW.requestFocus();
      }
    }
    for (;;)
    {
      if (this.qOs.getVisibility() == 0)
      {
        if (!paramc.qPH) {
          break;
        }
        this.qOs.setBackgroundResource(2131235744);
      }
      return;
      this.JKX.requestFocus();
      continue;
      if (this.JKW.hasFocus()) {
        this.JKW.clearFocus();
      }
      if (this.JKX.hasFocus()) {
        this.JKX.clearFocus();
      }
    }
    this.qOs.setBackgroundResource(2131235743);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.j
 * JD-Core Version:    0.7.0.1
 */