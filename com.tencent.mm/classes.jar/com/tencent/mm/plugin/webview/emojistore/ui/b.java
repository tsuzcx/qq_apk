package com.tencent.mm.plugin.webview.emojistore.ui;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.f.b.a.kn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.vfs.u;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/emojistore/ui/MenuItemSelectListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "data", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager;", "position", "", "(Landroid/content/Context;Lcom/tencent/mm/emoji/model/panel/EmojiItem;Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager;I)V", "getContext", "()Landroid/content/Context;", "getData", "()Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager;", "getItem", "()Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "getPosition", "()I", "doAddAction", "", "md5", "", "designerID", "thumbUrl", "activityId", "getReportScene", "", "onMMMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", "index", "plugin-webview_release"})
public final class b
  implements q.g
{
  private final h PJR;
  private final c PJS;
  private final Context context;
  private final int position;
  
  public b(Context paramContext, h paramh, c paramc, int paramInt)
  {
    AppMethodBeat.i(252669);
    this.context = paramContext;
    this.PJR = paramh;
    this.PJS = paramc;
    this.position = paramInt;
    AppMethodBeat.o(252669);
  }
  
  private long gTk()
  {
    AppMethodBeat.i(252658);
    if (this.PJS.gTo())
    {
      AppMethodBeat.o(252658);
      return 59L;
    }
    AppMethodBeat.o(252658);
    return 78L;
  }
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(252666);
    if (paramMenuItem != null) {
      switch (paramMenuItem.getItemId())
      {
      }
    }
    Object localObject2;
    do
    {
      AppMethodBeat.o(252666);
      return;
      localObject2 = this.PJR;
    } while (localObject2 == null);
    paramMenuItem = ((h)localObject2).jHh.getMd5();
    if (paramMenuItem == null) {
      paramMenuItem = "";
    }
    for (;;)
    {
      String str = ((h)localObject2).jHh.field_designerID;
      if (str == null) {
        str = "";
      }
      for (;;)
      {
        Object localObject1 = ((h)localObject2).jHh.field_thumbUrl;
        if (localObject1 == null) {
          localObject1 = "";
        }
        for (;;)
        {
          localObject2 = ((h)localObject2).jHh.field_activityid;
          if (localObject2 == null) {
            localObject2 = "";
          }
          for (;;)
          {
            Object localObject5 = new kn();
            ((kn)localObject5).vc(gTk());
            ((kn)localObject5).By(this.PJS.sessionId);
            ((kn)localObject5).Bz(this.PJS.uMC);
            Object localObject3 = this.PJR;
            if (localObject3 != null)
            {
              localObject3 = ((h)localObject3).jHh;
              if (localObject3 != null)
              {
                localObject4 = ((EmojiInfo)localObject3).field_md5;
                localObject3 = localObject4;
                if (localObject4 != null) {
                  break label207;
                }
              }
            }
            localObject3 = "";
            label207:
            ((kn)localObject5).BA((String)localObject3);
            localObject3 = this.PJS.PJV;
            if (localObject3 != null)
            {
              localObject4 = ((SimilarEmojiQueryModel)localObject3).emojiMD5;
              localObject3 = localObject4;
              if (localObject4 != null) {}
            }
            else
            {
              localObject3 = "";
            }
            ((kn)localObject5).BB((String)localObject3);
            ((kn)localObject5).vd(this.PJS.offset);
            ((kn)localObject5).ve(this.position);
            ((kn)localObject5).vf(System.currentTimeMillis());
            ((kn)localObject5).BC(this.PJS.uMC);
            ((kn)localObject5).vg(2L);
            ((kn)localObject5).bpa();
            ar.a((a)localObject5);
            localObject3 = com.tencent.mm.plugin.emoji.model.p.getEmojiStorageMgr();
            kotlin.g.b.p.j(localObject3, "SubCoreEmoji.getEmojiStorageMgr()");
            Object localObject4 = ((bj)localObject3).ctY().bxK(paramMenuItem);
            localObject5 = EmojiLogic.T(com.tencent.mm.plugin.emoji.i.b.bcb(), "", paramMenuItem);
            localObject3 = localObject4;
            if (localObject4 == null) {
              if (!ImgUtil.isGif((String)localObject5)) {
                break label696;
              }
            }
            label696:
            for (paramInt = EmojiInfo.YCF;; paramInt = EmojiInfo.YCE)
            {
              localObject3 = new EmojiInfo();
              ((EmojiInfo)localObject3).setMd5(paramMenuItem);
              ((EmojiInfo)localObject3).aGn(EmojiInfo.YCx);
              ((EmojiInfo)localObject3).setType(paramInt);
              ((EmojiInfo)localObject3).setSize((int)u.bBQ((String)localObject5));
              ((EmojiInfo)localObject3).hBA();
              ((EmojiInfo)localObject3).field_designerID = str;
              ((EmojiInfo)localObject3).field_thumbUrl = ((String)localObject1);
              ((EmojiInfo)localObject3).field_activityid = ((String)localObject2);
              paramMenuItem = com.tencent.mm.plugin.emoji.model.p.getEmojiStorageMgr();
              kotlin.g.b.p.j(paramMenuItem, "SubCoreEmoji.getEmojiStorageMgr()");
              paramMenuItem.ctY().K((EmojiInfo)localObject3);
              Log.i("MicroMsg.WebSearch.SosSimilarUI", "doAddAction %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.emoji.model.p.cUO().a(this.context, (EmojiInfo)localObject3, 18, z.bcZ())) });
              localObject1 = new kn();
              ((kn)localObject1).vc(gTk());
              ((kn)localObject1).By(this.PJS.uMC);
              ((kn)localObject1).Bz(this.PJS.uMC);
              paramMenuItem = this.PJR;
              if (paramMenuItem != null)
              {
                paramMenuItem = paramMenuItem.jHh;
                if (paramMenuItem != null)
                {
                  str = paramMenuItem.field_md5;
                  paramMenuItem = str;
                  if (str != null) {
                    break label580;
                  }
                }
              }
              paramMenuItem = "";
              label580:
              ((kn)localObject1).BA(paramMenuItem);
              paramMenuItem = this.PJS.PJV;
              if (paramMenuItem != null)
              {
                str = paramMenuItem.emojiMD5;
                paramMenuItem = str;
                if (str != null) {}
              }
              else
              {
                paramMenuItem = "";
              }
              ((kn)localObject1).BB(paramMenuItem);
              ((kn)localObject1).vd(this.PJS.offset);
              ((kn)localObject1).ve(this.position);
              ((kn)localObject1).vf(System.currentTimeMillis());
              ((kn)localObject1).BC(this.PJS.uMC);
              ((kn)localObject1).vg(3L);
              ((kn)localObject1).bpa();
              ar.a((a)localObject1);
              AppMethodBeat.o(252666);
              return;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.emojistore.ui.b
 * JD-Core Version:    0.7.0.1
 */