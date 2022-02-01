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
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.preference.Preference;

public class PersonalPreference
  extends Preference
{
  private String drF;
  private String eNf;
  private TextView fwp;
  Bitmap hua;
  ImageView qTo;
  String ruB;
  private String username;
  private TextView xpH;
  int xpI;
  private View.OnClickListener xpJ;
  
  public PersonalPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.fwp = null;
    this.xpH = null;
    this.qTo = null;
    this.hua = null;
    this.xpI = -1;
    this.ruB = null;
  }
  
  public PersonalPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(73903);
    this.fwp = null;
    this.xpH = null;
    this.qTo = null;
    this.hua = null;
    this.xpI = -1;
    this.ruB = null;
    setLayoutResource(2131494804);
    setWidgetLayoutResource(2131494884);
    AppMethodBeat.o(73903);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(73905);
    if (this.qTo == null) {
      this.qTo = ((ImageView)paramView.findViewById(2131300943));
    }
    if (this.hua != null)
    {
      this.qTo.setImageBitmap(this.hua);
      this.qTo.setOnClickListener(this.xpJ);
      if ((this.fwp != null) && (this.drF != null)) {
        this.fwp.setText(k.b(this.mContext, this.drF, this.fwp.getTextSize()));
      }
      if (this.xpH != null) {
        if (!bs.isNullOrNil(this.eNf)) {
          break label230;
        }
      }
    }
    label230:
    for (String str = this.username;; str = this.eNf)
    {
      if ((bs.isNullOrNil(this.eNf)) && (ai.aNf(this.username))) {
        this.xpH.setVisibility(8);
      }
      this.xpH.setText(this.mContext.getString(2131755760) + str);
      super.onBindView(paramView);
      AppMethodBeat.o(73905);
      return;
      if (this.xpI > 0)
      {
        this.qTo.setImageResource(this.xpI);
        break;
      }
      if (this.ruB == null) {
        break;
      }
      a.b.c(this.qTo, this.ruB);
      break;
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(73904);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2131494838, localViewGroup);
    AppMethodBeat.o(73904);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.PersonalPreference
 * JD-Core Version:    0.7.0.1
 */