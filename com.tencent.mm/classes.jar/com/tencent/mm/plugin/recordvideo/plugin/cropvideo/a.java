package com.tencent.mm.plugin.recordvideo.plugin.cropvideo;

import a.f.b.j;
import a.l;
import a.v;
import android.animation.Animator.AnimatorListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar;
import com.tencent.mm.plugin.mmsight.segment.c.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.am;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/mmsight/segment/ISegmentSeekBar$OnSeekBarChangedListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "cropBtn", "Landroid/widget/ImageView;", "cropEnd", "", "cropRecyclerThumbSeekBar", "Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView;", "cropStart", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "changeThumbBarPercent", "", "currentTime", "", "forceCropVideo", "getSmaller", "a", "b", "name", "", "onBackPress", "", "onClick", "v", "Landroid/view/View;", "onDown", "left", "start", "end", "onMove", "onRecyclerChanged", "onUp", "release", "reset", "resetConfirmStyle", "bgStyleResId", "textColor", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "setCaptureInfo", "setVisibility", "visibility", "synCropInfo", "Companion", "plugin-recordvideo_release"})
public final class a
  implements View.OnClickListener, c.b, q
{
  public static final a.a qdp;
  private ViewGroup eyt;
  public RecordConfigProvider qaF;
  private d qbI;
  private final ImageView qdk;
  public final EditVideoSeekBarView qdl;
  public com.tencent.mm.media.widget.camerarecordview.a.b qdm;
  private float qdn;
  public float qdo;
  
  static
  {
    AppMethodBeat.i(150748);
    qdp = new a.a((byte)0);
    AppMethodBeat.o(150748);
  }
  
  public a(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(150747);
    this.eyt = paramViewGroup;
    this.qbI = paramd;
    paramViewGroup = this.eyt.findViewById(2131828705);
    j.p(paramViewGroup, "parent.findViewById(R.id.editor_crop_video)");
    this.qdk = ((ImageView)paramViewGroup);
    paramViewGroup = this.eyt.findViewById(2131828719);
    j.p(paramViewGroup, "parent.findViewById(R.id.editor_crop_bar)");
    this.qdl = ((EditVideoSeekBarView)paramViewGroup);
    this.qdo = 1.0F;
    this.qdk.setImageDrawable(aj.g(this.eyt.getContext(), 2131231450, -1));
    this.qdk.setOnClickListener((View.OnClickListener)this);
    this.qdl.setCancelButtonClickListener((View.OnClickListener)this);
    this.qdl.setFinishButtonClickListener((View.OnClickListener)this);
    paramViewGroup = this.qdl.getLayoutParams();
    if (paramViewGroup == null)
    {
      paramViewGroup = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(150747);
      throw paramViewGroup;
    }
    paramViewGroup = (RelativeLayout.LayoutParams)paramViewGroup;
    paramViewGroup.bottomMargin += am.fx(this.eyt.getContext());
    this.qdl.setLayoutParams((ViewGroup.LayoutParams)paramViewGroup);
    AppMethodBeat.o(150747);
  }
  
  private final void aa(float paramFloat1, float paramFloat2)
  {
    float f1 = 0.0F;
    AppMethodBeat.i(150743);
    Object localObject = this.qdm;
    int k;
    float f2;
    int i;
    if (localObject != null)
    {
      k = ((com.tencent.mm.media.widget.camerarecordview.a.b)localObject).endTime - ((com.tencent.mm.media.widget.camerarecordview.a.b)localObject).startTime;
      f2 = k;
      localObject = this.qaF;
      if (localObject == null) {
        j.ebi();
      }
      i = ((RecordConfigProvider)localObject).qbx;
      localObject = this.qdm;
      if (localObject == null) {
        j.ebi();
      }
      f2 = (paramFloat2 - paramFloat1) * f2 - fm(i + 250, ((com.tencent.mm.media.widget.camerarecordview.a.b)localObject).endTime);
      if (f2 >= 0.0F) {
        break label193;
      }
    }
    for (;;)
    {
      i = Math.round(k * paramFloat1);
      int j = (int)f1 / 2;
      k = Math.round(k * paramFloat2);
      int m = (int)f1 / 2;
      localObject = new Bundle();
      ((Bundle)localObject).putInt("EDIT_CROP_VIDEO_LENGTH_START_TIME_INT", i + j);
      ((Bundle)localObject).putInt("EDIT_CROP_VIDEO_LENGTH_END_TIME_INT", k - m);
      this.qbI.a(d.c.qeH, (Bundle)localObject);
      AppMethodBeat.o(150743);
      return;
      AppMethodBeat.o(150743);
      return;
      label193:
      f1 = f2;
    }
  }
  
  public static int fm(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  public final void V(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(150738);
    ab.d("MicroMsg.EditCropVideoPlugin", "onRecyclerChanged : " + paramFloat1 + ' ' + paramFloat2);
    this.qdn = paramFloat1;
    this.qdo = paramFloat2;
    aa(paramFloat1, paramFloat2);
    AppMethodBeat.o(150738);
  }
  
  public final void W(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(150739);
    ab.d("MicroMsg.EditCropVideoPlugin", "onDown : " + paramFloat1 + ' ' + paramFloat2);
    d.b.a(this.qbI, d.c.qeJ);
    AppMethodBeat.o(150739);
  }
  
  public final void X(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(150740);
    ab.d("MicroMsg.EditCropVideoPlugin", "onUp : " + paramFloat1 + ' ' + paramFloat2);
    this.qdn = paramFloat1;
    this.qdo = paramFloat2;
    aa(paramFloat1, paramFloat2);
    AppMethodBeat.o(150740);
  }
  
  public final void Y(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(150741);
    ab.d("MicroMsg.EditCropVideoPlugin", "onMove : " + paramFloat1 + ' ' + paramFloat2);
    AppMethodBeat.o(150741);
  }
  
  public final boolean cgq()
  {
    AppMethodBeat.i(150744);
    if (this.qdl.getVisibility() == 0)
    {
      d.b.a(this.qbI, d.c.qeL);
      this.qdl.animate().alpha(0.0F).setDuration(100L).setListener((Animator.AnimatorListener)new a.b(this));
      AppMethodBeat.o(150744);
      return true;
    }
    AppMethodBeat.o(150744);
    return false;
  }
  
  public final void cgz()
  {
    AppMethodBeat.i(150736);
    this.qdl.setVisibility(0);
    d.b.a(this.qbI, d.c.qeF);
    AppMethodBeat.o(150736);
  }
  
  public final String name()
  {
    return "plugin_crop";
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(150737);
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      if (paramView != null) {
        break label42;
      }
      label22:
      if (paramView != null) {
        break label111;
      }
    }
    for (;;)
    {
      if (paramView == null)
      {
        AppMethodBeat.o(150737);
        return;
        paramView = null;
        break;
        label42:
        if (paramView.intValue() != 2131826738) {
          break label22;
        }
        this.qdl.oQL.reset();
        d.b.a(this.qbI, d.c.qeL);
        this.qdl.animate().alpha(0.0F).setDuration(100L).setListener((Animator.AnimatorListener)new a.c(this));
        AppMethodBeat.o(150737);
        return;
        label111:
        if (paramView.intValue() == 2131826739)
        {
          aa(this.qdn, this.qdo);
          d.b.a(this.qbI, d.c.qeM);
          this.qdl.animate().alpha(0.0F).setDuration(100L).setListener((Animator.AnimatorListener)new a.d(this));
          paramView = this.qdm;
          if (paramView != null)
          {
            int i = paramView.endTime;
            int j = paramView.startTime;
            paramView = com.tencent.mm.plugin.recordvideo.c.b.qfu;
            com.tencent.mm.plugin.recordvideo.c.b.p("KEY_VIDEO_CROP_DURATION_MS_INT", Integer.valueOf((int)((i - j) * (this.qdo - this.qdn))));
            AppMethodBeat.o(150737);
            return;
          }
          AppMethodBeat.o(150737);
          return;
        }
      }
    }
    if (paramView.intValue() == 2131828705)
    {
      cgz();
      paramView = com.tencent.mm.plugin.recordvideo.c.b.qfu;
      com.tencent.mm.plugin.recordvideo.c.b.Ya("KEY_CLICK_VIDEO_CROP_COUNT_INT");
    }
    AppMethodBeat.o(150737);
  }
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(150746);
    this.qdl.release();
    AppMethodBeat.o(150746);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(150745);
    this.qdl.release();
    AppMethodBeat.o(150745);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(150742);
    this.qdk.setVisibility(paramInt);
    AppMethodBeat.o(150742);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a
 * JD-Core Version:    0.7.0.1
 */