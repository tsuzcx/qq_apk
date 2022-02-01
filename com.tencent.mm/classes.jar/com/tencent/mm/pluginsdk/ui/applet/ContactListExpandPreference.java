package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.plugin.patmsg.ui.AvatarPatTipImageView;
import com.tencent.mm.pluginsdk.a.a.a;
import com.tencent.mm.pluginsdk.a.a.c;
import com.tencent.mm.pluginsdk.a.a.d;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.List;

public class ContactListExpandPreference
  extends Preference
{
  private int RgL;
  public q RgM;
  public s RgN;
  
  public ContactListExpandPreference(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(152211);
    this.RgL = -1;
    if (paramInt == 0) {
      hkD();
    }
    for (;;)
    {
      setLayoutResource(a.d.mm_preference_contact_list_row);
      AppMethodBeat.o(152211);
      return;
      if (paramInt == 1)
      {
        this.RgL = 1;
        this.RgN = new s();
      }
    }
  }
  
  public ContactListExpandPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(152212);
    this.RgL = -1;
    hkD();
    setLayoutResource(a.d.mm_preference_contact_list_row);
    AppMethodBeat.o(152212);
  }
  
  public ContactListExpandPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(152213);
    this.RgL = -1;
    hkD();
    setLayoutResource(a.d.mm_preference_contact_list_row);
    AppMethodBeat.o(152213);
  }
  
  private void hkD()
  {
    AppMethodBeat.i(152214);
    this.RgL = 0;
    this.RgM = new q(this.mContext);
    AppMethodBeat.o(152214);
  }
  
  public final void DY(boolean paramBoolean)
  {
    AppMethodBeat.i(191469);
    if (this.RgM != null) {
      this.RgM.DY(paramBoolean);
    }
    if (this.RgN != null) {
      this.RgN.Rgb = paramBoolean;
    }
    AppMethodBeat.o(191469);
  }
  
  public final ContactListExpandPreference DZ(boolean paramBoolean)
  {
    if (this.RgM != null) {
      this.RgM.Rgc.Rgv = paramBoolean;
    }
    return this;
  }
  
  public final ContactListExpandPreference Ea(boolean paramBoolean)
  {
    if (this.RgM != null) {
      this.RgM.Rgc.Rgu = paramBoolean;
    }
    return this;
  }
  
  public final void a(a parama)
  {
    if (this.RgM != null) {
      this.RgM.Lyz = parama;
    }
  }
  
  public final void a(s.b paramb)
  {
    if (this.RgM != null) {
      this.RgM.Rgd = paramb;
    }
  }
  
  public final void a(e parame)
  {
    if (this.RgM != null) {
      this.RgM.Rgc.Rgt = parame;
    }
  }
  
  public final void a(f paramf, String paramString)
  {
    AppMethodBeat.i(152216);
    if (this.RgM != null) {
      this.RgM.a(paramf, paramString);
    }
    AppMethodBeat.o(152216);
  }
  
  public final boolean aqn(int paramInt)
  {
    AppMethodBeat.i(152220);
    if (this.RgM != null)
    {
      boolean bool = this.RgM.Rgc.aqn(paramInt);
      AppMethodBeat.o(152220);
      return bool;
    }
    AppMethodBeat.o(152220);
    return true;
  }
  
  public final boolean aqp(int paramInt)
  {
    AppMethodBeat.i(152221);
    if (this.RgM != null)
    {
      boolean bool = this.RgM.Rgc.aqp(paramInt);
      AppMethodBeat.o(152221);
      return bool;
    }
    AppMethodBeat.o(152221);
    return false;
  }
  
  public final String aqq(int paramInt)
  {
    AppMethodBeat.i(152223);
    if ((this.RgM != null) && (this.RgM.Rgc.aqp(paramInt)))
    {
      String str = ((as)this.RgM.Rgc.getItem(paramInt)).field_username;
      AppMethodBeat.o(152223);
      return str;
    }
    AppMethodBeat.o(152223);
    return "";
  }
  
  public final String aqr(int paramInt)
  {
    AppMethodBeat.i(152224);
    if ((this.RgM != null) && (this.RgM.Rgc.aqp(paramInt)))
    {
      String str = ((as)this.RgM.Rgc.getItem(paramInt)).field_nickname;
      AppMethodBeat.o(152224);
      return str;
    }
    AppMethodBeat.o(152224);
    return "";
  }
  
  public final String aqs(int paramInt)
  {
    AppMethodBeat.i(152225);
    if ((this.RgM != null) && (this.RgM.Rgc.aqp(paramInt)))
    {
      String str = ((as)this.RgM.Rgc.getItem(paramInt)).field_conRemark;
      AppMethodBeat.o(152225);
      return str;
    }
    AppMethodBeat.o(152225);
    return "";
  }
  
  public final void bfU()
  {
    AppMethodBeat.i(152228);
    if (this.RgM != null) {
      this.RgM.Rgc.ata();
    }
    AppMethodBeat.o(152228);
  }
  
  public final void brp(String paramString)
  {
    if (this.RgM != null) {
      this.RgM.Rgc.RgA = paramString;
    }
  }
  
  public final void bv(ArrayList<as> paramArrayList)
  {
    AppMethodBeat.i(152219);
    if (this.RgM != null) {
      this.RgM.bv(paramArrayList);
    }
    AppMethodBeat.o(152219);
  }
  
  public final void fO(List<String> paramList)
  {
    AppMethodBeat.i(152229);
    if (this.RgM != null) {
      this.RgM.Rgc.fO(paramList);
    }
    AppMethodBeat.o(152229);
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(152222);
    if ((this.RgM != null) && (this.RgM.Rgc.aqp(paramInt)))
    {
      Object localObject = this.RgM.Rgc.getItem(paramInt);
      AppMethodBeat.o(152222);
      return localObject;
    }
    AppMethodBeat.o(152222);
    return null;
  }
  
  public final void hkC()
  {
    AppMethodBeat.i(152226);
    if (this.RgM != null) {
      this.RgM.Rgc.hkC();
    }
    AppMethodBeat.o(152226);
  }
  
  public final void hkE()
  {
    if (this.RgM != null) {
      this.RgM.Rgc.RgE = false;
    }
  }
  
  public final ContactListExpandPreference hkF()
  {
    if (this.RgM != null) {
      this.RgM.Rgc.Rgw = false;
    }
    return this;
  }
  
  public final void hky()
  {
    AppMethodBeat.i(152227);
    if (this.RgM != null) {
      this.RgM.hky();
    }
    AppMethodBeat.o(152227);
  }
  
  public final void notifyChanged()
  {
    AppMethodBeat.i(152217);
    if (this.RgM != null) {
      this.RgM.cnv();
    }
    AppMethodBeat.o(152217);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(152215);
    ViewGroup localViewGroup;
    if (this.RgL == 1)
    {
      s locals = this.RgN;
      locals.oFW = paramView;
      label86:
      int i;
      label172:
      label223:
      Object localObject;
      label262:
      LinearLayout.LayoutParams localLayoutParams;
      int j;
      if (paramView.getId() == a.c.contact_list_content_layout)
      {
        localViewGroup = (ViewGroup)paramView;
        if (locals.row != 0) {
          break label505;
        }
        localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getResources().getDimensionPixelSize(a.a.ListPadding), localViewGroup.getPaddingRight(), localViewGroup.getResources().getDimensionPixelSize(a.a.MiddlePadding));
        if (((locals.Rgc.Rgs % r.Rgl != r.Rgl - 1) && (locals.Rgc.Rgs % r.Rgl != 0)) || (!locals.iYp) || (locals.row != locals.Rgc.getCount() / r.Rgl - 1)) {
          break label601;
        }
        localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getPaddingTop(), localViewGroup.getPaddingRight(), 0);
        if (locals.Rgc == null) {
          break label752;
        }
        localViewGroup.setOnClickListener(locals.bwV);
        if (localViewGroup.getChildCount() > r.Rgl)
        {
          localViewGroup.removeViews(0, localViewGroup.getChildCount() - r.Rgl);
          localViewGroup.requestLayout();
        }
        i = 0;
        if (i >= locals.RgO) {
          break label719;
        }
        if (localViewGroup.getChildAt(i) != null) {
          break label684;
        }
        localObject = View.inflate(localViewGroup.getContext(), a.d.roominfo_contact, null);
        localViewGroup.addView((View)localObject);
        localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.gravity = 49;
        if (r.Rgl != 4) {
          break label695;
        }
        j = localViewGroup.getResources().getDimensionPixelSize(a.a.NormalPadding);
        localLayoutParams.setMargins(j, 0, j, 0);
      }
      for (;;)
      {
        if ((!locals.Rgc.hkA()) && (locals.Rgc.Rgs == 1))
        {
          j = localViewGroup.getResources().getDimensionPixelSize(a.a.BiggerPadding);
          localLayoutParams.setMargins(j, 0, j, 0);
        }
        ((View)localObject).setLayoutParams(localLayoutParams);
        j = locals.row * locals.RgO + i;
        locals.Rgc.getView(j, (View)localObject, localViewGroup);
        if (locals.Rgi != null) {
          ((View)localObject).setOnClickListener(new s.3(locals, localViewGroup, j));
        }
        if (locals.RgP != null) {
          ((View)localObject).setOnLongClickListener(new s.4(locals, localViewGroup, j));
        }
        localObject = (AvatarPatTipImageView)((View)localObject).findViewById(a.c.roominfo_img);
        ((AvatarPatTipImageView)localObject).setOnDoubleClickListener(new s.5(locals));
        ((AvatarPatTipImageView)localObject).setOnClickListener(new s.6(locals, localViewGroup, j));
        i += 1;
        break label223;
        localViewGroup = (ViewGroup)paramView.findViewById(a.c.contact_list_content_layout);
        break;
        label505:
        if (locals.row == locals.Rgc.getCount() / r.Rgl - 1)
        {
          localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getPaddingTop(), localViewGroup.getPaddingRight(), localViewGroup.getResources().getDimensionPixelSize(a.a.ListPadding));
          break label86;
        }
        localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getResources().getDimensionPixelSize(a.a.MiddlePadding), localViewGroup.getPaddingRight(), localViewGroup.getResources().getDimensionPixelSize(a.a.MiddlePadding));
        break label86;
        label601:
        if ((locals.iYp) || (locals.Rgc.Rgs % r.Rgl != 0) || (locals.row != locals.Rgc.getCount() / r.Rgl - 1)) {
          break label172;
        }
        localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getPaddingTop(), localViewGroup.getPaddingRight(), (int)localViewGroup.getContext().getResources().getDimension(a.a.SmallPadding));
        break label172;
        label684:
        localObject = localViewGroup.getChildAt(i);
        break label262;
        label695:
        j = localViewGroup.getResources().getDimensionPixelSize(a.a.MiddlePadding);
        localLayoutParams.setMargins(j, 0, j, 0);
      }
      label719:
      if ((!locals.Rgc.hkA()) && (locals.Rgc.Rgs <= 1)) {
        break label763;
      }
      ((LinearLayout)localViewGroup).setGravity(17);
    }
    for (;;)
    {
      label752:
      super.onBindView(paramView);
      AppMethodBeat.o(152215);
      return;
      label763:
      ((LinearLayout)localViewGroup).setGravity(19);
    }
  }
  
  public final void s(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(152218);
    if (this.RgM != null) {
      this.RgM.s(paramString, paramList);
    }
    AppMethodBeat.o(152218);
  }
  
  public static abstract interface a
  {
    public abstract void asG();
    
    public abstract void e(ViewGroup paramViewGroup, int paramInt);
    
    public abstract void qv(int paramInt);
    
    public abstract void qw(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference
 * JD-Core Version:    0.7.0.1
 */