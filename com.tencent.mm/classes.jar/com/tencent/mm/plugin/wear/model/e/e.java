package com.tencent.mm.plugin.wear.model.e;

import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.pe;
import com.tencent.mm.f.a.tk;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.List;

public final class e
  extends a
{
  public final List<Integer> gON()
  {
    AppMethodBeat.i(30077);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11013));
    localArrayList.add(Integer.valueOf(11014));
    localArrayList.add(Integer.valueOf(11015));
    AppMethodBeat.o(30077);
    return localArrayList;
  }
  
  protected final byte[] t(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30078);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30078);
      return null;
      paramArrayOfByte = new pe();
      EventCenter.instance.publish(paramArrayOfByte);
      continue;
      paramArrayOfByte = ((n)h.ae(n.class)).eSe().eSq();
      if (paramArrayOfByte.size() == 1)
      {
        paramArrayOfByte = ((ca)paramArrayOfByte.get(0)).field_talker;
        Intent localIntent = new Intent();
        localIntent.putExtra("Main_User", paramArrayOfByte);
        localIntent.putExtra("From_fail_notify", true);
        localIntent.addFlags(67108864);
        localIntent.addFlags(536870912);
        if (Build.VERSION.SDK_INT < 16) {
          localIntent.putExtra("resend_fail_messages", true);
        }
        Log.d("MicroMsg.Wear.HttpFailMsgServer", "startChattingUI talker=%s", new Object[] { paramArrayOfByte });
        c.f(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI", localIntent);
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
        Log.d("MicroMsg.Wear.HttpFailMsgServer", "startMainUI");
        c.f(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI", paramArrayOfByte);
        continue;
        paramArrayOfByte = new tk();
        EventCenter.instance.publish(paramArrayOfByte);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.e
 * JD-Core Version:    0.7.0.1
 */