package com.tencent.mm.plugin.story.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.story.h.b;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.h.m;
import com.tencent.mm.plugin.story.h.o;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.protocal.protobuf.cic;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.t;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/StoryCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "allUnRead", "", "allmockData", "args", "", "", "([Ljava/lang/String;)V", "cleanDb", "commentClear", "commentDump", "copyFile", "copydb", "createFiles", "delfile", "dumpDbInfo", "dumpFile", "processCommand", "", "context", "Landroid/content/Context;", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "resetFirst", "resetI2VParams", "(Landroid/content/Context;[Ljava/lang/String;)V", "rsetStoryPostThreshold", "strangerClear", "strangerDump", "strangerRead", "testMakeData", "videoCacheClear", "Companion", "plugin-story_release"})
public final class h
  implements a
{
  public static final h.a suD;
  
  static
  {
    AppMethodBeat.i(109033);
    suD = new h.a((byte)0);
    AppMethodBeat.o(109033);
  }
  
  private static void H(String[] paramArrayOfString)
  {
    AppMethodBeat.i(109030);
    Object localObject2 = paramArrayOfString[2];
    paramArrayOfString = j.svi;
    paramArrayOfString = j.b.cAC().acU("foreverzeus");
    Object localObject1 = j.svi;
    localObject1 = j.b.cAB();
    Object localObject3 = j.svi;
    boolean bool = bo.isEqual(j.b.coK(), "foreverzeus");
    int i = cb.abr();
    localObject3 = i.suJ;
    localObject1 = k.a((k)localObject1, "foreverzeus", bool, i - i.cAp());
    if (((List)localObject1).isEmpty())
    {
      t.makeText(ah.getContext(), (CharSequence)"allmockData error1", 1).show();
      AppMethodBeat.o(109030);
      return;
    }
    localObject2 = com.tencent.mm.model.n.nt((String)localObject2);
    if (localObject2 != null)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        Object localObject4 = j.svi;
        localObject4 = j.b.cAC();
        a.f.b.j.p(localObject3, "it");
        localObject4 = ((com.tencent.mm.plugin.story.h.g)localObject4).acU((String)localObject3);
        i = (int)((f)localObject4).systemRowid;
        if (!((f)localObject4).isValid())
        {
          paramArrayOfString.setUserName((String)localObject3);
          paramArrayOfString.field_storyPostTime = ((int)bo.yB());
          paramArrayOfString.systemRowid = -1L;
          if (i >= 0) {
            break label299;
          }
          localObject4 = j.svi;
          j.b.cAC().insert((com.tencent.mm.sdk.e.c)paramArrayOfString);
        }
        for (;;)
        {
          localObject4 = (com.tencent.mm.plugin.story.h.j)((List)localObject1).get(0);
          ((com.tencent.mm.plugin.story.h.j)localObject4).field_userName = ((String)localObject3);
          ((com.tencent.mm.plugin.story.h.j)localObject4).field_createTime = cb.abr();
          cic localcic = ((com.tencent.mm.plugin.story.h.j)localObject4).cEY();
          localcic.jJA = ((String)localObject3);
          ((com.tencent.mm.plugin.story.h.j)localObject4).b(localcic);
          ((com.tencent.mm.plugin.story.h.j)localObject4).cIp = -1;
          localObject3 = j.svi;
          j.b.cAB().insert((com.tencent.mm.sdk.e.c)localObject4);
          break;
          label299:
          localObject4 = j.svi;
          j.b.cAC().b(i * 1L, paramArrayOfString);
        }
      }
    }
    t.makeText(ah.getContext(), (CharSequence)"allmockData done", 1).show();
    AppMethodBeat.o(109030);
  }
  
  private static void I(String[] paramArrayOfString)
  {
    AppMethodBeat.i(109031);
    int j = bo.apV(paramArrayOfString[2]);
    ab.i("MicroMsg.StoryCommand", "testMakeData datacount ".concat(String.valueOf(j)));
    paramArrayOfString = j.svi;
    paramArrayOfString = j.b.cAB();
    Object localObject1 = j.svi;
    boolean bool = bo.isEqual(j.b.coK(), "ychengo");
    int i = cb.abr();
    localObject1 = i.suJ;
    paramArrayOfString = k.a(paramArrayOfString, "ychengo", bool, i - i.cAp());
    i = 0;
    while (i < j)
    {
      localObject1 = (com.tencent.mm.plugin.story.h.j)paramArrayOfString.get(0);
      ((com.tencent.mm.plugin.story.h.j)localObject1).field_userName = "ychengo";
      ((com.tencent.mm.plugin.story.h.j)localObject1).field_createTime = cb.abr();
      Object localObject2 = ((com.tencent.mm.plugin.story.h.j)localObject1).cEY();
      ((cic)localObject2).jJA = "ychengo";
      ((com.tencent.mm.plugin.story.h.j)localObject1).b((cic)localObject2);
      ((com.tencent.mm.plugin.story.h.j)localObject1).cIp = -1;
      localObject2 = j.svi;
      j.b.cAB().insert((com.tencent.mm.sdk.e.c)localObject1);
      i += 1;
    }
    t.makeText(ah.getContext(), (CharSequence)"testMakeData done ".concat(String.valueOf(j)), 1).show();
    AppMethodBeat.o(109031);
  }
  
  private static void cAj()
  {
    AppMethodBeat.i(109025);
    Object localObject = j.svi;
    localObject = ((Iterable)j.b.cAE().cEJ()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.story.h.c localc = (com.tencent.mm.plugin.story.h.c)((Iterator)localObject).next();
      ab.i("MicroMsg.StoryCommand", "commentDump " + localc.field_storyId + ' ' + localc.field_readCommentId + ' ' + localc.field_syncCommentId);
    }
    AppMethodBeat.o(109025);
  }
  
  private static void cAk()
  {
    AppMethodBeat.i(109026);
    Object localObject = j.svi;
    localObject = ((Iterable)j.b.cAE().cEJ()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.story.h.c localc = (com.tencent.mm.plugin.story.h.c)((Iterator)localObject).next();
      j.b localb = j.svi;
      j.b.cAE().delete((com.tencent.mm.sdk.e.c)localc, new String[0]);
    }
    AppMethodBeat.o(109026);
  }
  
  private static void cAl()
  {
    AppMethodBeat.i(109027);
    Object localObject1 = j.svi;
    Object localObject2 = j.b.cAF();
    localObject1 = new ArrayList();
    localObject2 = ((o)localObject2).db.rawQuery("select * from StoryVideoCacheInfo", null);
    Object localObject3;
    if (localObject2 != null)
    {
      while (((Cursor)localObject2).moveToNext())
      {
        localObject3 = new com.tencent.mm.plugin.story.h.n();
        ((com.tencent.mm.plugin.story.h.n)localObject3).convertFrom((Cursor)localObject2);
        ((ArrayList)localObject1).add(localObject3);
      }
      ((Cursor)localObject2).close();
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.plugin.story.h.n)((Iterator)localObject1).next();
      localObject3 = j.svi;
      j.b.cAF().delete((com.tencent.mm.sdk.e.c)localObject2, new String[0]);
    }
    AppMethodBeat.o(109027);
  }
  
  public static void cAm()
  {
    AppMethodBeat.i(109028);
    ab.i("MicroMsg.StoryCommand", "cleanDb");
    j.b localb = j.svi;
    j.b.cAF().csu();
    localb = j.svi;
    j.b.cAC().csu();
    localb = j.svi;
    j.b.cAD().csu();
    localb = j.svi;
    j.b.cAB().csu();
    localb = j.svi;
    com.tencent.mm.vfs.e.cO(j.b.getAccStoryCachePath());
    AppMethodBeat.o(109028);
  }
  
  public static void cAn()
  {
    AppMethodBeat.i(109029);
    Object localObject = j.svi;
    j.b.cAB().csu();
    localObject = j.svi;
    j.b.cAF().csu();
    localObject = j.svi;
    com.tencent.mm.vfs.e.cO(j.b.getAccStoryCachePath());
    localObject = j.svi;
    localObject = ((Iterable)j.b.cAC().cEW()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      f localf = (f)((Iterator)localObject).next();
      localf.field_readId = 0L;
      localf.field_md5 = "";
      localf.field_preLoadResource = 0L;
      localf.ady("");
      localf.field_preloadStoryId = 0L;
      j.b localb = j.svi;
      j.b.cAC().b(localf.systemRowid, localf);
    }
    ab.i("MicroMsg.StoryCommand", "allUnRead done");
    t.makeText(ah.getContext(), (CharSequence)"allUnRead Done", 1).show();
    AppMethodBeat.o(109029);
  }
  
  public static void cAo()
  {
    AppMethodBeat.i(109032);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.RL();
    a.f.b.j.p(locale, "MMKernel.storage()");
    locale.Ru().set(ac.a.yLr, Integer.valueOf(0));
    AppMethodBeat.o(109032);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(109024);
    a.f.b.j.q(paramArrayOfString, "args");
    a.f.b.j.q(paramString, "username");
    ab.i("MicroMsg.StoryCommand", a.a.e.a(paramArrayOfString, null, null, null, 0, null, null, 63));
    if (paramArrayOfString.length <= 1)
    {
      AppMethodBeat.o(109024);
      return false;
    }
    paramString = paramArrayOfString[1];
    label350:
    int i;
    switch (paramString.hashCode())
    {
    default: 
    case -350339842: 
    case -2113815067: 
    case 536375440: 
    case 2103071987: 
    case -2122675824: 
    case 102573: 
    case 1550482439: 
    case 1233668806: 
    case -505421199: 
      do
      {
        do
        {
          AppMethodBeat.o(109024);
          return false;
        } while (!paramString.equals("reseti2v"));
        paramArrayOfString = localObject1;
        if (paramContext != null) {
          paramArrayOfString = paramContext.getSharedPreferences("storyi2v", 0);
        }
        if (paramArrayOfString != null)
        {
          paramContext = paramArrayOfString.edit();
          if (paramContext != null)
          {
            paramContext = paramContext.putInt("storyi2v_bitRate", 3500000);
            if (paramContext != null)
            {
              paramContext = paramContext.putInt("storyi2v_frameRate", 15);
              if (paramContext != null)
              {
                paramContext = paramContext.putInt("storyi2v_iFrameInterval", 10);
                if (paramContext != null)
                {
                  paramContext = paramContext.putInt("storyi2v_MaxSize", 720);
                  if (paramContext != null) {
                    paramContext.commit();
                  }
                }
              }
            }
          }
        }
        for (;;)
        {
          AppMethodBeat.o(109024);
          return true;
          if (!paramString.equals("testcopyDb")) {
            break;
          }
          paramContext = new StringBuilder();
          paramArrayOfString = com.tencent.mm.kernel.g.RL();
          a.f.b.j.p(paramArrayOfString, "MMKernel.storage()");
          paramContext = paramArrayOfString.Rp() + "StoryMicroMsg.db";
          paramArrayOfString = new StringBuilder();
          paramString = j.svi;
          paramArrayOfString = j.b.getAccStoryPath() + "StoryMicroMsg.db";
          com.tencent.mm.vfs.e.C(paramContext, paramArrayOfString);
          ab.i("MicroMsg.StoryCommand", "copydb ".concat(String.valueOf(paramArrayOfString)));
          t.makeText(ah.getContext(), (CharSequence)"copydb done", 1).show();
          continue;
          if (!paramString.equals("allunread")) {
            break;
          }
          cAn();
          continue;
          if (!paramString.equals("commentDump")) {
            break;
          }
          cAj();
          continue;
          if (!paramString.equals("dumpFile")) {
            break;
          }
          paramContext = l.svv;
          l.cAU();
          continue;
          if (!paramString.equals("i2v")) {
            break;
          }
          a.f.b.j.q(paramArrayOfString, "args");
          i = bo.apV(paramArrayOfString[2]);
          int j = bo.apV(paramArrayOfString[3]);
          int k = bo.apV(paramArrayOfString[4]);
          int m = bo.apV(paramArrayOfString[5]);
          paramArrayOfString = localObject2;
          if (paramContext != null) {
            paramArrayOfString = paramContext.getSharedPreferences("storyi2v", 0);
          }
          if (paramArrayOfString != null)
          {
            paramContext = paramArrayOfString.edit();
            if (paramContext != null)
            {
              paramContext = paramContext.putInt("storyi2v_bitRate", i);
              if (paramContext != null)
              {
                paramContext = paramContext.putInt("storyi2v_frameRate", j);
                if (paramContext != null)
                {
                  paramContext = paramContext.putInt("storyi2v_iFrameInterval", k);
                  if (paramContext != null)
                  {
                    paramContext = paramContext.putInt("storyi2v_MaxSize", m);
                    if (paramContext != null)
                    {
                      paramContext.commit();
                      continue;
                      if (!paramString.equals("delfile")) {
                        break;
                      }
                      paramContext = l.svv;
                      com.tencent.mm.vfs.e.cO(l.cAT());
                      continue;
                      if (!paramString.equals("videoCacheClear")) {
                        break;
                      }
                      cAl();
                    }
                  }
                }
              }
            }
          }
        }
      } while (!paramString.equals("copyfile"));
      paramArrayOfString = paramArrayOfString[2];
      paramContext = l.svv;
      l.cAU();
      paramContext = l.svv;
      a.f.b.j.q(paramArrayOfString, "path");
      l.adc(l.cAS() + "cpfiles/");
      paramContext = new File(paramArrayOfString);
      if (!paramContext.exists()) {
        paramContext = "";
      }
      break;
    }
    for (;;)
    {
      t.makeText(ah.getContext(), (CharSequence)"copyFile done ".concat(String.valueOf(paramContext)), 1).show();
      break label350;
      if (!paramString.equals("createFile")) {
        break;
      }
      paramContext = l.svv;
      l.cAV();
      break label350;
      if (!paramString.equals("resetFirst")) {
        break;
      }
      paramContext = com.tencent.mm.kernel.g.RL();
      a.f.b.j.p(paramContext, "MMKernel.storage()");
      paramContext.Ru().set(ac.a.yLu, Integer.valueOf(0));
      paramContext = com.tencent.mm.kernel.g.RL();
      a.f.b.j.p(paramContext, "MMKernel.storage()");
      paramContext.Ru().set(ac.a.yLv, Boolean.FALSE);
      paramContext = com.tencent.mm.kernel.g.RL();
      a.f.b.j.p(paramContext, "MMKernel.storage()");
      paramContext.Ru().set(ac.a.yLw, Boolean.FALSE);
      break label350;
      if (!paramString.equals("strangerClear")) {
        break;
      }
      paramContext = j.svi;
      paramContext = ((Iterable)j.b.cAC().cEW()).iterator();
      while (paramContext.hasNext())
      {
        paramArrayOfString = (f)paramContext.next();
        paramString = j.svi;
        j.b.cAC().delete((com.tencent.mm.sdk.e.c)paramArrayOfString, new String[0]);
      }
      if (!paramString.equals("commentClear")) {
        break;
      }
      cAk();
      break label350;
      if (!paramString.equals("strangerRead")) {
        break;
      }
      paramContext = j.svi;
      paramContext = ((Iterable)j.b.cAC().cEJ()).iterator();
      while (paramContext.hasNext())
      {
        paramArrayOfString = (f)paramContext.next();
        paramArrayOfString.field_readId = paramArrayOfString.field_syncId;
        paramString = j.svi;
        j.b.cAC().b(paramArrayOfString);
      }
      if (!paramString.equals("cleandb")) {
        break;
      }
      cAm();
      break label350;
      if (!paramString.equals("testDumpInfo")) {
        break;
      }
      paramContext = j.svi;
      paramContext = j.b.cAF().db.rawQuery("select count(*) from StoryVideoCacheInfo", null);
      a.f.b.j.p(paramContext, "cu");
      i = paramContext.getCount();
      paramContext.close();
      paramContext = "StoryVideoCacheInfo resultData ".concat(String.valueOf(i));
      paramArrayOfString = j.svi;
      paramArrayOfString = j.b.cAB();
      paramString = "select count(*) from " + k.sGE;
      paramArrayOfString = paramArrayOfString.db.rawQuery(paramString, null);
      a.f.b.j.p(paramArrayOfString, "cu");
      i = paramArrayOfString.getCount();
      paramArrayOfString.close();
      paramArrayOfString = k.sGE + " resultData " + i;
      ab.i("MicroMsg.StoryCommand", "info1 " + paramContext + " info2 " + paramArrayOfString);
      break label350;
      if (!paramString.equals("allmakeData")) {
        break;
      }
      I(paramArrayOfString);
      break label350;
      if (!paramString.equals("strangerDump")) {
        break;
      }
      paramContext = j.svi;
      paramContext = ((Iterable)j.b.cAC().cEJ()).iterator();
      while (paramContext.hasNext())
      {
        paramArrayOfString = (f)paramContext.next();
        ab.i("MicroMsg.StoryCommand", "strangerDump " + paramArrayOfString.getUserName() + ' ' + paramArrayOfString.field_syncId + ' ' + paramArrayOfString.field_readId + ' ' + paramArrayOfString.field_storyPostTime + ' ' + paramArrayOfString.field_updateTime);
      }
      if (!paramString.equals("allmockData")) {
        break;
      }
      H(paramArrayOfString);
      break label350;
      paramContext = l.cAS() + "cpfiles/" + paramContext.getName();
      ab.i("MicroMsg.StoryFileNameUtil", "copy file path " + paramArrayOfString + " newPath " + paramContext);
      com.tencent.mm.vfs.e.C(paramArrayOfString, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.h
 * JD-Core Version:    0.7.0.1
 */