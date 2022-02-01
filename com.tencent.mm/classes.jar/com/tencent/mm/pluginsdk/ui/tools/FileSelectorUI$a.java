package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.platformtools.f;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ChattingFileSource;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileDataSource;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "Lcom/tencent/mm/plugin/fts/api/IFTSResultListener;", "adapter", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "msgIdList", "", "", "searchTask", "Lcom/tencent/mm/plugin/fts/api/model/BaseFTSTask;", "appendFileList", "", "msgInfoList", "", "Lcom/tencent/mm/storage/MsgInfo;", "asyncLoad", "cancelSearchTask", "coreLoad", "createFileListItem", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListFileItem;", "msgInfo", "finish", "getAllAppMsgFileId", "getAttachPathSimple", "", "msgId", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "getQuery", "initASync", "isAppMsgFileDownloaded", "", "loadDataAndShow", "loadMoreAsync", "onFTSSearchEnd", "ftsResult", "Lcom/tencent/mm/plugin/fts/api/model/FTSResult;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FileSelectorUI$a
  extends FileSelectorUI.d
  implements com.tencent.mm.plugin.fts.a.l
{
  private com.tencent.mm.plugin.fts.a.a.c HtE;
  private final List<Long> ICS;
  private final MMHandler handler;
  
  public FileSelectorUI$a(FileSelectorUI.e parame)
  {
    super(parame, localObject);
    AppMethodBeat.i(245697);
    this.handler = new MMHandler();
    this.ICS = ((List)new ArrayList());
    AppMethodBeat.o(245697);
  }
  
  private static final void a(a parama)
  {
    AppMethodBeat.i(245732);
    s.u(parama, "this$0");
    long l = System.currentTimeMillis();
    boolean bool = parama.hasInit;
    if (!parama.hasInit)
    {
      parama.hasInit = true;
      parama.iNZ();
      com.tencent.mm.plugin.fts.a.a.l locall = new com.tencent.mm.plugin.fts.a.a.l();
      locall.query = "query_app_msg_file";
      locall.Htv = null;
      locall.Hty = new int[] { 42 };
      locall.HtC = ((com.tencent.mm.plugin.fts.a.l)parama);
      locall.handler = parama.handler;
      locall.qRb = 256;
      parama.HtE = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).search(3, locall);
      Log.i("MicroMsg.FileSelectorUI", "do search %s", new Object[] { "query_app_msg_file" });
    }
    for (;;)
    {
      Log.i("MicroMsg.FileSelectorUI", "[isInit:" + bool + "] chatting load data end:" + (System.currentTimeMillis() - l) + ", startIndex:" + parama.getStartIndex());
      AppMethodBeat.o(245732);
      return;
      parama.iOb();
    }
  }
  
  private final void iOa()
  {
    AppMethodBeat.i(245704);
    int m = this.YrW.size();
    Object localObject;
    int i;
    int j;
    if (this.YrW.size() - m < 10)
    {
      localObject = new ArrayList();
      if (getStartIndex() + iOg() > this.ICS.size()) {}
      for (i = this.ICS.size(); i <= getStartIndex(); i = getStartIndex() + iOg())
      {
        Log.i("MicroMsg.FileSelectorUI", "coreLoad, not data to load, " + i + " < " + getStartIndex());
        AppMethodBeat.o(245704);
        return;
      }
      Log.i("MicroMsg.FileSelectorUI", "coreLoad, startIndex:" + getStartIndex() + ", endIndex:" + i + ", totalCnt:" + this.ICS.size() + ", PageSize:" + iOg());
      j = getStartIndex();
      if (j >= i) {}
    }
    for (;;)
    {
      int k = j + 1;
      ((ArrayList)localObject).add(this.ICS.get(j));
      if (k >= i)
      {
        bh.bCz();
        localObject = com.tencent.mm.model.c.bzD().n(aJK(), (ArrayList)localObject);
        setStartIndex(getStartIndex() + iOg());
        if (((List)localObject).size() == 0)
        {
          AppMethodBeat.o(245704);
          return;
        }
        s.s(localObject, "msgInfoList");
        my((List)localObject);
        break;
        AppMethodBeat.o(245704);
        return;
      }
      j = k;
    }
  }
  
  private final void iOb()
  {
    AppMethodBeat.i(245706);
    iOa();
    com.tencent.mm.ae.d.uiThread((a)new a(this));
    AppMethodBeat.o(245706);
  }
  
  private final void iOc()
  {
    AppMethodBeat.i(245710);
    com.tencent.threadpool.h.ahAA.bm(new FileSelectorUI.a..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(245710);
  }
  
  private final void my(List<? extends cc> paramList)
  {
    AppMethodBeat.i(245720);
    Iterator localIterator = paramList.iterator();
    label581:
    while (localIterator.hasNext())
    {
      cc localcc = (cc)localIterator.next();
      long l1 = System.currentTimeMillis();
      Object localObject1;
      if (localcc == null) {
        localObject1 = null;
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label581;
        }
        ((FileSelectorUI.j)localObject1).a(FileSelectorUI.g.Ysn);
        ((FileSelectorUI.j)localObject1).d(FileSelectorUI.h.Ysq);
        ((FileSelectorUI.l)localObject1).title = f.B((Context)this.YrS.getContext(), ((FileSelectorUI.j)localObject1).createTime);
        this.YrW.add(localObject1);
        break;
        k.b localb = k.b.Hf(localcc.field_content);
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
          localObject1 = com.tencent.mm.pluginsdk.model.app.n.bpU(localb.hzM);
          if (localObject1 != null)
          {
            localObject2 = new com.tencent.mm.vfs.u(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath);
            if ((!((com.tencent.mm.vfs.u)localObject2).jKS()) || (((com.tencent.mm.vfs.u)localObject2).length() != ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_totalLen)) {}
          }
          for (boolean bool = true;; bool = false)
          {
            if ((FileSelectorUI.p(this.YrS) != 0) || (bool)) {
              break label249;
            }
            Log.i("MicroMsg.FileSelectorUI", s.X("file not download, ", localb.title));
            localObject1 = null;
            break;
          }
          label249:
          long l2 = localcc.field_msgId;
          Object localObject2 = com.tencent.mm.pluginsdk.model.app.n.bpU(localb.hzM);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = as.cWJ().yi(l2);
          }
          if (localObject1 == null) {
            Log.w("MicroMsg.FileSelectorUI", "felix getAppAttachInfo is null stack[%s]", new Object[] { Util.getStack() });
          }
          for (localObject1 = null;; localObject1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath)
          {
            if (!Util.isNullOrNil((String)localObject1)) {
              break label462;
            }
            Log.e("MicroMsg.FileSelectorUI", "createFileListItem, chatting filePath is null, filter!");
            localObject1 = null;
            break;
            Log.i("MicroMsg.FileSelectorUI", "felix getAppAttachInfo info[%s], rowid[%d], isUpload[%b], fullpath[%s], totallen[%d], offset[%d], mediaSvrId[%s], mediaid[%s], msgid[%d], type[%d], stack[%s]", new Object[] { localObject1, Long.valueOf(((com.tencent.mm.pluginsdk.model.app.c)localObject1).systemRowid), Boolean.valueOf(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_isUpload), ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath, Long.valueOf(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_totalLen), Long.valueOf(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_offset), ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_mediaSvrId, ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_mediaId, Long.valueOf(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_msgInfoId), Long.valueOf(((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_type), Util.getStack() });
          }
          label462:
          localObject2 = new FileSelectorUI.j(this.YrS);
          ((FileSelectorUI.j)localObject2).msgId = localcc.field_msgId;
          ((FileSelectorUI.j)localObject2).createTime = localcc.getCreateTime();
          ((FileSelectorUI.j)localObject2).Ysx = ((CharSequence)getDisplayName(localb.hQQ));
          ((FileSelectorUI.j)localObject2).aO((CharSequence)new q(localb.title));
          ((FileSelectorUI.j)localObject2).Ysz = localb.nRd;
          ((FileSelectorUI.j)localObject2).filePath = ((String)localObject1);
          ((FileSelectorUI.j)localObject2).YsB = bool;
          Log.d("MicroMsg.FileSelectorUI", s.X("end create, cost:", Long.valueOf(System.currentTimeMillis() - l1)));
          localObject1 = localObject2;
        }
      }
    }
    Log.d("MicroMsg.FileSelectorUI", "append file item list size %d, current total size is %d(chatting)", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(this.YrW.size()) });
    AppMethodBeat.o(245720);
  }
  
  public final void b(m paramm)
  {
    AppMethodBeat.i(245747);
    s.u(paramm, "ftsResult");
    switch (paramm.resultCode)
    {
    }
    for (;;)
    {
      iOb();
      AppMethodBeat.o(245747);
      return;
      Log.i("MicroMsg.FileSelectorUI", s.X("onFTSSearchEnd, size:", Integer.valueOf(paramm.HtF.size())));
      paramm = paramm.HtF.iterator();
      while (paramm.hasNext())
      {
        o localo = (o)paramm.next();
        this.ICS.add(Long.valueOf(localo.HtI));
        Log.d("MicroMsg.FileSelectorUI", s.X("msgId:", Long.valueOf(localo.HtI)));
      }
      Log.e("MicroMsg.FileSelectorUI", s.X("get msgId fail, errorCode:", Integer.valueOf(paramm.resultCode)));
    }
  }
  
  final void iNZ()
  {
    AppMethodBeat.i(245741);
    if (this.HtE != null) {
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.HtE);
    }
    AppMethodBeat.o(245741);
  }
  
  public final void iOd()
  {
    AppMethodBeat.i(245751);
    this.hasInit = false;
    setStartIndex(0);
    axe(30);
    iOc();
    AppMethodBeat.o(245751);
  }
  
  public final void iOe()
  {
    AppMethodBeat.i(245754);
    iOc();
    AppMethodBeat.o(245754);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements a<ah>
  {
    a(FileSelectorUI.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.a
 * JD-Core Version:    0.7.0.1
 */