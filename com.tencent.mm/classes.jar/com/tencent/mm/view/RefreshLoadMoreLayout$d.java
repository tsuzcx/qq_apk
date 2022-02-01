package com.tencent.mm.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "E", "", "actionType", "", "(I)V", "getActionType", "()I", "extra", "getExtra", "()Ljava/lang/Object;", "setExtra", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "extraData", "getExtraData", "setExtraData", "hasAnyMore", "", "getHasAnyMore", "()Z", "setHasAnyMore", "(Z)V", "isAnim", "setAnim", "isFooterVisible", "setFooterVisible", "isShowLoadMoreWhenRefresh", "setShowLoadMoreWhenRefresh", "isSliceNoShowLoadingRefresh", "setSliceNoShowLoadingRefresh", "reasonType", "getReasonType", "setReasonType", "remainSize", "getRemainSize", "setRemainSize", "wording", "", "getWording", "()Ljava/lang/CharSequence;", "setWording", "(Ljava/lang/CharSequence;)V", "component1", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RefreshLoadMoreLayout$d<E>
{
  private static final int agJA;
  private static final int agJB;
  private static final int agJC = 0;
  private static final int agJD;
  private static final int agJE;
  public static final a agJr;
  private static final int agJz = 0;
  public final int actionType;
  public int agJs;
  public CharSequence agJt;
  public boolean agJu;
  public int agJv;
  public boolean agJw;
  public boolean agJx;
  public boolean agJy;
  public E extra;
  public E extraData;
  public boolean pzq;
  
  static
  {
    AppMethodBeat.i(164573);
    agJr = new a((byte)0);
    agJA = 1;
    agJB = 2;
    agJD = 1;
    agJE = 2;
    AppMethodBeat.o(164573);
  }
  
  public RefreshLoadMoreLayout$d(int paramInt)
  {
    AppMethodBeat.i(164572);
    this.actionType = paramInt;
    this.agJt = ((CharSequence)"");
    this.agJu = true;
    this.pzq = true;
    AppMethodBeat.o(164572);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof d)) {
        return false;
      }
      paramObject = (d)paramObject;
    } while (this.actionType == paramObject.actionType);
    return false;
  }
  
  public final int hashCode()
  {
    return this.actionType;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(164571);
    String str = "(actionType=" + this.actionType + ", reasonType=" + this.agJs + ", extra=" + this.extra + ", hasAnyMore=" + this.agJu + ", isAnim=" + this.pzq + ", remainSize=" + this.agJv + " isFooterVisible=" + this.agJw + ')';
    AppMethodBeat.o(164571);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason$Companion;", "", "()V", "AutoPull", "", "getAutoPull", "()I", "INSERTED", "getINSERTED", "LOADMORE", "getLOADMORE", "Other", "getOther", "REFRESH", "getREFRESH", "TouchPull", "getTouchPull", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.RefreshLoadMoreLayout.d
 * JD-Core Version:    0.7.0.1
 */