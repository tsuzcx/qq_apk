package com.tencent.mm.pluginsdk.ui;

import android.content.ActivityNotFoundException;
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
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;

public class ProfileMobilePhoneView
  extends ProfileItemView
{
  private View.OnClickListener Fms;
  public boolean RdA = false;
  public String Rdn;
  public String Rdo;
  public String[] Rdp;
  public LinearLayout Rdz;
  private Context mContext;
  public TextView pPT;
  
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
    this.Fms = paramOnClickListener;
    this.mContext = paramContext;
  }
  
  public final boolean ap(as paramas)
  {
    this.uNk = paramas;
    return true;
  }
  
  public final boolean fqK()
  {
    AppMethodBeat.i(31242);
    Object localObject;
    if (this.pPT != null)
    {
      localObject = this.pPT.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = com.tencent.mm.ci.a.aY(getContext(), R.f.FixedTitleWidth);
      this.pPT.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (this.Rdz == null)
    {
      AppMethodBeat.o(31242);
      return false;
    }
    int k;
    if ((!Util.isNullOrNil(this.Rdn)) && (Util.isPhoneNumber(this.Rdn).booleanValue()))
    {
      localObject = this.Rdz.getChildAt(0);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        ((TextView)localObject).setText(this.Rdn);
      }
      k = 1;
    }
    int j;
    for (int i = 1;; i = 0)
    {
      j = i;
      if (Util.isNullOrNil(this.Rdo)) {
        break;
      }
      this.Rdp = com.tencent.mm.contact.a.a(this.uNk, this.Rdo);
      j = i;
      if (this.Rdp == null) {
        break;
      }
      setVisibility(0);
      while (i < this.Rdp.length + k)
      {
        localObject = this.Rdz.getChildAt(i);
        if (localObject != null)
        {
          ((View)localObject).setVisibility(0);
          ((TextView)localObject).setText(this.Rdp[(i - k)]);
        }
        i += 1;
      }
      if ((this.Rdn != null) && (!Util.isPhoneNumber(this.Rdn).booleanValue())) {
        Log.e("MicroMsg.ProfileMobilePhoneView", "mobile format is error----%s", new Object[] { this.Rdn });
      }
      k = 0;
    }
    for (;;)
    {
      if (j < 5)
      {
        this.Rdz.getChildAt(j).setVisibility(8);
        j += 1;
      }
      else
      {
        if ((k != 1) && (Util.isNullOrNil(this.Rdo))) {
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
    return R.i.ekd;
  }
  
  public final void init()
  {
    AppMethodBeat.i(31240);
    this.pPT = ((TextView)findViewById(R.h.dQY));
    this.Rdz = ((LinearLayout)findViewById(R.h.dQX));
    int i = 0;
    while (i < 5)
    {
      this.Rdz.getChildAt(i).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31234);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/ProfileMobilePhoneView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
  
  public final void no(String paramString1, String paramString2)
  {
    AppMethodBeat.i(31241);
    Log.i("MicroMsg.ProfileMobilePhoneView", "phoneNumberByMD5:%s phoneNumberList:%s", new Object[] { paramString1, paramString2 });
    this.Rdn = paramString1;
    this.Rdo = paramString2;
    fqK();
    AppMethodBeat.o(31241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView
 * JD-Core Version:    0.7.0.1
 */