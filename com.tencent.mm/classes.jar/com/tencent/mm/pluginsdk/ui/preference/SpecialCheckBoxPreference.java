package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.o.b;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class SpecialCheckBoxPreference
  extends Preference
{
  private ToggleButton FgS;
  private ToggleButton FgT;
  private ToggleButton FgU;
  private CompoundButton.OnCheckedChangeListener FgV;
  private boolean dyF;
  private boolean fMP;
  private boolean fMw;
  private Context mContext;
  private am pMt;
  private String roomId;
  
  public SpecialCheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31914);
    this.FgV = new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(31913);
        int i = paramAnonymousCompoundButton.getId();
        if (i == 2131304222)
        {
          SpecialCheckBoxPreference.a(SpecialCheckBoxPreference.this);
          AppMethodBeat.o(31913);
          return;
        }
        if (i == 2131304221)
        {
          SpecialCheckBoxPreference.b(SpecialCheckBoxPreference.this);
          AppMethodBeat.o(31913);
          return;
        }
        if (i == 2131304229) {
          SpecialCheckBoxPreference.c(SpecialCheckBoxPreference.this);
        }
        AppMethodBeat.o(31913);
      }
    };
    this.fMP = false;
    this.mContext = paramContext;
    AppMethodBeat.o(31914);
  }
  
  public SpecialCheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31915);
    this.FgV = new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(31913);
        int i = paramAnonymousCompoundButton.getId();
        if (i == 2131304222)
        {
          SpecialCheckBoxPreference.a(SpecialCheckBoxPreference.this);
          AppMethodBeat.o(31913);
          return;
        }
        if (i == 2131304221)
        {
          SpecialCheckBoxPreference.b(SpecialCheckBoxPreference.this);
          AppMethodBeat.o(31913);
          return;
        }
        if (i == 2131304229) {
          SpecialCheckBoxPreference.c(SpecialCheckBoxPreference.this);
        }
        AppMethodBeat.o(31913);
      }
    };
    this.fMP = false;
    this.mContext = paramContext;
    AppMethodBeat.o(31915);
  }
  
  private boolean feR()
  {
    AppMethodBeat.i(31917);
    boolean bool;
    if (this.dyF) {
      if (this.pMt.ePs == 0)
      {
        bool = true;
        this.fMP = bool;
      }
    }
    for (;;)
    {
      if ((this.mContext instanceof MMActivity))
      {
        if (this.fMP)
        {
          ((MMActivity)this.mContext).setTitleMuteIconVisibility(0);
          AppMethodBeat.o(31917);
          return true;
          bool = false;
          break;
          if (this.fMw) {
            continue;
          }
          this.fMP = this.pMt.Pf();
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
    this.FgS = ((ToggleButton)paramView.findViewById(2131304222));
    this.FgT = ((ToggleButton)paramView.findViewById(2131304221));
    this.FgU = ((ToggleButton)paramView.findViewById(2131304229));
    this.roomId = ((MMActivity)this.mContext).getIntent().getStringExtra("RoomInfo_Id");
    this.dyF = ((MMActivity)this.mContext).getIntent().getBooleanExtra("Is_Chatroom", true);
    this.fMw = ((MMActivity)this.mContext).getIntent().getBooleanExtra("Is_Lbsroom", false);
    ba.aBQ();
    this.pMt = c.azp().Bf(this.roomId);
    if (this.pMt != null)
    {
      paramView = this.FgS;
      ba.aBQ();
      paramView.setChecked(c.azv().aTH(this.pMt.field_username));
      this.FgU.setChecked(b.lM(this.pMt.field_type));
      this.FgT.setChecked(feR());
    }
    this.FgS.setOnCheckedChangeListener(this.FgV);
    this.FgT.setOnCheckedChangeListener(this.FgV);
    this.FgU.setOnCheckedChangeListener(this.FgV);
    AppMethodBeat.o(31916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.SpecialCheckBoxPreference
 * JD-Core Version:    0.7.0.1
 */