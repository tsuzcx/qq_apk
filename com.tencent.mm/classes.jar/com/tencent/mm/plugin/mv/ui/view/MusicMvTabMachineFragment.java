package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.mv.model.a.i;
import com.tencent.mm.plugin.mv.model.m;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.dsr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabMachineFragment;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "totalCnt", "getFeedFrom", "getType", "onDestroy", "", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "syncGetFeeds", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "songId", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicMvTabMachineFragment
  extends MusicMvTabFragment
  implements com.tencent.mm.am.h
{
  public static final MusicMvTabMachineFragment.a MjU;
  private int EcL;
  private b lastBuffer;
  
  static
  {
    AppMethodBeat.i(286914);
    MjU = new MusicMvTabMachineFragment.a((byte)0);
    AppMethodBeat.o(286914);
  }
  
  public MusicMvTabMachineFragment(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(286895);
    AppMethodBeat.o(286895);
  }
  
  public MusicMvTabMachineFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(286902);
    AppMethodBeat.o(286902);
  }
  
  private MusicMvTabMachineFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(286908);
    com.tencent.mm.kernel.h.aZW().a(6860, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(286908);
  }
  
  public final void a(com.tencent.mm.plugin.music.model.e.a parama, String paramString)
  {
    AppMethodBeat.i(286926);
    super.a(parama, getKeyword());
    Log.i("Music.MusicMvTabFragment", kotlin.g.b.s.X("syncBgFinderFeed ", paramString));
    if (parama != null)
    {
      parama = getContext();
      kotlin.g.b.s.s(parama, "context");
      parama = new i(parama, this.lastBuffer);
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)parama, 0);
    }
    AppMethodBeat.o(286926);
  }
  
  public final int getFeedFrom()
  {
    return 3;
  }
  
  public final int getType()
  {
    return 1;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(286918);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(6860, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(286918);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(286937);
    Object localObject2 = new StringBuilder("onSceneEnd, type:");
    Object localObject1;
    if (paramp == null)
    {
      localObject1 = null;
      Log.i("Music.MusicMvTabFragment", localObject1 + ", errType:" + paramInt1 + ", errcode:" + paramInt2 + ", errMsg:" + paramString);
      if (!(paramp instanceof i)) {
        break label513;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label443;
      }
      paramString = ((i)paramp).LXH;
      if (paramString != null) {
        break label303;
      }
      paramString = null;
      label97:
      this.lastBuffer = paramString;
      paramString = ((i)paramp).LXH;
      if (paramString == null) {
        break label443;
      }
      this.EcL = paramString.object.size();
      localObject1 = paramString.object.iterator();
    }
    label135:
    label524:
    label530:
    label548:
    label551:
    for (;;)
    {
      Object localObject3;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FinderObject)((Iterator)localObject1).next();
        if (localObject2 == null) {
          continue;
        }
        localObject3 = com.tencent.mm.plugin.mv.ui.a.Maz;
        com.tencent.mm.plugin.mv.ui.a.R((FinderObject)localObject2);
        localObject3 = ((FinderObject)localObject2).objectDesc;
        if (localObject3 == null) {
          break label548;
        }
        localObject3 = ((FinderObjectDesc)localObject3).media;
        if (localObject3 == null) {
          break label548;
        }
        localObject3 = (FinderMedia)kotlin.a.p.oL((List)localObject3);
        if ((localObject3 == null) || (((FinderMedia)localObject3).mediaType != 2)) {
          break label548;
        }
      }
      for (paramInt1 = 0;; paramInt1 = 1)
      {
        if (paramInt1 == 0) {
          break label551;
        }
        long l = ((FinderObject)localObject2).id;
        localObject3 = ((FinderObject)localObject2).objectNonceId;
        if (getFeedIdMap().contains(Long.valueOf(l))) {
          break label135;
        }
        getDataList().add(new MusicMvTabFragment.d(new MusicMvTabFragment.f(l, (String)localObject3, (FinderObject)localObject2, (byte)0)));
        break label135;
        localObject1 = Integer.valueOf(paramp.getType());
        break;
        label303:
        paramString = paramString.ZEQ;
        break label97;
        getAdapter().bZE.notifyChanged();
        paramp = ((i)paramp).LXH;
        boolean bool;
        if ((paramp != null) && (paramp.BeA == 0))
        {
          paramInt1 = 1;
          if (paramInt1 != 0) {
            break label524;
          }
          bool = true;
          label353:
          setHasMore(bool);
          paramString = paramString.request_id;
          paramp = getOnSceneEndListener();
          if (paramp != null) {
            paramp.invoke();
          }
          Log.i("Music.MusicMvTabFragment", "onSceneEnd GetFinderFavFeed " + getDataList().size() + ", hasMore:" + getHasMore() + ", report requestId:" + paramString);
          paramp = m.LYc;
          m.aPz(paramString);
          label443:
          getRlLayout().aFW(0);
          paramString = getResultListener();
          if (paramString != null) {
            paramString.kg(0, getAdapter().getItemCount());
          }
          if (getAdapter().getItemCount() != 0) {
            break label530;
          }
          paramString = getEmptyLL();
          if (paramString != null) {
            paramString.setVisibility(0);
          }
        }
        for (;;)
        {
          paramString = getLoadingTv();
          if (paramString != null) {
            paramString.setVisibility(8);
          }
          AppMethodBeat.o(286937);
          return;
          paramInt1 = 0;
          break;
          bool = false;
          break label353;
          paramString = getEmptyLL();
          if (paramString != null) {
            paramString.setVisibility(8);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvTabMachineFragment
 * JD-Core Version:    0.7.0.1
 */