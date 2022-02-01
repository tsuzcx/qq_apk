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
import com.tencent.mm.model.bc;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class SpecialCheckBoxPreference
  extends Preference
{
  private ToggleButton Fzq;
  private ToggleButton Fzr;
  private ToggleButton Fzs;
  private CompoundButton.OnCheckedChangeListener Fzt;
  private boolean dzK;
  private boolean fOE;
  private boolean fOX;
  private Context mContext;
  private an pSY;
  private String roomId;
  
  public SpecialCheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31914);
    this.Fzt = new CompoundButton.OnCheckedChangeListener()
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
    this.fOX = false;
    this.mContext = paramContext;
    AppMethodBeat.o(31914);
  }
  
  public SpecialCheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31915);
    this.Fzt = new CompoundButton.OnCheckedChangeListener()
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
    this.fOX = false;
    this.mContext = paramContext;
    AppMethodBeat.o(31915);
  }
  
  private boolean fiH()
  {
    AppMethodBeat.i(31917);
    boolean bool;
    if (this.dzK) {
      if (this.pSY.eRd == 0)
      {
        bool = true;
        this.fOX = bool;
      }
    }
    for (;;)
    {
      if ((this.mContext instanceof MMActivity))
      {
        if (this.fOX)
        {
          ((MMActivity)this.mContext).setTitleMuteIconVisibility(0);
          AppMethodBeat.o(31917);
          return true;
          bool = false;
          break;
          if (this.fOE) {
            continue;
          }
          this.fOX = this.pSY.Pd();
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
    this.Fzq = ((ToggleButton)paramView.findViewById(2131304222));
    this.Fzr = ((ToggleButton)paramView.findViewById(2131304221));
    this.Fzs = ((ToggleButton)paramView.findViewById(2131304229));
    this.roomId = ((MMActivity)this.mContext).getIntent().getStringExtra("RoomInfo_Id");
    this.dzK = ((MMActivity)this.mContext).getIntent().getBooleanExtra("Is_Chatroom", true);
    this.fOE = ((MMActivity)this.mContext).getIntent().getBooleanExtra("Is_Lbsroom", false);
    bc.aCg();
    this.pSY = com.tencent.mm.model.c.azF().BH(this.roomId);
    if (this.pSY != null)
    {
      paramView = this.Fzq;
      bc.aCg();
      paramView.setChecked(com.tencent.mm.model.c.azL().aVi(this.pSY.field_username));
      this.Fzs.setChecked(com.tencent.mm.contact.c.lO(this.pSY.field_type));
      this.Fzr.setChecked(fiH());
    }
    this.Fzq.setOnCheckedChangeListener(this.Fzt);
    this.Fzr.setOnCheckedChangeListener(this.Fzt);
    this.Fzs.setOnCheckedChangeListener(this.Fzt);
    AppMethodBeat.o(31916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.SpecialCheckBoxPreference
 * JD-Core Version:    0.7.0.1
 */