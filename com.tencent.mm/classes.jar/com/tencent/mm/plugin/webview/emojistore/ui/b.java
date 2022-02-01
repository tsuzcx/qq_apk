package com.tencent.mm.plugin.webview.emojistore.ui;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ng;
import com.tencent.mm.emoji.c.b.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.g.d;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.s;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/emojistore/ui/MenuItemSelectListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "data", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager;", "position", "", "(Landroid/content/Context;Lcom/tencent/mm/emoji/model/panel/EmojiItem;Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager;I)V", "getContext", "()Landroid/content/Context;", "getData", "()Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager;", "getItem", "()Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "getPosition", "()I", "doAddAction", "", "md5", "", "designerID", "thumbUrl", "activityId", "getReportScene", "", "onMMMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", "index", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements u.i
{
  private final h WAj;
  private final c WAk;
  private final Context context;
  private final int position;
  
  public b(Context paramContext, h paramh, c paramc, int paramInt)
  {
    AppMethodBeat.i(294749);
    this.context = paramContext;
    this.WAj = paramh;
    this.WAk = paramc;
    this.position = paramInt;
    AppMethodBeat.o(294749);
  }
  
  private long isY()
  {
    AppMethodBeat.i(294753);
    if (this.WAk.itb())
    {
      AppMethodBeat.o(294753);
      return 59L;
    }
    AppMethodBeat.o(294753);
    return 78L;
  }
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(294757);
    String str1;
    Object localObject1;
    label60:
    label78:
    label96:
    Object localObject2;
    if ((paramMenuItem != null) && (paramMenuItem.getItemId() == 0))
    {
      paramMenuItem = this.WAj;
      if (paramMenuItem != null)
      {
        str1 = paramMenuItem.mgK.getMd5();
        if (str1 != null) {
          break label551;
        }
        str1 = "";
        localObject1 = paramMenuItem.mgK.field_designerID;
        if (localObject1 != null) {
          break label554;
        }
        localObject1 = "";
        String str2 = paramMenuItem.mgK.field_thumbUrl;
        if (str2 != null) {
          break label557;
        }
        str2 = "";
        String str3 = paramMenuItem.mgK.field_activityid;
        if (str3 != null) {
          break label560;
        }
        str3 = "";
        Object localObject3 = new ng();
        ((ng)localObject3).iqr = isY();
        ((ng)localObject3).vA(this.WAk.sessionId);
        ((ng)localObject3).vB(this.WAk.xVe);
        paramMenuItem = this.WAj;
        if (paramMenuItem != null) {
          break label563;
        }
        paramMenuItem = "";
        label152:
        ((ng)localObject3).vC(paramMenuItem);
        paramMenuItem = this.WAk.WAo;
        if (paramMenuItem != null) {
          break label598;
        }
        paramMenuItem = "";
        label174:
        ((ng)localObject3).vD(paramMenuItem);
        ((ng)localObject3).jeA = this.WAk.offset;
        ((ng)localObject3).jeB = this.position;
        ((ng)localObject3).ivT = System.currentTimeMillis();
        ((ng)localObject3).vE(this.WAk.xVe);
        ((ng)localObject3).ioV = 2L;
        ((ng)localObject3).bMH();
        as.a((a)localObject3);
        localObject2 = s.getEmojiStorageMgr().adju.bza(str1);
        localObject3 = EmojiLogic.W(d.bzQ(), "", str1);
        paramMenuItem = (MenuItem)localObject2;
        if (localObject2 == null)
        {
          if (!ImgUtil.isGif((String)localObject3)) {
            break label618;
          }
          paramInt = EmojiInfo.aklO;
          label290:
          paramMenuItem = new EmojiInfo();
          paramMenuItem.field_md5 = str1;
          paramMenuItem.field_catalog = EmojiInfo.aklG;
          paramMenuItem.field_type = paramInt;
          paramMenuItem.field_size = ((int)y.bEl((String)localObject3));
          paramMenuItem.field_temp = 1;
          paramMenuItem.field_designerID = ((String)localObject1);
          paramMenuItem.field_thumbUrl = str2;
          paramMenuItem.field_activityid = str3;
          s.getEmojiStorageMgr().adju.K(paramMenuItem);
        }
        Log.i("MicroMsg.WebSearch.SosSimilarUI", "doAddAction %b", new Object[] { Boolean.valueOf(s.dAl().a(this.context, paramMenuItem, 18, z.bAM())) });
        localObject1 = new ng();
        ((ng)localObject1).iqr = isY();
        ((ng)localObject1).vA(this.WAk.xVe);
        ((ng)localObject1).vB(this.WAk.xVe);
        paramMenuItem = this.WAj;
        if (paramMenuItem != null) {
          break label625;
        }
        paramMenuItem = "";
        label450:
        ((ng)localObject1).vC(paramMenuItem);
        paramMenuItem = this.WAk.WAo;
        if (paramMenuItem != null) {
          break label657;
        }
        paramMenuItem = "";
      }
    }
    for (;;)
    {
      ((ng)localObject1).vD(paramMenuItem);
      ((ng)localObject1).jeA = this.WAk.offset;
      ((ng)localObject1).jeB = this.position;
      ((ng)localObject1).ivT = System.currentTimeMillis();
      ((ng)localObject1).vE(this.WAk.xVe);
      ((ng)localObject1).ioV = 3L;
      ((ng)localObject1).bMH();
      as.a((a)localObject1);
      AppMethodBeat.o(294757);
      return;
      label551:
      break;
      label554:
      break label60;
      label557:
      break label78;
      label560:
      break label96;
      label563:
      paramMenuItem = paramMenuItem.mgK;
      if (paramMenuItem == null)
      {
        paramMenuItem = "";
        break label152;
      }
      localObject2 = paramMenuItem.field_md5;
      paramMenuItem = (MenuItem)localObject2;
      if (localObject2 != null) {
        break label152;
      }
      paramMenuItem = "";
      break label152;
      label598:
      localObject2 = paramMenuItem.emojiMD5;
      paramMenuItem = (MenuItem)localObject2;
      if (localObject2 != null) {
        break label174;
      }
      paramMenuItem = "";
      break label174;
      label618:
      paramInt = EmojiInfo.aklN;
      break label290;
      label625:
      paramMenuItem = paramMenuItem.mgK;
      if (paramMenuItem == null)
      {
        paramMenuItem = "";
        break label450;
      }
      str1 = paramMenuItem.field_md5;
      paramMenuItem = str1;
      if (str1 != null) {
        break label450;
      }
      paramMenuItem = "";
      break label450;
      label657:
      str1 = paramMenuItem.emojiMD5;
      paramMenuItem = str1;
      if (str1 == null) {
        paramMenuItem = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.emojistore.ui.b
 * JD-Core Version:    0.7.0.1
 */