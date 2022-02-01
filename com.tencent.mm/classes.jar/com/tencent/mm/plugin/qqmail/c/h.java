package com.tencent.mm.plugin.qqmail.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.kernel.g;
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
  implements i, b<IPCString, Bundle>
{
  private String BqZ;
  private com.tencent.mm.ipcinvoker.d<Bundle> hny;
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(198586);
    Log.i("MicroMsg.ReadMailTask", "read mail, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!((c)paramq).BqZ.equals(this.BqZ))
    {
      Log.w("MicroMsg.ReadMailTask", "not my scene, ignore");
      AppMethodBeat.o(198586);
      return;
    }
    g.azz().b(11312, this);
    if (this.hny != null)
    {
      Bundle localBundle1 = new Bundle();
      localBundle1.putInt("err_type", paramInt1);
      localBundle1.putInt("err_code", paramInt2);
      localBundle1.putString("err_msg", paramString);
      localBundle1.putString("mail_id", this.BqZ);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((au)((c)paramq).iUB.iLL.iLR).Bth;
        if (paramString != null)
        {
          localBundle1.putString("mail_content", paramString.content);
          ArrayList localArrayList;
          Object localObject1;
          Object localObject2;
          if (!paramString.BsS.isEmpty())
          {
            localArrayList = new ArrayList();
            localObject1 = paramString.BsS.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (ak)((Iterator)localObject1).next();
              Bundle localBundle2 = new Bundle();
              localBundle2.putString("attach_fileId", ((ak)localObject2).fileid);
              localBundle2.putString("attach_key", ((ak)localObject2).key);
              localBundle2.putString("attach_name", ((ak)localObject2).name);
              localBundle2.putString("attach_type", ((ak)localObject2).type);
              localBundle2.putInt("attach_size", ((ak)localObject2).size);
              localBundle2.putString("attach_download_url", ((ak)localObject2).BsJ);
              localArrayList.add(localBundle2);
            }
            localBundle1.putParcelableArrayList("mail_normal_attach", localArrayList);
          }
          if (!paramString.BsT.isEmpty())
          {
            localArrayList = new ArrayList();
            paramString = paramString.BsT.iterator();
            while (paramString.hasNext())
            {
              localObject1 = (ak)paramString.next();
              localObject2 = new Bundle();
              ((Bundle)localObject2).putString("attach_fileId", ((ak)localObject1).fileid);
              ((Bundle)localObject2).putString("attach_key", ((ak)localObject1).key);
              ((Bundle)localObject2).putString("attach_name", ((ak)localObject1).name);
              ((Bundle)localObject2).putString("attach_type", ((ak)localObject1).type);
              ((Bundle)localObject2).putInt("attach_size", ((ak)localObject1).size);
              ((Bundle)localObject2).putString("attach_download_url", ((ak)localObject1).BsJ);
              localArrayList.add(localObject2);
            }
            localBundle1.putParcelableArrayList("mail_big_attach", localArrayList);
          }
        }
        paramString = ((au)((c)paramq).iUB.iLL.iLR).Bti;
        if (paramString != null)
        {
          paramq = new Bundle();
          paramq.putLong("cookie_xmail_uin", paramString.Btl);
          paramq.putString("cookie_xmail_skey", paramString.Btn);
          paramq.putString("cookie_xmail_sid", paramString.Btm);
          localBundle1.putParcelable("mail_cookie", paramq);
        }
      }
      this.hny.bn(localBundle1);
    }
    AppMethodBeat.o(198586);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.c.h
 * JD-Core Version:    0.7.0.1
 */