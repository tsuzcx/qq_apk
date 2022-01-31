package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class TbsReaderPredownload
{
  public static final int READER_SO_SUCCESS = 2;
  public static final int READER_WAIT_IN_QUEUE = 3;
  static final String[] b = { "docx", "pptx", "xlsx", "pdf", "epub", "txt" };
  Handler a;
  LinkedList<String> c;
  boolean d;
  ReaderWizard e;
  TbsReaderView.ReaderCallback f;
  Object g;
  Context h;
  TbsReaderPredownload.ReaderPreDownloadCallback i;
  String j;
  
  public TbsReaderPredownload(TbsReaderPredownload.ReaderPreDownloadCallback paramReaderPreDownloadCallback)
  {
    AppMethodBeat.i(139368);
    this.a = null;
    this.c = new LinkedList();
    this.d = false;
    this.e = null;
    this.f = null;
    this.g = null;
    this.h = null;
    this.i = null;
    this.j = "";
    this.i = paramReaderPreDownloadCallback;
    paramReaderPreDownloadCallback = b;
    int m = paramReaderPreDownloadCallback.length;
    while (k < m)
    {
      Object localObject = paramReaderPreDownloadCallback[k];
      this.c.add(localObject);
      k += 1;
    }
    a();
    AppMethodBeat.o(139368);
  }
  
  private void b()
  {
    AppMethodBeat.i(139373);
    b(3);
    AppMethodBeat.o(139373);
  }
  
  void a()
  {
    AppMethodBeat.i(139376);
    this.a = new bd(this, Looper.getMainLooper());
    AppMethodBeat.o(139376);
  }
  
  void a(int paramInt)
  {
    AppMethodBeat.i(139375);
    if (this.i != null)
    {
      boolean bool = this.c.isEmpty();
      this.i.onEvent(this.j, paramInt, bool);
    }
    AppMethodBeat.o(139375);
  }
  
  void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(139379);
    Message localMessage = this.a.obtainMessage(paramInt1);
    this.a.sendMessageDelayed(localMessage, paramInt2);
    AppMethodBeat.o(139379);
  }
  
  boolean a(String paramString)
  {
    AppMethodBeat.i(139374);
    if ((this.g == null) || (this.e == null))
    {
      AppMethodBeat.o(139374);
      return false;
    }
    if (!ReaderWizard.isSupportExt(paramString))
    {
      AppMethodBeat.o(139374);
      return false;
    }
    boolean bool = this.e.checkPlugin(this.g, this.h, paramString, true);
    AppMethodBeat.o(139374);
    return bool;
  }
  
  void b(int paramInt)
  {
    AppMethodBeat.i(139377);
    this.a.removeMessages(paramInt);
    AppMethodBeat.o(139377);
  }
  
  boolean c(int paramInt)
  {
    AppMethodBeat.i(139378);
    boolean bool = this.a.hasMessages(paramInt);
    AppMethodBeat.o(139378);
    return bool;
  }
  
  public boolean init(Context paramContext)
  {
    AppMethodBeat.i(139369);
    if (paramContext == null)
    {
      AppMethodBeat.o(139369);
      return false;
    }
    this.h = paramContext.getApplicationContext();
    bool = TbsReaderView.a(paramContext.getApplicationContext());
    this.f = new bc(this);
    try
    {
      if (this.e == null) {
        this.e = new ReaderWizard(this.f);
      }
      if (this.g == null) {
        this.g = this.e.getTbsReader();
      }
      if (this.g != null) {
        bool = this.e.initTbsReader(this.g, paramContext.getApplicationContext());
      }
    }
    catch (NullPointerException paramContext)
    {
      for (;;)
      {
        bool = false;
      }
    }
    AppMethodBeat.o(139369);
    return bool;
  }
  
  public void pause()
  {
    this.d = true;
  }
  
  public void shutdown()
  {
    AppMethodBeat.i(139372);
    this.i = null;
    this.d = false;
    this.c.clear();
    b();
    if (this.e != null)
    {
      this.e.destroy(this.g);
      this.g = null;
    }
    this.h = null;
    AppMethodBeat.o(139372);
  }
  
  public void start(String paramString)
  {
    AppMethodBeat.i(139371);
    this.d = false;
    b(3);
    this.c.add(paramString);
    a(3, 100);
    AppMethodBeat.o(139371);
  }
  
  public void startAll()
  {
    AppMethodBeat.i(139370);
    this.d = false;
    if (!(c(3) | false)) {
      a(3, 100);
    }
    AppMethodBeat.o(139370);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsReaderPredownload
 * JD-Core Version:    0.7.0.1
 */