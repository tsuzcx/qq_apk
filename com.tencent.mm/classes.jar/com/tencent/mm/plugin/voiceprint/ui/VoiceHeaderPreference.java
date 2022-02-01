package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class VoiceHeaderPreference
  extends Preference
{
  private MMActivity fNT;
  private ImageView fWT;
  private TextView iFP;
  private String mTitle;
  private View rtA;
  private View.OnClickListener rtB;
  private String rtC;
  private String rtD;
  private int rty;
  private Button rtz;
  private TextView titleTv;
  
  public VoiceHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(29867);
    this.fNT = ((MMActivity)paramContext);
    AppMethodBeat.o(29867);
  }
  
  public VoiceHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29868);
    this.mTitle = "";
    this.rty = 255;
    this.rtB = null;
    this.rtC = "";
    this.rtD = "";
    this.fNT = ((MMActivity)paramContext);
    setLayoutResource(2131495865);
    AppMethodBeat.o(29868);
  }
  
  public final void b(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(29870);
    this.rtB = paramOnClickListener;
    if ((this.rtz == null) || (this.rtA == null))
    {
      AppMethodBeat.o(29870);
      return;
    }
    if ((this.rtz != null) && (this.rtB != null))
    {
      this.rtz.setOnClickListener(paramOnClickListener);
      this.rtz.setVisibility(0);
      this.rtA.setVisibility(0);
      AppMethodBeat.o(29870);
      return;
    }
    this.rtz.setVisibility(8);
    this.rtA.setVisibility(8);
    AppMethodBeat.o(29870);
  }
  
  public final void gl(String paramString1, String paramString2)
  {
    AppMethodBeat.i(29869);
    this.rtC = paramString1;
    this.rtD = paramString2;
    if (this.titleTv != null)
    {
      if (bu.isNullOrNil(this.rtC)) {
        break label95;
      }
      this.titleTv.setText(this.rtC);
      this.titleTv.setVisibility(0);
    }
    while (this.iFP != null) {
      if (!bu.isNullOrNil(this.rtD))
      {
        this.iFP.setText(this.rtD);
        this.iFP.setVisibility(0);
        AppMethodBeat.o(29869);
        return;
        label95:
        this.titleTv.setVisibility(8);
      }
      else
      {
        this.iFP.setVisibility(8);
      }
    }
    AppMethodBeat.o(29869);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(29871);
    super.onBindView(paramView);
    this.fWT = ((ImageView)paramView.findViewById(2131306513));
    this.titleTv = ((TextView)paramView.findViewById(2131306514));
    this.iFP = ((TextView)paramView.findViewById(2131306516));
    this.rtz = ((Button)paramView.findViewById(2131304179));
    this.rtA = paramView.findViewById(2131297656);
    if (!bu.isNullOrNil(this.rtC))
    {
      this.titleTv.setText(this.rtC);
      this.titleTv.setVisibility(0);
      if (bu.isNullOrNil(this.rtD)) {
        break label191;
      }
      this.iFP.setText(this.rtD);
      this.iFP.setVisibility(0);
    }
    for (;;)
    {
      if ((this.rtz == null) || (this.rtB == null)) {
        break label203;
      }
      this.rtz.setOnClickListener(this.rtB);
      this.rtz.setVisibility(0);
      this.rtA.setVisibility(0);
      AppMethodBeat.o(29871);
      return;
      this.titleTv.setVisibility(8);
      break;
      label191:
      this.iFP.setVisibility(8);
    }
    label203:
    this.rtz.setVisibility(8);
    this.rtA.setVisibility(8);
    AppMethodBeat.o(29871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceHeaderPreference
 * JD-Core Version:    0.7.0.1
 */