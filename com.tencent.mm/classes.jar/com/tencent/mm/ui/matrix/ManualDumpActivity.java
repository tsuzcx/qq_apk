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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ManualDumpActivity
  extends MMActivity
{
  private String KXI;
  private String KXJ;
  private TextView KXK;
  private TextView KXL;
  private boolean KXM;
  private k KXN;
  private aq hXp;
  
  public ManualDumpActivity()
  {
    AppMethodBeat.i(38869);
    this.KXI = null;
    this.KXJ = null;
    this.hXp = new aq(Looper.getMainLooper());
    this.KXM = false;
    AppMethodBeat.o(38869);
  }
  
  private static com.tencent.matrix.resource.analyzer.model.a a(k paramk, String paramString, Boolean paramBoolean)
  {
    AppMethodBeat.i(169898);
    if (paramBoolean.booleanValue()) {
      paramBoolean = c.k(Build.VERSION.SDK_INT, Build.MANUFACTURER).IK();
    }
    try
    {
      for (;;)
      {
        paramk = new com.tencent.matrix.resource.analyzer.model.g(paramk);
        paramk = new com.tencent.matrix.resource.analyzer.a(paramString, paramBoolean).a(paramk);
        AppMethodBeat.o(169898);
        return paramk;
        paramBoolean = c.l(Build.VERSION.SDK_INT, Build.MANUFACTURER).IK();
      }
    }
    catch (IOException paramk)
    {
      for (;;)
      {
        paramk = com.tencent.matrix.resource.analyzer.model.a.a(paramk, 0L);
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
    Object localObject = (com.tencent.matrix.resource.b)com.tencent.matrix.b.HT().V(com.tencent.matrix.resource.b.class);
    if (localObject == null)
    {
      AppMethodBeat.o(38872);
      return;
    }
    localObject = ((com.tencent.matrix.resource.b)localObject).cGs;
    if (localObject == null)
    {
      AppMethodBeat.o(38872);
      return;
    }
    if (((com.tencent.matrix.resource.e.b)localObject).cJm == null)
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
              localObject = new d(ak.getContext());
              ManualDumpActivity.a(ManualDumpActivity.this, k.W(((d)localObject).IV()));
            }
            try
            {
              Debug.dumpHprofData(w.B(ManualDumpActivity.b(ManualDumpActivity.this).fTh()));
              ae.i("ManualDumpActivity", String.format("cost=%sms refString=%s path=%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), ManualDumpActivity.c(ManualDumpActivity.this), w.B(ManualDumpActivity.b(ManualDumpActivity.this).fTh()) }));
              ManualDumpActivity.e(ManualDumpActivity.this).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(38865);
                  ManualDumpActivity.d(ManualDumpActivity.this).setText(w.B(ManualDumpActivity.b(ManualDumpActivity.this).fTh()));
                  ManualDumpActivity.3.this.KXP.setVisibility(0);
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
                  if ((this.KXS.cGv) && (this.KXS.cGx != null))
                  {
                    ManualDumpActivity.a(ManualDumpActivity.this).setTextColor(ManualDumpActivity.this.getResources().getColor(17170457));
                    localObject = this.KXS.cGx.toString();
                    ManualDumpActivity.a(ManualDumpActivity.this).setText((CharSequence)localObject);
                    ae.i("ManualDumpActivity", (String)localObject);
                    ManualDumpActivity.3.this.KXP.setVisibility(8);
                    localHashMap = new HashMap();
                    localHashMap.put("stack", localObject);
                    localHashMap.put("isHardAnalyze", Boolean.valueOf(ManualDumpActivity.f(ManualDumpActivity.this)));
                    com.tencent.mm.plugin.report.service.g.yxI.f(18573, new Object[] { this.KXS.mClassName, localHashMap, Integer.valueOf(0), Integer.valueOf(1000), Integer.valueOf(0) });
                    ae.i("ManualDumpActivity", (String)localObject);
                    Toast.makeText(ManualDumpActivity.this.getContext(), "已成功上报", 1).show();
                    AppMethodBeat.o(38866);
                    return;
                  }
                  if (this.KXS.cGy != null)
                  {
                    if (ManualDumpActivity.f(ManualDumpActivity.this))
                    {
                      ManualDumpActivity.a(ManualDumpActivity.this).setTextColor(ManualDumpActivity.this.getResources().getColor(17170455));
                      localObject = new JSONObject();
                      try
                      {
                        this.KXS.m((JSONObject)localObject);
                        ManualDumpActivity.a(ManualDumpActivity.this).setText(((JSONObject)localObject).toString());
                        ManualDumpActivity.3.this.KXP.setVisibility(8);
                        localHashMap = new HashMap();
                        localHashMap.put("stack", ((JSONObject)localObject).toString());
                        localHashMap.put("isHardAnalyze", Boolean.valueOf(ManualDumpActivity.f(ManualDumpActivity.this)));
                        com.tencent.mm.plugin.report.service.g.yxI.f(18573, new Object[] { this.KXS.mClassName, localHashMap, Integer.valueOf(0), Integer.valueOf(1000), Integer.valueOf(1) });
                        ae.i("ManualDumpActivity", ((JSONObject)localObject).toString());
                        Toast.makeText(ManualDumpActivity.this.getContext(), "已成功上报", 1).show();
                        AppMethodBeat.o(38866);
                        return;
                      }
                      catch (JSONException localJSONException)
                      {
                        for (;;)
                        {
                          ae.printErrStackTrace("ManualDumpActivity", localJSONException, "", new Object[0]);
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
                  ManualDumpActivity.3.this.KXP.setVisibility(8);
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
                ae.printErrStackTrace("ManualDumpActivity", localIOException, "", new Object[0]);
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
    this.KXK = ((TextView)findViewById(2131301376));
    this.KXL = ((TextView)findViewById(2131300860));
    this.KXK.setOnLongClickListener(new ManualDumpActivity.2(this));
    this.KXJ = getIntent().getStringExtra("activity");
    this.KXI = getIntent().getStringExtra("ref_key");
    ((TextView)findViewById(2131301375)).setText(this.KXJ);
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