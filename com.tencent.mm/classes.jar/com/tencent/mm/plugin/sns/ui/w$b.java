package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.MMActivity;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/sns/ui/FinderPicWidget$initView$1$1"})
final class w$b
  implements View.OnClickListener
{
  w$b(w paramw, View paramView, ImageView paramImageView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(264060);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    a.c("com/tencent/mm/plugin/sns/ui/FinderPicWidget$initView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    paramView = new Intent();
    paramView.setClass((Context)this.KDm.iXq, SnsUploadBrowseUI.class);
    paramView.putExtra("k_need_delete", false);
    paramView.putExtra("sns_gallery_position", 0);
    paramView.putExtra("key_from_scene", 7);
    localObject = new ArrayList();
    ((ArrayList)localObject).add(this.KDm.mediaPath);
    paramView.putExtra("sns_gallery_temp_paths", (Serializable)localObject);
    this.KDm.iXq.startActivityForResult(paramView, 7);
    a.a(this, "com/tencent/mm/plugin/sns/ui/FinderPicWidget$initView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(264060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.w.b
 * JD-Core Version:    0.7.0.1
 */