package com.tencent.mm.pluginsdk.res.downloader.checkresupdate;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/res/downloader/checkresupdate/CheckResUpdateIPCUtils;", "", "()V", "TAG", "", "getCachedFilePath", "resType", "", "subType", "QueryArgs", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CheckResUpdateIPCUtils
{
  public static final CheckResUpdateIPCUtils XVD;
  
  static
  {
    AppMethodBeat.i(245030);
    XVD = new CheckResUpdateIPCUtils();
    AppMethodBeat.o(245030);
  }
  
  private static final IPCString a(QueryArgs paramQueryArgs)
  {
    AppMethodBeat.i(245025);
    int i = paramQueryArgs.hCh;
    int j = paramQueryArgs.subType;
    b.iJf();
    paramQueryArgs = new IPCString(b.nK(i, j));
    AppMethodBeat.o(245025);
    return paramQueryArgs;
  }
  
  public static final String iJm()
  {
    AppMethodBeat.i(245021);
    Object localObject;
    if (MMApplicationContext.isMainProcess())
    {
      b.iJf();
      localObject = b.nK(89, 1);
      AppMethodBeat.o(245021);
      return localObject;
    }
    try
    {
      localObject = (IPCString)a.a(new QueryArgs(89, 1), CheckResUpdateIPCUtils..ExternalSyntheticLambda0.INSTANCE);
      if (localObject != null)
      {
        localObject = ((IPCString)localObject).value;
        AppMethodBeat.o(245021);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.CheckResUpdateIPCUtils", "getCachedFilePath(89," + 1 + "), get exception:" + localException);
      AppMethodBeat.o(245021);
    }
    return null;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/res/downloader/checkresupdate/CheckResUpdateIPCUtils$QueryArgs;", "Landroid/os/Parcelable;", "resType", "", "subType", "(II)V", "getResType", "()I", "getSubType", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class QueryArgs
    implements Parcelable
  {
    public static final Parcelable.Creator<QueryArgs> CREATOR;
    final int hCh;
    final int subType;
    
    static
    {
      AppMethodBeat.i(245022);
      CREATOR = (Parcelable.Creator)new a();
      AppMethodBeat.o(245022);
    }
    
    public QueryArgs(int paramInt1, int paramInt2)
    {
      this.hCh = paramInt1;
      this.subType = paramInt2;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof QueryArgs)) {
          return false;
        }
        paramObject = (QueryArgs)paramObject;
        if (this.hCh != paramObject.hCh) {
          return false;
        }
      } while (this.subType == paramObject.subType);
      return false;
    }
    
    public final int hashCode()
    {
      return this.hCh * 31 + this.subType;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(245028);
      String str = "QueryArgs(resType=" + this.hCh + ", subType=" + this.subType + ')';
      AppMethodBeat.o(245028);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(245036);
      s.u(paramParcel, "out");
      paramParcel.writeInt(this.hCh);
      paramParcel.writeInt(this.subType);
      AppMethodBeat.o(245036);
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Parcelable.Creator<CheckResUpdateIPCUtils.QueryArgs>
    {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.res.downloader.checkresupdate.CheckResUpdateIPCUtils
 * JD-Core Version:    0.7.0.1
 */