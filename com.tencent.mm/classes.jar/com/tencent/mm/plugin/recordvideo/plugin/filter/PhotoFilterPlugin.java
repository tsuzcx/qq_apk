package com.tencent.mm.plugin.recordvideo.plugin.filter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.b.c;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.v;
import com.tencent.mm.plugin.recordvideo.plugin.v.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.y.a.a;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/filter/PhotoFilterPlugin;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "defaultWeight", "", "getDefaultWeight", "()F", "itemViews", "", "Lcom/tencent/mm/plugin/recordvideo/plugin/filter/PhotoFilterPlugin$ViewHolder;", "getItemViews", "()Ljava/util/List;", "lastSelectedIndex", "", "getLastSelectedIndex", "()I", "setLastSelectedIndex", "(I)V", "progressDescTv", "Landroid/widget/TextView;", "getProgressDescTv", "()Landroid/widget/TextView;", "seekBar", "Landroid/widget/SeekBar;", "getSeekBar", "()Landroid/widget/SeekBar;", "seekBarLayout", "Landroid/view/ViewGroup;", "getSeekBarLayout", "()Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "weightMap", "", "getWeightMap", "()Ljava/util/Map;", "setWeightMap", "(Ljava/util/Map;)V", "onBackPress", "", "postFuncType", "", "index", "colorWeight", "setPreImage", "bitmap", "Landroid/graphics/Bitmap;", "setStatus", "setVisibility", "visibility", "ViewHolder", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PhotoFilterPlugin
  extends RelativeLayout
  implements v
{
  private com.tencent.mm.plugin.recordvideo.plugin.parent.a GrC;
  private final List<a> NME;
  private final ViewGroup NMF;
  private final TextView NMG;
  private int NMH;
  private Map<Integer, Float> NMI;
  private final float NMJ;
  private final String TAG;
  private final SeekBar uMM;
  
  public PhotoFilterPlugin(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(163462);
    this.TAG = "MicroMsg.PhotoFilterPlugin";
    this.NME = ((List)new ArrayList());
    this.NMI = ((Map)new LinkedHashMap());
    this.NMJ = 0.8F;
    LayoutInflater.from(paramContext).inflate(b.f.photo_filter_layout, (ViewGroup)this, true);
    paramAttributeSet = findViewById(b.e.seekbar_layout);
    s.s(paramAttributeSet, "findViewById(R.id.seekbar_layout)");
    this.NMF = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(b.e.filter_seek_bar);
    s.s(paramAttributeSet, "findViewById(R.id.filter_seek_bar)");
    this.uMM = ((SeekBar)paramAttributeSet);
    paramAttributeSet = findViewById(b.e.filter_seek_bar_desc);
    s.s(paramAttributeSet, "findViewById(R.id.filter_seek_bar_desc)");
    this.NMG = ((TextView)paramAttributeSet);
    paramAttributeSet = (kotlin.g.a.b)new b(this);
    this.uMM.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)new SeekBar.OnSeekBarChangeListener()
    {
      public final void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(163449);
        Log.d(this.NMK.getTAG(), s.X("onProgressChanged ", Integer.valueOf(paramAnonymousInt)));
        this.NMK.getProgressDescTv().setText((CharSequence)(paramAnonymousInt + '%'));
        AppMethodBeat.o(163449);
      }
      
      public final void onStartTrackingTouch(SeekBar paramAnonymousSeekBar) {}
      
      public final void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        AppMethodBeat.i(163450);
        PhotoFilterPlugin localPhotoFilterPlugin = this.NMK;
        int i = this.NMK.getLastSelectedIndex();
        s.checkNotNull(paramAnonymousSeekBar);
        PhotoFilterPlugin.a(localPhotoFilterPlugin, i, paramAnonymousSeekBar.getProgress() / 100.0F);
        AppMethodBeat.o(163450);
      }
    });
    LinearLayout localLinearLayout = (LinearLayout)findViewById(b.e.photo_effect_list_layout);
    Object localObject = com.tencent.mm.y.a.muK;
    localObject = ((Iterable)com.tencent.mm.y.a.aXH()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a.a locala = (a.a)((Iterator)localObject).next();
      View localView = LayoutInflater.from(paramContext).inflate(b.f.photo_filter_choose_effect_item, (ViewGroup)localLinearLayout, false);
      localLinearLayout.addView(localView);
      List localList = getItemViews();
      s.s(localView, "itemView");
      localList.add(new a(localView, locala.type, locala.name, paramAttributeSet));
    }
    AppMethodBeat.o(163462);
  }
  
  private static final void a(a parama, Bitmap paramBitmap)
  {
    AppMethodBeat.i(281003);
    s.u(parama, "$it");
    s.u(paramBitmap, "$bmp");
    s.u(paramBitmap, "bitmap");
    parama.NMO.setImageBitmap(paramBitmap);
    parama.NMQ = true;
    AppMethodBeat.o(281003);
  }
  
  private static final void a(PhotoFilterPlugin paramPhotoFilterPlugin, Bitmap paramBitmap)
  {
    AppMethodBeat.i(281009);
    s.u(paramPhotoFilterPlugin, "this$0");
    s.u(paramBitmap, "$bitmap");
    Iterator localIterator = ((Iterable)paramPhotoFilterPlugin.getItemViews()).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (!locala.NMQ)
      {
        com.tencent.mm.y.a locala1 = com.tencent.mm.y.a.muK;
        com.tencent.mm.y.a.D(paramBitmap);
        int k = com.tencent.mm.cd.a.bs(paramPhotoFilterPlugin.getContext(), b.c.Edge_8A);
        int j = com.tencent.mm.cd.a.bs(paramPhotoFilterPlugin.getContext(), b.c.Edge_8A);
        int i;
        if (paramBitmap.getWidth() > paramBitmap.getHeight()) {
          i = (int)(paramBitmap.getWidth() / paramBitmap.getHeight() * j);
        }
        for (;;)
        {
          locala1 = com.tencent.mm.y.a.muK;
          paramPhotoFilterPlugin.post(new PhotoFilterPlugin..ExternalSyntheticLambda0(locala, com.tencent.mm.y.a.a(paramBitmap, locala.index, i, j, paramPhotoFilterPlugin.getDefaultWeight())));
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
    AppMethodBeat.o(281009);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(281081);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(281081);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(281096);
    s.u(this, "this");
    AppMethodBeat.o(281096);
  }
  
  public final float getDefaultWeight()
  {
    return this.NMJ;
  }
  
  public final List<a> getItemViews()
  {
    return this.NME;
  }
  
  public final int getLastSelectedIndex()
  {
    return this.NMH;
  }
  
  public final TextView getProgressDescTv()
  {
    return this.NMG;
  }
  
  public final SeekBar getSeekBar()
  {
    return this.uMM;
  }
  
  public final ViewGroup getSeekBarLayout()
  {
    return this.NMF;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final Map<Integer, Float> getWeightMap()
  {
    return this.NMI;
  }
  
  public final String name()
  {
    AppMethodBeat.i(281086);
    String str = v.a.b(this);
    AppMethodBeat.o(281086);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(281091);
    s.u(this, "this");
    AppMethodBeat.o(281091);
  }
  
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
  
  public final void onDetach()
  {
    AppMethodBeat.i(281101);
    s.u(this, "this");
    AppMethodBeat.o(281101);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(281107);
    s.u(this, "this");
    AppMethodBeat.o(281107);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(281114);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(281114);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(281120);
    s.u(this, "this");
    AppMethodBeat.o(281120);
  }
  
  public final void release()
  {
    AppMethodBeat.i(281124);
    s.u(this, "this");
    AppMethodBeat.o(281124);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(281129);
    s.u(this, "this");
    AppMethodBeat.o(281129);
  }
  
  public final void setLastSelectedIndex(int paramInt)
  {
    this.NMH = paramInt;
  }
  
  public final void setPreImage(Bitmap paramBitmap)
  {
    AppMethodBeat.i(163459);
    s.u(paramBitmap, "bitmap");
    h.ahAA.bm(new PhotoFilterPlugin..ExternalSyntheticLambda1(this, paramBitmap));
    AppMethodBeat.o(163459);
  }
  
  public final void setStatus(com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    AppMethodBeat.i(163458);
    s.u(parama, "status");
    this.GrC = parama;
    AppMethodBeat.o(163458);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(163460);
    super.setVisibility(paramInt);
    if (paramInt == 0) {
      ((a)this.NME.get(this.NMH)).gIU();
    }
    AppMethodBeat.o(163460);
  }
  
  public final void setWeightMap(Map<Integer, Float> paramMap)
  {
    AppMethodBeat.i(163457);
    s.u(paramMap, "<set-?>");
    this.NMI = paramMap;
    AppMethodBeat.o(163457);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/filter/PhotoFilterPlugin$ViewHolder;", "", "effectLayout", "Landroid/view/View;", "index", "", "effectName", "", "onSelect", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "(Landroid/view/View;ILjava/lang/String;Lkotlin/jvm/functions/Function1;)V", "effectIv", "Landroid/widget/ImageView;", "getEffectIv", "()Landroid/widget/ImageView;", "getEffectLayout", "()Landroid/view/View;", "getEffectName", "()Ljava/lang/String;", "effectTv", "Landroid/widget/TextView;", "getEffectTv", "()Landroid/widget/TextView;", "filtered", "", "getFiltered", "()Z", "setFiltered", "(Z)V", "getIndex", "()I", "maskView", "getMaskView", "getOnSelect", "()Lkotlin/jvm/functions/Function1;", "selected", "setImage", "bitmap", "Landroid/graphics/Bitmap;", "unselected", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private final View NML;
    private final String NMM;
    private final kotlin.g.a.b<Integer, ah> NMN;
    final ImageView NMO;
    private final TextView NMP;
    boolean NMQ;
    final int index;
    final View maskView;
    
    public a(View paramView, int paramInt, String paramString, kotlin.g.a.b<? super Integer, ah> paramb)
    {
      AppMethodBeat.i(163453);
      this.NML = paramView;
      this.index = paramInt;
      this.NMM = paramString;
      this.NMN = paramb;
      paramView = this.NML.findViewById(b.e.photo_effect_iv);
      s.s(paramView, "effectLayout.findViewById(R.id.photo_effect_iv)");
      this.NMO = ((ImageView)paramView);
      paramView = this.NML.findViewById(b.e.photo_effect_mask);
      s.s(paramView, "effectLayout.findViewById(R.id.photo_effect_mask)");
      this.maskView = paramView;
      paramView = this.NML.findViewById(b.e.photo_effect_name_tv);
      s.s(paramView, "effectLayout.findViewByI….id.photo_effect_name_tv)");
      this.NMP = ((TextView)paramView);
      this.NML.setOnClickListener(new PhotoFilterPlugin.a..ExternalSyntheticLambda0(this));
      this.NMP.setText((CharSequence)this.NMM);
      AppMethodBeat.o(163453);
    }
    
    private static final void a(a parama, View paramView)
    {
      AppMethodBeat.i(280999);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(parama);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/plugin/filter/PhotoFilterPlugin$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(parama, "this$0");
      parama.gIU();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/recordvideo/plugin/filter/PhotoFilterPlugin$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(280999);
    }
    
    public final void gIU()
    {
      AppMethodBeat.i(163452);
      this.maskView.setVisibility(8);
      this.NMN.invoke(Integer.valueOf(this.index));
      AppMethodBeat.o(163452);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "index", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Integer, ah>
  {
    b(PhotoFilterPlugin paramPhotoFilterPlugin)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.filter.PhotoFilterPlugin
 * JD-Core Version:    0.7.0.1
 */