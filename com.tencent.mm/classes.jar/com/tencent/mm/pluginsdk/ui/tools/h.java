package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.b.a;
import com.tencent.mm.plugin.multitask.b.c;
import com.tencent.mm.plugin.multitask.g;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.vfs.s;

public final class h
  extends c
{
  private static h Kvk;
  public boolean CB = false;
  String mFileName = "";
  public String mFilePath = "";
  String nhr = "";
  public int qpr = 0;
  
  static
  {
    AppMethodBeat.i(204781);
    Kvk = new h();
    AppMethodBeat.o(204781);
  }
  
  public h()
  {
    super((byte)0);
  }
  
  private static String aYk(String paramString)
  {
    AppMethodBeat.i(204780);
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
    AppMethodBeat.o(204780);
    return paramString;
  }
  
  public static String akC(String paramString)
  {
    AppMethodBeat.i(204779);
    paramString = s.akC(aYk(paramString));
    AppMethodBeat.o(204779);
    return paramString;
  }
  
  private void gsu()
  {
    AppMethodBeat.i(204777);
    this.Abp.erh().gCr = this.nhr;
    this.Abp.erh().title = this.mFileName;
    eqX();
    AppMethodBeat.o(204777);
  }
  
  public static h gsv()
  {
    return Kvk;
  }
  
  public final void I(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(204775);
    b(paramString1, paramString2, "", paramInt, this.Abq);
    AppMethodBeat.o(204775);
  }
  
  public final boolean O(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(204778);
    paramBoolean = super.O(paramInt, this.CB);
    AppMethodBeat.o(204778);
    return paramBoolean;
  }
  
  public final void b(String paramString1, String paramString2, String paramString3, int paramInt, ach paramach)
  {
    AppMethodBeat.i(204776);
    Log.i("MicroMsg.FilesFloatBall.FilesMultiTaskHelper", "onCreate, filePath:%s fileExt:%s fileName:%s sence:%s", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt) });
    super.G(4, g.aGI(paramString1));
    this.mFilePath = paramString1;
    this.nhr = paramString2;
    this.mFileName = paramString3;
    if (TextUtils.isEmpty(this.mFileName)) {
      this.mFileName = aYk(paramString1);
    }
    this.CB = false;
    this.qpr = paramInt;
    a(paramach);
    paramString3 = new aoe();
    paramString3.LzL = false;
    paramString3.filePath = paramString1;
    paramString3.gCr = paramString2;
    paramString3.LzM = s.boW(paramString1);
    paramString3.qoX = paramInt;
    try
    {
      this.Abp.field_data = paramString3.toByteArray();
      eqX();
      gsu();
      AppMethodBeat.o(204776);
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
  
  public final boolean bPp()
  {
    return false;
  }
  
  public final boolean bPq()
  {
    return false;
  }
  
  public final long eqU()
  {
    return 1500L;
  }
  
  public final void ib(boolean paramBoolean)
  {
    AppMethodBeat.i(204774);
    if (paramBoolean)
    {
      Log.i("MicroMsg.FilesFloatBall.FilesMultiTaskHelper", "onMenuFloatBallSelected, enter float ball");
      b(null, true);
      PlaySound.play(MMApplicationContext.getContext(), 2131768604);
      Context localContext = MMApplicationContext.getContext();
      Intent localIntent = new Intent("com.tencent.QQBrowser.action.sdk.document.receiver");
      localIntent.setPackage("com.tencent.mtt");
      localIntent.putExtra("key_reader_sdk_window_close", true);
      try
      {
        localContext.sendBroadcast(localIntent);
        AppMethodBeat.o(204774);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.FilesFloatBall.FilesMultiTaskHelper", "closeQb() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      }
    }
    AppMethodBeat.o(204774);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.h
 * JD-Core Version:    0.7.0.1
 */