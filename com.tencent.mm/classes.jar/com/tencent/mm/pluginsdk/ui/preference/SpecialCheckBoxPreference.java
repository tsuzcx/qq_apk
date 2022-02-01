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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class SpecialCheckBoxPreference
  extends Preference
{
  private ToggleButton YnA;
  private ToggleButton YnB;
  private CompoundButton.OnCheckedChangeListener YnC;
  private ToggleButton Ynz;
  private boolean hQu;
  private boolean lAj;
  private boolean lzS;
  private Context mContext;
  private String roomId;
  private au xVS;
  
  public SpecialCheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31914);
    this.YnC = new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(31913);
        int i = paramAnonymousCompoundButton.getId();
        if (i == R.h.fVf)
        {
          SpecialCheckBoxPreference.a(SpecialCheckBoxPreference.this);
          AppMethodBeat.o(31913);
          return;
        }
        if (i == R.h.fVe)
        {
          SpecialCheckBoxPreference.b(SpecialCheckBoxPreference.this);
          AppMethodBeat.o(31913);
          return;
        }
        if (i == R.h.fVg) {
          SpecialCheckBoxPreference.c(SpecialCheckBoxPreference.this);
        }
        AppMethodBeat.o(31913);
      }
    };
    this.lAj = false;
    this.mContext = paramContext;
    AppMethodBeat.o(31914);
  }
  
  public SpecialCheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31915);
    this.YnC = new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(31913);
        int i = paramAnonymousCompoundButton.getId();
        if (i == R.h.fVf)
        {
          SpecialCheckBoxPreference.a(SpecialCheckBoxPreference.this);
          AppMethodBeat.o(31913);
          return;
        }
        if (i == R.h.fVe)
        {
          SpecialCheckBoxPreference.b(SpecialCheckBoxPreference.this);
          AppMethodBeat.o(31913);
          return;
        }
        if (i == R.h.fVg) {
          SpecialCheckBoxPreference.c(SpecialCheckBoxPreference.this);
        }
        AppMethodBeat.o(31913);
      }
    };
    this.lAj = false;
    this.mContext = paramContext;
    AppMethodBeat.o(31915);
  }
  
  private boolean iNJ()
  {
    AppMethodBeat.i(31917);
    boolean bool;
    if (this.hQu) {
      if (this.xVS.kaf == 0)
      {
        bool = true;
        this.lAj = bool;
      }
    }
    for (;;)
    {
      if ((this.mContext instanceof MMActivity))
      {
        if (this.lAj)
        {
          ((MMActivity)this.mContext).setTitleMuteIconVisibility(0);
          AppMethodBeat.o(31917);
          return true;
          bool = false;
          break;
          if (this.lzS) {
            continue;
          }
          this.lAj = this.xVS.aGe();
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
    this.Ynz = ((ToggleButton)paramView.findViewById(R.h.fVf));
    this.YnA = ((ToggleButton)paramView.findViewById(R.h.fVe));
    this.YnB = ((ToggleButton)paramView.findViewById(R.h.fVg));
    this.roomId = ((MMActivity)this.mContext).getIntent().getStringExtra("RoomInfo_Id");
    this.hQu = ((MMActivity)this.mContext).getIntent().getBooleanExtra("Is_Chatroom", true);
    this.lzS = ((MMActivity)this.mContext).getIntent().getBooleanExtra("Is_Lbsroom", false);
    bh.bCz();
    this.xVS = c.bzA().JE(this.roomId);
    if (this.xVS != null)
    {
      paramView = this.Ynz;
      bh.bCz();
      paramView.setChecked(c.bzG().bxV(this.xVS.field_username));
      this.YnB.setChecked(d.rs(this.xVS.field_type));
      this.YnA.setChecked(iNJ());
    }
    this.Ynz.setOnCheckedChangeListener(this.YnC);
    this.YnA.setOnCheckedChangeListener(this.YnC);
    this.YnB.setOnCheckedChangeListener(this.YnC);
    AppMethodBeat.o(31916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.SpecialCheckBoxPreference
 * JD-Core Version:    0.7.0.1
 */