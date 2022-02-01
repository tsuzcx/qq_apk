package com.tencent.mm.plugin.repairer.ui.demo;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.repairer.ui.BaseRepairerUI;
import com.tencent.mm.plugin.repairer.ui.b.c;
import com.tencent.mm.plugin.repairer.ui.b.d;
import com.tencent.mm.pluginsdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/RepairerDBSelectDemoUI;", "Lcom/tencent/mm/plugin/repairer/ui/BaseRepairerUI;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "costView", "Landroid/widget/TextView;", "getCostView", "()Landroid/widget/TextView;", "setCostView", "(Landroid/widget/TextView;)V", "resultView", "getResultView", "setResultView", "execSql", "", "exportSql", "getLayoutId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RepairerDBSelectDemoUI
  extends BaseRepairerUI
{
  TextView OwT;
  TextView OwU;
  private final String TAG = "MicroMsg.RepairerDBSelectDemoUI";
  
  private static final void a(RepairerDBSelectDemoUI paramRepairerDBSelectDemoUI, View paramView)
  {
    AppMethodBeat.i(278185);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramRepairerDBSelectDemoUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerDBSelectDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerDBSelectDemoUI, "this$0");
    if (MMApplicationContext.isMMProcess())
    {
      paramView = ((MMEditText)paramRepairerDBSelectDemoUI.findViewById(b.c.Oua)).getText().toString();
      if ((paramView != null) && (paramView.length() > 0)) {
        h.baH().postToWorker(new RepairerDBSelectDemoUI..ExternalSyntheticLambda3(paramView, paramRepairerDBSelectDemoUI));
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/RepairerDBSelectDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278185);
  }
  
  /* Error */
  private static final void a(String paramString, RepairerDBSelectDemoUI paramRepairerDBSelectDemoUI)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 8
    //   6: ldc 167
    //   8: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: ldc 169
    //   14: invokestatic 114	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   17: aload_1
    //   18: ldc 108
    //   20: invokestatic 114	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   23: new 171	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   30: astore 9
    //   32: new 174	kotlin/g/b/ah$e
    //   35: dup
    //   36: invokespecial 175	kotlin/g/b/ah$e:<init>	()V
    //   39: astore 10
    //   41: aload 10
    //   43: invokestatic 181	java/lang/System:currentTimeMillis	()J
    //   46: putfield 185	kotlin/g/b/ah$e:aixc	J
    //   49: invokestatic 189	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   52: getfield 195	com/tencent/mm/kernel/f:mCN	Lcom/tencent/mm/storagebase/h;
    //   55: invokevirtual 201	com/tencent/mm/storagebase/h:jef	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   58: astore 6
    //   60: aload 6
    //   62: getstatic 207	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   65: aload_0
    //   66: aconst_null
    //   67: aconst_null
    //   68: invokevirtual 213	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   71: checkcast 215	android/database/Cursor
    //   74: astore 6
    //   76: aload 6
    //   78: checkcast 217	com/tencent/wcdb/Cursor
    //   81: invokeinterface 221 1 0
    //   86: astore 5
    //   88: aload 5
    //   90: ifnonnull +268 -> 358
    //   93: iconst_0
    //   94: istore_2
    //   95: aload_1
    //   96: getfield 78	com/tencent/mm/plugin/repairer/ui/demo/RepairerDBSelectDemoUI:TAG	Ljava/lang/String;
    //   99: ldc 223
    //   101: aload_0
    //   102: invokestatic 227	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   105: invokestatic 232	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: iload_2
    //   109: ifle +41 -> 150
    //   112: ldc 234
    //   114: checkcast 236	java/lang/CharSequence
    //   117: astore 7
    //   119: aload 5
    //   121: invokestatic 239	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   124: aload 9
    //   126: ldc 241
    //   128: aload 7
    //   130: aload 5
    //   132: invokestatic 247	android/text/TextUtils:join	(Ljava/lang/CharSequence;[Ljava/lang/Object;)Ljava/lang/String;
    //   135: invokestatic 227	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   138: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload 9
    //   144: ldc 253
    //   146: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: new 171	java/lang/StringBuilder
    //   153: dup
    //   154: sipush 1024
    //   157: invokespecial 255	java/lang/StringBuilder:<init>	(I)V
    //   160: astore 5
    //   162: aload 6
    //   164: checkcast 217	com/tencent/wcdb/Cursor
    //   167: invokeinterface 258 1 0
    //   172: ifeq +241 -> 413
    //   175: aload 5
    //   177: iconst_0
    //   178: invokevirtual 261	java/lang/StringBuilder:setLength	(I)V
    //   181: aload 5
    //   183: ldc 241
    //   185: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: iload_2
    //   190: ifle +77 -> 267
    //   193: iconst_0
    //   194: istore_3
    //   195: iload_3
    //   196: iconst_1
    //   197: iadd
    //   198: istore 4
    //   200: aload 6
    //   202: checkcast 217	com/tencent/wcdb/Cursor
    //   205: iload_3
    //   206: invokeinterface 265 2 0
    //   211: lookupswitch	default:+279->490, 0:+154->365, 4:+190->401
    //   237: iconst_2
    //   238: aload 6
    //   240: checkcast 217	com/tencent/wcdb/Cursor
    //   243: iload_3
    //   244: invokeinterface 269 2 0
    //   249: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload 5
    //   255: ldc 234
    //   257: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: iload 4
    //   263: iload_2
    //   264: if_icmplt +220 -> 484
    //   267: aload 9
    //   269: aload 5
    //   271: checkcast 236	java/lang/CharSequence
    //   274: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload 9
    //   280: ldc_w 274
    //   283: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: goto -125 -> 162
    //   290: astore 7
    //   292: aload 6
    //   294: astore 5
    //   296: aload_1
    //   297: getfield 78	com/tencent/mm/plugin/repairer/ui/demo/RepairerDBSelectDemoUI:TAG	Ljava/lang/String;
    //   300: ldc_w 276
    //   303: iconst_2
    //   304: anewarray 81	java/lang/Object
    //   307: dup
    //   308: iconst_0
    //   309: aload_0
    //   310: aastore
    //   311: dup
    //   312: iconst_1
    //   313: aload 7
    //   315: invokevirtual 279	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   318: aastore
    //   319: invokestatic 283	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   322: aload 6
    //   324: ifnull +10 -> 334
    //   327: aload 6
    //   329: invokeinterface 286 1 0
    //   334: new 288	com/tencent/mm/plugin/repairer/ui/demo/RepairerDBSelectDemoUI$a
    //   337: dup
    //   338: aload_1
    //   339: aload 10
    //   341: aload 9
    //   343: invokespecial 291	com/tencent/mm/plugin/repairer/ui/demo/RepairerDBSelectDemoUI$a:<init>	(Lcom/tencent/mm/plugin/repairer/ui/demo/RepairerDBSelectDemoUI;Lkotlin/g/b/ah$e;Ljava/lang/StringBuilder;)V
    //   346: checkcast 293	kotlin/g/a/a
    //   349: invokestatic 299	com/tencent/mm/ae/d:uiThread	(Lkotlin/g/a/a;)V
    //   352: ldc 167
    //   354: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   357: return
    //   358: aload 5
    //   360: arraylength
    //   361: istore_2
    //   362: goto -267 -> 95
    //   365: aload 5
    //   367: ldc_w 301
    //   370: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: goto -121 -> 253
    //   377: astore_0
    //   378: aload 6
    //   380: astore 5
    //   382: aload 5
    //   384: ifnull +10 -> 394
    //   387: aload 5
    //   389: invokeinterface 286 1 0
    //   394: ldc 167
    //   396: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   399: aload_0
    //   400: athrow
    //   401: aload 5
    //   403: ldc_w 303
    //   406: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: goto -157 -> 253
    //   413: aload 10
    //   415: invokestatic 181	java/lang/System:currentTimeMillis	()J
    //   418: aload 10
    //   420: getfield 185	kotlin/g/b/ah$e:aixc	J
    //   423: lsub
    //   424: putfield 185	kotlin/g/b/ah$e:aixc	J
    //   427: aload_1
    //   428: getfield 78	com/tencent/mm/plugin/repairer/ui/demo/RepairerDBSelectDemoUI:TAG	Ljava/lang/String;
    //   431: ldc_w 305
    //   434: iconst_2
    //   435: anewarray 81	java/lang/Object
    //   438: dup
    //   439: iconst_0
    //   440: aload 10
    //   442: getfield 185	kotlin/g/b/ah$e:aixc	J
    //   445: invokestatic 311	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   448: aastore
    //   449: dup
    //   450: iconst_1
    //   451: aload_0
    //   452: aastore
    //   453: invokestatic 313	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   456: aload 6
    //   458: ifnull -124 -> 334
    //   461: aload 6
    //   463: invokeinterface 286 1 0
    //   468: goto -134 -> 334
    //   471: astore_0
    //   472: goto -90 -> 382
    //   475: astore 7
    //   477: aload 8
    //   479: astore 6
    //   481: goto -189 -> 292
    //   484: iload 4
    //   486: istore_3
    //   487: goto -292 -> 195
    //   490: goto -254 -> 236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	493	0	paramString	String
    //   0	493	1	paramRepairerDBSelectDemoUI	RepairerDBSelectDemoUI
    //   94	268	2	i	int
    //   194	293	3	j	int
    //   198	287	4	k	int
    //   1	401	5	localObject1	Object
    //   58	422	6	localObject2	Object
    //   117	12	7	localCharSequence	java.lang.CharSequence
    //   290	24	7	localRuntimeException1	java.lang.RuntimeException
    //   475	1	7	localRuntimeException2	java.lang.RuntimeException
    //   4	474	8	localObject3	Object
    //   30	312	9	localStringBuilder	java.lang.StringBuilder
    //   39	402	10	locale	kotlin.g.b.ah.e
    // Exception table:
    //   from	to	target	type
    //   76	88	290	java/lang/RuntimeException
    //   95	108	290	java/lang/RuntimeException
    //   112	150	290	java/lang/RuntimeException
    //   150	162	290	java/lang/RuntimeException
    //   162	189	290	java/lang/RuntimeException
    //   200	236	290	java/lang/RuntimeException
    //   236	253	290	java/lang/RuntimeException
    //   253	261	290	java/lang/RuntimeException
    //   267	287	290	java/lang/RuntimeException
    //   358	362	290	java/lang/RuntimeException
    //   365	374	290	java/lang/RuntimeException
    //   401	410	290	java/lang/RuntimeException
    //   413	456	290	java/lang/RuntimeException
    //   76	88	377	finally
    //   95	108	377	finally
    //   112	150	377	finally
    //   150	162	377	finally
    //   162	189	377	finally
    //   200	236	377	finally
    //   236	253	377	finally
    //   253	261	377	finally
    //   267	287	377	finally
    //   358	362	377	finally
    //   365	374	377	finally
    //   401	410	377	finally
    //   413	456	377	finally
    //   60	76	471	finally
    //   296	322	471	finally
    //   60	76	475	java/lang/RuntimeException
  }
  
  private static final boolean a(RepairerDBSelectDemoUI paramRepairerDBSelectDemoUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(278178);
    s.u(paramRepairerDBSelectDemoUI, "this$0");
    paramRepairerDBSelectDemoUI.finish();
    AppMethodBeat.o(278178);
    return true;
  }
  
  private static final void b(RepairerDBSelectDemoUI paramRepairerDBSelectDemoUI, View paramView)
  {
    AppMethodBeat.i(278202);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramRepairerDBSelectDemoUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerDBSelectDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerDBSelectDemoUI, "this$0");
    paramView = "db_exec_info_" + f.formatTime("yyyy-MM-dd_HH_mm_ss", System.currentTimeMillis() / 1000L) + ".json";
    localObject = (com.tencent.mm.plugin.repairer.a)h.az(com.tencent.mm.plugin.repairer.a.class);
    paramRepairerDBSelectDemoUI = paramRepairerDBSelectDemoUI.OwT;
    if (paramRepairerDBSelectDemoUI == null) {
      paramRepairerDBSelectDemoUI = null;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.repairer.a)localObject).saveRepairerFile(paramView, paramRepairerDBSelectDemoUI, true);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/RepairerDBSelectDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(278202);
      return;
      paramRepairerDBSelectDemoUI = paramRepairerDBSelectDemoUI.getText();
      if (paramRepairerDBSelectDemoUI == null)
      {
        paramRepairerDBSelectDemoUI = null;
      }
      else
      {
        paramRepairerDBSelectDemoUI = paramRepairerDBSelectDemoUI.toString();
        if (paramRepairerDBSelectDemoUI == null)
        {
          paramRepairerDBSelectDemoUI = null;
        }
        else
        {
          paramRepairerDBSelectDemoUI = paramRepairerDBSelectDemoUI.getBytes(d.UTF_8);
          s.s(paramRepairerDBSelectDemoUI, "(this as java.lang.String).getBytes(charset)");
        }
      }
    }
  }
  
  public final int getLayoutId()
  {
    return b.d.Ovr;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(278250);
    super.onCreate(paramBundle);
    setMMTitle("DB查询工具Demo");
    setBackBtn(new RepairerDBSelectDemoUI..ExternalSyntheticLambda0(this));
    this.OwT = ((TextView)findViewById(b.c.result_tv));
    this.OwU = ((TextView)findViewById(b.c.OtG));
    ((Button)findViewById(b.c.ok_btn)).setOnClickListener(new RepairerDBSelectDemoUI..ExternalSyntheticLambda1(this));
    ((Button)findViewById(b.c.OtX)).setOnClickListener(new RepairerDBSelectDemoUI..ExternalSyntheticLambda2(this));
    AppMethodBeat.o(278250);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.RepairerDBSelectDemoUI
 * JD-Core Version:    0.7.0.1
 */