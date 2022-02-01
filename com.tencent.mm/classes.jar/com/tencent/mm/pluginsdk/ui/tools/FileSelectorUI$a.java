package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.pluginsdk.j.f;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ChattingFileSource;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileDataSource;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "Lcom/tencent/mm/plugin/fts/api/IFTSResultListener;", "adapter", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "msgIdList", "", "", "searchTask", "Lcom/tencent/mm/plugin/fts/api/model/BaseFTSTask;", "appendFileList", "", "msgInfoList", "", "Lcom/tencent/mm/storage/MsgInfo;", "asyncLoad", "cancelSearchTask", "coreLoad", "createFileListItem", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListFileItem;", "msgInfo", "finish", "getAllAppMsgFileId", "getAttachPathSimple", "", "msgId", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "getQuery", "initASync", "isAppMsgFileDownloaded", "", "loadDataAndShow", "loadMoreAsync", "onFTSSearchEnd", "ftsResult", "Lcom/tencent/mm/plugin/fts/api/model/FTSResult;", "app_release"})
public final class FileSelectorUI$a
  extends FileSelectorUI.d
  implements com.tencent.mm.plugin.fts.a.l
{
  com.tencent.mm.plugin.fts.a.a.a BIV;
  private final List<Long> CIH;
  final MMHandler handler;
  
  public FileSelectorUI$a(FileSelectorUI.e parame)
  {
    super(parame, localObject);
    AppMethodBeat.i(274369);
    this.handler = new MMHandler();
    this.CIH = ((List)new ArrayList());
    AppMethodBeat.o(274369);
  }
  
  private final void hnk()
  {
    AppMethodBeat.i(274364);
    int k = this.RvB.size();
    while (this.RvB.size() - k < 10)
    {
      Object localObject = new ArrayList();
      if (this.startIndex + hno() > this.CIH.size()) {}
      for (int i = this.CIH.size(); i <= this.startIndex; i = this.startIndex + hno())
      {
        Log.i("MicroMsg.FileSelectorUI", "coreLoad, not data to load, " + i + " < " + this.startIndex);
        AppMethodBeat.o(274364);
        return;
      }
      Log.i("MicroMsg.FileSelectorUI", "coreLoad, startIndex:" + this.startIndex + ", endIndex:" + i + ", totalCnt:" + this.CIH.size() + ", PageSize:" + hno());
      int j = this.startIndex;
      while (j < i)
      {
        ((ArrayList)localObject).add(this.CIH.get(j));
        j += 1;
      }
      p.j(bh.beI(), "MMCore.getAccStg()");
      localObject = com.tencent.mm.model.c.bbO().m(apJ(), (ArrayList)localObject);
      this.startIndex += hno();
      if (((List)localObject).size() == 0)
      {
        AppMethodBeat.o(274364);
        return;
      }
      p.j(localObject, "msgInfoList");
      jn((List)localObject);
    }
    AppMethodBeat.o(274364);
  }
  
  private final void hnl()
  {
    AppMethodBeat.i(274365);
    hnk();
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(274365);
  }
  
  private final void jn(List<? extends ca> paramList)
  {
    AppMethodBeat.i(274368);
    Iterator localIterator = paramList.iterator();
    label258:
    label597:
    while (localIterator.hasNext())
    {
      ca localca = (ca)localIterator.next();
      long l1 = System.currentTimeMillis();
      Object localObject1;
      if (localca == null) {
        localObject1 = null;
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label597;
        }
        ((FileSelectorUI.j)localObject1).a(FileSelectorUI.g.RvS);
        ((FileSelectorUI.j)localObject1).d(FileSelectorUI.h.RvV);
        ((FileSelectorUI.l)localObject1).title = f.y((Context)this.Rvw.getContext(), ((FileSelectorUI.j)localObject1).createTime);
        this.RvB.add(localObject1);
        break;
        k.b localb = k.b.OQ(localca.getContent());
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
          localObject1 = com.tencent.mm.pluginsdk.model.app.m.bqf(localb.fvr);
          if (localObject1 != null)
          {
            localObject2 = new com.tencent.mm.vfs.q(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath);
            if ((!((com.tencent.mm.vfs.q)localObject2).ifE()) || (((com.tencent.mm.vfs.q)localObject2).length() != ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_totalLen)) {}
          }
          for (boolean bool = true;; bool = false)
          {
            if ((FileSelectorUI.a(this.Rvw) != 0) || (bool)) {
              break label258;
            }
            Log.i("MicroMsg.FileSelectorUI", "file not download, " + localb.title);
            localObject1 = null;
            break;
          }
          long l2 = localca.apG();
          Object localObject2 = com.tencent.mm.pluginsdk.model.app.m.bqf(localb.fvr);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = ao.ctZ().TR(l2);
          }
          if (localObject1 == null) {
            Log.w("MicroMsg.FileSelectorUI", "felix getAppAttachInfo is null stack[%s]", new Object[] { Util.getStack() });
          }
          for (localObject1 = null;; localObject1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath)
          {
            if (!Util.isNullOrNil((String)localObject1)) {
              break label471;
            }
            Log.e("MicroMsg.FileSelectorUI", "createFileListItem, chatting filePath is null, filter!");
            localObject1 = null;
            break;
            Log.i("MicroMsg.FileSelectorUI", "felix getAppAttachInfo info[%s], rowid[%d], isUpload[%b], fullpath[%s], totallen[%d], offset[%d], mediaSvrId[%s], mediaid[%s], msgid[%d], type[%d], stack[%s]", new Object[] { localObject1, Long.valueOf(((com.tencent.mm.pluginsdk.model.app.c)localObject1).systemRowid), Boolean.valueOf(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_isUpload), ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath, Long.valueOf(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_totalLen), Long.valueOf(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_offset), ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_mediaSvrId, ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_mediaId, Long.valueOf(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_msgInfoId), Long.valueOf(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_type), Util.getStack() });
          }
          label471:
          localObject2 = new FileSelectorUI.j(this.Rvw);
          ((FileSelectorUI.j)localObject2).msgId = localca.apG();
          ((FileSelectorUI.j)localObject2).createTime = localca.getCreateTime();
          ((FileSelectorUI.j)localObject2).Rwc = ((CharSequence)PJ(localb.fLi));
          ((FileSelectorUI.j)localObject2).aA((CharSequence)new com.tencent.mm.pluginsdk.ui.span.m(localb.title));
          ((FileSelectorUI.j)localObject2).Rwe = localb.llX;
          ((FileSelectorUI.j)localObject2).filePath = ((String)localObject1);
          ((FileSelectorUI.j)localObject2).Rwg = bool;
          Log.d("MicroMsg.FileSelectorUI", "end create, cost:" + (System.currentTimeMillis() - l1));
          localObject1 = localObject2;
        }
      }
    }
    Log.d("MicroMsg.FileSelectorUI", "append file item list size %d, current total size is %d(chatting)", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(this.RvB.size()) });
    AppMethodBeat.o(274368);
  }
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(274363);
    p.k(paramk, "ftsResult");
    switch (paramk.resultCode)
    {
    }
    for (;;)
    {
      hnl();
      AppMethodBeat.o(274363);
      return;
      Log.i("MicroMsg.FileSelectorUI", "onFTSSearchEnd, size:" + paramk.BIW.size());
      paramk = paramk.BIW.iterator();
      while (paramk.hasNext())
      {
        com.tencent.mm.plugin.fts.a.a.m localm = (com.tencent.mm.plugin.fts.a.a.m)paramk.next();
        this.CIH.add(Long.valueOf(localm.BIZ));
        Log.d("MicroMsg.FileSelectorUI", "msgId:" + localm.BIZ);
      }
      Log.e("MicroMsg.FileSelectorUI", "get msgId fail, errorCode:" + paramk.resultCode);
    }
  }
  
  final void hnj()
  {
    AppMethodBeat.i(274361);
    if (this.BIV != null) {
      ((n)com.tencent.mm.kernel.h.ag(n.class)).cancelSearchTask(this.BIV);
    }
    AppMethodBeat.o(274361);
  }
  
  final void hnm()
  {
    AppMethodBeat.i(274366);
    com.tencent.e.h.ZvG.be((Runnable)new a(this));
    AppMethodBeat.o(274366);
  }
  
  public final void hnn()
  {
    AppMethodBeat.i(274367);
    this.hasInit = false;
    this.startIndex = 0;
    aqY(30);
    hnm();
    AppMethodBeat.o(274367);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(FileSelectorUI.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(278735);
      long l = System.currentTimeMillis();
      boolean bool = this.Rvx.hasInit;
      if (!this.Rvx.hasInit)
      {
        this.Rvx.hasInit = true;
        FileSelectorUI.a locala = this.Rvx;
        locala.hnj();
        j localj = new j();
        localj.query = "query_app_msg_file";
        localj.BIN = null;
        localj.BIQ = new int[] { 42 };
        localj.BIU = ((com.tencent.mm.plugin.fts.a.l)locala);
        localj.handler = locala.handler;
        localj.nRn = 256;
        locala.BIV = ((n)com.tencent.mm.kernel.h.ag(n.class)).search(3, localj);
        Log.i("MicroMsg.FileSelectorUI", "do search %s", new Object[] { "query_app_msg_file" });
      }
      for (;;)
      {
        Log.i("MicroMsg.FileSelectorUI", "[isInit:" + bool + "] chatting load data end:" + (System.currentTimeMillis() - l) + ", startIndex:" + this.Rvx.startIndex);
        AppMethodBeat.o(278735);
        return;
        FileSelectorUI.a.a(this.Rvx);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(FileSelectorUI.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.a
 * JD-Core Version:    0.7.0.1
 */