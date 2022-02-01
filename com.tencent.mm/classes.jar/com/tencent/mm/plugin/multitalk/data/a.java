package com.tencent.mm.plugin.multitalk.data;

import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/data/MultitalkAvatarViewData;", "", "member", "Lcom/tencent/pb/talkroom/sdk/MultiTalkGroupMember;", "listener", "Landroid/view/View$OnClickListener;", "index", "", "isRenderVideo", "", "nickName", "", "(Lcom/tencent/pb/talkroom/sdk/MultiTalkGroupMember;Landroid/view/View$OnClickListener;IZLjava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public MultiTalkGroupMember Liv;
  public boolean Liw;
  public int index;
  public String nickName;
  public View.OnClickListener tyA;
  
  public a(MultiTalkGroupMember paramMultiTalkGroupMember, View.OnClickListener paramOnClickListener, int paramInt, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(284589);
    this.Liv = paramMultiTalkGroupMember;
    this.tyA = paramOnClickListener;
    this.index = paramInt;
    this.Liw = paramBoolean;
    this.nickName = paramString;
    AppMethodBeat.o(284589);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(178953);
    if (this == paramObject)
    {
      AppMethodBeat.o(178953);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(178953);
      return false;
    }
    paramObject = (a)paramObject;
    if (!s.p(this.Liv, paramObject.Liv))
    {
      AppMethodBeat.o(178953);
      return false;
    }
    if (!s.p(this.tyA, paramObject.tyA))
    {
      AppMethodBeat.o(178953);
      return false;
    }
    if (this.index != paramObject.index)
    {
      AppMethodBeat.o(178953);
      return false;
    }
    if (this.Liw != paramObject.Liw)
    {
      AppMethodBeat.o(178953);
      return false;
    }
    if (!s.p(this.nickName, paramObject.nickName))
    {
      AppMethodBeat.o(178953);
      return false;
    }
    AppMethodBeat.o(178953);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(178951);
    String str = "MultitalkAvatarViewData(member=" + this.Liv + ", listener=" + this.tyA + ", index=" + this.index + ", isRenderVideo=" + this.Liw + ", nickName=" + this.nickName + ')';
    AppMethodBeat.o(178951);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.data.a
 * JD-Core Version:    0.7.0.1
 */