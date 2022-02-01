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
import com.tencent.mm.g.a.nj;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class j
  extends a
{
  public static float ECJ = Resources.getSystem().getDisplayMetrics().density;
  public static int psI = Resources.getSystem().getDisplayMetrics().widthPixels;
  public static int psJ = (int)(40.0F * ECJ + 0.5F);
  public WXRTEditText ECH;
  public WXRTEditText ECI;
  public ImageView dsD;
  public LinearLayout jld;
  public LinearLayout psA;
  public LinearLayout psB;
  public LinearLayout psC;
  public LinearLayout psD;
  public LinearLayout psE;
  public LinearLayout psF;
  public LinearLayout psG;
  public View.OnClickListener psK = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(30869);
      Object localObject = new b();
      ((b)localObject).bd(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
      if (j.this.EBf.EAx == 2)
      {
        j.this.EBf.EAo.eXo().cdv();
        j.this.EBf.eXc();
      }
      int i = ((RecyclerView.w)paramAnonymousView.getTag()).lN();
      localObject = new nj();
      if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().XY(i) == null)
      {
        ad.e("Micromsg.NoteOtherItemHolder", "click not response, null == NoteDataManager.getMgr().get(position),position is %d,datalist size = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().size()) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30869);
        return;
      }
      if (com.tencent.mm.plugin.wenote.model.c.eWI().EyD == null)
      {
        ad.e("Micromsg.NoteOtherItemHolder", "getWnNoteBase is null");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30869);
        return;
      }
      ad.i("Micromsg.NoteOtherItemHolder", "click item, type is %d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().XY(i).getType()) });
      ((nj)localObject).dBj.dBl = ((o)com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().XY(i)).ptS;
      ((nj)localObject).dBj.context = paramAnonymousView.getContext();
      ((nj)localObject).dBj.type = 1;
      com.tencent.mm.plugin.wenote.model.c.eWI().EyD.b((nj)localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(30869);
    }
  };
  public LinearLayout psv;
  public TextView psw;
  public TextView psx;
  public ImageView psy;
  public View psz;
  
  public j(View paramView, k paramk)
  {
    super(paramView, paramk);
    this.dsD = ((ImageView)paramView.findViewById(2131299257));
    this.psz = paramView.findViewById(2131306315);
    this.psv = ((LinearLayout)paramView.findViewById(2131302917));
    this.jld = ((LinearLayout)paramView.findViewById(2131302943));
    this.psw = ((TextView)paramView.findViewById(2131302918));
    this.psx = ((TextView)paramView.findViewById(2131302915));
    this.psy = ((ImageView)paramView.findViewById(2131302916));
    this.psw.setTextSize(16.0F);
    this.psx.setTextSize(12.0F);
    this.psA = ((LinearLayout)paramView.findViewById(2131302941));
    this.psA.setVisibility(8);
    this.psC = ((LinearLayout)paramView.findViewById(2131302936));
    this.psC.setVisibility(8);
    this.psD = ((LinearLayout)paramView.findViewById(2131302914));
    this.psD.setVisibility(8);
    this.psE = ((LinearLayout)paramView.findViewById(2131303103));
    this.psE.setBackgroundColor(1347529272);
    this.psE.setVisibility(8);
    this.psE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30866);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        e.eXf().ceU();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30866);
      }
    });
    this.psF = ((LinearLayout)paramView.findViewById(2131303110));
    this.psF.setBackgroundColor(1347529272);
    this.psF.setVisibility(4);
    this.psG = ((LinearLayout)paramView.findViewById(2131303105));
    this.psG.setBackgroundColor(1347529272);
    this.psG.setVisibility(4);
    this.psB = ((LinearLayout)paramView.findViewById(2131299269));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.psB.getLayoutParams();
    localLayoutParams.width = (psI - psJ);
    localLayoutParams.height = -2;
    this.psB.setLayoutParams(localLayoutParams);
    this.ECI = ((WXRTEditText)paramView.findViewById(2131297578));
    this.ECH = ((WXRTEditText)paramView.findViewById(2131297580));
    ((LinearLayout)paramView.findViewById(2131297579)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30867);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        j.this.ECI.ceA();
        j.this.ECI.requestFocus();
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        j.this.ECH.ceA();
        j.this.ECH.requestFocus();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30868);
      }
    });
    this.ECI.setEditTextType(2);
    this.ECH.setEditTextType(1);
    this.ECH.pvl = this;
    this.ECI.pvl = this;
    if ((paramk.EAx != 2) || (!this.EBf.EAy))
    {
      this.ECI.setKeyListener(null);
      this.ECI.setEnabled(false);
      this.ECI.setFocusable(false);
      this.ECH.setKeyListener(null);
      this.ECH.setEnabled(false);
      this.ECH.setFocusable(false);
    }
    this.EBf.q(this.ECH);
    this.EBf.q(this.ECI);
  }
  
  public void a(com.tencent.mm.plugin.wenote.model.a.c paramc, int paramInt1, int paramInt2)
  {
    ad.i("Micromsg.NoteOtherItemHolder", "ImageItemHolder position is " + lM());
    this.ECH.setPosInDataList(paramInt1);
    this.ECI.setPosInDataList(paramInt1);
    if (e.isEnabled()) {
      e.eXf().a(this.psE, this.psF, this.psG, paramInt1);
    }
    paramc.EzA = this.ECH;
    paramc.EzB = this.ECI;
    paramc.EzC = null;
    if (paramc.ptF) {
      if (paramc.ptL) {
        this.ECH.requestFocus();
      }
    }
    for (;;)
    {
      if (this.psv.getVisibility() == 0)
      {
        if (!paramc.ptM) {
          break;
        }
        this.psv.setBackgroundResource(2131234765);
      }
      return;
      this.ECI.requestFocus();
      continue;
      if (this.ECH.hasFocus()) {
        this.ECH.clearFocus();
      }
      if (this.ECI.hasFocus()) {
        this.ECI.clearFocus();
      }
    }
    this.psv.setBackgroundResource(2131234764);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.j
 * JD-Core Version:    0.7.0.1
 */