package com.tencent.mm.plugin.webview.emojistore.ui;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.h;
import com.tencent.mm.g.b.a.cj;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.vfs.i;
import d.l;
import d.n.n;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/emojistore/ui/MenuItemSelectListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "data", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager;", "position", "", "(Landroid/content/Context;Lcom/tencent/mm/emoji/model/panel/EmojiItem;Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager;I)V", "getContext", "()Landroid/content/Context;", "getData", "()Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager;", "getItem", "()Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "getPosition", "()I", "doAddAction", "", "md5", "", "designerID", "thumbUrl", "activityId", "onMMMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", "index", "plugin-webview_release"})
public final class b
  implements n.d
{
  private final h ANT;
  private final c ANU;
  private final Context context;
  private final int position;
  
  public b(Context paramContext, h paramh, c paramc, int paramInt)
  {
    AppMethodBeat.i(188874);
    this.context = paramContext;
    this.ANT = paramh;
    this.ANU = paramc;
    this.position = paramInt;
    AppMethodBeat.o(188874);
  }
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(188873);
    if (paramMenuItem != null) {
      switch (paramMenuItem.getItemId())
      {
      }
    }
    do
    {
      AppMethodBeat.o(188873);
      return;
      localObject4 = this.ANT;
    } while (localObject4 == null);
    Object localObject1 = ((h)localObject4).fLP.JS();
    paramMenuItem = (MenuItem)localObject1;
    if (localObject1 == null) {
      paramMenuItem = "";
    }
    Object localObject2 = ((h)localObject4).fLP.field_designerID;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    Object localObject3 = ((h)localObject4).fLP.field_thumbUrl;
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = "";
    }
    Object localObject4 = ((h)localObject4).fLP.field_activityid;
    localObject3 = localObject4;
    if (localObject4 == null) {
      localObject3 = "";
    }
    cj localcj = new cj();
    localcj.QB();
    localcj.iY(this.ANU.oEK);
    localcj.iZ(this.ANU.oEK);
    localObject4 = this.ANT;
    if (localObject4 != null)
    {
      localObject4 = ((h)localObject4).fLP;
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
    localcj.ja((String)localObject4);
    localObject4 = this.ANU.ANX;
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
    localcj.jb((String)localObject4);
    localcj.fa(this.ANU.offset);
    localcj.fb(this.position);
    localcj.fc(System.currentTimeMillis());
    localcj.jc(this.ANU.oEK);
    localcj.fd(2L);
    localcj.aBj();
    localObject4 = new StringBuilder("report19651 ");
    String str = localcj.PW();
    d.g.b.k.g(str, "struct.toShowString()");
    ad.i("MicroMsg.WebSearch.SosSimilarUI", n.h(str, "\r\n", " ", false));
    localObject4 = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr();
    d.g.b.k.g(localObject4, "SubCoreEmoji.getEmojiStorageMgr()");
    localObject4 = ((aw)localObject4).bxR().aJx(paramMenuItem);
    str = EmojiLogic.P(com.tencent.mm.plugin.emoji.h.b.aqb(), "", paramMenuItem);
    if (localObject4 == null) {
      if (t.aFm(str))
      {
        paramInt = EmojiInfo.LBY;
        localObject4 = new EmojiInfo();
        ((EmojiInfo)localObject4).Cb(paramMenuItem);
        ((EmojiInfo)localObject4).aim(EmojiInfo.LBQ);
        ((EmojiInfo)localObject4).setType(paramInt);
        ((EmojiInfo)localObject4).setSize((int)i.aMN(str));
        ((EmojiInfo)localObject4).fZU();
        ((EmojiInfo)localObject4).field_designerID = ((String)localObject1);
        ((EmojiInfo)localObject4).field_thumbUrl = ((String)localObject2);
        ((EmojiInfo)localObject4).field_activityid = ((String)localObject3);
        paramMenuItem = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr();
        d.g.b.k.g(paramMenuItem, "SubCoreEmoji.getEmojiStorageMgr()");
        paramMenuItem.bxR().J((EmojiInfo)localObject4);
      }
    }
    for (paramMenuItem = (MenuItem)localObject4;; paramMenuItem = (MenuItem)localObject4)
    {
      ad.i("MicroMsg.WebSearch.SosSimilarUI", "doAddAction %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.emoji.model.k.bUZ().a(this.context, paramMenuItem, 18, u.aqG())) });
      localObject2 = new cj();
      ((cj)localObject2).QB();
      ((cj)localObject2).iY(this.ANU.oEK);
      ((cj)localObject2).iZ(this.ANU.oEK);
      paramMenuItem = this.ANT;
      if (paramMenuItem != null)
      {
        paramMenuItem = paramMenuItem.fLP;
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
      ((cj)localObject2).ja(paramMenuItem);
      paramMenuItem = this.ANU.ANX;
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
      ((cj)localObject2).jb(paramMenuItem);
      ((cj)localObject2).fa(this.ANU.offset);
      ((cj)localObject2).fb(this.position);
      ((cj)localObject2).fc(System.currentTimeMillis());
      ((cj)localObject2).jc(this.ANU.oEK);
      ((cj)localObject2).fd(3L);
      ((cj)localObject2).aBj();
      paramMenuItem = new StringBuilder("report19651 ");
      localObject1 = ((cj)localObject2).PW();
      d.g.b.k.g(localObject1, "struct.toShowString()");
      ad.i("MicroMsg.WebSearch.SosSimilarUI", n.h((String)localObject1, "\r\n", " ", false));
      AppMethodBeat.o(188873);
      return;
      paramInt = EmojiInfo.LBX;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.emojistore.ui.b
 * JD-Core Version:    0.7.0.1
 */