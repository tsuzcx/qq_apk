package com.tencent.mm.plugin.mv.ui.adapter;

import android.content.Context;
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
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.gallery.b.f;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.g;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.plugin.mv.ui.uic.j;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.vfs.y;
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
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "allMediaItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lkotlin/collections/ArrayList;", "headers", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$Companion$Header;", "mDateFormat", "Ljava/text/SimpleDateFormat;", "mOnClickListener", "Landroid/view/View$OnClickListener;", "mOnItemClickListener", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$OnItemClickListener;", "mediaCount", "", "getMediaCount", "()I", "onItemViewLongClick", "Landroid/view/View$OnLongClickListener;", "selectListener", "videoMaxDurationMs", "videoMinDurationMs", "addHeader", "", "header", "addMediaItems", "mediaItems", "clear", "getAllMediaItem", "getHeaderCount", "getItem", "position", "getItemCount", "getItemViewType", "isFlexMode", "", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeHeader", "setMediaItems", "setOnItemClickListener", "onItemClickListener", "setVideoDuration", "syncCheckedStatus", "uniqueIdList", "", "unCheckedItem", "uniqueId", "AlbumViewHolder", "CameraHeaderViewHolder", "Companion", "OnItemClickListener", "SimpleVideoAnalysisTask", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends RecyclerView.a<RecyclerView.v>
{
  public static final b.c MaI;
  public final LinkedList<c.b> HLF;
  private final View.OnLongClickListener HLH;
  private final View.OnClickListener HLI;
  public ArrayList<GalleryItem.MediaItem> MaJ;
  private int MaK;
  private int MaL;
  public d MaM;
  private final Context mContext;
  private final View.OnClickListener mOnClickListener;
  private final SimpleDateFormat xiR;
  
  static
  {
    AppMethodBeat.i(287313);
    MaI = new b.c((byte)0);
    AppMethodBeat.o(287313);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(287264);
    this.mContext = paramContext;
    this.MaJ = new ArrayList();
    this.MaK = 2000;
    this.MaL = 2147483647;
    this.xiR = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
    this.HLF = new LinkedList();
    this.HLI = new b..ExternalSyntheticLambda1(this);
    this.HLH = new b..ExternalSyntheticLambda2(this);
    this.mOnClickListener = new b..ExternalSyntheticLambda0(this);
    this.bZE.notifyChanged();
    AppMethodBeat.o(287264);
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(287285);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramb);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    a.c("com/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramb, "this$0");
    localObject1 = paramView.getTag(com.tencent.mm.plugin.mv.b.e.item_position);
    if ((localObject1 == null) || (!(localObject1 instanceof Integer)))
    {
      Log.e("Music.MusicMvAlbumAdapter", "error tag");
      a.a(new Object(), "com/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(287285);
      return;
    }
    localObject2 = paramb.WF(((Number)localObject1).intValue());
    if ((localObject2 == null) || (Util.isNullOrNil(((GalleryItem.MediaItem)localObject2).Gcc)))
    {
      Log.e("Music.MusicMvAlbumAdapter", "[onClick] null == item!");
      paramb.fV(((Number)localObject1).intValue());
      a.a(new Object(), "com/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(287285);
      return;
    }
    Log.i("Music.MusicMvAlbumAdapter", s.X("click image path:", ((GalleryItem.MediaItem)localObject2).Gcc));
    boolean bool;
    if (!((GalleryItem.MediaItem)localObject2).idG)
    {
      bool = true;
      ((GalleryItem.MediaItem)localObject2).idG = bool;
      paramView = paramb.MaM;
      if (paramView != null) {
        break label283;
      }
    }
    label283:
    for (paramView = null;; paramView = Boolean.valueOf(paramView.b(((GalleryItem.MediaItem)localObject2).idG, (GalleryItem.MediaItem)localObject2)))
    {
      if ((paramView != null) && (!paramView.booleanValue())) {
        ((GalleryItem.MediaItem)localObject2).idG = false;
      }
      paramb.fV(((Number)localObject1).intValue());
      a.a(new Object(), "com/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(287285);
      return;
      bool = false;
      break;
    }
  }
  
  private static final boolean b(b paramb, View paramView)
  {
    AppMethodBeat.i(287293);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramView = paramView.getTag(com.tencent.mm.plugin.mv.b.e.item_position);
    s.s(paramView, "v.getTag(R.id.item_position)");
    if ((paramView instanceof Integer))
    {
      paramView = paramb.WF(((Number)paramView).intValue());
      if (paramView != null) {
        ClipboardHelper.setText(paramb.mContext, (CharSequence)"media info", (CharSequence)paramView.toString());
      }
    }
    a.a(true, new Object(), "com/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(287293);
    return true;
  }
  
  private static final void c(b paramb, View paramView)
  {
    AppMethodBeat.i(287303);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    localObject = paramView.getTag(com.tencent.mm.plugin.mv.b.e.item_position);
    int i;
    if ((localObject instanceof Integer))
    {
      i = ((Number)localObject).intValue();
      localObject = paramView.getTag(com.tencent.mm.plugin.mv.b.e.item_type);
      if (!(localObject instanceof Integer)) {
        break label177;
      }
    }
    label177:
    for (int j = ((Number)localObject).intValue();; j = -1)
    {
      if ((i != -1) && (j != -1) && (paramb.MaM != null))
      {
        paramb = paramb.MaM;
        if (paramb != null) {
          paramb.a(i, paramView, j);
        }
      }
      a.a(new Object(), "com/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(287303);
      return;
      i = -1;
      break;
    }
  }
  
  private final boolean gqh()
  {
    AppMethodBeat.i(287272);
    k localk = k.aeZF;
    boolean bool = ((j)k.nq(this.mContext).q(j.class)).gqh();
    AppMethodBeat.o(287272);
    return bool;
  }
  
  public final GalleryItem.MediaItem WF(int paramInt)
  {
    AppMethodBeat.i(287433);
    if (paramInt < this.HLF.size())
    {
      Log.i("Music.MusicMvAlbumAdapter", "get header, pos[%d]", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(287433);
      return null;
    }
    paramInt -= this.HLF.size();
    if (paramInt >= this.MaJ.size())
    {
      Log.w("Music.MusicMvAlbumAdapter", "get item error, media items size[%d], adjustPos[%d]", new Object[] { Integer.valueOf(this.MaJ.size()), Integer.valueOf(paramInt) });
      AppMethodBeat.o(287433);
      return null;
    }
    GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)this.MaJ.get(paramInt);
    AppMethodBeat.o(287433);
    return localMediaItem;
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(287406);
    s.u(paramViewGroup, "parent");
    switch (paramInt)
    {
    default: 
      paramViewGroup = LayoutInflater.from(this.mContext).inflate(b.f.LVe, paramViewGroup, false);
      s.s(paramViewGroup, "from(mContext).inflate(R…           parent, false)");
      paramViewGroup = (RecyclerView.v)new b.a(paramViewGroup);
      AppMethodBeat.o(287406);
      return paramViewGroup;
    case 2: 
      paramViewGroup = LayoutInflater.from(this.mContext).inflate(b.f.LVx, paramViewGroup, false);
      s.s(paramViewGroup, "from(mContext).inflate(R…           parent, false)");
      paramViewGroup = (RecyclerView.v)new b.b(paramViewGroup);
      AppMethodBeat.o(287406);
      return paramViewGroup;
    }
    paramViewGroup = LayoutInflater.from(this.mContext).inflate(b.f.LVe, paramViewGroup, false);
    s.s(paramViewGroup, "from(mContext).inflate(R…           parent, false)");
    paramViewGroup = (RecyclerView.v)new b.a(paramViewGroup);
    AppMethodBeat.o(287406);
    return paramViewGroup;
  }
  
  public final void bo(LinkedList<GalleryItem.MediaItem> paramLinkedList)
  {
    AppMethodBeat.i(287352);
    s.u(paramLinkedList, "mediaItems");
    int i = getItemCount() - this.HLF.size();
    int j = paramLinkedList.size();
    if (i < j)
    {
      this.MaJ.addAll((Collection)paramLinkedList.subList(i, j));
      bA(this.HLF.size() + i, getItemCount());
    }
    AppMethodBeat.o(287352);
  }
  
  public final void d(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(287425);
    s.u(paramv, "holder");
    if ((paramv instanceof b.b))
    {
      paramv.caK.setTag(com.tencent.mm.plugin.mv.b.e.item_position, Integer.valueOf(paramInt));
      paramv.caK.setTag(com.tencent.mm.plugin.mv.b.e.item_type, Integer.valueOf(2));
      paramv.caK.setOnClickListener(this.mOnClickListener);
      AppMethodBeat.o(287425);
      return;
    }
    GalleryItem.MediaItem localMediaItem;
    b.a locala;
    if ((paramv instanceof b.a))
    {
      paramv.caK.setTag(com.tencent.mm.plugin.mv.b.e.item_position, Integer.valueOf(paramInt));
      paramv.caK.setTag(com.tencent.mm.plugin.mv.b.e.item_type, Integer.valueOf(1));
      paramv.caK.setOnClickListener(this.mOnClickListener);
      localMediaItem = WF(paramInt);
      if (localMediaItem == null)
      {
        Log.e("Music.MusicMvAlbumAdapter", "get item failed");
        AppMethodBeat.o(287425);
        return;
      }
      String str1 = localMediaItem.bud();
      s.s(str1, "item.thumbPath");
      String str2 = localMediaItem.Gcc;
      s.s(str2, "item.originalPath");
      if ((Util.isNullOrNil(str1)) && (Util.isNullOrNil(str2)))
      {
        Log.e("Music.MusicMvAlbumAdapter", "null or nil filepath, poi: %s.", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(287425);
        return;
      }
      locala = (b.a)paramv;
      locala.HLM.setAlpha(1.0F);
      if (!gqh()) {
        break label536;
      }
      locala.MaN.setChecked(localMediaItem.idG);
      if (!(localMediaItem instanceof GalleryItem.VideoMediaItem)) {
        break label507;
      }
      locala.HLP.setVisibility(0);
      paramv = e.MaO;
      b.e.a.a(locala.HLP, (View)locala.HLM, (GalleryItem.VideoMediaItem)localMediaItem, this.MaK, this.MaL);
      paramv = this.xiR.format(new Date(localMediaItem.HHK));
      s.s(paramv, "mDateFormat.format(Date(item.generateDate))");
      paramv = paramInt + 1 + ", " + paramv;
      if (2 != localMediaItem.getType()) {
        break label763;
      }
      paramv = s.X("视频 ", paramv);
      label360:
      locala.HLM.setContentDescription((CharSequence)paramv);
      Log.d("Music.MusicMvAlbumAdapter", "thumbFilePath: %s | origFilePath: %s | contentDescription %s", new Object[] { str1, str2, paramv });
      com.tencent.mm.plugin.gallery.ui.h.a(locala.HLM, localMediaItem.getType(), str1, str2, localMediaItem.HHJ, localMediaItem.HHK);
      locala.caK.setOnLongClickListener(this.HLH);
      if (!gqh()) {
        break label774;
      }
      locala.MaN.setVisibility(0);
      label451:
      if (locala.MaN.getVisibility() != 0) {
        break label787;
      }
      b.a.iq((View)locala.MaN);
    }
    for (;;)
    {
      locala.MaN.setTag(com.tencent.mm.plugin.mv.b.e.item_position, Integer.valueOf(paramInt));
      locala.MaN.setOnClickListener(this.HLI);
      AppMethodBeat.o(287425);
      return;
      label507:
      locala.HLP.setVisibility(8);
      if (!localMediaItem.idG)
      {
        locala.HLM.setAlpha(1.0F);
        break;
        label536:
        locala.HLP.setVisibility(8);
        if (!(localMediaItem instanceof GalleryItem.VideoMediaItem)) {
          break;
        }
        locala.HLP.setVisibility(0);
        paramv = e.MaO;
        b.e.a.a(locala.HLP, (View)locala.HLM, (GalleryItem.VideoMediaItem)localMediaItem, this.MaK, this.MaL);
        Log.d("Music.MusicMvAlbumAdapter", "item path:" + ((GalleryItem.VideoMediaItem)localMediaItem).Gcc + ", width:" + ((GalleryItem.VideoMediaItem)localMediaItem).videoWidth + ", height:" + ((GalleryItem.VideoMediaItem)localMediaItem).videoHeight + ", durationMs:" + ((GalleryItem.VideoMediaItem)localMediaItem).oTN + ", videoMinDurationMs:" + this.MaK + ", videoMaxDurationMs:" + this.MaL);
        if ((com.tencent.mm.plugin.mv.ui.a.e.adW(((GalleryItem.VideoMediaItem)localMediaItem).oTN) >= com.tencent.mm.plugin.mv.ui.a.e.adV(this.MaK)) && (com.tencent.mm.plugin.mv.ui.a.e.adW(((GalleryItem.VideoMediaItem)localMediaItem).oTN) <= com.tencent.mm.plugin.mv.ui.a.e.adV(this.MaL)))
        {
          locala.HLM.setAlpha(1.0F);
          break;
        }
      }
      locala.HLM.setAlpha(0.1F);
      break;
      label763:
      paramv = s.X("图片", paramv);
      break label360;
      label774:
      locala.MaN.setVisibility(8);
      break label451;
      label787:
      b.a.ir((View)locala.MaN);
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(287375);
    int i = this.HLF.size();
    int j = this.MaJ.size();
    AppMethodBeat.o(287375);
    return i + j;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(287390);
    if (paramInt < this.HLF.size())
    {
      paramInt = ((c.b)this.HLF.get(paramInt)).HLY;
      AppMethodBeat.o(287390);
      return paramInt;
    }
    AppMethodBeat.o(287390);
    return 1;
  }
  
  public final void sI(long paramLong)
  {
    AppMethodBeat.i(287365);
    Iterator localIterator = ((Iterable)this.MaJ).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (i < 0) {
        p.kkW();
      }
      localObject = (GalleryItem.MediaItem)localObject;
      if (((GalleryItem.MediaItem)localObject).HHJ == paramLong)
      {
        ((GalleryItem.MediaItem)localObject).idG = false;
        fV(this.HLF.size() + i);
      }
      i += 1;
    }
    AppMethodBeat.o(287365);
  }
  
  public final void setVideoDuration(int paramInt)
  {
    AppMethodBeat.i(287341);
    this.MaK = paramInt;
    this.bZE.notifyChanged();
    AppMethodBeat.o(287341);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$Companion$CameraHeader;", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$Companion$Header;", "headerType", "", "(I)V", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c$a
    extends b.c.b
  {
    public c$a()
    {
      this.HLY = 2;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$Companion$Header;", "", "()V", "headerType", "", "getHeaderType", "()I", "setHeaderType", "(I)V", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract class c$b
  {
    int HLY;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$OnItemClickListener;", "", "onItemChecked", "", "isCheck", "item", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "onItemClick", "", "position", "", "itemView", "Landroid/view/View;", "itemViewType", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface d
  {
    public abstract void a(int paramInt1, View paramView, int paramInt2);
    
    public abstract boolean b(boolean paramBoolean, GalleryItem.MediaItem paramMediaItem);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$SimpleVideoAnalysisTask;", "Ljava/lang/Runnable;", "tv", "Landroid/widget/TextView;", "iv", "Landroid/view/View;", "mediaItem", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;", "listener", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$SimpleVideoAnalysisTask$Listener;", "(Landroid/widget/TextView;Landroid/view/View;Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$SimpleVideoAnalysisTask$Listener;)V", "isCancel", "", "ivRef", "Ljava/lang/ref/WeakReference;", "tvRef", "cancel", "", "checkDeviceIsConfiguration", "videoPath", "", "equals", "o", "", "hashCode", "", "loadItemFromExtractor", "loadItemFromSimpleMP4Info", "notifyObserver", "run", "setImageView", "Landroid/widget/ImageView;", "setTextView", "Companion", "Listener", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements Runnable
  {
    private static final HashMap<TextView, e> HMb;
    public static final a MaO;
    private final GalleryItem.VideoMediaItem HLZ;
    private WeakReference<View> MaP;
    private final b MaQ;
    boolean nzW;
    private WeakReference<TextView> zVE;
    
    static
    {
      AppMethodBeat.i(287368);
      MaO = new a((byte)0);
      HMb = new HashMap();
      AppMethodBeat.o(287368);
    }
    
    private e(TextView paramTextView, View paramView, GalleryItem.VideoMediaItem paramVideoMediaItem, b paramb)
    {
      AppMethodBeat.i(287298);
      this.zVE = new WeakReference(paramTextView);
      this.MaP = new WeakReference(paramView);
      this.HLZ = paramVideoMediaItem;
      this.MaQ = paramb;
      AppMethodBeat.o(287298);
    }
    
    private static boolean aBm(String paramString)
    {
      AppMethodBeat.i(287312);
      Object localObject1 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zoa, "");
      s.s(localObject1, "service(IExptService::cl…device_configuration, \"\")");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        AppMethodBeat.o(287312);
        return false;
      }
      Log.i("Music.MusicMvAlbumAdapter", "devices configuration: %s", new Object[] { localObject1 });
      Log.i("Music.MusicMvAlbumAdapter", "android version: %s, manufacturer: %s, brand: %s, model: %s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Build.MANUFACTURER, Build.BRAND, q.aPo() });
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        localObject2 = ((JSONObject)localObject1).optString("devices");
        s.s(localObject2, "`object`.optString(\"devices\")");
        k = ((JSONObject)localObject1).optInt("maxsize");
        localObject1 = new JSONArray((String)localObject2);
        m = ((JSONArray)localObject1).length();
        if (m <= 0) {
          break label388;
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
          Log.printErrStackTrace("Music.MusicMvAlbumAdapter", (Throwable)paramString, "parse json error", new Object[0]);
          continue;
          int i = j;
        }
      }
      j = i + 1;
      localObject2 = ((JSONArray)localObject1).optJSONObject(i);
      s.s(localObject2, "array.optJSONObject(i)");
      if ((n.T(Build.MANUFACTURER, ((JSONObject)localObject2).optString("brand"), true)) && (n.T(q.aPo(), ((JSONObject)localObject2).optString("model"), true)))
      {
        l = y.bEl(paramString);
        if ((k != 0) && (l > k * 1024 * 1024))
        {
          Log.i("Music.MusicMvAlbumAdapter", "hit devices but it is too big, fileSize: %s, maxSize: %s, filePath: %s", new Object[] { Long.valueOf(l), Integer.valueOf(k), paramString });
          AppMethodBeat.o(287312);
          return false;
        }
        i = ((JSONObject)localObject2).optInt("androidVersion");
        if (-1 == i)
        {
          Log.i("Music.MusicMvAlbumAdapter", "hit devices all version, manufacturer: %s, brand: %s, model: %s", new Object[] { Build.MANUFACTURER, Build.BRAND, q.aPo() });
          AppMethodBeat.o(287312);
          return true;
        }
        if (Build.VERSION.SDK_INT == i)
        {
          Log.i("Music.MusicMvAlbumAdapter", "hit devices, version: %s, manufacturer: %s, brand: %s, model: %s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Build.MANUFACTURER, Build.BRAND, q.aPo() });
          AppMethodBeat.o(287312);
          return true;
        }
      }
      if (j >= m)
      {
        label388:
        AppMethodBeat.o(287312);
        return false;
      }
    }
    
    private final void fBo()
    {
      AppMethodBeat.i(287321);
      if (this.HLZ == null)
      {
        AppMethodBeat.o(287321);
        return;
      }
      long l = Util.currentTicks();
      try
      {
        String str = this.HLZ.bud();
        s.s(str, "mediaItem.thumbPath");
        Object localObject = SightVideoJNI.getSimpleMp4InfoVFS(str);
        s.s(localObject, "getSimpleMp4InfoVFS(path)");
        Log.d("Music.MusicMvAlbumAdapter", "get simple mp4 info %s", new Object[] { localObject });
        localObject = new JSONObject((String)localObject);
        this.HLZ.oTN = ((JSONObject)localObject).getInt("videoDuration");
        this.HLZ.videoHeight = ((JSONObject)localObject).getInt("videoHeight");
        this.HLZ.videoWidth = ((JSONObject)localObject).getInt("videoWidth");
        this.HLZ.videoBitRate = ((JSONObject)localObject).getInt("videoBitrate");
        this.HLZ.videoFrameRate = ((JSONObject)localObject).getInt("videoFPS");
        this.HLZ.nCg = SightVideoJNI.getMp4RotateVFS(str);
        this.HLZ.videoIFrameInterval = 0;
        this.HLZ.oTL = f.aFg(((JSONObject)localObject).getString("videoType"));
        this.HLZ.oTM = f.aFg(((JSONObject)localObject).getString("audioType"));
        Log.d("Music.MusicMvAlbumAdapter", "loadItemFromSimpleMP4Info mediaItem: %s", new Object[] { this.HLZ });
        Log.i("Music.MusicMvAlbumAdapter", "loadItemFromSimpleMP4Info used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
        AppMethodBeat.o(287321);
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
      AppMethodBeat.i(287377);
      if (!(paramObject instanceof e))
      {
        AppMethodBeat.o(287377);
        return false;
      }
      boolean bool = s.p(this.HLZ, ((e)paramObject).HLZ);
      AppMethodBeat.o(287377);
      return bool;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(287384);
      GalleryItem.VideoMediaItem localVideoMediaItem = this.HLZ;
      if (localVideoMediaItem != null)
      {
        int i = localVideoMediaItem.hashCode();
        AppMethodBeat.o(287384);
        return i;
      }
      AppMethodBeat.o(287384);
      return 0;
    }
    
    public final void run()
    {
      AppMethodBeat.i(287404);
      if (this.nzW)
      {
        AppMethodBeat.o(287404);
        return;
      }
      Object localObject1 = this.HLZ;
      s.checkNotNull(localObject1);
      localObject1 = ((GalleryItem.VideoMediaItem)localObject1).bud();
      s.s(localObject1, "mediaItem!!.thumbPath");
      Object localObject4;
      int i;
      label176:
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
          break label901;
        }
        if (s.p(Looper.myLooper(), Looper.getMainLooper()))
        {
          localObject1 = this.MaQ;
          if (localObject1 != null)
          {
            localObject4 = this.HLZ;
            s.checkNotNull(localObject4);
            i = ((GalleryItem.VideoMediaItem)localObject4).oTN;
            localObject4 = this.HLZ;
            s.checkNotNull(localObject4);
            ((b)localObject1).a(this, i, ((GalleryItem.VideoMediaItem)localObject4).idG);
          }
          AppMethodBeat.o(287404);
        }
      }
      else
      {
        if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zns, 0) == 1) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label176;
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
            break label921;
          }
          j = i + 1;
          localMediaFormat = localc.getTrackFormat(i);
          s.s(localMediaFormat, "extractor.getTrackFormat(i)");
          if (localMediaFormat.containsKey("mime")) {
            break label607;
          }
          Log.d("Music.MusicMvAlbumAdapter", "find video mime : not found.");
          localObject7 = localObject6;
          localObject8 = localObject5;
        }
        catch (Exception localException)
        {
          label297:
          label328:
          label607:
          for (;;)
          {
            MediaFormat localMediaFormat;
            label353:
            label378:
            Log.d("Music.MusicMvAlbumAdapter", "Video extractor init failed. video path = [%s] e = [%s]", new Object[] { str1, localException.getMessage() });
            label481:
            label744:
            label756:
            localc.lZm.release();
          }
        }
        finally
        {
          label405:
          label431:
          label456:
          label727:
          localc.lZm.release();
          label768:
          label781:
          label793:
          label805:
          label817:
          AppMethodBeat.o(287404);
        }
        if (this.HLZ != null)
        {
          if (localObject8 != null)
          {
            localObject4 = this.HLZ;
            if (localObject8.containsKey("durationUs")) {
              break label727;
            }
            i = 0;
            ((GalleryItem.VideoMediaItem)localObject4).oTN = i;
            localObject4 = this.HLZ;
            if (localObject8.containsKey("height")) {
              break label744;
            }
            i = 0;
            ((GalleryItem.VideoMediaItem)localObject4).videoHeight = i;
            localObject4 = this.HLZ;
            if (localObject8.containsKey("width")) {
              break label756;
            }
            i = 0;
            ((GalleryItem.VideoMediaItem)localObject4).videoWidth = i;
            localObject5 = this.HLZ;
            if (localObject8.containsKey("mime")) {
              break label768;
            }
            localObject4 = "";
            ((GalleryItem.VideoMediaItem)localObject5).oTL = ((String)localObject4);
            localObject4 = this.HLZ;
            if (localObject8.containsKey("bitrate")) {
              break label781;
            }
            i = 0;
            ((GalleryItem.VideoMediaItem)localObject4).videoBitRate = i;
            localObject4 = this.HLZ;
            if (localObject8.containsKey("i-frame-interval")) {
              break label793;
            }
            i = 0;
            ((GalleryItem.VideoMediaItem)localObject4).videoIFrameInterval = i;
            localObject4 = this.HLZ;
            if (localObject8.containsKey("frame-rate")) {
              break label805;
            }
            i = 0;
            ((GalleryItem.VideoMediaItem)localObject4).videoFrameRate = i;
            this.HLZ.nCg = SightVideoJNI.getMp4RotateVFS(str1);
          }
          if (localObject1 != null)
          {
            localObject4 = this.HLZ;
            if (((MediaFormat)localObject1).containsKey("mime")) {
              break label817;
            }
          }
        }
        for (localObject1 = "";; localObject1 = ((MediaFormat)localObject1).getString("mime"))
        {
          ((GalleryItem.VideoMediaItem)localObject4).oTM = ((String)localObject1);
          Log.d("Music.MusicMvAlbumAdapter", "loadItemFromExtractor mediaItem: %s", new Object[] { this.HLZ });
          Log.d("Music.MusicMvAlbumAdapter", "mediaItem format:%s, videoPath:%s", new Object[] { localObject8, str1 });
          localc.lZm.release();
          Log.i("Music.MusicMvAlbumAdapter", "loadItemFromExtractor used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
          break;
          String str2 = localMediaFormat.getString("mime");
          Log.d("Music.MusicMvAlbumAdapter", "find video mime : %s", new Object[] { str2 });
          localObject7 = localObject6;
          localObject8 = localObject5;
          if (str2 == null) {
            break label927;
          }
          if (n.U(str2, "video/", false))
          {
            localObject1 = localObject6;
            localObject4 = localObject5;
            if (localObject5 != null) {
              break label939;
            }
            localObject4 = localMediaFormat;
            localObject1 = localObject6;
            break label939;
          }
          localObject1 = localObject6;
          localObject4 = localObject5;
          if (!n.U(str2, "audio/", false)) {
            break label939;
          }
          localObject1 = localObject6;
          localObject4 = localObject5;
          if (localObject6 != null) {
            break label939;
          }
          localObject1 = localMediaFormat;
          localObject4 = localObject5;
          break label939;
          i = (int)(localObject8.getLong("durationUs") / 1000L);
          break label328;
          i = localObject8.getInteger("height");
          break label353;
          i = localObject8.getInteger("width");
          break label378;
          localObject4 = localObject8.getString("mime");
          break label405;
          i = localObject8.getInteger("bitrate");
          break label431;
          i = localObject8.getInteger("i-frame-interval");
          break label456;
          i = localObject8.getInteger("frame-rate");
          break label481;
        }
      }
      MMHandlerThread.postToMainThread((Runnable)new c(this));
      label901:
      AppMethodBeat.o(287404);
      return;
      label921:
      label927:
      label939:
      label974:
      for (;;)
      {
        i = j;
        localObject6 = localObject7;
        localObject5 = localObject8;
        break;
        Object localObject3 = null;
        break label297;
        for (;;)
        {
          if (j < k) {
            break label974;
          }
          do
          {
            localObject3 = localObject7;
            break;
            localObject7 = localObject3;
            localObject8 = localObject4;
            if (localObject3 == null) {
              break label927;
            }
            localObject7 = localObject3;
            localObject8 = localObject4;
          } while (localObject4 != null);
          localObject7 = localObject3;
          localObject8 = localObject4;
        }
      }
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$SimpleVideoAnalysisTask$Companion;", "", "()V", "taskContainer", "Ljava/util/HashMap;", "Landroid/widget/TextView;", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$SimpleVideoAnalysisTask;", "clearFetchDurationTask", "", "fetchDurationMs", "tv", "iv", "Landroid/view/View;", "videoMediaItem", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;", "videoMinDurationMs", "", "videoMaxDurationMs", "setResult", "durationMs", "isCheck", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
    {
      static void a(TextView paramTextView, View paramView, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
      {
        AppMethodBeat.i(287319);
        if (paramTextView == null)
        {
          AppMethodBeat.o(287319);
          return;
        }
        if (paramInt1 < 0)
        {
          paramTextView.setText((CharSequence)"--:--");
          AppMethodBeat.o(287319);
          return;
        }
        paramInt1 = com.tencent.mm.plugin.mv.ui.a.e.adW(paramInt1);
        paramInt2 = com.tencent.mm.plugin.mv.ui.a.e.adV(paramInt2);
        paramInt3 = com.tencent.mm.plugin.mv.ui.a.e.adX(paramInt3);
        if (paramView != null)
        {
          paramView.setAlpha(1.0F);
          if ((paramInt1 >= paramInt2) && (paramInt1 <= paramInt3) && (!paramBoolean)) {
            break label150;
          }
          paramView.setAlpha(0.1F);
        }
        for (;;)
        {
          String str = String.valueOf(paramInt1 % 60);
          paramView = str;
          if (str.length() < 2) {
            paramView = s.X("0", str);
          }
          paramTextView.setText((CharSequence)(paramInt1 / 60 + ':' + paramView));
          AppMethodBeat.o(287319);
          return;
          label150:
          paramView.setAlpha(1.0F);
        }
      }
      
      public static void a(TextView paramTextView, View paramView, GalleryItem.VideoMediaItem paramVideoMediaItem, int paramInt1, final int paramInt2)
      {
        AppMethodBeat.i(287309);
        if ((paramTextView == null) || (paramView == null) || (paramVideoMediaItem == null))
        {
          Log.e("Music.MusicMvAlbumAdapter", "Error input for duration fetcher");
          AppMethodBeat.o(287309);
          return;
        }
        if (b.e.gqi().containsKey(paramTextView))
        {
          b.e locale = (b.e)b.e.gqi().get(paramTextView);
          if (locale != null)
          {
            if (s.p(b.e.b(locale), paramVideoMediaItem))
            {
              AppMethodBeat.o(287309);
              return;
            }
            WeakReference localWeakReference = b.e.c(locale);
            s.checkNotNull(localWeakReference);
            if (s.p(paramTextView, localWeakReference.get()))
            {
              b.e.d(locale);
              b.e.e(locale);
              locale.nzW = true;
            }
          }
        }
        if (paramVideoMediaItem.oTN >= 0)
        {
          Log.i("Music.MusicMvAlbumAdapter", "Directly attach durationMs %d to tv, path %s", new Object[] { Integer.valueOf(paramVideoMediaItem.oTN), paramVideoMediaItem });
          a(paramTextView, paramView, paramVideoMediaItem.oTN, paramInt1, paramInt2, paramVideoMediaItem.idG);
          b.e.gqi().remove(paramTextView);
          AppMethodBeat.o(287309);
          return;
        }
        paramTextView.setText((CharSequence)"");
        paramView = new b.e(paramTextView, paramView, paramVideoMediaItem, (b.e.b)new a(paramInt1, paramInt2), (byte)0);
        com.tencent.mm.plugin.gallery.model.e.fAo().aF((Runnable)paramView);
        ((Map)b.e.gqi()).put(paramTextView, paramView);
        AppMethodBeat.o(287309);
      }
      
      @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$SimpleVideoAnalysisTask$Companion$fetchDurationMs$task$1", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$SimpleVideoAnalysisTask$Listener;", "onResult", "", "task", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$SimpleVideoAnalysisTask;", "durationMs", "", "isCheck", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
      public static final class a
        implements b.e.b
      {
        a(int paramInt1, int paramInt2) {}
        
        public final void a(b.e parame, int paramInt, boolean paramBoolean)
        {
          AppMethodBeat.i(287267);
          if (parame == null) {}
          for (Object localObject = null; localObject == null; localObject = b.e.c(parame))
          {
            AppMethodBeat.o(287267);
            return;
          }
          localObject = b.e.c(parame);
          s.checkNotNull(localObject);
          localObject = (TextView)((WeakReference)localObject).get();
          if (localObject == null)
          {
            AppMethodBeat.o(287267);
            return;
          }
          parame = (View)b.e.f(parame).get();
          if (parame == null)
          {
            AppMethodBeat.o(287267);
            return;
          }
          b.e.a locala = b.e.MaO;
          b.e.a.a((TextView)localObject, parame, paramInt, this.MaR, paramInt2, paramBoolean);
          b.e.gqi().remove(localObject);
          AppMethodBeat.o(287267);
        }
      }
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$SimpleVideoAnalysisTask$Listener;", "", "onResult", "", "task", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$SimpleVideoAnalysisTask;", "durationMs", "", "isCheck", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
    static abstract interface b
    {
      public abstract void a(b.e parame, int paramInt, boolean paramBoolean);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$SimpleVideoAnalysisTask$notifyObserver$1", "Ljava/lang/Runnable;", "run", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class c
      implements Runnable
    {
      c(b.e parame) {}
      
      public final void run()
      {
        AppMethodBeat.i(287317);
        b.e.b localb = b.e.a(this.MaT);
        if (localb != null)
        {
          b.e locale = this.MaT;
          GalleryItem.VideoMediaItem localVideoMediaItem = b.e.b(this.MaT);
          s.checkNotNull(localVideoMediaItem);
          int i = localVideoMediaItem.oTN;
          localVideoMediaItem = b.e.b(this.MaT);
          s.checkNotNull(localVideoMediaItem);
          localb.a(locale, i, localVideoMediaItem.idG);
        }
        AppMethodBeat.o(287317);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.adapter.b
 * JD-Core Version:    0.7.0.1
 */