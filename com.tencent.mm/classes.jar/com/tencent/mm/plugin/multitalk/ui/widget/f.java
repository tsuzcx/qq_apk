package com.tencent.mm.plugin.multitalk.ui.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d.a;
import com.tencent.mm.ah.o;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.multitalk.model.j;
import com.tencent.mm.plugin.multitalk.model.k;
import com.tencent.mm.plugin.multitalk.model.k.a;
import com.tencent.mm.plugin.multitalk.model.k.b;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.voip.ui.MMCheckBox;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.af;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import com.tencent.pb.talkroom.sdk.g;
import com.tencent.wecall.talkroom.model.TalkRoom;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f
  implements View.OnClickListener, d.a, com.tencent.mm.plugin.voip.video.f
{
  public TextView ekh;
  com.tencent.mm.ui.widget.b.c gNn;
  private ImageButton oVE;
  public FrameLayout oVU;
  public FrameLayout oVV;
  private RelativeLayout oVW;
  public View oVX;
  private View oVY;
  private View oVZ;
  private MultiTalkMainUI oVy;
  public View oWa;
  public MMCheckBox oWb;
  public MMCheckBox oWc;
  public MMCheckBox oWd;
  private int oWe;
  private int oWf;
  public ArrayList<RelativeLayout> oWg;
  private RelativeLayout oWh;
  private com.tencent.mm.plugin.voip.video.a oWi;
  private k oWj;
  private ObservableTextureView oWk;
  public String oWl;
  private int oWm;
  public long oWn;
  f.c oWo;
  
  public f(MultiTalkMainUI paramMultiTalkMainUI)
  {
    AppMethodBeat.i(54203);
    this.oWo = new f.c(this, (byte)0);
    this.gNn = null;
    this.oWg = new ArrayList(9);
    this.oVy = paramMultiTalkMainUI;
    this.oVW = ((RelativeLayout)paramMultiTalkMainUI.findViewById(2131826416));
    if (af.hW(paramMultiTalkMainUI.getContext())) {}
    for (int i = af.hV(paramMultiTalkMainUI.getContext()) + 0;; i = 0)
    {
      this.oVW.setPadding(0, i, 0, 0);
      this.ekh = ((TextView)paramMultiTalkMainUI.findViewById(2131821004));
      this.oVX = paramMultiTalkMainUI.findViewById(2131826415);
      this.oVE = ((ImageButton)paramMultiTalkMainUI.findViewById(2131826425));
      this.oVU = ((FrameLayout)paramMultiTalkMainUI.findViewById(2131826417));
      this.oVV = ((FrameLayout)paramMultiTalkMainUI.findViewById(2131826418));
      this.oVY = paramMultiTalkMainUI.findViewById(2131826419);
      this.oVZ = paramMultiTalkMainUI.findViewById(2131826420);
      this.oWb = ((MMCheckBox)paramMultiTalkMainUI.findViewById(2131826423));
      this.oWc = ((MMCheckBox)paramMultiTalkMainUI.findViewById(2131826422));
      this.oWd = ((MMCheckBox)paramMultiTalkMainUI.findViewById(2131826424));
      this.oWa = paramMultiTalkMainUI.findViewById(2131826426);
      this.oWc.setChecked(p.bTF().efg);
      this.oWd.setChecked(p.bTF().oTm);
      this.oWb.setChecked(p.bTF().bTf());
      this.oWe = com.tencent.mm.cb.a.gw(paramMultiTalkMainUI.getContext());
      this.oWf = b.eF(paramMultiTalkMainUI.getContext());
      ab.i("MicroMsg.MT.MultiTalkTalkingUILogic", "talkingAvatarContainerHeight %d", new Object[] { Integer.valueOf(this.oWf) });
      this.oVE.setOnClickListener(this);
      this.oVY.setOnClickListener(this);
      this.oWb.setOnClickListener(this);
      this.oWc.setOnClickListener(this);
      this.oWd.setOnClickListener(this);
      this.oVZ.setOnClickListener(this);
      this.oWa.setOnClickListener(this);
      o.acQ().a(this);
      i = 8;
      Object localObject;
      while (i >= 0)
      {
        localObject = this.oVU;
        localObject = (RelativeLayout)LayoutInflater.from(paramMultiTalkMainUI).inflate(2130970071, (ViewGroup)localObject, false);
        f.a locala = new f.a();
        locala.oWq = ((MultiTalkVideoView)((RelativeLayout)localObject).findViewById(2131825899));
        locala.oWq.setIndex(i);
        locala.oWq.setOnClickListener(this);
        locala.jbK = ((RelativeLayout)localObject).findViewById(2131825900);
        locala.oWr = ((ImageView)((RelativeLayout)localObject).findViewById(2131825903));
        locala.oWs = ((ImageView)((RelativeLayout)localObject).findViewById(2131825904));
        locala.oWt = ((TextView)((RelativeLayout)localObject).findViewById(2131825902));
        locala.owe = ((ImageView)((RelativeLayout)localObject).findViewById(2131825901));
        ((RelativeLayout)localObject).setTag(locala);
        ((RelativeLayout)localObject).setVisibility(8);
        this.oWg.add(localObject);
        this.oVU.addView((View)localObject);
        i -= 1;
      }
      if (this.oVV != null)
      {
        localObject = this.oVV;
        paramMultiTalkMainUI = (RelativeLayout)LayoutInflater.from(paramMultiTalkMainUI).inflate(2130970071, (ViewGroup)localObject, false);
        localObject = new f.a();
        ((f.a)localObject).oWq = ((MultiTalkVideoView)paramMultiTalkMainUI.findViewById(2131825899));
        ((f.a)localObject).oWq.setIndex(0);
        ((f.a)localObject).oWq.setOnClickListener(this);
        ((f.a)localObject).jbK = paramMultiTalkMainUI.findViewById(2131825900);
        ((f.a)localObject).oWr = ((ImageView)paramMultiTalkMainUI.findViewById(2131825903));
        ((f.a)localObject).oWs = ((ImageView)paramMultiTalkMainUI.findViewById(2131825904));
        ((f.a)localObject).oWt = ((TextView)paramMultiTalkMainUI.findViewById(2131825902));
        ((f.a)localObject).owe = ((ImageView)paramMultiTalkMainUI.findViewById(2131825901));
        paramMultiTalkMainUI.setTag(localObject);
        paramMultiTalkMainUI.setVisibility(8);
        this.oWh = paramMultiTalkMainUI;
        this.oVV.addView(paramMultiTalkMainUI);
      }
      this.oVV.setVisibility(8);
      if (p.bTF().bTf()) {
        this.oWa.setVisibility(0);
      }
      for (;;)
      {
        this.oWl = "";
        bTO();
        AppMethodBeat.o(54203);
        return;
        this.oWa.setVisibility(8);
      }
    }
  }
  
  private static int A(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(54208);
    if (!paramBoolean) {}
    for (int i = -1;; i = paramInt)
    {
      Object localObject = ByteBuffer.allocate(4);
      ((ByteBuffer)localObject).order(ByteOrder.LITTLE_ENDIAN).putInt(i);
      localObject = ((ByteBuffer)localObject).array();
      int j = p.bTE().oTa.setAppCmd(22, (byte[])localObject, 4);
      if (j < 0)
      {
        ab.e("MicroMsg.MT.MultiTalkTalkingUILogic", "steve:set netBigVideo failed or NO need!, ret:%d, vID:%d, memberId:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramInt) });
        AppMethodBeat.o(54208);
        return -1;
      }
      AppMethodBeat.o(54208);
      return j;
    }
  }
  
  private static void a(RelativeLayout paramRelativeLayout, MultiTalkGroupMember paramMultiTalkGroupMember, boolean paramBoolean, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(54206);
    paramRelativeLayout = (f.a)paramRelativeLayout.getTag();
    if (paramMultiTalkGroupMember != null)
    {
      paramRelativeLayout.oWq.UE(paramMultiTalkGroupMember.Bhq);
      paramRelativeLayout.oWq.setPosition(paramRelativeLayout.oWq.getIndex());
      if (paramMultiTalkGroupMember.status != 10)
      {
        paramRelativeLayout.jbK.setVisibility(0);
        a(paramRelativeLayout);
      }
      while ((paramHashSet.contains(paramMultiTalkGroupMember.Bhq)) && (!paramBoolean))
      {
        paramRelativeLayout.oWq.bTR();
        AppMethodBeat.o(54206);
        return;
        paramRelativeLayout.jbK.setVisibility(8);
        b(paramRelativeLayout);
      }
      paramRelativeLayout.oWq.bTQ();
      AppMethodBeat.o(54206);
      return;
    }
    paramRelativeLayout.jbK.setVisibility(8);
    b(paramRelativeLayout);
    paramRelativeLayout.oWq.bTS();
    AppMethodBeat.o(54206);
  }
  
  private static void a(f.a parama)
  {
    AppMethodBeat.i(54220);
    if (parama.owe.getBackground() != null)
    {
      parama.owe.setVisibility(0);
      ((AnimationDrawable)parama.owe.getBackground()).stop();
      ((AnimationDrawable)parama.owe.getBackground()).start();
    }
    AppMethodBeat.o(54220);
  }
  
  private void ak(LinkedList<MultiTalkGroupMember> paramLinkedList)
  {
    AppMethodBeat.i(54205);
    this.oWm = paramLinkedList.size();
    Object localObject = this.oVU.getLayoutParams();
    int j;
    int i;
    int k;
    HashSet localHashSet;
    label164:
    int m;
    label172:
    MultiTalkGroupMember localMultiTalkGroupMember;
    label204:
    int i1;
    if (this.oWm <= 4)
    {
      j = this.oWe / 2;
      if (this.oWf / 2 > j)
      {
        i = j;
        ((ViewGroup.LayoutParams)localObject).height = (i * 2);
        k = i;
        this.oVU.setLayoutParams((ViewGroup.LayoutParams)localObject);
        ab.i("MicroMsg.MT.MultiTalkTalkingUILogic", "talkingAvatarWidth: %d | talkingAvatarHeight: %d | size %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(this.oWm) });
        localHashSet = new HashSet();
        localHashSet.addAll(p.bTF().oTq);
        if (p.bTF().bTf()) {
          localHashSet.add(r.Zn());
        }
        if (this.oWm > 4) {
          break label484;
        }
        localObject = j.oUd[this.oWm];
        if (localObject == null) {
          break label500;
        }
        m = 0;
        if (m >= localObject.length) {
          break label500;
        }
        if (this.oWm <= m / 2) {
          break label494;
        }
        localMultiTalkGroupMember = (MultiTalkGroupMember)paramLinkedList.get(m / 2);
        int n = (int)(localObject[m] * j);
        i1 = (int)(localObject[(m + 1)] * k);
        i = n;
        if (this.oWm == 2)
        {
          i = n;
          if (n == 0) {
            i = 1;
          }
        }
        if ((this.oWm != 4) || (i != 0)) {
          break label583;
        }
        i = 1;
      }
    }
    label583:
    for (;;)
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.oWg.get(m / 2);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.width = j;
      localLayoutParams.height = k;
      localLayoutParams.leftMargin = i;
      localLayoutParams.topMargin = i1;
      localRelativeLayout.setLayoutParams(localLayoutParams);
      a(localRelativeLayout, localMultiTalkGroupMember, false, localHashSet);
      localRelativeLayout.setVisibility(0);
      ab.i("MicroMsg.MT.MultiTalkTalkingUILogic", "setIvLayoutParams, width: %s, height: %s, marginLeft: %s, marginTop: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(i1) });
      m += 2;
      break label172;
      i = this.oWf / 2;
      break;
      if (this.oWm <= 9)
      {
        j = this.oWe / 3;
        if (this.oWf / 3 > j) {}
        for (i = j;; i = this.oWf / 3)
        {
          ((ViewGroup.LayoutParams)localObject).height = (i * 3);
          k = i;
          break;
        }
      }
      ab.e("MicroMsg.MT.MultiTalkTalkingUILogic", "onlineUserSize larger than 9, %s", new Object[] { Integer.valueOf(this.oWm) });
      AppMethodBeat.o(54205);
      return;
      label484:
      localObject = j.oUd[5];
      break label164;
      label494:
      localMultiTalkGroupMember = null;
      break label204;
      label500:
      if (this.oWm <= 4)
      {
        i = this.oWm;
        while (i < 9)
        {
          ((RelativeLayout)this.oWg.get(i)).setVisibility(8);
          i += 1;
        }
      }
      if ((p.bTF().bTh()) && (this.oWb != null) && (!this.oWb.isChecked())) {
        p.bTF().zF(1);
      }
      AppMethodBeat.o(54205);
      return;
    }
  }
  
  private static void b(f.a parama)
  {
    AppMethodBeat.i(54221);
    if (parama.owe.getBackground() != null) {
      ((AnimationDrawable)parama.owe.getBackground()).stop();
    }
    parama.owe.setVisibility(8);
    AppMethodBeat.o(54221);
  }
  
  public final RelativeLayout UD(String paramString)
  {
    AppMethodBeat.i(54207);
    Iterator localIterator = this.oWg.iterator();
    while (localIterator.hasNext())
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)localIterator.next();
      if (paramString.equals(((f.a)localRelativeLayout.getTag()).oWq.getUsername()))
      {
        AppMethodBeat.o(54207);
        return localRelativeLayout;
      }
    }
    AppMethodBeat.o(54207);
    return null;
  }
  
  /* Error */
  public final void a(String paramString, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 526
    //   5: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 137	com/tencent/mm/plugin/multitalk/ui/widget/f:oVV	Landroid/widget/FrameLayout;
    //   12: invokevirtual 529	android/widget/FrameLayout:getVisibility	()I
    //   15: ifne +51 -> 66
    //   18: aload_0
    //   19: getfield 293	com/tencent/mm/plugin/multitalk/ui/widget/f:oWh	Landroid/widget/RelativeLayout;
    //   22: invokevirtual 360	android/widget/RelativeLayout:getTag	()Ljava/lang/Object;
    //   25: checkcast 14	com/tencent/mm/plugin/multitalk/ui/widget/f$a
    //   28: astore 5
    //   30: aload_1
    //   31: aload 5
    //   33: getfield 249	com/tencent/mm/plugin/multitalk/ui/widget/f$a:oWq	Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView;
    //   36: invokevirtual 519	com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView:getUsername	()Ljava/lang/String;
    //   39: invokevirtual 524	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   42: ifeq +15 -> 57
    //   45: aload 5
    //   47: getfield 249	com/tencent/mm/plugin/multitalk/ui/widget/f$a:oWq	Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView;
    //   50: aload_2
    //   51: iload 4
    //   53: iload_3
    //   54: invokevirtual 533	com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView:d	(Landroid/graphics/Bitmap;II)V
    //   57: ldc_w 526
    //   60: invokestatic 305	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aload_0
    //   64: monitorexit
    //   65: return
    //   66: aload_0
    //   67: aload_1
    //   68: invokevirtual 535	com/tencent/mm/plugin/multitalk/ui/widget/f:UD	(Ljava/lang/String;)Landroid/widget/RelativeLayout;
    //   71: astore_1
    //   72: aload_1
    //   73: ifnull +20 -> 93
    //   76: aload_1
    //   77: invokevirtual 360	android/widget/RelativeLayout:getTag	()Ljava/lang/Object;
    //   80: checkcast 14	com/tencent/mm/plugin/multitalk/ui/widget/f$a
    //   83: getfield 249	com/tencent/mm/plugin/multitalk/ui/widget/f$a:oWq	Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView;
    //   86: aload_2
    //   87: iload 4
    //   89: iload_3
    //   90: invokevirtual 533	com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView:d	(Landroid/graphics/Bitmap;II)V
    //   93: ldc_w 526
    //   96: invokestatic 305	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: goto -36 -> 63
    //   102: astore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_1
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	f
    //   0	107	1	paramString	String
    //   0	107	2	paramBitmap	Bitmap
    //   0	107	3	paramInt1	int
    //   0	107	4	paramInt2	int
    //   28	18	5	locala	f.a
    // Exception table:
    //   from	to	target	type
    //   2	57	102	finally
    //   57	63	102	finally
    //   66	72	102	finally
    //   76	93	102	finally
    //   93	99	102	finally
  }
  
  /* Error */
  public final void a(String paramString, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 537
    //   5: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 137	com/tencent/mm/plugin/multitalk/ui/widget/f:oVV	Landroid/widget/FrameLayout;
    //   12: invokevirtual 529	android/widget/FrameLayout:getVisibility	()I
    //   15: ifne +53 -> 68
    //   18: aload_0
    //   19: getfield 293	com/tencent/mm/plugin/multitalk/ui/widget/f:oWh	Landroid/widget/RelativeLayout;
    //   22: invokevirtual 360	android/widget/RelativeLayout:getTag	()Ljava/lang/Object;
    //   25: checkcast 14	com/tencent/mm/plugin/multitalk/ui/widget/f$a
    //   28: astore 6
    //   30: aload_1
    //   31: aload 6
    //   33: getfield 249	com/tencent/mm/plugin/multitalk/ui/widget/f$a:oWq	Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView;
    //   36: invokevirtual 519	com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView:getUsername	()Ljava/lang/String;
    //   39: invokevirtual 524	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   42: ifeq +17 -> 59
    //   45: aload 6
    //   47: getfield 249	com/tencent/mm/plugin/multitalk/ui/widget/f$a:oWq	Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView;
    //   50: aload_2
    //   51: iload_3
    //   52: iload 4
    //   54: iload 5
    //   56: invokevirtual 540	com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView:b	([IIII)V
    //   59: ldc_w 537
    //   62: invokestatic 305	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aload_0
    //   66: monitorexit
    //   67: return
    //   68: aload_0
    //   69: aload_1
    //   70: invokevirtual 535	com/tencent/mm/plugin/multitalk/ui/widget/f:UD	(Ljava/lang/String;)Landroid/widget/RelativeLayout;
    //   73: astore_1
    //   74: aload_1
    //   75: ifnull +22 -> 97
    //   78: aload_1
    //   79: invokevirtual 360	android/widget/RelativeLayout:getTag	()Ljava/lang/Object;
    //   82: checkcast 14	com/tencent/mm/plugin/multitalk/ui/widget/f$a
    //   85: getfield 249	com/tencent/mm/plugin/multitalk/ui/widget/f$a:oWq	Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView;
    //   88: aload_2
    //   89: iload_3
    //   90: iload 4
    //   92: iload 5
    //   94: invokevirtual 540	com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView:b	([IIII)V
    //   97: ldc_w 537
    //   100: invokestatic 305	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: goto -38 -> 65
    //   106: astore_1
    //   107: aload_0
    //   108: monitorexit
    //   109: aload_1
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	f
    //   0	111	1	paramString	String
    //   0	111	2	paramArrayOfInt	int[]
    //   0	111	3	paramInt1	int
    //   0	111	4	paramInt2	int
    //   0	111	5	paramInt3	int
    //   28	18	6	locala	f.a
    // Exception table:
    //   from	to	target	type
    //   2	59	106	finally
    //   59	65	106	finally
    //   68	74	106	finally
    //   78	97	106	finally
    //   97	103	106	finally
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(54215);
    if (!p.bTF().bTh())
    {
      jJ(false);
      AppMethodBeat.o(54215);
      return;
    }
    if (this.oWo.oUo == null)
    {
      this.oWo.w = paramInt1;
      this.oWo.h = paramInt2;
      this.oWo.oUo = new int[this.oWo.w * this.oWo.h];
    }
    if (!p.bTF().bTf())
    {
      j.bTw();
      p.bTF().zF(3);
    }
    long l1 = System.currentTimeMillis();
    p.bTF().oTp = this.oWi.cPB();
    int j;
    if (this.oWi.cPB())
    {
      j = OpenGlRender.FLAG_Mirror;
      if (!this.oWi.cPC()) {
        break label263;
      }
    }
    g localg;
    label263:
    for (int k = OpenGlRender.FLAG_Angle270;; k = OpenGlRender.FLAG_Angle90)
    {
      localg = p.bTE().oTa.a(paramArrayOfByte, (int)paramLong, this.oWo.w, this.oWo.h, paramInt3 + paramInt4 & 0x1F, this.oWo.oUo);
      if ((localg.ret >= 0) && (this.oWo.oUo != null) && (localg.Bhy != 0) && (localg.Bhz != 0)) {
        break label271;
      }
      ab.e("MicroMsg.MT.MultiTalkTalkingUILogic", "ret: %d", new Object[] { Integer.valueOf(localg.ret) });
      AppMethodBeat.o(54215);
      return;
      j = 0;
      break;
    }
    label271:
    long l2 = System.currentTimeMillis();
    int i;
    if (j == OpenGlRender.FLAG_Mirror)
    {
      i = 257;
      if (!p.bTF().oTF) {
        break label800;
      }
      if (j != OpenGlRender.FLAG_Mirror) {
        break label518;
      }
      i = 259;
    }
    label518:
    label800:
    for (;;)
    {
      paramInt1 = p.bTE().oTa.a(paramArrayOfByte, (short)(int)paramLong, paramInt1, paramInt2, paramInt3 + paramInt4, i);
      paramLong = System.currentTimeMillis();
      long l3 = paramLong - l1;
      if (l3 > 30L) {
        ab.d("MicroMsg.MT.MultiTalkTalkingUILogic", "steve: trans size:%dx%d, total: %d, trans: %d, enc: %d", new Object[] { Integer.valueOf(localg.Bhy), Integer.valueOf(localg.Bhz), Long.valueOf(l3), Long.valueOf(l2 - l1), Long.valueOf(paramLong - l2) });
      }
      if (paramInt1 <= 0) {
        ab.v("MicroMsg.MT.MultiTalkTalkingUILogic", "send ret = %d", new Object[] { Integer.valueOf(paramInt1) });
      }
      if ((this.oWj != null) && (this.oWo.oUo != null))
      {
        paramArrayOfByte = this.oWj;
        int[] arrayOfInt = this.oWo.oUo;
        paramInt1 = localg.Bhy;
        paramInt2 = localg.Bhz;
        if (arrayOfInt == null)
        {
          ab.e("MicroMsg.MT.MultiTalkVideoNativeReceiver", "onDrawerReady pBuffer is null");
          AppMethodBeat.o(54215);
          return;
          i = 1;
          break;
          i = 3;
          continue;
        }
        if (paramArrayOfByte.oUk.ezJ)
        {
          ab.d("MicroMsg.MT.MultiTalkVideoNativeReceiver", "onDrawerReady busy!!!!");
          AppMethodBeat.o(54215);
          return;
        }
        if (paramArrayOfByte.oUk.oUo == null) {
          paramArrayOfByte.oUk.oUo = new int[arrayOfInt.length];
        }
        paramArrayOfByte.oUk.w = paramInt1;
        paramArrayOfByte.oUk.h = paramInt2;
        paramArrayOfByte.oUk.oUm = (paramInt3 + paramInt4);
        paramArrayOfByte.oUk.oUn = j;
        paramArrayOfByte.oUk.angle = k;
        paramLong = System.currentTimeMillis();
        paramInt1 = paramArrayOfByte.oUk.h;
        if (paramArrayOfByte.oUk.h > paramArrayOfByte.oUk.w) {
          paramInt1 = paramArrayOfByte.oUk.w;
        }
        if (paramArrayOfByte.oUk.nfX == null) {
          paramArrayOfByte.oUk.nfX = Bitmap.createBitmap(paramInt1, paramInt1, Bitmap.Config.RGB_565);
        }
        if (paramArrayOfByte.oUk.nfX != null) {
          paramArrayOfByte.oUk.nfX.setPixels(arrayOfInt, paramArrayOfByte.oUk.w - paramArrayOfByte.oUk.h, paramArrayOfByte.oUk.w, 0, 0, paramInt1, paramInt1);
        }
        paramLong = System.currentTimeMillis() - paramLong;
        if (paramLong > 30L) {
          ab.d("MicroMsg.MT.MultiTalkVideoNativeReceiver", "steve: createBitmap: %d", new Object[] { Long.valueOf(paramLong) });
        }
        if (paramArrayOfByte.oUj != null) {
          paramArrayOfByte.oUj.post(new k.b(paramArrayOfByte));
        }
      }
      AppMethodBeat.o(54215);
      return;
    }
  }
  
  public final boolean bSH()
  {
    return this.oWi != null;
  }
  
  public final void bTN()
  {
    AppMethodBeat.i(54211);
    Iterator localIterator = this.oWg.iterator();
    while (localIterator.hasNext())
    {
      f.a locala = (f.a)((RelativeLayout)localIterator.next()).getTag();
      if ((!r.Zn().equals(locala.oWq.getUsername())) && (locala.oWq.bTV())) {
        locala.oWq.bTQ();
      }
    }
    AppMethodBeat.o(54211);
  }
  
  public final void bTO()
  {
    AppMethodBeat.i(54222);
    if (this.oWd.isEnabled()) {
      p.bTF().jH(this.oWd.isChecked());
    }
    AppMethodBeat.o(54222);
  }
  
  public final void bho()
  {
    AppMethodBeat.i(54218);
    ab.e("MicroMsg.MT.MultiTalkTalkingUILogic", "onCameraError");
    if (this.gNn == null) {
      this.gNn = com.tencent.mm.bg.e.a(this.oVy, 2131304714, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(54201);
          f.this.jJ(false);
          AppMethodBeat.o(54201);
        }
      });
    }
    if (!this.gNn.isShowing()) {
      this.gNn.show();
    }
    p.bTF().zF(1);
    AppMethodBeat.o(54218);
  }
  
  public final void d(HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(54210);
    Iterator localIterator = this.oWg.iterator();
    while (localIterator.hasNext())
    {
      f.a locala = (f.a)((RelativeLayout)localIterator.next()).getTag();
      if (!r.Zn().equals(locala.oWq.getUsername())) {
        if (paramHashSet.contains(locala.oWq.getUsername()))
        {
          if (!locala.oWq.bTV()) {
            locala.oWq.bTR();
          }
        }
        else if (locala.oWq.bTV())
        {
          locala.oWq.bTQ();
          if ((locala.oWq.getUsername() != null) && (!locala.oWq.getUsername().equals(r.Zn())))
          {
            ab.d("MicroMsg.MT.MultiTalkTalkingUILogic", "steve: unsubscribe big video!");
            p.bTF().Uw("");
            A(false, -1);
          }
          if ((this.oWl.equals(locala.oWq.getUsername())) && (this.oVV.getVisibility() == 0))
          {
            this.oWl = "";
            this.oVV.setVisibility(8);
            this.oVU.setVisibility(0);
          }
        }
      }
    }
    AppMethodBeat.o(54210);
  }
  
  public final void jI(boolean paramBoolean)
  {
    AppMethodBeat.i(54212);
    if (!paramBoolean) {
      this.oWn = System.currentTimeMillis();
    }
    ab.i("MicroMsg.MT.MultiTalkTalkingUILogic", "start capture render");
    if ((this.oVV != null) && (this.oVV.getVisibility() == 0)) {}
    for (Object localObject = this.oVy.bTL();; localObject = UD(r.Zn()))
    {
      if (localObject != null)
      {
        if (this.oWk == null)
        {
          ab.i("MicroMsg.MT.MultiTalkTalkingUILogic", "create capture View");
          this.oWk = new ObservableTextureView(this.oVy);
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(1, 1);
          this.oWk.setLayoutParams(localLayoutParams);
          ((ViewGroup)localObject).addView(this.oWk);
          this.oWk.setVisibility(0);
        }
        if (this.oWi == null)
        {
          ab.i("MicroMsg.MT.MultiTalkTalkingUILogic", "create capture Render");
          this.oWi = new com.tencent.mm.plugin.voip.video.a(320, 240);
          this.oWi.a(this, p.bTF().oTp);
          this.oWi.a(this.oWk);
          this.oWi.cPz();
          ab.i("MicroMsg.MT.MultiTalkTalkingUILogic", "captureRender.mIsCurrentFaceCamera=%b captureRender.mIsCameraRemote180=%b", new Object[] { Boolean.valueOf(this.oWi.cPB()), Boolean.valueOf(this.oWi.cPC()) });
        }
        if (this.oWj == null)
        {
          this.oWj = new k(this.oVy);
          this.oWj.start();
        }
      }
      AppMethodBeat.o(54212);
      return;
    }
  }
  
  public final void jJ(boolean paramBoolean)
  {
    AppMethodBeat.i(54213);
    if ((!paramBoolean) && (this.oWn != 0L) && (System.currentTimeMillis() - this.oWn > 0L) && (p.bTF().bSC()))
    {
      com.tencent.mm.plugin.multitalk.model.e.r(System.currentTimeMillis() - this.oWn, j.bTu());
      this.oWn = 0L;
    }
    ab.i("MicroMsg.MT.MultiTalkTalkingUILogic", "stop capture render");
    if (this.oWk != null)
    {
      ViewParent localViewParent = this.oWk.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.oWk);
      }
      this.oWk = null;
    }
    if (this.oWi != null)
    {
      this.oWi.cPA();
      this.oWi = null;
    }
    if (this.oWj != null)
    {
      this.oWj.stop();
      this.oWj = null;
    }
    AppMethodBeat.o(54213);
  }
  
  public final void jK(boolean paramBoolean)
  {
    AppMethodBeat.i(54214);
    ab.i("MicroMsg.MT.MultiTalkTalkingUILogic", "onRefreshed");
    this.oWm = 0;
    if (!paramBoolean) {
      al.d(new f.1(this));
    }
    jJ(false);
    Iterator localIterator = this.oWg.iterator();
    while (localIterator.hasNext()) {
      ((f.a)((RelativeLayout)localIterator.next()).getTag()).oWq.setSurfaceTextureListener(null);
    }
    o.acQ().b(this);
    AppMethodBeat.o(54214);
  }
  
  public final void o(MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(54204);
    this.oVX.setVisibility(0);
    LinkedList localLinkedList = new LinkedList();
    paramMultiTalkGroup = paramMultiTalkGroup.Bhp.iterator();
    while (paramMultiTalkGroup.hasNext())
    {
      MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)paramMultiTalkGroup.next();
      if ((localMultiTalkGroupMember.status == 10) || (localMultiTalkGroupMember.status == 1)) {
        localLinkedList.add(localMultiTalkGroupMember);
      }
    }
    ak(localLinkedList);
    bTO();
    AppMethodBeat.o(54204);
  }
  
  public final void onClick(View paramView)
  {
    boolean bool2 = true;
    AppMethodBeat.i(54209);
    Object localObject1;
    String str;
    Object localObject2;
    if ((paramView instanceof MultiTalkVideoView))
    {
      paramView = (MultiTalkVideoView)paramView;
      if (this.oVV.getVisibility() == 8)
      {
        if (!paramView.bTV())
        {
          AppMethodBeat.o(54209);
          return;
        }
        this.oVV.setVisibility(0);
        this.oVU.setVisibility(8);
        localObject1 = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject1).width = this.oWe;
        ((FrameLayout.LayoutParams)localObject1).height = this.oWe;
        ((FrameLayout.LayoutParams)localObject1).leftMargin = 0;
        ((FrameLayout.LayoutParams)localObject1).topMargin = 0;
        this.oWh.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        str = paramView.getUsername();
        localObject1 = null;
        paramView = null;
        if (p.bTF().oTs != null)
        {
          localObject2 = p.bTF().oTs.Bhp.iterator();
          localObject1 = paramView;
          if (((Iterator)localObject2).hasNext())
          {
            localObject1 = (MultiTalkGroupMember)((Iterator)localObject2).next();
            if (((((MultiTalkGroupMember)localObject1).status != 10) && (((MultiTalkGroupMember)localObject1).status != 1)) || (!((MultiTalkGroupMember)localObject1).Bhq.equals(str))) {
              break label1114;
            }
            paramView = (View)localObject1;
          }
        }
      }
    }
    label467:
    label1114:
    for (;;)
    {
      break;
      paramView = p.bTF().oTs.Bhl;
      paramView = com.tencent.wecall.talkroom.model.c.dXv().axp(paramView);
      if (paramView != null)
      {
        paramView = paramView.dXp().iterator();
        do
        {
          if (!paramView.hasNext()) {
            break;
          }
          localObject2 = (a.av)paramView.next();
        } while (!((a.av)localObject2).Bfy.equals(str));
      }
      for (int i = ((a.av)localObject2).kJx;; i = 0)
      {
        if (!str.equals(r.Zn()))
        {
          ab.d("MicroMsg.MT.MultiTalkTalkingUILogic", "steve:click memberId:%d", new Object[] { Integer.valueOf(i) });
          p.bTF().Uw(str);
          A(true, i);
        }
        boolean bool1 = bool2;
        if (!at.is2G(this.oVy)) {
          if (!at.is3G(this.oVy)) {
            break label467;
          }
        }
        for (bool1 = bool2;; bool1 = false)
        {
          paramView = new HashSet();
          paramView.addAll(p.bTF().oTq);
          if (p.bTF().bTf()) {
            paramView.add(r.Zn());
          }
          localObject2 = (f.a)this.oWh.getTag();
          ((f.a)localObject2).oWq.UE(str);
          ((f.a)localObject2).oWq.bTS();
          this.oWh.setTag(localObject2);
          a(this.oWh, (MultiTalkGroupMember)localObject1, bool1, paramView);
          this.oWh.setVisibility(0);
          this.oWl = str;
          com.tencent.mm.plugin.multitalk.model.e.bTd();
          AppMethodBeat.o(54209);
          return;
        }
        if ((paramView.getUsername() != null) && (!paramView.getUsername().equals(r.Zn())))
        {
          ab.d("MicroMsg.MT.MultiTalkTalkingUILogic", "steve: unsubscribe big video!");
          p.bTF().Uw("");
          A(false, -1);
        }
        this.oVV.setVisibility(8);
        this.oVU.setVisibility(0);
        if (this.oWh != null)
        {
          paramView = (f.a)this.oWh.getTag();
          if (paramView != null) {
            paramView.oWq.bTS();
          }
        }
        this.oWl = "";
        com.tencent.mm.plugin.multitalk.model.e.bTe();
        AppMethodBeat.o(54209);
        return;
        if (paramView.getId() == 2131826425)
        {
          p.bTF().f(true, false, false);
          AppMethodBeat.o(54209);
          return;
        }
        if (paramView.getId() == 2131826419)
        {
          com.tencent.mm.plugin.multitalk.model.e.oTg += 1;
          p.bTF().jE(true);
          com.tencent.mm.plugin.multitalk.model.e.bTc();
          AppMethodBeat.o(54209);
          return;
        }
        if (paramView.getId() == 2131826424)
        {
          if (this.oWd.isEnabled())
          {
            com.tencent.mm.plugin.multitalk.model.e.oTi += 1;
            p.bTF().jF(this.oWd.isChecked());
            bTO();
            if (this.oWd.isChecked())
            {
              com.tencent.mm.plugin.multitalk.model.e.bSX();
              AppMethodBeat.o(54209);
              return;
            }
            com.tencent.mm.plugin.multitalk.model.e.bSY();
            AppMethodBeat.o(54209);
          }
        }
        else
        {
          if (paramView.getId() == 2131826422)
          {
            com.tencent.mm.plugin.multitalk.model.e.oTh += 1;
            paramView = p.bTF();
            bool1 = this.oWc.isChecked();
            p.bTE().oTa.rS(bool1);
            paramView.jx(bool1);
            if (this.oWc.isChecked())
            {
              com.tencent.mm.plugin.multitalk.model.e.bSV();
              AppMethodBeat.o(54209);
              return;
            }
            com.tencent.mm.plugin.multitalk.model.e.bSW();
            AppMethodBeat.o(54209);
            return;
          }
          if (paramView.getId() == 2131826426)
          {
            if (this.oWi != null) {
              this.oWi.cPy();
            }
            com.tencent.mm.plugin.multitalk.model.e.bTb();
            AppMethodBeat.o(54209);
            return;
          }
          if (paramView.getId() == 2131826423)
          {
            com.tencent.mm.plugin.multitalk.model.e.oTj += 1;
            bool1 = com.tencent.mm.pluginsdk.permission.b.a(this.oVy.getContext(), "android.permission.CAMERA", 22, "", "");
            ab.i("MicroMsg.MT.MultiTalkTalkingUILogic", "summerper checkPermission checkcamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool1), bo.dtY(), this.oVy.getContext() });
            if (!bool1) {}
            for (i = 0; i == 0; i = 1)
            {
              this.oWb.setChecked(false);
              AppMethodBeat.o(54209);
              return;
            }
            if (!p.bTF().bTh())
            {
              this.oWb.setChecked(false);
              AppMethodBeat.o(54209);
              return;
            }
            if (!at.isNetworkConnected(this.oVy))
            {
              com.tencent.mm.bg.e.a(this.oVy, 2131304713, null);
              this.oWb.setChecked(false);
              AppMethodBeat.o(54209);
              return;
            }
            if (!j.bTy())
            {
              Toast.makeText(this.oVy, 2131301658, 1).show();
              this.oWb.setChecked(false);
              AppMethodBeat.o(54209);
              return;
            }
            if (this.oWb.isChecked())
            {
              jI(false);
              com.tencent.mm.plugin.multitalk.model.e.bSZ();
            }
            for (;;)
            {
              this.oWb.setChecked(p.bTF().bTf());
              AppMethodBeat.o(54209);
              return;
              jJ(false);
              p.bTF().zF(1);
              com.tencent.mm.plugin.multitalk.model.e.bTa();
            }
          }
          if (paramView.getId() == 2131826420)
          {
            com.tencent.mm.plugin.multitalk.model.e.oTk += 1;
            this.oVy.bTK();
          }
        }
        AppMethodBeat.o(54209);
        return;
      }
    }
  }
  
  public final void re(String paramString)
  {
    AppMethodBeat.i(54219);
    ab.i("MicroMsg.MT.MultiTalkTalkingUILogic", "notifyChanged %s", new Object[] { paramString });
    paramString = UD(paramString);
    if (paramString != null) {
      ((f.a)paramString.getTag()).oWq.bTP();
    }
    AppMethodBeat.o(54219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.f
 * JD-Core Version:    0.7.0.1
 */