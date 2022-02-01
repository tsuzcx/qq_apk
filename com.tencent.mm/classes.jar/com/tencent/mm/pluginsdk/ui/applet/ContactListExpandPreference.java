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
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.List;

public class ContactListExpandPreference
  extends Preference
{
  private int Fpg;
  public q Fph;
  public s Fpi;
  
  public ContactListExpandPreference(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(152211);
    this.Fpg = -1;
    if (paramInt == 0) {
      fgw();
    }
    for (;;)
    {
      setLayoutResource(2131494818);
      AppMethodBeat.o(152211);
      return;
      if (paramInt == 1)
      {
        this.Fpg = 1;
        this.Fpi = new s();
      }
    }
  }
  
  public ContactListExpandPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(152212);
    this.Fpg = -1;
    fgw();
    setLayoutResource(2131494818);
    AppMethodBeat.o(152212);
  }
  
  public ContactListExpandPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(152213);
    this.Fpg = -1;
    fgw();
    setLayoutResource(2131494818);
    AppMethodBeat.o(152213);
  }
  
  private void fgw()
  {
    AppMethodBeat.i(152214);
    this.Fpg = 0;
    this.Fph = new q(this.mContext);
    AppMethodBeat.o(152214);
  }
  
  public final void B(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(152218);
    if (this.Fph != null) {
      this.Fph.B(paramString, paramList);
    }
    AppMethodBeat.o(152218);
  }
  
  public final boolean ZA(int paramInt)
  {
    AppMethodBeat.i(152220);
    if (this.Fph != null)
    {
      boolean bool = this.Fph.Fox.ZA(paramInt);
      AppMethodBeat.o(152220);
      return bool;
    }
    AppMethodBeat.o(152220);
    return true;
  }
  
  public final boolean ZC(int paramInt)
  {
    AppMethodBeat.i(152221);
    if (this.Fph != null)
    {
      boolean bool = this.Fph.Fox.ZC(paramInt);
      AppMethodBeat.o(152221);
      return bool;
    }
    AppMethodBeat.o(152221);
    return false;
  }
  
  public final String ZD(int paramInt)
  {
    AppMethodBeat.i(152223);
    if ((this.Fph != null) && (this.Fph.Fox.ZC(paramInt)))
    {
      String str = ((an)this.Fph.Fox.getItem(paramInt)).field_username;
      AppMethodBeat.o(152223);
      return str;
    }
    AppMethodBeat.o(152223);
    return "";
  }
  
  public final String ZE(int paramInt)
  {
    AppMethodBeat.i(152224);
    if ((this.Fph != null) && (this.Fph.Fox.ZC(paramInt)))
    {
      String str = ((an)this.Fph.Fox.getItem(paramInt)).field_nickname;
      AppMethodBeat.o(152224);
      return str;
    }
    AppMethodBeat.o(152224);
    return "";
  }
  
  public final String ZF(int paramInt)
  {
    AppMethodBeat.i(152225);
    if ((this.Fph != null) && (this.Fph.Fox.ZC(paramInt)))
    {
      String str = ((an)this.Fph.Fox.getItem(paramInt)).field_conRemark;
      AppMethodBeat.o(152225);
      return str;
    }
    AppMethodBeat.o(152225);
    return "";
  }
  
  public final void a(a parama)
  {
    if (this.Fph != null) {
      this.Fph.AYR = parama;
    }
  }
  
  public final void a(s.b paramb)
  {
    if (this.Fph != null) {
      this.Fph.Foy = paramb;
    }
  }
  
  public final void a(e parame)
  {
    if (this.Fph != null) {
      this.Fph.Fox.FoO = parame;
    }
  }
  
  public final void a(f paramf, String paramString)
  {
    AppMethodBeat.i(152216);
    if (this.Fph != null) {
      this.Fph.a(paramf, paramString);
    }
    AppMethodBeat.o(152216);
  }
  
  public final void aO(ArrayList<an> paramArrayList)
  {
    AppMethodBeat.i(152219);
    if (this.Fph != null) {
      this.Fph.aO(paramArrayList);
    }
    AppMethodBeat.o(152219);
  }
  
  public final void aOr(String paramString)
  {
    if (this.Fph != null) {
      this.Fph.Fox.FoV = paramString;
    }
  }
  
  public final void es(List<String> paramList)
  {
    AppMethodBeat.i(152229);
    if (this.Fph != null) {
      this.Fph.Fox.es(paramList);
    }
    AppMethodBeat.o(152229);
  }
  
  public final void fgr()
  {
    AppMethodBeat.i(152227);
    if (this.Fph != null) {
      this.Fph.fgr();
    }
    AppMethodBeat.o(152227);
  }
  
  public final void fgv()
  {
    AppMethodBeat.i(152226);
    if (this.Fph != null) {
      this.Fph.Fox.fgv();
    }
    AppMethodBeat.o(152226);
  }
  
  public final void fgx()
  {
    if (this.Fph != null) {
      this.Fph.Fox.FoZ = false;
    }
  }
  
  public final ContactListExpandPreference fgy()
  {
    if (this.Fph != null) {
      this.Fph.Fox.FoR = false;
    }
    return this;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(152222);
    if ((this.Fph != null) && (this.Fph.Fox.ZC(paramInt)))
    {
      Object localObject = this.Fph.Fox.getItem(paramInt);
      AppMethodBeat.o(152222);
      return localObject;
    }
    AppMethodBeat.o(152222);
    return null;
  }
  
  public final void notifyChanged()
  {
    AppMethodBeat.i(152217);
    if (this.Fph != null) {
      this.Fph.bDZ();
    }
    AppMethodBeat.o(152217);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(152215);
    ViewGroup localViewGroup;
    if (this.Fpg == 1)
    {
      s locals = this.Fpi;
      locals.kFh = paramView;
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
        if (((locals.Fox.FoN % r.FoG != r.FoG - 1) && (locals.Fox.FoN % r.FoG != 0)) || (!locals.fOU) || (locals.row != locals.Fox.getCount() / r.FoG - 1)) {
          break label594;
        }
        localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getPaddingTop(), localViewGroup.getPaddingRight(), 0);
        if (locals.Fox == null) {
          break label744;
        }
        localViewGroup.setOnClickListener(locals.km);
        if (localViewGroup.getChildCount() > r.FoG)
        {
          localViewGroup.removeViews(0, localViewGroup.getChildCount() - r.FoG);
          localViewGroup.requestLayout();
        }
        i = 0;
        if (i >= locals.Fpj) {
          break label711;
        }
        if (localViewGroup.getChildAt(i) != null) {
          break label677;
        }
        localObject = View.inflate(localViewGroup.getContext(), 2131495276, null);
        localViewGroup.addView((View)localObject);
        localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.gravity = 49;
        if (r.FoG != 4) {
          break label688;
        }
        j = localViewGroup.getResources().getDimensionPixelSize(2131165516);
        localLayoutParams.setMargins(j, 0, j, 0);
      }
      for (;;)
      {
        if ((!locals.Fox.fgt()) && (locals.Fox.FoN == 1))
        {
          j = localViewGroup.getResources().getDimensionPixelSize(2131165198);
          localLayoutParams.setMargins(j, 0, j, 0);
        }
        ((View)localObject).setLayoutParams(localLayoutParams);
        j = locals.row * locals.Fpj + i;
        locals.Fox.getView(j, (View)localObject, localViewGroup);
        if (locals.FoD != null) {
          ((View)localObject).setOnClickListener(new s.3(locals, localViewGroup, j));
        }
        if (locals.Fpk != null) {
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
        if (locals.row == locals.Fox.getCount() / r.FoG - 1)
        {
          localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getPaddingTop(), localViewGroup.getPaddingRight(), localViewGroup.getResources().getDimensionPixelSize(2131165489));
          break label83;
        }
        localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getResources().getDimensionPixelSize(2131165500), localViewGroup.getPaddingRight(), localViewGroup.getResources().getDimensionPixelSize(2131165500));
        break label83;
        label594:
        if ((locals.fOU) || (locals.Fox.FoN % r.FoG != 0) || (locals.row != locals.Fox.getCount() / r.FoG - 1)) {
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
      if ((!locals.Fox.fgt()) && (locals.Fox.FoN <= 1)) {
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
    if (this.Fph != null) {
      this.Fph.Fox.Zm();
    }
    AppMethodBeat.o(152228);
  }
  
  public final void vV(boolean paramBoolean)
  {
    AppMethodBeat.i(217893);
    if (this.Fph != null) {
      this.Fph.vV(paramBoolean);
    }
    if (this.Fpi != null) {
      this.Fpi.Fow = paramBoolean;
    }
    AppMethodBeat.o(217893);
  }
  
  public final ContactListExpandPreference vW(boolean paramBoolean)
  {
    if (this.Fph != null) {
      this.Fph.Fox.FoQ = paramBoolean;
    }
    return this;
  }
  
  public final ContactListExpandPreference vX(boolean paramBoolean)
  {
    if (this.Fph != null) {
      this.Fph.Fox.FoP = paramBoolean;
    }
    return this;
  }
  
  public static abstract interface a
  {
    public abstract void YS();
    
    public abstract void e(ViewGroup paramViewGroup, int paramInt);
    
    public abstract void le(int paramInt);
    
    public abstract void lf(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference
 * JD-Core Version:    0.7.0.1
 */