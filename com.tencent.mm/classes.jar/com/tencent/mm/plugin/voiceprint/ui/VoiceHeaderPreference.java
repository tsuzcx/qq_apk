package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class VoiceHeaderPreference
  extends Preference
{
  private ImageView gBZ;
  private MMActivity gte;
  private TextView jBS;
  private String mTitle;
  private int sUb;
  private Button sUc;
  private View sUd;
  private View.OnClickListener sUe;
  private String sUf;
  private String sUg;
  private TextView titleTv;
  
  public VoiceHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(29867);
    this.gte = ((MMActivity)paramContext);
    AppMethodBeat.o(29867);
  }
  
  public VoiceHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29868);
    this.mTitle = "";
    this.sUb = 255;
    this.sUe = null;
    this.sUf = "";
    this.sUg = "";
    this.gte = ((MMActivity)paramContext);
    setLayoutResource(2131496845);
    AppMethodBeat.o(29868);
  }
  
  public final void b(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(29870);
    this.sUe = paramOnClickListener;
    if ((this.sUc == null) || (this.sUd == null))
    {
      AppMethodBeat.o(29870);
      return;
    }
    if ((this.sUc != null) && (this.sUe != null))
    {
      this.sUc.setOnClickListener(paramOnClickListener);
      this.sUc.setVisibility(0);
      this.sUd.setVisibility(0);
      AppMethodBeat.o(29870);
      return;
    }
    this.sUc.setVisibility(8);
    this.sUd.setVisibility(8);
    AppMethodBeat.o(29870);
  }
  
  public final void gD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(29869);
    this.sUf = paramString1;
    this.sUg = paramString2;
    if (this.titleTv != null)
    {
      if (Util.isNullOrNil(this.sUf)) {
        break label95;
      }
      this.titleTv.setText(this.sUf);
      this.titleTv.setVisibility(0);
    }
    while (this.jBS != null) {
      if (!Util.isNullOrNil(this.sUg))
      {
        this.jBS.setText(this.sUg);
        this.jBS.setVisibility(0);
        AppMethodBeat.o(29869);
        return;
        label95:
        this.titleTv.setVisibility(8);
      }
      else
      {
        this.jBS.setVisibility(8);
      }
    }
    AppMethodBeat.o(29869);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(29871);
    super.onBindView(paramView);
    this.gBZ = ((ImageView)paramView.findViewById(2131309973));
    this.titleTv = ((TextView)paramView.findViewById(2131309974));
    this.jBS = ((TextView)paramView.findViewById(2131309976));
    this.sUc = ((Button)paramView.findViewById(2131307087));
    this.sUd = paramView.findViewById(2131297921);
    if (!Util.isNullOrNil(this.sUf))
    {
      this.titleTv.setText(this.sUf);
      this.titleTv.setVisibility(0);
      if (Util.isNullOrNil(this.sUg)) {
        break label191;
      }
      this.jBS.setText(this.sUg);
      this.jBS.setVisibility(0);
    }
    for (;;)
    {
      if ((this.sUc == null) || (this.sUe == null)) {
        break label203;
      }
      this.sUc.setOnClickListener(this.sUe);
      this.sUc.setVisibility(0);
      this.sUd.setVisibility(0);
      AppMethodBeat.o(29871);
      return;
      this.titleTv.setVisibility(8);
      break;
      label191:
      this.jBS.setVisibility(8);
    }
    label203:
    this.sUc.setVisibility(8);
    this.sUd.setVisibility(8);
    AppMethodBeat.o(29871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceHeaderPreference
 * JD-Core Version:    0.7.0.1
 */