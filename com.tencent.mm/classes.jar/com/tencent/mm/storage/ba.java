package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.c;
import com.tencent.mm.storage.emotion.e;
import com.tencent.mm.ui.tools.f;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

public final class ba
{
  private static final ba Jfw;
  public String Jfo;
  private int Jfp;
  public int Jfq;
  HashMap<String, String> Jfr;
  public HashMap<String, ArrayList<String>> Jfs;
  public HashMap<String, String> Jft;
  public HashMap<String, ArrayList<a>> Jfu;
  public Comparator<a> Jfv;
  public boolean mInit;
  
  static
  {
    AppMethodBeat.i(188523);
    Jfw = new ba();
    AppMethodBeat.o(188523);
  }
  
  public ba()
  {
    AppMethodBeat.i(104958);
    this.mInit = false;
    this.Jfp = 2;
    this.Jfq = 32;
    this.Jfr = new HashMap();
    this.Jfs = new HashMap();
    this.Jft = new HashMap();
    this.Jfu = new HashMap();
    this.Jfv = new Comparator() {};
    AppMethodBeat.o(104958);
  }
  
  public static ba fuY()
  {
    return Jfw;
  }
  
  public final String acm(String paramString)
  {
    AppMethodBeat.i(104961);
    if ((this.Jfr != null) && (this.Jfr.containsKey(paramString)))
    {
      ae.i("MicroMsg.emoji.EmojiDescNewMgr", "getCurLangDesc: from map");
      paramString = (String)this.Jfr.get(paramString);
      AppMethodBeat.o(104961);
      return paramString;
    }
    ae.i("MicroMsg.emoji.EmojiDescNewMgr", "getCurLangDesc: from db");
    paramString = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().JfW.acm(paramString);
    AppMethodBeat.o(104961);
    return paramString;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(104959);
    if (this.Jfr != null) {
      this.Jfr.clear();
    }
    if (this.Jfs != null) {
      this.Jfs.clear();
    }
    if (this.Jft != null) {
      this.Jft.clear();
    }
    if (this.Jfu != null) {
      this.Jfu.clear();
    }
    AppMethodBeat.o(104959);
  }
  
