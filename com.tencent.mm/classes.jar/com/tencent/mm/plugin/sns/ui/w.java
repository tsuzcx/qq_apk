package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.bg;
import com.tencent.mm.plugin.sns.model.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ar;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/FinderPicWidget;", "Lcom/tencent/mm/plugin/sns/ui/PicWidget;", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "finderShareObject", "Lcom/tencent/mm/modelsns/SnsFinderShareLive;", "mediaPath", "", "handlerOnCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initView", "Landroid/view/View;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onPrepareCommitPack", "packHelper", "Lcom/tencent/mm/plugin/sns/model/UploadPackHelper;", "ThumbLoader", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
  extends at
{
  private d RcK;
  private String mediaPath;
  
  public w(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(308072);
    this.mediaPath = "";
    AppMethodBeat.o(308072);
  }
  
  private static final void a(w paramw, View paramView)
  {
    AppMethodBeat.i(308075);
    Object localObject1 = new Object();
    Object localObject2 = new b();
    ((b)localObject2).cH(paramw);
    ((b)localObject2).cH(paramView);
    a.c("com/tencent/mm/plugin/sns/ui/FinderPicWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((b)localObject2).aYj());
    s.u(paramw, "this$0");
    paramView = new Intent();
    paramView.setClass((Context)paramw.lzt, SnsUploadBrowseUI.class);
    paramView.putExtra("k_need_delete", false);
    paramView.putExtra("sns_gallery_position", 0);
    paramView.putExtra("key_from_scene", 7);
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(paramw.mediaPath);
    localObject2 = ah.aiuX;
    paramView.putExtra("sns_gallery_temp_paths", (Serializable)localObject1);
    paramw.lzt.startActivityForResult(paramView, 7);
    a.a(new Object(), "com/tencent/mm/plugin/sns/ui/FinderPicWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(308075);
  }
  
  protected final void a(bg parambg)
  {
    AppMethodBeat.i(308094);
    if ((this.RcK != null) && (parambg != null)) {
      parambg.a(this.RcK);
    }
    super.a(parambg);
    AppMethodBeat.o(308094);
  }
  
  public final void aZ(Bundle paramBundle)
  {
    AppMethodBeat.i(308082);
    super.aZ(paramBundle);
    Object localObject = this.lzt.getIntent().getStringExtra("sns_kemdia_path");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    this.mediaPath = paramBundle;
    paramBundle = this.lzt.getIntent().getStringExtra("ksnsupload_finder_live_xml");
    if (!Util.isNullOrNil(paramBundle))
    {
      localObject = XmlParser.parseXml(paramBundle, "finderLive", null);
      if (localObject != null)
      {
        paramBundle = new d();
        paramBundle.i("", (Map)localObject);
        localObject = ah.aiuX;
        this.RcK = paramBundle;
      }
    }
    AppMethodBeat.o(308082);
  }
  
  public final View hlQ()
  {
    AppMethodBeat.i(308090);
    View localView = af.mU((Context)this.lzt).inflate(b.g.sns_festival_pic_widget_ui, null);
    ImageView localImageView = (ImageView)localView.findViewById(b.f.sns_festival_pic_ui_image);
    Object localObject = this.RcK;
    if ((localObject != null) && (((d)localObject).oUb != null))
    {
      localObject = ar.jR((Context)this.lzt);
      localObject = o.a(localObject[0], localObject[1], (Context)this.lzt, false);
      Integer localInteger = (Integer)((Pair)localObject).first;
      int i = (int)(((Number)((Pair)localObject).first).floatValue() * 3.5F / 3.0F);
      s.s(localInteger, "smallSide");
      localView.setLayoutParams(new ViewGroup.LayoutParams(localInteger.intValue(), i));
      localView.requestLayout();
      s.s(localImageView, "thumb");
      new a(localImageView, this.mediaPath).A(new String[] { "" });
      localImageView.setOnClickListener(new w..ExternalSyntheticLambda0(this));
    }
    s.s(localView, "layout");
    AppMethodBeat.o(308090);
    return localView;
  }
  
  public final boolean n(int paramInt, Intent paramIntent)
  {
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/FinderPicWidget$ThumbLoader;", "Lcom/tencent/mm/plugin/sns/model/MagicAsyncTask;", "", "", "", "iv", "Landroid/widget/ImageView;", "path", "(Landroid/widget/ImageView;Ljava/lang/String;)V", "bm", "Landroid/graphics/Bitmap;", "doInBackground", "params", "", "([Ljava/lang/String;)Ljava/lang/Boolean;", "getExecutor", "Ljava/util/concurrent/ExecutorService;", "onPostExecute", "", "result", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends h<String, Integer, Boolean>
  {
    private final ImageView hNV;
    private Bitmap orY;
    private final String path;
    
    public a(ImageView paramImageView, String paramString)
    {
      AppMethodBeat.i(308410);
      this.hNV = paramImageView;
      this.path = paramString;
      AppMethodBeat.o(308410);
    }
    
    public final ExecutorService gDT()
    {
      AppMethodBeat.i(308411);
      ExecutorService localExecutorService = al.hgl();
      s.s(localExecutorService, "getMediaExecutor()");
      AppMethodBeat.o(308411);
      return localExecutorService;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.w
 * JD-Core Version:    0.7.0.1
 */