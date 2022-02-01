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
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.base.preference.Preference;

public class PersonalPreference
  extends Preference
{
  private String dtU;
  private String eKn;
  private TextView fsI;
  Bitmap gTB;
  String qDs;
  ImageView qkM;
  private String username;
  private TextView wet;
  int weu;
  private View.OnClickListener wev;
  
  public PersonalPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.fsI = null;
    this.wet = null;
    this.qkM = null;
    this.gTB = null;
    this.weu = -1;
    this.qDs = null;
  }
  
  public PersonalPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(73903);
    this.fsI = null;
    this.wet = null;
    this.qkM = null;
    this.gTB = null;
    this.weu = -1;
    this.qDs = null;
    setLayoutResource(2131494804);
    setWidgetLayoutResource(2131494884);
    AppMethodBeat.o(73903);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(73905);
    if (this.qkM == null) {
      this.qkM = ((ImageView)paramView.findViewById(2131300943));
    }
    if (this.gTB != null)
    {
      this.qkM.setImageBitmap(this.gTB);
      this.qkM.setOnClickListener(this.wev);
      if ((this.fsI != null) && (this.dtU != null)) {
        this.fsI.setText(k.b(this.mContext, this.dtU, this.fsI.getTextSize()));
      }
      if (this.wet != null) {
        if (!bt.isNullOrNil(this.eKn)) {
          break label230;
        }
      }
    }
    label230:
    for (String str = this.username;; str = this.eKn)
    {
      if ((bt.isNullOrNil(this.eKn)) && (af.aHK(this.username))) {
        this.wet.setVisibility(8);
      }
      this.wet.setText(this.mContext.getString(2131755760) + str);
      super.onBindView(paramView);
      AppMethodBeat.o(73905);
      return;
      if (this.weu > 0)
      {
        this.qkM.setImageResource(this.weu);
        break;
      }
      if (this.qDs == null) {
        break;
      }
      a.b.c(this.qkM, this.qDs);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.PersonalPreference
 * JD-Core Version:    0.7.0.1
 */