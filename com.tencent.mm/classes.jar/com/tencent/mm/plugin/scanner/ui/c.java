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
import com.tencent.mm.plugin.scanner.util.q;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.io.IOException;

public final class c
  extends Preference
  implements u.a
{
  private TextView CKk;
  String CKl;
  String mContent;
  private TextView mPa;
  private View mView;
  String qnT;
  private ImageView qyu;
  private f screen;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51785);
    this.mView = null;
    this.qyu = null;
    this.mPa = null;
    this.CKk = null;
    setLayoutResource(2131495953);
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
    if ((!Util.isNullOrNil(paramString)) && (paramString.equals(this.CKl)) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.qyu.setImageBitmap(paramBitmap);
      this.qyu.setBackgroundColor(0);
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
    this.qyu = ((ImageView)paramView.findViewById(2131298931));
    this.mPa = ((TextView)paramView.findViewById(2131298958));
    this.CKk = ((TextView)paramView.findViewById(2131298934));
    Object localObject;
    if (!Util.isNullOrNil(this.CKl))
    {
      localObject = u.a(new q(this.CKl));
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        this.qyu.setImageBitmap((Bitmap)localObject);
        this.qyu.setBackgroundColor(0);
        if (Util.isNullOrNil(this.qnT)) {
          break label289;
        }
        this.mPa.setText(l.b(this.mContext, this.qnT, this.mPa.getTextSize()));
        label136:
        if (Util.isNullOrNil(this.mContent)) {
          break label301;
        }
        this.CKk.setText(this.mContent);
      }
    }
    for (;;)
    {
      for (;;)
      {
        if ((Util.isNullOrNil(this.qnT)) && (Util.isNullOrNil(this.CKl)))
        {
          paramView = (LinearLayout)paramView.findViewById(2131298933);
          localObject = paramView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).height = this.mContext.getResources().getDimensionPixelSize(2131166814);
          paramView.setPadding(BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 9.0F), 0, 0, 0);
          paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        AppMethodBeat.o(51787);
        return;
        try
        {
          localObject = BackwardSupportUtil.BitmapFactory.decodeStream(MMApplicationContext.getContext().getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null));
          this.qyu.setImageBitmap((Bitmap)localObject);
        }
        catch (IOException localIOException)
        {
          this.qyu.setImageBitmap(null);
        }
      }
      break;
      this.qyu.setVisibility(8);
      break;
      label289:
      this.mPa.setVisibility(8);
      break label136;
      label301:
      this.CKk.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.c
 * JD-Core Version:    0.7.0.1
 */