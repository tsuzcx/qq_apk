package com.tencent.mm.plugin.webview.emojistore.ui;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.h;
import com.tencent.mm.g.b.a.dx;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.vfs.i;
import d.l;
import d.n.n;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/emojistore/ui/MenuItemSelectListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "data", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager;", "position", "", "(Landroid/content/Context;Lcom/tencent/mm/emoji/model/panel/EmojiItem;Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager;I)V", "getContext", "()Landroid/content/Context;", "getData", "()Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager;", "getItem", "()Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "getPosition", "()I", "doAddAction", "", "md5", "", "designerID", "thumbUrl", "activityId", "onMMMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", "index", "plugin-webview_release"})
public final class b
  implements n.d
{
  private final h Cgl;
  private final c Cgm;
  private final Context context;
  private final int position;
  
  public b(Context paramContext, h paramh, c paramc, int paramInt)
  {
    AppMethodBeat.i(189443);
    this.context = paramContext;
    this.Cgl = paramh;
    this.Cgm = paramc;
    this.position = paramInt;
    AppMethodBeat.o(189443);
  }
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(189442);
    if (paramMenuItem != null) {
      switch (paramMenuItem.getItemId())
      {
      }
    }
    do
    {
      AppMethodBeat.o(189442);
      return;
      localObject4 = this.Cgl;
    } while (localObject4 == null);
    Object localObject1 = ((h)localObject4).fPB.JC();
    paramMenuItem = (MenuItem)localObject1;
    if (localObject1 == null) {
      paramMenuItem = "";
    }
    Object localObject2 = ((h)localObject4).fPB.field_designerID;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    Object localObject3 = ((h)localObject4).fPB.field_thumbUrl;
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = "";
    }
    Object localObject4 = ((h)localObject4).fPB.field_activityid;
    localObject3 = localObject4;
    if (localObject4 == null) {
      localObject3 = "";
    }
    dx localdx = new dx();
    localdx.Rd();
    localdx.lO(this.Cgm.pik);
    localdx.lP(this.Cgm.pik);
    localObject4 = this.Cgl;
    if (localObject4 != null)
    {
      localObject4 = ((h)localObject4).fPB;
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
    localdx.lQ((String)localObject4);
    localObject4 = this.Cgm.Cgp;
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
    localdx.lR((String)localObject4);
    localdx.in(this.Cgm.offset);
    localdx.io(this.position);
    localdx.ip(System.currentTimeMillis());
    localdx.lS(this.Cgm.pik);
    localdx.iq(2L);
    localdx.aHZ();
    localObject4 = new StringBuilder("report19651 ");
    String str = localdx.PS();
    d.g.b.k.g(str, "struct.toShowString()");
    ac.i("MicroMsg.WebSearch.SosSimilarUI", n.h(str, "\r\n", " ", false));
    localObject4 = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr();
    d.g.b.k.g(localObject4, "SubCoreEmoji.getEmojiStorageMgr()");
    localObject4 = ((az)localObject4).bEN().aOT(paramMenuItem);
    str = EmojiLogic.P(com.tencent.mm.plugin.emoji.h.b.awQ(), "", paramMenuItem);
    if (localObject4 == null) {
      if (s.aKD(str))
      {
        paramInt = EmojiInfo.KfZ;
        localObject4 = new EmojiInfo();
        ((EmojiInfo)localObject4).Ge(paramMenuItem);
        ((EmojiInfo)localObject4).ajs(EmojiInfo.Jss);
        ((EmojiInfo)localObject4).setType(paramInt);
        ((EmojiInfo)localObject4).setSize((int)i.aSp(str));
        ((EmojiInfo)localObject4).fFc();
        ((EmojiInfo)localObject4).field_designerID = ((String)localObject1);
        ((EmojiInfo)localObject4).field_thumbUrl = ((String)localObject2);
        ((EmojiInfo)localObject4).field_activityid = ((String)localObject3);
        paramMenuItem = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr();
        d.g.b.k.g(paramMenuItem, "SubCoreEmoji.getEmojiStorageMgr()");
        paramMenuItem.bEN().J((EmojiInfo)localObject4);
      }
    }
    for (paramMenuItem = (MenuItem)localObject4;; paramMenuItem = (MenuItem)localObject4)
    {
      ac.i("MicroMsg.WebSearch.SosSimilarUI", "doAddAction %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.emoji.model.k.ccm().a(this.context, paramMenuItem, 18, u.axw())) });
      localObject2 = new dx();
      ((dx)localObject2).Rd();
      ((dx)localObject2).lO(this.Cgm.pik);
      ((dx)localObject2).lP(this.Cgm.pik);
      paramMenuItem = this.Cgl;
      if (paramMenuItem != null)
      {
        paramMenuItem = paramMenuItem.fPB;
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
      ((dx)localObject2).lQ(paramMenuItem);
      paramMenuItem = this.Cgm.Cgp;
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
      ((dx)localObject2).lR(paramMenuItem);
      ((dx)localObject2).in(this.Cgm.offset);
      ((dx)localObject2).io(this.position);
      ((dx)localObject2).ip(System.currentTimeMillis());
      ((dx)localObject2).lS(this.Cgm.pik);
      ((dx)localObject2).iq(3L);
      ((dx)localObject2).aHZ();
      paramMenuItem = new StringBuilder("report19651 ");
      localObject1 = ((dx)localObject2).PS();
      d.g.b.k.g(localObject1, "struct.toShowString()");
      ac.i("MicroMsg.WebSearch.SosSimilarUI", n.h((String)localObject1, "\r\n", " ", false));
      AppMethodBeat.o(189442);
      return;
      paramInt = EmojiInfo.KfY;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.emojistore.ui.b
 * JD-Core Version:    0.7.0.1
 */