package com.tencent.mm.ui.widget.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.text.SpannableString;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import com.tencent.mm.ci.a.c;
import com.tencent.mm.ci.a.f;
import com.tencent.mm.ci.a.g;
import com.tencent.mm.ci.a.i;
import com.tencent.mm.ui.AlertActivity;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.e.c.b;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public final class e$a
{
  public c few;
  public Context mContext;
  public final c.a scn;
  private LinearLayout wnA;
  public e.e wnB;
  int[] wnC;
  public String wnv = null;
  public String wnw = null;
  public boolean wnx = false;
  public boolean wny = false;
  public RadioGroup wnz;
  
  public e$a(Context paramContext)
  {
    this.mContext = paramContext;
    this.scn = new c.a(this.mContext);
    this.scn.nW(false);
    this.scn.nX(false);
    this.scn.a(new e.a.1(this));
  }
  
  public final a Iu(int paramInt)
  {
    this.wnv = this.mContext.getResources().getString(paramInt);
    return this;
  }
  
  public final a Iv(int paramInt)
  {
    this.scn.wmT.wmp = paramInt;
    return this;
  }
  
  public final a a(e.b paramb)
  {
    if (this.wnz != null) {
      this.wnz.setTag(this.few);
    }
    if ((this.wnv == null) || ((this.wnv != null) && (this.wnv.length() == 0))) {
      this.wnv = this.mContext.getResources().getString(a.i.button_ok);
    }
    this.scn.aeD(this.wnv);
    this.scn.a(new e.a.7(this, paramb));
    if ((this.wnw == null) || ((this.wnw != null) && (this.wnw.length() == 0))) {
      this.wnw = this.mContext.getResources().getString(a.i.button_cancel);
    }
    this.scn.aeE(this.wnw);
    if (!this.wny) {
      this.scn.b(new e.a.8(this, paramb));
    }
    return this;
  }
  
  public final a a(e.c paramc)
  {
    if ((this.wnv == null) || ((this.wnv != null) && (this.wnv.length() == 0))) {
      this.wnv = this.mContext.getResources().getString(a.i.button_ok);
    }
    if ((this.wnw == null) || ((this.wnw != null) && (this.wnw.length() == 0))) {
      this.wnw = this.mContext.getResources().getString(a.i.button_cancel);
    }
    this.scn.aeE(this.wnw);
    this.scn.aeD(this.wnv);
    this.scn.a(new e.a.5(this, paramc));
    if (!this.wny) {
      this.scn.b(new e.a.6(this, paramc));
    }
    return this;
  }
  
  public final a a(e.d paramd)
  {
    if ((this.wnw == null) || ((this.wnw != null) && (this.wnw.length() == 0))) {
      this.wnw = this.mContext.getResources().getString(a.i.button_cancel);
    }
    this.scn.aeE(this.wnw);
    if (!this.wny) {
      this.scn.b(new e.a.3(this, paramd));
    }
    return this;
  }
  
  public final a a(e.d paramd1, e.d paramd2)
  {
    if (this.wnz != null) {
      this.wnz.setTag(this.few);
    }
    a(paramd1);
    b(paramd2);
    if (this.wnx)
    {
      paramd1 = this.scn;
      int i = this.mContext.getResources().getColor(a.c.green_text_color);
      paramd1.wmT.wmo = i;
    }
    return this;
  }
  
  public final a aeF(String paramString)
  {
    int i = ap.fromDPToPix(this.mContext, (int)(20.0F * ap.cJ(this.mContext)));
    if ((paramString != null) && (paramString.length() > 0))
    {
      SpannableString localSpannableString = (SpannableString)b.c(paramString.toString(), i);
      this.scn.S(localSpannableString);
    }
    this.scn.aez(paramString);
    return this;
  }
  
  public final a aeG(String paramString)
  {
    this.scn.aeA(paramString);
    return this;
  }
  
  public final a aeH(String paramString)
  {
    this.scn.aeC(paramString);
    return this;
  }
  
  public final a b(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.scn.a(paramOnDismissListener);
    return this;
  }
  
  public final a b(e.d paramd)
  {
    if ((this.wnv == null) || ((this.wnv != null) && (this.wnv.length() == 0))) {
      this.wnv = this.mContext.getResources().getString(a.i.button_ok);
    }
    this.scn.aeD(this.wnv);
    this.scn.a(new e.a.4(this, paramd));
    return this;
  }
  
  public final a b(LinkedHashMap<String, Integer> paramLinkedHashMap)
  {
    View localView = View.inflate(this.mContext, a.g.dialog_checkbox_view, null);
    this.wnA = ((LinearLayout)localView.findViewById(a.f.checkbox_group));
    this.wnC = new int[paramLinkedHashMap.size()];
    paramLinkedHashMap = paramLinkedHashMap.entrySet().iterator();
    int i = 0;
    if (paramLinkedHashMap.hasNext())
    {
      Object localObject = (Map.Entry)paramLinkedHashMap.next();
      int j = ((Integer)((Map.Entry)localObject).getValue()).intValue();
      localObject = (String)((Map.Entry)localObject).getKey();
      this.wnC[i] = j;
      LinearLayout localLinearLayout = (LinearLayout)View.inflate(this.mContext, a.g.dialog_checkbox_item, null);
      CheckBox localCheckBox = (CheckBox)localLinearLayout.findViewById(a.f.checkbox_item);
      localCheckBox.setText((CharSequence)localObject);
      localCheckBox.setTag(Integer.valueOf(i));
      localCheckBox.setOnClickListener(new e.a.2(this, localCheckBox, i));
      if (j == 2)
      {
        localCheckBox.setChecked(true);
        localCheckBox.setEnabled(false);
      }
      for (;;)
      {
        this.wnA.addView(localLinearLayout);
        i += 1;
        break;
        if (j == 1) {
          localCheckBox.setChecked(true);
        } else {
          localCheckBox.setChecked(false);
        }
      }
    }
    this.scn.ei(localView);
    return this;
  }
  
  public final a c(e.d paramd)
  {
    if (this.wnz != null) {
      this.wnz.setTag(this.few);
    }
    b(paramd);
    a(paramd);
    return this;
  }
  
  public final a ek(View paramView)
  {
    this.scn.ei(paramView);
    return this;
  }
  
  public final a l(Boolean paramBoolean)
  {
    this.scn.nV(paramBoolean.booleanValue());
    return this;
  }
  
  public final a nY(boolean paramBoolean)
  {
    this.scn.nW(paramBoolean);
    this.scn.nX(paramBoolean);
    return this;
  }
  
  public final void show()
  {
    if ((this.mContext instanceof Activity))
    {
      if (this.few == null) {
        this.few = this.scn.aoP();
      }
      this.few.show();
      return;
    }
    AlertActivity.a(this.scn);
    Intent localIntent = new Intent(this.mContext, AlertActivity.class);
    localIntent.setFlags(335544320);
    this.mContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.e.a
 * JD-Core Version:    0.7.0.1
 */