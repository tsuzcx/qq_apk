package com.tencent.mm.plugin.story.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.recordvideo.PluginVideoEditor;
import com.tencent.mm.plugin.recordvideo.background.d;
import com.tencent.mm.plugin.story.i.b;
import com.tencent.mm.plugin.story.i.c;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.plugin.story.i.m;
import com.tencent.mm.plugin.story.i.n;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/StoryCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "allUnRead", "", "allmockData", "args", "", "", "([Ljava/lang/String;)V", "cleanDb", "commentClear", "commentDump", "copyFile", "copydb", "createFiles", "delfile", "dumpDbInfo", "dumpFile", "processCommand", "", "context", "Landroid/content/Context;", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "resetFirst", "resetI2VParams", "(Landroid/content/Context;[Ljava/lang/String;)V", "rsetStoryPostThreshold", "strangerClear", "strangerDump", "strangerRead", "testMakeData", "videoCacheClear", "Companion", "plugin-story_release"})
public final class h
  implements a
{
  public static final a FlX;
  
  static
  {
    AppMethodBeat.i(118663);
    FlX = new a((byte)0);
    AppMethodBeat.o(118663);
  }
  
  private static void Q(String[] paramArrayOfString)
  {
    AppMethodBeat.i(118660);
    Object localObject2 = paramArrayOfString[2];
    paramArrayOfString = j.Fmy;
    paramArrayOfString = j.b.fod().aRS("foreverzeus");
    Object localObject1 = j.Fmy;
    localObject1 = j.b.foc();
    Object localObject3 = j.Fmy;
    boolean bool = Util.isEqual(j.b.fau(), "foreverzeus");
    int i = cl.aWB();
    localObject3 = i.Fmb;
    localObject1 = k.a((k)localObject1, "foreverzeus", bool, i - i.fnT());
    if (((List)localObject1).isEmpty())
    {
      u.makeText(MMApplicationContext.getContext(), (CharSequence)"allmockData error1", 1).show();
      AppMethodBeat.o(118660);
      return;
    }
    localObject2 = v.Ic((String)localObject2);
    if (localObject2 != null)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        Object localObject4 = j.Fmy;
        localObject4 = j.b.fod();
        p.g(localObject3, "it");
        localObject4 = ((com.tencent.mm.plugin.story.i.g)localObject4).aRS((String)localObject3);
        i = (int)((f)localObject4).systemRowid;
        if (!((f)localObject4).isValid())
        {
          paramArrayOfString.setUserName((String)localObject3);
          paramArrayOfString.field_storyPostTime = ((int)Util.currentTicks());
          paramArrayOfString.systemRowid = -1L;
          if (i >= 0) {
            break label299;
          }
          localObject4 = j.Fmy;
          j.b.fod().insert((IAutoDBItem)paramArrayOfString);
        }
        for (;;)
        {
          localObject4 = (com.tencent.mm.plugin.story.i.j)((List)localObject1).get(0);
          ((com.tencent.mm.plugin.story.i.j)localObject4).field_userName = ((String)localObject3);
          ((com.tencent.mm.plugin.story.i.j)localObject4).field_createTime = cl.aWB();
          eek localeek = ((com.tencent.mm.plugin.story.i.j)localObject4).frG();
          localeek.UserName = ((String)localObject3);
          ((com.tencent.mm.plugin.story.i.j)localObject4).b(localeek);
          ((com.tencent.mm.plugin.story.i.j)localObject4).ecf = -1;
          localObject3 = j.Fmy;
          j.b.foc().insert((IAutoDBItem)localObject4);
          break;
          label299:
          localObject4 = j.Fmy;
          j.b.fod().b(i * 1L, paramArrayOfString);
        }
      }
    }
    u.makeText(MMApplicationContext.getContext(), (CharSequence)"allmockData done", 1).show();
    AppMethodBeat.o(118660);
  }
  
  private static void R(String[] paramArrayOfString)
  {
    AppMethodBeat.i(118661);
    int j = Util.safeParseInt(paramArrayOfString[2]);
    Log.i("MicroMsg.StoryCommand", "testMakeData datacount ".concat(String.valueOf(j)));
    paramArrayOfString = j.Fmy;
    paramArrayOfString = j.b.foc();
    Object localObject1 = j.Fmy;
    boolean bool = Util.isEqual(j.b.fau(), "ychengo");
    int i = cl.aWB();
    localObject1 = i.Fmb;
    paramArrayOfString = k.a(paramArrayOfString, "ychengo", bool, i - i.fnT());
    i = 0;
    while (i < j)
    {
      localObject1 = (com.tencent.mm.plugin.story.i.j)paramArrayOfString.get(0);
      ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName = "ychengo";
      ((com.tencent.mm.plugin.story.i.j)localObject1).field_createTime = cl.aWB();
      Object localObject2 = ((com.tencent.mm.plugin.story.i.j)localObject1).frG();
      ((eek)localObject2).UserName = "ychengo";
      ((com.tencent.mm.plugin.story.i.j)localObject1).b((eek)localObject2);
      ((com.tencent.mm.plugin.story.i.j)localObject1).ecf = -1;
      localObject2 = j.Fmy;
      j.b.foc().insert((IAutoDBItem)localObject1);
      i += 1;
    }
    u.makeText(MMApplicationContext.getContext(), (CharSequence)"testMakeData done ".concat(String.valueOf(j)), 1).show();
    AppMethodBeat.o(118661);
  }
  
  private static void fnN()
  {
    AppMethodBeat.i(118655);
    Object localObject = j.Fmy;
    localObject = ((Iterable)j.b.fof().frv()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      c localc = (c)((Iterator)localObject).next();
      Log.i("MicroMsg.StoryCommand", "commentDump " + localc.field_storyId + ' ' + localc.field_readCommentId + ' ' + localc.field_syncCommentId);
    }
    AppMethodBeat.o(118655);
  }
  
  private static void fnO()
  {
    AppMethodBeat.i(118656);
    Object localObject = j.Fmy;
    localObject = ((Iterable)j.b.fof().frv()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      c localc = (c)((Iterator)localObject).next();
      j.b localb = j.Fmy;
      j.b.fof().delete((IAutoDBItem)localc, new String[0]);
    }
    AppMethodBeat.o(118656);
  }
  
  private static void fnP()
  {
    AppMethodBeat.i(118657);
    Object localObject1 = j.Fmy;
    Object localObject2 = j.b.fog();
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
      localObject3 = j.Fmy;
      j.b.fog().delete((IAutoDBItem)localObject2, new String[0]);
    }
    AppMethodBeat.o(118657);
  }
  
  public static void fnQ()
  {
    AppMethodBeat.i(118658);
    Log.i("MicroMsg.StoryCommand", "cleanDb");
    Object localObject = j.Fmy;
    j.b.fog().eIQ();
    localObject = j.Fmy;
    j.b.fod().eIQ();
    localObject = j.Fmy;
    j.b.foe().eIQ();
    localObject = j.Fmy;
    j.b.foc().eIQ();
    localObject = j.Fmy;
    s.deleteDir(j.b.getAccStoryCachePath());
    localObject = com.tencent.mm.kernel.g.ah(PluginVideoEditor.class);
    p.g(localObject, "MMKernel.plugin(PluginVideoEditor::class.java)");
    ((PluginVideoEditor)localObject).getVideoEditorDataStorage().eIQ();
    AppMethodBeat.o(118658);
  }
  
  public static void fnR()
  {
    AppMethodBeat.i(118659);
    Object localObject = j.Fmy;
    j.b.foc().eIQ();
    localObject = j.Fmy;
    j.b.fog().eIQ();
    localObject = j.Fmy;
    s.deleteDir(j.b.getAccStoryCachePath());
    localObject = j.Fmy;
    localObject = ((Iterable)j.b.fod().frC()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      f localf = (f)((Iterator)localObject).next();
      localf.field_readId = 0L;
      localf.field_md5 = "";
      localf.field_preLoadResource = 0L;
      localf.aSs("");
      localf.field_preloadStoryId = 0L;
      j.b localb = j.Fmy;
      j.b.fod().b(localf.systemRowid, localf);
    }
    Log.i("MicroMsg.StoryCommand", "allUnRead done");
    u.makeText(MMApplicationContext.getContext(), (CharSequence)"allUnRead Done", 1).show();
    AppMethodBeat.o(118659);
  }
  
  public static void fnS()
  {
    AppMethodBeat.i(118662);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.aAh();
    p.g(locale, "MMKernel.storage()");
    locale.azQ().set(ar.a.Oir, Integer.valueOf(0));
    AppMethodBeat.o(118662);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(118654);
    p.h(paramArrayOfString, "args");
    p.h(paramString, "username");
    Log.i("MicroMsg.StoryCommand", kotlin.a.e.a(paramArrayOfString, null, null, null, 0, null, null, 63));
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
          paramArrayOfString = com.tencent.mm.kernel.g.aAh();
          p.g(paramArrayOfString, "MMKernel.storage()");
          paramContext = paramArrayOfString.azM() + "StoryMicroMsg.db";
          paramArrayOfString = new StringBuilder();
          paramString = j.Fmy;
          paramArrayOfString = j.b.getAccStoryPath() + "StoryMicroMsg.db";
          s.nw(paramContext, paramArrayOfString);
          Log.i("MicroMsg.StoryCommand", "copydb ".concat(String.valueOf(paramArrayOfString)));
          u.makeText(MMApplicationContext.getContext(), (CharSequence)"copydb done", 1).show();
          continue;
          if (!paramString.equals("allunread")) {
            break;
          }
          fnR();
          continue;
          if (!paramString.equals("commentDump")) {
            break;
          }
          fnN();
          continue;
          if (!paramString.equals("dumpFile")) {
            break;
          }
          paramContext = l.FmK;
          l.fot();
          continue;
          if (!paramString.equals("i2v")) {
            break;
          }
          p.h(paramArrayOfString, "args");
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
                      paramContext = l.FmK;
                      s.deleteDir(l.fos());
                      continue;
                      if (!paramString.equals("videoCacheClear")) {
                        break;
                      }
                      fnP();
                    }
                  }
                }
              }
            }
          }
        }
      } while (!paramString.equals("copyfile"));
      paramArrayOfString = paramArrayOfString[2];
      paramContext = l.FmK;
      l.fot();
      paramContext = l.FmK;
      p.h(paramArrayOfString, "path");
      l.aLP(l.jdMethod_for() + "cpfiles/");
      paramContext = new com.tencent.mm.vfs.o(paramArrayOfString);
      if (!paramContext.exists()) {
        paramContext = "";
      }
      break;
    }
    for (;;)
    {
      u.makeText(MMApplicationContext.getContext(), (CharSequence)"copyFile done ".concat(String.valueOf(paramContext)), 1).show();
      break label350;
      if (!paramString.equals("createFile")) {
        break;
      }
      paramContext = l.FmK;
      l.fou();
      break label350;
      if (!paramString.equals("resetFirst")) {
        break;
      }
      paramContext = com.tencent.mm.kernel.g.aAh();
      p.g(paramContext, "MMKernel.storage()");
      paramContext.azQ().set(ar.a.Oiu, Integer.valueOf(0));
      paramContext = com.tencent.mm.kernel.g.aAh();
      p.g(paramContext, "MMKernel.storage()");
      paramContext.azQ().set(ar.a.Oiv, Boolean.FALSE);
      paramContext = com.tencent.mm.kernel.g.aAh();
      p.g(paramContext, "MMKernel.storage()");
      paramContext.azQ().set(ar.a.Oiw, Boolean.FALSE);
      break label350;
      if (!paramString.equals("strangerClear")) {
        break;
      }
      paramContext = j.Fmy;
      paramContext = ((Iterable)j.b.fod().frC()).iterator();
      while (paramContext.hasNext())
      {
        paramArrayOfString = (f)paramContext.next();
        paramString = j.Fmy;
        j.b.fod().delete((IAutoDBItem)paramArrayOfString, new String[0]);
      }
      if (!paramString.equals("commentClear")) {
        break;
      }
      fnO();
      break label350;
      if (!paramString.equals("strangerRead")) {
        break;
      }
      paramContext = j.Fmy;
      paramContext = ((Iterable)j.b.fod().frv()).iterator();
      while (paramContext.hasNext())
      {
        paramArrayOfString = (f)paramContext.next();
        paramArrayOfString.field_readId = paramArrayOfString.field_syncId;
        paramString = j.Fmy;
        j.b.fod().b(paramArrayOfString);
      }
      if (!paramString.equals("cleandb")) {
        break;
      }
      fnQ();
      break label350;
      if (!paramString.equals("testDumpInfo")) {
        break;
      }
      paramContext = j.Fmy;
      paramContext = j.b.fog().db.rawQuery("select count(*) from StoryVideoCacheInfo", null);
      p.g(paramContext, "cu");
      i = paramContext.getCount();
      paramContext.close();
      paramContext = "StoryVideoCacheInfo resultData ".concat(String.valueOf(i));
      paramArrayOfString = j.Fmy;
      paramArrayOfString = j.b.foc();
      paramString = "select count(*) from " + k.TABLE;
      paramArrayOfString = paramArrayOfString.db.rawQuery(paramString, null);
      p.g(paramArrayOfString, "cu");
      i = paramArrayOfString.getCount();
      paramArrayOfString.close();
      paramArrayOfString = k.TABLE + " resultData " + i;
      Log.i("MicroMsg.StoryCommand", "info1 " + paramContext + " info2 " + paramArrayOfString);
      break label350;
      if (!paramString.equals("allmakeData")) {
        break;
      }
      R(paramArrayOfString);
      break label350;
      if (!paramString.equals("strangerDump")) {
        break;
      }
      paramContext = j.Fmy;
      paramContext = ((Iterable)j.b.fod().frv()).iterator();
      while (paramContext.hasNext())
      {
        paramArrayOfString = (f)paramContext.next();
        Log.i("MicroMsg.StoryCommand", "strangerDump " + paramArrayOfString.getUserName() + ' ' + paramArrayOfString.field_syncId + ' ' + paramArrayOfString.field_readId + ' ' + paramArrayOfString.field_storyPostTime + ' ' + paramArrayOfString.field_updateTime);
      }
      if (!paramString.equals("allmockData")) {
        break;
      }
      Q(paramArrayOfString);
      break label350;
      paramContext = l.jdMethod_for() + "cpfiles/" + paramContext.getName();
      Log.i("MicroMsg.StoryFileNameUtil", "copy file path " + paramArrayOfString + " newPath " + paramContext);
      s.nw(paramArrayOfString, paramContext);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/StoryCommand$Companion;", "", "()V", "CommandStart", "", "TAG", "TestAllMockData", "TestAllUnRead", "TestCommentClear", "TestCommentDump", "TestCopyDb", "TestCopyFile", "TestCreateFile", "TestDBClean", "TestDelFile", "TestDumpInfo", "TestDumpeFile", "TestI2V", "TestMakeData", "TestResetFirst", "TestResetI2V", "TestStrangerClear", "TestStrangerDump", "TestStrangerMarkRead", "TestVideoCacheClear", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.h
 * JD-Core Version:    0.7.0.1
 */