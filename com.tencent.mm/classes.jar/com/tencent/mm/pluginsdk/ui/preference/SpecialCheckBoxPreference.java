package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class SpecialCheckBoxPreference
  extends Preference
{
  private ToggleButton Kqs;
  private ToggleButton Kqt;
  private ToggleButton Kqu;
  private CompoundButton.OnCheckedChangeListener Kqv;
  private boolean dRx;
  private boolean gtO;
  private boolean guh;
  private Context mContext;
  private as rjX;
  private String roomId;
  
  public SpecialCheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31914);
    this.Kqv = new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(31913);
        int i = paramAnonymousCompoundButton.getId();
        if (i == 2131307140)
        {
          SpecialCheckBoxPreference.a(SpecialCheckBoxPreference.this);
          AppMethodBeat.o(31913);
          return;
        }
        if (i == 2131307139)
        {
          SpecialCheckBoxPreference.b(SpecialCheckBoxPreference.this);
          AppMethodBeat.o(31913);
          return;
        }
        if (i == 2131307147) {
          SpecialCheckBoxPreference.c(SpecialCheckBoxPreference.this);
        }
        AppMethodBeat.o(31913);
      }
    };
    this.guh = false;
    this.mContext = paramContext;
    AppMethodBeat.o(31914);
  }
  
  public SpecialCheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31915);
    this.Kqv = new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(31913);
        int i = paramAnonymousCompoundButton.getId();
        if (i == 2131307140)
        {
          SpecialCheckBoxPreference.a(SpecialCheckBoxPreference.this);
          AppMethodBeat.o(31913);
          return;
        }
        if (i == 2131307139)
        {
          SpecialCheckBoxPreference.b(SpecialCheckBoxPreference.this);
          AppMethodBeat.o(31913);
          return;
        }
        if (i == 2131307147) {
          SpecialCheckBoxPreference.c(SpecialCheckBoxPreference.this);
        }
        AppMethodBeat.o(31913);
      }
    };
    this.guh = false;
    this.mContext = paramContext;
    AppMethodBeat.o(31915);
  }
  
  private boolean grT()
  {
    AppMethodBeat.i(31917);
    boolean bool;
    if (this.dRx) {
      if (this.rjX.fuH == 0)
      {
        bool = true;
        this.guh = bool;
      }
    }
    for (;;)
    {
      if ((this.mContext instanceof MMActivity))
      {
        if (this.guh)
        {
          ((MMActivity)this.mContext).setTitleMuteIconVisibility(0);
          AppMethodBeat.o(31917);
          return true;
          bool = false;
          break;
          if (this.gtO) {
            continue;
          }
          this.guh = this.rjX.Zx();
          continue;
        }
        ((MMActivity)this.mContext).setTitleMuteIconVisibility(8);
        AppMethodBeat.o(31917);
        return false;
      }
    }
    AppMethodBeat.o(31917);
    return false;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(31916);
    super.onBindView(paramView);
    this.Kqs = ((ToggleButton)paramView.findViewById(2131307140));
    this.Kqt = ((ToggleButton)paramView.findViewById(2131307139));
    this.Kqu = ((ToggleButton)paramView.findViewById(2131307147));
    this.roomId = ((MMActivity)this.mContext).getIntent().getStringExtra("RoomInfo_Id");
    this.dRx = ((MMActivity)this.mContext).getIntent().getBooleanExtra("Is_Chatroom", true);
    this.gtO = ((MMActivity)this.mContext).getIntent().getBooleanExtra("Is_Lbsroom", false);
    bg.aVF();
    this.rjX = com.tencent.mm.model.c.aSN().Kn(this.roomId);
    if (this.rjX != null)
    {
      paramView = this.Kqs;
      bg.aVF();
      paramView.setChecked(com.tencent.mm.model.c.aST().bkg(this.rjX.field_username));
      this.Kqu.setChecked(com.tencent.mm.contact.c.oR(this.rjX.field_type));
      this.Kqt.setChecked(grT());
    }
    this.Kqs.setOnCheckedChangeListener(this.Kqv);
    this.Kqt.setOnCheckedChangeListener(this.Kqv);
    this.Kqu.setOnCheckedChangeListener(this.Kqv);
    AppMethodBeat.o(31916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.SpecialCheckBoxPreference
 * JD-Core Version:    0.7.0.1
 */