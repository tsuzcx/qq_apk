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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.R.m;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.voip.widget.MMCheckBox;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.a.i;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends i
  implements DialogInterface
{
  private LinearLayout acrm;
  private int adNc;
  private ImageView adNd;
  private ImageView adNe;
  private Button adNf;
  private ViewGroup adNg;
  private TextView adNh;
  private TextView adNi;
  private TextView adNj;
  private TextView adNk;
  public List<b> adNl;
  public a adNm;
  CompoundButton.OnCheckedChangeListener adNn;
  private int mMode;
  private View.OnClickListener mWW;
  private String sWX;
  private boolean tYg;
  private TextView xtJ;
  
  public b(Context paramContext, int paramInt, String paramString)
  {
    super(paramContext, R.m.TopstoryFeedbackDialog);
    AppMethodBeat.i(249664);
    this.adNl = new ArrayList();
    this.mWW = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(249667);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/appbrand/AppBrandNoticeMoreDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        int i = paramAnonymousView.getId();
        if (b.a(b.this) != null)
        {
          if (i != R.h.fwe) {
            break label86;
          }
          b.a(b.this).jlN();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/appbrand/AppBrandNoticeMoreDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(249667);
          return;
          label86:
          if ((i == R.h.fvV) || (i == R.h.fwa)) {
            b.a(b.this).jlO();
          } else if ((i == R.h.fvW) || (i == R.h.fwb)) {
            b.a(b.this).jlP();
          } else if (i == R.h.fwc) {
            b.a(b.this).esm();
          }
        }
      }
    };
    this.adNn = new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(249668);
        ((b.b)paramAnonymousCompoundButton.getTag()).wwJ = paramAnonymousBoolean;
        if (paramAnonymousBoolean) {
          b.b(b.this);
        }
        for (;;)
        {
          b.d(b.this);
          AppMethodBeat.o(249668);
          return;
          b.c(b.this);
        }
      }
    };
    this.mMode = paramInt;
    this.sWX = paramString;
    this.adNc = 0;
    if (!Util.isNullOrNil(paramString))
    {
      if ((bU(paramString, 0)) || (bU(paramString, 1)) || (bU(paramString, 2))) {
        bool = true;
      }
      this.tYg = bool;
    }
    this.acrm = ((LinearLayout)com.tencent.mm.ui.af.mU(paramContext).inflate(R.i.geS, null));
    this.adNd = ((ImageView)this.acrm.findViewById(R.h.fvU));
    this.adNd.setColorFilter(paramContext.getResources().getColor(R.e.BG_2));
    this.adNe = ((ImageView)this.acrm.findViewById(R.h.fvT));
    this.adNe.setColorFilter(paramContext.getResources().getColor(R.e.BG_2));
    setCanceledOnTouchOutside(true);
    if (this.mMode == 0)
    {
      ((ViewStub)this.acrm.findViewById(R.h.fvZ)).inflate();
      this.adNf = ((Button)this.acrm.findViewById(R.h.fwe));
      this.adNg = ((ViewGroup)this.acrm.findViewById(R.h.fvY));
      this.adNh = ((TextView)this.acrm.findViewById(R.h.fvV));
      this.xtJ = ((TextView)this.acrm.findViewById(R.h.fvW));
      this.adNf.setOnClickListener(this.mWW);
      this.adNh.setOnClickListener(this.mWW);
      this.xtJ.setOnClickListener(this.mWW);
      paramContext = new ArrayList();
      paramString = this.acrm.getContext();
      paramContext.add(new b(1, paramString.getString(R.l.gwN)));
      paramContext.add(new b(2, paramString.getString(R.l.gwM)));
      paramContext.add(new b(3, paramString.getString(R.l.gwO)));
      nk(paramContext);
      AppMethodBeat.o(249664);
      return;
    }
    ((ViewStub)this.acrm.findViewById(R.h.fwd)).inflate();
    this.adNi = ((TextView)this.acrm.findViewById(R.h.fwc));
    this.adNj = ((TextView)this.acrm.findViewById(R.h.fwa));
    this.adNk = ((TextView)this.acrm.findViewById(R.h.fwb));
    if (this.tYg) {
      this.adNi.setOnClickListener(this.mWW);
    }
    for (;;)
    {
      this.adNj.setOnClickListener(this.mWW);
      this.adNk.setOnClickListener(this.mWW);
      AppMethodBeat.o(249664);
      return;
      this.adNi.setVisibility(8);
    }
  }
  
  private void Lx(boolean paramBoolean)
  {
    AppMethodBeat.i(249679);
    if (paramBoolean)
    {
      this.adNd.setVisibility(0);
      this.adNe.setVisibility(8);
      AppMethodBeat.o(249679);
      return;
    }
    this.adNd.setVisibility(8);
    this.adNe.setVisibility(0);
    AppMethodBeat.o(249679);
  }
  
  private MMCheckBox a(Context paramContext, b paramb)
  {
    AppMethodBeat.i(249673);
    MMCheckBox localMMCheckBox = new MMCheckBox(new ContextThemeWrapper(paramContext, R.m.gZr), null, R.m.gZr);
    localMMCheckBox.setText(paramb.displayName);
    localMMCheckBox.setTag(paramb);
    localMMCheckBox.setTextSize(0, com.tencent.mm.cd.a.br(paramContext, R.f.SmallTextSize));
    localMMCheckBox.setOnCheckedChangeListener(this.adNn);
    AppMethodBeat.o(249673);
    return localMMCheckBox;
  }
  
  private static boolean bU(String paramString, int paramInt)
  {
    AppMethodBeat.i(249682);
    boolean bool = ((com.tencent.mm.plugin.appbrand.appusage.af)h.ax(com.tencent.mm.plugin.appbrand.appusage.af.class)).bP(paramString, paramInt);
    AppMethodBeat.o(249682);
    return bool;
  }
  
  private void nk(List<b> paramList)
  {
    AppMethodBeat.i(249670);
    if (paramList.isEmpty())
    {
      Log.i("MicroMsg.AppBrandNoticeMoreDialog", "has no reason data");
      AppMethodBeat.o(249670);
      return;
    }
    this.adNl.clear();
    this.adNl.addAll(paramList);
    Context localContext = this.acrm.getContext();
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
        localLayoutParams = new LinearLayout.LayoutParams(-2, localContext.getResources().getDimensionPixelOffset(R.f.NormalIconSize));
        localObject = a(localContext, (b)paramList.get(i * 3 + j));
        if (j != 0) {
          localLayoutParams.leftMargin = localContext.getResources().getDimensionPixelOffset(R.f.Edge_1_5_A);
        }
        localLinearLayout.addView((View)localObject, localLayoutParams);
        j += 1;
      }
      i += 1;
    }
    this.adNg.addView(localLinearLayout);
    localLinearLayout = new LinearLayout(localContext);
    int j = 0;
    while (j < paramList.size() - i * 3)
    {
      localObject = (b)paramList.get(i * 3 + j);
      localLinearLayout.setOrientation(0);
      localLayoutParams = new LinearLayout.LayoutParams(-2, localContext.getResources().getDimensionPixelOffset(R.f.NormalIconSize));
      localObject = a(localContext, (b)localObject);
      if (j != 0) {
        localLayoutParams.leftMargin = localContext.getResources().getDimensionPixelOffset(R.f.Edge_1_5_A);
      }
      localLinearLayout.addView((View)localObject, localLayoutParams);
      j += 1;
    }
    this.adNg.addView(localLinearLayout);
    AppMethodBeat.o(249670);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(249693);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(249674);
          b.this.dismiss();
          AppMethodBeat.o(249674);
        }
      });
      Log.e("MicroMsg.AppBrandNoticeMoreDialog", Util.getStack().toString());
      AppMethodBeat.o(249693);
      return;
    }
    try
    {
      super.dismiss();
      AppMethodBeat.o(249693);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.AppBrandNoticeMoreDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(249693);
    }
  }
  
  public final void lc(View paramView)
  {
    AppMethodBeat.i(249692);
    Context localContext = paramView.getContext();
    Point localPoint = aw.bf(localContext);
    int i;
    Window localWindow;
    WindowManager.LayoutParams localLayoutParams;
    int[] arrayOfInt;
    int j;
    int k;
    int m;
    if (this.mMode == 0)
    {
      i = com.tencent.mm.cd.a.bs(localContext, R.f.flx) + com.tencent.mm.cd.a.bs(localContext, R.f.flv) + com.tencent.mm.cd.a.bs(localContext, R.f.flu);
      localWindow = getWindow();
      if (localWindow != null)
      {
        localLayoutParams = localWindow.getAttributes();
        localLayoutParams.gravity = 8388661;
        localLayoutParams.verticalMargin = 0.0F;
        localLayoutParams.horizontalMargin = 0.0F;
        arrayOfInt = new int[2];
        paramView.getLocationOnScreen(arrayOfInt);
        localLayoutParams.x = (localPoint.x - arrayOfInt[0] - paramView.getMeasuredWidth() / 2 - com.tencent.mm.cd.a.bs(localContext, R.f.flt) - com.tencent.mm.cd.a.bs(localContext, R.f.flv) / 2);
        j = aw.mL(localContext);
        k = com.tencent.mm.cd.a.bs(localContext, R.f.fly);
        m = com.tencent.mm.cd.a.bs(localContext, R.f.flw);
        if (arrayOfInt[1] + paramView.getMeasuredHeight() + i + k - m <= localPoint.y - aw.bk(localContext)) {
          break label293;
        }
        localLayoutParams.y = (arrayOfInt[1] - j - i - k + m);
        Lx(false);
      }
    }
    for (;;)
    {
      localWindow.setAttributes(localLayoutParams);
      try
      {
        super.show();
        AppMethodBeat.o(249692);
        return;
      }
      catch (Exception paramView)
      {
        Log.printErrStackTrace("MicroMsg.AppBrandNoticeMoreDialog", paramView, "", new Object[0]);
        AppMethodBeat.o(249692);
      }
      j = com.tencent.mm.cd.a.bs(localContext, R.f.flz) + com.tencent.mm.cd.a.bs(localContext, R.f.flv) + com.tencent.mm.cd.a.bs(localContext, R.f.flu);
      i = j;
      if (this.tYg) {
        break;
      }
      i = j - com.tencent.mm.cd.a.bs(localContext, R.f.flA);
      break;
      label293:
      localLayoutParams.y = (arrayOfInt[1] - j + paramView.getMeasuredHeight() + k - m);
      Lx(true);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(249688);
    super.onCreate(paramBundle);
    setContentView(this.acrm);
    AppMethodBeat.o(249688);
  }
  
  public static abstract interface a
  {
    public abstract void esm();
    
    public abstract void jlN();
    
    public abstract void jlO();
    
    public abstract void jlP();
  }
  
  public final class b
  {
    public int adNp;
    public String displayName;
    public boolean wwJ;
    
    public b(int paramInt, String paramString)
    {
      this.adNp = paramInt;
      this.displayName = paramString;
      this.wwJ = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.b
 * JD-Core Version:    0.7.0.1
 */