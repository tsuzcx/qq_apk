package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.Preference;

public final class HeadImgPreference
  extends Preference
{
  private int height;
  private ImageView iTH;
  private View.OnClickListener qMg;
  private Bitmap waS;
  
  public HeadImgPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HeadImgPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(28066);
    this.height = -1;
    setLayoutResource(2130970179);
    AppMethodBeat.o(28066);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(28068);
    super.onBindView(paramView);
    if (this.iTH == null) {
      this.iTH = ((ImageView)paramView.findViewById(2131826214));
    }
    if (this.qMg != null) {
      this.iTH.setOnClickListener(this.qMg);
    }
    if (this.waS != null)
    {
      this.iTH.setImageBitmap(this.waS);
      this.waS = null;
    }
    paramView = (LinearLayout)paramView.findViewById(2131822408);
    if (this.height != -1) {
      paramView.setMinimumHeight(this.height);
    }
    AppMethodBeat.o(28068);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(28067);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2130970201, localViewGroup);
    this.iTH = ((ImageView)paramViewGroup.findViewById(2131826214));
    AppMethodBeat.o(28067);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.HeadImgPreference
 * JD-Core Version:    0.7.0.1
 */