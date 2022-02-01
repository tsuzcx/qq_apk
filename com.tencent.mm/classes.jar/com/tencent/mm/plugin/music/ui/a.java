package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.ref.WeakReference;

public final class a
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  private TextView And;
  private f Ane;
  private IListener lEl;
  private View oQL;
  private View oQM;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(63196);
    this.Ane = null;
    if (this.view != null)
    {
      this.And = ((TextView)this.view.findViewById(2131305083));
      this.oQL = this.view.findViewById(2131305084);
      this.oQM = this.view.findViewById(2131297327);
      this.And.setTextSize(0, com.tencent.mm.cb.a.aG(MMApplicationContext.getContext(), 2131165482));
      this.view.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(63194);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/music/ui/MusicBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          paramAnonymousView = com.tencent.mm.ay.a.bef();
          if ((paramAnonymousView != null) && (paramAnonymousView.jfu) && (!TextUtils.isEmpty(paramAnonymousView.jfv)))
          {
            paramAnonymousView = paramAnonymousView.jfv;
            Log.i("MusicBanner", "barBackToWebView is true, start to jump Url:%s", new Object[] { paramAnonymousView });
            localObject = new Intent();
            ((Intent)localObject).putExtra("rawUrl", paramAnonymousView);
            c.b((Context)a.this.Kgr.get(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/music/ui/MusicBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(63194);
            return;
            paramAnonymousView = new Intent();
            h.CyF.a(11992, new Object[] { Integer.valueOf(1) });
            paramAnonymousView.putExtra("key_scene", 1);
            c.b((Context)a.this.Kgr.get(), "music", ".ui.MusicMainUI", paramAnonymousView);
          }
        }
      });
    }
    this.lEl = new IListener() {};
    EventCenter.instance.addListener(this.lEl);
    AppMethodBeat.o(63196);
  }
  
  private void aIa(String paramString)
  {
    AppMethodBeat.i(63200);
    if (this.And != null) {
      this.And.setText(paramString);
    }
    AppMethodBeat.o(63200);
  }
  
  private boolean evf()
  {
    AppMethodBeat.i(63201);
    f localf;
    if ((this.isFirst) && (this.ifo))
    {
      this.oQM.setBackgroundResource(2131235299);
      this.oQL.setBackground(null);
      this.And.setBackground(null);
      if (!com.tencent.mm.ay.a.bec()) {
        break label250;
      }
      localf = com.tencent.mm.ay.a.bef();
      this.Ane = localf;
      aIa(MMApplicationContext.getContext().getString(2131763333) + MMApplicationContext.getContext().getString(2131763334) + localf.jeX);
      if (!localf.jfr) {
        break label238;
      }
    }
    label238:
    for (int i = 8;; i = 0)
    {
      setVisibility(i);
      this.Ane = null;
      if (localf.jfr) {
        break label243;
      }
      AppMethodBeat.o(63201);
      return true;
      if (this.isFirst)
      {
        this.oQM.setBackgroundResource(2131233332);
        this.oQL.setBackgroundResource(2131233330);
        this.And.setBackgroundResource(2131233327);
        break;
      }
      if (this.ifo)
      {
        this.oQM.setBackgroundResource(2131233332);
        this.oQL.setBackgroundResource(2131233327);
        this.And.setBackground(null);
        break;
      }
      this.oQM.setBackgroundResource(2131233332);
      this.oQL.setBackground(null);
      this.And.setBackgroundResource(2131233327);
      break;
    }
    label243:
    AppMethodBeat.o(63201);
    return false;
    label250:
    if (com.tencent.mm.ay.a.bed())
    {
      setVisibility(0);
      AppMethodBeat.o(63201);
      return true;
    }
    setVisibility(8);
    AppMethodBeat.o(63201);
    return false;
  }
  
  public final boolean bYa()
  {
    AppMethodBeat.i(63198);
    boolean bool = evf();
    AppMethodBeat.o(63198);
    return bool;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(63199);
    EventCenter.instance.removeListener(this.lEl);
    AppMethodBeat.o(63199);
  }
  
  public final int getLayoutId()
  {
    return 2131495767;
  }
  
  public final int getOrder()
  {
    return 1;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(63197);
    if (this.view != null)
    {
      View localView = this.view.findViewById(2131305084);
      if (paramInt == 0)
      {
        if (com.tencent.mm.compatible.e.b.cx(MMApplicationContext.getContext()))
        {
          Log.e("MicroMsg.MusicBanner", "isFloatWindowOpAllowed return true");
          localView.setVisibility(8);
          if (com.tencent.mm.ay.a.bec())
          {
            Log.i("MicroMsg.MusicBanner", "resume music to float ball");
            com.tencent.mm.plugin.music.model.b.x(this.Ane);
            AppMethodBeat.o(63197);
          }
        }
        else
        {
          Log.e("MicroMsg.MusicBanner", "isFloatWindowOpAllowed return false");
        }
      }
      else {
        localView.setVisibility(paramInt);
      }
    }
    AppMethodBeat.o(63197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.a
 * JD-Core Version:    0.7.0.1
 */