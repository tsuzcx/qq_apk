package com.tencent.mm.pluginsdk.ui;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.k;

public class ProfileMobilePhoneView
  extends ProfileItemView
{
  public LinearLayout DoA;
  public boolean DoB = false;
  public String Dop;
  public String Doq;
  public String[] Dor;
  public TextView lfN;
  private Context mContext;
  private View.OnClickListener uWS;
  
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
    this.uWS = paramOnClickListener;
    this.mContext = paramContext;
  }
  
  public final boolean aa(ai paramai)
  {
    this.piT = paramai;
    return true;
  }
  
  public final boolean dqG()
  {
    AppMethodBeat.i(31242);
    Object localObject;
    if (this.lfN != null)
    {
      localObject = this.lfN.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = com.tencent.mm.cc.a.au(getContext(), 2131165370);
      this.lfN.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (this.DoA == null)
    {
      AppMethodBeat.o(31242);
      return false;
    }
    int k;
    if ((!bs.isNullOrNil(this.Dop)) && (bs.aLH(this.Dop).booleanValue()))
    {
      localObject = this.DoA.getChildAt(0);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        ((TextView)localObject).setText(this.Dop);
      }
      k = 1;
    }
    int j;
    for (int i = 1;; i = 0)
    {
      j = i;
      if (bs.isNullOrNil(this.Doq)) {
        break;
      }
      this.Dor = com.tencent.mm.n.a.a(this.piT, this.Doq);
      j = i;
      if (this.Dor == null) {
        break;
      }
      setVisibility(0);
      while (i < this.Dor.length + k)
      {
        localObject = this.DoA.getChildAt(i);
        if (localObject != null)
        {
          ((View)localObject).setVisibility(0);
          ((TextView)localObject).setText(this.Dor[(i - k)]);
        }
        i += 1;
      }
      if ((this.Dop != null) && (!bs.aLH(this.Dop).booleanValue())) {
        ac.e("MicroMsg.ProfileMobilePhoneView", "mobile format is error----%s", new Object[] { this.Dop });
      }
      k = 0;
    }
    for (;;)
    {
      if (j < 5)
      {
        this.DoA.getChildAt(j).setVisibility(8);
        j += 1;
      }
      else
      {
        if ((k != 1) && (bs.isNullOrNil(this.Doq))) {
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
    this.lfN = ((TextView)findViewById(2131303213));
    this.DoA = ((LinearLayout)findViewById(2131303212));
    int i = 0;
    while (i < 5)
    {
      this.DoA.getChildAt(i).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31234);
          ProfileMobilePhoneView.a(ProfileMobilePhoneView.this, ((TextView)paramAnonymousView).getText().toString());
          ProfileMobilePhoneView.a(ProfileMobilePhoneView.this).onClick(paramAnonymousView);
          AppMethodBeat.o(31234);
        }
      });
      i += 1;
    }
    AppMethodBeat.o(31240);
  }
  
  public final void kW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(31241);
    ac.i("MicroMsg.ProfileMobilePhoneView", "phoneNumberByMD5:%s phoneNumberList:%s", new Object[] { paramString1, paramString2 });
    this.Dop = paramString1;
    this.Doq = paramString2;
    dqG();
    AppMethodBeat.o(31241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView
 * JD-Core Version:    0.7.0.1
 */