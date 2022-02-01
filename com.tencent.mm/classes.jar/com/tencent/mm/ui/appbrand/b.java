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
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.voip.ui.MMCheckBox;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.y;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends i
  implements DialogInterface
{
  private LinearLayout ERU;
  private ImageView FTA;
  private ImageView FTB;
  private Button FTC;
  private ViewGroup FTD;
  private TextView FTE;
  private TextView FTF;
  private TextView FTG;
  private TextView FTH;
  public List<b> FTI;
  public a FTJ;
  CompoundButton.OnCheckedChangeListener FTK;
  private int FTz;
  private String kGt;
  private boolean lyh;
  private int mMode;
  private TextView oiW;
  private View.OnClickListener pgj;
  
  public b(Context paramContext, int paramInt, String paramString)
  {
    super(paramContext, 2131821484);
    AppMethodBeat.i(191416);
    this.FTI = new ArrayList();
    this.pgj = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191413);
        int i = paramAnonymousView.getId();
        if (b.a(b.this) != null)
        {
          if (i == 2131297999)
          {
            b.a(b.this).eSh();
            AppMethodBeat.o(191413);
            return;
          }
          if ((i == 2131297989) || (i == 2131297994))
          {
            b.a(b.this).eSi();
            AppMethodBeat.o(191413);
            return;
          }
          if ((i == 2131297990) || (i == 2131297995))
          {
            b.a(b.this).eSj();
            AppMethodBeat.o(191413);
            return;
          }
          if (i == 2131297996) {
            b.a(b.this).eSk();
          }
        }
        AppMethodBeat.o(191413);
      }
    };
    this.FTK = new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(191414);
        ((b.b)paramAnonymousCompoundButton.getTag()).nvF = paramAnonymousBoolean;
        if (paramAnonymousBoolean) {
          b.b(b.this);
        }
        for (;;)
        {
          b.d(b.this);
          AppMethodBeat.o(191414);
          return;
          b.c(b.this);
        }
      }
    };
    this.mMode = paramInt;
    this.kGt = paramString;
    this.FTz = 0;
    if (!bt.isNullOrNil(paramString))
    {
      if ((aV(paramString, 0)) || (aV(paramString, 1)) || (aV(paramString, 2))) {
        bool = true;
      }
      this.lyh = bool;
    }
    this.ERU = ((LinearLayout)y.js(paramContext).inflate(2131493389, null));
    this.FTA = ((ImageView)this.ERU.findViewById(2131297988));
    this.FTA.setColorFilter(paramContext.getResources().getColor(2131099650));
    this.FTB = ((ImageView)this.ERU.findViewById(2131297987));
    this.FTB.setColorFilter(paramContext.getResources().getColor(2131099650));
    setCanceledOnTouchOutside(true);
    if (this.mMode == 0)
    {
      ((ViewStub)this.ERU.findViewById(2131297993)).inflate();
      this.FTC = ((Button)this.ERU.findViewById(2131297999));
      this.FTD = ((ViewGroup)this.ERU.findViewById(2131297992));
      this.FTE = ((TextView)this.ERU.findViewById(2131297989));
      this.oiW = ((TextView)this.ERU.findViewById(2131297990));
      this.FTC.setOnClickListener(this.pgj);
      this.FTE.setOnClickListener(this.pgj);
      this.oiW.setOnClickListener(this.pgj);
      paramContext = new ArrayList();
      paramString = this.ERU.getContext();
      paramContext.add(new b(1, paramString.getString(2131757121)));
      paramContext.add(new b(2, paramString.getString(2131757120)));
      paramContext.add(new b(3, paramString.getString(2131757122)));
      hq(paramContext);
      AppMethodBeat.o(191416);
      return;
    }
    ((ViewStub)this.ERU.findViewById(2131297997)).inflate();
    this.FTF = ((TextView)this.ERU.findViewById(2131297996));
    this.FTG = ((TextView)this.ERU.findViewById(2131297994));
    this.FTH = ((TextView)this.ERU.findViewById(2131297995));
    if (this.lyh) {
      this.FTF.setOnClickListener(this.pgj);
    }
    for (;;)
    {
      this.FTG.setOnClickListener(this.pgj);
      this.FTH.setOnClickListener(this.pgj);
      AppMethodBeat.o(191416);
      return;
      this.FTF.setVisibility(8);
    }
  }
  
  private MMCheckBox a(Context paramContext, b paramb)
  {
    AppMethodBeat.i(191419);
    MMCheckBox localMMCheckBox = new MMCheckBox(new ContextThemeWrapper(paramContext, 2131820561), null, 2131820561);
    localMMCheckBox.setText(paramb.fyo);
    localMMCheckBox.setTag(paramb);
    localMMCheckBox.setTextSize(0, a.ao(paramContext, 2131165569));
    localMMCheckBox.setOnCheckedChangeListener(this.FTK);
    AppMethodBeat.o(191419);
    return localMMCheckBox;
  }
  
  private static boolean aV(String paramString, int paramInt)
  {
    AppMethodBeat.i(191422);
    boolean bool = ((ah)g.ab(ah.class)).aR(paramString, paramInt);
    AppMethodBeat.o(191422);
    return bool;
  }
  
  private void hq(List<b> paramList)
  {
    AppMethodBeat.i(191418);
    if (paramList.isEmpty())
    {
      ad.i("MicroMsg.AppBrandNoticeMoreDialog", "has no reason data");
      AppMethodBeat.o(191418);
      return;
    }
    this.FTI.clear();
    this.FTI.addAll(paramList);
    Context localContext = this.ERU.getContext();
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
    this.FTD.addView(localLinearLayout);
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
    this.FTD.addView(localLinearLayout);
    AppMethodBeat.o(191418);
  }
  
  private void vI(boolean paramBoolean)
  {
    AppMethodBeat.i(191420);
    if (paramBoolean)
    {
      this.FTA.setVisibility(0);
      this.FTB.setVisibility(8);
      AppMethodBeat.o(191420);
      return;
    }
    this.FTA.setVisibility(8);
    this.FTB.setVisibility(0);
    AppMethodBeat.o(191420);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(191423);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(191415);
          b.this.dismiss();
          AppMethodBeat.o(191415);
        }
      });
      ad.e("MicroMsg.AppBrandNoticeMoreDialog", bt.eGN().toString());
      AppMethodBeat.o(191423);
      return;
    }
    try
    {
      super.dismiss();
      AppMethodBeat.o(191423);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.AppBrandNoticeMoreDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(191423);
    }
  }
  
  public final void fC(View paramView)
  {
    AppMethodBeat.i(191421);
    Context localContext = paramView.getContext();
    Point localPoint = ai.cf(localContext);
    int i;
    Window localWindow;
    WindowManager.LayoutParams localLayoutParams;
    int[] arrayOfInt;
    int j;
    int k;
    int m;
    if (this.mMode == 0)
    {
      i = a.ap(localContext, 2131166013) + a.ap(localContext, 2131166009) + a.ap(localContext, 2131166008);
      localWindow = getWindow();
      if (localWindow != null)
      {
        localLayoutParams = localWindow.getAttributes();
        localLayoutParams.gravity = 8388661;
        localLayoutParams.verticalMargin = 0.0F;
        localLayoutParams.horizontalMargin = 0.0F;
        arrayOfInt = new int[2];
        paramView.getLocationOnScreen(arrayOfInt);
        localLayoutParams.x = (localPoint.x - arrayOfInt[0] - paramView.getMeasuredWidth() / 2 - a.ap(localContext, 2131166007) - a.ap(localContext, 2131166009) / 2);
        j = ai.jl(localContext);
        k = a.ap(localContext, 2131166015);
        m = a.ap(localContext, 2131166010);
        if (arrayOfInt[1] + paramView.getMeasuredHeight() + i + k - m <= localPoint.y - ai.eb(localContext)) {
          break label293;
        }
        localLayoutParams.y = (arrayOfInt[1] - j - i - k + m);
        vI(false);
      }
    }
    for (;;)
    {
      localWindow.setAttributes(localLayoutParams);
      try
      {
        super.show();
        AppMethodBeat.o(191421);
        return;
      }
      catch (Exception paramView)
      {
        ad.printErrStackTrace("MicroMsg.AppBrandNoticeMoreDialog", paramView, "", new Object[0]);
        AppMethodBeat.o(191421);
      }
      j = a.ap(localContext, 2131166016) + a.ap(localContext, 2131166009) + a.ap(localContext, 2131166008);
      i = j;
      if (this.lyh) {
        break;
      }
      i = j - a.ap(localContext, 2131167029);
      break;
      label293:
      localLayoutParams.y = (arrayOfInt[1] - j + paramView.getMeasuredHeight() + k - m);
      vI(true);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(191417);
    super.onCreate(paramBundle);
    setContentView(this.ERU);
    AppMethodBeat.o(191417);
  }
  
  public static abstract interface a
  {
    public abstract void eSh();
    
    public abstract void eSi();
    
    public abstract void eSj();
    
    public abstract void eSk();
  }
  
  public final class b
  {
    public int FTM;
    public String fyo;
    public boolean nvF;
    
    public b(int paramInt, String paramString)
    {
      this.FTM = paramInt;
      this.fyo = paramString;
      this.nvF = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.b
 * JD-Core Version:    0.7.0.1
 */