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
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.x.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/plugin/filter/PhotoFilterPlugin;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "defaultWeight", "", "getDefaultWeight", "()F", "itemViews", "", "Lcom/tencent/mm/plugin/recordvideo/plugin/filter/PhotoFilterPlugin$ViewHolder;", "getItemViews", "()Ljava/util/List;", "lastSelectedIndex", "", "getLastSelectedIndex", "()I", "setLastSelectedIndex", "(I)V", "progressDescTv", "Landroid/widget/TextView;", "getProgressDescTv", "()Landroid/widget/TextView;", "seekBar", "Landroid/widget/SeekBar;", "getSeekBar", "()Landroid/widget/SeekBar;", "seekBarLayout", "Landroid/view/ViewGroup;", "getSeekBarLayout", "()Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "weightMap", "", "getWeightMap", "()Ljava/util/Map;", "setWeightMap", "(Ljava/util/Map;)V", "onBackPress", "", "postFuncType", "", "index", "colorWeight", "setPreImage", "bitmap", "Landroid/graphics/Bitmap;", "setStatus", "setVisibility", "visibility", "ViewHolder", "plugin-recordvideo_release"})
public final class PhotoFilterPlugin
  extends RelativeLayout
  implements t
{
  private final List<a> BTk;
  private final ViewGroup BTl;
  private final TextView BTm;
  private int BTn;
  private Map<Integer, Float> BTo;
  private final float BTp;
  private final String TAG;
  private final SeekBar oyP;
  private d wgr;
  
  public PhotoFilterPlugin(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(163462);
    this.TAG = "MicroMsg.PhotoFilterPlugin";
    this.BTk = ((List)new ArrayList());
    this.BTo = ((Map)new LinkedHashMap());
    this.BTp = 0.8F;
    LayoutInflater.from(paramContext).inflate(2131495926, (ViewGroup)this, true);
    paramAttributeSet = findViewById(2131307491);
    p.g(paramAttributeSet, "findViewById(R.id.seekbar_layout)");
    this.BTl = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131300718);
    p.g(paramAttributeSet, "findViewById(R.id.filter_seek_bar)");
    this.oyP = ((SeekBar)paramAttributeSet);
    paramAttributeSet = findViewById(2131300719);
    p.g(paramAttributeSet, "findViewById(R.id.filter_seek_bar_desc)");
    this.BTm = ((TextView)paramAttributeSet);
    paramAttributeSet = (kotlin.g.a.b)new b(this);
    this.oyP.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)new SeekBar.OnSeekBarChangeListener()
    {
      public final void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(163449);
        Log.d(this.BTq.getTAG(), "onProgressChanged ".concat(String.valueOf(paramAnonymousInt)));
        this.BTq.getProgressDescTv().setText((CharSequence)(paramAnonymousInt + '%'));
        AppMethodBeat.o(163449);
      }
      
      public final void onStartTrackingTouch(SeekBar paramAnonymousSeekBar) {}
      
      public final void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        AppMethodBeat.i(163450);
        PhotoFilterPlugin localPhotoFilterPlugin = this.BTq;
        int i = this.BTq.getLastSelectedIndex();
        if (paramAnonymousSeekBar == null) {
          p.hyc();
        }
        PhotoFilterPlugin.a(localPhotoFilterPlugin, i, paramAnonymousSeekBar.getProgress() / 100.0F);
        AppMethodBeat.o(163450);
      }
    });
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131305915);
    Object localObject = com.tencent.mm.x.a.hiy;
    localObject = ((Iterable)com.tencent.mm.x.a.axh()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a.a locala = (a.a)((Iterator)localObject).next();
      View localView = LayoutInflater.from(paramContext).inflate(2131495925, (ViewGroup)localLinearLayout, false);
      localLinearLayout.addView(localView);
      List localList = this.BTk;
      p.g(localView, "itemView");
      localList.add(new a(localView, locala.type, locala.name, paramAttributeSet));
    }
    AppMethodBeat.o(163462);
  }
  
  public final void aSs() {}
  
  public final float getDefaultWeight()
  {
    return this.BTp;
  }
  
  public final List<a> getItemViews()
  {
    return this.BTk;
  }
  
  public final int getLastSelectedIndex()
  {
    return this.BTn;
  }
  
  public final TextView getProgressDescTv()
  {
    return this.BTm;
  }
  
  public final SeekBar getSeekBar()
  {
    return this.oyP;
  }
  
  public final ViewGroup getSeekBarLayout()
  {
    return this.BTl;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final Map<Integer, Float> getWeightMap()
  {
    return this.BTo;
  }
  
  public final String name()
  {
    return null;
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
    AppMethodBeat.i(237397);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(237397);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setLastSelectedIndex(int paramInt)
  {
    this.BTn = paramInt;
  }
  
  public final void setPreImage(final Bitmap paramBitmap)
  {
    AppMethodBeat.i(163459);
    p.h(paramBitmap, "bitmap");
    h.RTc.aX((Runnable)new c(this, paramBitmap));
    AppMethodBeat.o(163459);
  }
  
  public final void setStatus(d paramd)
  {
    AppMethodBeat.i(163458);
    p.h(paramd, "status");
    this.wgr = paramd;
    AppMethodBeat.o(163458);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(163460);
    super.setVisibility(paramInt);
    if (paramInt == 0) {
      ((a)this.BTk.get(this.BTn)).eKO();
    }
    AppMethodBeat.o(163460);
  }
  
  public final void setWeightMap(Map<Integer, Float> paramMap)
  {
    AppMethodBeat.i(163457);
    p.h(paramMap, "<set-?>");
    this.BTo = paramMap;
    AppMethodBeat.o(163457);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/plugin/filter/PhotoFilterPlugin$ViewHolder;", "", "effectLayout", "Landroid/view/View;", "index", "", "effectName", "", "onSelect", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "(Landroid/view/View;ILjava/lang/String;Lkotlin/jvm/functions/Function1;)V", "effectIv", "Landroid/widget/ImageView;", "getEffectIv", "()Landroid/widget/ImageView;", "getEffectLayout", "()Landroid/view/View;", "getEffectName", "()Ljava/lang/String;", "effectTv", "Landroid/widget/TextView;", "getEffectTv", "()Landroid/widget/TextView;", "filtered", "", "getFiltered", "()Z", "setFiltered", "(Z)V", "getIndex", "()I", "maskView", "getMaskView", "getOnSelect", "()Lkotlin/jvm/functions/Function1;", "selected", "setImage", "bitmap", "Landroid/graphics/Bitmap;", "unselected", "plugin-recordvideo_release"})
  public static final class a
  {
    final ImageView BTr;
    private final TextView BTs;
    boolean BTt;
    private final View BTu;
    private final String BTv;
    private final kotlin.g.a.b<Integer, x> BTw;
    final int index;
    final View maskView;
    
    public a(View paramView, int paramInt, String paramString, kotlin.g.a.b<? super Integer, x> paramb)
    {
      AppMethodBeat.i(163453);
      this.BTu = paramView;
      this.index = paramInt;
      this.BTv = paramString;
      this.BTw = paramb;
      paramView = this.BTu.findViewById(2131305914);
      p.g(paramView, "effectLayout.findViewById(R.id.photo_effect_iv)");
      this.BTr = ((ImageView)paramView);
      paramView = this.BTu.findViewById(2131305916);
      p.g(paramView, "effectLayout.findViewById(R.id.photo_effect_mask)");
      this.maskView = paramView;
      paramView = this.BTu.findViewById(2131305917);
      p.g(paramView, "effectLayout.findViewByI….id.photo_effect_name_tv)");
      this.BTs = ((TextView)paramView);
      this.BTu.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(163451);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/filter/PhotoFilterPlugin$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          this.BTx.eKO();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/filter/PhotoFilterPlugin$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(163451);
        }
      });
      this.BTs.setText((CharSequence)this.BTv);
      AppMethodBeat.o(163453);
    }
    
    public final void eKO()
    {
      AppMethodBeat.i(163452);
      this.maskView.setVisibility(8);
      this.BTw.invoke(Integer.valueOf(this.index));
      AppMethodBeat.o(163452);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "index", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<Integer, x>
  {
    b(PhotoFilterPlugin paramPhotoFilterPlugin)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(PhotoFilterPlugin paramPhotoFilterPlugin, Bitmap paramBitmap) {}
    
    public final void run()
    {
      AppMethodBeat.i(163456);
      Iterator localIterator = ((Iterable)this.BTq.getItemViews()).iterator();
      while (localIterator.hasNext())
      {
        PhotoFilterPlugin.a locala = (PhotoFilterPlugin.a)localIterator.next();
        if (!locala.BTt)
        {
          Object localObject = com.tencent.mm.x.a.hiy;
          com.tencent.mm.x.a.A(paramBitmap);
          int k = com.tencent.mm.cb.a.aH(this.BTq.getContext(), 2131165312);
          int j = com.tencent.mm.cb.a.aH(this.BTq.getContext(), 2131165312);
          int i;
          if (paramBitmap.getWidth() > paramBitmap.getHeight()) {
            i = (int)(paramBitmap.getWidth() / paramBitmap.getHeight() * j);
          }
          for (;;)
          {
            localObject = com.tencent.mm.x.a.hiy;
            localObject = com.tencent.mm.x.a.a(paramBitmap, locala.index, i, j, this.BTq.getDefaultWeight());
            this.BTq.post((Runnable)new a(locala, (Bitmap)localObject));
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
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(PhotoFilterPlugin.a parama, Bitmap paramBitmap) {}
      
      public final void run()
      {
        AppMethodBeat.i(163455);
        PhotoFilterPlugin.a locala = this.BTy;
        Bitmap localBitmap = this.BTz;
        p.h(localBitmap, "bitmap");
        locala.BTr.setImageBitmap(localBitmap);
        locala.BTt = true;
        AppMethodBeat.o(163455);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.filter.PhotoFilterPlugin
 * JD-Core Version:    0.7.0.1
 */