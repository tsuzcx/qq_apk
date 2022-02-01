package com.tencent.mm.plugin.wenote.ui.nativenote.a;

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
import com.tencent.mm.f.a.oz;
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
  public static float QKr = Resources.getSystem().getDisplayMetrics().density;
  public static int uqJ = Resources.getSystem().getDisplayMetrics().widthPixels;
  public static int uqK = (int)(40.0F * QKr + 0.5F);
  public WXRTEditText QKp;
  public WXRTEditText QKq;
  public ImageView fDJ;
  public LinearLayout ndX;
  public View uqA;
  public LinearLayout uqB;
  public LinearLayout uqC;
  public LinearLayout uqD;
  public LinearLayout uqE;
  public LinearLayout uqF;
  public LinearLayout uqG;
  public LinearLayout uqH;
  public View.OnClickListener uqL = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(30869);
      Object localObject = new b();
      ((b)localObject).bn(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      if (j.this.QIM.QHZ == 2)
      {
        j.this.QIM.QHQ.hdV().cRf();
        j.this.QIM.hdH();
      }
      int i = ((RecyclerView.v)paramAnonymousView.getTag()).md();
      localObject = new oz();
      if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().aph(i) == null)
      {
        Log.e("Micromsg.NoteOtherItemHolder", "click not response, null == NoteDataManager.getMgr().get(position),position is %d,datalist size = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().size()) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30869);
        return;
      }
      if (com.tencent.mm.plugin.wenote.model.c.hdm().QGd == null)
      {
        Log.e("Micromsg.NoteOtherItemHolder", "getWnNoteBase is null");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30869);
        return;
      }
      Log.i("Micromsg.NoteOtherItemHolder", "click item, type is %d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().aph(i).getType()) });
      ((oz)localObject).fNG.fNI = ((o)com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().aph(i)).urT;
      ((oz)localObject).fNG.context = paramAnonymousView.getContext();
      ((oz)localObject).fNG.type = 1;
      com.tencent.mm.plugin.wenote.model.c.hdm().QGd.b((oz)localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(30869);
    }
  };
  public LinearLayout uqw;
  public TextView uqx;
  public TextView uqy;
  public ImageView uqz;
  
  public j(View paramView, k paramk)
  {
    super(paramView, paramk);
    this.fDJ = ((ImageView)paramView.findViewById(R.h.dFr));
    this.uqA = paramView.findViewById(R.h.dYE);
    this.uqw = ((LinearLayout)paramView.findViewById(R.h.dPL));
    this.ndX = ((LinearLayout)paramView.findViewById(R.h.dQh));
    this.uqx = ((TextView)paramView.findViewById(R.h.dPM));
    this.uqy = ((TextView)paramView.findViewById(R.h.dPJ));
    this.uqz = ((ImageView)paramView.findViewById(R.h.dPK));
    this.uqx.setTextSize(16.0F);
    this.uqy.setTextSize(12.0F);
    this.uqB = ((LinearLayout)paramView.findViewById(R.h.dQf));
    this.uqB.setVisibility(8);
    this.uqD = ((LinearLayout)paramView.findViewById(R.h.dQa));
    this.uqD.setVisibility(8);
    this.uqE = ((LinearLayout)paramView.findViewById(R.h.dPI));
    this.uqE.setVisibility(8);
    this.uqF = ((LinearLayout)paramView.findViewById(R.h.dQG));
    this.uqF.setBackgroundColor(1347529272);
    this.uqF.setVisibility(8);
    this.uqF.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30866);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        e.hdK().cSE();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30866);
      }
    });
    this.uqG = ((LinearLayout)paramView.findViewById(R.h.dQJ));
    this.uqG.setBackgroundColor(1347529272);
    this.uqG.setVisibility(4);
    this.uqH = ((LinearLayout)paramView.findViewById(R.h.dQH));
    this.uqH.setBackgroundColor(1347529272);
    this.uqH.setVisibility(4);
    this.uqC = ((LinearLayout)paramView.findViewById(R.h.dFs));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.uqC.getLayoutParams();
    localLayoutParams.width = (uqJ - uqK);
    localLayoutParams.height = -2;
    this.uqC.setLayoutParams(localLayoutParams);
    this.QKq = ((WXRTEditText)paramView.findViewById(R.h.duD));
    this.QKp = ((WXRTEditText)paramView.findViewById(R.h.duF));
    ((LinearLayout)paramView.findViewById(R.h.duE)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30867);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        j.this.QKq.cSk();
        j.this.QKq.requestFocus();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30867);
      }
    });
    ((LinearLayout)paramView.findViewById(R.h.duG)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30868);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        j.this.QKp.cSk();
        j.this.QKp.requestFocus();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteOtherItemHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30868);
      }
    });
    this.QKq.setEditTextType(2);
    this.QKp.setEditTextType(1);
    this.QKp.utn = this;
    this.QKq.utn = this;
    if ((paramk.QHZ != 2) || (!this.QIM.QIa))
    {
      this.QKq.setKeyListener(null);
      this.QKq.setEnabled(false);
      this.QKq.setFocusable(false);
      this.QKp.setKeyListener(null);
      this.QKp.setEnabled(false);
      this.QKp.setFocusable(false);
    }
    this.QIM.q(this.QKp);
    this.QIM.q(this.QKq);
  }
  
  public void a(com.tencent.mm.plugin.wenote.model.a.c paramc, int paramInt1, int paramInt2)
  {
    Log.i("Micromsg.NoteOtherItemHolder", "ImageItemHolder position is " + mc());
    this.QKp.setPosInDataList(paramInt1);
    this.QKq.setPosInDataList(paramInt1);
    if (e.isEnabled()) {
      e.hdK().a(this.uqF, this.uqG, this.uqH, paramInt1);
    }
    paramc.QHb = this.QKp;
    paramc.QHc = this.QKq;
    paramc.QHd = null;
    if (paramc.urG) {
      if (paramc.urM) {
        this.QKp.requestFocus();
      }
    }
    for (;;)
    {
      if (this.uqw.getVisibility() == 0)
      {
        if (!paramc.urN) {
          break;
        }
        this.uqw.setBackgroundResource(R.g.dpz);
      }
      return;
      this.QKq.requestFocus();
      continue;
      if (this.QKp.hasFocus()) {
        this.QKp.clearFocus();
      }
      if (this.QKq.hasFocus()) {
        this.QKq.clearFocus();
      }
    }
    this.uqw.setBackgroundResource(R.g.dpy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.j
 * JD-Core Version:    0.7.0.1
 */