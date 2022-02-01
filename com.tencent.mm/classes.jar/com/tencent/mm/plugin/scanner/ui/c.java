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
import com.tencent.mm.cb.a;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.io.IOException;

public final class c
  extends Preference
  implements u.a
{
  private TextView lHk;
  String mContent;
  private View mView;
  String oYU;
  private ImageView pjj;
  private f screen;
  private TextView yGw;
  String yGx;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51785);
    this.mView = null;
    this.pjj = null;
    this.lHk = null;
    this.yGw = null;
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
    if ((!bu.isNullOrNil(paramString)) && (paramString.equals(this.yGx)) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.pjj.setImageBitmap(paramBitmap);
      this.pjj.setBackgroundColor(0);
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
    this.pjj = ((ImageView)paramView.findViewById(2131298507));
    this.lHk = ((TextView)paramView.findViewById(2131298528));
    this.yGw = ((TextView)paramView.findViewById(2131298510));
    Object localObject;
    if (!bu.isNullOrNil(this.yGx))
    {
      localObject = u.a(new n(this.yGx));
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        this.pjj.setImageBitmap((Bitmap)localObject);
        this.pjj.setBackgroundColor(0);
        if (bu.isNullOrNil(this.oYU)) {
          break label289;
        }
        this.lHk.setText(k.b(this.mContext, this.oYU, this.lHk.getTextSize()));
        label136:
        if (bu.isNullOrNil(this.mContent)) {
          break label301;
        }
        this.yGw.setText(this.mContent);
      }
    }
    for (;;)
    {
      for (;;)
      {
        if ((bu.isNullOrNil(this.oYU)) && (bu.isNullOrNil(this.yGx)))
        {
          paramView = (LinearLayout)paramView.findViewById(2131298509);
          localObject = paramView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).height = this.mContext.getResources().getDimensionPixelSize(2131166694);
          paramView.setPadding(BackwardSupportUtil.b.h(this.mContext, 9.0F), 0, 0, 0);
          paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        AppMethodBeat.o(51787);
        return;
        try
        {
          localObject = BackwardSupportUtil.b.b(ak.getContext().getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null));
          this.pjj.setImageBitmap((Bitmap)localObject);
        }
        catch (IOException localIOException)
        {
          this.pjj.setImageBitmap(null);
        }
      }
      break;
      this.pjj.setVisibility(8);
      break;
      label289:
      this.lHk.setVisibility(8);
      break label136;
      label301:
      this.yGw.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.c
 * JD-Core Version:    0.7.0.1
 */