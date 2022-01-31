package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.t;

public class AccountInfoPreference
  extends Preference
{
  private boolean pyz;
  public String userName;
  public SpannableString wap;
  public String waq;
  private RelativeLayout war;
  private View was;
  private boolean wat;
  private int wau;
  private NoMeasuredTextView wav;
  public View.OnClickListener waw;
  public View.OnClickListener wax;
  private View.OnClickListener way;
  private View.OnClickListener waz;
  
  public AccountInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AccountInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(28016);
    this.pyz = false;
    this.wat = true;
    this.wav = null;
    this.waw = null;
    this.wax = null;
    this.way = null;
    this.waz = new AccountInfoPreference.1(this);
    AppMethodBeat.o(28016);
  }
  
  public final void ae(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(28018);
    ab.d("TEST", "updateAccountStoryStatus %s", new Object[] { Boolean.valueOf(paramBoolean1) });
    this.pyz = paramBoolean1;
    this.wat = paramBoolean2;
    LinearLayout.LayoutParams localLayoutParams;
    if (this.wav != null)
    {
      if (paramBoolean1)
      {
        this.wav.setTextColor(a.l(this.mContext, 2131690711));
        localLayoutParams = (LinearLayout.LayoutParams)this.war.getLayoutParams();
        localLayoutParams.gravity = 8388693;
        this.war.setLayoutParams(localLayoutParams);
        this.war.setGravity(16);
      }
    }
    else if (this.was != null) {
      if ((paramBoolean1) || (!paramBoolean2)) {
        break label215;
      }
    }
    label215:
    for (int i = a.ap(this.mContext, 2131428635);; i = a.ap(this.mContext, 2131428634))
    {
      this.was.setPadding(this.was.getPaddingLeft(), i, this.was.getPaddingRight(), this.was.getPaddingBottom());
      AppMethodBeat.o(28018);
      return;
      this.wav.setTextColor(a.l(this.mContext, 2131690322));
      localLayoutParams = (LinearLayout.LayoutParams)this.war.getLayoutParams();
      localLayoutParams.gravity = 8388693;
      this.war.setGravity(16);
      this.war.setLayoutParams(localLayoutParams);
      break;
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(28017);
    super.onBindView(paramView);
    Object localObject = (ImageView)paramView.findViewById(2131821210);
    if ((this.userName != null) && (localObject != null) && (g.RG())) {
      a.b.c((ImageView)localObject, this.userName);
    }
    ((ImageView)localObject).setOnClickListener(this.waz);
    this.wav = ((NoMeasuredTextView)paramView.findViewById(2131821854));
    if ((this.userName != null) && (this.wav != null))
    {
      this.wav.setShouldEllipsize(true);
      this.wav.setTextSize(0, a.ao(this.mContext, 2131427759));
      if (!this.pyz) {
        break label404;
      }
      this.wav.setTextColor(a.l(this.mContext, 2131690711));
      NoMeasuredTextView localNoMeasuredTextView = this.wav;
      if (this.wap != null) {
        break label423;
      }
      localObject = this.userName;
      label148:
      localNoMeasuredTextView.setText((CharSequence)localObject);
      if (this.wav.getPaint() != null) {
        this.wav.getPaint().setFakeBoldText(true);
      }
    }
    localObject = (TextView)paramView.findViewById(2131826331);
    if ((this.waq != null) && (localObject != null))
    {
      ((TextView)localObject).setText(paramView.getResources().getString(2131296536, new Object[] { this.waq }));
      label220:
      ((TextView)localObject).setOnClickListener(this.waz);
      localObject = (TextView)paramView.findViewById(2131822414);
      if (localObject != null)
      {
        if (this.wau <= 99) {
          break label444;
        }
        ((TextView)localObject).setText(this.mContext.getString(2131304225));
        ((TextView)localObject).setBackgroundResource(t.iF(this.mContext));
        ((TextView)localObject).setVisibility(0);
      }
      label280:
      this.war = ((RelativeLayout)paramView.findViewById(2131826334));
      this.war.setOnClickListener(this.waz);
      this.was = paramView.findViewById(2131823111);
      if (this.was != null) {
        if ((this.pyz) || (!this.wat)) {
          break label489;
        }
      }
    }
    label404:
    label423:
    label444:
    label489:
    for (int i = a.ap(this.mContext, 2131428635);; i = a.ap(this.mContext, 2131428634))
    {
      this.was.setPadding(this.was.getPaddingLeft(), i, this.was.getPaddingRight(), this.was.getPaddingBottom());
      this.was.setOnClickListener(this.wax);
      ae(this.pyz, this.wat);
      AppMethodBeat.o(28017);
      return;
      this.wav.setTextColor(a.l(this.mContext, 2131690322));
      break;
      localObject = this.wap;
      break label148;
      if (localObject == null) {
        break label220;
      }
      ((TextView)localObject).setVisibility(8);
      break label220;
      if (this.wau > 0)
      {
        ((TextView)localObject).setText(this.wau);
        ((TextView)localObject).setVisibility(0);
        break label280;
      }
      ((TextView)localObject).setVisibility(8);
      break label280;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.AccountInfoPreference
 * JD-Core Version:    0.7.0.1
 */