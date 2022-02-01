package com.tencent.mm.plugin.mv.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.ui.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "allMediaItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lkotlin/collections/ArrayList;", "headers", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$Companion$Header;", "mDateFormat", "Ljava/text/SimpleDateFormat;", "mOnClickListener", "Landroid/view/View$OnClickListener;", "mOnItemClickListener", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$OnItemClickListener;", "maxDurationSec", "", "getMaxDurationSec", "()I", "maxDurationTip", "getMaxDurationTip", "mediaCount", "getMediaCount", "onItemViewLongClick", "Landroid/view/View$OnLongClickListener;", "videoMaxDurationMs", "videoMinDurationMs", "addHeader", "", "header", "addMediaItems", "mediaItems", "clear", "getAllMediaItem", "getHeaderCount", "getItem", "position", "getItemCount", "getItemViewType", "getItemWithOutAdjust", "getTypeRelatedMediaItems", "type", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeHeader", "setMediaItems", "setOnItemClickListener", "onItemClickListener", "setVideoDuration", "videoMinDuration", "AlbumViewHolder", "CameraHeaderViewHolder", "Companion", "OnItemClickListener", "SimpleVideoAnalysisTask", "plugin-mv_release"})
public final class b
  extends RecyclerView.a<RecyclerView.v>
{
  public static final c ArM;
  public ArrayList<GalleryItem.MediaItem> ArI;
  public int ArJ;
  private int ArK;
  public d ArL;
  private final Context mContext;
  private final View.OnClickListener mOnClickListener;
  private final SimpleDateFormat qDM;
  public final LinkedList<b.c.b> xns;
  private final View.OnLongClickListener xnu;
  
  static
  {
    AppMethodBeat.i(256994);
    ArM = new c((byte)0);
    AppMethodBeat.o(256994);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(256993);
    this.mContext = paramContext;
    this.ArI = new ArrayList();
    this.ArJ = 10001;
    this.ArK = 2147483647;
    this.qDM = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
    this.xns = new LinkedList();
    this.xnu = ((View.OnLongClickListener)new g(this));
    this.mOnClickListener = ((View.OnClickListener)new f(this));
    notifyDataSetChanged();
    AppMethodBeat.o(256993);
  }
  
  public final GalleryItem.MediaItem NK(int paramInt)
  {
    AppMethodBeat.i(256992);
    if (paramInt < this.xns.size())
    {
      Log.i("Music.MusicMvAlbumVideoAdapter", "get header, pos[%d]", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(256992);
      return null;
    }
    paramInt -= this.xns.size();
    if (paramInt >= this.ArI.size())
    {
      Log.w("Music.MusicMvAlbumVideoAdapter", "get item error, media items size[%d], adjustPos[%d]", new Object[] { Integer.valueOf(this.ArI.size()), Integer.valueOf(paramInt) });
      AppMethodBeat.o(256992);
      return null;
    }
    GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)this.ArI.get(paramInt);
    AppMethodBeat.o(256992);
    return localMediaItem;
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(256990);
    p.h(paramViewGroup, "parent");
    switch (paramInt)
    {
    default: 
      paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131495766, paramViewGroup, false);
      p.g(paramViewGroup, "LayoutInflater.from(mCon…           parent, false)");
      paramViewGroup = (RecyclerView.v)new a(paramViewGroup);
      AppMethodBeat.o(256990);
      return paramViewGroup;
    case 2: 
      paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131495785, paramViewGroup, false);
      p.g(paramViewGroup, "LayoutInflater.from(mCon…           parent, false)");
      paramViewGroup = (RecyclerView.v)new b.b(paramViewGroup);
      AppMethodBeat.o(256990);
      return paramViewGroup;
    }
    paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131495766, paramViewGroup, false);
    p.g(paramViewGroup, "LayoutInflater.from(mCon…           parent, false)");
    paramViewGroup = (RecyclerView.v)new a(paramViewGroup);
    AppMethodBeat.o(256990);
    return paramViewGroup;
  }
  
  @SuppressLint({"ResourceType"})
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(256991);
    p.h(paramv, "holder");
    if ((paramv instanceof b.b))
    {
      paramv.aus.setTag(2131302847, Integer.valueOf(paramInt));
      paramv.aus.setTag(2131302872, Integer.valueOf(2));
      paramv.aus.setOnClickListener(this.mOnClickListener);
      AppMethodBeat.o(256991);
      return;
    }
    Object localObject1;
    a locala;
    Object localObject2;
    int i;
    int j;
    if ((paramv instanceof a))
    {
      paramv.aus.setTag(2131302847, Integer.valueOf(paramInt));
      paramv.aus.setTag(2131302872, Integer.valueOf(1));
      paramv.aus.setOnClickListener(this.mOnClickListener);
      localObject1 = NK(paramInt);
      if (localObject1 == null)
      {
        paramv = new t("null cannot be cast to non-null type com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem");
        AppMethodBeat.o(256991);
        throw paramv;
      }
      localObject1 = (GalleryItem.VideoMediaItem)localObject1;
      if (localObject1 == null)
      {
        Log.e("Music.MusicMvAlbumVideoAdapter", "get item failed");
        AppMethodBeat.o(256991);
        return;
      }
      String str1 = ((GalleryItem.VideoMediaItem)localObject1).aQn();
      p.g(str1, "item.thumbPath");
      String str2 = ((GalleryItem.VideoMediaItem)localObject1).dRh();
      p.g(str2, "item.originalPath");
      if ((Util.isNullOrNil(str1)) && (Util.isNullOrNil(str2)))
      {
        Log.e("Music.MusicMvAlbumVideoAdapter", "null or nil filepath, poi: %s.", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(256991);
        return;
      }
      locala = (a)paramv;
      locala.xnB.setVisibility(0);
      if (2 == ((GalleryItem.VideoMediaItem)localObject1).getType())
      {
        paramv = e.ArP;
        paramv = locala.xnB;
        localObject2 = locala.xnz;
        i = this.ArJ;
        j = this.ArK;
        if ((paramv != null) && (localObject2 != null) && (localObject1 != null)) {
          break label615;
        }
        Log.e("Music.MusicMvAlbumVideoAdapter", "Error input for duration fetcher");
      }
      paramv = this.qDM.format(new Date(((GalleryItem.VideoMediaItem)localObject1).xja));
      p.g(paramv, "mDateFormat.format(Date(item.generateDate))");
      paramv = paramInt + 1 + ", " + paramv;
      if (2 != ((GalleryItem.VideoMediaItem)localObject1).getType()) {
        break label829;
      }
      paramv = "视频 ".concat(String.valueOf(paramv));
      label390:
      locala.xdY.setContentDescription((CharSequence)paramv);
      Log.d("Music.MusicMvAlbumVideoAdapter", "thumbFilePath: %s | origFilePath: %s | contentDescription %s", new Object[] { str1, str2, paramv });
      h.a(locala.xdY, ((GalleryItem.VideoMediaItem)localObject1).getType(), str1, str2, ((GalleryItem.VideoMediaItem)localObject1).xiZ, ((GalleryItem.VideoMediaItem)localObject1).xja);
      Log.d("Music.MusicMvAlbumVideoAdapter", "item path:" + ((GalleryItem.VideoMediaItem)localObject1).xiW + ", width:" + ((GalleryItem.VideoMediaItem)localObject1).videoWidth + ", height:" + ((GalleryItem.VideoMediaItem)localObject1).videoHeight + ", durationMs:" + ((GalleryItem.VideoMediaItem)localObject1).jkS + ", videoMinDurationMs:" + this.ArJ + ", videoMaxDurationMs:" + this.ArK);
      if ((com.tencent.mm.plugin.mv.ui.a.e.Tm(((GalleryItem.VideoMediaItem)localObject1).jkS) < com.tencent.mm.plugin.mv.ui.a.e.Tl(this.ArJ)) || (com.tencent.mm.plugin.mv.ui.a.e.Tm(((GalleryItem.VideoMediaItem)localObject1).jkS) > com.tencent.mm.plugin.mv.ui.a.e.Tl(this.ArK))) {
        break label843;
      }
      locala.xnz.setBackgroundResource(2131234161);
    }
    for (;;)
    {
      locala.aus.setOnLongClickListener(this.xnu);
      AppMethodBeat.o(256991);
      return;
      label615:
      if (e.evH().containsKey(paramv))
      {
        e locale = (e)e.evH().get(paramv);
        if (locale != null)
        {
          if (p.j(e.b(locale), localObject1)) {
            break;
          }
          WeakReference localWeakReference = e.c(locale);
          if (localWeakReference == null) {
            p.hyc();
          }
          if (p.j(paramv, (TextView)localWeakReference.get()))
          {
            e.d(locale);
            e.e(locale);
            locale.ifz = true;
          }
        }
      }
      if (((GalleryItem.VideoMediaItem)localObject1).jkS >= 0)
      {
        Log.i("Music.MusicMvAlbumVideoAdapter", "Directly attach durationMs %d to tv, path %s", new Object[] { Integer.valueOf(((GalleryItem.VideoMediaItem)localObject1).jkS), localObject1 });
        b.e.a.a(paramv, (ImageView)localObject2, ((GalleryItem.VideoMediaItem)localObject1).jkS, i, j);
        e.evH().remove(paramv);
        break;
      }
      paramv.setText((CharSequence)"");
      localObject2 = new e(paramv, (ImageView)localObject2, (GalleryItem.VideoMediaItem)localObject1, (b.e.b)new b.e.a.a(i, j), (byte)0);
      com.tencent.mm.plugin.gallery.model.e.dQL().aq((Runnable)localObject2);
      ((Map)e.evH()).put(paramv, localObject2);
      break;
      label829:
      paramv = "图片".concat(String.valueOf(paramv));
      break label390;
      label843:
      locala.xnz.setBackgroundColor(com.tencent.mm.cb.a.n(this.mContext, 2131099835));
    }
  }
  
  public final void aN(LinkedList<GalleryItem.MediaItem> paramLinkedList)
  {
    AppMethodBeat.i(256987);
    p.h(paramLinkedList, "mediaItems");
    int i = getItemCount() - this.xns.size();
    int j = paramLinkedList.size();
    if (i < j)
    {
      this.ArI.addAll((Collection)paramLinkedList.subList(i, j));
      as(this.xns.size() + i, getItemCount());
    }
    AppMethodBeat.o(256987);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(256988);
    int i = this.xns.size();
    int j = this.ArI.size();
    AppMethodBeat.o(256988);
    return i + j;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(256989);
    if (paramInt < this.xns.size())
    {
      paramInt = ((b.c.b)this.xns.get(paramInt)).xnH;
      AppMethodBeat.o(256989);
      return paramInt;
    }
    AppMethodBeat.o(256989);
    return 1;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$AlbumViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "thumbIV", "Landroid/widget/ImageView;", "getThumbIV", "()Landroid/widget/ImageView;", "setThumbIV", "(Landroid/widget/ImageView;)V", "thumbMaskIV", "getThumbMaskIV", "setThumbMaskIV", "typeMaskTV", "Landroid/widget/TextView;", "getTypeMaskTV", "()Landroid/widget/TextView;", "setTypeMaskTV", "(Landroid/widget/TextView;)V", "collapseTouch", "", "delegate", "expandTouch", "plugin-mv_release"})
  public static final class a
    extends RecyclerView.v
  {
    ImageView xdY;
    TextView xnB;
    ImageView xnz;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(256971);
      View localView = paramView.findViewById(2131304573);
      p.g(localView, "itemView.findViewById(R.id.media_thumb)");
      this.xdY = ((ImageView)localView);
      localView = paramView.findViewById(2131304563);
      p.g(localView, "itemView.findViewById(R.id.media_mask)");
      this.xnz = ((ImageView)localView);
      paramView = paramView.findViewById(2131309564);
      p.g(paramView, "itemView.findViewById(R.id.type_mask_tv)");
      this.xnB = ((TextView)paramView);
      AppMethodBeat.o(256971);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$Companion;", "", "()V", "ITEM_TYPE_CAMERA_HEADER", "", "ITEM_TYPE_MEDIA", "TAG", "", "CameraHeader", "Header", "plugin-mv_release"})
  public static final class c
  {
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$Companion$CameraHeader;", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$Companion$Header;", "headerType", "", "(I)V", "plugin-mv_release"})
    public static final class a
      extends b.c.b
    {
      public a()
      {
        this.xnH = 2;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$Companion$Header;", "", "()V", "headerType", "", "getHeaderType", "()I", "setHeaderType", "(I)V", "plugin-mv_release"})
    public static abstract class b
    {
      int xnH;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$OnItemClickListener;", "", "onItemClick", "", "position", "", "itemView", "Landroid/view/View;", "itemViewType", "plugin-mv_release"})
  public static abstract interface d
  {
    public abstract void a(int paramInt1, View paramView, int paramInt2);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$SimpleVideoAnalysisTask;", "Ljava/lang/Runnable;", "tv", "Landroid/widget/TextView;", "iv", "Landroid/widget/ImageView;", "mediaItem", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;", "listener", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$SimpleVideoAnalysisTask$Listener;", "(Landroid/widget/TextView;Landroid/widget/ImageView;Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$SimpleVideoAnalysisTask$Listener;)V", "isCancel", "", "ivRef", "Ljava/lang/ref/WeakReference;", "tvRef", "cancel", "", "checkDeviceIsConfiguration", "videoPath", "", "equals", "o", "", "hashCode", "", "loadItemFromExtractor", "loadItemFromSimpleMP4Info", "notifyObserver", "run", "setImageView", "setTextView", "Companion", "Listener", "plugin-mv_release"})
  public static final class e
    implements Runnable
  {
    public static final a ArP;
    private static final HashMap<TextView, e> xnK;
    private WeakReference<ImageView> ArN;
    private final b ArO;
    boolean ifz;
    private WeakReference<TextView> sTx;
    private final GalleryItem.VideoMediaItem xnI;
    
    static
    {
      AppMethodBeat.i(256982);
      ArP = new a((byte)0);
      xnK = new HashMap();
      AppMethodBeat.o(256982);
    }
    
    private e(TextView paramTextView, ImageView paramImageView, GalleryItem.VideoMediaItem paramVideoMediaItem, b paramb)
    {
      AppMethodBeat.i(256981);
      this.sTx = new WeakReference(paramTextView);
      this.ArN = new WeakReference(paramImageView);
      this.xnI = paramVideoMediaItem;
      this.ArO = paramb;
      AppMethodBeat.o(256981);
    }
    
    private static boolean ayX(String paramString)
    {
      AppMethodBeat.i(256979);
      Object localObject1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.skT, "");
      p.g(localObject1, "MMKernel.service(IExptSe…device_configuration, \"\")");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        AppMethodBeat.o(256979);
        return false;
      }
      Log.i("Music.MusicMvAlbumVideoAdapter", "devices configuration: %s", new Object[] { localObject1 });
      Log.i("Music.MusicMvAlbumVideoAdapter", "android version: %s, manufacturer: %s, brand: %s, model: %s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Build.MANUFACTURER, Build.BRAND, Build.MODEL });
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        Object localObject2 = ((JSONObject)localObject1).optString("devices");
        p.g(localObject2, "`object`.optString(\"devices\")");
        int j = ((JSONObject)localObject1).optInt("maxsize");
        localObject1 = new JSONArray((String)localObject2);
        int k = ((JSONArray)localObject1).length();
        int i = 0;
        while (i < k)
        {
          localObject2 = ((JSONArray)localObject1).optJSONObject(i);
          p.g(localObject2, "array.optJSONObject(i)");
          if ((n.I(Build.MANUFACTURER, ((JSONObject)localObject2).optString("brand"), true)) && (n.I(Build.MODEL, ((JSONObject)localObject2).optString("model"), true)))
          {
            long l = s.boW(paramString);
            if ((j != 0) && (l > j * 1024 * 1024))
            {
              Log.i("Music.MusicMvAlbumVideoAdapter", "hit devices but it is too big, fileSize: %s, maxSize: %s, filePath: %s", new Object[] { Long.valueOf(l), Integer.valueOf(j), paramString });
              AppMethodBeat.o(256979);
              return false;
            }
            int m = ((JSONObject)localObject2).optInt("androidVersion");
            if (-1 == m)
            {
              Log.i("Music.MusicMvAlbumVideoAdapter", "hit devices all version, manufacturer: %s, brand: %s, model: %s", new Object[] { Build.MANUFACTURER, Build.BRAND, Build.MODEL });
              AppMethodBeat.o(256979);
              return true;
            }
            if (Build.VERSION.SDK_INT == m)
            {
              Log.i("Music.MusicMvAlbumVideoAdapter", "hit devices, version: %s, manufacturer: %s, brand: %s, model: %s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Build.MANUFACTURER, Build.BRAND, Build.MODEL });
              AppMethodBeat.o(256979);
              return true;
            }
          }
          i += 1;
        }
        return false;
      }
      catch (JSONException paramString)
      {
        Log.printErrStackTrace("Music.MusicMvAlbumVideoAdapter", (Throwable)paramString, "parse json error", new Object[0]);
        AppMethodBeat.o(256979);
      }
    }
    
    private final void dRS()
    {
      AppMethodBeat.i(256980);
      if (this.xnI == null)
      {
        AppMethodBeat.o(256980);
        return;
      }
      long l = Util.currentTicks();
      try
      {
        String str = this.xnI.aQn();
        p.g(str, "mediaItem.thumbPath");
        Object localObject = SightVideoJNI.getSimpleMp4InfoVFS(str);
        p.g(localObject, "SightVideoJNI.getSimpleMp4InfoVFS(path)");
        Log.d("Music.MusicMvAlbumVideoAdapter", "get simple mp4 info %s", new Object[] { localObject });
        localObject = new JSONObject((String)localObject);
        this.xnI.jkS = ((JSONObject)localObject).getInt("videoDuration");
        this.xnI.videoHeight = ((JSONObject)localObject).getInt("videoHeight");
        this.xnI.videoWidth = ((JSONObject)localObject).getInt("videoWidth");
        this.xnI.videoBitRate = ((JSONObject)localObject).getInt("videoBitrate");
        this.xnI.videoFrameRate = ((JSONObject)localObject).getInt("videoFPS");
        this.xnI.ihS = SightVideoJNI.getMp4RotateVFS(str);
        this.xnI.videoIFrameInterval = 0;
        this.xnI.jkQ = com.tencent.mm.plugin.gallery.a.b.azg(((JSONObject)localObject).getString("videoType"));
        this.xnI.jkR = com.tencent.mm.plugin.gallery.a.b.azg(((JSONObject)localObject).getString("audioType"));
        Log.d("Music.MusicMvAlbumVideoAdapter", "loadItemFromSimpleMP4Info mediaItem: %s", new Object[] { this.xnI });
        Log.i("Music.MusicMvAlbumVideoAdapter", "loadItemFromSimpleMP4Info used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
        AppMethodBeat.o(256980);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("Music.MusicMvAlbumVideoAdapter", (Throwable)localException, "loadItemFromSimpleMP4Info fail", new Object[0]);
        }
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(256976);
      if (!(paramObject instanceof e))
      {
        AppMethodBeat.o(256976);
        return false;
      }
      boolean bool = p.j(this.xnI, ((e)paramObject).xnI);
      AppMethodBeat.o(256976);
      return bool;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(256977);
      GalleryItem.VideoMediaItem localVideoMediaItem = this.xnI;
      if (localVideoMediaItem != null)
      {
        int i = localVideoMediaItem.hashCode();
        AppMethodBeat.o(256977);
        return i;
      }
      AppMethodBeat.o(256977);
      return 0;
    }
    
    public final void run()
    {
      AppMethodBeat.i(256978);
      if (this.ifz)
      {
        AppMethodBeat.o(256978);
        return;
      }
      Object localObject1 = this.xnI;
      if (localObject1 == null) {
        p.hyc();
      }
      localObject1 = ((GalleryItem.VideoMediaItem)localObject1).aQn();
      p.g(localObject1, "mediaItem!!.thumbPath");
      Object localObject4;
      int i;
      label164:
      long l;
      c localc;
      String str1;
      if (ayX((String)localObject1))
      {
        dRS();
        if (this.ifz) {
          break label887;
        }
        if (!p.j(Looper.myLooper(), Looper.getMainLooper())) {
          break label873;
        }
        localObject1 = this.ArO;
        if (localObject1 != null)
        {
          localObject4 = this.xnI;
          if (localObject4 == null) {
            p.hyc();
          }
          ((b)localObject1).a(this, ((GalleryItem.VideoMediaItem)localObject4).jkS);
          AppMethodBeat.o(256978);
        }
      }
      else
      {
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.skt, 0) == 1) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label164;
          }
          dRS();
          break;
        }
        l = Util.currentTicks();
        localc = new c();
        localObject1 = this.xnI;
        if (localObject1 == null) {
          p.hyc();
        }
        str1 = ((GalleryItem.VideoMediaItem)localObject1).aQn();
        p.g(str1, "mediaItem!!.thumbPath");
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
            p.g(localMediaFormat, "extractor.getTrackFormat(i)");
            if (!localMediaFormat.containsKey("mime"))
            {
              Log.d("Music.MusicMvAlbumVideoAdapter", "find video mime : not found.");
              localObject7 = localObject4;
              localObject8 = localObject1;
              break label894;
            }
            str2 = localMediaFormat.getString("mime");
            Log.d("Music.MusicMvAlbumVideoAdapter", "find video mime : %s", new Object[] { str2 });
            localObject7 = localObject4;
            localObject8 = localObject1;
            if (str2 == null) {
              break label894;
            }
            if (!n.J(str2, "video/", false)) {
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
          if (this.xnI != null)
          {
            if (localObject6 != null)
            {
              localObject1 = this.xnI;
              if (localObject6.containsKey("durationUs")) {
                continue;
              }
              i = 0;
              ((GalleryItem.VideoMediaItem)localObject1).jkS = i;
              localObject1 = this.xnI;
              if (localObject6.containsKey("height")) {
                continue;
              }
              i = 0;
              ((GalleryItem.VideoMediaItem)localObject1).videoHeight = i;
              localObject1 = this.xnI;
              if (localObject6.containsKey("width")) {
                continue;
              }
              i = 0;
              ((GalleryItem.VideoMediaItem)localObject1).videoWidth = i;
              localObject4 = this.xnI;
              if (localObject6.containsKey("mime")) {
                continue;
              }
              localObject1 = "";
              ((GalleryItem.VideoMediaItem)localObject4).jkQ = ((String)localObject1);
              localObject1 = this.xnI;
              if (localObject6.containsKey("bitrate")) {
                continue;
              }
              i = 0;
              ((GalleryItem.VideoMediaItem)localObject1).videoBitRate = i;
              localObject1 = this.xnI;
              if (localObject6.containsKey("i-frame-interval")) {
                continue;
              }
              i = 0;
              ((GalleryItem.VideoMediaItem)localObject1).videoIFrameInterval = i;
              localObject1 = this.xnI;
              if (localObject6.containsKey("frame-rate")) {
                continue;
              }
              i = 0;
              ((GalleryItem.VideoMediaItem)localObject1).videoFrameRate = i;
              this.xnI.ihS = SightVideoJNI.getMp4RotateVFS(str1);
            }
            if (localObject5 != null)
            {
              localObject4 = this.xnI;
              if (localObject5.containsKey("mime")) {
                continue;
              }
              localObject1 = "";
              ((GalleryItem.VideoMediaItem)localObject4).jkR = ((String)localObject1);
            }
          }
          Log.d("Music.MusicMvAlbumVideoAdapter", "loadItemFromExtractor mediaItem: %s", new Object[] { this.xnI });
          Log.d("Music.MusicMvAlbumVideoAdapter", "mediaItem format:%s, videoPath:%s", new Object[] { localObject6, str1 });
          localc.release();
        }
        catch (Exception localException)
        {
          MediaFormat localMediaFormat;
          String str2;
          Log.d("Music.MusicMvAlbumVideoAdapter", "Video extractor init failed. video path = [%s] e = [%s]", new Object[] { str1, localException.getMessage() });
          localc.release();
          continue;
        }
        finally
        {
          localc.release();
          AppMethodBeat.o(256978);
        }
        Log.i("Music.MusicMvAlbumVideoAdapter", "loadItemFromExtractor used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
        break;
        Object localObject5 = localObject4;
        Object localObject6 = localObject1;
        if (n.J(str2, "audio/", false))
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
            AppMethodBeat.o(256978);
            return;
            label873:
            MMHandlerThread.postToMainThread((Runnable)new c(this));
            label887:
            AppMethodBeat.o(256978);
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
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$SimpleVideoAnalysisTask$Companion;", "", "()V", "taskContainer", "Ljava/util/HashMap;", "Landroid/widget/TextView;", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$SimpleVideoAnalysisTask;", "clearFetchDurationTask", "", "fetchDurationMs", "tv", "iv", "Landroid/widget/ImageView;", "videoMediaItem", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;", "videoMinDurationMs", "", "videoMaxDurationMs", "setResult", "durationMs", "plugin-mv_release"})
    public static final class a
    {
      static void a(TextView paramTextView, ImageView paramImageView, int paramInt1, int paramInt2, int paramInt3)
      {
        AppMethodBeat.i(256974);
        if (paramTextView == null)
        {
          AppMethodBeat.o(256974);
          return;
        }
        if (paramInt1 < 0)
        {
          paramTextView.setText((CharSequence)"--:--");
          AppMethodBeat.o(256974);
          return;
        }
        paramInt1 = com.tencent.mm.plugin.mv.ui.a.e.Tm(paramInt1);
        paramInt2 = com.tencent.mm.plugin.mv.ui.a.e.Tl(paramInt2);
        paramInt3 = com.tencent.mm.plugin.mv.ui.a.e.Tn(paramInt3);
        if (paramImageView != null)
        {
          if ((paramInt1 < paramInt2) || (paramInt1 > paramInt3)) {
            break label146;
          }
          paramImageView.setBackgroundResource(2131234161);
        }
        for (;;)
        {
          String str = String.valueOf(paramInt1 % 60);
          paramImageView = str;
          if (str.length() < 2) {
            paramImageView = "0".concat(String.valueOf(str));
          }
          paramTextView.setText((CharSequence)(String.valueOf(paramInt1 / 60) + ":" + paramImageView));
          AppMethodBeat.o(256974);
          return;
          label146:
          paramImageView.setBackgroundColor(com.tencent.mm.cb.a.n(paramImageView.getContext(), 2131099835));
        }
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$SimpleVideoAnalysisTask$Companion$fetchDurationMs$task$1", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$SimpleVideoAnalysisTask$Listener;", "onResult", "", "task", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$SimpleVideoAnalysisTask;", "durationMs", "", "plugin-mv_release"})
      public static final class a
        implements b.e.b
      {
        a(int paramInt1, int paramInt2) {}
        
        public final void a(b.e parame, int paramInt)
        {
          AppMethodBeat.i(256973);
          if (parame != null) {}
          for (Object localObject = b.e.c(parame); localObject == null; localObject = null)
          {
            AppMethodBeat.o(256973);
            return;
          }
          localObject = b.e.c(parame);
          if (localObject == null) {
            p.hyc();
          }
          localObject = (TextView)((WeakReference)localObject).get();
          if (localObject == null)
          {
            AppMethodBeat.o(256973);
            return;
          }
          parame = (ImageView)b.e.f(parame).get();
          if (parame == null)
          {
            AppMethodBeat.o(256973);
            return;
          }
          b.e.a locala = b.e.ArP;
          b.e.a.a((TextView)localObject, parame, paramInt, this.ArQ, this.ArR);
          b.e.evH().remove(localObject);
          AppMethodBeat.o(256973);
        }
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$SimpleVideoAnalysisTask$Listener;", "", "onResult", "", "task", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$SimpleVideoAnalysisTask;", "durationMs", "", "plugin-mv_release"})
    static abstract interface b
    {
      public abstract void a(b.e parame, int paramInt);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$SimpleVideoAnalysisTask$notifyObserver$1", "Ljava/lang/Runnable;", "run", "", "plugin-mv_release"})
    public static final class c
      implements Runnable
    {
      public final void run()
      {
        AppMethodBeat.i(256975);
        b.e.b localb = b.e.a(this.ArS);
        if (localb != null)
        {
          b.e locale = this.ArS;
          GalleryItem.VideoMediaItem localVideoMediaItem = b.e.b(this.ArS);
          if (localVideoMediaItem == null) {
            p.hyc();
          }
          localb.a(locale, localVideoMediaItem.jkS);
          AppMethodBeat.o(256975);
          return;
        }
        AppMethodBeat.o(256975);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$mOnClickListener$1", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-mv_release"})
  public static final class f
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(256985);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$mOnClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      p.h(paramView, "v");
      localObject = paramView.getTag(2131302847);
      int i;
      if ((localObject instanceof Integer))
      {
        i = ((Number)localObject).intValue();
        localObject = paramView.getTag(2131302872);
        if (!(localObject instanceof Integer)) {
          break label163;
        }
      }
      label163:
      for (int j = ((Number)localObject).intValue();; j = -1)
      {
        if ((i != -1) && (j != -1) && (b.b(this.ArT) != null))
        {
          localObject = b.b(this.ArT);
          if (localObject == null) {
            p.hyc();
          }
          ((b.d)localObject).a(i, paramView, j);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$mOnClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(256985);
        return;
        i = -1;
        break;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$onItemViewLongClick$1", "Landroid/view/View$OnLongClickListener;", "onLongClick", "", "v", "Landroid/view/View;", "plugin-mv_release"})
  public static final class g
    implements View.OnLongClickListener
  {
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(256986);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$onItemViewLongClick$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
      p.h(paramView, "v");
      paramView = paramView.getTag(2131302847);
      p.g(paramView, "v.getTag(R.id.item_position)");
      if ((paramView instanceof Integer))
      {
        paramView = this.ArT.NK(((Number)paramView).intValue());
        if (paramView != null) {
          ClipboardHelper.setText(b.a(this.ArT), (CharSequence)"media info", (CharSequence)paramView.toString());
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumVideoAdapter$onItemViewLongClick$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(256986);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.adapter.b
 * JD-Core Version:    0.7.0.1
 */