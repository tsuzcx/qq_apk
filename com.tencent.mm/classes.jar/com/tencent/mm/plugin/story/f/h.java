package com.tencent.mm.plugin.story.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.recordvideo.PluginVideoEditor;
import com.tencent.mm.plugin.recordvideo.background.d;
import com.tencent.mm.plugin.story.i.b;
import com.tencent.mm.plugin.story.i.c;
import com.tencent.mm.plugin.story.i.g;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.plugin.story.i.m;
import com.tencent.mm.plugin.story.i.n;
import com.tencent.mm.plugin.story.i.o;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.protocal.protobuf.eol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.e;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/StoryCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "allUnRead", "", "allmockData", "args", "", "", "([Ljava/lang/String;)V", "cleanDb", "commentClear", "commentDump", "copyFile", "copydb", "createFiles", "delfile", "dumpDbInfo", "dumpFile", "processCommand", "", "context", "Landroid/content/Context;", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "resetFirst", "resetI2VParams", "(Landroid/content/Context;[Ljava/lang/String;)V", "rsetStoryPostThreshold", "strangerClear", "strangerDump", "strangerRead", "testMakeData", "videoCacheClear", "Companion", "plugin-story_release"})
public final class h
  implements a
{
  public static final a LFZ;
  
  static
  {
    AppMethodBeat.i(118663);
    LFZ = new a((byte)0);
    AppMethodBeat.o(118663);
  }
  
  private static void R(String[] paramArrayOfString)
  {
    AppMethodBeat.i(118660);
    Object localObject2 = paramArrayOfString[2];
    paramArrayOfString = j.LGA;
    paramArrayOfString = j.b.gcx().bcW("foreverzeus");
    Object localObject1 = j.LGA;
    localObject1 = j.b.gcw();
    Object localObject3 = j.LGA;
    boolean bool = Util.isEqual(j.b.fOo(), "foreverzeus");
    int i = cm.bfF();
    localObject3 = i.LGd;
    localObject1 = k.a((k)localObject1, "foreverzeus", bool, i - i.gcn());
    if (((List)localObject1).isEmpty())
    {
      w.makeText(MMApplicationContext.getContext(), (CharSequence)"allmockData error1", 1).show();
      AppMethodBeat.o(118660);
      return;
    }
    localObject2 = v.Ps((String)localObject2);
    if (localObject2 != null)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        Object localObject4 = j.LGA;
        localObject4 = j.b.gcx();
        p.j(localObject3, "it");
        localObject4 = ((g)localObject4).bcW((String)localObject3);
        i = (int)((com.tencent.mm.plugin.story.i.f)localObject4).systemRowid;
        if (!((com.tencent.mm.plugin.story.i.f)localObject4).isValid())
        {
          paramArrayOfString.setUserName((String)localObject3);
          paramArrayOfString.field_storyPostTime = ((int)Util.currentTicks());
          paramArrayOfString.systemRowid = -1L;
          if (i >= 0) {
            break label299;
          }
          localObject4 = j.LGA;
          j.b.gcx().insert((IAutoDBItem)paramArrayOfString);
        }
        for (;;)
        {
          localObject4 = (com.tencent.mm.plugin.story.i.j)((List)localObject1).get(0);
          ((com.tencent.mm.plugin.story.i.j)localObject4).field_userName = ((String)localObject3);
          ((com.tencent.mm.plugin.story.i.j)localObject4).field_createTime = cm.bfF();
          eol localeol = ((com.tencent.mm.plugin.story.i.j)localObject4).ggc();
          localeol.UserName = ((String)localObject3);
          ((com.tencent.mm.plugin.story.i.j)localObject4).b(localeol);
          ((com.tencent.mm.plugin.story.i.j)localObject4).fWh = -1;
          localObject3 = j.LGA;
          j.b.gcw().insert((IAutoDBItem)localObject4);
          break;
          label299:
          localObject4 = j.LGA;
          j.b.gcx().b(i * 1L, paramArrayOfString);
        }
      }
    }
    w.makeText(MMApplicationContext.getContext(), (CharSequence)"allmockData done", 1).show();
    AppMethodBeat.o(118660);
  }
  
  private static void S(String[] paramArrayOfString)
  {
    AppMethodBeat.i(118661);
    int j = Util.safeParseInt(paramArrayOfString[2]);
    Log.i("MicroMsg.StoryCommand", "testMakeData datacount ".concat(String.valueOf(j)));
    paramArrayOfString = j.LGA;
    paramArrayOfString = j.b.gcw();
    Object localObject1 = j.LGA;
    boolean bool = Util.isEqual(j.b.fOo(), "ychengo");
    int i = cm.bfF();
    localObject1 = i.LGd;
    paramArrayOfString = k.a(paramArrayOfString, "ychengo", bool, i - i.gcn());
    i = 0;
    while (i < j)
    {
      localObject1 = (com.tencent.mm.plugin.story.i.j)paramArrayOfString.get(0);
      ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName = "ychengo";
      ((com.tencent.mm.plugin.story.i.j)localObject1).field_createTime = cm.bfF();
      Object localObject2 = ((com.tencent.mm.plugin.story.i.j)localObject1).ggc();
      ((eol)localObject2).UserName = "ychengo";
      ((com.tencent.mm.plugin.story.i.j)localObject1).b((eol)localObject2);
      ((com.tencent.mm.plugin.story.i.j)localObject1).fWh = -1;
      localObject2 = j.LGA;
      j.b.gcw().insert((IAutoDBItem)localObject1);
      i += 1;
    }
    w.makeText(MMApplicationContext.getContext(), (CharSequence)"testMakeData done ".concat(String.valueOf(j)), 1).show();
    AppMethodBeat.o(118661);
  }
  
  private static void gch()
  {
    AppMethodBeat.i(118655);
    Object localObject = j.LGA;
    localObject = ((Iterable)j.b.gcz().gfR()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      c localc = (c)((Iterator)localObject).next();
      Log.i("MicroMsg.StoryCommand", "commentDump " + localc.field_storyId + ' ' + localc.field_readCommentId + ' ' + localc.field_syncCommentId);
    }
    AppMethodBeat.o(118655);
  }
  
  private static void gci()
  {
    AppMethodBeat.i(118656);
    Object localObject = j.LGA;
    localObject = ((Iterable)j.b.gcz().gfR()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      c localc = (c)((Iterator)localObject).next();
      j.b localb = j.LGA;
      j.b.gcz().delete((IAutoDBItem)localc, new String[0]);
    }
    AppMethodBeat.o(118656);
  }
  
  private static void gcj()
  {
    AppMethodBeat.i(118657);
    Object localObject1 = j.LGA;
    Object localObject2 = j.b.gcA();
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
      localObject3 = j.LGA;
      j.b.gcA().delete((IAutoDBItem)localObject2, new String[0]);
    }
    AppMethodBeat.o(118657);
  }
  
  public static void gck()
  {
    AppMethodBeat.i(118658);
    Log.i("MicroMsg.StoryCommand", "cleanDb");
    Object localObject = j.LGA;
    j.b.gcA().fuU();
    localObject = j.LGA;
    j.b.gcx().fuU();
    localObject = j.LGA;
    j.b.gcy().fuU();
    localObject = j.LGA;
    j.b.gcw().fuU();
    localObject = j.LGA;
    u.deleteDir(j.b.getAccStoryCachePath());
    localObject = com.tencent.mm.kernel.h.ag(PluginVideoEditor.class);
    p.j(localObject, "MMKernel.plugin(PluginVideoEditor::class.java)");
    ((PluginVideoEditor)localObject).getVideoEditorDataStorage().fuU();
    AppMethodBeat.o(118658);
  }
  
  public static void gcl()
  {
    AppMethodBeat.i(118659);
    Object localObject = j.LGA;
    j.b.gcw().fuU();
    localObject = j.LGA;
    j.b.gcA().fuU();
    localObject = j.LGA;
    u.deleteDir(j.b.getAccStoryCachePath());
    localObject = j.LGA;
    localObject = ((Iterable)j.b.gcx().gfY()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.story.i.f localf = (com.tencent.mm.plugin.story.i.f)((Iterator)localObject).next();
      localf.field_readId = 0L;
      localf.field_md5 = "";
      localf.field_preLoadResource = 0L;
      localf.bdw("");
      localf.field_preloadStoryId = 0L;
      j.b localb = j.LGA;
      j.b.gcx().b(localf.systemRowid, localf);
    }
    Log.i("MicroMsg.StoryCommand", "allUnRead done");
    w.makeText(MMApplicationContext.getContext(), (CharSequence)"allUnRead Done", 1).show();
    AppMethodBeat.o(118659);
  }
  
  public static void gcm()
  {
    AppMethodBeat.i(118662);
    com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.VwH, Integer.valueOf(0));
    AppMethodBeat.o(118662);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(118654);
    p.k(paramArrayOfString, "args");
    p.k(paramString, "username");
    Log.i("MicroMsg.StoryCommand", e.a(paramArrayOfString, null, null, null, 0, null, null, 63));
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
          paramArrayOfString = com.tencent.mm.kernel.h.aHG();
          p.j(paramArrayOfString, "MMKernel.storage()");
          paramContext = paramArrayOfString.aHl() + "StoryMicroMsg.db";
          paramArrayOfString = new StringBuilder();
          paramString = j.LGA;
          paramArrayOfString = j.b.getAccStoryPath() + "StoryMicroMsg.db";
          u.on(paramContext, paramArrayOfString);
          Log.i("MicroMsg.StoryCommand", "copydb ".concat(String.valueOf(paramArrayOfString)));
          w.makeText(MMApplicationContext.getContext(), (CharSequence)"copydb done", 1).show();
          continue;
          if (!paramString.equals("allunread")) {
            break;
          }
          gcl();
          continue;
          if (!paramString.equals("commentDump")) {
            break;
          }
          gch();
          continue;
          if (!paramString.equals("dumpFile")) {
            break;
          }
          paramContext = l.LGM;
          l.gcN();
          continue;
          if (!paramString.equals("i2v")) {
            break;
          }
          p.k(paramArrayOfString, "args");
          i = Util.safeParseInt(paramArrayOfString[2]);
          int j = Util.safeParseInt(paramArrayOfString[3]);
          int k = Util.safeParseInt(paramArrayOfString[4]);
          int m = Util.safeParseInt(paramArrayOfString[5]);
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
                      paramContext = l.LGM;
                      u.deleteDir(l.gcM());
                      continue;
                      if (!paramString.equals("videoCacheClear")) {
                        break;
                      }
                      gcj();
                    }
                  }
                }
              }
            }
          }
        }
      } while (!paramString.equals("copyfile"));
      paramArrayOfString = paramArrayOfString[2];
      paramContext = l.LGM;
      l.gcN();
      paramContext = l.LGM;
      p.k(paramArrayOfString, "path");
      l.aWs(l.gcL() + "cpfiles/");
      paramContext = new q(paramArrayOfString);
      if (!paramContext.ifE()) {
        paramContext = "";
      }
      break;
    }
    for (;;)
    {
      w.makeText(MMApplicationContext.getContext(), (CharSequence)"copyFile done ".concat(String.valueOf(paramContext)), 1).show();
      break label350;
      if (!paramString.equals("createFile")) {
        break;
      }
      paramContext = l.LGM;
      l.gcO();
      break label350;
      if (!paramString.equals("resetFirst")) {
        break;
      }
      paramContext = com.tencent.mm.kernel.h.aHG();
      p.j(paramContext, "MMKernel.storage()");
      paramContext.aHp().set(ar.a.VwK, Integer.valueOf(0));
      paramContext = com.tencent.mm.kernel.h.aHG();
      p.j(paramContext, "MMKernel.storage()");
      paramContext.aHp().set(ar.a.VwL, Boolean.FALSE);
      paramContext = com.tencent.mm.kernel.h.aHG();
      p.j(paramContext, "MMKernel.storage()");
      paramContext.aHp().set(ar.a.VwM, Boolean.FALSE);
      break label350;
      if (!paramString.equals("strangerClear")) {
        break;
      }
      paramContext = j.LGA;
      paramContext = ((Iterable)j.b.gcx().gfY()).iterator();
      while (paramContext.hasNext())
      {
        paramArrayOfString = (com.tencent.mm.plugin.story.i.f)paramContext.next();
        paramString = j.LGA;
        j.b.gcx().delete((IAutoDBItem)paramArrayOfString, new String[0]);
      }
      if (!paramString.equals("commentClear")) {
        break;
      }
      gci();
      break label350;
      if (!paramString.equals("strangerRead")) {
        break;
      }
      paramContext = j.LGA;
      paramContext = ((Iterable)j.b.gcx().gfR()).iterator();
      while (paramContext.hasNext())
      {
        paramArrayOfString = (com.tencent.mm.plugin.story.i.f)paramContext.next();
        paramArrayOfString.field_readId = paramArrayOfString.field_syncId;
        paramString = j.LGA;
        j.b.gcx().b(paramArrayOfString);
      }
      if (!paramString.equals("cleandb")) {
        break;
      }
      gck();
      break label350;
      if (!paramString.equals("testDumpInfo")) {
        break;
      }
      paramContext = j.LGA;
      paramContext = j.b.gcA().db.rawQuery("select count(*) from StoryVideoCacheInfo", null);
      p.j(paramContext, "cu");
      i = paramContext.getCount();
      paramContext.close();
      paramContext = "StoryVideoCacheInfo resultData ".concat(String.valueOf(i));
      paramArrayOfString = j.LGA;
      paramArrayOfString = j.b.gcw();
      paramString = "select count(*) from " + k.Alf;
      paramArrayOfString = paramArrayOfString.db.rawQuery(paramString, null);
      p.j(paramArrayOfString, "cu");
      i = paramArrayOfString.getCount();
      paramArrayOfString.close();
      paramArrayOfString = k.Alf + " resultData " + i;
      Log.i("MicroMsg.StoryCommand", "info1 " + paramContext + " info2 " + paramArrayOfString);
      break label350;
      if (!paramString.equals("allmakeData")) {
        break;
      }
      S(paramArrayOfString);
      break label350;
      if (!paramString.equals("strangerDump")) {
        break;
      }
      paramContext = j.LGA;
      paramContext = ((Iterable)j.b.gcx().gfR()).iterator();
      while (paramContext.hasNext())
      {
        paramArrayOfString = (com.tencent.mm.plugin.story.i.f)paramContext.next();
        Log.i("MicroMsg.StoryCommand", "strangerDump " + paramArrayOfString.getUserName() + ' ' + paramArrayOfString.field_syncId + ' ' + paramArrayOfString.field_readId + ' ' + paramArrayOfString.field_storyPostTime + ' ' + paramArrayOfString.field_updateTime);
      }
      if (!paramString.equals("allmockData")) {
        break;
      }
      R(paramArrayOfString);
      break label350;
      paramContext = l.gcL() + "cpfiles/" + paramContext.getName();
      Log.i("MicroMsg.StoryFileNameUtil", "copy file path " + paramArrayOfString + " newPath " + paramContext);
      u.on(paramArrayOfString, paramContext);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/StoryCommand$Companion;", "", "()V", "CommandStart", "", "TAG", "TestAllMockData", "TestAllUnRead", "TestCommentClear", "TestCommentDump", "TestCopyDb", "TestCopyFile", "TestCreateFile", "TestDBClean", "TestDelFile", "TestDumpInfo", "TestDumpeFile", "TestI2V", "TestMakeData", "TestResetFirst", "TestResetI2V", "TestStrangerClear", "TestStrangerDump", "TestStrangerMarkRead", "TestVideoCacheClear", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.h
 * JD-Core Version:    0.7.0.1
 */