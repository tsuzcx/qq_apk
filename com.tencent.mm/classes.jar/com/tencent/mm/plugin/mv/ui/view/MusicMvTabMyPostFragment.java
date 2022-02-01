package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.dt;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.FinderUserPageResponse;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabMyPostFragment;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getFeedFrom", "getType", "onDestroy", "", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "syncGetFeeds", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "keyword", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicMvTabMyPostFragment
  extends MusicMvTabFragment
  implements com.tencent.mm.am.h
{
  public static final MusicMvTabMyPostFragment.a MjX;
  private b lastBuffer;
  
  static
  {
    AppMethodBeat.i(287124);
    MjX = new MusicMvTabMyPostFragment.a((byte)0);
    AppMethodBeat.o(287124);
  }
  
  public MusicMvTabMyPostFragment(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(287109);
    AppMethodBeat.o(287109);
  }
  
  public MusicMvTabMyPostFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(287113);
    AppMethodBeat.o(287113);
  }
  
  private MusicMvTabMyPostFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(287118);
    com.tencent.mm.kernel.h.aZW().a(3736, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(287118);
  }
  
  public final void a(com.tencent.mm.plugin.music.model.e.a parama, String paramString)
  {
    AppMethodBeat.i(287138);
    super.a(parama, paramString);
    parama = z.bAW();
    paramString = new bui();
    paramString.AJo = 93;
    paramString.hLK = 93;
    kotlin.g.b.s.s(parama, "finderUsername");
    parama = new dt(parama, 0L, this.lastBuffer, 0, paramString, 0, 0L, false, null, 0L, null, null, null, 8064);
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)parama, 0);
    AppMethodBeat.o(287138);
  }
  
  public final int getFeedFrom()
  {
    return 4;
  }
  
  public final int getType()
  {
    return 2;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(287130);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(3736, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(287130);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(287201);
    FinderObject localFinderObject;
    Object localObject;
    if (((paramp instanceof dt)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      this.lastBuffer = ((dt)paramp).getLastBuffer();
      paramString = c.c.b(((dt)paramp).rr.otC);
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
        AppMethodBeat.o(287201);
        throw paramString;
      }
      paramString = (List)((FinderUserPageResponse)paramString).object;
      if (paramString != null)
      {
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          localFinderObject = (FinderObject)paramString.next();
          if (localFinderObject != null)
          {
            localObject = com.tencent.mm.plugin.mv.ui.a.Maz;
            com.tencent.mm.plugin.mv.ui.a.R(localFinderObject);
            localObject = localFinderObject.objectDesc;
            if (localObject == null) {
              break label404;
            }
            localObject = ((FinderObjectDesc)localObject).media;
            if (localObject == null) {
              break label404;
            }
            localObject = (FinderMedia)kotlin.a.p.oL((List)localObject);
            if ((localObject == null) || (((FinderMedia)localObject).mediaType != 2)) {
              break label404;
            }
          }
        }
      }
    }
    label386:
    label404:
    for (paramInt1 = 0;; paramInt1 = 1)
    {
      if (localFinderObject.privateFlag == 1) {
        paramInt1 = 0;
      }
      if (paramInt1 == 0) {
        break;
      }
      long l = localFinderObject.id;
      localObject = localFinderObject.objectNonceId;
      if (getFeedIdMap().contains(Long.valueOf(l))) {
        break;
      }
      getDataList().add(new MusicMvTabFragment.d(new MusicMvTabFragment.f(l, (String)localObject, localFinderObject, (byte)0)));
      break;
      getAdapter().bZE.notifyChanged();
      paramString = getOnSceneEndListener();
      if (paramString != null) {
        paramString.invoke();
      }
      setHasMore(((dt)paramp).ABD);
      getRlLayout().aFW(0);
      paramString = getResultListener();
      if (paramString != null) {
        paramString.kg(1, getAdapter().getItemCount());
      }
      paramString = getAdapter();
      if ((paramString != null) && (paramString.getItemCount() == 0))
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label386;
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
        AppMethodBeat.o(287201);
        return;
        paramInt1 = 0;
        break;
        paramString = getEmptyLL();
        if (paramString != null) {
          paramString.setVisibility(8);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvTabMyPostFragment
 * JD-Core Version:    0.7.0.1
 */