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
  private ImageView fxT;
  private TextView hJf;
  private MMActivity imP;
  private String mTitle;
  private int pSW;
  private Button pSX;
  private View pSY;
  private View.OnClickListener pSZ;
  private String pTa;
  private String pTb;
  private TextView titleTv;
  
  public VoiceHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(29867);
    this.imP = ((MMActivity)paramContext);
    AppMethodBeat.o(29867);
  }
  
  public VoiceHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29868);
    this.mTitle = "";
    this.pSW = 255;
    this.pSZ = null;
    this.pTa = "";
    this.pTb = "";
    this.imP = ((MMActivity)paramContext);
    setLayoutResource(2131495865);
    AppMethodBeat.o(29868);
  }
  
  public final void c(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(29870);
    this.pSZ = paramOnClickListener;
    if ((this.pSX == null) || (this.pSY == null))
    {
      AppMethodBeat.o(29870);
      return;
    }
    if ((this.pSX != null) && (this.pSZ != null))
    {
      this.pSX.setOnClickListener(paramOnClickListener);
      this.pSX.setVisibility(0);
      this.pSY.setVisibility(0);
      AppMethodBeat.o(29870);
      return;
    }
    this.pSX.setVisibility(8);
    this.pSY.setVisibility(8);
    AppMethodBeat.o(29870);
  }
  
  public final void fK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(29869);
    this.pTa = paramString1;
    this.pTb = paramString2;
    if (this.titleTv != null)
    {
      if (bt.isNullOrNil(this.pTa)) {
        break label95;
      }
      this.titleTv.setText(this.pTa);
      this.titleTv.setVisibility(0);
    }
    while (this.hJf != null) {
      if (!bt.isNullOrNil(this.pTb))
      {
        this.hJf.setText(this.pTb);
        this.hJf.setVisibility(0);
        AppMethodBeat.o(29869);
        return;
        label95:
        this.titleTv.setVisibility(8);
      }
      else
      {
        this.hJf.setVisibility(8);
      }
    }
    AppMethodBeat.o(29869);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(29871);
    super.onBindView(paramView);
    this.fxT = ((ImageView)paramView.findViewById(2131306513));
    this.titleTv = ((TextView)paramView.findViewById(2131306514));
    this.hJf = ((TextView)paramView.findViewById(2131306516));
    this.pSX = ((Button)paramView.findViewById(2131304179));
    this.pSY = paramView.findViewById(2131297656);
    if (!bt.isNullOrNil(this.pTa))
    {
      this.titleTv.setText(this.pTa);
      this.titleTv.setVisibility(0);
      if (bt.isNullOrNil(this.pTb)) {
        break label191;
      }
      this.hJf.setText(this.pTb);
      this.hJf.setVisibility(0);
    }
    for (;;)
    {
      if ((this.pSX == null) || (this.pSZ == null)) {
        break label203;
      }
      this.pSX.setOnClickListener(this.pSZ);
      this.pSX.setVisibility(0);
      this.pSY.setVisibility(0);
      AppMethodBeat.o(29871);
      return;
      this.titleTv.setVisibility(8);
      break;
      label191:
      this.hJf.setVisibility(8);
    }
    label203:
    this.pSX.setVisibility(8);
    this.pSY.setVisibility(8);
    AppMethodBeat.o(29871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceHeaderPreference
 * JD-Core Version:    0.7.0.1
 */