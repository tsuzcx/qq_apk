package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.dw;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/storage/emotion/GetEmotionStoreRecListCacheInfo;", "Lcom/tencent/mm/autogen/table/BaseGetEmotionStoreRecListCache;", "reqType", "", "cache", "", "(Ljava/lang/String;[B)V", "cu", "Landroid/database/Cursor;", "(Landroid/database/Cursor;)V", "()V", "GetEmotionListCache", "", "getCache", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
  extends dw
{
  public static final a admI;
  private static final IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(248979);
    admI = new a((byte)0);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = dw.aJm();
    s.s(localMAutoDBInfo, "initAutoDBInfo(GetEmotio…istCacheInfo::class.java)");
    info = localMAutoDBInfo;
    AppMethodBeat.o(248979);
  }
  
  public t() {}
  
  public t(Cursor paramCursor)
  {
    this();
    AppMethodBeat.i(248972);
    if (paramCursor == null)
    {
      AppMethodBeat.o(248972);
      return;
    }
    convertFrom(paramCursor);
    AppMethodBeat.o(248972);
  }
  
  public t(String paramString, byte[] paramArrayOfByte)
  {
    this();
    AppMethodBeat.i(248965);
    this.field_reqType = paramString;
    this.field_cache = paramArrayOfByte;
    AppMethodBeat.o(248965);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/storage/emotion/GetEmotionStoreRecListCacheInfo$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getEmotionStoreRecListCacheTableName", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.t
 * JD-Core Version:    0.7.0.1
 */