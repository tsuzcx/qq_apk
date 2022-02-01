package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.a.a.a;
import com.tencent.pb.common.b.a.a.a.ay;
import com.tencent.pb.common.b.a.a.a.az;
import com.tencent.pb.common.c.b;
import com.tencent.pb.common.c.f;

public final class d
{
  private String AEd;
  a.ay MIu;
  private a.az MIv;
  
  public d(a.ay paramay)
  {
    AppMethodBeat.i(208327);
    a(paramay);
    AppMethodBeat.o(208327);
  }
  
  public d(a.ay paramay, a.az paramaz)
  {
    AppMethodBeat.i(208328);
    a(paramay);
    if (paramaz == null)
    {
      b.w("tagorewang:TalkRoomMember", new Object[] { "set null profile" });
      AppMethodBeat.o(208328);
      return;
    }
    this.MIv = paramaz;
    AppMethodBeat.o(208328);
  }
  
  public final void a(a.ay paramay)
  {
    AppMethodBeat.i(208329);
    if (paramay == null)
    {
      b.w("tagorewang:TalkRoomMember", new Object[] { "set null info" });
      AppMethodBeat.o(208329);
      return;
    }
    this.MIu = paramay;
    AppMethodBeat.o(208329);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(62597);
    if ((paramObject == null) || (!(paramObject instanceof d)))
    {
      AppMethodBeat.o(62597);
      return false;
    }
    boolean bool = f.equals(gdY(), ((d)paramObject).gdY());
    AppMethodBeat.o(62597);
    return bool;
  }
  
  public final String gdY()
  {
    if (this.MIu != null) {
      return this.MIu.duC;
    }
    return "";
  }
  
  public final boolean gdZ()
  {
    AppMethodBeat.i(62599);
    boolean bool = f.equals(a.fXK(), gdY());
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
        Object localObject2 = this.AEd;
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
        String str = this.AEd;
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
    if (this.MIu == null) {
      return -1;
    }
    return this.MIu.pcE;
  }
  
  public final int getState()
  {
    if (this.MIu == null) {
      return 0;
    }
    return this.MIu.status;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(62598);
    String str = gdY();
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
    if (this.MIu != null) {
      i = this.MIu.FHN;
    }
    while ((this.MIu == null) || (this.MIv == null))
    {
      localObject = "invlaid TalkRoomMember which uuid is ".concat(String.valueOf(i));
      AppMethodBeat.o(62596);
      return localObject;
      if (this.MIv != null) {
        i = this.MIv.FHN;
      }
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    Object localObject = this.MIu;
    StringBuilder localStringBuilder2;
    if (localObject == null)
    {
      localObject = "null";
      localStringBuilder2 = localStringBuilder1.append((String)localObject).append(" ");
      localObject = this.MIv;
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
      localStringBuilder2.append(" uuid:").append(((a.ay)localObject).FHN);
      localStringBuilder2.append(" openClientId:").append(((a.ay)localObject).MfQ);
      localStringBuilder2.append(" invite uuid: ").append(((a.ay)localObject).MfM);
      localStringBuilder2.append(" member id:").append(((a.ay)localObject).pcE);
      localStringBuilder2.append(" status: ").append(((a.ay)localObject).status);
      localStringBuilder2.append(" reason: ").append(((a.ay)localObject).reason);
      localObject = localStringBuilder2.toString();
      break;
      localStringBuilder3 = new StringBuilder();
      localStringBuilder3.append("VoiceGroupUsrProfile");
      localStringBuilder3.append(" uuid: ").append(((a.az)localObject).FHN);
      localStringBuilder3.append(" user name: ").append(((a.az)localObject).username);
      localStringBuilder3.append(" head url: ").append(((a.az)localObject).headUrl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.d
 * JD-Core Version:    0.7.0.1
 */