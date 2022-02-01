package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.c;
import com.tencent.mm.storage.emotion.e;
import com.tencent.mm.ui.tools.g;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

public class bf
{
  private static final bf VFj;
  public String VFb;
  private int VFc;
  public int VFd;
  HashMap<String, String> VFe;
  public HashMap<String, ArrayList<String>> VFf;
  public HashMap<String, String> VFg;
  public HashMap<String, ArrayList<a>> VFh;
  public Comparator<a> VFi;
  public boolean mInit;
  
  static
  {
    AppMethodBeat.i(228946);
    VFj = new bf();
    AppMethodBeat.o(228946);
  }
  
  public bf()
  {
    AppMethodBeat.i(104958);
    this.mInit = false;
    this.VFc = 2;
    this.VFd = 32;
    this.VFe = new HashMap();
    this.VFf = new HashMap();
    this.VFg = new HashMap();
    this.VFh = new HashMap();
    this.VFi = new Comparator() {};
    AppMethodBeat.o(104958);
  }
  
  public static bf hyR()
  {
    return VFj;
  }
  
  public final boolean LO(String paramString)
  {
    AppMethodBeat.i(228944);
    if (!this.mInit) {
      hyS();
    }
    if (g.bAB(paramString) > this.VFd)
    {
      Log.i("MicroMsg.emoji.EmojiDescNewMgr", "input text over checkout limit.");
      AppMethodBeat.o(228944);
      return false;
    }
    if ((!Util.isNullOrNil(paramString)) && (this.VFh != null))
    {
      paramString = paramString.toLowerCase();
      paramString = (ArrayList)this.VFh.get(paramString);
      if ((paramString != null) && (paramString.size() > 0))
      {
        AppMethodBeat.o(228944);
        return true;
      }
      AppMethodBeat.o(228944);
      return false;
    }
    AppMethodBeat.o(228944);
    return false;
  }
  
  public final String auh(String paramString)
  {
    AppMethodBeat.i(104961);
    if ((this.VFe != null) && (this.VFe.containsKey(paramString)))
    {
      Log.i("MicroMsg.emoji.EmojiDescNewMgr", "getCurLangDesc: from map");
      paramString = (String)this.VFe.get(paramString);
      AppMethodBeat.o(104961);
      return paramString;
    }
    Log.i("MicroMsg.emoji.EmojiDescNewMgr", "getCurLangDesc: from db");
    paramString = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().VFJ.auh(paramString);
    AppMethodBeat.o(104961);
    return paramString;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(104959);
    if (this.VFe != null) {
      this.VFe.clear();
    }
    if (this.VFf != null) {
      this.VFf.clear();
    }
    if (this.VFg != null) {
      this.VFg.clear();
    }
    if (this.VFh != null) {
      this.VFh.clear();
    }
    AppMethodBeat.o(104959);
  }
  
  public final void hyS()
  {
    AppMethodBeat.i(104960);
    com.tencent.e.h.ZvG.d(new Runnable()
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
          localObject4 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().VFR.getAll();
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
                  localbf.VFg.put(localObject5, ((com.tencent.mm.storage.emotion.h)localObject7).field_groupID);
                  localObject1 = localObject4;
                  localObject3 = localObject4;
                  localObject6 = (ArrayList)localbf.VFf.get(((com.tencent.mm.storage.emotion.h)localObject7).field_groupID);
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
                  localbf.VFf.put(((com.tencent.mm.storage.emotion.h)localObject7).field_groupID, localObject5);
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
        localbf.VFb = ((String)localObject4);
        localObject5 = bj.hyV().VFI.hAX().iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (EmojiGroupInfo)((Iterator)localObject5).next();
          localObject7 = bj.hyV().VFJ.bxJ(((EmojiGroupInfo)localObject6).field_productID).iterator();
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
              if (localbf.VFh.containsKey(str3))
              {
                localObject3 = (ArrayList)localbf.VFh.get(str3);
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
                localbf.VFe.put(str1, str3);
                break;
                label602:
                ArrayList localArrayList = new ArrayList();
                localArrayList.add(new bf.a(localbf, str1, i));
                localbf.VFh.put(str3, localArrayList);
              }
              label653:
              if ((str2.equals("default")) && (!localbf.VFe.containsKey(str1))) {
                localbf.VFe.put(str1, str3);
              }
            }
          }
        }
        Log.i("MicroMsg.emoji.EmojiDescNewMgr", "tryInit: %s, %s", new Object[] { Integer.valueOf(localbf.VFh.size()), Integer.valueOf(localbf.VFe.size()) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.storage.bf
 * JD-Core Version:    0.7.0.1
 */