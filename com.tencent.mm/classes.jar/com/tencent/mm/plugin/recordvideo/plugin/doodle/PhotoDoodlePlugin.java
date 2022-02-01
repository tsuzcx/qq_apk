package com.tencent.mm.plugin.recordvideo.plugin.doodle;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.ui.am;
import d.a.j;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Iterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "colorList", "Landroid/widget/GridView;", "imageSizeDP", "", "resourceArray", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$ClickImageViewResource;", "Lkotlin/collections/ArrayList;", "selectType", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "unDoImageView", "Landroid/widget/ImageView;", "hideMosaic", "", "hide", "", "initResourceArray", "msc", "Landroid/graphics/Bitmap;", "brush", "onBackPress", "postFuncType", "type", "resetClickBigImageView", "view", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/ClickBigImageView;", "selectClickBigImageView", "setStatus", "setVisibility", "visibility", "ClickImageViewResource", "ClickImageViewResourceAdapter", "Companion", "plugin-recordvideo_release"})
public final class PhotoDoodlePlugin
  extends RelativeLayout
  implements t
{
  public static final c vmi;
  private int ici;
  private d vjo;
  private final ArrayList<a> vme;
  private final ImageView vmf;
  public final GridView vmg;
  private final int vmh;
  
  static
  {
    AppMethodBeat.i(75733);
    vmi = new c((byte)0);
    AppMethodBeat.o(75733);
  }
  
  public PhotoDoodlePlugin(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75732);
    this.vme = new ArrayList();
    this.ici = 2;
    this.vmh = 22;
    LayoutInflater.from(paramContext).inflate(2131495085, (ViewGroup)this, true);
    paramAttributeSet = findViewById(2131303804);
    k.g(paramAttributeSet, "findViewById(R.id.recall)");
    this.vmf = ((ImageView)paramAttributeSet);
    this.vmf.setImageDrawable(am.i(paramContext, 2131690462, -1));
    this.vmf.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(75722);
        paramAnonymousView = PhotoDoodlePlugin.d(this.vmj);
        if (paramAnonymousView != null)
        {
          d.b.a(paramAnonymousView, d.c.vou);
          AppMethodBeat.o(75722);
          return;
        }
        AppMethodBeat.o(75722);
      }
    });
    paramAttributeSet = findViewById(2131298493);
    k.g(paramAttributeSet, "findViewById(R.id.color_list)");
    this.vmg = ((GridView)paramAttributeSet);
    paramAttributeSet = BitmapFactory.decodeResource(paramContext.getResources(), 2131232703);
    b(BitmapFactory.decodeResource(paramContext.getResources(), 2131232704), paramAttributeSet);
    this.vmg.setAdapter((ListAdapter)new b(this.vme));
    this.vmg.setOnItemClickListener((AdapterView.OnItemClickListener)new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(163441);
        if (paramAnonymousView == null)
        {
          paramAnonymousAdapterView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
          AppMethodBeat.o(163441);
          throw paramAnonymousAdapterView;
        }
        if (((ClickBigImageView)paramAnonymousView).getType() == PhotoDoodlePlugin.c(this.vmj))
        {
          PhotoDoodlePlugin.b(this.vmj, ((ClickBigImageView)paramAnonymousView).getType());
          AppMethodBeat.o(163441);
          return;
        }
        PhotoDoodlePlugin.a(this.vmj, ((ClickBigImageView)paramAnonymousView).getType());
        PhotoDoodlePlugin.b(this.vmj, ((ClickBigImageView)paramAnonymousView).getType());
        paramAnonymousAdapterView = (Iterable)PhotoDoodlePlugin.e(this.vmj);
        int i = 0;
        paramAnonymousAdapterView = paramAnonymousAdapterView.iterator();
        while (paramAnonymousAdapterView.hasNext())
        {
          paramAnonymousAdapterView.next();
          int j = i + 1;
          if (i < 0) {
            j.fvx();
          }
          if (i == paramAnonymousInt)
          {
            paramAnonymousView = PhotoDoodlePlugin.a(this.vmj).getChildAt(i);
            if (paramAnonymousView == null)
            {
              paramAnonymousAdapterView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
              AppMethodBeat.o(163441);
              throw paramAnonymousAdapterView;
            }
            if (!((ClickBigImageView)paramAnonymousView).sUj)
            {
              paramAnonymousView = PhotoDoodlePlugin.a(this.vmj).getChildAt(i);
              if (paramAnonymousView == null)
              {
                paramAnonymousAdapterView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
                AppMethodBeat.o(163441);
                throw paramAnonymousAdapterView;
              }
              PhotoDoodlePlugin.a((ClickBigImageView)paramAnonymousView);
              i = j;
            }
          }
          else
          {
            paramAnonymousView = PhotoDoodlePlugin.a(this.vmj).getChildAt(i);
            if (paramAnonymousView == null)
            {
              paramAnonymousAdapterView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
              AppMethodBeat.o(163441);
              throw paramAnonymousAdapterView;
            }
            if (((ClickBigImageView)paramAnonymousView).sUj)
            {
              paramAnonymousView = PhotoDoodlePlugin.a(this.vmj).getChildAt(i);
              if (paramAnonymousView == null)
              {
                paramAnonymousAdapterView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
                AppMethodBeat.o(163441);
                throw paramAnonymousAdapterView;
              }
              PhotoDoodlePlugin.b((ClickBigImageView)paramAnonymousView);
            }
          }
          i = j;
        }
        AppMethodBeat.o(163441);
      }
    });
    AppMethodBeat.o(75732);
  }
  
  private final void Km(int paramInt)
  {
    AppMethodBeat.i(75731);
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = new Bundle();
      ((Bundle)localObject).putInt("EDIT_PHOTO_DOODLE_PENCIL_INDEX_INT", paramInt);
      d locald = this.vjo;
      if (locald != null)
      {
        locald.a(d.c.vot, (Bundle)localObject);
        AppMethodBeat.o(75731);
        return;
      }
      break;
    case 99: 
      localObject = this.vjo;
      if (localObject != null)
      {
        d.b.a((d)localObject, d.c.vor);
        AppMethodBeat.o(75731);
        return;
      }
      AppMethodBeat.o(75731);
      return;
    case 100: 
      localObject = this.vjo;
      if (localObject != null)
      {
        d.b.a((d)localObject, d.c.vos);
        AppMethodBeat.o(75731);
        return;
      }
      AppMethodBeat.o(75731);
      return;
    }
    AppMethodBeat.o(75731);
  }
  
  public final void apt() {}
  
  public final void b(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    AppMethodBeat.i(163442);
    this.vme.clear();
    Object localObject;
    if (paramBitmap1 != null)
    {
      localObject = this.vme;
      a locala = new a();
      locala.bitmap = paramBitmap1;
      locala.type = 99;
      ((ArrayList)localObject).add(locala);
    }
    if (paramBitmap2 != null)
    {
      paramBitmap1 = this.vme;
      localObject = new a();
      ((a)localObject).bitmap = paramBitmap2;
      ((a)localObject).type = 100;
      paramBitmap1.add(localObject);
    }
    paramBitmap1 = this.vme;
    paramBitmap2 = new a();
    paramBitmap2.color = -1;
    paramBitmap2.type = 0;
    paramBitmap1.add(paramBitmap2);
    paramBitmap1 = this.vme;
    paramBitmap2 = new a();
    paramBitmap2.color = -16777216;
    paramBitmap2.type = 1;
    paramBitmap1.add(paramBitmap2);
    paramBitmap1 = this.vme;
    paramBitmap2 = new a();
    paramBitmap2.color = -707825;
    paramBitmap2.type = 2;
    paramBitmap1.add(paramBitmap2);
    paramBitmap1 = this.vme;
    paramBitmap2 = new a();
    paramBitmap2.color = -17592;
    paramBitmap2.type = 3;
    paramBitmap1.add(paramBitmap2);
    paramBitmap1 = this.vme;
    paramBitmap2 = new a();
    paramBitmap2.color = -16535286;
    paramBitmap2.type = 4;
    paramBitmap1.add(paramBitmap2);
    paramBitmap1 = this.vme;
    paramBitmap2 = new a();
    paramBitmap2.color = -15172610;
    paramBitmap2.type = 5;
    paramBitmap1.add(paramBitmap2);
    paramBitmap1 = this.vme;
    paramBitmap2 = new a();
    paramBitmap2.color = -7054596;
    paramBitmap2.type = 6;
    paramBitmap1.add(paramBitmap2);
    AppMethodBeat.o(163442);
  }
  
  public final boolean dia()
  {
    AppMethodBeat.i(75730);
    if (getVisibility() == 0)
    {
      setVisibility(4);
      AppMethodBeat.o(75730);
      return true;
    }
    AppMethodBeat.o(75730);
    return false;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setStatus(d paramd)
  {
    AppMethodBeat.i(75728);
    k.h(paramd, "status");
    this.vjo = paramd;
    AppMethodBeat.o(75728);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75729);
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      Object localObject = ((Iterable)this.vme).iterator();
      int i = 0;
      while (((Iterator)localObject).hasNext())
      {
        ((Iterator)localObject).next();
        int j = i + 1;
        if (i < 0) {
          j.fvx();
        }
        if (this.vmg.getChildAt(i) != null)
        {
          View localView = this.vmg.getChildAt(i);
          if (localView == null)
          {
            localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
            AppMethodBeat.o(75729);
            throw ((Throwable)localObject);
          }
          if (((ClickBigImageView)localView).getType() != this.ici)
          {
            localView = this.vmg.getChildAt(i);
            if (localView == null)
            {
              localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
              AppMethodBeat.o(75729);
              throw ((Throwable)localObject);
            }
            ((ClickBigImageView)localView).setHasSelected(false);
            i = j;
          }
          else
          {
            localView = this.vmg.getChildAt(i);
            if (localView == null)
            {
              localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.ClickBigImageView");
              AppMethodBeat.o(75729);
              throw ((Throwable)localObject);
            }
            ((ClickBigImageView)localView).setHasSelected(true);
          }
        }
        else
        {
          i = j;
        }
      }
      Km(this.ici);
    }
    this.vmg.setVisibility(paramInt);
    this.vmf.setVisibility(paramInt);
    AppMethodBeat.o(75729);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$ClickImageViewResource;", "", "()V", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "color", "", "getColor", "()I", "setColor", "(I)V", "type", "getType", "setType", "plugin-recordvideo_release"})
  static final class a
  {
    Bitmap bitmap;
    int color;
    int type;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$ClickImageViewResourceAdapter;", "Landroid/widget/BaseAdapter;", "resourceArray", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$ClickImageViewResource;", "Lkotlin/collections/ArrayList;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin;Ljava/util/ArrayList;)V", "getResourceArray", "()Ljava/util/ArrayList;", "setResourceArray", "(Ljava/util/ArrayList;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-recordvideo_release"})
  final class b
    extends BaseAdapter
  {
    private ArrayList<PhotoDoodlePlugin.a> vme;
    
    public b()
    {
      AppMethodBeat.i(75727);
      this.vme = localObject;
      AppMethodBeat.o(75727);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(75726);
      int i = this.vme.size();
      AppMethodBeat.o(75726);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(75725);
      Object localObject = this.vme.get(paramInt);
      k.g(localObject, "resourceArray[position]");
      AppMethodBeat.o(75725);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(75724);
      if (paramViewGroup == null) {
        k.fvU();
      }
      paramView = paramViewGroup.getContext();
      k.g(paramView, "parent!!.context");
      paramView = new ClickBigImageView(paramView, null);
      paramViewGroup = getItem(paramInt);
      if (paramViewGroup == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.doodle.PhotoDoodlePlugin.ClickImageViewResource");
        AppMethodBeat.o(75724);
        throw paramView;
      }
      paramViewGroup = (PhotoDoodlePlugin.a)paramViewGroup;
      if (paramViewGroup.bitmap == null)
      {
        paramView.setDrawColor(paramViewGroup.color);
        paramView.setType(paramViewGroup.type);
        paramInt = a.fromDPToPix(PhotoDoodlePlugin.a(PhotoDoodlePlugin.this).getContext(), PhotoDoodlePlugin.b(PhotoDoodlePlugin.this));
        paramView.setLayoutParams((ViewGroup.LayoutParams)new AbsListView.LayoutParams(paramInt, paramInt));
        if (paramView.getType() != PhotoDoodlePlugin.c(PhotoDoodlePlugin.this)) {
          break label179;
        }
        paramView.setHasSelected(true);
      }
      for (;;)
      {
        paramView = (View)paramView;
        AppMethodBeat.o(75724);
        return paramView;
        Bitmap localBitmap = paramViewGroup.bitmap;
        if (localBitmap == null) {
          k.fvU();
        }
        paramView.setBitmap(localBitmap);
        break;
        label179:
        paramView.setHasSelected(false);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/PhotoDoodlePlugin$Companion;", "", "()V", "BRUSH", "", "COLOR_0", "COLOR_1", "COLOR_2", "COLOR_3", "COLOR_4", "COLOR_5", "COLOR_6", "MSC", "plugin-recordvideo_release"})
  public static final class c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.doodle.PhotoDoodlePlugin
 * JD-Core Version:    0.7.0.1
 */