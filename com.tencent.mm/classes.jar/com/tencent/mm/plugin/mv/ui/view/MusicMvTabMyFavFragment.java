package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.mv.model.a.j;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabMyFavFragment;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "totalCnt", "getFeedFrom", "getType", "onDestroy", "", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "syncGetFeeds", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "songId", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicMvTabMyFavFragment
  extends MusicMvTabFragment
  implements com.tencent.mm.am.h
{
  public static final MusicMvTabMyFavFragment.a MjV;
  private int EcL;
  private b lastBuffer;
  
  static
  {
    AppMethodBeat.i(287095);
    MjV = new MusicMvTabMyFavFragment.a((byte)0);
    AppMethodBeat.o(287095);
  }
  
  public MusicMvTabMyFavFragment(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(287057);
    AppMethodBeat.o(287057);
  }
  
  public MusicMvTabMyFavFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(287070);
    AppMethodBeat.o(287070);
  }
  
  private MusicMvTabMyFavFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(287085);
    com.tencent.mm.kernel.h.aZW().a(3966, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(287085);
  }
  
  public final void a(com.tencent.mm.plugin.music.model.e.a parama, String paramString)
  {
    AppMethodBeat.i(287112);
    super.a(parama, paramString);
    parama = z.bAW();
    kotlin.g.b.s.s(parama, "finderUsername");
    parama = new j(parama, this.lastBuffer);
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)parama, 0);
    AppMethodBeat.o(287112);
  }
  
  public final int getFeedFrom()
  {
    return 5;
  }
  
  public final int getType()
  {
    return 3;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(287103);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(3966, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(287103);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(287140);
    if ((paramp instanceof j)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((j)paramp).LZd;
        if (paramString == null)
        {
          paramString = null;
          this.lastBuffer = paramString;
          paramString = ((j)paramp).LZd;
          if (paramString == null) {
            break label327;
          }
          this.EcL = paramString.lNX;
          paramString = paramString.object.iterator();
        }
      }
    }
    label70:
    label327:
    label462:
    label465:
    for (;;)
    {
      FinderObject localFinderObject;
      Object localObject;
      if (paramString.hasNext())
      {
        localFinderObject = (FinderObject)paramString.next();
        if (localFinderObject == null) {
          continue;
        }
        localObject = com.tencent.mm.plugin.mv.ui.a.Maz;
        com.tencent.mm.plugin.mv.ui.a.R(localFinderObject);
        localObject = localFinderObject.objectDesc;
        if (localObject == null) {
          break label462;
        }
        localObject = ((FinderObjectDesc)localObject).media;
        if (localObject == null) {
          break label462;
        }
        localObject = (FinderMedia)kotlin.a.p.oL((List)localObject);
        if ((localObject == null) || (((FinderMedia)localObject).mediaType != 2)) {
          break label462;
        }
      }
      for (paramInt1 = 0;; paramInt1 = 1)
      {
        if (paramInt1 == 0) {
          break label465;
        }
        long l = localFinderObject.id;
        localObject = localFinderObject.objectNonceId;
        if (getFeedIdMap().contains(Long.valueOf(l))) {
          break label70;
        }
        getDataList().add(new MusicMvTabFragment.d(new MusicMvTabFragment.f(l, (String)localObject, localFinderObject, (byte)0)));
        break label70;
        paramString = paramString.lastBuffer;
        break;
        getAdapter().bZE.notifyChanged();
        paramString = ((j)paramp).LZd;
        boolean bool;
        if (paramString == null)
        {
          paramString = null;
          if (paramString != null) {
            break label426;
          }
          bool = true;
          setHasMore(bool);
          paramString = getOnSceneEndListener();
          if (paramString != null) {
            paramString.invoke();
          }
          Log.i("Music.MusicMvTabFragment", "onSceneEnd GetFinderFavFeed " + getDataList().size() + ", hasMore:" + getHasMore());
          getRlLayout().aFW(0);
          paramString = getResultListener();
          if (paramString != null) {
            paramString.kg(2, getAdapter().getItemCount());
          }
          paramString = getAdapter();
          if ((paramString == null) || (paramString.getItemCount() != 0)) {
            break label439;
          }
          paramInt1 = 1;
          label376:
          if (paramInt1 == 0) {
            break label444;
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
          AppMethodBeat.o(287140);
          return;
          paramString = Integer.valueOf(paramString.continueFlag);
          break;
          if (paramString.intValue() != 0) {
            break label260;
          }
          bool = false;
          break label263;
          paramInt1 = 0;
          break label376;
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
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvTabMyFavFragment
 * JD-Core Version:    0.7.0.1
 */