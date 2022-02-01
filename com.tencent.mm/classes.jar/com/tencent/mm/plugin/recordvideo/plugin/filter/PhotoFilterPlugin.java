package com.tencent.mm.plugin.recordvideo.plugin.filter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.x.a.a;
import d.g.a.b;
import d.g.b.k;
import d.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/plugin/filter/PhotoFilterPlugin;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "defaultWeight", "", "getDefaultWeight", "()F", "itemViews", "", "Lcom/tencent/mm/plugin/recordvideo/plugin/filter/PhotoFilterPlugin$ViewHolder;", "getItemViews", "()Ljava/util/List;", "lastSelectedIndex", "", "getLastSelectedIndex", "()I", "setLastSelectedIndex", "(I)V", "progressDescTv", "Landroid/widget/TextView;", "getProgressDescTv", "()Landroid/widget/TextView;", "seekBar", "Landroid/widget/SeekBar;", "getSeekBar", "()Landroid/widget/SeekBar;", "seekBarLayout", "Landroid/view/ViewGroup;", "getSeekBarLayout", "()Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "weightMap", "", "getWeightMap", "()Ljava/util/Map;", "setWeightMap", "(Ljava/util/Map;)V", "onBackPress", "", "postFuncType", "", "index", "colorWeight", "setPreImage", "bitmap", "Landroid/graphics/Bitmap;", "setStatus", "setVisibility", "visibility", "ViewHolder", "plugin-recordvideo_release"})
public final class PhotoFilterPlugin
  extends RelativeLayout
  implements t
{
  private final String TAG;
  private final SeekBar mJE;
  private d rTT;
  private final List<a> wuT;
  private final ViewGroup wuU;
  private final TextView wuV;
  private int wuW;
  private Map<Integer, Float> wuX;
  private final float wuY;
  
  public PhotoFilterPlugin(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(163462);
    this.TAG = "MicroMsg.PhotoFilterPlugin";
    this.wuT = ((List)new ArrayList());
    this.wuX = ((Map)new LinkedHashMap());
    this.wuY = 0.8F;
    LayoutInflater.from(paramContext).inflate(2131495088, (ViewGroup)this, true);
    paramAttributeSet = findViewById(2131304489);
    k.g(paramAttributeSet, "findViewById(R.id.seekbar_layout)");
    this.wuU = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131299962);
    k.g(paramAttributeSet, "findViewById(R.id.filter_seek_bar)");
    this.mJE = ((SeekBar)paramAttributeSet);
    paramAttributeSet = findViewById(2131299963);
    k.g(paramAttributeSet, "findViewById(R.id.filter_seek_bar_desc)");
    this.wuV = ((TextView)paramAttributeSet);
    paramAttributeSet = (b)new b(this);
    this.mJE.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)new SeekBar.OnSeekBarChangeListener()
    {
      public final void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(163449);
        ac.d(this.wuZ.getTAG(), "onProgressChanged ".concat(String.valueOf(paramAnonymousInt)));
        this.wuZ.getProgressDescTv().setText((CharSequence)(paramAnonymousInt + '%'));
        AppMethodBeat.o(163449);
      }
      
      public final void onStartTrackingTouch(SeekBar paramAnonymousSeekBar) {}
      
      public final void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        AppMethodBeat.i(163450);
        PhotoFilterPlugin localPhotoFilterPlugin = this.wuZ;
        int i = this.wuZ.getLastSelectedIndex();
        if (paramAnonymousSeekBar == null) {
          k.fOy();
        }
        PhotoFilterPlugin.a(localPhotoFilterPlugin, i, paramAnonymousSeekBar.getProgress() / 100.0F);
        AppMethodBeat.o(163450);
      }
    });
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131303246);
    Object localObject = com.tencent.mm.x.a.fZG;
    localObject = ((Iterable)com.tencent.mm.x.a.aeb()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a.a locala = (a.a)((Iterator)localObject).next();
      View localView = LayoutInflater.from(paramContext).inflate(2131495087, (ViewGroup)localLinearLayout, false);
      localLinearLayout.addView(localView);
      List localList = this.wuT;
      k.g(localView, "itemView");
      localList.add(new a(localView, locala.type, locala.name, paramAttributeSet));
    }
    AppMethodBeat.o(163462);
  }
  
  public final boolean alO()
  {
    AppMethodBeat.i(163461);
    if (getVisibility() == 0)
    {
      setVisibility(8);
      AppMethodBeat.o(163461);
      return true;
    }
    AppMethodBeat.o(163461);
    return false;
  }
  
  public final void awk() {}
  
  public final float getDefaultWeight()
  {
    return this.wuY;
  }
  
  public final List<a> getItemViews()
  {
    return this.wuT;
  }
  
  public final int getLastSelectedIndex()
  {
    return this.wuW;
  }
  
  public final TextView getProgressDescTv()
  {
    return this.wuV;
  }
  
  public final SeekBar getSeekBar()
  {
    return this.mJE;
  }
  
  public final ViewGroup getSeekBarLayout()
  {
    return this.wuU;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final Map<Integer, Float> getWeightMap()
  {
    return this.wuX;
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
  
  public final void setLastSelectedIndex(int paramInt)
  {
    this.wuW = paramInt;
  }
  
  public final void setPreImage(final Bitmap paramBitmap)
  {
    AppMethodBeat.i(163459);
    k.h(paramBitmap, "bitmap");
    h.JZN.aS((Runnable)new c(this, paramBitmap));
    AppMethodBeat.o(163459);
  }
  
  public final void setStatus(d paramd)
  {
    AppMethodBeat.i(163458);
    k.h(paramd, "status");
    this.rTT = paramd;
    AppMethodBeat.o(163458);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(163460);
    super.setVisibility(paramInt);
    if (paramInt == 0) {
      ((a)this.wuT.get(this.wuW)).dwh();
    }
    AppMethodBeat.o(163460);
  }
  
  public final void setWeightMap(Map<Integer, Float> paramMap)
  {
    AppMethodBeat.i(163457);
    k.h(paramMap, "<set-?>");
    this.wuX = paramMap;
    AppMethodBeat.o(163457);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/plugin/filter/PhotoFilterPlugin$ViewHolder;", "", "effectLayout", "Landroid/view/View;", "index", "", "effectName", "", "onSelect", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "(Landroid/view/View;ILjava/lang/String;Lkotlin/jvm/functions/Function1;)V", "effectIv", "Landroid/widget/ImageView;", "getEffectIv", "()Landroid/widget/ImageView;", "getEffectLayout", "()Landroid/view/View;", "getEffectName", "()Ljava/lang/String;", "effectTv", "Landroid/widget/TextView;", "getEffectTv", "()Landroid/widget/TextView;", "filtered", "", "getFiltered", "()Z", "setFiltered", "(Z)V", "getIndex", "()I", "maskView", "getMaskView", "getOnSelect", "()Lkotlin/jvm/functions/Function1;", "selected", "setImage", "bitmap", "Landroid/graphics/Bitmap;", "unselected", "plugin-recordvideo_release"})
  public static final class a
  {
    final View gGk;
    final int index;
    final ImageView wva;
    private final TextView wvb;
    boolean wvc;
    private final View wvd;
    private final String wve;
    private final b<Integer, y> wvf;
    
    public a(View paramView, int paramInt, String paramString, b<? super Integer, y> paramb)
    {
      AppMethodBeat.i(163453);
      this.wvd = paramView;
      this.index = paramInt;
      this.wve = paramString;
      this.wvf = paramb;
      paramView = this.wvd.findViewById(2131303245);
      k.g(paramView, "effectLayout.findViewById(R.id.photo_effect_iv)");
      this.wva = ((ImageView)paramView);
      paramView = this.wvd.findViewById(2131303247);
      k.g(paramView, "effectLayout.findViewById(R.id.photo_effect_mask)");
      this.gGk = paramView;
      paramView = this.wvd.findViewById(2131303248);
      k.g(paramView, "effectLayout.findViewByI….id.photo_effect_name_tv)");
      this.wvb = ((TextView)paramView);
      this.wvd.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(163451);
          this.wvg.dwh();
          AppMethodBeat.o(163451);
        }
      });
      this.wvb.setText((CharSequence)this.wve);
      AppMethodBeat.o(163453);
    }
    
    public final void dwh()
    {
      AppMethodBeat.i(163452);
      this.gGk.setVisibility(8);
      this.wvf.ay(Integer.valueOf(this.index));
      AppMethodBeat.o(163452);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "index", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements b<Integer, y>
  {
    b(PhotoFilterPlugin paramPhotoFilterPlugin)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(PhotoFilterPlugin paramPhotoFilterPlugin, Bitmap paramBitmap) {}
    
    public final void run()
    {
      AppMethodBeat.i(163456);
      Iterator localIterator = ((Iterable)this.wuZ.getItemViews()).iterator();
      while (localIterator.hasNext())
      {
        PhotoFilterPlugin.a locala = (PhotoFilterPlugin.a)localIterator.next();
        if (!locala.wvc)
        {
          Object localObject = com.tencent.mm.x.a.fZG;
          com.tencent.mm.x.a.v(paramBitmap);
          int k = com.tencent.mm.cc.a.av(this.wuZ.getContext(), 2131165301);
          int j = com.tencent.mm.cc.a.av(this.wuZ.getContext(), 2131165301);
          int i;
          if (paramBitmap.getWidth() > paramBitmap.getHeight()) {
            i = (int)(paramBitmap.getWidth() / paramBitmap.getHeight() * j);
          }
          for (;;)
          {
            localObject = com.tencent.mm.x.a.fZG;
            localObject = com.tencent.mm.x.a.a(paramBitmap, locala.index, i, j, this.wuZ.getDefaultWeight());
            this.wuZ.post((Runnable)new a(locala, (Bitmap)localObject));
            break;
            i = k;
            if (paramBitmap.getWidth() < paramBitmap.getHeight())
            {
              j = (int)(paramBitmap.getHeight() / paramBitmap.getWidth() * k);
              i = k;
            }
          }
        }
      }
      AppMethodBeat.o(163456);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(PhotoFilterPlugin.a parama, Bitmap paramBitmap) {}
      
      public final void run()
      {
        AppMethodBeat.i(163455);
        PhotoFilterPlugin.a locala = this.wvh;
        Bitmap localBitmap = this.wvi;
        k.h(localBitmap, "bitmap");
        locala.wva.setImageBitmap(localBitmap);
        locala.wvc = true;
        AppMethodBeat.o(163455);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.filter.PhotoFilterPlugin
 * JD-Core Version:    0.7.0.1
 */