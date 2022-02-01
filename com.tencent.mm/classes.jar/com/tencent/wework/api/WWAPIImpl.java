package com.tencent.wework.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
  private static boolean Bcz;
  private static final ArrayList<String> aicF;
  private static final ArrayList<String> aicG;
  private Map<String, Object> Lfc;
  private String aicE;
  private Callbacks.SessionKeyUpdateCallback aicH;
  private BroadcastReceiver aicI;
  private Context context;
  SharedPreferences mPreferences;
  
  static
  {
    AppMethodBeat.i(106537);
    aicF = new ArrayList() {};
    aicG = new ArrayList() {};
    Bcz = false;
    AppMethodBeat.o(106537);
  }
  
  WWAPIImpl(Context paramContext)
  {
    AppMethodBeat.i(106530);
    this.Lfc = new HashMap();
    this.aicH = null;
    this.aicI = new BroadcastReceiver()
    {
      public void onReceive(final Context paramAnonymousContext, final Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(210544);
        try
        {
          boolean bool = WWAPIImpl.a(WWAPIImpl.this).equals(paramAnonymousIntent.getScheme());
          if (!bool) {
            return;
          }
          paramAnonymousContext = BaseMessage.w(paramAnonymousIntent.getData());
          paramAnonymousContext.bGX(WWAPIImpl.b(WWAPIImpl.this).getString("sk", ""));
          paramAnonymousContext.fromBundle(paramAnonymousIntent.getExtras());
          paramAnonymousIntent = ((WWBaseRespMessage)paramAnonymousContext).aicV;
          if (!TextUtils.isEmpty(paramAnonymousIntent)) {
            WWAPIImpl.this.mPreferences.edit().putString("sk", paramAnonymousIntent).commit();
          }
          if ((paramAnonymousContext instanceof WWBaseRespMessage)) {
            new Handler(Looper.getMainLooper()).post(new Runnable()
            {
              public void run()
              {
                AppMethodBeat.i(210546);
                try
                {
                  WWAPIImpl.c(WWAPIImpl.this).get(((WWBaseRespMessage)paramAnonymousContext).transaction);
                  label31:
                  WWAPIImpl.c(WWAPIImpl.this).remove(((WWBaseRespMessage)paramAnonymousContext).transaction);
                  try
                  {
                    if (!TextUtils.isEmpty(paramAnonymousIntent)) {
                      WWAPIImpl.d(WWAPIImpl.this);
                    }
                  }
                  finally
                  {
                    AppMethodBeat.o(210546);
                    return;
                  }
                }
                finally
                {
                  break label31;
                }
              }
            });
          }
          return;
        }
        finally
        {
          AppMethodBeat.o(210544);
        }
      }
    };
    this.mPreferences = null;
    this.context = paramContext;
    this.mPreferences = paramContext.getSharedPreferences("wxwork_wwapi_store", 0);
    AppMethodBeat.o(106530);
  }
  
  private int bGU(String paramString)
  {
    AppMethodBeat.i(106533);
    try
    {
      paramString = this.context.getPackageManager().getPackageInfo(paramString, 128);
      if (paramString == null) {
        return 0;
      }
      int i = paramString.versionCode;
      return i;
    }
    finally
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
  
  public final boolean keI()
  {
    AppMethodBeat.i(106531);
    ArrayList localArrayList = aicF;
    Object localObject = localArrayList;
    if (this.context != null)
    {
      localObject = localArrayList;
      if (!TextUtils.equals(this.context.getPackageName(), "com.tencent.mm")) {
        localObject = aicG;
      }
    }
    localObject = ((List)localObject).iterator();
    int i;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      i = bGU((String)((Iterator)localObject).next());
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