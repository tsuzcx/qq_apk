package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class SpecialCheckBoxPreference
  extends Preference
{
  private ToggleButton Rri;
  private ToggleButton Rrj;
  private ToggleButton Rrk;
  private CompoundButton.OnCheckedChangeListener Rrl;
  private boolean fKN;
  private boolean iXZ;
  private boolean iYs;
  private Context mContext;
  private String roomId;
  private as uNk;
  
  public SpecialCheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31914);
    this.Rrl = new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(31913);
        int i = paramAnonymousCompoundButton.getId();
        if (i == R.h.dSZ)
        {
          SpecialCheckBoxPreference.a(SpecialCheckBoxPreference.this);
          AppMethodBeat.o(31913);
          return;
        }
        if (i == R.h.dSY)
        {
          SpecialCheckBoxPreference.b(SpecialCheckBoxPreference.this);
          AppMethodBeat.o(31913);
          return;
        }
        if (i == R.h.dTa) {
          SpecialCheckBoxPreference.c(SpecialCheckBoxPreference.this);
        }
        AppMethodBeat.o(31913);
      }
    };
    this.iYs = false;
    this.mContext = paramContext;
    AppMethodBeat.o(31914);
  }
  
  public SpecialCheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31915);
    this.Rrl = new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(31913);
        int i = paramAnonymousCompoundButton.getId();
        if (i == R.h.dSZ)
        {
          SpecialCheckBoxPreference.a(SpecialCheckBoxPreference.this);
          AppMethodBeat.o(31913);
          return;
        }
        if (i == R.h.dSY)
        {
          SpecialCheckBoxPreference.b(SpecialCheckBoxPreference.this);
          AppMethodBeat.o(31913);
          return;
        }
        if (i == R.h.dTa) {
          SpecialCheckBoxPreference.c(SpecialCheckBoxPreference.this);
        }
        AppMethodBeat.o(31913);
      }
    };
    this.iYs = false;
    this.mContext = paramContext;
    AppMethodBeat.o(31915);
  }
  
  private boolean hmT()
  {
    AppMethodBeat.i(31917);
    boolean bool;
    if (this.fKN) {
      if (this.uNk.hDj == 0)
      {
        bool = true;
        this.iYs = bool;
      }
    }
    for (;;)
    {
      if ((this.mContext instanceof MMActivity))
      {
        if (this.iYs)
        {
          ((MMActivity)this.mContext).setTitleMuteIconVisibility(0);
          AppMethodBeat.o(31917);
          return true;
          bool = false;
          break;
          if (this.iXZ) {
            continue;
          }
          this.iYs = this.uNk.aeg();
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
    this.Rri = ((ToggleButton)paramView.findViewById(R.h.dSZ));
    this.Rrj = ((ToggleButton)paramView.findViewById(R.h.dSY));
    this.Rrk = ((ToggleButton)paramView.findViewById(R.h.dTa));
    this.roomId = ((MMActivity)this.mContext).getIntent().getStringExtra("RoomInfo_Id");
    this.fKN = ((MMActivity)this.mContext).getIntent().getBooleanExtra("Is_Chatroom", true);
    this.iXZ = ((MMActivity)this.mContext).getIntent().getBooleanExtra("Is_Lbsroom", false);
    bh.beI();
    this.uNk = c.bbL().RG(this.roomId);
    if (this.uNk != null)
    {
      paramView = this.Rri;
      bh.beI();
      paramView.setChecked(c.bbR().bwF(this.uNk.field_username));
      this.Rrk.setChecked(d.rk(this.uNk.field_type));
      this.Rrj.setChecked(hmT());
    }
    this.Rri.setOnCheckedChangeListener(this.Rrl);
    this.Rrj.setOnCheckedChangeListener(this.Rrl);
    this.Rrk.setOnCheckedChangeListener(this.Rrl);
    AppMethodBeat.o(31916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.SpecialCheckBoxPreference
 * JD-Core Version:    0.7.0.1
 */