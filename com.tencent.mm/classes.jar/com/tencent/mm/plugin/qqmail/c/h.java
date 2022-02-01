package com.tencent.mm.plugin.qqmail.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.qqmail.d.ak;
import com.tencent.mm.plugin.qqmail.d.am;
import com.tencent.mm.plugin.qqmail.d.au;
import com.tencent.mm.plugin.qqmail.d.ay;
import com.tencent.mm.plugin.qqmail.e.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class h
  implements i, com.tencent.mm.ipcinvoker.d<IPCString, Bundle>
{
  private String Hls;
  private f<Bundle> jZn;
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(249715);
    Log.i("MicroMsg.ReadMailTask", "read mail, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!((c)paramq).Hls.equals(this.Hls))
    {
      Log.w("MicroMsg.ReadMailTask", "not my scene, ignore");
      AppMethodBeat.o(249715);
      return;
    }
    com.tencent.mm.kernel.h.aGY().b(11312, this);
    if (this.jZn != null)
    {
      Bundle localBundle1 = new Bundle();
      localBundle1.putInt("err_type", paramInt1);
      localBundle1.putInt("err_code", paramInt2);
      localBundle1.putString("err_msg", paramString);
      localBundle1.putString("mail_id", this.Hls);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((au)d.c.b(((c)paramq).lKU.lBS)).HnB;
        if (paramString != null)
        {
          localBundle1.putString("mail_content", paramString.content);
          ArrayList localArrayList;
          Object localObject1;
          Object localObject2;
          if (!paramString.Hnm.isEmpty())
          {
            localArrayList = new ArrayList();
            localObject1 = paramString.Hnm.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (ak)((Iterator)localObject1).next();
              Bundle localBundle2 = new Bundle();
              localBundle2.putString("attach_fileId", ((ak)localObject2).fileid);
              localBundle2.putString("attach_key", ((ak)localObject2).key);
              localBundle2.putString("attach_name", ((ak)localObject2).name);
              localBundle2.putString("attach_type", ((ak)localObject2).type);
              localBundle2.putInt("attach_size", ((ak)localObject2).size);
              localBundle2.putString("attach_download_url", ((ak)localObject2).Hnd);
              localArrayList.add(localBundle2);
            }
            localBundle1.putParcelableArrayList("mail_normal_attach", localArrayList);
          }
          if (!paramString.Hnn.isEmpty())
          {
            localArrayList = new ArrayList();
            paramString = paramString.Hnn.iterator();
            while (paramString.hasNext())
            {
              localObject1 = (ak)paramString.next();
              localObject2 = new Bundle();
              ((Bundle)localObject2).putString("attach_fileId", ((ak)localObject1).fileid);
              ((Bundle)localObject2).putString("attach_key", ((ak)localObject1).key);
              ((Bundle)localObject2).putString("attach_name", ((ak)localObject1).name);
              ((Bundle)localObject2).putString("attach_type", ((ak)localObject1).type);
              ((Bundle)localObject2).putInt("attach_size", ((ak)localObject1).size);
              ((Bundle)localObject2).putString("attach_download_url", ((ak)localObject1).Hnd);
              localArrayList.add(localObject2);
            }
            localBundle1.putParcelableArrayList("mail_big_attach", localArrayList);
          }
        }
        paramString = ((au)d.c.b(((c)paramq).lKU.lBS)).HnC;
        if (paramString != null)
        {
          paramq = new Bundle();
          paramq.putLong("cookie_xmail_uin", paramString.HnF);
          paramq.putString("cookie_xmail_skey", paramString.HnH);
          paramq.putString("cookie_xmail_sid", paramString.HnG);
          localBundle1.putParcelable("mail_cookie", paramq);
        }
      }
      this.jZn.aH(localBundle1);
    }
    AppMethodBeat.o(249715);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.c.h
 * JD-Core Version:    0.7.0.1
 */