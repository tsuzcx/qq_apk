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
  private DetectCodeView JVy;
  private c.c JVz;
  
  public ScanCodeDetectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(3580);
    this.JVz = new c.c()
    {
      public final void ad(final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(3576);
        ScanCodeDetectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(3572);
            if ((paramAnonymousLong1 == ScanCodeDetectView.this.wXJ) && (paramAnonymousLong1 != 0L)) {
              ScanCodeDetectView.this.wE(this.tGh);
            }
            AppMethodBeat.o(3572);
          }
        });
        AppMethodBeat.o(3576);
      }
      
      public final void b(final long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(3577);
        ScanCodeDetectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(3573);
            if ((paramAnonymousLong == ScanCodeDetectView.this.wXJ) && (paramAnonymousLong != 0L))
            {
              if (this.val$param.containsKey("param_zoom_ratio"))
              {
                float f = this.val$param.getFloat("param_zoom_ratio", 0.0F);
                if ((f > 0.0F) && (ScanCodeDetectView.this.JVI.cDz()))
                {
                  int i = (int)(((a)ScanCodeDetectView.this.JVI).fCV() * f);
                  ((a)ScanCodeDetectView.this.JVI).aei(i);
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
      
      public final void c(final long paramAnonymousLong, List<a.a> paramAnonymousList)
      {
        AppMethodBeat.i(3578);
        if ((paramAnonymousList != null) && (!paramAnonymousList.isEmpty())) {
          ScanCodeDetectView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(3575);
              if ((ScanCodeDetectView.this.wXJ == paramAnonymousLong) && (paramAnonymousLong != 0L))
              {
                c.fDb().wz(ScanCodeDetectView.this.wXJ);
                ScanCodeDetectView.this.wXJ = 0L;
                ScanCodeDetectView.this.postDelayed(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(3574);
                    ScanCodeDetectView.a(ScanCodeDetectView.this).setDetectedCodes(null);
                    AppMethodBeat.o(3574);
                  }
                }, 500L);
                if ((this.wZk != null) && (!this.wZk.isEmpty()))
                {
                  Bundle localBundle = new Bundle();
                  String str = ((a.a)this.wZk.get(0)).data;
                  localBundle.putString("result_content", str);
                  int i = ((a.a)this.wZk.get(0)).typeID;
                  localBundle.putInt("result_code_format", i);
                  localBundle.putString("result_code_name", ((a.a)this.wZk.get(0)).typeName);
                  byte[] arrayOfByte = ((a.a)this.wZk.get(0)).rawData;
                  if (arrayOfByte != null) {
                    localBundle.putByteArray("result_raw_data", arrayOfByte);
                  }
                  Log.i("ScanCodeDetectView", String.format("scan result format: %d, content:%s", new Object[] { Integer.valueOf(i), str }));
                  if (ScanCodeDetectView.this.JVE != null) {
                    ScanCodeDetectView.this.JVE.ai(localBundle);
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
    this.JVz = new c.c()
    {
      public final void ad(final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(3576);
        ScanCodeDetectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(3572);
            if ((paramAnonymousLong1 == ScanCodeDetectView.this.wXJ) && (paramAnonymousLong1 != 0L)) {
              ScanCodeDetectView.this.wE(this.tGh);
            }
            AppMethodBeat.o(3572);
          }
        });
        AppMethodBeat.o(3576);
      }
      
      public final void b(final long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(3577);
        ScanCodeDetectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(3573);
            if ((paramAnonymousLong == ScanCodeDetectView.this.wXJ) && (paramAnonymousLong != 0L))
            {
              if (this.val$param.containsKey("param_zoom_ratio"))
              {
                float f = this.val$param.getFloat("param_zoom_ratio", 0.0F);
                if ((f > 0.0F) && (ScanCodeDetectView.this.JVI.cDz()))
                {
                  int i = (int)(((a)ScanCodeDetectView.this.JVI).fCV() * f);
                  ((a)ScanCodeDetectView.this.JVI).aei(i);
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
      
      public final void c(final long paramAnonymousLong, List<a.a> paramAnonymousList)
      {
        AppMethodBeat.i(3578);
        if ((paramAnonymousList != null) && (!paramAnonymousList.isEmpty())) {
          ScanCodeDetectView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(3575);
              if ((ScanCodeDetectView.this.wXJ == paramAnonymousLong) && (paramAnonymousLong != 0L))
              {
                c.fDb().wz(ScanCodeDetectView.this.wXJ);
                ScanCodeDetectView.this.wXJ = 0L;
                ScanCodeDetectView.this.postDelayed(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(3574);
                    ScanCodeDetectView.a(ScanCodeDetectView.this).setDetectedCodes(null);
                    AppMethodBeat.o(3574);
                  }
                }, 500L);
                if ((this.wZk != null) && (!this.wZk.isEmpty()))
                {
                  Bundle localBundle = new Bundle();
                  String str = ((a.a)this.wZk.get(0)).data;
                  localBundle.putString("result_content", str);
                  int i = ((a.a)this.wZk.get(0)).typeID;
                  localBundle.putInt("result_code_format", i);
                  localBundle.putString("result_code_name", ((a.a)this.wZk.get(0)).typeName);
                  byte[] arrayOfByte = ((a.a)this.wZk.get(0)).rawData;
                  if (arrayOfByte != null) {
                    localBundle.putByteArray("result_raw_data", arrayOfByte);
                  }
                  Log.i("ScanCodeDetectView", String.format("scan result format: %d, content:%s", new Object[] { Integer.valueOf(i), str }));
                  if (ScanCodeDetectView.this.JVE != null) {
                    ScanCodeDetectView.this.JVE.ai(localBundle);
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
    this.JVy = new DetectCodeView(getContext());
    addView(this.JVy, new FrameLayout.LayoutParams(-1, -1));
    AppMethodBeat.o(3583);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(3582);
    if (!this.JVI.isOpen()) {
      a(new b.b.a()
      {
        public final void dAJ()
        {
          AppMethodBeat.i(3579);
          ScanCodeDetectView.this.a(new b.d.a()
          {
            public final void dAI()
            {
              AppMethodBeat.i(174602);
              ScanCodeDetectView.this.wE(0L);
              AppMethodBeat.o(174602);
            }
          });
          AppMethodBeat.o(3579);
        }
      });
    }
    for (;;)
    {
      this.wXJ = System.currentTimeMillis();
      c.fDb().a(this.wXJ, this.JVz);
      AppMethodBeat.o(3582);
      return;
      if (!this.JVI.cDz()) {
        a(new b.d.a()
        {
          public final void dAI()
          {
            AppMethodBeat.i(174603);
            ScanCodeDetectView.this.wE(0L);
            AppMethodBeat.o(174603);
          }
        });
      } else {
        wE(0L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.scanlib.ui.ScanCodeDetectView
 * JD-Core Version:    0.7.0.1
 */