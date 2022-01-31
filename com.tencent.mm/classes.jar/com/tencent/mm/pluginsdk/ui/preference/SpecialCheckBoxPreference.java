package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;
import com.tencent.mm.R.h;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.n.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class SpecialCheckBoxPreference
  extends Preference
{
  private boolean bRz;
  private String dmT;
  private boolean dnJ = false;
  private boolean dno;
  private ad jgl;
  private Context mContext;
  private ToggleButton sji;
  private ToggleButton sjj;
  private ToggleButton sjk;
  private CompoundButton.OnCheckedChangeListener sjl = new SpecialCheckBoxPreference.1(this);
  
  public SpecialCheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public SpecialCheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
  }
  
  private boolean cob()
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.bRz) {
      if (this.jgl.cCy == 0)
      {
        bool1 = true;
        this.dnJ = bool1;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if ((this.mContext instanceof MMActivity))
      {
        if (!this.dnJ) {
          break label86;
        }
        ((MMActivity)this.mContext).setTitleMuteIconVisibility(0);
        bool1 = true;
      }
      return bool1;
      bool1 = false;
      break;
      if (!this.dno) {
        this.dnJ = this.jgl.Bj();
      }
    }
    label86:
    ((MMActivity)this.mContext).setTitleMuteIconVisibility(8);
    return false;
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.sji = ((ToggleButton)paramView.findViewById(R.h.room_placed_to_the_top));
    this.sjj = ((ToggleButton)paramView.findViewById(R.h.room_notify_new_msg));
    this.sjk = ((ToggleButton)paramView.findViewById(R.h.room_save_to_contact));
    this.dmT = ((MMActivity)this.mContext).getIntent().getStringExtra("RoomInfo_Id");
    this.bRz = ((MMActivity)this.mContext).getIntent().getBooleanExtra("Is_Chatroom", true);
    this.dno = ((MMActivity)this.mContext).getIntent().getBooleanExtra("Is_Lbsroom", false);
    au.Hx();
    this.jgl = c.Fw().abl(this.dmT);
    if (this.jgl != null)
    {
      paramView = this.sji;
      au.Hx();
      paramView.setChecked(c.FB().abD(this.jgl.field_username));
      this.sjk.setChecked(a.gR(this.jgl.field_type));
      this.sjj.setChecked(cob());
    }
    this.sji.setOnCheckedChangeListener(this.sjl);
    this.sjj.setOnCheckedChangeListener(this.sjl);
    this.sjk.setOnCheckedChangeListener(this.sjl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.SpecialCheckBoxPreference
 * JD-Core Version:    0.7.0.1
 */