package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import java.util.List;
import junit.framework.Assert;

public class ProfileMobilePhoneView
  extends ProfileItemView
{
  public TextView iJG;
  private Context mContext;
  private View.OnClickListener qMg;
  public LinearLayout vRC;
  public boolean vRD = false;
  public String vRr;
  public String vRs;
  public String[] vRt;
  
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
    this.qMg = paramOnClickListener;
    this.mContext = paramContext;
  }
  
  @Deprecated
  public final boolean S(ad paramad)
  {
    return false;
  }
  
  public final boolean ccG()
  {
    AppMethodBeat.i(27540);
    Object localObject;
    if (this.iJG != null)
    {
      localObject = this.iJG.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = a.ao(getContext(), 2131427664);
      this.iJG.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (this.vRC == null)
    {
      AppMethodBeat.o(27540);
      return false;
    }
    int k;
    if ((!bo.isNullOrNil(this.vRr)) && (bo.aqe(this.vRr).booleanValue()))
    {
      localObject = this.vRC.getChildAt(0);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        ((TextView)localObject).setText(this.vRr);
      }
      k = 1;
    }
    int j;
    for (int i = 1;; i = 0)
    {
      if (bo.isNullOrNil(this.vRs)) {
        break label304;
      }
      this.vRt = this.vRs.split(",");
      setVisibility(0);
      for (;;)
      {
        j = i;
        if (i >= this.vRt.length + k) {
          break;
        }
        localObject = this.vRC.getChildAt(i);
        if (localObject != null)
        {
          ((View)localObject).setVisibility(0);
          ((TextView)localObject).setText(this.vRt[(i - k)]);
        }
        i += 1;
      }
      if ((this.vRr != null) && (!bo.aqe(this.vRr).booleanValue())) {
        ab.e("MicroMsg.ProfileMobilePhoneView", "mobile format is error----%s", new Object[] { this.vRr });
      }
      k = 0;
    }
    for (;;)
    {
      if (j < 5)
      {
        this.vRC.getChildAt(j).setVisibility(8);
        j += 1;
      }
      else
      {
        if ((k != 1) && (bo.isNullOrNil(this.vRs))) {
          setVisibility(8);
        }
        AppMethodBeat.o(27540);
        return false;
        label304:
        j = i;
      }
    }
  }
  
  public int getLayout()
  {
    return 2130970466;
  }
  
  public final void hT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(27539);
    ab.i("MicroMsg.ProfileMobilePhoneView", "phoneNumberByMD5:%s phoneNumberList:%s", new Object[] { paramString1, paramString2 });
    this.vRr = paramString1;
    this.vRs = paramString2;
    ccG();
    AppMethodBeat.o(27539);
  }
  
  public final void init()
  {
    AppMethodBeat.i(27538);
    this.iJG = ((TextView)findViewById(2131826852));
    this.vRC = ((LinearLayout)findViewById(2131826853));
    int i = 0;
    while (i < 5)
    {
      this.vRC.getChildAt(i).setOnClickListener(new ProfileMobilePhoneView.1(this));
      i += 1;
    }
    AppMethodBeat.o(27538);
  }
  
  static final class a
    extends BaseAdapter
  {
    private Context mContext;
    private List<String> nxh;
    
    public a(Context paramContext, List<String> paramList)
    {
      AppMethodBeat.i(27534);
      this.nxh = null;
      this.mContext = null;
      if (paramContext != null) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        this.mContext = paramContext;
        this.nxh = paramList;
        AppMethodBeat.o(27534);
        return;
      }
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(27535);
      if (this.nxh == null)
      {
        AppMethodBeat.o(27535);
        return 0;
      }
      int i = this.nxh.size();
      AppMethodBeat.o(27535);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(27536);
      Object localObject = this.nxh.get(paramInt);
      AppMethodBeat.o(27536);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(27537);
      String str = (String)getItem(paramInt);
      View localView;
      if (paramView == null)
      {
        localView = ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2130969099, paramViewGroup, false);
        paramView = new ProfileMobilePhoneView.a.a(this, (byte)0);
        ((ProfileMobilePhoneView.a.a)paramView).gui = ((TextView)localView.findViewById(2131820680));
        localView.setTag(paramView);
        paramViewGroup = paramView;
      }
      for (;;)
      {
        ((ProfileMobilePhoneView.a.a)paramViewGroup).gui.setText(str);
        AppMethodBeat.o(27537);
        return localView;
        paramViewGroup = paramView.getTag();
        localView = paramView;
      }
    }
    
    public final int getViewTypeCount()
    {
      return 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView
 * JD-Core Version:    0.7.0.1
 */