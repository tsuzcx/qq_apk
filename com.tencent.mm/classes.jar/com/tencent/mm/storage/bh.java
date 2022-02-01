package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.c;
import com.tencent.mm.storage.emotion.e;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

public class bh
{
  private static final bh adiW;
  public String adiO;
  private int adiP;
  public int adiQ;
  HashMap<String, String> adiR;
  public HashMap<String, ArrayList<String>> adiS;
  public HashMap<String, String> adiT;
  public HashMap<String, ArrayList<a>> adiU;
  public Comparator<a> adiV;
  public boolean mInit;
  
  static
  {
    AppMethodBeat.i(248665);
    adiW = new bh();
    AppMethodBeat.o(248665);
  }
  
  public bh()
  {
    AppMethodBeat.i(104958);
    this.mInit = false;
    this.adiP = 2;
    this.adiQ = 32;
    this.adiR = new HashMap();
    this.adiS = new HashMap();
    this.adiT = new HashMap();
    this.adiU = new HashMap();
    this.adiV = new Comparator() {};
    AppMethodBeat.o(104958);
  }
  
  public static bh jaX()
  {
    return adiW;
  }
  
  public final String aoi(String paramString)
  {
    AppMethodBeat.i(104961);
    if ((this.adiR != null) && (this.adiR.containsKey(paramString)))
    {
      Log.i("MicroMsg.emoji.EmojiDescNewMgr", "getCurLangDesc: from map");
      paramString = (String)this.adiR.get(paramString);
      AppMethodBeat.o(104961);
      return paramString;
    }
    Log.i("MicroMsg.emoji.EmojiDescNewMgr", "getCurLangDesc: from db");
    paramString = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiStorageMgr().adjw.aoi(paramString);
    AppMethodBeat.o(104961);
    return paramString;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(104959);
    if (this.adiR != null) {
      this.adiR.clear();
    }
    if (this.adiS != null) {
      this.adiS.clear();
    }
    if (this.adiT != null) {
      this.adiT.clear();
    }
    if (this.adiU != null) {
      this.adiU.clear();
    }
    AppMethodBeat.o(104959);
  }
  
  public final void jaY()
  {
    AppMethodBeat.i(104960);
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104956);
        long l = System.currentTimeMillis();
        bh localbh = bh.this;
        localbh.clear();
        Object localObject3 = null;
        Object localObject1 = null;
        int i;
        try
        {
          localObject4 = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiStorageMgr().adjF.getAll();
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
                  localbh.adiT.put(localObject5, ((com.tencent.mm.storage.emotion.h)localObject7).field_groupID);
                  localObject1 = localObject4;
                  localObject3 = localObject4;
                  localObject6 = (ArrayList)localbh.adiS.get(((com.tencent.mm.storage.emotion.h)localObject7).field_groupID);
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
                  localbh.adiS.put(((com.tencent.mm.storage.emotion.h)localObject7).field_groupID, localObject5);
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
        localbh.adiO = ((String)localObject4);
        localObject5 = bl.jba().adjv.jcY().iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (EmojiGroupInfo)((Iterator)localObject5).next();
          localObject7 = bl.jba().adjw.byZ(((EmojiGroupInfo)localObject6).field_productID).iterator();
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
              if (localbh.adiU.containsKey(str3))
              {
                localObject3 = (ArrayList)localbh.adiU.get(str3);
                localObject1 = localObject3;
                if (localObject3 == null) {
                  localObject1 = new ArrayList();
                }
                ((ArrayList)localObject1).add(new bh.a(localbh, str1, i));
              }
              for (;;)
              {
                if (!str2.equals(localObject4)) {
                  break label653;
                }
                localbh.adiR.put(str1, str3);
                break;
                label602:
                ArrayList localArrayList = new ArrayList();
                localArrayList.add(new bh.a(localbh, str1, i));
                localbh.adiU.put(str3, localArrayList);
              }
              label653:
              if ((str2.equals("default")) && (!localbh.adiR.containsKey(str1))) {
                localbh.adiR.put(str1, str3);
              }
            }
          }
        }
        Log.i("MicroMsg.emoji.EmojiDescNewMgr", "tryInit: %s, %s", new Object[] { Integer.valueOf(localbh.adiU.size()), Integer.valueOf(localbh.adiR.size()) });
        bh.a(bh.this);
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
 * Qualified Name:     com.tencent.mm.storage.bh
 * JD-Core Version:    0.7.0.1
 */