package com.tencent.mm.plugin.story.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.recordvideo.PluginVideoEditor;
import com.tencent.mm.plugin.recordvideo.background.d;
import com.tencent.mm.plugin.story.h.b;
import com.tencent.mm.plugin.story.h.c;
import com.tencent.mm.plugin.story.h.g;
import com.tencent.mm.plugin.story.h.j;
import com.tencent.mm.plugin.story.h.m;
import com.tencent.mm.plugin.story.h.n;
import com.tencent.mm.plugin.story.h.o;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.protocal.protobuf.fjj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/StoryCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "allUnRead", "", "allmockData", "args", "", "", "([Ljava/lang/String;)V", "cleanDb", "commentClear", "commentDump", "copyFile", "copydb", "createFiles", "delfile", "dumpDbInfo", "dumpFile", "processCommand", "", "context", "Landroid/content/Context;", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "resetFirst", "resetI2VParams", "(Landroid/content/Context;[Ljava/lang/String;)V", "rsetStoryPostThreshold", "strangerClear", "strangerDump", "strangerRead", "testMakeData", "videoCacheClear", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements a
{
  public static final h.a SjK;
  
  static
  {
    AppMethodBeat.i(118663);
    SjK = new h.a((byte)0);
    AppMethodBeat.o(118663);
  }
  
  private static void S(String[] paramArrayOfString)
  {
    AppMethodBeat.i(118660);
    Object localObject2 = paramArrayOfString[2];
    paramArrayOfString = StoryCore.SjP;
    paramArrayOfString = StoryCore.b.hvS().bbJ("foreverzeus");
    Object localObject1 = StoryCore.SjP;
    localObject1 = StoryCore.b.hvR();
    Object localObject3 = StoryCore.SjP;
    boolean bool = Util.isEqual(StoryCore.b.hgg(), "foreverzeus");
    int i = cn.getSyncServerTimeSecond();
    localObject3 = i.SjL;
    localObject1 = com.tencent.mm.plugin.story.h.k.a((com.tencent.mm.plugin.story.h.k)localObject1, "foreverzeus", bool, i - i.hvz());
    if (((List)localObject1).isEmpty())
    {
      aa.makeText(MMApplicationContext.getContext(), (CharSequence)"allmockData error1", 1).show();
      AppMethodBeat.o(118660);
      return;
    }
    localObject2 = v.Il((String)localObject2);
    if (localObject2 != null)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        Object localObject4 = StoryCore.SjP;
        localObject4 = StoryCore.b.hvS();
        s.s(localObject3, "it");
        localObject4 = ((g)localObject4).bbJ((String)localObject3);
        i = (int)((com.tencent.mm.plugin.story.h.f)localObject4).systemRowid;
        if (!((com.tencent.mm.plugin.story.h.f)localObject4).isValid())
        {
          paramArrayOfString.setUserName((String)localObject3);
          paramArrayOfString.field_storyPostTime = ((int)Util.currentTicks());
          paramArrayOfString.systemRowid = -1L;
          if (i >= 0) {
            break label299;
          }
          localObject4 = StoryCore.SjP;
          StoryCore.b.hvS().insert((IAutoDBItem)paramArrayOfString);
        }
        for (;;)
        {
          localObject4 = (j)((List)localObject1).get(0);
          ((j)localObject4).field_userName = ((String)localObject3);
          ((j)localObject4).field_createTime = cn.getSyncServerTimeSecond();
          fjj localfjj = ((j)localObject4).hzt();
          localfjj.UserName = ((String)localObject3);
          ((j)localObject4).b(localfjj);
          ((j)localObject4).icg = -1;
          localObject3 = StoryCore.SjP;
          StoryCore.b.hvR().insert((IAutoDBItem)localObject4);
          break;
          label299:
          localObject4 = StoryCore.SjP;
          StoryCore.b.hvS().b(i * 1L, paramArrayOfString);
        }
      }
    }
    aa.makeText(MMApplicationContext.getContext(), (CharSequence)"allmockData done", 1).show();
    AppMethodBeat.o(118660);
  }
  
  private static void T(String[] paramArrayOfString)
  {
    AppMethodBeat.i(118661);
    int j = Util.safeParseInt(paramArrayOfString[2]);
    Log.i("MicroMsg.StoryCommand", s.X("testMakeData datacount ", Integer.valueOf(j)));
    paramArrayOfString = StoryCore.SjP;
    paramArrayOfString = StoryCore.b.hvR();
    Object localObject1 = StoryCore.SjP;
    boolean bool = Util.isEqual(StoryCore.b.hgg(), "ychengo");
    int i = cn.getSyncServerTimeSecond();
    localObject1 = i.SjL;
    paramArrayOfString = com.tencent.mm.plugin.story.h.k.a(paramArrayOfString, "ychengo", bool, i - i.hvz());
    if (j > 0) {
      i = 0;
    }
    for (;;)
    {
      i += 1;
      localObject1 = (j)paramArrayOfString.get(0);
      ((j)localObject1).field_userName = "ychengo";
      ((j)localObject1).field_createTime = cn.getSyncServerTimeSecond();
      Object localObject2 = ((j)localObject1).hzt();
      ((fjj)localObject2).UserName = "ychengo";
      ((j)localObject1).b((fjj)localObject2);
      ((j)localObject1).icg = -1;
      localObject2 = StoryCore.SjP;
      StoryCore.b.hvR().insert((IAutoDBItem)localObject1);
      if (i >= j)
      {
        aa.makeText(MMApplicationContext.getContext(), (CharSequence)s.X("testMakeData done ", Integer.valueOf(j)), 1).show();
        AppMethodBeat.o(118661);
        return;
      }
    }
  }
  
  private static void hvt()
  {
    AppMethodBeat.i(118655);
    Object localObject = StoryCore.SjP;
    localObject = ((Iterable)StoryCore.b.hvU().eZt()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      c localc = (c)((Iterator)localObject).next();
      Log.i("MicroMsg.StoryCommand", "commentDump " + localc.field_storyId + ' ' + localc.field_readCommentId + ' ' + localc.field_syncCommentId);
    }
    AppMethodBeat.o(118655);
  }
  
  private static void hvu()
  {
    AppMethodBeat.i(118656);
    Object localObject = StoryCore.SjP;
    localObject = ((Iterable)StoryCore.b.hvU().eZt()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      c localc = (c)((Iterator)localObject).next();
      StoryCore.b localb = StoryCore.SjP;
      StoryCore.b.hvU().delete((IAutoDBItem)localc, new String[0]);
    }
    AppMethodBeat.o(118656);
  }
  
  private static void hvv()
  {
    AppMethodBeat.i(118657);
    Object localObject1 = StoryCore.SjP;
    Object localObject2 = StoryCore.b.hvV();
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
      localObject3 = StoryCore.SjP;
      StoryCore.b.hvV().delete((IAutoDBItem)localObject2, new String[0]);
    }
    AppMethodBeat.o(118657);
  }
  
  public static void hvw()
  {
    AppMethodBeat.i(118658);
    Log.i("MicroMsg.StoryCommand", "cleanDb");
    StoryCore.b localb = StoryCore.SjP;
    StoryCore.b.hvV().gGK();
    localb = StoryCore.SjP;
    StoryCore.b.hvS().gGK();
    localb = StoryCore.SjP;
    StoryCore.b.hvT().gGK();
    localb = StoryCore.SjP;
    StoryCore.b.hvR().gGK();
    localb = StoryCore.SjP;
    y.ew(StoryCore.b.getAccStoryCachePath(), true);
    ((PluginVideoEditor)com.tencent.mm.kernel.h.az(PluginVideoEditor.class)).getVideoEditorDataStorage().gGK();
    AppMethodBeat.o(118658);
  }
  
  public static void hvx()
  {
    AppMethodBeat.i(118659);
    Object localObject = StoryCore.SjP;
    StoryCore.b.hvR().gGK();
    localObject = StoryCore.SjP;
    StoryCore.b.hvV().gGK();
    localObject = StoryCore.SjP;
    y.ew(StoryCore.b.getAccStoryCachePath(), true);
    localObject = StoryCore.SjP;
    localObject = ((Iterable)StoryCore.b.hvS().hzp()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.story.h.f localf = (com.tencent.mm.plugin.story.h.f)((Iterator)localObject).next();
      localf.field_readId = 0L;
      localf.field_md5 = "";
      localf.field_preLoadResource = 0L;
      localf.bcj("");
      localf.field_preloadStoryId = 0L;
      StoryCore.b localb = StoryCore.SjP;
      StoryCore.b.hvS().b(localf.systemRowid, localf);
    }
    Log.i("MicroMsg.StoryCommand", "allUnRead done");
    aa.makeText(MMApplicationContext.getContext(), (CharSequence)"allUnRead Done", 1).show();
    AppMethodBeat.o(118659);
  }
  
  public static void hvy()
  {
    AppMethodBeat.i(118662);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acYs, Integer.valueOf(0));
    AppMethodBeat.o(118662);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(118654);
    s.u(paramArrayOfString, "args");
    s.u(paramString, "username");
    Log.i("MicroMsg.StoryCommand", kotlin.a.k.a(paramArrayOfString, null, null, null, 0, null, null, 63));
    if (paramArrayOfString.length <= 1)
    {
      AppMethodBeat.o(118654);
      return false;
    }
    paramString = paramArrayOfString[1];
    switch (paramString.hashCode())
    {
    default: 
    case -350339842: 
      do
      {
        AppMethodBeat.o(118654);
        return false;
      } while (!paramString.equals("reseti2v"));
      if (paramContext != null) {
        break;
      }
    }
    for (paramContext = localObject1;; paramContext = paramContext.getSharedPreferences("storyi2v", 0))
    {
      if (paramContext != null)
      {
        paramContext = paramContext.edit();
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
      label1410:
      for (;;)
      {
        label341:
        AppMethodBeat.o(118654);
        return true;
        if (!paramString.equals("testcopyDb")) {
          break;
        }
        paramContext = s.X(com.tencent.mm.kernel.h.baE().cachePath, "StoryMicroMsg.db");
        paramArrayOfString = StoryCore.SjP;
        paramArrayOfString = s.X(StoryCore.b.getAccStoryPath(), "StoryMicroMsg.db");
        y.O(paramContext, paramArrayOfString, false);
        Log.i("MicroMsg.StoryCommand", s.X("copydb ", paramArrayOfString));
        aa.makeText(MMApplicationContext.getContext(), (CharSequence)"copydb done", 1).show();
        continue;
        if (!paramString.equals("allunread")) {
          break;
        }
        hvx();
        continue;
        if (!paramString.equals("commentDump")) {
          break;
        }
        hvt();
        continue;
        if (!paramString.equals("dumpFile")) {
          break;
        }
        paramContext = k.Skq;
        k.hwh();
        continue;
        if (!paramString.equals("i2v")) {
          break;
        }
        s.u(paramArrayOfString, "args");
        int i = Util.safeParseInt(paramArrayOfString[2]);
        int j = Util.safeParseInt(paramArrayOfString[3]);
        int k = Util.safeParseInt(paramArrayOfString[4]);
        int m = Util.safeParseInt(paramArrayOfString[5]);
        if (paramContext == null) {}
        for (paramContext = localObject2;; paramContext = paramContext.getSharedPreferences("storyi2v", 0))
        {
          if (paramContext == null) {
            break label1410;
          }
          paramContext = paramContext.edit();
          if (paramContext == null) {
            break label341;
          }
          paramContext = paramContext.putInt("storyi2v_bitRate", i);
          if (paramContext == null) {
            break label341;
          }
          paramContext = paramContext.putInt("storyi2v_frameRate", j);
          if (paramContext == null) {
            break label341;
          }
          paramContext = paramContext.putInt("storyi2v_iFrameInterval", k);
          if (paramContext == null) {
            break label341;
          }
          paramContext = paramContext.putInt("storyi2v_MaxSize", m);
          if (paramContext == null) {
            break label341;
          }
          paramContext.commit();
          break label341;
          if (!paramString.equals("delfile")) {
            break;
          }
          paramContext = k.Skq;
          y.ew(k.hwg(), true);
          break label341;
          if (!paramString.equals("videoCacheClear")) {
            break;
          }
          hvv();
          break label341;
          if (!paramString.equals("copyfile")) {
            break;
          }
          paramArrayOfString = paramArrayOfString[2];
          paramContext = k.Skq;
          k.hwh();
          paramContext = k.Skq;
          s.u(paramArrayOfString, "path");
          k.aTB(s.X(k.hwf(), "cpfiles/"));
          paramContext = new u(paramArrayOfString);
          if (!paramContext.jKS()) {
            paramContext = "";
          }
          for (;;)
          {
            aa.makeText(MMApplicationContext.getContext(), (CharSequence)s.X("copyFile done ", paramContext), 1).show();
            break label341;
            if (!paramString.equals("createFile")) {
              break;
            }
            paramContext = k.Skq;
            k.hwi();
            break label341;
            if (!paramString.equals("resetFirst")) {
              break;
            }
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acYv, Integer.valueOf(0));
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acYw, Boolean.FALSE);
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acYx, Boolean.FALSE);
            break label341;
            if (!paramString.equals("strangerClear")) {
              break;
            }
            paramContext = StoryCore.SjP;
            paramContext = ((Iterable)StoryCore.b.hvS().hzp()).iterator();
            while (paramContext.hasNext())
            {
              paramArrayOfString = (com.tencent.mm.plugin.story.h.f)paramContext.next();
              paramString = StoryCore.SjP;
              StoryCore.b.hvS().delete((IAutoDBItem)paramArrayOfString, new String[0]);
            }
            break label341;
            if (!paramString.equals("commentClear")) {
              break;
            }
            hvu();
            break label341;
            if (!paramString.equals("strangerRead")) {
              break;
            }
            paramContext = StoryCore.SjP;
            paramContext = ((Iterable)StoryCore.b.hvS().eZt()).iterator();
            while (paramContext.hasNext())
            {
              paramArrayOfString = (com.tencent.mm.plugin.story.h.f)paramContext.next();
              paramArrayOfString.field_readId = paramArrayOfString.field_syncId;
              paramString = StoryCore.SjP;
              StoryCore.b.hvS().b(paramArrayOfString);
            }
            break label341;
            if (!paramString.equals("cleandb")) {
              break;
            }
            hvw();
            break label341;
            if (!paramString.equals("testDumpInfo")) {
              break;
            }
            paramContext = StoryCore.SjP;
            paramContext = StoryCore.b.hvV().db.rawQuery("select count(*) from StoryVideoCacheInfo", null);
            i = paramContext.getCount();
            paramContext.close();
            paramContext = s.X("StoryVideoCacheInfo resultData ", Integer.valueOf(i));
            paramArrayOfString = StoryCore.SjP;
            paramArrayOfString = StoryCore.b.hvR();
            paramString = s.X("select count(*) from ", com.tencent.mm.plugin.story.h.k.ptT);
            paramArrayOfString = paramArrayOfString.db.rawQuery(paramString, null);
            i = paramArrayOfString.getCount();
            paramArrayOfString.close();
            paramArrayOfString = com.tencent.mm.plugin.story.h.k.ptT + " resultData " + i;
            Log.i("MicroMsg.StoryCommand", "info1 " + paramContext + " info2 " + paramArrayOfString);
            break label341;
            if (!paramString.equals("allmakeData")) {
              break;
            }
            T(paramArrayOfString);
            break label341;
            if (!paramString.equals("strangerDump")) {
              break;
            }
            paramContext = StoryCore.SjP;
            paramContext = ((Iterable)StoryCore.b.hvS().eZt()).iterator();
            while (paramContext.hasNext())
            {
              paramArrayOfString = (com.tencent.mm.plugin.story.h.f)paramContext.next();
              Log.i("MicroMsg.StoryCommand", "strangerDump " + paramArrayOfString.getUserName() + ' ' + paramArrayOfString.field_syncId + ' ' + paramArrayOfString.field_readId + ' ' + paramArrayOfString.field_storyPostTime + ' ' + paramArrayOfString.field_updateTime);
            }
            break label341;
            if (!paramString.equals("allmockData")) {
              break;
            }
            S(paramArrayOfString);
            break label341;
            paramContext = k.hwf() + "cpfiles/" + paramContext.getName();
            Log.i("MicroMsg.StoryFileNameUtil", "copy file path " + paramArrayOfString + " newPath " + paramContext);
            y.O(paramArrayOfString, paramContext, false);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.h
 * JD-Core Version:    0.7.0.1
 */