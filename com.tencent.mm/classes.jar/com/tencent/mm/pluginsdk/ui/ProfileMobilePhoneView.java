package com.tencent.mm.pluginsdk.ui;

import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;

public class ProfileMobilePhoneView
  extends ProfileItemView
{
  public String FlQ;
  public String FlR;
  public String[] FlS;
  public LinearLayout Fmb;
  public boolean Fmc = false;
  public TextView lHk;
  private Context mContext;
  private View.OnClickListener wme;
  
  public ProfileMobilePhoneView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ProfileMobilePhoneView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
  }
  
  public ProfileMobilePhoneView(Context paramContext, View.OnClickListener paramOnClickListener)
  {
    super(paramContext, null);
    this.wme = paramOnClickListener;
    this.mContext = paramContext;
  }
  
  public final boolean ah(an paraman)
  {
    this.pSY = paraman;
    return true;
  }
  
  public final boolean dEA()
  {
    AppMethodBeat.i(31242);
    Object localObject;
    if (this.lHk != null)
    {
      localObject = this.lHk.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = com.tencent.mm.cb.a.ax(getContext(), 2131165370);
      this.lHk.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (this.Fmb == null)
    {
      AppMethodBeat.o(31242);
      return false;
    }
    int k;
    if ((!bu.isNullOrNil(this.FlQ)) && (bu.aSK(this.FlQ).booleanValue()))
    {
      localObject = this.Fmb.getChildAt(0);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        ((TextView)localObject).setText(this.FlQ);
      }
      k = 1;
    }
    int j;
    for (int i = 1;; i = 0)
    {
      j = i;
      if (bu.isNullOrNil(this.FlR)) {
        break;
      }
      this.FlS = com.tencent.mm.contact.a.a(this.pSY, this.FlR);
      j = i;
      if (this.FlS == null) {
        break;
      }
      setVisibility(0);
      while (i < this.FlS.length + k)
      {
        localObject = this.Fmb.getChildAt(i);
        if (localObject != null)
        {
          ((View)localObject).setVisibility(0);
          ((TextView)localObject).setText(this.FlS[(i - k)]);
        }
        i += 1;
      }
      if ((this.FlQ != null) && (!bu.aSK(this.FlQ).booleanValue())) {
        ae.e("MicroMsg.ProfileMobilePhoneView", "mobile format is error----%s", new Object[] { this.FlQ });
      }
      k = 0;
    }
    for (;;)
    {
      if (j < 5)
      {
        this.Fmb.getChildAt(j).setVisibility(8);
        j += 1;
      }
      else
      {
        if ((k != 1) && (bu.isNullOrNil(this.FlR))) {
          setVisibility(8);
        }
        AppMethodBeat.o(31242);
        return false;
        j = i;
      }
    }
  }
  
  public int getLayout()
  {
    return 2131495139;
  }
  
  public final void init()
  {
    AppMethodBeat.i(31240);
    this.lHk = ((TextView)findViewById(2131303213));
    this.Fmb = ((LinearLayout)findViewById(2131303212));
    int i = 0;
    while (i < 5)
    {
      this.Fmb.getChildAt(i).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31234);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/ProfileMobilePhoneView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ProfileMobilePhoneView.a(ProfileMobilePhoneView.this, ((TextView)paramAnonymousView).getText().toString());
          ProfileMobilePhoneView.a(ProfileMobilePhoneView.this).onClick(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/ProfileMobilePhoneView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(31234);
        }
      });
      i += 1;
    }
    AppMethodBeat.o(31240);
  }
  
  public final void lA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(31241);
    ae.i("MicroMsg.ProfileMobilePhoneView", "phoneNumberByMD5:%s phoneNumberList:%s", new Object[] { paramString1, paramString2 });
    this.FlQ = paramString1;
    this.FlR = paramString2;
    dEA();
    AppMethodBeat.o(31241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView
 * JD-Core Version:    0.7.0.1
 */