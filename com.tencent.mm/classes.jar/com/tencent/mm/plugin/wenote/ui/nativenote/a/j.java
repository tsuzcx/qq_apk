package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.w;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nk;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.sdk.platformtools.ae;

public abstract class j
  extends a
{
  public static float EVf = Resources.getSystem().getDisplayMetrics().density;
  public static int pzo = Resources.getSystem().getDisplayMetrics().widthPixels;
  public static int pzp = (int)(40.0F * EVf + 0.5F);
  public WXRTEditText EVd;
  public WXRTEditText EVe;
  public ImageView dtJ;
  public LinearLayout jnX;
  public LinearLayout pzb;
  public TextView pzc;
  public TextView pzd;
  public ImageView pze;
  public View pzf;
  public LinearLayout pzg;
  public LinearLayout pzh;
  public LinearLayout pzi;
  public LinearLayout pzj;
  public LinearLayout pzk;
  public LinearLayout pzl;
  public LinearLayout pzm;
  public View.OnClickListener pzq = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(30869);
      Object localObject = new b();
      ((b)localObject).bd(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
      if (j.this.ETB.EST == 2)
      {
        j.this.ETB.ESK.fba().ceK();
        j.this.ETB.faO();
      }
      int i = ((RecyclerView.w)paramAnonymousView.getTag()).lN();
      localObject = new nk();
      if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().YE(i) == null)
      {
        ae.e("Micromsg.NoteOtherItemHolder", "click not response, null == NoteDataManager.getMgr().get(position),position is %d,datalist size = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().size()) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30869);
        return;
      }
      if (com.tencent.mm.plugin.wenote.model.c.fau().EQZ == null)
      {
        ae.e("Micromsg.NoteOtherItemHolder", "getWnNoteBase is null");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30869);
        return;
      }
      ae.i("Micromsg.NoteOtherItemHolder", "click item, type is %d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().YE(i).getType()) });
      ((nk)localObject).dCo.dCq = ((o)com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().YE(i)).pAw;
      ((nk)localObject).dCo.context = paramAnonymousView.getContext();
      ((nk)localObject).dCo.type = 1;
      com.tencent.mm.plugin.wenote.model.c.fau().EQZ.b((nk)localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(30869);
    }
  };
  
  public j(View paramView, k paramk)
  {
    super(paramView, paramk);
    this.dtJ = ((ImageView)paramView.findViewById(2131299257));
    this.pzf = paramView.findViewById(2131306315);
    this.pzb = ((LinearLayout)paramView.findViewById(2131302917));
    this.jnX = ((LinearLayout)paramView.findViewById(2131302943));
    this.pzc = ((TextView)paramView.findViewById(2131302918));
    this.pzd = ((TextView)paramView.findViewById(2131302915));
    this.pze = ((ImageView)paramView.findViewById(2131302916));
    this.pzc.setTextSize(16.0F);
    this.pzd.setTextSize(12.0F);
    this.pzg = ((LinearLayout)paramView.findViewById(2131302941));
    this.pzg.setVisibility(8);
    this.pzi = ((LinearLayout)paramView.findViewById(2131302936));
    this.pzi.setVisibility(8);
    this.pzj = ((LinearLayout)paramView.findViewById(2131302914));
    this.pzj.setVisibility(8);
    this.pzk = ((LinearLayout)paramView.findViewById(2131303103));
    this.pzk.setBackgroundColor(1347529272);
    this.pzk.setVisibility(8);
    this.pzk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30866);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        e.faR().cgj();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30866);
      }
    });
    this.pzl = ((LinearLayout)paramView.findViewById(2131303110));
    this.pzl.setBackgroundColor(1347529272);
    this.pzl.setVisibility(4);
    this.pzm = ((LinearLayout)paramView.findViewById(2131303105));
    this.pzm.setBackgroundColor(1347529272);
    this.pzm.setVisibility(4);
    this.pzh = ((LinearLayout)paramView.findViewById(2131299269));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.pzh.getLayoutParams();
    localLayoutParams.width = (pzo - pzp);
    localLayoutParams.height = -2;
    this.pzh.setLayoutParams(localLayoutParams);
    this.EVe = ((WXRTEditText)paramView.findViewById(2131297578));
    this.EVd = ((WXRTEditText)paramView.findViewById(2131297580));
    ((LinearLayout)paramView.findViewById(2131297579)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30867);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        j.this.EVe.cfP();
        j.this.EVe.requestFocus();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30867);
      }
    });
    ((LinearLayout)paramView.findViewById(2131297581)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30868);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        j.this.EVd.cfP();
        j.this.EVd.requestFocus();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30868);
      }
    });
    this.EVe.setEditTextType(2);
    this.EVd.setEditTextType(1);
    this.EVd.pBP = this;
    this.EVe.pBP = this;
    if ((paramk.EST != 2) || (!this.ETB.ESU))
    {
      this.EVe.setKeyListener(null);
      this.EVe.setEnabled(false);
      this.EVe.setFocusable(false);
      this.EVd.setKeyListener(null);
      this.EVd.setEnabled(false);
      this.EVd.setFocusable(false);
    }
    this.ETB.q(this.EVd);
    this.ETB.q(this.EVe);
  }
  
  public void a(com.tencent.mm.plugin.wenote.model.a.c paramc, int paramInt1, int paramInt2)
  {
    ae.i("Micromsg.NoteOtherItemHolder", "ImageItemHolder position is " + lM());
    this.EVd.setPosInDataList(paramInt1);
    this.EVe.setPosInDataList(paramInt1);
    if (e.isEnabled()) {
      e.faR().a(this.pzk, this.pzl, this.pzm, paramInt1);
    }
    paramc.ERW = this.EVd;
    paramc.ERX = this.EVe;
    paramc.ERY = null;
    if (paramc.pAj) {
      if (paramc.pAp) {
        this.EVd.requestFocus();
      }
    }
    for (;;)
    {
      if (this.pzb.getVisibility() == 0)
      {
        if (!paramc.pAq) {
          break;
        }
        this.pzb.setBackgroundResource(2131234765);
      }
      return;
      this.EVe.requestFocus();
      continue;
      if (this.EVd.hasFocus()) {
        this.EVd.clearFocus();
      }
      if (this.EVe.hasFocus()) {
        this.EVe.clearFocus();
      }
    }
    this.pzb.setBackgroundResource(2131234764);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.j
 * JD-Core Version:    0.7.0.1
 */