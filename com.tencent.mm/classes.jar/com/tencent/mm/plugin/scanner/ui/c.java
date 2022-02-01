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
import com.tencent.mm.ci.a;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.scanner.l.d;
import com.tencent.mm.plugin.scanner.l.f;
import com.tencent.mm.plugin.scanner.l.g;
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
  private TextView IPM;
  String IPN;
  String mContent;
  private View mView;
  private TextView pPT;
  private f screen;
  String tMB;
  private ImageView tXu;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51785);
    this.mView = null;
    this.tXu = null;
    this.pPT = null;
    this.IPM = null;
    setLayoutResource(l.g.IEk);
    u.a(this);
    AppMethodBeat.o(51785);
  }
  
  public final View c(View paramView, ViewGroup paramViewGroup)
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
    if ((!Util.isNullOrNil(paramString)) && (paramString.equals(this.IPN)) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.tXu.setImageBitmap(paramBitmap);
      this.tXu.setBackgroundColor(0);
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
    this.tXu = ((ImageView)paramView.findViewById(l.f.ICx));
    this.pPT = ((TextView)paramView.findViewById(l.f.ICy));
    this.IPM = ((TextView)paramView.findViewById(l.f.comment_content));
    Object localObject;
    if (!Util.isNullOrNil(this.IPN))
    {
      localObject = u.a(new q(this.IPN));
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        this.tXu.setImageBitmap((Bitmap)localObject);
        this.tXu.setBackgroundColor(0);
        if (Util.isNullOrNil(this.tMB)) {
          break label294;
        }
        this.pPT.setText(l.b(this.mContext, this.tMB, this.pPT.getTextSize()));
        label139:
        if (Util.isNullOrNil(this.mContent)) {
          break label306;
        }
        this.IPM.setText(this.mContent);
      }
    }
    for (;;)
    {
      for (;;)
      {
        if ((Util.isNullOrNil(this.tMB)) && (Util.isNullOrNil(this.IPN)))
        {
          paramView = (LinearLayout)paramView.findViewById(l.f.comment_container);
          localObject = paramView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).height = this.mContext.getResources().getDimensionPixelSize(l.d.IBY);
          paramView.setPadding(BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 9.0F), 0, 0, 0);
          paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        AppMethodBeat.o(51787);
        return;
        try
        {
          localObject = BackwardSupportUtil.BitmapFactory.decodeStream(MMApplicationContext.getContext().getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null));
          this.tXu.setImageBitmap((Bitmap)localObject);
        }
        catch (IOException localIOException)
        {
          this.tXu.setImageBitmap(null);
        }
      }
      break;
      this.tXu.setVisibility(8);
      break;
      label294:
      this.pPT.setVisibility(8);
      break label139;
      label306:
      this.IPM.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.c
 * JD-Core Version:    0.7.0.1
 */