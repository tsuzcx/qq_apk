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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.x.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/plugin/filter/PhotoFilterPlugin;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "defaultWeight", "", "getDefaultWeight", "()F", "itemViews", "", "Lcom/tencent/mm/plugin/recordvideo/plugin/filter/PhotoFilterPlugin$ViewHolder;", "getItemViews", "()Ljava/util/List;", "lastSelectedIndex", "", "getLastSelectedIndex", "()I", "setLastSelectedIndex", "(I)V", "progressDescTv", "Landroid/widget/TextView;", "getProgressDescTv", "()Landroid/widget/TextView;", "seekBar", "Landroid/widget/SeekBar;", "getSeekBar", "()Landroid/widget/SeekBar;", "seekBarLayout", "Landroid/view/ViewGroup;", "getSeekBarLayout", "()Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "weightMap", "", "getWeightMap", "()Ljava/util/Map;", "setWeightMap", "(Ljava/util/Map;)V", "onBackPress", "", "postFuncType", "", "index", "colorWeight", "setPreImage", "bitmap", "Landroid/graphics/Bitmap;", "setStatus", "setVisibility", "visibility", "ViewHolder", "plugin-recordvideo_release"})
public final class PhotoFilterPlugin
  extends RelativeLayout
  implements t
{
  private final String TAG;
  private final SeekBar npi;
  private d tbP;
  private final List<a> xSK;
  private final ViewGroup xSL;
  private final TextView xSM;
  private int xSN;
  private Map<Integer, Float> xSO;
  private final float xSP;
  
  public PhotoFilterPlugin(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(163462);
    this.TAG = "MicroMsg.PhotoFilterPlugin";
    this.xSK = ((List)new ArrayList());
    this.xSO = ((Map)new LinkedHashMap());
    this.xSP = 0.8F;
    LayoutInflater.from(paramContext).inflate(2131495088, (ViewGroup)this, true);
    paramAttributeSet = findViewById(2131304489);
    p.g(paramAttributeSet, "findViewById(R.id.seekbar_layout)");
    this.xSL = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131299962);
    p.g(paramAttributeSet, "findViewById(R.id.filter_seek_bar)");
    this.npi = ((SeekBar)paramAttributeSet);
    paramAttributeSet = findViewById(2131299963);
    p.g(paramAttributeSet, "findViewById(R.id.filter_seek_bar_desc)");
    this.xSM = ((TextView)paramAttributeSet);
    paramAttributeSet = (d.g.a.b)new b(this);
    this.npi.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)new SeekBar.OnSeekBarChangeListener()
    {
      public final void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(163449);
        ae.d(this.xSQ.getTAG(), "onProgressChanged ".concat(String.valueOf(paramAnonymousInt)));
        this.xSQ.getProgressDescTv().setText((CharSequence)(paramAnonymousInt + '%'));
        AppMethodBeat.o(163449);
      }
      
      public final void onStartTrackingTouch(SeekBar paramAnonymousSeekBar) {}
      
      public final void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        AppMethodBeat.i(163450);
        PhotoFilterPlugin localPhotoFilterPlugin = this.xSQ;
        int i = this.xSQ.getLastSelectedIndex();
        if (paramAnonymousSeekBar == null) {
          p.gkB();
        }
        PhotoFilterPlugin.a(localPhotoFilterPlugin, i, paramAnonymousSeekBar.getProgress() / 100.0F);
        AppMethodBeat.o(163450);
      }
    });
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131303246);
    Object localObject = com.tencent.mm.x.a.gvJ;
    localObject = ((Iterable)com.tencent.mm.x.a.agV()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a.a locala = (a.a)((Iterator)localObject).next();
      View localView = LayoutInflater.from(paramContext).inflate(2131495087, (ViewGroup)localLinearLayout, false);
      localLinearLayout.addView(localView);
      List localList = this.xSK;
      p.g(localView, "itemView");
      localList.add(new a(localView, locala.type, locala.name, paramAttributeSet));
    }
    AppMethodBeat.o(163462);
  }
  
  public final boolean aoQ()
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
  
  public final void azm() {}
  
  public final float getDefaultWeight()
  {
    return this.xSP;
  }
  
  public final List<a> getItemViews()
  {
    return this.xSK;
  }
  
  public final int getLastSelectedIndex()
  {
    return this.xSN;
  }
  
  public final TextView getProgressDescTv()
  {
    return this.xSM;
  }
  
  public final SeekBar getSeekBar()
  {
    return this.npi;
  }
  
  public final ViewGroup getSeekBarLayout()
  {
    return this.xSL;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final Map<Integer, Float> getWeightMap()
  {
    return this.xSO;
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
    AppMethodBeat.i(206632);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(206632);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setLastSelectedIndex(int paramInt)
  {
    this.xSN = paramInt;
  }
  
  public final void setPreImage(final Bitmap paramBitmap)
  {
    AppMethodBeat.i(163459);
    p.h(paramBitmap, "bitmap");
    h.MqF.aO((Runnable)new c(this, paramBitmap));
    AppMethodBeat.o(163459);
  }
  
  public final void setStatus(d paramd)
  {
    AppMethodBeat.i(163458);
    p.h(paramd, "status");
    this.tbP = paramd;
    AppMethodBeat.o(163458);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(163460);
    super.setVisibility(paramInt);
    if (paramInt == 0) {
      ((a)this.xSK.get(this.xSN)).dJU();
    }
    AppMethodBeat.o(163460);
  }
  
  public final void setWeightMap(Map<Integer, Float> paramMap)
  {
    AppMethodBeat.i(163457);
    p.h(paramMap, "<set-?>");
    this.xSO = paramMap;
    AppMethodBeat.o(163457);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/plugin/filter/PhotoFilterPlugin$ViewHolder;", "", "effectLayout", "Landroid/view/View;", "index", "", "effectName", "", "onSelect", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "(Landroid/view/View;ILjava/lang/String;Lkotlin/jvm/functions/Function1;)V", "effectIv", "Landroid/widget/ImageView;", "getEffectIv", "()Landroid/widget/ImageView;", "getEffectLayout", "()Landroid/view/View;", "getEffectName", "()Ljava/lang/String;", "effectTv", "Landroid/widget/TextView;", "getEffectTv", "()Landroid/widget/TextView;", "filtered", "", "getFiltered", "()Z", "setFiltered", "(Z)V", "getIndex", "()I", "maskView", "getMaskView", "getOnSelect", "()Lkotlin/jvm/functions/Function1;", "selected", "setImage", "bitmap", "Landroid/graphics/Bitmap;", "unselected", "plugin-recordvideo_release"})
  public static final class a
  {
    final View hcH;
    final int index;
    final ImageView xSR;
    private final TextView xSS;
    boolean xST;
    private final View xSU;
    private final String xSV;
    private final d.g.a.b<Integer, z> xSW;
    
    public a(View paramView, int paramInt, String paramString, d.g.a.b<? super Integer, z> paramb)
    {
      AppMethodBeat.i(163453);
      this.xSU = paramView;
      this.index = paramInt;
      this.xSV = paramString;
      this.xSW = paramb;
      paramView = this.xSU.findViewById(2131303245);
      p.g(paramView, "effectLayout.findViewById(R.id.photo_effect_iv)");
      this.xSR = ((ImageView)paramView);
      paramView = this.xSU.findViewById(2131303247);
      p.g(paramView, "effectLayout.findViewById(R.id.photo_effect_mask)");
      this.hcH = paramView;
      paramView = this.xSU.findViewById(2131303248);
      p.g(paramView, "effectLayout.findViewByI….id.photo_effect_name_tv)");
      this.xSS = ((TextView)paramView);
      this.xSU.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(163451);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/filter/PhotoFilterPlugin$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          this.xSX.dJU();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/filter/PhotoFilterPlugin$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(163451);
        }
      });
      this.xSS.setText((CharSequence)this.xSV);
      AppMethodBeat.o(163453);
    }
    
    public final void dJU()
    {
      AppMethodBeat.i(163452);
      this.hcH.setVisibility(8);
      this.xSW.invoke(Integer.valueOf(this.index));
      AppMethodBeat.o(163452);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "index", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.b<Integer, z>
  {
    b(PhotoFilterPlugin paramPhotoFilterPlugin)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(PhotoFilterPlugin paramPhotoFilterPlugin, Bitmap paramBitmap) {}
    
    public final void run()
    {
      AppMethodBeat.i(163456);
      Iterator localIterator = ((Iterable)this.xSQ.getItemViews()).iterator();
      while (localIterator.hasNext())
      {
        PhotoFilterPlugin.a locala = (PhotoFilterPlugin.a)localIterator.next();
        if (!locala.xST)
        {
          Object localObject = com.tencent.mm.x.a.gvJ;
          com.tencent.mm.x.a.w(paramBitmap);
          int k = com.tencent.mm.cb.a.ay(this.xSQ.getContext(), 2131165301);
          int j = com.tencent.mm.cb.a.ay(this.xSQ.getContext(), 2131165301);
          int i;
          if (paramBitmap.getWidth() > paramBitmap.getHeight()) {
            i = (int)(paramBitmap.getWidth() / paramBitmap.getHeight() * j);
          }
          for (;;)
          {
            localObject = com.tencent.mm.x.a.gvJ;
            localObject = com.tencent.mm.x.a.a(paramBitmap, locala.index, i, j, this.xSQ.getDefaultWeight());
            this.xSQ.post((Runnable)new a(locala, (Bitmap)localObject));
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
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(PhotoFilterPlugin.a parama, Bitmap paramBitmap) {}
      
      public final void run()
      {
        AppMethodBeat.i(163455);
        PhotoFilterPlugin.a locala = this.xSY;
        Bitmap localBitmap = this.xSZ;
        p.h(localBitmap, "bitmap");
        locala.xSR.setImageBitmap(localBitmap);
        locala.xST = true;
        AppMethodBeat.o(163455);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.filter.PhotoFilterPlugin
 * JD-Core Version:    0.7.0.1
 */