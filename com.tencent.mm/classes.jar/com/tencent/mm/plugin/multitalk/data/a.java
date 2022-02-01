package com.tencent.mm.plugin.multitalk.data;

import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/multitalk/data/MultitalkAvatarViewData;", "", "member", "Lcom/tencent/pb/talkroom/sdk/MultiTalkGroupMember;", "listener", "Landroid/view/View$OnClickListener;", "index", "", "isRenderVideo", "", "(Lcom/tencent/pb/talkroom/sdk/MultiTalkGroupMember;Landroid/view/View$OnClickListener;IZ)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "plugin-multitalk_release"})
public final class a
{
  public int index;
  public MultiTalkGroupMember tOo;
  public View.OnClickListener tOp;
  public boolean tOq;
  
  public a(MultiTalkGroupMember paramMultiTalkGroupMember, View.OnClickListener paramOnClickListener, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(178950);
    this.tOo = paramMultiTalkGroupMember;
    this.tOp = paramOnClickListener;
    this.index = paramInt;
    this.tOq = paramBoolean;
    AppMethodBeat.o(178950);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(178953);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!k.g(this.tOo, paramObject.tOo)) || (!k.g(this.tOp, paramObject.tOp)) || (this.index != paramObject.index) || (this.tOq != paramObject.tOq)) {}
      }
    }
    else
    {
      AppMethodBeat.o(178953);
      return true;
    }
    AppMethodBeat.o(178953);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(178951);
    String str = "MultitalkAvatarViewData(member=" + this.tOo + ", listener=" + this.tOp + ", index=" + this.index + ", isRenderVideo=" + this.tOq + ")";
    AppMethodBeat.o(178951);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.data.a
 * JD-Core Version:    0.7.0.1
 */