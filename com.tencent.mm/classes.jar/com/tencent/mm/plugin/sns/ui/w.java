package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.plugin.sns.model.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ao;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import java.util.concurrent.ExecutorService;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/sns/ui/FinderPicWidget;", "Lcom/tencent/mm/plugin/sns/ui/PicWidget;", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "finderShareObject", "Lcom/tencent/mm/modelsns/SnsFinderShareLive;", "mediaPath", "", "handlerOnCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initView", "Landroid/view/View;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onPrepareCommitPack", "packHelper", "Lcom/tencent/mm/plugin/sns/model/UploadPackHelper;", "ThumbLoader", "plugin-sns_release"})
public final class w
  extends as
{
  private d KDd;
  String mediaPath;
  
  public w(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(270740);
    this.mediaPath = "";
    AppMethodBeat.o(270740);
  }
  
  protected final void a(be parambe)
  {
    AppMethodBeat.i(270739);
    if ((this.KDd != null) && (parambe != null)) {
      parambe.a(this.KDd);
    }
    super.a(parambe);
    AppMethodBeat.o(270739);
  }
  
  public final void ay(Bundle paramBundle)
  {
    AppMethodBeat.i(270737);
    super.ay(paramBundle);
    paramBundle = this.iXq;
    p.j(paramBundle, "context");
    Object localObject = paramBundle.getIntent().getStringExtra("sns_kemdia_path");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    this.mediaPath = paramBundle;
    paramBundle = this.iXq;
    p.j(paramBundle, "context");
    paramBundle = paramBundle.getIntent().getStringExtra("ksnsupload_finder_live_xml");
    if (!Util.isNullOrNil(paramBundle))
    {
      paramBundle = XmlParser.parseXml(paramBundle, "finderLive", null);
      if (paramBundle != null)
      {
        localObject = new d();
        ((d)localObject).i("", paramBundle);
        this.KDd = ((d)localObject);
      }
    }
    AppMethodBeat.o(270737);
  }
  
  public final View fTx()
  {
    AppMethodBeat.i(270738);
    View localView = ad.kS((Context)this.iXq).inflate(i.g.sns_festival_pic_widget_ui, null);
    ImageView localImageView = (ImageView)localView.findViewById(i.f.sns_festival_pic_ui_image);
    Object localObject = this.KDd;
    if ((localObject != null) && (((d)localObject).mbh != null))
    {
      localObject = ao.ib((Context)this.iXq);
      localObject = o.a(localObject[0], localObject[1], (Context)this.iXq, false);
      Integer localInteger = (Integer)((Pair)localObject).first;
      int i = (int)(((Number)((Pair)localObject).first).floatValue() * 3.5F / 3.0F);
      p.j(localInteger, "smallSide");
      localObject = new ViewGroup.LayoutParams(localInteger.intValue(), i);
      p.j(localView, "layout");
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localView.requestLayout();
      p.j(localImageView, "thumb");
      new a(localImageView, this.mediaPath).y(new String[] { "" });
      localImageView.setOnClickListener((View.OnClickListener)new w.b(this, localView, localImageView));
    }
    p.j(localView, "layout");
    AppMethodBeat.o(270738);
    return localView;
  }
  
  public final boolean k(int paramInt, Intent paramIntent)
  {
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/sns/ui/FinderPicWidget$ThumbLoader;", "Lcom/tencent/mm/plugin/sns/model/MagicAsyncTask;", "", "", "", "iv", "Landroid/widget/ImageView;", "path", "(Landroid/widget/ImageView;Ljava/lang/String;)V", "bm", "Landroid/graphics/Bitmap;", "doInBackground", "params", "", "([Ljava/lang/String;)Ljava/lang/Boolean;", "getExecutor", "Ljava/util/concurrent/ExecutorService;", "onPostExecute", "", "result", "plugin-sns_release"})
  public static final class a
    extends h<String, Integer, Boolean>
  {
    private final ImageView fIv;
    private Bitmap lAx;
    private final String path;
    
    public a(ImageView paramImageView, String paramString)
    {
      AppMethodBeat.i(196892);
      this.fIv = paramImageView;
      this.path = paramString;
      AppMethodBeat.o(196892);
    }
    
    public final ExecutorService fsl()
    {
      AppMethodBeat.i(196887);
      ExecutorService localExecutorService = aj.fOs();
      p.j(localExecutorService, "SnsCore.getMediaExecutor()");
      AppMethodBeat.o(196887);
      return localExecutorService;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.w
 * JD-Core Version:    0.7.0.1
 */