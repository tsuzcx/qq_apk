package com.tencent.mm.plugin.record.b;

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

public final class m
  implements h.a, h.b, SensorController.a
{
  public static SensorController iah;
  private int bNM;
  public List<m.a> dhm = new LinkedList();
  private boolean iak = true;
  private bb ial;
  long iam = -1L;
  private boolean ian;
  private boolean iar = false;
  public h jZC = ((i)g.r(i.class)).tl();
  public String path;
  
  public m()
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
        break label177;
      }
      this.jZC.a(this);
      this.jZC.a(this);
      this.jZC.aV(this.iak);
    }
    for (;;)
    {
      if (iah == null) {
        iah = new SensorController(ae.getContext());
      }
      if (this.ial == null) {
        this.ial = new bb(ae.getContext());
      }
      return;
      bool = false;
      break;
      label177:
      y.w("MicroMsg.RecordVoiceHelper", "get voice player fail, it is null");
    }
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
  
  public final void axa()
  {
    if (iah != null) {
      iah.crJ();
    }
    if (this.ial != null) {
      this.ial.crK();
    }
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
    Iterator localIterator = this.dhm.iterator();
    while (localIterator.hasNext()) {
      ((m.a)localIterator.next()).onFinish();
    }
  }
  
  public final boolean startPlay(String paramString, int paramInt)
  {
    if (this.jZC == null)
    {
      y.w("MicroMsg.RecordVoiceHelper", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt) });
      return false;
    }
    this.jZC.stop();
    Object localObject = this.dhm.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((m.a)((Iterator)localObject).next()).LI(paramString);
    }
    if ((iah != null) && (!iah.uil))
    {
      iah.a(this);
      localObject = new Runnable()
      {
        public final void run()
        {
          m.this.iam = bk.UZ();
        }
      };
      if (!this.ial.W((Runnable)localObject)) {
        break label168;
      }
    }
    label168:
    for (this.iam = 0L;; this.iam = -1L)
    {
      this.path = paramString;
      this.bNM = paramInt;
      if ((bk.bl(paramString)) || (!this.jZC.a(paramString, this.iak, true, paramInt))) {
        break;
      }
      ag.Zm("keep_app_silent");
      return true;
    }
    return false;
  }
  
  public final void stopPlay()
  {
    y.d("MicroMsg.RecordVoiceHelper", "stop play");
    ag.Zn("keep_app_silent");
    if (this.jZC != null) {
      this.jZC.stop();
    }
    axa();
  }
  
  public final void ug()
  {
    y.d("MicroMsg.RecordVoiceHelper", "on completion, do stop play");
    stopPlay();
    Iterator localIterator = this.dhm.iterator();
    while (localIterator.hasNext()) {
      ((m.a)localIterator.next()).onFinish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.m
 * JD-Core Version:    0.7.0.1
 */