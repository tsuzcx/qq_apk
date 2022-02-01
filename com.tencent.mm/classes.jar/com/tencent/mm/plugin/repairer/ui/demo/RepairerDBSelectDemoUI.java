package com.tencent.mm.plugin.repairer.ui.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.repairer.ui.b.a;
import com.tencent.mm.plugin.repairer.ui.b.b;
import com.tencent.mm.pluginsdk.j.f;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.widget.MMEditText;
import java.nio.charset.Charset;
import kotlin.g.b.aa.e;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.d;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/repairer/ui/demo/RepairerDBSelectDemoUI;", "Lcom/tencent/mm/ui/report/MMSecDataActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "costView", "Landroid/widget/TextView;", "getCostView", "()Landroid/widget/TextView;", "setCostView", "(Landroid/widget/TextView;)V", "resultView", "getResultView", "setResultView", "execSql", "", "exportSql", "getLayoutId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "ui-repairer_release"})
public final class RepairerDBSelectDemoUI
  extends MMSecDataActivity
{
  TextView Ixy;
  TextView Ixz;
  final String TAG = "MicroMsg.RepairerDBSelectDemoUI";
  
  public final int getLayoutId()
  {
    return b.b.IwF;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(226992);
    super.onCreate(paramBundle);
    setMMTitle("DB查询工具Demo");
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    this.Ixy = ((TextView)findViewById(b.a.result_tv));
    this.Ixz = ((TextView)findViewById(b.a.IvY));
    ((Button)findViewById(b.a.ok_btn)).setOnClickListener((View.OnClickListener)new c(this));
    ((Button)findViewById(b.a.Iwf)).setOnClickListener((View.OnClickListener)new d(this));
    AppMethodBeat.o(226992);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(RepairerDBSelectDemoUI paramRepairerDBSelectDemoUI, String paramString) {}
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: aconst_null
      //   3: astore 6
      //   5: ldc 37
      //   7: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   10: new 45	java/lang/StringBuilder
      //   13: dup
      //   14: invokespecial 46	java/lang/StringBuilder:<init>	()V
      //   17: astore 7
      //   19: new 48	kotlin/g/b/aa$e
      //   22: dup
      //   23: invokespecial 49	kotlin/g/b/aa$e:<init>	()V
      //   26: astore 8
      //   28: aload 8
      //   30: invokestatic 55	java/lang/System:currentTimeMillis	()J
      //   33: putfield 59	kotlin/g/b/aa$e:aaBB	J
      //   36: invokestatic 65	com/tencent/mm/kernel/h:aHG	()Lcom/tencent/mm/kernel/f;
      //   39: astore 4
      //   41: aload 4
      //   43: ldc 67
      //   45: invokestatic 73	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
      //   48: aload 4
      //   50: invokevirtual 79	com/tencent/mm/kernel/f:getDataDB	()Lcom/tencent/mm/storagebase/h;
      //   53: astore 4
      //   55: aload 4
      //   57: ldc 81
      //   59: invokestatic 73	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
      //   62: aload 4
      //   64: invokevirtual 87	com/tencent/mm/storagebase/h:hBZ	()Lcom/tencent/wcdb/database/SQLiteDatabase;
      //   67: astore 4
      //   69: aload 4
      //   71: getstatic 93	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
      //   74: aload_0
      //   75: getfield 30	com/tencent/mm/plugin/repairer/ui/demo/RepairerDBSelectDemoUI$a:IxB	Ljava/lang/String;
      //   78: aconst_null
      //   79: aconst_null
      //   80: invokevirtual 99	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
      //   83: checkcast 101	android/database/Cursor
      //   86: astore 4
      //   88: aload 4
      //   90: invokeinterface 105 1 0
      //   95: astore_3
      //   96: aload_3
      //   97: ifnull +414 -> 511
      //   100: aload_3
      //   101: arraylength
      //   102: istore_1
      //   103: aload_0
      //   104: getfield 28	com/tencent/mm/plugin/repairer/ui/demo/RepairerDBSelectDemoUI$a:IxA	Lcom/tencent/mm/plugin/repairer/ui/demo/RepairerDBSelectDemoUI;
      //   107: getfield 108	com/tencent/mm/plugin/repairer/ui/demo/RepairerDBSelectDemoUI:TAG	Ljava/lang/String;
      //   110: new 45	java/lang/StringBuilder
      //   113: dup
      //   114: ldc 110
      //   116: invokespecial 113	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   119: aload_0
      //   120: getfield 30	com/tencent/mm/plugin/repairer/ui/demo/RepairerDBSelectDemoUI$a:IxB	Ljava/lang/String;
      //   123: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   126: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   129: invokestatic 126	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   132: iload_1
      //   133: ifle +56 -> 189
      //   136: new 45	java/lang/StringBuilder
      //   139: dup
      //   140: ldc 128
      //   142: invokespecial 113	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   145: astore 5
      //   147: ldc 130
      //   149: checkcast 132	java/lang/CharSequence
      //   152: astore 6
      //   154: aload_3
      //   155: ifnonnull +6 -> 161
      //   158: invokestatic 135	kotlin/g/b/p:iCn	()V
      //   161: aload 7
      //   163: aload 5
      //   165: aload 6
      //   167: aload_3
      //   168: invokestatic 141	android/text/TextUtils:join	(Ljava/lang/CharSequence;[Ljava/lang/Object;)Ljava/lang/String;
      //   171: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   174: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   177: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   180: pop
      //   181: aload 7
      //   183: ldc 143
      //   185: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   188: pop
      //   189: new 45	java/lang/StringBuilder
      //   192: dup
      //   193: sipush 1024
      //   196: invokespecial 145	java/lang/StringBuilder:<init>	(I)V
      //   199: astore_3
      //   200: aload 4
      //   202: invokeinterface 149 1 0
      //   207: ifeq +224 -> 431
      //   210: aload_3
      //   211: iconst_0
      //   212: invokevirtual 152	java/lang/StringBuilder:setLength	(I)V
      //   215: aload_3
      //   216: ldc 128
      //   218: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   221: pop
      //   222: iconst_0
      //   223: istore_2
      //   224: iload_2
      //   225: iload_1
      //   226: if_icmpge +184 -> 410
      //   229: aload 4
      //   231: iload_2
      //   232: invokeinterface 156 2 0
      //   237: lookupswitch	default:+271->508, 0:+54->291, 4:+136->373
      //   265: aload 4
      //   267: iload_2
      //   268: invokeinterface 160 2 0
      //   273: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   276: pop
      //   277: aload_3
      //   278: ldc 130
      //   280: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   283: pop
      //   284: iload_2
      //   285: iconst_1
      //   286: iadd
      //   287: istore_2
      //   288: goto -64 -> 224
      //   291: aload_3
      //   292: ldc 162
      //   294: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   297: pop
      //   298: goto -21 -> 277
      //   301: astore 5
      //   303: aload 4
      //   305: astore_3
      //   306: aload_0
      //   307: getfield 28	com/tencent/mm/plugin/repairer/ui/demo/RepairerDBSelectDemoUI$a:IxA	Lcom/tencent/mm/plugin/repairer/ui/demo/RepairerDBSelectDemoUI;
      //   310: getfield 108	com/tencent/mm/plugin/repairer/ui/demo/RepairerDBSelectDemoUI:TAG	Ljava/lang/String;
      //   313: ldc 164
      //   315: iconst_2
      //   316: anewarray 4	java/lang/Object
      //   319: dup
      //   320: iconst_0
      //   321: aload_0
      //   322: getfield 30	com/tencent/mm/plugin/repairer/ui/demo/RepairerDBSelectDemoUI$a:IxB	Ljava/lang/String;
      //   325: aastore
      //   326: dup
      //   327: iconst_1
      //   328: aload 5
      //   330: invokevirtual 167	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
      //   333: aastore
      //   334: invokestatic 171	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   337: aload 4
      //   339: ifnull +10 -> 349
      //   342: aload 4
      //   344: invokeinterface 174 1 0
      //   349: new 10	com/tencent/mm/plugin/repairer/ui/demo/RepairerDBSelectDemoUI$a$1
      //   352: dup
      //   353: aload_0
      //   354: aload 8
      //   356: aload 7
      //   358: invokespecial 177	com/tencent/mm/plugin/repairer/ui/demo/RepairerDBSelectDemoUI$a$1:<init>	(Lcom/tencent/mm/plugin/repairer/ui/demo/RepairerDBSelectDemoUI$a;Lkotlin/g/b/aa$e;Ljava/lang/StringBuilder;)V
      //   361: checkcast 179	kotlin/g/a/a
      //   364: invokestatic 185	com/tencent/mm/ae/d:uiThread	(Lkotlin/g/a/a;)V
      //   367: ldc 37
      //   369: invokestatic 188	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   372: return
      //   373: aload_3
      //   374: ldc 190
      //   376: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   379: pop
      //   380: goto -103 -> 277
      //   383: astore 5
      //   385: aload 4
      //   387: astore_3
      //   388: aload 5
      //   390: astore 4
      //   392: aload_3
      //   393: ifnull +9 -> 402
      //   396: aload_3
      //   397: invokeinterface 174 1 0
      //   402: ldc 37
      //   404: invokestatic 188	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   407: aload 4
      //   409: athrow
      //   410: aload 7
      //   412: aload_3
      //   413: checkcast 132	java/lang/CharSequence
      //   416: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
      //   419: pop
      //   420: aload 7
      //   422: ldc 195
      //   424: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   427: pop
      //   428: goto -228 -> 200
      //   431: aload 8
      //   433: invokestatic 55	java/lang/System:currentTimeMillis	()J
      //   436: aload 8
      //   438: getfield 59	kotlin/g/b/aa$e:aaBB	J
      //   441: lsub
      //   442: putfield 59	kotlin/g/b/aa$e:aaBB	J
      //   445: aload_0
      //   446: getfield 28	com/tencent/mm/plugin/repairer/ui/demo/RepairerDBSelectDemoUI$a:IxA	Lcom/tencent/mm/plugin/repairer/ui/demo/RepairerDBSelectDemoUI;
      //   449: getfield 108	com/tencent/mm/plugin/repairer/ui/demo/RepairerDBSelectDemoUI:TAG	Ljava/lang/String;
      //   452: ldc 197
      //   454: iconst_2
      //   455: anewarray 4	java/lang/Object
      //   458: dup
      //   459: iconst_0
      //   460: aload 8
      //   462: getfield 59	kotlin/g/b/aa$e:aaBB	J
      //   465: invokestatic 203	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   468: aastore
      //   469: dup
      //   470: iconst_1
      //   471: aload_0
      //   472: getfield 30	com/tencent/mm/plugin/repairer/ui/demo/RepairerDBSelectDemoUI$a:IxB	Ljava/lang/String;
      //   475: aastore
      //   476: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   479: aload 4
      //   481: ifnull -132 -> 349
      //   484: aload 4
      //   486: invokeinterface 174 1 0
      //   491: goto -142 -> 349
      //   494: astore 4
      //   496: goto -104 -> 392
      //   499: astore 5
      //   501: aload 6
      //   503: astore 4
      //   505: goto -202 -> 303
      //   508: goto -244 -> 264
      //   511: iconst_0
      //   512: istore_1
      //   513: goto -410 -> 103
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	516	0	this	a
      //   102	411	1	i	int
      //   223	65	2	j	int
      //   1	412	3	localObject1	Object
      //   39	446	4	localObject2	Object
      //   494	1	4	localObject3	Object
      //   503	1	4	localCharSequence1	java.lang.CharSequence
      //   145	19	5	localStringBuilder1	StringBuilder
      //   301	28	5	localRuntimeException1	java.lang.RuntimeException
      //   383	6	5	localObject4	Object
      //   499	1	5	localRuntimeException2	java.lang.RuntimeException
      //   3	499	6	localCharSequence2	java.lang.CharSequence
      //   17	404	7	localStringBuilder2	StringBuilder
      //   26	435	8	locale	aa.e
      // Exception table:
      //   from	to	target	type
      //   88	96	301	java/lang/RuntimeException
      //   100	103	301	java/lang/RuntimeException
      //   103	132	301	java/lang/RuntimeException
      //   136	154	301	java/lang/RuntimeException
      //   158	161	301	java/lang/RuntimeException
      //   161	189	301	java/lang/RuntimeException
      //   189	200	301	java/lang/RuntimeException
      //   200	222	301	java/lang/RuntimeException
      //   229	264	301	java/lang/RuntimeException
      //   264	277	301	java/lang/RuntimeException
      //   277	284	301	java/lang/RuntimeException
      //   291	298	301	java/lang/RuntimeException
      //   373	380	301	java/lang/RuntimeException
      //   410	428	301	java/lang/RuntimeException
      //   431	479	301	java/lang/RuntimeException
      //   88	96	383	finally
      //   100	103	383	finally
      //   103	132	383	finally
      //   136	154	383	finally
      //   158	161	383	finally
      //   161	189	383	finally
      //   189	200	383	finally
      //   200	222	383	finally
      //   229	264	383	finally
      //   264	277	383	finally
      //   277	284	383	finally
      //   291	298	383	finally
      //   373	380	383	finally
      //   410	428	383	finally
      //   431	479	383	finally
      //   69	88	494	finally
      //   306	337	494	finally
      //   69	88	499	java/lang/RuntimeException
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(RepairerDBSelectDemoUI paramRepairerDBSelectDemoUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(226788);
      this.IxA.finish();
      AppMethodBeat.o(226788);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(RepairerDBSelectDemoUI paramRepairerDBSelectDemoUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(226647);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerDBSelectDemoUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      paramView = this.IxA;
      if (MMApplicationContext.isMMProcess())
      {
        localObject = paramView.findViewById(b.a.Iwi);
        p.j(localObject, "findViewById<MMEditText>(R.id.id_sql)");
        localObject = ((MMEditText)localObject).getText().toString();
        if ((localObject != null) && (((String)localObject).length() > 0)) {
          h.aHJ().postToWorker((Runnable)new RepairerDBSelectDemoUI.a(paramView, (String)localObject));
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/repairer/ui/demo/RepairerDBSelectDemoUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(226647);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(RepairerDBSelectDemoUI paramRepairerDBSelectDemoUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(227045);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerDBSelectDemoUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      paramView = this.IxA;
      localObject = "db_exec_info_" + f.formatTime("yyyy-MM-dd_HH_mm_ss", System.currentTimeMillis() / 1000L) + ".json";
      com.tencent.mm.plugin.repairer.a locala = (com.tencent.mm.plugin.repairer.a)h.ag(com.tencent.mm.plugin.repairer.a.class);
      paramView = paramView.Ixy;
      if (paramView != null)
      {
        paramView = paramView.getText();
        if (paramView != null)
        {
          paramView = paramView.toString();
          if (paramView != null)
          {
            Charset localCharset = d.UTF_8;
            if (paramView == null)
            {
              paramView = new t("null cannot be cast to non-null type java.lang.String");
              AppMethodBeat.o(227045);
              throw paramView;
            }
            paramView = paramView.getBytes(localCharset);
            p.j(paramView, "(this as java.lang.String).getBytes(charset)");
          }
        }
      }
      for (;;)
      {
        locala.saveRepairerFile((String)localObject, paramView, true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/repairer/ui/demo/RepairerDBSelectDemoUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(227045);
        return;
        paramView = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.RepairerDBSelectDemoUI
 * JD-Core Version:    0.7.0.1
 */