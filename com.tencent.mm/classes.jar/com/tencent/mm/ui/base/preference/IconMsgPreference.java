package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.bs;

public class IconMsgPreference
  extends Preference
{
  private int HEj;
  private int HEk;
  private int HEl;
  private ImageView HEm;
  private ViewGroup HEn;
  private TextView HEo;
  private String HEp;
  private Context context;
  private Drawable drawable;
  private int height;
  private String vLt;
  private int xpM;
  private int xpN;
  
  public IconMsgPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IconMsgPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142540);
    this.vLt = "";
    this.xpM = -1;
    this.xpN = 8;
    this.HEj = 8;
    this.HEk = 0;
    this.HEl = 8;
    this.HEm = null;
    this.HEn = null;
    this.height = -1;
    this.HEp = "";
    this.context = paramContext;
    setLayoutResource(2131494804);
    AppMethodBeat.o(142540);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(142542);
    super.onBindView(paramView);
    Object localObject = (ImageView)paramView.findViewById(2131300943);
    if (localObject != null)
    {
      if (this.drawable == null) {
        break label216;
      }
      ((ImageView)localObject).setImageDrawable(this.drawable);
      ((ImageView)localObject).setVisibility(0);
    }
    for (;;)
    {
      localObject = (LinearLayout)paramView.findViewById(2131302326);
      if (this.height != -1) {
        ((LinearLayout)localObject).setMinimumHeight(this.height);
      }
      localObject = (TextView)paramView.findViewById(2131305745);
      if (localObject != null)
      {
        ((TextView)localObject).setVisibility(this.xpN);
        ((TextView)localObject).setText(this.vLt);
        if (this.xpM != -1) {
          ((TextView)localObject).setBackgroundDrawable(a.l(this.context, this.xpM));
        }
      }
      this.HEm = ((ImageView)paramView.findViewById(2131305740));
      this.HEm.setVisibility(this.HEj);
      this.HEn = ((ViewGroup)paramView.findViewById(2131304191));
      this.HEn.setVisibility(this.HEk);
      this.HEo = ((TextView)paramView.findViewById(16908310));
      paramView = (TextView)paramView.findViewById(2131305746);
      if (!bs.isNullOrNil(this.HEp)) {
        break;
      }
      paramView.setVisibility(8);
      AppMethodBeat.o(142542);
      return;
      label216:
      if (this.acJ != 0)
      {
        ((ImageView)localObject).setImageResource(this.acJ);
        ((ImageView)localObject).setVisibility(0);
      }
      else
      {
        ((ImageView)localObject).setVisibility(8);
      }
    }
    paramView.setVisibility(0);
    paramView.setText(this.HEp);
    AppMethodBeat.o(142542);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142541);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2131494858, localViewGroup);
    paramViewGroup.setMinimumHeight(paramViewGroup.getResources().getDimensionPixelSize(2131165567));
    AppMethodBeat.o(142541);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.IconMsgPreference
 * JD-Core Version:    0.7.0.1
 */