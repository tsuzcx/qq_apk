package com.tencent.mm.wallet_core.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.sa;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Stack;
import java.util.UUID;

public final class g
{
  private static sa agUT = null;
  private static int agUU;
  private static String agUV = "";
  private static Stack<String> agUW;
  private static String sessionId = "";
  
  public static void aGt(int paramInt)
  {
    AppMethodBeat.i(242199);
    ac(5, 1, "cgi_".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(242199);
  }
  
  public static void aGu(int paramInt)
  {
    AppMethodBeat.i(242201);
    ac(5, 2, "cgi_".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(242201);
  }
  
  private static String aGv(int paramInt)
  {
    AppMethodBeat.i(242220);
    switch (paramInt)
    {
    default: 
      Log.i("MicroMsg.WalletAutoReportUtil", "unknow type：%s", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(242220);
      return "UseCase";
    case 1: 
      AppMethodBeat.o(242220);
      return "UseCase";
    case 2: 
      AppMethodBeat.o(242220);
      return "UIPage";
    case 3: 
      AppMethodBeat.o(242220);
      return "View";
    case 4: 
      AppMethodBeat.o(242220);
      return "Dialog";
    case 5: 
      AppMethodBeat.o(242220);
      return "Cgi";
    }
    AppMethodBeat.o(242220);
    return "SystemEvent";
  }
  
  private static void ac(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(242205);
    k(paramInt1, paramInt2, paramString, "");
    AppMethodBeat.o(242205);
  }
  
  private static String bEH(String paramString)
  {
    AppMethodBeat.i(242212);
    String str = agUV;
    agUV = paramString;
    paramString = str + "/" + paramString;
    AppMethodBeat.o(242212);
    return paramString;
  }
  
  public static void bEI(String paramString)
  {
    AppMethodBeat.i(242214);
    Stack localStack = jPq();
    if (localStack.size() == 0)
    {
      sessionId = "";
      agUU = 0;
      agUT = null;
      agUW.clear();
      ac(1, 1, "[Begin]".concat(String.valueOf(paramString)));
    }
    localStack.push(paramString);
    ac(2, 1, paramString);
    AppMethodBeat.o(242214);
  }
  
  public static void bEJ(String paramString)
  {
    AppMethodBeat.i(242219);
    Stack localStack = jPq();
    if (localStack.size() > 0)
    {
      localStack.pop();
      ac(2, 2, paramString);
    }
    if (localStack.size() == 0)
    {
      ac(1, 2, "[End]".concat(String.valueOf(paramString)));
      localStack.clear();
    }
    AppMethodBeat.o(242219);
  }
  
  public static String getSessionId()
  {
    AppMethodBeat.i(242194);
    if (Util.isNullOrNil(sessionId)) {
      sessionId = UUID.randomUUID().toString();
    }
    String str = sessionId;
    AppMethodBeat.o(242194);
    return str;
  }
  
  private static sa jPp()
  {
    AppMethodBeat.i(242187);
    if (agUT == null) {
      agUT = new sa();
    }
    sa localsa = agUT;
    AppMethodBeat.o(242187);
    return localsa;
  }
  
  private static Stack<String> jPq()
  {
    AppMethodBeat.i(242190);
    if (agUW == null) {
      agUW = new Stack();
    }
    Stack localStack = agUW;
    AppMethodBeat.o(242190);
    return localStack;
  }
  
  private static boolean jPr()
  {
    AppMethodBeat.i(242222);
    boolean bool = ((c)h.ax(c.class)).a(c.a.yXd, false);
    Log.i("MicroMsg.WalletAutoReportUtil", " isOpenAutoReport ：%s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(242222);
    return bool;
  }
  
  private static void k(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(242208);
    if (!jPr())
    {
      AppMethodBeat.o(242208);
      return;
    }
    Object localObject = paramString1;
    if (!Util.isNullOrNil(paramString1))
    {
      String str = paramString1;
      if (paramString1.contains(",")) {
        str = paramString1.replaceAll(",", "+").trim();
      }
      localObject = str;
      if (str.contains("，")) {
        localObject = str.replaceAll("，", "+").trim();
      }
    }
    paramString1 = jPp();
    paramString1.jlE = paramInt1;
    paramString1.yM(getSessionId());
    paramString1.yN(bEH((String)localObject));
    paramString1.yO(String.valueOf(System.currentTimeMillis()));
    paramString1.jxe = paramInt2;
    paramString1.yP(paramString2);
    agUU += 1;
    paramString1.jxb = agUU;
    paramString1.bMH();
    paramString1 = new StringBuilder();
    paramString1.append("KindaNativeLog.type: ").append(aGv(paramInt1)).append("\nKindaNativeLog.sessionID: ").append(sessionId).append("\nKindaNativeLog.url: ").append((String)localObject).append("\nKindaNativeLog.action: ").append(pz(paramInt1, paramInt2)).append("\nKindaNativeLog.sequence: ").append(agUU).append("\nKindaNativeLog.ext: ").append(paramString2).append("\n");
    Log.i("MicroMsg.WalletAutoReportUtil", "KindaNativeLog reportString :%s", new Object[] { paramString1.toString() });
    AppMethodBeat.o(242208);
  }
  
  public static void mH(View paramView)
  {
    AppMethodBeat.i(242197);
    if (paramView == null)
    {
      AppMethodBeat.o(242197);
      return;
    }
    String str = "";
    if ((paramView instanceof Button)) {
      str = ((Button)paramView).getText().toString();
    }
    for (;;)
    {
      if (!Util.isNullOrNil(str)) {
        ac(3, 1, str);
      }
      AppMethodBeat.o(242197);
      return;
      if ((paramView instanceof TextView)) {
        str = ((TextView)paramView).getText().toString();
      } else if ((paramView instanceof ImageView)) {
        str = "ImageView";
      } else if ((paramView instanceof ViewGroup)) {
        str = mI(paramView).toString();
      }
    }
  }
  
  private static CharSequence mI(View paramView)
  {
    AppMethodBeat.i(242210);
    paramView = (ViewGroup)paramView;
    int i = 0;
    while (i < paramView.getChildCount())
    {
      Object localObject = paramView.getChildAt(i);
      if ((localObject instanceof ViewGroup))
      {
        localObject = mI((ViewGroup)localObject).toString();
        if (!Util.isNullOrNil((String)localObject))
        {
          AppMethodBeat.o(242210);
          return localObject;
        }
      }
      else if ((localObject instanceof TextView))
      {
        localObject = ((TextView)localObject).getText().toString();
        if (!Util.isNullOrNil((String)localObject))
        {
          AppMethodBeat.o(242210);
          return localObject;
        }
      }
      else if ((localObject instanceof Button))
      {
        localObject = ((Button)localObject).getText().toString();
        if (!Util.isNullOrNil((String)localObject))
        {
          AppMethodBeat.o(242210);
          return localObject;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(242210);
    return "";
  }
  
  private static String pz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(242221);
    switch (paramInt1)
    {
    default: 
      Log.i("MicroMsg.WalletAutoReportUtil", "unknow type：%s", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(242221);
      return "UseCase";
    case 1: 
      switch (paramInt2)
      {
      default: 
        Log.i("MicroMsg.WalletAutoReportUtil", "unknow action：%s", new Object[] { Integer.valueOf(paramInt2) });
        AppMethodBeat.o(242221);
        return "ClearedAllUseCase";
      case 1: 
        AppMethodBeat.o(242221);
        return "StartUseCase";
      case 2: 
        AppMethodBeat.o(242221);
        return "EndUseCase";
      }
      AppMethodBeat.o(242221);
      return "ClearedAllUseCase";
    case 2: 
      switch (paramInt2)
      {
      default: 
        Log.i("MicroMsg.WalletAutoReportUtil", "unknow action：%s", new Object[] { Integer.valueOf(paramInt2) });
        AppMethodBeat.o(242221);
        return "DimissUIPage";
      case 1: 
        AppMethodBeat.o(242221);
        return "ShowUIPage";
      }
      AppMethodBeat.o(242221);
      return "DimissUIPage";
    case 3: 
      switch (paramInt2)
      {
      default: 
        Log.i("MicroMsg.WalletAutoReportUtil", "unknow action：%s", new Object[] { Integer.valueOf(paramInt2) });
        AppMethodBeat.o(242221);
        return "ShowView";
      case 1: 
        AppMethodBeat.o(242221);
        return "ClicKView";
      }
      AppMethodBeat.o(242221);
      return "ShowView";
    case 4: 
      switch (paramInt2)
      {
      default: 
        Log.i("MicroMsg.WalletAutoReportUtil", "unknow action：%s", new Object[] { Integer.valueOf(paramInt2) });
        AppMethodBeat.o(242221);
        return "ClickDialogButton";
      case 1: 
        AppMethodBeat.o(242221);
        return "ShowDialog";
      }
      AppMethodBeat.o(242221);
      return "ClickDialogButton";
    case 5: 
      switch (paramInt2)
      {
      default: 
        Log.i("MicroMsg.WalletAutoReportUtil", "unknow action：%s", new Object[] { Integer.valueOf(paramInt2) });
        AppMethodBeat.o(242221);
        return "EndCgi";
      case 1: 
        AppMethodBeat.o(242221);
        return "StartCgi";
      }
      AppMethodBeat.o(242221);
      return "EndCgi";
    }
    switch (paramInt2)
    {
    default: 
      Log.i("MicroMsg.WalletAutoReportUtil", "unknow action：%s", new Object[] { Integer.valueOf(paramInt2) });
      AppMethodBeat.o(242221);
      return "Terminate";
    case 1: 
      AppMethodBeat.o(242221);
      return "EnterBackground";
    case 2: 
      AppMethodBeat.o(242221);
      return "EnterForeground";
    case 3: 
      AppMethodBeat.o(242221);
      return "BecomeActive";
    case 4: 
      AppMethodBeat.o(242221);
      return "ResignActive";
    case 5: 
      AppMethodBeat.o(242221);
      return "MemoryWarning";
    case 6: 
      AppMethodBeat.o(242221);
      return "Terminate";
    }
    AppMethodBeat.o(242221);
    return "NetworkChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.g
 * JD-Core Version:    0.7.0.1
 */