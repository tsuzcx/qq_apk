package com.tencent.mm.plugin.webview.emojistore.ui;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.h;
import com.tencent.mm.g.b.a.ev;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.vfs.i;
import d.g.b.p;
import d.l;
import d.n.n;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/emojistore/ui/MenuItemSelectListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "data", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager;", "position", "", "(Landroid/content/Context;Lcom/tencent/mm/emoji/model/panel/EmojiItem;Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager;I)V", "getContext", "()Landroid/content/Context;", "getData", "()Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager;", "getItem", "()Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "getPosition", "()I", "doAddAction", "", "md5", "", "designerID", "thumbUrl", "activityId", "onMMMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", "index", "plugin-webview_release"})
public final class b
  implements n.e
{
  private final h DJo;
  private final c DJp;
  private final Context context;
  private final int position;
  
  public b(Context paramContext, h paramh, c paramc, int paramInt)
  {
    AppMethodBeat.i(207570);
    this.context = paramContext;
    this.DJo = paramh;
    this.DJp = paramc;
    this.position = paramInt;
    AppMethodBeat.o(207570);
  }
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(207569);
    if (paramMenuItem != null) {
      switch (paramMenuItem.getItemId())
      {
      }
    }
    do
    {
      AppMethodBeat.o(207569);
      return;
      localObject4 = this.DJo;
    } while (localObject4 == null);
    Object localObject1 = ((h)localObject4).gjb.Lb();
    paramMenuItem = (MenuItem)localObject1;
    if (localObject1 == null) {
      paramMenuItem = "";
    }
    Object localObject2 = ((h)localObject4).gjb.field_designerID;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    Object localObject3 = ((h)localObject4).gjb.field_thumbUrl;
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = "";
    }
    Object localObject4 = ((h)localObject4).gjb.field_activityid;
    localObject3 = localObject4;
    if (localObject4 == null) {
      localObject3 = "";
    }
    ev localev = new ev();
    localev.Tk();
    localev.nY(this.DJp.pLL);
    localev.nZ(this.DJp.pLL);
    localObject4 = this.DJo;
    if (localObject4 != null)
    {
      localObject4 = ((h)localObject4).gjb;
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
    localev.oa((String)localObject4);
    localObject4 = this.DJp.DJs;
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
    localev.ob((String)localObject4);
    localev.jZ(this.DJp.offset);
    localev.ka(this.position);
    localev.kb(System.currentTimeMillis());
    localev.oc(this.DJp.pLL);
    localev.kc(2L);
    localev.aLk();
    localObject4 = new StringBuilder("report19651 ");
    String str = localev.RE();
    p.g(str, "struct.toShowString()");
    ad.i("MicroMsg.WebSearch.SosSimilarUI", n.h(str, "\r\n", " ", false));
    localObject4 = k.getEmojiStorageMgr();
    p.g(localObject4, "SubCoreEmoji.getEmojiStorageMgr()");
    localObject4 = ((bd)localObject4).bIW().aUK(paramMenuItem);
    str = EmojiLogic.Q(com.tencent.mm.plugin.emoji.h.b.azF(), "", paramMenuItem);
    if (localObject4 == null) {
      if (t.aQj(str))
      {
        paramInt = EmojiInfo.OeV;
        localObject4 = new EmojiInfo();
        ((EmojiInfo)localObject4).Jt(paramMenuItem);
        ((EmojiInfo)localObject4).amj(EmojiInfo.OeN);
        ((EmojiInfo)localObject4).setType(paramInt);
        ((EmojiInfo)localObject4).setSize((int)i.aYo(str));
        ((EmojiInfo)localObject4).gzK();
        ((EmojiInfo)localObject4).field_designerID = ((String)localObject1);
        ((EmojiInfo)localObject4).field_thumbUrl = ((String)localObject2);
        ((EmojiInfo)localObject4).field_activityid = ((String)localObject3);
        paramMenuItem = k.getEmojiStorageMgr();
        p.g(paramMenuItem, "SubCoreEmoji.getEmojiStorageMgr()");
        paramMenuItem.bIW().I((EmojiInfo)localObject4);
      }
    }
    for (paramMenuItem = (MenuItem)localObject4;; paramMenuItem = (MenuItem)localObject4)
    {
      ad.i("MicroMsg.WebSearch.SosSimilarUI", "doAddAction %b", new Object[] { Boolean.valueOf(k.cgQ().a(this.context, paramMenuItem, 18, u.aAm())) });
      localObject2 = new ev();
      ((ev)localObject2).Tk();
      ((ev)localObject2).nY(this.DJp.pLL);
      ((ev)localObject2).nZ(this.DJp.pLL);
      paramMenuItem = this.DJo;
      if (paramMenuItem != null)
      {
        paramMenuItem = paramMenuItem.gjb;
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
      ((ev)localObject2).oa(paramMenuItem);
      paramMenuItem = this.DJp.DJs;
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
      ((ev)localObject2).ob(paramMenuItem);
      ((ev)localObject2).jZ(this.DJp.offset);
      ((ev)localObject2).ka(this.position);
      ((ev)localObject2).kb(System.currentTimeMillis());
      ((ev)localObject2).oc(this.DJp.pLL);
      ((ev)localObject2).kc(3L);
      ((ev)localObject2).aLk();
      paramMenuItem = new StringBuilder("report19651 ");
      localObject1 = ((ev)localObject2).RE();
      p.g(localObject1, "struct.toShowString()");
      ad.i("MicroMsg.WebSearch.SosSimilarUI", n.h((String)localObject1, "\r\n", " ", false));
      AppMethodBeat.o(207569);
      return;
      paramInt = EmojiInfo.OeU;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.emojistore.ui.b
 * JD-Core Version:    0.7.0.1
 */