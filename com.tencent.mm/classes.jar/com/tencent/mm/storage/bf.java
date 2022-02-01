package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.c;
import com.tencent.mm.storage.emotion.e;
import com.tencent.mm.ui.tools.f;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

public final class bf
{
  private static final bf Opq;
  public String Opi;
  private int Opj;
  public int Opk;
  HashMap<String, String> Opl;
  public HashMap<String, ArrayList<String>> Opm;
  public HashMap<String, String> Opn;
  public HashMap<String, ArrayList<a>> Opo;
  public Comparator<a> Opp;
  public boolean mInit;
  
  static
  {
    AppMethodBeat.i(199819);
    Opq = new bf();
    AppMethodBeat.o(199819);
  }
  
  public bf()
  {
    AppMethodBeat.i(104958);
    this.mInit = false;
    this.Opj = 2;
    this.Opk = 32;
    this.Opl = new HashMap();
    this.Opm = new HashMap();
    this.Opn = new HashMap();
    this.Opo = new HashMap();
    this.Opp = new Comparator() {};
    AppMethodBeat.o(104958);
  }
  
  public static bf gCF()
  {
    return Opq;
  }
  
  public final boolean EV(String paramString)
  {
    AppMethodBeat.i(199818);
    if (!this.mInit) {
      gCG();
    }
    if (f.bnP(paramString) > this.Opk)
    {
      Log.i("MicroMsg.emoji.EmojiDescNewMgr", "input text over checkout limit.");
      AppMethodBeat.o(199818);
      return false;
    }
    if ((!Util.isNullOrNil(paramString)) && (this.Opo != null))
    {
      paramString = paramString.toLowerCase();
      paramString = (ArrayList)this.Opo.get(paramString);
      if ((paramString != null) && (paramString.size() > 0))
      {
        AppMethodBeat.o(199818);
        return true;
      }
      AppMethodBeat.o(199818);
      return false;
    }
    AppMethodBeat.o(199818);
    return false;
  }
  
  public final String amp(String paramString)
  {
    AppMethodBeat.i(104961);
    if ((this.Opl != null) && (this.Opl.containsKey(paramString)))
    {
      Log.i("MicroMsg.emoji.EmojiDescNewMgr", "getCurLangDesc: from map");
      paramString = (String)this.Opl.get(paramString);
      AppMethodBeat.o(104961);
      return paramString;
    }
    Log.i("MicroMsg.emoji.EmojiDescNewMgr", "getCurLangDesc: from db");
    paramString = ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpP.amp(paramString);
    AppMethodBeat.o(104961);
    return paramString;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(104959);
    if (this.Opl != null) {
      this.Opl.clear();
    }
    if (this.Opm != null) {
      this.Opm.clear();
    }
    if (this.Opn != null) {
      this.Opn.clear();
    }
    if (this.Opo != null) {
      this.Opo.clear();
    }
    AppMethodBeat.o(104959);
  }
  
  public final void gCG()
  {
    AppMethodBeat.i(104960);
    com.tencent.f.h.RTc.b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104956);
        long l = System.currentTimeMillis();
        bf localbf = bf.this;
        localbf.clear();
        Object localObject3 = null;
        Object localObject1 = null;
        int i;
        try
        {
          localObject4 = ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpX.getAll();
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
                if (!Util.isNullOrNil((String)localObject5))
                {
                  localObject1 = localObject4;
                  localObject3 = localObject4;
                  localObject5 = ((String)localObject5).toLowerCase();
                  localObject1 = localObject4;
                  localObject3 = localObject4;
                  localbf.Opn.put(localObject5, ((com.tencent.mm.storage.emotion.h)localObject7).field_groupID);
                  localObject1 = localObject4;
                  localObject3 = localObject4;
                  localObject6 = (ArrayList)localbf.Opm.get(((com.tencent.mm.storage.emotion.h)localObject7).field_groupID);
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
                  localbf.Opm.put(((com.tencent.mm.storage.emotion.h)localObject7).field_groupID, localObject5);
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
            Log.e("MicroMsg.emoji.EmojiDescNewMgr", Util.stackTraceToString(localException));
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
        localObject4 = LocaleUtil.getApplicationLanguage().toLowerCase();
        localbf.Opi = ((String)localObject4);
        localObject5 = bj.gCJ().OpO.gEG().iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (EmojiGroupInfo)((Iterator)localObject5).next();
          localObject7 = bj.gCJ().OpP.blj(((EmojiGroupInfo)localObject6).field_productID).iterator();
          while (((Iterator)localObject7).hasNext())
          {
            localObject3 = (com.tencent.mm.storage.emotion.d)((Iterator)localObject7).next();
            localObject1 = ((com.tencent.mm.storage.emotion.d)localObject3).field_desc;
            String str1 = ((com.tencent.mm.storage.emotion.d)localObject3).field_md5;
            String str2 = ((com.tencent.mm.storage.emotion.d)localObject3).field_lang;
            i = ((EmojiGroupInfo)localObject6).field_idx;
            if ((!Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil(str2)))
            {
              String str3 = ((String)localObject1).toLowerCase();
              if (localbf.Opo.containsKey(str3))
              {
                localObject3 = (ArrayList)localbf.Opo.get(str3);
                localObject1 = localObject3;
                if (localObject3 == null) {
                  localObject1 = new ArrayList();
                }
                ((ArrayList)localObject1).add(new bf.a(localbf, str1, i));
              }
              for (;;)
              {
                if (!str2.equals(localObject4)) {
                  break label653;
                }
                localbf.Opl.put(str1, str3);
                break;
                label602:
                ArrayList localArrayList = new ArrayList();
                localArrayList.add(new bf.a(localbf, str1, i));
                localbf.Opo.put(str3, localArrayList);
              }
              label653:
              if ((str2.equals("default")) && (!localbf.Opl.containsKey(str1))) {
                localbf.Opl.put(str1, str3);
              }
            }
          }
        }
        Log.i("MicroMsg.emoji.EmojiDescNewMgr", "tryInit: %s, %s", new Object[] { Integer.valueOf(localbf.Opo.size()), Integer.valueOf(localbf.Opl.size()) });
        bf.a(bf.this);
        Log.i("MicroMsg.emoji.EmojiDescNewMgr", "cpan[newinit] all use time:%s", new Object[] { System.currentTimeMillis() - l });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.bf
 * JD-Core Version:    0.7.0.1
 */