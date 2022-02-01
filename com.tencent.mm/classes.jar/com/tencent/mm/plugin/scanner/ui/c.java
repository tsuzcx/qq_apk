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
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.scanner.l.d;
import com.tencent.mm.plugin.scanner.l.f;
import com.tencent.mm.plugin.scanner.l.g;
import com.tencent.mm.plugin.scanner.util.s;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.io.IOException;

public final class c
  extends Preference
  implements r.a
{
  private TextView OYJ;
  String OYK;
  String mContent;
  private View mView;
  private TextView sUt;
  private f screen;
  String wPR;
  private ImageView xaN;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51785);
    this.mView = null;
    this.xaN = null;
    this.sUt = null;
    this.OYJ = null;
    setLayoutResource(l.g.OKn);
    r.a(this);
    AppMethodBeat.o(51785);
  }
  
  public final View b(View paramView, ViewGroup paramViewGroup)
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
    if ((!Util.isNullOrNil(paramString)) && (paramString.equals(this.OYK)) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.xaN.setImageBitmap(paramBitmap);
      this.xaN.setBackgroundColor(0);
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
    this.xaN = ((ImageView)paramView.findViewById(l.f.OIy));
    this.sUt = ((TextView)paramView.findViewById(l.f.OIz));
    this.OYJ = ((TextView)paramView.findViewById(l.f.comment_content));
    Object localObject;
    if (!Util.isNullOrNil(this.OYK))
    {
      localObject = r.a(new s(this.OYK));
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        this.xaN.setImageBitmap((Bitmap)localObject);
        this.xaN.setBackgroundColor(0);
        if (Util.isNullOrNil(this.wPR)) {
          break label294;
        }
        this.sUt.setText(p.b(this.mContext, this.wPR, this.sUt.getTextSize()));
        label139:
        if (Util.isNullOrNil(this.mContent)) {
          break label306;
        }
        this.OYJ.setText(this.mContent);
      }
    }
    for (;;)
    {
      for (;;)
      {
        if ((Util.isNullOrNil(this.wPR)) && (Util.isNullOrNil(this.OYK)))
        {
          paramView = (LinearLayout)paramView.findViewById(l.f.comment_container);
          localObject = paramView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).height = this.mContext.getResources().getDimensionPixelSize(l.d.OIa);
          paramView.setPadding(BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 9.0F), 0, 0, 0);
          paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        AppMethodBeat.o(51787);
        return;
        try
        {
          localObject = BackwardSupportUtil.BitmapFactory.decodeStream(MMApplicationContext.getContext().getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null));
          this.xaN.setImageBitmap((Bitmap)localObject);
        }
        catch (IOException localIOException)
        {
          this.xaN.setImageBitmap(null);
        }
      }
      break;
      this.xaN.setVisibility(8);
      break;
      label294:
      this.sUt.setVisibility(8);
      break label139;
      label306:
      this.OYJ.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.c
 * JD-Core Version:    0.7.0.1
 */