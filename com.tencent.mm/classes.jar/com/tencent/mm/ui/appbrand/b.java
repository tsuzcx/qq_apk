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
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.voip.ui.MMCheckBox;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.i;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends i
  implements DialogInterface
{
  private LinearLayout NIA;
  private int OMH;
  private ImageView OMI;
  private ImageView OMJ;
  private Button OMK;
  private ViewGroup OML;
  private TextView OMM;
  private TextView OMN;
  private TextView OMO;
  private TextView OMP;
  public List<b> OMQ;
  public a OMR;
  CompoundButton.OnCheckedChangeListener OMS;
  private View.OnClickListener hEZ;
  private int mMode;
  private String mRa;
  private boolean nRM;
  private TextView qMb;
  
  public b(Context paramContext, int paramInt, String paramString)
  {
    super(paramContext, 2131821530);
    AppMethodBeat.i(232742);
    this.OMQ = new ArrayList();
    this.hEZ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(232739);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/appbrand/AppBrandNoticeMoreDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        int i = paramAnonymousView.getId();
        if (b.a(b.this) != null)
        {
          if (i != 2131298339) {
            break label85;
          }
          b.a(b.this).gKh();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/appbrand/AppBrandNoticeMoreDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(232739);
          return;
          label85:
          if ((i == 2131298329) || (i == 2131298334)) {
            b.a(b.this).gKi();
          } else if ((i == 2131298330) || (i == 2131298335)) {
            b.a(b.this).gKj();
          } else if (i == 2131298336) {
            b.a(b.this).gKk();
          }
        }
      }
    };
    this.OMS = new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(232740);
        ((b.b)paramAnonymousCompoundButton.getTag()).pWp = paramAnonymousBoolean;
        if (paramAnonymousBoolean) {
          b.b(b.this);
        }
        for (;;)
        {
          b.d(b.this);
          AppMethodBeat.o(232740);
          return;
          b.c(b.this);
        }
      }
    };
    this.mMode = paramInt;
    this.mRa = paramString;
    this.OMH = 0;
    if (!Util.isNullOrNil(paramString))
    {
      if ((bj(paramString, 0)) || (bj(paramString, 1)) || (bj(paramString, 2))) {
        bool = true;
      }
      this.nRM = bool;
    }
    this.NIA = ((LinearLayout)aa.jQ(paramContext).inflate(2131493483, null));
    this.OMI = ((ImageView)this.NIA.findViewById(2131298328));
    this.OMI.setColorFilter(paramContext.getResources().getColor(2131099650));
    this.OMJ = ((ImageView)this.NIA.findViewById(2131298327));
    this.OMJ.setColorFilter(paramContext.getResources().getColor(2131099650));
    setCanceledOnTouchOutside(true);
    if (this.mMode == 0)
    {
      ((ViewStub)this.NIA.findViewById(2131298333)).inflate();
      this.OMK = ((Button)this.NIA.findViewById(2131298339));
      this.OML = ((ViewGroup)this.NIA.findViewById(2131298332));
      this.OMM = ((TextView)this.NIA.findViewById(2131298329));
      this.qMb = ((TextView)this.NIA.findViewById(2131298330));
      this.OMK.setOnClickListener(this.hEZ);
      this.OMM.setOnClickListener(this.hEZ);
      this.qMb.setOnClickListener(this.hEZ);
      paramContext = new ArrayList();
      paramString = this.NIA.getContext();
      paramContext.add(new b(1, paramString.getString(2131757325)));
      paramContext.add(new b(2, paramString.getString(2131757324)));
      paramContext.add(new b(3, paramString.getString(2131757326)));
      jd(paramContext);
      AppMethodBeat.o(232742);
      return;
    }
    ((ViewStub)this.NIA.findViewById(2131298337)).inflate();
    this.OMN = ((TextView)this.NIA.findViewById(2131298336));
    this.OMO = ((TextView)this.NIA.findViewById(2131298334));
    this.OMP = ((TextView)this.NIA.findViewById(2131298335));
    if (this.nRM) {
      this.OMN.setOnClickListener(this.hEZ);
    }
    for (;;)
    {
      this.OMO.setOnClickListener(this.hEZ);
      this.OMP.setOnClickListener(this.hEZ);
      AppMethodBeat.o(232742);
      return;
      this.OMN.setVisibility(8);
    }
  }
  
  private void Bt(boolean paramBoolean)
  {
    AppMethodBeat.i(232746);
    if (paramBoolean)
    {
      this.OMI.setVisibility(0);
      this.OMJ.setVisibility(8);
      AppMethodBeat.o(232746);
      return;
    }
    this.OMI.setVisibility(8);
    this.OMJ.setVisibility(0);
    AppMethodBeat.o(232746);
  }
  
  private MMCheckBox a(Context paramContext, b paramb)
  {
    AppMethodBeat.i(232745);
    MMCheckBox localMMCheckBox = new MMCheckBox(new ContextThemeWrapper(paramContext, 2131820562), null, 2131820562);
    localMMCheckBox.setText(paramb.gCv);
    localMMCheckBox.setTag(paramb);
    localMMCheckBox.setTextSize(0, com.tencent.mm.cb.a.aG(paramContext, 2131165587));
    localMMCheckBox.setOnCheckedChangeListener(this.OMS);
    AppMethodBeat.o(232745);
    return localMMCheckBox;
  }
  
  private static boolean bj(String paramString, int paramInt)
  {
    AppMethodBeat.i(232748);
    boolean bool = ((ag)g.af(ag.class)).bf(paramString, paramInt);
    AppMethodBeat.o(232748);
    return bool;
  }
  
  private void jd(List<b> paramList)
  {
    AppMethodBeat.i(232744);
    if (paramList.isEmpty())
    {
      Log.i("MicroMsg.AppBrandNoticeMoreDialog", "has no reason data");
      AppMethodBeat.o(232744);
      return;
    }
    this.OMQ.clear();
    this.OMQ.addAll(paramList);
    Context localContext = this.NIA.getContext();
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
        localLayoutParams = new LinearLayout.LayoutParams(-2, localContext.getResources().getDimensionPixelOffset(2131165532));
        localObject = a(localContext, (b)paramList.get(i * 3 + j));
        if (j != 0) {
          localLayoutParams.leftMargin = localContext.getResources().getDimensionPixelOffset(2131165289);
        }
        localLinearLayout.addView((View)localObject, localLayoutParams);
        j += 1;
      }
      i += 1;
    }
    this.OML.addView(localLinearLayout);
    localLinearLayout = new LinearLayout(localContext);
    int j = 0;
    while (j < paramList.size() - i * 3)
    {
      localObject = (b)paramList.get(i * 3 + j);
      localLinearLayout.setOrientation(0);
      localLayoutParams = new LinearLayout.LayoutParams(-2, localContext.getResources().getDimensionPixelOffset(2131165532));
      localObject = a(localContext, (b)localObject);
      if (j != 0) {
        localLayoutParams.leftMargin = localContext.getResources().getDimensionPixelOffset(2131165289);
      }
      localLinearLayout.addView((View)localObject, localLayoutParams);
      j += 1;
    }
    this.OML.addView(localLinearLayout);
    AppMethodBeat.o(232744);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(232749);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(232741);
          b.this.dismiss();
          AppMethodBeat.o(232741);
        }
      });
      Log.e("MicroMsg.AppBrandNoticeMoreDialog", Util.getStack().toString());
      AppMethodBeat.o(232749);
      return;
    }
    try
    {
      super.dismiss();
      AppMethodBeat.o(232749);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.AppBrandNoticeMoreDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(232749);
    }
  }
  
  public final void gv(View paramView)
  {
    AppMethodBeat.i(232747);
    Context localContext = paramView.getContext();
    Point localPoint = ao.az(localContext);
    int i;
    Window localWindow;
    WindowManager.LayoutParams localLayoutParams;
    int[] arrayOfInt;
    int j;
    int k;
    int m;
    if (this.mMode == 0)
    {
      i = com.tencent.mm.cb.a.aH(localContext, 2131166045) + com.tencent.mm.cb.a.aH(localContext, 2131166041) + com.tencent.mm.cb.a.aH(localContext, 2131166040);
      localWindow = getWindow();
      if (localWindow != null)
      {
        localLayoutParams = localWindow.getAttributes();
        localLayoutParams.gravity = 8388661;
        localLayoutParams.verticalMargin = 0.0F;
        localLayoutParams.horizontalMargin = 0.0F;
        arrayOfInt = new int[2];
        paramView.getLocationOnScreen(arrayOfInt);
        localLayoutParams.x = (localPoint.x - arrayOfInt[0] - paramView.getMeasuredWidth() / 2 - com.tencent.mm.cb.a.aH(localContext, 2131166039) - com.tencent.mm.cb.a.aH(localContext, 2131166041) / 2);
        j = ao.jJ(localContext);
        k = com.tencent.mm.cb.a.aH(localContext, 2131166047);
        m = com.tencent.mm.cb.a.aH(localContext, 2131166042);
        if (arrayOfInt[1] + paramView.getMeasuredHeight() + i + k - m <= localPoint.y - ao.aD(localContext)) {
          break label293;
        }
        localLayoutParams.y = (arrayOfInt[1] - j - i - k + m);
        Bt(false);
      }
    }
    for (;;)
    {
      localWindow.setAttributes(localLayoutParams);
      try
      {
        super.show();
        AppMethodBeat.o(232747);
        return;
      }
      catch (Exception paramView)
      {
        Log.printErrStackTrace("MicroMsg.AppBrandNoticeMoreDialog", paramView, "", new Object[0]);
        AppMethodBeat.o(232747);
      }
      j = com.tencent.mm.cb.a.aH(localContext, 2131166048) + com.tencent.mm.cb.a.aH(localContext, 2131166041) + com.tencent.mm.cb.a.aH(localContext, 2131166040);
      i = j;
      if (this.nRM) {
        break;
      }
      i = j - com.tencent.mm.cb.a.aH(localContext, 2131166050);
      break;
      label293:
      localLayoutParams.y = (arrayOfInt[1] - j + paramView.getMeasuredHeight() + k - m);
      Bt(true);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(232743);
    super.onCreate(paramBundle);
    setContentView(this.NIA);
    AppMethodBeat.o(232743);
  }
  
  public static abstract interface a
  {
    public abstract void gKh();
    
    public abstract void gKi();
    
    public abstract void gKj();
    
    public abstract void gKk();
  }
  
  public final class b
  {
    public int OMU;
    public String gCv;
    public boolean pWp;
    
    public b(int paramInt, String paramString)
    {
      this.OMU = paramInt;
      this.gCv = paramString;
      this.pWp = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.b
 * JD-Core Version:    0.7.0.1
 */