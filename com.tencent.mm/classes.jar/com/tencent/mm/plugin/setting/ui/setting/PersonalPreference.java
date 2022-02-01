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
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.base.preference.Preference;

public class PersonalPreference
  extends Preference
{
  private String dEC;
  private TextView fRI;
  private String fhy;
  Bitmap hPl;
  ImageView rLC;
  String ssR;
  private String username;
  private TextView yUp;
  int yUq;
  private View.OnClickListener yUr;
  
  public PersonalPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.fRI = null;
    this.yUp = null;
    this.rLC = null;
    this.hPl = null;
    this.yUq = -1;
    this.ssR = null;
  }
  
  public PersonalPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(73903);
    this.fRI = null;
    this.yUp = null;
    this.rLC = null;
    this.hPl = null;
    this.yUq = -1;
    this.ssR = null;
    setLayoutResource(2131494804);
    setWidgetLayoutResource(2131494884);
    AppMethodBeat.o(73903);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(73905);
    if (this.rLC == null) {
      this.rLC = ((ImageView)paramView.findViewById(2131300943));
    }
    if (this.hPl != null)
    {
      this.rLC.setImageBitmap(this.hPl);
      this.rLC.setOnClickListener(this.yUr);
      if ((this.fRI != null) && (this.dEC != null)) {
        this.fRI.setText(k.b(this.mContext, this.dEC, this.fRI.getTextSize()));
      }
      if (this.yUp != null) {
        if (!bu.isNullOrNil(this.fhy)) {
          break label230;
        }
      }
    }
    label230:
    for (String str = this.username;; str = this.fhy)
    {
      if ((bu.isNullOrNil(this.fhy)) && (an.aUy(this.username))) {
        this.yUp.setVisibility(8);
      }
      this.yUp.setText(this.mContext.getString(2131755760) + str);
      super.onBindView(paramView);
      AppMethodBeat.o(73905);
      return;
      if (this.yUq > 0)
      {
        this.rLC.setImageResource(this.yUq);
        break;
      }
      if (this.ssR == null) {
        break;
      }
      a.b.c(this.rLC, this.ssR);
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