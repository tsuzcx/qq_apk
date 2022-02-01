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
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;

public class ProfileMobilePhoneView
  extends ProfileItemView
{
  public LinearLayout XZF;
  public boolean XZG = false;
  public String XZt;
  public String XZu;
  public String[] XZv;
  private Context mContext;
  public TextView sUt;
  private View.OnClickListener tyA;
  
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
    this.tyA = paramOnClickListener;
    this.mContext = paramContext;
  }
  
  public final boolean av(au paramau)
  {
    this.xVS = paramau;
    return true;
  }
  
  public final boolean gCe()
  {
    AppMethodBeat.i(31242);
    Object localObject;
    if (this.sUt != null)
    {
      localObject = this.sUt.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = com.tencent.mm.cd.a.br(getContext(), R.f.FixedTitleWidth);
      this.sUt.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (this.XZF == null)
    {
      AppMethodBeat.o(31242);
      return false;
    }
    int k;
    if ((!Util.isNullOrNil(this.XZt)) && (Util.isPhoneNumber(this.XZt).booleanValue()))
    {
      localObject = this.XZF.getChildAt(0);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        ((TextView)localObject).setText(this.XZt);
      }
      k = 1;
    }
    int j;
    for (int i = 1;; i = 0)
    {
      j = i;
      if (Util.isNullOrNil(this.XZu)) {
        break;
      }
      this.XZv = com.tencent.mm.contact.a.a(this.xVS, this.XZu);
      j = i;
      if (this.XZv == null) {
        break;
      }
      setVisibility(0);
      while (i < this.XZv.length + k)
      {
        localObject = this.XZF.getChildAt(i);
        if (localObject != null)
        {
          ((View)localObject).setVisibility(0);
          ((TextView)localObject).setText(this.XZv[(i - k)]);
        }
        i += 1;
      }
      if ((this.XZt != null) && (!Util.isPhoneNumber(this.XZt).booleanValue())) {
        Log.e("MicroMsg.ProfileMobilePhoneView", "mobile format is error----%s", new Object[] { this.XZt });
      }
      k = 0;
    }
    for (;;)
    {
      if (j < 5)
      {
        this.XZF.getChildAt(j).setVisibility(8);
        j += 1;
      }
      else
      {
        if ((k != 1) && (Util.isNullOrNil(this.XZu))) {
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
    return R.i.gng;
  }
  
  public final void init()
  {
    AppMethodBeat.i(31240);
    this.sUt = ((TextView)findViewById(R.h.fTe));
    this.XZF = ((LinearLayout)findViewById(R.h.fTd));
    int i = 0;
    while (i < 5)
    {
      this.XZF.getChildAt(i).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31234);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/ProfileMobilePhoneView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
  
  public final void pj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(31241);
    Log.i("MicroMsg.ProfileMobilePhoneView", "phoneNumberByMD5:%s phoneNumberList:%s", new Object[] { paramString1, paramString2 });
    this.XZt = paramString1;
    this.XZu = paramString2;
    gCe();
    AppMethodBeat.o(31241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView
 * JD-Core Version:    0.7.0.1
 */