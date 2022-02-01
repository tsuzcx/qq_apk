package com.tencent.mm.pluginsdk.ui.tools.a.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.TimeMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.g;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.j.f;
import com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.MMNumberCheckbox;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.ag;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter;", "Lcom/tencent/mm/pluginsdk/ui/pin/PinnedHeaderAdapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mContext", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "mOnSelectItemChanged", "Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$IOnSelectItemChanged;", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$IOnSelectItemChanged;)V", "allMediaItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lkotlin/collections/ArrayList;", "businessTag", "", "mDateFormat", "Ljava/text/SimpleDateFormat;", "mOnClickListener", "Landroid/view/View$OnClickListener;", "mOnItemClickListener", "Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$OnItemClickListener;", "mSelectMediaItems", "maxDurationSec", "", "getMaxDurationSec", "()I", "maxDurationTip", "getMaxDurationTip", "mediaCount", "getMediaCount", "onItemViewLongClick", "Landroid/view/View$OnLongClickListener;", "selectLimitCount", "selectListener", "selectedItemCount", "getSelectedItemCount", "mediaItems", "selectedMediaItems", "getSelectedMediaItems", "()Ljava/util/ArrayList;", "setSelectedMediaItems", "(Ljava/util/ArrayList;)V", "selectedPaths", "selectedMediaPaths", "getSelectedMediaPaths", "setSelectedMediaPaths", "videoMaxDuration", "addMediaItems", "", "Ljava/util/LinkedList;", "clear", "filterTimeMedia", "", "fixedMediaItemListWithTimeItem", "getAllMediaItem", "getItem", "position", "getItemCount", "getItemViewType", "getItemWithOutAdjust", "isPinnedPosition", "", "notifySelectedItemsAllChanged", "notifiedItems", "Landroidx/collection/ArraySet;", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeSelectedItemWithNotifyChanged", "item", "setMediaItems", "setOnItemClickListener", "onItemClickListener", "setSelectLimitCount", "count", "AlbumViewHolder", "Companion", "IOnSelectItemChanged", "OnItemClickListener", "SimpleVideoAnalysisTask", "TimeViewHolder", "app_release"})
public final class a
  extends com.tencent.mm.pluginsdk.ui.pin.b<RecyclerView.v>
{
  public static final b RyD;
  public int BZF;
  public final ArrayList<GalleryItem.MediaItem> BZH;
  private String BZJ;
  private final View.OnLongClickListener BZM;
  private final View.OnClickListener BZN;
  public ArrayList<GalleryItem.MediaItem> Gfp;
  public d RyA;
  private final FileSelectorUI RyB;
  private final a.c RyC;
  private final View.OnClickListener mOnClickListener;
  private int nrt;
  private final SimpleDateFormat ucN;
  
  static
  {
    AppMethodBeat.i(282074);
    RyD = new b((byte)0);
    AppMethodBeat.o(282074);
  }
  
  public a(FileSelectorUI paramFileSelectorUI, a.c paramc)
  {
    AppMethodBeat.i(282073);
    this.RyB = paramFileSelectorUI;
    this.RyC = paramc;
    this.BZF = 9;
    this.Gfp = new ArrayList();
    this.BZH = new ArrayList();
    this.nrt = 10;
    this.ucN = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
    this.BZM = ((View.OnLongClickListener)new h(this));
    this.BZN = ((View.OnClickListener)new i(this));
    this.mOnClickListener = ((View.OnClickListener)new g(this));
    notifyDataSetChanged();
    AppMethodBeat.o(282073);
  }
  
  public final GalleryItem.MediaItem SY(int paramInt)
  {
    AppMethodBeat.i(282071);
    if (paramInt >= this.Gfp.size())
    {
      Log.w("MicroMsg.AlbumAdapter", "get item error, media items size[%d], adjustPos[%d]", new Object[] { Integer.valueOf(this.Gfp.size()), Integer.valueOf(paramInt) });
      AppMethodBeat.o(282071);
      return null;
    }
    GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)this.Gfp.get(paramInt);
    AppMethodBeat.o(282071);
    return localMediaItem;
  }
  
  public final boolean aqL(int paramInt)
  {
    AppMethodBeat.i(282063);
    if (getItemViewType(paramInt) == 2)
    {
      AppMethodBeat.o(282063);
      return true;
    }
    AppMethodBeat.o(282063);
    return false;
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(282069);
    p.k(paramViewGroup, "parent");
    switch (paramInt)
    {
    default: 
      paramViewGroup = LayoutInflater.from((Context)this.RyB).inflate(R.i.egY, paramViewGroup, false);
      p.j(paramViewGroup, "LayoutInflater.from(mCon…edia_item, parent, false)");
      paramViewGroup = (RecyclerView.v)new a(paramViewGroup);
      AppMethodBeat.o(282069);
      return paramViewGroup;
    case 2: 
      paramViewGroup = LayoutInflater.from((Context)this.RyB).inflate(R.i.egZ, paramViewGroup, false);
      p.j(paramViewGroup, "LayoutInflater.from(mCon…time_item, parent, false)");
      paramViewGroup = (RecyclerView.v)new a.f(paramViewGroup);
      AppMethodBeat.o(282069);
      return paramViewGroup;
    }
    paramViewGroup = LayoutInflater.from((Context)this.RyB).inflate(R.i.egY, paramViewGroup, false);
    p.j(paramViewGroup, "LayoutInflater.from(mCon…edia_item, parent, false)");
    paramViewGroup = (RecyclerView.v)new a(paramViewGroup);
    AppMethodBeat.o(282069);
    return paramViewGroup;
  }
  
  @SuppressLint({"ResourceType"})
  public final void d(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(282070);
    p.k(paramv, "holder");
    GalleryItem.MediaItem localMediaItem;
    String str2;
    a locala;
    Object localObject1;
    Object localObject2;
    if ((paramv instanceof a))
    {
      paramv.amk.setTag(R.h.item_position, Integer.valueOf(paramInt));
      paramv.amk.setTag(R.h.item_type, Integer.valueOf(1));
      paramv.amk.setOnClickListener(this.mOnClickListener);
      localMediaItem = SY(paramInt);
      if (localMediaItem == null)
      {
        Log.e("MicroMsg.AlbumAdapter", "get item failed");
        AppMethodBeat.o(282070);
        return;
      }
      String str1 = localMediaItem.aZe();
      p.j(str1, "item.thumbPath");
      str2 = localMediaItem.etI();
      p.j(str2, "item.originalPath");
      if ((Util.isNullOrNil(str1)) && (Util.isNullOrNil(str2)))
      {
        Log.e("MicroMsg.AlbumAdapter", "null or nil filepath, poi: %s.", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(282070);
        return;
      }
      locala = (a)paramv;
      locala.BZU.setTag(R.h.item_position, Integer.valueOf(paramInt));
      locala.BZU.setOnClickListener(this.BZN);
      locala.BZS.setVisibility(0);
      locala.BZT.setVisibility(0);
      if (2 != localMediaItem.getType()) {
        break label794;
      }
      locala.BZS.setImageResource(R.k.video_icon_in_gird);
      localObject1 = e.RyH;
      localObject1 = locala.BZT;
      localObject2 = (GalleryItem.VideoMediaItem)localMediaItem;
      if ((localObject1 != null) && (localObject2 != null)) {
        break label594;
      }
      Log.e("MicroMsg.AlbumAdapter", "Error input for duration fetcher");
      localObject1 = this.ucN.format(new Date(localMediaItem.BVm));
      p.j(localObject1, "mDateFormat.format(Date(item.generateDate))");
      localObject1 = paramInt + 1 + ", " + (String)localObject1;
      if (2 != localMediaItem.getType()) {
        break label891;
      }
      localObject1 = "视频 ".concat(String.valueOf(localObject1));
      label340:
      locala.BPW.setContentDescription((CharSequence)localObject1);
      Log.d("MicroMsg.AlbumAdapter", "thumbFilePath: %s | origFilePath: %s | contentDescription %s", new Object[] { str1, str2, localObject1 });
      com.tencent.mm.plugin.gallery.ui.h.a(locala.BPW, localMediaItem.getType(), str1, str2, localMediaItem.BVl, localMediaItem.BVm);
      locala.BZU.setVisibility(0);
      if (!this.BZH.contains(localMediaItem)) {
        break label905;
      }
      locala.BZU.setCheckedNumber(this.BZH.indexOf(localMediaItem) + 1);
      locala.BZR.setBackgroundResource(R.e.UN_BW_0_Alpha_0_5);
      label457:
      if (locala.BZU.getVisibility() != 0) {
        break label928;
      }
      a.fD((View)locala.BZU);
    }
    for (;;)
    {
      locala.kEs.setText((CharSequence)new q(str2).getName());
      locala.umL.setText((CharSequence)Util.getSizeKB(u.bBQ(str2)));
      locala.amk.setOnLongClickListener(this.BZM);
      if (!(paramv instanceof a.f)) {
        break label959;
      }
      paramv.amk.setTag(R.h.item_position, Integer.valueOf(paramInt));
      paramv.amk.setTag(R.h.item_type, Integer.valueOf(2));
      localObject1 = SY(paramInt);
      if (localObject1 != null) {
        break label942;
      }
      Log.e("MicroMsg.AlbumAdapter", "get item failed");
      AppMethodBeat.o(282070);
      return;
      label594:
      if (e.fgE().containsKey(localObject1))
      {
        e locale = (e)e.fgE().get(localObject1);
        if (locale != null)
        {
          if (p.h(e.b(locale), localObject2)) {
            break;
          }
          WeakReference localWeakReference = e.c(locale);
          if (localWeakReference == null) {
            p.iCn();
          }
          if (p.h(localObject1, (TextView)localWeakReference.get()))
          {
            e.d(locale);
            locale.kUn = true;
          }
        }
      }
      if (((GalleryItem.VideoMediaItem)localObject2).maT >= 0)
      {
        Log.i("MicroMsg.AlbumAdapter", "Directly attach durationMs %d to tv, path %s", new Object[] { Integer.valueOf(((GalleryItem.VideoMediaItem)localObject2).maT), localObject2 });
        a.e.a.j((TextView)localObject1, ((GalleryItem.VideoMediaItem)localObject2).maT);
        e.fgE().remove(localObject1);
        break;
      }
      ((TextView)localObject1).setText((CharSequence)"");
      localObject2 = new e((TextView)localObject1, (GalleryItem.VideoMediaItem)localObject2, (a.e.b)new a.e.a.a(), (byte)0);
      com.tencent.mm.plugin.gallery.model.e.etm().av((Runnable)localObject2);
      ((Map)e.fgE()).put(localObject1, localObject2);
      break;
      label794:
      if (n.L(localMediaItem.getMimeType(), "edit", true))
      {
        locala.BZS.setImageResource(R.k.photo_edit_mark);
        locala.BZT.setVisibility(4);
        break;
      }
      if (n.L(localMediaItem.getMimeType(), "image/gif", true))
      {
        locala.BZS.setImageResource(R.g.gif_tips_icon);
        locala.BZT.setVisibility(4);
        break;
      }
      locala.BZS.setVisibility(4);
      locala.BZT.setVisibility(4);
      break;
      label891:
      localObject1 = "图片".concat(String.valueOf(localObject1));
      break label340;
      label905:
      locala.BZU.setChecked(false);
      locala.BZR.setBackgroundResource(R.e.image_gallery_mask);
      break label457;
      label928:
      a.fE((View)locala.BZU);
    }
    label942:
    ((a.f)paramv).timeTv.setText((CharSequence)((GalleryItem.MediaItem)localObject1).BVn);
    label959:
    AppMethodBeat.o(282070);
  }
  
  public final ArrayList<String> eun()
  {
    AppMethodBeat.i(282066);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.BZH.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((GalleryItem.MediaItem)localIterator.next()).AAz);
    }
    AppMethodBeat.o(282066);
    return localArrayList;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(282067);
    int i = this.Gfp.size();
    AppMethodBeat.o(282067);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(282068);
    Object localObject = this.Gfp.get(paramInt);
    p.j(localObject, "allMediaItems[position]");
    if (5 == ((GalleryItem.MediaItem)localObject).getType())
    {
      AppMethodBeat.o(282068);
      return 2;
    }
    AppMethodBeat.o(282068);
    return 1;
  }
  
  public final void j(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(282072);
    if (j.a((Iterable)this.BZH, paramMediaItem))
    {
      int i = j.a((List)this.BZH, paramMediaItem);
      ArrayList localArrayList = new ArrayList();
      int j = this.BZH.size();
      while (i < j)
      {
        localObject = this.BZH.get(i);
        p.j(localObject, "mSelectMediaItems[i]");
        localObject = (GalleryItem.MediaItem)localObject;
        int k = this.Gfp.indexOf(localObject);
        if (k != -1) {
          localArrayList.add(Integer.valueOf(k));
        }
        i += 1;
      }
      Object localObject = (Collection)this.BZH;
      if (localObject == null)
      {
        paramMediaItem = new t("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        AppMethodBeat.o(282072);
        throw paramMediaItem;
      }
      ag.fc(localObject).remove(paramMediaItem);
      paramMediaItem = localArrayList.iterator();
      while (paramMediaItem.hasNext()) {
        cL(((Number)paramMediaItem.next()).intValue());
      }
    }
    AppMethodBeat.o(282072);
  }
  
  public final ArrayList<GalleryItem.MediaItem> jq(List<? extends GalleryItem.MediaItem> paramList)
  {
    AppMethodBeat.i(282065);
    Object localObject = "";
    ArrayList localArrayList = new ArrayList();
    int j = ((Collection)paramList).size();
    int i = 0;
    GalleryItem.MediaItem localMediaItem;
    String str;
    if (i < j)
    {
      localMediaItem = (GalleryItem.MediaItem)paramList.get(i);
      str = f.y((Context)this.RyB, localMediaItem.BVm);
      p.j(str, "TimeUtil.anotherFormatTi…, mediaItem.generateDate)");
      if (p.h(localObject, str)) {
        break label143;
      }
      localObject = new GalleryItem.TimeMediaItem();
      ((GalleryItem.TimeMediaItem)localObject).BVn = str;
      localArrayList.add(localObject);
      localObject = str;
    }
    label143:
    for (;;)
    {
      localMediaItem.BVn = str;
      localArrayList.add(localMediaItem);
      i += 1;
      break;
      AppMethodBeat.o(282065);
      return localArrayList;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$AlbumViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "checkBox", "Lcom/tencent/mm/ui/widget/MMNumberCheckbox;", "getCheckBox", "()Lcom/tencent/mm/ui/widget/MMNumberCheckbox;", "setCheckBox", "(Lcom/tencent/mm/ui/widget/MMNumberCheckbox;)V", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "sizeTv", "getSizeTv", "setSizeTv", "thumbIV", "Landroid/widget/ImageView;", "getThumbIV", "()Landroid/widget/ImageView;", "setThumbIV", "(Landroid/widget/ImageView;)V", "thumbMaskIV", "getThumbMaskIV", "setThumbMaskIV", "typeMaskIV", "getTypeMaskIV", "setTypeMaskIV", "typeMaskTV", "getTypeMaskTV", "setTypeMaskTV", "collapseTouch", "", "delegate", "expandTouch", "app_release"})
  public static final class a
    extends RecyclerView.v
  {
    ImageView BPW;
    ImageView BZR;
    ImageView BZS;
    TextView BZT;
    MMNumberCheckbox BZU;
    TextView kEs;
    TextView umL;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(195892);
      View localView = paramView.findViewById(R.h.media_thumb);
      p.j(localView, "itemView.findViewById(R.id.media_thumb)");
      this.BPW = ((ImageView)localView);
      localView = paramView.findViewById(R.h.media_mask);
      p.j(localView, "itemView.findViewById(R.id.media_mask)");
      this.BZR = ((ImageView)localView);
      localView = paramView.findViewById(R.h.type_mask_iv);
      p.j(localView, "itemView.findViewById(R.id.type_mask_iv)");
      this.BZS = ((ImageView)localView);
      localView = paramView.findViewById(R.h.type_mask_tv);
      p.j(localView, "itemView.findViewById(R.id.type_mask_tv)");
      this.BZT = ((TextView)localView);
      localView = paramView.findViewById(R.h.media_cbx);
      p.j(localView, "itemView.findViewById(R.id.media_cbx)");
      this.BZU = ((MMNumberCheckbox)localView);
      localView = paramView.findViewById(R.h.dMs);
      p.j(localView, "itemView.findViewById(R.id.media_desc_tv)");
      this.kEs = ((TextView)localView);
      paramView = paramView.findViewById(R.h.dMu);
      p.j(paramView, "itemView.findViewById(R.id.media_size_tv)");
      this.umL = ((TextView)paramView);
      AppMethodBeat.o(195892);
    }
    
    public static void fD(View paramView)
    {
      AppMethodBeat.i(195887);
      p.k(paramView, "delegate");
      Object localObject = paramView.getParent();
      if (localObject == null)
      {
        paramView = new t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(195887);
        throw paramView;
      }
      localObject = (View)localObject;
      ((View)localObject).post((Runnable)new a(paramView, (View)localObject));
      AppMethodBeat.o(195887);
    }
    
    public static void fE(View paramView)
    {
      AppMethodBeat.i(195889);
      p.k(paramView, "delegate");
      paramView = paramView.getParent();
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(195889);
        throw paramView;
      }
      ((View)paramView).setTouchDelegate(null);
      AppMethodBeat.o(195889);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(View paramView1, View paramView2) {}
      
      public final void run()
      {
        AppMethodBeat.i(278193);
        Rect localRect = new Rect();
        this.Gfv.getHitRect(localRect);
        localRect.left -= com.tencent.mm.ci.a.fromDPToPix(this.Gfv.getContext(), 20);
        localRect.top -= com.tencent.mm.ci.a.fromDPToPix(this.Gfv.getContext(), 20);
        localRect.right += com.tencent.mm.ci.a.fromDPToPix(this.Gfv.getContext(), 20);
        localRect.bottom += com.tencent.mm.ci.a.fromDPToPix(this.Gfv.getContext(), 20);
        this.AVD.setTouchDelegate(new TouchDelegate(localRect, this.Gfv));
        AppMethodBeat.o(278193);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$Companion;", "", "()V", "ITEM_TYPE_MEDIA", "", "ITEM_TYPE_TIME", "MAX_SELECT_COUNT", "TAG", "", "app_release"})
  public static final class b {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$OnItemClickListener;", "", "onItemClick", "", "position", "", "itemView", "Landroid/view/View;", "itemViewType", "onItemSelect", "isChecked", "", "app_release"})
  public static abstract interface d
  {
    public abstract void a(int paramInt1, View paramView, int paramInt2);
    
    public abstract void bN(int paramInt, boolean paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$SimpleVideoAnalysisTask;", "Ljava/lang/Runnable;", "tv", "Landroid/widget/TextView;", "mediaItem", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;", "listener", "Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$SimpleVideoAnalysisTask$Listener;", "(Landroid/widget/TextView;Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$SimpleVideoAnalysisTask$Listener;)V", "isCancel", "", "tvRef", "Ljava/lang/ref/WeakReference;", "cancel", "", "checkDeviceIsConfiguration", "videoPath", "", "equals", "o", "", "hashCode", "", "loadItemFromExtractor", "loadItemFromSimpleMP4Info", "notifyObserver", "run", "setTextView", "Companion", "Listener", "app_release"})
  public static final class e
    implements Runnable
  {
    private static final HashMap<TextView, e> Cac;
    public static final a.e.a RyH;
    private final GalleryItem.VideoMediaItem Caa;
    private final b RyG;
    boolean kUn;
    private WeakReference<TextView> wzt;
    
    static
    {
      AppMethodBeat.i(277057);
      RyH = new a.e.a((byte)0);
      Cac = new HashMap();
      AppMethodBeat.o(277057);
    }
    
    private e(TextView paramTextView, GalleryItem.VideoMediaItem paramVideoMediaItem, b paramb)
    {
      AppMethodBeat.i(277056);
      this.wzt = new WeakReference(paramTextView);
      this.Caa = paramVideoMediaItem;
      this.RyG = paramb;
      AppMethodBeat.o(277056);
    }
    
    private static boolean aFp(String paramString)
    {
      AppMethodBeat.i(277052);
      Object localObject1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vVw, "");
      p.j(localObject1, "MMKernel.service(IExptSe…device_configuration, \"\")");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        AppMethodBeat.o(277052);
        return false;
      }
      Log.i("MicroMsg.AlbumAdapter", "devices configuration: %s", new Object[] { localObject1 });
      Log.i("MicroMsg.AlbumAdapter", "android version: %s, manufacturer: %s, brand: %s, model: %s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Build.MANUFACTURER, Build.BRAND, Build.MODEL });
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
              Log.i("MicroMsg.AlbumAdapter", "hit devices but it is too big, fileSize: %s, maxSize: %s, filePath: %s", new Object[] { Long.valueOf(l), Integer.valueOf(j), paramString });
              AppMethodBeat.o(277052);
              return false;
            }
            int m = ((JSONObject)localObject2).optInt("androidVersion");
            if (-1 == m)
            {
              Log.i("MicroMsg.AlbumAdapter", "hit devices all version, manufacturer: %s, brand: %s, model: %s", new Object[] { Build.MANUFACTURER, Build.BRAND, Build.MODEL });
              AppMethodBeat.o(277052);
              return true;
            }
            if (Build.VERSION.SDK_INT == m)
            {
              Log.i("MicroMsg.AlbumAdapter", "hit devices, version: %s, manufacturer: %s, brand: %s, model: %s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Build.MANUFACTURER, Build.BRAND, Build.MODEL });
              AppMethodBeat.o(277052);
              return true;
            }
          }
          i += 1;
        }
        return false;
      }
      catch (JSONException paramString)
      {
        Log.printErrStackTrace("MicroMsg.AlbumAdapter", (Throwable)paramString, "parse json error", new Object[0]);
        AppMethodBeat.o(277052);
      }
    }
    
    private final void euu()
    {
      AppMethodBeat.i(277055);
      if (this.Caa == null)
      {
        AppMethodBeat.o(277055);
        return;
      }
      long l = Util.currentTicks();
      try
      {
        String str = this.Caa.aZe();
        p.j(str, "mediaItem.thumbPath");
        Object localObject = SightVideoJNI.getSimpleMp4InfoVFS(str);
        p.j(localObject, "SightVideoJNI.getSimpleMp4InfoVFS(path)");
        Log.d("MicroMsg.AlbumAdapter", "get simple mp4 info %s", new Object[] { localObject });
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
        Log.d("MicroMsg.AlbumAdapter", "loadItemFromSimpleMP4Info mediaItem: %s", new Object[] { this.Caa });
        Log.i("MicroMsg.AlbumAdapter", "loadItemFromSimpleMP4Info used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
        AppMethodBeat.o(277055);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.AlbumAdapter", (Throwable)localException, "loadItemFromSimpleMP4Info fail", new Object[0]);
        }
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(277045);
      if (!(paramObject instanceof e))
      {
        AppMethodBeat.o(277045);
        return false;
      }
      boolean bool = p.h(this.Caa, ((e)paramObject).Caa);
      AppMethodBeat.o(277045);
      return bool;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(277046);
      GalleryItem.VideoMediaItem localVideoMediaItem = this.Caa;
      if (localVideoMediaItem != null)
      {
        int i = localVideoMediaItem.hashCode();
        AppMethodBeat.o(277046);
        return i;
      }
      AppMethodBeat.o(277046);
      return 0;
    }
    
    public final void run()
    {
      AppMethodBeat.i(277050);
      if (this.kUn)
      {
        AppMethodBeat.o(277050);
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
      label164:
      long l;
      com.tencent.mm.compatible.i.c localc;
      String str1;
      if (aFp((String)localObject1))
      {
        euu();
        if (this.kUn) {
          break label887;
        }
        if (!p.h(Looper.myLooper(), Looper.getMainLooper())) {
          break label873;
        }
        localObject1 = this.RyG;
        if (localObject1 != null)
        {
          localObject4 = this.Caa;
          if (localObject4 == null) {
            p.iCn();
          }
          ((b)localObject1).a(this, ((GalleryItem.VideoMediaItem)localObject4).maT);
          AppMethodBeat.o(277050);
        }
      }
      else
      {
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vUO, 0) == 1) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label164;
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
      label909:
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
              Log.d("MicroMsg.AlbumAdapter", "find video mime : not found.");
              localObject7 = localObject4;
              localObject8 = localObject1;
              break label894;
            }
            str2 = localMediaFormat.getString("mime");
            Log.d("MicroMsg.AlbumAdapter", "find video mime : %s", new Object[] { str2 });
            localObject7 = localObject4;
            localObject8 = localObject1;
            if (str2 == null) {
              break label894;
            }
            if (!n.M(str2, "video/", false)) {
              continue;
            }
            localObject5 = localObject4;
            localObject6 = localObject1;
            if (localObject1 != null) {
              break label909;
            }
            localObject6 = localMediaFormat;
            localObject5 = localObject4;
            break label909;
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
          Log.d("MicroMsg.AlbumAdapter", "loadItemFromExtractor mediaItem: %s", new Object[] { this.Caa });
          Log.d("MicroMsg.AlbumAdapter", "mediaItem format:%s, videoPath:%s", new Object[] { localObject6, str1 });
          localc.release();
        }
        catch (Exception localException)
        {
          MediaFormat localMediaFormat;
          String str2;
          Log.d("MicroMsg.AlbumAdapter", "Video extractor init failed. video path = [%s] e = [%s]", new Object[] { str1, localException.getMessage() });
          localc.release();
          continue;
        }
        finally
        {
          localc.release();
          AppMethodBeat.o(277050);
        }
        Log.i("MicroMsg.AlbumAdapter", "loadItemFromExtractor used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
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
            break label909;
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
            AppMethodBeat.o(277050);
            return;
            label873:
            MMHandlerThread.postToMainThread((Runnable)new c(this));
            label887:
            AppMethodBeat.o(277050);
            return;
          }
        }
        label894:
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
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$SimpleVideoAnalysisTask$Companion$fetchDurationMs$task$1", "Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$SimpleVideoAnalysisTask$Listener;", "onResult", "", "task", "Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$SimpleVideoAnalysisTask;", "durationMs", "", "app_release"})
    public static final class a$a
      implements a.e.b
    {
      public final void a(a.e parame, int paramInt)
      {
        AppMethodBeat.i(285295);
        if (parame != null) {}
        for (Object localObject = a.e.c(parame); localObject == null; localObject = null)
        {
          AppMethodBeat.o(285295);
          return;
        }
        parame = a.e.c(parame);
        if (parame == null) {
          p.iCn();
        }
        parame = (TextView)parame.get();
        if (parame == null)
        {
          AppMethodBeat.o(285295);
          return;
        }
        localObject = a.e.RyH;
        a.e.a.j(parame, paramInt);
        a.e.fgE().remove(parame);
        AppMethodBeat.o(285295);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$SimpleVideoAnalysisTask$Listener;", "", "onResult", "", "task", "Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$SimpleVideoAnalysisTask;", "durationMs", "", "app_release"})
    static abstract interface b
    {
      public abstract void a(a.e parame, int paramInt);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class c
      implements Runnable
    {
      c(a.e parame) {}
      
      public final void run()
      {
        AppMethodBeat.i(288814);
        a.e.b localb = a.e.a(this.RyI);
        if (localb != null)
        {
          a.e locale = this.RyI;
          GalleryItem.VideoMediaItem localVideoMediaItem = a.e.b(this.RyI);
          if (localVideoMediaItem == null) {
            p.iCn();
          }
          localb.a(locale, localVideoMediaItem.maT);
          AppMethodBeat.o(288814);
          return;
        }
        AppMethodBeat.o(288814);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(196988);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$mOnClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      localObject = paramView.getTag(R.h.item_position);
      int i;
      if ((localObject instanceof Integer))
      {
        i = ((Number)localObject).intValue();
        localObject = paramView.getTag(R.h.item_type);
        if (!(localObject instanceof Integer)) {
          break label156;
        }
      }
      label156:
      for (int j = ((Number)localObject).intValue();; j = -1)
      {
        if ((i != -1) && (j != -1) && (a.c(this.RyJ) != null))
        {
          localObject = a.c(this.RyJ);
          if (localObject != null) {
            ((a.d)localObject).a(i, paramView, j);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$mOnClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196988);
        return;
        i = -1;
        break;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$onItemViewLongClick$1", "Landroid/view/View$OnLongClickListener;", "onLongClick", "", "v", "Landroid/view/View;", "app_release"})
  public static final class h
    implements View.OnLongClickListener
  {
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(292388);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$onItemViewLongClick$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
      p.k(paramView, "v");
      paramView = paramView.getTag(R.h.item_position);
      p.j(paramView, "v.getTag(R.id.item_position)");
      if ((paramView instanceof Integer))
      {
        paramView = this.RyJ.SY(((Number)paramView).intValue());
        if (paramView != null) {
          ClipboardHelper.setText((Context)a.a(this.RyJ), (CharSequence)"media info", (CharSequence)paramView.toString());
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$onItemViewLongClick$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(292388);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$selectListener$1", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "app_release"})
  public static final class i
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(279419);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$selectListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      p.k(paramView, "v");
      localObject1 = paramView.getTag(R.h.item_position);
      p.j(localObject1, "v.getTag(R.id.item_position)");
      if (!(localObject1 instanceof Integer))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$selectListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(279419);
        return;
      }
      int n = ((Number)localObject1).intValue();
      localObject1 = this.RyJ.SY(n);
      if ((localObject1 == null) || (Util.isNullOrNil(((GalleryItem.MediaItem)localObject1).AAz)))
      {
        Log.e("MicroMsg.AlbumAdapter", "[onClick] null == item!");
        this.RyJ.cL(n);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$selectListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(279419);
        return;
      }
      Log.i("MicroMsg.AlbumAdapter", "click image path:" + ((GalleryItem.MediaItem)localObject1).AAz);
      int j;
      if (a.b(this.RyJ).contains(localObject1))
      {
        a.b(this.RyJ).indexOf(localObject1);
        this.RyJ.j((GalleryItem.MediaItem)localObject1);
        int k = 0;
        int m = 1;
        paramView = a.c(this.RyJ);
        j = m;
        i = k;
        if (paramView != null)
        {
          paramView.bN(n, false);
          i = k;
          j = m;
        }
        if (i == 0)
        {
          paramView = a.g(this.RyJ);
          if (paramView != null) {
            paramView.ak(this.RyJ.BZH.size(), n, j);
          }
          label292:
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$selectListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(279419);
        }
      }
      else
      {
        Object localObject2 = com.tencent.mm.plugin.gallery.model.e.etl();
        p.j(localObject2, "GalleryCore.getMediaQueryService()");
        if ((((o)localObject2).etR() == 3) && (n.L(((GalleryItem.MediaItem)localObject1).getMimeType(), "image/gif", true)))
        {
          localObject2 = com.tencent.mm.kernel.h.ag(d.class);
          p.j(localObject2, "MMKernel.plugin(IPluginEmoji::class.java)");
          if (!((d)localObject2).getProvider().aus(((GalleryItem.MediaItem)localObject1).etI()))
          {
            l1 = u.bBQ(((GalleryItem.MediaItem)localObject1).etI());
            com.tencent.mm.plugin.gallery.a.e.bt(13459, l1 + ",1,,0");
            com.tencent.mm.ui.base.h.cL((Context)a.a(this.RyJ), a.a(this.RyJ).getString(R.l.gallery_select_gif_to_big));
            this.RyJ.cL(n);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$selectListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(279419);
            return;
          }
        }
        if ((!Util.isNullOrNil(a.d(this.RyJ))) && (p.h(a.d(this.RyJ), "album_business_byp")) && (n.L(((GalleryItem.MediaItem)localObject1).getMimeType(), "image/gif", true)))
        {
          localObject2 = com.tencent.mm.kernel.h.ag(d.class);
          p.j(localObject2, "MMKernel.plugin(IPluginEmoji::class.java)");
          if (!((d)localObject2).getProvider().aut(((GalleryItem.MediaItem)localObject1).etI()))
          {
            com.tencent.mm.ui.base.h.cL((Context)a.a(this.RyJ), a.a(this.RyJ).getString(R.l.gallery_no_support_giant_gif_gamelife));
            this.RyJ.cL(n);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$selectListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(279419);
            return;
          }
        }
        long l1 = u.bBQ(((GalleryItem.MediaItem)localObject1).etI());
        long l2 = com.tencent.mm.n.c.awK();
        if (l1 > l2)
        {
          w.makeText((Context)a.a(this.RyJ), (CharSequence)a.a(this.RyJ).getString(R.l.eET, new Object[] { Util.getSizeKB(l2) }), 0).show();
          this.RyJ.cL(n);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$selectListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(279419);
          return;
        }
        if ((localObject1 instanceof GalleryItem.VideoMediaItem))
        {
          localObject2 = com.tencent.mm.plugin.gallery.model.e.etl();
          p.j(localObject2, "GalleryCore.getMediaQueryService()");
          if (((o)localObject2).etR() == 25)
          {
            l1 = a.hnX();
            l2 = a.hnY();
            i = ((GalleryItem.VideoMediaItem)localObject1).maT;
            localObject2 = com.tencent.mm.modelcontrol.e.bkp();
            p.j(localObject2, "SubCoreVideoControl.getCore()");
            if (i < ((com.tencent.mm.modelcontrol.e)localObject2).bkv().minDuration * 1000)
            {
              localObject1 = (Context)a.a(this.RyJ);
              localObject2 = a.a(this.RyJ).getResources();
              i = R.l.gallery_video_duration_below;
              com.tencent.mm.modelcontrol.e locale = com.tencent.mm.modelcontrol.e.bkp();
              p.j(locale, "SubCoreVideoControl.getCore()");
              com.tencent.mm.ui.base.h.a((Context)localObject1, ((Resources)localObject2).getString(i, new Object[] { Integer.valueOf(locale.bkv().minDuration) }), "", false, (DialogInterface.OnClickListener)new a(paramView));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$selectListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(279419);
              return;
            }
            if (((GalleryItem.VideoMediaItem)localObject1).maT > l1 * 1000L)
            {
              com.tencent.mm.ui.base.h.a((Context)a.a(this.RyJ), a.a(this.RyJ).getResources().getString(R.l.gallery_video_duration_limit, new Object[] { Long.valueOf(l2) }), "", false, (DialogInterface.OnClickListener)new b(paramView));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$selectListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(279419);
              return;
            }
          }
          if ((!Util.isNullOrNil(a.d(this.RyJ))) && (p.h(a.d(this.RyJ), "album_business_bubble_media_by_coordinate")) && (((GalleryItem.VideoMediaItem)localObject1).maT >= a.e(this.RyJ) * 1000 + 500))
          {
            com.tencent.mm.ui.base.h.cL((Context)a.a(this.RyJ), a.a(this.RyJ).getResources().getString(R.l.gallery_video_duration_limit, new Object[] { Integer.valueOf(a.e(this.RyJ)) }));
            this.RyJ.cL(n);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$selectListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(279419);
            return;
          }
        }
        if (a.a(this.RyJ).hnf() + a.b(this.RyJ).size() >= a.f(this.RyJ)) {
          break label1253;
        }
        a.b(this.RyJ).add(localObject1);
        paramView = a.c(this.RyJ);
        if (paramView != null) {
          paramView.bN(n, true);
        }
        a.b(this.RyJ).size();
      }
      label1253:
      for (int i = 0;; i = 1)
      {
        j = 0;
        this.RyJ.cL(n);
        break;
        w.makeText((Context)a.a(this.RyJ), (CharSequence)a.a(this.RyJ).getString(R.l.eEU, new Object[] { Integer.valueOf(a.f(this.RyJ)) }), 0).show();
        break label292;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$selectListener$1$onClick$1", "Landroid/content/DialogInterface$OnClickListener;", "onClick", "", "dialog", "Landroid/content/DialogInterface;", "which", "", "app_release"})
    public static final class a
      implements DialogInterface.OnClickListener
    {
      a(View paramView) {}
      
      public final void onClick(DialogInterface paramDialogInterface, int paramInt)
      {
        AppMethodBeat.i(279574);
        p.k(paramDialogInterface, "dialog");
        if ((this.jLx instanceof MMNumberCheckbox)) {
          ((MMNumberCheckbox)this.jLx).setChecked(false);
        }
        AppMethodBeat.o(279574);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$selectListener$1$onClick$2", "Landroid/content/DialogInterface$OnClickListener;", "onClick", "", "dialog", "Landroid/content/DialogInterface;", "which", "", "app_release"})
    public static final class b
      implements DialogInterface.OnClickListener
    {
      b(View paramView) {}
      
      public final void onClick(DialogInterface paramDialogInterface, int paramInt)
      {
        AppMethodBeat.i(283028);
        p.k(paramDialogInterface, "dialog");
        if ((this.jLx instanceof MMNumberCheckbox)) {
          ((MMNumberCheckbox)this.jLx).setChecked(false);
        }
        AppMethodBeat.o(283028);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */