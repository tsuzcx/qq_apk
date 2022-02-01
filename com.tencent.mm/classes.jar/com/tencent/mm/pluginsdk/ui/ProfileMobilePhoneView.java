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
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.base.k;

public class ProfileMobilePhoneView
  extends ProfileItemView
{
  public String BVY;
  public String BVZ;
  public String[] BWa;
  public LinearLayout BWj;
  public boolean BWk = false;
  public TextView kEu;
  private Context mContext;
  private View.OnClickListener tOp;
  
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
    this.tOp = paramOnClickListener;
    this.mContext = paramContext;
  }
  
  public final boolean Z(af paramaf)
  {
    this.oFt = paramaf;
    return true;
  }
  
  public final boolean dcY()
  {
    AppMethodBeat.i(31242);
    Object localObject;
    if (this.kEu != null)
    {
      localObject = this.kEu.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = com.tencent.mm.cd.a.ao(getContext(), 2131165370);
      this.kEu.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (this.BWj == null)
    {
      AppMethodBeat.o(31242);
      return false;
    }
    int k;
    if ((!bt.isNullOrNil(this.BVY)) && (bt.aGq(this.BVY).booleanValue()))
    {
      localObject = this.BWj.getChildAt(0);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        ((TextView)localObject).setText(this.BVY);
      }
      k = 1;
    }
    int j;
    for (int i = 1;; i = 0)
    {
      j = i;
      if (bt.isNullOrNil(this.BVZ)) {
        break;
      }
      this.BWa = com.tencent.mm.n.a.a(this.oFt, this.BVZ);
      j = i;
      if (this.BWa == null) {
        break;
      }
      setVisibility(0);
      while (i < this.BWa.length + k)
      {
        localObject = this.BWj.getChildAt(i);
        if (localObject != null)
        {
          ((View)localObject).setVisibility(0);
          ((TextView)localObject).setText(this.BWa[(i - k)]);
        }
        i += 1;
      }
      if ((this.BVY != null) && (!bt.aGq(this.BVY).booleanValue())) {
        ad.e("MicroMsg.ProfileMobilePhoneView", "mobile format is error----%s", new Object[] { this.BVY });
      }
      k = 0;
    }
    for (;;)
    {
      if (j < 5)
      {
        this.BWj.getChildAt(j).setVisibility(8);
        j += 1;
      }
      else
      {
        if ((k != 1) && (bt.isNullOrNil(this.BVZ))) {
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
    this.kEu = ((TextView)findViewById(2131303213));
    this.BWj = ((LinearLayout)findViewById(2131303212));
    int i = 0;
    while (i < 5)
    {
      this.BWj.getChildAt(i).setOnClickListener(new View.OnClickListener()
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
  
  public final void kz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(31241);
    ad.i("MicroMsg.ProfileMobilePhoneView", "phoneNumberByMD5:%s phoneNumberList:%s", new Object[] { paramString1, paramString2 });
    this.BVY = paramString1;
    this.BVZ = paramString2;
    dcY();
    AppMethodBeat.o(31241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView
 * JD-Core Version:    0.7.0.1
 */