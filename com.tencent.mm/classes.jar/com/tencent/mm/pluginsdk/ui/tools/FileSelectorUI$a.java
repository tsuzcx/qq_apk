package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ChattingFileSource;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileDataSource;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "Lcom/tencent/mm/plugin/fts/api/IFTSResultListener;", "adapter", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "msgIdList", "", "", "searchTask", "Lcom/tencent/mm/plugin/fts/api/model/BaseFTSTask;", "appendFileList", "", "msgInfoList", "", "Lcom/tencent/mm/storage/MsgInfo;", "asyncLoad", "cancelSearchTask", "coreLoad", "createFileListItem", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListFileItem;", "msgInfo", "finish", "getAllAppMsgFileId", "getAttachPathSimple", "", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "getQuery", "initASync", "isAppMsgFileDownloaded", "", "loadDataAndShow", "loadMoreAsync", "onFTSSearchEnd", "ftsResult", "Lcom/tencent/mm/plugin/fts/api/model/FTSResult;", "app_release"})
public final class FileSelectorUI$a
  extends FileSelectorUI.d
  implements com.tencent.mm.plugin.fts.a.l
{
  final MMHandler handler;
  com.tencent.mm.plugin.fts.a.a.a wXa;
  private final List<Long> xEG;
  
  public FileSelectorUI$a(FileSelectorUI.e parame)
  {
    super(parame, localObject);
    AppMethodBeat.i(231053);
    this.handler = new MMHandler();
    this.xEG = ((List)new ArrayList());
    AppMethodBeat.o(231053);
  }
  
  private final void gsi()
  {
    AppMethodBeat.i(231048);
    int k = this.Kuu.size();
    while (this.Kuu.size() - k < FileSelectorUI.a(this.Kup))
    {
      Object localObject = new ArrayList();
      if (this.startIndex + this.Kut > this.xEG.size()) {}
      for (int i = this.xEG.size(); i <= this.startIndex; i = this.startIndex + this.Kut)
      {
        Log.i("MicroMsg.FileSelectorUI", "coreLoad, not data to load, " + i + " < " + this.startIndex);
        AppMethodBeat.o(231048);
        return;
      }
      Log.i("MicroMsg.FileSelectorUI", "coreLoad, startIndex:" + this.startIndex + ", endIndex:" + i + ", totalCnt:" + this.xEG.size() + ", PageSize:" + this.Kut);
      int j = this.startIndex;
      while (j < i)
      {
        ((ArrayList)localObject).add(this.xEG.get(j));
        j += 1;
      }
      p.g(bg.aVF(), "MMCore.getAccStg()");
      localObject = com.tencent.mm.model.c.aSQ().k(this.talker, (ArrayList)localObject);
      this.startIndex += this.Kut;
      if (((List)localObject).size() == 0)
      {
        AppMethodBeat.o(231048);
        return;
      }
      p.g(localObject, "msgInfoList");
      iw((List)localObject);
    }
    AppMethodBeat.o(231048);
  }
  
  private final void iw(List<? extends ca> paramList)
  {
    AppMethodBeat.i(231052);
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      ca localca = (ca)localIterator.next();
      long l = System.currentTimeMillis();
      if (localca == null) {
        localObject1 = null;
      }
      label47:
      k.b localb;
      Object localObject2;
      boolean bool;
      for (;;)
      {
        if (localObject1 != null)
        {
          ((FileSelectorUI.i)localObject1).a(FileSelectorUI.f.KuJ);
          ((FileSelectorUI.i)localObject1).d(FileSelectorUI.g.KuM);
          ((FileSelectorUI.k)localObject1).title = f.w((Context)this.Kup.getContext(), ((FileSelectorUI.i)localObject1).createTime);
          this.Kuu.add(localObject1);
          break;
          localb = k.b.HD(localca.getContent());
          if (localb == null)
          {
            localObject1 = null;
          }
          else if (localb.type != 6)
          {
            Log.e("MicroMsg.FileSelectorUI", "is not FILE?!! MayBe queryConversationTypeMessage wrong");
            localObject1 = null;
          }
          else
          {
            localObject1 = com.tencent.mm.pluginsdk.model.app.m.bdJ(localb.dCK);
            if (localObject1 != null)
            {
              localObject2 = new o(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath);
              if ((!((o)localObject2).exists()) || (((o)localObject2).length() != ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_totalLen)) {}
            }
            for (bool = true;; bool = false)
            {
              if ((FileSelectorUI.b(this.Kup) != 0) || (bool)) {
                break label258;
              }
              Log.i("MicroMsg.FileSelectorUI", "file not download, " + localb.title);
              localObject1 = null;
              break;
            }
            label258:
            localObject1 = com.tencent.mm.pluginsdk.model.app.m.bdJ(localb.dCK);
            if (localObject1 != null) {
              break label403;
            }
          }
        }
      }
      label403:
      for (Object localObject1 = null;; localObject1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath)
      {
        localObject2 = new FileSelectorUI.i(this.Kup);
        ((FileSelectorUI.i)localObject2).msgId = localca.ajL();
        ((FileSelectorUI.i)localObject2).createTime = localca.getCreateTime();
        ((FileSelectorUI.i)localObject2).KuS = ((CharSequence)getDisplayName(localb.dRL));
        ((FileSelectorUI.i)localObject2).am((CharSequence)new com.tencent.mm.pluginsdk.ui.span.m(localb.title));
        ((FileSelectorUI.i)localObject2).zGp = localb.iwI;
        ((FileSelectorUI.i)localObject2).filePath = ((String)localObject1);
        ((FileSelectorUI.i)localObject2).KuV = bool;
        Log.d("MicroMsg.FileSelectorUI", "end create, cost:" + (System.currentTimeMillis() - l));
        localObject1 = localObject2;
        break label47;
        break;
      }
    }
    Log.d("MicroMsg.FileSelectorUI", "append file item list size %d, current total size is %d(chatting)", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(this.Kuu.size()) });
    AppMethodBeat.o(231052);
  }
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(231047);
    p.h(paramk, "ftsResult");
    switch (paramk.resultCode)
    {
    }
    for (;;)
    {
      gsj();
      AppMethodBeat.o(231047);
      return;
      Log.i("MicroMsg.FileSelectorUI", "onFTSSearchEnd, size:" + paramk.wXb.size());
      paramk = paramk.wXb.iterator();
      while (paramk.hasNext())
      {
        com.tencent.mm.plugin.fts.a.a.m localm = (com.tencent.mm.plugin.fts.a.a.m)paramk.next();
        this.xEG.add(Long.valueOf(localm.wXe));
        Log.d("MicroMsg.FileSelectorUI", "msgId:" + localm.wXe);
      }
      Log.e("MicroMsg.FileSelectorUI", "get msgId fail, errorCode:" + paramk.resultCode);
    }
  }
  
  final void gsh()
  {
    AppMethodBeat.i(231046);
    if (this.wXa != null) {
      ((n)g.ah(n.class)).cancelSearchTask(this.wXa);
    }
    AppMethodBeat.o(231046);
  }
  
  final void gsj()
  {
    AppMethodBeat.i(231049);
    gsi();
    d.h((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(231049);
  }
  
  final void gsk()
  {
    AppMethodBeat.i(231050);
    h.RTc.aX((Runnable)new a(this));
    AppMethodBeat.o(231050);
  }
  
  public final void gsl()
  {
    AppMethodBeat.i(231051);
    this.hasInit = false;
    this.startIndex = 0;
    this.Kut = 30;
    gsk();
    AppMethodBeat.o(231051);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(FileSelectorUI.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(231044);
      long l = System.currentTimeMillis();
      boolean bool = this.Kuq.hasInit;
      if (!this.Kuq.hasInit)
      {
        this.Kuq.hasInit = true;
        FileSelectorUI.a locala = this.Kuq;
        locala.gsh();
        j localj = new j();
        localj.query = "query_app_msg_file";
        localj.wWS = null;
        localj.wWV = new int[] { 42 };
        localj.wWZ = ((com.tencent.mm.plugin.fts.a.l)locala);
        localj.handler = locala.handler;
        localj.kXb = 256;
        locala.wXa = ((n)g.ah(n.class)).search(3, localj);
        Log.i("MicroMsg.FileSelectorUI", "do search %s", new Object[] { "query_app_msg_file" });
      }
      for (;;)
      {
        Log.i("MicroMsg.FileSelectorUI", "[isInit:" + bool + "] chatting load data end:" + (System.currentTimeMillis() - l) + ", startIndex:" + this.Kuq.startIndex);
        AppMethodBeat.o(231044);
        return;
        this.Kuq.gsj();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(FileSelectorUI.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.a
 * JD-Core Version:    0.7.0.1
 */