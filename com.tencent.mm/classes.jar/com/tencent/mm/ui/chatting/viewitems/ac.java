package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu.ContextMenuInfo;
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
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.ex;
import com.tencent.mm.autogen.a.ex.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.loader.b.d;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.findersdk.a.cp;
import com.tencent.mm.plugin.findersdk.a.cr;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.protocal.protobuf.dtk;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ae;
import com.tencent.mm.ui.chatting.component.api.ag;
import com.tencent.mm.ui.chatting.u;
import com.tencent.mm.ui.chatting.v.n;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public final class ac
{
  /* Error */
  private static final Bitmap a(Context paramContext, Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 29
    //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 41	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   8: lstore 8
    //   10: iload_2
    //   11: istore 6
    //   13: iload_2
    //   14: ifne +11 -> 25
    //   17: aload_0
    //   18: bipush 88
    //   20: invokestatic 47	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
    //   23: istore 6
    //   25: iload_3
    //   26: istore_2
    //   27: iload_3
    //   28: ifne +11 -> 39
    //   31: aload_0
    //   32: sipush 280
    //   35: invokestatic 47	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
    //   38: istore_2
    //   39: aload_1
    //   40: invokevirtual 53	android/graphics/Bitmap:getHeight	()I
    //   43: istore_3
    //   44: aload_1
    //   45: invokevirtual 56	android/graphics/Bitmap:getWidth	()I
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
    //   64: istore_2
    //   65: aload_1
    //   66: ifnull +10 -> 76
    //   69: aload_1
    //   70: invokevirtual 60	android/graphics/Bitmap:isRecycled	()Z
    //   73: ifeq +239 -> 312
    //   76: aload_0
    //   77: invokevirtual 66	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   80: getstatic 72	com/tencent/mm/R$e:chat_item_default_mucic_mask_color	I
    //   83: invokevirtual 78	android/content/res/Resources:getColor	(I)I
    //   86: iload 7
    //   88: iload_2
    //   89: invokestatic 84	com/tencent/mm/sdk/platformtools/BitmapUtil:createColorBitmap	(III)Landroid/graphics/Bitmap;
    //   92: astore_0
    //   93: new 86	android/graphics/Matrix
    //   96: dup
    //   97: invokespecial 90	android/graphics/Matrix:<init>	()V
    //   100: astore 10
    //   102: iload 6
    //   104: i2f
    //   105: fconst_1
    //   106: fmul
    //   107: iload_2
    //   108: i2f
    //   109: fdiv
    //   110: ldc 91
    //   112: fmul
    //   113: ldc 91
    //   115: fmul
    //   116: fstore 5
    //   118: aload 10
    //   120: fload 5
    //   122: fload 5
    //   124: invokevirtual 95	android/graphics/Matrix:postScale	(FF)Z
    //   127: pop
    //   128: aload_0
    //   129: iconst_0
    //   130: iload_3
    //   131: iload_2
    //   132: isub
    //   133: iconst_2
    //   134: idiv
    //   135: iload 7
    //   137: iload_2
    //   138: aload 10
    //   140: iconst_0
    //   141: invokestatic 99	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   144: astore_0
    //   145: new 101	com/tencent/mm/ui/blur/f
    //   148: dup
    //   149: invokestatic 107	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   152: invokespecial 110	com/tencent/mm/ui/blur/f:<init>	(Landroid/content/Context;)V
    //   155: astore 10
    //   157: aload 10
    //   159: aload_0
    //   160: ldc 111
    //   162: invokevirtual 114	com/tencent/mm/ui/blur/f:c	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   165: astore_0
    //   166: aload 10
    //   168: invokevirtual 117	com/tencent/mm/ui/blur/f:destroy	()V
    //   171: getstatic 123	com/tencent/mm/plugin/comm/b:xeH	Lcom/tencent/mm/plugin/comm/b;
    //   174: astore_1
    //   175: invokestatic 128	com/tencent/mm/ui/aw:isDarkMode	()Z
    //   178: aload_0
    //   179: invokestatic 131	com/tencent/mm/plugin/comm/b:a	(ZLandroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   182: astore_0
    //   183: ldc 133
    //   185: ldc 135
    //   187: iconst_2
    //   188: anewarray 4	java/lang/Object
    //   191: dup
    //   192: iconst_0
    //   193: iload 4
    //   195: invokestatic 141	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   198: aastore
    //   199: dup
    //   200: iconst_1
    //   201: lload 8
    //   203: invokestatic 145	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   206: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   209: aastore
    //   210: invokestatic 156	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   213: invokestatic 161	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   216: ldc 29
    //   218: invokestatic 164	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: aload_0
    //   222: areturn
    //   223: astore_1
    //   224: ldc 133
    //   226: ldc 166
    //   228: invokestatic 169	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: goto -60 -> 171
    //   234: astore_0
    //   235: ldc 133
    //   237: aload_0
    //   238: ldc 171
    //   240: iconst_0
    //   241: anewarray 4	java/lang/Object
    //   244: invokestatic 175	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   247: ldc 29
    //   249: invokestatic 164	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   252: aconst_null
    //   253: areturn
    //   254: astore_0
    //   255: ldc 133
    //   257: ldc 177
    //   259: invokestatic 180	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   262: aload_1
    //   263: bipush 30
    //   265: invokestatic 184	com/tencent/mm/sdk/platformtools/BitmapUtil:fastblur	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   268: astore_0
    //   269: aload 10
    //   271: invokevirtual 117	com/tencent/mm/ui/blur/f:destroy	()V
    //   274: goto -103 -> 171
    //   277: astore_1
    //   278: ldc 133
    //   280: ldc 166
    //   282: invokestatic 169	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   285: goto -114 -> 171
    //   288: astore_0
    //   289: aload 10
    //   291: invokevirtual 117	com/tencent/mm/ui/blur/f:destroy	()V
    //   294: ldc 29
    //   296: invokestatic 164	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   299: aload_0
    //   300: athrow
    //   301: astore_1
    //   302: ldc 133
    //   304: ldc 166
    //   306: invokestatic 169	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   309: goto -15 -> 294
    //   312: aload_1
    //   313: astore_0
    //   314: goto -221 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	317	0	paramContext	Context
    //   0	317	1	paramBitmap	Bitmap
    //   0	317	2	paramInt1	int
    //   0	317	3	paramInt2	int
    //   0	317	4	paramBoolean	boolean
    //   116	7	5	f	float
    //   11	92	6	i	int
    //   48	88	7	j	int
    //   8	194	8	l	long
    //   100	190	10	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   166	171	223	android/renderscript/RSInvalidStateException
    //   17	25	234	java/lang/Exception
    //   31	39	234	java/lang/Exception
    //   39	65	234	java/lang/Exception
    //   69	76	234	java/lang/Exception
    //   76	93	234	java/lang/Exception
    //   93	157	234	java/lang/Exception
    //   166	171	234	java/lang/Exception
    //   171	216	234	java/lang/Exception
    //   224	231	234	java/lang/Exception
    //   269	274	234	java/lang/Exception
    //   278	285	234	java/lang/Exception
    //   289	294	234	java/lang/Exception
    //   294	301	234	java/lang/Exception
    //   302	309	234	java/lang/Exception
    //   157	166	254	finally
    //   269	274	277	android/renderscript/RSInvalidStateException
    //   255	269	288	finally
    //   289	294	301	android/renderscript/RSInvalidStateException
  }
  
  public static boolean a(k.b paramb, Context paramContext, String paramString, cc paramcc)
  {
    AppMethodBeat.i(255179);
    Log.i("MicroMsg.ChattingItemAppMsgMusic", "handleMusicVideoClick, content:%s", new Object[] { paramb.nUe });
    if (!((cn)com.tencent.mm.kernel.h.az(cn.class)).canEnterMvAndShowToast())
    {
      AppMethodBeat.o(255179);
      return false;
    }
    Log.i("MicroMsg.ChattingItemAppMsgMusic", "handleMusicVideoClick, doPlayMusic, musicCoverPath:%s", new Object[] { paramString });
    Intent localIntent = new Intent();
    localIntent.putExtra("key_scene", 6);
    String str = paramString;
    com.tencent.mm.pluginsdk.ui.tools.b localb;
    if (paramb != null)
    {
      localb = (com.tencent.mm.pluginsdk.ui.tools.b)paramb.aK(com.tencent.mm.pluginsdk.ui.tools.b.class);
      str = paramString;
      if (localb != null)
      {
        localIntent.putExtra("key_mv_song_name", paramb.title);
        localIntent.putExtra("key_mv_song_lyric", localb.songLyric);
        localIntent.putExtra("key_mv_album_cover_url", localb.songAlbumUrl);
        localIntent.putExtra("key_mv_feed_id", localb.YqN);
        localIntent.putExtra("key_mv_nonce_id", localb.YqO);
        localIntent.putExtra("key_mv_cover_url", localb.YqP);
        localIntent.putExtra("key_mv_poster", localb.YqQ);
        if (Util.isNullOrNil(localb.YqR)) {
          break label494;
        }
      }
    }
    label494:
    for (str = localb.YqR;; str = paramb.description)
    {
      localIntent.putExtra("key_mv_singer_name", str);
      localIntent.putExtra("key_mv_album_name", localb.YqS);
      localIntent.putExtra("key_mv_music_genre", localb.YqT);
      localIntent.putExtra("key_mv_issue_date", localb.YqU);
      localIntent.putExtra("key_mv_music_duration", localb.LNC);
      localIntent.putExtra("key_mv_identification", localb.YqV);
      localIntent.putExtra("key_mv_extra_info", localb.YqW);
      localIntent.putExtra("key_mv_thumb_path", paramString);
      localIntent.putExtra("key_mv_music_operation_url", localb.YqX);
      localIntent.putExtra("key_mv_song_mid", localb.oOZ);
      str = paramString;
      if (Util.isNullOrNil(paramString))
      {
        str = paramString;
        if (!Util.isNullOrNil(localb.YqP)) {
          str = com.tencent.mm.plugin.music.h.b.cy(com.tencent.mm.b.g.getMessageDigest(localb.YqP.getBytes()) + "_cover", false);
        }
      }
      localIntent.setFlags(268435456);
      u.a(paramcc, paramb, str);
      paramb = com.tencent.mm.plugin.secdata.ui.a.PlI;
      paramb = (dtk)a.a.a(paramContext, "MusicMvMainUI", 7, dtk.class);
      paramb.scene = 2;
      paramString = com.tencent.mm.plugin.comm.a.xeG;
      paramb.zIO = com.tencent.mm.plugin.comm.a.dsT();
      paramb.aaYP = 84;
      paramb.aaYQ = paramcc.field_talker;
      com.tencent.mm.br.c.b(paramContext, "mv", ".ui.MusicMvMainUI", localIntent);
      AppMethodBeat.o(255179);
      return true;
    }
  }
  
  protected static boolean a(com.tencent.mm.ui.chatting.d.a parama, s params, View paramView, cc paramcc, boolean paramBoolean)
  {
    AppMethodBeat.i(255169);
    int i = ((bz)paramView.getTag()).position;
    if (paramcc.field_content == null)
    {
      AppMethodBeat.o(255169);
      return true;
    }
    k.b localb = k.b.Hf(br.a(parama.juG(), paramcc.field_content, paramcc.field_isSend));
    if (localb == null)
    {
      AppMethodBeat.o(255169);
      return true;
    }
    if ((3 != localb.type) && (76 != localb.type))
    {
      Log.e("MicroMsg.ChattingItemAppMsgMusic", "onCreateContextMenu(from), not music type, but enter here.");
      AppMethodBeat.o(255169);
      return true;
    }
    Object localObject = com.tencent.mm.pluginsdk.model.app.h.s(localb.appId, false, false);
    if ((com.tencent.mm.pluginsdk.model.app.h.l((com.tencent.mm.pluginsdk.model.app.g)localObject)) && (!com.tencent.mm.ui.chatting.m.bR(paramcc)) && (!com.tencent.mm.ui.chatting.m.bT(paramcc)) && (paramcc.field_status != 1)) {
      params.a(i, 111, parama.aezO.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
    }
    if ((!paramBoolean) && ((paramcc.field_status == 2) || (paramcc.kLk == 1)) && (c.c(paramcc, parama)) && (c.bBs(paramcc.field_talker)) && (!au.Hh(parama.getTalkerUserName()))) {
      params.a(i, 123, paramView.getContext().getString(R.l.gyA), R.k.icons_filled_previous);
    }
    if ((com.tencent.mm.an.g.bGR()) && (!parama.juH())) {
      params.add(i, 114, 0, paramView.getContext().getString(R.l.gyk));
    }
    if ((com.tencent.mm.br.c.blq("favorite")) && ((localObject == null) || (!((com.tencent.mm.pluginsdk.model.app.g)localObject).aqJ()))) {
      params.a(i, 116, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
    }
    localObject = new ex();
    ((ex)localObject).hFc.msgId = paramcc.field_msgId;
    ((ex)localObject).publish();
    if ((((ex)localObject).hFd.hEn) || (e.b.a(parama.aezO.getContext(), localb))) {
      params.a(i, 129, paramView.getContext().getString(R.l.gyu), R.k.icons_filled_open);
    }
    if (!parama.juH()) {
      params.a(i, 100, parama.aezO.getMMResources().getString(R.l.gyo), R.k.icons_filled_delete);
    }
    AppMethodBeat.o(255169);
    return true;
  }
  
  protected static boolean a(final c paramc, MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(255171);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(255171);
      return false;
    case 100: 
      AppMethodBeat.o(255171);
      return false;
    case 111: 
      if (!ae.cj(paramcc))
      {
        k.a(parama.aezO.getContext(), parama.aezO.getContext().getString(R.l.gHq), "", parama.aezO.getContext().getString(R.l.welcome_i_know), null);
        AppMethodBeat.o(255171);
        return false;
      }
      e.b.a(parama, paramcc, paramc.a(parama, paramcc), 2000, new com.tencent.mm.br.c.a()
      {
        public final void onActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(255002);
          if ((paramAnonymousInt1 == 2000) && (paramAnonymousInt2 == -1))
          {
            paramAnonymousIntent = Util.listToString(paramAnonymousIntent.getStringArrayListExtra("SendMsgUsernames"), ";");
            cp localcp = cp.HcA;
            cp.a(ac.this, paramc.aedO, true, paramAnonymousIntent);
          }
          AppMethodBeat.o(255002);
        }
      });
      AppMethodBeat.o(255171);
      return false;
    }
    com.tencent.mm.ui.chatting.ap.a(paramcc, br.a(parama.juG(), paramcc.field_content, paramcc.field_isSend), parama.aezO.getContext());
    AppMethodBeat.o(255171);
    return false;
  }
  
  public static final class a
    extends c
  {
    private com.tencent.mm.ui.chatting.d.a aeiK;
    private String oPc = "";
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(255733);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new ap(paramLayoutInflater, R.i.gfS);
        ((View)localObject).setTag(new ac.c().P((View)localObject, true));
      }
      AppMethodBeat.o(255733);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
    {
      AppMethodBeat.i(255738);
      this.aeiK = parama1;
      ac.c.a(this, (ac.c)parama, paramcc, true, paramInt, parama1);
      AppMethodBeat.o(255738);
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255745);
      boolean bool = ac.a(this, paramMenuItem, parama, paramcc);
      AppMethodBeat.o(255745);
      return bool;
    }
    
    public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(255742);
      boolean bool = ac.a(this.aeiK, params, paramView, paramcc, true);
      AppMethodBeat.o(255742);
      return bool;
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255748);
      boolean bool = ac.a(this, parama, paramcc);
      AppMethodBeat.o(255748);
      return bool;
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 1040187441);
    }
    
    public final boolean fXn()
    {
      return false;
    }
  }
  
  public static final class b
    extends c
    implements v.n
  {
    private com.tencent.mm.ui.chatting.d.a aeiK;
    private String oPc = "";
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(255729);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new ap(paramLayoutInflater, R.i.ggS);
        ((View)localObject).setTag(new ac.c().P((View)localObject, false));
      }
      AppMethodBeat.o(255729);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
    {
      AppMethodBeat.i(255737);
      this.aeiK = parama1;
      ac.c.a(this, (ac.c)parama, paramcc, false, paramInt, parama1);
      parama = (ac.c)parama;
      if (jxj())
      {
        if ((paramcc.field_status != 2) || (!b((com.tencent.mm.ui.chatting.component.api.m)parama1.cm(com.tencent.mm.ui.chatting.component.api.m.class), paramcc.field_msgId))) {
          break label102;
        }
        if (parama.aeNG != null) {
          parama.aeNG.setVisibility(0);
        }
      }
      for (;;)
      {
        a(paramInt, parama, paramcc, parama1.getSelfUserName(), parama1.juG(), parama1, this);
        AppMethodBeat.o(255737);
        return;
        label102:
        if (parama.aeNG != null) {
          parama.aeNG.setVisibility(8);
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255746);
      boolean bool = ac.a(this, paramMenuItem, parama, paramcc);
      AppMethodBeat.o(255746);
      return bool;
    }
    
    public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(255741);
      boolean bool = ac.a(this.aeiK, params, paramView, paramcc, false);
      AppMethodBeat.o(255741);
      return bool;
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255752);
      paramcc.unsetOmittedFailResend();
      bh.bCz();
      com.tencent.mm.model.c.bzD().a(paramcc.field_msgId, paramcc);
      ((ag)parama.cm(ag.class)).cK(paramcc);
      AppMethodBeat.o(255752);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255749);
      boolean bool = ac.a(this, parama, paramcc);
      AppMethodBeat.o(255749);
      return bool;
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 1040187441);
    }
    
    public final boolean fXn()
    {
      return true;
    }
  }
  
  static final class c
    extends c.a
  {
    protected View DmL;
    protected ImageView LOJ;
    protected TextView RMS;
    protected TextView RMT;
    protected WeImageView RMV;
    protected TextView RfE;
    protected ImageView aeNG;
    protected RelativeLayout aeRf;
    protected LinearLayout aeRg;
    protected MMRoundCornerImageView aeRh;
    protected TextView aeRi;
    
    public static void a(c paramc, c paramc1, cc paramcc, final boolean paramBoolean, int paramInt, final com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(255775);
      if (paramc1 == null)
      {
        AppMethodBeat.o(255775);
        return;
      }
      Object localObject2 = paramcc.field_content;
      Object localObject1 = localObject2;
      if (parama.juG())
      {
        int i = paramcc.field_content.indexOf(':');
        localObject1 = localObject2;
        if (i != -1) {
          localObject1 = paramcc.field_content.substring(i + 1);
        }
      }
      if (localObject1 != null) {}
      for (k.b localb = k.b.aP((String)localObject1, paramcc.field_reserved);; localb = null)
      {
        paramc1.RMS.setMaxLines(2);
        paramc1.RfE.setMaxLines(1);
        paramc1.RMT.setMaxLines(1);
        paramc1.RfE.setText("");
        paramc1.LOJ.setImageDrawable(parama.aezO.getContext().getResources().getDrawable(R.g.music_mv_cover_empty_lightmode));
        if (aw.isDarkMode()) {
          paramc1.LOJ.setImageDrawable(parama.aezO.getContext().getResources().getDrawable(R.g.music_mv_cover_empty_darkmode));
        }
        if (localb == null)
        {
          Log.e("MicroMsg.MusicItemHolder", "null == content");
          AppMethodBeat.o(255775);
          return;
        }
        com.tencent.mm.pluginsdk.ui.tools.b localb1;
        label273:
        label342:
        label481:
        final String str1;
        label391:
        label548:
        label717:
        final String str2;
        label767:
        Object localObject3;
        Object localObject4;
        if (paramBoolean)
        {
          paramc1.aeRf.setBackgroundResource(R.g.chatfrom_bg_app);
          if ((3 == localb.type) || (76 == localb.type))
          {
            localb1 = (com.tencent.mm.pluginsdk.ui.tools.b)localb.aK(com.tencent.mm.pluginsdk.ui.tools.b.class);
            paramc1.RMS.setText(localb.getTitle());
            if ((localb1 == null) || (Util.isNullOrNil(localb1.YqR))) {
              break label1362;
            }
            paramc1.RfE.setText(localb1.YqR);
            paramc1.RMS.setTextColor(parama.aezO.getContext().getResources().getColor(R.e.FG_0));
            paramc1.RfE.setTextColor(parama.aezO.getContext().getResources().getColor(R.e.half_alpha_black));
            if (Util.isNullOrNil(paramc1.RfE.getText())) {
              break label1377;
            }
            paramc1.RfE.setVisibility(0);
            localObject2 = com.tencent.mm.pluginsdk.model.app.h.is(localb.appId, localb.appVersion);
            if ((localObject2 != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName.trim().length() > 0)) {
              break label1398;
            }
            localObject1 = localb.appName;
            if ((localb.appId != null) && (localb.appId.length() > 0) && (c.iA((String)localObject1)))
            {
              localObject1 = com.tencent.mm.pluginsdk.model.app.h.a(parama.aezO.getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject2, (String)localObject1);
              if (((localb1.YqY == null) || (!"wx485a97c844086dc9".equals(localb1.YqY))) && (!"wx485a97c844086dc9".equals(localb.appId))) {
                break label1408;
              }
              localObject1 = "摇一摇";
              paramc1.DmL.setVisibility(0);
              paramc1.aeRi.setText((CharSequence)localObject1);
              paramc1.aeRi.setCompoundDrawables(null, null, null, null);
              if ((localb1.YqY == null) || (localb1.YqY.length() <= 0)) {
                break label1420;
              }
              c.a(parama, paramc1.aeRi, localb1.YqY);
              c.a(parama, paramc1.aeRh, localb1.YqY);
              paramc1.aeRg.setVisibility(0);
            }
            paramc1.aeRg.setBackgroundResource(R.g.fnm);
            localObject1 = "";
            if (localb1 != null)
            {
              localObject1 = localb1.YqP;
              localObject2 = localb1.YqQ;
              if (Util.isNullOrNil((String)localObject2)) {
                break label1451;
              }
              paramc1.RMS.setMaxLines(1);
              ((ViewGroup.MarginLayoutParams)paramc1.RMS.getLayoutParams()).topMargin = com.tencent.mm.cd.a.fromDPToPix(parama.aezO.getContext(), 8);
              ((ViewGroup.MarginLayoutParams)paramc1.RfE.getLayoutParams()).topMargin = com.tencent.mm.cd.a.fromDPToPix(parama.aezO.getContext(), 4);
              paramc1.aeRf.findViewById(R.h.padding_view).setVisibility(0);
              paramc1.RMT.setText((String)localObject2 + parama.aezO.getContext().getString(R.l.music_mv_info_share_suffix));
              paramc1.RMT.setVisibility(0);
            }
            if (Util.isNullOrNil((String)localObject1)) {
              break label1546;
            }
            str1 = com.tencent.mm.b.g.getMessageDigest(((String)localObject1).getBytes());
            str2 = str1 + "_cover";
            if (!paramBoolean) {
              break label1527;
            }
            localObject2 = "from";
            localObject3 = String.format("%s_bg_%s", new Object[] { str1, localObject2 });
            localObject2 = r.bKe().Oo(str2);
            localObject4 = r.bKe().Oo((String)localObject3);
            paramc1.LOJ.setTag(str2);
            Log.i("MicroMsg.MusicItemHolder", "updateTag %s %s %s %s %s", new Object[] { Integer.valueOf(paramc1.LOJ.hashCode()), paramc1.LOJ.getTag(), str2, Long.valueOf(paramcc.field_msgId), localObject1 });
            paramc1.aeRf.setTag(localObject3);
            if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled())) {
              paramc1.LOJ.setImageBitmap((Bitmap)localObject2);
            }
            if ((localObject4 == null) || (((Bitmap)localObject4).isRecycled())) {
              break label1535;
            }
            BitmapDrawable localBitmapDrawable = new BitmapDrawable(parama.aezO.getContext().getResources(), (Bitmap)localObject4);
            paramc1.aeRf.setBackground(localBitmapDrawable);
          }
        }
        for (;;)
        {
          str1 = com.tencent.mm.plugin.music.h.b.cy(str1, false);
          if (localObject2 != null)
          {
            localObject2 = str1;
            if (localObject4 != null) {}
          }
          else
          {
            localObject2 = new com.tencent.mm.modelimage.loader.a.c.a();
            ((com.tencent.mm.modelimage.loader.a.c.a)localObject2).oKp = true;
            ((com.tencent.mm.modelimage.loader.a.c.a)localObject2).oKn = true;
            ((com.tencent.mm.modelimage.loader.a.c.a)localObject2).fullPath = str1;
            ((com.tencent.mm.modelimage.loader.a.c.a)localObject2).oKP = new Object[] { paramc1.LOJ, str2, paramc1.aeRf, localObject3, str1 };
            r.bKe().a((String)localObject1, ((com.tencent.mm.modelimage.loader.a.c.a)localObject2).bKx(), new d()
            {
              public final void onImageDownload(boolean paramAnonymousBoolean, final Object... paramAnonymousVarArgs)
              {
                AppMethodBeat.i(255217);
                final ImageView localImageView = (ImageView)paramAnonymousVarArgs[0];
                final String str1 = (String)paramAnonymousVarArgs[1];
                final RelativeLayout localRelativeLayout = (RelativeLayout)paramAnonymousVarArgs[2];
                final String str2 = (String)paramAnonymousVarArgs[3];
                paramAnonymousVarArgs = BitmapUtil.getBitmapNative((String)paramAnonymousVarArgs[4], localImageView.getWidth(), localImageView.getHeight());
                final Bitmap localBitmap = ac.b(ac.c.this.aezO.getContext(), paramAnonymousVarArgs, localRelativeLayout.getHeight(), localRelativeLayout.getWidth(), paramBoolean);
                r.bKe().h(str1, paramAnonymousVarArgs);
                r.bKe().h(str2, localBitmap);
                com.tencent.threadpool.h.ahAA.bk(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(254887);
                    if ((localImageView.getTag() != null) && (localImageView.getTag().equals(str1)))
                    {
                      Log.i("MicroMsg.MusicItemHolder", "setImageBitmap %s %s %s ", new Object[] { Integer.valueOf(localImageView.hashCode()), localImageView.getTag(), str1 });
                      localImageView.setImageBitmap(paramAnonymousVarArgs);
                    }
                    if ((localRelativeLayout.getTag() != null) && (localRelativeLayout.getTag().equals(str2)))
                    {
                      BitmapDrawable localBitmapDrawable = new BitmapDrawable(ac.c.this.aezO.getContext().getResources(), localBitmap);
                      localRelativeLayout.setBackground(localBitmapDrawable);
                    }
                    AppMethodBeat.o(254887);
                  }
                });
                AppMethodBeat.o(255217);
              }
            });
            localObject2 = str1;
          }
          if (!(paramcc.field_msgId + "_msg").equals(paramc1.playingMsgId)) {
            break label1897;
          }
          paramc1.RMV.setImageResource(R.k.icons_outlined_pause2);
          paramc1.RMV.setContentDescription(MMApplicationContext.getString(R.l.sns_stop_music));
          label1119:
          paramc1.RMV.setIconColor(parama.aezO.getContext().getResources().getColor(R.e.black_color));
          if (!paramBoolean) {
            break label1923;
          }
          ac.a.a((ac.a)paramc, (String)localObject2);
          label1157:
          localObject1 = new e.g();
          ((e.g)localObject1).msgId = paramcc.field_msgId;
          ((e.g)localObject1).xml = paramcc.field_content;
          ((e.g)localObject1).hQn = paramcc.field_imgPath;
          ((e.g)localObject1).oPb = cr.a(localb, localb1);
          if (((e.g)localObject1).oPb != null) {
            ((e.g)localObject1).oPb.oPc = ((String)localObject2);
          }
          ((e.g)localObject1).nSq = 1;
          ((e.g)localObject1).aaYQ = paramcc.field_talker;
          paramc1.RMV.setTag(localObject1);
          paramc1.RMV.setOnClickListener(((com.tencent.mm.ui.chatting.component.api.m)parama.cm(com.tencent.mm.ui.chatting.component.api.m.class)).jqw());
          paramc1.clickArea.setTag(new bz(paramcc, parama.juG(), paramInt, null, '\000'));
          paramc1.clickArea.setOnClickListener(paramc.d(parama));
          paramc1.clickArea.setOnLongClickListener(paramc.c(parama));
          paramc1.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.component.api.m)parama.cm(com.tencent.mm.ui.chatting.component.api.m.class)).jqv());
          AppMethodBeat.o(255775);
          return;
          paramc1.aeRf.setBackgroundResource(R.g.chatto_bg_app);
          break;
          label1362:
          paramc1.RfE.setText(localb.getDescription());
          break label273;
          label1377:
          paramc1.RfE.setText("");
          paramc1.RfE.setVisibility(8);
          break label342;
          label1398:
          localObject1 = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName;
          break label391;
          label1408:
          paramc1.DmL.setVisibility(8);
          break label481;
          label1420:
          c.a(parama, paramc1.aeRi, localb.appId);
          c.a(parama, paramc1.aeRh, localb.appId);
          break label548;
          label1451:
          ((ViewGroup.MarginLayoutParams)paramc1.RMS.getLayoutParams()).topMargin = 0;
          ((ViewGroup.MarginLayoutParams)paramc1.RfE.getLayoutParams()).topMargin = com.tencent.mm.cd.a.fromDPToPix(parama.aezO.getContext(), 6);
          paramc1.aeRf.findViewById(R.h.padding_view).setVisibility(8);
          paramc1.RMT.setText("");
          paramc1.RMT.setVisibility(8);
          break label717;
          label1527:
          localObject2 = "to";
          break label767;
          label1535:
          paramc1.aeRf.setBackground(null);
        }
        label1546:
        if (!localb.bwo())
        {
          bh.bCz();
          if (com.tencent.mm.model.c.isSDCardAvailable()) {
            if (e.b.bBw(paramcc.field_imgPath)) {
              break label1936;
            }
          }
        }
        label1923:
        label1936:
        for (localObject1 = r.bKa().d(paramcc.field_imgPath, false, true);; localObject1 = "")
        {
          localObject2 = localObject1;
          if (Util.isNullOrNil((String)localObject1)) {
            break;
          }
          str2 = com.tencent.mm.b.g.getMessageDigest(((String)localObject1).getBytes());
          str1 = str2 + "_cover";
          if (paramBoolean) {}
          for (localObject2 = "from";; localObject2 = "to")
          {
            str2 = String.format("%s_bg_%s", new Object[] { str2, localObject2 });
            paramc1.LOJ.setTag(str1);
            paramc1.aeRf.setTag(str2);
            localObject2 = r.bKe().Oo(str1);
            localObject3 = r.bKe().Oo(str2);
            if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
            {
              Log.i("MicroMsg.MusicItemHolder", "coverBm (local) is valid, use cache, key:".concat(String.valueOf(str1)));
              paramc1.LOJ.setImageBitmap((Bitmap)localObject2);
            }
            if ((localObject3 != null) && (!((Bitmap)localObject3).isRecycled()))
            {
              Log.i("MicroMsg.MusicItemHolder", "bgBm (local) is valid, use bg cache, key:".concat(String.valueOf(str2)));
              localObject4 = new BitmapDrawable(parama.aezO.getContext().getResources(), (Bitmap)localObject3);
              paramc1.aeRf.setBackground((Drawable)localObject4);
            }
            if (localObject2 != null)
            {
              localObject2 = localObject1;
              if (localObject3 != null) {
                break;
              }
            }
            localObject2 = paramc1.LOJ;
            localObject3 = paramc1.aeRf;
            com.tencent.threadpool.h.ahAA.bm(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(255310);
                final Bitmap localBitmap1 = r.bKa().a(ac.c.this.field_imgPath, com.tencent.mm.cd.a.getDensity(parama.aezO.getContext()), false);
                final Bitmap localBitmap2 = ac.b(parama.aezO.getContext(), localBitmap1, this.aeRl.getHeight(), this.aeRl.getWidth(), paramBoolean);
                r.bKe().h(str1, localBitmap1);
                r.bKe().h(str2, localBitmap2);
                com.tencent.threadpool.h.ahAA.bk(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(255376);
                    if ((ac.c.2.this.WsL.getTag() != null) && (ac.c.2.this.WsL.getTag().equals(ac.c.2.this.aeRj)) && (localBitmap1 != null) && (!localBitmap1.isRecycled())) {
                      ac.c.2.this.WsL.setImageBitmap(localBitmap1);
                    }
                    if ((ac.c.2.this.aeRl.getTag() != null) && (ac.c.2.this.aeRl.getTag().equals(ac.c.2.this.aeRm)) && (localBitmap2 != null) && (!localBitmap2.isRecycled()))
                    {
                      BitmapDrawable localBitmapDrawable = new BitmapDrawable(ac.c.2.this.XSz.aezO.getContext().getResources(), localBitmap2);
                      ac.c.2.this.aeRl.setBackground(localBitmapDrawable);
                    }
                    AppMethodBeat.o(255376);
                  }
                });
                AppMethodBeat.o(255310);
              }
            });
            localObject2 = localObject1;
            break;
          }
          paramc1.LOJ.setImageBitmap(BitmapFactory.decodeResource(parama.aezO.getMMResources(), R.g.foI));
          localObject2 = "";
          break;
          label1897:
          paramc1.RMV.setImageResource(R.k.icons_outlined_play2);
          paramc1.RMV.setContentDescription(MMApplicationContext.getString(R.l.sns_play_music));
          break label1119;
          ac.b.a((ac.b)paramc, (String)localObject2);
          break label1157;
        }
      }
    }
    
    public final c.a P(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(255778);
      super.create(paramView);
      this.clickArea = paramView.findViewById(R.h.fzv);
      this.aeRf = ((RelativeLayout)paramView.findViewById(R.h.fzw));
      this.userTV = ((TextView)paramView.findViewById(R.h.fAr));
      this.RfE = ((TextView)paramView.findViewById(R.h.chatting_music_singer_name));
      this.RMS = ((TextView)paramView.findViewById(R.h.chatting_music_song_name));
      this.RMT = ((TextView)paramView.findViewById(R.h.chatting_music_mv_info));
      this.RMV = ((WeImageView)paramView.findViewById(R.h.chatting_music_media_icon));
      this.LOJ = ((ImageView)paramView.findViewById(R.h.chatting_music_cover));
      ((RoundCornerRelativeLayout)paramView.findViewById(R.h.fzx)).setRadius(bd.fromDPToPix(paramView.getContext(), 4));
      this.aeRg = ((LinearLayout)paramView.findViewById(R.h.fzy));
      this.aeRh = ((MMRoundCornerImageView)paramView.findViewById(R.h.fzz));
      int i = bd.fromDPToPix(paramView.getContext(), 2);
      this.aeRh.setRadius(i);
      this.aeRi = ((TextView)paramView.findViewById(R.h.fzA));
      this.checkBox = ((CheckBox)paramView.findViewById(R.h.fxt));
      this.maskView = paramView.findViewById(R.h.fzn);
      this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.gbo));
      this.DmL = paramView.findViewById(R.h.arrow);
      if (!paramBoolean) {
        this.aeNG = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
      }
      this.RMS.setTextSize(1, 15.0F);
      this.RfE.setTextSize(1, 12.0F);
      AppMethodBeat.o(255778);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ac
 * JD-Core Version:    0.7.0.1
 */