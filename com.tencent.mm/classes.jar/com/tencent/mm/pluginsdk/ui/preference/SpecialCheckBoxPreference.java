package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
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
  private boolean czb;
  private boolean eeO;
  private String eeu;
  private boolean efg;
  private ad lpe;
  private Context mContext;
  private ToggleButton wbO;
  private ToggleButton wbP;
  private ToggleButton wbQ;
  private CompoundButton.OnCheckedChangeListener wbR;
  
  public SpecialCheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(28124);
    this.wbR = new SpecialCheckBoxPreference.1(this);
    this.efg = false;
    this.mContext = paramContext;
    AppMethodBeat.o(28124);
  }
  
  public SpecialCheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(28125);
    this.wbR = new SpecialCheckBoxPreference.1(this);
    this.efg = false;
    this.mContext = paramContext;
    AppMethodBeat.o(28125);
  }
  
  private boolean dpn()
  {
    AppMethodBeat.i(28127);
    boolean bool;
    if (this.czb) {
      if (this.lpe.dqK == 0)
      {
        bool = true;
        this.efg = bool;
      }
    }
    for (;;)
    {
      if ((this.mContext instanceof MMActivity))
      {
        if (this.efg)
        {
          ((MMActivity)this.mContext).setTitleMuteIconVisibility(0);
          AppMethodBeat.o(28127);
          return true;
          bool = false;
          break;
          if (this.eeO) {
            continue;
          }
          this.efg = this.lpe.DP();
          continue;
        }
        ((MMActivity)this.mContext).setTitleMuteIconVisibility(8);
        AppMethodBeat.o(28127);
        return false;
      }
    }
    AppMethodBeat.o(28127);
    return false;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(28126);
    super.onBindView(paramView);
    this.wbO = ((ToggleButton)paramView.findViewById(2131826194));
    this.wbP = ((ToggleButton)paramView.findViewById(2131826195));
    this.wbQ = ((ToggleButton)paramView.findViewById(2131826196));
    this.eeu = ((MMActivity)this.mContext).getIntent().getStringExtra("RoomInfo_Id");
    this.czb = ((MMActivity)this.mContext).getIntent().getBooleanExtra("Is_Chatroom", true);
    this.eeO = ((MMActivity)this.mContext).getIntent().getBooleanExtra("Is_Lbsroom", false);
    aw.aaz();
    this.lpe = c.YA().arw(this.eeu);
    if (this.lpe != null)
    {
      paramView = this.wbO;
      aw.aaz();
      paramView.setChecked(c.YF().arP(this.lpe.field_username));
      this.wbQ.setChecked(a.je(this.lpe.field_type));
      this.wbP.setChecked(dpn());
    }
    this.wbO.setOnCheckedChangeListener(this.wbR);
    this.wbP.setOnCheckedChangeListener(this.wbR);
    this.wbQ.setOnCheckedChangeListener(this.wbR);
    AppMethodBeat.o(28126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.SpecialCheckBoxPreference
 * JD-Core Version:    0.7.0.1
 */