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
    AppMethodBeat.i(187974);
    this.a = null;
    this.b = null;
    this.a = new TbsReaderManager();
    AppMethodBeat.o(187974);
  }
  
  public static boolean canOpenFile(String paramString)
  {
    AppMethodBeat.i(187977);
    boolean bool = false;
    if (ReaderEngine.getInstance().isSupportCurrentPlatform()) {
      bool = ReaderEngine.getInstance().isSupportExt(3, paramString);
    }
    AppMethodBeat.o(187977);
    return bool;
  }
  
  public static TbsFileInterfaceImpl getInstance()
  {
    AppMethodBeat.i(187973);
    if (c == null) {
      c = new TbsFileInterfaceImpl();
    }
    TbsFileInterfaceImpl localTbsFileInterfaceImpl = c;
    AppMethodBeat.o(187973);
    return localTbsFileInterfaceImpl;
  }
  
  public static boolean initEngine(Context paramContext)
  {
    AppMethodBeat.i(187975);
    ReaderEngine.getInstance().initReaderEntry(paramContext);
    boolean bool = ReaderEngine.getInstance().isSupportCurrentPlatform();
    AppMethodBeat.o(187975);
    return bool;
  }
  
  public static void setProviderSetting(String paramString)
  {
    AppMethodBeat.i(187976);
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("provider_classname", paramString);
    ReaderEngine.getInstance().setConfigSetting(localLinkedHashMap);
    AppMethodBeat.o(187976);
  }
  
  public void closeFileReader()
  {
    AppMethodBeat.i(187978);
    if (this.b != null) {
      this.b.closeFile();
    }
    this.b = null;
    if (this.a != null) {
      this.a.destroy();
    }
    AppMethodBeat.o(187978);
  }
  
  public ITbsReaderAtom createAtom(int paramInt)
  {
    AppMethodBeat.i(187980);
    if (this.a.getTbsReader() != null)
    {
      ITbsReaderAtom localITbsReaderAtom = (ITbsReaderAtom)this.a.getTbsReader().createAtom(paramInt);
      AppMethodBeat.o(187980);
      return localITbsReaderAtom;
    }
    AppMethodBeat.o(187980);
    return null;
  }
  
  public ReaderMixerMode createReader(Context paramContext, ITbsReaderCallback paramITbsReaderCallback)
  {
    AppMethodBeat.i(187979);
    paramContext = this.a.createReaderMode(paramContext, paramITbsReaderCallback);
    AppMethodBeat.o(187979);
    return paramContext;
  }
  
  public boolean initReader(Context paramContext, ITbsReaderCallback paramITbsReaderCallback)
  {
    AppMethodBeat.i(187981);
    this.b = createReader(paramContext, paramITbsReaderCallback);
    if (this.b != null)
    {
      AppMethodBeat.o(187981);
      return true;
    }
    AppMethodBeat.o(187981);
    return false;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187984);
    if (this.b != null) {
      this.b.onSizeChanged(paramInt1, paramInt2);
    }
    AppMethodBeat.o(187984);
  }
  
  public int openFileReader(Context paramContext, Bundle paramBundle, ITbsReaderCallback paramITbsReaderCallback, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(187983);
    closeFileReader();
    this.b = createReader(paramContext, paramITbsReaderCallback);
    int i = this.b.openFile(paramBundle, paramFrameLayout);
    AppMethodBeat.o(187983);
    return i;
  }
  
  public int openFileReader(Bundle paramBundle, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(187982);
    int i = this.b.openFile(paramBundle, paramFrameLayout);
    AppMethodBeat.o(187982);
    return i;
  }
  
  public void pluginPreLoad(Context paramContext, String paramString)
  {
    AppMethodBeat.i(187985);
    this.a.getPluginPre(paramContext).downloadPlugin(paramContext, paramString);
    AppMethodBeat.o(187985);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tbs.reader.TbsFileInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */