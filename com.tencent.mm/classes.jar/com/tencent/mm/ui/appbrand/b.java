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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.z;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends i
  implements DialogInterface
{
  private LinearLayout Ivb;
  private int JBP;
  private ImageView JBQ;
  private ImageView JBR;
  private Button JBS;
  private ViewGroup JBT;
  private TextView JBU;
  private TextView JBV;
  private TextView JBW;
  private TextView JBX;
  public List<b> JBY;
  public a JBZ;
  CompoundButton.OnCheckedChangeListener JCa;
  private View.OnClickListener gON;
  private String lJm;
  private boolean mEW;
  private int mMode;
  private TextView pwK;
  
  public b(Context paramContext, int paramInt, String paramString)
  {
    super(paramContext, 2131821484);
    AppMethodBeat.i(187058);
    this.JBY = new ArrayList();
    this.gON = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187055);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/appbrand/AppBrandNoticeMoreDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        int i = paramAnonymousView.getId();
        if (b.a(b.this) != null)
        {
          if (i != 2131297999) {
            break label85;
          }
          b.a(b.this).fCj();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/appbrand/AppBrandNoticeMoreDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(187055);
          return;
          label85:
          if ((i == 2131297989) || (i == 2131297994)) {
            b.a(b.this).fCk();
          } else if ((i == 2131297990) || (i == 2131297995)) {
            b.a(b.this).fCl();
          } else if (i == 2131297996) {
            b.a(b.this).fCm();
          }
        }
      }
    };
    this.JCa = new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(187056);
        ((b.b)paramAnonymousCompoundButton.getTag()).oIB = paramAnonymousBoolean;
        if (paramAnonymousBoolean) {
          b.b(b.this);
        }
        for (;;)
        {
          b.d(b.this);
          AppMethodBeat.o(187056);
          return;
          b.c(b.this);
        }
      }
    };
    this.mMode = paramInt;
    this.lJm = paramString;
    this.JBP = 0;
    if (!bu.isNullOrNil(paramString))
    {
      if ((be(paramString, 0)) || (be(paramString, 1)) || (be(paramString, 2))) {
        bool = true;
      }
      this.mEW = bool;
    }
    this.Ivb = ((LinearLayout)z.jV(paramContext).inflate(2131493389, null));
    this.JBQ = ((ImageView)this.Ivb.findViewById(2131297988));
    this.JBQ.setColorFilter(paramContext.getResources().getColor(2131099650));
    this.JBR = ((ImageView)this.Ivb.findViewById(2131297987));
    this.JBR.setColorFilter(paramContext.getResources().getColor(2131099650));
    setCanceledOnTouchOutside(true);
    if (this.mMode == 0)
    {
      ((ViewStub)this.Ivb.findViewById(2131297993)).inflate();
      this.JBS = ((Button)this.Ivb.findViewById(2131297999));
      this.JBT = ((ViewGroup)this.Ivb.findViewById(2131297992));
      this.JBU = ((TextView)this.Ivb.findViewById(2131297989));
      this.pwK = ((TextView)this.Ivb.findViewById(2131297990));
      this.JBS.setOnClickListener(this.gON);
      this.JBU.setOnClickListener(this.gON);
      this.pwK.setOnClickListener(this.gON);
      paramContext = new ArrayList();
      paramString = this.Ivb.getContext();
      paramContext.add(new b(1, paramString.getString(2131757121)));
      paramContext.add(new b(2, paramString.getString(2131757120)));
      paramContext.add(new b(3, paramString.getString(2131757122)));
      hZ(paramContext);
      AppMethodBeat.o(187058);
      return;
    }
    ((ViewStub)this.Ivb.findViewById(2131297997)).inflate();
    this.JBV = ((TextView)this.Ivb.findViewById(2131297996));
    this.JBW = ((TextView)this.Ivb.findViewById(2131297994));
    this.JBX = ((TextView)this.Ivb.findViewById(2131297995));
    if (this.mEW) {
      this.JBV.setOnClickListener(this.gON);
    }
    for (;;)
    {
      this.JBW.setOnClickListener(this.gON);
      this.JBX.setOnClickListener(this.gON);
      AppMethodBeat.o(187058);
      return;
      this.JBV.setVisibility(8);
    }
  }
  
  private MMCheckBox a(Context paramContext, b paramb)
  {
    AppMethodBeat.i(187061);
    MMCheckBox localMMCheckBox = new MMCheckBox(new ContextThemeWrapper(paramContext, 2131820561), null, 2131820561);
    localMMCheckBox.setText(paramb.fXp);
    localMMCheckBox.setTag(paramb);
    localMMCheckBox.setTextSize(0, com.tencent.mm.cb.a.ax(paramContext, 2131165569));
    localMMCheckBox.setOnCheckedChangeListener(this.JCa);
    AppMethodBeat.o(187061);
    return localMMCheckBox;
  }
  
  private static boolean be(String paramString, int paramInt)
  {
    AppMethodBeat.i(187064);
    boolean bool = ((ah)g.ab(ah.class)).ba(paramString, paramInt);
    AppMethodBeat.o(187064);
    return bool;
  }
  
  private void hZ(List<b> paramList)
  {
    AppMethodBeat.i(187060);
    if (paramList.isEmpty())
    {
      ae.i("MicroMsg.AppBrandNoticeMoreDialog", "has no reason data");
      AppMethodBeat.o(187060);
      return;
    }
    this.JBY.clear();
    this.JBY.addAll(paramList);
    Context localContext = this.Ivb.getContext();
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
    this.JBT.addView(localLinearLayout);
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
    this.JBT.addView(localLinearLayout);
    AppMethodBeat.o(187060);
  }
  
  private void xF(boolean paramBoolean)
  {
    AppMethodBeat.i(187062);
    if (paramBoolean)
    {
      this.JBQ.setVisibility(0);
      this.JBR.setVisibility(8);
      AppMethodBeat.o(187062);
      return;
    }
    this.JBQ.setVisibility(8);
    this.JBR.setVisibility(0);
    AppMethodBeat.o(187062);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(187065);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187057);
          b.this.dismiss();
          AppMethodBeat.o(187057);
        }
      });
      ae.e("MicroMsg.AppBrandNoticeMoreDialog", bu.fpN().toString());
      AppMethodBeat.o(187065);
      return;
    }
    try
    {
      super.dismiss();
      AppMethodBeat.o(187065);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.AppBrandNoticeMoreDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(187065);
    }
  }
  
  public final void gd(View paramView)
  {
    AppMethodBeat.i(187063);
    Context localContext = paramView.getContext();
    Point localPoint = al.ck(localContext);
    int i;
    Window localWindow;
    WindowManager.LayoutParams localLayoutParams;
    int[] arrayOfInt;
    int j;
    int k;
    int m;
    if (this.mMode == 0)
    {
      i = com.tencent.mm.cb.a.ay(localContext, 2131166013) + com.tencent.mm.cb.a.ay(localContext, 2131166009) + com.tencent.mm.cb.a.ay(localContext, 2131166008);
      localWindow = getWindow();
      if (localWindow != null)
      {
        localLayoutParams = localWindow.getAttributes();
        localLayoutParams.gravity = 8388661;
        localLayoutParams.verticalMargin = 0.0F;
        localLayoutParams.horizontalMargin = 0.0F;
        arrayOfInt = new int[2];
        paramView.getLocationOnScreen(arrayOfInt);
        localLayoutParams.x = (localPoint.x - arrayOfInt[0] - paramView.getMeasuredWidth() / 2 - com.tencent.mm.cb.a.ay(localContext, 2131166007) - com.tencent.mm.cb.a.ay(localContext, 2131166009) / 2);
        j = al.jO(localContext);
        k = com.tencent.mm.cb.a.ay(localContext, 2131166015);
        m = com.tencent.mm.cb.a.ay(localContext, 2131166010);
        if (arrayOfInt[1] + paramView.getMeasuredHeight() + i + k - m <= localPoint.y - al.en(localContext)) {
          break label293;
        }
        localLayoutParams.y = (arrayOfInt[1] - j - i - k + m);
        xF(false);
      }
    }
    for (;;)
    {
      localWindow.setAttributes(localLayoutParams);
      try
      {
        super.show();
        AppMethodBeat.o(187063);
        return;
      }
      catch (Exception paramView)
      {
        ae.printErrStackTrace("MicroMsg.AppBrandNoticeMoreDialog", paramView, "", new Object[0]);
        AppMethodBeat.o(187063);
      }
      j = com.tencent.mm.cb.a.ay(localContext, 2131166016) + com.tencent.mm.cb.a.ay(localContext, 2131166009) + com.tencent.mm.cb.a.ay(localContext, 2131166008);
      i = j;
      if (this.mEW) {
        break;
      }
      i = j - com.tencent.mm.cb.a.ay(localContext, 2131167029);
      break;
      label293:
      localLayoutParams.y = (arrayOfInt[1] - j + paramView.getMeasuredHeight() + k - m);
      xF(true);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(187059);
    super.onCreate(paramBundle);
    setContentView(this.Ivb);
    AppMethodBeat.o(187059);
  }
  
  public static abstract interface a
  {
    public abstract void fCj();
    
    public abstract void fCk();
    
    public abstract void fCl();
    
    public abstract void fCm();
  }
  
  public final class b
  {
    public int JCc;
    public String fXp;
    public boolean oIB;
    
    public b(int paramInt, String paramString)
    {
      this.JCc = paramInt;
      this.fXp = paramString;
      this.oIB = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.b
 * JD-Core Version:    0.7.0.1
 */