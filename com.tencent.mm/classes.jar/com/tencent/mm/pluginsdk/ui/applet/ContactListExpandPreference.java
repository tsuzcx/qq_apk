package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.plugin.patmsg.ui.AvatarPatTipImageView;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.storage.am;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.List;

public class ContactListExpandPreference
  extends Preference
{
  private int EWL;
  public q EWM;
  public s EWN;
  
  public ContactListExpandPreference(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(152211);
    this.EWL = -1;
    if (paramInt == 0) {
      fcI();
    }
    for (;;)
    {
      setLayoutResource(2131494818);
      AppMethodBeat.o(152211);
      return;
      if (paramInt == 1)
      {
        this.EWL = 1;
        this.EWN = new s();
      }
    }
  }
  
  public ContactListExpandPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(152212);
    this.EWL = -1;
    fcI();
    setLayoutResource(2131494818);
    AppMethodBeat.o(152212);
  }
  
  public ContactListExpandPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(152213);
    this.EWL = -1;
    fcI();
    setLayoutResource(2131494818);
    AppMethodBeat.o(152213);
  }
  
  private void fcI()
  {
    AppMethodBeat.i(152214);
    this.EWL = 0;
    this.EWM = new q(this.mContext);
    AppMethodBeat.o(152214);
  }
  
  public final void A(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(152218);
    if (this.EWM != null) {
      this.EWM.A(paramString, paramList);
    }
    AppMethodBeat.o(152218);
  }
  
  public final boolean YU(int paramInt)
  {
    AppMethodBeat.i(152220);
    if (this.EWM != null)
    {
      boolean bool = this.EWM.EWc.YU(paramInt);
      AppMethodBeat.o(152220);
      return bool;
    }
    AppMethodBeat.o(152220);
    return true;
  }
  
  public final boolean YW(int paramInt)
  {
    AppMethodBeat.i(152221);
    if (this.EWM != null)
    {
      boolean bool = this.EWM.EWc.YW(paramInt);
      AppMethodBeat.o(152221);
      return bool;
    }
    AppMethodBeat.o(152221);
    return false;
  }
  
  public final String YX(int paramInt)
  {
    AppMethodBeat.i(152223);
    if ((this.EWM != null) && (this.EWM.EWc.YW(paramInt)))
    {
      String str = ((am)this.EWM.EWc.getItem(paramInt)).field_username;
      AppMethodBeat.o(152223);
      return str;
    }
    AppMethodBeat.o(152223);
    return "";
  }
  
  public final String YY(int paramInt)
  {
    AppMethodBeat.i(152224);
    if ((this.EWM != null) && (this.EWM.EWc.YW(paramInt)))
    {
      String str = ((am)this.EWM.EWc.getItem(paramInt)).field_nickname;
      AppMethodBeat.o(152224);
      return str;
    }
    AppMethodBeat.o(152224);
    return "";
  }
  
  public final String YZ(int paramInt)
  {
    AppMethodBeat.i(152225);
    if ((this.EWM != null) && (this.EWM.EWc.YW(paramInt)))
    {
      String str = ((am)this.EWM.EWc.getItem(paramInt)).field_conRemark;
      AppMethodBeat.o(152225);
      return str;
    }
    AppMethodBeat.o(152225);
    return "";
  }
  
  public final void a(a parama)
  {
    if (this.EWM != null) {
      this.EWM.AHo = parama;
    }
  }
  
  public final void a(s.b paramb)
  {
    if (this.EWM != null) {
      this.EWM.EWd = paramb;
    }
  }
  
  public final void a(e parame)
  {
    if (this.EWM != null) {
      this.EWM.EWc.EWt = parame;
    }
  }
  
  public final void a(f paramf, String paramString)
  {
    AppMethodBeat.i(152216);
    if (this.EWM != null) {
      this.EWM.a(paramf, paramString);
    }
    AppMethodBeat.o(152216);
  }
  
  public final void aMV(String paramString)
  {
    if (this.EWM != null) {
      this.EWM.EWc.EWA = paramString;
    }
  }
  
  public final void aN(ArrayList<am> paramArrayList)
  {
    AppMethodBeat.i(152219);
    if (this.EWM != null) {
      this.EWM.aN(paramArrayList);
    }
    AppMethodBeat.o(152219);
  }
  
  public final void eo(List<String> paramList)
  {
    AppMethodBeat.i(152229);
    if (this.EWM != null) {
      this.EWM.EWc.eo(paramList);
    }
    AppMethodBeat.o(152229);
  }
  
  public final void fcD()
  {
    AppMethodBeat.i(152227);
    if (this.EWM != null) {
      this.EWM.fcD();
    }
    AppMethodBeat.o(152227);
  }
  
  public final void fcH()
  {
    AppMethodBeat.i(152226);
    if (this.EWM != null) {
      this.EWM.EWc.fcH();
    }
    AppMethodBeat.o(152226);
  }
  
  public final void fcJ()
  {
    if (this.EWM != null) {
      this.EWM.EWc.EWE = false;
    }
  }
  
  public final ContactListExpandPreference fcK()
  {
    if (this.EWM != null) {
      this.EWM.EWc.EWw = false;
    }
    return this;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(152222);
    if ((this.EWM != null) && (this.EWM.EWc.YW(paramInt)))
    {
      Object localObject = this.EWM.EWc.getItem(paramInt);
      AppMethodBeat.o(152222);
      return localObject;
    }
    AppMethodBeat.o(152222);
    return null;
  }
  
  public final void notifyChanged()
  {
    AppMethodBeat.i(152217);
    if (this.EWM != null) {
      this.EWM.bDh();
    }
    AppMethodBeat.o(152217);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(152215);
    ViewGroup localViewGroup;
    if (this.EWL == 1)
    {
      s locals = this.EWN;
      locals.kBS = paramView;
      label83:
      int i;
      label169:
      label220:
      Object localObject;
      label259:
      LinearLayout.LayoutParams localLayoutParams;
      int j;
      if (paramView.getId() == 2131298675)
      {
        localViewGroup = (ViewGroup)paramView;
        if (locals.row != 0) {
          break label501;
        }
        localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getResources().getDimensionPixelSize(2131165489), localViewGroup.getPaddingRight(), localViewGroup.getResources().getDimensionPixelSize(2131165500));
        if (((locals.EWc.EWs % r.EWl != r.EWl - 1) && (locals.EWc.EWs % r.EWl != 0)) || (!locals.fMM) || (locals.row != locals.EWc.getCount() / r.EWl - 1)) {
          break label594;
        }
        localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getPaddingTop(), localViewGroup.getPaddingRight(), 0);
        if (locals.EWc == null) {
          break label744;
        }
        localViewGroup.setOnClickListener(locals.km);
        if (localViewGroup.getChildCount() > r.EWl)
        {
          localViewGroup.removeViews(0, localViewGroup.getChildCount() - r.EWl);
          localViewGroup.requestLayout();
        }
        i = 0;
        if (i >= locals.EWO) {
          break label711;
        }
        if (localViewGroup.getChildAt(i) != null) {
          break label677;
        }
        localObject = View.inflate(localViewGroup.getContext(), 2131495276, null);
        localViewGroup.addView((View)localObject);
        localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.gravity = 49;
        if (r.EWl != 4) {
          break label688;
        }
        j = localViewGroup.getResources().getDimensionPixelSize(2131165516);
        localLayoutParams.setMargins(j, 0, j, 0);
      }
      for (;;)
      {
        if ((!locals.EWc.fcF()) && (locals.EWc.EWs == 1))
        {
          j = localViewGroup.getResources().getDimensionPixelSize(2131165198);
          localLayoutParams.setMargins(j, 0, j, 0);
        }
        ((View)localObject).setLayoutParams(localLayoutParams);
        j = locals.row * locals.EWO + i;
        locals.EWc.getView(j, (View)localObject, localViewGroup);
        if (locals.EWi != null) {
          ((View)localObject).setOnClickListener(new s.3(locals, localViewGroup, j));
        }
        if (locals.EWP != null) {
          ((View)localObject).setOnLongClickListener(new s.4(locals, localViewGroup, j));
        }
        localObject = (AvatarPatTipImageView)((View)localObject).findViewById(2131304237);
        ((AvatarPatTipImageView)localObject).setOnDoubleClickListener(new s.5(locals));
        ((AvatarPatTipImageView)localObject).setOnClickListener(new s.6(locals, localViewGroup, j));
        i += 1;
        break label220;
        localViewGroup = (ViewGroup)paramView.findViewById(2131298675);
        break;
        label501:
        if (locals.row == locals.EWc.getCount() / r.EWl - 1)
        {
          localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getPaddingTop(), localViewGroup.getPaddingRight(), localViewGroup.getResources().getDimensionPixelSize(2131165489));
          break label83;
        }
        localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getResources().getDimensionPixelSize(2131165500), localViewGroup.getPaddingRight(), localViewGroup.getResources().getDimensionPixelSize(2131165500));
        break label83;
        label594:
        if ((locals.fMM) || (locals.EWc.EWs % r.EWl != 0) || (locals.row != locals.EWc.getCount() / r.EWl - 1)) {
          break label169;
        }
        localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getPaddingTop(), localViewGroup.getPaddingRight(), (int)localViewGroup.getContext().getResources().getDimension(2131165568));
        break label169;
        label677:
        localObject = localViewGroup.getChildAt(i);
        break label259;
        label688:
        j = localViewGroup.getResources().getDimensionPixelSize(2131165500);
        localLayoutParams.setMargins(j, 0, j, 0);
      }
      label711:
      if ((!locals.EWc.fcF()) && (locals.EWc.EWs <= 1)) {
        break label755;
      }
      ((LinearLayout)localViewGroup).setGravity(17);
    }
    for (;;)
    {
      label744:
      super.onBindView(paramView);
      AppMethodBeat.o(152215);
      return;
      label755:
      ((LinearLayout)localViewGroup).setGravity(19);
    }
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(152228);
    if (this.EWM != null) {
      this.EWM.EWc.Zd();
    }
    AppMethodBeat.o(152228);
  }
  
  public final void vN(boolean paramBoolean)
  {
    AppMethodBeat.i(214482);
    if (this.EWM != null) {
      this.EWM.vN(paramBoolean);
    }
    if (this.EWN != null) {
      this.EWN.EWb = paramBoolean;
    }
    AppMethodBeat.o(214482);
  }
  
  public final ContactListExpandPreference vO(boolean paramBoolean)
  {
    if (this.EWM != null) {
      this.EWM.EWc.EWv = paramBoolean;
    }
    return this;
  }
  
  public final ContactListExpandPreference vP(boolean paramBoolean)
  {
    if (this.EWM != null) {
      this.EWM.EWc.EWu = paramBoolean;
    }
    return this;
  }
  
  public static abstract interface a
  {
    public abstract void YJ();
    
    public abstract void e(ViewGroup paramViewGroup, int paramInt);
    
    public abstract void lc(int paramInt);
    
    public abstract void ld(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference
 * JD-Core Version:    0.7.0.1
 */