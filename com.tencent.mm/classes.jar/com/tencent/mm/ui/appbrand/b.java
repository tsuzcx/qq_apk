package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Looper;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.voip.ui.MMCheckBox;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.z;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends i
  implements DialogInterface
{
  private LinearLayout Gph;
  private int Hto;
  private ImageView Htp;
  private ImageView Htq;
  private Button Htr;
  private ViewGroup Hts;
  private TextView Htt;
  private TextView Htu;
  private TextView Htv;
  private TextView Htw;
  public List<b> Htx;
  public a Hty;
  CompoundButton.OnCheckedChangeListener Htz;
  private View.OnClickListener gst;
  private String lhM;
  private int mMode;
  private boolean mab;
  private TextView oMw;
  
  public b(Context paramContext, int paramInt, String paramString)
  {
    super(paramContext, 2131821484);
    AppMethodBeat.i(196348);
    this.Htx = new ArrayList();
    this.gst = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196345);
        int i = paramAnonymousView.getId();
        if (b.a(b.this) != null)
        {
          if (i == 2131297999)
          {
            b.a(b.this).fhR();
            AppMethodBeat.o(196345);
            return;
          }
          if ((i == 2131297989) || (i == 2131297994))
          {
            b.a(b.this).fhS();
            AppMethodBeat.o(196345);
            return;
          }
          if ((i == 2131297990) || (i == 2131297995))
          {
            b.a(b.this).fhT();
            AppMethodBeat.o(196345);
            return;
          }
          if (i == 2131297996) {
            b.a(b.this).fhU();
          }
        }
        AppMethodBeat.o(196345);
      }
    };
    this.Htz = new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(196346);
        ((b.b)paramAnonymousCompoundButton.getTag()).nYF = paramAnonymousBoolean;
        if (paramAnonymousBoolean) {
          b.b(b.this);
        }
        for (;;)
        {
          b.d(b.this);
          AppMethodBeat.o(196346);
          return;
          b.c(b.this);
        }
      }
    };
    this.mMode = paramInt;
    this.lhM = paramString;
    this.Hto = 0;
    if (!bs.isNullOrNil(paramString))
    {
      if ((aZ(paramString, 0)) || (aZ(paramString, 1)) || (aZ(paramString, 2))) {
        bool = true;
      }
      this.mab = bool;
    }
    this.Gph = ((LinearLayout)z.jD(paramContext).inflate(2131493389, null));
    this.Htp = ((ImageView)this.Gph.findViewById(2131297988));
    this.Htp.setColorFilter(paramContext.getResources().getColor(2131099650));
    this.Htq = ((ImageView)this.Gph.findViewById(2131297987));
    this.Htq.setColorFilter(paramContext.getResources().getColor(2131099650));
    setCanceledOnTouchOutside(true);
    if (this.mMode == 0)
    {
      ((ViewStub)this.Gph.findViewById(2131297993)).inflate();
      this.Htr = ((Button)this.Gph.findViewById(2131297999));
      this.Hts = ((ViewGroup)this.Gph.findViewById(2131297992));
      this.Htt = ((TextView)this.Gph.findViewById(2131297989));
      this.oMw = ((TextView)this.Gph.findViewById(2131297990));
      this.Htr.setOnClickListener(this.gst);
      this.Htt.setOnClickListener(this.gst);
      this.oMw.setOnClickListener(this.gst);
      paramContext = new ArrayList();
      paramString = this.Gph.getContext();
      paramContext.add(new b(1, paramString.getString(2131757121)));
      paramContext.add(new b(2, paramString.getString(2131757120)));
      paramContext.add(new b(3, paramString.getString(2131757122)));
      hD(paramContext);
      AppMethodBeat.o(196348);
      return;
    }
    ((ViewStub)this.Gph.findViewById(2131297997)).inflate();
    this.Htu = ((TextView)this.Gph.findViewById(2131297996));
    this.Htv = ((TextView)this.Gph.findViewById(2131297994));
    this.Htw = ((TextView)this.Gph.findViewById(2131297995));
    if (this.mab) {
      this.Htu.setOnClickListener(this.gst);
    }
    for (;;)
    {
      this.Htv.setOnClickListener(this.gst);
      this.Htw.setOnClickListener(this.gst);
      AppMethodBeat.o(196348);
      return;
      this.Htu.setVisibility(8);
    }
  }
  
  private MMCheckBox a(Context paramContext, b paramb)
  {
    AppMethodBeat.i(196351);
    MMCheckBox localMMCheckBox = new MMCheckBox(new ContextThemeWrapper(paramContext, 2131820561), null, 2131820561);
    localMMCheckBox.setText(paramb.fBV);
    localMMCheckBox.setTag(paramb);
    localMMCheckBox.setTextSize(0, a.au(paramContext, 2131165569));
    localMMCheckBox.setOnCheckedChangeListener(this.Htz);
    AppMethodBeat.o(196351);
    return localMMCheckBox;
  }
  
  private static boolean aZ(String paramString, int paramInt)
  {
    AppMethodBeat.i(196354);
    boolean bool = ((ah)g.ab(ah.class)).aV(paramString, paramInt);
    AppMethodBeat.o(196354);
    return bool;
  }
  
  private void hD(List<b> paramList)
  {
    AppMethodBeat.i(196350);
    if (paramList.isEmpty())
    {
      ac.i("MicroMsg.AppBrandNoticeMoreDialog", "has no reason data");
      AppMethodBeat.o(196350);
      return;
    }
    this.Htx.clear();
    this.Htx.addAll(paramList);
    Context localContext = this.Gph.getContext();
    LinearLayout localLinearLayout = new LinearLayout(localContext);
    int i = 0;
    LinearLayout.LayoutParams localLayoutParams;
    Object localObject;
    while (i < paramList.size() / 3)
    {
      localLinearLayout.setOrientation(0);
      j = 0;
      while (j < 3)
      {
        localLayoutParams = new LinearLayout.LayoutParams(-2, localContext.getResources().getDimensionPixelOffset(2131165514));
        localObject = a(localContext, (b)paramList.get(i * 3 + j));
        if (j != 0) {
          localLayoutParams.leftMargin = localContext.getResources().getDimensionPixelOffset(2131165284);
        }
        localLinearLayout.addView((View)localObject, localLayoutParams);
        j += 1;
      }
      i += 1;
    }
    this.Hts.addView(localLinearLayout);
    localLinearLayout = new LinearLayout(localContext);
    int j = 0;
    while (j < paramList.size() - i * 3)
    {
      localObject = (b)paramList.get(i * 3 + j);
      localLinearLayout.setOrientation(0);
      localLayoutParams = new LinearLayout.LayoutParams(-2, localContext.getResources().getDimensionPixelOffset(2131165514));
      localObject = a(localContext, (b)localObject);
      if (j != 0) {
        localLayoutParams.leftMargin = localContext.getResources().getDimensionPixelOffset(2131165284);
      }
      localLinearLayout.addView((View)localObject, localLayoutParams);
      j += 1;
    }
    this.Hts.addView(localLinearLayout);
    AppMethodBeat.o(196350);
  }
  
  private void wM(boolean paramBoolean)
  {
    AppMethodBeat.i(196352);
    if (paramBoolean)
    {
      this.Htp.setVisibility(0);
      this.Htq.setVisibility(8);
      AppMethodBeat.o(196352);
      return;
    }
    this.Htp.setVisibility(8);
    this.Htq.setVisibility(0);
    AppMethodBeat.o(196352);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(196355);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(196347);
          b.this.dismiss();
          AppMethodBeat.o(196347);
        }
      });
      ac.e("MicroMsg.AppBrandNoticeMoreDialog", bs.eWi().toString());
      AppMethodBeat.o(196355);
      return;
    }
    try
    {
      super.dismiss();
      AppMethodBeat.o(196355);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.AppBrandNoticeMoreDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(196355);
    }
  }
  
  public final void fP(View paramView)
  {
    AppMethodBeat.i(196353);
    Context localContext = paramView.getContext();
    Point localPoint = aj.cl(localContext);
    int i;
    Window localWindow;
    WindowManager.LayoutParams localLayoutParams;
    int[] arrayOfInt;
    int j;
    int k;
    int m;
    if (this.mMode == 0)
    {
      i = a.av(localContext, 2131166013) + a.av(localContext, 2131166009) + a.av(localContext, 2131166008);
      localWindow = getWindow();
      if (localWindow != null)
      {
        localLayoutParams = localWindow.getAttributes();
        localLayoutParams.gravity = 8388661;
        localLayoutParams.verticalMargin = 0.0F;
        localLayoutParams.horizontalMargin = 0.0F;
        arrayOfInt = new int[2];
        paramView.getLocationOnScreen(arrayOfInt);
        localLayoutParams.x = (localPoint.x - arrayOfInt[0] - paramView.getMeasuredWidth() / 2 - a.av(localContext, 2131166007) - a.av(localContext, 2131166009) / 2);
        j = aj.jw(localContext);
        k = a.av(localContext, 2131166015);
        m = a.av(localContext, 2131166010);
        if (arrayOfInt[1] + paramView.getMeasuredHeight() + i + k - m <= localPoint.y - aj.ej(localContext)) {
          break label293;
        }
        localLayoutParams.y = (arrayOfInt[1] - j - i - k + m);
        wM(false);
      }
    }
    for (;;)
    {
      localWindow.setAttributes(localLayoutParams);
      try
      {
        super.show();
        AppMethodBeat.o(196353);
        return;
      }
      catch (Exception paramView)
      {
        ac.printErrStackTrace("MicroMsg.AppBrandNoticeMoreDialog", paramView, "", new Object[0]);
        AppMethodBeat.o(196353);
      }
      j = a.av(localContext, 2131166016) + a.av(localContext, 2131166009) + a.av(localContext, 2131166008);
      i = j;
      if (this.mab) {
        break;
      }
      i = j - a.av(localContext, 2131167029);
      break;
      label293:
      localLayoutParams.y = (arrayOfInt[1] - j + paramView.getMeasuredHeight() + k - m);
      wM(true);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(196349);
    super.onCreate(paramBundle);
    setContentView(this.Gph);
    AppMethodBeat.o(196349);
  }
  
  public static abstract interface a
  {
    public abstract void fhR();
    
    public abstract void fhS();
    
    public abstract void fhT();
    
    public abstract void fhU();
  }
  
  public final class b
  {
    public int HtB;
    public String fBV;
    public boolean nYF;
    
    public b(int paramInt, String paramString)
    {
      this.HtB = paramInt;
      this.fBV = paramString;
      this.nYF = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.b
 * JD-Core Version:    0.7.0.1
 */