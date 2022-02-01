package com.tencent.tbs.reader;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.reader.external.ITbsReaderAtom;
import java.util.LinkedHashMap;
import java.util.Map;

public class TbsFileInterfaceImpl
{
  public static int FILE_READER_WINDOW_TYPE_DEFAULT = 0;
  public static int FILE_READER_WINDOW_TYPE_VIEW = 2;
  static TbsFileInterfaceImpl c = null;
  TbsReaderManager a;
  ReaderMixerMode b;
  
  public TbsFileInterfaceImpl()
  {
    AppMethodBeat.i(192391);
    this.a = null;
    this.b = null;
    this.a = new TbsReaderManager();
    AppMethodBeat.o(192391);
  }
  
  public static boolean canOpenFile(String paramString)
  {
    AppMethodBeat.i(192394);
    boolean bool = false;
    if (ReaderEngine.getInstance().isSupportCurrentPlatform()) {
      bool = ReaderEngine.getInstance().isSupportExt(3, paramString);
    }
    AppMethodBeat.o(192394);
    return bool;
  }
  
  public static TbsFileInterfaceImpl getInstance()
  {
    AppMethodBeat.i(192390);
    if (c == null) {
      c = new TbsFileInterfaceImpl();
    }
    TbsFileInterfaceImpl localTbsFileInterfaceImpl = c;
    AppMethodBeat.o(192390);
    return localTbsFileInterfaceImpl;
  }
  
  public static boolean initEngine(Context paramContext)
  {
    AppMethodBeat.i(192392);
    ReaderEngine.getInstance().initReaderEntry(paramContext);
    boolean bool = ReaderEngine.getInstance().isSupportCurrentPlatform();
    AppMethodBeat.o(192392);
    return bool;
  }
  
  public static void setProviderSetting(String paramString)
  {
    AppMethodBeat.i(192393);
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("provider_classname", paramString);
    ReaderEngine.getInstance().setConfigSetting(localLinkedHashMap);
    AppMethodBeat.o(192393);
  }
  
  public void closeFileReader()
  {
    AppMethodBeat.i(192395);
    if (this.b != null) {
      this.b.closeFile();
    }
    this.b = null;
    if (this.a != null) {
      this.a.destroy();
    }
    AppMethodBeat.o(192395);
  }
  
  public ITbsReaderAtom createAtom(int paramInt)
  {
    AppMethodBeat.i(192397);
    if (this.a.getTbsReader() != null)
    {
      ITbsReaderAtom localITbsReaderAtom = (ITbsReaderAtom)this.a.getTbsReader().createAtom(paramInt);
      AppMethodBeat.o(192397);
      return localITbsReaderAtom;
    }
    AppMethodBeat.o(192397);
    return null;
  }
  
  public ReaderMixerMode createReader(Context paramContext, ITbsReaderCallback paramITbsReaderCallback)
  {
    AppMethodBeat.i(192396);
    paramContext = this.a.createReaderMode(paramContext, paramITbsReaderCallback);
    AppMethodBeat.o(192396);
    return paramContext;
  }
  
  public boolean initReader(Context paramContext, ITbsReaderCallback paramITbsReaderCallback)
  {
    AppMethodBeat.i(192398);
    this.b = createReader(paramContext, paramITbsReaderCallback);
    if (this.b != null)
    {
      AppMethodBeat.o(192398);
      return true;
    }
    AppMethodBeat.o(192398);
    return false;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192401);
    if (this.b != null) {
      this.b.onSizeChanged(paramInt1, paramInt2);
    }
    AppMethodBeat.o(192401);
  }
  
  public int openFileReader(Context paramContext, Bundle paramBundle, ITbsReaderCallback paramITbsReaderCallback, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(192400);
    closeFileReader();
    this.b = createReader(paramContext, paramITbsReaderCallback);
    int i = this.b.openFile(paramBundle, paramFrameLayout);
    AppMethodBeat.o(192400);
    return i;
  }
  
  public int openFileReader(Bundle paramBundle, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(192399);
    int i = this.b.openFile(paramBundle, paramFrameLayout);
    AppMethodBeat.o(192399);
    return i;
  }
  
  public void pluginPreLoad(Context paramContext, String paramString)
  {
    AppMethodBeat.i(192402);
    this.a.getPluginPre(paramContext).downloadPlugin(paramContext, paramString);
    AppMethodBeat.o(192402);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.reader.TbsFileInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */