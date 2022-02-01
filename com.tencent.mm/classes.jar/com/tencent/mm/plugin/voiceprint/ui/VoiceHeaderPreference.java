package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class VoiceHeaderPreference
  extends Preference
{
  private ImageView lPb;
  private MMActivity lzt;
  private String mTitle;
  private TextView pls;
  private TextView titleTv;
  private int zWi;
  private Button zWj;
  private View zWk;
  private View.OnClickListener zWl;
  private String zWm;
  private String zWn;
  
  public VoiceHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(29867);
    this.lzt = ((MMActivity)paramContext);
    AppMethodBeat.o(29867);
  }
  
  public VoiceHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29868);
    this.mTitle = "";
    this.zWi = 255;
    this.zWl = null;
    this.zWm = "";
    this.zWn = "";
    this.lzt = ((MMActivity)paramContext);
    setLayoutResource(R.i.goW);
    AppMethodBeat.o(29868);
  }
  
  public final void c(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(29870);
    this.zWl = paramOnClickListener;
    if ((this.zWj == null) || (this.zWk == null))
    {
      AppMethodBeat.o(29870);
      return;
    }
    if ((this.zWj != null) && (this.zWl != null))
    {
      this.zWj.setOnClickListener(paramOnClickListener);
      this.zWj.setVisibility(0);
      this.zWk.setVisibility(0);
      AppMethodBeat.o(29870);
      return;
    }
    this.zWj.setVisibility(8);
    this.zWk.setVisibility(8);
    AppMethodBeat.o(29870);
  }
  
  public final void hA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(29869);
    this.zWm = paramString1;
    this.zWn = paramString2;
    if (this.titleTv != null)
    {
      if (Util.isNullOrNil(this.zWm)) {
        break label95;
      }
      this.titleTv.setText(this.zWm);
      this.titleTv.setVisibility(0);
    }
    while (this.pls != null) {
      if (!Util.isNullOrNil(this.zWn))
      {
        this.pls.setText(this.zWn);
        this.pls.setVisibility(0);
        AppMethodBeat.o(29869);
        return;
        label95:
        this.titleTv.setVisibility(8);
      }
      else
      {
        this.pls.setVisibility(8);
      }
    }
    AppMethodBeat.o(29869);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(29871);
    super.onBindView(paramView);
    this.lPb = ((ImageView)paramView.findViewById(R.h.gcU));
    this.titleTv = ((TextView)paramView.findViewById(R.h.gcV));
    this.pls = ((TextView)paramView.findViewById(R.h.gcX));
    this.zWj = ((Button)paramView.findViewById(R.h.right_btn));
    this.zWk = paramView.findViewById(R.h.button_ll);
    if (!Util.isNullOrNil(this.zWm))
    {
      this.titleTv.setText(this.zWm);
      this.titleTv.setVisibility(0);
      if (Util.isNullOrNil(this.zWn)) {
        break label196;
      }
      this.pls.setText(this.zWn);
      this.pls.setVisibility(0);
    }
    for (;;)
    {
      if ((this.zWj == null) || (this.zWl == null)) {
        break label208;
      }
      this.zWj.setOnClickListener(this.zWl);
      this.zWj.setVisibility(0);
      this.zWk.setVisibility(0);
      AppMethodBeat.o(29871);
      return;
      this.titleTv.setVisibility(8);
      break;
      label196:
      this.pls.setVisibility(8);
    }
    label208:
    this.zWj.setVisibility(8);
    this.zWk.setVisibility(8);
    AppMethodBeat.o(29871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceHeaderPreference
 * JD-Core Version:    0.7.0.1
 */