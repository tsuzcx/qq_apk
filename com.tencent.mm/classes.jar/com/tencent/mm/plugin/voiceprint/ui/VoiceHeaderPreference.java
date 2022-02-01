package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class VoiceHeaderPreference
  extends Preference
{
  private MMActivity fLP;
  private ImageView fUN;
  private TextView iCW;
  private String mTitle;
  private int rlt;
  private Button rlu;
  private View rlv;
  private View.OnClickListener rlw;
  private String rlx;
  private String rly;
  private TextView titleTv;
  
  public VoiceHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(29867);
    this.fLP = ((MMActivity)paramContext);
    AppMethodBeat.o(29867);
  }
  
  public VoiceHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29868);
    this.mTitle = "";
    this.rlt = 255;
    this.rlw = null;
    this.rlx = "";
    this.rly = "";
    this.fLP = ((MMActivity)paramContext);
    setLayoutResource(2131495865);
    AppMethodBeat.o(29868);
  }
  
  public final void b(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(29870);
    this.rlw = paramOnClickListener;
    if ((this.rlu == null) || (this.rlv == null))
    {
      AppMethodBeat.o(29870);
      return;
    }
    if ((this.rlu != null) && (this.rlw != null))
    {
      this.rlu.setOnClickListener(paramOnClickListener);
      this.rlu.setVisibility(0);
      this.rlv.setVisibility(0);
      AppMethodBeat.o(29870);
      return;
    }
    this.rlu.setVisibility(8);
    this.rlv.setVisibility(8);
    AppMethodBeat.o(29870);
  }
  
  public final void gg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(29869);
    this.rlx = paramString1;
    this.rly = paramString2;
    if (this.titleTv != null)
    {
      if (bt.isNullOrNil(this.rlx)) {
        break label95;
      }
      this.titleTv.setText(this.rlx);
      this.titleTv.setVisibility(0);
    }
    while (this.iCW != null) {
      if (!bt.isNullOrNil(this.rly))
      {
        this.iCW.setText(this.rly);
        this.iCW.setVisibility(0);
        AppMethodBeat.o(29869);
        return;
        label95:
        this.titleTv.setVisibility(8);
      }
      else
      {
        this.iCW.setVisibility(8);
      }
    }
    AppMethodBeat.o(29869);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(29871);
    super.onBindView(paramView);
    this.fUN = ((ImageView)paramView.findViewById(2131306513));
    this.titleTv = ((TextView)paramView.findViewById(2131306514));
    this.iCW = ((TextView)paramView.findViewById(2131306516));
    this.rlu = ((Button)paramView.findViewById(2131304179));
    this.rlv = paramView.findViewById(2131297656);
    if (!bt.isNullOrNil(this.rlx))
    {
      this.titleTv.setText(this.rlx);
      this.titleTv.setVisibility(0);
      if (bt.isNullOrNil(this.rly)) {
        break label191;
      }
      this.iCW.setText(this.rly);
      this.iCW.setVisibility(0);
    }
    for (;;)
    {
      if ((this.rlu == null) || (this.rlw == null)) {
        break label203;
      }
      this.rlu.setOnClickListener(this.rlw);
      this.rlu.setVisibility(0);
      this.rlv.setVisibility(0);
      AppMethodBeat.o(29871);
      return;
      this.titleTv.setVisibility(8);
      break;
      label191:
      this.iCW.setVisibility(8);
    }
    label203:
    this.rlu.setVisibility(8);
    this.rlv.setVisibility(8);
    AppMethodBeat.o(29871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceHeaderPreference
 * JD-Core Version:    0.7.0.1
 */