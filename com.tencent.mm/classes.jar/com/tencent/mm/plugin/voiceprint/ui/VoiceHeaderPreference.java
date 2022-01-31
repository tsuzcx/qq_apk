package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class VoiceHeaderPreference
  extends Preference
{
  private MMActivity cmc;
  private TextView gLI;
  private ImageView iQd;
  private String mTitle;
  private int mml;
  private Button mmm;
  private View mmn;
  private View.OnClickListener mmo;
  private String mmp;
  private String mmq;
  private TextView titleTv;
  
  public VoiceHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(26185);
    this.cmc = ((MMActivity)paramContext);
    AppMethodBeat.o(26185);
  }
  
  public VoiceHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(26186);
    this.mTitle = "";
    this.mml = 255;
    this.mmo = null;
    this.mmp = "";
    this.mmq = "";
    this.cmc = ((MMActivity)paramContext);
    setLayoutResource(2130971095);
    AppMethodBeat.o(26186);
  }
  
  public final void a(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(26188);
    this.mmo = paramOnClickListener;
    if ((this.mmm == null) || (this.mmn == null))
    {
      AppMethodBeat.o(26188);
      return;
    }
    if ((this.mmm != null) && (this.mmo != null))
    {
      this.mmm.setOnClickListener(paramOnClickListener);
      this.mmm.setVisibility(0);
      this.mmn.setVisibility(0);
      AppMethodBeat.o(26188);
      return;
    }
    this.mmm.setVisibility(8);
    this.mmn.setVisibility(8);
    AppMethodBeat.o(26188);
  }
  
  public final void en(String paramString1, String paramString2)
  {
    AppMethodBeat.i(26187);
    this.mmp = paramString1;
    this.mmq = paramString2;
    if (this.titleTv != null)
    {
      if (bo.isNullOrNil(this.mmp)) {
        break label95;
      }
      this.titleTv.setText(this.mmp);
      this.titleTv.setVisibility(0);
    }
    while (this.gLI != null) {
      if (!bo.isNullOrNil(this.mmq))
      {
        this.gLI.setText(this.mmq);
        this.gLI.setVisibility(0);
        AppMethodBeat.o(26187);
        return;
        label95:
        this.titleTv.setVisibility(8);
      }
      else
      {
        this.gLI.setVisibility(8);
      }
    }
    AppMethodBeat.o(26187);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(26189);
    super.onBindView(paramView);
    this.iQd = ((ImageView)paramView.findViewById(2131823888));
    this.titleTv = ((TextView)paramView.findViewById(2131828763));
    this.gLI = ((TextView)paramView.findViewById(2131823889));
    this.mmm = ((Button)paramView.findViewById(2131823890));
    this.mmn = paramView.findViewById(2131823908);
    if (!bo.isNullOrNil(this.mmp))
    {
      this.titleTv.setText(this.mmp);
      this.titleTv.setVisibility(0);
      if (bo.isNullOrNil(this.mmq)) {
        break label191;
      }
      this.gLI.setText(this.mmq);
      this.gLI.setVisibility(0);
    }
    for (;;)
    {
      if ((this.mmm == null) || (this.mmo == null)) {
        break label203;
      }
      this.mmm.setOnClickListener(this.mmo);
      this.mmm.setVisibility(0);
      this.mmn.setVisibility(0);
      AppMethodBeat.o(26189);
      return;
      this.titleTv.setVisibility(8);
      break;
      label191:
      this.gLI.setVisibility(8);
    }
    label203:
    this.mmm.setVisibility(8);
    this.mmn.setVisibility(8);
    AppMethodBeat.o(26189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceHeaderPreference
 * JD-Core Version:    0.7.0.1
 */