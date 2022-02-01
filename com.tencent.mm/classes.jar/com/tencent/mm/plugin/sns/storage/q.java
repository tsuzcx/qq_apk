package com.tencent.mm.plugin.sns.storage;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.hj;
import com.tencent.mm.plugin.sns.cover.a.b;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.vfs.y;
import java.io.IOException;

public final class q
  extends hj
  implements b
{
  protected static IAutoDBItem.MAutoDBInfo info;
  public String QYG = "";
  public String QYH;
  
  static
  {
    AppMethodBeat.i(306562);
    info = hj.aJm();
    AppMethodBeat.o(306562);
  }
  
  public final String bud()
  {
    AppMethodBeat.i(306570);
    if (y.ZC(this.field_localThumb))
    {
      str = this.field_localThumb;
      AppMethodBeat.o(306570);
      return str;
    }
    String str = this.field_thumbUrl;
    AppMethodBeat.o(306570);
    return str;
  }
  
  public final String gUr()
  {
    AppMethodBeat.i(306565);
    if ((this.field_type == 1) || (this.field_type == 6) || (this.field_type == 0))
    {
      if (y.ZC(this.field_localImage))
      {
        str = this.field_localImage;
        AppMethodBeat.o(306565);
        return str;
      }
      if (!TextUtils.isEmpty(this.field_imageBgUrl))
      {
        str = this.field_imageBgUrl;
        AppMethodBeat.o(306565);
        return str;
      }
    }
    String str = bud();
    AppMethodBeat.o(306565);
    return str;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final FinderObject getFinderObject()
  {
    AppMethodBeat.i(306572);
    FinderObject localFinderObject = new FinderObject();
    if (this.field_finderObject != null) {}
    try
    {
      localFinderObject.parseFrom(this.field_finderObject);
      AppMethodBeat.o(306572);
      return localFinderObject;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.SnsCover", localIOException, "FinderObject parseFrom error", new Object[0]);
      }
    }
  }
  
  public final String getUserName()
  {
    return this.field_userName;
  }
  
  public final String getVideoPath()
  {
    AppMethodBeat.i(306569);
    if (y.ZC(this.field_localVideo))
    {
      str = this.field_localVideo;
      AppMethodBeat.o(306569);
      return str;
    }
    String str = this.field_videoBgUrl;
    AppMethodBeat.o(306569);
    return str;
  }
  
  public final Long hen()
  {
    AppMethodBeat.i(306581);
    long l = this.field_finderCheckTime;
    AppMethodBeat.o(306581);
    return Long.valueOf(l);
  }
  
  public final Long heo()
  {
    AppMethodBeat.i(369893);
    long l = this.field_snsBgId;
    AppMethodBeat.o(369893);
    return Long.valueOf(l);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(306590);
    Object localObject = new FinderObject();
    if (this.field_finderObject != null) {}
    try
    {
      ((FinderObject)localObject).parseFrom(this.field_finderObject);
      localObject = "SnsCover{field_userName='" + this.field_userName + '\'' + ", field_type=" + this.field_type + ", field_snsBgId=" + t.uA(this.field_snsBgId) + ", field_thumbUrl='" + this.field_thumbUrl + '\'' + ", field_imageBgUrl='" + this.field_imageBgUrl + '\'' + ", field_videoBgUrl='" + this.field_videoBgUrl + '\'' + ", field_localThumb='" + this.field_localThumb + '\'' + ", field_localImage='" + this.field_localImage + '\'' + ", field_localVideo='" + this.field_localVideo + '\'' + ", field_finderObject=" + t.uA(((FinderObject)localObject).id) + ", field_finderCheckTime=" + this.field_finderCheckTime + ", field_success=" + this.field_success + ", systemRowid=" + this.systemRowid + ", reportExtraInfo=" + this.QYG + '}';
      AppMethodBeat.o(306590);
      return localObject;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.SnsCover", localIOException, "FinderObject parseFrom error", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.q
 * JD-Core Version:    0.7.0.1
 */