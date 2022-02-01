package com.tencent.mm.plugin.webview.ui.tools.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.message.y;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoDataParcelable;", "Landroid/os/Parcelable;", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "appendText", "", "getAppendText$plugin_webview_release", "()Ljava/lang/String;", "setAppendText$plugin_webview_release", "(Ljava/lang/String;)V", "msgInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "getMsgInfo$plugin_webview_release", "()Lcom/tencent/mm/message/MPShareVideoInfo;", "setMsgInfo$plugin_webview_release", "(Lcom/tencent/mm/message/MPShareVideoInfo;)V", "msgInfoLength", "", "getMsgInfoLength$plugin_webview_release", "()I", "setMsgInfoLength$plugin_webview_release", "(I)V", "sessionId", "getSessionId$plugin_webview_release", "setSessionId$plugin_webview_release", "toUser", "getToUser$plugin_webview_release", "setToUser$plugin_webview_release", "describeContents", "readParcel", "", "writeToParcel", "dest", "flags", "CREATOR", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MpVideoDataParcelable
  implements Parcelable
{
  public static final a CREATOR;
  private int Xmm;
  y Xmn;
  private String sessionId;
  String suZ;
  String toUser;
  
  static
  {
    AppMethodBeat.i(82670);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(82670);
  }
  
  public MpVideoDataParcelable() {}
  
  public MpVideoDataParcelable(Parcel paramParcel)
  {
    AppMethodBeat.i(82669);
    s.u(paramParcel, "parcel");
    this.toUser = paramParcel.readString();
    this.suZ = paramParcel.readString();
    this.Xmm = paramParcel.readInt();
    if (this.Xmm > 0)
    {
      Object localObject = new byte[this.Xmm];
      paramParcel.readByteArray((byte[])localObject);
      y localy = new y();
      localy.parseFrom((byte[])localObject);
      localObject = ah.aiuX;
      this.Xmn = localy;
    }
    this.sessionId = paramParcel.readString();
    AppMethodBeat.o(82669);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(82668);
    s.u(paramParcel, "dest");
    paramParcel.writeString(this.toUser);
    paramParcel.writeString(this.suZ);
    Object localObject = this.Xmn;
    if (localObject == null)
    {
      localObject = null;
      if (localObject == null) {
        break label121;
      }
      if (localObject.length != 0) {
        break label111;
      }
      paramInt = 1;
      label56:
      if (paramInt != 0) {
        break label116;
      }
      paramInt = i;
      label62:
      if (paramInt == 0) {
        break label121;
      }
      this.Xmm = localObject.length;
      paramParcel.writeInt(this.Xmm);
      paramParcel.writeByteArray((byte[])localObject);
    }
    for (;;)
    {
      paramParcel.writeString(this.sessionId);
      AppMethodBeat.o(82668);
      return;
      localObject = ((y)localObject).toByteArray();
      break;
      label111:
      paramInt = 0;
      break label56;
      label116:
      paramInt = 0;
      break label62;
      label121:
      paramParcel.writeInt(this.Xmm);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoDataParcelable$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoDataParcelable;", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoDataParcelable;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<MpVideoDataParcelable>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.MpVideoDataParcelable
 * JD-Core Version:    0.7.0.1
 */