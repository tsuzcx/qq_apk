package com.tencent.mm.plugin.wear.model.e;

import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.lm;
import com.tencent.mm.g.a.pa;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.List;

public final class e
  extends a
{
  public final List<Integer> cYL()
  {
    AppMethodBeat.i(26395);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11013));
    localArrayList.add(Integer.valueOf(11014));
    localArrayList.add(Integer.valueOf(11015));
    AppMethodBeat.o(26395);
    return localArrayList;
  }
  
  protected final byte[] q(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26396);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26396);
      return null;
      paramArrayOfByte = new lm();
      com.tencent.mm.sdk.b.a.ymk.l(paramArrayOfByte);
      continue;
      paramArrayOfByte = ((j)g.E(j.class)).bPQ().bQb();
      if (paramArrayOfByte.size() == 1)
      {
        paramArrayOfByte = ((bi)paramArrayOfByte.get(0)).field_talker;
        Intent localIntent = new Intent();
        localIntent.putExtra("Main_User", paramArrayOfByte);
        localIntent.putExtra("From_fail_notify", true);
        localIntent.addFlags(67108864);
        localIntent.addFlags(536870912);
        if (Build.VERSION.SDK_INT < 16) {
          localIntent.putExtra("resend_fail_messages", true);
        }
        ab.d("MicroMsg.Wear.HttpFailMsgServer", "startChattingUI talker=%s", new Object[] { paramArrayOfByte });
        d.f(ah.getContext(), "com.tencent.mm.ui.LauncherUI", localIntent);
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
        ab.d("MicroMsg.Wear.HttpFailMsgServer", "startMainUI");
        d.f(ah.getContext(), "com.tencent.mm.ui.LauncherUI", paramArrayOfByte);
        continue;
        paramArrayOfByte = new pa();
        com.tencent.mm.sdk.b.a.ymk.l(paramArrayOfByte);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.e
 * JD-Core Version:    0.7.0.1
 */