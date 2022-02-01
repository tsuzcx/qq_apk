package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.preference.Preference;

public class PersonalPreference
  extends Preference
{
  int CZh;
  private String dWp;
  private String fMb;
  private TextView gwR;
  Bitmap iKs;
  private View.OnClickListener tAc;
  ImageView tlo;
  String uNR;
  private TextView userTV;
  private String username;
  
  public PersonalPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.gwR = null;
    this.userTV = null;
    this.tlo = null;
    this.iKs = null;
    this.CZh = -1;
    this.uNR = null;
  }
  
  public PersonalPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(73903);
    this.gwR = null;
    this.userTV = null;
    this.tlo = null;
    this.iKs = null;
    this.CZh = -1;
    this.uNR = null;
    setLayoutResource(2131495538);
    setWidgetLayoutResource(2131495622);
    AppMethodBeat.o(73903);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(73905);
    if (this.tlo == null) {
      this.tlo = ((ImageView)paramView.findViewById(2131302573));
    }
    if (this.iKs != null)
    {
      this.tlo.setImageBitmap(this.iKs);
      this.tlo.setOnClickListener(this.tAc);
      if ((this.gwR != null) && (this.dWp != null)) {
        this.gwR.setText(l.b(this.mContext, this.dWp, this.gwR.getTextSize()));
      }
      if (this.userTV != null) {
        if (!Util.isNullOrNil(this.fMb)) {
          break label230;
        }
      }
    }
    label230:
    for (String str = this.username;; str = this.fMb)
    {
      if ((Util.isNullOrNil(this.fMb)) && (as.bjx(this.username))) {
        this.userTV.setVisibility(8);
      }
      this.userTV.setText(this.mContext.getString(2131755837) + str);
      super.onBindView(paramView);
      AppMethodBeat.o(73905);
      return;
      if (this.CZh > 0)
      {
        this.tlo.setImageResource(this.CZh);
        break;
      }
      if (this.uNR == null) {
        break;
      }
      a.b.c(this.tlo, this.uNR);
      break;
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(73904);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2131495573, localViewGroup);
    AppMethodBeat.o(73904);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.PersonalPreference
 * JD-Core Version:    0.7.0.1
 */