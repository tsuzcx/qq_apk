package com.tencent.mm.plugin.recordvideo.plugin.doodle;

import a.l;
import a.v;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.q;
import com.tencent.mm.ui.aj;
import java.util.ArrayList;
import java.util.Iterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "colorList", "Landroid/widget/GridView;", "resourceArray", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$ClickImageViewResource;", "Lkotlin/collections/ArrayList;", "selectType", "", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "unDoImageView", "Landroid/widget/ImageView;", "onBackPress", "", "postFuncType", "", "type", "resetClickBigImageView", "view", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/ClickBigImageView;", "selectClickBigImageView", "setStatus", "setVisibility", "visibility", "ClickImageViewResource", "ClickImageViewResourceAdapter", "Companion", "plugin-recordvideo_release"})
public final class PhotoDoodlePlugin
  extends RelativeLayout
  implements q
{
  public static final PhotoDoodlePlugin.c qdw;
  private int gpS;
  private d qbI;
  private final ArrayList<a> qdt;
  private final ImageView qdu;
  private final GridView qdv;
  
  static
  {
    AppMethodBeat.i(150774);
    qdw = new PhotoDoodlePlugin.c((byte)0);
    AppMethodBeat.o(150774);
  }
  
  public PhotoDoodlePlugin(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(150773);
    this.qdt = new ArrayList();
    this.gpS = 2;
    LayoutInflater.from(paramContext).inflate(2130970418, (ViewGroup)this, true);
    paramAttributeSet = findViewById(2131826734);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.recall)");
    this.qdu = ((ImageView)paramAttributeSet);
    this.qdu.setImageDrawable(aj.g(paramContext, 2131232143, -1));
    this.qdu.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(150763);
        paramAnonymousView = PhotoDoodlePlugin.b(this.qdx);
        if (paramAnonymousView != null)
        {
          d.b.a(paramAnonymousView, d.c.qfa);
          AppMethodBeat.o(150763);
          return;
        }
        AppMethodBeat.o(150763);
      }
    });
    paramAttributeSet = findViewById(2131826735);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.color_list)");
    this.qdv = ((GridView)paramAttributeSet);
    paramAttributeSet = BitmapFactory.decodeResource(paramContext.getResources(), 2130839144);
    paramContext = BitmapFactory.decodeResource(paramContext.getResources(), 2130839145);
    Object localObject = this.qdt;
    a locala = new a();
    locala.bitmap = paramContext;
    locala.type = 99;
    ((ArrayList)localObject).add(locala);
    paramContext = this.qdt;
    localObject = new a();
    ((a)localObject).bitmap = paramAttributeSet;
    ((a)localObject).type = 100;
    paramContext.add(localObject);
    paramContext = this.qdt;
    paramAttributeSet = new a();
    paramAttributeSet.color = -1;
    paramAttributeSet.type = 0;
    paramContext.add(paramAttributeSet);
    paramContext = this.qdt;
    paramAttributeSet = new a();
    paramAttributeSet.color = -16777216;
    paramAttributeSet.type = 1;
    paramContext.add(paramAttributeSet);
    paramContext = this.qdt;
    paramAttributeSet = new a();
    paramAttributeSet.color = -707825;
    paramAttributeSet.type = 2;
    paramContext.add(paramAttributeSet);
    paramContext = this.qdt;
    paramAttributeSet = new a();
    paramAttributeSet.color = -17592;
    paramAttributeSet.type = 3;
    paramContext.add(paramAttributeSet);
    paramContext = this.qdt;
    paramAttributeSet = new a();
    paramAttributeSet.color = -16535286;
    paramAttributeSet.type = 4;
    paramContext.add(paramAttributeSet);
    paramContext = this.qdt;
    paramAttributeSet = new a();
    paramAttributeSet.color = -15172610;
    paramAttributeSet.type = 5;
    paramContext.add(paramAttributeSet);
    paramContext = this.qdt;
    paramAttributeSet = new a();
    paramAttributeSet.color = -7054596;
    paramAttributeSet.type = 6;
    paramContext.add(paramAttributeSet);
    this.qdv.setAdapter((ListAdapter)new PhotoDoodlePlugin.b(this, this.qdt));
    this.qdv.setOnItemClickListener((AdapterView.OnItemClickListener)new PhotoDoodlePlugin.2(this));
    AppMethodBeat.o(150773);
  }
  
  private final void Cr(int paramInt)
  {
    AppMethodBeat.i(150772);
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = new Bundle();
      ((Bundle)localObject).putInt("EDIT_PHOTO_DOODLE_PENCIL_INDEX_INT", paramInt);
      d locald = this.qbI;
      if (locald != null)
      {
        locald.a(d.c.qeZ, (Bundle)localObject);
        AppMethodBeat.o(150772);
        return;
      }
      break;
    case 99: 
      localObject = this.qbI;
      if (localObject != null)
      {
        d.b.a((d)localObject, d.c.qeX);
        AppMethodBeat.o(150772);
        return;
      }
      AppMethodBeat.o(150772);
      return;
    case 100: 
      localObject = this.qbI;
      if (localObject != null)
      {
        d.b.a((d)localObject, d.c.qeY);
        AppMethodBeat.o(150772);
        return;
      }
      AppMethodBeat.o(150772);
      return;
    }
    AppMethodBeat.o(150772);
  }
  
  public final boolean cgq()
  {
    AppMethodBeat.i(150771);
    if (getVisibility() == 0)
    {
      setVisibility(4);
      AppMethodBeat.o(150771);
      return true;
    }
    AppMethodBeat.o(150771);
    return false;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setStatus(d paramd)
  {
    AppMethodBeat.i(150769);
    a.f.b.j.q(paramd, "status");
    this.qbI = paramd;
    AppMethodBeat.o(150769);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(150770);
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      Object localObject1 = ((Iterable)this.qdt).iterator();
      paramInt = 0;
      while (((Iterator)localObject1).hasNext())
      {
        ((Iterator)localObject1).next();
        int i = paramInt + 1;
        if (paramInt < 0) {
          a.a.j.eaS();
        }
        if (this.qdv.getChildAt(paramInt) != null)
        {
          Object localObject2 = this.qdv.getChildAt(paramInt);
          if (localObject2 == null)
          {
            localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
            AppMethodBeat.o(150770);
            throw ((Throwable)localObject1);
          }
          View localView;
          if (((ClickBigImageView)localObject2).getType() != this.gpS)
          {
            localObject2 = this.qdv.getChildAt(paramInt);
            if (localObject2 == null)
            {
              localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
              AppMethodBeat.o(150770);
              throw ((Throwable)localObject1);
            }
            ((ClickBigImageView)localObject2).setHasSelected(false);
            localObject2 = this.qdv.getChildAt(paramInt);
            a.f.b.j.p(localObject2, "colorList.getChildAt(index)");
            localObject2 = ((View)localObject2).getLayoutParams();
            ((ViewGroup.LayoutParams)localObject2).height = a.fromDPToPix(this.qdv.getContext(), 18);
            ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject2).height;
            localView = this.qdv.getChildAt(paramInt);
            a.f.b.j.p(localView, "colorList.getChildAt(index)");
            localView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            paramInt = i;
          }
          else
          {
            localObject2 = this.qdv.getChildAt(paramInt);
            if (localObject2 == null)
            {
              localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
              AppMethodBeat.o(150770);
              throw ((Throwable)localObject1);
            }
            ((ClickBigImageView)localObject2).setHasSelected(true);
            localObject2 = this.qdv.getChildAt(paramInt);
            a.f.b.j.p(localObject2, "colorList.getChildAt(index)");
            localObject2 = ((View)localObject2).getLayoutParams();
            ((ViewGroup.LayoutParams)localObject2).height = ((int)(a.fromDPToPix(this.qdv.getContext(), 18) * 1.2D));
            ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject2).height;
            localView = this.qdv.getChildAt(paramInt);
            a.f.b.j.p(localView, "colorList.getChildAt(index)");
            localView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
        }
        else
        {
          paramInt = i;
        }
      }
      Cr(this.gpS);
    }
    AppMethodBeat.o(150770);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$ClickImageViewResource;", "", "()V", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "color", "", "getColor", "()I", "setColor", "(I)V", "type", "getType", "setType", "plugin-recordvideo_release"})
  static final class a
  {
    Bitmap bitmap;
    int color;
    int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.doodle.PhotoDoodlePlugin
 * JD-Core Version:    0.7.0.1
 */