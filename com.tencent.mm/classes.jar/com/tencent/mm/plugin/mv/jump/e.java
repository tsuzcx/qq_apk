package com.tencent.mm.plugin.mv.jump;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.model.z;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.finder.cgi.az;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.findersdk.a.cq;
import com.tencent.mm.plugin.textstatus.a.k;
import com.tencent.mm.plugin.textstatus.a.o;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.textstatus.proto.l;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ayl;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.threadpool.i;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/jump/MusicStatusService;", "Lcom/tencent/mm/plugin/textstatus/api/IStatusThirdShareService;", "()V", "jumper", "Lcom/tencent/mm/plugin/mv/jump/MusicPlayerJumper;", "musicPlayerListener", "com/tencent/mm/plugin/mv/jump/MusicStatusService$musicPlayerListener$1", "Lcom/tencent/mm/plugin/mv/jump/MusicStatusService$musicPlayerListener$1;", "musicState", "", "createCustomParts", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "jumpType", "", "createPullDownView", "Lcom/tencent/mm/ui/widget/IPullDownView;", "sourceId", "container", "Landroid/widget/FrameLayout;", "jumpInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "pullDownParam", "Lcom/tencent/mm/plugin/textstatus/proto/PullDownParam;", "release", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements o
{
  final b LWE;
  int LWF;
  private final MusicStatusService.musicPlayerListener.1 LWG;
  
  public e()
  {
    AppMethodBeat.i(286012);
    this.LWE = new b();
    this.LWG = new MusicStatusService.musicPlayerListener.1(this, com.tencent.mm.app.f.hfK);
    this.LWG.alive();
    AppMethodBeat.o(286012);
  }
  
  public final com.tencent.mm.ui.widget.b a(String paramString, FrameLayout paramFrameLayout, TextStatusJumpInfo paramTextStatusJumpInfo, l paraml)
  {
    int i = 1;
    AppMethodBeat.i(286022);
    kotlin.g.b.s.u(paramFrameLayout, "container");
    kotlin.g.b.s.u(paraml, "pullDownParam");
    int j = paraml.ToO;
    if (j != 0)
    {
      if (j == 1) {}
      while (i != 0)
      {
        paramString = (com.tencent.mm.ui.widget.b)new d(paramString, paramFrameLayout, paramTextStatusJumpInfo, this.LWF);
        AppMethodBeat.o(286022);
        return paramString;
        if (j != 3) {
          i = 0;
        }
      }
      if (j == 2)
      {
        paramString = (com.tencent.mm.ui.widget.b)new a(paramString, paramFrameLayout, paramTextStatusJumpInfo, this.LWF);
        AppMethodBeat.o(286022);
        return paramString;
      }
    }
    AppMethodBeat.o(286022);
    return null;
  }
  
  public final k axF(final String paramString)
  {
    AppMethodBeat.i(286030);
    paramString = (k)new a(this, paramString);
    AppMethodBeat.o(286030);
    return paramString;
  }
  
  public final void release()
  {
    AppMethodBeat.i(286033);
    this.LWG.dead();
    AppMethodBeat.o(286033);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/jump/MusicStatusService$createCustomParts$1", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "finderUserName", "", "getFinderUserName", "()Ljava/lang/String;", "setFinderUserName", "(Ljava/lang/String;)V", "jumpInfos", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "getJumpInfos", "()Ljava/util/List;", "setJumpInfos", "(Ljava/util/List;)V", "musicShareObject", "Lcom/tencent/mm/protocal/protobuf/MusicShareObject;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "getSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "setSongInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;)V", "textStatusId", "getTextStatusId", "setTextStatusId", "doJumpAuthor", "", "context", "Landroid/content/Context;", "doJumpSource", "extParam", "Landroid/os/Bundle;", "getAuthorName", "getReportFeedId", "getSourceDesc", "isHasCustomPullDown", "isShowSourceWhenPullDown", "loadAvatar", "", "container", "Landroid/widget/FrameLayout;", "avatarUrl", "onAttach", "textStatusID", "onDetach", "setCustomAuthorView", "setCustomSourceView", "setCustomThumbView", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends k
  {
    private List<TextStatusJumpInfo> DHi;
    private String LWH;
    private boo LWI;
    private dtj oPb;
    private String zDJ;
    
    a(e parame, String paramString)
    {
      super();
    }
    
    private static final ah a(a parama, FrameLayout paramFrameLayout, b.a parama1)
    {
      AppMethodBeat.i(286034);
      kotlin.g.b.s.u(parama, "$this_run");
      kotlin.g.b.s.u(paramFrameLayout, "$container");
      Object localObject;
      if ((parama1.errType != 0) || (parama1.errCode != 0))
      {
        localObject = aw.Gjk;
        if (!aw.iv(parama1.errType, parama1.errCode)) {}
      }
      else
      {
        parama1 = ((ayl)parama1.ott).feedObject;
        if (parama1 != null)
        {
          localObject = FinderItem.Companion;
          parama1 = FinderItem.a.e(parama1, 1);
          localObject = com.tencent.mm.plugin.finder.storage.data.e.FMN;
          com.tencent.mm.plugin.finder.storage.data.e.a.s(parama1);
          parama.zDJ = parama1.getUserName();
          parama1 = parama1.getFeedObject().contact;
          if (parama1 != null) {
            break label135;
          }
        }
      }
      label135:
      for (parama1 = null;; parama1 = parama1.headUrl)
      {
        com.tencent.threadpool.h.ahAA.bk(new e.a..ExternalSyntheticLambda2(parama, paramFrameLayout, parama1));
        parama = ah.aiuX;
        AppMethodBeat.o(286034);
        return parama;
      }
    }
    
    private static void a(FrameLayout paramFrameLayout, String paramString)
    {
      AppMethodBeat.i(286007);
      ImageView localImageView = (ImageView)paramFrameLayout.findViewWithTag("Finder.TextStatusProvider");
      if (localImageView == null) {
        localImageView = new ImageView(paramFrameLayout.getContext());
      }
      for (;;)
      {
        paramFrameLayout.removeAllViews();
        paramFrameLayout.addView((View)localImageView);
        paramFrameLayout = com.tencent.mm.plugin.finder.loader.p.ExI;
        paramFrameLayout = com.tencent.mm.plugin.finder.loader.p.eCp();
        paramString = new com.tencent.mm.plugin.finder.loader.b(paramString);
        com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
        paramFrameLayout.a(paramString, localImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
        AppMethodBeat.o(286007);
        return;
      }
    }
    
    private static final void a(a parama, FrameLayout paramFrameLayout, String paramString)
    {
      AppMethodBeat.i(286027);
      kotlin.g.b.s.u(parama, "$this_run");
      kotlin.g.b.s.u(paramFrameLayout, "$container");
      a(paramFrameLayout, paramString);
      AppMethodBeat.o(286027);
    }
    
    private static final void b(ImageView paramImageView, String paramString1, Bitmap paramBitmap, String paramString2)
    {
      AppMethodBeat.i(286013);
      kotlin.g.b.s.u(paramImageView, "$img");
      if (paramBitmap == null)
      {
        AppMethodBeat.o(286013);
        return;
      }
      paramString1 = new com.tencent.mm.videocomposition.effect.a();
      paramString1.setInputBitmap(paramBitmap);
      paramString1.setOutputSize(paramImageView.getWidth(), paramImageView.getHeight());
      paramString1.HkF.GpO.jQk();
      paramString1.aW((kotlin.g.a.b)new e.a.a(paramImageView));
      AppMethodBeat.o(286013);
    }
    
    private static final void j(String paramString, ImageView paramImageView)
    {
      AppMethodBeat.i(286018);
      kotlin.g.b.s.u(paramImageView, "$img");
      r.bKd().a(paramString, new e.a..ExternalSyntheticLambda0(paramImageView));
      AppMethodBeat.o(286018);
    }
    
    public final boolean d(FrameLayout paramFrameLayout)
    {
      AppMethodBeat.i(286117);
      kotlin.g.b.s.u(paramFrameLayout, "container");
      Object localObject1 = this.LWI;
      Object localObject2;
      int i;
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject2 = (CharSequence)localObject1;
        if ((localObject2 != null) && (!n.bp((CharSequence)localObject2))) {
          break label138;
        }
        i = 1;
        label45:
        if (i == 0)
        {
          localObject2 = (ImageView)paramFrameLayout.findViewWithTag("Finder.TextStatusProvider");
          if (localObject2 != null) {
            break label143;
          }
          localObject2 = new ImageView(paramFrameLayout.getContext());
          ((ImageView)localObject2).setTag("Finder.TextStatusProvider");
          paramFrameLayout.removeAllViews();
          paramFrameLayout.addView((View)localObject2);
        }
      }
      label138:
      label143:
      for (paramFrameLayout = (FrameLayout)localObject2;; paramFrameLayout = (FrameLayout)localObject2)
      {
        paramFrameLayout.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramFrameLayout.post(new e.a..ExternalSyntheticLambda3((String)localObject1, paramFrameLayout));
        AppMethodBeat.o(286117);
        return true;
        localObject1 = ((boo)localObject1).ZWS;
        break;
        i = 0;
        break label45;
      }
    }
    
    public final boolean e(FrameLayout paramFrameLayout)
    {
      return false;
    }
    
    public final String etP()
    {
      AppMethodBeat.i(286072);
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject1 = this.LWI;
      Object localObject2;
      if (localObject1 == null)
      {
        localObject1 = "";
        localObject2 = localStringBuilder.append((String)localObject1).append('|');
        localObject1 = this.oPb;
        if (localObject1 != null) {
          break label84;
        }
      }
      label84:
      for (localObject1 = null;; localObject1 = ((dtj)localObject1).YqN)
      {
        localObject1 = localObject1;
        AppMethodBeat.o(286072);
        return localObject1;
        localObject2 = ((boo)localObject1).mLQ;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        localObject1 = "";
        break;
      }
    }
    
    public final boolean etQ()
    {
      return true;
    }
    
    public final boolean f(FrameLayout paramFrameLayout)
    {
      AppMethodBeat.i(286137);
      kotlin.g.b.s.u(paramFrameLayout, "container");
      Object localObject1 = this.oPb;
      if (localObject1 != null)
      {
        long l = com.tencent.mm.ae.d.FK(((dtj)localObject1).YqN);
        String str = ((dtj)localObject1).YqO;
        localObject1 = com.tencent.mm.plugin.finder.storage.data.e.FMN;
        Object localObject2 = com.tencent.mm.plugin.finder.storage.data.e.a.jn(l);
        if (localObject2 == null)
        {
          localObject1 = null;
          if (localObject1 == null)
          {
            localObject1 = (a)this;
            localObject2 = z.bAW();
            kotlin.g.b.s.s(localObject2, "getMyFinderUsername()");
            new az(l, str, 43, 1, (String)localObject2, true, null, null, 0L, null, false, false, null, null, 0, null, 57280).bFJ().h(new e.a..ExternalSyntheticLambda1((a)localObject1, paramFrameLayout));
          }
          AppMethodBeat.o(286137);
          return true;
        }
        localObject1 = ((FinderItem)localObject2).getFeedObject().contact;
        if (localObject1 == null) {}
        for (localObject1 = null;; localObject1 = ((FinderContact)localObject1).headUrl)
        {
          this.zDJ = ((FinderItem)localObject2).getUserName();
          a(paramFrameLayout, (String)localObject1);
          localObject1 = ah.aiuX;
          break;
        }
      }
      AppMethodBeat.o(286137);
      return false;
    }
    
    public final boolean g(Context paramContext, Bundle paramBundle)
    {
      AppMethodBeat.i(286098);
      kotlin.g.b.s.u(paramContext, "context");
      boolean bool = b.d(paramContext, this.LWH, this.DHi);
      AppMethodBeat.o(286098);
      return bool;
    }
    
    public final boolean gz(Context paramContext)
    {
      AppMethodBeat.i(286107);
      kotlin.g.b.s.u(paramContext, "context");
      Object localObject = (CharSequence)this.zDJ;
      int i;
      if ((localObject == null) || (n.bp((CharSequence)localObject)))
      {
        i = 1;
        if (i != 0) {
          break label153;
        }
        localObject = new Intent();
        boolean bool = kotlin.g.b.s.p(this.zDJ, z.bAW());
        ((Intent)localObject).putExtra("finder_username", this.zDJ);
        if (!bool) {
          break label111;
        }
        ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterFinderSelfProfile(paramContext, (Intent)localObject, 20, 2);
      }
      for (;;)
      {
        AppMethodBeat.o(286107);
        return true;
        i = 0;
        break;
        label111:
        ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(20, 2, 32, (Intent)localObject);
        ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterFinderProfileUI(paramContext, (Intent)localObject);
      }
      label153:
      AppMethodBeat.o(286107);
      return false;
    }
    
    public final void onDetach() {}
    
    public final void y(String paramString, List<TextStatusJumpInfo> paramList)
    {
      AppMethodBeat.i(286065);
      this.DHi = paramList;
      this.LWH = paramString;
      this.zDJ = null;
      if (paramList == null) {
        paramString = null;
      }
      for (;;)
      {
        try
        {
          paramString = XmlParser.parseXml(paramString, "MusicVideoStatusOpenParams", null);
          if (paramString == null) {
            continue;
          }
          paramList = new boo();
          Object localObject = kotlin.g.b.s.X(".", "MusicVideoStatusOpenParams");
          kotlin.g.b.s.s(paramString, "values");
          c.a(paramList, (String)localObject, paramString);
          localObject = ah.aiuX;
          this.LWI = paramList;
          this.oPb = cq.J(kotlin.g.b.s.X(".", "MusicVideoStatusOpenParams"), paramString);
          return;
        }
        finally
        {
          AppMethodBeat.o(286065);
        }
        paramString = (TextStatusJumpInfo)kotlin.a.p.oK(paramList);
        if (paramString == null) {
          paramString = null;
        } else {
          paramString = paramString.busiBuf;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.jump.e
 * JD-Core Version:    0.7.0.1
 */