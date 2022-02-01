package com.tencent.mm.plugin.ringtone.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.a.e;
import com.tencent.mm.view.recyclerview.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/data/ExclusiveConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "exclusiveRingtoneData", "Lcom/tencent/mm/protocal/protobuf/ringtone/GetAllFriendRingBackInfo;", "(Lcom/tencent/mm/protocal/protobuf/ringtone/GetAllFriendRingBackInfo;)V", "getExclusiveRingtoneData", "()Lcom/tencent/mm/protocal/protobuf/ringtone/GetAllFriendRingBackInfo;", "isPlay", "", "()Z", "setPlay", "(Z)V", "unAvailable", "getUnAvailable", "setUnAvailable", "getItemId", "", "getItemType", "", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements a
{
  boolean OBU;
  public final e OBY;
  public boolean hJg;
  
  public c(e parame)
  {
    AppMethodBeat.i(272994);
    this.OBY = parame;
    AppMethodBeat.o(272994);
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(273004);
    String str = this.OBY.UserName;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      long l = i;
      AppMethodBeat.o(273004);
      return l;
    }
  }
  
  public final int bZB()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.b.c
 * JD-Core Version:    0.7.0.1
 */