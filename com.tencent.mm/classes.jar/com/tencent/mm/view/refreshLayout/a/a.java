package com.tencent.mm.view.refreshLayout.a;

import android.content.res.TypedArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.m;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/refreshLayout/config/CommonConfig;", "", "()V", "disableContentWhenLoading", "", "getDisableContentWhenLoading", "()Z", "setDisableContentWhenLoading", "(Z)V", "disableContentWhenRefresh", "getDisableContentWhenRefresh", "setDisableContentWhenRefresh", "dragRate", "", "getDragRate", "()F", "setDragRate", "(F)V", "enableAutoLoadMore", "getEnableAutoLoadMore", "setEnableAutoLoadMore", "enableFooterFollowWhenNoMoreData", "getEnableFooterFollowWhenNoMoreData", "setEnableFooterFollowWhenNoMoreData", "enableFooterMoveContent", "getEnableFooterMoveContent", "setEnableFooterMoveContent", "enableHeaderMoveContent", "getEnableHeaderMoveContent", "setEnableHeaderMoveContent", "enableLoadMore", "getEnableLoadMore", "setEnableLoadMore", "enableLoadMoreWhenContentNotFull", "getEnableLoadMoreWhenContentNotFull", "setEnableLoadMoreWhenContentNotFull", "enableNestedScrolling", "getEnableNestedScrolling", "setEnableNestedScrolling", "enableOverScrollBounce", "getEnableOverScrollBounce", "setEnableOverScrollBounce", "enableOverScrollDrag", "getEnableOverScrollDrag", "setEnableOverScrollDrag", "enablePureScrollMode", "getEnablePureScrollMode", "setEnablePureScrollMode", "enableRefresh", "getEnableRefresh", "setEnableRefresh", "enableScrollContentWhenLoaded", "getEnableScrollContentWhenLoaded", "setEnableScrollContentWhenLoaded", "enableScrollContentWhenRefreshed", "getEnableScrollContentWhenRefreshed", "setEnableScrollContentWhenRefreshed", "reboundDuration", "", "getReboundDuration", "()I", "setReboundDuration", "(I)V", "initConfig", "ta", "Landroid/content/res/TypedArray;", "Builder", "Companion", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.b agPD;
  public boolean Jcx = true;
  public boolean agJq = true;
  public float agPE = 0.6F;
  public boolean agPF = true;
  public boolean agPG = true;
  public boolean agPH = true;
  public boolean agPI;
  public boolean agPJ;
  public boolean agPK = true;
  public boolean agPL = true;
  public boolean agPM = true;
  public boolean agPN;
  public boolean agPO;
  public boolean agPP = true;
  public boolean agPQ;
  public boolean agPR;
  public int reboundDuration = 300;
  
  static
  {
    AppMethodBeat.i(235135);
    agPD = new a.b((byte)0);
    AppMethodBeat.o(235135);
  }
  
  public final a e(TypedArray paramTypedArray)
  {
    AppMethodBeat.i(235146);
    s.u(paramTypedArray, "ta");
    this.agPE = paramTypedArray.getFloat(a.m.WxRefreshLayout_dragRate, this.agPE);
    this.agJq = paramTypedArray.getBoolean(a.m.WxRefreshLayout_enableRefresh, this.agJq);
    this.reboundDuration = paramTypedArray.getInt(a.m.WxRefreshLayout_reboundDuration, this.reboundDuration);
    this.Jcx = paramTypedArray.getBoolean(a.m.WxRefreshLayout_enableLoadMore, this.Jcx);
    this.agPF = paramTypedArray.getBoolean(a.m.WxRefreshLayout_enableAutoLoadMore, this.agPF);
    this.agPG = paramTypedArray.getBoolean(a.m.WxRefreshLayout_enableHeaderMoveContent, this.agPG);
    this.agPH = paramTypedArray.getBoolean(a.m.WxRefreshLayout_enableFooterMoveContent, this.agPH);
    this.agPI = paramTypedArray.getBoolean(a.m.WxRefreshLayout_enableFooterFollowWhenNoMoreData, this.agPI);
    this.agPJ = paramTypedArray.getBoolean(a.m.WxRefreshLayout_enableLoadMoreWhenContentNotFull, this.agPJ);
    this.agPK = paramTypedArray.getBoolean(a.m.WxRefreshLayout_enableScrollContentWhenLoaded, this.agPK);
    this.agPL = paramTypedArray.getBoolean(a.m.WxRefreshLayout_enableScrollContentWhenRefreshed, this.agPL);
    this.agPM = paramTypedArray.getBoolean(a.m.WxRefreshLayout_enableOverScrollBounce, this.agPM);
    this.agPO = paramTypedArray.getBoolean(a.m.WxRefreshLayout_enablePureScrollMode, this.agPO);
    this.agPN = paramTypedArray.getBoolean(a.m.WxRefreshLayout_enableOverScrollDrag, this.agPN);
    this.agPP = paramTypedArray.getBoolean(a.m.WxRefreshLayout_enableNestedScrolling, this.agPP);
    this.agPQ = paramTypedArray.getBoolean(a.m.WxRefreshLayout_disableContentWhenRefresh, this.agPQ);
    this.agPR = paramTypedArray.getBoolean(a.m.WxRefreshLayout_disableContentWhenLoad, this.agPR);
    AppMethodBeat.o(235146);
    return this;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/view/refreshLayout/config/CommonConfig$Builder;", "", "()V", "disableContentWhenLoading", "", "getDisableContentWhenLoading", "()Z", "setDisableContentWhenLoading", "(Z)V", "disableContentWhenRefresh", "getDisableContentWhenRefresh", "setDisableContentWhenRefresh", "dragRate", "", "getDragRate", "()F", "setDragRate", "(F)V", "enableAutoLoadMore", "getEnableAutoLoadMore", "setEnableAutoLoadMore", "enableFooterFollowWhenNoMoreData", "getEnableFooterFollowWhenNoMoreData", "setEnableFooterFollowWhenNoMoreData", "enableFooterMoveContent", "getEnableFooterMoveContent", "setEnableFooterMoveContent", "enableHeaderMoveContent", "getEnableHeaderMoveContent", "setEnableHeaderMoveContent", "enableLoadMore", "getEnableLoadMore", "setEnableLoadMore", "enableLoadMoreWhenContentNotFull", "getEnableLoadMoreWhenContentNotFull", "setEnableLoadMoreWhenContentNotFull", "enableNestedScrolling", "getEnableNestedScrolling", "setEnableNestedScrolling", "enableOverScrollBounce", "getEnableOverScrollBounce", "setEnableOverScrollBounce", "enableOverScrollDrag", "getEnableOverScrollDrag", "setEnableOverScrollDrag", "enablePureScrollMode", "getEnablePureScrollMode", "setEnablePureScrollMode", "enableRefresh", "getEnableRefresh", "setEnableRefresh", "enableScrollContentWhenLoaded", "getEnableScrollContentWhenLoaded", "setEnableScrollContentWhenLoaded", "enableScrollContentWhenRefreshed", "getEnableScrollContentWhenRefreshed", "setEnableScrollContentWhenRefreshed", "reboundDuration", "", "getReboundDuration", "()I", "setReboundDuration", "(I)V", "build", "Lcom/tencent/mm/view/refreshLayout/config/CommonConfig;", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public boolean Jcx = true;
    public boolean agJq = true;
    public float agPE = 0.5F;
    public boolean agPF = true;
    public boolean agPG = true;
    public boolean agPH = true;
    public boolean agPI;
    public boolean agPJ;
    public boolean agPK = true;
    public boolean agPL = true;
    public boolean agPM = true;
    public boolean agPN;
    public boolean agPO;
    public boolean agPP = true;
    public boolean agPQ;
    public boolean agPR;
    public int reboundDuration = 300;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.view.refreshLayout.a.a
 * JD-Core Version:    0.7.0.1
 */