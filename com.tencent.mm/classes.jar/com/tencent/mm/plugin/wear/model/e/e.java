package com.tencent.mm.plugin.wear.model.e;

import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.no;
import com.tencent.mm.g.a.rm;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.bu;
import java.util.ArrayList;
import java.util.List;

public final class e
  extends a
{
  public final List<Integer> eKN()
  {
    AppMethodBeat.i(30077);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11013));
    localArrayList.add(Integer.valueOf(11014));
    localArrayList.add(Integer.valueOf(11015));
    AppMethodBeat.o(30077);
    return localArrayList;
  }
  
  protected final byte[] s(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30078);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30078);
      return null;
      paramArrayOfByte = new no();
      com.tencent.mm.sdk.b.a.IbL.l(paramArrayOfByte);
      continue;
      paramArrayOfByte = ((l)g.ab(l.class)).dlK().dlW();
      if (paramArrayOfByte.size() == 1)
      {
        paramArrayOfByte = ((bu)paramArrayOfByte.get(0)).field_talker;
        Intent localIntent = new Intent();
        localIntent.putExtra("Main_User", paramArrayOfByte);
        localIntent.putExtra("From_fail_notify", true);
        localIntent.addFlags(67108864);
        localIntent.addFlags(536870912);
        if (Build.VERSION.SDK_INT < 16) {
          localIntent.putExtra("resend_fail_messages", true);
        }
        ad.d("MicroMsg.Wear.HttpFailMsgServer", "startChattingUI talker=%s", new Object[] { paramArrayOfByte });
        d.f(aj.getContext(), "com.tencent.mm.ui.LauncherUI", localIntent);
      }
      else
      {
        paramArrayOfByte = new Intent();
        paramArrayOfByte.addFlags(67108864);
        paramArrayOfByte.addFlags(536870912);
        if (Build.VERSION.SDK_INT < 16) {
          paramArrayOfByte.putExtra("resend_fail_messages", true);
        }
        paramArrayOfByte.putExtra("From_fail_notify", true);
        ad.d("MicroMsg.Wear.HttpFailMsgServer", "startMainUI");
        d.f(aj.getContext(), "com.tencent.mm.ui.LauncherUI", paramArrayOfByte);
        continue;
        paramArrayOfByte = new rm();
        com.tencent.mm.sdk.b.a.IbL.l(paramArrayOfByte);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.e
 * JD-Core Version:    0.7.0.1
 */