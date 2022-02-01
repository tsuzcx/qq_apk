package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.c;
import com.tencent.mm.storage.emotion.e;
import com.tencent.mm.ui.tools.f;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

public final class az
{
  private static final az IKP;
  public String IKH;
  private int IKI;
  public int IKJ;
  HashMap<String, String> IKK;
  public HashMap<String, ArrayList<String>> IKL;
  public HashMap<String, String> IKM;
  public HashMap<String, ArrayList<a>> IKN;
  public Comparator<a> IKO;
  public boolean mInit;
  
  static
  {
    AppMethodBeat.i(219042);
    IKP = new az();
    AppMethodBeat.o(219042);
  }
  
  public az()
  {
    AppMethodBeat.i(104958);
    this.mInit = false;
    this.IKI = 2;
    this.IKJ = 32;
    this.IKK = new HashMap();
    this.IKL = new HashMap();
    this.IKM = new HashMap();
    this.IKN = new HashMap();
    this.IKO = new Comparator() {};
    AppMethodBeat.o(104958);
  }
  
  public static az fqY()
  {
    return IKP;
  }
  
  public final String abv(String paramString)
  {
    AppMethodBeat.i(104961);
    if ((this.IKK != null) && (this.IKK.containsKey(paramString)))
    {
      ad.i("MicroMsg.emoji.EmojiDescNewMgr", "getCurLangDesc: from map");
      paramString = (String)this.IKK.get(paramString);
      AppMethodBeat.o(104961);
      return paramString;
    }
    ad.i("MicroMsg.emoji.EmojiDescNewMgr", "getCurLangDesc: from db");
    paramString = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().ILp.abv(paramString);
    AppMethodBeat.o(104961);
    return paramString;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(104959);
    if (this.IKK != null) {
      this.IKK.clear();
    }
    if (this.IKL != null) {
      this.IKL.clear();
    }
    if (this.IKM != null) {
      this.IKM.clear();
    }
    if (this.IKN != null) {
      this.IKN.clear();
    }
    AppMethodBeat.o(104959);
  }
  
  public final void fqZ()
  {
    AppMethodBeat.i(104960);
    com.tencent.e.h.LTJ.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104956);
        long l = System.currentTimeMillis();
        az localaz = az.this;
        localaz.clear();
        Object localObject3 = null;
        Object localObject1 = null;
        int i;
        try
        {
          localObject4 = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().ILx.getAll();
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
                if (!bt.isNullOrNil((String)localObject5))
                {
                  localObject1 = localObject4;
                  localObject3 = localObject4;
                  localObject5 = ((String)localObject5).toLowerCase();
                  localObject1 = localObject4;
                  localObject3 = localObject4;
                  localaz.IKM.put(localObject5, ((com.tencent.mm.storage.emotion.h)localObject7).field_groupID);
                  localObject1 = localObject4;
                  localObject3 = localObject4;
                  localObject6 = (ArrayList)localaz.IKL.get(((com.tencent.mm.storage.emotion.h)localObject7).field_groupID);
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
                  localaz.IKL.put(((com.tencent.mm.storage.emotion.h)localObject7).field_groupID, localObject5);
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
            ad.e("MicroMsg.emoji.EmojiDescNewMgr", bt.n(localException));
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
        localObject4 = ac.fks().toLowerCase();
        localaz.IKH = ((String)localObject4);
        localObject5 = bd.frc().ILo.fsT().iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (EmojiGroupInfo)((Iterator)localObject5).next();
          localObject7 = bd.frc().ILp.aUJ(((EmojiGroupInfo)localObject6).field_productID).iterator();
          while (((Iterator)localObject7).hasNext())
          {
            localObject3 = (com.tencent.mm.storage.emotion.d)((Iterator)localObject7).next();
            localObject1 = ((com.tencent.mm.storage.emotion.d)localObject3).field_desc;
            String str1 = ((com.tencent.mm.storage.emotion.d)localObject3).field_md5;
            String str2 = ((com.tencent.mm.storage.emotion.d)localObject3).field_lang;
            i = ((EmojiGroupInfo)localObject6).field_idx;
            if ((!bt.isNullOrNil((String)localObject1)) && (!bt.isNullOrNil(str2)))
            {
              String str3 = ((String)localObject1).toLowerCase();
              if (localaz.IKN.containsKey(str3))
              {
                localObject3 = (ArrayList)localaz.IKN.get(str3);
                localObject1 = localObject3;
                if (localObject3 == null) {
                  localObject1 = new ArrayList();
                }
                ((ArrayList)localObject1).add(new az.a(localaz, str1, i));
              }
              for (;;)
              {
                if (!str2.equals(localObject4)) {
                  break label653;
                }
                localaz.IKK.put(str1, str3);
                break;
                label602:
                ArrayList localArrayList = new ArrayList();
                localArrayList.add(new az.a(localaz, str1, i));
                localaz.IKN.put(str3, localArrayList);
              }
              label653:
              if ((str2.equals("default")) && (!localaz.IKK.containsKey(str1))) {
                localaz.IKK.put(str1, str3);
              }
            }
          }
        }
        ad.i("MicroMsg.emoji.EmojiDescNewMgr", "tryInit: %s, %s", new Object[] { Integer.valueOf(localaz.IKN.size()), Integer.valueOf(localaz.IKK.size()) });
        az.a(az.this);
        ad.i("MicroMsg.emoji.EmojiDescNewMgr", "cpan[newinit] all use time:%s", new Object[] { System.currentTimeMillis() - l });
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
  
  public final boolean vZ(String paramString)
  {
    AppMethodBeat.i(219041);
    if (!this.mInit) {
      fqZ();
    }
    if (f.aXj(paramString) > this.IKJ)
    {
      ad.i("MicroMsg.emoji.EmojiDescNewMgr", "input text over checkout limit.");
      AppMethodBeat.o(219041);
      return false;
    }
    if ((!bt.isNullOrNil(paramString)) && (this.IKN != null))
    {
      paramString = paramString.toLowerCase();
      paramString = (ArrayList)this.IKN.get(paramString);
      if ((paramString != null) && (paramString.size() > 0))
      {
        AppMethodBeat.o(219041);
        return true;
      }
      AppMethodBeat.o(219041);
      return false;
    }
    AppMethodBeat.o(219041);
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
 * Qualified Name:     com.tencent.mm.storage.az
 * JD-Core Version:    0.7.0.1
 */