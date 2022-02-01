package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.plugin.patmsg.ui.AvatarPatTipImageView;
import com.tencent.mm.pluginsdk.a.a.a;
import com.tencent.mm.pluginsdk.a.a.c;
import com.tencent.mm.pluginsdk.a.a.d;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.List;

public class ContactListExpandPreference
  extends Preference
{
  private int YcO;
  public q YcP;
  public s YcQ;
  
  public ContactListExpandPreference(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(152211);
    this.YcO = -1;
    if (paramInt == 0) {
      iLu();
    }
    for (;;)
    {
      setLayoutResource(a.d.mm_preference_contact_list_row);
      AppMethodBeat.o(152211);
      return;
      if (paramInt == 1)
      {
        this.YcO = 1;
        this.YcQ = new s();
      }
    }
  }
  
  public ContactListExpandPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(152212);
    this.YcO = -1;
    iLu();
    setLayoutResource(a.d.mm_preference_contact_list_row);
    AppMethodBeat.o(152212);
  }
  
  public ContactListExpandPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(152213);
    this.YcO = -1;
    iLu();
    setLayoutResource(a.d.mm_preference_contact_list_row);
    AppMethodBeat.o(152213);
  }
  
  private void iLu()
  {
    AppMethodBeat.i(152214);
    this.YcO = 0;
    this.YcP = new q(this.mContext);
    AppMethodBeat.o(152214);
  }
  
  public final void JI(boolean paramBoolean)
  {
    AppMethodBeat.i(245351);
    if (this.YcP != null) {
      this.YcP.JI(paramBoolean);
    }
    if (this.YcQ != null) {
      this.YcQ.Ycd = paramBoolean;
    }
    AppMethodBeat.o(245351);
  }
  
  public final ContactListExpandPreference JJ(boolean paramBoolean)
  {
    if (this.YcP != null) {
      this.YcP.Yce.Ycy = paramBoolean;
    }
    return this;
  }
  
  public final ContactListExpandPreference JK(boolean paramBoolean)
  {
    if (this.YcP != null) {
      this.YcP.Yce.Ycx = paramBoolean;
    }
    return this;
  }
  
  public final void a(a parama)
  {
    if (this.YcP != null) {
      this.YcP.Sco = parama;
    }
  }
  
  public final void a(s.b paramb)
  {
    if (this.YcP != null) {
      this.YcP.Ycf = paramb;
    }
  }
  
  public final void a(e parame)
  {
    if (this.YcP != null) {
      this.YcP.Yce.Ycw = parame;
    }
  }
  
  public final void a(f paramf, String paramString)
  {
    AppMethodBeat.i(152216);
    if (this.YcP != null) {
      this.YcP.a(paramf, paramString);
    }
    AppMethodBeat.o(152216);
  }
  
  public final boolean awr(int paramInt)
  {
    AppMethodBeat.i(152220);
    if (this.YcP != null)
    {
      boolean bool = this.YcP.Yce.awr(paramInt);
      AppMethodBeat.o(152220);
      return bool;
    }
    AppMethodBeat.o(152220);
    return true;
  }
  
  public final boolean awt(int paramInt)
  {
    AppMethodBeat.i(152221);
    if (this.YcP != null)
    {
      boolean bool = this.YcP.Yce.awt(paramInt);
      AppMethodBeat.o(152221);
      return bool;
    }
    AppMethodBeat.o(152221);
    return false;
  }
  
  public final String awu(int paramInt)
  {
    AppMethodBeat.i(152223);
    if ((this.YcP != null) && (this.YcP.Yce.awt(paramInt)))
    {
      String str = ((au)this.YcP.Yce.getItem(paramInt)).field_username;
      AppMethodBeat.o(152223);
      return str;
    }
    AppMethodBeat.o(152223);
    return "";
  }
  
  public final String awv(int paramInt)
  {
    AppMethodBeat.i(152224);
    if ((this.YcP != null) && (this.YcP.Yce.awt(paramInt)))
    {
      String str = ((au)this.YcP.Yce.getItem(paramInt)).field_nickname;
      AppMethodBeat.o(152224);
      return str;
    }
    AppMethodBeat.o(152224);
    return "";
  }
  
  public final String aww(int paramInt)
  {
    AppMethodBeat.i(152225);
    if ((this.YcP != null) && (this.YcP.Yce.awt(paramInt)))
    {
      String str = ((au)this.YcP.Yce.getItem(paramInt)).field_conRemark;
      AppMethodBeat.o(152225);
      return str;
    }
    AppMethodBeat.o(152225);
    return "";
  }
  
  public final void bDL()
  {
    AppMethodBeat.i(152228);
    if (this.YcP != null) {
      this.YcP.Yce.aNi();
    }
    AppMethodBeat.o(152228);
  }
  
  public final void bW(ArrayList<au> paramArrayList)
  {
    AppMethodBeat.i(152219);
    if (this.YcP != null) {
      this.YcP.bW(paramArrayList);
    }
    AppMethodBeat.o(152219);
  }
  
  public final void brd(String paramString)
  {
    if (this.YcP != null) {
      this.YcP.Yce.YcD = paramString;
    }
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(152222);
    if ((this.YcP != null) && (this.YcP.Yce.awt(paramInt)))
    {
      Object localObject = this.YcP.Yce.getItem(paramInt);
      AppMethodBeat.o(152222);
      return localObject;
    }
    AppMethodBeat.o(152222);
    return null;
  }
  
  public final void iLp()
  {
    AppMethodBeat.i(152227);
    if (this.YcP != null) {
      this.YcP.iLp();
    }
    AppMethodBeat.o(152227);
  }
  
  public final void iLt()
  {
    AppMethodBeat.i(152226);
    if (this.YcP != null) {
      this.YcP.Yce.iLt();
    }
    AppMethodBeat.o(152226);
  }
  
  public final void iLv()
  {
    if (this.YcP != null) {
      this.YcP.Yce.YcH = false;
    }
  }
  
  public final ContactListExpandPreference iLw()
  {
    if (this.YcP != null) {
      this.YcP.Yce.Ycz = false;
    }
    return this;
  }
  
  public final void iM(List<String> paramList)
  {
    AppMethodBeat.i(152229);
    if (this.YcP != null) {
      this.YcP.Yce.iM(paramList);
    }
    AppMethodBeat.o(152229);
  }
  
  public final void notifyChanged()
  {
    AppMethodBeat.i(152217);
    if (this.YcP != null) {
      this.YcP.cPy();
    }
    AppMethodBeat.o(152217);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(152215);
    ViewGroup localViewGroup;
    if (this.YcO == 1)
    {
      s locals = this.YcQ;
      locals.rootView = paramView;
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
        if (((locals.Yce.Ycv % r.Yco != r.Yco - 1) && (locals.Yce.Ycv % r.Yco != 0)) || (!locals.lAh) || (locals.row != locals.Yce.getCount() / r.Yco - 1)) {
          break label601;
        }
        localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getPaddingTop(), localViewGroup.getPaddingRight(), 0);
        if (locals.Yce == null) {
          break label752;
        }
        localViewGroup.setOnClickListener(locals.dpY);
        if (localViewGroup.getChildCount() > r.Yco)
        {
          localViewGroup.removeViews(0, localViewGroup.getChildCount() - r.Yco);
          localViewGroup.requestLayout();
        }
        i = 0;
        if (i >= locals.YcR) {
          break label719;
        }
        if (localViewGroup.getChildAt(i) != null) {
          break label684;
        }
        localObject = View.inflate(localViewGroup.getContext(), a.d.roominfo_contact, null);
        localViewGroup.addView((View)localObject);
        localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.gravity = 49;
        if (r.Yco != 4) {
          break label695;
        }
        j = localViewGroup.getResources().getDimensionPixelSize(a.a.NormalPadding);
        localLayoutParams.setMargins(j, 0, j, 0);
      }
      for (;;)
      {
        if ((!locals.Yce.iLr()) && (locals.Yce.Ycv == 1))
        {
          j = localViewGroup.getResources().getDimensionPixelSize(a.a.BiggerPadding);
          localLayoutParams.setMargins(j, 0, j, 0);
        }
        ((View)localObject).setLayoutParams(localLayoutParams);
        j = locals.row * locals.YcR + i;
        locals.Yce.getView(j, (View)localObject, localViewGroup);
        if (locals.Ycl != null) {
          ((View)localObject).setOnClickListener(new s.3(locals, localViewGroup, j));
        }
        if (locals.YcS != null) {
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
        if (locals.row == locals.Yce.getCount() / r.Yco - 1)
        {
          localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getPaddingTop(), localViewGroup.getPaddingRight(), localViewGroup.getResources().getDimensionPixelSize(a.a.ListPadding));
          break label86;
        }
        localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getResources().getDimensionPixelSize(a.a.MiddlePadding), localViewGroup.getPaddingRight(), localViewGroup.getResources().getDimensionPixelSize(a.a.MiddlePadding));
        break label86;
        label601:
        if ((locals.lAh) || (locals.Yce.Ycv % r.Yco != 0) || (locals.row != locals.Yce.getCount() / r.Yco - 1)) {
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
      if ((!locals.Yce.iLr()) && (locals.Yce.Ycv <= 1)) {
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
  
  public final void y(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(152218);
    if (this.YcP != null) {
      this.YcP.y(paramString, paramList);
    }
    AppMethodBeat.o(152218);
  }
  
  public static abstract interface a
  {
    public abstract void aMI();
    
    public abstract void e(ViewGroup paramViewGroup, int paramInt);
    
    public abstract void qw(int paramInt);
    
    public abstract void qx(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference
 * JD-Core Version:    0.7.0.1
 */