package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.os.Looper;
import android.os.Message;
import android.view.ViewStub;
import com.tencent.mm.R.h;
import com.tencent.mm.ah.p;
import com.tencent.mm.az.h;
import com.tencent.mm.cd.f.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.g.a.a.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ac
{
  public List<bi> ilf;
  public com.tencent.mm.sdk.platformtools.ah mHandler = new com.tencent.mm.sdk.platformtools.ah(Looper.getMainLooper())
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      if ((ac.this.ilf == null) || (!au.DK())) {
        return;
      }
      y.d("MicroMsg.EggMgr", "post start egg");
      ac.this.a(ac.this.vmh, ac.this.ilf);
    }
  };
  public ChattingAnimFrame vmg = null;
  public Activity vmh;
  
  private static void ar(int paramInt, boolean paramBoolean)
  {
    for (;;)
    {
      Object localObject2;
      try
      {
        Object localObject1 = new StringBuilder();
        au.Hx();
        localObject1 = com.tencent.mm.vfs.e.c(c.FT() + "eggresult.rep", 0, -1);
        com.tencent.mm.az.g localg;
        if (localObject1 != null)
        {
          y.d("MicroMsg.EggMgr", "data not null, parse it");
          localObject1 = (h)new h().aH((byte[])localObject1);
          localObject2 = ((h)localObject1).ewM.iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label292;
          }
          localg = (com.tencent.mm.az.g)((Iterator)localObject2).next();
          if (localg.ewz != paramInt) {
            continue;
          }
          if (paramBoolean)
          {
            localg.ewK += 1;
            break label297;
            if (i == 0)
            {
              localObject2 = new com.tencent.mm.az.g();
              ((com.tencent.mm.az.g)localObject2).ewz = paramInt;
              if (!paramBoolean) {
                break label283;
              }
              ((com.tencent.mm.az.g)localObject2).ewK = 1;
              ((h)localObject1).ewM.add(localObject2);
            }
            localObject2 = ((h)localObject1).toByteArray();
            y.d("MicroMsg.EggMgr", "report list is %s, then save it", new Object[] { localObject1.toString() });
            localObject1 = new StringBuilder();
            au.Hx();
            com.tencent.mm.vfs.e.b(c.FT() + "eggresult.rep", (byte[])localObject2, localObject2.length);
          }
        }
        else
        {
          y.d("MicroMsg.EggMgr", "data is null, new one");
          localObject1 = new h();
          continue;
        }
        localg.ewL += 1;
      }
      catch (Exception localException)
      {
        y.w("MicroMsg.EggMgr", "statistics crash : %s", new Object[] { localException.getLocalizedMessage() });
        y.printErrStackTrace("MicroMsg.EggMgr", localException, "", new Object[0]);
        return;
      }
      label283:
      ((com.tencent.mm.az.g)localObject2).ewL = 1;
      continue;
      label292:
      int i = 0;
      continue;
      label297:
      i = 1;
    }
  }
  
  private static boolean ar(String paramString1, String paramString2, String paramString3)
  {
    if ((com.tencent.mm.platformtools.ah.bl(paramString1)) || (com.tencent.mm.platformtools.ah.bl(paramString2)) || (ae.getContext() == null)) {}
    String str;
    int i;
    do
    {
      return false;
      str = paramString1.toLowerCase();
      i = str.indexOf(paramString2.toLowerCase());
    } while (i == -1);
    for (;;)
    {
      Object localObject;
      boolean bool1;
      try
      {
        if ((i >= str.length() - 1) || (com.tencent.mm.platformtools.ah.bl(paramString3))) {
          break label408;
        }
        if ((i <= 0) || (str.charAt(i - 1) < 'a') || (str.charAt(i - 1) > 'z')) {
          break label402;
        }
        y.v("MicroMsg.EggMgr", "letter in the prefix");
        localObject = paramString1.substring(0, i);
        int k = ((String)localObject).lastIndexOf('/');
        j = k;
        if (k == -1) {
          break label414;
        }
        localObject = ((String)localObject).subSequence(k, ((String)localObject).length());
        com.tencent.mm.cd.g.csM();
        localObject = com.tencent.mm.cd.f.csI().aau((String)localObject);
        if (localObject == null) {
          break label427;
        }
        localObject = ((f.a)localObject).text;
        j = k;
        if (com.tencent.mm.platformtools.ah.bl((String)localObject)) {
          break label414;
        }
        j = k;
        if (((String)localObject).length() + k != i) {
          break label414;
        }
        y.v("MicroMsg.EggMgr", "letter in the prefix is smiley");
        j = -2;
      }
      catch (Exception paramString1)
      {
        y.v("MicroMsg.EggMgr", "Exception in isKeywordMatch, %s", new Object[] { paramString1.getMessage() });
        y.printErrStackTrace("MicroMsg.EggMgr", paramString1, "", new Object[0]);
        return false;
      }
      boolean bool2 = bool1;
      if (bool1)
      {
        bool2 = bool1;
        if (paramString2.length() + i < str.length())
        {
          bool2 = bool1;
          if (str.charAt(paramString2.length() + i) >= 'a')
          {
            bool2 = bool1;
            if (str.charAt(paramString2.length() + i) <= 'z')
            {
              y.v("MicroMsg.EggMgr", "letter in the suffix");
              bool2 = false;
            }
          }
        }
      }
      label297:
      if (bool2)
      {
        y.v("MicroMsg.EggMgr", "full match, matchPos = %s, TextLength = %s, keyLength = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(str.length()), Integer.valueOf(paramString2.length()) });
        return bool2;
      }
      int j = str.indexOf(paramString2.toLowerCase(), i + 1);
      i = j;
      if (j == -1)
      {
        return false;
        label402:
        label408:
        label414:
        do
        {
          bool1 = true;
          break;
          bool2 = true;
          break label297;
        } while (j == -2);
        bool1 = false;
        continue;
        label427:
        localObject = null;
      }
    }
  }
  
  public final void a(Activity paramActivity, List<bi> paramList)
  {
    if (paramList == null) {
      return;
    }
    Iterator localIterator1 = paramList.iterator();
    while (localIterator1.hasNext())
    {
      bi localbi = (bi)localIterator1.next();
      au.Hx();
      if (com.tencent.mm.platformtools.ah.cn(com.tencent.mm.platformtools.ah.d((Long)c.Dz().get(68108, null))) * 1000L > 21600000L) {
        new com.tencent.mm.sdk.platformtools.ah().postDelayed(new Runnable()
        {
          public final void run()
          {
            if (!au.DK()) {
              return;
            }
            m localm = new m(37);
            au.Dk().a(localm, 0);
            au.Hx();
            c.Dz().o(68108, Long.valueOf(com.tencent.mm.platformtools.ah.UX()));
          }
        }, 10000L);
      }
      paramList = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aHj();
      int i;
      if (paramList == null)
      {
        y.d("MicroMsg.EggMgr", "eggList is null");
        i = 0;
      }
      while (i != 0)
      {
        return;
        int m = (int)bk.UX();
        y.d("MicroMsg.EggMgr", "cursecond is %d, getEggList.size is %d", new Object[] { Integer.valueOf(m), Integer.valueOf(paramList.ewI.size()) });
        Iterator localIterator2 = paramList.ewI.iterator();
        for (;;)
        {
          if (localIterator2.hasNext())
          {
            com.tencent.mm.az.d locald = (com.tencent.mm.az.d)localIterator2.next();
            paramList = locald.ewC;
            int k = 0;
            label218:
            Iterator localIterator3;
            if (com.tencent.mm.platformtools.ah.bl(paramList))
            {
              i = 1;
              if (i == 0) {
                break label321;
              }
              localIterator3 = locald.ewx.iterator();
            }
            String str2;
            for (;;)
            {
              if (!localIterator3.hasNext()) {
                break label450;
              }
              com.tencent.mm.az.e locale = (com.tencent.mm.az.e)localIterator3.next();
              str2 = locale.ewH;
              if (com.tencent.mm.platformtools.ah.bl(str2))
              {
                y.e("MicroMsg.EggMgr", "error egg keyWord");
                continue;
                paramList = paramList.split(",");
                int n = paramList.length;
                int j = 0;
                for (;;)
                {
                  i = k;
                  if (j >= n) {
                    break label218;
                  }
                  if (paramList[j].equals(x.cqJ()))
                  {
                    i = 1;
                    break label218;
                    label321:
                    break;
                  }
                  j += 1;
                }
              }
              else
              {
                String str1 = localbi.field_content;
                paramList = str1;
                if (s.fn(localbi.field_talker))
                {
                  i = bd.iH(str1);
                  paramList = str1;
                  if (i != -1) {
                    paramList = str1.substring(i + 1).trim();
                  }
                }
                if (ar(paramList, str2, locale.lang))
                {
                  if (this.vmg == null)
                  {
                    paramList = (ViewStub)paramActivity.findViewById(R.h.viewstub_chatting_animframe);
                    if (paramList != null) {
                      paramList.inflate();
                    }
                    this.vmg = ((ChattingAnimFrame)paramActivity.findViewById(R.h.chatting_anim_iv));
                  }
                  if (this.vmg != null) {
                    break label452;
                  }
                  y.e("MicroMsg.EggMgr", "AnimFrameView should not be null");
                }
              }
            }
            label450:
            continue;
            label452:
            boolean bool;
            if ((locald.ewA <= m) && (m <= locald.ewB + 86400L))
            {
              this.vmg.a(locald);
              i = locald.ewz;
              if (localbi.field_isSend == 1) {}
              for (bool = true;; bool = false)
              {
                ar(i, bool);
                y.d("MicroMsg.EggMgr", "match keyWord[%s], time[%d - %d]", new Object[] { str2, Integer.valueOf(locald.ewA), Integer.valueOf(locald.ewB) });
                i = 1;
                break;
              }
            }
            if ((locald.ewA == locald.ewB) && (locald.ewA == 0))
            {
              this.vmg.a(locald);
              i = locald.ewz;
              if (localbi.field_isSend == 1) {}
              for (bool = true;; bool = false)
              {
                ar(i, bool);
                y.d("MicroMsg.EggMgr", "match keyWord[%s], time[0 - 0]", new Object[] { str2 });
                i = 1;
                break;
              }
            }
            y.d("MicroMsg.EggMgr", "match keyWord[%s], but not match time[%d - %d]", new Object[] { str2, Integer.valueOf(locald.ewA), Integer.valueOf(locald.ewB) });
            i = 0;
            break;
          }
        }
        y.d("MicroMsg.EggMgr", "no match");
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ac
 * JD-Core Version:    0.7.0.1
 */