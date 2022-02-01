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
import com.tencent.mm.g.a.nb;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.sdk.platformtools.ac;

public abstract class j
  extends a
{
  public static float CYN = Resources.getSystem().getDisplayMetrics().density;
  public static int oPa = Resources.getSystem().getDisplayMetrics().widthPixels;
  public static int oPb = (int)(40.0F * CYN + 0.5F);
  public WXRTEditText CYL;
  public WXRTEditText CYM;
  public ImageView dhf;
  public LinearLayout iRV;
  public LinearLayout oON;
  public TextView oOO;
  public TextView oOP;
  public ImageView oOQ;
  public View oOR;
  public LinearLayout oOS;
  public LinearLayout oOT;
  public LinearLayout oOU;
  public LinearLayout oOV;
  public LinearLayout oOW;
  public LinearLayout oOX;
  public LinearLayout oOY;
  public View.OnClickListener oPc = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(30869);
      if (j.this.CXj.CWB == 2)
      {
        j.this.CXj.CWs.eIv().bYR();
        j.this.CXj.eIj();
      }
      int i = ((RecyclerView.w)paramAnonymousView.getTag()).lv();
      nb localnb = new nb();
      if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().Wh(i) == null)
      {
        ac.e("Micromsg.NoteOtherItemHolder", "click not response, null == NoteDataManager.getMgr().get(position),position is %d,datalist size = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().size()) });
        AppMethodBeat.o(30869);
        return;
      }
      if (com.tencent.mm.plugin.wenote.model.c.eHP().CUG == null)
      {
        ac.e("Micromsg.NoteOtherItemHolder", "getWnNoteBase is null");
        AppMethodBeat.o(30869);
        return;
      }
      ac.i("Micromsg.NoteOtherItemHolder", "click item, type is %d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().Wh(i).getType()) });
      localnb.dpw.dpy = ((o)com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().Wh(i)).oQi;
      localnb.dpw.context = paramAnonymousView.getContext();
      localnb.dpw.type = 1;
      com.tencent.mm.plugin.wenote.model.c.eHP().CUG.b(localnb);
      AppMethodBeat.o(30869);
    }
  };
  
  public j(View paramView, k paramk)
  {
    super(paramView, paramk);
    this.dhf = ((ImageView)paramView.findViewById(2131299257));
    this.oOR = paramView.findViewById(2131306315);
    this.oON = ((LinearLayout)paramView.findViewById(2131302917));
    this.iRV = ((LinearLayout)paramView.findViewById(2131302943));
    this.oOO = ((TextView)paramView.findViewById(2131302918));
    this.oOP = ((TextView)paramView.findViewById(2131302915));
    this.oOQ = ((ImageView)paramView.findViewById(2131302916));
    this.oOO.setTextSize(16.0F);
    this.oOP.setTextSize(12.0F);
    this.oOS = ((LinearLayout)paramView.findViewById(2131302941));
    this.oOS.setVisibility(8);
    this.oOU = ((LinearLayout)paramView.findViewById(2131302936));
    this.oOU.setVisibility(8);
    this.oOV = ((LinearLayout)paramView.findViewById(2131302914));
    this.oOV.setVisibility(8);
    this.oOW = ((LinearLayout)paramView.findViewById(2131303103));
    this.oOW.setBackgroundColor(1347529272);
    this.oOW.setVisibility(8);
    this.oOW.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30866);
        e.eIm().caq();
        AppMethodBeat.o(30866);
      }
    });
    this.oOX = ((LinearLayout)paramView.findViewById(2131303110));
    this.oOX.setBackgroundColor(1347529272);
    this.oOX.setVisibility(4);
    this.oOY = ((LinearLayout)paramView.findViewById(2131303105));
    this.oOY.setBackgroundColor(1347529272);
    this.oOY.setVisibility(4);
    this.oOT = ((LinearLayout)paramView.findViewById(2131299269));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.oOT.getLayoutParams();
    localLayoutParams.width = (oPa - oPb);
    localLayoutParams.height = -2;
    this.oOT.setLayoutParams(localLayoutParams);
    this.CYM = ((WXRTEditText)paramView.findViewById(2131297578));
    this.CYL = ((WXRTEditText)paramView.findViewById(2131297580));
    ((LinearLayout)paramView.findViewById(2131297579)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30867);
        j.this.CYM.bZW();
        j.this.CYM.requestFocus();
        AppMethodBeat.o(30867);
      }
    });
    ((LinearLayout)paramView.findViewById(2131297581)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30868);
        j.this.CYL.bZW();
        j.this.CYL.requestFocus();
        AppMethodBeat.o(30868);
      }
    });
    this.CYM.setEditTextType(2);
    this.CYL.setEditTextType(1);
    this.CYL.oRB = this;
    this.CYM.oRB = this;
    if ((paramk.CWB != 2) || (!this.CXj.CWC))
    {
      this.CYM.setKeyListener(null);
      this.CYM.setEnabled(false);
      this.CYM.setFocusable(false);
      this.CYL.setKeyListener(null);
      this.CYL.setEnabled(false);
      this.CYL.setFocusable(false);
    }
    this.CXj.q(this.CYL);
    this.CXj.q(this.CYM);
  }
  
  public void a(com.tencent.mm.plugin.wenote.model.a.c paramc, int paramInt1, int paramInt2)
  {
    ac.i("Micromsg.NoteOtherItemHolder", "ImageItemHolder position is " + lu());
    this.CYL.setPosInDataList(paramInt1);
    this.CYM.setPosInDataList(paramInt1);
    if (e.isEnabled()) {
      e.eIm().a(this.oOW, this.oOX, this.oOY, paramInt1);
    }
    paramc.CVD = this.CYL;
    paramc.CVE = this.CYM;
    paramc.CVF = null;
    if (paramc.oPV) {
      if (paramc.oQb) {
        this.CYL.requestFocus();
      }
    }
    for (;;)
    {
      if (this.oON.getVisibility() == 0)
      {
        if (!paramc.oQc) {
          break;
        }
        this.oON.setBackgroundResource(2131234765);
      }
      return;
      this.CYM.requestFocus();
      continue;
      if (this.CYL.hasFocus()) {
        this.CYL.clearFocus();
      }
      if (this.CYM.hasFocus()) {
        this.CYM.clearFocus();
      }
    }
    this.oON.setBackgroundResource(2131234764);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.j
 * JD-Core Version:    0.7.0.1
 */