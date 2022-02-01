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
    AppMethodBeat.i(190621);
    this.a = null;
    this.b = null;
    this.a = new TbsReaderManager();
    AppMethodBeat.o(190621);
  }
  
  public static boolean canOpenFile(String paramString)
  {
    AppMethodBeat.i(190624);
    boolean bool = false;
    if (ReaderEngine.getInstance().isSupportCurrentPlatform()) {
      bool = ReaderEngine.getInstance().isSupportExt(3, paramString);
    }
    AppMethodBeat.o(190624);
    return bool;
  }
  
  public static TbsFileInterfaceImpl getInstance()
  {
    AppMethodBeat.i(190620);
    if (c == null) {
      c = new TbsFileInterfaceImpl();
    }
    TbsFileInterfaceImpl localTbsFileInterfaceImpl = c;
    AppMethodBeat.o(190620);
    return localTbsFileInterfaceImpl;
  }
  
  public static boolean initEngine(Context paramContext)
  {
    AppMethodBeat.i(190622);
    ReaderEngine.getInstance().initReaderEntry(paramContext);
    boolean bool = ReaderEngine.getInstance().isSupportCurrentPlatform();
    AppMethodBeat.o(190622);
    return bool;
  }
  
  public static void setProviderSetting(String paramString)
  {
    AppMethodBeat.i(190623);
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("provider_classname", paramString);
    ReaderEngine.getInstance().setConfigSetting(localLinkedHashMap);
    AppMethodBeat.o(190623);
  }
  
  public void closeFileReader()
  {
    AppMethodBeat.i(190625);
    if (this.b != null) {
      this.b.closeFile();
    }
    this.b = null;
    if (this.a != null) {
      this.a.destroy();
    }
    AppMethodBeat.o(190625);
  }
  
  public ITbsReaderAtom createAtom(int paramInt)
  {
    AppMethodBeat.i(190627);
    if (this.a.getTbsReader() != null)
    {
      ITbsReaderAtom localITbsReaderAtom = (ITbsReaderAtom)this.a.getTbsReader().createAtom(paramInt);
      AppMethodBeat.o(190627);
      return localITbsReaderAtom;
    }
    AppMethodBeat.o(190627);
    return null;
  }
  
  public ReaderMixerMode createReader(Context paramContext, ITbsReaderCallback paramITbsReaderCallback)
  {
    AppMethodBeat.i(190626);
    paramContext = this.a.createReaderMode(paramContext, paramITbsReaderCallback);
    AppMethodBeat.o(190626);
    return paramContext;
  }
  
  public boolean initReader(Context paramContext, ITbsReaderCallback paramITbsReaderCallback)
  {
    AppMethodBeat.i(190628);
    this.b = createReader(paramContext, paramITbsReaderCallback);
    if (this.b != null)
    {
      AppMethodBeat.o(190628);
      return true;
    }
    AppMethodBeat.o(190628);
    return false;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190631);
    if (this.b != null) {
      this.b.onSizeChanged(paramInt1, paramInt2);
    }
    AppMethodBeat.o(190631);
  }
  
  public int openFileReader(Context paramContext, Bundle paramBundle, ITbsReaderCallback paramITbsReaderCallback, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(190630);
    closeFileReader();
    this.b = createReader(paramContext, paramITbsReaderCallback);
    int i = this.b.openFile(paramBundle, paramFrameLayout);
    AppMethodBeat.o(190630);
    return i;
  }
  
  public int openFileReader(Bundle paramBundle, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(190629);
    int i = this.b.openFile(paramBundle, paramFrameLayout);
    AppMethodBeat.o(190629);
    return i;
  }
  
  public void pluginPreLoad(Context paramContext, String paramString)
  {
    AppMethodBeat.i(190632);
    this.a.getPluginPre(paramContext).downloadPlugin(paramContext, paramString);
    AppMethodBeat.o(190632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.reader.TbsFileInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */