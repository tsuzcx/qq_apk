package com.tencent.mm.ui.matrix;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.resource.analyzer.model.c;
import com.tencent.matrix.resource.analyzer.model.d.a;
import com.tencent.matrix.resource.analyzer.model.h;
import com.tencent.matrix.resource.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ManualDumpActivity
  extends MMActivity
{
  private String KBo;
  private String KBp;
  private TextView KBq;
  private TextView KBr;
  private boolean KBs;
  private e KBt;
  private ap hUx;
  
  public ManualDumpActivity()
  {
    AppMethodBeat.i(38869);
    this.KBo = null;
    this.KBp = null;
    this.hUx = new ap(Looper.getMainLooper());
    this.KBs = false;
    AppMethodBeat.o(38869);
  }
  
  private static com.tencent.matrix.resource.analyzer.model.a a(e parame, String paramString, Boolean paramBoolean)
  {
    AppMethodBeat.i(169898);
    if (paramBoolean.booleanValue()) {
      paramBoolean = c.k(Build.VERSION.SDK_INT, Build.MANUFACTURER).IC();
    }
    try
    {
      for (;;)
      {
        parame = new com.tencent.matrix.resource.analyzer.model.g(parame);
        parame = new com.tencent.matrix.resource.analyzer.a(paramString, paramBoolean).a(parame);
        AppMethodBeat.o(169898);
        return parame;
        paramBoolean = c.l(Build.VERSION.SDK_INT, Build.MANUFACTURER).IC();
      }
    }
    catch (IOException parame)
    {
      for (;;)
      {
        parame = com.tencent.matrix.resource.analyzer.model.a.a(parame, 0L);
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2131494730;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(38871);
    super.onBackPressed();
    finish();
    AppMethodBeat.o(38871);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(38872);
    Object localObject = (com.tencent.matrix.resource.b)com.tencent.matrix.b.HL().V(com.tencent.matrix.resource.b.class);
    if (localObject == null)
    {
      AppMethodBeat.o(38872);
      return;
    }
    localObject = ((com.tencent.matrix.resource.b)localObject).cFJ;
    if (localObject == null)
    {
      AppMethodBeat.o(38872);
      return;
    }
    if (((com.tencent.matrix.resource.e.b)localObject).cID == null)
    {
      AppMethodBeat.o(38872);
      return;
    }
    localObject = new HandlerThread("DumpHprofWorker");
    ((HandlerThread)localObject).start();
    localObject = new Handler(((HandlerThread)localObject).getLooper());
    final View localView = findViewById(2131303515);
    paramView.animate().alpha(0.0F).setDuration(300L).withEndAction(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38868);
        this.val$handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38867);
            long l;
            Object localObject;
            if (ManualDumpActivity.b(ManualDumpActivity.this) == null)
            {
              l = System.currentTimeMillis();
              localObject = new d(aj.getContext());
              ManualDumpActivity.a(ManualDumpActivity.this, e.X(((d)localObject).IN()));
            }
            try
            {
              Debug.dumpHprofData(q.B(ManualDumpActivity.b(ManualDumpActivity.this).fOK()));
              ad.i("ManualDumpActivity", String.format("cost=%sms refString=%s path=%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), ManualDumpActivity.c(ManualDumpActivity.this), q.B(ManualDumpActivity.b(ManualDumpActivity.this).fOK()) }));
              ManualDumpActivity.e(ManualDumpActivity.this).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(38865);
                  ManualDumpActivity.d(ManualDumpActivity.this).setText(q.B(ManualDumpActivity.b(ManualDumpActivity.this).fOK()));
                  ManualDumpActivity.3.this.KBv.setVisibility(0);
                  AppMethodBeat.o(38865);
                }
              });
              localObject = ManualDumpActivity.b(ManualDumpActivity.b(ManualDumpActivity.this), ManualDumpActivity.c(ManualDumpActivity.this), Boolean.valueOf(ManualDumpActivity.f(ManualDumpActivity.this)));
              ManualDumpActivity.e(ManualDumpActivity.this).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(38866);
                  Object localObject;
                  HashMap localHashMap;
                  if ((this.KBy.cFM) && (this.KBy.cFO != null))
                  {
                    ManualDumpActivity.a(ManualDumpActivity.this).setTextColor(ManualDumpActivity.this.getResources().getColor(17170457));
                    localObject = this.KBy.cFO.toString();
                    ManualDumpActivity.a(ManualDumpActivity.this).setText((CharSequence)localObject);
                    ad.i("ManualDumpActivity", (String)localObject);
                    ManualDumpActivity.3.this.KBv.setVisibility(8);
                    localHashMap = new HashMap();
                    localHashMap.put("stack", localObject);
                    localHashMap.put("isHardAnalyze", Boolean.valueOf(ManualDumpActivity.f(ManualDumpActivity.this)));
                    com.tencent.mm.plugin.report.service.g.yhR.f(18573, new Object[] { this.KBy.mClassName, localHashMap, Integer.valueOf(0), Integer.valueOf(1000), Integer.valueOf(0) });
                    ad.i("ManualDumpActivity", (String)localObject);
                    Toast.makeText(ManualDumpActivity.this.getContext(), "已成功上报", 1).show();
                    AppMethodBeat.o(38866);
                    return;
                  }
                  if (this.KBy.cFP != null)
                  {
                    if (ManualDumpActivity.f(ManualDumpActivity.this))
                    {
                      ManualDumpActivity.a(ManualDumpActivity.this).setTextColor(ManualDumpActivity.this.getResources().getColor(17170455));
                      localObject = new JSONObject();
                      try
                      {
                        this.KBy.m((JSONObject)localObject);
                        ManualDumpActivity.a(ManualDumpActivity.this).setText(((JSONObject)localObject).toString());
                        ManualDumpActivity.3.this.KBv.setVisibility(8);
                        localHashMap = new HashMap();
                        localHashMap.put("stack", ((JSONObject)localObject).toString());
                        localHashMap.put("isHardAnalyze", Boolean.valueOf(ManualDumpActivity.f(ManualDumpActivity.this)));
                        com.tencent.mm.plugin.report.service.g.yhR.f(18573, new Object[] { this.KBy.mClassName, localHashMap, Integer.valueOf(0), Integer.valueOf(1000), Integer.valueOf(1) });
                        ad.i("ManualDumpActivity", ((JSONObject)localObject).toString());
                        Toast.makeText(ManualDumpActivity.this.getContext(), "已成功上报", 1).show();
                        AppMethodBeat.o(38866);
                        return;
                      }
                      catch (JSONException localJSONException)
                      {
                        for (;;)
                        {
                          ad.printErrStackTrace("ManualDumpActivity", localJSONException, "", new Object[0]);
                        }
                      }
                    }
                    ManualDumpActivity.g(ManualDumpActivity.this);
                    ManualDumpActivity.e(ManualDumpActivity.this).post(this);
                    AppMethodBeat.o(38866);
                    return;
                  }
                  ManualDumpActivity.a(ManualDumpActivity.this).setTextColor(ManualDumpActivity.this.getResources().getColor(17170453));
                  ManualDumpActivity.a(ManualDumpActivity.this).setText("not found!");
                  ManualDumpActivity.3.this.KBv.setVisibility(8);
                  AppMethodBeat.o(38866);
                }
              });
              AppMethodBeat.o(38867);
              return;
            }
            catch (IOException localIOException)
            {
              for (;;)
              {
                ad.printErrStackTrace("ManualDumpActivity", localIOException, "", new Object[0]);
              }
            }
          }
        });
        AppMethodBeat.o(38868);
      }
    }).start();
    AppMethodBeat.o(38872);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38870);
    super.onCreate(paramBundle);
    setMMTitle("Activity Leak");
    setBackBtn(new ManualDumpActivity.1(this));
    this.KBq = ((TextView)findViewById(2131301376));
    this.KBr = ((TextView)findViewById(2131300860));
    this.KBq.setOnLongClickListener(new ManualDumpActivity.2(this));
    this.KBp = getIntent().getStringExtra("activity");
    this.KBo = getIntent().getStringExtra("ref_key");
    ((TextView)findViewById(2131301375)).setText(this.KBp);
    AppMethodBeat.o(38870);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.matrix.ManualDumpActivity
 * JD-Core Version:    0.7.0.1
 */