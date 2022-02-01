package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.a.a.a;
import com.tencent.pb.common.b.a.a.a.ba;
import com.tencent.pb.common.b.a.a.a.bb;
import com.tencent.pb.common.c.b;
import com.tencent.pb.common.c.f;

public final class d
{
  private String RBD;
  a.ba ahZK;
  private a.bb ahZL;
  
  public d(a.ba paramba)
  {
    AppMethodBeat.i(212279);
    a(paramba);
    AppMethodBeat.o(212279);
  }
  
  public d(a.ba paramba, a.bb parambb)
  {
    AppMethodBeat.i(212280);
    a(paramba);
    if (parambb == null)
    {
      b.w("tagorewang:TalkRoomMember", new Object[] { "set null profile" });
      AppMethodBeat.o(212280);
      return;
    }
    this.ahZL = parambb;
    AppMethodBeat.o(212280);
  }
  
  public final void a(a.ba paramba)
  {
    AppMethodBeat.i(212282);
    if (paramba == null)
    {
      b.w("tagorewang:TalkRoomMember", new Object[] { "set null info" });
      AppMethodBeat.o(212282);
      return;
    }
    this.ahZK = paramba;
    AppMethodBeat.o(212282);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(62597);
    if ((paramObject == null) || (!(paramObject instanceof d)))
    {
      AppMethodBeat.o(62597);
      return false;
    }
    boolean bool = f.qA(kef(), ((d)paramObject).kef());
    AppMethodBeat.o(62597);
    return bool;
  }
  
  public final String getDisplayName()
  {
    AppMethodBeat.i(62595);
    for (;;)
    {
      int j;
      int i;
      try
      {
        Object localObject2 = this.RBD;
        if ((localObject2 == null) || (((String)localObject2).trim().length() == 0))
        {
          AppMethodBeat.o(62595);
          return localObject2;
        }
        Object localObject1 = ((String)localObject2).trim().toCharArray();
        j = 0;
        i = 0;
        if (j < localObject1.length)
        {
          if (localObject1[j] < '¡') {
            break label200;
          }
          i += 2;
        }
        else
        {
          if (i <= 10)
          {
            AppMethodBeat.o(62595);
            return localObject2;
          }
          localObject2 = new StringBuilder();
          i = 0;
          j = 0;
          if (j < localObject1.length)
          {
            if (localObject1[j] < '¡') {
              break label207;
            }
            i += 2;
            if (i + 1 <= 10)
            {
              ((StringBuilder)localObject2).append(localObject1[j]);
              j += 1;
              continue;
            }
          }
          ((StringBuilder)localObject2).append('…');
          localObject1 = ((StringBuilder)localObject2).toString();
          AppMethodBeat.o(62595);
          return localObject1;
        }
      }
      catch (Exception localException)
      {
        b.w("tagorewang:TalkRoomMember", new Object[] { "getDisplayName err: ", localException });
        String str = this.RBD;
        AppMethodBeat.o(62595);
        return str;
      }
      for (;;)
      {
        j += 1;
        break;
        label200:
        i += 1;
      }
      label207:
      i += 1;
    }
  }
  
  public final int getMemberId()
  {
    if (this.ahZK == null) {
      return -1;
    }
    return this.ahZK.wTC;
  }
  
  public final int getState()
  {
    if (this.ahZK == null) {
      return 0;
    }
    return this.ahZK.status;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(62598);
    String str = kef();
    if (str == null)
    {
      AppMethodBeat.o(62598);
      return 0;
    }
    int i = str.hashCode();
    AppMethodBeat.o(62598);
    return i;
  }
  
  public final boolean isSelf()
  {
    AppMethodBeat.i(62599);
    boolean bool = f.qA(a.jRr(), kef());
    AppMethodBeat.o(62599);
    return bool;
  }
  
  public final String kef()
  {
    if (this.ahZK != null) {
      return this.ahZK.hJs;
    }
    return "";
  }
  
  public final String toString()
  {
    AppMethodBeat.i(62596);
    int i = 0;
    if (this.ahZK != null) {
      i = this.ahZK.Yzt;
    }
    while ((this.ahZK == null) || (this.ahZL == null))
    {
      localObject = "invlaid TalkRoomMember which uuid is ".concat(String.valueOf(i));
      AppMethodBeat.o(62596);
      return localObject;
      if (this.ahZL != null) {
        i = this.ahZL.Yzt;
      }
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    Object localObject = this.ahZK;
    StringBuilder localStringBuilder2;
    if (localObject == null)
    {
      localObject = "null";
      localStringBuilder2 = localStringBuilder1.append((String)localObject).append(" ");
      localObject = this.ahZL;
      if (localObject != null) {
        break label250;
      }
    }
    label250:
    StringBuilder localStringBuilder3;
    for (localObject = "null";; localObject = localStringBuilder3.toString())
    {
      localStringBuilder2.append((String)localObject);
      localObject = localStringBuilder1.toString();
      AppMethodBeat.o(62596);
      return localObject;
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("VoiceGroupMem");
      localStringBuilder2.append(" uuid:").append(((a.ba)localObject).Yzt);
      localStringBuilder2.append(" openClientId:").append(((a.ba)localObject).ahgp);
      localStringBuilder2.append(" invite uuid: ").append(((a.ba)localObject).ahgl);
      localStringBuilder2.append(" member id:").append(((a.ba)localObject).wTC);
      localStringBuilder2.append(" status: ").append(((a.ba)localObject).status);
      localStringBuilder2.append(" reason: ").append(((a.ba)localObject).reason);
      localObject = localStringBuilder2.toString();
      break;
      localStringBuilder3 = new StringBuilder();
      localStringBuilder3.append("VoiceGroupUsrProfile");
      localStringBuilder3.append(" uuid: ").append(((a.bb)localObject).Yzt);
      localStringBuilder3.append(" user name: ").append(((a.bb)localObject).username);
      localStringBuilder3.append(" head url: ").append(((a.bb)localObject).headUrl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.d
 * JD-Core Version:    0.7.0.1
 */