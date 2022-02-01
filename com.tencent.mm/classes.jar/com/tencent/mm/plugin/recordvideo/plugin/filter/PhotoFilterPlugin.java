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
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.y.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/plugin/filter/PhotoFilterPlugin;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "defaultWeight", "", "getDefaultWeight", "()F", "itemViews", "", "Lcom/tencent/mm/plugin/recordvideo/plugin/filter/PhotoFilterPlugin$ViewHolder;", "getItemViews", "()Ljava/util/List;", "lastSelectedIndex", "", "getLastSelectedIndex", "()I", "setLastSelectedIndex", "(I)V", "progressDescTv", "Landroid/widget/TextView;", "getProgressDescTv", "()Landroid/widget/TextView;", "seekBar", "Landroid/widget/SeekBar;", "getSeekBar", "()Landroid/widget/SeekBar;", "seekBarLayout", "Landroid/view/ViewGroup;", "getSeekBarLayout", "()Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "weightMap", "", "getWeightMap", "()Ljava/util/Map;", "setWeightMap", "(Ljava/util/Map;)V", "onBackPress", "", "postFuncType", "", "index", "colorWeight", "setPreImage", "bitmap", "Landroid/graphics/Bitmap;", "setStatus", "setVisibility", "visibility", "ViewHolder", "plugin-recordvideo_release"})
public final class PhotoFilterPlugin
  extends RelativeLayout
  implements t
{
  private final String TAG;
  private final SeekBar nka;
  private d sQE;
  private final List<a> xCP;
  private final ViewGroup xCQ;
  private final TextView xCR;
  private int xCS;
  private Map<Integer, Float> xCT;
  private final float xCU;
  
  public PhotoFilterPlugin(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(163462);
    this.TAG = "MicroMsg.PhotoFilterPlugin";
    this.xCP = ((List)new ArrayList());
    this.xCT = ((Map)new LinkedHashMap());
    this.xCU = 0.8F;
    LayoutInflater.from(paramContext).inflate(2131495088, (ViewGroup)this, true);
    paramAttributeSet = findViewById(2131304489);
    p.g(paramAttributeSet, "findViewById(R.id.seekbar_layout)");
    this.xCQ = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131299962);
    p.g(paramAttributeSet, "findViewById(R.id.filter_seek_bar)");
    this.nka = ((SeekBar)paramAttributeSet);
    paramAttributeSet = findViewById(2131299963);
    p.g(paramAttributeSet, "findViewById(R.id.filter_seek_bar_desc)");
    this.xCR = ((TextView)paramAttributeSet);
    paramAttributeSet = (d.g.a.b)new b(this);
    this.nka.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)new SeekBar.OnSeekBarChangeListener()
    {
      public final void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(163449);
        ad.d(this.xCV.getTAG(), "onProgressChanged ".concat(String.valueOf(paramAnonymousInt)));
        this.xCV.getProgressDescTv().setText((CharSequence)(paramAnonymousInt + '%'));
        AppMethodBeat.o(163449);
      }
      
      public final void onStartTrackingTouch(SeekBar paramAnonymousSeekBar) {}
      
      public final void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        AppMethodBeat.i(163450);
        PhotoFilterPlugin localPhotoFilterPlugin = this.xCV;
        int i = this.xCV.getLastSelectedIndex();
        if (paramAnonymousSeekBar == null) {
          p.gfZ();
        }
        PhotoFilterPlugin.a(localPhotoFilterPlugin, i, paramAnonymousSeekBar.getProgress() / 100.0F);
        AppMethodBeat.o(163450);
      }
    });
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131303246);
    Object localObject = com.tencent.mm.y.a.gtc;
    localObject = ((Iterable)com.tencent.mm.y.a.agG()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a.a locala = (a.a)((Iterator)localObject).next();
      View localView = LayoutInflater.from(paramContext).inflate(2131495087, (ViewGroup)localLinearLayout, false);
      localLinearLayout.addView(localView);
      List localList = this.xCP;
      p.g(localView, "itemView");
      localList.add(new a(localView, locala.type, locala.name, paramAttributeSet));
    }
    AppMethodBeat.o(163462);
  }
  
  public final boolean aoB()
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
  
  public final void ayX() {}
  
  public final float getDefaultWeight()
  {
    return this.xCU;
  }
  
  public final List<a> getItemViews()
  {
    return this.xCP;
  }
  
  public final int getLastSelectedIndex()
  {
    return this.xCS;
  }
  
  public final TextView getProgressDescTv()
  {
    return this.xCR;
  }
  
  public final SeekBar getSeekBar()
  {
    return this.nka;
  }
  
  public final ViewGroup getSeekBarLayout()
  {
    return this.xCQ;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final Map<Integer, Float> getWeightMap()
  {
    return this.xCT;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(200371);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(200371);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setLastSelectedIndex(int paramInt)
  {
    this.xCS = paramInt;
  }
  
  public final void setPreImage(final Bitmap paramBitmap)
  {
    AppMethodBeat.i(163459);
    p.h(paramBitmap, "bitmap");
    h.LTJ.aR((Runnable)new c(this, paramBitmap));
    AppMethodBeat.o(163459);
  }
  
  public final void setStatus(d paramd)
  {
    AppMethodBeat.i(163458);
    p.h(paramd, "status");
    this.sQE = paramd;
    AppMethodBeat.o(163458);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(163460);
    super.setVisibility(paramInt);
    if (paramInt == 0) {
      ((a)this.xCP.get(this.xCS)).dGD();
    }
    AppMethodBeat.o(163460);
  }
  
  public final void setWeightMap(Map<Integer, Float> paramMap)
  {
    AppMethodBeat.i(163457);
    p.h(paramMap, "<set-?>");
    this.xCT = paramMap;
    AppMethodBeat.o(163457);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/plugin/filter/PhotoFilterPlugin$ViewHolder;", "", "effectLayout", "Landroid/view/View;", "index", "", "effectName", "", "onSelect", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "(Landroid/view/View;ILjava/lang/String;Lkotlin/jvm/functions/Function1;)V", "effectIv", "Landroid/widget/ImageView;", "getEffectIv", "()Landroid/widget/ImageView;", "getEffectLayout", "()Landroid/view/View;", "getEffectName", "()Ljava/lang/String;", "effectTv", "Landroid/widget/TextView;", "getEffectTv", "()Landroid/widget/TextView;", "filtered", "", "getFiltered", "()Z", "setFiltered", "(Z)V", "getIndex", "()I", "maskView", "getMaskView", "getOnSelect", "()Lkotlin/jvm/functions/Function1;", "selected", "setImage", "bitmap", "Landroid/graphics/Bitmap;", "unselected", "plugin-recordvideo_release"})
  public static final class a
  {
    final View gZU;
    final int index;
    final ImageView xCW;
    private final TextView xCX;
    boolean xCY;
    private final View xCZ;
    private final String xDa;
    private final d.g.a.b<Integer, z> xDb;
    
    public a(View paramView, int paramInt, String paramString, d.g.a.b<? super Integer, z> paramb)
    {
      AppMethodBeat.i(163453);
      this.xCZ = paramView;
      this.index = paramInt;
      this.xDa = paramString;
      this.xDb = paramb;
      paramView = this.xCZ.findViewById(2131303245);
      p.g(paramView, "effectLayout.findViewById(R.id.photo_effect_iv)");
      this.xCW = ((ImageView)paramView);
      paramView = this.xCZ.findViewById(2131303247);
      p.g(paramView, "effectLayout.findViewById(R.id.photo_effect_mask)");
      this.gZU = paramView;
      paramView = this.xCZ.findViewById(2131303248);
      p.g(paramView, "effectLayout.findViewByI….id.photo_effect_name_tv)");
      this.xCX = ((TextView)paramView);
      this.xCZ.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(163451);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/filter/PhotoFilterPlugin$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          this.xDc.dGD();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/filter/PhotoFilterPlugin$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(163451);
        }
      });
      this.xCX.setText((CharSequence)this.xDa);
      AppMethodBeat.o(163453);
    }
    
    public final void dGD()
    {
      AppMethodBeat.i(163452);
      this.gZU.setVisibility(8);
      this.xDb.invoke(Integer.valueOf(this.index));
      AppMethodBeat.o(163452);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "index", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.b<Integer, z>
  {
    b(PhotoFilterPlugin paramPhotoFilterPlugin)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(PhotoFilterPlugin paramPhotoFilterPlugin, Bitmap paramBitmap) {}
    
    public final void run()
    {
      AppMethodBeat.i(163456);
      Iterator localIterator = ((Iterable)this.xCV.getItemViews()).iterator();
      while (localIterator.hasNext())
      {
        PhotoFilterPlugin.a locala = (PhotoFilterPlugin.a)localIterator.next();
        if (!locala.xCY)
        {
          Object localObject = com.tencent.mm.y.a.gtc;
          com.tencent.mm.y.a.v(paramBitmap);
          int k = com.tencent.mm.cc.a.ay(this.xCV.getContext(), 2131165301);
          int j = com.tencent.mm.cc.a.ay(this.xCV.getContext(), 2131165301);
          int i;
          if (paramBitmap.getWidth() > paramBitmap.getHeight()) {
            i = (int)(paramBitmap.getWidth() / paramBitmap.getHeight() * j);
          }
          for (;;)
          {
            localObject = com.tencent.mm.y.a.gtc;
            localObject = com.tencent.mm.y.a.a(paramBitmap, locala.index, i, j, this.xCV.getDefaultWeight());
            this.xCV.post((Runnable)new a(locala, (Bitmap)localObject));
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
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(PhotoFilterPlugin.a parama, Bitmap paramBitmap) {}
      
      public final void run()
      {
        AppMethodBeat.i(163455);
        PhotoFilterPlugin.a locala = this.xDd;
        Bitmap localBitmap = this.xDe;
        p.h(localBitmap, "bitmap");
        locala.xCW.setImageBitmap(localBitmap);
        locala.xCY = true;
        AppMethodBeat.o(163455);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.filter.PhotoFilterPlugin
 * JD-Core Version:    0.7.0.1
 */