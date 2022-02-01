package com.tencent.mm.plugin.wepkg.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.q.a;
import com.tencent.mm.autogen.a.aee;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.wepkg.e;
import com.tencent.mm.plugin.wepkg.model.k;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.List;

public class c
{
  public IListener XGW;
  public final IListener XGX;
  public q.a appForegroundListener;
  
  public c()
  {
    AppMethodBeat.i(110795);
    this.appForegroundListener = new q.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(110787);
        if ((h.baz()) && (h.baC().mBZ))
        {
          h.baC();
          if (!b.aZG())
          {
            paramAnonymousString = new aee();
            paramAnonymousString.iiI.hAf = 3;
            paramAnonymousString.publish();
          }
        }
        AppMethodBeat.o(110787);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(110786);
        if ((h.baz()) && (h.baC().mBZ))
        {
          h.baC();
          if (!b.aZG())
          {
            paramAnonymousString = new aee();
            paramAnonymousString.iiI.hAf = 5;
            paramAnonymousString.publish();
          }
        }
        AppMethodBeat.o(110786);
      }
    };
    this.XGW = new WepkgListener.2(this, com.tencent.mm.app.f.hfK);
    this.XGX = new WepkgListener.3(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(110795);
  }
  
  public static void iFz()
  {
    AppMethodBeat.i(278666);
    Object localObject = MMApplicationContext.getContext();
    if (localObject == null)
    {
      AppMethodBeat.o(278666);
      return;
    }
    try
    {
      localObject = ((Context)localObject).getSharedPreferences("we_pkg_sp", 4);
      if (localObject == null)
      {
        Log.e("MicroMsg.Wepkg.WepkgListener", "sp is null");
        AppMethodBeat.o(278666);
        return;
      }
      if (((SharedPreferences)localObject).getBoolean("disable_we_pkg", false))
      {
        Log.i("MicroMsg.Wepkg.WepkgListener", "enable wepkg");
        ((SharedPreferences)localObject).edit().putBoolean("disable_we_pkg", false).commit();
      }
      ((SharedPreferences)localObject).edit().putInt("white_screen_times", 0).commit();
      AppMethodBeat.o(278666);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.Wepkg.WepkgListener", localException.getMessage());
      AppMethodBeat.o(278666);
    }
  }
  
  static class a
    implements d
  {
    public void invoke(Object paramObject, com.tencent.mm.ipcinvoker.f paramf)
    {
      AppMethodBeat.i(110794);
      e.iET();
      AppMethodBeat.o(110794);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.c
 * JD-Core Version:    0.7.0.1
 */