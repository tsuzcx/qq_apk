package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ui.widget.a.j;
import com.tencent.mm.view.MaxHeightScrollView;
import org.xwalk.core.Log;

public final class n
  extends j
{
  private TextView adRk;
  public ImageView adRl;
  private MaxHeightScrollView adRm;
  public boolean adRn;
  public ImageView dpM;
  private Button lDJ;
  private Button njI;
  private TextView qjr;
  private TextView titleTv;
  
  public n(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(251353);
    this.adRn = false;
    aFf(a.h.half_bottom_img_double_dlg_layout);
    this.titleTv = ((TextView)this.rootView.findViewById(a.g.tips_title));
    this.qjr = ((TextView)this.rootView.findViewById(a.g.tips_hint));
    this.lDJ = ((Button)this.rootView.findViewById(a.g.next_btn));
    this.njI = ((Button)this.rootView.findViewById(a.g.cancel_btn));
    this.adRk = ((TextView)this.rootView.findViewById(a.g.tips_hint_entry3));
    this.adRm = ((MaxHeightScrollView)this.rootView.findViewById(a.g.scroll));
    this.dpM = ((ImageView)this.rootView.findViewById(a.g.title_icon));
    if (this.adRm != null)
    {
      this.adRm.setVisibility(0);
      if ((this.adRm.getContext() instanceof Activity))
      {
        paramContext = this.adRm.getContext().getResources().getDisplayMetrics();
        if (paramContext != null)
        {
          this.adRm.setMaxHeight((int)(paramContext.heightPixels * 0.45F));
          Log.i("MicroMsg.MMHalfBottomTipsDoubleBtnDialog", "displayMetrics.heightPixels = " + paramContext.heightPixels);
        }
      }
    }
    for (;;)
    {
      this.adRl = ((ImageView)this.rootView.findViewById(a.g.education_content_iv));
      AppMethodBeat.o(251353);
      return;
      Log.i("MicroMsg.MMHalfBottomTipsDoubleBtnDialog", "displayMetrics is null");
      continue;
      Log.i("MicroMsg.MMHalfBottomTipsDoubleBtnDialog", "display is null");
      continue;
      Log.i("MicroMsg.MMHalfBottomTipsDoubleBtnDialog", "scroll is null");
    }
  }
  
  public final n bAa(String paramString)
  {
    AppMethodBeat.i(251356);
    this.qjr.setText(paramString);
    this.qjr.setVisibility(0);
    AppMethodBeat.o(251356);
    return this;
  }
  
  public final n bAb(String paramString)
  {
    AppMethodBeat.i(251368);
    this.lDJ.setText(paramString);
    AppMethodBeat.o(251368);
    return this;
  }
  
  public final n g(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(251360);
    this.lDJ.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(251360);
    return this;
  }
  
  public final n h(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(251363);
    this.njI.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(251363);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.n
 * JD-Core Version:    0.7.0.1
 */