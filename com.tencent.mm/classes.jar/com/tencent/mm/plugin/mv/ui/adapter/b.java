package com.tencent.mm.plugin.mv.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.vfs.u;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.t;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "allMediaItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lkotlin/collections/ArrayList;", "headers", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$Companion$Header;", "mDateFormat", "Ljava/text/SimpleDateFormat;", "mOnClickListener", "Landroid/view/View$OnClickListener;", "mOnItemClickListener", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$OnItemClickListener;", "mediaCount", "", "getMediaCount", "()I", "onItemViewLongClick", "Landroid/view/View$OnLongClickListener;", "selectListener", "videoMaxDurationMs", "videoMinDurationMs", "addHeader", "", "header", "addMediaItems", "mediaItems", "clear", "getAllMediaItem", "getHeaderCount", "getItem", "position", "getItemCount", "getItemViewType", "isFlexMode", "", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeHeader", "setMediaItems", "setOnItemClickListener", "onItemClickListener", "setVideoDuration", "syncCheckedStatus", "uniqueIdList", "", "unCheckedItem", "uniqueId", "AlbumViewHolder", "CameraHeaderViewHolder", "Companion", "OnItemClickListener", "SimpleVideoAnalysisTask", "plugin-mv_release"})
public final class b
  extends RecyclerView.a<RecyclerView.v>
{
  public static final c Gft;
  public final LinkedList<b.c.b> BZK;
  private final View.OnLongClickListener BZM;
  private final View.OnClickListener BZN;
  public ArrayList<GalleryItem.MediaItem> Gfp;
  private int Gfq;
  private int Gfr;
  public d Gfs;
  private final Context mContext;
  private final View.OnClickListener mOnClickListener;
  private final SimpleDateFormat ucN;
  
  static
  {
    AppMethodBeat.i(237723);
    Gft = new c((byte)0);
    AppMethodBeat.o(237723);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(237721);
    this.mContext = paramContext;
    this.Gfp = new ArrayList();
    this.Gfq = 2000;
    this.Gfr = 2147483647;
    this.ucN = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
    this.BZK = new LinkedList();
    this.BZN = ((View.OnClickListener)new h(this));
    this.BZM = ((View.OnLongClickListener)new g(this));
    this.mOnClickListener = ((View.OnClickListener)new f(this));
    notifyDataSetChanged();
    AppMethodBeat.o(237721);
  }
  
  private final boolean fgD()
  {
    AppMethodBeat.i(237716);
    com.tencent.mm.ui.component.g localg = com.tencent.mm.ui.component.g.Xox;
    boolean bool = ((com.tencent.mm.plugin.mv.ui.uic.l)com.tencent.mm.ui.component.g.lm(this.mContext).i(com.tencent.mm.plugin.mv.ui.uic.l.class)).fgD();
    AppMethodBeat.o(237716);
    return bool;
  }
  
  public final void OK(long paramLong)
  {
    AppMethodBeat.i(237698);
    Iterator localIterator = ((Iterable)this.Gfp).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (i < 0) {
        j.iBO();
      }
      localObject = (GalleryItem.MediaItem)localObject;
      if (((GalleryItem.MediaItem)localObject).BVl == paramLong)
      {
        ((GalleryItem.MediaItem)localObject).fXF = false;
        cL(this.BZK.size() + i);
      }
      i += 1;
    }
    AppMethodBeat.o(237698);
  }
  
  public final GalleryItem.MediaItem SY(int paramInt)
  {
    AppMethodBeat.i(237719);
    if (paramInt < this.BZK.size())
    {
      Log.i("Music.MusicMvAlbumAdapter", "get header, pos[%d]", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(237719);
      return null;
    }
    paramInt -= this.BZK.size();
    if (paramInt >= this.Gfp.size())
    {
      Log.w("Music.MusicMvAlbumAdapter", "get item error, media items size[%d], adjustPos[%d]", new Object[] { Integer.valueOf(this.Gfp.size()), Integer.valueOf(paramInt) });
      AppMethodBeat.o(237719);
      return null;
    }
    GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)this.Gfp.get(paramInt);
    AppMethodBeat.o(237719);
    return localMediaItem;
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(237703);
    p.k(paramViewGroup, "parent");
    switch (paramInt)
    {
    default: 
      paramViewGroup = LayoutInflater.from(this.mContext).inflate(com.tencent.mm.plugin.mv.b.f.FZj, paramViewGroup, false);
      p.j(paramViewGroup, "LayoutInflater.from(mCon…           parent, false)");
      paramViewGroup = (RecyclerView.v)new a(paramViewGroup);
      AppMethodBeat.o(237703);
      return paramViewGroup;
    case 2: 
      paramViewGroup = LayoutInflater.from(this.mContext).inflate(com.tencent.mm.plugin.mv.b.f.FZA, paramViewGroup, false);
      p.j(paramViewGroup, "LayoutInflater.from(mCon…           parent, false)");
      paramViewGroup = (RecyclerView.v)new b.b(paramViewGroup);
      AppMethodBeat.o(237703);
      return paramViewGroup;
    }
    paramViewGroup = LayoutInflater.from(this.mContext).inflate(com.tencent.mm.plugin.mv.b.f.FZj, paramViewGroup, false);
    p.j(paramViewGroup, "LayoutInflater.from(mCon…           parent, false)");
    paramViewGroup = (RecyclerView.v)new a(paramViewGroup);
    AppMethodBeat.o(237703);
    return paramViewGroup;
  }
  
  public final void bg(LinkedList<GalleryItem.MediaItem> paramLinkedList)
  {
    AppMethodBeat.i(237696);
    p.k(paramLinkedList, "mediaItems");
    int i = getItemCount() - this.BZK.size();
    int j = paramLinkedList.size();
    if (i < j)
    {
      this.Gfp.addAll((Collection)paramLinkedList.subList(i, j));
      aG(this.BZK.size() + i, getItemCount());
    }
    AppMethodBeat.o(237696);
  }
  
  @SuppressLint({"ResourceType"})
  public final void d(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(237710);
    p.k(paramv, "holder");
    if ((paramv instanceof b.b))
    {
      paramv.amk.setTag(com.tencent.mm.plugin.mv.b.e.item_position, Integer.valueOf(paramInt));
      paramv.amk.setTag(com.tencent.mm.plugin.mv.b.e.item_type, Integer.valueOf(2));
      paramv.amk.setOnClickListener(this.mOnClickListener);
      AppMethodBeat.o(237710);
      return;
    }
    GalleryItem.MediaItem localMediaItem;
    a locala;
    if ((paramv instanceof a))
    {
      paramv.amk.setTag(com.tencent.mm.plugin.mv.b.e.item_position, Integer.valueOf(paramInt));
      paramv.amk.setTag(com.tencent.mm.plugin.mv.b.e.item_type, Integer.valueOf(1));
      paramv.amk.setOnClickListener(this.mOnClickListener);
      localMediaItem = SY(paramInt);
      if (localMediaItem == null)
      {
        Log.e("Music.MusicMvAlbumAdapter", "get item failed");
        AppMethodBeat.o(237710);
        return;
      }
      String str1 = localMediaItem.aZe();
      p.j(str1, "item.thumbPath");
      String str2 = localMediaItem.etI();
      p.j(str2, "item.originalPath");
      if ((Util.isNullOrNil(str1)) && (Util.isNullOrNil(str2)))
      {
        Log.e("Music.MusicMvAlbumAdapter", "null or nil filepath, poi: %s.", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(237710);
        return;
      }
      locala = (a)paramv;
      locala.BPW.setAlpha(1.0F);
      if (!fgD()) {
        break label539;
      }
      locala.Gfu.setChecked(localMediaItem.fXF);
      if (!(localMediaItem instanceof GalleryItem.VideoMediaItem)) {
        break label510;
      }
      locala.BZT.setVisibility(0);
      paramv = e.Gfy;
      b.e.a.a(locala.BZT, (View)locala.BPW, (GalleryItem.VideoMediaItem)localMediaItem, this.Gfq, this.Gfr);
      paramv = this.ucN.format(new Date(localMediaItem.BVm));
      p.j(paramv, "mDateFormat.format(Date(item.generateDate))");
      paramv = paramInt + 1 + ", " + paramv;
      if (2 != localMediaItem.getType()) {
        break label763;
      }
      paramv = "视频 ".concat(String.valueOf(paramv));
      label363:
      locala.BPW.setContentDescription((CharSequence)paramv);
      Log.d("Music.MusicMvAlbumAdapter", "thumbFilePath: %s | origFilePath: %s | contentDescription %s", new Object[] { str1, str2, paramv });
      com.tencent.mm.plugin.gallery.ui.h.a(locala.BPW, localMediaItem.getType(), str1, str2, localMediaItem.BVl, localMediaItem.BVm);
      locala.amk.setOnLongClickListener(this.BZM);
      if (!fgD()) {
        break label777;
      }
      locala.Gfu.setVisibility(0);
      label454:
      if (locala.Gfu.getVisibility() != 0) {
        break label790;
      }
      a.fD((View)locala.Gfu);
    }
    for (;;)
    {
      locala.Gfu.setTag(com.tencent.mm.plugin.mv.b.e.item_position, Integer.valueOf(paramInt));
      locala.Gfu.setOnClickListener(this.BZN);
      AppMethodBeat.o(237710);
      return;
      label510:
      locala.BZT.setVisibility(8);
      if (!localMediaItem.fXF)
      {
        locala.BPW.setAlpha(1.0F);
        break;
        label539:
        locala.BZT.setVisibility(8);
        if (!(localMediaItem instanceof GalleryItem.VideoMediaItem)) {
          break;
        }
        locala.BZT.setVisibility(0);
        paramv = e.Gfy;
        b.e.a.a(locala.BZT, (View)locala.BPW, (GalleryItem.VideoMediaItem)localMediaItem, this.Gfq, this.Gfr);
        Log.d("Music.MusicMvAlbumAdapter", "item path:" + localMediaItem.AAz + ", width:" + ((GalleryItem.VideoMediaItem)localMediaItem).videoWidth + ", height:" + ((GalleryItem.VideoMediaItem)localMediaItem).videoHeight + ", durationMs:" + ((GalleryItem.VideoMediaItem)localMediaItem).maT + ", videoMinDurationMs:" + this.Gfq + ", videoMaxDurationMs:" + this.Gfr);
        if ((com.tencent.mm.plugin.mv.ui.a.e.ZJ(((GalleryItem.VideoMediaItem)localMediaItem).maT) >= com.tencent.mm.plugin.mv.ui.a.e.ZI(this.Gfq)) && (com.tencent.mm.plugin.mv.ui.a.e.ZJ(((GalleryItem.VideoMediaItem)localMediaItem).maT) <= com.tencent.mm.plugin.mv.ui.a.e.ZI(this.Gfr)))
        {
          locala.BPW.setAlpha(1.0F);
          break;
        }
      }
      locala.BPW.setAlpha(0.1F);
      break;
      label763:
      paramv = "图片".concat(String.valueOf(paramv));
      break label363;
      label777:
      locala.Gfu.setVisibility(8);
      break label454;
      label790:
      a.fE((View)locala.Gfu);
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(237699);
    int i = this.BZK.size();
    int j = this.Gfp.size();
    AppMethodBeat.o(237699);
    return i + j;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(237701);
    if (paramInt < this.BZK.size())
    {
      paramInt = ((b.c.b)this.BZK.get(paramInt)).BZZ;
      AppMethodBeat.o(237701);
      return paramInt;
    }
    AppMethodBeat.o(237701);
    return 1;
  }
  
  public final void setVideoDuration(int paramInt)
  {
    AppMethodBeat.i(237693);
    this.Gfq = paramInt;
    notifyDataSetChanged();
    AppMethodBeat.o(237693);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$AlbumViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "flexCB", "Landroid/widget/CheckBox;", "getFlexCB", "()Landroid/widget/CheckBox;", "setFlexCB", "(Landroid/widget/CheckBox;)V", "thumbIV", "Landroid/widget/ImageView;", "getThumbIV", "()Landroid/widget/ImageView;", "setThumbIV", "(Landroid/widget/ImageView;)V", "typeMaskTV", "Landroid/widget/TextView;", "getTypeMaskTV", "()Landroid/widget/TextView;", "setTypeMaskTV", "(Landroid/widget/TextView;)V", "collapseTouch", "", "delegate", "expandTouch", "plugin-mv_release"})
  public static final class a
    extends RecyclerView.v
  {
    ImageView BPW;
    TextView BZT;
    CheckBox Gfu;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(227755);
      View localView = paramView.findViewById(com.tencent.mm.plugin.mv.b.e.media_thumb);
      p.j(localView, "itemView.findViewById(R.id.media_thumb)");
      this.BPW = ((ImageView)localView);
      localView = paramView.findViewById(com.tencent.mm.plugin.mv.b.e.type_mask_tv);
      p.j(localView, "itemView.findViewById(R.id.type_mask_tv)");
      this.BZT = ((TextView)localView);
      paramView = paramView.findViewById(com.tencent.mm.plugin.mv.b.e.media_cbx);
      p.j(paramView, "itemView.findViewById(R.id.media_cbx)");
      this.Gfu = ((CheckBox)paramView);
      AppMethodBeat.o(227755);
    }
    
    public static void fD(View paramView)
    {
      AppMethodBeat.i(227751);
      p.k(paramView, "delegate");
      Object localObject = paramView.getParent();
      if (localObject == null)
      {
        paramView = new t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(227751);
        throw paramView;
      }
      localObject = (View)localObject;
      ((View)localObject).post((Runnable)new a(paramView, (View)localObject));
      AppMethodBeat.o(227751);
    }
    
    public static void fE(View paramView)
    {
      AppMethodBeat.i(227753);
      p.k(paramView, "delegate");
      paramView = paramView.getParent();
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(227753);
        throw paramView;
      }
      ((View)paramView).setTouchDelegate(null);
      AppMethodBeat.o(227753);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(View paramView1, View paramView2) {}
      
      public final void run()
      {
        AppMethodBeat.i(231367);
        Rect localRect = new Rect();
        this.Gfv.getHitRect(localRect);
        localRect.left -= com.tencent.mm.ci.a.fromDPToPix(this.Gfv.getContext(), 20);
        localRect.top -= com.tencent.mm.ci.a.fromDPToPix(this.Gfv.getContext(), 20);
        localRect.right += com.tencent.mm.ci.a.fromDPToPix(this.Gfv.getContext(), 20);
        localRect.bottom += com.tencent.mm.ci.a.fromDPToPix(this.Gfv.getContext(), 20);
        this.AVD.setTouchDelegate(new TouchDelegate(localRect, this.Gfv));
        AppMethodBeat.o(231367);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$Companion;", "", "()V", "ITEM_TYPE_CAMERA_HEADER", "", "ITEM_TYPE_MEDIA", "TAG", "", "CameraHeader", "Header", "plugin-mv_release"})
  public static final class c
  {
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$Companion$CameraHeader;", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$Companion$Header;", "headerType", "", "(I)V", "plugin-mv_release"})
    public static final class a
      extends b.c.b
    {
      public a()
      {
        this.BZZ = 2;
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$Companion$Header;", "", "()V", "headerType", "", "getHeaderType", "()I", "setHeaderType", "(I)V", "plugin-mv_release"})
    public static abstract class b
    {
      int BZZ;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$OnItemClickListener;", "", "onItemChecked", "", "isCheck", "item", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "onItemClick", "", "position", "", "itemView", "Landroid/view/View;", "itemViewType", "plugin-mv_release"})
  public static abstract interface d
  {
    public abstract void a(int paramInt1, View paramView, int paramInt2);
    
    public abstract boolean b(boolean paramBoolean, GalleryItem.MediaItem paramMediaItem);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$SimpleVideoAnalysisTask;", "Ljava/lang/Runnable;", "tv", "Landroid/widget/TextView;", "iv", "Landroid/view/View;", "mediaItem", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;", "listener", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$SimpleVideoAnalysisTask$Listener;", "(Landroid/widget/TextView;Landroid/view/View;Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$SimpleVideoAnalysisTask$Listener;)V", "isCancel", "", "ivRef", "Ljava/lang/ref/WeakReference;", "tvRef", "cancel", "", "checkDeviceIsConfiguration", "videoPath", "", "equals", "o", "", "hashCode", "", "loadItemFromExtractor", "loadItemFromSimpleMP4Info", "notifyObserver", "run", "setImageView", "Landroid/widget/ImageView;", "setTextView", "Companion", "Listener", "plugin-mv_release"})
  public static final class e
    implements Runnable
  {
    private static final HashMap<TextView, e> Cac;
    public static final a Gfy;
    private final GalleryItem.VideoMediaItem Caa;
    private WeakReference<View> Gfw;
    private final b Gfx;
    boolean kUn;
    private WeakReference<TextView> wzt;
    
    static
    {
      AppMethodBeat.i(230642);
      Gfy = new a((byte)0);
      Cac = new HashMap();
      AppMethodBeat.o(230642);
    }
    
    private e(TextView paramTextView, View paramView, GalleryItem.VideoMediaItem paramVideoMediaItem, b paramb)
    {
      AppMethodBeat.i(230641);
      this.wzt = new WeakReference(paramTextView);
      this.Gfw = new WeakReference(paramView);
      this.Caa = paramVideoMediaItem;
      this.Gfx = paramb;
      AppMethodBeat.o(230641);
    }
    
    private static boolean aFp(String paramString)
    {
      AppMethodBeat.i(230636);
      Object localObject1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vVw, "");
      p.j(localObject1, "MMKernel.service(IExptSe…device_configuration, \"\")");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        AppMethodBeat.o(230636);
        return false;
      }
      Log.i("Music.MusicMvAlbumAdapter", "devices configuration: %s", new Object[] { localObject1 });
      Log.i("Music.MusicMvAlbumAdapter", "android version: %s, manufacturer: %s, brand: %s, model: %s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Build.MANUFACTURER, Build.BRAND, Build.MODEL });
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        Object localObject2 = ((JSONObject)localObject1).optString("devices");
        p.j(localObject2, "`object`.optString(\"devices\")");
        int j = ((JSONObject)localObject1).optInt("maxsize");
        localObject1 = new JSONArray((String)localObject2);
        int k = ((JSONArray)localObject1).length();
        int i = 0;
        while (i < k)
        {
          localObject2 = ((JSONArray)localObject1).optJSONObject(i);
          p.j(localObject2, "array.optJSONObject(i)");
          if ((n.L(Build.MANUFACTURER, ((JSONObject)localObject2).optString("brand"), true)) && (n.L(Build.MODEL, ((JSONObject)localObject2).optString("model"), true)))
          {
            long l = u.bBQ(paramString);
            if ((j != 0) && (l > j * 1024 * 1024))
            {
              Log.i("Music.MusicMvAlbumAdapter", "hit devices but it is too big, fileSize: %s, maxSize: %s, filePath: %s", new Object[] { Long.valueOf(l), Integer.valueOf(j), paramString });
              AppMethodBeat.o(230636);
              return false;
            }
            int m = ((JSONObject)localObject2).optInt("androidVersion");
            if (-1 == m)
            {
              Log.i("Music.MusicMvAlbumAdapter", "hit devices all version, manufacturer: %s, brand: %s, model: %s", new Object[] { Build.MANUFACTURER, Build.BRAND, Build.MODEL });
              AppMethodBeat.o(230636);
              return true;
            }
            if (Build.VERSION.SDK_INT == m)
            {
              Log.i("Music.MusicMvAlbumAdapter", "hit devices, version: %s, manufacturer: %s, brand: %s, model: %s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Build.MANUFACTURER, Build.BRAND, Build.MODEL });
              AppMethodBeat.o(230636);
              return true;
            }
          }
          i += 1;
        }
        return false;
      }
      catch (JSONException paramString)
      {
        Log.printErrStackTrace("Music.MusicMvAlbumAdapter", (Throwable)paramString, "parse json error", new Object[0]);
        AppMethodBeat.o(230636);
      }
    }
    
    private final void euu()
    {
      AppMethodBeat.i(230639);
      if (this.Caa == null)
      {
        AppMethodBeat.o(230639);
        return;
      }
      long l = Util.currentTicks();
      try
      {
        String str = this.Caa.aZe();
        p.j(str, "mediaItem.thumbPath");
        Object localObject = SightVideoJNI.getSimpleMp4InfoVFS(str);
        p.j(localObject, "SightVideoJNI.getSimpleMp4InfoVFS(path)");
        Log.d("Music.MusicMvAlbumAdapter", "get simple mp4 info %s", new Object[] { localObject });
        localObject = new JSONObject((String)localObject);
        this.Caa.maT = ((JSONObject)localObject).getInt("videoDuration");
        this.Caa.videoHeight = ((JSONObject)localObject).getInt("videoHeight");
        this.Caa.videoWidth = ((JSONObject)localObject).getInt("videoWidth");
        this.Caa.videoBitRate = ((JSONObject)localObject).getInt("videoBitrate");
        this.Caa.videoFrameRate = ((JSONObject)localObject).getInt("videoFPS");
        this.Caa.kWG = SightVideoJNI.getMp4RotateVFS(str);
        this.Caa.videoIFrameInterval = 0;
        this.Caa.maR = com.tencent.mm.plugin.gallery.a.c.aIG(((JSONObject)localObject).getString("videoType"));
        this.Caa.maS = com.tencent.mm.plugin.gallery.a.c.aIG(((JSONObject)localObject).getString("audioType"));
        Log.d("Music.MusicMvAlbumAdapter", "loadItemFromSimpleMP4Info mediaItem: %s", new Object[] { this.Caa });
        Log.i("Music.MusicMvAlbumAdapter", "loadItemFromSimpleMP4Info used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
        AppMethodBeat.o(230639);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("Music.MusicMvAlbumAdapter", (Throwable)localException, "loadItemFromSimpleMP4Info fail", new Object[0]);
        }
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(230625);
      if (!(paramObject instanceof e))
      {
        AppMethodBeat.o(230625);
        return false;
      }
      boolean bool = p.h(this.Caa, ((e)paramObject).Caa);
      AppMethodBeat.o(230625);
      return bool;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(230629);
      GalleryItem.VideoMediaItem localVideoMediaItem = this.Caa;
      if (localVideoMediaItem != null)
      {
        int i = localVideoMediaItem.hashCode();
        AppMethodBeat.o(230629);
        return i;
      }
      AppMethodBeat.o(230629);
      return 0;
    }
    
    public final void run()
    {
      AppMethodBeat.i(230634);
      if (this.kUn)
      {
        AppMethodBeat.o(230634);
        return;
      }
      Object localObject1 = this.Caa;
      if (localObject1 == null) {
        p.iCn();
      }
      localObject1 = ((GalleryItem.VideoMediaItem)localObject1).aZe();
      p.j(localObject1, "mediaItem!!.thumbPath");
      Object localObject4;
      int i;
      label185:
      long l;
      com.tencent.mm.compatible.i.c localc;
      String str1;
      if (aFp((String)localObject1))
      {
        euu();
        if (this.kUn) {
          break label908;
        }
        if (!p.h(Looper.myLooper(), Looper.getMainLooper())) {
          break label894;
        }
        localObject1 = this.Gfx;
        if (localObject1 != null)
        {
          localObject4 = this.Caa;
          if (localObject4 == null) {
            p.iCn();
          }
          i = ((GalleryItem.VideoMediaItem)localObject4).maT;
          localObject4 = this.Caa;
          if (localObject4 == null) {
            p.iCn();
          }
          ((b)localObject1).a(this, i, ((GalleryItem.VideoMediaItem)localObject4).fXF);
          AppMethodBeat.o(230634);
        }
      }
      else
      {
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vUO, 0) == 1) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label185;
          }
          euu();
          break;
        }
        l = Util.currentTicks();
        localc = new com.tencent.mm.compatible.i.c();
        localObject1 = this.Caa;
        if (localObject1 == null) {
          p.iCn();
        }
        str1 = ((GalleryItem.VideoMediaItem)localObject1).aZe();
        p.j(str1, "mediaItem!!.thumbPath");
      }
      for (;;)
      {
        Object localObject7;
        Object localObject8;
        try
        {
          localc.setDataSource(str1);
          int j = localc.getTrackCount();
          localObject1 = null;
          localObject4 = null;
          i = 0;
          localObject5 = localObject4;
          localObject6 = localObject1;
          if (i < j)
          {
            localMediaFormat = localc.getTrackFormat(i);
            p.j(localMediaFormat, "extractor.getTrackFormat(i)");
            if (!localMediaFormat.containsKey("mime"))
            {
              Log.d("Music.MusicMvAlbumAdapter", "find video mime : not found.");
              localObject7 = localObject4;
              localObject8 = localObject1;
              break label915;
            }
            str2 = localMediaFormat.getString("mime");
            Log.d("Music.MusicMvAlbumAdapter", "find video mime : %s", new Object[] { str2 });
            localObject7 = localObject4;
            localObject8 = localObject1;
            if (str2 == null) {
              break label915;
            }
            if (!n.M(str2, "video/", false)) {
              continue;
            }
            localObject5 = localObject4;
            localObject6 = localObject1;
            if (localObject1 != null) {
              break label930;
            }
            localObject6 = localMediaFormat;
            localObject5 = localObject4;
            break label930;
          }
          if (this.Caa != null)
          {
            if (localObject6 != null)
            {
              localObject1 = this.Caa;
              if (localObject6.containsKey("durationUs")) {
                continue;
              }
              i = 0;
              ((GalleryItem.VideoMediaItem)localObject1).maT = i;
              localObject1 = this.Caa;
              if (localObject6.containsKey("height")) {
                continue;
              }
              i = 0;
              ((GalleryItem.VideoMediaItem)localObject1).videoHeight = i;
              localObject1 = this.Caa;
              if (localObject6.containsKey("width")) {
                continue;
              }
              i = 0;
              ((GalleryItem.VideoMediaItem)localObject1).videoWidth = i;
              localObject4 = this.Caa;
              if (localObject6.containsKey("mime")) {
                continue;
              }
              localObject1 = "";
              ((GalleryItem.VideoMediaItem)localObject4).maR = ((String)localObject1);
              localObject1 = this.Caa;
              if (localObject6.containsKey("bitrate")) {
                continue;
              }
              i = 0;
              ((GalleryItem.VideoMediaItem)localObject1).videoBitRate = i;
              localObject1 = this.Caa;
              if (localObject6.containsKey("i-frame-interval")) {
                continue;
              }
              i = 0;
              ((GalleryItem.VideoMediaItem)localObject1).videoIFrameInterval = i;
              localObject1 = this.Caa;
              if (localObject6.containsKey("frame-rate")) {
                continue;
              }
              i = 0;
              ((GalleryItem.VideoMediaItem)localObject1).videoFrameRate = i;
              this.Caa.kWG = SightVideoJNI.getMp4RotateVFS(str1);
            }
            if (localObject5 != null)
            {
              localObject4 = this.Caa;
              if (localObject5.containsKey("mime")) {
                continue;
              }
              localObject1 = "";
              ((GalleryItem.VideoMediaItem)localObject4).maS = ((String)localObject1);
            }
          }
          Log.d("Music.MusicMvAlbumAdapter", "loadItemFromExtractor mediaItem: %s", new Object[] { this.Caa });
          Log.d("Music.MusicMvAlbumAdapter", "mediaItem format:%s, videoPath:%s", new Object[] { localObject6, str1 });
          localc.release();
        }
        catch (Exception localException)
        {
          MediaFormat localMediaFormat;
          String str2;
          Log.d("Music.MusicMvAlbumAdapter", "Video extractor init failed. video path = [%s] e = [%s]", new Object[] { str1, localException.getMessage() });
          localc.release();
          continue;
        }
        finally
        {
          localc.release();
          AppMethodBeat.o(230634);
        }
        Log.i("Music.MusicMvAlbumAdapter", "loadItemFromExtractor used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
        break;
        Object localObject5 = localObject4;
        Object localObject6 = localObject1;
        if (n.M(str2, "audio/", false))
        {
          localObject5 = localObject4;
          localObject6 = localObject1;
          if (localObject4 == null)
          {
            localObject5 = localMediaFormat;
            localObject6 = localObject1;
            break label930;
            i = (int)(localObject6.getLong("durationUs") / 1000L);
            continue;
            i = localObject6.getInteger("height");
            continue;
            i = localObject6.getInteger("width");
            continue;
            localObject1 = localObject6.getString("mime");
            continue;
            i = localObject6.getInteger("bitrate");
            continue;
            i = localObject6.getInteger("i-frame-interval");
            continue;
            i = localObject6.getInteger("frame-rate");
            continue;
            localObject1 = localObject5.getString("mime");
            continue;
            AppMethodBeat.o(230634);
            return;
            label894:
            MMHandlerThread.postToMainThread((Runnable)new c(this));
            label908:
            AppMethodBeat.o(230634);
            return;
          }
        }
        label915:
        label930:
        do
        {
          do
          {
            i += 1;
            localObject4 = localObject7;
            Object localObject3 = localObject8;
            break;
            localObject7 = localObject5;
            localObject8 = localObject6;
          } while (localObject5 == null);
          localObject7 = localObject5;
          localObject8 = localObject6;
        } while (localObject6 == null);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$SimpleVideoAnalysisTask$Companion;", "", "()V", "taskContainer", "Ljava/util/HashMap;", "Landroid/widget/TextView;", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$SimpleVideoAnalysisTask;", "clearFetchDurationTask", "", "fetchDurationMs", "tv", "iv", "Landroid/view/View;", "videoMediaItem", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;", "videoMinDurationMs", "", "videoMaxDurationMs", "setResult", "durationMs", "isCheck", "", "plugin-mv_release"})
    public static final class a
    {
      static void a(TextView paramTextView, View paramView, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
      {
        AppMethodBeat.i(225762);
        if (paramTextView == null)
        {
          AppMethodBeat.o(225762);
          return;
        }
        if (paramInt1 < 0)
        {
          paramTextView.setText((CharSequence)"--:--");
          AppMethodBeat.o(225762);
          return;
        }
        paramInt1 = com.tencent.mm.plugin.mv.ui.a.e.ZJ(paramInt1);
        paramInt2 = com.tencent.mm.plugin.mv.ui.a.e.ZI(paramInt2);
        paramInt3 = com.tencent.mm.plugin.mv.ui.a.e.ZK(paramInt3);
        if (paramView != null)
        {
          paramView.setAlpha(1.0F);
          if ((paramInt1 >= paramInt2) && (paramInt1 <= paramInt3) && (!paramBoolean)) {
            break label156;
          }
          paramView.setAlpha(0.1F);
        }
        for (;;)
        {
          String str = String.valueOf(paramInt1 % 60);
          paramView = str;
          if (str.length() < 2) {
            paramView = "0".concat(String.valueOf(str));
          }
          paramTextView.setText((CharSequence)(String.valueOf(paramInt1 / 60) + ":" + paramView));
          AppMethodBeat.o(225762);
          return;
          label156:
          paramView.setAlpha(1.0F);
        }
      }
      
      public static void a(TextView paramTextView, View paramView, GalleryItem.VideoMediaItem paramVideoMediaItem, int paramInt1, final int paramInt2)
      {
        AppMethodBeat.i(225759);
        if ((paramTextView == null) || (paramView == null) || (paramVideoMediaItem == null))
        {
          Log.e("Music.MusicMvAlbumAdapter", "Error input for duration fetcher");
          AppMethodBeat.o(225759);
          return;
        }
        if (b.e.fgE().containsKey(paramTextView))
        {
          b.e locale = (b.e)b.e.fgE().get(paramTextView);
          if (locale != null)
          {
            if (p.h(b.e.b(locale), paramVideoMediaItem))
            {
              AppMethodBeat.o(225759);
              return;
            }
            WeakReference localWeakReference = b.e.c(locale);
            if (localWeakReference == null) {
              p.iCn();
            }
            if (p.h(paramTextView, (TextView)localWeakReference.get()))
            {
              b.e.d(locale);
              b.e.e(locale);
              locale.kUn = true;
            }
          }
        }
        if (paramVideoMediaItem.maT >= 0)
        {
          Log.i("Music.MusicMvAlbumAdapter", "Directly attach durationMs %d to tv, path %s", new Object[] { Integer.valueOf(paramVideoMediaItem.maT), paramVideoMediaItem });
          a(paramTextView, paramView, paramVideoMediaItem.maT, paramInt1, paramInt2, paramVideoMediaItem.fXF);
          b.e.fgE().remove(paramTextView);
          AppMethodBeat.o(225759);
          return;
        }
        paramTextView.setText((CharSequence)"");
        paramView = new b.e(paramTextView, paramView, paramVideoMediaItem, (b.e.b)new a(paramInt1, paramInt2), (byte)0);
        com.tencent.mm.plugin.gallery.model.e.etm().av((Runnable)paramView);
        ((Map)b.e.fgE()).put(paramTextView, paramView);
        AppMethodBeat.o(225759);
      }
      
      @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$SimpleVideoAnalysisTask$Companion$fetchDurationMs$task$1", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$SimpleVideoAnalysisTask$Listener;", "onResult", "", "task", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$SimpleVideoAnalysisTask;", "durationMs", "", "isCheck", "", "plugin-mv_release"})
      public static final class a
        implements b.e.b
      {
        a(int paramInt1, int paramInt2) {}
        
        public final void a(b.e parame, int paramInt, boolean paramBoolean)
        {
          AppMethodBeat.i(228802);
          if (parame != null) {}
          for (Object localObject = b.e.c(parame); localObject == null; localObject = null)
          {
            AppMethodBeat.o(228802);
            return;
          }
          localObject = b.e.c(parame);
          if (localObject == null) {
            p.iCn();
          }
          localObject = (TextView)((WeakReference)localObject).get();
          if (localObject == null)
          {
            AppMethodBeat.o(228802);
            return;
          }
          parame = (View)b.e.f(parame).get();
          if (parame == null)
          {
            AppMethodBeat.o(228802);
            return;
          }
          b.e.a locala = b.e.Gfy;
          b.e.a.a((TextView)localObject, parame, paramInt, this.Gfz, paramInt2, paramBoolean);
          b.e.fgE().remove(localObject);
          AppMethodBeat.o(228802);
        }
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$SimpleVideoAnalysisTask$Listener;", "", "onResult", "", "task", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$SimpleVideoAnalysisTask;", "durationMs", "", "isCheck", "", "plugin-mv_release"})
    static abstract interface b
    {
      public abstract void a(b.e parame, int paramInt, boolean paramBoolean);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$SimpleVideoAnalysisTask$notifyObserver$1", "Ljava/lang/Runnable;", "run", "", "plugin-mv_release"})
    public static final class c
      implements Runnable
    {
      public final void run()
      {
        AppMethodBeat.i(231184);
        b.e.b localb = b.e.a(this.GfB);
        if (localb != null)
        {
          b.e locale = this.GfB;
          GalleryItem.VideoMediaItem localVideoMediaItem = b.e.b(this.GfB);
          if (localVideoMediaItem == null) {
            p.iCn();
          }
          int i = localVideoMediaItem.maT;
          localVideoMediaItem = b.e.b(this.GfB);
          if (localVideoMediaItem == null) {
            p.iCn();
          }
          localb.a(locale, i, localVideoMediaItem.fXF);
          AppMethodBeat.o(231184);
          return;
        }
        AppMethodBeat.o(231184);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(231214);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$mOnClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      localObject = paramView.getTag(com.tencent.mm.plugin.mv.b.e.item_position);
      int i;
      if ((localObject instanceof Integer))
      {
        i = ((Number)localObject).intValue();
        localObject = paramView.getTag(com.tencent.mm.plugin.mv.b.e.item_type);
        if (!(localObject instanceof Integer)) {
          break label156;
        }
      }
      label156:
      for (int j = ((Number)localObject).intValue();; j = -1)
      {
        if ((i != -1) && (j != -1) && (b.a(this.GfC) != null))
        {
          localObject = b.a(this.GfC);
          if (localObject != null) {
            ((b.d)localObject).a(i, paramView, j);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$mOnClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(231214);
        return;
        i = -1;
        break;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class g
    implements View.OnLongClickListener
  {
    g(b paramb) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(236154);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$onItemViewLongClick$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
      paramView = paramView.getTag(com.tencent.mm.plugin.mv.b.e.item_position);
      p.j(paramView, "v.getTag(R.id.item_position)");
      if ((paramView instanceof Integer))
      {
        paramView = this.GfC.SY(((Number)paramView).intValue());
        if (paramView != null) {
          ClipboardHelper.setText(b.b(this.GfC), (CharSequence)"media info", (CharSequence)paramView.toString());
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$onItemViewLongClick$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(236154);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(227833);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$selectListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      localObject = paramView.getTag(com.tencent.mm.plugin.mv.b.e.item_position);
      if ((localObject == null) || (!(localObject instanceof Integer)))
      {
        Log.e("Music.MusicMvAlbumAdapter", "error tag");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$selectListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(227833);
        return;
      }
      GalleryItem.MediaItem localMediaItem = this.GfC.SY(((Number)localObject).intValue());
      if ((localMediaItem == null) || (Util.isNullOrNil(localMediaItem.AAz)))
      {
        Log.e("Music.MusicMvAlbumAdapter", "[onClick] null == item!");
        this.GfC.cL(((Number)localObject).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$selectListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(227833);
        return;
      }
      Log.i("Music.MusicMvAlbumAdapter", "click image path:" + localMediaItem.AAz);
      boolean bool;
      if (!localMediaItem.fXF)
      {
        bool = true;
        localMediaItem.fXF = bool;
        paramView = b.a(this.GfC);
        if (paramView == null) {
          break label273;
        }
      }
      label273:
      for (paramView = Boolean.valueOf(paramView.b(localMediaItem.fXF, localMediaItem));; paramView = null)
      {
        if ((paramView != null) && (!paramView.booleanValue())) {
          localMediaItem.fXF = false;
        }
        this.GfC.cL(((Number)localObject).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$selectListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(227833);
        return;
        bool = false;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.adapter.b
 * JD-Core Version:    0.7.0.1
 */