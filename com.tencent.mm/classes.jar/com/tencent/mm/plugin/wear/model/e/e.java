package com.tencent.mm.plugin.wear.model.e;

import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.ky;
import com.tencent.mm.h.a.nz;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.List;

public final class e
  extends a
{
  public final List<Integer> bYY()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11013));
    localArrayList.add(Integer.valueOf(11014));
    localArrayList.add(Integer.valueOf(11015));
    return localArrayList;
  }
  
  protected final byte[] p(int paramInt, byte[] paramArrayOfByte)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return null;
      paramArrayOfByte = new ky();
      com.tencent.mm.sdk.b.a.udP.m(paramArrayOfByte);
      continue;
      paramArrayOfByte = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().bhZ();
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
        y.d("MicroMsg.Wear.HttpFailMsgServer", "startChattingUI talker=%s", new Object[] { paramArrayOfByte });
        d.e(ae.getContext(), "com.tencent.mm.ui.LauncherUI", localIntent);
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
        y.d("MicroMsg.Wear.HttpFailMsgServer", "startMainUI");
        d.e(ae.getContext(), "com.tencent.mm.ui.LauncherUI", paramArrayOfByte);
        continue;
        paramArrayOfByte = new nz();
        com.tencent.mm.sdk.b.a.udP.m(paramArrayOfByte);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.e
 * JD-Core Version:    0.7.0.1
 */