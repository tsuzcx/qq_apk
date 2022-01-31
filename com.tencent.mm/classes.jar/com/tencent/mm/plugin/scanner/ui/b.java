package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.scanner.util.s;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class b
  extends Preference
  implements x.a
{
  String ljG;
  private Context mContext;
  private View mView;
  private ImageView qvy;
  f screen;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(80903);
    this.mView = null;
    this.qvy = null;
    setLayoutResource(2130970435);
    x.a(this);
    this.mContext = paramContext;
    AppMethodBeat.o(80903);
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(80904);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(80904);
    return paramView;
  }
  
  public final void m(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(80906);
    if ((!bo.isNullOrNil(paramString)) && (paramString.equals(this.ljG)) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.qvy.setImageBitmap(paramBitmap);
      this.qvy.setBackgroundColor(0);
      if (this.screen != null) {
        this.screen.notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(80906);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(80905);
    super.onBindView(paramView);
    this.qvy = ((ImageView)paramView.findViewById(2131826766));
    if (!bo.isNullOrNil(this.ljG))
    {
      paramView = x.a(new s(this.ljG));
      if ((paramView != null) && (!paramView.isRecycled()))
      {
        this.qvy.setImageBitmap(paramView);
        this.qvy.setBackgroundColor(0);
        AppMethodBeat.o(80905);
        return;
      }
      this.qvy.setBackgroundColor(this.mContext.getResources().getColor(2131690158));
      this.qvy.setImageBitmap(null);
    }
    AppMethodBeat.o(80905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.b
 * JD-Core Version:    0.7.0.1
 */