package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.b.a;
import com.tencent.mm.plugin.multitask.b.c;
import com.tencent.mm.plugin.multitask.g;
import com.tencent.mm.plugin.multitask.j.h;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.vfs.u;

public final class i
  extends c
{
  private static i Rwx;
  public boolean VX = false;
  String mFileName = "";
  public String mFilePath = "";
  String qia = "";
  public int tOb = 0;
  
  static
  {
    AppMethodBeat.i(246563);
    Rwx = new i();
    AppMethodBeat.o(246563);
  }
  
  public i()
  {
    super((byte)0);
  }
  
  public static String asq(String paramString)
  {
    AppMethodBeat.i(246561);
    paramString = u.asq(bkf(paramString));
    AppMethodBeat.o(246561);
    return paramString;
  }
  
  private static String bkf(String paramString)
  {
    AppMethodBeat.i(246562);
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
    AppMethodBeat.o(246562);
    return paramString;
  }
  
  private void hnA()
  {
    AppMethodBeat.i(246559);
    this.FHd.fbc().jmx = this.qia;
    this.FHd.fbc().title = this.mFileName;
    faR();
    AppMethodBeat.o(246559);
  }
  
  public static i hnB()
  {
    return Rwx;
  }
  
  public final void M(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(246557);
    b(paramString1, paramString2, "", paramInt, faF());
    AppMethodBeat.o(246557);
  }
  
  public final boolean Q(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(246560);
    paramBoolean = super.Q(paramInt, this.VX);
    AppMethodBeat.o(246560);
    return paramBoolean;
  }
  
  public final void b(String paramString1, String paramString2, String paramString3, int paramInt, aco paramaco)
  {
    AppMethodBeat.i(246558);
    Log.i("MicroMsg.FilesFloatBall.FilesMultiTaskHelper", "onCreate, filePath:%s fileExt:%s fileName:%s sence:%s", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt) });
    super.I(4, g.aQW(paramString1));
    this.mFilePath = paramString1;
    this.qia = paramString2;
    this.mFileName = paramString3;
    if (TextUtils.isEmpty(this.mFileName)) {
      this.mFileName = bkf(paramString1);
    }
    this.VX = false;
    this.tOb = paramInt;
    b(paramaco);
    paramString3 = new apf();
    paramString3.SCl = false;
    paramString3.filePath = paramString1;
    paramString3.jmx = paramString2;
    paramString3.Rwe = u.bBQ(paramString1);
    paramString3.tNG = paramInt;
    try
    {
      this.FHd.field_data = paramString3.toByteArray();
      faR();
      hnA();
      AppMethodBeat.o(246558);
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
  
  public final boolean cbG()
  {
    return false;
  }
  
  public final boolean cbH()
  {
    return false;
  }
  
  public final long faO()
  {
    return 1500L;
  }
  
  public final void iV(boolean paramBoolean)
  {
    AppMethodBeat.i(246556);
    if (paramBoolean)
    {
      Log.i("MicroMsg.FilesFloatBall.FilesMultiTaskHelper", "onMenuFloatBallSelected, enter float ball");
      b(null, true);
      PlaySound.play(MMApplicationContext.getContext(), j.h.webview_minimize_sound_path);
      Context localContext = MMApplicationContext.getContext();
      Intent localIntent = new Intent("com.tencent.QQBrowser.action.sdk.document.receiver");
      localIntent.setPackage("com.tencent.mtt");
      localIntent.putExtra("key_reader_sdk_window_close", true);
      try
      {
        localContext.sendBroadcast(localIntent);
        AppMethodBeat.o(246556);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.FilesFloatBall.FilesMultiTaskHelper", "closeQb() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      }
    }
    AppMethodBeat.o(246556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.i
 * JD-Core Version:    0.7.0.1
 */