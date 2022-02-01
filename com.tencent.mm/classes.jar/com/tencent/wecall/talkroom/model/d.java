package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.a.a.a;
import com.tencent.pb.common.b.a.a.a.ay;
import com.tencent.pb.common.b.a.a.a.az;
import com.tencent.pb.common.c.b;
import com.tencent.pb.common.c.f;

public final class d
{
  private String AmP;
  a.ay Mlx;
  private a.az Mly;
  
  public d(a.ay paramay)
  {
    AppMethodBeat.i(213652);
    a(paramay);
    AppMethodBeat.o(213652);
  }
  
  public d(a.ay paramay, a.az paramaz)
  {
    AppMethodBeat.i(213653);
    a(paramay);
    if (paramaz == null)
    {
      b.w("tagorewang:TalkRoomMember", new Object[] { "set null profile" });
      AppMethodBeat.o(213653);
      return;
    }
    this.Mly = paramaz;
    AppMethodBeat.o(213653);
  }
  
  public final void a(a.ay paramay)
  {
    AppMethodBeat.i(213654);
    if (paramay == null)
    {
      b.w("tagorewang:TalkRoomMember", new Object[] { "set null info" });
      AppMethodBeat.o(213654);
      return;
    }
    this.Mlx = paramay;
    AppMethodBeat.o(213654);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(62597);
    if ((paramObject == null) || (!(paramObject instanceof d)))
    {
      AppMethodBeat.o(62597);
      return false;
    }
    boolean bool = f.equals(fZx(), ((d)paramObject).fZx());
    AppMethodBeat.o(62597);
    return bool;
  }
  
  public final String fZx()
  {
    if (this.Mlx != null) {
      return this.Mlx.dtx;
    }
    return "";
  }
  
  public final boolean fZy()
  {
    AppMethodBeat.i(62599);
    boolean bool = f.equals(a.fTk(), fZx());
    AppMethodBeat.o(62599);
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
        Object localObject2 = this.AmP;
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
        String str = this.AmP;
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
    if (this.Mlx == null) {
      return -1;
    }
    return this.Mlx.oWb;
  }
  
  public final int getState()
  {
    if (this.Mlx == null) {
      return 0;
    }
    return this.Mlx.status;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(62598);
    String str = fZx();
    if (str == null)
    {
      AppMethodBeat.o(62598);
      return 0;
    }
    int i = str.hashCode();
    AppMethodBeat.o(62598);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(62596);
    int i = 0;
    if (this.Mlx != null) {
      i = this.Mlx.Fpp;
    }
    while ((this.Mlx == null) || (this.Mly == null))
    {
      localObject = "invlaid TalkRoomMember which uuid is ".concat(String.valueOf(i));
      AppMethodBeat.o(62596);
      return localObject;
      if (this.Mly != null) {
        i = this.Mly.Fpp;
      }
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    Object localObject = this.Mlx;
    StringBuilder localStringBuilder2;
    if (localObject == null)
    {
      localObject = "null";
      localStringBuilder2 = localStringBuilder1.append((String)localObject).append(" ");
      localObject = this.Mly;
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
      localStringBuilder2.append(" uuid:").append(((a.ay)localObject).Fpp);
      localStringBuilder2.append(" openClientId:").append(((a.ay)localObject).LIM);
      localStringBuilder2.append(" invite uuid: ").append(((a.ay)localObject).LII);
      localStringBuilder2.append(" member id:").append(((a.ay)localObject).oWb);
      localStringBuilder2.append(" status: ").append(((a.ay)localObject).status);
      localStringBuilder2.append(" reason: ").append(((a.ay)localObject).reason);
      localObject = localStringBuilder2.toString();
      break;
      localStringBuilder3 = new StringBuilder();
      localStringBuilder3.append("VoiceGroupUsrProfile");
      localStringBuilder3.append(" uuid: ").append(((a.az)localObject).Fpp);
      localStringBuilder3.append(" user name: ").append(((a.az)localObject).username);
      localStringBuilder3.append(" head url: ").append(((a.az)localObject).headUrl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.d
 * JD-Core Version:    0.7.0.1
 */