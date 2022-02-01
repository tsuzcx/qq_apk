package com.tencent.mm.ui.matrix;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.resource.analyzer.model.c;
import com.tencent.matrix.resource.analyzer.model.d.a;
import com.tencent.matrix.resource.analyzer.model.g;
import com.tencent.matrix.resource.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
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
  private String IKh;
  private String IKi;
  private TextView IKj;
  private TextView IKk;
  private boolean IKl;
  private e IKm;
  private ao hBR;
  
  public ManualDumpActivity()
  {
    AppMethodBeat.i(38869);
    this.IKh = null;
    this.IKi = null;
    this.hBR = new ao(Looper.getMainLooper());
    this.IKl = false;
    AppMethodBeat.o(38869);
  }
  
  private static com.tencent.matrix.resource.analyzer.model.a a(e parame, String paramString, Boolean paramBoolean)
  {
    AppMethodBeat.i(169898);
    if (paramBoolean.booleanValue()) {
      paramBoolean = c.k(Build.VERSION.SDK_INT, Build.MANUFACTURER).Hh();
    }
    try
    {
      for (;;)
      {
        parame = new g(parame);
        parame = new com.tencent.matrix.resource.analyzer.a(paramString, paramBoolean).a(parame);
        AppMethodBeat.o(169898);
        return parame;
        paramBoolean = c.l(Build.VERSION.SDK_INT, Build.MANUFACTURER).Hh();
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
    Object localObject = (com.tencent.matrix.resource.b)com.tencent.matrix.b.Gq().V(com.tencent.matrix.resource.b.class);
    if (localObject == null)
    {
      AppMethodBeat.o(38872);
      return;
    }
    localObject = ((com.tencent.matrix.resource.b)localObject).cuO;
    if (localObject == null)
    {
      AppMethodBeat.o(38872);
      return;
    }
    if (((com.tencent.matrix.resource.e.b)localObject).cxI == null)
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
              localObject = new d(ai.getContext());
              ManualDumpActivity.a(ManualDumpActivity.this, e.U(((d)localObject).Hs()));
            }
            try
            {
              Debug.dumpHprofData(q.B(ManualDumpActivity.b(ManualDumpActivity.this).fxV()));
              ac.i("ManualDumpActivity", String.format("cost=%sms refString=%s path=%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), ManualDumpActivity.c(ManualDumpActivity.this), q.B(ManualDumpActivity.b(ManualDumpActivity.this).fxV()) }));
              ManualDumpActivity.e(ManualDumpActivity.this).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(38865);
                  ManualDumpActivity.d(ManualDumpActivity.this).setText(q.B(ManualDumpActivity.b(ManualDumpActivity.this).fxV()));
                  ManualDumpActivity.3.this.IKo.setVisibility(0);
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
                  if ((this.IKr.cuR) && (this.IKr.cuT != null))
                  {
                    ManualDumpActivity.a(ManualDumpActivity.this).setTextColor(ManualDumpActivity.this.getResources().getColor(17170457));
                    localObject = this.IKr.cuT.toString();
                    ManualDumpActivity.a(ManualDumpActivity.this).setText((CharSequence)localObject);
                    ac.i("ManualDumpActivity", (String)localObject);
                    ManualDumpActivity.3.this.IKo.setVisibility(8);
                    localHashMap = new HashMap();
                    localHashMap.put("stack", localObject);
                    localHashMap.put("isHardAnalyze", Boolean.valueOf(ManualDumpActivity.f(ManualDumpActivity.this)));
                    com.tencent.mm.plugin.report.service.h.wUl.f(18573, new Object[] { this.IKr.mClassName, localHashMap, Integer.valueOf(0), Integer.valueOf(1000), Integer.valueOf(0) });
                    ac.i("ManualDumpActivity", (String)localObject);
                    Toast.makeText(ManualDumpActivity.this.getContext(), "已成功上报", 1).show();
                    AppMethodBeat.o(38866);
                    return;
                  }
                  if (this.IKr.cuU != null)
                  {
                    if (ManualDumpActivity.f(ManualDumpActivity.this))
                    {
                      ManualDumpActivity.a(ManualDumpActivity.this).setTextColor(ManualDumpActivity.this.getResources().getColor(17170455));
                      localObject = new JSONObject();
                      try
                      {
                        this.IKr.m((JSONObject)localObject);
                        ManualDumpActivity.a(ManualDumpActivity.this).setText(((JSONObject)localObject).toString());
                        ManualDumpActivity.3.this.IKo.setVisibility(8);
                        localHashMap = new HashMap();
                        localHashMap.put("stack", ((JSONObject)localObject).toString());
                        localHashMap.put("isHardAnalyze", Boolean.valueOf(ManualDumpActivity.f(ManualDumpActivity.this)));
                        com.tencent.mm.plugin.report.service.h.wUl.f(18573, new Object[] { this.IKr.mClassName, localHashMap, Integer.valueOf(0), Integer.valueOf(1000), Integer.valueOf(1) });
                        ac.i("ManualDumpActivity", ((JSONObject)localObject).toString());
                        Toast.makeText(ManualDumpActivity.this.getContext(), "已成功上报", 1).show();
                        AppMethodBeat.o(38866);
                        return;
                      }
                      catch (JSONException localJSONException)
                      {
                        for (;;)
                        {
                          ac.printErrStackTrace("ManualDumpActivity", localJSONException, "", new Object[0]);
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
                  ManualDumpActivity.3.this.IKo.setVisibility(8);
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
                ac.printErrStackTrace("ManualDumpActivity", localIOException, "", new Object[0]);
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
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(38863);
        ManualDumpActivity.this.finish();
        AppMethodBeat.o(38863);
        return true;
      }
    });
    this.IKj = ((TextView)findViewById(2131301376));
    this.IKk = ((TextView)findViewById(2131300860));
    this.IKj.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(38864);
        ((ClipboardManager)ai.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, ManualDumpActivity.a(ManualDumpActivity.this).getText().toString()));
        com.tencent.mm.ui.base.h.cg(ManualDumpActivity.this, ManualDumpActivity.this.getString(2131755702));
        AppMethodBeat.o(38864);
        return true;
      }
    });
    this.IKi = getIntent().getStringExtra("activity");
    this.IKh = getIntent().getStringExtra("ref_key");
    ((TextView)findViewById(2131301375)).setText(this.IKi);
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