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
import com.tencent.mm.g.a.ms;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class j
  extends a
{
  public static float BGG = Resources.getSystem().getDisplayMetrics().density;
  public static int olA = Resources.getSystem().getDisplayMetrics().widthPixels;
  public static int olB = (int)(40.0F * BGG + 0.5F);
  public WXRTEditText BGE;
  public WXRTEditText BGF;
  public ImageView djK;
  public LinearLayout irQ;
  public View.OnClickListener olC = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(30869);
      if (j.this.BFc.BEu == 2)
      {
        j.this.BFc.BEl.etc().bRC();
        j.this.BFc.esQ();
      }
      int i = ((RecyclerView.v)paramAnonymousView.getTag()).ln();
      ms localms = new ms();
      if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().TZ(i) == null)
      {
        ad.e("Micromsg.NoteOtherItemHolder", "click not response, null == NoteDataManager.getMgr().get(position),position is %d,datalist size = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().size()) });
        AppMethodBeat.o(30869);
        return;
      }
      if (com.tencent.mm.plugin.wenote.model.c.esw().BCA == null)
      {
        ad.e("Micromsg.NoteOtherItemHolder", "getWnNoteBase is null");
        AppMethodBeat.o(30869);
        return;
      }
      ad.i("Micromsg.NoteOtherItemHolder", "click item, type is %d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().TZ(i).getType()) });
      localms.drL.drN = ((o)com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().TZ(i)).omI;
      localms.drL.context = paramAnonymousView.getContext();
      localms.drL.type = 1;
      com.tencent.mm.plugin.wenote.model.c.esw().BCA.b(localms);
      AppMethodBeat.o(30869);
    }
  };
  public LinearLayout oln;
  public TextView olo;
  public TextView olp;
  public ImageView olq;
  public View olr;
  public LinearLayout ols;
  public LinearLayout olt;
  public LinearLayout olu;
  public LinearLayout olv;
  public LinearLayout olw;
  public LinearLayout olx;
  public LinearLayout oly;
  
  public j(View paramView, k paramk)
  {
    super(paramView, paramk);
    this.djK = ((ImageView)paramView.findViewById(2131299257));
    this.olr = paramView.findViewById(2131306315);
    this.oln = ((LinearLayout)paramView.findViewById(2131302917));
    this.irQ = ((LinearLayout)paramView.findViewById(2131302943));
    this.olo = ((TextView)paramView.findViewById(2131302918));
    this.olp = ((TextView)paramView.findViewById(2131302915));
    this.olq = ((ImageView)paramView.findViewById(2131302916));
    this.olo.setTextSize(16.0F);
    this.olp.setTextSize(12.0F);
    this.ols = ((LinearLayout)paramView.findViewById(2131302941));
    this.ols.setVisibility(8);
    this.olu = ((LinearLayout)paramView.findViewById(2131302936));
    this.olu.setVisibility(8);
    this.olv = ((LinearLayout)paramView.findViewById(2131302914));
    this.olv.setVisibility(8);
    this.olw = ((LinearLayout)paramView.findViewById(2131303103));
    this.olw.setBackgroundColor(1347529272);
    this.olw.setVisibility(8);
    this.olw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30866);
        e.esT().bTb();
        AppMethodBeat.o(30866);
      }
    });
    this.olx = ((LinearLayout)paramView.findViewById(2131303110));
    this.olx.setBackgroundColor(1347529272);
    this.olx.setVisibility(4);
    this.oly = ((LinearLayout)paramView.findViewById(2131303105));
    this.oly.setBackgroundColor(1347529272);
    this.oly.setVisibility(4);
    this.olt = ((LinearLayout)paramView.findViewById(2131299269));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.olt.getLayoutParams();
    localLayoutParams.width = (olA - olB);
    localLayoutParams.height = -2;
    this.olt.setLayoutParams(localLayoutParams);
    this.BGF = ((WXRTEditText)paramView.findViewById(2131297578));
    this.BGE = ((WXRTEditText)paramView.findViewById(2131297580));
    ((LinearLayout)paramView.findViewById(2131297579)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30867);
        j.this.BGF.bSH();
        j.this.BGF.requestFocus();
        AppMethodBeat.o(30867);
      }
    });
    ((LinearLayout)paramView.findViewById(2131297581)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30868);
        j.this.BGE.bSH();
        j.this.BGE.requestFocus();
        AppMethodBeat.o(30868);
      }
    });
    this.BGF.setEditTextType(2);
    this.BGE.setEditTextType(1);
    this.BGE.oob = this;
    this.BGF.oob = this;
    if ((paramk.BEu != 2) || (!this.BFc.BEv))
    {
      this.BGF.setKeyListener(null);
      this.BGF.setEnabled(false);
      this.BGF.setFocusable(false);
      this.BGE.setKeyListener(null);
      this.BGE.setEnabled(false);
      this.BGE.setFocusable(false);
    }
    this.BFc.q(this.BGE);
    this.BFc.q(this.BGF);
  }
  
  public void a(com.tencent.mm.plugin.wenote.model.a.c paramc, int paramInt1, int paramInt2)
  {
    ad.i("Micromsg.NoteOtherItemHolder", "ImageItemHolder position is " + lm());
    this.BGE.setPosInDataList(paramInt1);
    this.BGF.setPosInDataList(paramInt1);
    if (e.isEnabled()) {
      e.esT().a(this.olw, this.olx, this.oly, paramInt1);
    }
    paramc.BDx = this.BGE;
    paramc.BDy = this.BGF;
    paramc.BDz = null;
    if (paramc.omv) {
      if (paramc.omB) {
        this.BGE.requestFocus();
      }
    }
    for (;;)
    {
      if (this.oln.getVisibility() == 0)
      {
        if (!paramc.omC) {
          break;
        }
        this.oln.setBackgroundResource(2131234765);
      }
      return;
      this.BGF.requestFocus();
      continue;
      if (this.BGE.hasFocus()) {
        this.BGE.clearFocus();
      }
      if (this.BGF.hasFocus()) {
        this.BGF.clearFocus();
      }
    }
    this.oln.setBackgroundResource(2131234764);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.j
 * JD-Core Version:    0.7.0.1
 */