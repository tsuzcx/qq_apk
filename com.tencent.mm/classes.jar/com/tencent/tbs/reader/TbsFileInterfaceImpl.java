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
    AppMethodBeat.i(186614);
    this.a = null;
    this.b = null;
    this.a = new TbsReaderManager();
    AppMethodBeat.o(186614);
  }
  
  public static boolean canOpenFile(String paramString)
  {
    AppMethodBeat.i(186617);
    boolean bool = false;
    if (ReaderEngine.getInstance().isSupportCurrentPlatform()) {
      bool = ReaderEngine.getInstance().isSupportExt(3, paramString);
    }
    AppMethodBeat.o(186617);
    return bool;
  }
  
  public static TbsFileInterfaceImpl getInstance()
  {
    AppMethodBeat.i(186613);
    if (c == null) {
      c = new TbsFileInterfaceImpl();
    }
    TbsFileInterfaceImpl localTbsFileInterfaceImpl = c;
    AppMethodBeat.o(186613);
    return localTbsFileInterfaceImpl;
  }
  
  public static boolean initEngine(Context paramContext)
  {
    AppMethodBeat.i(186615);
    ReaderEngine.getInstance().initReaderEntry(paramContext);
    boolean bool = ReaderEngine.getInstance().isSupportCurrentPlatform();
    AppMethodBeat.o(186615);
    return bool;
  }
  
  public static void setProviderSetting(String paramString)
  {
    AppMethodBeat.i(186616);
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("provider_classname", paramString);
    ReaderEngine.getInstance().setConfigSetting(localLinkedHashMap);
    AppMethodBeat.o(186616);
  }
  
  public void closeFileReader()
  {
    AppMethodBeat.i(186618);
    if (this.b != null) {
      this.b.closeFile();
    }
    this.b = null;
    if (this.a != null) {
      this.a.destroy();
    }
    AppMethodBeat.o(186618);
  }
  
  public ITbsReaderAtom createAtom(int paramInt)
  {
    AppMethodBeat.i(186620);
    if (this.a.getTbsReader() != null)
    {
      ITbsReaderAtom localITbsReaderAtom = (ITbsReaderAtom)this.a.getTbsReader().createAtom(paramInt);
      AppMethodBeat.o(186620);
      return localITbsReaderAtom;
    }
    AppMethodBeat.o(186620);
    return null;
  }
  
  public ReaderMixerMode createReader(Context paramContext, ITbsReaderCallback paramITbsReaderCallback)
  {
    AppMethodBeat.i(186619);
    paramContext = this.a.createReaderMode(paramContext, paramITbsReaderCallback);
    AppMethodBeat.o(186619);
    return paramContext;
  }
  
  public boolean initReader(Context paramContext, ITbsReaderCallback paramITbsReaderCallback)
  {
    AppMethodBeat.i(186621);
    this.b = createReader(paramContext, paramITbsReaderCallback);
    if (this.b != null)
    {
      AppMethodBeat.o(186621);
      return true;
    }
    AppMethodBeat.o(186621);
    return false;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186624);
    if (this.b != null) {
      this.b.onSizeChanged(paramInt1, paramInt2);
    }
    AppMethodBeat.o(186624);
  }
  
  public int openFileReader(Context paramContext, Bundle paramBundle, ITbsReaderCallback paramITbsReaderCallback, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(186623);
    closeFileReader();
    this.b = createReader(paramContext, paramITbsReaderCallback);
    int i = this.b.openFile(paramBundle, paramFrameLayout);
    AppMethodBeat.o(186623);
    return i;
  }
  
  public int openFileReader(Bundle paramBundle, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(186622);
    int i = this.b.openFile(paramBundle, paramFrameLayout);
    AppMethodBeat.o(186622);
    return i;
  }
  
  public void pluginPreLoad(Context paramContext, String paramString)
  {
    AppMethodBeat.i(186625);
    this.a.getPluginPre(paramContext).downloadPlugin(paramContext, paramString);
    AppMethodBeat.o(186625);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.reader.TbsFileInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */