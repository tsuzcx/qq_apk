package com.tencent.mm.plugin.sns.ui.d;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.wp;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.emx;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.vfs.y;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/sheet/ShareSheet;", "", "context", "Landroid/app/Activity;", "fromScene", "", "(Landroid/app/Activity;I)V", "activity", "hasTitle", "", "style", "(Landroid/app/Activity;IZI)V", "_imgScanCodeLogic", "Lcom/tencent/mm/plugin/scanner/ScanCodeSheetItemLogic;", "getActivity", "()Landroid/app/Activity;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getBottomSheet", "()Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "bottomSheet$delegate", "Lkotlin/Lazy;", "getFromScene", "()I", "getHasTitle", "()Z", "value", "imgScanCodeLogic", "getImgScanCodeLogic", "()Lcom/tencent/mm/plugin/scanner/ScanCodeSheetItemLogic;", "setImgScanCodeLogic", "(Lcom/tencent/mm/plugin/scanner/ScanCodeSheetItemLogic;)V", "showQbar", "getShowQbar", "setShowQbar", "(Z)V", "startTime", "", "getStartTime", "()J", "setStartTime", "(J)V", "getStyle", "addMenu", "", "Landroid/content/Context;", "items", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "addQuickShare", "snsInfo", "Lcom/tencent/mm/plugin/sns/storage/SnsInfo;", "media", "Lcom/tencent/mm/protocal/protobuf/MediaObj;", "getMediaPath", "", "isPhoto", "getRecentReportInfo", "Lcom/tencent/mm/protocal/protobuf/RecentForwardReportInfo;", "getThumbBitmap", "Landroid/graphics/Bitmap;", "path", "getVideoThumb", "imagePath", "isPhotoType", "isShowing", "reportMenuType", "menuId", "setOnFooterMenuSelectedListener", "listener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "setOnSheetDismissListener", "dismissCb", "Lkotlin/Function0;", "setSheetSelectedListener", "menuItemSelectedListener", "shareSendImg", "toUsers", "editText", "tryShow", "updateSheetMenus", "firstMenuItems", "sencondItems", "cancel", "", "Companion", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final a RUl;
  private static final int[] RUo;
  private static final HashMap<Integer, b> RUp;
  final boolean Nfh;
  private final j RUm;
  public ScanCodeSheetItemLogic RUn;
  public boolean RdW;
  final Activity activity;
  private final int fromScene;
  private long startTime;
  private final int style;
  
  static
  {
    AppMethodBeat.i(308969);
    RUl = new a((byte)0);
    RUo = new int[] { 1003, 1006, 1010 };
    HashMap localHashMap = new HashMap();
    RUp = localHashMap;
    ((Map)localHashMap).put(Integer.valueOf(-1), new b(b.j.sns_del_sns, b.i.icons_outlined_delete, 0, 4));
    ((Map)RUp).put(Integer.valueOf(1000), new b(b.j.sns_set_private, b.i.icons_outlined_lock, 0, 4));
    ((Map)RUp).put(Integer.valueOf(1002), new b(b.j.save_img_to_local, b.i.icons_outlined_download, 0, 4));
    ((Map)RUp).put(Integer.valueOf(1003), new b(b.j.sns_post_to, b.i.icons_filled_share, b.c.Brand));
    ((Map)RUp).put(Integer.valueOf(1004), new b(b.j.sns_expose_sns, 0, 0, 6));
    ((Map)RUp).put(Integer.valueOf(1005), new b(b.j.sns_set_open, b.i.icons_outlined_lock_on, 0, 4));
    ((Map)RUp).put(Integer.valueOf(1006), new b(b.j.plugin_favorite_opt, b.i.bottomsheet_icon_fav, b.c.transparent));
    ((Map)RUp).put(Integer.valueOf(1008), new b(b.j.app_open, b.i.icons_outlined_open, 0, 4));
    ((Map)RUp).put(Integer.valueOf(1009), new b(b.j.chatting_image_long_click_photo_trans_short, b.i.icons_outlined_translate, 0, 4));
    ((Map)RUp).put(Integer.valueOf(1010), new b(b.j.find_friends_search, b.i.icons_filled_search_logo, b.c.Red));
    ((Map)RUp).put(Integer.valueOf(1011), new b(b.j.chatting_image_long_click_image_ocr, b.i.icons_outlined_ocr, 0, 4));
    ((Map)RUp).put(Integer.valueOf(1012), new b(b.j.chatting_image_long_click_photo_edit, b.i.icons_outlined_pencil, 0, 4));
    ((Map)RUp).put(Integer.valueOf(1013), new b(b.j.save_video_to_local, b.i.icons_outlined_download, 0, 4));
    ((Map)RUp).put(Integer.valueOf(1014), new b(b.j.sns_save_to_sns, b.i.icons_outlined_download, 0, 4));
    AppMethodBeat.o(308969);
  }
  
  public c(Activity paramActivity, int paramInt)
  {
    this(paramActivity, paramInt, 0);
    AppMethodBeat.i(308918);
    AppMethodBeat.o(308918);
  }
  
  public c(Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(308910);
    this.activity = paramActivity;
    this.fromScene = paramInt1;
    this.Nfh = false;
    this.style = paramInt2;
    this.RUm = kotlin.k.cm((kotlin.g.a.a)new c(this));
    paramActivity = hsf();
    if (paramActivity != null) {
      paramActivity.scene = this.fromScene;
    }
    AppMethodBeat.o(308910);
  }
  
  public static Bitmap Pf(String paramString)
  {
    AppMethodBeat.i(308932);
    kotlin.g.b.s.u(paramString, "imagePath");
    paramString = BitmapUtil.getBitmapNative(paramString);
    AppMethodBeat.o(308932);
    return paramString;
  }
  
  public static String a(boolean paramBoolean, dmz paramdmz)
  {
    AppMethodBeat.i(308925);
    kotlin.g.b.s.u(paramdmz, "media");
    if (paramBoolean)
    {
      paramdmz = kotlin.g.b.s.X(as.mg(al.getAccSnsPath(), paramdmz.Id), t.k(paramdmz));
      AppMethodBeat.o(308925);
      return paramdmz;
    }
    String str = as.mg(al.getAccSnsPath(), paramdmz.Id);
    if (y.ZC(kotlin.g.b.s.X(str, t.i(paramdmz))))
    {
      paramdmz = kotlin.g.b.s.X(str, t.d(paramdmz));
      AppMethodBeat.o(308925);
      return paramdmz;
    }
    AppMethodBeat.o(308925);
    return "";
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, dmz paramdmz)
  {
    AppMethodBeat.i(308938);
    kotlin.g.b.s.u(paramActivity, "activity");
    kotlin.g.b.s.u(paramString1, "toUsers");
    kotlin.g.b.s.u(paramdmz, "media");
    Object localObject = com.tencent.mm.pluginsdk.m.a.YvC;
    kotlin.g.b.s.u(paramString1, "userName");
    if (!TextUtils.isEmpty((CharSequence)paramString2))
    {
      localObject = new wp();
      ((wp)localObject).iak.hgl = paramString1;
      ((wp)localObject).iak.content = paramString2;
      ((wp)localObject).iak.type = ab.IX(paramString1);
      ((wp)localObject).iak.flags = 0;
      ((wp)localObject).publish();
    }
    paramString2 = kotlin.g.b.s.X(as.mg(al.getAccSnsPath(), paramdmz.Id), t.k(paramdmz));
    g.gaI().a((Context)paramActivity, paramString1, paramString2, 0, "", "", -1L, null);
    com.tencent.mm.ui.widget.snackbar.b.u(paramActivity, paramActivity.getString(b.j.has_send));
    AppMethodBeat.o(308938);
  }
  
  private static void a(Context paramContext, int[] paramArrayOfInt, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(308922);
    params.clear();
    int j = paramArrayOfInt.length;
    int i = 0;
    if (i < j)
    {
      int k = paramArrayOfInt[i];
      b localb = (b)RUp.get(Integer.valueOf(k));
      if (localb != null)
      {
        if (localb.RUj != -1) {
          break label83;
        }
        params.c(k, (CharSequence)paramContext.getString(localb.RUi));
      }
      for (;;)
      {
        i += 1;
        break;
        label83:
        if (localb.RUk == -1) {
          params.a(k, (CharSequence)paramContext.getString(localb.RUi), localb.RUj);
        } else {
          params.a(k, (CharSequence)paramContext.getString(localb.RUi), localb.RUj, paramContext.getResources().getColor(localb.RUk));
        }
      }
    }
    AppMethodBeat.o(308922);
  }
  
  private static final void a(c paramc, int[] paramArrayOfInt, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(308942);
    kotlin.g.b.s.u(paramc, "this$0");
    paramc = (Context)paramc.activity;
    kotlin.g.b.s.s(params, "menu");
    a(paramc, paramArrayOfInt, params);
    AppMethodBeat.o(308942);
  }
  
  private static final void a(u.i parami, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(308954);
    kotlin.g.b.s.u(parami, "$listener");
    parami.onMMMenuItemSelected(paramMenuItem, paramInt);
    AppMethodBeat.o(308954);
  }
  
  private static final void a(u.i parami, c paramc, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(308961);
    kotlin.g.b.s.u(parami, "$menuItemSelectedListener");
    kotlin.g.b.s.u(paramc, "this$0");
    parami.onMMMenuItemSelected(paramMenuItem, paramInt);
    paramc.amJ(paramMenuItem.getItemId());
    AppMethodBeat.o(308961);
  }
  
  private static final void a(kotlin.g.a.a parama, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(308951);
    if (parama != null) {
      parama.invoke();
    }
    AppMethodBeat.o(308951);
  }
  
  private static final void a(kotlin.g.a.a parama, c paramc)
  {
    AppMethodBeat.i(308959);
    kotlin.g.b.s.u(parama, "$dismissCb");
    kotlin.g.b.s.u(paramc, "this$0");
    parama.invoke();
    paramc.hse().onDismiss();
    parama = paramc.hsf();
    if (parama != null)
    {
      parama.lsO = 1;
      parama.Qmp = ((int)(SystemClock.elapsedRealtime() - parama.startTime));
    }
    parama = com.tencent.mm.pluginsdk.j.a.XUW;
    com.tencent.mm.pluginsdk.j.a.ly((Context)paramc.activity);
    AppMethodBeat.o(308959);
  }
  
  private void amJ(int paramInt)
  {
    AppMethodBeat.i(308941);
    Object localObject;
    if (paramInt == 1003)
    {
      localObject = hsf();
      if (localObject != null) {
        ((emx)localObject).lsO = 2;
      }
    }
    for (;;)
    {
      localObject = hsf();
      if (localObject != null) {
        ((emx)localObject).Qmp = ((int)(SystemClock.elapsedRealtime() - this.startTime));
      }
      localObject = com.tencent.mm.pluginsdk.j.a.XUW;
      com.tencent.mm.pluginsdk.j.a.ly((Context)this.activity);
      AppMethodBeat.o(308941);
      return;
      localObject = hsf();
      if (localObject != null) {
        ((emx)localObject).lsO = 4;
      }
    }
  }
  
  private static final void b(c paramc, int[] paramArrayOfInt, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(308944);
    kotlin.g.b.s.u(paramc, "this$0");
    kotlin.g.b.s.u(paramArrayOfInt, "$sencondItems");
    paramc = (Context)paramc.activity;
    kotlin.g.b.s.s(params, "menu");
    a(paramc, paramArrayOfInt, params);
    AppMethodBeat.o(308944);
  }
  
  private static final void b(u.i parami, c paramc, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(308964);
    kotlin.g.b.s.u(parami, "$menuItemSelectedListener");
    kotlin.g.b.s.u(paramc, "this$0");
    parami.onMMMenuItemSelected(paramMenuItem, paramInt);
    paramc.amJ(paramMenuItem.getItemId());
    AppMethodBeat.o(308964);
  }
  
  public static Bitmap bbl(String paramString)
  {
    AppMethodBeat.i(308928);
    kotlin.g.b.s.u(paramString, "path");
    Bitmap localBitmap = null;
    if (!Util.isNullOrNil(paramString))
    {
      localBitmap = BitmapUtil.getBitmapNative(paramString, 140, 140, com.tencent.mm.cd.a.getDensity(MMApplicationContext.getContext()));
      int j = Exif.fromFile(paramString).getOrientationInDegree();
      int i = j;
      if (j < 0) {
        i = 0;
      }
      localBitmap = BitmapUtil.rotate(localBitmap, i);
    }
    AppMethodBeat.o(308928);
    return localBitmap;
  }
  
  public final void a(List<Integer> paramList1, List<Integer> paramList2, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(309004);
    kotlin.g.b.s.u(paramList1, "firstMenuItems");
    kotlin.g.b.s.u(paramList2, "sencondItems");
    a(a.la(paramList1), a.la(paramList2), parama);
    AppMethodBeat.o(309004);
  }
  
  public final void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(309006);
    kotlin.g.b.s.u(paramArrayOfInt2, "sencondItems");
    if (paramArrayOfInt1 != null) {
      cDi().Vtg = new c..ExternalSyntheticLambda1(this, paramArrayOfInt1);
    }
    cDi().GAz = new c..ExternalSyntheticLambda0(this, paramArrayOfInt2);
    cDi().ageq = new c..ExternalSyntheticLambda5(parama);
    AppMethodBeat.o(309006);
  }
  
  public final void b(SnsInfo paramSnsInfo, final dmz paramdmz)
  {
    AppMethodBeat.i(309014);
    kotlin.g.b.s.u(paramSnsInfo, "snsInfo");
    kotlin.g.b.s.u(paramdmz, "media");
    final boolean bool;
    emx localemx;
    if (paramSnsInfo.getTimeLine().ContentObj.Zpq == 1)
    {
      bool = true;
      localemx = hsf();
      if (localemx != null) {
        if (!bool) {
          break label132;
        }
      }
    }
    label132:
    for (paramSnsInfo = "3";; paramSnsInfo = "43")
    {
      localemx.MFq = paramSnsInfo;
      paramSnsInfo = hsf();
      if (paramSnsInfo != null) {
        paramSnsInfo.abrg = "0";
      }
      ((q)h.ax(q.class)).iGI().a((Context)this.activity, cDi(), (kotlin.g.a.b)new b(this, bool, paramdmz));
      AppMethodBeat.o(309014);
      return;
      bool = false;
      break;
    }
  }
  
  public final void bM(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(309012);
    kotlin.g.b.s.u(parama, "dismissCb");
    cDi().aeLi = new c..ExternalSyntheticLambda6(parama, this);
    AppMethodBeat.o(309012);
  }
  
  public final f cDi()
  {
    AppMethodBeat.i(308997);
    f localf = (f)this.RUm.getValue();
    AppMethodBeat.o(308997);
    return localf;
  }
  
  public final void d(u.i parami)
  {
    AppMethodBeat.i(309008);
    kotlin.g.b.s.u(parami, "listener");
    cDi().ageq = new c..ExternalSyntheticLambda2(parami);
    AppMethodBeat.o(309008);
  }
  
  public final void dDn()
  {
    AppMethodBeat.i(309016);
    cDi().dDn();
    this.startTime = SystemClock.elapsedRealtime();
    AppMethodBeat.o(309016);
  }
  
  public final void e(u.i parami)
  {
    AppMethodBeat.i(309017);
    kotlin.g.b.s.u(parami, "menuItemSelectedListener");
    cDi().GAC = new c..ExternalSyntheticLambda4(parami, this);
    cDi().agem = new c..ExternalSyntheticLambda3(parami, this);
    AppMethodBeat.o(309017);
  }
  
  public final ScanCodeSheetItemLogic hse()
  {
    AppMethodBeat.i(309001);
    if (this.RUn == null) {
      this.RUn = new ScanCodeSheetItemLogic((Context)this.activity);
    }
    ScanCodeSheetItemLogic localScanCodeSheetItemLogic = this.RUn;
    kotlin.g.b.s.checkNotNull(localScanCodeSheetItemLogic);
    AppMethodBeat.o(309001);
    return localScanCodeSheetItemLogic;
  }
  
  public final emx hsf()
  {
    AppMethodBeat.i(309009);
    Object localObject = com.tencent.mm.plugin.secdata.ui.a.PlI;
    localObject = (emx)a.a.c((Context)this.activity, 14, emx.class);
    AppMethodBeat.o(309009);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/sheet/ShareSheet$Companion;", "", "()V", "DEFAULT_FIRST_MENUS", "", "getDEFAULT_FIRST_MENUS", "()[I", "MENU_ITEMS", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/sns/ui/sheet/MenuItem;", "Lkotlin/collections/HashMap;", "getMENU_ITEMS", "()Ljava/util/HashMap;", "MM_ALERT_DEL", "MM_ALERT_EDIT_PHOTO", "MM_ALERT_EXPOSE", "MM_ALERT_FAVORITE", "MM_ALERT_OCR_IMAGE", "MM_ALERT_SAVE_OTHER", "MM_ALERT_SAVE_PHOTO", "MM_ALERT_SAVE_VIDEO", "MM_ALERT_SCAN_IMAGE", "MM_ALERT_SEND_DATA", "MM_ALERT_SET_OPEN", "MM_ALERT_SET_PRIVATED", "MM_ALERT_SHARE_FRIEND", "MM_ALERT_SOS", "MM_ALERT_TRANSLATE_IMG", "array2int", "items", "", "shareSendVideo", "", "activity", "Landroid/app/Activity;", "toUsers", "", "editText", "media", "Lcom/tencent/mm/protocal/protobuf/MediaObj;", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void b(Activity paramActivity, String paramString1, String paramString2, dmz paramdmz)
    {
      AppMethodBeat.i(308914);
      kotlin.g.b.s.u(paramActivity, "activity");
      kotlin.g.b.s.u(paramString1, "toUsers");
      kotlin.g.b.s.u(paramdmz, "media");
      String str3 = as.mg(al.getAccSnsPath(), paramdmz.Id);
      String str1 = "";
      String str2 = "";
      String str4 = t.i(paramdmz);
      if (y.ZC(kotlin.g.b.s.X(str3, str4)))
      {
        str2 = kotlin.g.b.s.X(str3, str4);
        str1 = kotlin.g.b.s.X(str3, t.d(paramdmz));
      }
      if (y.ZC(kotlin.g.b.s.X(str3, t.o(paramdmz))))
      {
        str2 = kotlin.g.b.s.X(str3, t.o(paramdmz));
        str1 = kotlin.g.b.s.X(str3, t.m(paramdmz));
      }
      for (paramdmz = str2;; paramdmz = str2)
      {
        paramString1 = (CharSequence)paramString1;
        paramString1 = ((Collection)new kotlin.n.k(",").o(paramString1, 0)).toArray(new String[0]);
        if (paramString1 == null)
        {
          paramActivity = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
          AppMethodBeat.o(308914);
          throw paramActivity;
        }
        paramString1 = Util.stringsToList((String[])paramString1);
        kotlin.g.b.s.s(paramString1, "stringsToList(toUsers.sp…oRegex()).toTypedArray())");
        paramString1 = (List)paramString1;
        int i = t.aXE(paramdmz);
        paramString1 = paramString1.iterator();
        while (paramString1.hasNext())
        {
          str2 = (String)paramString1.next();
          Log.i("MicroMsg.SnsGalleryUI", "send sight to %s, videopath %s, thumbpath %s duration %d", new Object[] { str2, paramdmz, str1, Integer.valueOf(i) });
          g.gaI().a((Context)paramActivity, str2, paramdmz, str1, 62, i, "", null);
          g.gaI().ke(paramString2, str2);
        }
        com.tencent.mm.ui.widget.snackbar.b.u(paramActivity, paramActivity.getString(b.j.has_send));
        AppMethodBeat.o(308914);
        return;
      }
    }
    
    public static int[] la(List<Integer> paramList)
    {
      AppMethodBeat.i(308919);
      kotlin.g.b.s.u(paramList, "items");
      int[] arrayOfInt = new int[paramList.size()];
      int k = paramList.size() - 1;
      if (k >= 0) {}
      int j;
      for (int i = 0;; i = j)
      {
        j = i + 1;
        arrayOfInt[i] = ((Number)paramList.get(i)).intValue();
        if (j > k)
        {
          AppMethodBeat.o(308919);
          return arrayOfInt;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "userName", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    b(c paramc, boolean paramBoolean, dmz paramdmz)
    {
      super();
    }
    
    private static final void a(c paramc, String paramString1, boolean paramBoolean1, dmz paramdmz, boolean paramBoolean2, String paramString2, int paramInt)
    {
      AppMethodBeat.i(308909);
      kotlin.g.b.s.u(paramc, "this$0");
      kotlin.g.b.s.u(paramdmz, "$media");
      Object localObject = paramc.hsf();
      if (localObject != null)
      {
        ((emx)localObject).lsO = 3;
        if (paramBoolean2) {
          ((emx)localObject).toUser = paramString1;
        }
        ((emx)localObject).Qmp = ((int)(SystemClock.elapsedRealtime() - ((emx)localObject).startTime));
      }
      localObject = com.tencent.mm.pluginsdk.j.a.XUW;
      com.tencent.mm.pluginsdk.j.a.ly((Context)paramc.activity);
      if ((!paramBoolean2) || (Util.isNullOrNil(paramString1)))
      {
        AppMethodBeat.o(308909);
        return;
      }
      if (paramBoolean1)
      {
        paramc = paramc.activity;
        kotlin.g.b.s.checkNotNull(paramString1);
        c.a(paramc, paramString1, paramString2, paramdmz);
      }
      for (;;)
      {
        ((PluginMessengerFoundation)h.az(PluginMessengerFoundation.class)).getRecentForwardInfoStorage().bzq(paramString1);
        AppMethodBeat.o(308909);
        return;
        localObject = c.RUl;
        paramc = paramc.activity;
        kotlin.g.b.s.checkNotNull(paramString1);
        c.a.b(paramc, paramString1, paramString2, paramdmz);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<f>
  {
    c(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.c
 * JD-Core Version:    0.7.0.1
 */