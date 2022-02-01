package com.tencent.mm.plugin.record.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.gr;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class j
  extends gr
  implements c
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(140937);
    info = aJm();
    AppMethodBeat.o(140937);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof j)) {}
    while (this.field_localId != ((j)paramObject).field_localId) {
      return false;
    }
    return true;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final int getKey()
  {
    return this.field_localId;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(140936);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("localid[").append(this.field_localId).append("]\n");
    ((StringBuilder)localObject).append("recordId[").append(this.field_recordLocalId).append("]\n");
    ((StringBuilder)localObject).append("mediaId[").append(this.field_mediaId).append("]\n");
    ((StringBuilder)localObject).append("dataId[").append(this.field_dataId).append("]\n");
    ((StringBuilder)localObject).append("path[").append(this.field_path).append("]\n");
    ((StringBuilder)localObject).append("cdnurl[").append(this.field_cdnUrl).append("]\n");
    ((StringBuilder)localObject).append("cdnkey[").append(this.field_cdnKey).append("]\n");
    ((StringBuilder)localObject).append("type[").append(this.field_type).append("]\n");
    ((StringBuilder)localObject).append("errCode[").append(this.field_errCode).append("]\n");
    ((StringBuilder)localObject).append("fileType[").append(this.field_fileType).append("]\n");
    ((StringBuilder)localObject).append("isThumb[").append(this.field_isThumb).append("]\n");
    ((StringBuilder)localObject).append("status[").append(this.field_status).append("]\n");
    ((StringBuilder)localObject).append("totalLen[").append(this.field_totalLen).append("]\n");
    ((StringBuilder)localObject).append("offset[").append(this.field_offset).append("]\n");
    ((StringBuilder)localObject).append("toUser[").append(this.field_toUser).append("]\n");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(140936);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.a.j
 * JD-Core Version:    0.7.0.1
 */