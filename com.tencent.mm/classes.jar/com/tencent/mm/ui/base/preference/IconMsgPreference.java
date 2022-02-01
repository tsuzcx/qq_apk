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
import com.tencent.mm.sdk.platformtools.bt;

public class IconMsgPreference
  extends Preference
{
  private int JrZ;
  private int Jsa;
  private int Jsb;
  private ImageView Jsc;
  private ViewGroup Jsd;
  private TextView Jse;
  private String Jsf;
  private Context context;
  private Drawable drawable;
  private int height;
  private String wSC;
  private int yEp;
  private int yEq;
  
  public IconMsgPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IconMsgPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142540);
    this.wSC = "";
    this.yEp = -1;
    this.yEq = 8;
    this.JrZ = 8;
    this.Jsa = 0;
    this.Jsb = 8;
    this.Jsc = null;
    this.Jsd = null;
    this.height = -1;
    this.Jsf = "";
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
        ((TextView)localObject).setVisibility(this.yEq);
        ((TextView)localObject).setText(this.wSC);
        if (this.yEp != -1) {
          ((TextView)localObject).setBackgroundDrawable(a.l(this.context, this.yEp));
        }
      }
      this.Jsc = ((ImageView)paramView.findViewById(2131305740));
      this.Jsc.setVisibility(this.JrZ);
      this.Jsd = ((ViewGroup)paramView.findViewById(2131304191));
      this.Jsd.setVisibility(this.Jsa);
      this.Jse = ((TextView)paramView.findViewById(16908310));
      paramView = (TextView)paramView.findViewById(2131305746);
      if (!bt.isNullOrNil(this.Jsf)) {
        break;
      }
      paramView.setVisibility(8);
      AppMethodBeat.o(142542);
      return;
      label216:
      if (this.aeA != 0)
      {
        ((ImageView)localObject).setImageResource(this.aeA);
        ((ImageView)localObject).setVisibility(0);
      }
      else
      {
        ((ImageView)localObject).setVisibility(8);
      }
    }
    paramView.setVisibility(0);
    paramView.setText(this.Jsf);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.IconMsgPreference
 * JD-Core Version:    0.7.0.1
 */