package com.tencent.mm.pluginsdk.model.app;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.pluginsdk.permission.a;

public class IPCInstallApp
  implements b<IPCInstallAppParam, IPCBoolean>
{
  public static final class IPCInstallAppParam
    implements Parcelable
  {
    public static final Parcelable.Creator<IPCInstallAppParam> CREATOR;
    private boolean Dir;
    private String filePath;
    private int type;
    private Uri uri;
    
    static
    {
      AppMethodBeat.i(151799);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(151799);
    }
    
    public IPCInstallAppParam(int paramInt, String paramString, Uri paramUri, boolean paramBoolean)
    {
      this.type = paramInt;
      this.filePath = paramString;
      this.uri = paramUri;
      this.Dir = paramBoolean;
    }
    
    protected IPCInstallAppParam(Parcel paramParcel)
    {
      AppMethodBeat.i(151798);
      this.type = paramParcel.readInt();
      this.filePath = paramParcel.readString();
      this.uri = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.Dir = bool;
        AppMethodBeat.o(151798);
        return;
      }
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(151797);
      paramParcel.writeInt(this.type);
      paramParcel.writeString(this.filePath);
      paramParcel.writeParcelable(this.uri, paramInt);
      if (this.Dir) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        AppMethodBeat.o(151797);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.IPCInstallApp
 * JD-Core Version:    0.7.0.1
 */