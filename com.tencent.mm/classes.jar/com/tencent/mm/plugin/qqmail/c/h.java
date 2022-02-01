package com.tencent.mm.plugin.qqmail.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.qqmail.model.aj;
import com.tencent.mm.plugin.qqmail.model.al;
import com.tencent.mm.plugin.qqmail.model.at;
import com.tencent.mm.plugin.qqmail.model.ax;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class h
  implements com.tencent.mm.am.h, d<IPCString, Bundle>
{
  private String Njg;
  private f<Bundle> mzo;
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(266877);
    Log.i("MicroMsg.ReadMailTask", "read mail, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!((com.tencent.mm.plugin.qqmail.d.c)paramp).Njg.equals(this.Njg))
    {
      Log.w("MicroMsg.ReadMailTask", "not my scene, ignore");
      AppMethodBeat.o(266877);
      return;
    }
    com.tencent.mm.kernel.h.aZW().b(11312, this);
    if (this.mzo != null)
    {
      Bundle localBundle1 = new Bundle();
      localBundle1.putInt("err_type", paramInt1);
      localBundle1.putInt("err_code", paramInt2);
      localBundle1.putString("err_msg", paramString);
      localBundle1.putString("mail_id", this.Njg);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((at)c.c.b(((com.tencent.mm.plugin.qqmail.d.c)paramp).oDw.otC)).Nlp;
        if (paramString != null)
        {
          localBundle1.putString("mail_content", paramString.content);
          ArrayList localArrayList;
          Object localObject1;
          Object localObject2;
          if (!paramString.Nla.isEmpty())
          {
            localArrayList = new ArrayList();
            localObject1 = paramString.Nla.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (aj)((Iterator)localObject1).next();
              Bundle localBundle2 = new Bundle();
              localBundle2.putString("attach_fileId", ((aj)localObject2).fileid);
              localBundle2.putString("attach_key", ((aj)localObject2).key);
              localBundle2.putString("attach_name", ((aj)localObject2).name);
              localBundle2.putString("attach_type", ((aj)localObject2).type);
              localBundle2.putInt("attach_size", ((aj)localObject2).size);
              localBundle2.putString("attach_download_url", ((aj)localObject2).NkR);
              localArrayList.add(localBundle2);
            }
            localBundle1.putParcelableArrayList("mail_normal_attach", localArrayList);
          }
          if (!paramString.Nlb.isEmpty())
          {
            localArrayList = new ArrayList();
            paramString = paramString.Nlb.iterator();
            while (paramString.hasNext())
            {
              localObject1 = (aj)paramString.next();
              localObject2 = new Bundle();
              ((Bundle)localObject2).putString("attach_fileId", ((aj)localObject1).fileid);
              ((Bundle)localObject2).putString("attach_key", ((aj)localObject1).key);
              ((Bundle)localObject2).putString("attach_name", ((aj)localObject1).name);
              ((Bundle)localObject2).putString("attach_type", ((aj)localObject1).type);
              ((Bundle)localObject2).putInt("attach_size", ((aj)localObject1).size);
              ((Bundle)localObject2).putString("attach_download_url", ((aj)localObject1).NkR);
              localArrayList.add(localObject2);
            }
            localBundle1.putParcelableArrayList("mail_big_attach", localArrayList);
          }
        }
        paramString = ((at)c.c.b(((com.tencent.mm.plugin.qqmail.d.c)paramp).oDw.otC)).Nlq;
        if (paramString != null)
        {
          paramp = new Bundle();
          paramp.putLong("cookie_xmail_uin", paramString.Nlt);
          paramp.putString("cookie_xmail_skey", paramString.Nlv);
          paramp.putString("cookie_xmail_sid", paramString.Nlu);
          localBundle1.putParcelable("mail_cookie", paramp);
        }
      }
      this.mzo.onCallback(localBundle1);
    }
    AppMethodBeat.o(266877);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.c.h
 * JD-Core Version:    0.7.0.1
 */