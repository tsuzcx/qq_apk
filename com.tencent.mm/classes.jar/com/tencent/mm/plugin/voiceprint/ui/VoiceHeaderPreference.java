package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class VoiceHeaderPreference
  extends Preference
{
  private ImageView fBA;
  private MMActivity iMV;
  private TextView ijF;
  private String mTitle;
  private int qBD;
  private Button qBE;
  private View qBF;
  private View.OnClickListener qBG;
  private String qBH;
  private String qBI;
  private TextView titleTv;
  
  public VoiceHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(29867);
    this.iMV = ((MMActivity)paramContext);
    AppMethodBeat.o(29867);
  }
  
  public VoiceHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29868);
    this.mTitle = "";
    this.qBD = 255;
    this.qBG = null;
    this.qBH = "";
    this.qBI = "";
    this.iMV = ((MMActivity)paramContext);
    setLayoutResource(2131495865);
    AppMethodBeat.o(29868);
  }
  
  public final void c(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(29870);
    this.qBG = paramOnClickListener;
    if ((this.qBE == null) || (this.qBF == null))
    {
      AppMethodBeat.o(29870);
      return;
    }
    if ((this.qBE != null) && (this.qBG != null))
    {
      this.qBE.setOnClickListener(paramOnClickListener);
      this.qBE.setVisibility(0);
      this.qBF.setVisibility(0);
      AppMethodBeat.o(29870);
      return;
    }
    this.qBE.setVisibility(8);
    this.qBF.setVisibility(8);
    AppMethodBeat.o(29870);
  }
  
  public final void fX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(29869);
    this.qBH = paramString1;
    this.qBI = paramString2;
    if (this.titleTv != null)
    {
      if (bs.isNullOrNil(this.qBH)) {
        break label95;
      }
      this.titleTv.setText(this.qBH);
      this.titleTv.setVisibility(0);
    }
    while (this.ijF != null) {
      if (!bs.isNullOrNil(this.qBI))
      {
        this.ijF.setText(this.qBI);
        this.ijF.setVisibility(0);
        AppMethodBeat.o(29869);
        return;
        label95:
        this.titleTv.setVisibility(8);
      }
      else
      {
        this.ijF.setVisibility(8);
      }
    }
    AppMethodBeat.o(29869);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(29871);
    super.onBindView(paramView);
    this.fBA = ((ImageView)paramView.findViewById(2131306513));
    this.titleTv = ((TextView)paramView.findViewById(2131306514));
    this.ijF = ((TextView)paramView.findViewById(2131306516));
    this.qBE = ((Button)paramView.findViewById(2131304179));
    this.qBF = paramView.findViewById(2131297656);
    if (!bs.isNullOrNil(this.qBH))
    {
      this.titleTv.setText(this.qBH);
      this.titleTv.setVisibility(0);
      if (bs.isNullOrNil(this.qBI)) {
        break label191;
      }
      this.ijF.setText(this.qBI);
      this.ijF.setVisibility(0);
    }
    for (;;)
    {
      if ((this.qBE == null) || (this.qBG == null)) {
        break label203;
      }
      this.qBE.setOnClickListener(this.qBG);
      this.qBE.setVisibility(0);
      this.qBF.setVisibility(0);
      AppMethodBeat.o(29871);
      return;
      this.titleTv.setVisibility(8);
      break;
      label191:
      this.ijF.setVisibility(8);
    }
    label203:
    this.qBE.setVisibility(8);
    this.qBF.setVisibility(8);
    AppMethodBeat.o(29871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceHeaderPreference
 * JD-Core Version:    0.7.0.1
 */