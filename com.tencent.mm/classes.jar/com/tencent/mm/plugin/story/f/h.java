package com.tencent.mm.plugin.story.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.recordvideo.PluginVideoEditor;
import com.tencent.mm.plugin.recordvideo.background.d;
import com.tencent.mm.plugin.story.i.b;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.i.m;
import com.tencent.mm.plugin.story.i.n;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.protocal.protobuf.dkx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.base.t;
import d.g.b.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/StoryCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "allUnRead", "", "allmockData", "args", "", "", "([Ljava/lang/String;)V", "cleanDb", "commentClear", "commentDump", "copyFile", "copydb", "createFiles", "delfile", "dumpDbInfo", "dumpFile", "processCommand", "", "context", "Landroid/content/Context;", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "resetFirst", "resetI2VParams", "(Landroid/content/Context;[Ljava/lang/String;)V", "rsetStoryPostThreshold", "strangerClear", "strangerDump", "strangerRead", "testMakeData", "videoCacheClear", "Companion", "plugin-story_release"})
public final class h
  implements a
{
  public static final h.a Bbd;
  
  static
  {
    AppMethodBeat.i(118663);
    Bbd = new h.a((byte)0);
    AppMethodBeat.o(118663);
  }
  
  private static void N(String[] paramArrayOfString)
  {
    AppMethodBeat.i(118660);
    Object localObject2 = paramArrayOfString[2];
    paramArrayOfString = j.BbE;
    paramArrayOfString = j.b.elC().aCW("foreverzeus");
    Object localObject1 = j.BbE;
    localObject1 = j.b.elB();
    Object localObject3 = j.BbE;
    boolean bool = bu.lX(j.b.dXj(), "foreverzeus");
    int i = ch.aDd();
    localObject3 = i.Bbh;
    localObject1 = com.tencent.mm.plugin.story.i.k.a((com.tencent.mm.plugin.story.i.k)localObject1, "foreverzeus", bool, i - i.els());
    if (((List)localObject1).isEmpty())
    {
      t.makeText(ak.getContext(), (CharSequence)"allmockData error1", 1).show();
      AppMethodBeat.o(118660);
      return;
    }
    localObject2 = r.zA((String)localObject2);
    if (localObject2 != null)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        Object localObject4 = j.BbE;
        localObject4 = j.b.elC();
        p.g(localObject3, "it");
        localObject4 = ((com.tencent.mm.plugin.story.i.g)localObject4).aCW((String)localObject3);
        i = (int)((f)localObject4).systemRowid;
        if (!((f)localObject4).isValid())
        {
          paramArrayOfString.setUserName((String)localObject3);
          paramArrayOfString.field_storyPostTime = ((int)bu.HQ());
          paramArrayOfString.systemRowid = -1L;
          if (i >= 0) {
            break label299;
          }
          localObject4 = j.BbE;
          j.b.elC().insert((com.tencent.mm.sdk.e.c)paramArrayOfString);
        }
        for (;;)
        {
          localObject4 = (com.tencent.mm.plugin.story.i.j)((List)localObject1).get(0);
          ((com.tencent.mm.plugin.story.i.j)localObject4).field_userName = ((String)localObject3);
          ((com.tencent.mm.plugin.story.i.j)localObject4).field_createTime = ch.aDd();
          dkx localdkx = ((com.tencent.mm.plugin.story.i.j)localObject4).epg();
          localdkx.nIJ = ((String)localObject3);
          ((com.tencent.mm.plugin.story.i.j)localObject4).b(localdkx);
          ((com.tencent.mm.plugin.story.i.j)localObject4).dKr = -1;
          localObject3 = j.BbE;
          j.b.elB().insert((com.tencent.mm.sdk.e.c)localObject4);
          break;
          label299:
          localObject4 = j.BbE;
          j.b.elC().b(i * 1L, paramArrayOfString);
        }
      }
    }
    t.makeText(ak.getContext(), (CharSequence)"allmockData done", 1).show();
    AppMethodBeat.o(118660);
  }
  
  private static void O(String[] paramArrayOfString)
  {
    AppMethodBeat.i(118661);
    int j = bu.aSB(paramArrayOfString[2]);
    ae.i("MicroMsg.StoryCommand", "testMakeData datacount ".concat(String.valueOf(j)));
    paramArrayOfString = j.BbE;
    paramArrayOfString = j.b.elB();
    Object localObject1 = j.BbE;
    boolean bool = bu.lX(j.b.dXj(), "ychengo");
    int i = ch.aDd();
    localObject1 = i.Bbh;
    paramArrayOfString = com.tencent.mm.plugin.story.i.k.a(paramArrayOfString, "ychengo", bool, i - i.els());
    i = 0;
    while (i < j)
    {
      localObject1 = (com.tencent.mm.plugin.story.i.j)paramArrayOfString.get(0);
      ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName = "ychengo";
      ((com.tencent.mm.plugin.story.i.j)localObject1).field_createTime = ch.aDd();
      Object localObject2 = ((com.tencent.mm.plugin.story.i.j)localObject1).epg();
      ((dkx)localObject2).nIJ = "ychengo";
      ((com.tencent.mm.plugin.story.i.j)localObject1).b((dkx)localObject2);
      ((com.tencent.mm.plugin.story.i.j)localObject1).dKr = -1;
      localObject2 = j.BbE;
      j.b.elB().insert((com.tencent.mm.sdk.e.c)localObject1);
      i += 1;
    }
    t.makeText(ak.getContext(), (CharSequence)"testMakeData done ".concat(String.valueOf(j)), 1).show();
    AppMethodBeat.o(118661);
  }
  
  private static void elm()
  {
    AppMethodBeat.i(118655);
    Object localObject = j.BbE;
    localObject = ((Iterable)j.b.elE().eoV()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.story.i.c localc = (com.tencent.mm.plugin.story.i.c)((Iterator)localObject).next();
      ae.i("MicroMsg.StoryCommand", "commentDump " + localc.field_storyId + ' ' + localc.field_readCommentId + ' ' + localc.field_syncCommentId);
    }
    AppMethodBeat.o(118655);
  }
  
  private static void eln()
  {
    AppMethodBeat.i(118656);
    Object localObject = j.BbE;
    localObject = ((Iterable)j.b.elE().eoV()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.story.i.c localc = (com.tencent.mm.plugin.story.i.c)((Iterator)localObject).next();
      j.b localb = j.BbE;
      j.b.elE().delete((com.tencent.mm.sdk.e.c)localc, new String[0]);
    }
    AppMethodBeat.o(118656);
  }
  
  private static void elo()
  {
    AppMethodBeat.i(118657);
    Object localObject1 = j.BbE;
    Object localObject2 = j.b.elF();
    localObject1 = new ArrayList();
    localObject2 = ((com.tencent.mm.plugin.story.i.o)localObject2).db.rawQuery("select * from StoryVideoCacheInfo", null);
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
      localObject3 = j.BbE;
      j.b.elF().delete((com.tencent.mm.sdk.e.c)localObject2, new String[0]);
    }
    AppMethodBeat.o(118657);
  }
  
  public static void elp()
  {
    AppMethodBeat.i(118658);
    ae.i("MicroMsg.StoryCommand", "cleanDb");
    Object localObject = j.BbE;
    j.b.elF().dId();
    localObject = j.BbE;
    j.b.elC().dId();
    localObject = j.BbE;
    j.b.elD().dId();
    localObject = j.BbE;
    j.b.elB().dId();
    localObject = j.BbE;
    com.tencent.mm.vfs.o.deleteDir(j.b.getAccStoryCachePath());
    localObject = com.tencent.mm.kernel.g.ad(PluginVideoEditor.class);
    p.g(localObject, "MMKernel.plugin(PluginVideoEditor::class.java)");
    ((PluginVideoEditor)localObject).getVideoEditorDataStorage().dId();
    AppMethodBeat.o(118658);
  }
  
  public static void elq()
  {
    AppMethodBeat.i(118659);
    Object localObject = j.BbE;
    j.b.elB().dId();
    localObject = j.BbE;
    j.b.elF().dId();
    localObject = j.BbE;
    com.tencent.mm.vfs.o.deleteDir(j.b.getAccStoryCachePath());
    localObject = j.BbE;
    localObject = ((Iterable)j.b.elC().epc()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      f localf = (f)((Iterator)localObject).next();
      localf.field_readId = 0L;
      localf.field_md5 = "";
      localf.field_preLoadResource = 0L;
      localf.aDx("");
      localf.field_preloadStoryId = 0L;
      j.b localb = j.BbE;
      j.b.elC().b(localf.systemRowid, localf);
    }
    ae.i("MicroMsg.StoryCommand", "allUnRead done");
    t.makeText(ak.getContext(), (CharSequence)"allUnRead Done", 1).show();
    AppMethodBeat.o(118659);
  }
  
  public static void elr()
  {
    AppMethodBeat.i(118662);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajR();
    p.g(locale, "MMKernel.storage()");
    locale.ajA().set(am.a.IZL, Integer.valueOf(0));
    AppMethodBeat.o(118662);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(118654);
    p.h(paramArrayOfString, "args");
    p.h(paramString, "username");
    ae.i("MicroMsg.StoryCommand", d.a.e.a(paramArrayOfString, null, null, null, 0, null, null, 63));
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
          paramArrayOfString = com.tencent.mm.kernel.g.ajR();
          p.g(paramArrayOfString, "MMKernel.storage()");
          paramContext = paramArrayOfString.ajw() + "StoryMicroMsg.db";
          paramArrayOfString = new StringBuilder();
          paramString = j.BbE;
          paramArrayOfString = j.b.getAccStoryPath() + "StoryMicroMsg.db";
          com.tencent.mm.vfs.o.mF(paramContext, paramArrayOfString);
          ae.i("MicroMsg.StoryCommand", "copydb ".concat(String.valueOf(paramArrayOfString)));
          t.makeText(ak.getContext(), (CharSequence)"copydb done", 1).show();
          continue;
          if (!paramString.equals("allunread")) {
            break;
          }
          elq();
          continue;
          if (!paramString.equals("commentDump")) {
            break;
          }
          elm();
          continue;
          if (!paramString.equals("dumpFile")) {
            break;
          }
          paramContext = l.BbR;
          l.cOz();
          continue;
          if (!paramString.equals("i2v")) {
            break;
          }
          p.h(paramArrayOfString, "args");
          i = bu.aSB(paramArrayOfString[2]);
          int j = bu.aSB(paramArrayOfString[3]);
          int k = bu.aSB(paramArrayOfString[4]);
          int m = bu.aSB(paramArrayOfString[5]);
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
                      paramContext = l.BbR;
                      com.tencent.mm.vfs.o.deleteDir(l.elR());
                      continue;
                      if (!paramString.equals("videoCacheClear")) {
                        break;
                      }
                      elo();
                    }
                  }
                }
              }
            }
          }
        }
      } while (!paramString.equals("copyfile"));
      paramArrayOfString = paramArrayOfString[2];
      paramContext = l.BbR;
      l.cOz();
      paramContext = l.BbR;
      p.h(paramArrayOfString, "path");
      l.axq(l.elQ() + "cpfiles/");
      paramContext = new com.tencent.mm.vfs.k(paramArrayOfString);
      if (!paramContext.exists()) {
        paramContext = "";
      }
      break;
    }
    for (;;)
    {
      t.makeText(ak.getContext(), (CharSequence)"copyFile done ".concat(String.valueOf(paramContext)), 1).show();
      break label350;
      if (!paramString.equals("createFile")) {
        break;
      }
      paramContext = l.BbR;
      l.elS();
      break label350;
      if (!paramString.equals("resetFirst")) {
        break;
      }
      paramContext = com.tencent.mm.kernel.g.ajR();
      p.g(paramContext, "MMKernel.storage()");
      paramContext.ajA().set(am.a.IZO, Integer.valueOf(0));
      paramContext = com.tencent.mm.kernel.g.ajR();
      p.g(paramContext, "MMKernel.storage()");
      paramContext.ajA().set(am.a.IZP, Boolean.FALSE);
      paramContext = com.tencent.mm.kernel.g.ajR();
      p.g(paramContext, "MMKernel.storage()");
      paramContext.ajA().set(am.a.IZQ, Boolean.FALSE);
      break label350;
      if (!paramString.equals("strangerClear")) {
        break;
      }
      paramContext = j.BbE;
      paramContext = ((Iterable)j.b.elC().epc()).iterator();
      while (paramContext.hasNext())
      {
        paramArrayOfString = (f)paramContext.next();
        paramString = j.BbE;
        j.b.elC().delete((com.tencent.mm.sdk.e.c)paramArrayOfString, new String[0]);
      }
      if (!paramString.equals("commentClear")) {
        break;
      }
      eln();
      break label350;
      if (!paramString.equals("strangerRead")) {
        break;
      }
      paramContext = j.BbE;
      paramContext = ((Iterable)j.b.elC().eoV()).iterator();
      while (paramContext.hasNext())
      {
        paramArrayOfString = (f)paramContext.next();
        paramArrayOfString.field_readId = paramArrayOfString.field_syncId;
        paramString = j.BbE;
        j.b.elC().b(paramArrayOfString);
      }
      if (!paramString.equals("cleandb")) {
        break;
      }
      elp();
      break label350;
      if (!paramString.equals("testDumpInfo")) {
        break;
      }
      paramContext = j.BbE;
      paramContext = j.b.elF().db.rawQuery("select count(*) from StoryVideoCacheInfo", null);
      p.g(paramContext, "cu");
      i = paramContext.getCount();
      paramContext.close();
      paramContext = "StoryVideoCacheInfo resultData ".concat(String.valueOf(i));
      paramArrayOfString = j.BbE;
      paramArrayOfString = j.b.elB();
      paramString = "select count(*) from " + com.tencent.mm.plugin.story.i.k.TABLE;
      paramArrayOfString = paramArrayOfString.db.rawQuery(paramString, null);
      p.g(paramArrayOfString, "cu");
      i = paramArrayOfString.getCount();
      paramArrayOfString.close();
      paramArrayOfString = com.tencent.mm.plugin.story.i.k.TABLE + " resultData " + i;
      ae.i("MicroMsg.StoryCommand", "info1 " + paramContext + " info2 " + paramArrayOfString);
      break label350;
      if (!paramString.equals("allmakeData")) {
        break;
      }
      O(paramArrayOfString);
      break label350;
      if (!paramString.equals("strangerDump")) {
        break;
      }
      paramContext = j.BbE;
      paramContext = ((Iterable)j.b.elC().eoV()).iterator();
      while (paramContext.hasNext())
      {
        paramArrayOfString = (f)paramContext.next();
        ae.i("MicroMsg.StoryCommand", "strangerDump " + paramArrayOfString.getUserName() + ' ' + paramArrayOfString.field_syncId + ' ' + paramArrayOfString.field_readId + ' ' + paramArrayOfString.field_storyPostTime + ' ' + paramArrayOfString.field_updateTime);
      }
      if (!paramString.equals("allmockData")) {
        break;
      }
      N(paramArrayOfString);
      break label350;
      paramContext = l.elQ() + "cpfiles/" + paramContext.getName();
      ae.i("MicroMsg.StoryFileNameUtil", "copy file path " + paramArrayOfString + " newPath " + paramContext);
      com.tencent.mm.vfs.o.mF(paramArrayOfString, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.h
 * JD-Core Version:    0.7.0.1
 */