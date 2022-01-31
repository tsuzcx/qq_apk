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
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.scanner.util.s;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.io.IOException;

public final class d
  extends Preference
  implements x.a
{
  private TextView iJG;
  String kEW;
  private ImageView kPy;
  String mContent;
  private View mView;
  private TextView qwP;
  String qwQ;
  private f screen;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(81006);
    this.mView = null;
    this.kPy = null;
    this.iJG = null;
    this.qwP = null;
    setLayoutResource(2130970437);
    x.a(this);
    AppMethodBeat.o(81006);
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(81007);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(81007);
    return paramView;
  }
  
  public final void m(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(81009);
    if ((!bo.isNullOrNil(paramString)) && (paramString.equals(this.qwQ)) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.kPy.setImageBitmap(paramBitmap);
      this.kPy.setBackgroundColor(0);
      if (this.screen != null) {
        this.screen.notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(81009);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(81008);
    super.onBindView(paramView);
    this.kPy = ((ImageView)paramView.findViewById(2131826768));
    this.iJG = ((TextView)paramView.findViewById(2131826769));
    this.qwP = ((TextView)paramView.findViewById(2131826770));
    Object localObject;
    if (!bo.isNullOrNil(this.qwQ))
    {
      localObject = x.a(new s(this.qwQ));
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        this.kPy.setImageBitmap((Bitmap)localObject);
        this.kPy.setBackgroundColor(0);
        if (bo.isNullOrNil(this.kEW)) {
          break label289;
        }
        this.iJG.setText(j.b(this.mContext, this.kEW, this.iJG.getTextSize()));
        label136:
        if (bo.isNullOrNil(this.mContent)) {
          break label301;
        }
        this.qwP.setText(this.mContent);
      }
    }
    for (;;)
    {
      for (;;)
      {
        if ((bo.isNullOrNil(this.kEW)) && (bo.isNullOrNil(this.qwQ)))
        {
          paramView = (LinearLayout)paramView.findViewById(2131826767);
          localObject = paramView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).height = this.mContext.getResources().getDimensionPixelSize(2131428623);
          paramView.setPadding(BackwardSupportUtil.b.b(this.mContext, 9.0F), 0, 0, 0);
          paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        AppMethodBeat.o(81008);
        return;
        try
        {
          localObject = BackwardSupportUtil.b.b(ah.getContext().getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null));
          this.kPy.setImageBitmap((Bitmap)localObject);
        }
        catch (IOException localIOException)
        {
          this.kPy.setImageBitmap(null);
        }
      }
      break;
      this.kPy.setVisibility(8);
      break;
      label289:
      this.iJG.setVisibility(8);
      break label136;
      label301:
      this.qwP.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.d
 * JD-Core Version:    0.7.0.1
 */