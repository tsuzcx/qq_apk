package com.tencent.mm.plugin.story.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.recordvideo.PluginVideoEditor;
import com.tencent.mm.plugin.recordvideo.background.d;
import com.tencent.mm.plugin.story.i.b;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.plugin.story.i.m;
import com.tencent.mm.plugin.story.i.n;
import com.tencent.mm.plugin.story.i.o;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.protocal.protobuf.dkc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.base.t;
import d.g.b.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/StoryCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "allUnRead", "", "allmockData", "args", "", "", "([Ljava/lang/String;)V", "cleanDb", "commentClear", "commentDump", "copyFile", "copydb", "createFiles", "delfile", "dumpDbInfo", "dumpFile", "processCommand", "", "context", "Landroid/content/Context;", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "resetFirst", "resetI2VParams", "(Landroid/content/Context;[Ljava/lang/String;)V", "rsetStoryPostThreshold", "strangerClear", "strangerDump", "strangerRead", "testMakeData", "videoCacheClear", "Companion", "plugin-story_release"})
public final class h
  implements a
{
  public static final h.a AJA;
  
  static
  {
    AppMethodBeat.i(118663);
    AJA = new h.a((byte)0);
    AppMethodBeat.o(118663);
  }
  
  private static void N(String[] paramArrayOfString)
  {
    AppMethodBeat.i(118660);
    Object localObject2 = paramArrayOfString[2];
    paramArrayOfString = j.AKb;
    paramArrayOfString = j.b.ehU().aBD("foreverzeus");
    Object localObject1 = j.AKb;
    localObject1 = j.b.ehT();
    Object localObject3 = j.AKb;
    boolean bool = bt.lQ(j.b.dTJ(), "foreverzeus");
    int i = cf.aCN();
    localObject3 = i.AJE;
    localObject1 = k.a((k)localObject1, "foreverzeus", bool, i - i.ehK());
    if (((List)localObject1).isEmpty())
    {
      t.makeText(aj.getContext(), (CharSequence)"allmockData error1", 1).show();
      AppMethodBeat.o(118660);
      return;
    }
    localObject2 = q.yQ((String)localObject2);
    if (localObject2 != null)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        Object localObject4 = j.AKb;
        localObject4 = j.b.ehU();
        p.g(localObject3, "it");
        localObject4 = ((com.tencent.mm.plugin.story.i.g)localObject4).aBD((String)localObject3);
        i = (int)((f)localObject4).systemRowid;
        if (!((f)localObject4).isValid())
        {
          paramArrayOfString.setUserName((String)localObject3);
          paramArrayOfString.field_storyPostTime = ((int)bt.HI());
          paramArrayOfString.systemRowid = -1L;
          if (i >= 0) {
            break label299;
          }
          localObject4 = j.AKb;
          j.b.ehU().insert((com.tencent.mm.sdk.e.c)paramArrayOfString);
        }
        for (;;)
        {
          localObject4 = (com.tencent.mm.plugin.story.i.j)((List)localObject1).get(0);
          ((com.tencent.mm.plugin.story.i.j)localObject4).field_userName = ((String)localObject3);
          ((com.tencent.mm.plugin.story.i.j)localObject4).field_createTime = cf.aCN();
          dkc localdkc = ((com.tencent.mm.plugin.story.i.j)localObject4).elx();
          localdkc.nDo = ((String)localObject3);
          ((com.tencent.mm.plugin.story.i.j)localObject4).b(localdkc);
          ((com.tencent.mm.plugin.story.i.j)localObject4).dJd = -1;
          localObject3 = j.AKb;
          j.b.ehT().insert((com.tencent.mm.sdk.e.c)localObject4);
          break;
          label299:
          localObject4 = j.AKb;
          j.b.ehU().b(i * 1L, paramArrayOfString);
        }
      }
    }
    t.makeText(aj.getContext(), (CharSequence)"allmockData done", 1).show();
    AppMethodBeat.o(118660);
  }
  
  private static void O(String[] paramArrayOfString)
  {
    AppMethodBeat.i(118661);
    int j = bt.aRe(paramArrayOfString[2]);
    ad.i("MicroMsg.StoryCommand", "testMakeData datacount ".concat(String.valueOf(j)));
    paramArrayOfString = j.AKb;
    paramArrayOfString = j.b.ehT();
    Object localObject1 = j.AKb;
    boolean bool = bt.lQ(j.b.dTJ(), "ychengo");
    int i = cf.aCN();
    localObject1 = i.AJE;
    paramArrayOfString = k.a(paramArrayOfString, "ychengo", bool, i - i.ehK());
    i = 0;
    while (i < j)
    {
      localObject1 = (com.tencent.mm.plugin.story.i.j)paramArrayOfString.get(0);
      ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName = "ychengo";
      ((com.tencent.mm.plugin.story.i.j)localObject1).field_createTime = cf.aCN();
      Object localObject2 = ((com.tencent.mm.plugin.story.i.j)localObject1).elx();
      ((dkc)localObject2).nDo = "ychengo";
      ((com.tencent.mm.plugin.story.i.j)localObject1).b((dkc)localObject2);
      ((com.tencent.mm.plugin.story.i.j)localObject1).dJd = -1;
      localObject2 = j.AKb;
      j.b.ehT().insert((com.tencent.mm.sdk.e.c)localObject1);
      i += 1;
    }
    t.makeText(aj.getContext(), (CharSequence)"testMakeData done ".concat(String.valueOf(j)), 1).show();
    AppMethodBeat.o(118661);
  }
  
  private static void ehE()
  {
    AppMethodBeat.i(118655);
    Object localObject = j.AKb;
    localObject = ((Iterable)j.b.ehW().elm()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.story.i.c localc = (com.tencent.mm.plugin.story.i.c)((Iterator)localObject).next();
      ad.i("MicroMsg.StoryCommand", "commentDump " + localc.field_storyId + ' ' + localc.field_readCommentId + ' ' + localc.field_syncCommentId);
    }
    AppMethodBeat.o(118655);
  }
  
  private static void ehF()
  {
    AppMethodBeat.i(118656);
    Object localObject = j.AKb;
    localObject = ((Iterable)j.b.ehW().elm()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.story.i.c localc = (com.tencent.mm.plugin.story.i.c)((Iterator)localObject).next();
      j.b localb = j.AKb;
      j.b.ehW().delete((com.tencent.mm.sdk.e.c)localc, new String[0]);
    }
    AppMethodBeat.o(118656);
  }
  
  private static void ehG()
  {
    AppMethodBeat.i(118657);
    Object localObject1 = j.AKb;
    Object localObject2 = j.b.ehX();
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
      localObject3 = j.AKb;
      j.b.ehX().delete((com.tencent.mm.sdk.e.c)localObject2, new String[0]);
    }
    AppMethodBeat.o(118657);
  }
  
  public static void ehH()
  {
    AppMethodBeat.i(118658);
    ad.i("MicroMsg.StoryCommand", "cleanDb");
    Object localObject = j.AKb;
    j.b.ehX().dEM();
    localObject = j.AKb;
    j.b.ehU().dEM();
    localObject = j.AKb;
    j.b.ehV().dEM();
    localObject = j.AKb;
    j.b.ehT().dEM();
    localObject = j.AKb;
    com.tencent.mm.vfs.i.deleteDir(j.b.getAccStoryCachePath());
    localObject = com.tencent.mm.kernel.g.ad(PluginVideoEditor.class);
    p.g(localObject, "MMKernel.plugin(PluginVideoEditor::class.java)");
    ((PluginVideoEditor)localObject).getVideoEditorDataStorage().dEM();
    AppMethodBeat.o(118658);
  }
  
  public static void ehI()
  {
    AppMethodBeat.i(118659);
    Object localObject = j.AKb;
    j.b.ehT().dEM();
    localObject = j.AKb;
    j.b.ehX().dEM();
    localObject = j.AKb;
    com.tencent.mm.vfs.i.deleteDir(j.b.getAccStoryCachePath());
    localObject = j.AKb;
    localObject = ((Iterable)j.b.ehU().elt()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      f localf = (f)((Iterator)localObject).next();
      localf.field_readId = 0L;
      localf.field_md5 = "";
      localf.field_preLoadResource = 0L;
      localf.aCe("");
      localf.field_preloadStoryId = 0L;
      j.b localb = j.AKb;
      j.b.ehU().b(localf.systemRowid, localf);
    }
    ad.i("MicroMsg.StoryCommand", "allUnRead done");
    t.makeText(aj.getContext(), (CharSequence)"allUnRead Done", 1).show();
    AppMethodBeat.o(118659);
  }
  
  public static void ehJ()
  {
    AppMethodBeat.i(118662);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajC();
    p.g(locale, "MMKernel.storage()");
    locale.ajl().set(al.a.IFl, Integer.valueOf(0));
    AppMethodBeat.o(118662);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(118654);
    p.h(paramArrayOfString, "args");
    p.h(paramString, "username");
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
          paramArrayOfString = com.tencent.mm.kernel.g.ajC();
          p.g(paramArrayOfString, "MMKernel.storage()");
          paramContext = paramArrayOfString.ajh() + "StoryMicroMsg.db";
          paramArrayOfString = new StringBuilder();
          paramString = j.AKb;
          paramArrayOfString = j.b.getAccStoryPath() + "StoryMicroMsg.db";
          com.tencent.mm.vfs.i.mz(paramContext, paramArrayOfString);
          ad.i("MicroMsg.StoryCommand", "copydb ".concat(String.valueOf(paramArrayOfString)));
          t.makeText(aj.getContext(), (CharSequence)"copydb done", 1).show();
          continue;
          if (!paramString.equals("allunread")) {
            break;
          }
          ehI();
          continue;
          if (!paramString.equals("commentDump")) {
            break;
          }
          ehE();
          continue;
          if (!paramString.equals("dumpFile")) {
            break;
          }
          paramContext = l.AKo;
          l.cLR();
          continue;
          if (!paramString.equals("i2v")) {
            break;
          }
          p.h(paramArrayOfString, "args");
          i = bt.aRe(paramArrayOfString[2]);
          int j = bt.aRe(paramArrayOfString[3]);
          int k = bt.aRe(paramArrayOfString[4]);
          int m = bt.aRe(paramArrayOfString[5]);
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
                      paramContext = l.AKo;
                      com.tencent.mm.vfs.i.deleteDir(l.eij());
                      continue;
                      if (!paramString.equals("videoCacheClear")) {
                        break;
                      }
                      ehG();
                    }
                  }
                }
              }
            }
          }
        }
      } while (!paramString.equals("copyfile"));
      paramArrayOfString = paramArrayOfString[2];
      paramContext = l.AKo;
      l.cLR();
      paramContext = l.AKo;
      p.h(paramArrayOfString, "path");
      l.awb(l.eii() + "cpfiles/");
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
      paramContext = l.AKo;
      l.eik();
      break label350;
      if (!paramString.equals("resetFirst")) {
        break;
      }
      paramContext = com.tencent.mm.kernel.g.ajC();
      p.g(paramContext, "MMKernel.storage()");
      paramContext.ajl().set(al.a.IFo, Integer.valueOf(0));
      paramContext = com.tencent.mm.kernel.g.ajC();
      p.g(paramContext, "MMKernel.storage()");
      paramContext.ajl().set(al.a.IFp, Boolean.FALSE);
      paramContext = com.tencent.mm.kernel.g.ajC();
      p.g(paramContext, "MMKernel.storage()");
      paramContext.ajl().set(al.a.IFq, Boolean.FALSE);
      break label350;
      if (!paramString.equals("strangerClear")) {
        break;
      }
      paramContext = j.AKb;
      paramContext = ((Iterable)j.b.ehU().elt()).iterator();
      while (paramContext.hasNext())
      {
        paramArrayOfString = (f)paramContext.next();
        paramString = j.AKb;
        j.b.ehU().delete((com.tencent.mm.sdk.e.c)paramArrayOfString, new String[0]);
      }
      if (!paramString.equals("commentClear")) {
        break;
      }
      ehF();
      break label350;
      if (!paramString.equals("strangerRead")) {
        break;
      }
      paramContext = j.AKb;
      paramContext = ((Iterable)j.b.ehU().elm()).iterator();
      while (paramContext.hasNext())
      {
        paramArrayOfString = (f)paramContext.next();
        paramArrayOfString.field_readId = paramArrayOfString.field_syncId;
        paramString = j.AKb;
        j.b.ehU().b(paramArrayOfString);
      }
      if (!paramString.equals("cleandb")) {
        break;
      }
      ehH();
      break label350;
      if (!paramString.equals("testDumpInfo")) {
        break;
      }
      paramContext = j.AKb;
      paramContext = j.b.ehX().db.rawQuery("select count(*) from StoryVideoCacheInfo", null);
      p.g(paramContext, "cu");
      i = paramContext.getCount();
      paramContext.close();
      paramContext = "StoryVideoCacheInfo resultData ".concat(String.valueOf(i));
      paramArrayOfString = j.AKb;
      paramArrayOfString = j.b.ehT();
      paramString = "select count(*) from " + k.TABLE;
      paramArrayOfString = paramArrayOfString.db.rawQuery(paramString, null);
      p.g(paramArrayOfString, "cu");
      i = paramArrayOfString.getCount();
      paramArrayOfString.close();
      paramArrayOfString = k.TABLE + " resultData " + i;
      ad.i("MicroMsg.StoryCommand", "info1 " + paramContext + " info2 " + paramArrayOfString);
      break label350;
      if (!paramString.equals("allmakeData")) {
        break;
      }
      O(paramArrayOfString);
      break label350;
      if (!paramString.equals("strangerDump")) {
        break;
      }
      paramContext = j.AKb;
      paramContext = ((Iterable)j.b.ehU().elm()).iterator();
      while (paramContext.hasNext())
      {
        paramArrayOfString = (f)paramContext.next();
        ad.i("MicroMsg.StoryCommand", "strangerDump " + paramArrayOfString.getUserName() + ' ' + paramArrayOfString.field_syncId + ' ' + paramArrayOfString.field_readId + ' ' + paramArrayOfString.field_storyPostTime + ' ' + paramArrayOfString.field_updateTime);
      }
      if (!paramString.equals("allmockData")) {
        break;
      }
      N(paramArrayOfString);
      break label350;
      paramContext = l.eii() + "cpfiles/" + paramContext.getName();
      ad.i("MicroMsg.StoryFileNameUtil", "copy file path " + paramArrayOfString + " newPath " + paramContext);
      com.tencent.mm.vfs.i.mz(paramArrayOfString, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.h
 * JD-Core Version:    0.7.0.1
 */