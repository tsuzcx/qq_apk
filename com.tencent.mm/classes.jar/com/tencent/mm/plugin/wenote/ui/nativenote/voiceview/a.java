package com.tencent.mm.plugin.wenote.ui.nativenote.voiceview;

import com.tencent.mm.ah.h;
import com.tencent.mm.ah.h.a;
import com.tencent.mm.ah.h.b;
import com.tencent.mm.ah.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class a
  implements h.a, h.b, SensorController.a
{
  public static volatile a rNG = null;
  private int bNM;
  public List<a.a> dhm = new LinkedList();
  public SensorController iah;
  private boolean iak = true;
  public bb ial;
  private long iam = -1L;
  private boolean ian;
  private boolean iar = false;
  public h jZC = ((i)g.r(i.class)).tl();
  public String path;
  
  private a()
  {
    au.Hx();
    Boolean localBoolean = (Boolean)c.Dz().get(26, Boolean.valueOf(false));
    this.ian = localBoolean.booleanValue();
    boolean bool;
    if (!localBoolean.booleanValue())
    {
      bool = true;
      this.iak = bool;
      if (this.jZC == null) {
        break label179;
      }
      this.jZC.a(this);
      this.jZC.a(this);
      this.jZC.aV(this.iak);
    }
    for (;;)
    {
      if (this.iah == null) {
        this.iah = new SensorController(ae.getContext());
      }
      if (this.ial == null) {
        this.ial = new bb(ae.getContext());
      }
      return;
      bool = false;
      break;
      label179:
      y.w("MicroMsg.RecordVoiceHelper", "get voice player fail, it is null");
    }
  }
  
  public static a cjx()
  {
    if (rNG == null) {}
    try
    {
      if (rNG == null) {
        rNG = new a();
      }
      return rNG;
    }
    finally {}
  }
  
  public final void a(a.a parama)
  {
    if (parama == null) {
      return;
    }
    Iterator localIterator = this.dhm.iterator();
    while (localIterator.hasNext()) {
      if (parama == (a.a)localIterator.next()) {
        return;
      }
    }
    this.dhm.add(parama);
  }
  
  public final boolean aQk()
  {
    if (this.jZC == null)
    {
      y.w("MicroMsg.RecordVoiceHelper", "check is play, but player is null");
      return false;
    }
    return this.jZC.isPlaying();
  }
  
  public final void eq(boolean paramBoolean)
  {
    boolean bool = true;
    if (bk.bl(this.path)) {}
    do
    {
      do
      {
        return;
        if (this.iar)
        {
          if (!paramBoolean) {}
          for (paramBoolean = bool;; paramBoolean = false)
          {
            this.iar = paramBoolean;
            return;
          }
        }
        if ((!paramBoolean) && (this.iam != -1L) && (bk.cp(this.iam) > 400L))
        {
          this.iar = true;
          return;
        }
        this.iar = false;
      } while ((this.jZC != null) && (this.jZC.uc()));
      if (this.ian)
      {
        if (this.jZC != null) {
          this.jZC.aV(false);
        }
        this.iak = false;
        return;
      }
      if ((this.jZC != null) && (!this.jZC.isPlaying()))
      {
        this.jZC.aV(true);
        this.iak = true;
        return;
      }
      if (this.jZC != null) {
        this.jZC.aV(paramBoolean);
      }
      this.iak = paramBoolean;
    } while (paramBoolean);
    startPlay(this.path, this.bNM);
  }
  
  public final void onError()
  {
    y.d("MicroMsg.RecordVoiceHelper", "on error, do stop play");
    stopPlay();
  }
  
  public final boolean startPlay(String paramString, int paramInt)
  {
    if (this.jZC == null)
    {
      y.w("MicroMsg.RecordVoiceHelper", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt) });
      return false;
    }
    this.jZC.stop();
    Object localObject;
    if ((this.iah != null) && (!this.iah.uil))
    {
      this.iah.a(this);
      localObject = new a.1(this);
      if (!this.ial.W((Runnable)localObject)) {
        break label178;
      }
    }
    label178:
    for (this.iam = 0L;; this.iam = -1L)
    {
      this.path = paramString;
      this.bNM = paramInt;
      if ((bk.bl(paramString)) || (!this.jZC.a(paramString, this.iak, true, paramInt))) {
        break;
      }
      ag.Zm("keep_app_silent");
      localObject = this.dhm.iterator();
      while (((Iterator)localObject).hasNext())
      {
        a.a locala = (a.a)((Iterator)localObject).next();
        if (locala != null) {
          locala.UJ(paramString);
        }
      }
    }
    return true;
  }
  
  public final void stopPlay()
  {
    y.i("MicroMsg.RecordVoiceHelper", "stop play");
    ag.Zn("keep_app_silent");
    if (this.jZC != null)
    {
      this.jZC.stop();
      Iterator localIterator = this.dhm.iterator();
      while (localIterator.hasNext())
      {
        a.a locala = (a.a)localIterator.next();
        if (locala != null) {
          locala.cjw();
        }
      }
    }
    if (this.iah != null) {
      this.iah.crJ();
    }
    if (this.ial != null) {
      this.ial.crK();
    }
  }
  
  public final double ue()
  {
    if (this.jZC == null)
    {
      y.w("MicroMsg.RecordVoiceHelper", "get now progress error, player is null");
      return 0.0D;
    }
    return this.jZC.ue();
  }
  
  public final void ug()
  {
    y.d("MicroMsg.RecordVoiceHelper", "on completion, do stop play");
    stopPlay();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a
 * JD-Core Version:    0.7.0.1
 */