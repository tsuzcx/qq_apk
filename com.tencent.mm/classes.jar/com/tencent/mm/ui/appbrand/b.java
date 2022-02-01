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
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.voip.ui.MMCheckBox;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.i;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends i
  implements DialogInterface
{
  private LinearLayout UWb;
  private int Wgg;
  private ImageView Wgh;
  private ImageView Wgi;
  private Button Wgj;
  private ViewGroup Wgk;
  private TextView Wgl;
  private TextView Wgm;
  private TextView Wgn;
  private TextView Wgo;
  public List<b> Wgp;
  public a Wgq;
  CompoundButton.OnCheckedChangeListener Wgr;
  private View.OnClickListener kte;
  private int mMode;
  private String pRV;
  private boolean qTp;
  private TextView unn;
  
  public b(Context paramContext, int paramInt, String paramString)
  {
    super(paramContext, R.m.TopstoryFeedbackDialog);
    AppMethodBeat.i(279393);
    this.Wgp = new ArrayList();
    this.kte = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(288876);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/appbrand/AppBrandNoticeMoreDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        int i = paramAnonymousView.getId();
        if (b.a(b.this) != null)
        {
          if (i != R.h.dvN) {
            break label86;
          }
          b.a(b.this).hJj();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/appbrand/AppBrandNoticeMoreDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(288876);
          return;
          label86:
          if ((i == R.h.dvE) || (i == R.h.dvJ)) {
            b.a(b.this).hJk();
          } else if ((i == R.h.dvF) || (i == R.h.dvK)) {
            b.a(b.this).hJl();
          } else if (i == R.h.dvL) {
            b.a(b.this).hJm();
          }
        }
      }
    };
    this.Wgr = new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(271544);
        ((b.b)paramAnonymousCompoundButton.getTag()).tsm = paramAnonymousBoolean;
        if (paramAnonymousBoolean) {
          b.b(b.this);
        }
        for (;;)
        {
          b.d(b.this);
          AppMethodBeat.o(271544);
          return;
          b.c(b.this);
        }
      }
    };
    this.mMode = paramInt;
    this.pRV = paramString;
    this.Wgg = 0;
    if (!Util.isNullOrNil(paramString))
    {
      if ((bC(paramString, 0)) || (bC(paramString, 1)) || (bC(paramString, 2))) {
        bool = true;
      }
      this.qTp = bool;
    }
    this.UWb = ((LinearLayout)ad.kS(paramContext).inflate(R.i.ecl, null));
    this.Wgh = ((ImageView)this.UWb.findViewById(R.h.dvD));
    this.Wgh.setColorFilter(paramContext.getResources().getColor(R.e.BG_2));
    this.Wgi = ((ImageView)this.UWb.findViewById(R.h.dvC));
    this.Wgi.setColorFilter(paramContext.getResources().getColor(R.e.BG_2));
    setCanceledOnTouchOutside(true);
    if (this.mMode == 0)
    {
      ((ViewStub)this.UWb.findViewById(R.h.dvI)).inflate();
      this.Wgj = ((Button)this.UWb.findViewById(R.h.dvN));
      this.Wgk = ((ViewGroup)this.UWb.findViewById(R.h.dvH));
      this.Wgl = ((TextView)this.UWb.findViewById(R.h.dvE));
      this.unn = ((TextView)this.UWb.findViewById(R.h.dvF));
      this.Wgj.setOnClickListener(this.kte);
      this.Wgl.setOnClickListener(this.kte);
      this.unn.setOnClickListener(this.kte);
      paramContext = new ArrayList();
      paramString = this.UWb.getContext();
      paramContext.add(new b(1, paramString.getString(R.l.eup)));
      paramContext.add(new b(2, paramString.getString(R.l.euo)));
      paramContext.add(new b(3, paramString.getString(R.l.euq)));
      jV(paramContext);
      AppMethodBeat.o(279393);
      return;
    }
    ((ViewStub)this.UWb.findViewById(R.h.dvM)).inflate();
    this.Wgm = ((TextView)this.UWb.findViewById(R.h.dvL));
    this.Wgn = ((TextView)this.UWb.findViewById(R.h.dvJ));
    this.Wgo = ((TextView)this.UWb.findViewById(R.h.dvK));
    if (this.qTp) {
      this.Wgm.setOnClickListener(this.kte);
    }
    for (;;)
    {
      this.Wgn.setOnClickListener(this.kte);
      this.Wgo.setOnClickListener(this.kte);
      AppMethodBeat.o(279393);
      return;
      this.Wgm.setVisibility(8);
    }
  }
  
  private void FL(boolean paramBoolean)
  {
    AppMethodBeat.i(279397);
    if (paramBoolean)
    {
      this.Wgh.setVisibility(0);
      this.Wgi.setVisibility(8);
      AppMethodBeat.o(279397);
      return;
    }
    this.Wgh.setVisibility(8);
    this.Wgi.setVisibility(0);
    AppMethodBeat.o(279397);
  }
  
  private MMCheckBox a(Context paramContext, b paramb)
  {
    AppMethodBeat.i(279396);
    MMCheckBox localMMCheckBox = new MMCheckBox(new ContextThemeWrapper(paramContext, R.m.eWe), null, R.m.eWe);
    localMMCheckBox.setText(paramb.jmB);
    localMMCheckBox.setTag(paramb);
    localMMCheckBox.setTextSize(0, com.tencent.mm.ci.a.aY(paramContext, R.f.SmallTextSize));
    localMMCheckBox.setOnCheckedChangeListener(this.Wgr);
    AppMethodBeat.o(279396);
    return localMMCheckBox;
  }
  
  private static boolean bC(String paramString, int paramInt)
  {
    AppMethodBeat.i(279401);
    boolean bool = ((ag)h.ae(ag.class)).by(paramString, paramInt);
    AppMethodBeat.o(279401);
    return bool;
  }
  
  private void jV(List<b> paramList)
  {
    AppMethodBeat.i(279395);
    if (paramList.isEmpty())
    {
      Log.i("MicroMsg.AppBrandNoticeMoreDialog", "has no reason data");
      AppMethodBeat.o(279395);
      return;
    }
    this.Wgp.clear();
    this.Wgp.addAll(paramList);
    Context localContext = this.UWb.getContext();
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
    this.Wgk.addView(localLinearLayout);
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
    this.Wgk.addView(localLinearLayout);
    AppMethodBeat.o(279395);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(279402);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(281907);
          b.this.dismiss();
          AppMethodBeat.o(281907);
        }
      });
      Log.e("MicroMsg.AppBrandNoticeMoreDialog", Util.getStack().toString());
      AppMethodBeat.o(279402);
      return;
    }
    try
    {
      super.dismiss();
      AppMethodBeat.o(279402);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.AppBrandNoticeMoreDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(279402);
    }
  }
  
  public final void hG(View paramView)
  {
    AppMethodBeat.i(279399);
    Context localContext = paramView.getContext();
    Point localPoint = ar.au(localContext);
    int i;
    Window localWindow;
    WindowManager.LayoutParams localLayoutParams;
    int[] arrayOfInt;
    int j;
    int k;
    int m;
    if (this.mMode == 0)
    {
      i = com.tencent.mm.ci.a.aZ(localContext, R.f.dlh) + com.tencent.mm.ci.a.aZ(localContext, R.f.dlf) + com.tencent.mm.ci.a.aZ(localContext, R.f.dle);
      localWindow = getWindow();
      if (localWindow != null)
      {
        localLayoutParams = localWindow.getAttributes();
        localLayoutParams.gravity = 8388661;
        localLayoutParams.verticalMargin = 0.0F;
        localLayoutParams.horizontalMargin = 0.0F;
        arrayOfInt = new int[2];
        paramView.getLocationOnScreen(arrayOfInt);
        localLayoutParams.x = (localPoint.x - arrayOfInt[0] - paramView.getMeasuredWidth() / 2 - com.tencent.mm.ci.a.aZ(localContext, R.f.dld) - com.tencent.mm.ci.a.aZ(localContext, R.f.dlf) / 2);
        j = ar.kI(localContext);
        k = com.tencent.mm.ci.a.aZ(localContext, R.f.dli);
        m = com.tencent.mm.ci.a.aZ(localContext, R.f.dlg);
        if (arrayOfInt[1] + paramView.getMeasuredHeight() + i + k - m <= localPoint.y - ar.aB(localContext)) {
          break label293;
        }
        localLayoutParams.y = (arrayOfInt[1] - j - i - k + m);
        FL(false);
      }
    }
    for (;;)
    {
      localWindow.setAttributes(localLayoutParams);
      try
      {
        super.show();
        AppMethodBeat.o(279399);
        return;
      }
      catch (Exception paramView)
      {
        Log.printErrStackTrace("MicroMsg.AppBrandNoticeMoreDialog", paramView, "", new Object[0]);
        AppMethodBeat.o(279399);
      }
      j = com.tencent.mm.ci.a.aZ(localContext, R.f.dlj) + com.tencent.mm.ci.a.aZ(localContext, R.f.dlf) + com.tencent.mm.ci.a.aZ(localContext, R.f.dle);
      i = j;
      if (this.qTp) {
        break;
      }
      i = j - com.tencent.mm.ci.a.aZ(localContext, R.f.dlk);
      break;
      label293:
      localLayoutParams.y = (arrayOfInt[1] - j + paramView.getMeasuredHeight() + k - m);
      FL(true);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(279394);
    super.onCreate(paramBundle);
    setContentView(this.UWb);
    AppMethodBeat.o(279394);
  }
  
  public static abstract interface a
  {
    public abstract void hJj();
    
    public abstract void hJk();
    
    public abstract void hJl();
    
    public abstract void hJm();
  }
  
  public final class b
  {
    public int Wgt;
    public String jmB;
    public boolean tsm;
    
    public b(int paramInt, String paramString)
    {
      this.Wgt = paramInt;
      this.jmB = paramString;
      this.tsm = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.b
 * JD-Core Version:    0.7.0.1
 */