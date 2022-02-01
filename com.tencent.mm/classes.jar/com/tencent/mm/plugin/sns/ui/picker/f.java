package com.tencent.mm.plugin.sns.ui.picker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumVideoEditArgument;", "", "mediaStoragePathList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "isAllPhoto", "", "enterTransition", "", "outTransition", "biz", "(Ljava/util/ArrayList;ZIII)V", "IMAGE_COMPRESS_QUALITY", "getIMAGE_COMPRESS_QUALITY", "()I", "setIMAGE_COMPRESS_QUALITY", "(I)V", "IMAGE_MAX_HEIGHT", "getIMAGE_MAX_HEIGHT", "setIMAGE_MAX_HEIGHT", "IMAGE_MAX_WIDTH", "getIMAGE_MAX_WIDTH", "setIMAGE_MAX_WIDTH", "MAX_VIDEO_PLAY_DURATION", "getMAX_VIDEO_PLAY_DURATION", "MAX_VIDEO_PLAY_DURATION$delegate", "Lkotlin/Lazy;", "MEDIA_MAX_HEIGHT_RATIO", "", "MEDIA_MIN_HEIGHT_RATIO", "getBiz", "getEnterTransition", "()Z", "getMediaStoragePathList", "()Ljava/util/ArrayList;", "getOutTransition", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "getAlbumProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getGalleryMediaItemArrayList", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "getWhere", "hashCode", "loadProviderRouter", "", "provider", "toString", "Companion", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f.a RSJ;
  private int FAS;
  private int FAT;
  private int FAU;
  final j FBz;
  private final float MjR;
  private final float MjS;
  final boolean RRd;
  private final ArrayList<String> RSK;
  final int RSL;
  final int RSM;
  final int biz;
  
  static
  {
    AppMethodBeat.i(308787);
    RSJ = new f.a((byte)0);
    AppMethodBeat.o(308787);
  }
  
  private f(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(308748);
    this.RSK = paramArrayList;
    this.RRd = paramBoolean;
    this.RSL = 0;
    this.RSM = 0;
    this.biz = 0;
    this.MjR = 1.316667F;
    this.MjS = 0.95F;
    this.FBz = k.cm((kotlin.g.a.a)f.b.RSN);
    this.FAT = 1080;
    this.FAS = 1280;
    this.FAU = 90;
    AppMethodBeat.o(308748);
  }
  
  public static int eQo()
  {
    AppMethodBeat.i(308776);
    String str = ((com.tencent.mm.plugin.zero.b.a)h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue("FinderFeedCompressResolution");
    CharSequence localCharSequence = (CharSequence)str;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(308776);
      return 1280;
    }
    s.s(str, "info");
    i = Util.safeParseInt((String)n.a((CharSequence)n.bq((CharSequence)str).toString(), new String[] { "*" }).get(1));
    AppMethodBeat.o(308776);
    return i;
  }
  
  public static int eQp()
  {
    AppMethodBeat.i(308770);
    String str = ((com.tencent.mm.plugin.zero.b.a)h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue("FinderFeedCompressResolution");
    CharSequence localCharSequence = (CharSequence)str;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(308770);
      return 1080;
    }
    s.s(str, "info");
    i = Util.safeParseInt((String)n.a((CharSequence)n.bq((CharSequence)str).toString(), new String[] { "*" }).get(0));
    AppMethodBeat.o(308770);
    return i;
  }
  
  public static int eQq()
  {
    AppMethodBeat.i(308783);
    String str = ((com.tencent.mm.plugin.zero.b.a)h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue("FinderFeedCompressPicLevel");
    CharSequence localCharSequence = (CharSequence)str;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(308783);
      return 90;
    }
    s.s(str, "info");
    i = Util.safeParseInt(n.bq((CharSequence)str).toString());
    AppMethodBeat.o(308783);
    return i;
  }
  
  static void t(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(308762);
    if (((c)h.ax(c.class)).a(c.a.zdz, true)) {
      paramRecordConfigProvider.cD(4, "com.tencent.mm.plugin.vlog.ui.timelineeditor.scene.TimelineEditorFollowMusicPluginLayout");
    }
    for (;;)
    {
      paramRecordConfigProvider.cD(3, "com.tencent.mm.plugin.vlog.ui.MultiVideoFullScreenPluginLayout");
      paramRecordConfigProvider.cD(1, "com.tencent.mm.plugin.vlog.ui.MultiVideoFullScreenPluginLayout");
      paramRecordConfigProvider.cD(0, "com.tencent.mm.plugin.finder.video.FinderRecordPluginLayout");
      AppMethodBeat.o(308762);
      return;
      paramRecordConfigProvider.cD(4, "com.tencent.mm.plugin.vlog.ui.MultiVideoFullScreenPluginLayout");
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(308810);
    if (this == paramObject)
    {
      AppMethodBeat.o(308810);
      return true;
    }
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(308810);
      return false;
    }
    paramObject = (f)paramObject;
    if (!s.p(this.RSK, paramObject.RSK))
    {
      AppMethodBeat.o(308810);
      return false;
    }
    if (this.RRd != paramObject.RRd)
    {
      AppMethodBeat.o(308810);
      return false;
    }
    if (this.RSL != paramObject.RSL)
    {
      AppMethodBeat.o(308810);
      return false;
    }
    if (this.RSM != paramObject.RSM)
    {
      AppMethodBeat.o(308810);
      return false;
    }
    if (this.biz != paramObject.biz)
    {
      AppMethodBeat.o(308810);
      return false;
    }
    AppMethodBeat.o(308810);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final ArrayList<GalleryItem.MediaItem> hrM()
  {
    AppMethodBeat.i(308792);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.RSK.iterator();
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      s.s(str, "path");
      if (n.rs(str, ".mp4")) {}
      for (GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)new GalleryItem.VideoMediaItem(0L);; localMediaItem = (GalleryItem.MediaItem)new GalleryItem.ImageMediaItem())
      {
        localMediaItem.Gcc = str;
        if ((localMediaItem instanceof GalleryItem.VideoMediaItem)) {
          localMediaItem.mMimeType = "video/mp4";
        }
        localArrayList.add(localMediaItem);
        break;
      }
    }
    AppMethodBeat.o(308792);
    return localArrayList;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(308797);
    String str = "SnsAlbumVideoEditArgument(mediaStoragePathList=" + this.RSK + ", isAllPhoto=" + this.RRd + ", enterTransition=" + this.RSL + ", outTransition=" + this.RSM + ", biz=" + this.biz + ')';
    AppMethodBeat.o(308797);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.picker.f
 * JD-Core Version:    0.7.0.1
 */