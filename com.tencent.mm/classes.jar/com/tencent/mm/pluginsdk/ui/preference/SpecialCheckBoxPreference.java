package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.n.b;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class SpecialCheckBoxPreference
  extends Preference
{
  private ToggleButton DBL;
  private ToggleButton DBM;
  private ToggleButton DBN;
  private CompoundButton.OnCheckedChangeListener DBO;
  private boolean dmR;
  private boolean ftN;
  private boolean ftu;
  private Context mContext;
  private ai piT;
  private String roomId;
  
  public SpecialCheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31914);
    this.DBO = new CompoundButton.OnCheckedChangeListener()
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
    this.ftN = false;
    this.mContext = paramContext;
    AppMethodBeat.o(31914);
  }
  
  public SpecialCheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31915);
    this.DBO = new CompoundButton.OnCheckedChangeListener()
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
    this.ftN = false;
    this.mContext = paramContext;
    AppMethodBeat.o(31915);
  }
  
  private boolean ePP()
  {
    AppMethodBeat.i(31917);
    boolean bool;
    if (this.dmR) {
      if (this.piT.exT == 0)
      {
        bool = true;
        this.ftN = bool;
      }
    }
    for (;;)
    {
      if ((this.mContext instanceof MMActivity))
      {
        if (this.ftN)
        {
          ((MMActivity)this.mContext).setTitleMuteIconVisibility(0);
          AppMethodBeat.o(31917);
          return true;
          bool = false;
          break;
          if (this.ftu) {
            continue;
          }
          this.ftN = this.piT.Nw();
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
    this.DBL = ((ToggleButton)paramView.findViewById(2131304222));
    this.DBM = ((ToggleButton)paramView.findViewById(2131304221));
    this.DBN = ((ToggleButton)paramView.findViewById(2131304229));
    this.roomId = ((MMActivity)this.mContext).getIntent().getStringExtra("RoomInfo_Id");
    this.dmR = ((MMActivity)this.mContext).getIntent().getBooleanExtra("Is_Chatroom", true);
    this.ftu = ((MMActivity)this.mContext).getIntent().getBooleanExtra("Is_Lbsroom", false);
    az.ayM();
    this.piT = c.awB().aNt(this.roomId);
    if (this.piT != null)
    {
      paramView = this.DBL;
      az.ayM();
      paramView.setChecked(c.awG().aNQ(this.piT.field_username));
      this.DBN.setChecked(b.ln(this.piT.field_type));
      this.DBM.setChecked(ePP());
    }
    this.DBL.setOnCheckedChangeListener(this.DBO);
    this.DBM.setOnCheckedChangeListener(this.DBO);
    this.DBN.setOnCheckedChangeListener(this.DBO);
    AppMethodBeat.o(31916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.SpecialCheckBoxPreference
 * JD-Core Version:    0.7.0.1
 */