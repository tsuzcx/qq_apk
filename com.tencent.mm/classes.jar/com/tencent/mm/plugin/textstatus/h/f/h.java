package com.tencent.mm.plugin.textstatus.h.f;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.j.g;
import com.tencent.mm.plugin.textstatus.proto.TextStatusExtInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusStrangerContact;", "Lcom/tencent/mm/plugin/textstatus/storage/BaseTextStatusStrangerContact;", "()V", "extInfoCache", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;", "extInfoCacheHashCode", "", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getExtInfo", "toWxContact", "Lcom/tencent/mm/storage/Contact;", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends g
{
  private static final IAutoDBItem.MAutoDBInfo JmM;
  public static final h.a TnR;
  private TextStatusExtInfo TnS;
  private int TnT;
  
  static
  {
    AppMethodBeat.i(290720);
    TnR = new h.a((byte)0);
    JmM = g.aJm();
    AppMethodBeat.o(290720);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(290731);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = JmM;
    s.s(localMAutoDBInfo, "_dbInfo");
    AppMethodBeat.o(290731);
    return localMAutoDBInfo;
  }
  
  public final TextStatusExtInfo hHR()
  {
    AppMethodBeat.i(290746);
    int i = this.TnT;
    Object localObject1 = this.field_textStatusExtInfo;
    if ((localObject1 != null) && (i == ((String)localObject1).hashCode())) {}
    for (i = 1; i != 0; i = 0)
    {
      localObject1 = this.TnS;
      AppMethodBeat.o(290746);
      return localObject1;
    }
    localObject1 = this.field_textStatusExtInfo;
    Object localObject2 = (CharSequence)localObject1;
    if ((localObject2 == null) || (n.bp((CharSequence)localObject2))) {}
    for (i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(290746);
      return null;
    }
    localObject2 = new TextStatusExtInfo();
    try
    {
      ((TextStatusExtInfo)localObject2).parseFrom(Base64.decode((String)localObject1, 0));
      this.TnS = ((TextStatusExtInfo)localObject2);
      localObject1 = this.TnS;
      AppMethodBeat.o(290746);
      return localObject1;
    }
    finally
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.TextStatus.TextStatusStrangerContact", localThrowable, "getStatus err", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.f.h
 * JD-Core Version:    0.7.0.1
 */