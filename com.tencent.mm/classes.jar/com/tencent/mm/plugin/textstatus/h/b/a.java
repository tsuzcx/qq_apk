package com.tencent.mm.plugin.textstatus.h.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/data/TextStatusNotifyShowInfo;", "", "latestNewMsgInfo", "Lcom/tencent/mm/plugin/textstatus/model/data/TextStatusNotifyShowInfo$NewMsgInfo;", "notifyUnreadCount", "", "notifyUnreadCountUser", "", "(Lcom/tencent/mm/plugin/textstatus/model/data/TextStatusNotifyShowInfo$NewMsgInfo;ILjava/lang/String;)V", "getLatestNewMsgInfo", "()Lcom/tencent/mm/plugin/textstatus/model/data/TextStatusNotifyShowInfo$NewMsgInfo;", "setLatestNewMsgInfo", "(Lcom/tencent/mm/plugin/textstatus/model/data/TextStatusNotifyShowInfo$NewMsgInfo;)V", "getNotifyUnreadCount", "()I", "setNotifyUnreadCount", "(I)V", "getNotifyUnreadCountUser", "()Ljava/lang/String;", "setNotifyUnreadCountUser", "(Ljava/lang/String;)V", "showTipType", "getShowTipType", "component1", "component2", "component3", "copy", "equals", "", "other", "getAvatarUsr", "hashCode", "toString", "Companion", "NewMsgInfo", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a Tnm;
  public a.b Tnn = null;
  public int Tno = 0;
  public String Tnp;
  
  static
  {
    AppMethodBeat.i(290578);
    Tnm = new a((byte)0);
    AppMethodBeat.o(290578);
  }
  
  private a(String paramString)
  {
    this.Tnp = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(290616);
    if (this == paramObject)
    {
      AppMethodBeat.o(290616);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(290616);
      return false;
    }
    paramObject = (a)paramObject;
    if (!s.p(this.Tnn, paramObject.Tnn))
    {
      AppMethodBeat.o(290616);
      return false;
    }
    if (this.Tno != paramObject.Tno)
    {
      AppMethodBeat.o(290616);
      return false;
    }
    if (!s.p(this.Tnp, paramObject.Tnp))
    {
      AppMethodBeat.o(290616);
      return false;
    }
    AppMethodBeat.o(290616);
    return true;
  }
  
  public final String hHB()
  {
    Object localObject;
    if (this.Tno > 0) {
      localObject = this.Tnp;
    }
    String str;
    do
    {
      return localObject;
      if (this.Tnn == null) {
        break;
      }
      localObject = this.Tnn;
      if (localObject == null) {
        break;
      }
      str = ((a.b)localObject).sessionId;
      localObject = str;
    } while (str != null);
    return "";
  }
  
  public final int hHC()
  {
    if (this.Tno > 0) {
      return 1;
    }
    if (this.Tnn != null) {
      return 2;
    }
    return 0;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(290607);
    int i;
    int k;
    if (this.Tnn == null)
    {
      i = 0;
      k = this.Tno;
      if (this.Tnp != null) {
        break label56;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(290607);
      return (i * 31 + k) * 31 + j;
      i = this.Tnn.hashCode();
      break;
      label56:
      j = this.Tnp.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(290598);
    String str = "TextStatusNotifyShowInfo(latestNewMsgInfo=" + this.Tnn + ", notifyUnreadCount=" + this.Tno + ", notifyUnreadCountUser=" + this.Tnp + ')';
    AppMethodBeat.o(290598);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/data/TextStatusNotifyShowInfo$Companion;", "", "()V", "SHOW_TYPE_CNT", "", "SHOW_TYPE_MSG", "SHOW_TYPE_NONE", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.b.a
 * JD-Core Version:    0.7.0.1
 */