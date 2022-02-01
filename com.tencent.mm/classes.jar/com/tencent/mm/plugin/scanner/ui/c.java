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
import com.tencent.mm.cd.a;
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
  private TextView kEu;
  String mContent;
  private View mView;
  String nLX;
  private ImageView nVN;
  private f screen;
  private TextView vRJ;
  String vRK;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51785);
    this.mView = null;
    this.nVN = null;
    this.kEu = null;
    this.vRJ = null;
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
  
  public final void l(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(51788);
    if ((!bt.isNullOrNil(paramString)) && (paramString.equals(this.vRK)) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.nVN.setImageBitmap(paramBitmap);
      this.nVN.setBackgroundColor(0);
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
    this.nVN = ((ImageView)paramView.findViewById(2131298507));
    this.kEu = ((TextView)paramView.findViewById(2131298528));
    this.vRJ = ((TextView)paramView.findViewById(2131298510));
    Object localObject;
    if (!bt.isNullOrNil(this.vRK))
    {
      localObject = u.a(new n(this.vRK));
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        this.nVN.setImageBitmap((Bitmap)localObject);
        this.nVN.setBackgroundColor(0);
        if (bt.isNullOrNil(this.nLX)) {
          break label289;
        }
        this.kEu.setText(k.b(this.mContext, this.nLX, this.kEu.getTextSize()));
        label136:
        if (bt.isNullOrNil(this.mContent)) {
          break label301;
        }
        this.vRJ.setText(this.mContent);
      }
    }
    for (;;)
    {
      for (;;)
      {
        if ((bt.isNullOrNil(this.nLX)) && (bt.isNullOrNil(this.vRK)))
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
          this.nVN.setImageBitmap((Bitmap)localObject);
        }
        catch (IOException localIOException)
        {
          this.nVN.setImageBitmap(null);
        }
      }
      break;
      this.nVN.setVisibility(8);
      break;
      label289:
      this.kEu.setVisibility(8);
      break label136;
      label301:
      this.vRJ.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.c
 * JD-Core Version:    0.7.0.1
 */