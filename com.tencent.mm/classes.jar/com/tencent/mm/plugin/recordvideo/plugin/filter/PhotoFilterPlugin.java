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
import com.tencent.mm.plugin.recordvideo.b.c;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.u;
import com.tencent.mm.plugin.recordvideo.plugin.u.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.z.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/filter/PhotoFilterPlugin;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "defaultWeight", "", "getDefaultWeight", "()F", "itemViews", "", "Lcom/tencent/mm/plugin/recordvideo/plugin/filter/PhotoFilterPlugin$ViewHolder;", "getItemViews", "()Ljava/util/List;", "lastSelectedIndex", "", "getLastSelectedIndex", "()I", "setLastSelectedIndex", "(I)V", "progressDescTv", "Landroid/widget/TextView;", "getProgressDescTv", "()Landroid/widget/TextView;", "seekBar", "Landroid/widget/SeekBar;", "getSeekBar", "()Landroid/widget/SeekBar;", "seekBarLayout", "Landroid/view/ViewGroup;", "getSeekBarLayout", "()Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "weightMap", "", "getWeightMap", "()Ljava/util/Map;", "setWeightMap", "(Ljava/util/Map;)V", "onBackPress", "", "postFuncType", "", "index", "colorWeight", "setPreImage", "bitmap", "Landroid/graphics/Bitmap;", "setStatus", "setVisibility", "visibility", "ViewHolder", "plugin-recordvideo_release"})
public final class PhotoFilterPlugin
  extends RelativeLayout
  implements u
{
  private d APl;
  private final List<a> HPY;
  private final ViewGroup HPZ;
  private final TextView HQa;
  private int HQb;
  private Map<Integer, Float> HQc;
  private final float HQd;
  private final String TAG;
  private final SeekBar rBx;
  
  public PhotoFilterPlugin(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(163462);
    this.TAG = "MicroMsg.PhotoFilterPlugin";
    this.HPY = ((List)new ArrayList());
    this.HQc = ((Map)new LinkedHashMap());
    this.HQd = 0.8F;
    LayoutInflater.from(paramContext).inflate(b.f.photo_filter_layout, (ViewGroup)this, true);
    paramAttributeSet = findViewById(b.e.seekbar_layout);
    p.j(paramAttributeSet, "findViewById(R.id.seekbar_layout)");
    this.HPZ = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(b.e.filter_seek_bar);
    p.j(paramAttributeSet, "findViewById(R.id.filter_seek_bar)");
    this.rBx = ((SeekBar)paramAttributeSet);
    paramAttributeSet = findViewById(b.e.filter_seek_bar_desc);
    p.j(paramAttributeSet, "findViewById(R.id.filter_seek_bar_desc)");
    this.HQa = ((TextView)paramAttributeSet);
    paramAttributeSet = (kotlin.g.a.b)new b(this);
    this.rBx.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)new SeekBar.OnSeekBarChangeListener()
    {
      public final void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(163449);
        Log.d(this.HQe.getTAG(), "onProgressChanged ".concat(String.valueOf(paramAnonymousInt)));
        this.HQe.getProgressDescTv().setText((CharSequence)(paramAnonymousInt + '%'));
        AppMethodBeat.o(163449);
      }
      
      public final void onStartTrackingTouch(SeekBar paramAnonymousSeekBar) {}
      
      public final void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        AppMethodBeat.i(163450);
        PhotoFilterPlugin localPhotoFilterPlugin = this.HQe;
        int i = this.HQe.getLastSelectedIndex();
        if (paramAnonymousSeekBar == null) {
          p.iCn();
        }
        PhotoFilterPlugin.a(localPhotoFilterPlugin, i, paramAnonymousSeekBar.getProgress() / 100.0F);
        AppMethodBeat.o(163450);
      }
    });
    LinearLayout localLinearLayout = (LinearLayout)findViewById(b.e.photo_effect_list_layout);
    Object localObject = com.tencent.mm.z.a.jUw;
    localObject = ((Iterable)com.tencent.mm.z.a.aEE()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a.a locala = (a.a)((Iterator)localObject).next();
      View localView = LayoutInflater.from(paramContext).inflate(b.f.photo_filter_choose_effect_item, (ViewGroup)localLinearLayout, false);
      localLinearLayout.addView(localView);
      List localList = this.HPY;
      p.j(localView, "itemView");
      localList.add(new a(localView, locala.type, locala.name, paramAttributeSet));
    }
    AppMethodBeat.o(163462);
  }
  
  public final void bbp() {}
  
  public final float getDefaultWeight()
  {
    return this.HQd;
  }
  
  public final List<a> getItemViews()
  {
    return this.HPY;
  }
  
  public final int getLastSelectedIndex()
  {
    return this.HQb;
  }
  
  public final TextView getProgressDescTv()
  {
    return this.HQa;
  }
  
  public final SeekBar getSeekBar()
  {
    return this.rBx;
  }
  
  public final ViewGroup getSeekBarLayout()
  {
    return this.HPZ;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final Map<Integer, Float> getWeightMap()
  {
    return this.HQc;
  }
  
  public final String name()
  {
    AppMethodBeat.i(219705);
    String str = getClass().getName();
    AppMethodBeat.o(219705);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
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
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(219710);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    u.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(219710);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setLastSelectedIndex(int paramInt)
  {
    this.HQb = paramInt;
  }
  
  public final void setPreImage(final Bitmap paramBitmap)
  {
    AppMethodBeat.i(163459);
    p.k(paramBitmap, "bitmap");
    h.ZvG.be((Runnable)new c(this, paramBitmap));
    AppMethodBeat.o(163459);
  }
  
  public final void setStatus(d paramd)
  {
    AppMethodBeat.i(163458);
    p.k(paramd, "status");
    this.APl = paramd;
    AppMethodBeat.o(163458);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(163460);
    super.setVisibility(paramInt);
    if (paramInt == 0) {
      ((a)this.HPY.get(this.HQb)).fxi();
    }
    AppMethodBeat.o(163460);
  }
  
  public final void setWeightMap(Map<Integer, Float> paramMap)
  {
    AppMethodBeat.i(163457);
    p.k(paramMap, "<set-?>");
    this.HQc = paramMap;
    AppMethodBeat.o(163457);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/filter/PhotoFilterPlugin$ViewHolder;", "", "effectLayout", "Landroid/view/View;", "index", "", "effectName", "", "onSelect", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "(Landroid/view/View;ILjava/lang/String;Lkotlin/jvm/functions/Function1;)V", "effectIv", "Landroid/widget/ImageView;", "getEffectIv", "()Landroid/widget/ImageView;", "getEffectLayout", "()Landroid/view/View;", "getEffectName", "()Ljava/lang/String;", "effectTv", "Landroid/widget/TextView;", "getEffectTv", "()Landroid/widget/TextView;", "filtered", "", "getFiltered", "()Z", "setFiltered", "(Z)V", "getIndex", "()I", "maskView", "getMaskView", "getOnSelect", "()Lkotlin/jvm/functions/Function1;", "selected", "setImage", "bitmap", "Landroid/graphics/Bitmap;", "unselected", "plugin-recordvideo_release"})
  public static final class a
  {
    final ImageView HQf;
    private final TextView HQg;
    boolean HQh;
    private final View HQi;
    private final String HQj;
    private final kotlin.g.a.b<Integer, x> HQk;
    final int index;
    final View maskView;
    
    public a(View paramView, int paramInt, String paramString, kotlin.g.a.b<? super Integer, x> paramb)
    {
      AppMethodBeat.i(163453);
      this.HQi = paramView;
      this.index = paramInt;
      this.HQj = paramString;
      this.HQk = paramb;
      paramView = this.HQi.findViewById(b.e.photo_effect_iv);
      p.j(paramView, "effectLayout.findViewById(R.id.photo_effect_iv)");
      this.HQf = ((ImageView)paramView);
      paramView = this.HQi.findViewById(b.e.photo_effect_mask);
      p.j(paramView, "effectLayout.findViewById(R.id.photo_effect_mask)");
      this.maskView = paramView;
      paramView = this.HQi.findViewById(b.e.photo_effect_name_tv);
      p.j(paramView, "effectLayout.findViewByI….id.photo_effect_name_tv)");
      this.HQg = ((TextView)paramView);
      this.HQi.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(163451);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/plugin/filter/PhotoFilterPlugin$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          this.HQl.fxi();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/filter/PhotoFilterPlugin$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(163451);
        }
      });
      this.HQg.setText((CharSequence)this.HQj);
      AppMethodBeat.o(163453);
    }
    
    public final void fxi()
    {
      AppMethodBeat.i(163452);
      this.maskView.setVisibility(8);
      this.HQk.invoke(Integer.valueOf(this.index));
      AppMethodBeat.o(163452);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "index", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<Integer, x>
  {
    b(PhotoFilterPlugin paramPhotoFilterPlugin)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(PhotoFilterPlugin paramPhotoFilterPlugin, Bitmap paramBitmap) {}
    
    public final void run()
    {
      AppMethodBeat.i(163456);
      Iterator localIterator = ((Iterable)this.HQe.getItemViews()).iterator();
      while (localIterator.hasNext())
      {
        PhotoFilterPlugin.a locala = (PhotoFilterPlugin.a)localIterator.next();
        if (!locala.HQh)
        {
          Object localObject = com.tencent.mm.z.a.jUw;
          com.tencent.mm.z.a.v(paramBitmap);
          int k = com.tencent.mm.ci.a.aZ(this.HQe.getContext(), b.c.Edge_8A);
          int j = com.tencent.mm.ci.a.aZ(this.HQe.getContext(), b.c.Edge_8A);
          int i;
          if (paramBitmap.getWidth() > paramBitmap.getHeight()) {
            i = (int)(paramBitmap.getWidth() / paramBitmap.getHeight() * j);
          }
          for (;;)
          {
            localObject = com.tencent.mm.z.a.jUw;
            localObject = com.tencent.mm.z.a.a(paramBitmap, locala.index, i, j, this.HQe.getDefaultWeight());
            this.HQe.post((Runnable)new a(locala, (Bitmap)localObject));
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
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(PhotoFilterPlugin.a parama, Bitmap paramBitmap) {}
      
      public final void run()
      {
        AppMethodBeat.i(163455);
        PhotoFilterPlugin.a locala = this.HQm;
        Bitmap localBitmap = this.HQn;
        p.k(localBitmap, "bitmap");
        locala.HQf.setImageBitmap(localBitmap);
        locala.HQh = true;
        AppMethodBeat.o(163455);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.filter.PhotoFilterPlugin
 * JD-Core Version:    0.7.0.1
 */