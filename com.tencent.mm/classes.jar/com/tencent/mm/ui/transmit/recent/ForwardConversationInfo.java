package com.tencent.mm.ui.transmit.recent;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/transmit/recent/ForwardConversationInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "userName", "", "nickName", "contactAlias", "contactConRemark", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContactAlias", "()Ljava/lang/String;", "getContactConRemark", "getNickName", "getUserName", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ForwardConversationInfo
  implements Parcelable
{
  public static final a CREATOR;
  public final String afPQ;
  public final String afPR;
  public final String nickName;
  public final String userName;
  
  static
  {
    AppMethodBeat.i(250896);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(250896);
  }
  
  public ForwardConversationInfo(Parcel paramParcel)
  {
    this((String)localObject1, (String)localObject2, (String)localObject3, paramParcel);
    AppMethodBeat.i(250888);
    AppMethodBeat.o(250888);
  }
  
  public ForwardConversationInfo(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(250881);
    this.userName = paramString1;
    this.nickName = paramString2;
    this.afPQ = paramString3;
    this.afPR = paramString4;
    AppMethodBeat.o(250881);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(250918);
    if (this == paramObject)
    {
      AppMethodBeat.o(250918);
      return true;
    }
    if (!(paramObject instanceof ForwardConversationInfo))
    {
      AppMethodBeat.o(250918);
      return false;
    }
    paramObject = (ForwardConversationInfo)paramObject;
    if (!s.p(this.userName, paramObject.userName))
    {
      AppMethodBeat.o(250918);
      return false;
    }
    if (!s.p(this.nickName, paramObject.nickName))
    {
      AppMethodBeat.o(250918);
      return false;
    }
    if (!s.p(this.afPQ, paramObject.afPQ))
    {
      AppMethodBeat.o(250918);
      return false;
    }
    if (!s.p(this.afPR, paramObject.afPR))
    {
      AppMethodBeat.o(250918);
      return false;
    }
    AppMethodBeat.o(250918);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(250914);
    if (this.userName == null) {}
    for (int i = 0;; i = this.userName.hashCode())
    {
      int j = this.nickName.hashCode();
      int k = this.afPQ.hashCode();
      int m = this.afPR.hashCode();
      AppMethodBeat.o(250914);
      return ((i * 31 + j) * 31 + k) * 31 + m;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(250910);
    String str = "ForwardConversationInfo(userName=" + this.userName + ", nickName=" + this.nickName + ", contactAlias=" + this.afPQ + ", contactConRemark=" + this.afPR + ')';
    AppMethodBeat.o(250910);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(250902);
    s.u(paramParcel, "parcel");
    paramParcel.writeString(this.userName);
    paramParcel.writeString(this.nickName);
    paramParcel.writeString(this.afPQ);
    paramParcel.writeString(this.afPR);
    AppMethodBeat.o(250902);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/transmit/recent/ForwardConversationInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/ui/transmit/recent/ForwardConversationInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/ui/transmit/recent/ForwardConversationInfo;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<ForwardConversationInfo>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.recent.ForwardConversationInfo
 * JD-Core Version:    0.7.0.1
 */