  public final void fuZ()
  {
    AppMethodBeat.i(104960);
    com.tencent.e.h.MqF.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104956);
        long l = System.currentTimeMillis();
        ba localba = ba.this;
        localba.clear();
        Object localObject3 = null;
        Object localObject1 = null;
        int i;
        try
        {
          localObject4 = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().Jge.getAll();
          if (localObject4 != null)
          {
            localObject1 = localObject4;
            localObject3 = localObject4;
            if (((Cursor)localObject4).moveToFirst())
            {
              localObject1 = localObject4;
              localObject3 = localObject4;
              int j = ((Cursor)localObject4).getCount();
              i = 0;
              while (i < j)
              {
                localObject1 = localObject4;
                localObject3 = localObject4;
                localObject7 = new com.tencent.mm.storage.emotion.h();
                localObject1 = localObject4;
                localObject3 = localObject4;
                ((com.tencent.mm.storage.emotion.h)localObject7).convertFrom((Cursor)localObject4);
                localObject1 = localObject4;
                localObject3 = localObject4;
                localObject5 = ((com.tencent.mm.storage.emotion.h)localObject7).field_desc;
                localObject1 = localObject4;
                localObject3 = localObject4;
                if (!bu.isNullOrNil((String)localObject5))
                {
                  localObject1 = localObject4;
                  localObject3 = localObject4;
                  localObject5 = ((String)localObject5).toLowerCase();
                  localObject1 = localObject4;
                  localObject3 = localObject4;
                  localba.Jft.put(localObject5, ((com.tencent.mm.storage.emotion.h)localObject7).field_groupID);
                  localObject1 = localObject4;
                  localObject3 = localObject4;
                  localObject6 = (ArrayList)localba.Jfs.get(((com.tencent.mm.storage.emotion.h)localObject7).field_groupID);
                  localObject5 = localObject6;
                  if (localObject6 == null)
                  {
                    localObject1 = localObject4;
                    localObject3 = localObject4;
                    localObject5 = new ArrayList();
                  }
                  localObject1 = localObject4;
                  localObject3 = localObject4;
                  ((ArrayList)localObject5).add(((com.tencent.mm.storage.emotion.h)localObject7).field_desc);
                  localObject1 = localObject4;
                  localObject3 = localObject4;
                  localba.Jfs.put(((com.tencent.mm.storage.emotion.h)localObject7).field_groupID, localObject5);
                }
                localObject1 = localObject4;
                localObject3 = localObject4;
                ((Cursor)localObject4).moveToNext();
                i += 1;
              }
            }
          }
          if (localObject4 != null) {
            ((Cursor)localObject4).close();
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Object localObject4;
            Object localObject7;
            Object localObject5;
            Object localObject6;
            localObject3 = localObject1;
            ae.e("MicroMsg.emoji.EmojiDescNewMgr", bu.o(localException));
            if (localObject1 != null) {
              ((Cursor)localObject1).close();
            }
          }
        }
        finally
        {
          if (localObject3 == null) {
            break label602;
          }
          ((Cursor)localObject3).close();
          AppMethodBeat.o(104956);
        }
        localObject4 = ad.fom().toLowerCase();
        localba.Jfo = ((String)localObject4);
        localObject5 = be.fvc().JfV.fwU().iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (EmojiGroupInfo)((Iterator)localObject5).next();
          localObject7 = be.fvc().JfW.aWk(((EmojiGroupInfo)localObject6).field_productID).iterator();
          while (((Iterator)localObject7).hasNext())
          {
            localObject3 = (com.tencent.mm.storage.emotion.d)((Iterator)localObject7).next();
            localObject1 = ((com.tencent.mm.storage.emotion.d)localObject3).field_desc;
            String str1 = ((com.tencent.mm.storage.emotion.d)localObject3).field_md5;
            String str2 = ((com.tencent.mm.storage.emotion.d)localObject3).field_lang;
            i = ((EmojiGroupInfo)localObject6).field_idx;
            if ((!bu.isNullOrNil((String)localObject1)) && (!bu.isNullOrNil(str2)))
            {
              String str3 = ((String)localObject1).toLowerCase();
              if (localba.Jfu.containsKey(str3))
              {
                localObject3 = (ArrayList)localba.Jfu.get(str3);
                localObject1 = localObject3;
                if (localObject3 == null) {
                  localObject1 = new ArrayList();
                }
                ((ArrayList)localObject1).add(new ba.a(localba, str1, i));
              }
              for (;;)
              {
                if (!str2.equals(localObject4)) {
                  break label653;
                }
                localba.Jfr.put(str1, str3);
                break;
                label602:
                ArrayList localArrayList = new ArrayList();
                localArrayList.add(new ba.a(localba, str1, i));
                localba.Jfu.put(str3, localArrayList);
              }
              label653:
              if ((str2.equals("default")) && (!localba.Jfr.containsKey(str1))) {
                localba.Jfr.put(str1, str3);
              }
            }
          }
        }
        ae.i("MicroMsg.emoji.EmojiDescNewMgr", "tryInit: %s, %s", new Object[] { Integer.valueOf(localba.Jfu.size()), Integer.valueOf(localba.Jfr.size()) });
        ba.a(ba.this);
        ae.i("MicroMsg.emoji.EmojiDescNewMgr", "cpan[newinit] all use time:%s", new Object[] { System.currentTimeMillis() - l });
        AppMethodBeat.o(104956);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(104957);
        String str = super.toString() + "|newinit";
        AppMethodBeat.o(104957);
        return str;
      }
    }, "MicroMsg.emoji.EmojiDescNewMgr|newinit");
    AppMethodBeat.o(104960);
  }
  
  public final boolean wG(String paramString)
  {
    AppMethodBeat.i(188522);
    if (!this.mInit) {
      fuZ();
    }
    if (f.aYK(paramString) > this.Jfq)
    {
      ae.i("MicroMsg.emoji.EmojiDescNewMgr", "input text over checkout limit.");
      AppMethodBeat.o(188522);
      return false;
    }
    if ((!bu.isNullOrNil(paramString)) && (this.Jfu != null))
    {
      paramString = paramString.toLowerCase();
      paramString = (ArrayList)this.Jfu.get(paramString);
      if ((paramString != null) && (paramString.size() > 0))
      {
        AppMethodBeat.o(188522);
        return true;
      }
      AppMethodBeat.o(188522);
      return false;
    }
    AppMethodBeat.o(188522);
    return false;
  }
  
  public final class a
  {
    int index;
    public String md5;
    
    a(String paramString, int paramInt)
    {
      this.md5 = paramString;
      this.index = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.storage.ba
 * JD-Core Version:    0.7.0.1
 */