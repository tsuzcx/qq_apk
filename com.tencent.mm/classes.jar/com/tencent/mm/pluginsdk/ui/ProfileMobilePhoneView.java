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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;

public class ProfileMobilePhoneView
  extends ProfileItemView
{
  public LinearLayout ETG;
  public boolean ETH = false;
  public String ETv;
  public String ETw;
  public String[] ETx;
  public TextView lCL;
  private Context mContext;
  private View.OnClickListener waa;
  
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
    this.waa = paramOnClickListener;
    this.mContext = paramContext;
  }
  
  public final boolean aa(am paramam)
  {
    this.pMt = paramam;
    return true;
  }
  
  public final boolean dBj()
  {
    AppMethodBeat.i(31242);
    Object localObject;
    if (this.lCL != null)
    {
      localObject = this.lCL.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = com.tencent.mm.cc.a.ax(getContext(), 2131165370);
      this.lCL.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (this.ETG == null)
    {
      AppMethodBeat.o(31242);
      return false;
    }
    int k;
    if ((!bt.isNullOrNil(this.ETv)) && (bt.aRn(this.ETv).booleanValue()))
    {
      localObject = this.ETG.getChildAt(0);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        ((TextView)localObject).setText(this.ETv);
      }
      k = 1;
    }
    int j;
    for (int i = 1;; i = 0)
    {
      j = i;
      if (bt.isNullOrNil(this.ETw)) {
        break;
      }
      this.ETx = com.tencent.mm.o.a.a(this.pMt, this.ETw);
      j = i;
      if (this.ETx == null) {
        break;
      }
      setVisibility(0);
      while (i < this.ETx.length + k)
      {
        localObject = this.ETG.getChildAt(i);
        if (localObject != null)
        {
          ((View)localObject).setVisibility(0);
          ((TextView)localObject).setText(this.ETx[(i - k)]);
        }
        i += 1;
      }
      if ((this.ETv != null) && (!bt.aRn(this.ETv).booleanValue())) {
        ad.e("MicroMsg.ProfileMobilePhoneView", "mobile format is error----%s", new Object[] { this.ETv });
      }
      k = 0;
    }
    for (;;)
    {
      if (j < 5)
      {
        this.ETG.getChildAt(j).setVisibility(8);
        j += 1;
      }
      else
      {
        if ((k != 1) && (bt.isNullOrNil(this.ETw))) {
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
    this.lCL = ((TextView)findViewById(2131303213));
    this.ETG = ((LinearLayout)findViewById(2131303212));
    int i = 0;
    while (i < 5)
    {
      this.ETG.getChildAt(i).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31234);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/ProfileMobilePhoneView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
  
  public final void lt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(31241);
    ad.i("MicroMsg.ProfileMobilePhoneView", "phoneNumberByMD5:%s phoneNumberList:%s", new Object[] { paramString1, paramString2 });
    this.ETv = paramString1;
    this.ETw = paramString2;
    dBj();
    AppMethodBeat.o(31241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView
 * JD-Core Version:    0.7.0.1
 */