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
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.ui.base.preference.Preference;

public class PersonalPreference
  extends Preference
{
  private String dDx;
  private TextView fPC;
  private String ffB;
  Bitmap hMs;
  ImageView rDr;
  String sjU;
  private String username;
  private TextView yEk;
  int yEl;
  private View.OnClickListener yEm;
  
  public PersonalPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.fPC = null;
    this.yEk = null;
    this.rDr = null;
    this.hMs = null;
    this.yEl = -1;
    this.sjU = null;
  }
  
  public PersonalPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(73903);
    this.fPC = null;
    this.yEk = null;
    this.rDr = null;
    this.hMs = null;
    this.yEl = -1;
    this.sjU = null;
    setLayoutResource(2131494804);
    setWidgetLayoutResource(2131494884);
    AppMethodBeat.o(73903);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(73905);
    if (this.rDr == null) {
      this.rDr = ((ImageView)paramView.findViewById(2131300943));
    }
    if (this.hMs != null)
    {
      this.rDr.setImageBitmap(this.hMs);
      this.rDr.setOnClickListener(this.yEm);
      if ((this.fPC != null) && (this.dDx != null)) {
        this.fPC.setText(k.b(this.mContext, this.dDx, this.fPC.getTextSize()));
      }
      if (this.yEk != null) {
        if (!bt.isNullOrNil(this.ffB)) {
          break label230;
        }
      }
    }
    label230:
    for (String str = this.username;; str = this.ffB)
    {
      if ((bt.isNullOrNil(this.ffB)) && (am.aSX(this.username))) {
        this.yEk.setVisibility(8);
      }
      this.yEk.setText(this.mContext.getString(2131755760) + str);
      super.onBindView(paramView);
      AppMethodBeat.o(73905);
      return;
      if (this.yEl > 0)
      {
        this.rDr.setImageResource(this.yEl);
        break;
      }
      if (this.sjU == null) {
        break;
      }
      a.b.c(this.rDr, this.sjU);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.PersonalPreference
 * JD-Core Version:    0.7.0.1
 */