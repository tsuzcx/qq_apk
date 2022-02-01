package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ui.widget.a.j;
import com.tencent.mm.view.MaxHeightScrollView;
import org.xwalk.core.Log;

public final class p
  extends j
{
  private TextView adRk;
  private MaxHeightScrollView adRm;
  public boolean adRn;
  private Button lDJ;
  private Button njI;
  public TextView qjr;
  private TextView titleTv;
  
  public p(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(251347);
    this.adRn = false;
    aFf(a.h.half_bottom_tips_double_dlg_layout);
    this.titleTv = ((TextView)this.rootView.findViewById(a.g.tips_title));
    this.qjr = ((TextView)this.rootView.findViewById(a.g.tips_hint));
    this.lDJ = ((Button)this.rootView.findViewById(a.g.next_btn));
    this.njI = ((Button)this.rootView.findViewById(a.g.cancel_btn));
    this.adRk = ((TextView)this.rootView.findViewById(a.g.tips_hint_entry3));
    this.adRm = ((MaxHeightScrollView)this.rootView.findViewById(a.g.scroll));
    if (this.adRm != null)
    {
      if ((this.adRm.getContext() instanceof Activity))
      {
        paramContext = this.adRm.getContext().getResources().getDisplayMetrics();
        if (paramContext != null)
        {
          this.adRm.setMaxHeight((int)(paramContext.heightPixels * 0.45F));
          Log.i("MicroMsg.MMHalfBottomTipsDoubleBtnDialog", "displayMetrics.heightPixels = " + paramContext.heightPixels);
          AppMethodBeat.o(251347);
          return;
        }
        Log.i("MicroMsg.MMHalfBottomTipsDoubleBtnDialog", "displayMetrics is null");
        AppMethodBeat.o(251347);
        return;
      }
      Log.i("MicroMsg.MMHalfBottomTipsDoubleBtnDialog", "display is null");
    }
    AppMethodBeat.o(251347);
  }
  
  public final p bAe(String paramString)
  {
    AppMethodBeat.i(251349);
    this.titleTv.setText(paramString);
    AppMethodBeat.o(251349);
    return this;
  }
  
  public final p bAf(String paramString)
  {
    AppMethodBeat.i(251351);
    this.qjr.setText(paramString);
    AppMethodBeat.o(251351);
    return this;
  }
  
  public final p bAg(String paramString)
  {
    AppMethodBeat.i(251359);
    this.lDJ.setText(paramString);
    AppMethodBeat.o(251359);
    return this;
  }
  
  public final p j(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(251352);
    this.lDJ.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(251352);
    return this;
  }
  
  public final p jmq()
  {
    AppMethodBeat.i(251362);
    this.adRk.setVisibility(8);
    AppMethodBeat.o(251362);
    return this;
  }
  
  public final p k(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(251354);
    this.njI.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(251354);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.p
 * JD-Core Version:    0.7.0.1
 */