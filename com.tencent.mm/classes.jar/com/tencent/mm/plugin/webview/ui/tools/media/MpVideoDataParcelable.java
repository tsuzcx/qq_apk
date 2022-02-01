package com.tencent.mm.plugin.webview.ui.tools.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.y;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoDataParcelable;", "Landroid/os/Parcelable;", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "appendText", "", "getAppendText$plugin_webview_release", "()Ljava/lang/String;", "setAppendText$plugin_webview_release", "(Ljava/lang/String;)V", "msgInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "getMsgInfo$plugin_webview_release", "()Lcom/tencent/mm/message/MPShareVideoInfo;", "setMsgInfo$plugin_webview_release", "(Lcom/tencent/mm/message/MPShareVideoInfo;)V", "msgInfoLength", "", "getMsgInfoLength$plugin_webview_release", "()I", "setMsgInfoLength$plugin_webview_release", "(I)V", "sessionId", "getSessionId$plugin_webview_release", "setSessionId$plugin_webview_release", "toUser", "getToUser$plugin_webview_release", "setToUser$plugin_webview_release", "describeContents", "readParcel", "", "writeToParcel", "dest", "flags", "CREATOR", "plugin-webview_release"})
public final class MpVideoDataParcelable
  implements Parcelable
{
  public static final a CREATOR;
  y EoU;
  String liv;
  private int oqe;
  private String sessionId;
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
    p.h(paramParcel, "parcel");
    this.toUser = paramParcel.readString();
    this.liv = paramParcel.readString();
    this.oqe = paramParcel.readInt();
    if (this.oqe > 0)
    {
      byte[] arrayOfByte = new byte[this.oqe];
      paramParcel.readByteArray(arrayOfByte);
      y localy = new y();
      localy.parseFrom(arrayOfByte);
      this.EoU = localy;
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
    p.h(paramParcel, "dest");
    paramParcel.writeString(this.toUser);
    paramParcel.writeString(this.liv);
    Object localObject = this.EoU;
    if (localObject != null)
    {
      localObject = ((y)localObject).toByteArray();
      if (localObject == null) {
        break label121;
      }
      if (localObject.length != 0) {
        break label111;
      }
      paramInt = 1;
      label60:
      if (paramInt != 0) {
        break label116;
      }
      paramInt = i;
      label66:
      if (paramInt == 0) {
        break label121;
      }
      this.oqe = localObject.length;
      paramParcel.writeInt(this.oqe);
      paramParcel.writeByteArray((byte[])localObject);
    }
    for (;;)
    {
      paramParcel.writeString(this.sessionId);
      AppMethodBeat.o(82668);
      return;
      localObject = null;
      break;
      label111:
      paramInt = 0;
      break label60;
      label116:
      paramInt = 0;
      break label66;
      label121:
      paramParcel.writeInt(this.oqe);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoDataParcelable$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoDataParcelable;", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoDataParcelable;", "plugin-webview_release"})
  public static final class a
    implements Parcelable.Creator<MpVideoDataParcelable>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.MpVideoDataParcelable
 * JD-Core Version:    0.7.0.1
 */