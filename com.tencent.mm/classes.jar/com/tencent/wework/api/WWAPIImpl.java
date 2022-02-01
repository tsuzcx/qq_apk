package com.tencent.wework.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wework.api.model.BaseMessage;
import com.tencent.wework.api.model.WWBaseRespMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class WWAPIImpl
  implements IWWAPI
{
  private static final ArrayList<String> Sxg;
  private static final ArrayList<String> Sxh;
  private static boolean tUq;
  private String Sxf;
  private BroadcastReceiver Sxi;
  private Map<String, Object> callbacks;
  private Context context;
  private SharedPreferences mPreferences;
  
  static
  {
    AppMethodBeat.i(106537);
    Sxg = new WWAPIImpl.1();
    Sxh = new WWAPIImpl.2();
    tUq = false;
    AppMethodBeat.o(106537);
  }
  
  WWAPIImpl(Context paramContext)
  {
    AppMethodBeat.i(106530);
    this.callbacks = new HashMap();
    this.Sxi = new BroadcastReceiver()
    {
      public void onReceive(final Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(198984);
        try
        {
          boolean bool = WWAPIImpl.a(WWAPIImpl.this).equals(paramAnonymousIntent.getScheme());
          if (!bool)
          {
            AppMethodBeat.o(198984);
            return;
          }
          paramAnonymousContext = BaseMessage.A(paramAnonymousIntent.getData());
          paramAnonymousContext.brz(WWAPIImpl.b(WWAPIImpl.this).getString("sk", ""));
          paramAnonymousContext.fromBundle(paramAnonymousIntent.getExtras());
          if ((paramAnonymousContext instanceof WWBaseRespMessage)) {
            new Handler(Looper.getMainLooper()).post(new Runnable()
            {
              public void run()
              {
                AppMethodBeat.i(198983);
                try
                {
                  WWAPIImpl.c(WWAPIImpl.this).get(((WWBaseRespMessage)paramAnonymousContext).transaction);
                  WWAPIImpl.c(WWAPIImpl.this).remove(((WWBaseRespMessage)paramAnonymousContext).transaction);
                  AppMethodBeat.o(198983);
                  return;
                }
                catch (Throwable localThrowable)
                {
                  AppMethodBeat.o(198983);
                }
              }
            });
          }
          AppMethodBeat.o(198984);
          return;
        }
        catch (Throwable paramAnonymousContext)
        {
          AppMethodBeat.o(198984);
        }
      }
    };
    this.mPreferences = null;
    this.context = paramContext;
    this.mPreferences = paramContext.getSharedPreferences("wxwork_wwapi_store", 0);
    AppMethodBeat.o(106530);
  }
  
  private int brw(String paramString)
  {
    AppMethodBeat.i(106533);
    try
    {
      paramString = this.context.getPackageManager().getPackageInfo(paramString, 128);
      if (paramString == null)
      {
        AppMethodBeat.o(106533);
        return 0;
      }
      int i = paramString.versionCode;
      AppMethodBeat.o(106533);
      return i;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(106533);
    }
    return 0;
  }
  
  public final boolean a(IWWAPI.WWAppType paramWWAppType)
  {
    return false;
  }
  
  public final boolean a(BaseMessage paramBaseMessage, IWWAPI.WWAppType paramWWAppType)
  {
    return false;
  }
  
  public final String b(IWWAPI.WWAppType paramWWAppType)
  {
    return null;
  }
  
  public final boolean hrE()
  {
    AppMethodBeat.i(106531);
    ArrayList localArrayList = Sxg;
    Object localObject = localArrayList;
    if (this.context != null)
    {
      localObject = localArrayList;
      if (!TextUtils.equals(this.context.getPackageName(), "com.tencent.mm")) {
        localObject = Sxh;
      }
    }
    localObject = ((List)localObject).iterator();
    int i;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      i = brw((String)((Iterator)localObject).next());
    } while (i == 0);
    while (i >= 100)
    {
      AppMethodBeat.o(106531);
      return true;
      i = 0;
    }
    AppMethodBeat.o(106531);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wework.api.WWAPIImpl
 * JD-Core Version:    0.7.0.1
 */