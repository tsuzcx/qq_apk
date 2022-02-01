package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.b.a;
import com.tencent.mm.plugin.multitask.b.c;
import com.tencent.mm.plugin.multitask.j.h;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.aet;
import com.tencent.mm.protocal.protobuf.asy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.vfs.y;

public final class g
  extends c
{
  private static g YsL;
  public boolean bCD = false;
  String mFileName = "";
  public String mFilePath = "";
  String tmM = "";
  public int wRr = 0;
  
  static
  {
    AppMethodBeat.i(245548);
    YsL = new g();
    AppMethodBeat.o(245548);
  }
  
  public g()
  {
    super((byte)0);
  }
  
  public static String alV(String paramString)
  {
    AppMethodBeat.i(245541);
    paramString = y.alV(bjP(paramString));
    AppMethodBeat.o(245541);
    return paramString;
  }
  
  private static String bjP(String paramString)
  {
    AppMethodBeat.i(245546);
    try
    {
      int j = paramString.lastIndexOf('/') + 1;
      if (j < 0) {
        break label79;
      }
      i = j;
      if (j != paramString.length()) {}
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.FilesFloatBall.FilesMultiTaskHelper", "get file name error " + paramString.getMessage());
        paramString = " ";
        continue;
        int i = 0;
      }
    }
    paramString = paramString.substring(i, paramString.length());
    AppMethodBeat.o(245546);
    return paramString;
  }
  
  private void iOs()
  {
    AppMethodBeat.i(245534);
    this.LCE.gkh().lPJ = this.tmM;
    this.LCE.gkh().title = this.mFileName;
    gjW();
    AppMethodBeat.o(245534);
  }
  
  public static g iOt()
  {
    return YsL;
  }
  
  public final void T(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(245559);
    b(paramString1, paramString2, "", paramInt, gjK());
    AppMethodBeat.o(245559);
  }
  
  public final boolean af(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(245564);
    paramBoolean = super.af(paramInt, this.bCD);
    AppMethodBeat.o(245564);
    return paramBoolean;
  }
  
  public final void b(String paramString1, String paramString2, String paramString3, int paramInt, aet paramaet)
  {
    AppMethodBeat.i(245562);
    Log.i("MicroMsg.FilesFloatBall.FilesMultiTaskHelper", "onCreate, filePath:%s fileExt:%s fileName:%s sence:%s", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt) });
    super.J(4, com.tencent.mm.plugin.multitask.g.aNO(paramString1));
    this.mFilePath = paramString1;
    this.tmM = paramString2;
    this.mFileName = paramString3;
    if (TextUtils.isEmpty(this.mFileName)) {
      this.mFileName = bjP(paramString1);
    }
    this.bCD = false;
    this.wRr = paramInt;
    b(paramaet);
    paramString3 = new asy();
    paramString3.ZDd = false;
    paramString3.filePath = paramString1;
    paramString3.lPJ = paramString2;
    paramString3.Ysz = y.bEl(paramString1);
    paramString3.wQW = paramInt;
    try
    {
      this.LCE.field_data = paramString3.toByteArray();
      gjW();
      iOs();
      AppMethodBeat.o(245562);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.FilesFloatBall.FilesMultiTaskHelper", paramString1, "", new Object[0]);
      }
    }
  }
  
  public final boolean cBZ()
  {
    return false;
  }
  
  public final boolean cCa()
  {
    return false;
  }
  
  public final long gjT()
  {
    return 1500L;
  }
  
  public final void kd(boolean paramBoolean)
  {
    AppMethodBeat.i(245555);
    if (paramBoolean)
    {
      Log.i("MicroMsg.FilesFloatBall.FilesMultiTaskHelper", "onMenuFloatBallSelected, enter float ball");
      c(null, true);
      PlaySound.play(MMApplicationContext.getContext(), j.h.webview_minimize_sound_path);
      Context localContext = MMApplicationContext.getContext();
      Intent localIntent = new Intent("com.tencent.QQBrowser.action.sdk.document.receiver");
      localIntent.setPackage("com.tencent.mtt");
      localIntent.putExtra("key_reader_sdk_window_close", true);
      try
      {
        localContext.sendBroadcast(localIntent);
        AppMethodBeat.o(245555);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.FilesFloatBall.FilesMultiTaskHelper", "closeQb() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      }
    }
    AppMethodBeat.o(245555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.g
 * JD-Core Version:    0.7.0.1
 */