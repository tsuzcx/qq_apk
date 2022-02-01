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
  ReaderPreDownloadCallback i;
  String j;
  
  public TbsReaderPredownload(ReaderPreDownloadCallback paramReaderPreDownloadCallback)
  {
    AppMethodBeat.i(55030);
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
    AppMethodBeat.o(55030);
  }
  
  private void b()
  {
    AppMethodBeat.i(55035);
    b(3);
    AppMethodBeat.o(55035);
  }
  
  void a()
  {
    AppMethodBeat.i(55038);
    this.a = new Handler(Looper.getMainLooper())
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(54939);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(54939);
          return;
          if ((!TbsReaderPredownload.this.c.isEmpty()) && (!TbsReaderPredownload.this.d))
          {
            paramAnonymousMessage = (String)TbsReaderPredownload.this.c.removeFirst();
            TbsReaderPredownload.this.j = paramAnonymousMessage;
            if (!TbsReaderPredownload.this.a(paramAnonymousMessage)) {
              TbsReaderPredownload.this.a(-1);
            }
          }
        }
      }
    };
    AppMethodBeat.o(55038);
  }
  
  void a(int paramInt)
  {
    AppMethodBeat.i(55037);
    if (this.i != null)
    {
      boolean bool = this.c.isEmpty();
      this.i.onEvent(this.j, paramInt, bool);
    }
    AppMethodBeat.o(55037);
  }
  
  void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(55041);
    Message localMessage = this.a.obtainMessage(paramInt1);
    this.a.sendMessageDelayed(localMessage, paramInt2);
    AppMethodBeat.o(55041);
  }
  
  boolean a(String paramString)
  {
    AppMethodBeat.i(55036);
    if ((this.g == null) || (this.e == null))
    {
      AppMethodBeat.o(55036);
      return false;
    }
    if (!ReaderWizard.isSupportExt(paramString))
    {
      AppMethodBeat.o(55036);
      return false;
    }
    boolean bool = this.e.checkPlugin(this.g, this.h, paramString, true);
    AppMethodBeat.o(55036);
    return bool;
  }
  
  void b(int paramInt)
  {
    AppMethodBeat.i(55039);
    this.a.removeMessages(paramInt);
    AppMethodBeat.o(55039);
  }
  
  boolean c(int paramInt)
  {
    AppMethodBeat.i(55040);
    boolean bool = this.a.hasMessages(paramInt);
    AppMethodBeat.o(55040);
    return bool;
  }
  
  public boolean init(Context paramContext)
  {
    AppMethodBeat.i(55031);
    if (paramContext == null)
    {
      AppMethodBeat.o(55031);
      return false;
    }
    this.h = paramContext.getApplicationContext();
    bool = TbsReaderView.a(paramContext.getApplicationContext());
    this.f = new TbsReaderView.ReaderCallback()
    {
      public void onCallBackAction(Integer paramAnonymousInteger, Object paramAnonymousObject1, Object paramAnonymousObject2)
      {
        AppMethodBeat.i(54937);
        switch (paramAnonymousInteger.intValue())
        {
        default: 
          AppMethodBeat.o(54937);
          return;
        }
        int i = ((Integer)paramAnonymousObject1).intValue();
        if (5014 == i)
        {
          AppMethodBeat.o(54937);
          return;
        }
        if (5013 == i) {
          TbsReaderPredownload.this.a(0);
        }
        for (;;)
        {
          TbsReaderPredownload.this.j = "";
          TbsReaderPredownload.this.a(3, 100);
          break;
          if (i == 0) {
            TbsReaderPredownload.this.a(0);
          } else {
            TbsReaderPredownload.this.a(-1);
          }
        }
      }
    };
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
    AppMethodBeat.o(55031);
    return bool;
  }
  
  public void pause()
  {
    this.d = true;
  }
  
  public void shutdown()
  {
    AppMethodBeat.i(55034);
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
    AppMethodBeat.o(55034);
  }
  
  public void start(String paramString)
  {
    AppMethodBeat.i(55033);
    this.d = false;
    b(3);
    this.c.add(paramString);
    a(3, 100);
    AppMethodBeat.o(55033);
  }
  
  public void startAll()
  {
    AppMethodBeat.i(55032);
    this.d = false;
    if (!(c(3) | false)) {
      a(3, 100);
    }
    AppMethodBeat.o(55032);
  }
  
  public static abstract interface ReaderPreDownloadCallback
  {
    public static final int NOTIFY_PLUGIN_FAILED = -1;
    public static final int NOTIFY_PLUGIN_SUCCESS = 0;
    
    public abstract void onEvent(String paramString, int paramInt, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsReaderPredownload
 * JD-Core Version:    0.7.0.1
 */