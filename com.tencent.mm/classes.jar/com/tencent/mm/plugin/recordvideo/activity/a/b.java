package com.tencent.mm.plugin.recordvideo.activity.a;

import android.content.Context;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.bo;
import com.tencent.mm.autogen.mmdata.rpt.nf;
import com.tencent.mm.plugin.recordvideo.activity.MMRecordUI;
import com.tencent.mm.plugin.recordvideo.f.c;
import com.tencent.mm.plugin.recordvideo.f.g;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.DirectSendPhotoPluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.EditPhotoPluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.EditorVideoPluginLayoutNew;
import com.tencent.mm.plugin.recordvideo.plugin.parent.RecordPluginLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/activity/controller/RecordUIRouter;", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "context", "Landroid/content/Context;", "root", "Landroid/view/ViewGroup;", "provider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "toWhere", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;I)V", "currentRouter", "currentView", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "enableRecordPage", "", "isFinishing", "getProvider", "()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "viewMap", "", "kotlin.jvm.PlatformType", "", "viewTable", "Landroid/util/SparseArray;", "Ljava/lang/Class;", "finish", "", "loadViewFromClass", "key", "clazz", "directLoad", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "scene", "onDestroy", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "preRelease", "route", "model", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements com.tencent.mm.plugin.recordvideo.activity.a
{
  public static final b.a NDm;
  private final RecordConfigProvider NDn;
  private final Map<Integer, BasePluginLayout> NDo;
  public BasePluginLayout NDp;
  private boolean NDq;
  private int NDr;
  private final Context context;
  private boolean isFinishing;
  private final ViewGroup mJe;
  private final SparseArray<Class<?>> mJh;
  
  static
  {
    AppMethodBeat.i(75075);
    NDm = new b.a((byte)0);
    AppMethodBeat.o(75075);
  }
  
  public b(Context paramContext, ViewGroup paramViewGroup, RecordConfigProvider paramRecordConfigProvider, int paramInt)
  {
    AppMethodBeat.i(75074);
    this.context = paramContext;
    this.mJe = paramViewGroup;
    this.NDn = paramRecordConfigProvider;
    this.mJh = new SparseArray();
    this.NDo = Collections.synchronizedMap((Map)new HashMap());
    this.NDr = -2;
    Log.i("MicroMsg.RecordUIRouter", "init");
    this.mJh.put(0, RecordPluginLayout.class);
    int i;
    if (this.NDn.NIp)
    {
      this.mJh.put(1, DirectSendPhotoPluginLayout.class);
      this.mJh.put(2, EditorVideoPluginLayoutNew.class);
      paramContext = this.NDn.mIB;
      s.s(paramContext, "routerMap");
      if (((Map)paramContext).isEmpty()) {
        break label244;
      }
      i = 1;
      label152:
      if (i == 0) {
        break label374;
      }
      paramContext = ((Map)paramContext).entrySet().iterator();
    }
    for (;;)
    {
      if (!paramContext.hasNext()) {
        break label374;
      }
      paramViewGroup = (Map.Entry)paramContext.next();
      paramRecordConfigProvider = new StringBuilder("add route key:");
      Object localObject = paramViewGroup.getKey();
      if (localObject == null)
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(75074);
        throw paramContext;
        this.mJh.put(1, EditPhotoPluginLayout.class);
        break;
        label244:
        i = 0;
        break label152;
      }
      Log.i("MicroMsg.RecordUIRouter", ((Integer)localObject).intValue() + " value:" + paramViewGroup.getValue());
      paramRecordConfigProvider = this.mJh;
      localObject = paramViewGroup.getKey();
      if (localObject == null)
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(75074);
        throw paramContext;
      }
      i = ((Integer)localObject).intValue();
      paramViewGroup = paramViewGroup.getValue();
      if (paramViewGroup == null)
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(75074);
        throw paramContext;
      }
      paramRecordConfigProvider.put(i, Class.forName((String)paramViewGroup));
    }
    label374:
    paramContext = g.NRB;
    long l = SystemClock.elapsedRealtime();
    if (g.NRD != 0L)
    {
      Log.i("MicroMsg.VideoWidgetReporter", "videoWidgetReporter doReport In setInitRouterTImeStamp");
      g.NRC.vz(g.gJo());
      g.NRC.bMH();
    }
    Log.i("MicroMsg.VideoWidgetReporter", "videoWidgetReporter doReset");
    g.NRC = new nf();
    g.NRE.clear();
    g.NRD = l;
    g.NRC.jem = l;
    paramContext = g.NRB;
    g.g(this.mJh);
    if (paramInt == 0)
    {
      this.NDq = true;
      paramContext = this.mJh.get(0);
      s.s(paramContext, "viewTable[KEY_TO_RECORD]");
      a(0, (Class)paramContext, true);
    }
    Log.i("MicroMsg.RecordUIRouter", s.X("setEnableRecordPage ", Boolean.valueOf(this.NDq)));
    AppMethodBeat.o(75074);
  }
  
  public static final int I(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(75077);
    int i = b.a.c(-1, paramList1, paramList2);
    AppMethodBeat.o(75077);
    return i;
  }
  
  private static final void a(int paramInt1, b paramb, com.tencent.mm.media.widget.camerarecordview.b.b paramb1, int paramInt2)
  {
    AppMethodBeat.i(279403);
    s.u(paramb, "this$0");
    if ((paramInt1 == 0) && (!paramb.NDq))
    {
      ((MMRecordUI)paramb.context).finish();
      AppMethodBeat.o(279403);
      return;
    }
    if (paramb.NDo.get(Integer.valueOf(paramInt1)) == null)
    {
      if (paramb.mJh.get(paramInt1) == null)
      {
        Log.e("MicroMsg.RecordUIRouter", s.X("No corresponding ", Integer.valueOf(paramInt1)));
        AppMethodBeat.o(279403);
        return;
      }
      localObject = paramb.mJh.get(paramInt1);
      if (localObject == null)
      {
        paramb = new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
        AppMethodBeat.o(279403);
        throw paramb;
      }
      localObject = (Class)localObject;
      Log.i("MicroMsg.RecordUIRouter", s.X("create BasePluginLayout :", ((Class)localObject).getSimpleName()));
      paramb.a(paramInt1, (Class)localObject, false);
    }
    Object localObject = paramb.NDp;
    paramb.NDp = ((BasePluginLayout)paramb.NDo.get(Integer.valueOf(paramInt1)));
    BasePluginLayout localBasePluginLayout = paramb.NDp;
    if (localBasePluginLayout != null) {
      localBasePluginLayout.a(paramb1);
    }
    paramb1 = paramb.NDp;
    if (paramb1 != null) {
      paramb1.bringToFront();
    }
    if (localObject != null) {
      ((BasePluginLayout)localObject).onPause();
    }
    if (localObject != null) {
      ((BasePluginLayout)localObject).onDetach();
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      paramb1 = g.NRB;
      long l = SystemClock.elapsedRealtime();
      paramb = ((Class)paramb.mJh.get(paramInt2)).getSimpleName();
      s.s(paramb, "viewTable.get(toWhere).simpleName");
      g.ac(l, paramb);
      AppMethodBeat.o(279403);
      return;
      paramb1 = c.NRf;
      c.I("KEY_EXIT_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
      continue;
      paramb1 = c.NRf;
      c.I("KEY_EXIT_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
      continue;
      paramb1 = c.NRf;
      c.agH(19);
      paramb1 = c.NRf;
      c.I("KEY_EXIT_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
    }
  }
  
  /* Error */
  private final void a(int paramInt, Class<?> paramClass, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 426
    //   5: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_2
    //   9: iconst_2
    //   10: anewarray 264	java/lang/Class
    //   13: dup
    //   14: iconst_0
    //   15: ldc_w 428
    //   18: aastore
    //   19: dup
    //   20: iconst_1
    //   21: ldc_w 430
    //   24: aastore
    //   25: invokevirtual 434	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   28: iconst_2
    //   29: anewarray 4	java/lang/Object
    //   32: dup
    //   33: iconst_0
    //   34: aload_0
    //   35: getfield 134	com/tencent/mm/plugin/recordvideo/activity/a/b:context	Landroid/content/Context;
    //   38: aastore
    //   39: dup
    //   40: iconst_1
    //   41: aconst_null
    //   42: aastore
    //   43: invokevirtual 440	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   46: astore_2
    //   47: aload_2
    //   48: ifnonnull +48 -> 96
    //   51: new 228	java/lang/NullPointerException
    //   54: dup
    //   55: ldc_w 442
    //   58: invokespecial 231	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   61: astore_2
    //   62: ldc_w 426
    //   65: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: aload_2
    //   69: athrow
    //   70: astore_2
    //   71: ldc 160
    //   73: aload_2
    //   74: checkcast 444	java/lang/Throwable
    //   77: ldc_w 445
    //   80: iconst_0
    //   81: anewarray 4	java/lang/Object
    //   84: invokestatic 449	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   87: ldc_w 426
    //   90: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aload_0
    //   94: monitorexit
    //   95: return
    //   96: aload_2
    //   97: checkcast 382	com/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout
    //   100: astore_2
    //   101: ldc 160
    //   103: new 218	java/lang/StringBuilder
    //   106: dup
    //   107: ldc_w 451
    //   110: invokespecial 223	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   113: iload_1
    //   114: invokevirtual 243	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   117: ldc_w 453
    //   120: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload_2
    //   124: invokevirtual 457	java/lang/Object:getClass	()Ljava/lang/Class;
    //   127: invokevirtual 460	java/lang/Class:getName	()Ljava/lang/String;
    //   130: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 167	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: aload_2
    //   140: aload_0
    //   141: checkcast 6	com/tencent/mm/plugin/recordvideo/activity/a
    //   144: aload_0
    //   145: getfield 138	com/tencent/mm/plugin/recordvideo/activity/a/b:NDn	Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;
    //   148: invokevirtual 463	com/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout:a	(Lcom/tencent/mm/plugin/recordvideo/activity/a;Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;)V
    //   151: aload_0
    //   152: getfield 156	com/tencent/mm/plugin/recordvideo/activity/a/b:NDo	Ljava/util/Map;
    //   155: iload_1
    //   156: invokestatic 363	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   159: aload_2
    //   160: invokeinterface 466 3 0
    //   165: pop
    //   166: aload_0
    //   167: getfield 136	com/tencent/mm/plugin/recordvideo/activity/a/b:mJe	Landroid/view/ViewGroup;
    //   170: aload_2
    //   171: checkcast 468	android/view/View
    //   174: new 470	android/view/ViewGroup$LayoutParams
    //   177: dup
    //   178: iconst_m1
    //   179: iconst_m1
    //   180: invokespecial 473	android/view/ViewGroup$LayoutParams:<init>	(II)V
    //   183: invokevirtual 479	android/view/ViewGroup:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   186: iload_3
    //   187: ifne -100 -> 87
    //   190: aload_2
    //   191: bipush 8
    //   193: invokevirtual 482	com/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout:setVisibility	(I)V
    //   196: ldc_w 426
    //   199: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: goto -109 -> 93
    //   205: astore_2
    //   206: aload_0
    //   207: monitorexit
    //   208: aload_2
    //   209: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	this	b
    //   0	210	1	paramInt	int
    //   0	210	2	paramClass	Class<?>
    //   0	210	3	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   8	47	70	java/lang/Exception
    //   51	70	70	java/lang/Exception
    //   96	186	70	java/lang/Exception
    //   190	196	70	java/lang/Exception
    //   2	8	205	finally
    //   8	47	205	finally
    //   51	70	205	finally
    //   71	87	205	finally
    //   87	93	205	finally
    //   96	186	205	finally
    //   190	196	205	finally
    //   196	202	205	finally
  }
  
  private static final void a(b paramb)
  {
    AppMethodBeat.i(279407);
    s.u(paramb, "this$0");
    paramb = paramb.NDo;
    s.s(paramb, "viewMap");
    paramb = paramb.entrySet().iterator();
    while (paramb.hasNext()) {
      ((BasePluginLayout)((Map.Entry)paramb.next()).getValue()).release();
    }
    AppMethodBeat.o(279407);
  }
  
  private static final void b(b paramb)
  {
    AppMethodBeat.i(279411);
    s.u(paramb, "this$0");
    paramb = paramb.NDo;
    s.s(paramb, "viewMap");
    paramb = paramb.entrySet().iterator();
    while (paramb.hasNext()) {
      ((BasePluginLayout)((Map.Entry)paramb.next()).getValue()).release();
    }
    AppMethodBeat.o(279411);
  }
  
  private static final void c(b paramb)
  {
    AppMethodBeat.i(279418);
    s.u(paramb, "this$0");
    paramb = paramb.NDo;
    s.s(paramb, "viewMap");
    paramb = paramb.entrySet().iterator();
    while (paramb.hasNext()) {
      ((BasePluginLayout)((Map.Entry)paramb.next()).getValue()).onDetach();
    }
    AppMethodBeat.o(279418);
  }
  
  public final void a(int paramInt, com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    Object localObject2 = null;
    AppMethodBeat.i(75072);
    if (this.isFinishing)
    {
      Log.i("MicroMsg.RecordUIRouter", "isFinishing toWhere:" + paramInt + "  MediaCaptureInfo:" + paramb);
      AppMethodBeat.o(75072);
      return;
    }
    List localList;
    if (paramb == null)
    {
      localObject1 = null;
      localList = (List)localObject1;
      if (paramb != null) {
        break label168;
      }
    }
    int i;
    label168:
    for (Object localObject1 = localObject2;; localObject1 = paramb.nKd)
    {
      i = b.a.c(paramInt, localList, (List)localObject1);
      Log.i("MicroMsg.RecordUIRouter", "toWhere:" + paramInt + " real:" + i + " current:" + this.NDr + " MediaCaptureInfo:" + paramb);
      if (i != this.NDr) {
        break label177;
      }
      AppMethodBeat.o(75072);
      return;
      localObject1 = paramb.nKc;
      break;
    }
    label177:
    this.NDr = i;
    h.ahAA.bk(new b..ExternalSyntheticLambda0(i, this, paramb, paramInt));
    AppMethodBeat.o(75072);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(279453);
    Log.i("MicroMsg.RecordUIRouter", s.X("finish ", this.NDp));
    this.isFinishing = true;
    MMHandlerThread.postToMainThread(new b..ExternalSyntheticLambda3(this));
    AppMethodBeat.o(279453);
  }
  
  public final void gGz()
  {
    AppMethodBeat.i(279450);
    Log.i("MicroMsg.RecordUIRouter", s.X("onDestroy ", this.NDp));
    MMHandlerThread.postToMainThread(new b..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(279450);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(279449);
    Log.i("MicroMsg.RecordUIRouter", s.X("onDestroy ", this.NDp));
    MMHandlerThread.postToMainThread(new b..ExternalSyntheticLambda2(this));
    if ((this.NDp instanceof RecordPluginLayout))
    {
      localObject1 = c.NRf;
      c.I("KEY_EXIT_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
    }
    Object localObject1 = c.NRf;
    localObject1 = new bo();
    RecordMediaReportInfo localRecordMediaReportInfo = c.gJe();
    Object localObject2 = localRecordMediaReportInfo.J("KEY_NET_TYPE_INT", Long.valueOf(-1L));
    s.s(localObject2, "info.getReportValue(KEY_NET_TYPE_INT,-1)");
    ((bo)localObject1).itb = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_FROM_SCENE_INT", Long.valueOf(-1L));
    s.s(localObject2, "info.getReportValue(KEY_FROM_SCENE_INT,-1)");
    ((bo)localObject1).itc = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_ENTER_TIME_MS_LONG", Long.valueOf(-1L));
    s.s(localObject2, "info.getReportValue(KEY_ENTER_TIME_MS_LONG,-1)");
    ((bo)localObject1).itd = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_EXIT_TIME_MS_LONG", Long.valueOf(-1L));
    s.s(localObject2, "info.getReportValue(KEY_EXIT_TIME_MS_LONG,-1)");
    ((bo)localObject1).ite = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_MEDIA_SOURCE_INT", Long.valueOf(-1L));
    s.s(localObject2, "info.getReportValue(KEY_MEDIA_SOURCE_INT,-1)");
    ((bo)localObject1).itf = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_MEDIA_TYPE_INT", Long.valueOf(-1L));
    s.s(localObject2, "info.getReportValue(KEY_MEDIA_TYPE_INT,-1)");
    ((bo)localObject1).itg = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_START_RECORD_MS_LONG", Long.valueOf(-1L));
    s.s(localObject2, "info.getReportValue(KEY_START_RECORD_MS_LONG,-1)");
    ((bo)localObject1).ith = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_ORIGIN_MEDIA_DURATION_MS_LONG", Long.valueOf(-1L));
    s.s(localObject2, "info.getReportValue(KEY_…EDIA_DURATION_MS_LONG,-1)");
    ((bo)localObject1).iti = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_ORIGIN_MEDIA_WIDTH_INT", Long.valueOf(-1L));
    s.s(localObject2, "info.getReportValue(KEY_ORIGIN_MEDIA_WIDTH_INT,-1)");
    ((bo)localObject1).itj = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_ORIGIN_MEDIA_HEIGHT_INT", Long.valueOf(-1L));
    s.s(localObject2, "info.getReportValue(KEY_…IGIN_MEDIA_HEIGHT_INT,-1)");
    ((bo)localObject1).itk = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_ENTER_CROP_PAGE_TIME_MS_LONG", Long.valueOf(-1L));
    s.s(localObject2, "info.getReportValue(KEY_…ROP_PAGE_TIME_MS_LONG,-1)");
    ((bo)localObject1).itl = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_EXIT_CROP_PAGE_TIME_MS_LONG", Long.valueOf(-1L));
    s.s(localObject2, "info.getReportValue(KEY_…ROP_PAGE_TIME_MS_LONG,-1)");
    ((bo)localObject1).itm = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_ENTER_EDIT_PAGE_TIME_MS_LONG", Long.valueOf(-1L));
    s.s(localObject2, "info.getReportValue(KEY_…DIT_PAGE_TIME_MS_LONG,-1)");
    ((bo)localObject1).itn = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_CLICK_EMOJI_COUNT_INT", Long.valueOf(0L));
    s.s(localObject2, "info.getReportValue(KEY_CLICK_EMOJI_COUNT_INT,0)");
    ((bo)localObject1).ito = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_ADD_EMOJI_COUNT_INT", Long.valueOf(0L));
    s.s(localObject2, "info.getReportValue(KEY_ADD_EMOJI_COUNT_INT,0)");
    ((bo)localObject1).itp = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_CLICK_TEXT_COUNT_INT", Long.valueOf(0L));
    s.s(localObject2, "info.getReportValue(KEY_CLICK_TEXT_COUNT_INT,0)");
    ((bo)localObject1).itq = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_ADD_TEXT_COUNT_INT", Long.valueOf(0L));
    s.s(localObject2, "info.getReportValue(KEY_ADD_TEXT_COUNT_INT,0)");
    ((bo)localObject1).itr = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_CLICK_DOODLE_COUNT_INT", Long.valueOf(0L));
    s.s(localObject2, "info.getReportValue(KEY_CLICK_DOODLE_COUNT_INT,0)");
    ((bo)localObject1).its = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_ADD_DOODLE_COUNT_INT", Long.valueOf(0L));
    s.s(localObject2, "info.getReportValue(KEY_ADD_DOODLE_COUNT_INT,0)");
    ((bo)localObject1).itt = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_ADD_DOODLE_COLOR_COUNT_INT", Long.valueOf(0L));
    s.s(localObject2, "info.getReportValue(KEY_…DOODLE_COLOR_COUNT_INT,0)");
    ((bo)localObject1).itu = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_CLICK_MOSAIC_COUNT_INT", Long.valueOf(0L));
    s.s(localObject2, "info.getReportValue(KEY_CLICK_MOSAIC_COUNT_INT,0)");
    ((bo)localObject1).itv = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_CLICK_BRUSH_COUNT_INT", Long.valueOf(0L));
    s.s(localObject2, "info.getReportValue(KEY_CLICK_BRUSH_COUNT_INT,0)");
    ((bo)localObject1).itw = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_ADD_MOSAIC_COUNT_INT", Long.valueOf(0L));
    s.s(localObject2, "info.getReportValue(KEY_ADD_MOSAIC_COUNT_INT,0)");
    ((bo)localObject1).itz = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_CLICK_CROP_COUNT_INT", Long.valueOf(0L));
    s.s(localObject2, "info.getReportValue(KEY_CLICK_CROP_COUNT_INT,0)");
    ((bo)localObject1).itA = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_CROP_MEDIA_HEIGHT_INT", Long.valueOf(-1L));
    s.s(localObject2, "info.getReportValue(KEY_CROP_MEDIA_HEIGHT_INT,-1)");
    ((bo)localObject1).itC = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_CROP_MEDIA_WIDTH_INT", Long.valueOf(-1L));
    s.s(localObject2, "info.getReportValue(KEY_CROP_MEDIA_WIDTH_INT,-1)");
    ((bo)localObject1).itB = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_ROTATE_INT", Long.valueOf(-1L));
    s.s(localObject2, "info.getReportValue(KEY_ROTATE_INT,-1)");
    ((bo)localObject1).itD = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_CLICK_MUSIC_COUNT_INT", Long.valueOf(0L));
    s.s(localObject2, "info.getReportValue(KEY_CLICK_MUSIC_COUNT_INT,0)");
    ((bo)localObject1).itE = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_MUSIC_ID_INT", Long.valueOf(-1L));
    s.s(localObject2, "info.getReportValue(KEY_MUSIC_ID_INT,-1)");
    ((bo)localObject1).itF = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_MUSIC_INDEX_INT", Long.valueOf(-1L));
    s.s(localObject2, "info.getReportValue(KEY_MUSIC_INDEX_INT,-1)");
    ((bo)localObject1).itG = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_SELECT_MUSIC_INT", Long.valueOf(-1L));
    s.s(localObject2, "info.getReportValue(KEY_SELECT_MUSIC_INT,-1)");
    ((bo)localObject1).itH = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_SELECT_ORIGIN_INT", Long.valueOf(-1L));
    s.s(localObject2, "info.getReportValue(KEY_SELECT_ORIGIN_INT,-1)");
    ((bo)localObject1).itI = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_MUSIC_REQ_ID_INT", Long.valueOf(-1L));
    s.s(localObject2, "info.getReportValue(KEY_MUSIC_REQ_ID_INT,-1)");
    ((bo)localObject1).itJ = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_SEARCH_MUSIC_INT", Long.valueOf(-1L));
    s.s(localObject2, "info.getReportValue(KEY_SEARCH_MUSIC_INT,-1)");
    ((bo)localObject1).itK = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_CLICK_VIDEO_CROP_COUNT_INT", Long.valueOf(0L));
    s.s(localObject2, "info.getReportValue(KEY_…K_VIDEO_CROP_COUNT_INT,0)");
    ((bo)localObject1).itL = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_VIDEO_CROP_DURATION_MS_INT", Long.valueOf(-1L));
    s.s(localObject2, "info.getReportValue(KEY_…_CROP_DURATION_MS_INT,-1)");
    ((bo)localObject1).itM = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_AFTER_EDIT_INT", Long.valueOf(-1L));
    s.s(localObject2, "info.getReportValue(KEY_AFTER_EDIT_INT,-1)");
    ((bo)localObject1).itN = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_EDIT_PUBLISHID_INT", Long.valueOf(-1L));
    s.s(localObject2, "info.getReportValue(KEY_EDIT_PUBLISHID_INT,-1)");
    ((bo)localObject1).itO = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_IS_SHOW_WESEE_BTN", Long.valueOf(0L));
    s.s(localObject2, "info.getReportValue(KEY_IS_SHOW_WESEE_BTN, 0)");
    ((bo)localObject1).itQ = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_IS_CLICK_WESEE_BTN", Long.valueOf(0L));
    s.s(localObject2, "info.getReportValue(KEY_IS_CLICK_WESEE_BTN, 0)");
    ((bo)localObject1).itR = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_IS_INSTALL_WESEE", Long.valueOf(0L));
    s.s(localObject2, "info.getReportValue(KEY_IS_INSTALL_WESEE, 0)");
    ((bo)localObject1).itS = ((Number)localObject2).longValue();
    localObject2 = localRecordMediaReportInfo.J("KEY_WESEE_DIALOG_OPERATION", Long.valueOf(0L));
    s.s(localObject2, "info.getReportValue(KEY_WESEE_DIALOG_OPERATION, 0)");
    ((bo)localObject1).itT = ((Number)localObject2).longValue();
    ((bo)localObject1).itP = ((bo)localObject1).F("ActionTrace", c.NRh.gJd(), true);
    localObject2 = localRecordMediaReportInfo.J("KEY_SEARCH_MUSIC_COUNT_INT", Long.valueOf(0L));
    s.s(localObject2, "info.getReportValue(KEY_SEARCH_MUSIC_COUNT_INT, 0)");
    ((bo)localObject1).itU = ((Number)localObject2).longValue();
    ((bo)localObject1).itV = ((bo)localObject1).F("SearchMusicList", (String)localRecordMediaReportInfo.J("KEY_SEARCH_MUSIC_LIST_STRING", ""), true);
    ((bo)localObject1).itW = ((bo)localObject1).F("TextWidgetContentList", (String)localRecordMediaReportInfo.J("KEY_TEXT_WIDGET_CONTENT_STRING", ""), true);
    ((bo)localObject1).itY = ((bo)localObject1).F("moment_sessionid", (String)localRecordMediaReportInfo.J("moment_sessionid_", ""), true);
    ((bo)localObject1).bMH();
    AppMethodBeat.o(279449);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.activity.a.b
 * JD-Core Version:    0.7.0.1
 */