package com.tencent.mm.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "E", "", "actionType", "", "(I)V", "getActionType", "()I", "extra", "getExtra", "()Ljava/lang/Object;", "setExtra", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "extraData", "getExtraData", "setExtraData", "hasAnyMore", "", "getHasAnyMore", "()Z", "setHasAnyMore", "(Z)V", "isAnim", "setAnim", "isFooterVisible", "setFooterVisible", "reasonType", "getReasonType", "setReasonType", "remainSize", "getRemainSize", "setRemainSize", "wording", "", "getWording", "()Ljava/lang/CharSequence;", "setWording", "(Ljava/lang/CharSequence;)V", "component1", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "libmmui_release"})
public final class RefreshLoadMoreLayout$c<E>
{
  private static final int YNI = 0;
  private static final int YNJ = 1;
  private static final int YNK = 2;
  private static final int YNL = 0;
  private static final int YNM = 1;
  private static final int YNN = 2;
  public static final a YNO;
  public int YND;
  public CharSequence YNE;
  public boolean YNF;
  public int YNG;
  public boolean YNH;
  public final int actionType;
  public E lCh;
  public boolean mCI;
  public E xJA;
  
  static
  {
    AppMethodBeat.i(164573);
    YNO = new a((byte)0);
    YNJ = 1;
    YNK = 2;
    YNM = 1;
    YNN = 2;
    AppMethodBeat.o(164573);
  }
  
  public RefreshLoadMoreLayout$c(int paramInt)
  {
    AppMethodBeat.i(164572);
    this.actionType = paramInt;
    this.YNE = ((CharSequence)"");
    this.YNF = true;
    this.mCI = true;
    AppMethodBeat.o(164572);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if (this.actionType != paramObject.actionType) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    return this.actionType;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(164571);
    String str = "(actionType=" + this.actionType + ", reasonType=" + this.YND + ", extra=" + this.lCh + ", hasAnyMore=" + this.YNF + ", isAnim=" + this.mCI + ", remainSize=" + this.YNG + " isFooterVisible=" + this.YNH + ')';
    AppMethodBeat.o(164571);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason$Companion;", "", "()V", "AutoPull", "", "getAutoPull", "()I", "INSERTED", "getINSERTED", "LOADMORE", "getLOADMORE", "Other", "getOther", "REFRESH", "getREFRESH", "TouchPull", "getTouchPull", "libmmui_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.RefreshLoadMoreLayout.c
 * JD-Core Version:    0.7.0.1
 */