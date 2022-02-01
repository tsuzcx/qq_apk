package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.a.a.a;
import com.tencent.pb.common.b.a.a.a.bb;
import com.tencent.pb.common.b.a.a.a.bc;
import com.tencent.pb.common.c.b;
import com.tencent.pb.common.c.f;

public final class d
{
  private String ENE;
  a.bb Sup;
  private a.bc Suq;
  
  public d(a.bb parambb)
  {
    AppMethodBeat.i(199670);
    a(parambb);
    AppMethodBeat.o(199670);
  }
  
  public d(a.bb parambb, a.bc parambc)
  {
    AppMethodBeat.i(199671);
    a(parambb);
    if (parambc == null)
    {
      b.w("tagorewang:TalkRoomMember", new Object[] { "set null profile" });
      AppMethodBeat.o(199671);
      return;
    }
    this.Suq = parambc;
    AppMethodBeat.o(199671);
  }
  
  public final void a(a.bb parambb)
  {
    AppMethodBeat.i(199672);
    if (parambb == null)
    {
      b.w("tagorewang:TalkRoomMember", new Object[] { "set null info" });
      AppMethodBeat.o(199672);
      return;
    }
    this.Sup = parambb;
    AppMethodBeat.o(199672);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(62597);
    if ((paramObject == null) || (!(paramObject instanceof d)))
    {
      AppMethodBeat.o(62597);
      return false;
    }
    boolean bool = f.equals(hra(), ((d)paramObject).hra());
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
        Object localObject2 = this.ENE;
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
        String str = this.ENE;
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
    if (this.Sup == null) {
      return -1;
    }
    return this.Sup.qrD;
  }
  
  public final int getState()
  {
    if (this.Sup == null) {
      return 0;
    }
    return this.Sup.status;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(62598);
    String str = hra();
    if (str == null)
    {
      AppMethodBeat.o(62598);
      return 0;
    }
    int i = str.hashCode();
    AppMethodBeat.o(62598);
    return i;
  }
  
  public final String hra()
  {
    if (this.Sup != null) {
      return this.Sup.dLN;
    }
    return "";
  }
  
  public final boolean isSelf()
  {
    AppMethodBeat.i(62599);
    boolean bool = f.equals(a.hjq(), hra());
    AppMethodBeat.o(62599);
    return bool;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(62596);
    int i = 0;
    if (this.Sup != null) {
      i = this.Sup.KBb;
    }
    while ((this.Sup == null) || (this.Suq == null))
    {
      localObject = "invlaid TalkRoomMember which uuid is ".concat(String.valueOf(i));
      AppMethodBeat.o(62596);
      return localObject;
      if (this.Suq != null) {
        i = this.Suq.KBb;
      }
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    Object localObject = this.Sup;
    StringBuilder localStringBuilder2;
    if (localObject == null)
    {
      localObject = "null";
      localStringBuilder2 = localStringBuilder1.append((String)localObject).append(" ");
      localObject = this.Suq;
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
      localStringBuilder2.append(" uuid:").append(((a.bb)localObject).KBb);
      localStringBuilder2.append(" openClientId:").append(((a.bb)localObject).RGi);
      localStringBuilder2.append(" invite uuid: ").append(((a.bb)localObject).RGe);
      localStringBuilder2.append(" member id:").append(((a.bb)localObject).qrD);
      localStringBuilder2.append(" status: ").append(((a.bb)localObject).status);
      localStringBuilder2.append(" reason: ").append(((a.bb)localObject).bDZ);
      localObject = localStringBuilder2.toString();
      break;
      localStringBuilder3 = new StringBuilder();
      localStringBuilder3.append("VoiceGroupUsrProfile");
      localStringBuilder3.append(" uuid: ").append(((a.bc)localObject).KBb);
      localStringBuilder3.append(" user name: ").append(((a.bc)localObject).username);
      localStringBuilder3.append(" head url: ").append(((a.bc)localObject).headUrl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.d
 * JD-Core Version:    0.7.0.1
 */