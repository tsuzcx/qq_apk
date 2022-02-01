package com.tencent.mm.ui.chatting.viewitems;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.renderscript.RSInvalidStateException;
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
import com.tencent.mm.aj.k.b;
import com.tencent.mm.ay.q;
import com.tencent.mm.f.a.em;
import com.tencent.mm.f.a.em.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.findersdk.a.al;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.protocal.protobuf.dbs;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.blur.f;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ac;
import com.tencent.mm.ui.chatting.d.b.ad;
import com.tencent.mm.ui.chatting.s;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.xweb.util.d;

public final class ae
{
  private static final Bitmap a(Context paramContext, Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(279380);
    long l = Util.currentTicks();
    int i = paramInt1;
    if (paramInt1 == 0) {}
    for (;;)
    {
      Object localObject;
      try
      {
        i = com.tencent.mm.ci.a.fromDPToPix(paramContext, 88);
        paramInt1 = paramInt2;
        if (paramInt2 == 0) {
          paramInt1 = com.tencent.mm.ci.a.fromDPToPix(paramContext, 280);
        }
        paramInt2 = paramBitmap.getHeight();
        int j = paramBitmap.getWidth();
        paramInt1 = (int)(paramInt2 * 1.0F * (i * 1.0F / paramInt1));
        if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
          break label312;
        }
        paramContext = BitmapUtil.createColorBitmap(paramContext.getResources().getColor(R.e.chat_item_default_mucic_mask_color), j, paramInt1);
        localObject = new Matrix();
        float f = i * 1.0F / paramInt1 * 0.25F * 0.25F;
        ((Matrix)localObject).postScale(f, f);
        paramContext = Bitmap.createBitmap(paramContext, 0, (paramInt2 - paramInt1) / 2, j, paramInt1, (Matrix)localObject, false);
        localObject = new f(MMApplicationContext.getContext());
      }
      catch (Exception paramContext)
      {
        Log.printErrStackTrace("MicroMsg.ChattingItemAppMsgMusic", paramContext, "getBgContentBm", new Object[0]);
        AppMethodBeat.o(279380);
        return null;
      }
      try
      {
        paramContext = ((f)localObject).b(paramContext, 30.0F);
      }
      catch (Throwable paramContext)
      {
        paramContext = paramContext;
        Log.e("MicroMsg.ChattingItemAppMsgMusic", "setBlurBitmap error:${err.message}");
        paramContext = BitmapUtil.fastblur(paramBitmap, 30);
        try
        {
          ((f)localObject).destroy();
        }
        catch (RSInvalidStateException paramBitmap)
        {
          Log.w("MicroMsg.ChattingItemAppMsgMusic", "RSInvalidStateException ${ex.message}");
        }
        continue;
      }
      finally {}
      try
      {
        ((f)localObject).destroy();
        paramBitmap = com.tencent.mm.plugin.comm.b.ubp;
        paramContext = com.tencent.mm.plugin.comm.b.a(ar.isDarkMode(), paramContext);
        Log.i("MicroMsg.ChattingItemAppMsgMusic", String.format("getBgContentBm,from:%b, cost:%d", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(Util.ticksToNow(l)) }));
        AppMethodBeat.o(279380);
        return paramContext;
      }
      catch (RSInvalidStateException paramBitmap)
      {
        Log.w("MicroMsg.ChattingItemAppMsgMusic", "RSInvalidStateException ${ex.message}");
        continue;
      }
      try
      {
        ((f)localObject).destroy();
        AppMethodBeat.o(279380);
        throw paramContext;
      }
      catch (RSInvalidStateException paramBitmap)
      {
        for (;;)
        {
          Log.w("MicroMsg.ChattingItemAppMsgMusic", "RSInvalidStateException ${ex.message}");
        }
      }
      label312:
      paramContext = paramBitmap;
    }
  }
  
  public static boolean a(k.b paramb, Context paramContext, String paramString, ca paramca)
  {
    AppMethodBeat.i(279377);
    Log.i("MicroMsg.ChattingItemAppMsgMusic", "handleMusicVideoClick, content:%s", new Object[] { paramb.lpb });
    if (!((ak)com.tencent.mm.kernel.h.ag(ak.class)).canEnterMvAndShowToast())
    {
      AppMethodBeat.o(279377);
      return false;
    }
    Log.i("MicroMsg.ChattingItemAppMsgMusic", "handleMusicVideoClick, doPlayMusic, musicCoverPath:%s", new Object[] { paramString });
    Intent localIntent = new Intent();
    localIntent.putExtra("key_scene", 6);
    String str = paramString;
    com.tencent.mm.pluginsdk.ui.tools.b localb;
    if (paramb != null)
    {
      localb = (com.tencent.mm.pluginsdk.ui.tools.b)paramb.ar(com.tencent.mm.pluginsdk.ui.tools.b.class);
      str = paramString;
      if (localb != null)
      {
        localIntent.putExtra("key_mv_song_name", paramb.title);
        localIntent.putExtra("key_mv_song_lyric", localb.songLyric);
        localIntent.putExtra("key_mv_album_cover_url", localb.songAlbumUrl);
        localIntent.putExtra("key_mv_feed_id", localb.Ruu);
        localIntent.putExtra("key_mv_nonce_id", localb.Ruv);
        localIntent.putExtra("key_mv_cover_url", localb.Ruw);
        localIntent.putExtra("key_mv_poster", localb.Rux);
        if (Util.isNullOrNil(localb.Ruy)) {
          break label465;
        }
      }
    }
    label465:
    for (str = localb.Ruy;; str = paramb.description)
    {
      localIntent.putExtra("key_mv_singer_name", str);
      localIntent.putExtra("key_mv_album_name", localb.Ruz);
      localIntent.putExtra("key_mv_music_genre", localb.RuA);
      localIntent.putExtra("key_mv_issue_date", localb.RuB);
      localIntent.putExtra("key_mv_music_duration", localb.FSG);
      localIntent.putExtra("key_mv_identification", localb.RuC);
      localIntent.putExtra("key_mv_extra_info", localb.RuD);
      localIntent.putExtra("key_mv_thumb_path", paramString);
      str = paramString;
      if (Util.isNullOrNil(paramString))
      {
        str = paramString;
        if (!Util.isNullOrNil(localb.Ruw)) {
          str = com.tencent.mm.plugin.music.h.b.cc(d.getMessageDigest(localb.Ruw.getBytes()) + "_cover", false);
        }
      }
      localIntent.setFlags(268435456);
      s.a(paramca, paramb, str);
      paramb = com.tencent.mm.plugin.secdata.ui.a.JbV;
      paramb = (dbs)a.a.a(paramContext, "MusicMvMainUI", 7, dbs.class);
      paramb.scene = 2;
      paramString = com.tencent.mm.plugin.comm.a.ubo;
      paramb.wmL = com.tencent.mm.plugin.comm.a.cPn();
      paramb.TIZ = 84;
      paramb.TJa = paramca.field_talker;
      com.tencent.mm.by.c.b(paramContext, "mv", ".ui.MusicMvMainUI", localIntent);
      AppMethodBeat.o(279377);
      return true;
    }
  }
  
  protected static boolean a(com.tencent.mm.ui.chatting.e.a parama, o paramo, View paramView, ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(279374);
    int i = ((by)paramView.getTag()).position;
    if (paramca.field_content == null)
    {
      AppMethodBeat.o(279374);
      return true;
    }
    k.b localb = k.b.OQ(bq.b(parama.hRi(), paramca.field_content, paramca.field_isSend));
    if (localb == null)
    {
      AppMethodBeat.o(279374);
      return true;
    }
    if ((3 != localb.type) && (76 != localb.type))
    {
      Log.e("MicroMsg.ChattingItemAppMsgMusic", "onCreateContextMenu(from), not music type, but enter here.");
      AppMethodBeat.o(279374);
      return true;
    }
    Object localObject = com.tencent.mm.pluginsdk.model.app.h.o(localb.appId, false, false);
    if ((com.tencent.mm.pluginsdk.model.app.h.l((com.tencent.mm.pluginsdk.model.app.g)localObject)) && (!com.tencent.mm.ui.chatting.k.bF(paramca)) && (!com.tencent.mm.ui.chatting.k.bG(paramca)) && (paramca.field_status != 1)) {
      paramo.a(i, 111, parama.WQv.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
    }
    if ((!paramBoolean) && ((paramca.field_status == 2) || (paramca.ill == 1)) && (c.b(paramca, parama)) && (c.bzE(paramca.field_talker)) && (!as.OS(parama.getTalkerUserName()))) {
      paramo.a(i, 123, paramView.getContext().getString(R.l.ewa), R.k.icons_filled_previous);
    }
    if ((com.tencent.mm.ao.g.bjh()) && (!parama.hRj())) {
      paramo.add(i, 114, 0, paramView.getContext().getString(R.l.evJ));
    }
    if ((com.tencent.mm.by.c.blP("favorite")) && ((localObject == null) || (!((com.tencent.mm.pluginsdk.model.app.g)localObject).Qv()))) {
      paramo.a(i, 116, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
    }
    localObject = new em();
    ((em)localObject).fAp.msgId = paramca.field_msgId;
    EventCenter.instance.publish((IEvent)localObject);
    if ((((em)localObject).fAq.fzO) || (e.b.a(parama.WQv.getContext(), localb))) {
      paramo.a(i, 129, paramView.getContext().getString(R.l.evU), R.k.icons_filled_open);
    }
    if (!parama.hRj()) {
      paramo.a(i, 100, parama.WQv.getMMResources().getString(R.l.evO), R.k.icons_filled_delete);
    }
    if ((BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())) {
      paramo.a(i, 144, paramView.getContext().getString(R.l.menu_show_app_msg_content), R.k.fix_tools_entry);
    }
    AppMethodBeat.o(279374);
    return true;
  }
  
  protected static boolean a(final c paramc, MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(279375);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(279375);
      return false;
    case 100: 
      AppMethodBeat.o(279375);
      return false;
    case 111: 
      if (!ac.bV(paramca))
      {
        com.tencent.mm.ui.base.h.a(parama.WQv.getContext(), parama.WQv.getContext().getString(R.l.eEx), "", parama.WQv.getContext().getString(R.l.welcome_i_know), null);
        AppMethodBeat.o(279375);
        return false;
      }
      e.b.a(parama, paramca, paramc.a(parama, paramca), 2000, new com.tencent.mm.by.c.a()
      {
        public final void onActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(289801);
          if ((paramAnonymousInt1 == 2000) && (paramAnonymousInt2 == -1))
          {
            paramAnonymousIntent = Util.listToString(paramAnonymousIntent.getStringArrayListExtra("SendMsgUsernames"), ";");
            al localal = al.Bvs;
            al.a(this.lrk, paramc.Wwx, true, paramAnonymousIntent);
          }
          AppMethodBeat.o(289801);
        }
      });
      AppMethodBeat.o(279375);
      return false;
    case 114: 
      com.tencent.mm.ui.chatting.an.a(paramca, bq.b(parama.hRi(), paramca.field_content, paramca.field_isSend), parama.WQv.getContext());
      AppMethodBeat.o(279375);
      return false;
    }
    paramc = new Intent();
    paramc.putExtra("Chat_Msg_Id", paramca.field_msgId);
    com.tencent.mm.by.c.b(parama.WQv.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramc);
    AppMethodBeat.o(279375);
    return false;
  }
  
  public static final class a
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a WBq;
    private String lVZ = "";
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(280511);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new aq(paramLayoutInflater, R.i.edd);
        ((View)localObject).setTag(new ae.c().J((View)localObject, true));
      }
      AppMethodBeat.o(280511);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(280512);
      this.WBq = parama1;
      ae.c.a(this, (ae.c)parama, paramca, true, paramInt, parama1);
      AppMethodBeat.o(280512);
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(280516);
      boolean bool = ae.a(this, paramMenuItem, parama, paramca);
      AppMethodBeat.o(280516);
      return bool;
    }
    
    public final boolean a(o paramo, View paramView, ca paramca)
    {
      AppMethodBeat.i(280514);
      boolean bool = ae.a(this.WBq, paramo, paramView, paramca, true);
      AppMethodBeat.o(280514);
      return bool;
    }
    
    public final boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 1040187441);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(280518);
      boolean bool = ae.a(this, parama, paramca);
      AppMethodBeat.o(280518);
      return bool;
    }
    
    public final boolean hTD()
    {
      return false;
    }
  }
  
  public static final class b
    extends c
    implements t.n
  {
    private com.tencent.mm.ui.chatting.e.a WBq;
    private String lVZ = "";
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(245755);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new aq(paramLayoutInflater, R.i.eed);
        ((View)localObject).setTag(new ae.c().J((View)localObject, false));
      }
      AppMethodBeat.o(245755);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(245757);
      this.WBq = parama1;
      ae.c.a(this, (ae.c)parama, paramca, false, paramInt, parama1);
      parama = (ae.c)parama;
      if (hTG())
      {
        if ((paramca.field_status != 2) || (!b((com.tencent.mm.ui.chatting.d.b.k)parama1.bC(com.tencent.mm.ui.chatting.d.b.k.class), paramca.field_msgId))) {
          break label102;
        }
        if (parama.XdI != null) {
          parama.XdI.setVisibility(0);
        }
      }
      for (;;)
      {
        a(paramInt, parama, paramca, parama1.getSelfUserName(), parama1.hRi(), parama1, this);
        AppMethodBeat.o(245757);
        return;
        label102:
        if (parama.XdI != null) {
          parama.XdI.setVisibility(8);
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(245761);
      boolean bool = ae.a(this, paramMenuItem, parama, paramca);
      AppMethodBeat.o(245761);
      return bool;
    }
    
    public final boolean a(o paramo, View paramView, ca paramca)
    {
      AppMethodBeat.i(245760);
      boolean bool = ae.a(this.WBq, paramo, paramView, paramca, false);
      AppMethodBeat.o(245760);
      return bool;
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(245764);
      paramca.unsetOmittedFailResend();
      bh.beI();
      com.tencent.mm.model.c.bbO().a(paramca.field_msgId, paramca);
      ((ad)parama.bC(ad.class)).co(paramca);
      AppMethodBeat.o(245764);
    }
    
    public final boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 1040187441);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(245762);
      boolean bool = ae.a(this, parama, paramca);
      AppMethodBeat.o(245762);
      return bool;
    }
    
    public final boolean hTD()
    {
      return true;
    }
  }
  
  static final class c
    extends c.a
  {
    protected ImageView FTI;
    protected TextView KGe;
    protected TextView Lnp;
    protected TextView Lnq;
    protected WeImageView Lns;
    protected ImageView XdI;
    protected RelativeLayout Xhb;
    protected LinearLayout Xhc;
    protected MMRoundCornerImageView Xhd;
    protected TextView Xhe;
    
    @SuppressLint({"ResourceType"})
    public static void a(c paramc, c paramc1, ca paramca, final boolean paramBoolean, int paramInt, final com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(205420);
      if (paramc1 == null)
      {
        AppMethodBeat.o(205420);
        return;
      }
      Object localObject2 = paramca.field_content;
      Object localObject1 = localObject2;
      if (parama.hRi())
      {
        int i = paramca.field_content.indexOf(':');
        localObject1 = localObject2;
        if (i != -1) {
          localObject1 = paramca.field_content.substring(i + 1);
        }
      }
      if (localObject1 != null) {}
      for (k.b localb = k.b.aG((String)localObject1, paramca.field_reserved);; localb = null)
      {
        paramc1.Lnp.setMaxLines(2);
        paramc1.KGe.setMaxLines(1);
        paramc1.Lnq.setMaxLines(1);
        paramc1.KGe.setText("");
        paramc1.FTI.setImageDrawable(parama.WQv.getContext().getResources().getDrawable(R.g.music_mv_cover_empty_lightmode));
        if (ar.isDarkMode()) {
          paramc1.FTI.setImageDrawable(parama.WQv.getContext().getResources().getDrawable(R.g.music_mv_cover_empty_darkmode));
        }
        if (localb == null)
        {
          Log.e("MicroMsg.MusicItemHolder", "null == content");
          AppMethodBeat.o(205420);
          return;
        }
        com.tencent.mm.pluginsdk.ui.tools.b localb1;
        label273:
        label342:
        final String str1;
        label391:
        label652:
        final String str2;
        label702:
        Object localObject3;
        Object localObject4;
        if (paramBoolean)
        {
          paramc1.Xhb.setBackgroundResource(R.g.chatfrom_bg_app);
          if ((3 == localb.type) || (76 == localb.type))
          {
            localb1 = (com.tencent.mm.pluginsdk.ui.tools.b)localb.ar(com.tencent.mm.pluginsdk.ui.tools.b.class);
            paramc1.Lnp.setText(localb.getTitle());
            if ((localb1 == null) || (Util.isNullOrNil(localb1.Ruy))) {
              break label1284;
            }
            paramc1.KGe.setText(localb1.Ruy);
            paramc1.Lnp.setTextColor(parama.WQv.getContext().getResources().getColor(R.e.FG_0));
            paramc1.KGe.setTextColor(parama.WQv.getContext().getResources().getColor(R.e.half_alpha_black));
            if (Util.isNullOrNil(paramc1.KGe.getText())) {
              break label1299;
            }
            paramc1.KGe.setVisibility(0);
            localObject2 = com.tencent.mm.pluginsdk.model.app.h.hn(localb.appId, localb.appVersion);
            if ((localObject2 != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName.trim().length() > 0)) {
              break label1320;
            }
            localObject1 = localb.appName;
            if ((localb.appId != null) && (localb.appId.length() > 0) && (c.gZ((String)localObject1)))
            {
              localObject1 = com.tencent.mm.pluginsdk.model.app.h.a(parama.WQv.getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject2, (String)localObject1);
              paramc1.Xhe.setText((CharSequence)localObject1);
              paramc1.Xhe.setCompoundDrawables(null, null, null, null);
              c.a(parama, paramc1.Xhe, localb.appId);
              c.a(parama, paramc1.Xhd, localb.appId);
              paramc1.Xhc.setVisibility(0);
            }
            paramc1.Xhc.setBackgroundResource(R.g.dna);
            localObject1 = "";
            if (localb1 != null)
            {
              localObject1 = localb1.Ruw;
              localObject2 = localb1.Rux;
              if (Util.isNullOrNil((String)localObject2)) {
                break label1330;
              }
              paramc1.Lnp.setMaxLines(1);
              ((ViewGroup.MarginLayoutParams)paramc1.Lnp.getLayoutParams()).topMargin = com.tencent.mm.ci.a.fromDPToPix(parama.WQv.getContext(), 8);
              ((ViewGroup.MarginLayoutParams)paramc1.KGe.getLayoutParams()).topMargin = com.tencent.mm.ci.a.fromDPToPix(parama.WQv.getContext(), 4);
              paramc1.Xhb.findViewById(R.h.padding_view).setVisibility(0);
              paramc1.Lnq.setText((String)localObject2 + parama.WQv.getContext().getString(R.l.music_mv_info_share_suffix));
              paramc1.Lnq.setVisibility(0);
            }
            if (Util.isNullOrNil((String)localObject1)) {
              break label1425;
            }
            str1 = d.getMessageDigest(((String)localObject1).getBytes());
            str2 = str1 + "_cover";
            if (!paramBoolean) {
              break label1406;
            }
            localObject2 = "from";
            localObject3 = String.format("%s_bg_%s", new Object[] { str1, localObject2 });
            localObject2 = q.bml().Wo(str2);
            localObject4 = q.bml().Wo((String)localObject3);
            paramc1.FTI.setTag(str2);
            Log.i("MicroMsg.MusicItemHolder", "updateTag %s %s %s %s %s", new Object[] { Integer.valueOf(paramc1.FTI.hashCode()), paramc1.FTI.getTag(), str2, Long.valueOf(paramca.field_msgId), localObject1 });
            paramc1.Xhb.setTag(localObject3);
            if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled())) {
              paramc1.FTI.setImageBitmap((Bitmap)localObject2);
            }
            if ((localObject4 == null) || (((Bitmap)localObject4).isRecycled())) {
              break label1414;
            }
            BitmapDrawable localBitmapDrawable = new BitmapDrawable(parama.WQv.getContext().getResources(), (Bitmap)localObject4);
            paramc1.Xhb.setBackground(localBitmapDrawable);
          }
        }
        for (;;)
        {
          str1 = com.tencent.mm.plugin.music.h.b.cc(str1, false);
          if (localObject2 != null)
          {
            localObject2 = str1;
            if (localObject4 != null) {}
          }
          else
          {
            localObject2 = new com.tencent.mm.ay.a.a.c.a();
            ((com.tencent.mm.ay.a.a.c.a)localObject2).lRD = true;
            ((com.tencent.mm.ay.a.a.c.a)localObject2).lRB = true;
            ((com.tencent.mm.ay.a.a.c.a)localObject2).fullPath = str1;
            ((com.tencent.mm.ay.a.a.c.a)localObject2).lSd = new Object[] { paramc1.FTI, str2, paramc1.Xhb, localObject3, str1 };
            q.bml().a((String)localObject1, ((com.tencent.mm.ay.a.a.c.a)localObject2).bmL(), new ae.c.1(parama, paramBoolean));
            localObject2 = str1;
          }
          if (!(paramca.field_msgId + "_msg").equals(paramc1.playingMsgId)) {
            break label1776;
          }
          paramc1.Lns.setImageResource(R.k.icons_outlined_pause2);
          label1041:
          paramc1.Lns.setIconColor(parama.WQv.getContext().getResources().getColor(R.e.black_color));
          if (!paramBoolean) {
            break label1789;
          }
          ae.a.a((ae.a)paramc, (String)localObject2);
          label1079:
          localObject1 = new e.g();
          ((e.g)localObject1).msgId = paramca.field_msgId;
          ((e.g)localObject1).xml = paramca.field_content;
          ((e.g)localObject1).fKH = paramca.field_imgPath;
          ((e.g)localObject1).lVY = com.tencent.mm.plugin.findersdk.a.an.a(localb, localb1);
          if (((e.g)localObject1).lVY != null) {
            ((e.g)localObject1).lVY.lVZ = ((String)localObject2);
          }
          ((e.g)localObject1).lnm = 1;
          ((e.g)localObject1).TJa = paramca.field_talker;
          paramc1.Lns.setTag(localObject1);
          paramc1.Lns.setOnClickListener(((com.tencent.mm.ui.chatting.d.b.k)parama.bC(com.tencent.mm.ui.chatting.d.b.k.class)).hNP());
          paramc1.clickArea.setTag(new by(paramca, parama.hRi(), paramInt, null, '\000'));
          paramc1.clickArea.setOnClickListener(paramc.d(parama));
          paramc1.clickArea.setOnLongClickListener(paramc.c(parama));
          paramc1.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama.bC(com.tencent.mm.ui.chatting.d.b.k.class)).hNO());
          AppMethodBeat.o(205420);
          return;
          paramc1.Xhb.setBackgroundResource(R.g.chatto_bg_app);
          break;
          label1284:
          paramc1.KGe.setText(localb.getDescription());
          break label273;
          label1299:
          paramc1.KGe.setText("");
          paramc1.KGe.setVisibility(8);
          break label342;
          label1320:
          localObject1 = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName;
          break label391;
          label1330:
          ((ViewGroup.MarginLayoutParams)paramc1.Lnp.getLayoutParams()).topMargin = 0;
          ((ViewGroup.MarginLayoutParams)paramc1.KGe.getLayoutParams()).topMargin = com.tencent.mm.ci.a.fromDPToPix(parama.WQv.getContext(), 6);
          paramc1.Xhb.findViewById(R.h.padding_view).setVisibility(8);
          paramc1.Lnq.setText("");
          paramc1.Lnq.setVisibility(8);
          break label652;
          label1406:
          localObject2 = "to";
          break label702;
          label1414:
          paramc1.Xhb.setBackground(null);
        }
        label1425:
        if (!localb.bbv())
        {
          bh.beI();
          if (com.tencent.mm.model.c.isSDCardAvailable()) {
            if (e.b.bzI(paramca.field_imgPath)) {
              break label1802;
            }
          }
        }
        label1802:
        for (localObject1 = q.bmh().d(paramca.field_imgPath, false, true);; localObject1 = "")
        {
          localObject2 = localObject1;
          if (Util.isNullOrNil((String)localObject1)) {
            break;
          }
          str2 = d.getMessageDigest(((String)localObject1).getBytes());
          str1 = str2 + "_cover";
          if (paramBoolean) {}
          for (localObject2 = "from";; localObject2 = "to")
          {
            str2 = String.format("%s_bg_%s", new Object[] { str2, localObject2 });
            paramc1.FTI.setTag(str1);
            paramc1.Xhb.setTag(str2);
            localObject2 = q.bml().Wo(str1);
            localObject3 = q.bml().Wo(str2);
            if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
            {
              Log.i("MicroMsg.MusicItemHolder", "coverBm (local) is valid, use cache, key:".concat(String.valueOf(str1)));
              paramc1.FTI.setImageBitmap((Bitmap)localObject2);
            }
            if ((localObject3 != null) && (!((Bitmap)localObject3).isRecycled()))
            {
              Log.i("MicroMsg.MusicItemHolder", "bgBm (local) is valid, use bg cache, key:".concat(String.valueOf(str2)));
              localObject4 = new BitmapDrawable(parama.WQv.getContext().getResources(), (Bitmap)localObject3);
              paramc1.Xhb.setBackground((Drawable)localObject4);
            }
            if (localObject2 != null)
            {
              localObject2 = localObject1;
              if (localObject3 != null) {
                break;
              }
            }
            localObject2 = paramc1.FTI;
            localObject3 = paramc1.Xhb;
            com.tencent.e.h.ZvG.be(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(278225);
                final Bitmap localBitmap1 = q.bmh().a(this.lrk.field_imgPath, com.tencent.mm.ci.a.getDensity(parama.WQv.getContext()), false);
                final Bitmap localBitmap2 = ae.b(parama.WQv.getContext(), localBitmap1, this.Xhh.getHeight(), this.Xhh.getWidth(), paramBoolean);
                q.bml().h(str1, localBitmap1);
                q.bml().h(str2, localBitmap2);
                com.tencent.e.h.ZvG.bc(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(286133);
                    if ((ae.c.2.this.PCg.getTag() != null) && (ae.c.2.this.PCg.getTag().equals(ae.c.2.this.Xhf)) && (localBitmap1 != null) && (!localBitmap1.isRecycled())) {
                      ae.c.2.this.PCg.setImageBitmap(localBitmap1);
                    }
                    if ((ae.c.2.this.Xhh.getTag() != null) && (ae.c.2.this.Xhh.getTag().equals(ae.c.2.this.Xhi)) && (localBitmap2 != null) && (!localBitmap2.isRecycled()))
                    {
                      BitmapDrawable localBitmapDrawable = new BitmapDrawable(ae.c.2.this.QWD.WQv.getContext().getResources(), localBitmap2);
                      ae.c.2.this.Xhh.setBackground(localBitmapDrawable);
                    }
                    AppMethodBeat.o(286133);
                  }
                });
                AppMethodBeat.o(278225);
              }
            });
            localObject2 = localObject1;
            break;
          }
          paramc1.FTI.setImageBitmap(BitmapFactory.decodeResource(parama.WQv.getMMResources(), R.g.dok));
          localObject2 = "";
          break;
          label1776:
          paramc1.Lns.setImageResource(R.k.icons_outlined_play2);
          break label1041;
          label1789:
          ae.b.a((ae.b)paramc, (String)localObject2);
          break label1079;
        }
      }
    }
    
    public final c.a J(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(205416);
      super.create(paramView);
      this.clickArea = paramView.findViewById(R.h.dyK);
      this.Xhb = ((RelativeLayout)paramView.findViewById(R.h.dyL));
      this.userTV = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
      this.KGe = ((TextView)paramView.findViewById(R.h.chatting_music_singer_name));
      this.Lnp = ((TextView)paramView.findViewById(R.h.chatting_music_song_name));
      this.Lnq = ((TextView)paramView.findViewById(R.h.chatting_music_mv_info));
      this.Lns = ((WeImageView)paramView.findViewById(R.h.chatting_music_media_icon));
      this.FTI = ((ImageView)paramView.findViewById(R.h.chatting_music_cover));
      ((RoundCornerRelativeLayout)paramView.findViewById(R.h.dyM)).setRadius(aw.fromDPToPix(paramView.getContext(), 4));
      this.Xhc = ((LinearLayout)paramView.findViewById(R.h.dyN));
      this.Xhd = ((MMRoundCornerImageView)paramView.findViewById(R.h.dyO));
      int i = aw.fromDPToPix(paramView.getContext(), 2);
      this.Xhd.setRadius(i);
      this.Xhe = ((TextView)paramView.findViewById(R.h.dyP));
      this.checkBox = ((CheckBox)paramView.findViewById(R.h.dwZ));
      this.maskView = paramView.findViewById(R.h.dyD);
      this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.dYz));
      if (!paramBoolean) {
        this.XdI = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
      }
      this.Lnp.setTextSize(1, 15.0F);
      this.KGe.setTextSize(1, 12.0F);
      AppMethodBeat.o(205416);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ae
 * JD-Core Version:    0.7.0.1
 */