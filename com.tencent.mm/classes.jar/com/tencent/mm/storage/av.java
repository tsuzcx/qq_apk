package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.c;
import com.tencent.mm.storage.emotion.e;
import com.tencent.mm.ui.tools.f;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

public final class av
{
  private static final av GXB;
  public Comparator<a> GXA;
  public String GXt;
  private int GXu;
  public int GXv;
  HashMap<String, String> GXw;
  public HashMap<String, ArrayList<String>> GXx;
  public HashMap<String, String> GXy;
  public HashMap<String, ArrayList<a>> GXz;
  public boolean mInit;
  
  static
  {
    AppMethodBeat.i(209800);
    GXB = new av();
    AppMethodBeat.o(209800);
  }
  
  public av()
  {
    AppMethodBeat.i(104958);
    this.mInit = false;
    this.GXu = 2;
    this.GXv = 32;
    this.GXw = new HashMap();
    this.GXx = new HashMap();
    this.GXy = new HashMap();
    this.GXz = new HashMap();
    this.GXA = new Comparator() {};
    AppMethodBeat.o(104958);
  }
  
  public static av faV()
  {
    return GXB;
  }
  
  public final String XP(String paramString)
  {
    AppMethodBeat.i(104961);
    if ((this.GXw != null) && (this.GXw.containsKey(paramString)))
    {
      ac.i("MicroMsg.emoji.EmojiDescNewMgr", "getCurLangDesc: from map");
      paramString = (String)this.GXw.get(paramString);
      AppMethodBeat.o(104961);
      return paramString;
    }
    ac.i("MicroMsg.emoji.EmojiDescNewMgr", "getCurLangDesc: from db");
    paramString = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().GYb.XP(paramString);
    AppMethodBeat.o(104961);
    return paramString;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(104959);
    if (this.GXw != null) {
      this.GXw.clear();
    }
    if (this.GXx != null) {
      this.GXx.clear();
    }
    if (this.GXy != null) {
      this.GXy.clear();
    }
    if (this.GXz != null) {
      this.GXz.clear();
    }
    AppMethodBeat.o(104959);
  }
  
  public final void faW()
  {
    AppMethodBeat.i(104960);
    com.tencent.e.h.JZN.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104956);
        long l = System.currentTimeMillis();
        av localav = av.this;
        localav.clear();
        Object localObject3 = null;
        Object localObject1 = null;
        int i;
        try
        {
          localObject4 = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().GYj.getAll();
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
                if (!bs.isNullOrNil((String)localObject5))
                {
                  localObject1 = localObject4;
                  localObject3 = localObject4;
                  localObject5 = ((String)localObject5).toLowerCase();
                  localObject1 = localObject4;
                  localObject3 = localObject4;
                  localav.GXy.put(localObject5, ((com.tencent.mm.storage.emotion.h)localObject7).field_groupID);
                  localObject1 = localObject4;
                  localObject3 = localObject4;
                  localObject6 = (ArrayList)localav.GXx.get(((com.tencent.mm.storage.emotion.h)localObject7).field_groupID);
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
                  localav.GXx.put(((com.tencent.mm.storage.emotion.h)localObject7).field_groupID, localObject5);
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
            ac.e("MicroMsg.emoji.EmojiDescNewMgr", bs.m(localException));
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
        localObject4 = ab.eUO().toLowerCase();
        localav.GXt = ((String)localObject4);
        localObject5 = az.faZ().GYa.fcM().iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (EmojiGroupInfo)((Iterator)localObject5).next();
          localObject7 = az.faZ().GYb.aOS(((EmojiGroupInfo)localObject6).field_productID).iterator();
          while (((Iterator)localObject7).hasNext())
          {
            localObject3 = (com.tencent.mm.storage.emotion.d)((Iterator)localObject7).next();
            localObject1 = ((com.tencent.mm.storage.emotion.d)localObject3).field_desc;
            String str1 = ((com.tencent.mm.storage.emotion.d)localObject3).field_md5;
            String str2 = ((com.tencent.mm.storage.emotion.d)localObject3).field_lang;
            i = ((EmojiGroupInfo)localObject6).field_idx;
            if ((!bs.isNullOrNil((String)localObject1)) && (!bs.isNullOrNil(str2)))
            {
              String str3 = ((String)localObject1).toLowerCase();
              if (localav.GXz.containsKey(str3))
              {
                localObject3 = (ArrayList)localav.GXz.get(str3);
                localObject1 = localObject3;
                if (localObject3 == null) {
                  localObject1 = new ArrayList();
                }
                ((ArrayList)localObject1).add(new av.a(localav, str1, i));
              }
              for (;;)
              {
                if (!str2.equals(localObject4)) {
                  break label653;
                }
                localav.GXw.put(str1, str3);
                break;
                label602:
                ArrayList localArrayList = new ArrayList();
                localArrayList.add(new av.a(localav, str1, i));
                localav.GXz.put(str3, localArrayList);
              }
              label653:
              if ((str2.equals("default")) && (!localav.GXw.containsKey(str1))) {
                localav.GXw.put(str1, str3);
              }
            }
          }
        }
        ac.i("MicroMsg.emoji.EmojiDescNewMgr", "tryInit: %s, %s", new Object[] { Integer.valueOf(localav.GXz.size()), Integer.valueOf(localav.GXw.size()) });
        av.a(av.this);
        ac.i("MicroMsg.emoji.EmojiDescNewMgr", "cpan[newinit] all use time:%s", new Object[] { System.currentTimeMillis() - l });
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
  
  public final boolean tj(String paramString)
  {
    AppMethodBeat.i(209799);
    if (!this.mInit) {
      faW();
    }
    if (f.aRl(paramString) > this.GXv)
    {
      ac.i("MicroMsg.emoji.EmojiDescNewMgr", "input text over checkout limit.");
      AppMethodBeat.o(209799);
      return false;
    }
    if ((!bs.isNullOrNil(paramString)) && (this.GXz != null))
    {
      paramString = paramString.toLowerCase();
      paramString = (ArrayList)this.GXz.get(paramString);
      if ((paramString != null) && (paramString.size() > 0))
      {
        AppMethodBeat.o(209799);
        return true;
      }
      AppMethodBeat.o(209799);
      return false;
    }
    AppMethodBeat.o(209799);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.av
 * JD-Core Version:    0.7.0.1
 */