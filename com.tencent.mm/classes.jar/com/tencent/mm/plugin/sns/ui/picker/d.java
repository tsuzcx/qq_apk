package com.tencent.mm.plugin.sns.ui.picker;

import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.br;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapterBase;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "()V", "mSnsArguments", "Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapterBase$SnsInfoArguments;", "getMSnsArguments", "()Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapterBase$SnsInfoArguments;", "mSnsArguments$delegate", "Lkotlin/Lazy;", "filterLan", "", "context", "Landroid/content/Context;", "getFixPosition", "", "getLimitSeq", "getUserName", "isCurPageLoadAll", "", "isDataLoadAll", "isMySelf", "setCurPageLoadAll", "", "value", "tips", "setDataLoadAll", "isAll", "setFixPosition", "fixPos", "setRecentLimitedID", "limitedID", "", "setRespMinSeq", "respMinSeq", "setUserName", "name", "updateLimitSeq", "getListId", "firstPage", "limitSeq", "Companion", "SnsInfoArguments", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class d
  extends RecyclerView.a<RecyclerView.v>
{
  public static final d.a RRP = new d.a((byte)0);
  private final j RRQ = k.cm((a)c.RRT);
  
  public void Ev(boolean paramBoolean)
  {
    hrz().RRR = paramBoolean;
  }
  
  public final void baQ(String paramString)
  {
    s.u(paramString, "respMinSeq");
    b localb = hrz();
    s.u(paramString, "<set-?>");
    localb.RHr = paramString;
  }
  
  public final void bbh(String paramString)
  {
    s.u(paramString, "tips");
    hrz().RRS = true;
    b localb = hrz();
    s.u(paramString, "<set-?>");
    localb.vEv = paramString;
  }
  
  public final void bbi(String paramString)
  {
    s.u(paramString, "limitSeq");
    hrz().bbj(paramString);
  }
  
  public final b hrz()
  {
    return (b)this.RRQ.getValue();
  }
  
  public final void setUserName(String paramString)
  {
    s.u(paramString, "name");
    b localb = hrz();
    s.u(paramString, "<set-?>");
    localb.luk = paramString;
  }
  
  public final void vr(long paramLong)
  {
    if (0L != hrz().RHu) {
      return;
    }
    hrz().RHu = paramLong;
    hrz().RHv = 0L;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapterBase$SnsInfoArguments;", "", "()V", "mAllPageDataLoadFinish", "", "getMAllPageDataLoadFinish", "()Z", "setMAllPageDataLoadFinish", "(Z)V", "mCorrectLimitedID", "", "getMCorrectLimitedID", "()J", "setMCorrectLimitedID", "(J)V", "mCurDataCount", "", "getMCurDataCount", "()I", "setMCurDataCount", "(I)V", "mFixPosition", "getMFixPosition", "setMFixPosition", "mFromScene", "Lcom/tencent/mm/storage/FROM_SCENE;", "kotlin.jvm.PlatformType", "getMFromScene", "()Lcom/tencent/mm/storage/FROM_SCENE;", "setMFromScene", "(Lcom/tencent/mm/storage/FROM_SCENE;)V", "mIsCurPageLoadAll", "getMIsCurPageLoadAll", "setMIsCurPageLoadAll", "mIsPrivacy", "getMIsPrivacy", "setMIsPrivacy", "mIsSelf", "getMIsSelf", "setMIsSelf", "mIsUpAll", "getMIsUpAll", "setMIsUpAll", "mLang", "", "getMLang", "()Ljava/lang/String;", "setMLang", "(Ljava/lang/String;)V", "mLimitSeq", "getMLimitSeq", "setMLimitSeq", "mLimitedID", "getMLimitedID", "setMLimitedID", "mRespMinSeq", "getMRespMinSeq", "setMRespMinSeq", "mTips", "getMTips", "setMTips", "mUserName", "getMUserName", "setMUserName", "prePageDayEndFlagFeedId", "getPrePageDayEndFlagFeedId", "setPrePageDayEndFlagFeedId", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    private String HqN;
    String RHr;
    String RHs;
    boolean RHt;
    long RHu;
    long RHv;
    int RHw;
    boolean RRR;
    boolean RRS;
    boolean RdS;
    private br RvM;
    String luk;
    String vEv;
    
    public b()
    {
      AppMethodBeat.i(308632);
      this.RHs = "";
      this.HqN = "";
      this.RHr = "";
      this.luk = "";
      this.RdS = true;
      this.vEv = "";
      this.RvM = br.jbj();
      AppMethodBeat.o(308632);
    }
    
    public final void bbj(String paramString)
    {
      AppMethodBeat.i(308639);
      s.u(paramString, "<set-?>");
      this.RHs = paramString;
      AppMethodBeat.o(308639);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapterBase$SnsInfoArguments;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<d.b>
  {
    public static final c RRT;
    
    static
    {
      AppMethodBeat.i(308625);
      RRT = new c();
      AppMethodBeat.o(308625);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.picker.d
 * JD-Core Version:    0.7.0.1
 */