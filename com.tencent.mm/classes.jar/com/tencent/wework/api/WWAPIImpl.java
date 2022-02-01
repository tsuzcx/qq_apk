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
  private static final ArrayList<String> ZYg;
  private static final ArrayList<String> ZYh;
  private static boolean xFl;
  private String ZYf;
  private BroadcastReceiver ZYi;
  private Map<String, Object> callbacks;
  private Context context;
  private SharedPreferences mPreferences;
  
  static
  {
    AppMethodBeat.i(106537);
    ZYg = new ArrayList() {};
    ZYh = new ArrayList() {};
    xFl = false;
    AppMethodBeat.o(106537);
  }
  
  WWAPIImpl(Context paramContext)
  {
    AppMethodBeat.i(106530);
    this.callbacks = new HashMap();
    this.ZYi = new BroadcastReceiver()
    {
      public void onReceive(final Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(233284);
        try
        {
          boolean bool = WWAPIImpl.a(WWAPIImpl.this).equals(paramAnonymousIntent.getScheme());
          if (!bool)
          {
            AppMethodBeat.o(233284);
            return;
          }
          paramAnonymousContext = BaseMessage.t(paramAnonymousIntent.getData());
          paramAnonymousContext.bEy(WWAPIImpl.b(WWAPIImpl.this).getString("sk", ""));
          paramAnonymousContext.fromBundle(paramAnonymousIntent.getExtras());
          if ((paramAnonymousContext instanceof WWBaseRespMessage)) {
            new Handler(Looper.getMainLooper()).post(new Runnable()
            {
              public void run()
              {
                AppMethodBeat.i(233279);
                try
                {
                  WWAPIImpl.c(WWAPIImpl.this).get(((WWBaseRespMessage)paramAnonymousContext).transaction);
                  WWAPIImpl.c(WWAPIImpl.this).remove(((WWBaseRespMessage)paramAnonymousContext).transaction);
                  AppMethodBeat.o(233279);
                  return;
                }
                catch (Throwable localThrowable)
                {
                  AppMethodBeat.o(233279);
                }
              }
            });
          }
          AppMethodBeat.o(233284);
          return;
        }
        catch (Throwable paramAnonymousContext)
        {
          AppMethodBeat.o(233284);
        }
      }
    };
    this.mPreferences = null;
    this.context = paramContext;
    this.mPreferences = paramContext.getSharedPreferences("wxwork_wwapi_store", 0);
    AppMethodBeat.o(106530);
  }
  
  private int bEv(String paramString)
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
  
  public final boolean ivm()
  {
    AppMethodBeat.i(106531);
    ArrayList localArrayList = ZYg;
    Object localObject = localArrayList;
    if (this.context != null)
    {
      localObject = localArrayList;
      if (!TextUtils.equals(this.context.getPackageName(), "com.tencent.mm")) {
        localObject = ZYh;
      }
    }
    localObject = ((List)localObject).iterator();
    int i;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      i = bEv((String)((Iterator)localObject).next());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wework.api.WWAPIImpl
 * JD-Core Version:    0.7.0.1
 */