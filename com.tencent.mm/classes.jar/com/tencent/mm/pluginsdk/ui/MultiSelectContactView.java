package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.selectcontact.a.a;
import com.tencent.mm.plugin.selectcontact.a.c;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MultiSelectContactView
  extends LinearLayout
{
  private LayoutInflater fhz;
  private View khn;
  private int padding = 0;
  private HorizontalScrollView sak;
  private LinearLayout sal;
  private View sam;
  public MMEditText san;
  private List<String> sao;
  private Animation sap;
  private int saq = 0;
  private MultiSelectContactView.a sar;
  private MultiSelectContactView.b sas;
  private MultiSelectContactView.c sat;
  private List<View> sau;
  boolean sav = false;
  
  public MultiSelectContactView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.fhz = LayoutInflater.from(paramContext);
    this.fhz.inflate(a.f.muti_select_contact_view, this, true);
    this.sak = ((HorizontalScrollView)findViewById(a.e.mutiselectcontact_scroll));
    this.san = ((MMEditText)findViewById(a.e.mutiselectcontact_edittext));
    this.sal = ((LinearLayout)findViewById(a.e.mutiselectcontact_avatar_ll));
    this.sam = findViewById(a.e.mutiselectcontact_searchicon);
    this.sao = new LinkedList();
    this.sap = AnimationUtils.loadAnimation(paramContext, a.a.fast_faded_in);
    c.d(this.san).Ig(100).a(null);
    this.khn = findViewById(a.e.root);
    this.san.addTextChangedListener(new MultiSelectContactView.1(this));
    this.san.setOnKeyListener(new MultiSelectContactView.2(this));
    this.sau = new ArrayList();
    this.san.clearFocus();
    this.san.setOnFocusChangeListener(new MultiSelectContactView.3(this));
    setBackgroundColor(-201326593);
    setOnClickListener(new MultiSelectContactView.4(this));
  }
  
  private void DV(int paramInt)
  {
    if (this.saq <= 0)
    {
      this.saq += getResources().getDimensionPixelSize(a.c.LargerPadding);
      i = BackwardSupportUtil.b.b(getContext(), 40.0F);
      int j = (int)this.san.getPaint().measureText(getContext().getString(a.h.app_search));
      int k = this.saq;
      this.saq = (Math.max(i, j) + k);
    }
    if (this.saq <= 0) {
      return;
    }
    int i = this.khn.getWidth();
    paramInt *= (getResources().getDimensionPixelSize(a.c.ContactAvatarSize) + getResources().getDimensionPixelSize(a.c.BasicPaddingSize));
    y.v("MicroMsg.MultiSeclectContactView", "parentWidth:%d, avatarWidth:%d, minInputAreaWidth:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(this.saq) });
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.sak.getLayoutParams();
    if (i - paramInt > this.saq)
    {
      localLayoutParams.width = -2;
      return;
    }
    localLayoutParams.width = (i - this.saq);
  }
  
  private View Wx(String paramString)
  {
    int j = this.sal.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.sal.getChildAt(i);
      if (paramString.equals(localView.getTag())) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  private void a(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (this.sar != null)) {
      this.sar.pw(paramView.getTag().toString());
    }
    if (paramBoolean2)
    {
      Animation localAnimation = AnimationUtils.loadAnimation(getContext(), a.a.fast_faded_out);
      localAnimation.setAnimationListener(new MultiSelectContactView.6(this, paramView));
      paramView.startAnimation(localAnimation);
      return;
    }
    this.sal.removeView(paramView);
    cms();
    DV(this.sal.getChildCount());
  }
  
  private void cmq()
  {
    if (this.sal.getChildCount() == 0) {}
    while (!this.sav) {
      return;
    }
    View localView = this.sal.getChildAt(this.sal.getChildCount() - 1);
    this.sav = false;
    localView.findViewById(a.e.mask).setVisibility(8);
  }
  
  private void cmr()
  {
    this.sal.post(new MultiSelectContactView.7(this));
  }
  
  private void cms()
  {
    if (this.sal.getChildCount() == 0)
    {
      this.sam.setVisibility(0);
      return;
    }
    this.sam.setVisibility(8);
  }
  
  public final void Wv(String paramString)
  {
    if (bk.bl(paramString)) {
      return;
    }
    if (this.sao.contains(paramString))
    {
      y.i("MicroMsg.MultiSeclectContactView", "fixed user cant change");
      return;
    }
    cmq();
    View localView = Wx(paramString);
    if (localView != null)
    {
      a(localView, false, false);
      return;
    }
    bz(paramString, true);
  }
  
  public final void Ww(String paramString)
  {
    paramString = Wx(paramString);
    if (paramString != null) {
      a(paramString, false, false);
    }
  }
  
  public final void bz(String paramString, boolean paramBoolean)
  {
    DV(this.sal.getChildCount() + 1);
    View localView = this.fhz.inflate(a.f.select_contact_avatar, null, true);
    ImageView localImageView = (ImageView)localView.findViewById(a.e.avatar);
    a.b.a(localImageView, paramString);
    localImageView.setContentDescription(((b)g.r(b.class)).gV(paramString));
    localView.setTag(paramString);
    localView.setOnClickListener(new MultiSelectContactView.5(this));
    if (paramBoolean) {
      localView.startAnimation(this.sap);
    }
    this.sal.addView(localView);
    cms();
    paramString = (LinearLayout.LayoutParams)localView.getLayoutParams();
    paramString.height = getResources().getDimensionPixelSize(a.c.ContactAvatarSize);
    paramString.width = getResources().getDimensionPixelSize(a.c.ContactAvatarSize);
    paramString.rightMargin = getResources().getDimensionPixelSize(a.c.BasicPaddingSize);
    localView.setLayoutParams(paramString);
    cmr();
  }
  
  public void clearFocus()
  {
    this.san.clearFocus();
    cmq();
  }
  
  public EditText getInputText()
  {
    return this.san;
  }
  
  public String getSearchContent()
  {
    return this.san.getText().toString();
  }
  
  public int getSelectedCount()
  {
    return this.sal.getChildCount();
  }
  
  public void setFixedUserList(List<String> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.sao.addAll(paramList);
  }
  
  public void setOnContactDeselectListener(MultiSelectContactView.a parama)
  {
    this.sar = parama;
  }
  
  public void setOnSearchTextChangeListener(MultiSelectContactView.b paramb)
  {
    this.sas = paramb;
  }
  
  public void setOnSearchTextFouceChangeListener(MultiSelectContactView.c paramc)
  {
    this.sat = paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.MultiSelectContactView
 * JD-Core Version:    0.7.0.1
 */