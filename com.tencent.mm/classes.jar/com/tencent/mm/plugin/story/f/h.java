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
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.i.m;
import com.tencent.mm.plugin.story.i.n;
import com.tencent.mm.plugin.story.i.o;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.protocal.protobuf.czd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.base.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/StoryCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "allUnRead", "", "allmockData", "args", "", "", "([Ljava/lang/String;)V", "cleanDb", "commentClear", "commentDump", "copyFile", "copydb", "createFiles", "delfile", "dumpDbInfo", "dumpFile", "processCommand", "", "context", "Landroid/content/Context;", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "resetFirst", "resetI2VParams", "(Landroid/content/Context;[Ljava/lang/String;)V", "rsetStoryPostThreshold", "strangerClear", "strangerDump", "strangerRead", "testMakeData", "videoCacheClear", "Companion", "plugin-story_release"})
public final class h
  implements a
{
  public static final a yeG;
  
  static
  {
    AppMethodBeat.i(118663);
    yeG = new a((byte)0);
    AppMethodBeat.o(118663);
  }
  
  private static void L(String[] paramArrayOfString)
  {
    AppMethodBeat.i(118660);
    Object localObject2 = paramArrayOfString[2];
    paramArrayOfString = j.yfh;
    paramArrayOfString = j.b.dHe().arp("foreverzeus");
    Object localObject1 = j.yfh;
    localObject1 = j.b.dHd();
    Object localObject3 = j.yfh;
    boolean bool = bt.kU(j.b.dta(), "foreverzeus");
    int i = ce.asT();
    localObject3 = i.yeK;
    localObject1 = com.tencent.mm.plugin.story.i.k.a((com.tencent.mm.plugin.story.i.k)localObject1, "foreverzeus", bool, i - i.dGU());
    if (((List)localObject1).isEmpty())
    {
      t.makeText(aj.getContext(), (CharSequence)"allmockData error1", 1).show();
      AppMethodBeat.o(118660);
      return;
    }
    localObject2 = q.rW((String)localObject2);
    if (localObject2 != null)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        Object localObject4 = j.yfh;
        localObject4 = j.b.dHe();
        d.g.b.k.g(localObject3, "it");
        localObject4 = ((com.tencent.mm.plugin.story.i.g)localObject4).arp((String)localObject3);
        i = (int)((f)localObject4).systemRowid;
        if (!((f)localObject4).isValid())
        {
          paramArrayOfString.setUserName((String)localObject3);
          paramArrayOfString.field_storyPostTime = ((int)bt.GC());
          paramArrayOfString.systemRowid = -1L;
          if (i >= 0) {
            break label299;
          }
          localObject4 = j.yfh;
          j.b.dHe().insert((com.tencent.mm.sdk.e.c)paramArrayOfString);
        }
        for (;;)
        {
          localObject4 = (com.tencent.mm.plugin.story.i.j)((List)localObject1).get(0);
          ((com.tencent.mm.plugin.story.i.j)localObject4).field_userName = ((String)localObject3);
          ((com.tencent.mm.plugin.story.i.j)localObject4).field_createTime = ce.asT();
          czd localczd = ((com.tencent.mm.plugin.story.i.j)localObject4).dKH();
          localczd.mAQ = ((String)localObject3);
          ((com.tencent.mm.plugin.story.i.j)localObject4).b(localczd);
          ((com.tencent.mm.plugin.story.i.j)localObject4).dzf = -1;
          localObject3 = j.yfh;
          j.b.dHd().insert((com.tencent.mm.sdk.e.c)localObject4);
          break;
          label299:
          localObject4 = j.yfh;
          j.b.dHe().b(i * 1L, paramArrayOfString);
        }
      }
    }
    t.makeText(aj.getContext(), (CharSequence)"allmockData done", 1).show();
    AppMethodBeat.o(118660);
  }
  
  private static void M(String[] paramArrayOfString)
  {
    AppMethodBeat.i(118661);
    int j = bt.aGh(paramArrayOfString[2]);
    ad.i("MicroMsg.StoryCommand", "testMakeData datacount ".concat(String.valueOf(j)));
    paramArrayOfString = j.yfh;
    paramArrayOfString = j.b.dHd();
    Object localObject1 = j.yfh;
    boolean bool = bt.kU(j.b.dta(), "ychengo");
    int i = ce.asT();
    localObject1 = i.yeK;
    paramArrayOfString = com.tencent.mm.plugin.story.i.k.a(paramArrayOfString, "ychengo", bool, i - i.dGU());
    i = 0;
    while (i < j)
    {
      localObject1 = (com.tencent.mm.plugin.story.i.j)paramArrayOfString.get(0);
      ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName = "ychengo";
      ((com.tencent.mm.plugin.story.i.j)localObject1).field_createTime = ce.asT();
      Object localObject2 = ((com.tencent.mm.plugin.story.i.j)localObject1).dKH();
      ((czd)localObject2).mAQ = "ychengo";
      ((com.tencent.mm.plugin.story.i.j)localObject1).b((czd)localObject2);
      ((com.tencent.mm.plugin.story.i.j)localObject1).dzf = -1;
      localObject2 = j.yfh;
      j.b.dHd().insert((com.tencent.mm.sdk.e.c)localObject1);
      i += 1;
    }
    t.makeText(aj.getContext(), (CharSequence)"testMakeData done ".concat(String.valueOf(j)), 1).show();
    AppMethodBeat.o(118661);
  }
  
  private static void dGO()
  {
    AppMethodBeat.i(118655);
    Object localObject = j.yfh;
    localObject = ((Iterable)j.b.dHg().dKw()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.story.i.c localc = (com.tencent.mm.plugin.story.i.c)((Iterator)localObject).next();
      ad.i("MicroMsg.StoryCommand", "commentDump " + localc.field_storyId + ' ' + localc.field_readCommentId + ' ' + localc.field_syncCommentId);
    }
    AppMethodBeat.o(118655);
  }
  
  private static void dGP()
  {
    AppMethodBeat.i(118656);
    Object localObject = j.yfh;
    localObject = ((Iterable)j.b.dHg().dKw()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.story.i.c localc = (com.tencent.mm.plugin.story.i.c)((Iterator)localObject).next();
      j.b localb = j.yfh;
      j.b.dHg().delete((com.tencent.mm.sdk.e.c)localc, new String[0]);
    }
    AppMethodBeat.o(118656);
  }
  
  private static void dGQ()
  {
    AppMethodBeat.i(118657);
    Object localObject1 = j.yfh;
    Object localObject2 = j.b.dHh();
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
      localObject3 = j.yfh;
      j.b.dHh().delete((com.tencent.mm.sdk.e.c)localObject2, new String[0]);
    }
    AppMethodBeat.o(118657);
  }
  
  public static void dGR()
  {
    AppMethodBeat.i(118658);
    ad.i("MicroMsg.StoryCommand", "cleanDb");
    Object localObject = j.yfh;
    j.b.dHh().dgI();
    localObject = j.yfh;
    j.b.dHe().dgI();
    localObject = j.yfh;
    j.b.dHf().dgI();
    localObject = j.yfh;
    j.b.dHd().dgI();
    localObject = j.yfh;
    com.tencent.mm.vfs.i.deleteDir(j.b.getAccStoryCachePath());
    localObject = com.tencent.mm.kernel.g.ad(PluginVideoEditor.class);
    d.g.b.k.g(localObject, "MMKernel.plugin(PluginVideoEditor::class.java)");
    ((PluginVideoEditor)localObject).getVideoEditorDataStorage().dgI();
    AppMethodBeat.o(118658);
  }
  
  public static void dGS()
  {
    AppMethodBeat.i(118659);
    Object localObject = j.yfh;
    j.b.dHd().dgI();
    localObject = j.yfh;
    j.b.dHh().dgI();
    localObject = j.yfh;
    com.tencent.mm.vfs.i.deleteDir(j.b.getAccStoryCachePath());
    localObject = j.yfh;
    localObject = ((Iterable)j.b.dHe().dKD()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      f localf = (f)((Iterator)localObject).next();
      localf.field_readId = 0L;
      localf.field_md5 = "";
      localf.field_preLoadResource = 0L;
      localf.arR("");
      localf.field_preloadStoryId = 0L;
      j.b localb = j.yfh;
      j.b.dHe().b(localf.systemRowid, localf);
    }
    ad.i("MicroMsg.StoryCommand", "allUnRead done");
    t.makeText(aj.getContext(), (CharSequence)"allUnRead Done", 1).show();
    AppMethodBeat.o(118659);
  }
  
  public static void dGT()
  {
    AppMethodBeat.i(118662);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(locale, "MMKernel.storage()");
    locale.afk().set(ae.a.FuM, Integer.valueOf(0));
    AppMethodBeat.o(118662);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(118654);
    d.g.b.k.h(paramArrayOfString, "args");
    d.g.b.k.h(paramString, "username");
    ad.i("MicroMsg.StoryCommand", d.a.e.a(paramArrayOfString, null, null, null, 0, null, null, 63));
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
          paramArrayOfString = com.tencent.mm.kernel.g.afB();
          d.g.b.k.g(paramArrayOfString, "MMKernel.storage()");
          paramContext = paramArrayOfString.aff() + "StoryMicroMsg.db";
          paramArrayOfString = new StringBuilder();
          paramString = j.yfh;
          paramArrayOfString = j.b.getAccStoryPath() + "StoryMicroMsg.db";
          com.tencent.mm.vfs.i.lC(paramContext, paramArrayOfString);
          ad.i("MicroMsg.StoryCommand", "copydb ".concat(String.valueOf(paramArrayOfString)));
          t.makeText(aj.getContext(), (CharSequence)"copydb done", 1).show();
          continue;
          if (!paramString.equals("allunread")) {
            break;
          }
          dGS();
          continue;
          if (!paramString.equals("commentDump")) {
            break;
          }
          dGO();
          continue;
          if (!paramString.equals("dumpFile")) {
            break;
          }
          paramContext = l.yfu;
          l.cse();
          continue;
          if (!paramString.equals("i2v")) {
            break;
          }
          d.g.b.k.h(paramArrayOfString, "args");
          i = bt.aGh(paramArrayOfString[2]);
          int j = bt.aGh(paramArrayOfString[3]);
          int k = bt.aGh(paramArrayOfString[4]);
          int m = bt.aGh(paramArrayOfString[5]);
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
                      paramContext = l.yfu;
                      com.tencent.mm.vfs.i.deleteDir(l.dHt());
                      continue;
                      if (!paramString.equals("videoCacheClear")) {
                        break;
                      }
                      dGQ();
                    }
                  }
                }
              }
            }
          }
        }
      } while (!paramString.equals("copyfile"));
      paramArrayOfString = paramArrayOfString[2];
      paramContext = l.yfu;
      l.cse();
      paramContext = l.yfu;
      d.g.b.k.h(paramArrayOfString, "path");
      l.alY(l.dHs() + "cpfiles/");
      paramContext = new com.tencent.mm.vfs.e(paramArrayOfString);
      if (!paramContext.exists()) {
        paramContext = "";
      }
      break;
    }
    for (;;)
    {
      t.makeText(aj.getContext(), (CharSequence)"copyFile done ".concat(String.valueOf(paramContext)), 1).show();
      break label350;
      if (!paramString.equals("createFile")) {
        break;
      }
      paramContext = l.yfu;
      l.dHu();
      break label350;
      if (!paramString.equals("resetFirst")) {
        break;
      }
      paramContext = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(paramContext, "MMKernel.storage()");
      paramContext.afk().set(ae.a.FuP, Integer.valueOf(0));
      paramContext = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(paramContext, "MMKernel.storage()");
      paramContext.afk().set(ae.a.FuQ, Boolean.FALSE);
      paramContext = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(paramContext, "MMKernel.storage()");
      paramContext.afk().set(ae.a.FuR, Boolean.FALSE);
      break label350;
      if (!paramString.equals("strangerClear")) {
        break;
      }
      paramContext = j.yfh;
      paramContext = ((Iterable)j.b.dHe().dKD()).iterator();
      while (paramContext.hasNext())
      {
        paramArrayOfString = (f)paramContext.next();
        paramString = j.yfh;
        j.b.dHe().delete((com.tencent.mm.sdk.e.c)paramArrayOfString, new String[0]);
      }
      if (!paramString.equals("commentClear")) {
        break;
      }
      dGP();
      break label350;
      if (!paramString.equals("strangerRead")) {
        break;
      }
      paramContext = j.yfh;
      paramContext = ((Iterable)j.b.dHe().dKw()).iterator();
      while (paramContext.hasNext())
      {
        paramArrayOfString = (f)paramContext.next();
        paramArrayOfString.field_readId = paramArrayOfString.field_syncId;
        paramString = j.yfh;
        j.b.dHe().b(paramArrayOfString);
      }
      if (!paramString.equals("cleandb")) {
        break;
      }
      dGR();
      break label350;
      if (!paramString.equals("testDumpInfo")) {
        break;
      }
      paramContext = j.yfh;
      paramContext = j.b.dHh().db.rawQuery("select count(*) from StoryVideoCacheInfo", null);
      d.g.b.k.g(paramContext, "cu");
      i = paramContext.getCount();
      paramContext.close();
      paramContext = "StoryVideoCacheInfo resultData ".concat(String.valueOf(i));
      paramArrayOfString = j.yfh;
      paramArrayOfString = j.b.dHd();
      paramString = "select count(*) from " + com.tencent.mm.plugin.story.i.k.TABLE;
      paramArrayOfString = paramArrayOfString.db.rawQuery(paramString, null);
      d.g.b.k.g(paramArrayOfString, "cu");
      i = paramArrayOfString.getCount();
      paramArrayOfString.close();
      paramArrayOfString = com.tencent.mm.plugin.story.i.k.TABLE + " resultData " + i;
      ad.i("MicroMsg.StoryCommand", "info1 " + paramContext + " info2 " + paramArrayOfString);
      break label350;
      if (!paramString.equals("allmakeData")) {
        break;
      }
      M(paramArrayOfString);
      break label350;
      if (!paramString.equals("strangerDump")) {
        break;
      }
      paramContext = j.yfh;
      paramContext = ((Iterable)j.b.dHe().dKw()).iterator();
      while (paramContext.hasNext())
      {
        paramArrayOfString = (f)paramContext.next();
        ad.i("MicroMsg.StoryCommand", "strangerDump " + paramArrayOfString.getUserName() + ' ' + paramArrayOfString.field_syncId + ' ' + paramArrayOfString.field_readId + ' ' + paramArrayOfString.field_storyPostTime + ' ' + paramArrayOfString.field_updateTime);
      }
      if (!paramString.equals("allmockData")) {
        break;
      }
      L(paramArrayOfString);
      break label350;
      paramContext = l.dHs() + "cpfiles/" + paramContext.getName();
      ad.i("MicroMsg.StoryFileNameUtil", "copy file path " + paramArrayOfString + " newPath " + paramContext);
      com.tencent.mm.vfs.i.lC(paramArrayOfString, paramContext);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/StoryCommand$Companion;", "", "()V", "CommandStart", "", "TAG", "TestAllMockData", "TestAllUnRead", "TestCommentClear", "TestCommentDump", "TestCopyDb", "TestCopyFile", "TestCreateFile", "TestDBClean", "TestDelFile", "TestDumpInfo", "TestDumpeFile", "TestI2V", "TestMakeData", "TestResetFirst", "TestResetI2V", "TestStrangerClear", "TestStrangerDump", "TestStrangerMarkRead", "TestVideoCacheClear", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.h
 * JD-Core Version:    0.7.0.1
 */