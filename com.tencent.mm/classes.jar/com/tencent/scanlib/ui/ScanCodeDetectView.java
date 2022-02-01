package com.tencent.scanlib.ui;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qbar.a.a;
import com.tencent.scanlib.a.a;
import com.tencent.scanlib.a.b.b.a;
import com.tencent.scanlib.a.b.d.a;
import com.tencent.scanlib.a.f;
import com.tencent.scanlib.b.c;
import com.tencent.scanlib.b.c.c;
import com.tencent.scanlib.model.DetectCode;
import com.tencent.stubs.logger.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ScanCodeDetectView
  extends ScanCodeView
{
  private DetectCodeView ahwh;
  private c.c ahwi;
  
  public ScanCodeDetectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(3580);
    this.ahwi = new c.c()
    {
      public final void b(final long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(3577);
        ScanCodeDetectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(3573);
            if ((paramAnonymousLong == ScanCodeDetectView.this.OOu) && (paramAnonymousLong != 0L))
            {
              if (this.val$param.containsKey("param_zoom_ratio"))
              {
                float f = this.val$param.getFloat("param_zoom_ratio", 0.0F);
                if ((f > 0.0F) && (ScanCodeDetectView.this.ahwr.boa()))
                {
                  int i = (int)(((a)ScanCodeDetectView.this.ahwr).jXI() * f);
                  ((a)ScanCodeDetectView.this.ahwr).aHc(i);
                }
              }
              if (this.val$param.containsKey("param_detect_codes"))
              {
                ArrayList localArrayList1 = this.val$param.getParcelableArrayList("param_detect_codes");
                if ((localArrayList1 != null) && (!localArrayList1.isEmpty()))
                {
                  Iterator localIterator1 = localArrayList1.iterator();
                  while (localIterator1.hasNext())
                  {
                    DetectCode localDetectCode = (DetectCode)localIterator1.next();
                    ArrayList localArrayList2 = new ArrayList(localDetectCode.points.size());
                    Iterator localIterator2 = localDetectCode.points.iterator();
                    while (localIterator2.hasNext())
                    {
                      Point localPoint = (Point)localIterator2.next();
                      localArrayList2.add(ScanCodeDetectView.a(ScanCodeDetectView.this, localPoint));
                    }
                    localDetectCode.points = localArrayList2;
                  }
                  ScanCodeDetectView.a(ScanCodeDetectView.this).setDetectedCodes(localArrayList1);
                }
              }
            }
            AppMethodBeat.o(3573);
          }
        });
        AppMethodBeat.o(3577);
      }
      
      public final void bc(final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(3576);
        ScanCodeDetectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(3572);
            if ((paramAnonymousLong1 == ScanCodeDetectView.this.OOu) && (paramAnonymousLong1 != 0L)) {
              ScanCodeDetectView.this.ua(this.JEx);
            }
            AppMethodBeat.o(3572);
          }
        });
        AppMethodBeat.o(3576);
      }
      
      public final void h(final long paramAnonymousLong, List<a.a> paramAnonymousList)
      {
        AppMethodBeat.i(3578);
        if ((paramAnonymousList != null) && (!paramAnonymousList.isEmpty())) {
          ScanCodeDetectView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(3575);
              if ((ScanCodeDetectView.this.OOu == paramAnonymousLong) && (paramAnonymousLong != 0L))
              {
                c.jXP().tR(ScanCodeDetectView.this.OOu);
                ScanCodeDetectView.this.OOu = 0L;
                ScanCodeDetectView.this.postDelayed(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(3574);
                    ScanCodeDetectView.a(ScanCodeDetectView.this).setDetectedCodes(null);
                    AppMethodBeat.o(3574);
                  }
                }, 500L);
                if ((this.OSa != null) && (!this.OSa.isEmpty()))
                {
                  Bundle localBundle = new Bundle();
                  String str = ((a.a)this.OSa.get(0)).data;
                  localBundle.putString("result_content", str);
                  int i = ((a.a)this.OSa.get(0)).typeID;
                  localBundle.putInt("result_code_format", i);
                  localBundle.putString("result_code_name", ((a.a)this.OSa.get(0)).typeName);
                  byte[] arrayOfByte = ((a.a)this.OSa.get(0)).rawData;
                  if (arrayOfByte != null) {
                    localBundle.putByteArray("result_raw_data", arrayOfByte);
                  }
                  Log.i("ScanCodeDetectView", String.format("scan result format: %d, content:%s", new Object[] { Integer.valueOf(i), str }));
                  if (ScanCodeDetectView.this.ahwn != null) {
                    ScanCodeDetectView.this.ahwn.aV(localBundle);
                  }
                }
              }
              AppMethodBeat.o(3575);
            }
          });
        }
        AppMethodBeat.o(3578);
      }
    };
    AppMethodBeat.o(3580);
  }
  
  public ScanCodeDetectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(3581);
    this.ahwi = new c.c()
    {
      public final void b(final long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(3577);
        ScanCodeDetectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(3573);
            if ((paramAnonymousLong == ScanCodeDetectView.this.OOu) && (paramAnonymousLong != 0L))
            {
              if (this.val$param.containsKey("param_zoom_ratio"))
              {
                float f = this.val$param.getFloat("param_zoom_ratio", 0.0F);
                if ((f > 0.0F) && (ScanCodeDetectView.this.ahwr.boa()))
                {
                  int i = (int)(((a)ScanCodeDetectView.this.ahwr).jXI() * f);
                  ((a)ScanCodeDetectView.this.ahwr).aHc(i);
                }
              }
              if (this.val$param.containsKey("param_detect_codes"))
              {
                ArrayList localArrayList1 = this.val$param.getParcelableArrayList("param_detect_codes");
                if ((localArrayList1 != null) && (!localArrayList1.isEmpty()))
                {
                  Iterator localIterator1 = localArrayList1.iterator();
                  while (localIterator1.hasNext())
                  {
                    DetectCode localDetectCode = (DetectCode)localIterator1.next();
                    ArrayList localArrayList2 = new ArrayList(localDetectCode.points.size());
                    Iterator localIterator2 = localDetectCode.points.iterator();
                    while (localIterator2.hasNext())
                    {
                      Point localPoint = (Point)localIterator2.next();
                      localArrayList2.add(ScanCodeDetectView.a(ScanCodeDetectView.this, localPoint));
                    }
                    localDetectCode.points = localArrayList2;
                  }
                  ScanCodeDetectView.a(ScanCodeDetectView.this).setDetectedCodes(localArrayList1);
                }
              }
            }
            AppMethodBeat.o(3573);
          }
        });
        AppMethodBeat.o(3577);
      }
      
      public final void bc(final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(3576);
        ScanCodeDetectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(3572);
            if ((paramAnonymousLong1 == ScanCodeDetectView.this.OOu) && (paramAnonymousLong1 != 0L)) {
              ScanCodeDetectView.this.ua(this.JEx);
            }
            AppMethodBeat.o(3572);
          }
        });
        AppMethodBeat.o(3576);
      }
      
      public final void h(final long paramAnonymousLong, List<a.a> paramAnonymousList)
      {
        AppMethodBeat.i(3578);
        if ((paramAnonymousList != null) && (!paramAnonymousList.isEmpty())) {
          ScanCodeDetectView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(3575);
              if ((ScanCodeDetectView.this.OOu == paramAnonymousLong) && (paramAnonymousLong != 0L))
              {
                c.jXP().tR(ScanCodeDetectView.this.OOu);
                ScanCodeDetectView.this.OOu = 0L;
                ScanCodeDetectView.this.postDelayed(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(3574);
                    ScanCodeDetectView.a(ScanCodeDetectView.this).setDetectedCodes(null);
                    AppMethodBeat.o(3574);
                  }
                }, 500L);
                if ((this.OSa != null) && (!this.OSa.isEmpty()))
                {
                  Bundle localBundle = new Bundle();
                  String str = ((a.a)this.OSa.get(0)).data;
                  localBundle.putString("result_content", str);
                  int i = ((a.a)this.OSa.get(0)).typeID;
                  localBundle.putInt("result_code_format", i);
                  localBundle.putString("result_code_name", ((a.a)this.OSa.get(0)).typeName);
                  byte[] arrayOfByte = ((a.a)this.OSa.get(0)).rawData;
                  if (arrayOfByte != null) {
                    localBundle.putByteArray("result_raw_data", arrayOfByte);
                  }
                  Log.i("ScanCodeDetectView", String.format("scan result format: %d, content:%s", new Object[] { Integer.valueOf(i), str }));
                  if (ScanCodeDetectView.this.ahwn != null) {
                    ScanCodeDetectView.this.ahwn.aV(localBundle);
                  }
                }
              }
              AppMethodBeat.o(3575);
            }
          });
        }
        AppMethodBeat.o(3578);
      }
    };
    AppMethodBeat.o(3581);
  }
  
  protected final void init()
  {
    AppMethodBeat.i(3583);
    super.init();
    this.ahwh = new DetectCodeView(getContext());
    addView(this.ahwh, new FrameLayout.LayoutParams(-1, -1));
    AppMethodBeat.o(3583);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(3582);
    if (!this.ahwr.isOpen()) {
      a(new b.b.a()
      {
        public final void gSY()
        {
          AppMethodBeat.i(3579);
          ScanCodeDetectView.this.a(new b.d.a()
          {
            public final void gSX()
            {
              AppMethodBeat.i(174602);
              ScanCodeDetectView.this.ua(0L);
              AppMethodBeat.o(174602);
            }
          });
          AppMethodBeat.o(3579);
        }
      });
    }
    for (;;)
    {
      this.OOu = System.currentTimeMillis();
      c.jXP().a(this.OOu, this.ahwi);
      AppMethodBeat.o(3582);
      return;
      if (!this.ahwr.boa()) {
        a(new b.d.a()
        {
          public final void gSX()
          {
            AppMethodBeat.i(174603);
            ScanCodeDetectView.this.ua(0L);
            AppMethodBeat.o(174603);
          }
        });
      } else {
        ua(0L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.scanlib.ui.ScanCodeDetectView
 * JD-Core Version:    0.7.0.1
 */