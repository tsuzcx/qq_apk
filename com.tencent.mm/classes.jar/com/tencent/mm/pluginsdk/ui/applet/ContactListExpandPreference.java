package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.plugin.patmsg.ui.AvatarPatTipImageView;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.List;

public class ContactListExpandPreference
  extends Preference
{
  private int KfX;
  public q KfY;
  public s KfZ;
  
  public ContactListExpandPreference(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(152211);
    this.KfX = -1;
    if (paramInt == 0) {
      gpF();
    }
    for (;;)
    {
      setLayoutResource(2131495552);
      AppMethodBeat.o(152211);
      return;
      if (paramInt == 1)
      {
        this.KfX = 1;
        this.KfZ = new s();
      }
    }
  }
  
  public ContactListExpandPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(152212);
    this.KfX = -1;
    gpF();
    setLayoutResource(2131495552);
    AppMethodBeat.o(152212);
  }
  
  public ContactListExpandPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(152213);
    this.KfX = -1;
    gpF();
    setLayoutResource(2131495552);
    AppMethodBeat.o(152213);
  }
  
  private void gpF()
  {
    AppMethodBeat.i(152214);
    this.KfX = 0;
    this.KfY = new q(this.mContext);
    AppMethodBeat.o(152214);
  }
  
  public final void H(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(152218);
    if (this.KfY != null) {
      this.KfY.H(paramString, paramList);
    }
    AppMethodBeat.o(152218);
  }
  
  public final void a(a parama)
  {
    if (this.KfY != null) {
      this.KfY.FjO = parama;
    }
  }
  
  public final void a(s.b paramb)
  {
    if (this.KfY != null) {
      this.KfY.Kfp = paramb;
    }
  }
  
  public final void a(e parame)
  {
    if (this.KfY != null) {
      this.KfY.Kfo.KfF = parame;
    }
  }
  
  public final void a(f paramf, String paramString)
  {
    AppMethodBeat.i(152216);
    if (this.KfY != null) {
      this.KfY.a(paramf, paramString);
    }
    AppMethodBeat.o(152216);
  }
  
  public final boolean ail(int paramInt)
  {
    AppMethodBeat.i(152220);
    if (this.KfY != null)
    {
      boolean bool = this.KfY.Kfo.ail(paramInt);
      AppMethodBeat.o(152220);
      return bool;
    }
    AppMethodBeat.o(152220);
    return true;
  }
  
  public final boolean ain(int paramInt)
  {
    AppMethodBeat.i(152221);
    if (this.KfY != null)
    {
      boolean bool = this.KfY.Kfo.ain(paramInt);
      AppMethodBeat.o(152221);
      return bool;
    }
    AppMethodBeat.o(152221);
    return false;
  }
  
  public final String aio(int paramInt)
  {
    AppMethodBeat.i(152223);
    if ((this.KfY != null) && (this.KfY.Kfo.ain(paramInt)))
    {
      String str = ((as)this.KfY.Kfo.getItem(paramInt)).field_username;
      AppMethodBeat.o(152223);
      return str;
    }
    AppMethodBeat.o(152223);
    return "";
  }
  
  public final String aip(int paramInt)
  {
    AppMethodBeat.i(152224);
    if ((this.KfY != null) && (this.KfY.Kfo.ain(paramInt)))
    {
      String str = ((as)this.KfY.Kfo.getItem(paramInt)).field_nickname;
      AppMethodBeat.o(152224);
      return str;
    }
    AppMethodBeat.o(152224);
    return "";
  }
  
  public final String aiq(int paramInt)
  {
    AppMethodBeat.i(152225);
    if ((this.KfY != null) && (this.KfY.Kfo.ain(paramInt)))
    {
      String str = ((as)this.KfY.Kfo.getItem(paramInt)).field_conRemark;
      AppMethodBeat.o(152225);
      return str;
    }
    AppMethodBeat.o(152225);
    return "";
  }
  
  public final void beT(String paramString)
  {
    if (this.KfY != null) {
      this.KfY.Kfo.KfM = paramString;
    }
  }
  
  public final void bg(ArrayList<as> paramArrayList)
  {
    AppMethodBeat.i(152219);
    if (this.KfY != null) {
      this.KfY.bg(paramArrayList);
    }
    AppMethodBeat.o(152219);
  }
  
  public final void fm(List<String> paramList)
  {
    AppMethodBeat.i(152229);
    if (this.KfY != null) {
      this.KfY.Kfo.fm(paramList);
    }
    AppMethodBeat.o(152229);
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(152222);
    if ((this.KfY != null) && (this.KfY.Kfo.ain(paramInt)))
    {
      Object localObject = this.KfY.Kfo.getItem(paramInt);
      AppMethodBeat.o(152222);
      return localObject;
    }
    AppMethodBeat.o(152222);
    return null;
  }
  
  public final void gpA()
  {
    AppMethodBeat.i(152227);
    if (this.KfY != null) {
      this.KfY.gpA();
    }
    AppMethodBeat.o(152227);
  }
  
  public final void gpE()
  {
    AppMethodBeat.i(152226);
    if (this.KfY != null) {
      this.KfY.Kfo.gpE();
    }
    AppMethodBeat.o(152226);
  }
  
  public final void gpG()
  {
    if (this.KfY != null) {
      this.KfY.Kfo.KfQ = false;
    }
  }
  
  public final ContactListExpandPreference gpH()
  {
    if (this.KfY != null) {
      this.KfY.Kfo.KfI = false;
    }
    return this;
  }
  
  public final void notifyChanged()
  {
    AppMethodBeat.i(152217);
    if (this.KfY != null) {
      this.KfY.cax();
    }
    AppMethodBeat.o(152217);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(152215);
    ViewGroup localViewGroup;
    if (this.KfX == 1)
    {
      s locals = this.KfZ;
      locals.lJI = paramView;
      label83:
      int i;
      label169:
      label220:
      Object localObject;
      label259:
      LinearLayout.LayoutParams localLayoutParams;
      int j;
      if (paramView.getId() == 2131299112)
      {
        localViewGroup = (ViewGroup)paramView;
        if (locals.row != 0) {
          break label501;
        }
        localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getResources().getDimensionPixelSize(2131165507), localViewGroup.getPaddingRight(), localViewGroup.getResources().getDimensionPixelSize(2131165518));
        if (((locals.Kfo.KfE % r.Kfx != r.Kfx - 1) && (locals.Kfo.KfE % r.Kfx != 0)) || (!locals.gue) || (locals.row != locals.Kfo.getCount() / r.Kfx - 1)) {
          break label594;
        }
        localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getPaddingTop(), localViewGroup.getPaddingRight(), 0);
        if (locals.Kfo == null) {
          break label744;
        }
        localViewGroup.setOnClickListener(locals.ko);
        if (localViewGroup.getChildCount() > r.Kfx)
        {
          localViewGroup.removeViews(0, localViewGroup.getChildCount() - r.Kfx);
          localViewGroup.requestLayout();
        }
        i = 0;
        if (i >= locals.Kga) {
          break label711;
        }
        if (localViewGroup.getChildAt(i) != null) {
          break label677;
        }
        localObject = View.inflate(localViewGroup.getContext(), 2131496126, null);
        localViewGroup.addView((View)localObject);
        localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.gravity = 49;
        if (r.Kfx != 4) {
          break label688;
        }
        j = localViewGroup.getResources().getDimensionPixelSize(2131165534);
        localLayoutParams.setMargins(j, 0, j, 0);
      }
      for (;;)
      {
        if ((!locals.Kfo.gpC()) && (locals.Kfo.KfE == 1))
        {
          j = localViewGroup.getResources().getDimensionPixelSize(2131165201);
          localLayoutParams.setMargins(j, 0, j, 0);
        }
        ((View)localObject).setLayoutParams(localLayoutParams);
        j = locals.row * locals.Kga + i;
        locals.Kfo.getView(j, (View)localObject, localViewGroup);
        if (locals.Kfu != null) {
          ((View)localObject).setOnClickListener(new s.3(locals, localViewGroup, j));
        }
        if (locals.Kgb != null) {
          ((View)localObject).setOnLongClickListener(new s.4(locals, localViewGroup, j));
        }
        localObject = (AvatarPatTipImageView)((View)localObject).findViewById(2131307155);
        ((AvatarPatTipImageView)localObject).setOnDoubleClickListener(new s.5(locals));
        ((AvatarPatTipImageView)localObject).setOnClickListener(new s.6(locals, localViewGroup, j));
        i += 1;
        break label220;
        localViewGroup = (ViewGroup)paramView.findViewById(2131299112);
        break;
        label501:
        if (locals.row == locals.Kfo.getCount() / r.Kfx - 1)
        {
          localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getPaddingTop(), localViewGroup.getPaddingRight(), localViewGroup.getResources().getDimensionPixelSize(2131165507));
          break label83;
        }
        localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getResources().getDimensionPixelSize(2131165518), localViewGroup.getPaddingRight(), localViewGroup.getResources().getDimensionPixelSize(2131165518));
        break label83;
        label594:
        if ((locals.gue) || (locals.Kfo.KfE % r.Kfx != 0) || (locals.row != locals.Kfo.getCount() / r.Kfx - 1)) {
          break label169;
        }
        localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getPaddingTop(), localViewGroup.getPaddingRight(), (int)localViewGroup.getContext().getResources().getDimension(2131165586));
        break label169;
        label677:
        localObject = localViewGroup.getChildAt(i);
        break label259;
        label688:
        j = localViewGroup.getResources().getDimensionPixelSize(2131165518);
        localLayoutParams.setMargins(j, 0, j, 0);
      }
      label711:
      if ((!locals.Kfo.gpC()) && (locals.Kfo.KfE <= 1)) {
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
    if (this.KfY != null) {
      this.KfY.Kfo.amZ();
    }
    AppMethodBeat.o(152228);
  }
  
  public final void zT(boolean paramBoolean)
  {
    AppMethodBeat.i(207174);
    if (this.KfY != null) {
      this.KfY.zT(paramBoolean);
    }
    if (this.KfZ != null) {
      this.KfZ.Kfn = paramBoolean;
    }
    AppMethodBeat.o(207174);
  }
  
  public final ContactListExpandPreference zU(boolean paramBoolean)
  {
    if (this.KfY != null) {
      this.KfY.Kfo.KfH = paramBoolean;
    }
    return this;
  }
  
  public final ContactListExpandPreference zV(boolean paramBoolean)
  {
    if (this.KfY != null) {
      this.KfY.Kfo.KfG = paramBoolean;
    }
    return this;
  }
  
  public static abstract interface a
  {
    public abstract void amF();
    
    public abstract void e(ViewGroup paramViewGroup, int paramInt);
    
    public abstract void og(int paramInt);
    
    public abstract void oh(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference
 * JD-Core Version:    0.7.0.1
 */