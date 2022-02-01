package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.e.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.sdk.platformtools.f;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoBgPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "bgView", "Landroid/widget/ImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/ImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "TAG", "", "getBgView", "()Landroid/widget/ImageView;", "setBgView", "(Landroid/widget/ImageView;)V", "blurBitmap", "Landroid/graphics/Bitmap;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "initLogic", "", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "release", "reset", "saveBgBitmap", "setBlackBg", "plugin-recordvideo_release"})
public final class q
  implements t
{
  public String TAG;
  public Context context;
  public ImageView vkA;
  public Bitmap vkz;
  
  public q(ImageView paramImageView, d paramd)
  {
    AppMethodBeat.i(75578);
    this.vkA = paramImageView;
    this.TAG = "MicroMsg.EditVideoBgPlugin";
    this.context = this.vkA.getContext();
    AppMethodBeat.o(75578);
  }
  
  public final void apt() {}
  
  public final boolean dia()
  {
    return false;
  }
  
  public final String diq()
  {
    AppMethodBeat.i(163434);
    if (this.vkz != null)
    {
      Object localObject = b.vtE;
      localObject = b.alX(String.valueOf(System.currentTimeMillis()));
      f.a(this.vkz, 100, Bitmap.CompressFormat.JPEG, (String)localObject, false);
      AppMethodBeat.o(163434);
      return localObject;
    }
    AppMethodBeat.o(163434);
    return null;
  }
  
  public final void fYe()
  {
    AppMethodBeat.i(204080);
    ImageView localImageView = this.vkA;
    Context localContext = this.vkA.getContext();
    k.g(localContext, "bgView.context");
    localImageView.setBackgroundColor(localContext.getResources().getColor(2131100017));
    AppMethodBeat.o(204080);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(75577);
    Bitmap localBitmap = this.vkz;
    if (localBitmap != null)
    {
      if (!localBitmap.isRecycled())
      {
        localBitmap = this.vkz;
        if (localBitmap != null) {
          localBitmap.recycle();
        }
        this.vkz = null;
      }
      AppMethodBeat.o(75577);
      return;
    }
    AppMethodBeat.o(75577);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(75576);
    ImageView localImageView = this.vkA;
    Context localContext = this.vkA.getContext();
    k.g(localContext, "bgView.context");
    localImageView.setBackgroundColor(localContext.getResources().getColor(2131101053));
    AppMethodBeat.o(75576);
  }
  
  public final void setVisibility(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.q
 * JD-Core Version:    0.7.0.1
 */