package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.n.b;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class SpecialCheckBoxPreference
  extends Preference
{
  private ToggleButton Cju;
  private ToggleButton Cjv;
  private ToggleButton Cjw;
  private CompoundButton.OnCheckedChangeListener Cjx;
  private boolean dph;
  private boolean fpQ;
  private boolean fqj;
  private Context mContext;
  private af oFt;
  private String roomId;
  
  public SpecialCheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31914);
    this.Cjx = new CompoundButton.OnCheckedChangeListener()
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
    this.fqj = false;
    this.mContext = paramContext;
    AppMethodBeat.o(31914);
  }
  
  public SpecialCheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31915);
    this.Cjx = new CompoundButton.OnCheckedChangeListener()
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
    this.fqj = false;
    this.mContext = paramContext;
    AppMethodBeat.o(31915);
  }
  
  private boolean eAv()
  {
    AppMethodBeat.i(31917);
    boolean bool;
    if (this.dph) {
      if (this.oFt.evx == 0)
      {
        bool = true;
        this.fqj = bool;
      }
    }
    for (;;)
    {
      if ((this.mContext instanceof MMActivity))
      {
        if (this.fqj)
        {
          ((MMActivity)this.mContext).setTitleMuteIconVisibility(0);
          AppMethodBeat.o(31917);
          return true;
          bool = false;
          break;
          if (this.fpQ) {
            continue;
          }
          this.fqj = this.oFt.Ny();
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
    this.Cju = ((ToggleButton)paramView.findViewById(2131304222));
    this.Cjv = ((ToggleButton)paramView.findViewById(2131304221));
    this.Cjw = ((ToggleButton)paramView.findViewById(2131304229));
    this.roomId = ((MMActivity)this.mContext).getIntent().getStringExtra("RoomInfo_Id");
    this.dph = ((MMActivity)this.mContext).getIntent().getBooleanExtra("Is_Chatroom", true);
    this.fpQ = ((MMActivity)this.mContext).getIntent().getBooleanExtra("Is_Lbsroom", false);
    az.arV();
    this.oFt = c.apM().aHY(this.roomId);
    if (this.oFt != null)
    {
      paramView = this.Cju;
      az.arV();
      paramView.setChecked(c.apR().aIv(this.oFt.field_username));
      this.Cjw.setChecked(b.ls(this.oFt.field_type));
      this.Cjv.setChecked(eAv());
    }
    this.Cju.setOnCheckedChangeListener(this.Cjx);
    this.Cjv.setOnCheckedChangeListener(this.Cjx);
    this.Cjw.setOnCheckedChangeListener(this.Cjx);
    AppMethodBeat.o(31916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.SpecialCheckBoxPreference
 * JD-Core Version:    0.7.0.1
 */