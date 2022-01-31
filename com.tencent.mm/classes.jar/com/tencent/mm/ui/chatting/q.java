package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.media.ToneGenerator;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.j.a;
import com.tencent.mm.ah.j.b;
import com.tencent.mm.ai.d.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.h.a.ne;
import com.tencent.mm.h.a.td;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.plugin.subapp.c.i;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.chatting.b.b.aa;
import com.tencent.mm.ui.chatting.b.b.ac;
import com.tencent.mm.ui.chatting.b.b.ai;
import com.tencent.mm.ui.x;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class q
  implements com.tencent.mm.pluginsdk.ui.chat.b
{
  public static boolean vjI = true;
  private ad dnp;
  private final am eNb = new am(new am.a()
  {
    public final boolean tC()
    {
      q.d(q.this).Ek(q.a(q.this).getMaxAmplitude());
      return true;
    }
  }, true);
  private final am ibI = new am(new q.9(this), true);
  private final j.a ibK = new q.1(this);
  private ToneGenerator ibo;
  private Vibrator ibr;
  private Object lock = new Object();
  private ChatFooter maV;
  private AppPanel.a mbH = new q.10(this);
  private final j.b mba = new q.4(this);
  com.tencent.mm.ui.chatting.c.a uPh;
  private boolean vgB;
  private com.tencent.mm.ah.j vjJ;
  private String vjK;
  private String vjL;
  private boolean vjM;
  private boolean vjN;
  public boolean vjO;
  private volatile boolean vjP = false;
  private volatile boolean vjQ = false;
  private boolean vjR = false;
  
  public q(com.tencent.mm.ui.chatting.c.a parama, ChatFooter paramChatFooter, String paramString)
  {
    this.uPh = parama;
    this.maV = paramChatFooter;
    this.vjK = paramString;
    au.Hx();
    this.dnp = c.Fw().abl(paramString);
    this.vjM = s.fn(this.uPh.getTalkerUserName());
    this.vjN = s.hf(this.uPh.getTalkerUserName());
    boolean bool;
    if ((this.vjM) || (this.vjN))
    {
      bool = true;
      this.vgB = bool;
      this.ibr = ((Vibrator)this.uPh.vtz.getContext().getSystemService("vibrator"));
      if (!s.hH(this.vjK)) {
        break label280;
      }
      this.vjJ = new i();
      y.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new VoiceRemindRecorder().");
    }
    for (;;)
    {
      this.vjJ.a(this.mba);
      this.vjJ.a(this.ibK);
      paramChatFooter.setAppPanelListener(this.mbH);
      return;
      bool = false;
      break;
      label280:
      parama = this.vjK;
      int i;
      if (s.hS(parama)) {
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label461;
        }
        this.vjJ = new com.tencent.mm.f.b.h(this.uPh.vtz.getContext(), true);
        y.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new SceneVoiceRecorder, use Speex");
        break;
        parama = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(parama);
        if ((parama != null) && (parama.cua()))
        {
          paramString = f.kX(parama.field_username);
          if (paramString != null)
          {
            paramString = paramString.bS(false);
            if (paramString != null)
            {
              if (paramString.efa != null) {
                paramString.efe = "1".equals(paramString.efa.optString("CanReceiveSpeexVoice"));
              }
              if (paramString.efe)
              {
                y.i("MicroMsg.BizInfoStorageLogic", "bizinfo name=" + parama.field_username + " canReceiveSpeexVoice");
                i = 1;
                continue;
              }
            }
          }
        }
        i = 0;
      }
      label461:
      this.vjJ = new com.tencent.mm.f.b.h(this.uPh.vtz.getContext(), false);
      y.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new SceneVoiceRecorder, not use Speex");
    }
  }
  
  private static void GO(int paramInt)
  {
    ne localne = new ne();
    localne.bWW.state = paramInt;
    com.tencent.mm.sdk.b.a.udP.m(localne);
  }
  
  private void cCF()
  {
    com.tencent.mm.ui.chatting.c.a locala = this.uPh;
    y.i("MicroMsg.ChattingContext", "[smoothScrollBy] dis:%s duration:%s", new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
    locala.vtA.cCX();
  }
  
  @Deprecated
  @SuppressLint({"NewApi"})
  private void cCG()
  {
    com.tencent.mm.ui.chatting.c.a locala = this.uPh;
    y.i("MicroMsg.ChattingContext", "[scrollToLast] force:%b", new Object[] { Boolean.valueOf(true) });
    locala.vtA.nk(true);
  }
  
  private boolean cCH()
  {
    this.uPh.vtz.enableOptionMenu(true);
    this.uPh.vtz.enableBackMenu(true);
    if (this.vjJ != null)
    {
      int i;
      label75:
      boolean bool;
      long l;
      if (this.vjJ.isRecording()) {
        if ((this.dnp.field_username.equals("medianote")) && ((com.tencent.mm.model.q.Gn() & 0x4000) == 0))
        {
          i = 1;
          if (i == 0) {
            break label244;
          }
          i = 1;
          bool = this.vjJ.un();
          this.eNb.stopTimer();
          this.ibI.stopTimer();
          if (i != 0)
          {
            bi localbi = new bi();
            localbi.ec("medianote");
            localbi.setType(34);
            localbi.fA(1);
            localbi.ed(this.vjL);
            localbi.setStatus(2);
            localbi.setContent(n.d(com.tencent.mm.model.q.Gj(), this.vjJ.ux(), false));
            localbi.bg(com.tencent.mm.model.bd.iK("medianote"));
            if (this.vjJ.uA() == 2) {
              localbi.cY("SOURCE_SILK_FILE");
            }
            au.Hx();
            l = c.Fy().T(localbi);
            if (l > 0L) {
              break label249;
            }
            y.e("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg fail");
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ag.Zn("keep_app_silent");
        return bool;
        i = 0;
        break;
        label244:
        i = 0;
        break label75;
        label249:
        y.i("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg success, msgId = " + l);
      }
    }
    y.i("MicroMsg.ChattingFooterEventImpl", "stopRecording recorder == null");
    return false;
  }
  
  private void releaseWakeLock()
  {
    this.uPh.setKeepScreenOn(false);
  }
  
  public final void D(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent == null) || (paramMotionEvent.getAction() == 1))
    {
      cCG();
      cCF();
    }
  }
  
  public final void GP(int paramInt)
  {
    boolean bool = com.tencent.mm.pluginsdk.permission.a.a(this.uPh.vtz.getContext(), "android.permission.CAMERA", 18, "", "");
    y.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bk.csb(), this.uPh.vtz.getContext() });
    if (!bool) {}
    do
    {
      do
      {
        return;
        bool = com.tencent.mm.pluginsdk.permission.a.a(this.uPh.vtz.getContext(), "android.permission.RECORD_AUDIO", 18, "", "");
        y.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bk.csb(), this.uPh.vtz.getContext() });
      } while (!bool);
      if ((com.tencent.mm.sdk.a.b.cqk()) || (com.tencent.mm.platformtools.ae.eTI))
      {
        com.tencent.mm.ui.tools.j localj = new com.tencent.mm.ui.tools.j(this.uPh.vtz.getContext());
        localj.phH = new q.2(this);
        localj.phI = new q.3(this, paramInt);
        localj.bJQ();
        return;
      }
    } while (com.tencent.mm.platformtools.ae.eTJ);
    com.tencent.mm.plugin.report.service.h.nFQ.f(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
    l.a(this.uPh.vtz, new Intent(), getTalkerUserName(), paramInt);
  }
  
  public final boolean GU(String paramString)
  {
    cCG();
    cCF();
    return ((ac)this.uPh.ac(ac.class)).adw(paramString);
  }
  
  public final boolean bhf()
  {
    synchronized (this.lock)
    {
      this.vjP = true;
      if (!this.vjQ)
      {
        y.i("MicroMsg.ChattingFooterEventImpl", "jacks in voice rcd stop but not begin.");
        return false;
      }
    }
    this.vjQ = false;
    releaseWakeLock();
    if (!cCH())
    {
      this.maV.cnh();
      y.i("MicroMsg.ChattingFooterEventImpl", "record stop on stop request setRcdTooShort");
    }
    for (;;)
    {
      ((ai)this.uPh.ac(ai.class)).cFx().cBX();
      ((aa)this.uPh.ac(aa.class)).Hf(4);
      ((aa)this.uPh.ac(aa.class)).stopSignalling();
      GO(1);
      ((ai)this.uPh.ac(ai.class)).a(this.uPh.vtz, false);
      return true;
      this.maV.aRj();
      y.i("MicroMsg.ChattingFooterEventImpl", "record stop on stop request resetRcdStatus");
    }
  }
  
  public final boolean bhh()
  {
    y.v("MicroMsg.ChattingFooterEventImpl", "record cancel on cancel request");
    synchronized (this.lock)
    {
      this.vjP = true;
      if (!this.vjQ)
      {
        y.i("MicroMsg.ChattingFooterEventImpl", "jacks in voice rcd stop but not begin.");
        return false;
      }
    }
    this.vjQ = false;
    releaseWakeLock();
    this.uPh.vtz.enableOptionMenu(true);
    this.uPh.vtz.enableBackMenu(true);
    if (this.vjJ != null)
    {
      this.vjJ.cancel();
      this.eNb.stopTimer();
      this.ibI.stopTimer();
    }
    this.maV.aRj();
    ((ai)this.uPh.ac(ai.class)).cFx().cBX();
    ((aa)this.uPh.ac(aa.class)).Hf(4);
    ((aa)this.uPh.ac(aa.class)).stopSignalling();
    GO(1);
    ((ai)this.uPh.ac(ai.class)).a(this.uPh.vtz, false);
    return true;
  }
  
  /* Error */
  public final boolean bhi()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 94	com/tencent/mm/ui/chatting/q:uPh	Lcom/tencent/mm/ui/chatting/c/a;
    //   4: getfield 143	com/tencent/mm/ui/chatting/c/a:vtz	Lcom/tencent/mm/ui/chatting/e;
    //   7: invokevirtual 149	com/tencent/mm/ui/chatting/e:getContext	()Landroid/app/Activity;
    //   10: invokestatic 788	com/tencent/mm/r/a:bk	(Landroid/content/Context;)Z
    //   13: ifne +19 -> 32
    //   16: aload_0
    //   17: getfield 94	com/tencent/mm/ui/chatting/q:uPh	Lcom/tencent/mm/ui/chatting/c/a;
    //   20: getfield 143	com/tencent/mm/ui/chatting/c/a:vtz	Lcom/tencent/mm/ui/chatting/e;
    //   23: invokevirtual 149	com/tencent/mm/ui/chatting/e:getContext	()Landroid/app/Activity;
    //   26: invokestatic 791	com/tencent/mm/r/a:bi	(Landroid/content/Context;)Z
    //   29: ifeq +13 -> 42
    //   32: ldc 171
    //   34: ldc_w 793
    //   37: invokestatic 795	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: iconst_0
    //   41: ireturn
    //   42: invokestatic 104	com/tencent/mm/model/au:Hx	()Lcom/tencent/mm/model/c;
    //   45: pop
    //   46: invokestatic 798	com/tencent/mm/model/c:isSDCardAvailable	()Z
    //   49: ifne +26 -> 75
    //   52: aload_0
    //   53: getfield 94	com/tencent/mm/ui/chatting/q:uPh	Lcom/tencent/mm/ui/chatting/c/a;
    //   56: getfield 143	com/tencent/mm/ui/chatting/c/a:vtz	Lcom/tencent/mm/ui/chatting/e;
    //   59: invokevirtual 149	com/tencent/mm/ui/chatting/e:getContext	()Landroid/app/Activity;
    //   62: invokestatic 802	com/tencent/mm/ui/base/s:gM	(Landroid/content/Context;)V
    //   65: ldc 171
    //   67: ldc_w 804
    //   70: invokestatic 576	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: iconst_0
    //   74: ireturn
    //   75: invokestatic 809	com/tencent/mm/compatible/f/b:zA	()Z
    //   78: ifne +74 -> 152
    //   81: aload_0
    //   82: getfield 94	com/tencent/mm/ui/chatting/q:uPh	Lcom/tencent/mm/ui/chatting/c/a;
    //   85: getfield 143	com/tencent/mm/ui/chatting/c/a:vtz	Lcom/tencent/mm/ui/chatting/e;
    //   88: invokevirtual 149	com/tencent/mm/ui/chatting/e:getContext	()Landroid/app/Activity;
    //   91: aload_0
    //   92: getfield 94	com/tencent/mm/ui/chatting/q:uPh	Lcom/tencent/mm/ui/chatting/c/a;
    //   95: getfield 143	com/tencent/mm/ui/chatting/c/a:vtz	Lcom/tencent/mm/ui/chatting/e;
    //   98: invokevirtual 605	com/tencent/mm/ui/chatting/e:getMMResources	()Landroid/content/res/Resources;
    //   101: getstatic 812	com/tencent/mm/R$l:app_special_no_record_audio_permission	I
    //   104: invokevirtual 615	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   107: aload_0
    //   108: getfield 94	com/tencent/mm/ui/chatting/q:uPh	Lcom/tencent/mm/ui/chatting/c/a;
    //   111: getfield 143	com/tencent/mm/ui/chatting/c/a:vtz	Lcom/tencent/mm/ui/chatting/e;
    //   114: invokevirtual 605	com/tencent/mm/ui/chatting/e:getMMResources	()Landroid/content/res/Resources;
    //   117: getstatic 815	com/tencent/mm/R$l:app_need_audio_title	I
    //   120: invokevirtual 615	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   123: aload_0
    //   124: getfield 94	com/tencent/mm/ui/chatting/q:uPh	Lcom/tencent/mm/ui/chatting/c/a;
    //   127: getfield 143	com/tencent/mm/ui/chatting/c/a:vtz	Lcom/tencent/mm/ui/chatting/e;
    //   130: invokevirtual 605	com/tencent/mm/ui/chatting/e:getMMResources	()Landroid/content/res/Resources;
    //   133: getstatic 818	com/tencent/mm/R$l:app_need_show_settings_button	I
    //   136: invokevirtual 615	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   139: iconst_1
    //   140: new 8	com/tencent/mm/ui/chatting/q$5
    //   143: dup
    //   144: aload_0
    //   145: invokespecial 819	com/tencent/mm/ui/chatting/q$5:<init>	(Lcom/tencent/mm/ui/chatting/q;)V
    //   148: invokestatic 824	com/tencent/mm/ui/base/h:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mm/ui/widget/a/c;
    //   151: pop
    //   152: aload_0
    //   153: getfield 169	com/tencent/mm/ui/chatting/q:vjJ	Lcom/tencent/mm/ah/j;
    //   156: ifnull +113 -> 269
    //   159: aload_0
    //   160: getfield 641	com/tencent/mm/ui/chatting/q:ibo	Landroid/media/ToneGenerator;
    //   163: ifnonnull +59 -> 222
    //   166: aload_0
    //   167: getfield 94	com/tencent/mm/ui/chatting/q:uPh	Lcom/tencent/mm/ui/chatting/c/a;
    //   170: getfield 143	com/tencent/mm/ui/chatting/c/a:vtz	Lcom/tencent/mm/ui/chatting/e;
    //   173: iconst_3
    //   174: invokevirtual 828	com/tencent/mm/ui/x:getStreamMaxVolume	(I)I
    //   177: istore_1
    //   178: aload_0
    //   179: getfield 94	com/tencent/mm/ui/chatting/q:uPh	Lcom/tencent/mm/ui/chatting/c/a;
    //   182: getfield 143	com/tencent/mm/ui/chatting/c/a:vtz	Lcom/tencent/mm/ui/chatting/e;
    //   185: iconst_3
    //   186: invokevirtual 831	com/tencent/mm/ui/x:getStreamVolume	(I)I
    //   189: istore_2
    //   190: iload_1
    //   191: i2f
    //   192: iload_2
    //   193: i2f
    //   194: fdiv
    //   195: ldc_w 832
    //   198: fmul
    //   199: f2i
    //   200: istore_1
    //   201: aload_0
    //   202: new 834	android/media/ToneGenerator
    //   205: dup
    //   206: iconst_3
    //   207: iload_1
    //   208: invokespecial 837	android/media/ToneGenerator:<init>	(II)V
    //   211: putfield 641	com/tencent/mm/ui/chatting/q:ibo	Landroid/media/ToneGenerator;
    //   214: ldc 171
    //   216: ldc_w 839
    //   219: invokestatic 179	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: aload_0
    //   223: getfield 641	com/tencent/mm/ui/chatting/q:ibo	Landroid/media/ToneGenerator;
    //   226: ifnull +21 -> 247
    //   229: aload_0
    //   230: getfield 641	com/tencent/mm/ui/chatting/q:ibo	Landroid/media/ToneGenerator;
    //   233: bipush 24
    //   235: invokevirtual 843	android/media/ToneGenerator:startTone	(I)Z
    //   238: pop
    //   239: ldc 171
    //   241: ldc_w 845
    //   244: invokestatic 179	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   247: aload_0
    //   248: getfield 94	com/tencent/mm/ui/chatting/q:uPh	Lcom/tencent/mm/ui/chatting/c/a;
    //   251: invokevirtual 849	com/tencent/mm/ui/chatting/c/a:getListView	()Landroid/widget/ListView;
    //   254: new 851	com/tencent/mm/ui/chatting/q$7
    //   257: dup
    //   258: aload_0
    //   259: invokespecial 852	com/tencent/mm/ui/chatting/q$7:<init>	(Lcom/tencent/mm/ui/chatting/q;)V
    //   262: ldc2_w 853
    //   265: invokevirtual 860	android/widget/ListView:postDelayed	(Ljava/lang/Runnable;J)Z
    //   268: pop
    //   269: aload_0
    //   270: getfield 72	com/tencent/mm/ui/chatting/q:lock	Ljava/lang/Object;
    //   273: astore_3
    //   274: aload_3
    //   275: monitorenter
    //   276: aload_0
    //   277: iconst_0
    //   278: putfield 68	com/tencent/mm/ui/chatting/q:vjP	Z
    //   281: aload_3
    //   282: monitorexit
    //   283: new 862	com/tencent/mm/sdk/platformtools/ah
    //   286: dup
    //   287: invokestatic 868	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   290: invokespecial 871	com/tencent/mm/sdk/platformtools/ah:<init>	(Landroid/os/Looper;)V
    //   293: new 873	com/tencent/mm/ui/chatting/q$6
    //   296: dup
    //   297: aload_0
    //   298: invokespecial 874	com/tencent/mm/ui/chatting/q$6:<init>	(Lcom/tencent/mm/ui/chatting/q;)V
    //   301: ldc2_w 853
    //   304: invokevirtual 875	com/tencent/mm/sdk/platformtools/ah:postDelayed	(Ljava/lang/Runnable;J)Z
    //   307: pop
    //   308: iconst_1
    //   309: ireturn
    //   310: astore_3
    //   311: ldc 171
    //   313: ldc_w 877
    //   316: invokestatic 576	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   319: goto -97 -> 222
    //   322: astore 4
    //   324: aload_3
    //   325: monitorexit
    //   326: aload 4
    //   328: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	329	0	this	q
    //   177	31	1	i	int
    //   189	4	2	j	int
    //   310	15	3	localException	java.lang.Exception
    //   322	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   201	222	310	java/lang/Exception
    //   276	283	322	finally
    //   324	326	322	finally
  }
  
  public final void bhj()
  {
    cCG();
    cCF();
  }
  
  public final void bhk()
  {
    cCG();
    cCF();
  }
  
  public final void bsG()
  {
    boolean bool = com.tencent.mm.pluginsdk.permission.a.a(this.uPh.vtz.getContext(), "android.permission.RECORD_AUDIO", 82, "", "");
    y.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bk.csb(), this.uPh.vtz.getContext() });
    if (!bool) {
      return;
    }
    td localtd = new td();
    localtd.ccJ.bNb = 5;
    localtd.ccJ.talker = getTalkerUserName();
    localtd.ccJ.context = this.uPh.vtz.getContext();
    localtd.ccJ.ccE = 4;
    if (this.maV.cnD()) {
      this.maV.setBottomPanelVisibility(8);
    }
    com.tencent.mm.sdk.b.a.udP.m(localtd);
  }
  
  public final void bsH()
  {
    boolean bool = com.tencent.mm.pluginsdk.permission.a.a(this.uPh.vtz.getContext(), "android.permission.CAMERA", 19, "", "");
    y.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bk.csb(), this.uPh.vtz.getContext() });
    if (!bool) {}
    do
    {
      return;
      bool = com.tencent.mm.pluginsdk.permission.a.a(this.uPh.vtz.getContext(), "android.permission.RECORD_AUDIO", 19, "", "");
      y.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bk.csb(), this.uPh.vtz.getContext() });
    } while (!bool);
    td localtd = new td();
    localtd.ccJ.bNb = 5;
    localtd.ccJ.talker = getTalkerUserName();
    localtd.ccJ.context = this.uPh.vtz.getContext();
    localtd.ccJ.ccE = 2;
    if (this.maV.cnD()) {
      this.maV.setBottomPanelVisibility(8);
    }
    com.tencent.mm.sdk.b.a.udP.m(localtd);
  }
  
  public final void cCI()
  {
    boolean bool = com.tencent.mm.pluginsdk.permission.a.a(this.uPh.vtz.getContext(), "android.permission.CAMERA", 22, "", "");
    y.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bk.csb(), this.uPh.vtz.getContext() });
    if (!bool) {}
    do
    {
      return;
      bool = com.tencent.mm.pluginsdk.permission.a.a(this.uPh.vtz.getContext(), "android.permission.RECORD_AUDIO", 22, "", "");
      y.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bk.csb(), this.uPh.vtz.getContext() });
    } while (!bool);
    y.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk");
    Intent localIntent = new Intent();
    if (com.tencent.mm.bg.d.eEX.nA(getTalkerUserName()))
    {
      y.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but now is in share location!");
      Toast.makeText(com.tencent.mm.sdk.platformtools.ae.getContext(), R.l.in_share_location_tip, 0).show();
      return;
    }
    List localList;
    if (getTalkerUserName() != null)
    {
      localList = ((com.tencent.mm.plugin.multitalk.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.multitalk.a.a.class)).Iw(getTalkerUserName());
      au.Hx();
      String str1 = (String)c.Dz().get(2, null);
      bool = ((com.tencent.mm.plugin.multitalk.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.multitalk.a.a.class)).It(getTalkerUserName());
      Iterator localIterator = localList.iterator();
      String str2;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        str2 = (String)localIterator.next();
      } while ((str1 == null) || (!str1.equals(str2)));
    }
    for (int i = 1;; i = 0)
    {
      if ((localList.size() >= 9) && (i == 0))
      {
        y.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but > max 9 members!");
        Toast.makeText(com.tencent.mm.sdk.platformtools.ae.getContext(), com.tencent.mm.sdk.platformtools.ae.getContext().getString(R.l.multitalk_members_reach_max_limit, new Object[] { Integer.valueOf(9) }), 0).show();
        return;
      }
      if (i != 0)
      {
        if (((com.tencent.mm.plugin.multitalk.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.multitalk.a.a.class)).bkD())
        {
          y.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in it!");
          Toast.makeText(com.tencent.mm.sdk.platformtools.ae.getContext(), com.tencent.mm.sdk.platformtools.ae.getContext().getString(R.l.multitalk_exit_tip), 0).show();
          return;
        }
        y.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, already inlist, but in fact not multitalking now!");
      }
      if (((com.tencent.mm.plugin.multitalk.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.multitalk.a.a.class)).bkB())
      {
        y.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in VoIP or multitalk!");
        Toast.makeText(com.tencent.mm.sdk.platformtools.ae.getContext(), com.tencent.mm.sdk.platformtools.ae.getContext().getString(R.l.multitalk_exit_tip), 0).show();
        return;
      }
      if (bool)
      {
        y.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but this group already in multitalk, alter take in or not tips!");
        com.tencent.mm.ui.base.h.a(this.uPh.vtz.getContext(), this.uPh.vtz.getMMResources().getString(R.l.multitalk_talking_chose_enter), "", this.uPh.vtz.getMMResources().getString(R.l.multitalk_enter), this.uPh.vtz.getMMResources().getString(R.l.multitalk_cancel), new q.11(this), null);
        return;
      }
      localIntent.putExtra("chatroomName", getTalkerUserName());
      localIntent.putExtra("key_need_gallery", true);
      localIntent.putExtra("titile", this.uPh.vtz.getMMResources().getString(R.l.multitalk_select_contact));
      com.tencent.mm.br.d.b(this.uPh.vtz.getContext(), "multitalk", ".ui.MultiTalkSelectContactUI", localIntent);
      return;
    }
  }
  
  public final void cCJ()
  {
    boolean bool = com.tencent.mm.pluginsdk.permission.a.a(this.uPh.vtz.getContext(), "android.permission.RECORD_AUDIO", 83, "", "");
    y.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bk.csb(), this.uPh.vtz.getContext() });
    if (!bool) {
      return;
    }
    if (this.maV.cnD()) {
      this.maV.setBottomPanelVisibility(8);
    }
    td localtd = new td();
    localtd.ccJ.bNb = 5;
    localtd.ccJ.talker = getTalkerUserName();
    localtd.ccJ.context = this.uPh.vtz.getContext();
    localtd.ccJ.ccE = 3;
    com.tencent.mm.sdk.b.a.udP.m(localtd);
    com.tencent.mm.plugin.report.service.h.nFQ.f(11033, new Object[] { Integer.valueOf(4), Integer.valueOf(2), Integer.valueOf(0) });
  }
  
  public final void cCK()
  {
    boolean bool = com.tencent.mm.pluginsdk.permission.a.a(this.uPh.vtz.getContext(), "android.permission.CAMERA", 21, "", "");
    y.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bk.csb(), this.uPh.vtz.getContext() });
    if (!bool) {}
    do
    {
      return;
      bool = com.tencent.mm.pluginsdk.permission.a.a(this.uPh.vtz.getContext(), "android.permission.RECORD_AUDIO", 21, "", "");
      y.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bk.csb(), this.uPh.vtz.getContext() });
    } while (!bool);
    if (this.maV.cnD()) {
      this.maV.setBottomPanelVisibility(8);
    }
    td localtd = new td();
    localtd.ccJ.bNb = 5;
    localtd.ccJ.talker = getTalkerUserName();
    localtd.ccJ.context = this.uPh.vtz.getContext();
    localtd.ccJ.ccE = 2;
    com.tencent.mm.sdk.b.a.udP.m(localtd);
  }
  
  public final void cCL()
  {
    ((com.tencent.mm.ui.chatting.b.b.ae)this.uPh.ac(com.tencent.mm.ui.chatting.b.b.ae.class)).nn(false);
    this.maV.setBottomPanelVisibility(8);
  }
  
  public final void cCM()
  {
    if (!l.a(this.uPh.vtz, com.tencent.mm.compatible.util.e.dzD, "microMsg." + System.currentTimeMillis() + ".jpg")) {
      Toast.makeText(this.uPh.vtz.getContext(), this.uPh.vtz.getMMResources().getString(R.l.selectcameraapp_none), 1).show();
    }
  }
  
  public final String getTalkerUserName()
  {
    if ((this.dnp != null) && (ad.hd(this.dnp.field_username))) {
      return this.vjK;
    }
    if (this.dnp == null) {
      return null;
    }
    return this.dnp.field_username;
  }
  
  public final void hq(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ((aa)this.uPh.ac(aa.class)).keepSignalling();
      return;
    }
    ((aa)this.uPh.ac(aa.class)).stopSignalling();
  }
  
  public final void onPause()
  {
    if (this.ibo != null)
    {
      y.i("MicroMsg.ChattingFooterEventImpl", "release");
      this.ibo.release();
      this.ibo = null;
    }
    cCH();
    this.eNb.stopTimer();
    this.ibI.stopTimer();
  }
  
  public final void release()
  {
    if (this.ibo != null)
    {
      y.i("MicroMsg.ChattingFooterEventImpl", "release");
      this.ibo.release();
      this.ibo = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.q
 * JD-Core Version:    0.7.0.1
 */