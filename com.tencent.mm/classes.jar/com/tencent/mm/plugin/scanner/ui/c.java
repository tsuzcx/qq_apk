package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.io.IOException;

public final class c
  extends Preference
  implements u.a
{
  private TextView lCL;
  String mContent;
  private View mView;
  String oSs;
  private ImageView pcD;
  private f screen;
  private TextView yqw;
  String yqx;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51785);
    this.mView = null;
    this.pcD = null;
    this.lCL = null;
    this.yqw = null;
    setLayoutResource(2131495110);
    u.a(this);
    AppMethodBeat.o(51785);
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(51786);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(51786);
    return paramView;
  }
  
  public final void k(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(51788);
    if ((!bt.isNullOrNil(paramString)) && (paramString.equals(this.yqx)) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.pcD.setImageBitmap(paramBitmap);
      this.pcD.setBackgroundColor(0);
      if (this.screen != null) {
        this.screen.notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(51788);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(51787);
    super.onBindView(paramView);
    this.pcD = ((ImageView)paramView.findViewById(2131298507));
    this.lCL = ((TextView)paramView.findViewById(2131298528));
    this.yqw = ((TextView)paramView.findViewById(2131298510));
    Object localObject;
    if (!bt.isNullOrNil(this.yqx))
    {
      localObject = u.a(new n(this.yqx));
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        this.pcD.setImageBitmap((Bitmap)localObject);
        this.pcD.setBackgroundColor(0);
        if (bt.isNullOrNil(this.oSs)) {
          break label289;
        }
        this.lCL.setText(k.b(this.mContext, this.oSs, this.lCL.getTextSize()));
        label136:
        if (bt.isNullOrNil(this.mContent)) {
          break label301;
        }
        this.yqw.setText(this.mContent);
      }
    }
    for (;;)
    {
      for (;;)
      {
        if ((bt.isNullOrNil(this.oSs)) && (bt.isNullOrNil(this.yqx)))
        {
          paramView = (LinearLayout)paramView.findViewById(2131298509);
          localObject = paramView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).height = this.mContext.getResources().getDimensionPixelSize(2131166694);
          paramView.setPadding(BackwardSupportUtil.b.g(this.mContext, 9.0F), 0, 0, 0);
          paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        AppMethodBeat.o(51787);
        return;
        try
        {
          localObject = BackwardSupportUtil.b.b(aj.getContext().getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null));
          this.pcD.setImageBitmap((Bitmap)localObject);
        }
        catch (IOException localIOException)
        {
          this.pcD.setImageBitmap(null);
        }
      }
      break;
      this.pcD.setVisibility(8);
      break;
      label289:
      this.lCL.setVisibility(8);
      break label136;
      label301:
      this.yqw.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.c
 * JD-Core Version:    0.7.0.1
 */