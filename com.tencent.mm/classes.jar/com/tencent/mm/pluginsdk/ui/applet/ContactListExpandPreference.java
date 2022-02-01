package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.List;

public class ContactListExpandPreference
  extends Preference
{
  private int DrH;
  public q DrI;
  public s DrJ;
  
  public ContactListExpandPreference(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(152211);
    this.DrH = -1;
    if (paramInt == 0) {
      eNJ();
    }
    for (;;)
    {
      setLayoutResource(2131494818);
      AppMethodBeat.o(152211);
      return;
      if (paramInt == 1)
      {
        this.DrH = 1;
        this.DrJ = new s();
      }
    }
  }
  
  public ContactListExpandPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(152212);
    this.DrH = -1;
    eNJ();
    setLayoutResource(2131494818);
    AppMethodBeat.o(152212);
  }
  
  public ContactListExpandPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(152213);
    this.DrH = -1;
    eNJ();
    setLayoutResource(2131494818);
    AppMethodBeat.o(152213);
  }
  
  private void eNJ()
  {
    AppMethodBeat.i(152214);
    this.DrH = 0;
    this.DrI = new q(this.mContext);
    AppMethodBeat.o(152214);
  }
  
  public final boolean WY(int paramInt)
  {
    AppMethodBeat.i(152220);
    if (this.DrI != null)
    {
      boolean bool = this.DrI.DqY.WY(paramInt);
      AppMethodBeat.o(152220);
      return bool;
    }
    AppMethodBeat.o(152220);
    return true;
  }
  
  public final boolean Xa(int paramInt)
  {
    AppMethodBeat.i(152221);
    if (this.DrI != null)
    {
      boolean bool = this.DrI.DqY.Xa(paramInt);
      AppMethodBeat.o(152221);
      return bool;
    }
    AppMethodBeat.o(152221);
    return false;
  }
  
  public final String Xb(int paramInt)
  {
    AppMethodBeat.i(152223);
    if ((this.DrI != null) && (this.DrI.DqY.Xa(paramInt)))
    {
      String str = ((ai)this.DrI.DqY.getItem(paramInt)).field_username;
      AppMethodBeat.o(152223);
      return str;
    }
    AppMethodBeat.o(152223);
    return "";
  }
  
  public final String Xc(int paramInt)
  {
    AppMethodBeat.i(152224);
    if ((this.DrI != null) && (this.DrI.DqY.Xa(paramInt)))
    {
      String str = ((ai)this.DrI.DqY.getItem(paramInt)).field_nickname;
      AppMethodBeat.o(152224);
      return str;
    }
    AppMethodBeat.o(152224);
    return "";
  }
  
  public final String Xd(int paramInt)
  {
    AppMethodBeat.i(152225);
    if ((this.DrI != null) && (this.DrI.DqY.Xa(paramInt)))
    {
      String str = ((ai)this.DrI.DqY.getItem(paramInt)).field_conRemark;
      AppMethodBeat.o(152225);
      return str;
    }
    AppMethodBeat.o(152225);
    return "";
  }
  
  public final void a(a parama)
  {
    if (this.DrI != null) {
      this.DrI.zpu = parama;
    }
  }
  
  public final void a(s.b paramb)
  {
    if (this.DrI != null) {
      this.DrI.DqZ = paramb;
    }
  }
  
  public final void a(d paramd)
  {
    if (this.DrI != null) {
      this.DrI.DqY.Drp = paramd;
    }
  }
  
  public final void a(f paramf, String paramString)
  {
    AppMethodBeat.i(152216);
    if (this.DrI != null) {
      this.DrI.a(paramf, paramString);
    }
    AppMethodBeat.o(152216);
  }
  
  public final void aHs(String paramString)
  {
    if (this.DrI != null) {
      this.DrI.DqY.Drw = paramString;
    }
  }
  
  public final void aQ(ArrayList<ai> paramArrayList)
  {
    AppMethodBeat.i(152219);
    if (this.DrI != null) {
      this.DrI.aQ(paramArrayList);
    }
    AppMethodBeat.o(152219);
  }
  
  public final void eNE()
  {
    AppMethodBeat.i(152227);
    if (this.DrI != null) {
      this.DrI.eNE();
    }
    AppMethodBeat.o(152227);
  }
  
  public final void eNI()
  {
    AppMethodBeat.i(152226);
    if (this.DrI != null) {
      this.DrI.DqY.eNI();
    }
    AppMethodBeat.o(152226);
  }
  
  public final void eNK()
  {
    if (this.DrI != null) {
      this.DrI.DqY.DrA = false;
    }
  }
  
  public final ContactListExpandPreference eNL()
  {
    if (this.DrI != null) {
      this.DrI.DqY.Drs = false;
    }
    return this;
  }
  
  public final void eb(List<String> paramList)
  {
    AppMethodBeat.i(152229);
    if (this.DrI != null) {
      this.DrI.DqY.eb(paramList);
    }
    AppMethodBeat.o(152229);
  }
  
  public final void gS(List<String> paramList)
  {
    AppMethodBeat.i(210359);
    y(null, paramList);
    AppMethodBeat.o(210359);
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(152222);
    if ((this.DrI != null) && (this.DrI.DqY.Xa(paramInt)))
    {
      Object localObject = this.DrI.DqY.getItem(paramInt);
      AppMethodBeat.o(152222);
      return localObject;
    }
    AppMethodBeat.o(152222);
    return null;
  }
  
  public final void notifyChanged()
  {
    AppMethodBeat.i(152217);
    if (this.DrI != null) {
      this.DrI.bzd();
    }
    AppMethodBeat.o(152217);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(152215);
    ViewGroup localViewGroup;
    if (this.DrH == 1)
    {
      s locals = this.DrJ;
      label77:
      int i;
      label163:
      label214:
      View localView;
      label252:
      LinearLayout.LayoutParams localLayoutParams;
      int j;
      if (paramView.getId() == 2131298675)
      {
        localViewGroup = (ViewGroup)paramView;
        if (locals.row != 0) {
          break label450;
        }
        localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getResources().getDimensionPixelSize(2131165489), localViewGroup.getPaddingRight(), localViewGroup.getResources().getDimensionPixelSize(2131165500));
        if (((locals.DqY.Dro % r.Drh != r.Drh - 1) && (locals.DqY.Dro % r.Drh != 0)) || (!locals.ftK) || (locals.row != locals.DqY.getCount() / r.Drh - 1)) {
          break label543;
        }
        localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getPaddingTop(), localViewGroup.getPaddingRight(), 0);
        if (locals.DqY == null) {
          break label693;
        }
        localViewGroup.setOnClickListener(locals.iu);
        if (localViewGroup.getChildCount() > r.Drh)
        {
          localViewGroup.removeViews(0, localViewGroup.getChildCount() - r.Drh);
          localViewGroup.requestLayout();
        }
        i = 0;
        if (i >= locals.DrK) {
          break label660;
        }
        if (localViewGroup.getChildAt(i) != null) {
          break label626;
        }
        localView = View.inflate(localViewGroup.getContext(), 2131495276, null);
        localViewGroup.addView(localView);
        localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.gravity = 49;
        if (r.Drh != 4) {
          break label637;
        }
        j = localViewGroup.getResources().getDimensionPixelSize(2131165516);
        localLayoutParams.setMargins(j, 0, j, 0);
      }
      for (;;)
      {
        if ((!locals.DqY.eNG()) && (locals.DqY.Dro == 1))
        {
          j = localViewGroup.getResources().getDimensionPixelSize(2131165198);
          localLayoutParams.setMargins(j, 0, j, 0);
        }
        localView.setLayoutParams(localLayoutParams);
        j = locals.row * locals.DrK + i;
        locals.DqY.getView(j, localView, localViewGroup);
        if (locals.Dre != null) {
          localView.setOnClickListener(new s.3(locals, localViewGroup, j));
        }
        if (locals.DrL != null) {
          localView.setOnLongClickListener(new s.4(locals, localViewGroup, j));
        }
        i += 1;
        break label214;
        localViewGroup = (ViewGroup)paramView.findViewById(2131298675);
        break;
        label450:
        if (locals.row == locals.DqY.getCount() / r.Drh - 1)
        {
          localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getPaddingTop(), localViewGroup.getPaddingRight(), localViewGroup.getResources().getDimensionPixelSize(2131165489));
          break label77;
        }
        localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getResources().getDimensionPixelSize(2131165500), localViewGroup.getPaddingRight(), localViewGroup.getResources().getDimensionPixelSize(2131165500));
        break label77;
        label543:
        if ((locals.ftK) || (locals.DqY.Dro % r.Drh != 0) || (locals.row != locals.DqY.getCount() / r.Drh - 1)) {
          break label163;
        }
        localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getPaddingTop(), localViewGroup.getPaddingRight(), (int)localViewGroup.getContext().getResources().getDimension(2131165568));
        break label163;
        label626:
        localView = localViewGroup.getChildAt(i);
        break label252;
        label637:
        j = localViewGroup.getResources().getDimensionPixelSize(2131165500);
        localLayoutParams.setMargins(j, 0, j, 0);
      }
      label660:
      if ((!locals.DqY.eNG()) && (locals.DqY.Dro <= 1)) {
        break label704;
      }
      ((LinearLayout)localViewGroup).setGravity(17);
    }
    for (;;)
    {
      label693:
      super.onBindView(paramView);
      AppMethodBeat.o(152215);
      return;
      label704:
      ((LinearLayout)localViewGroup).setGravity(19);
    }
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(152228);
    if (this.DrI != null) {
      this.DrI.DqY.WJ();
    }
    AppMethodBeat.o(152228);
  }
  
  public final ContactListExpandPreference vc(boolean paramBoolean)
  {
    if (this.DrI != null) {
      this.DrI.DqY.Drr = paramBoolean;
    }
    return this;
  }
  
  public final ContactListExpandPreference vd(boolean paramBoolean)
  {
    if (this.DrI != null) {
      this.DrI.DqY.Drq = paramBoolean;
    }
    return this;
  }
  
  public final void y(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(152218);
    if (this.DrI != null) {
      this.DrI.y(paramString, paramList);
    }
    AppMethodBeat.o(152218);
  }
  
  public static abstract interface a
  {
    public abstract void a(ViewGroup paramViewGroup, View paramView, int paramInt);
    
    public abstract void b(ViewGroup paramViewGroup, View paramView, int paramInt);
    
    public abstract void c(ViewGroup paramViewGroup, View paramView, int paramInt);
    
    public abstract void d(ViewGroup paramViewGroup, View paramView);
    
    public abstract void e(ViewGroup paramViewGroup, View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference
 * JD-Core Version:    0.7.0.1
 */