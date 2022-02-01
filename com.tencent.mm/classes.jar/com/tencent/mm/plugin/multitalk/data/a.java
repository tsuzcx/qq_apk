package com.tencent.mm.plugin.multitalk.data;

import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/data/MultitalkAvatarViewData;", "", "member", "Lcom/tencent/pb/talkroom/sdk/MultiTalkGroupMember;", "listener", "Landroid/view/View$OnClickListener;", "index", "", "isRenderVideo", "", "nickName", "", "(Lcom/tencent/pb/talkroom/sdk/MultiTalkGroupMember;Landroid/view/View$OnClickListener;IZLjava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "plugin-multitalk_release"})
public final class a
{
  public int index;
  public String nickName;
  public MultiTalkGroupMember zHg;
  public View.OnClickListener zHh;
  public boolean zHi;
  
  public a(MultiTalkGroupMember paramMultiTalkGroupMember, View.OnClickListener paramOnClickListener, int paramInt, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(239554);
    this.zHg = paramMultiTalkGroupMember;
    this.zHh = paramOnClickListener;
    this.index = paramInt;
    this.zHi = paramBoolean;
    this.nickName = paramString;
    AppMethodBeat.o(239554);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(178953);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!p.j(this.zHg, paramObject.zHg)) || (!p.j(this.zHh, paramObject.zHh)) || (this.index != paramObject.index) || (this.zHi != paramObject.zHi) || (!p.j(this.nickName, paramObject.nickName))) {}
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
    String str = "MultitalkAvatarViewData(member=" + this.zHg + ", listener=" + this.zHh + ", index=" + this.index + ", isRenderVideo=" + this.zHi + ", nickName=" + this.nickName + ")";
    AppMethodBeat.o(178951);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.data.a
 * JD-Core Version:    0.7.0.1
 */