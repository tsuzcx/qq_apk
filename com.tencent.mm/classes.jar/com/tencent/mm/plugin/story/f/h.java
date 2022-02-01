package com.tencent.mm.plugin.story.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.recordvideo.PluginVideoEditor;
import com.tencent.mm.plugin.story.i.b;
import com.tencent.mm.plugin.story.i.m;
import com.tencent.mm.plugin.story.i.n;
import com.tencent.mm.plugin.story.i.o;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.protocal.protobuf.dep;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.base.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/StoryCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "allUnRead", "", "allmockData", "args", "", "", "([Ljava/lang/String;)V", "cleanDb", "commentClear", "commentDump", "copyFile", "copydb", "createFiles", "delfile", "dumpDbInfo", "dumpFile", "processCommand", "", "context", "Landroid/content/Context;", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "resetFirst", "resetI2VParams", "(Landroid/content/Context;[Ljava/lang/String;)V", "rsetStoryPostThreshold", "strangerClear", "strangerDump", "strangerRead", "testMakeData", "videoCacheClear", "Companion", "plugin-story_release"})
public final class h
  implements a
{
  public static final h.a zrG;
  
  static
  {
    AppMethodBeat.i(118663);
    zrG = new h.a((byte)0);
    AppMethodBeat.o(118663);
  }
  
  private static void L(String[] paramArrayOfString)
  {
    AppMethodBeat.i(118660);
    Object localObject2 = paramArrayOfString[2];
    paramArrayOfString = j.zsh;
    paramArrayOfString = j.b.dVF().awy("foreverzeus");
    Object localObject1 = j.zsh;
    localObject1 = j.b.dVE();
    Object localObject3 = j.zsh;
    boolean bool = bs.lr(j.b.dHx(), "foreverzeus");
    int i = ce.azK();
    localObject3 = i.zrK;
    localObject1 = com.tencent.mm.plugin.story.i.k.a((com.tencent.mm.plugin.story.i.k)localObject1, "foreverzeus", bool, i - i.dVv());
    if (((List)localObject1).isEmpty())
    {
      t.makeText(ai.getContext(), (CharSequence)"allmockData error1", 1).show();
      AppMethodBeat.o(118660);
      return;
    }
    localObject2 = q.vZ((String)localObject2);
    if (localObject2 != null)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        Object localObject4 = j.zsh;
        localObject4 = j.b.dVF();
        d.g.b.k.g(localObject3, "it");
        localObject4 = ((com.tencent.mm.plugin.story.i.g)localObject4).awy((String)localObject3);
        i = (int)((com.tencent.mm.plugin.story.i.f)localObject4).systemRowid;
        if (!((com.tencent.mm.plugin.story.i.f)localObject4).isValid())
        {
          paramArrayOfString.setUserName((String)localObject3);
          paramArrayOfString.field_storyPostTime = ((int)bs.Gn());
          paramArrayOfString.systemRowid = -1L;
          if (i >= 0) {
            break label299;
          }
          localObject4 = j.zsh;
          j.b.dVF().insert((com.tencent.mm.sdk.e.c)paramArrayOfString);
        }
        for (;;)
        {
          localObject4 = (com.tencent.mm.plugin.story.i.j)((List)localObject1).get(0);
          ((com.tencent.mm.plugin.story.i.j)localObject4).field_userName = ((String)localObject3);
          ((com.tencent.mm.plugin.story.i.j)localObject4).field_createTime = ce.azK();
          dep localdep = ((com.tencent.mm.plugin.story.i.j)localObject4).dZi();
          localdep.ncR = ((String)localObject3);
          ((com.tencent.mm.plugin.story.i.j)localObject4).b(localdep);
          ((com.tencent.mm.plugin.story.i.j)localObject4).dwR = -1;
          localObject3 = j.zsh;
          j.b.dVE().insert((com.tencent.mm.sdk.e.c)localObject4);
          break;
          label299:
          localObject4 = j.zsh;
          j.b.dVF().b(i * 1L, paramArrayOfString);
        }
      }
    }
    t.makeText(ai.getContext(), (CharSequence)"allmockData done", 1).show();
    AppMethodBeat.o(118660);
  }
  
  private static void M(String[] paramArrayOfString)
  {
    AppMethodBeat.i(118661);
    int j = bs.aLy(paramArrayOfString[2]);
    ac.i("MicroMsg.StoryCommand", "testMakeData datacount ".concat(String.valueOf(j)));
    paramArrayOfString = j.zsh;
    paramArrayOfString = j.b.dVE();
    Object localObject1 = j.zsh;
    boolean bool = bs.lr(j.b.dHx(), "ychengo");
    int i = ce.azK();
    localObject1 = i.zrK;
    paramArrayOfString = com.tencent.mm.plugin.story.i.k.a(paramArrayOfString, "ychengo", bool, i - i.dVv());
    i = 0;
    while (i < j)
    {
      localObject1 = (com.tencent.mm.plugin.story.i.j)paramArrayOfString.get(0);
      ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName = "ychengo";
      ((com.tencent.mm.plugin.story.i.j)localObject1).field_createTime = ce.azK();
      Object localObject2 = ((com.tencent.mm.plugin.story.i.j)localObject1).dZi();
      ((dep)localObject2).ncR = "ychengo";
      ((com.tencent.mm.plugin.story.i.j)localObject1).b((dep)localObject2);
      ((com.tencent.mm.plugin.story.i.j)localObject1).dwR = -1;
      localObject2 = j.zsh;
      j.b.dVE().insert((com.tencent.mm.sdk.e.c)localObject1);
      i += 1;
    }
    t.makeText(ai.getContext(), (CharSequence)"testMakeData done ".concat(String.valueOf(j)), 1).show();
    AppMethodBeat.o(118661);
  }
  
  private static void dVp()
  {
    AppMethodBeat.i(118655);
    Object localObject = j.zsh;
    localObject = ((Iterable)j.b.dVH().dYX()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.story.i.c localc = (com.tencent.mm.plugin.story.i.c)((Iterator)localObject).next();
      ac.i("MicroMsg.StoryCommand", "commentDump " + localc.field_storyId + ' ' + localc.field_readCommentId + ' ' + localc.field_syncCommentId);
    }
    AppMethodBeat.o(118655);
  }
  
  private static void dVq()
  {
    AppMethodBeat.i(118656);
    Object localObject = j.zsh;
    localObject = ((Iterable)j.b.dVH().dYX()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.story.i.c localc = (com.tencent.mm.plugin.story.i.c)((Iterator)localObject).next();
      j.b localb = j.zsh;
      j.b.dVH().delete((com.tencent.mm.sdk.e.c)localc, new String[0]);
    }
    AppMethodBeat.o(118656);
  }
  
  private static void dVr()
  {
    AppMethodBeat.i(118657);
    Object localObject1 = j.zsh;
    Object localObject2 = j.b.dVI();
    localObject1 = new ArrayList();
    localObject2 = ((o)localObject2).db.rawQuery("select * from StoryVideoCacheInfo", null);
    Object localObject3;
    if (localObject2 != null)
    {
      while (((Cursor)localObject2).moveToNext())
      {
        localObject3 = new n();
        ((n)localObject3).convertFrom((Cursor)localObject2);
        ((ArrayList)localObject1).add(localObject3);
      }
      ((Cursor)localObject2).close();
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (n)((Iterator)localObject1).next();
      localObject3 = j.zsh;
      j.b.dVI().delete((com.tencent.mm.sdk.e.c)localObject2, new String[0]);
    }
    AppMethodBeat.o(118657);
  }
  
  public static void dVs()
  {
    AppMethodBeat.i(118658);
    ac.i("MicroMsg.StoryCommand", "cleanDb");
    Object localObject = j.zsh;
    j.b.dVI().duq();
    localObject = j.zsh;
    j.b.dVF().duq();
    localObject = j.zsh;
    j.b.dVG().duq();
    localObject = j.zsh;
    j.b.dVE().duq();
    localObject = j.zsh;
    com.tencent.mm.vfs.i.deleteDir(j.b.getAccStoryCachePath());
    localObject = com.tencent.mm.kernel.g.ad(PluginVideoEditor.class);
    d.g.b.k.g(localObject, "MMKernel.plugin(PluginVideoEditor::class.java)");
    ((PluginVideoEditor)localObject).getVideoEditorDataStorage().duq();
    AppMethodBeat.o(118658);
  }
  
  public static void dVt()
  {
    AppMethodBeat.i(118659);
    Object localObject = j.zsh;
    j.b.dVE().duq();
    localObject = j.zsh;
    j.b.dVI().duq();
    localObject = j.zsh;
    com.tencent.mm.vfs.i.deleteDir(j.b.getAccStoryCachePath());
    localObject = j.zsh;
    localObject = ((Iterable)j.b.dVF().dZe()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.story.i.f localf = (com.tencent.mm.plugin.story.i.f)((Iterator)localObject).next();
      localf.field_readId = 0L;
      localf.field_md5 = "";
      localf.field_preLoadResource = 0L;
      localf.axa("");
      localf.field_preloadStoryId = 0L;
      j.b localb = j.zsh;
      j.b.dVF().b(localf.systemRowid, localf);
    }
    ac.i("MicroMsg.StoryCommand", "allUnRead done");
    t.makeText(ai.getContext(), (CharSequence)"allUnRead Done", 1).show();
    AppMethodBeat.o(118659);
  }
  
  public static void dVu()
  {
    AppMethodBeat.i(118662);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(locale, "MMKernel.storage()");
    locale.agA().set(ah.a.GSG, Integer.valueOf(0));
    AppMethodBeat.o(118662);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(118654);
    d.g.b.k.h(paramArrayOfString, "args");
    d.g.b.k.h(paramString, "username");
    ac.i("MicroMsg.StoryCommand", d.a.e.a(paramArrayOfString, null, null, null, 0, null, null, 63));
    if (paramArrayOfString.length <= 1)
    {
      AppMethodBeat.o(118654);
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
          AppMethodBeat.o(118654);
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
          AppMethodBeat.o(118654);
          return true;
          if (!paramString.equals("testcopyDb")) {
            break;
          }
          paramContext = new StringBuilder();
          paramArrayOfString = com.tencent.mm.kernel.g.agR();
          d.g.b.k.g(paramArrayOfString, "MMKernel.storage()");
          paramContext = paramArrayOfString.agv() + "StoryMicroMsg.db";
          paramArrayOfString = new StringBuilder();
          paramString = j.zsh;
          paramArrayOfString = j.b.getAccStoryPath() + "StoryMicroMsg.db";
          com.tencent.mm.vfs.i.lZ(paramContext, paramArrayOfString);
          ac.i("MicroMsg.StoryCommand", "copydb ".concat(String.valueOf(paramArrayOfString)));
          t.makeText(ai.getContext(), (CharSequence)"copydb done", 1).show();
          continue;
          if (!paramString.equals("allunread")) {
            break;
          }
          dVt();
          continue;
          if (!paramString.equals("commentDump")) {
            break;
          }
          dVp();
          continue;
          if (!paramString.equals("dumpFile")) {
            break;
          }
          paramContext = l.zsu;
          l.cDx();
          continue;
          if (!paramString.equals("i2v")) {
            break;
          }
          d.g.b.k.h(paramArrayOfString, "args");
          i = bs.aLy(paramArrayOfString[2]);
          int j = bs.aLy(paramArrayOfString[3]);
          int k = bs.aLy(paramArrayOfString[4]);
          int m = bs.aLy(paramArrayOfString[5]);
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
                      paramContext = l.zsu;
                      com.tencent.mm.vfs.i.deleteDir(l.dVU());
                      continue;
                      if (!paramString.equals("videoCacheClear")) {
                        break;
                      }
                      dVr();
                    }
                  }
                }
              }
            }
          }
        }
      } while (!paramString.equals("copyfile"));
      paramArrayOfString = paramArrayOfString[2];
      paramContext = l.zsu;
      l.cDx();
      paramContext = l.zsu;
      d.g.b.k.h(paramArrayOfString, "path");
      l.arb(l.dVT() + "cpfiles/");
      paramContext = new com.tencent.mm.vfs.e(paramArrayOfString);
      if (!paramContext.exists()) {
        paramContext = "";
      }
      break;
    }
    for (;;)
    {
      t.makeText(ai.getContext(), (CharSequence)"copyFile done ".concat(String.valueOf(paramContext)), 1).show();
      break label350;
      if (!paramString.equals("createFile")) {
        break;
      }
      paramContext = l.zsu;
      l.dVV();
      break label350;
      if (!paramString.equals("resetFirst")) {
        break;
      }
      paramContext = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(paramContext, "MMKernel.storage()");
      paramContext.agA().set(ah.a.GSJ, Integer.valueOf(0));
      paramContext = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(paramContext, "MMKernel.storage()");
      paramContext.agA().set(ah.a.GSK, Boolean.FALSE);
      paramContext = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(paramContext, "MMKernel.storage()");
      paramContext.agA().set(ah.a.GSL, Boolean.FALSE);
      break label350;
      if (!paramString.equals("strangerClear")) {
        break;
      }
      paramContext = j.zsh;
      paramContext = ((Iterable)j.b.dVF().dZe()).iterator();
      while (paramContext.hasNext())
      {
        paramArrayOfString = (com.tencent.mm.plugin.story.i.f)paramContext.next();
        paramString = j.zsh;
        j.b.dVF().delete((com.tencent.mm.sdk.e.c)paramArrayOfString, new String[0]);
      }
      if (!paramString.equals("commentClear")) {
        break;
      }
      dVq();
      break label350;
      if (!paramString.equals("strangerRead")) {
        break;
      }
      paramContext = j.zsh;
      paramContext = ((Iterable)j.b.dVF().dYX()).iterator();
      while (paramContext.hasNext())
      {
        paramArrayOfString = (com.tencent.mm.plugin.story.i.f)paramContext.next();
        paramArrayOfString.field_readId = paramArrayOfString.field_syncId;
        paramString = j.zsh;
        j.b.dVF().b(paramArrayOfString);
      }
      if (!paramString.equals("cleandb")) {
        break;
      }
      dVs();
      break label350;
      if (!paramString.equals("testDumpInfo")) {
        break;
      }
      paramContext = j.zsh;
      paramContext = j.b.dVI().db.rawQuery("select count(*) from StoryVideoCacheInfo", null);
      d.g.b.k.g(paramContext, "cu");
      i = paramContext.getCount();
      paramContext.close();
      paramContext = "StoryVideoCacheInfo resultData ".concat(String.valueOf(i));
      paramArrayOfString = j.zsh;
      paramArrayOfString = j.b.dVE();
      paramString = "select count(*) from " + com.tencent.mm.plugin.story.i.k.TABLE;
      paramArrayOfString = paramArrayOfString.db.rawQuery(paramString, null);
      d.g.b.k.g(paramArrayOfString, "cu");
      i = paramArrayOfString.getCount();
      paramArrayOfString.close();
      paramArrayOfString = com.tencent.mm.plugin.story.i.k.TABLE + " resultData " + i;
      ac.i("MicroMsg.StoryCommand", "info1 " + paramContext + " info2 " + paramArrayOfString);
      break label350;
      if (!paramString.equals("allmakeData")) {
        break;
      }
      M(paramArrayOfString);
      break label350;
      if (!paramString.equals("strangerDump")) {
        break;
      }
      paramContext = j.zsh;
      paramContext = ((Iterable)j.b.dVF().dYX()).iterator();
      while (paramContext.hasNext())
      {
        paramArrayOfString = (com.tencent.mm.plugin.story.i.f)paramContext.next();
        ac.i("MicroMsg.StoryCommand", "strangerDump " + paramArrayOfString.getUserName() + ' ' + paramArrayOfString.field_syncId + ' ' + paramArrayOfString.field_readId + ' ' + paramArrayOfString.field_storyPostTime + ' ' + paramArrayOfString.field_updateTime);
      }
      if (!paramString.equals("allmockData")) {
        break;
      }
      L(paramArrayOfString);
      break label350;
      paramContext = l.dVT() + "cpfiles/" + paramContext.getName();
      ac.i("MicroMsg.StoryFileNameUtil", "copy file path " + paramArrayOfString + " newPath " + paramContext);
      com.tencent.mm.vfs.i.lZ(paramArrayOfString, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.h
 * JD-Core Version:    0.7.0.1
 */