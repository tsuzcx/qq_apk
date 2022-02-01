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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;

public class ProfileMobilePhoneView
  extends ProfileItemView
{
  public String KcI;
  public String KcJ;
  public String[] KcK;
  public LinearLayout KcT;
  public boolean KcU = false;
  private Context mContext;
  public TextView mPa;
  private View.OnClickListener zHh;
  
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
    this.zHh = paramOnClickListener;
    this.mContext = paramContext;
  }
  
  public final boolean aj(as paramas)
  {
    this.rjX = paramas;
    return true;
  }
  
  public final boolean eEV()
  {
    AppMethodBeat.i(31242);
    Object localObject;
    if (this.mPa != null)
    {
      localObject = this.mPa.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = com.tencent.mm.cb.a.aG(getContext(), 2131165381);
      this.mPa.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (this.KcT == null)
    {
      AppMethodBeat.o(31242);
      return false;
    }
    int k;
    if ((!Util.isNullOrNil(this.KcI)) && (Util.isPhoneNumber(this.KcI).booleanValue()))
    {
      localObject = this.KcT.getChildAt(0);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        ((TextView)localObject).setText(this.KcI);
      }
      k = 1;
    }
    int j;
    for (int i = 1;; i = 0)
    {
      j = i;
      if (Util.isNullOrNil(this.KcJ)) {
        break;
      }
      this.KcK = com.tencent.mm.contact.a.a(this.rjX, this.KcJ);
      j = i;
      if (this.KcK == null) {
        break;
      }
      setVisibility(0);
      while (i < this.KcK.length + k)
      {
        localObject = this.KcT.getChildAt(i);
        if (localObject != null)
        {
          ((View)localObject).setVisibility(0);
          ((TextView)localObject).setText(this.KcK[(i - k)]);
        }
        i += 1;
      }
      if ((this.KcI != null) && (!Util.isPhoneNumber(this.KcI).booleanValue())) {
        Log.e("MicroMsg.ProfileMobilePhoneView", "mobile format is error----%s", new Object[] { this.KcI });
      }
      k = 0;
    }
    for (;;)
    {
      if (j < 5)
      {
        this.KcT.getChildAt(j).setVisibility(8);
        j += 1;
      }
      else
      {
        if ((k != 1) && (Util.isNullOrNil(this.KcJ))) {
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
    return 2131495982;
  }
  
  public final void init()
  {
    AppMethodBeat.i(31240);
    this.mPa = ((TextView)findViewById(2131305881));
    this.KcT = ((LinearLayout)findViewById(2131305880));
    int i = 0;
    while (i < 5)
    {
      this.KcT.getChildAt(i).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31234);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/ProfileMobilePhoneView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
  
  public final void my(String paramString1, String paramString2)
  {
    AppMethodBeat.i(31241);
    Log.i("MicroMsg.ProfileMobilePhoneView", "phoneNumberByMD5:%s phoneNumberList:%s", new Object[] { paramString1, paramString2 });
    this.KcI = paramString1;
    this.KcJ = paramString2;
    eEV();
    AppMethodBeat.o(31241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView
 * JD-Core Version:    0.7.0.1
 */