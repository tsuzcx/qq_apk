package com.tencent.tbs.one.optional;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TBSOneStandaloneService
  extends Service
{
  public static final String IMPL_CLASS_NAME_KEY = "implClassName";
  private ServiceImpl a;
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(53722);
    if (this.a == null)
    {
      AppMethodBeat.o(53722);
      return null;
    }
    paramIntent = this.a.onBind(paramIntent);
    AppMethodBeat.o(53722);
    return paramIntent;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(53725);
    super.onConfigurationChanged(paramConfiguration);
    if (this.a != null) {
      this.a.onConfigurationChanged(paramConfiguration);
    }
    AppMethodBeat.o(53725);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(53726);
    if (this.a != null) {
      this.a.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(53726);
  }
  
  public void onLowMemory()
  {
    AppMethodBeat.i(53727);
    super.onLowMemory();
    if (this.a != null) {
      this.a.onLowMemory();
    }
    AppMethodBeat.o(53727);
  }
  
  public void onRebind(Intent paramIntent)
  {
    AppMethodBeat.i(53724);
    super.onRebind(paramIntent);
    if (this.a != null) {
      this.a.onRebind(paramIntent);
    }
    AppMethodBeat.o(53724);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(53721);
    String str = paramIntent.getStringExtra("implClassName");
    if ((!TextUtils.isEmpty(str)) && ((this.a == null) || (!this.a.getClass().getName().equals(str)))) {
      if (this.a != null)
      {
        this.a.onDestroy();
        this.a = null;
      }
    }
    try
    {
      this.a = ((ServiceImpl)Class.forName(str).newInstance());
      this.a.setBaseService(this);
      label88:
      if (this.a != null) {
        this.a.onCreate();
      }
      if (this.a != null)
      {
        paramInt1 = this.a.onStartCommand(paramIntent, paramInt1, paramInt2);
        AppMethodBeat.o(53721);
        return paramInt1;
      }
      paramInt1 = super.onStartCommand(paramIntent, paramInt1, paramInt2);
      AppMethodBeat.o(53721);
      return paramInt1;
    }
    catch (Throwable localThrowable)
    {
      break label88;
    }
  }
  
  public void onTaskRemoved(Intent paramIntent)
  {
    AppMethodBeat.i(53729);
    super.onTaskRemoved(paramIntent);
    if (this.a != null) {
      this.a.onTaskRemoved(paramIntent);
    }
    AppMethodBeat.o(53729);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(53728);
    super.onTrimMemory(paramInt);
    if (this.a != null) {
      this.a.onTrimMemory(paramInt);
    }
    AppMethodBeat.o(53728);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(53723);
    if (this.a == null)
    {
      bool = super.onUnbind(paramIntent);
      AppMethodBeat.o(53723);
      return bool;
    }
    boolean bool = this.a.onUnbind(paramIntent);
    AppMethodBeat.o(53723);
    return bool;
  }
  
  public static abstract class ServiceImpl
  {
    protected Service a;
    
    public IBinder onBind(Intent paramIntent)
    {
      return null;
    }
    
    public void onConfigurationChanged(Configuration paramConfiguration) {}
    
    public void onCreate() {}
    
    public void onDestroy() {}
    
    public void onLowMemory() {}
    
    public void onRebind(Intent paramIntent) {}
    
    public abstract int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2);
    
    public void onTaskRemoved(Intent paramIntent) {}
    
    public void onTrimMemory(int paramInt) {}
    
    public boolean onUnbind(Intent paramIntent)
    {
      return false;
    }
    
    public void setBaseService(Service paramService)
    {
      this.a = paramService;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.one.optional.TBSOneStandaloneService
 * JD-Core Version:    0.7.0.1
 */