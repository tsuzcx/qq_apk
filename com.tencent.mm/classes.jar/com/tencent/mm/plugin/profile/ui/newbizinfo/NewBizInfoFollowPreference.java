package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class NewBizInfoFollowPreference
  extends Preference
{
  private MMActivity cmc;
  private boolean lJS;
  private TextView pDv;
  private TextView pDw;
  a pyo;
  
  public NewBizInfoFollowPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(23851);
    this.lJS = false;
    this.cmc = ((MMActivity)paramContext);
    this.lJS = false;
    AppMethodBeat.o(23851);
  }
  
  public NewBizInfoFollowPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(23852);
    this.lJS = false;
    this.cmc = ((MMActivity)paramContext);
    this.lJS = false;
    AppMethodBeat.o(23852);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(23853);
    this.lJS = true;
    this.pDv = ((TextView)paramView.findViewById(2131823080));
    if (this.pDv.getPaint() != null) {
      this.pDv.getPaint().setFakeBoldText(true);
    }
    this.pDw = ((TextView)paramView.findViewById(2131823081));
    if (this.pDw.getPaint() != null) {
      this.pDw.getPaint().setFakeBoldText(true);
    }
    if (this.lJS)
    {
      this.pDv.setOnClickListener(new NewBizInfoFollowPreference.1(this));
      this.pDw.setOnClickListener(new NewBizInfoFollowPreference.2(this));
    }
    AppMethodBeat.o(23853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoFollowPreference
 * JD-Core Version:    0.7.0.1
 */