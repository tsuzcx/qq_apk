package com.tencent.mm.plugin.ringtone.b;

import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.a.aa;
import com.tencent.mm.protocal.protobuf.a.b;
import com.tencent.mm.protocal.protobuf.a.c;
import com.tencent.mm.protocal.protobuf.a.u;
import com.tencent.mm.protocal.protobuf.a.v;
import com.tencent.mm.view.recyclerview.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/data/RingtoneConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "ringtoneInfo", "Lcom/tencent/mm/protocal/protobuf/ringtone/RingBackDetail;", "(Lcom/tencent/mm/protocal/protobuf/ringtone/RingBackDetail;)V", "isPlay", "", "()Z", "setPlay", "(Z)V", "onRingtoneSelect", "Landroid/view/View$OnClickListener;", "getOnRingtoneSelect", "()Landroid/view/View$OnClickListener;", "setOnRingtoneSelect", "(Landroid/view/View$OnClickListener;)V", "getRingtoneInfo", "()Lcom/tencent/mm/protocal/protobuf/ringtone/RingBackDetail;", "getItemId", "", "getItemType", "", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements a
{
  public final aa OCa;
  public View.OnClickListener OCb;
  public boolean hJg;
  
  public e(aa paramaa)
  {
    AppMethodBeat.i(273006);
    this.OCa = paramaa;
    AppMethodBeat.o(273006);
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(273012);
    switch (this.OCa.vhJ)
    {
    default: 
    case 2: 
    case 1: 
      Object localObject;
      do
      {
        do
        {
          do
          {
            do
            {
              AppMethodBeat.o(273012);
              return 0L;
              localObject = this.OCa.acjs;
            } while (localObject == null);
            localObject = ((c)localObject).aciR;
          } while (localObject == null);
          l = ((b)localObject).aacf;
          AppMethodBeat.o(273012);
          return l;
          localObject = this.OCa.acjr;
        } while (localObject == null);
        localObject = ((v)localObject).acjj;
      } while (localObject == null);
      l = ((u)localObject).aaYO;
      AppMethodBeat.o(273012);
      return l;
    }
    long l = z.bAL();
    AppMethodBeat.o(273012);
    return l;
  }
  
  public final int bZB()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.b.e
 * JD-Core Version:    0.7.0.1
 */