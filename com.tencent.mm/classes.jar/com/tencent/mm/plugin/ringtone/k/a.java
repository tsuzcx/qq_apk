package com.tencent.mm.plugin.ringtone.k;

import android.os.Bundle;
import com.tencent.mm.plugin.audio.d.b;
import com.tencent.mm.plugin.ringtone.PluginRingtone;
import com.tencent.mm.plugin.ringtone.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/setting/BaseSceneSetting;", "", "helper", "Lcom/tencent/mm/plugin/ringtone/PluginRingtone;", "(Lcom/tencent/mm/plugin/ringtone/PluginRingtone;)V", "getHelper", "()Lcom/tencent/mm/plugin/ringtone/PluginRingtone;", "setHelper", "scene", "Lcom/tencent/mm/plugin/ringtone/IPluginRingtone$RingSence;", "getScene", "()Lcom/tencent/mm/plugin/ringtone/IPluginRingtone$RingSence;", "setScene", "(Lcom/tencent/mm/plugin/ringtone/IPluginRingtone$RingSence;)V", "dealParams", "", "bundle", "Landroid/os/Bundle;", "responseBadNet", "streamType", "", "responseClose", "responsePause", "responseScene", "", "responseStop", "Companion", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
{
  public static final a.a OEu = new a.a((byte)0);
  private PluginRingtone OEv;
  public com.tencent.mm.plugin.ringtone.a.a OEw;
  
  public a(PluginRingtone paramPluginRingtone)
  {
    this.OEv = paramPluginRingtone;
    this.OEw = com.tencent.mm.plugin.ringtone.a.a.OBd;
  }
  
  public final void a(com.tencent.mm.plugin.ringtone.a.a parama)
  {
    s.u(parama, "<set-?>");
    this.OEw = parama;
  }
  
  public final boolean aP(Bundle paramBundle)
  {
    s.u(paramBundle, "bundle");
    String str = paramBundle.getString("scene");
    if (str != null) {
      return u(str, paramBundle);
    }
    return false;
  }
  
  protected final boolean ahA(int paramInt)
  {
    Object localObject1 = com.tencent.mm.plugin.audio.c.a.uVi;
    localObject1 = b.uVo;
    if (!b.cTX())
    {
      localObject1 = com.tencent.mm.plugin.audio.c.a.uVi;
      if (!com.tencent.mm.plugin.audio.c.a.a.cTW().cTQ())
      {
        localObject1 = com.tencent.mm.plugin.audio.c.a.uVi;
        if (com.tencent.mm.plugin.audio.c.a.a.cUh() != 0)
        {
          localObject1 = com.tencent.mm.plugin.audio.c.a.uVi;
          if (com.tencent.mm.plugin.audio.c.a.a.cUh() != 1) {}
        }
        else
        {
          return false;
        }
      }
    }
    try
    {
      this.OEv.setUpRingtoneInfo(a.b.OBj, paramInt, false);
      this.OEv.updateRingtoneInfo(null, false, 0L);
      localObject1 = this.OEv;
      com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.uVi;
      ((PluginRingtone)localObject1).startPlaySound(com.tencent.mm.plugin.audio.c.a.a.cTW().cTU());
      return true;
    }
    finally
    {
      Log.w("MicroMsg.BaseSceneSetting", "playSound Failed Throwable t = ", new Object[] { localObject2 });
    }
    return false;
  }
  
  protected final boolean ahz(int paramInt)
  {
    Object localObject1 = com.tencent.mm.plugin.audio.c.a.uVi;
    localObject1 = b.uVo;
    if (!b.cTX())
    {
      localObject1 = com.tencent.mm.plugin.audio.c.a.uVi;
      if (!com.tencent.mm.plugin.audio.c.a.a.cTW().cTQ())
      {
        localObject1 = com.tencent.mm.plugin.audio.c.a.uVi;
        if (com.tencent.mm.plugin.audio.c.a.a.cUh() != 0)
        {
          localObject1 = com.tencent.mm.plugin.audio.c.a.uVi;
          if (com.tencent.mm.plugin.audio.c.a.a.cUh() != 1) {}
        }
        else
        {
          return false;
        }
      }
    }
    try
    {
      this.OEv.setUpRingtoneInfo(a.b.OBj, paramInt, false);
      this.OEv.updateRingtoneInfo(null, false, 0L);
      localObject1 = com.tencent.mm.plugin.audio.c.a.uVi;
      localObject1 = b.uVo;
      if (!b.cTX())
      {
        localObject1 = com.tencent.mm.plugin.audio.c.a.uVi;
        if (!com.tencent.mm.plugin.audio.c.a.a.cTW().cTQ()) {}
      }
      else
      {
        this.OEv.adjustVolume(0.5F, 0.5F);
      }
      localObject1 = this.OEv;
      com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.uVi;
      ((PluginRingtone)localObject1).startPlaySound(com.tencent.mm.plugin.audio.c.a.a.cTW().cTU());
      return true;
    }
    finally
    {
      Log.w("MicroMsg.BaseSceneSetting", "playSound Failed Throwable t = ", new Object[] { localObject2 });
    }
    return false;
  }
  
  public final PluginRingtone gOL()
  {
    return this.OEv;
  }
  
  protected final boolean gOM()
  {
    this.OEv.pausePlay();
    return true;
  }
  
  protected final boolean gON()
  {
    this.OEv.stopPlay();
    return true;
  }
  
  protected abstract boolean u(String paramString, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.k.a
 * JD-Core Version:    0.7.0.1
 */