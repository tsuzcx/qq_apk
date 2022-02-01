package com.tencent.mm.ui.chatting.viewitems;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.ef.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.i.a.al;
import com.tencent.mm.plugin.r.a.a.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ac;
import com.tencent.mm.ui.chatting.d.b.ad;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public final class ab
{
  /* Error */
  private static final Bitmap a(Context paramContext, Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 23
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 35	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   8: lstore 9
    //   10: iload_2
    //   11: istore 6
    //   13: iload_2
    //   14: ifne +11 -> 25
    //   17: aload_0
    //   18: bipush 88
    //   20: invokestatic 41	com/tencent/mm/cb/a:fromDPToPix	(Landroid/content/Context;I)I
    //   23: istore 6
    //   25: iload_3
    //   26: istore_2
    //   27: iload_3
    //   28: ifne +11 -> 39
    //   31: aload_0
    //   32: sipush 280
    //   35: invokestatic 41	com/tencent/mm/cb/a:fromDPToPix	(Landroid/content/Context;I)I
    //   38: istore_2
    //   39: aload_1
    //   40: invokevirtual 47	android/graphics/Bitmap:getHeight	()I
    //   43: istore_3
    //   44: aload_1
    //   45: invokevirtual 50	android/graphics/Bitmap:getWidth	()I
    //   48: istore 7
    //   50: iload_3
    //   51: i2f
    //   52: fconst_1
    //   53: fmul
    //   54: iload 6
    //   56: i2f
    //   57: fconst_1
    //   58: fmul
    //   59: iload_2
    //   60: i2f
    //   61: fdiv
    //   62: fmul
    //   63: f2i
    //   64: istore 8
    //   66: aload_1
    //   67: ifnull +10 -> 77
    //   70: aload_1
    //   71: invokevirtual 54	android/graphics/Bitmap:isRecycled	()Z
    //   74: ifeq +295 -> 369
    //   77: aload_0
    //   78: invokevirtual 60	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   81: ldc 61
    //   83: invokevirtual 67	android/content/res/Resources:getColor	(I)I
    //   86: iload 7
    //   88: iload 8
    //   90: invokestatic 73	com/tencent/mm/sdk/platformtools/BitmapUtil:createColorBitmap	(III)Landroid/graphics/Bitmap;
    //   93: astore_0
    //   94: new 75	android/graphics/Matrix
    //   97: dup
    //   98: invokespecial 79	android/graphics/Matrix:<init>	()V
    //   101: astore 11
    //   103: iload 6
    //   105: i2f
    //   106: fconst_1
    //   107: fmul
    //   108: iload 8
    //   110: i2f
    //   111: fdiv
    //   112: ldc 80
    //   114: fmul
    //   115: ldc 80
    //   117: fmul
    //   118: fstore 5
    //   120: aload 11
    //   122: fload 5
    //   124: fload 5
    //   126: invokevirtual 84	android/graphics/Matrix:postScale	(FF)Z
    //   129: pop
    //   130: aload_0
    //   131: iconst_0
    //   132: iload_3
    //   133: iload 8
    //   135: isub
    //   136: iconst_2
    //   137: idiv
    //   138: iload 7
    //   140: iload 8
    //   142: aload 11
    //   144: iconst_0
    //   145: invokestatic 88	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   148: astore_0
    //   149: new 90	com/tencent/mm/ui/blur/f
    //   152: dup
    //   153: invokestatic 96	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   156: invokespecial 99	com/tencent/mm/ui/blur/f:<init>	(Landroid/content/Context;)V
    //   159: astore 11
    //   161: aload 11
    //   163: aload_0
    //   164: ldc 100
    //   166: invokevirtual 103	com/tencent/mm/ui/blur/f:b	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   169: astore_0
    //   170: aload 11
    //   172: invokevirtual 106	com/tencent/mm/ui/blur/f:destroy	()V
    //   175: ldc 107
    //   177: istore_3
    //   178: iload 4
    //   180: ifne +6 -> 186
    //   183: ldc 108
    //   185: istore_3
    //   186: getstatic 114	com/tencent/mm/plugin/comm/b:qCp	Lcom/tencent/mm/plugin/comm/b;
    //   189: astore_1
    //   190: invokestatic 119	com/tencent/mm/ui/ao:isDarkMode	()Z
    //   193: aload_0
    //   194: invokestatic 122	com/tencent/mm/plugin/comm/b:a	(ZLandroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   197: astore_0
    //   198: ldc 124
    //   200: ldc 126
    //   202: iconst_2
    //   203: anewarray 4	java/lang/Object
    //   206: dup
    //   207: iconst_0
    //   208: iload 4
    //   210: invokestatic 132	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   213: aastore
    //   214: dup
    //   215: iconst_1
    //   216: lload 9
    //   218: invokestatic 136	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   221: invokestatic 141	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   224: aastore
    //   225: invokestatic 147	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   228: invokestatic 152	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: aload_0
    //   232: iload_3
    //   233: iload_2
    //   234: iload 6
    //   236: invokestatic 156	com/tencent/mm/sdk/platformtools/BitmapUtil:createMaskImage	(Landroid/graphics/Bitmap;III)Landroid/graphics/Bitmap;
    //   239: astore_0
    //   240: ldc 124
    //   242: ldc 158
    //   244: iconst_2
    //   245: anewarray 4	java/lang/Object
    //   248: dup
    //   249: iconst_0
    //   250: iload 4
    //   252: invokestatic 132	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   255: aastore
    //   256: dup
    //   257: iconst_1
    //   258: lload 9
    //   260: invokestatic 136	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   263: invokestatic 141	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   266: aastore
    //   267: invokestatic 147	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   270: invokestatic 152	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   273: ldc 23
    //   275: invokestatic 161	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   278: aload_0
    //   279: areturn
    //   280: astore_1
    //   281: ldc 124
    //   283: ldc 163
    //   285: invokestatic 166	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   288: goto -113 -> 175
    //   291: astore_0
    //   292: ldc 124
    //   294: ldc 168
    //   296: invokestatic 171	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   299: aload_1
    //   300: bipush 30
    //   302: invokestatic 175	com/tencent/mm/sdk/platformtools/BitmapUtil:fastblur	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   305: astore_0
    //   306: aload 11
    //   308: invokevirtual 106	com/tencent/mm/ui/blur/f:destroy	()V
    //   311: goto -136 -> 175
    //   314: astore_1
    //   315: ldc 124
    //   317: ldc 163
    //   319: invokestatic 166	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   322: goto -147 -> 175
    //   325: astore_0
    //   326: aload 11
    //   328: invokevirtual 106	com/tencent/mm/ui/blur/f:destroy	()V
    //   331: ldc 23
    //   333: invokestatic 161	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   336: aload_0
    //   337: athrow
    //   338: astore_0
    //   339: ldc 124
    //   341: aload_0
    //   342: ldc 177
    //   344: iconst_0
    //   345: anewarray 4	java/lang/Object
    //   348: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   351: ldc 23
    //   353: invokestatic 161	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   356: aconst_null
    //   357: areturn
    //   358: astore_1
    //   359: ldc 124
    //   361: ldc 163
    //   363: invokestatic 166	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   366: goto -35 -> 331
    //   369: aload_1
    //   370: astore_0
    //   371: goto -277 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	374	0	paramContext	Context
    //   0	374	1	paramBitmap	Bitmap
    //   0	374	2	paramInt1	int
    //   0	374	3	paramInt2	int
    //   0	374	4	paramBoolean	boolean
    //   118	7	5	f	float
    //   11	224	6	i	int
    //   48	91	7	j	int
    //   64	77	8	k	int
    //   8	251	9	l	long
    //   101	226	11	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   170	175	280	android/renderscript/RSInvalidStateException
    //   161	170	291	java/lang/Throwable
    //   306	311	314	android/renderscript/RSInvalidStateException
    //   161	170	325	finally
    //   292	306	325	finally
    //   17	25	338	java/lang/Exception
    //   31	39	338	java/lang/Exception
    //   39	66	338	java/lang/Exception
    //   70	77	338	java/lang/Exception
    //   77	94	338	java/lang/Exception
    //   94	161	338	java/lang/Exception
    //   170	175	338	java/lang/Exception
    //   186	273	338	java/lang/Exception
    //   281	288	338	java/lang/Exception
    //   306	311	338	java/lang/Exception
    //   315	322	338	java/lang/Exception
    //   326	331	338	java/lang/Exception
    //   331	338	338	java/lang/Exception
    //   359	366	338	java/lang/Exception
    //   326	331	358	android/renderscript/RSInvalidStateException
  }
  
  protected static boolean a(com.tencent.mm.ui.chatting.e.a parama, m paramm, View paramView, ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(233773);
    int i = ((bq)paramView.getTag()).position;
    if (paramca.field_content == null)
    {
      AppMethodBeat.o(233773);
      return true;
    }
    k.b localb = k.b.HD(bp.b(parama.gRM(), paramca.field_content, paramca.field_isSend));
    if (localb == null)
    {
      AppMethodBeat.o(233773);
      return true;
    }
    if ((3 != localb.type) && (76 != localb.type))
    {
      Log.e("MicroMsg.ChattingItemAppMsgMusic", "onCreateContextMenu(from), not music type, but enter here.");
      AppMethodBeat.o(233773);
      return true;
    }
    Object localObject = com.tencent.mm.pluginsdk.model.app.h.o(localb.appId, false, false);
    if ((com.tencent.mm.pluginsdk.model.app.h.l((com.tencent.mm.pluginsdk.model.app.g)localObject)) && (!com.tencent.mm.ui.chatting.k.bm(paramca)) && (paramca.field_status != 1)) {
      paramm.a(i, 111, parama.Pwc.getMMResources().getString(2131764628), 2131690674);
    }
    if ((!paramBoolean) && ((paramca.field_status == 2) || (paramca.fQV == 1)) && (c.b(paramca, parama)) && (c.bnf(paramca.field_talker)) && (!as.HF(parama.getTalkerUserName()))) {
      paramm.a(i, 123, paramView.getContext().getString(2131757446), 2131690650);
    }
    if ((com.tencent.mm.al.g.aZR()) && (!parama.gRN())) {
      paramm.add(i, 114, 0, paramView.getContext().getString(2131757429));
    }
    if ((com.tencent.mm.br.c.aZU("favorite")) && ((localObject == null) || (!((com.tencent.mm.pluginsdk.model.app.g)localObject).NA()))) {
      paramm.a(i, 116, paramView.getContext().getString(2131763947), 2131690551);
    }
    localObject = new ef();
    ((ef)localObject).dHy.msgId = paramca.field_msgId;
    EventCenter.instance.publish((IEvent)localObject);
    if ((((ef)localObject).dHz.dGX) || (e.b.a(parama.Pwc.getContext(), localb))) {
      paramm.a(i, 129, paramView.getContext().getString(2131757440), 2131690628);
    }
    if (!parama.gRN()) {
      paramm.a(i, 100, parama.Pwc.getMMResources().getString(2131757433), 2131690529);
    }
    if ((BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())) {
      paramm.a(i, 144, paramView.getContext().getString(2131763040), 2131690297);
    }
    AppMethodBeat.o(233773);
    return true;
  }
  
  protected static boolean a(c paramc, MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(233774);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(233774);
      return false;
    case 100: 
      AppMethodBeat.o(233774);
      return false;
    case 111: 
      if (!ac.bB(paramca))
      {
        com.tencent.mm.ui.base.h.a(parama.Pwc.getContext(), parama.Pwc.getContext().getString(2131759141), "", parama.Pwc.getContext().getString(2131768713), null);
        AppMethodBeat.o(233774);
        return false;
      }
      e.b.a(parama, paramca, paramc.a(parama, paramca));
      AppMethodBeat.o(233774);
      return false;
    case 114: 
      com.tencent.mm.ui.chatting.an.a(paramca, bp.b(parama.gRM(), paramca.field_content, paramca.field_isSend), parama.Pwc.getContext());
      AppMethodBeat.o(233774);
      return false;
    }
    paramc = new Intent();
    paramc.putExtra("Chat_Msg_Id", paramca.field_msgId);
    com.tencent.mm.br.c.b(parama.Pwc.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramc);
    AppMethodBeat.o(233774);
    return false;
  }
  
  public static final class a
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a PhN;
    private String jfz = "";
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(233757);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new an(paramLayoutInflater, 2131493545);
        ((View)localObject).setTag(new ab.c().G((View)localObject, true));
      }
      AppMethodBeat.o(233757);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(233758);
      this.PhN = parama1;
      ab.c.a(this, (ab.c)parama, paramca, true, paramInt, parama1);
      AppMethodBeat.o(233758);
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(233760);
      boolean bool = ab.a(this, paramMenuItem, parama, paramca);
      AppMethodBeat.o(233760);
      return bool;
    }
    
    public final boolean a(m paramm, View paramView, ca paramca)
    {
      AppMethodBeat.i(233759);
      boolean bool = ab.a(this.PhN, paramm, paramView, paramca, true);
      AppMethodBeat.o(233759);
      return bool;
    }
    
    public final boolean bM(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 1040187441);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(233761);
      boolean bool = ab.a(this, parama, paramca);
      AppMethodBeat.o(233761);
      return bool;
    }
    
    public final boolean gTT()
    {
      return false;
    }
  }
  
  public static final class b
    extends c
    implements t.n
  {
    private com.tencent.mm.ui.chatting.e.a PhN;
    private String jfz = "";
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(233762);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new an(paramLayoutInflater, 2131493596);
        ((View)localObject).setTag(new ab.c().G((View)localObject, false));
      }
      AppMethodBeat.o(233762);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(233763);
      this.PhN = parama1;
      ab.c.a(this, (ab.c)parama, paramca, false, paramInt, parama1);
      parama = (ab.c)parama;
      if (gTW())
      {
        if ((paramca.field_status != 2) || (!b((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class), paramca.field_msgId))) {
          break label102;
        }
        if (parama.PIn != null) {
          parama.PIn.setVisibility(0);
        }
      }
      for (;;)
      {
        a(paramInt, parama, paramca, parama1.gRI(), parama1.gRM(), parama1, this);
        AppMethodBeat.o(233763);
        return;
        label102:
        if (parama.PIn != null) {
          parama.PIn.setVisibility(8);
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(233765);
      boolean bool = ab.a(this, paramMenuItem, parama, paramca);
      AppMethodBeat.o(233765);
      return bool;
    }
    
    public final boolean a(m paramm, View paramView, ca paramca)
    {
      AppMethodBeat.i(233764);
      boolean bool = ab.a(this.PhN, paramm, paramView, paramca, false);
      AppMethodBeat.o(233764);
      return bool;
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(233767);
      paramca.unsetOmittedFailResend();
      bg.aVF();
      com.tencent.mm.model.c.aSQ().a(paramca.field_msgId, paramca);
      ((ad)parama.bh(ad.class)).bU(paramca);
      AppMethodBeat.o(233767);
    }
    
    public final boolean bM(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 1040187441);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(233766);
      boolean bool = ab.a(this, parama, paramca);
      AppMethodBeat.o(233766);
      return bool;
    }
    
    public final boolean gTT()
    {
      return true;
    }
  }
  
  static final class c
    extends c.a
  {
    protected ImageView AmB;
    protected TextView EYV;
    protected TextView EYW;
    protected WeImageView EYY;
    protected TextView EsH;
    protected ImageView PIn;
    protected RelativeLayout PLh;
    protected LinearLayout PLi;
    protected MMRoundCornerImageView PLj;
    protected TextView PLk;
    
    @SuppressLint({"ResourceType"})
    public static void a(c paramc, c paramc1, ca paramca, final boolean paramBoolean, int paramInt, com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(233772);
      if (paramc1 == null)
      {
        AppMethodBeat.o(233772);
        return;
      }
      Object localObject2 = paramca.field_content;
      Object localObject1 = localObject2;
      if (parama.gRM())
      {
        int i = paramca.field_content.indexOf(':');
        localObject1 = localObject2;
        if (i != -1) {
          localObject1 = paramca.field_content.substring(i + 1);
        }
      }
      if (localObject1 != null) {}
      for (k.b localb = k.b.aD((String)localObject1, paramca.field_reserved);; localb = null)
      {
        paramc1.EYV.setMaxLines(2);
        paramc1.EsH.setMaxLines(1);
        paramc1.EYW.setMaxLines(1);
        paramc1.EsH.setText("");
        if (localb == null)
        {
          Log.e("MicroMsg.MusicItemHolder", "null == content");
          AppMethodBeat.o(233772);
          return;
        }
        com.tencent.mm.pluginsdk.ui.tools.b localb1;
        label218:
        String str1;
        label285:
        label334:
        label597:
        String str2;
        label647:
        Object localObject3;
        Object localObject4;
        if (paramBoolean)
        {
          paramc1.PLh.setBackgroundResource(2131231671);
          if ((3 == localb.type) || (76 == localb.type))
          {
            localb1 = (com.tencent.mm.pluginsdk.ui.tools.b)localb.as(com.tencent.mm.pluginsdk.ui.tools.b.class);
            paramc1.EYV.setText(localb.getTitle());
            if ((localb1 == null) || (Util.isNullOrNil(localb1.Ktr))) {
              break label1273;
            }
            paramc1.EsH.setText(localb1.Ktr);
            paramc1.EYV.setTextColor(parama.Pwc.getContext().getResources().getColor(2131099746));
            paramc1.EsH.setTextColor(parama.Pwc.getContext().getResources().getColor(2131100584));
            if (Util.isNullOrNil(paramc1.EsH.getText())) {
              break label1288;
            }
            paramc1.EsH.setVisibility(0);
            localObject2 = com.tencent.mm.pluginsdk.model.app.h.gE(localb.appId, localb.appVersion);
            if ((localObject2 != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName.trim().length() > 0)) {
              break label1309;
            }
            localObject1 = localb.appName;
            if ((localb.appId != null) && (localb.appId.length() > 0) && (c.gp((String)localObject1)))
            {
              localObject1 = com.tencent.mm.pluginsdk.model.app.h.a(parama.Pwc.getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject2, (String)localObject1);
              paramc1.PLk.setText((CharSequence)localObject1);
              paramc1.PLk.setCompoundDrawables(null, null, null, null);
              c.a(parama, paramc1.PLk, localb.appId);
              c.a(parama, paramc1.PLj, localb.appId);
              paramc1.PLi.setVisibility(0);
            }
            paramc1.PLi.setBackgroundResource(2131231763);
            localObject2 = "";
            if (localb1 != null)
            {
              localObject1 = localb1.Ktp;
              localObject2 = localb1.Ktq;
              if (Util.isNullOrNil((String)localObject2)) {
                break label1319;
              }
              paramc1.EYV.setMaxLines(1);
              ((ViewGroup.MarginLayoutParams)paramc1.EYV.getLayoutParams()).topMargin = com.tencent.mm.cb.a.fromDPToPix(parama.Pwc.getContext(), 8);
              ((ViewGroup.MarginLayoutParams)paramc1.EsH.getLayoutParams()).topMargin = com.tencent.mm.cb.a.fromDPToPix(parama.Pwc.getContext(), 4);
              paramc1.PLh.findViewById(2131305768).setVisibility(0);
              paramc1.EYW.setText((String)localObject2 + parama.Pwc.getContext().getString(2131763368));
              paramc1.EYW.setVisibility(0);
              localObject2 = localObject1;
            }
            if (Util.isNullOrNil((String)localObject2)) {
              break label1430;
            }
            str1 = com.tencent.xweb.util.d.getMessageDigest(((String)localObject2).getBytes());
            str2 = str1 + "_cover";
            if (!paramBoolean) {
              break label1398;
            }
            localObject1 = "from";
            localObject3 = String.format("%s_bg_%s", new Object[] { str1, localObject1 });
            localObject1 = q.bcV().OQ(str2);
            localObject4 = q.bcV().OQ((String)localObject3);
            paramc1.AmB.setTag(str2);
            Log.i("MicroMsg.MusicItemHolder", "updateTag %s %s %s %s %s", new Object[] { Integer.valueOf(paramc1.AmB.hashCode()), paramc1.AmB.getTag(), str2, Long.valueOf(paramca.field_msgId), localObject2 });
            paramc1.PLh.setTag(localObject3);
            if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
              break label1406;
            }
            paramc1.AmB.setImageBitmap((Bitmap)localObject1);
            label784:
            if ((localObject4 == null) || (((Bitmap)localObject4).isRecycled())) {
              break label1419;
            }
            BitmapDrawable localBitmapDrawable = new BitmapDrawable(parama.Pwc.getContext().getResources(), (Bitmap)localObject4);
            paramc1.PLh.setBackground(localBitmapDrawable);
          }
        }
        for (;;)
        {
          str1 = com.tencent.mm.plugin.music.h.b.bT(str1, false);
          if (localObject1 != null)
          {
            localObject1 = str1;
            if (localObject4 != null) {}
          }
          else
          {
            localObject1 = new com.tencent.mm.av.a.a.c.a();
            ((com.tencent.mm.av.a.a.c.a)localObject1).jbf = true;
            ((com.tencent.mm.av.a.a.c.a)localObject1).jbd = true;
            ((com.tencent.mm.av.a.a.c.a)localObject1).fullPath = str1;
            ((com.tencent.mm.av.a.a.c.a)localObject1).jbE = new Object[] { paramc1.AmB, str2, paramc1.PLh, localObject3, str1 };
            q.bcV().a((String)localObject2, ((com.tencent.mm.av.a.a.c.a)localObject1).bdv(), new com.tencent.mm.av.a.c.d()
            {
              public final void a(boolean paramAnonymousBoolean, Object... paramAnonymousVarArgs)
              {
                AppMethodBeat.i(258291);
                ImageView localImageView = (ImageView)paramAnonymousVarArgs[0];
                String str1 = (String)paramAnonymousVarArgs[1];
                RelativeLayout localRelativeLayout = (RelativeLayout)paramAnonymousVarArgs[2];
                String str2 = (String)paramAnonymousVarArgs[3];
                paramAnonymousVarArgs = BitmapUtil.getBitmapNative((String)paramAnonymousVarArgs[4], localImageView.getWidth(), localImageView.getHeight());
                Bitmap localBitmap = ab.b(this.PHb.Pwc.getContext(), paramAnonymousVarArgs, localRelativeLayout.getHeight(), localRelativeLayout.getWidth(), paramBoolean);
                q.bcV().h(str1, paramAnonymousVarArgs);
                q.bcV().h(str2, localBitmap);
                com.tencent.f.h.RTc.aV(new ab.c.1.1(this, localImageView, str1, paramAnonymousVarArgs, localRelativeLayout, str2, localBitmap));
                AppMethodBeat.o(258291);
              }
            });
            localObject1 = str1;
          }
          if (!paramca.field_msgId.equals(paramc1.playingMsgId)) {
            break label1781;
          }
          paramc1.EYY.setImageResource(2131690862);
          label980:
          paramc1.EYY.setIconColor(parama.Pwc.getContext().getResources().getColor(2131100044));
          localObject2 = localObject1;
          if (new boolean[] { false }[0] != 0)
          {
            localObject2 = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.cb.a.getDensity(parama.Pwc.getContext()));
            if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled())) {
              break label1794;
            }
            paramc1.AmB.setImageResource(2131689567);
            localObject2 = localObject1;
          }
          label1069:
          if (!paramBoolean) {
            break label1821;
          }
          ab.a.a((ab.a)paramc, (String)localObject2);
          label1083:
          localObject1 = new e.g();
          ((e.g)localObject1).msgId = paramca.field_msgId;
          ((e.g)localObject1).xml = paramca.field_content;
          ((e.g)localObject1).dRr = paramca.field_imgPath;
          ((e.g)localObject1).jfy = al.a(localb, localb1);
          if (((e.g)localObject1).jfy != null) {
            ((e.g)localObject1).jfy.jfz = ((String)localObject2);
          }
          paramc1.EYY.setTag(localObject1);
          paramc1.EYY.setOnClickListener(((com.tencent.mm.ui.chatting.d.b.k)parama.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOD());
          paramc1.clickArea.setTag(new bq(paramca, parama.gRM(), paramInt, null, '\000'));
          paramc1.clickArea.setOnClickListener(paramc.d(parama));
          paramc1.clickArea.setOnLongClickListener(paramc.c(parama));
          paramc1.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
          AppMethodBeat.o(233772);
          return;
          paramc1.PLh.setBackgroundResource(2131231798);
          break;
          label1273:
          paramc1.EsH.setText(localb.getDescription());
          break label218;
          label1288:
          paramc1.EsH.setText("");
          paramc1.EsH.setVisibility(8);
          break label285;
          label1309:
          localObject1 = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName;
          break label334;
          label1319:
          ((ViewGroup.MarginLayoutParams)paramc1.EYV.getLayoutParams()).topMargin = 0;
          ((ViewGroup.MarginLayoutParams)paramc1.EsH.getLayoutParams()).topMargin = com.tencent.mm.cb.a.fromDPToPix(parama.Pwc.getContext(), 6);
          paramc1.PLh.findViewById(2131305768).setVisibility(8);
          paramc1.EYW.setText("");
          paramc1.EYW.setVisibility(8);
          localObject2 = localObject1;
          break label597;
          label1398:
          localObject1 = "to";
          break label647;
          label1406:
          paramc1.AmB.setImageResource(2131690616);
          break label784;
          label1419:
          paramc1.PLh.setBackground(null);
        }
        label1430:
        if (!localb.aSy())
        {
          bg.aVF();
          if (com.tencent.mm.model.c.isSDCardAvailable()) {
            if (e.b.bnh(paramca.field_imgPath)) {
              break label1834;
            }
          }
        }
        label1794:
        label1821:
        label1834:
        for (localObject2 = q.bcR().d(paramca.field_imgPath, false, true);; localObject2 = "")
        {
          localObject1 = localObject2;
          if (Util.isNullOrNil((String)localObject2)) {
            break;
          }
          str2 = com.tencent.xweb.util.d.getMessageDigest(((String)localObject2).getBytes());
          str1 = str2 + "_cover";
          if (paramBoolean) {}
          for (localObject1 = "from";; localObject1 = "to")
          {
            str2 = String.format("%s_bg_%s", new Object[] { str2, localObject1 });
            paramc1.AmB.setTag(str1);
            paramc1.PLh.setTag(str2);
            localObject1 = q.bcV().OQ(str1);
            localObject3 = q.bcV().OQ(str2);
            if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
            {
              Log.i("MicroMsg.MusicItemHolder", "coverBm (local) is valid, use cache, key:".concat(String.valueOf(str1)));
              paramc1.AmB.setImageBitmap((Bitmap)localObject1);
            }
            if ((localObject3 != null) && (!((Bitmap)localObject3).isRecycled()))
            {
              Log.i("MicroMsg.MusicItemHolder", "bgBm (local) is valid, use bg cache, key:".concat(String.valueOf(str2)));
              localObject4 = new BitmapDrawable(parama.Pwc.getContext().getResources(), (Bitmap)localObject3);
              paramc1.PLh.setBackground((Drawable)localObject4);
            }
            if (localObject1 != null)
            {
              localObject1 = localObject2;
              if (localObject3 != null) {
                break;
              }
            }
            localObject1 = paramc1.AmB;
            localObject3 = paramc1.PLh;
            com.tencent.f.h.RTc.aX(new ab.c.2(paramca, parama, (RelativeLayout)localObject3, paramBoolean, str1, str2, (ImageView)localObject1));
            localObject1 = localObject2;
            break;
          }
          paramc1.AmB.setImageBitmap(BitmapFactory.decodeResource(parama.Pwc.getMMResources(), 2131234278));
          localObject1 = "";
          break;
          label1781:
          paramc1.EYY.setImageResource(2131690885);
          break label980;
          paramc1.AmB.setImageBitmap((Bitmap)localObject2);
          localObject2 = a.a.eAZ().aJy(localb.appId);
          break label1069;
          ab.b.a((ab.b)paramc, (String)localObject2);
          break label1083;
        }
      }
    }
    
    public final c.a G(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(233771);
      super.create(paramView);
      this.clickArea = paramView.findViewById(2131298517);
      this.PLh = ((RelativeLayout)paramView.findViewById(2131298518));
      this.userTV = ((TextView)paramView.findViewById(2131298566));
      this.EsH = ((TextView)paramView.findViewById(2131298523));
      this.EYV = ((TextView)paramView.findViewById(2131298524));
      this.EYW = ((TextView)paramView.findViewById(2131298521));
      this.EYY = ((WeImageView)paramView.findViewById(2131298520));
      this.AmB = ((ImageView)paramView.findViewById(2131298519));
      RoundCornerRelativeLayout localRoundCornerRelativeLayout = (RoundCornerRelativeLayout)paramView.findViewById(2131298522);
      int i = at.fromDPToPix(paramView.getContext(), 4);
      localRoundCornerRelativeLayout.s(i, 0.0F, i, 0.0F);
      this.PLi = ((LinearLayout)paramView.findViewById(2131298525));
      this.PLj = ((MMRoundCornerImageView)paramView.findViewById(2131298526));
      i = at.fromDPToPix(paramView.getContext(), 14);
      this.PLj.setRadius(i);
      this.PLk = ((TextView)paramView.findViewById(2131298527));
      this.checkBox = ((CheckBox)paramView.findViewById(2131298410));
      this.maskView = paramView.findViewById(2131298508);
      this.uploadingPB = ((ProgressBar)paramView.findViewById(2131309619));
      if (!paramBoolean) {
        this.PIn = ((ImageView)paramView.findViewById(2131298556));
      }
      this.EYV.setTextSize(1, 15.0F);
      this.EsH.setTextSize(1, 12.0F);
      AppMethodBeat.o(233771);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ab
 * JD-Core Version:    0.7.0.1
 */