package com.tencent.wecall.talkroom.model;

import com.tencent.pb.a.a.a;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.aw;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.g;

public final class d
{
  private String phd;
  a.av xdx;
  private a.aw xdy;
  
  public d(a.av paramav)
  {
    a(paramav);
  }
  
  public d(a.av paramav, a.aw paramaw)
  {
    a(paramav);
    if (paramaw == null)
    {
      c.x("tagorewang:TalkRoomMember", new Object[] { "set null profile" });
      return;
    }
    this.xdy = paramaw;
  }
  
  public final void a(a.av paramav)
  {
    if (paramav == null)
    {
      c.x("tagorewang:TalkRoomMember", new Object[] { "set null info" });
      return;
    }
    this.xdx = paramav;
  }
  
  public final String cRE()
  {
    if (this.xdx != null) {
      return this.xdx.wHY;
    }
    return "";
  }
  
  public final int cRF()
  {
    if (this.xdx == null) {
      return -1;
    }
    return this.xdx.iEo;
  }
  
  public final boolean cRG()
  {
    return g.equals(a.cOl(), cRE());
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof d))) {
      return false;
    }
    return g.equals(cRE(), ((d)paramObject).cRE());
  }
  
  public final String getDisplayName()
  {
    try
    {
      localObject2 = this.phd;
      if ((localObject2 == null) || (((String)localObject2).trim().length() == 0)) {
        break label157;
      }
      localObject1 = ((String)localObject2).trim().toCharArray();
      j = 0;
      i = 0;
      if (j >= localObject1.length) {
        break label174;
      }
      if (localObject1[j] < '¡') {
        break label167;
      }
      i += 2;
    }
    catch (Exception localException)
    {
      Object localObject1;
      label60:
      label73:
      c.x("tagorewang:TalkRoomMember", new Object[] { "getDisplayName err: ", localException });
      return this.phd;
    }
    Object localObject2 = new StringBuilder();
    int i = 0;
    int j = 0;
    if (j < localObject1.length)
    {
      if (localObject1[j] < '¡') {
        break label183;
      }
      i += 2;
    }
    for (;;)
    {
      if (i + 1 <= 10)
      {
        ((StringBuilder)localObject2).append(localObject1[j]);
        j += 1;
        break label73;
      }
      ((StringBuilder)localObject2).append('…');
      localObject1 = ((StringBuilder)localObject2).toString();
      return localObject1;
      label157:
      return localObject2;
      for (;;)
      {
        j += 1;
        break;
        label167:
        i += 1;
      }
      label174:
      if (i > 10) {
        break label60;
      }
      return localObject2;
      label183:
      i += 1;
    }
  }
  
  public final int getState()
  {
    if (this.xdx == null) {
      return 0;
    }
    return this.xdx.status;
  }
  
  public final int hashCode()
  {
    String str = cRE();
    if (str == null) {
      return 0;
    }
    return str.hashCode();
  }
  
  public final String toString()
  {
    int i = 0;
    if (this.xdx != null) {
      i = this.xdx.sqW;
    }
    while ((this.xdx == null) || (this.xdy == null))
    {
      return "invlaid TalkRoomMember which uuid is " + i;
      if (this.xdy != null) {
        i = this.xdy.sqW;
      }
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    Object localObject = this.xdx;
    StringBuilder localStringBuilder2;
    if (localObject == null)
    {
      localObject = "null";
      localStringBuilder2 = localStringBuilder1.append((String)localObject).append(" ");
      localObject = this.xdy;
      if (localObject != null) {
        break label238;
      }
    }
    label238:
    StringBuilder localStringBuilder3;
    for (localObject = "null";; localObject = localStringBuilder3.toString())
    {
      localStringBuilder2.append((String)localObject);
      return localStringBuilder1.toString();
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("VoiceGroupMem");
      localStringBuilder2.append(" uuid:").append(((a.av)localObject).sqW);
      localStringBuilder2.append(" openClientId:").append(((a.av)localObject).wIU);
      localStringBuilder2.append(" invite uuid: ").append(((a.av)localObject).wIQ);
      localStringBuilder2.append(" member id:").append(((a.av)localObject).iEo);
      localStringBuilder2.append(" status: ").append(((a.av)localObject).status);
      localStringBuilder2.append(" reason: ").append(((a.av)localObject).aQw);
      localObject = localStringBuilder2.toString();
      break;
      localStringBuilder3 = new StringBuilder();
      localStringBuilder3.append("VoiceGroupUsrProfile");
      localStringBuilder3.append(" uuid: ").append(((a.aw)localObject).sqW);
      localStringBuilder3.append(" user name: ").append(((a.aw)localObject).username);
      localStringBuilder3.append(" head url: ").append(((a.aw)localObject).nqW);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.d
 * JD-Core Version:    0.7.0.1
 */