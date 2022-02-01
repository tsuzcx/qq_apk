package com.tencent.mm.plugin.webview.emojistore.ui;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.g.b.a.ig;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/emojistore/ui/MenuItemSelectListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "data", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager;", "position", "", "(Landroid/content/Context;Lcom/tencent/mm/emoji/model/panel/EmojiItem;Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager;I)V", "getContext", "()Landroid/content/Context;", "getData", "()Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager;", "getItem", "()Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "getPosition", "()I", "doAddAction", "", "md5", "", "designerID", "thumbUrl", "activityId", "getReportScene", "", "onMMMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", "index", "plugin-webview_release"})
public final class b
  implements o.g
{
  private final h INy;
  private final c INz;
  private final Context context;
  private final int position;
  
  public b(Context paramContext, h paramh, c paramc, int paramInt)
  {
    AppMethodBeat.i(210289);
    this.context = paramContext;
    this.INy = paramh;
    this.INz = paramc;
    this.position = paramInt;
    AppMethodBeat.o(210289);
  }
  
  private long gaq()
  {
    AppMethodBeat.i(210287);
    if (this.INz.gau())
    {
      AppMethodBeat.o(210287);
      return 59L;
    }
    AppMethodBeat.o(210287);
    return 78L;
  }
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(210288);
    if (paramMenuItem != null) {
      switch (paramMenuItem.getItemId())
      {
      }
    }
    Object localObject2;
    do
    {
      AppMethodBeat.o(210288);
      return;
      localObject2 = this.INy;
    } while (localObject2 == null);
    paramMenuItem = ((h)localObject2).gWm.getMd5();
    if (paramMenuItem == null) {
      paramMenuItem = "";
    }
    for (;;)
    {
      String str = ((h)localObject2).gWm.field_designerID;
      if (str == null) {
        str = "";
      }
      for (;;)
      {
        Object localObject1 = ((h)localObject2).gWm.field_thumbUrl;
        if (localObject1 == null) {
          localObject1 = "";
        }
        for (;;)
        {
          localObject2 = ((h)localObject2).gWm.field_activityid;
          if (localObject2 == null) {
            localObject2 = "";
          }
          for (;;)
          {
            Object localObject5 = new ig();
            ((ig)localObject5).ri(gaq());
            ((ig)localObject5).vZ(this.INz.sessionId);
            ((ig)localObject5).wa(this.INz.rjq);
            Object localObject3 = this.INy;
            if (localObject3 != null)
            {
              localObject3 = ((h)localObject3).gWm;
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
            ((ig)localObject5).wb((String)localObject3);
            localObject3 = this.INz.INC;
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
            ((ig)localObject5).wc((String)localObject3);
            ((ig)localObject5).rj(this.INz.offset);
            ((ig)localObject5).rk(this.position);
            ((ig)localObject5).rl(System.currentTimeMillis());
            ((ig)localObject5).wd(this.INz.rjq);
            ((ig)localObject5).rm(2L);
            ((ig)localObject5).bfK();
            ar.a((a)localObject5);
            localObject3 = k.getEmojiStorageMgr();
            p.g(localObject3, "SubCoreEmoji.getEmojiStorageMgr()");
            Object localObject4 = ((bj)localObject3).cgN().blk(paramMenuItem);
            localObject5 = EmojiLogic.W(com.tencent.mm.plugin.emoji.h.b.aTd(), "", paramMenuItem);
            localObject3 = localObject4;
            if (localObject4 == null) {
              if (!ImgUtil.isGif((String)localObject5)) {
                break label696;
              }
            }
            label696:
            for (paramInt = EmojiInfo.Uux;; paramInt = EmojiInfo.Uuw)
            {
              localObject3 = new EmojiInfo();
              ((EmojiInfo)localObject3).setMd5(paramMenuItem);
              ((EmojiInfo)localObject3).awx(EmojiInfo.Uup);
              ((EmojiInfo)localObject3).setType(paramInt);
              ((EmojiInfo)localObject3).setSize((int)s.boW((String)localObject5));
              ((EmojiInfo)localObject3).hRG();
              ((EmojiInfo)localObject3).field_designerID = str;
              ((EmojiInfo)localObject3).field_thumbUrl = ((String)localObject1);
              ((EmojiInfo)localObject3).field_activityid = ((String)localObject2);
              paramMenuItem = k.getEmojiStorageMgr();
              p.g(paramMenuItem, "SubCoreEmoji.getEmojiStorageMgr()");
              paramMenuItem.cgN().J((EmojiInfo)localObject3);
              Log.i("MicroMsg.WebSearch.SosSimilarUI", "doAddAction %b", new Object[] { Boolean.valueOf(k.cGf().a(this.context, (EmojiInfo)localObject3, 18, z.aTY())) });
              localObject1 = new ig();
              ((ig)localObject1).ri(gaq());
              ((ig)localObject1).vZ(this.INz.rjq);
              ((ig)localObject1).wa(this.INz.rjq);
              paramMenuItem = this.INy;
              if (paramMenuItem != null)
              {
                paramMenuItem = paramMenuItem.gWm;
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
              ((ig)localObject1).wb(paramMenuItem);
              paramMenuItem = this.INz.INC;
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
              ((ig)localObject1).wc(paramMenuItem);
              ((ig)localObject1).rj(this.INz.offset);
              ((ig)localObject1).rk(this.position);
              ((ig)localObject1).rl(System.currentTimeMillis());
              ((ig)localObject1).wd(this.INz.rjq);
              ((ig)localObject1).rm(3L);
              ((ig)localObject1).bfK();
              ar.a((a)localObject1);
              AppMethodBeat.o(210288);
              return;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.emojistore.ui.b
 * JD-Core Version:    0.7.0.1
 */