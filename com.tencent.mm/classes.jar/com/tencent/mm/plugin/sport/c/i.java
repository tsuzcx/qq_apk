package com.tencent.mm.plugin.sport.c;

import android.os.RemoteException;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.sdk.platformtools.ae;

public final class i
{
  public static long Q(int paramInt, long paramLong)
  {
    if (ae.cqV()) {
      return ((PluginSport)g.t(PluginSport.class)).getSportFileStorage().getLong(paramInt, paramLong);
    }
    return new h(com.tencent.mm.plugin.sport.b.a.ptb).getLong(paramInt, paramLong);
  }
  
  public static void R(int paramInt, long paramLong)
  {
    if (ae.cqV())
    {
      ((PluginSport)g.t(PluginSport.class)).getSportFileStorage().setLong(paramInt, paramLong);
      return;
    }
    throw new RuntimeException(String.format("not support set value in %s process", new Object[] { ae.getProcessName() }));
  }
  
  public static void S(int paramInt, long paramLong)
  {
    if (ae.cqZ()) {
      ((PluginSport)g.t(PluginSport.class)).getSportFileStorage().setLong(paramInt, paramLong);
    }
    com.tencent.mm.plugin.sport.a.a locala;
    do
    {
      do
      {
        return;
      } while (!ae.cqV());
      locala = ((PluginSport)g.t(PluginSport.class)).getDeviceStepManager().ptg;
    } while (locala == null);
    try
    {
      locala.P(paramInt, paramLong);
      return;
    }
    catch (RemoteException localRemoteException) {}
  }
  
  public static h bLr()
  {
    if (ae.cqV()) {
      return new h(com.tencent.mm.plugin.sport.b.a.ptb);
    }
    if (ae.cqZ()) {
      return new h(com.tencent.mm.plugin.sport.b.a.pta);
    }
    return null;
  }
  
  public static long zl(int paramInt)
  {
    if (ae.cqZ()) {
      return ((PluginSport)g.t(PluginSport.class)).getSportFileStorage().getLong(paramInt, 0L);
    }
    if (ae.cqV())
    {
      com.tencent.mm.plugin.sport.a.a locala = ((PluginSport)g.t(PluginSport.class)).getDeviceStepManager().ptg;
      if (locala != null) {
        try
        {
          long l = locala.getLong(paramInt, 0L);
          return l;
        }
        catch (RemoteException localRemoteException) {}
      }
    }
    return new h(com.tencent.mm.plugin.sport.b.a.pta).getLong(paramInt, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.c.i
 * JD-Core Version:    0.7.0.1
 */