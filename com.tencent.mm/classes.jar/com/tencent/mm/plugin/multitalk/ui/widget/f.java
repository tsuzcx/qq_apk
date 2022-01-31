package com.tencent.mm.plugin.multitalk.ui.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.AnimationDrawable;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ag.d.a;
import com.tencent.mm.ag.o;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.multitalk.a.d;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.g;
import com.tencent.mm.plugin.multitalk.a.j;
import com.tencent.mm.plugin.multitalk.a.k;
import com.tencent.mm.plugin.multitalk.a.k.1;
import com.tencent.mm.plugin.multitalk.a.k.a;
import com.tencent.mm.plugin.multitalk.a.k.b;
import com.tencent.mm.plugin.multitalk.a.p;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.voip.ui.MMCheckBox;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.s;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import com.tencent.wecall.talkroom.model.TalkRoom;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f
  implements View.OnClickListener, d.a, com.tencent.mm.plugin.voip.video.g
{
  public TextView dsz;
  com.tencent.mm.ui.widget.a.c fvH = null;
  private MultiTalkMainUI mvG;
  private ImageButton mvM;
  public FrameLayout mwc;
  public FrameLayout mwd;
  private RelativeLayout mwe;
  public View mwf;
  private View mwg;
  private View mwh;
  public View mwi;
  public MMCheckBox mwj;
  public MMCheckBox mwk;
  public MMCheckBox mwl;
  private int mwm;
  private int mwn;
  public ArrayList<RelativeLayout> mwo = new ArrayList(9);
  private RelativeLayout mwp;
  private com.tencent.mm.plugin.voip.video.a mwq;
  private k mwr;
  private ObservableTextureView mws;
  public String mwt;
  private int mwu;
  public long mwv;
  f.c mww = new f.c(this, (byte)0);
  
  public f(MultiTalkMainUI paramMultiTalkMainUI)
  {
    this.mvG = paramMultiTalkMainUI;
    this.mwe = ((RelativeLayout)paramMultiTalkMainUI.findViewById(a.d.talking_main_top));
    if (ak.gC(paramMultiTalkMainUI.mController.uMN)) {}
    for (int i = ak.gB(paramMultiTalkMainUI.mController.uMN) + 0;; i = 0)
    {
      this.mwe.setPadding(0, i, 0, 0);
      this.dsz = ((TextView)paramMultiTalkMainUI.findViewById(a.d.time_tv));
      this.mwf = paramMultiTalkMainUI.findViewById(a.d.talking_layout);
      this.mvM = ((ImageButton)paramMultiTalkMainUI.findViewById(a.d.talking_hangup_btn));
      this.mwc = ((FrameLayout)paramMultiTalkMainUI.findViewById(a.d.talking_main_avatar_layout));
      this.mwd = ((FrameLayout)paramMultiTalkMainUI.findViewById(a.d.talking_big_avatar_layout));
      this.mwg = paramMultiTalkMainUI.findViewById(a.d.multitalk_mini_action);
      this.mwh = paramMultiTalkMainUI.findViewById(a.d.multitalk_addmembers_action);
      this.mwj = ((MMCheckBox)paramMultiTalkMainUI.findViewById(a.d.multitalk_video_action));
      this.mwk = ((MMCheckBox)paramMultiTalkMainUI.findViewById(a.d.multitalk_mute_action));
      this.mwl = ((MMCheckBox)paramMultiTalkMainUI.findViewById(a.d.multitalk_handsfree_action));
      this.mwi = paramMultiTalkMainUI.findViewById(a.d.multitalk_convert_camera_btn);
      this.mwk.setChecked(p.blF().dnJ);
      this.mwl.setChecked(p.blF().mtB);
      this.mwj.setChecked(p.blF().blf());
      this.mwm = com.tencent.mm.cb.a.fj(paramMultiTalkMainUI.mController.uMN);
      this.mwn = b.dS(paramMultiTalkMainUI.mController.uMN);
      y.i("MicroMsg.MT.MultiTalkTalkingUILogic", "talkingAvatarContainerHeight %d", new Object[] { Integer.valueOf(this.mwn) });
      this.mvM.setOnClickListener(this);
      this.mwg.setOnClickListener(this);
      this.mwj.setOnClickListener(this);
      this.mwk.setOnClickListener(this);
      this.mwl.setOnClickListener(this);
      this.mwh.setOnClickListener(this);
      this.mwi.setOnClickListener(this);
      o.JQ().a(this);
      i = 8;
      Object localObject;
      while (i >= 0)
      {
        localObject = this.mwc;
        localObject = (RelativeLayout)LayoutInflater.from(paramMultiTalkMainUI).inflate(a.e.main_ui_talking_avatar_cell, (ViewGroup)localObject, false);
        f.a locala = new f.a();
        locala.mwy = ((MultiTalkVideoView)((RelativeLayout)localObject).findViewById(a.d.talking_video_view));
        locala.mwy.setIndex(i);
        locala.mwy.setOnClickListener(this);
        locala.hoY = ((RelativeLayout)localObject).findViewById(a.d.mask_view);
        locala.mwz = ((ImageView)((RelativeLayout)localObject).findViewById(a.d.voice_icon_iv));
        locala.mwA = ((ImageView)((RelativeLayout)localObject).findViewById(a.d.multitalk_weaknetwork_iv));
        locala.mwB = ((TextView)((RelativeLayout)localObject).findViewById(a.d.switch_camera_tip_tv));
        locala.mwC = ((ImageView)((RelativeLayout)localObject).findViewById(a.d.loading_iv));
        ((RelativeLayout)localObject).setTag(locala);
        ((RelativeLayout)localObject).setVisibility(8);
        this.mwo.add(localObject);
        this.mwc.addView((View)localObject);
        i -= 1;
      }
      if (this.mwd != null)
      {
        localObject = this.mwd;
        paramMultiTalkMainUI = (RelativeLayout)LayoutInflater.from(paramMultiTalkMainUI).inflate(a.e.main_ui_talking_avatar_cell, (ViewGroup)localObject, false);
        localObject = new f.a();
        ((f.a)localObject).mwy = ((MultiTalkVideoView)paramMultiTalkMainUI.findViewById(a.d.talking_video_view));
        ((f.a)localObject).mwy.setIndex(0);
        ((f.a)localObject).mwy.setOnClickListener(this);
        ((f.a)localObject).hoY = paramMultiTalkMainUI.findViewById(a.d.mask_view);
        ((f.a)localObject).mwz = ((ImageView)paramMultiTalkMainUI.findViewById(a.d.voice_icon_iv));
        ((f.a)localObject).mwA = ((ImageView)paramMultiTalkMainUI.findViewById(a.d.multitalk_weaknetwork_iv));
        ((f.a)localObject).mwB = ((TextView)paramMultiTalkMainUI.findViewById(a.d.switch_camera_tip_tv));
        ((f.a)localObject).mwC = ((ImageView)paramMultiTalkMainUI.findViewById(a.d.loading_iv));
        paramMultiTalkMainUI.setTag(localObject);
        paramMultiTalkMainUI.setVisibility(8);
        this.mwp = paramMultiTalkMainUI;
        this.mwd.addView(paramMultiTalkMainUI);
      }
      this.mwd.setVisibility(8);
      if (p.blF().blf()) {
        this.mwi.setVisibility(0);
      }
      for (;;)
      {
        this.mwt = "";
        blO();
        return;
        this.mwi.setVisibility(8);
      }
    }
  }
  
  private static void a(RelativeLayout paramRelativeLayout, MultiTalkGroupMember paramMultiTalkGroupMember, boolean paramBoolean, HashSet<String> paramHashSet)
  {
    paramRelativeLayout = (f.a)paramRelativeLayout.getTag();
    if (paramMultiTalkGroupMember != null)
    {
      paramRelativeLayout.mwy.IO(paramMultiTalkGroupMember.wJQ);
      paramRelativeLayout.mwy.setPosition(paramRelativeLayout.mwy.getIndex());
      if (paramMultiTalkGroupMember.status != 10)
      {
        paramRelativeLayout.hoY.setVisibility(0);
        if (paramRelativeLayout.mwC.getBackground() != null)
        {
          paramRelativeLayout.mwC.setVisibility(0);
          ((AnimationDrawable)paramRelativeLayout.mwC.getBackground()).stop();
          ((AnimationDrawable)paramRelativeLayout.mwC.getBackground()).start();
        }
      }
      while ((paramHashSet.contains(paramMultiTalkGroupMember.wJQ)) && (!paramBoolean))
      {
        paramRelativeLayout.mwy.blR();
        return;
        paramRelativeLayout.hoY.setVisibility(8);
        a(paramRelativeLayout);
      }
      paramRelativeLayout.mwy.blQ();
      return;
    }
    paramRelativeLayout.hoY.setVisibility(8);
    a(paramRelativeLayout);
    paramRelativeLayout.mwy.blS();
  }
  
  private static void a(f.a parama)
  {
    if (parama.mwC.getBackground() != null) {
      ((AnimationDrawable)parama.mwC.getBackground()).stop();
    }
    parama.mwC.setVisibility(8);
  }
  
  private void ac(LinkedList<MultiTalkGroupMember> paramLinkedList)
  {
    this.mwu = paramLinkedList.size();
    Object localObject = this.mwc.getLayoutParams();
    int j;
    int i;
    int k;
    HashSet localHashSet;
    int m;
    label166:
    MultiTalkGroupMember localMultiTalkGroupMember;
    label198:
    int i1;
    if (this.mwu <= 4)
    {
      j = this.mwm / 2;
      if (this.mwn / 2 > j)
      {
        i = j;
        ((ViewGroup.LayoutParams)localObject).height = (i * 2);
        k = i;
        this.mwc.setLayoutParams((ViewGroup.LayoutParams)localObject);
        y.i("MicroMsg.MT.MultiTalkTalkingUILogic", "talkingAvatarWidth: %d | talkingAvatarHeight: %d | size %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(this.mwu) });
        localHashSet = new HashSet();
        localHashSet.addAll(p.blF().mtF);
        if (p.blF().blf()) {
          localHashSet.add(q.Gj());
        }
        if (this.mwu > 4) {
          break label472;
        }
        localObject = j.muo[this.mwu];
        if (localObject == null) {
          break label488;
        }
        m = 0;
        if (m >= localObject.length) {
          break label488;
        }
        if (this.mwu <= m / 2) {
          break label482;
        }
        localMultiTalkGroupMember = (MultiTalkGroupMember)paramLinkedList.get(m / 2);
        int n = (int)(localObject[m] * j);
        i1 = (int)(localObject[(m + 1)] * k);
        i = n;
        if (this.mwu == 2)
        {
          i = n;
          if (n == 0) {
            i = 1;
          }
        }
        if ((this.mwu != 4) || (i != 0)) {
          break label565;
        }
        i = 1;
      }
    }
    label565:
    for (;;)
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.mwo.get(m / 2);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.width = j;
      localLayoutParams.height = k;
      localLayoutParams.leftMargin = i;
      localLayoutParams.topMargin = i1;
      localRelativeLayout.setLayoutParams(localLayoutParams);
      a(localRelativeLayout, localMultiTalkGroupMember, false, localHashSet);
      localRelativeLayout.setVisibility(0);
      y.i("MicroMsg.MT.MultiTalkTalkingUILogic", "setIvLayoutParams, width: %s, height: %s, marginLeft: %s, marginTop: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(i1) });
      m += 2;
      break label166;
      i = this.mwn / 2;
      break;
      if (this.mwu <= 9)
      {
        j = this.mwm / 3;
        if (this.mwn / 3 > j) {}
        for (i = j;; i = this.mwn / 3)
        {
          ((ViewGroup.LayoutParams)localObject).height = (i * 3);
          k = i;
          break;
        }
      }
      y.e("MicroMsg.MT.MultiTalkTalkingUILogic", "onlineUserSize larger than 9, %s", new Object[] { Integer.valueOf(this.mwu) });
      label472:
      label482:
      label488:
      do
      {
        return;
        localObject = j.muo[5];
        break;
        localMultiTalkGroupMember = null;
        break label198;
        if (this.mwu <= 4)
        {
          i = this.mwu;
          while (i < 9)
          {
            ((RelativeLayout)this.mwo.get(i)).setVisibility(8);
            i += 1;
          }
        }
      } while ((!p.blF().blh()) || (this.mwj == null) || (this.mwj.isChecked()));
      p.blF().up(1);
      return;
    }
  }
  
  private static int r(boolean paramBoolean, int paramInt)
  {
    if (!paramBoolean) {}
    for (int i = -1;; i = paramInt)
    {
      Object localObject = ByteBuffer.allocate(4);
      ((ByteBuffer)localObject).order(ByteOrder.LITTLE_ENDIAN).putInt(i);
      localObject = ((ByteBuffer)localObject).array();
      int j = p.blE().mtp.setAppCmd(22, (byte[])localObject, 4);
      if (j < 0)
      {
        y.e("MicroMsg.MT.MultiTalkTalkingUILogic", "steve:set netBigVideo failed or NO need!, ret:%d, vID:%d, memberId:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramInt) });
        return -1;
      }
      return j;
    }
  }
  
  public final RelativeLayout IN(String paramString)
  {
    Iterator localIterator = this.mwo.iterator();
    while (localIterator.hasNext())
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)localIterator.next();
      if (paramString.equals(((f.a)localRelativeLayout.getTag()).mwy.getUsername())) {
        return localRelativeLayout;
      }
    }
    return null;
  }
  
  /* Error */
  public final void a(String paramString, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 153	com/tencent/mm/plugin/multitalk/ui/widget/f:mwd	Landroid/widget/FrameLayout;
    //   6: invokevirtual 561	android/widget/FrameLayout:getVisibility	()I
    //   9: ifne +45 -> 54
    //   12: aload_0
    //   13: getfield 338	com/tencent/mm/plugin/multitalk/ui/widget/f:mwp	Landroid/widget/RelativeLayout;
    //   16: invokevirtual 354	android/widget/RelativeLayout:getTag	()Ljava/lang/Object;
    //   19: checkcast 14	com/tencent/mm/plugin/multitalk/ui/widget/f$a
    //   22: astore 5
    //   24: aload_1
    //   25: aload 5
    //   27: getfield 284	com/tencent/mm/plugin/multitalk/ui/widget/f$a:mwy	Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView;
    //   30: invokevirtual 552	com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView:getUsername	()Ljava/lang/String;
    //   33: invokevirtual 557	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   36: ifeq +15 -> 51
    //   39: aload 5
    //   41: getfield 284	com/tencent/mm/plugin/multitalk/ui/widget/f$a:mwy	Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView;
    //   44: aload_2
    //   45: iload 4
    //   47: iload_3
    //   48: invokevirtual 565	com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView:c	(Landroid/graphics/Bitmap;II)V
    //   51: aload_0
    //   52: monitorexit
    //   53: return
    //   54: aload_0
    //   55: aload_1
    //   56: invokevirtual 567	com/tencent/mm/plugin/multitalk/ui/widget/f:IN	(Ljava/lang/String;)Landroid/widget/RelativeLayout;
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull -10 -> 51
    //   64: aload_1
    //   65: invokevirtual 354	android/widget/RelativeLayout:getTag	()Ljava/lang/Object;
    //   68: checkcast 14	com/tencent/mm/plugin/multitalk/ui/widget/f$a
    //   71: getfield 284	com/tencent/mm/plugin/multitalk/ui/widget/f$a:mwy	Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView;
    //   74: aload_2
    //   75: iload 4
    //   77: iload_3
    //   78: invokevirtual 565	com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView:c	(Landroid/graphics/Bitmap;II)V
    //   81: goto -30 -> 51
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	f
    //   0	89	1	paramString	String
    //   0	89	2	paramBitmap	Bitmap
    //   0	89	3	paramInt1	int
    //   0	89	4	paramInt2	int
    //   22	18	5	locala	f.a
    // Exception table:
    //   from	to	target	type
    //   2	51	84	finally
    //   54	60	84	finally
    //   64	81	84	finally
  }
  
  /* Error */
  public final void a(String paramString, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 153	com/tencent/mm/plugin/multitalk/ui/widget/f:mwd	Landroid/widget/FrameLayout;
    //   6: invokevirtual 561	android/widget/FrameLayout:getVisibility	()I
    //   9: ifne +47 -> 56
    //   12: aload_0
    //   13: getfield 338	com/tencent/mm/plugin/multitalk/ui/widget/f:mwp	Landroid/widget/RelativeLayout;
    //   16: invokevirtual 354	android/widget/RelativeLayout:getTag	()Ljava/lang/Object;
    //   19: checkcast 14	com/tencent/mm/plugin/multitalk/ui/widget/f$a
    //   22: astore 6
    //   24: aload_1
    //   25: aload 6
    //   27: getfield 284	com/tencent/mm/plugin/multitalk/ui/widget/f$a:mwy	Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView;
    //   30: invokevirtual 552	com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView:getUsername	()Ljava/lang/String;
    //   33: invokevirtual 557	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   36: ifeq +17 -> 53
    //   39: aload 6
    //   41: getfield 284	com/tencent/mm/plugin/multitalk/ui/widget/f$a:mwy	Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView;
    //   44: aload_2
    //   45: iload_3
    //   46: iload 4
    //   48: iload 5
    //   50: invokevirtual 572	com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView:b	([IIII)V
    //   53: aload_0
    //   54: monitorexit
    //   55: return
    //   56: aload_0
    //   57: aload_1
    //   58: invokevirtual 567	com/tencent/mm/plugin/multitalk/ui/widget/f:IN	(Ljava/lang/String;)Landroid/widget/RelativeLayout;
    //   61: astore_1
    //   62: aload_1
    //   63: ifnull -10 -> 53
    //   66: aload_1
    //   67: invokevirtual 354	android/widget/RelativeLayout:getTag	()Ljava/lang/Object;
    //   70: checkcast 14	com/tencent/mm/plugin/multitalk/ui/widget/f$a
    //   73: getfield 284	com/tencent/mm/plugin/multitalk/ui/widget/f$a:mwy	Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView;
    //   76: aload_2
    //   77: iload_3
    //   78: iload 4
    //   80: iload 5
    //   82: invokevirtual 572	com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView:b	([IIII)V
    //   85: goto -32 -> 53
    //   88: astore_1
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_1
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	f
    //   0	93	1	paramString	String
    //   0	93	2	paramArrayOfInt	int[]
    //   0	93	3	paramInt1	int
    //   0	93	4	paramInt2	int
    //   0	93	5	paramInt3	int
    //   22	18	6	locala	f.a
    // Exception table:
    //   from	to	target	type
    //   2	53	88	finally
    //   56	62	88	finally
    //   66	85	88	finally
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!p.blF().blh())
    {
      hP(false);
      return;
    }
    if (this.mww.muz == null)
    {
      this.mww.w = paramInt1;
      this.mww.h = paramInt2;
      this.mww.muz = new int[this.mww.w * this.mww.h];
    }
    if (!p.blF().blf())
    {
      j.blw();
      p.blF().up(3);
    }
    long l1 = System.currentTimeMillis();
    p.blF().mtE = this.mwq.bSu();
    int j;
    if (this.mwq.bSu())
    {
      j = OpenGlRender.FLAG_Mirror;
      if (!this.mwq.bSv()) {
        break label245;
      }
    }
    com.tencent.pb.talkroom.sdk.g localg;
    label245:
    for (int k = OpenGlRender.FLAG_Angle270;; k = OpenGlRender.FLAG_Angle90)
    {
      localg = p.blE().mtp.a(paramArrayOfByte, (int)paramLong, this.mww.w, this.mww.h, paramInt3 + paramInt4 & 0x1F, this.mww.muz);
      if ((localg.ret >= 0) && (this.mww.muz != null) && (localg.wJY != 0) && (localg.wJZ != 0)) {
        break label253;
      }
      y.e("MicroMsg.MT.MultiTalkTalkingUILogic", "ret: %d", new Object[] { Integer.valueOf(localg.ret) });
      return;
      j = 0;
      break;
    }
    label253:
    long l2 = System.currentTimeMillis();
    int i;
    if (j == OpenGlRender.FLAG_Mirror)
    {
      i = 257;
      label271:
      if (!p.blF().mtS) {
        break label764;
      }
      if (j != OpenGlRender.FLAG_Mirror) {
        break label494;
      }
      i = 259;
    }
    label494:
    label764:
    for (;;)
    {
      paramInt1 = p.blE().mtp.a(paramArrayOfByte, (short)(int)paramLong, paramInt1, paramInt2, paramInt3 + paramInt4, i);
      paramLong = System.currentTimeMillis();
      long l3 = paramLong - l1;
      if (l3 > 30L) {
        y.d("MicroMsg.MT.MultiTalkTalkingUILogic", "steve: trans size:%dx%d, total: %d, trans: %d, enc: %d", new Object[] { Integer.valueOf(localg.wJY), Integer.valueOf(localg.wJZ), Long.valueOf(l3), Long.valueOf(l2 - l1), Long.valueOf(paramLong - l2) });
      }
      if (paramInt1 <= 0) {
        y.v("MicroMsg.MT.MultiTalkTalkingUILogic", "send ret = %d", new Object[] { Integer.valueOf(paramInt1) });
      }
      if ((this.mwr == null) || (this.mww.muz == null)) {
        break;
      }
      paramArrayOfByte = this.mwr;
      int[] arrayOfInt = this.mww.muz;
      paramInt1 = localg.wJY;
      paramInt2 = localg.wJZ;
      if (arrayOfInt == null)
      {
        y.e("MicroMsg.MT.MultiTalkVideoNativeReceiver", "onDrawerReady pBuffer is null");
        return;
        i = 1;
        break label271;
        i = 3;
        continue;
      }
      if (paramArrayOfByte.muv.dCs)
      {
        y.d("MicroMsg.MT.MultiTalkVideoNativeReceiver", "onDrawerReady busy!!!!");
        return;
      }
      if (paramArrayOfByte.muv.muz == null) {
        paramArrayOfByte.muv.muz = new int[arrayOfInt.length];
      }
      paramArrayOfByte.muv.w = paramInt1;
      paramArrayOfByte.muv.h = paramInt2;
      paramArrayOfByte.muv.mux = (paramInt3 + paramInt4);
      paramArrayOfByte.muv.muy = j;
      paramArrayOfByte.muv.angle = k;
      paramLong = System.currentTimeMillis();
      paramInt1 = paramArrayOfByte.muv.h;
      if (paramArrayOfByte.muv.h > paramArrayOfByte.muv.w) {
        paramInt1 = paramArrayOfByte.muv.w;
      }
      if (paramArrayOfByte.muv.kJz == null) {
        paramArrayOfByte.muv.kJz = Bitmap.createBitmap(paramInt1, paramInt1, Bitmap.Config.RGB_565);
      }
      if (paramArrayOfByte.muv.kJz != null) {
        paramArrayOfByte.muv.kJz.setPixels(arrayOfInt, paramArrayOfByte.muv.w - paramArrayOfByte.muv.h, paramArrayOfByte.muv.w, 0, 0, paramInt1, paramInt1);
      }
      paramLong = System.currentTimeMillis() - paramLong;
      if (paramLong > 30L) {
        y.d("MicroMsg.MT.MultiTalkVideoNativeReceiver", "steve: createBitmap: %d", new Object[] { Long.valueOf(paramLong) });
      }
      if (paramArrayOfByte.muu == null) {
        break;
      }
      paramArrayOfByte.muu.post(new k.b(paramArrayOfByte));
      return;
    }
  }
  
  public final boolean bkH()
  {
    return this.mwq != null;
  }
  
  public final void blM()
  {
    Iterator localIterator = this.mwo.iterator();
    while (localIterator.hasNext())
    {
      f.a locala = (f.a)((RelativeLayout)localIterator.next()).getTag();
      if ((!q.Gj().equals(locala.mwy.getUsername())) && (locala.mwy.blV())) {
        locala.mwy.blQ();
      }
    }
  }
  
  public final void blN()
  {
    y.e("MicroMsg.MT.MultiTalkTalkingUILogic", "onCameraError");
    if (this.fvH == null) {
      this.fvH = com.tencent.mm.bf.e.a(this.mvG, a.g.voip_no_record_video_permission, new Runnable()
      {
        public final void run()
        {
          f.this.hP(false);
        }
      });
    }
    if (!this.fvH.isShowing()) {
      this.fvH.show();
    }
    p.blF().up(1);
  }
  
  public final void blO()
  {
    if (this.mwl.isEnabled())
    {
      com.tencent.mm.plugin.multitalk.a.f localf = p.blF();
      boolean bool = this.mwl.isChecked();
      y.l("MicroMsg.MT.MultiTalkManager", "setHandsFreeUIStatus: %s", new Object[] { Boolean.valueOf(bool) });
      localf.mtC = bool;
    }
  }
  
  public final void d(HashSet<String> paramHashSet)
  {
    Iterator localIterator = this.mwo.iterator();
    while (localIterator.hasNext())
    {
      f.a locala = (f.a)((RelativeLayout)localIterator.next()).getTag();
      if (!q.Gj().equals(locala.mwy.getUsername())) {
        if (paramHashSet.contains(locala.mwy.getUsername()))
        {
          if (!locala.mwy.blV()) {
            locala.mwy.blR();
          }
        }
        else if (locala.mwy.blV())
        {
          locala.mwy.blQ();
          if ((this.mwt.equals(locala.mwy.getUsername())) && (this.mwd.getVisibility() == 0))
          {
            this.mwt = "";
            this.mwd.setVisibility(8);
            this.mwc.setVisibility(0);
          }
        }
      }
    }
  }
  
  public final void hO(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.mwv = System.currentTimeMillis();
    }
    y.i("MicroMsg.MT.MultiTalkTalkingUILogic", "start capture render");
    if ((this.mwd != null) && (this.mwd.getVisibility() == 0)) {}
    for (Object localObject = (ViewGroup)this.mvG.findViewById(a.d.rootview);; localObject = IN(q.Gj()))
    {
      if (localObject != null)
      {
        if (this.mws == null)
        {
          y.i("MicroMsg.MT.MultiTalkTalkingUILogic", "create capture View");
          this.mws = new ObservableTextureView(this.mvG);
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(1, 1);
          this.mws.setLayoutParams(localLayoutParams);
          ((ViewGroup)localObject).addView(this.mws);
          this.mws.setVisibility(0);
        }
        if (this.mwq == null)
        {
          y.i("MicroMsg.MT.MultiTalkTalkingUILogic", "create capture Render");
          this.mwq = new com.tencent.mm.plugin.voip.video.a(320, 240);
          this.mwq.a(this, p.blF().mtE);
          this.mwq.a(this.mws);
          this.mwq.bSr();
          y.i("MicroMsg.MT.MultiTalkTalkingUILogic", "captureRender.mIsCurrentFaceCamera=%b captureRender.mIsCameraRemote180=%b", new Object[] { Boolean.valueOf(this.mwq.bSu()), Boolean.valueOf(this.mwq.bSv()) });
        }
        if (this.mwr == null)
        {
          this.mwr = new k(this.mvG);
          com.tencent.mm.sdk.f.e.c(new k.1(this.mwr), "MultiTalkVideoTaskManager_native_drawer_handler", 1).start();
        }
      }
      return;
    }
  }
  
  public final void hP(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.mwv != 0L) && (System.currentTimeMillis() - this.mwv > 0L) && (p.blF().bkC()))
    {
      com.tencent.mm.plugin.multitalk.a.e.r(System.currentTimeMillis() - this.mwv, j.blu());
      this.mwv = 0L;
    }
    y.i("MicroMsg.MT.MultiTalkTalkingUILogic", "stop capture render");
    Object localObject;
    if (this.mws != null)
    {
      localObject = this.mws.getParent();
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).removeView(this.mws);
      }
      this.mws = null;
    }
    if (this.mwq != null)
    {
      this.mwq.bSs();
      com.tencent.mm.plugin.voip.video.a.bSt();
      this.mwq = null;
    }
    if (this.mwr != null)
    {
      localObject = this.mwr;
      ((k)localObject).mtQ = null;
      ((k)localObject).muv.dCs = false;
      ((k)localObject).muv.muz = null;
      if (((k)localObject).muu != null)
      {
        ((k)localObject).muu.removeCallbacksAndMessages(null);
        ((k)localObject).muu.getLooper().quit();
        ((k)localObject).muu = null;
      }
      this.mwr = null;
    }
  }
  
  public final void hQ(boolean paramBoolean)
  {
    y.i("MicroMsg.MT.MultiTalkTalkingUILogic", "onRefreshed");
    this.mwu = 0;
    if (!paramBoolean) {
      ai.d(new f.1(this));
    }
    hP(false);
    Iterator localIterator = this.mwo.iterator();
    while (localIterator.hasNext()) {
      ((f.a)((RelativeLayout)localIterator.next()).getTag()).mwy.setSurfaceTextureListener(null);
    }
    o.JQ().b(this);
  }
  
  public final void kk(String paramString)
  {
    y.i("MicroMsg.MT.MultiTalkTalkingUILogic", "notifyChanged %s", new Object[] { paramString });
    paramString = IN(paramString);
    if (paramString != null) {
      ((f.a)paramString.getTag()).mwy.blP();
    }
  }
  
  public final void o(MultiTalkGroup paramMultiTalkGroup)
  {
    this.mwf.setVisibility(0);
    LinkedList localLinkedList = new LinkedList();
    paramMultiTalkGroup = paramMultiTalkGroup.wJP.iterator();
    while (paramMultiTalkGroup.hasNext())
    {
      MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)paramMultiTalkGroup.next();
      if ((localMultiTalkGroupMember.status == 10) || (localMultiTalkGroupMember.status == 1)) {
        localLinkedList.add(localMultiTalkGroupMember);
      }
    }
    ac(localLinkedList);
    blO();
  }
  
  public final void onClick(View paramView)
  {
    Object localObject1 = null;
    boolean bool2 = true;
    Object localObject2;
    Object localObject3;
    if ((paramView instanceof MultiTalkVideoView))
    {
      paramView = (MultiTalkVideoView)paramView;
      if (this.mwd.getVisibility() == 8)
      {
        if (!paramView.blV()) {
          return;
        }
        this.mwd.setVisibility(0);
        this.mwc.setVisibility(8);
        localObject2 = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject2).width = this.mwm;
        ((FrameLayout.LayoutParams)localObject2).height = this.mwm;
        ((FrameLayout.LayoutParams)localObject2).leftMargin = 0;
        ((FrameLayout.LayoutParams)localObject2).topMargin = 0;
        this.mwp.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = paramView.getUsername();
        localObject3 = p.blF().mtH.wJP.iterator();
        paramView = (View)localObject1;
        label132:
        if (((Iterator)localObject3).hasNext())
        {
          localObject1 = (MultiTalkGroupMember)((Iterator)localObject3).next();
          if (((((MultiTalkGroupMember)localObject1).status != 10) && (((MultiTalkGroupMember)localObject1).status != 1)) || (!((MultiTalkGroupMember)localObject1).wJQ.equals(localObject2))) {
            break label958;
          }
          paramView = (View)localObject1;
        }
      }
    }
    label958:
    for (;;)
    {
      break label132;
      localObject1 = p.blF().mtH.wJL;
      localObject1 = com.tencent.wecall.talkroom.model.c.cRC().agw((String)localObject1);
      if (localObject1 != null)
      {
        localObject1 = ((TalkRoom)localObject1).cRz().iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject3 = (a.av)((Iterator)localObject1).next();
        } while (!((a.av)localObject3).wHY.equals(localObject2));
      }
      for (int i = ((a.av)localObject3).iEo;; i = 0)
      {
        if (!((String)localObject2).equals(q.Gj()))
        {
          y.d("MicroMsg.MT.MultiTalkTalkingUILogic", "steve:click memberId:%d", new Object[] { Integer.valueOf(i) });
          p.blF().IH((String)localObject2);
          r(true, i);
        }
        boolean bool1 = bool2;
        if (!aq.is2G(this.mvG)) {
          if (!aq.is3G(this.mvG)) {
            break label449;
          }
        }
        label449:
        for (bool1 = bool2;; bool1 = false)
        {
          localObject1 = new HashSet();
          ((HashSet)localObject1).addAll(p.blF().mtF);
          if (p.blF().blf()) {
            ((HashSet)localObject1).add(q.Gj());
          }
          localObject3 = (f.a)this.mwp.getTag();
          ((f.a)localObject3).mwy.IO((String)localObject2);
          ((f.a)localObject3).mwy.blS();
          this.mwp.setTag(localObject3);
          a(this.mwp, paramView, bool1, (HashSet)localObject1);
          this.mwp.setVisibility(0);
          this.mwt = ((String)localObject2);
          com.tencent.mm.plugin.multitalk.a.e.bld();
          return;
        }
        if (!paramView.getUsername().equals(q.Gj()))
        {
          y.d("MicroMsg.MT.MultiTalkTalkingUILogic", "steve: unsubscribe big video!");
          p.blF().IH("");
          r(false, -1);
        }
        this.mwd.setVisibility(8);
        this.mwc.setVisibility(0);
        if (this.mwp != null)
        {
          paramView = (f.a)this.mwp.getTag();
          if (paramView != null) {
            paramView.mwy.blS();
          }
        }
        this.mwt = "";
        com.tencent.mm.plugin.multitalk.a.e.ble();
        return;
        if (paramView.getId() == a.d.talking_hangup_btn)
        {
          p.blF().h(true, false, false);
          return;
        }
        if (paramView.getId() == a.d.multitalk_mini_action)
        {
          com.tencent.mm.plugin.multitalk.a.e.mtv += 1;
          p.blF().hL(true);
          com.tencent.mm.plugin.multitalk.a.e.blc();
          return;
        }
        if (paramView.getId() == a.d.multitalk_handsfree_action)
        {
          if (!this.mwl.isEnabled()) {
            break;
          }
          com.tencent.mm.plugin.multitalk.a.e.mtx += 1;
          p.blF().hM(this.mwl.isChecked());
          blO();
          if (this.mwl.isChecked())
          {
            com.tencent.mm.plugin.multitalk.a.e.bkX();
            return;
          }
          com.tencent.mm.plugin.multitalk.a.e.bkY();
          return;
        }
        if (paramView.getId() == a.d.multitalk_mute_action)
        {
          com.tencent.mm.plugin.multitalk.a.e.mtw += 1;
          paramView = p.blF();
          bool1 = this.mwk.isChecked();
          p.blE().mtp.og(bool1);
          paramView.hE(bool1);
          if (this.mwk.isChecked())
          {
            com.tencent.mm.plugin.multitalk.a.e.bkV();
            return;
          }
          com.tencent.mm.plugin.multitalk.a.e.bkW();
          return;
        }
        if (paramView.getId() == a.d.multitalk_convert_camera_btn)
        {
          if (this.mwq != null) {
            this.mwq.bSq();
          }
          com.tencent.mm.plugin.multitalk.a.e.blb();
          return;
        }
        if (paramView.getId() == a.d.multitalk_video_action)
        {
          com.tencent.mm.plugin.multitalk.a.e.mty += 1;
          if (!com.tencent.mm.compatible.f.b.zB())
          {
            com.tencent.mm.bf.e.a(this.mvG, a.g.voip_no_record_video_permission, null);
            this.mwj.setChecked(false);
            return;
          }
          if (!p.blF().blh())
          {
            this.mwj.setChecked(false);
            return;
          }
          if (!aq.isNetworkConnected(this.mvG))
          {
            com.tencent.mm.bf.e.a(this.mvG, a.g.voip_net_unavailable, null);
            this.mwj.setChecked(false);
            return;
          }
          if (!j.bly())
          {
            Toast.makeText(this.mvG, a.g.multitalk_disabled, 1).show();
            this.mwj.setChecked(false);
            return;
          }
          if (this.mwj.isChecked())
          {
            hO(false);
            com.tencent.mm.plugin.multitalk.a.e.bkZ();
          }
          for (;;)
          {
            this.mwj.setChecked(p.blF().blf());
            return;
            hP(false);
            p.blF().up(1);
            com.tencent.mm.plugin.multitalk.a.e.bla();
          }
        }
        if (paramView.getId() != a.d.multitalk_addmembers_action) {
          break;
        }
        com.tencent.mm.plugin.multitalk.a.e.mtz += 1;
        this.mvG.blK();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.f
 * JD-Core Version:    0.7.0.1
 */