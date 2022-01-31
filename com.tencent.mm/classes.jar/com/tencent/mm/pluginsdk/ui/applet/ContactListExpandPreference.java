package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.List;

public class ContactListExpandPreference
  extends Preference
{
  private int vUj;
  public i vUk;
  public k vUl;
  
  public ContactListExpandPreference(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(79763);
    this.vUj = -1;
    if (paramInt == 0) {
      dnG();
    }
    for (;;)
    {
      setLayoutResource(2130970193);
      AppMethodBeat.o(79763);
      return;
      if (paramInt == 1)
      {
        this.vUj = 1;
        this.vUl = new k();
      }
    }
  }
  
  public ContactListExpandPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(79764);
    this.vUj = -1;
    dnG();
    setLayoutResource(2130970193);
    AppMethodBeat.o(79764);
  }
  
  public ContactListExpandPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(79765);
    this.vUj = -1;
    dnG();
    setLayoutResource(2130970193);
    AppMethodBeat.o(79765);
  }
  
  private void dnG()
  {
    AppMethodBeat.i(79766);
    this.vUj = 0;
    this.vUk = new i(this.mContext);
    AppMethodBeat.o(79766);
  }
  
  public final boolean LY(int paramInt)
  {
    AppMethodBeat.i(79772);
    if (this.vUk != null)
    {
      boolean bool = this.vUk.vTA.LY(paramInt);
      AppMethodBeat.o(79772);
      return bool;
    }
    AppMethodBeat.o(79772);
    return true;
  }
  
  public final boolean Ma(int paramInt)
  {
    AppMethodBeat.i(79773);
    if (this.vUk != null)
    {
      boolean bool = this.vUk.vTA.Ma(paramInt);
      AppMethodBeat.o(79773);
      return bool;
    }
    AppMethodBeat.o(79773);
    return false;
  }
  
  public final String Mb(int paramInt)
  {
    AppMethodBeat.i(79775);
    if ((this.vUk != null) && (this.vUk.vTA.Ma(paramInt)))
    {
      String str = ((ad)this.vUk.vTA.getItem(paramInt)).field_username;
      AppMethodBeat.o(79775);
      return str;
    }
    AppMethodBeat.o(79775);
    return "";
  }
  
  public final String Mc(int paramInt)
  {
    AppMethodBeat.i(79776);
    if ((this.vUk != null) && (this.vUk.vTA.Ma(paramInt)))
    {
      String str = ((ad)this.vUk.vTA.getItem(paramInt)).field_nickname;
      AppMethodBeat.o(79776);
      return str;
    }
    AppMethodBeat.o(79776);
    return "";
  }
  
  public final String Md(int paramInt)
  {
    AppMethodBeat.i(79777);
    if ((this.vUk != null) && (this.vUk.vTA.Ma(paramInt)))
    {
      String str = ((ad)this.vUk.vTA.getItem(paramInt)).field_conRemark;
      AppMethodBeat.o(79777);
      return str;
    }
    AppMethodBeat.o(79777);
    return "";
  }
  
  public final void a(ContactListExpandPreference.a parama)
  {
    if (this.vUk != null) {
      this.vUk.sqf = parama;
    }
  }
  
  public final void a(k.b paramb)
  {
    if (this.vUk != null) {
      this.vUk.vTB = paramb;
    }
  }
  
  public final void a(d paramd)
  {
    if (this.vUk != null) {
      this.vUk.vTA.vTR = paramd;
    }
  }
  
  public final void a(f paramf, String paramString)
  {
    AppMethodBeat.i(79768);
    if (this.vUk != null) {
      this.vUk.a(paramf, paramString);
    }
    AppMethodBeat.o(79768);
  }
  
  public final void ah(ArrayList<ad> paramArrayList)
  {
    AppMethodBeat.i(79771);
    if (this.vUk != null) {
      this.vUk.ah(paramArrayList);
    }
    AppMethodBeat.o(79771);
  }
  
  public final void amp(String paramString)
  {
    if (this.vUk != null) {
      this.vUk.vTA.vTY = paramString;
    }
  }
  
  public final void cg(List<String> paramList)
  {
    AppMethodBeat.i(79781);
    if (this.vUk != null) {
      this.vUk.vTA.cg(paramList);
    }
    AppMethodBeat.o(79781);
  }
  
  public final void dnB()
  {
    AppMethodBeat.i(79779);
    if (this.vUk != null) {
      this.vUk.dnB();
    }
    AppMethodBeat.o(79779);
  }
  
  public final void dnF()
  {
    AppMethodBeat.i(79778);
    if (this.vUk != null) {
      this.vUk.vTA.dnF();
    }
    AppMethodBeat.o(79778);
  }
  
  public final void dnH()
  {
    if (this.vUk != null) {
      this.vUk.vTA.vUc = false;
    }
  }
  
  public final ContactListExpandPreference dnI()
  {
    if (this.vUk != null) {
      this.vUk.vTA.vTU = false;
    }
    return this;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(79774);
    if ((this.vUk != null) && (this.vUk.vTA.Ma(paramInt)))
    {
      Object localObject = this.vUk.vTA.getItem(paramInt);
      AppMethodBeat.o(79774);
      return localObject;
    }
    AppMethodBeat.o(79774);
    return null;
  }
  
  public final void notifyChanged()
  {
    AppMethodBeat.i(79769);
    if (this.vUk != null) {
      this.vUk.aPD();
    }
    AppMethodBeat.o(79769);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(79767);
    ViewGroup localViewGroup;
    if (this.vUj == 1)
    {
      k localk = this.vUl;
      label77:
      int i;
      label163:
      label214:
      View localView;
      label252:
      LinearLayout.LayoutParams localLayoutParams;
      int j;
      if (paramView.getId() == 2131826200)
      {
        localViewGroup = (ViewGroup)paramView;
        if (localk.row != 0) {
          break label450;
        }
        localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getResources().getDimensionPixelSize(2131427781), localViewGroup.getPaddingRight(), localViewGroup.getResources().getDimensionPixelSize(2131427792));
        if (((localk.vTA.vTQ % j.vTJ != j.vTJ - 1) && (localk.vTA.vTQ % j.vTJ != 0)) || (!localk.efd) || (localk.row != localk.vTA.getCount() / j.vTJ - 1)) {
          break label543;
        }
        localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getPaddingTop(), localViewGroup.getPaddingRight(), 0);
        if (localk.vTA == null) {
          break label693;
        }
        localViewGroup.setOnClickListener(localk.qaq);
        if (localViewGroup.getChildCount() > j.vTJ)
        {
          localViewGroup.removeViews(0, localViewGroup.getChildCount() - j.vTJ);
          localViewGroup.requestLayout();
        }
        i = 0;
        if (i >= localk.vUm) {
          break label660;
        }
        if (localViewGroup.getChildAt(i) != null) {
          break label626;
        }
        localView = View.inflate(localViewGroup.getContext(), 2130970591, null);
        localViewGroup.addView(localView);
        localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.gravity = 49;
        if (j.vTJ != 4) {
          break label637;
        }
        j = localViewGroup.getResources().getDimensionPixelSize(2131427808);
        localLayoutParams.setMargins(j, 0, j, 0);
      }
      for (;;)
      {
        if ((!localk.vTA.dnD()) && (localk.vTA.vTQ == 1))
        {
          j = localViewGroup.getResources().getDimensionPixelSize(2131427506);
          localLayoutParams.setMargins(j, 0, j, 0);
        }
        localView.setLayoutParams(localLayoutParams);
        j = localk.row * localk.vUm + i;
        localk.vTA.getView(j, localView, localViewGroup);
        if (localk.vTG != null) {
          localView.setOnClickListener(new k.3(localk, localViewGroup, j));
        }
        if (localk.vUn != null) {
          localView.setOnLongClickListener(new k.4(localk, localViewGroup, j));
        }
        i += 1;
        break label214;
        localViewGroup = (ViewGroup)paramView.findViewById(2131826200);
        break;
        label450:
        if (localk.row == localk.vTA.getCount() / j.vTJ - 1)
        {
          localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getPaddingTop(), localViewGroup.getPaddingRight(), localViewGroup.getResources().getDimensionPixelSize(2131427781));
          break label77;
        }
        localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getResources().getDimensionPixelSize(2131427792), localViewGroup.getPaddingRight(), localViewGroup.getResources().getDimensionPixelSize(2131427792));
        break label77;
        label543:
        if ((localk.efd) || (localk.vTA.vTQ % j.vTJ != 0) || (localk.row != localk.vTA.getCount() / j.vTJ - 1)) {
          break label163;
        }
        localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getPaddingTop(), localViewGroup.getPaddingRight(), (int)localViewGroup.getContext().getResources().getDimension(2131427854));
        break label163;
        label626:
        localView = localViewGroup.getChildAt(i);
        break label252;
        label637:
        j = localViewGroup.getResources().getDimensionPixelSize(2131427792);
        localLayoutParams.setMargins(j, 0, j, 0);
      }
      label660:
      if ((!localk.vTA.dnD()) && (localk.vTA.vTQ <= 1)) {
        break label704;
      }
      ((LinearLayout)localViewGroup).setGravity(17);
    }
    for (;;)
    {
      label693:
      super.onBindView(paramView);
      AppMethodBeat.o(79767);
      return;
      label704:
      ((LinearLayout)localViewGroup).setGravity(19);
    }
  }
  
  public final ContactListExpandPreference pf(boolean paramBoolean)
  {
    if (this.vUk != null) {
      this.vUk.vTA.vTT = paramBoolean;
    }
    return this;
  }
  
  public final ContactListExpandPreference pg(boolean paramBoolean)
  {
    if (this.vUk != null) {
      this.vUk.vTA.vTS = paramBoolean;
    }
    return this;
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(79780);
    if (this.vUk != null) {
      this.vUk.vTA.Kc();
    }
    AppMethodBeat.o(79780);
  }
  
  public final void v(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(79770);
    if (this.vUk != null) {
      this.vUk.v(paramString, paramList);
    }
    AppMethodBeat.o(79770);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference
 * JD-Core Version:    0.7.0.1
 */