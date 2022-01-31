package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.a.a.a;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.aw;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.g;

public final class d
{
  a.av BAf;
  private a.aw BAg;
  private String rZK;
  
  public d(a.av paramav)
  {
    AppMethodBeat.i(127811);
    a(paramav);
    AppMethodBeat.o(127811);
  }
  
  public d(a.av paramav, a.aw paramaw)
  {
    AppMethodBeat.i(127812);
    a(paramav);
    if (paramaw == null)
    {
      c.w("tagorewang:TalkRoomMember", new Object[] { "set null profile" });
      AppMethodBeat.o(127812);
      return;
    }
    this.BAg = paramaw;
    AppMethodBeat.o(127812);
  }
  
  public final void a(a.av paramav)
  {
    AppMethodBeat.i(127813);
    if (paramav == null)
    {
      c.w("tagorewang:TalkRoomMember", new Object[] { "set null info" });
      AppMethodBeat.o(127813);
      return;
    }
    this.BAf = paramav;
    AppMethodBeat.o(127813);
  }
  
  public final String dXx()
  {
    if (this.BAf != null) {
      return this.BAf.Bfy;
    }
    return "";
  }
  
  public final boolean dXy()
  {
    AppMethodBeat.i(127818);
    boolean bool = g.equals(a.dTX(), dXx());
    AppMethodBeat.o(127818);
    return bool;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(127816);
    if ((paramObject == null) || (!(paramObject instanceof d)))
    {
      AppMethodBeat.o(127816);
      return false;
    }
    boolean bool = g.equals(dXx(), ((d)paramObject).dXx());
    AppMethodBeat.o(127816);
    return bool;
  }
  
  public final String getDisplayName()
  {
    AppMethodBeat.i(127814);
    for (;;)
    {
      int j;
      int i;
      try
      {
        Object localObject2 = this.rZK;
        if ((localObject2 == null) || (((String)localObject2).trim().length() == 0))
        {
          AppMethodBeat.o(127814);
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
            AppMethodBeat.o(127814);
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
          AppMethodBeat.o(127814);
          return localObject1;
        }
      }
      catch (Exception localException)
      {
        c.w("tagorewang:TalkRoomMember", new Object[] { "getDisplayName err: ", localException });
        String str = this.rZK;
        AppMethodBeat.o(127814);
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
    if (this.BAf == null) {
      return -1;
    }
    return this.BAf.kJx;
  }
  
  public final int getState()
  {
    if (this.BAf == null) {
      return 0;
    }
    return this.BAf.status;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(127817);
    String str = dXx();
    if (str == null)
    {
      AppMethodBeat.o(127817);
      return 0;
    }
    int i = str.hashCode();
    AppMethodBeat.o(127817);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(127815);
    int i = 0;
    if (this.BAf != null) {
      i = this.BAf.wjE;
    }
    while ((this.BAf == null) || (this.BAg == null))
    {
      localObject = "invlaid TalkRoomMember which uuid is ".concat(String.valueOf(i));
      AppMethodBeat.o(127815);
      return localObject;
      if (this.BAg != null) {
        i = this.BAg.wjE;
      }
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    Object localObject = this.BAf;
    StringBuilder localStringBuilder2;
    if (localObject == null)
    {
      localObject = "null";
      localStringBuilder2 = localStringBuilder1.append((String)localObject).append(" ");
      localObject = this.BAg;
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
      AppMethodBeat.o(127815);
      return localObject;
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("VoiceGroupMem");
      localStringBuilder2.append(" uuid:").append(((a.av)localObject).wjE);
      localStringBuilder2.append(" openClientId:").append(((a.av)localObject).Bgu);
      localStringBuilder2.append(" invite uuid: ").append(((a.av)localObject).Bgq);
      localStringBuilder2.append(" member id:").append(((a.av)localObject).kJx);
      localStringBuilder2.append(" status: ").append(((a.av)localObject).status);
      localStringBuilder2.append(" reason: ").append(((a.av)localObject).aXG);
      localObject = localStringBuilder2.toString();
      break;
      localStringBuilder3 = new StringBuilder();
      localStringBuilder3.append("VoiceGroupUsrProfile");
      localStringBuilder3.append(" uuid: ").append(((a.aw)localObject).wjE);
      localStringBuilder3.append(" user name: ").append(((a.aw)localObject).username);
      localStringBuilder3.append(" head url: ").append(((a.aw)localObject).pWk);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.d
 * JD-Core Version:    0.7.0.1
 */