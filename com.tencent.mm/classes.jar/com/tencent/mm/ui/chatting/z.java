package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.os.Looper;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.h;
import com.tencent.mm.cd.f.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class z
{
  public List<bi> kmd;
  public ak mHandler;
  public ChattingAnimFrame zBE;
  public Activity zBF;
  
  public z()
  {
    AppMethodBeat.i(30918);
    this.zBE = null;
    this.mHandler = new z.1(this, Looper.getMainLooper());
    AppMethodBeat.o(30918);
  }
  
  private boolean a(Activity paramActivity, bi parambi)
  {
    AppMethodBeat.i(30920);
    Object localObject = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().bkW();
    if (localObject == null)
    {
      ab.d("MicroMsg.EggMgr", "eggList is null");
      AppMethodBeat.o(30920);
      return false;
    }
    int i = (int)bo.aox();
    ab.d("MicroMsg.EggMgr", "cursecond is %d, getEggList.size is %d", new Object[] { Integer.valueOf(i), Integer.valueOf(((com.tencent.mm.ba.f)localObject).fMy.size()) });
    Iterator localIterator1 = ((com.tencent.mm.ba.f)localObject).fMy.iterator();
    while (localIterator1.hasNext())
    {
      com.tencent.mm.ba.d locald = (com.tencent.mm.ba.d)localIterator1.next();
      if (atN(locald.fMr))
      {
        Iterator localIterator2 = locald.fMn.iterator();
        String str2;
        while (localIterator2.hasNext())
        {
          com.tencent.mm.ba.e locale = (com.tencent.mm.ba.e)localIterator2.next();
          str2 = locale.fMx;
          if (com.tencent.mm.platformtools.ah.isNullOrNil(str2))
          {
            ab.e("MicroMsg.EggMgr", "error egg keyWord");
          }
          else
          {
            String str1 = parambi.field_content;
            localObject = str1;
            if (t.lA(parambi.field_talker)) {
              localObject = bf.pr(str1);
            }
            if (aI((String)localObject, str2, locale.lang))
            {
              if (this.zBE == null)
              {
                localObject = (ViewStub)paramActivity.findViewById(2131822444);
                if (localObject != null) {
                  ((ViewStub)localObject).inflate();
                }
                this.zBE = ((ChattingAnimFrame)paramActivity.findViewById(2131822795));
              }
              if (this.zBE != null) {
                break label284;
              }
              ab.e("MicroMsg.EggMgr", "AnimFrameView should not be null");
            }
          }
        }
        continue;
        label284:
        boolean bool;
        if ((locald.fMp <= i) && (i <= locald.fMq + 86400L))
        {
          this.zBE.a(locald);
          i = locald.cFd;
          if (parambi.field_isSend == 1) {}
          for (bool = true;; bool = false)
          {
            aH(i, bool);
            ab.d("MicroMsg.EggMgr", "match keyWord[%s], time[%d - %d]", new Object[] { str2, Integer.valueOf(locald.fMp), Integer.valueOf(locald.fMq) });
            AppMethodBeat.o(30920);
            return true;
          }
        }
        if ((locald.fMp == locald.fMq) && (locald.fMp == 0))
        {
          this.zBE.a(locald);
          i = locald.cFd;
          if (parambi.field_isSend == 1) {}
          for (bool = true;; bool = false)
          {
            aH(i, bool);
            ab.d("MicroMsg.EggMgr", "match keyWord[%s], time[0 - 0]", new Object[] { str2 });
            AppMethodBeat.o(30920);
            return true;
          }
        }
        ab.d("MicroMsg.EggMgr", "match keyWord[%s], but not match time[%d - %d]", new Object[] { str2, Integer.valueOf(locald.fMp), Integer.valueOf(locald.fMq) });
        AppMethodBeat.o(30920);
        return false;
      }
    }
    ab.d("MicroMsg.EggMgr", "no match");
    AppMethodBeat.o(30920);
    return false;
  }
  
  private static void aH(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(30924);
    for (;;)
    {
      Object localObject2;
      try
      {
        Object localObject1 = new StringBuilder();
        aw.aaz();
        localObject1 = com.tencent.mm.vfs.e.i(c.Rp() + "eggresult.rep", 0, -1);
        com.tencent.mm.ba.g localg;
        if (localObject1 != null)
        {
          ab.d("MicroMsg.EggMgr", "data not null, parse it");
          localObject1 = (h)new h().parseFrom((byte[])localObject1);
          localObject2 = ((h)localObject1).fMC.iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label314;
          }
          localg = (com.tencent.mm.ba.g)((Iterator)localObject2).next();
          if (localg.cFd != paramInt) {
            continue;
          }
          if (paramBoolean)
          {
            localg.fMA += 1;
            break label319;
            if (i == 0)
            {
              localObject2 = new com.tencent.mm.ba.g();
              ((com.tencent.mm.ba.g)localObject2).cFd = paramInt;
              if (!paramBoolean) {
                break label305;
              }
              ((com.tencent.mm.ba.g)localObject2).fMA = 1;
              ((h)localObject1).fMC.add(localObject2);
            }
            localObject2 = ((h)localObject1).toByteArray();
            ab.d("MicroMsg.EggMgr", "report list is %s, then save it", new Object[] { localObject1.toString() });
            localObject1 = new StringBuilder();
            aw.aaz();
            com.tencent.mm.vfs.e.b(c.Rp() + "eggresult.rep", (byte[])localObject2, localObject2.length);
            AppMethodBeat.o(30924);
          }
        }
        else
        {
          ab.d("MicroMsg.EggMgr", "data is null, new one");
          localObject1 = new h();
          continue;
        }
        localg.fMB += 1;
      }
      catch (Exception localException)
      {
        ab.w("MicroMsg.EggMgr", "statistics crash : %s", new Object[] { localException.getLocalizedMessage() });
        ab.printErrStackTrace("MicroMsg.EggMgr", localException, "", new Object[0]);
        AppMethodBeat.o(30924);
        return;
      }
      label305:
      ((com.tencent.mm.ba.g)localObject2).fMB = 1;
      continue;
      label314:
      int i = 0;
      continue;
      label319:
      i = 1;
    }
  }
  
  private static boolean aI(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(30922);
    if ((com.tencent.mm.platformtools.ah.isNullOrNil(paramString1)) || (com.tencent.mm.platformtools.ah.isNullOrNil(paramString2)) || (com.tencent.mm.sdk.platformtools.ah.getContext() == null))
    {
      AppMethodBeat.o(30922);
      return false;
    }
    String str = paramString1.toLowerCase();
    j = str.indexOf(paramString2.toLowerCase());
    int i = j;
    if (j == -1)
    {
      AppMethodBeat.o(30922);
      return false;
    }
    do
    {
      for (;;)
      {
        try
        {
          if ((i >= str.length() - 1) || (com.tencent.mm.platformtools.ah.isNullOrNil(paramString3))) {
            continue;
          }
          if ((i <= 0) || (str.charAt(i - 1) < 'a') || (str.charAt(i - 1) > 'z')) {
            continue;
          }
          ab.v("MicroMsg.EggMgr", "letter in the prefix");
          localObject = paramString1.substring(0, i);
          int k = ((String)localObject).lastIndexOf('/');
          j = k;
          if (k == -1) {
            continue;
          }
          localObject = ((String)localObject).subSequence(k, ((String)localObject).length());
          com.tencent.mm.cd.g.dvk();
          com.tencent.mm.sdk.platformtools.ah.getContext();
          localObject = com.tencent.mm.cd.f.dvf().aqE((String)localObject);
          if (localObject == null) {
            continue;
          }
          localObject = ((f.a)localObject).text;
          j = k;
          if (com.tencent.mm.platformtools.ah.isNullOrNil((String)localObject)) {
            continue;
          }
          j = k;
          if (((String)localObject).length() + k != i) {
            continue;
          }
          ab.v("MicroMsg.EggMgr", "letter in the prefix is smiley");
          j = -2;
        }
        catch (Exception paramString1)
        {
          Object localObject;
          ab.v("MicroMsg.EggMgr", "Exception in isKeywordMatch, %s", new Object[] { paramString1.getMessage() });
          ab.printErrStackTrace("MicroMsg.EggMgr", paramString1, "", new Object[0]);
          continue;
          boolean bool1 = true;
          continue;
          boolean bool2 = true;
          continue;
          if (j == -2) {
            continue;
          }
          bool1 = false;
          continue;
        }
        bool2 = bool1;
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
                ab.v("MicroMsg.EggMgr", "letter in the suffix");
                bool2 = false;
              }
            }
          }
        }
        if (!bool2) {
          continue;
        }
        ab.v("MicroMsg.EggMgr", "full match, matchPos = %s, TextLength = %s, keyLength = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(str.length()), Integer.valueOf(paramString2.length()) });
        AppMethodBeat.o(30922);
        return bool2;
        localObject = null;
      }
      j = str.indexOf(paramString2.toLowerCase(), i + 1);
      i = j;
    } while (j != -1);
    AppMethodBeat.o(30922);
    return false;
  }
  
  private static boolean atN(String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(30921);
    boolean bool1;
    if (com.tencent.mm.platformtools.ah.isNullOrNil(paramString)) {
      bool1 = bool2;
    }
    for (;;)
    {
      AppMethodBeat.o(30921);
      return bool1;
      paramString = paramString.split(",");
      int j = paramString.length;
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label67;
        }
        bool1 = bool2;
        if (paramString[i].equals(aa.dsG())) {
          break;
        }
        i += 1;
      }
      label67:
      bool1 = false;
    }
  }
  
  private void dGS()
  {
    AppMethodBeat.i(30923);
    aw.aaz();
    if (com.tencent.mm.platformtools.ah.gz(com.tencent.mm.platformtools.ah.d((Long)c.Ru().get(68108, null))) * 1000L > 21600000L) {
      new ak().postDelayed(new z.2(this), 10000L);
    }
    AppMethodBeat.o(30923);
  }
  
  public final void a(Activity paramActivity, List<bi> paramList)
  {
    AppMethodBeat.i(30919);
    if (paramList == null)
    {
      AppMethodBeat.o(30919);
      return;
    }
    dGS();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (a(paramActivity, (bi)paramList.next()))
      {
        AppMethodBeat.o(30919);
        return;
      }
    }
    AppMethodBeat.o(30919);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.z
 * JD-Core Version:    0.7.0.1
 */