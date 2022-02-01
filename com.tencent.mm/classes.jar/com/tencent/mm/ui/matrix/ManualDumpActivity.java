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
import com.tencent.matrix.resource.analyzer.model.g;
import com.tencent.matrix.resource.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ManualDumpActivity
  extends MMActivity
{
  private String QmC;
  private String QmD;
  private TextView QmE;
  private TextView QmF;
  private boolean QmG;
  private o QmH;
  private MMHandler mainHandler;
  
  public ManualDumpActivity()
  {
    AppMethodBeat.i(38869);
    this.QmC = null;
    this.QmD = null;
    this.mainHandler = new MMHandler(Looper.getMainLooper());
    this.QmG = false;
    AppMethodBeat.o(38869);
  }
  
  private static com.tencent.matrix.resource.analyzer.model.a a(o paramo, String paramString, Boolean paramBoolean)
  {
    AppMethodBeat.i(169898);
    if (paramBoolean.booleanValue()) {
      paramBoolean = c.l(Build.VERSION.SDK_INT, Build.MANUFACTURER).SY();
    }
    try
    {
      for (;;)
      {
        paramo = new g(paramo);
        paramo = new com.tencent.matrix.resource.analyzer.a(paramString, paramBoolean).a(paramo);
        AppMethodBeat.o(169898);
        return paramo;
        paramBoolean = c.m(Build.VERSION.SDK_INT, Build.MANUFACTURER).SY();
      }
    }
    catch (IOException paramo)
    {
      for (;;)
      {
        paramo = com.tencent.matrix.resource.analyzer.model.a.a(paramo, 0L);
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2131495459;
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
    Object localObject = (com.tencent.matrix.resource.b)com.tencent.matrix.b.RG().Y(com.tencent.matrix.resource.b.class);
    if (localObject == null)
    {
      AppMethodBeat.o(38872);
      return;
    }
    localObject = ((com.tencent.matrix.resource.b)localObject).cWQ;
    if (localObject == null)
    {
      AppMethodBeat.o(38872);
      return;
    }
    if (((com.tencent.matrix.resource.e.b)localObject).cZJ == null)
    {
      AppMethodBeat.o(38872);
      return;
    }
    localObject = new HandlerThread("DumpHprofWorker");
    ((HandlerThread)localObject).start();
    localObject = new Handler(((HandlerThread)localObject).getLooper());
    final View localView = findViewById(2131306281);
    paramView.animate().alpha(0.0F).setDuration(300L).withEndAction(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38868);
        this.NE.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38867);
            long l;
            Object localObject;
            if (ManualDumpActivity.b(ManualDumpActivity.this) == null)
            {
              l = System.currentTimeMillis();
              localObject = new d(MMApplicationContext.getContext());
              ManualDumpActivity.a(ManualDumpActivity.this, o.X(((d)localObject).Tj()));
            }
            try
            {
              Debug.dumpHprofData(aa.z(ManualDumpActivity.b(ManualDumpActivity.this).her()));
              Log.i("ManualDumpActivity", String.format("cost=%sms refString=%s path=%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), ManualDumpActivity.c(ManualDumpActivity.this), aa.z(ManualDumpActivity.b(ManualDumpActivity.this).her()) }));
              ManualDumpActivity.e(ManualDumpActivity.this).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(38865);
                  ManualDumpActivity.d(ManualDumpActivity.this).setText(aa.z(ManualDumpActivity.b(ManualDumpActivity.this).her()));
                  ManualDumpActivity.3.this.QmJ.setVisibility(0);
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
                  if ((this.QmM.cWT) && (this.QmM.cWV != null))
                  {
                    ManualDumpActivity.a(ManualDumpActivity.this).setTextColor(ManualDumpActivity.this.getResources().getColor(17170457));
                    localObject = this.QmM.cWV.toString();
                    ManualDumpActivity.a(ManualDumpActivity.this).setText((CharSequence)localObject);
                    Log.i("ManualDumpActivity", (String)localObject);
                    ManualDumpActivity.3.this.QmJ.setVisibility(8);
                    localHashMap = new HashMap();
                    localHashMap.put("stack", localObject);
                    localHashMap.put("isHardAnalyze", Boolean.valueOf(ManualDumpActivity.f(ManualDumpActivity.this)));
                    com.tencent.mm.plugin.report.service.h.CyF.a(18573, new Object[] { this.QmM.mClassName, localHashMap, Integer.valueOf(0), Integer.valueOf(1000), Integer.valueOf(0) });
                    Log.i("ManualDumpActivity", (String)localObject);
                    Toast.makeText(ManualDumpActivity.this.getContext(), "已成功上报", 1).show();
                    AppMethodBeat.o(38866);
                    return;
                  }
                  if (this.QmM.cWW != null)
                  {
                    if (ManualDumpActivity.f(ManualDumpActivity.this))
                    {
                      ManualDumpActivity.a(ManualDumpActivity.this).setTextColor(ManualDumpActivity.this.getResources().getColor(17170455));
                      localObject = new JSONObject();
                      try
                      {
                        this.QmM.q((JSONObject)localObject);
                        ManualDumpActivity.a(ManualDumpActivity.this).setText(((JSONObject)localObject).toString());
                        ManualDumpActivity.3.this.QmJ.setVisibility(8);
                        localHashMap = new HashMap();
                        localHashMap.put("stack", ((JSONObject)localObject).toString());
                        localHashMap.put("isHardAnalyze", Boolean.valueOf(ManualDumpActivity.f(ManualDumpActivity.this)));
                        com.tencent.mm.plugin.report.service.h.CyF.a(18573, new Object[] { this.QmM.mClassName, localHashMap, Integer.valueOf(0), Integer.valueOf(1000), Integer.valueOf(1) });
                        Log.i("ManualDumpActivity", ((JSONObject)localObject).toString());
                        Toast.makeText(ManualDumpActivity.this.getContext(), "已成功上报", 1).show();
                        AppMethodBeat.o(38866);
                        return;
                      }
                      catch (JSONException localJSONException)
                      {
                        for (;;)
                        {
                          Log.printErrStackTrace("ManualDumpActivity", localJSONException, "", new Object[0]);
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
                  ManualDumpActivity.3.this.QmJ.setVisibility(8);
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
                Log.printErrStackTrace("ManualDumpActivity", localIOException, "", new Object[0]);
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
    this.QmE = ((TextView)findViewById(2131303129));
    this.QmF = ((TextView)findViewById(2131302454));
    this.QmE.setOnLongClickListener(new ManualDumpActivity.2(this));
    this.QmD = getIntent().getStringExtra("activity");
    this.QmC = getIntent().getStringExtra("ref_key");
    ((TextView)findViewById(2131303128)).setText(this.QmD);
    AppMethodBeat.o(38870);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.matrix.ManualDumpActivity
 * JD-Core Version:    0.7.0.1
 */