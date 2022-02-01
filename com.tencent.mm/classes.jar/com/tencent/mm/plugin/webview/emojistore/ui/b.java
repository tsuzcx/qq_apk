package com.tencent.mm.plugin.webview.emojistore.ui;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.b.h;
import com.tencent.mm.g.b.a.ex;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;
import d.n.n;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/emojistore/ui/MenuItemSelectListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "data", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager;", "position", "", "(Landroid/content/Context;Lcom/tencent/mm/emoji/model/panel/EmojiItem;Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager;I)V", "getContext", "()Landroid/content/Context;", "getData", "()Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager;", "getItem", "()Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "getPosition", "()I", "doAddAction", "", "md5", "", "designerID", "thumbUrl", "activityId", "onMMMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", "index", "plugin-webview_release"})
public final class b
  implements n.e
{
  private final h Ebm;
  private final c Ebn;
  private final Context context;
  private final int position;
  
  public b(Context paramContext, h paramh, c paramc, int paramInt)
  {
    AppMethodBeat.i(199326);
    this.context = paramContext;
    this.Ebm = paramh;
    this.Ebn = paramc;
    this.position = paramInt;
    AppMethodBeat.o(199326);
  }
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(199325);
    if (paramMenuItem != null) {
      switch (paramMenuItem.getItemId())
      {
      }
    }
    do
    {
      AppMethodBeat.o(199325);
      return;
      localObject4 = this.Ebm;
    } while (localObject4 == null);
    Object localObject1 = ((h)localObject4).glt.Lj();
    paramMenuItem = (MenuItem)localObject1;
    if (localObject1 == null) {
      paramMenuItem = "";
    }
    Object localObject2 = ((h)localObject4).glt.field_designerID;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    Object localObject3 = ((h)localObject4).glt.field_thumbUrl;
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = "";
    }
    Object localObject4 = ((h)localObject4).glt.field_activityid;
    localObject3 = localObject4;
    if (localObject4 == null) {
      localObject3 = "";
    }
    ex localex = new ex();
    localex.Tq();
    localex.ot(this.Ebn.pSq);
    localex.ou(this.Ebn.pSq);
    localObject4 = this.Ebm;
    if (localObject4 != null)
    {
      localObject4 = ((h)localObject4).glt;
      if (localObject4 != null)
      {
        str = ((EmojiInfo)localObject4).field_md5;
        localObject4 = str;
        if (str != null) {
          break label218;
        }
      }
    }
    localObject4 = "";
    label218:
    localex.ov((String)localObject4);
    localObject4 = this.Ebn.Ebq;
    if (localObject4 != null)
    {
      str = ((SimilarEmojiQueryModel)localObject4).emojiMD5;
      localObject4 = str;
      if (str != null) {}
    }
    else
    {
      localObject4 = "";
    }
    localex.ow((String)localObject4);
    localex.kk(this.Ebn.offset);
    localex.kl(this.position);
    localex.km(System.currentTimeMillis());
    localex.ox(this.Ebn.pSq);
    localex.kn(2L);
    localex.aLH();
    localObject4 = new StringBuilder("report19651 ");
    String str = localex.RD();
    p.g(str, "struct.toShowString()");
    ae.i("MicroMsg.WebSearch.SosSimilarUI", n.h(str, "\r\n", " ", false));
    localObject4 = k.getEmojiStorageMgr();
    p.g(localObject4, "SubCoreEmoji.getEmojiStorageMgr()");
    localObject4 = ((be)localObject4).bJU().aWl(paramMenuItem);
    str = EmojiLogic.R(com.tencent.mm.plugin.emoji.h.b.azV(), "", paramMenuItem);
    if (localObject4 == null) {
      if (u.aRG(str))
      {
        paramInt = EmojiInfo.OAc;
        localObject4 = new EmojiInfo();
        ((EmojiInfo)localObject4).JS(paramMenuItem);
        ((EmojiInfo)localObject4).agn(EmojiInfo.OzU);
        ((EmojiInfo)localObject4).setType(paramInt);
        ((EmojiInfo)localObject4).setSize((int)o.aZR(str));
        ((EmojiInfo)localObject4).fxw();
        ((EmojiInfo)localObject4).field_designerID = ((String)localObject1);
        ((EmojiInfo)localObject4).field_thumbUrl = ((String)localObject2);
        ((EmojiInfo)localObject4).field_activityid = ((String)localObject3);
        paramMenuItem = k.getEmojiStorageMgr();
        p.g(paramMenuItem, "SubCoreEmoji.getEmojiStorageMgr()");
        paramMenuItem.bJU().I((EmojiInfo)localObject4);
      }
    }
    for (paramMenuItem = (MenuItem)localObject4;; paramMenuItem = (MenuItem)localObject4)
    {
      ae.i("MicroMsg.WebSearch.SosSimilarUI", "doAddAction %b", new Object[] { Boolean.valueOf(k.cig().a(this.context, paramMenuItem, 18, v.aAC())) });
      localObject2 = new ex();
      ((ex)localObject2).Tq();
      ((ex)localObject2).ot(this.Ebn.pSq);
      ((ex)localObject2).ou(this.Ebn.pSq);
      paramMenuItem = this.Ebm;
      if (paramMenuItem != null)
      {
        paramMenuItem = paramMenuItem.glt;
        if (paramMenuItem != null)
        {
          localObject1 = paramMenuItem.field_md5;
          paramMenuItem = (MenuItem)localObject1;
          if (localObject1 != null) {
            break label624;
          }
        }
      }
      paramMenuItem = "";
      label624:
      ((ex)localObject2).ov(paramMenuItem);
      paramMenuItem = this.Ebn.Ebq;
      if (paramMenuItem != null)
      {
        localObject1 = paramMenuItem.emojiMD5;
        paramMenuItem = (MenuItem)localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        paramMenuItem = "";
      }
      ((ex)localObject2).ow(paramMenuItem);
      ((ex)localObject2).kk(this.Ebn.offset);
      ((ex)localObject2).kl(this.position);
      ((ex)localObject2).km(System.currentTimeMillis());
      ((ex)localObject2).ox(this.Ebn.pSq);
      ((ex)localObject2).kn(3L);
      ((ex)localObject2).aLH();
      paramMenuItem = new StringBuilder("report19651 ");
      localObject1 = ((ex)localObject2).RD();
      p.g(localObject1, "struct.toShowString()");
      ae.i("MicroMsg.WebSearch.SosSimilarUI", n.h((String)localObject1, "\r\n", " ", false));
      AppMethodBeat.o(199325);
      return;
      paramInt = EmojiInfo.OAb;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.emojistore.ui.b
 * JD-Core Version:    0.7.0.1
 */