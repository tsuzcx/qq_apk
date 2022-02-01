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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.voip.ui.MMCheckBox;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.z;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends i
  implements DialogInterface
{
  private LinearLayout IaU;
  private int Jhe;
  private ImageView Jhf;
  private ImageView Jhg;
  private Button Jhh;
  private ViewGroup Jhi;
  private TextView Jhj;
  private TextView Jhk;
  private TextView Jhl;
  private TextView Jhm;
  public List<b> Jhn;
  public a Jho;
  CompoundButton.OnCheckedChangeListener Jhp;
  private View.OnClickListener gMe;
  private String lEN;
  private int mMode;
  private boolean mzW;
  private TextView pqe;
  
  public b(Context paramContext, int paramInt, String paramString)
  {
    super(paramContext, 2131821484);
    AppMethodBeat.i(193767);
    this.Jhn = new ArrayList();
    this.gMe = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(193764);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/appbrand/AppBrandNoticeMoreDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        int i = paramAnonymousView.getId();
        if (b.a(b.this) != null)
        {
          if (i != 2131297999) {
            break label85;
          }
          b.a(b.this).fyh();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/appbrand/AppBrandNoticeMoreDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(193764);
          return;
          label85:
          if ((i == 2131297989) || (i == 2131297994)) {
            b.a(b.this).fyi();
          } else if ((i == 2131297990) || (i == 2131297995)) {
            b.a(b.this).fyj();
          } else if (i == 2131297996) {
            b.a(b.this).fyk();
          }
        }
      }
    };
    this.Jhp = new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(193765);
        ((b.b)paramAnonymousCompoundButton.getTag()).oBZ = paramAnonymousBoolean;
        if (paramAnonymousBoolean) {
          b.b(b.this);
        }
        for (;;)
        {
          b.d(b.this);
          AppMethodBeat.o(193765);
          return;
          b.c(b.this);
        }
      }
    };
    this.mMode = paramInt;
    this.lEN = paramString;
    this.Jhe = 0;
    if (!bt.isNullOrNil(paramString))
    {
      if ((bb(paramString, 0)) || (bb(paramString, 1)) || (bb(paramString, 2))) {
        bool = true;
      }
      this.mzW = bool;
    }
    this.IaU = ((LinearLayout)z.jO(paramContext).inflate(2131493389, null));
    this.Jhf = ((ImageView)this.IaU.findViewById(2131297988));
    this.Jhf.setColorFilter(paramContext.getResources().getColor(2131099650));
    this.Jhg = ((ImageView)this.IaU.findViewById(2131297987));
    this.Jhg.setColorFilter(paramContext.getResources().getColor(2131099650));
    setCanceledOnTouchOutside(true);
    if (this.mMode == 0)
    {
      ((ViewStub)this.IaU.findViewById(2131297993)).inflate();
      this.Jhh = ((Button)this.IaU.findViewById(2131297999));
      this.Jhi = ((ViewGroup)this.IaU.findViewById(2131297992));
      this.Jhj = ((TextView)this.IaU.findViewById(2131297989));
      this.pqe = ((TextView)this.IaU.findViewById(2131297990));
      this.Jhh.setOnClickListener(this.gMe);
      this.Jhj.setOnClickListener(this.gMe);
      this.pqe.setOnClickListener(this.gMe);
      paramContext = new ArrayList();
      paramString = this.IaU.getContext();
      paramContext.add(new b(1, paramString.getString(2131757121)));
      paramContext.add(new b(2, paramString.getString(2131757120)));
      paramContext.add(new b(3, paramString.getString(2131757122)));
      hP(paramContext);
      AppMethodBeat.o(193767);
      return;
    }
    ((ViewStub)this.IaU.findViewById(2131297997)).inflate();
    this.Jhk = ((TextView)this.IaU.findViewById(2131297996));
    this.Jhl = ((TextView)this.IaU.findViewById(2131297994));
    this.Jhm = ((TextView)this.IaU.findViewById(2131297995));
    if (this.mzW) {
      this.Jhk.setOnClickListener(this.gMe);
    }
    for (;;)
    {
      this.Jhl.setOnClickListener(this.gMe);
      this.Jhm.setOnClickListener(this.gMe);
      AppMethodBeat.o(193767);
      return;
      this.Jhk.setVisibility(8);
    }
  }
  
  private MMCheckBox a(Context paramContext, b paramb)
  {
    AppMethodBeat.i(193770);
    MMCheckBox localMMCheckBox = new MMCheckBox(new ContextThemeWrapper(paramContext, 2131820561), null, 2131820561);
    localMMCheckBox.setText(paramb.fVj);
    localMMCheckBox.setTag(paramb);
    localMMCheckBox.setTextSize(0, com.tencent.mm.cc.a.ax(paramContext, 2131165569));
    localMMCheckBox.setOnCheckedChangeListener(this.Jhp);
    AppMethodBeat.o(193770);
    return localMMCheckBox;
  }
  
  private static boolean bb(String paramString, int paramInt)
  {
    AppMethodBeat.i(193773);
    boolean bool = ((ah)g.ab(ah.class)).aX(paramString, paramInt);
    AppMethodBeat.o(193773);
    return bool;
  }
  
  private void hP(List<b> paramList)
  {
    AppMethodBeat.i(193769);
    if (paramList.isEmpty())
    {
      ad.i("MicroMsg.AppBrandNoticeMoreDialog", "has no reason data");
      AppMethodBeat.o(193769);
      return;
    }
    this.Jhn.clear();
    this.Jhn.addAll(paramList);
    Context localContext = this.IaU.getContext();
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
    this.Jhi.addView(localLinearLayout);
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
    this.Jhi.addView(localLinearLayout);
    AppMethodBeat.o(193769);
  }
  
  private void xx(boolean paramBoolean)
  {
    AppMethodBeat.i(193771);
    if (paramBoolean)
    {
      this.Jhf.setVisibility(0);
      this.Jhg.setVisibility(8);
      AppMethodBeat.o(193771);
      return;
    }
    this.Jhf.setVisibility(8);
    this.Jhg.setVisibility(0);
    AppMethodBeat.o(193771);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(193774);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(193766);
          b.this.dismiss();
          AppMethodBeat.o(193766);
        }
      });
      ad.e("MicroMsg.AppBrandNoticeMoreDialog", bt.flS().toString());
      AppMethodBeat.o(193774);
      return;
    }
    try
    {
      super.dismiss();
      AppMethodBeat.o(193774);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.AppBrandNoticeMoreDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(193774);
    }
  }
  
  public final void ge(View paramView)
  {
    AppMethodBeat.i(193772);
    Context localContext = paramView.getContext();
    Point localPoint = al.ci(localContext);
    int i;
    Window localWindow;
    WindowManager.LayoutParams localLayoutParams;
    int[] arrayOfInt;
    int j;
    int k;
    int m;
    if (this.mMode == 0)
    {
      i = com.tencent.mm.cc.a.ay(localContext, 2131166013) + com.tencent.mm.cc.a.ay(localContext, 2131166009) + com.tencent.mm.cc.a.ay(localContext, 2131166008);
      localWindow = getWindow();
      if (localWindow != null)
      {
        localLayoutParams = localWindow.getAttributes();
        localLayoutParams.gravity = 8388661;
        localLayoutParams.verticalMargin = 0.0F;
        localLayoutParams.horizontalMargin = 0.0F;
        arrayOfInt = new int[2];
        paramView.getLocationOnScreen(arrayOfInt);
        localLayoutParams.x = (localPoint.x - arrayOfInt[0] - paramView.getMeasuredWidth() / 2 - com.tencent.mm.cc.a.ay(localContext, 2131166007) - com.tencent.mm.cc.a.ay(localContext, 2131166009) / 2);
        j = al.jH(localContext);
        k = com.tencent.mm.cc.a.ay(localContext, 2131166015);
        m = com.tencent.mm.cc.a.ay(localContext, 2131166010);
        if (arrayOfInt[1] + paramView.getMeasuredHeight() + i + k - m <= localPoint.y - al.ej(localContext)) {
          break label293;
        }
        localLayoutParams.y = (arrayOfInt[1] - j - i - k + m);
        xx(false);
      }
    }
    for (;;)
    {
      localWindow.setAttributes(localLayoutParams);
      try
      {
        super.show();
        AppMethodBeat.o(193772);
        return;
      }
      catch (Exception paramView)
      {
        ad.printErrStackTrace("MicroMsg.AppBrandNoticeMoreDialog", paramView, "", new Object[0]);
        AppMethodBeat.o(193772);
      }
      j = com.tencent.mm.cc.a.ay(localContext, 2131166016) + com.tencent.mm.cc.a.ay(localContext, 2131166009) + com.tencent.mm.cc.a.ay(localContext, 2131166008);
      i = j;
      if (this.mzW) {
        break;
      }
      i = j - com.tencent.mm.cc.a.ay(localContext, 2131167029);
      break;
      label293:
      localLayoutParams.y = (arrayOfInt[1] - j + paramView.getMeasuredHeight() + k - m);
      xx(true);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(193768);
    super.onCreate(paramBundle);
    setContentView(this.IaU);
    AppMethodBeat.o(193768);
  }
  
  public static abstract interface a
  {
    public abstract void fyh();
    
    public abstract void fyi();
    
    public abstract void fyj();
    
    public abstract void fyk();
  }
  
  public final class b
  {
    public int Jhr;
    public String fVj;
    public boolean oBZ;
    
    public b(int paramInt, String paramString)
    {
      this.Jhr = paramInt;
      this.fVj = paramString;
      this.oBZ = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.b
 * JD-Core Version:    0.7.0.1
 */