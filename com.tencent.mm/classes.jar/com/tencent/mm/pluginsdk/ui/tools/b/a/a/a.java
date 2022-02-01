package com.tencent.mm.pluginsdk.ui.tools.b.a.a;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.emoji.c.d;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.TimeMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.g;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.MMNumberCheckbox;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
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
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.an;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter;", "Lcom/tencent/mm/pluginsdk/ui/pin/PinnedHeaderAdapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mContext", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "mOnSelectItemChanged", "Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$IOnSelectItemChanged;", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$IOnSelectItemChanged;)V", "allMediaItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lkotlin/collections/ArrayList;", "businessTag", "", "mDateFormat", "Ljava/text/SimpleDateFormat;", "mOnClickListener", "Landroid/view/View$OnClickListener;", "mOnItemClickListener", "Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$OnItemClickListener;", "mSelectMediaItems", "maxDurationSec", "", "getMaxDurationSec", "()I", "maxDurationTip", "getMaxDurationTip", "mediaCount", "getMediaCount", "onItemViewLongClick", "Landroid/view/View$OnLongClickListener;", "selectLimitCount", "selectListener", "selectedItemCount", "getSelectedItemCount", "mediaItems", "selectedMediaItems", "getSelectedMediaItems", "()Ljava/util/ArrayList;", "setSelectedMediaItems", "(Ljava/util/ArrayList;)V", "selectedPaths", "selectedMediaPaths", "getSelectedMediaPaths", "setSelectedMediaPaths", "videoMaxDuration", "addMediaItems", "", "Ljava/util/LinkedList;", "clear", "filterTimeMedia", "", "fixedMediaItemListWithTimeItem", "getAllMediaItem", "getItem", "position", "getItemCount", "getItemViewType", "getItemWithOutAdjust", "isPinnedPosition", "", "notifySelectedItemsAllChanged", "notifiedItems", "Landroidx/collection/ArraySet;", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeSelectedItemWithNotifyChanged", "item", "setMediaItems", "setOnItemClickListener", "onItemClickListener", "setSelectLimitCount", "count", "AlbumViewHolder", "Companion", "IOnSelectItemChanged", "OnItemClickListener", "SimpleVideoAnalysisTask", "TimeViewHolder", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.pluginsdk.ui.pin.b<RecyclerView.v>
{
  public static final a.b YuX;
  public final ArrayList<GalleryItem.MediaItem> HLB;
  private String HLD;
  private final View.OnLongClickListener HLH;
  private final View.OnClickListener HLI;
  public int HLz;
  public ArrayList<GalleryItem.MediaItem> MaJ;
  private final FileSelectorUI YuY;
  private final a.c YuZ;
  public d Yva;
  private final View.OnClickListener mOnClickListener;
  private int qqa;
  private final SimpleDateFormat xiR;
  
  static
  {
    AppMethodBeat.i(245894);
    YuX = new a.b((byte)0);
    AppMethodBeat.o(245894);
  }
  
  public a(FileSelectorUI paramFileSelectorUI, a.c paramc)
  {
    AppMethodBeat.i(245867);
    this.YuY = paramFileSelectorUI;
    this.YuZ = paramc;
    this.HLz = 9;
    this.MaJ = new ArrayList();
    this.HLB = new ArrayList();
    this.qqa = 10;
    this.xiR = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
    this.HLH = ((View.OnLongClickListener)new g(this));
    this.HLI = ((View.OnClickListener)new h(this));
    this.mOnClickListener = new a..ExternalSyntheticLambda0(this);
    this.bZE.notifyChanged();
    AppMethodBeat.o(245867);
  }
  
  private static final void a(a parama, View paramView)
  {
    AppMethodBeat.i(245877);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    localObject = paramView.getTag(R.h.item_position);
    int i;
    if ((localObject instanceof Integer))
    {
      i = ((Number)localObject).intValue();
      localObject = paramView.getTag(R.h.item_type);
      if (!(localObject instanceof Integer)) {
        break label176;
      }
    }
    label176:
    for (int j = ((Number)localObject).intValue();; j = -1)
    {
      if ((i != -1) && (j != -1) && (parama.Yva != null))
      {
        parama = parama.Yva;
        if (parama != null) {
          parama.a(i, paramView, j);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(245877);
      return;
      i = -1;
      break;
    }
  }
  
  public static ArrayList<GalleryItem.MediaItem> mB(List<? extends GalleryItem.MediaItem> paramList)
  {
    AppMethodBeat.i(245870);
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)paramList.next();
        if (5 != localMediaItem.getType()) {
          localArrayList.add(localMediaItem);
        }
      }
    }
    AppMethodBeat.o(245870);
    return localArrayList;
  }
  
  public final GalleryItem.MediaItem WF(int paramInt)
  {
    AppMethodBeat.i(245912);
    if (paramInt >= this.MaJ.size())
    {
      Log.w("MicroMsg.AlbumAdapter", "get item error, media items size[%d], adjustPos[%d]", new Object[] { Integer.valueOf(this.MaJ.size()), Integer.valueOf(paramInt) });
      AppMethodBeat.o(245912);
      return null;
    }
    GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)this.MaJ.get(paramInt);
    AppMethodBeat.o(245912);
    return localMediaItem;
  }
  
  public final boolean awR(int paramInt)
  {
    AppMethodBeat.i(245901);
    if (getItemViewType(paramInt) == 2)
    {
      AppMethodBeat.o(245901);
      return true;
    }
    AppMethodBeat.o(245901);
    return false;
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(245909);
    s.u(paramViewGroup, "parent");
    switch (paramInt)
    {
    default: 
      paramViewGroup = LayoutInflater.from((Context)this.YuY).inflate(R.i.gjU, paramViewGroup, false);
      s.s(paramViewGroup, "from(mContext).inflate(R…edia_item, parent, false)");
      paramViewGroup = (RecyclerView.v)new a.a(paramViewGroup);
      AppMethodBeat.o(245909);
      return paramViewGroup;
    case 2: 
      paramViewGroup = LayoutInflater.from((Context)this.YuY).inflate(R.i.gjV, paramViewGroup, false);
      s.s(paramViewGroup, "from(mContext).inflate(R…time_item, parent, false)");
      paramViewGroup = (RecyclerView.v)new a.f(paramViewGroup);
      AppMethodBeat.o(245909);
      return paramViewGroup;
    }
    paramViewGroup = LayoutInflater.from((Context)this.YuY).inflate(R.i.gjU, paramViewGroup, false);
    s.s(paramViewGroup, "from(mContext).inflate(R…edia_item, parent, false)");
    paramViewGroup = (RecyclerView.v)new a.a(paramViewGroup);
    AppMethodBeat.o(245909);
    return paramViewGroup;
  }
  
  public final void d(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(245910);
    s.u(paramv, "holder");
    GalleryItem.MediaItem localMediaItem;
    String str2;
    a.a locala;
    Object localObject1;
    Object localObject2;
    if ((paramv instanceof a.a))
    {
      paramv.caK.setTag(R.h.item_position, Integer.valueOf(paramInt));
      paramv.caK.setTag(R.h.item_type, Integer.valueOf(1));
      paramv.caK.setOnClickListener(this.mOnClickListener);
      localMediaItem = WF(paramInt);
      if (localMediaItem == null)
      {
        Log.e("MicroMsg.AlbumAdapter", "get item failed");
        AppMethodBeat.o(245910);
        return;
      }
      String str1 = localMediaItem.bud();
      s.s(str1, "item.thumbPath");
      str2 = localMediaItem.Gcc;
      s.s(str2, "item.originalPath");
      if ((Util.isNullOrNil(str1)) && (Util.isNullOrNil(str2)))
      {
        Log.e("MicroMsg.AlbumAdapter", "null or nil filepath, poi: %s.", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(245910);
        return;
      }
      locala = (a.a)paramv;
      locala.HLT.setTag(R.h.item_position, Integer.valueOf(paramInt));
      locala.HLT.setOnClickListener(this.HLI);
      locala.HLO.setVisibility(0);
      locala.HLP.setVisibility(0);
      if (2 != localMediaItem.getType()) {
        break label785;
      }
      locala.HLO.setImageResource(R.k.video_icon_in_gird);
      localObject1 = e.Yvd;
      localObject1 = locala.HLP;
      localObject2 = (GalleryItem.VideoMediaItem)localMediaItem;
      if ((localObject1 != null) && (localObject2 != null)) {
        break label591;
      }
      Log.e("MicroMsg.AlbumAdapter", "Error input for duration fetcher");
      localObject1 = this.xiR.format(new Date(localMediaItem.HHK));
      s.s(localObject1, "mDateFormat.format(Date(item.generateDate))");
      localObject1 = paramInt + 1 + ", " + (String)localObject1;
      if (2 != localMediaItem.getType()) {
        break label882;
      }
      localObject1 = s.X("视频 ", localObject1);
      label337:
      locala.HLM.setContentDescription((CharSequence)localObject1);
      Log.d("MicroMsg.AlbumAdapter", "thumbFilePath: %s | origFilePath: %s | contentDescription %s", new Object[] { str1, str2, localObject1 });
      com.tencent.mm.plugin.gallery.ui.h.a(locala.HLM, localMediaItem.getType(), str1, str2, localMediaItem.HHJ, localMediaItem.HHK);
      locala.HLT.setVisibility(0);
      if (!this.HLB.contains(localMediaItem)) {
        break label893;
      }
      locala.HLT.setCheckedNumber(this.HLB.indexOf(localMediaItem) + 1);
      locala.HLN.setBackgroundResource(R.e.UN_BW_0_Alpha_0_5);
      label454:
      if (locala.HLT.getVisibility() != 0) {
        break label916;
      }
      a.a.iq((View)locala.HLT);
    }
    for (;;)
    {
      locala.descTv.setText((CharSequence)new u(str2).getName());
      locala.xsX.setText((CharSequence)Util.getSizeKB(y.bEl(str2)));
      locala.caK.setOnLongClickListener(this.HLH);
      if (!(paramv instanceof a.f)) {
        break label947;
      }
      paramv.caK.setTag(R.h.item_position, Integer.valueOf(paramInt));
      paramv.caK.setTag(R.h.item_type, Integer.valueOf(2));
      localObject1 = WF(paramInt);
      if (localObject1 != null) {
        break label930;
      }
      Log.e("MicroMsg.AlbumAdapter", "get item failed");
      AppMethodBeat.o(245910);
      return;
      label591:
      if (e.gqi().containsKey(localObject1))
      {
        e locale = (e)e.gqi().get(localObject1);
        if (locale != null)
        {
          if (s.p(e.b(locale), localObject2)) {
            break;
          }
          WeakReference localWeakReference = e.c(locale);
          s.checkNotNull(localWeakReference);
          if (s.p(localObject1, localWeakReference.get()))
          {
            e.d(locale);
            locale.nzW = true;
          }
        }
      }
      if (((GalleryItem.VideoMediaItem)localObject2).oTN >= 0)
      {
        Log.i("MicroMsg.AlbumAdapter", "Directly attach durationMs %d to tv, path %s", new Object[] { Integer.valueOf(((GalleryItem.VideoMediaItem)localObject2).oTN), localObject2 });
        a.e.a.l((TextView)localObject1, ((GalleryItem.VideoMediaItem)localObject2).oTN);
        e.gqi().remove(localObject1);
        break;
      }
      ((TextView)localObject1).setText((CharSequence)"");
      localObject2 = new e((TextView)localObject1, (GalleryItem.VideoMediaItem)localObject2, (a.e.b)new a.e.a.a(), (byte)0);
      com.tencent.mm.plugin.gallery.model.e.fAo().aF((Runnable)localObject2);
      ((Map)e.gqi()).put(localObject1, localObject2);
      break;
      label785:
      if (n.T(localMediaItem.mMimeType, "edit", true))
      {
        locala.HLO.setImageResource(R.k.photo_edit_mark);
        locala.HLP.setVisibility(4);
        break;
      }
      if (n.T(localMediaItem.mMimeType, "image/gif", true))
      {
        locala.HLO.setImageResource(R.g.gif_tips_icon);
        locala.HLP.setVisibility(4);
        break;
      }
      locala.HLO.setVisibility(4);
      locala.HLP.setVisibility(4);
      break;
      label882:
      localObject1 = s.X("图片", localObject1);
      break label337;
      label893:
      locala.HLT.setChecked(false);
      locala.HLN.setBackgroundResource(R.e.image_gallery_mask);
      break label454;
      label916:
      a.a.ir((View)locala.HLT);
    }
    label930:
    ((a.f)paramv).timeTv.setText((CharSequence)((GalleryItem.MediaItem)localObject1).HHL);
    label947:
    AppMethodBeat.o(245910);
  }
  
  public final ArrayList<String> fBk()
  {
    AppMethodBeat.i(245906);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.HLB.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      s.s(localObject, "mSelectMediaItems");
      localArrayList.add(((GalleryItem.MediaItem)localObject).Gcc);
    }
    AppMethodBeat.o(245906);
    return localArrayList;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(245907);
    int i = this.MaJ.size();
    AppMethodBeat.o(245907);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(245908);
    if (5 == ((GalleryItem.MediaItem)this.MaJ.get(paramInt)).getType())
    {
      AppMethodBeat.o(245908);
      return 2;
    }
    AppMethodBeat.o(245908);
    return 1;
  }
  
  public final void i(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(245913);
    int i;
    Object localObject1;
    int k;
    if (p.a((Iterable)this.HLB, paramMediaItem))
    {
      i = p.a((List)this.HLB, paramMediaItem);
      localObject1 = new ArrayList();
      k = this.HLB.size();
      if (i >= k) {}
    }
    for (;;)
    {
      int j = i + 1;
      Object localObject2 = this.HLB.get(i);
      s.s(localObject2, "mSelectMediaItems[i]");
      localObject2 = (GalleryItem.MediaItem)localObject2;
      i = this.MaJ.indexOf(localObject2);
      if (i != -1) {
        ((ArrayList)localObject1).add(Integer.valueOf(i));
      }
      if (j >= k)
      {
        localObject2 = (Collection)this.HLB;
        if (localObject2 == null)
        {
          paramMediaItem = new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
          AppMethodBeat.o(245913);
          throw paramMediaItem;
        }
        an.hA(localObject2).remove(paramMediaItem);
        paramMediaItem = ((ArrayList)localObject1).iterator();
        while (paramMediaItem.hasNext())
        {
          localObject1 = paramMediaItem.next();
          s.s(localObject1, "notifiedItems");
          fV(((Number)localObject1).intValue());
        }
        AppMethodBeat.o(245913);
        return;
      }
      i = j;
    }
  }
  
  public final ArrayList<GalleryItem.MediaItem> mC(List<? extends GalleryItem.MediaItem> paramList)
  {
    AppMethodBeat.i(245904);
    Object localObject = "";
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int k = paramList.size() - 1;
    if (k >= 0) {}
    for (;;)
    {
      int j = i + 1;
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)paramList.get(i);
      String str = com.tencent.mm.pluginsdk.platformtools.f.B((Context)this.YuY, localMediaItem.HHK);
      s.s(str, "anotherFormatTimeInList(…, mediaItem.generateDate)");
      if (!s.p(localObject, str))
      {
        localObject = new GalleryItem.TimeMediaItem();
        ((GalleryItem.TimeMediaItem)localObject).HHL = str;
        localArrayList.add(localObject);
        localObject = str;
      }
      for (;;)
      {
        localMediaItem.HHL = str;
        localArrayList.add(localMediaItem);
        if (j <= k) {
          break;
        }
        AppMethodBeat.o(245904);
        return localArrayList;
      }
      i = j;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$OnItemClickListener;", "", "onItemClick", "", "position", "", "itemView", "Landroid/view/View;", "itemViewType", "onItemSelect", "isChecked", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface d
  {
    public abstract void a(int paramInt1, View paramView, int paramInt2);
    
    public abstract void cv(int paramInt, boolean paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$SimpleVideoAnalysisTask;", "Ljava/lang/Runnable;", "tv", "Landroid/widget/TextView;", "mediaItem", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;", "listener", "Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$SimpleVideoAnalysisTask$Listener;", "(Landroid/widget/TextView;Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$SimpleVideoAnalysisTask$Listener;)V", "isCancel", "", "tvRef", "Ljava/lang/ref/WeakReference;", "cancel", "", "checkDeviceIsConfiguration", "videoPath", "", "equals", "o", "", "hashCode", "", "loadItemFromExtractor", "loadItemFromSimpleMP4Info", "notifyObserver", "run", "setTextView", "Companion", "Listener", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements Runnable
  {
    private static final HashMap<TextView, e> HMb;
    public static final a.e.a Yvd;
    private final GalleryItem.VideoMediaItem HLZ;
    private final b Yve;
    boolean nzW;
    private WeakReference<TextView> zVE;
    
    static
    {
      AppMethodBeat.i(245869);
      Yvd = new a.e.a((byte)0);
      HMb = new HashMap();
      AppMethodBeat.o(245869);
    }
    
    private e(TextView paramTextView, GalleryItem.VideoMediaItem paramVideoMediaItem, b paramb)
    {
      AppMethodBeat.i(245834);
      this.zVE = new WeakReference(paramTextView);
      this.HLZ = paramVideoMediaItem;
      this.Yve = paramb;
      AppMethodBeat.o(245834);
    }
    
    private static final void a(e parame)
    {
      AppMethodBeat.i(245856);
      s.u(parame, "this$0");
      b localb = parame.Yve;
      if (localb != null)
      {
        GalleryItem.VideoMediaItem localVideoMediaItem = parame.HLZ;
        s.checkNotNull(localVideoMediaItem);
        localb.a(parame, localVideoMediaItem.oTN);
      }
      AppMethodBeat.o(245856);
    }
    
    private static boolean aBm(String paramString)
    {
      AppMethodBeat.i(245845);
      Object localObject1 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zoa, "");
      s.s(localObject1, "service(IExptService::cl…device_configuration, \"\")");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        AppMethodBeat.o(245845);
        return false;
      }
      Log.i("MicroMsg.AlbumAdapter", "devices configuration: %s", new Object[] { localObject1 });
      Log.i("MicroMsg.AlbumAdapter", "android version: %s, manufacturer: %s, brand: %s, model: %s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Build.MANUFACTURER, Build.BRAND, com.tencent.mm.compatible.deviceinfo.q.aPo() });
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        localObject2 = ((JSONObject)localObject1).optString("devices");
        s.s(localObject2, "`object`.optString(\"devices\")");
        k = ((JSONObject)localObject1).optInt("maxsize");
        localObject1 = new JSONArray((String)localObject2);
        m = ((JSONArray)localObject1).length();
        if (m <= 0) {
          break label391;
        }
        i = 0;
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          Object localObject2;
          int k;
          int m;
          int j;
          long l;
          Log.printErrStackTrace("MicroMsg.AlbumAdapter", (Throwable)paramString, "parse json error", new Object[0]);
          continue;
          int i = j;
        }
      }
      j = i + 1;
      localObject2 = ((JSONArray)localObject1).optJSONObject(i);
      s.s(localObject2, "array.optJSONObject(i)");
      if ((n.T(Build.MANUFACTURER, ((JSONObject)localObject2).optString("brand"), true)) && (n.T(com.tencent.mm.compatible.deviceinfo.q.aPo(), ((JSONObject)localObject2).optString("model"), true)))
      {
        l = y.bEl(paramString);
        if ((k != 0) && (l > k * 1024 * 1024))
        {
          Log.i("MicroMsg.AlbumAdapter", "hit devices but it is too big, fileSize: %s, maxSize: %s, filePath: %s", new Object[] { Long.valueOf(l), Integer.valueOf(k), paramString });
          AppMethodBeat.o(245845);
          return false;
        }
        i = ((JSONObject)localObject2).optInt("androidVersion");
        if (-1 == i)
        {
          Log.i("MicroMsg.AlbumAdapter", "hit devices all version, manufacturer: %s, brand: %s, model: %s", new Object[] { Build.MANUFACTURER, Build.BRAND, com.tencent.mm.compatible.deviceinfo.q.aPo() });
          AppMethodBeat.o(245845);
          return true;
        }
        if (Build.VERSION.SDK_INT == i)
        {
          Log.i("MicroMsg.AlbumAdapter", "hit devices, version: %s, manufacturer: %s, brand: %s, model: %s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Build.MANUFACTURER, Build.BRAND, com.tencent.mm.compatible.deviceinfo.q.aPo() });
          AppMethodBeat.o(245845);
          return true;
        }
      }
      if (j >= m)
      {
        label391:
        AppMethodBeat.o(245845);
        return false;
      }
    }
    
    private final void fBo()
    {
      AppMethodBeat.i(245852);
      if (this.HLZ == null)
      {
        AppMethodBeat.o(245852);
        return;
      }
      long l = Util.currentTicks();
      try
      {
        String str = this.HLZ.bud();
        s.s(str, "mediaItem.thumbPath");
        Object localObject = SightVideoJNI.getSimpleMp4InfoVFS(str);
        s.s(localObject, "getSimpleMp4InfoVFS(path)");
        Log.d("MicroMsg.AlbumAdapter", "get simple mp4 info %s", new Object[] { localObject });
        localObject = new JSONObject((String)localObject);
        this.HLZ.oTN = ((JSONObject)localObject).getInt("videoDuration");
        this.HLZ.videoHeight = ((JSONObject)localObject).getInt("videoHeight");
        this.HLZ.videoWidth = ((JSONObject)localObject).getInt("videoWidth");
        this.HLZ.videoBitRate = ((JSONObject)localObject).getInt("videoBitrate");
        this.HLZ.videoFrameRate = ((JSONObject)localObject).getInt("videoFPS");
        this.HLZ.nCg = SightVideoJNI.getMp4RotateVFS(str);
        this.HLZ.videoIFrameInterval = 0;
        this.HLZ.oTL = com.tencent.mm.plugin.gallery.b.f.aFg(((JSONObject)localObject).getString("videoType"));
        this.HLZ.oTM = com.tencent.mm.plugin.gallery.b.f.aFg(((JSONObject)localObject).getString("audioType"));
        Log.d("MicroMsg.AlbumAdapter", "loadItemFromSimpleMP4Info mediaItem: %s", new Object[] { this.HLZ });
        Log.i("MicroMsg.AlbumAdapter", "loadItemFromSimpleMP4Info used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
        AppMethodBeat.o(245852);
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
      AppMethodBeat.i(245878);
      if (!(paramObject instanceof e))
      {
        AppMethodBeat.o(245878);
        return false;
      }
      boolean bool = s.p(this.HLZ, ((e)paramObject).HLZ);
      AppMethodBeat.o(245878);
      return bool;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(245880);
      GalleryItem.VideoMediaItem localVideoMediaItem = this.HLZ;
      if (localVideoMediaItem != null)
      {
        int i = localVideoMediaItem.hashCode();
        AppMethodBeat.o(245880);
        return i;
      }
      AppMethodBeat.o(245880);
      return 0;
    }
    
    public final void run()
    {
      AppMethodBeat.i(245889);
      if (this.nzW)
      {
        AppMethodBeat.o(245889);
        return;
      }
      Object localObject1 = this.HLZ;
      s.checkNotNull(localObject1);
      localObject1 = ((GalleryItem.VideoMediaItem)localObject1).bud();
      s.s(localObject1, "mediaItem!!.thumbPath");
      Object localObject4;
      int i;
      label158:
      com.tencent.mm.compatible.i.c localc;
      String str1;
      int k;
      Object localObject8;
      Object localObject5;
      Object localObject6;
      int j;
      Object localObject7;
      if (aBm((String)localObject1))
      {
        fBo();
        if (this.nzW) {
          break label880;
        }
        if (s.p(Looper.myLooper(), Looper.getMainLooper()))
        {
          localObject1 = this.Yve;
          if (localObject1 != null)
          {
            localObject4 = this.HLZ;
            s.checkNotNull(localObject4);
            ((b)localObject1).a(this, ((GalleryItem.VideoMediaItem)localObject4).oTN);
          }
          AppMethodBeat.o(245889);
        }
      }
      else
      {
        if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zns, 0) == 1) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label158;
          }
          fBo();
          break;
        }
        long l = Util.currentTicks();
        localc = new com.tencent.mm.compatible.i.c();
        localObject1 = this.HLZ;
        s.checkNotNull(localObject1);
        str1 = ((GalleryItem.VideoMediaItem)localObject1).bud();
        s.s(str1, "mediaItem!!.thumbPath");
        try
        {
          localc.setDataSource(str1);
          k = localc.lZm.getTrackCount();
          localObject8 = null;
          localObject5 = null;
          localObject6 = null;
          i = 0;
          if (k <= 0) {
            break label900;
          }
          j = i + 1;
          localMediaFormat = localc.getTrackFormat(i);
          s.s(localMediaFormat, "extractor.getTrackFormat(i)");
          if (localMediaFormat.containsKey("mime")) {
            break label589;
          }
          Log.d("MicroMsg.AlbumAdapter", "find video mime : not found.");
          localObject7 = localObject6;
          localObject8 = localObject5;
        }
        catch (Exception localException)
        {
          label279:
          label310:
          label589:
          for (;;)
          {
            MediaFormat localMediaFormat;
            label335:
            label360:
            label750:
            label763:
            Log.d("MicroMsg.AlbumAdapter", "Video extractor init failed. video path = [%s] e = [%s]", new Object[] { str1, localException.getMessage() });
            label463:
            label726:
            label738:
            localc.lZm.release();
          }
        }
        finally
        {
          label387:
          label413:
          label438:
          label709:
          localc.lZm.release();
          label775:
          label787:
          label799:
          AppMethodBeat.o(245889);
        }
        if (this.HLZ != null)
        {
          if (localObject8 != null)
          {
            localObject4 = this.HLZ;
            if (localObject8.containsKey("durationUs")) {
              break label709;
            }
            i = 0;
            ((GalleryItem.VideoMediaItem)localObject4).oTN = i;
            localObject4 = this.HLZ;
            if (localObject8.containsKey("height")) {
              break label726;
            }
            i = 0;
            ((GalleryItem.VideoMediaItem)localObject4).videoHeight = i;
            localObject4 = this.HLZ;
            if (localObject8.containsKey("width")) {
              break label738;
            }
            i = 0;
            ((GalleryItem.VideoMediaItem)localObject4).videoWidth = i;
            localObject5 = this.HLZ;
            if (localObject8.containsKey("mime")) {
              break label750;
            }
            localObject4 = "";
            ((GalleryItem.VideoMediaItem)localObject5).oTL = ((String)localObject4);
            localObject4 = this.HLZ;
            if (localObject8.containsKey("bitrate")) {
              break label763;
            }
            i = 0;
            ((GalleryItem.VideoMediaItem)localObject4).videoBitRate = i;
            localObject4 = this.HLZ;
            if (localObject8.containsKey("i-frame-interval")) {
              break label775;
            }
            i = 0;
            ((GalleryItem.VideoMediaItem)localObject4).videoIFrameInterval = i;
            localObject4 = this.HLZ;
            if (localObject8.containsKey("frame-rate")) {
              break label787;
            }
            i = 0;
            ((GalleryItem.VideoMediaItem)localObject4).videoFrameRate = i;
            this.HLZ.nCg = SightVideoJNI.getMp4RotateVFS(str1);
          }
          if (localObject1 != null)
          {
            localObject4 = this.HLZ;
            if (((MediaFormat)localObject1).containsKey("mime")) {
              break label799;
            }
          }
        }
        for (localObject1 = "";; localObject1 = ((MediaFormat)localObject1).getString("mime"))
        {
          ((GalleryItem.VideoMediaItem)localObject4).oTM = ((String)localObject1);
          Log.d("MicroMsg.AlbumAdapter", "loadItemFromExtractor mediaItem: %s", new Object[] { this.HLZ });
          Log.d("MicroMsg.AlbumAdapter", "mediaItem format:%s, videoPath:%s", new Object[] { localObject8, str1 });
          localc.lZm.release();
          Log.i("MicroMsg.AlbumAdapter", "loadItemFromExtractor used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
          break;
          String str2 = localMediaFormat.getString("mime");
          Log.d("MicroMsg.AlbumAdapter", "find video mime : %s", new Object[] { str2 });
          localObject7 = localObject6;
          localObject8 = localObject5;
          if (str2 == null) {
            break label906;
          }
          if (n.U(str2, "video/", false))
          {
            localObject1 = localObject6;
            localObject4 = localObject5;
            if (localObject5 != null) {
              break label918;
            }
            localObject4 = localMediaFormat;
            localObject1 = localObject6;
            break label918;
          }
          localObject1 = localObject6;
          localObject4 = localObject5;
          if (!n.U(str2, "audio/", false)) {
            break label918;
          }
          localObject1 = localObject6;
          localObject4 = localObject5;
          if (localObject6 != null) {
            break label918;
          }
          localObject1 = localMediaFormat;
          localObject4 = localObject5;
          break label918;
          i = (int)(localObject8.getLong("durationUs") / 1000L);
          break label310;
          i = localObject8.getInteger("height");
          break label335;
          i = localObject8.getInteger("width");
          break label360;
          localObject4 = localObject8.getString("mime");
          break label387;
          i = localObject8.getInteger("bitrate");
          break label413;
          i = localObject8.getInteger("i-frame-interval");
          break label438;
          i = localObject8.getInteger("frame-rate");
          break label463;
        }
      }
      MMHandlerThread.postToMainThread(new a.e..ExternalSyntheticLambda0(this));
      label880:
      AppMethodBeat.o(245889);
      return;
      label900:
      label906:
      label918:
      label953:
      for (;;)
      {
        i = j;
        localObject6 = localObject7;
        localObject5 = localObject8;
        break;
        Object localObject3 = null;
        break label279;
        for (;;)
        {
          if (j < k) {
            break label953;
          }
          do
          {
            localObject3 = localObject7;
            break;
            localObject7 = localObject3;
            localObject8 = localObject4;
            if (localObject3 == null) {
              break label906;
            }
            localObject7 = localObject3;
            localObject8 = localObject4;
          } while (localObject4 != null);
          localObject7 = localObject3;
          localObject8 = localObject4;
        }
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$SimpleVideoAnalysisTask$Companion$fetchDurationMs$task$1", "Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$SimpleVideoAnalysisTask$Listener;", "onResult", "", "task", "Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$SimpleVideoAnalysisTask;", "durationMs", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a$a
      implements a.e.b
    {
      public final void a(a.e parame, int paramInt)
      {
        AppMethodBeat.i(245862);
        if (parame == null) {}
        for (Object localObject = null; localObject == null; localObject = a.e.c(parame))
        {
          AppMethodBeat.o(245862);
          return;
        }
        parame = a.e.c(parame);
        s.checkNotNull(parame);
        parame = (TextView)parame.get();
        if (parame == null)
        {
          AppMethodBeat.o(245862);
          return;
        }
        localObject = a.e.Yvd;
        a.e.a.l(parame, paramInt);
        a.e.gqi().remove(parame);
        AppMethodBeat.o(245862);
      }
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$SimpleVideoAnalysisTask$Listener;", "", "onResult", "", "task", "Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$SimpleVideoAnalysisTask;", "durationMs", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
    static abstract interface b
    {
      public abstract void a(a.e parame, int paramInt);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$onItemViewLongClick$1", "Landroid/view/View$OnLongClickListener;", "onLongClick", "", "v", "Landroid/view/View;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements View.OnLongClickListener
  {
    g(a parama) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(245836);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$onItemViewLongClick$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
      s.u(paramView, "v");
      paramView = paramView.getTag(R.h.item_position);
      s.s(paramView, "v.getTag(R.id.item_position)");
      if ((paramView instanceof Integer))
      {
        paramView = this.Yvf.WF(((Number)paramView).intValue());
        if (paramView != null) {
          ClipboardHelper.setText((Context)a.a(this.Yvf), (CharSequence)"media info", (CharSequence)paramView.toString());
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$onItemViewLongClick$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(245836);
      return true;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$selectListener$1", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements View.OnClickListener
  {
    h(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(245849);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$selectListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
      s.u(paramView, "v");
      localObject = paramView.getTag(R.h.item_position);
      s.s(localObject, "v.getTag(R.id.item_position)");
      if (!(localObject instanceof Integer))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$selectListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(245849);
        return;
      }
      int n = ((Number)localObject).intValue();
      localObject = this.Yvf.WF(n);
      if ((localObject == null) || (Util.isNullOrNil(((GalleryItem.MediaItem)localObject).Gcc)))
      {
        Log.e("MicroMsg.AlbumAdapter", "[onClick] null == item!");
        this.Yvf.fV(n);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$selectListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(245849);
        return;
      }
      Log.i("MicroMsg.AlbumAdapter", s.X("click image path:", ((GalleryItem.MediaItem)localObject).Gcc));
      int j;
      if (a.b(this.Yvf).contains(localObject))
      {
        a.b(this.Yvf).indexOf(localObject);
        this.Yvf.i((GalleryItem.MediaItem)localObject);
        int k = 0;
        int m = 1;
        paramView = a.c(this.Yvf);
        j = m;
        i = k;
        if (paramView != null)
        {
          paramView.cv(n, false);
          i = k;
          j = m;
        }
        if (i == 0)
        {
          paramView = a.g(this.Yvf);
          if (paramView != null) {
            paramView.aG(this.Yvf.HLB.size(), n, j);
          }
          label282:
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$selectListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(245849);
        }
      }
      else
      {
        if ((com.tencent.mm.plugin.gallery.model.e.fAn().sfB == 3) && (n.T(((GalleryItem.MediaItem)localObject).mMimeType, "image/gif", true)) && (!((d)com.tencent.mm.kernel.h.az(d.class)).getProvider().aot(((GalleryItem.MediaItem)localObject).Gcc)))
        {
          l1 = y.bEl(((GalleryItem.MediaItem)localObject).Gcc);
          com.tencent.mm.plugin.gallery.b.h.bZ(13459, l1 + ",1,,0");
          k.cZ((Context)a.a(this.Yvf), a.a(this.Yvf).getString(R.l.gallery_select_gif_to_big));
          this.Yvf.fV(n);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$selectListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(245849);
          return;
        }
        if ((!Util.isNullOrNil(a.d(this.Yvf))) && (s.p(a.d(this.Yvf), "album_business_byp")) && (n.T(((GalleryItem.MediaItem)localObject).mMimeType, "image/gif", true)) && (!((d)com.tencent.mm.kernel.h.az(d.class)).getProvider().aou(((GalleryItem.MediaItem)localObject).Gcc)))
        {
          k.cZ((Context)a.a(this.Yvf), a.a(this.Yvf).getString(R.l.gallery_no_support_giant_gif_gamelife));
          this.Yvf.fV(n);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$selectListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(245849);
          return;
        }
        long l1 = y.bEl(((GalleryItem.MediaItem)localObject).Gcc);
        long l2 = com.tencent.mm.k.c.aRk();
        if (l1 > l2)
        {
          aa.makeText((Context)a.a(this.Yvf), (CharSequence)a.a(this.Yvf).getString(R.l.gHM, new Object[] { Util.getSizeKB(l2) }), 0).show();
          this.Yvf.fV(n);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$selectListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(245849);
          return;
        }
        if ((localObject instanceof GalleryItem.VideoMediaItem))
        {
          if (com.tencent.mm.plugin.gallery.model.e.fAn().sfB == 25)
          {
            l1 = a.iOP();
            l2 = a.iOQ();
            if (((GalleryItem.VideoMediaItem)localObject).oTN < com.tencent.mm.modelcontrol.e.bIg().bIn().minDuration * 1000)
            {
              k.a((Context)a.a(this.Yvf), a.a(this.Yvf).getResources().getString(R.l.gallery_video_duration_below, new Object[] { Integer.valueOf(com.tencent.mm.modelcontrol.e.bIg().bIn().minDuration) }), "", false, (DialogInterface.OnClickListener)new a.h.a(paramView));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$selectListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(245849);
              return;
            }
            if (((GalleryItem.VideoMediaItem)localObject).oTN > l1 * 1000L)
            {
              k.a((Context)a.a(this.Yvf), a.a(this.Yvf).getResources().getString(R.l.gallery_video_duration_limit, new Object[] { Long.valueOf(l2) }), "", false, (DialogInterface.OnClickListener)new a.h.b(paramView));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$selectListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(245849);
              return;
            }
          }
          if ((!Util.isNullOrNil(a.d(this.Yvf))) && (s.p(a.d(this.Yvf), "album_business_bubble_media_by_coordinate")) && (((GalleryItem.VideoMediaItem)localObject).oTN >= a.e(this.Yvf) * 1000 + 500))
          {
            k.cZ((Context)a.a(this.Yvf), a.a(this.Yvf).getResources().getString(R.l.gallery_video_duration_limit, new Object[] { Integer.valueOf(a.e(this.Yvf)) }));
            this.Yvf.fV(n);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$selectListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(245849);
            return;
          }
        }
        if (a.a(this.Yvf).iNV() + a.b(this.Yvf).size() >= a.f(this.Yvf)) {
          break label1163;
        }
        a.b(this.Yvf).add(localObject);
        paramView = a.c(this.Yvf);
        if (paramView != null) {
          paramView.cv(n, true);
        }
        a.b(this.Yvf).size();
      }
      label1163:
      for (int i = 0;; i = 1)
      {
        j = 0;
        this.Yvf.fV(n);
        break;
        aa.makeText((Context)a.a(this.Yvf), (CharSequence)a.a(this.Yvf).getString(R.l.gHN, new Object[] { Integer.valueOf(a.f(this.Yvf)) }), 0).show();
        break label282;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */