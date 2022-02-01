package com.tencent.mm.plugin.scanner.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.qbar.QbarNative.QBarPoint;
import com.tencent.qbar.WxQbarNative.QBarReportMsg;
import com.tencent.qbar.a.a;
import com.tencent.qbar.h;
import com.tencent.qbar.h.c;
import com.tencent.scanlib.a.b.b.a;
import com.tencent.scanlib.a.b.d.a;
import com.tencent.scanlib.a.f;
import com.tencent.scanlib.ui.ScanCodeView;
import com.tencent.scanlib.ui.ScanCodeView.a;
import java.util.List;

public class ScanCodeRectView
  extends ScanCodeView
{
  ScanRectDecorView ISL;
  private h.c JaV;
  
  public ScanCodeRectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ScanCodeRectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void fDY()
  {
    AppMethodBeat.i(91100);
    this.ZrD = new com.tencent.mm.plugin.scanner.a.a();
    AppMethodBeat.o(91100);
  }
  
  public Rect getDecorRect()
  {
    AppMethodBeat.i(91108);
    Rect localRect = this.ISL.getDecorRect();
    AppMethodBeat.o(91108);
    return localRect;
  }
  
  public final void init()
  {
    AppMethodBeat.i(91099);
    super.init();
    this.ISL = new ScanRectDecorView(getContext());
    addView(this.ISL, new FrameLayout.LayoutParams(-1, -1));
    this.JaV = new h.c()
    {
      public final void a(final long paramAnonymousLong, List<a.a> paramAnonymousList, List<QbarNative.QBarPoint> paramAnonymousList1, final List<WxQbarNative.QBarReportMsg> paramAnonymousList2, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(193729);
        Log.d("MicroMsg.ScanCodeRectView", String.format("after decode %d", new Object[] { Long.valueOf(paramAnonymousLong) }));
        if ((paramAnonymousList != null) && (!paramAnonymousList.isEmpty())) {
          ScanCodeRectView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(91093);
              if ((ScanCodeRectView.b(ScanCodeRectView.this) == paramAnonymousLong) && (paramAnonymousLong != 0L))
              {
                h.inM().PP(ScanCodeRectView.c(ScanCodeRectView.this));
                ScanCodeRectView.d(ScanCodeRectView.this);
                if ((paramAnonymousList2 != null) && (!paramAnonymousList2.isEmpty()))
                {
                  Bundle localBundle = new Bundle();
                  String str = ((a.a)paramAnonymousList2.get(0)).data;
                  localBundle.putString("result_content", str);
                  int i = ((a.a)paramAnonymousList2.get(0)).typeID;
                  localBundle.putInt("result_code_format", i);
                  localBundle.putString("result_code_name", ((a.a)paramAnonymousList2.get(0)).typeName);
                  byte[] arrayOfByte = ((a.a)paramAnonymousList2.get(0)).rawData;
                  if (arrayOfByte != null) {
                    localBundle.putByteArray("result_raw_data", arrayOfByte);
                  }
                  if ((this.ILf != null) && (!this.ILf.isEmpty())) {
                    localBundle.putInt("result_code_version", ((WxQbarNative.QBarReportMsg)this.ILf.get(0)).qrcodeVersion);
                  }
                  ScanCodeRectView.this.ISL.dlq();
                  Log.i("MicroMsg.ScanCodeRectView", "scan result format: %d, content:", new Object[] { Integer.valueOf(i), str });
                  if (ScanCodeRectView.e(ScanCodeRectView.this) != null) {
                    ScanCodeRectView.f(ScanCodeRectView.this).au(localBundle);
                  }
                }
              }
              AppMethodBeat.o(91093);
            }
          });
        }
        AppMethodBeat.o(193729);
      }
      
      public final void as(final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(91095);
        ScanCodeRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(91092);
            if ((paramAnonymousLong1 == ScanCodeRectView.a(ScanCodeRectView.this)) && (paramAnonymousLong1 != 0L)) {
              ScanCodeRectView.this.PW(this.DNj);
            }
            AppMethodBeat.o(91092);
          }
        });
        AppMethodBeat.o(91095);
      }
      
      public final void b(final long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(91097);
        ScanCodeRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(91094);
            if ((paramAnonymousLong == ScanCodeRectView.g(ScanCodeRectView.this)) && (paramAnonymousLong != 0L) && (this.val$param.containsKey("param_zoom_ratio")))
            {
              float f = this.val$param.getInt("param_zoom_ratio", 0);
              if ((f > 0.0F) && (ScanCodeRectView.h(ScanCodeRectView.this).egx()))
              {
                int i = (int)(((com.tencent.scanlib.a.a)ScanCodeRectView.i(ScanCodeRectView.this)).iov() * f);
                ((com.tencent.scanlib.a.a)ScanCodeRectView.j(ScanCodeRectView.this)).aAr(i);
              }
            }
            AppMethodBeat.o(91094);
          }
        });
        AppMethodBeat.o(91097);
      }
    };
    AppMethodBeat.o(91099);
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    AppMethodBeat.i(91105);
    Log.i("MicroMsg.ScanCodeRectView", "onAutoFocus %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      PW(0L);
    }
    WO(ZrG);
    AppMethodBeat.o(91105);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(91102);
    super.onCreate();
    h.inM().init(getContext());
    AppMethodBeat.o(91102);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(91107);
    super.onDestroy();
    h.inM().release();
    AppMethodBeat.o(91107);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(91104);
    h.inM().PP(this.IIw);
    this.IIw = 0L;
    this.ISL.dlq();
    AppMethodBeat.o(91104);
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    int j = 0;
    AppMethodBeat.i(91101);
    super.onPreviewFrame(paramArrayOfByte, paramCamera);
    paramCamera = new StringBuilder("onPreviewFrame null data:");
    boolean bool;
    Object localObject1;
    Object localObject2;
    Rect localRect2;
    if (paramArrayOfByte == null)
    {
      bool = true;
      Log.d("MicroMsg.ScanCodeRectView", bool);
      if ((this.IIw != 0L) && (this.ZrD.egx()))
      {
        paramCamera = this.ZrD.ios();
        localObject1 = (com.tencent.scanlib.a.a)this.ZrD;
        Rect localRect1 = getDecorRect();
        localObject2 = new Rect();
        ((Activity)getContext()).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject2);
        localObject2 = new Point(((Rect)localObject2).width(), ((Rect)localObject2).height());
        localRect2 = new Rect();
        i = (int)(localRect1.width() * 0.5F);
        int k = (int)(localRect1.height() * 0.5F);
        localRect1.left -= i / 2;
        int m = localRect1.right;
        localRect2.right = (i / 2 + m);
        localRect1.top -= k / 2;
        localRect1.bottom += k / 2;
        if (localRect2.left >= 0) {
          break label405;
        }
        i = 0;
        label241:
        localRect2.left = i;
        if (localRect2.right <= ((Point)localObject2).x) {
          break label414;
        }
        i = ((Point)localObject2).x;
        label266:
        localRect2.right = i;
        if (localRect2.top >= 0) {
          break label423;
        }
        i = j;
        label283:
        localRect2.top = i;
        if (localRect2.bottom <= ((Point)localObject2).y) {
          break label432;
        }
      }
    }
    label405:
    label414:
    label423:
    label432:
    for (int i = ((Point)localObject2).y;; i = localRect2.bottom)
    {
      localRect2.bottom = i;
      localObject1 = ((com.tencent.scanlib.a.a)localObject1).G(localRect2);
      h.inM().a(paramArrayOfByte, paramCamera, this.ZrD.getCameraRotation(), (Rect)localObject1);
      if ((!((com.tencent.scanlib.a.a)this.ZrD).fDZ()) && (h.inM().IIz > 50))
      {
        Log.i("MicroMsg.ScanCodeRectView", "change to FOCUS_MODE_AUTO");
        this.ZrD.bCY("auto");
        WO(100L);
      }
      AppMethodBeat.o(91101);
      return;
      bool = false;
      break;
      i = localRect2.left;
      break label241;
      i = localRect2.right;
      break label266;
      i = localRect2.top;
      break label283;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(91103);
    if (!this.ZrD.isOpen()) {
      a(new b.b.a()
      {
        public final void fEl()
        {
          AppMethodBeat.i(91098);
          ScanCodeRectView.this.a(new b.d.a()
          {
            public final void fEk()
            {
              AppMethodBeat.i(176201);
              ScanCodeRectView.this.PW(0L);
              AppMethodBeat.o(176201);
            }
          });
          AppMethodBeat.o(91098);
        }
      });
    }
    for (;;)
    {
      this.IIw = System.currentTimeMillis();
      h.inM().a(this.IIw, this.JaV);
      this.ISL.dlp();
      AppMethodBeat.o(91103);
      return;
      if (!this.ZrD.egx()) {
        a(new b.d.a()
        {
          public final void fEk()
          {
            AppMethodBeat.i(176202);
            ScanCodeRectView.this.PW(0L);
            AppMethodBeat.o(176202);
          }
        });
      } else {
        PW(0L);
      }
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(91106);
    super.onStop();
    AppMethodBeat.o(91106);
  }
  
  public void setDecorRect(Rect paramRect)
  {
    AppMethodBeat.i(91109);
    this.ISL.setDecorRect(paramRect);
    AppMethodBeat.o(91109);
  }
  
  public void setScanCodeReaders(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(91110);
    h.inM().R(paramArrayOfInt);
    AppMethodBeat.o(91110);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.ScanCodeRectView
 * JD-Core Version:    0.7.0.1
 */