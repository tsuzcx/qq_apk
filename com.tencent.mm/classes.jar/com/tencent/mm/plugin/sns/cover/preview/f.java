package com.tencent.mm.plugin.sns.cover.preview;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.cover.a.b;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.br;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/cover/preview/SnsWeComImageBackPreview;", "Lcom/tencent/mm/plugin/sns/cover/api/AbsSnsBackPreview;", "Lcom/tencent/mm/plugin/sns/model/DownloadManager$IOnDownloadListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "coverFoldImageView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getCoverFoldImageView", "()Landroid/widget/ImageView;", "coverFoldImageView$delegate", "Lkotlin/Lazy;", "coverInfo", "Lcom/tencent/mm/plugin/sns/cover/api/ISnsCoverInfo;", "thumbView", "Lcom/tencent/mm/plugin/sns/cover/preview/SnsCoverFadeImageView;", "getThumbView", "()Lcom/tencent/mm/plugin/sns/cover/preview/SnsCoverFadeImageView;", "thumbView$delegate", "downloadCover", "", "getLayoutId", "", "getType", "loadCover", "onDestroy", "onImageFinish", "snsId", "", "isOk", "", "onPause", "onPostClose", "onPostOpen", "onPreClose", "onPreOpen", "onResume", "onSetbg", "onSightFinish", "mediaId", "onThumbFinish", "Companion", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends com.tencent.mm.plugin.sns.cover.a.a
  implements c.b
{
  public static final f.a Qmj;
  private final j Gqu;
  private final j Qmb;
  private b Qmc;
  
  static
  {
    AppMethodBeat.i(307448);
    Qmj = new f.a((byte)0);
    AppMethodBeat.o(307448);
  }
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(307413);
    this.Gqu = k.cm((kotlin.g.a.a)new c(this));
    this.Qmb = k.cm((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(307413);
  }
  
  private void b(b paramb)
  {
    AppMethodBeat.i(307439);
    s.u(paramb, "coverInfo");
    Object localObject = al.getAccSnsPath();
    s.s(localObject, "getAccSnsPath()");
    com.tencent.mm.plugin.sns.storage.u localu = al.hgF().aZW(paramb.getUserName());
    s.s(localu, "getSnsExtStg().get(coverInfo.userName)");
    String str1 = localu.field_bgId;
    String str2 = localu.field_older_bgId;
    Log.i("MicroMsg.SnsWeComImageBackPreview", "downloadCover, userName:" + paramb.getUserName() + ", bgId:" + str1 + ", olderBgId:" + str2);
    String str5 = t.aXo(str1);
    s.s(str5, "getSnsBigNameWithoutEnc(newerId)");
    String str4 = s.X(paramb.getUserName(), "bg_");
    str2 = s.X(paramb.getUserName(), "tbg_");
    String str3 = as.mg((String)localObject, paramb.getUserName());
    s.s(str3, "getMediaFilePath(snsPath, coverInfo.userName)");
    y.bDX(str3);
    if (localu.dqH())
    {
      Log.d("MicroMsg.SnsWeComImageBackPreview", "bg is change");
      al.hgF().aZV(paramb.getUserName());
      if (y.ZC(s.X(as.mg((String)localObject, paramb.getUserName()), str4)))
      {
        y.deleteFile(s.X(as.mg((String)localObject, paramb.getUserName()), str2));
        y.bF(as.mg((String)localObject, paramb.getUserName()), str4, str2);
      }
      localu.hkN();
      al.hgF().c(localu);
    }
    if ((y.ZC(s.X(as.mg(al.getAccSnsPath(), str1), str5))) && (!y.ZC(s.X(as.mg((String)localObject, paramb.getUserName()), str4))))
    {
      y.O(s.X(as.mg((String)localObject, str1), str5), s.X(as.mg((String)localObject, paramb.getUserName()), str4), false);
      Log.d("MicroMsg.SnsWeComImageBackPreview", "nwer id Name update");
    }
    paramb = null;
    if (str1 != null)
    {
      al.hgy();
      localObject = g.a(s.X(str3, str4), localu.field_bgUrl, str1, true, br.adkd, localu.field_imBGaeskey, localu.field_imBGauthkey);
      Log.d("MicroMsg.SnsWeComImageBackPreview", "set a new bg");
      paramb = (b)localObject;
      if (localObject == null)
      {
        y.deleteFile(s.X(str3, str4));
        paramb = (b)localObject;
      }
    }
    localObject = paramb;
    if (paramb == null)
    {
      localObject = paramb;
      if (str1 != null)
      {
        al.hgy();
        localObject = g.a(s.X(str3, str2), localu.field_bgUrl, str1, false, br.adkd, localu.field_imBGaeskey, localu.field_imBGauthkey);
      }
    }
    getThumbView().setImageBitmapWithFade((Bitmap)localObject);
    AppMethodBeat.o(307439);
  }
  
  private final ImageView getCoverFoldImageView()
  {
    AppMethodBeat.i(307425);
    ImageView localImageView = (ImageView)this.Qmb.getValue();
    AppMethodBeat.o(307425);
    return localImageView;
  }
  
  private final SnsCoverFadeImageView getThumbView()
  {
    AppMethodBeat.i(307419);
    SnsCoverFadeImageView localSnsCoverFadeImageView = (SnsCoverFadeImageView)this.Gqu.getValue();
    AppMethodBeat.o(307419);
    return localSnsCoverFadeImageView;
  }
  
  public final void EE(String paramString) {}
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(307505);
    s.u(paramb, "coverInfo");
    al.hgw().b((c.b)this);
    al.hgw().a((c.b)this);
    this.Qmc = paramb;
    b(paramb);
    AppMethodBeat.o(307505);
  }
  
  public final void aXr()
  {
    AppMethodBeat.i(307499);
    b localb = this.Qmc;
    if (localb != null) {
      b(localb);
    }
    al.hgw().b((c.b)this);
    AppMethodBeat.o(307499);
  }
  
  public final void etL()
  {
    AppMethodBeat.i(307483);
    Log.i("MicroMsg.SnsWeComImageBackPreview", "[onPreOpen]");
    getCoverFoldImageView().setVisibility(4);
    AppMethodBeat.o(307483);
  }
  
  public final void etM()
  {
    AppMethodBeat.i(307478);
    Log.i("MicroMsg.SnsWeComImageBackPreview", "[onPreClose]");
    AppMethodBeat.o(307478);
  }
  
  public final void etO() {}
  
  public final int getLayoutId()
  {
    return b.g.sns_cover_image_preview;
  }
  
  public final int getType()
  {
    return 6;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(307469);
    al.hgw().b((c.b)this);
    AppMethodBeat.o(307469);
  }
  
  public final void onPause() {}
  
  public final void onPostClose()
  {
    AppMethodBeat.i(307488);
    Log.i("MicroMsg.SnsWeComImageBackPreview", "[onPostClose]");
    getCoverFoldImageView().setVisibility(0);
    AppMethodBeat.o(307488);
  }
  
  public final void onResume() {}
  
  public final void w(String paramString, boolean paramBoolean) {}
  
  public final void x(String paramString, boolean paramBoolean) {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ImageView>
  {
    b(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/sns/cover/preview/SnsCoverFadeImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.a<SnsCoverFadeImageView>
  {
    c(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.cover.preview.f
 * JD-Core Version:    0.7.0.1
 */