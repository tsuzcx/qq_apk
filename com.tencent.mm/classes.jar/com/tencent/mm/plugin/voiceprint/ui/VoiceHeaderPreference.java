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
  private MMActivity iXq;
  private ImageView jmf;
  private String mTitle;
  private TextView mrN;
  private TextView titleTv;
  private View.OnClickListener wAa;
  private String wAb;
  private String wAc;
  private int wzX;
  private Button wzY;
  private View wzZ;
  
  public VoiceHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(29867);
    this.iXq = ((MMActivity)paramContext);
    AppMethodBeat.o(29867);
  }
  
  public VoiceHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29868);
    this.mTitle = "";
    this.wzX = 255;
    this.wAa = null;
    this.wAb = "";
    this.wAc = "";
    this.iXq = ((MMActivity)paramContext);
    setLayoutResource(R.i.elS);
    AppMethodBeat.o(29868);
  }
  
  public final void c(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(29870);
    this.wAa = paramOnClickListener;
    if ((this.wzY == null) || (this.wzZ == null))
    {
      AppMethodBeat.o(29870);
      return;
    }
    if ((this.wzY != null) && (this.wAa != null))
    {
      this.wzY.setOnClickListener(paramOnClickListener);
      this.wzY.setVisibility(0);
      this.wzZ.setVisibility(0);
      AppMethodBeat.o(29870);
      return;
    }
    this.wzY.setVisibility(8);
    this.wzZ.setVisibility(8);
    AppMethodBeat.o(29870);
  }
  
  public final void gR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(29869);
    this.wAb = paramString1;
    this.wAc = paramString2;
    if (this.titleTv != null)
    {
      if (Util.isNullOrNil(this.wAb)) {
        break label95;
      }
      this.titleTv.setText(this.wAb);
      this.titleTv.setVisibility(0);
    }
    while (this.mrN != null) {
      if (!Util.isNullOrNil(this.wAc))
      {
        this.mrN.setText(this.wAc);
        this.mrN.setVisibility(0);
        AppMethodBeat.o(29869);
        return;
        label95:
        this.titleTv.setVisibility(8);
      }
      else
      {
        this.mrN.setVisibility(8);
      }
    }
    AppMethodBeat.o(29869);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(29871);
    super.onBindView(paramView);
    this.jmf = ((ImageView)paramView.findViewById(R.h.voice_print_sucesss_icon));
    this.titleTv = ((TextView)paramView.findViewById(R.h.eag));
    this.mrN = ((TextView)paramView.findViewById(R.h.voice_print_title_tip));
    this.wzY = ((Button)paramView.findViewById(R.h.right_btn));
    this.wzZ = paramView.findViewById(R.h.button_ll);
    if (!Util.isNullOrNil(this.wAb))
    {
      this.titleTv.setText(this.wAb);
      this.titleTv.setVisibility(0);
      if (Util.isNullOrNil(this.wAc)) {
        break label196;
      }
      this.mrN.setText(this.wAc);
      this.mrN.setVisibility(0);
    }
    for (;;)
    {
      if ((this.wzY == null) || (this.wAa == null)) {
        break label208;
      }
      this.wzY.setOnClickListener(this.wAa);
      this.wzY.setVisibility(0);
      this.wzZ.setVisibility(0);
      AppMethodBeat.o(29871);
      return;
      this.titleTv.setVisibility(8);
      break;
      label196:
      this.mrN.setVisibility(8);
    }
    label208:
    this.wzY.setVisibility(8);
    this.wzZ.setVisibility(8);
    AppMethodBeat.o(29871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceHeaderPreference
 * JD-Core Version:    0.7.0.1
 */