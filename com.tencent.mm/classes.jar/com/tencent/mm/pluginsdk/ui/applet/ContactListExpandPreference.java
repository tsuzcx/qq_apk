package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.List;

public class ContactListExpandPreference
  extends Preference
{
  private int BZq;
  public q BZr;
  public s BZs;
  
  public ContactListExpandPreference(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(152211);
    this.BZq = -1;
    if (paramInt == 0) {
      eyp();
    }
    for (;;)
    {
      setLayoutResource(2131494818);
      AppMethodBeat.o(152211);
      return;
      if (paramInt == 1)
      {
        this.BZq = 1;
        this.BZs = new s();
      }
    }
  }
  
  public ContactListExpandPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(152212);
    this.BZq = -1;
    eyp();
    setLayoutResource(2131494818);
    AppMethodBeat.o(152212);
  }
  
  public ContactListExpandPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(152213);
    this.BZq = -1;
    eyp();
    setLayoutResource(2131494818);
    AppMethodBeat.o(152213);
  }
  
  private void eyp()
  {
    AppMethodBeat.i(152214);
    this.BZq = 0;
    this.BZr = new q(this.mContext);
    AppMethodBeat.o(152214);
  }
  
  public final void B(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(152218);
    if (this.BZr != null) {
      this.BZr.B(paramString, paramList);
    }
    AppMethodBeat.o(152218);
  }
  
  public final boolean UP(int paramInt)
  {
    AppMethodBeat.i(152220);
    if (this.BZr != null)
    {
      boolean bool = this.BZr.BYH.UP(paramInt);
      AppMethodBeat.o(152220);
      return bool;
    }
    AppMethodBeat.o(152220);
    return true;
  }
  
  public final boolean UR(int paramInt)
  {
    AppMethodBeat.i(152221);
    if (this.BZr != null)
    {
      boolean bool = this.BZr.BYH.UR(paramInt);
      AppMethodBeat.o(152221);
      return bool;
    }
    AppMethodBeat.o(152221);
    return false;
  }
  
  public final String US(int paramInt)
  {
    AppMethodBeat.i(152223);
    if ((this.BZr != null) && (this.BZr.BYH.UR(paramInt)))
    {
      String str = ((af)this.BZr.BYH.getItem(paramInt)).field_username;
      AppMethodBeat.o(152223);
      return str;
    }
    AppMethodBeat.o(152223);
    return "";
  }
  
  public final String UT(int paramInt)
  {
    AppMethodBeat.i(152224);
    if ((this.BZr != null) && (this.BZr.BYH.UR(paramInt)))
    {
      String str = ((af)this.BZr.BYH.getItem(paramInt)).field_nickname;
      AppMethodBeat.o(152224);
      return str;
    }
    AppMethodBeat.o(152224);
    return "";
  }
  
  public final String UU(int paramInt)
  {
    AppMethodBeat.i(152225);
    if ((this.BZr != null) && (this.BZr.BYH.UR(paramInt)))
    {
      String str = ((af)this.BZr.BYH.getItem(paramInt)).field_conRemark;
      AppMethodBeat.o(152225);
      return str;
    }
    AppMethodBeat.o(152225);
    return "";
  }
  
  public final void a(a parama)
  {
    if (this.BZr != null) {
      this.BZr.ycu = parama;
    }
  }
  
  public final void a(s.b paramb)
  {
    if (this.BZr != null) {
      this.BZr.BYI = paramb;
    }
  }
  
  public final void a(d paramd)
  {
    if (this.BZr != null) {
      this.BZr.BYH.BYY = paramd;
    }
  }
  
  public final void a(f paramf, String paramString)
  {
    AppMethodBeat.i(152216);
    if (this.BZr != null) {
      this.BZr.a(paramf, paramString);
    }
    AppMethodBeat.o(152216);
  }
  
  public final void aCa(String paramString)
  {
    if (this.BZr != null) {
      this.BZr.BYH.BZf = paramString;
    }
  }
  
  public final void aE(ArrayList<af> paramArrayList)
  {
    AppMethodBeat.i(152219);
    if (this.BZr != null) {
      this.BZr.aE(paramArrayList);
    }
    AppMethodBeat.o(152219);
  }
  
  public final void dX(List<String> paramList)
  {
    AppMethodBeat.i(152229);
    if (this.BZr != null) {
      this.BZr.BYH.dX(paramList);
    }
    AppMethodBeat.o(152229);
  }
  
  public final void eyk()
  {
    AppMethodBeat.i(152227);
    if (this.BZr != null) {
      this.BZr.eyk();
    }
    AppMethodBeat.o(152227);
  }
  
  public final void eyo()
  {
    AppMethodBeat.i(152226);
    if (this.BZr != null) {
      this.BZr.BYH.eyo();
    }
    AppMethodBeat.o(152226);
  }
  
  public final void eyq()
  {
    if (this.BZr != null) {
      this.BZr.BYH.BZj = false;
    }
  }
  
  public final ContactListExpandPreference eyr()
  {
    if (this.BZr != null) {
      this.BZr.BYH.BZb = false;
    }
    return this;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(152222);
    if ((this.BZr != null) && (this.BZr.BYH.UR(paramInt)))
    {
      Object localObject = this.BZr.BYH.getItem(paramInt);
      AppMethodBeat.o(152222);
      return localObject;
    }
    AppMethodBeat.o(152222);
    return null;
  }
  
  public final void jd(List<String> paramList)
  {
    AppMethodBeat.i(203577);
    B(null, paramList);
    AppMethodBeat.o(203577);
  }
  
  public final void notifyChanged()
  {
    AppMethodBeat.i(152217);
    if (this.BZr != null) {
      this.BZr.bsd();
    }
    AppMethodBeat.o(152217);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(152215);
    ViewGroup localViewGroup;
    if (this.BZq == 1)
    {
      s locals = this.BZs;
      label77:
      int i;
      label163:
      label214:
      View localView;
      label253:
      LinearLayout.LayoutParams localLayoutParams;
      int j;
      if (paramView.getId() == 2131298675)
      {
        localViewGroup = (ViewGroup)paramView;
        if (locals.row != 0) {
          break label451;
        }
        localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getResources().getDimensionPixelSize(2131165489), localViewGroup.getPaddingRight(), localViewGroup.getResources().getDimensionPixelSize(2131165500));
        if (((locals.BYH.BYX % r.BYQ != r.BYQ - 1) && (locals.BYH.BYX % r.BYQ != 0)) || (!locals.fqg) || (locals.row != locals.BYH.getCount() / r.BYQ - 1)) {
          break label544;
        }
        localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getPaddingTop(), localViewGroup.getPaddingRight(), 0);
        if (locals.BYH == null) {
          break label694;
        }
        localViewGroup.setOnClickListener(locals.hs);
        if (localViewGroup.getChildCount() > r.BYQ)
        {
          localViewGroup.removeViews(0, localViewGroup.getChildCount() - r.BYQ);
          localViewGroup.requestLayout();
        }
        i = 0;
        if (i >= locals.BZt) {
          break label661;
        }
        if (localViewGroup.getChildAt(i) != null) {
          break label627;
        }
        localView = View.inflate(localViewGroup.getContext(), 2131495276, null);
        localViewGroup.addView(localView);
        localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.gravity = 49;
        if (r.BYQ != 4) {
          break label638;
        }
        j = localViewGroup.getResources().getDimensionPixelSize(2131165516);
        localLayoutParams.setMargins(j, 0, j, 0);
      }
      for (;;)
      {
        if ((!locals.BYH.eym()) && (locals.BYH.BYX == 1))
        {
          j = localViewGroup.getResources().getDimensionPixelSize(2131165198);
          localLayoutParams.setMargins(j, 0, j, 0);
        }
        localView.setLayoutParams(localLayoutParams);
        j = locals.row * locals.BZt + i;
        locals.BYH.getView(j, localView, localViewGroup);
        if (locals.BYN != null) {
          localView.setOnClickListener(new s.3(locals, localViewGroup, j));
        }
        if (locals.BZu != null) {
          localView.setOnLongClickListener(new s.4(locals, localViewGroup, j));
        }
        i += 1;
        break label214;
        localViewGroup = (ViewGroup)paramView.findViewById(2131298675);
        break;
        label451:
        if (locals.row == locals.BYH.getCount() / r.BYQ - 1)
        {
          localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getPaddingTop(), localViewGroup.getPaddingRight(), localViewGroup.getResources().getDimensionPixelSize(2131165489));
          break label77;
        }
        localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getResources().getDimensionPixelSize(2131165500), localViewGroup.getPaddingRight(), localViewGroup.getResources().getDimensionPixelSize(2131165500));
        break label77;
        label544:
        if ((locals.fqg) || (locals.BYH.BYX % r.BYQ != 0) || (locals.row != locals.BYH.getCount() / r.BYQ - 1)) {
          break label163;
        }
        localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getPaddingTop(), localViewGroup.getPaddingRight(), (int)localViewGroup.getContext().getResources().getDimension(2131165568));
        break label163;
        label627:
        localView = localViewGroup.getChildAt(i);
        break label253;
        label638:
        j = localViewGroup.getResources().getDimensionPixelSize(2131165500);
        localLayoutParams.setMargins(j, 0, j, 0);
      }
      label661:
      if ((!locals.BYH.eym()) && (locals.BYH.BYX <= 1)) {
        break label705;
      }
      ((LinearLayout)localViewGroup).setGravity(17);
    }
    for (;;)
    {
      label694:
      super.onBindView(paramView);
      AppMethodBeat.o(152215);
      return;
      label705:
      ((LinearLayout)localViewGroup).setGravity(19);
    }
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(152228);
    if (this.BZr != null) {
      this.BZr.BYH.VL();
    }
    AppMethodBeat.o(152228);
  }
  
  public final ContactListExpandPreference ub(boolean paramBoolean)
  {
    if (this.BZr != null) {
      this.BZr.BYH.BZa = paramBoolean;
    }
    return this;
  }
  
  public final ContactListExpandPreference uc(boolean paramBoolean)
  {
    if (this.BZr != null) {
      this.BZr.BYH.BYZ = paramBoolean;
    }
    return this;
  }
  
  public static abstract interface a
  {
    public abstract void b(ViewGroup paramViewGroup, View paramView, int paramInt);
    
    public abstract void c(ViewGroup paramViewGroup, View paramView, int paramInt);
    
    public abstract void d(ViewGroup paramViewGroup, View paramView);
    
    public abstract void d(ViewGroup paramViewGroup, View paramView, int paramInt);
    
    public abstract void e(ViewGroup paramViewGroup, View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference
 * JD-Core Version:    0.7.0.1
 */