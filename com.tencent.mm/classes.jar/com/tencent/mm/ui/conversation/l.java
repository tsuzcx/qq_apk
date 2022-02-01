package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.format.Time;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.platformtools.e;
import com.tencent.mm.pluginsdk.platformtools.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.tools.v;
import com.tencent.mm.ui.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class l
  extends x<bb>
  implements MStorageEx.IOnStorageChange
{
  private static long afmV = 2000L;
  private float aeaW;
  private float aeaZ;
  private float aeba;
  HashMap<String, a> aebd;
  private boolean aebe;
  public String afmQ;
  private final int afmS;
  private final int afmT;
  private boolean afmW;
  MTimerHandler afmX;
  private String afoT;
  private ColorStateList[] afoU;
  private String hUQ;
  protected MMSlideDelView.g vzf;
  protected MMSlideDelView.c vzg;
  protected MMSlideDelView.f vzh;
  protected MMSlideDelView.d vzi;
  private boolean xhA;
  
  /* Error */
  public l(Context paramContext, String paramString, com.tencent.mm.ui.x.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: new 60	com/tencent/mm/storage/bb
    //   5: dup
    //   6: invokespecial 62	com/tencent/mm/storage/bb:<init>	()V
    //   9: invokespecial 65	com/tencent/mm/ui/x:<init>	(Landroid/content/Context;Ljava/lang/Object;)V
    //   12: ldc 66
    //   14: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   17: aload_0
    //   18: iconst_5
    //   19: anewarray 74	android/content/res/ColorStateList
    //   22: putfield 76	com/tencent/mm/ui/conversation/l:afoU	[Landroid/content/res/ColorStateList;
    //   25: aload_0
    //   26: invokestatic 82	com/tencent/mm/ui/base/MMSlideDelView:getItemStatusCallBack	()Lcom/tencent/mm/ui/base/MMSlideDelView$d;
    //   29: putfield 84	com/tencent/mm/ui/conversation/l:vzi	Lcom/tencent/mm/ui/base/MMSlideDelView$d;
    //   32: aload_0
    //   33: ldc 85
    //   35: putfield 87	com/tencent/mm/ui/conversation/l:aeaW	F
    //   38: aload_0
    //   39: ldc 85
    //   41: putfield 89	com/tencent/mm/ui/conversation/l:aeaZ	F
    //   44: aload_0
    //   45: ldc 85
    //   47: putfield 91	com/tencent/mm/ui/conversation/l:aeba	F
    //   50: aload_0
    //   51: iconst_0
    //   52: putfield 93	com/tencent/mm/ui/conversation/l:xhA	Z
    //   55: aload_0
    //   56: iconst_0
    //   57: putfield 95	com/tencent/mm/ui/conversation/l:aebe	Z
    //   60: aload_0
    //   61: ldc 97
    //   63: putfield 99	com/tencent/mm/ui/conversation/l:afmQ	Ljava/lang/String;
    //   66: aload_0
    //   67: iconst_0
    //   68: putfield 101	com/tencent/mm/ui/conversation/l:afmW	Z
    //   71: aload_0
    //   72: new 103	com/tencent/mm/sdk/platformtools/MTimerHandler
    //   75: dup
    //   76: invokestatic 109	com/tencent/mm/model/bh:baH	()Lcom/tencent/mm/sdk/platformtools/MMHandlerThread;
    //   79: invokevirtual 115	com/tencent/mm/sdk/platformtools/MMHandlerThread:getLooper	()Landroid/os/Looper;
    //   82: new 9	com/tencent/mm/ui/conversation/l$1
    //   85: dup
    //   86: aload_0
    //   87: invokespecial 118	com/tencent/mm/ui/conversation/l$1:<init>	(Lcom/tencent/mm/ui/conversation/l;)V
    //   90: iconst_0
    //   91: invokespecial 121	com/tencent/mm/sdk/platformtools/MTimerHandler:<init>	(Landroid/os/Looper;Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;Z)V
    //   94: putfield 123	com/tencent/mm/ui/conversation/l:afmX	Lcom/tencent/mm/sdk/platformtools/MTimerHandler;
    //   97: aload_0
    //   98: aload_3
    //   99: invokespecial 126	com/tencent/mm/ui/x:a	(Lcom/tencent/mm/ui/x$a;)V
    //   102: aload_0
    //   103: aload_2
    //   104: putfield 128	com/tencent/mm/ui/conversation/l:hUQ	Ljava/lang/String;
    //   107: invokestatic 134	com/tencent/mm/an/af:bHf	()Lcom/tencent/mm/an/f;
    //   110: pop
    //   111: aload_0
    //   112: aload_2
    //   113: invokestatic 140	com/tencent/mm/an/f:Ms	(Ljava/lang/String;)Ljava/lang/String;
    //   116: putfield 142	com/tencent/mm/ui/conversation/l:afoT	Ljava/lang/String;
    //   119: aload_0
    //   120: new 144	java/util/HashMap
    //   123: dup
    //   124: invokespecial 145	java/util/HashMap:<init>	()V
    //   127: putfield 147	com/tencent/mm/ui/conversation/l:aebd	Ljava/util/HashMap;
    //   130: aload_0
    //   131: getfield 76	com/tencent/mm/ui/conversation/l:afoU	[Landroid/content/res/ColorStateList;
    //   134: iconst_0
    //   135: aload_1
    //   136: getstatic 152	com/tencent/mm/R$e:hint_text_color	I
    //   139: invokestatic 158	com/tencent/mm/cd/a:l	(Landroid/content/Context;I)Landroid/content/res/ColorStateList;
    //   142: aastore
    //   143: aload_0
    //   144: getfield 76	com/tencent/mm/ui/conversation/l:afoU	[Landroid/content/res/ColorStateList;
    //   147: iconst_1
    //   148: aload_1
    //   149: getstatic 161	com/tencent/mm/R$e:mm_list_textcolor_unread	I
    //   152: invokestatic 158	com/tencent/mm/cd/a:l	(Landroid/content/Context;I)Landroid/content/res/ColorStateList;
    //   155: aastore
    //   156: aload_0
    //   157: getfield 76	com/tencent/mm/ui/conversation/l:afoU	[Landroid/content/res/ColorStateList;
    //   160: iconst_3
    //   161: aload_1
    //   162: getstatic 164	com/tencent/mm/R$e:normal_text_color	I
    //   165: invokestatic 158	com/tencent/mm/cd/a:l	(Landroid/content/Context;I)Landroid/content/res/ColorStateList;
    //   168: aastore
    //   169: aload_0
    //   170: getfield 76	com/tencent/mm/ui/conversation/l:afoU	[Landroid/content/res/ColorStateList;
    //   173: iconst_2
    //   174: aload_1
    //   175: getstatic 167	com/tencent/mm/R$e:mm_list_textcolor_three	I
    //   178: invokestatic 158	com/tencent/mm/cd/a:l	(Landroid/content/Context;I)Landroid/content/res/ColorStateList;
    //   181: aastore
    //   182: aload_0
    //   183: getfield 76	com/tencent/mm/ui/conversation/l:afoU	[Landroid/content/res/ColorStateList;
    //   186: iconst_2
    //   187: aload_1
    //   188: getstatic 167	com/tencent/mm/R$e:mm_list_textcolor_three	I
    //   191: invokestatic 158	com/tencent/mm/cd/a:l	(Landroid/content/Context;I)Landroid/content/res/ColorStateList;
    //   194: aastore
    //   195: aload_0
    //   196: getfield 76	com/tencent/mm/ui/conversation/l:afoU	[Landroid/content/res/ColorStateList;
    //   199: iconst_4
    //   200: aload_1
    //   201: getstatic 170	com/tencent/mm/R$e:light_text_color	I
    //   204: invokestatic 158	com/tencent/mm/cd/a:l	(Landroid/content/Context;I)Landroid/content/res/ColorStateList;
    //   207: aastore
    //   208: aload_1
    //   209: invokestatic 174	com/tencent/mm/cd/a:mq	(Landroid/content/Context;)Z
    //   212: ifeq +86 -> 298
    //   215: aload_0
    //   216: aload_1
    //   217: invokevirtual 180	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   220: getstatic 185	com/tencent/mm/R$f:ConversationTimeLargerWidth	I
    //   223: invokevirtual 191	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   226: putfield 193	com/tencent/mm/ui/conversation/l:afmT	I
    //   229: aload_0
    //   230: aload_1
    //   231: invokevirtual 180	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   234: getstatic 196	com/tencent/mm/R$f:ConversationTimeSmallWidth	I
    //   237: invokevirtual 191	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   240: putfield 198	com/tencent/mm/ui/conversation/l:afmS	I
    //   243: aload_0
    //   244: aload_1
    //   245: getstatic 201	com/tencent/mm/R$f:NormalTextSize	I
    //   248: invokestatic 205	com/tencent/mm/cd/a:br	(Landroid/content/Context;I)I
    //   251: i2f
    //   252: putfield 87	com/tencent/mm/ui/conversation/l:aeaW	F
    //   255: aload_0
    //   256: aload_1
    //   257: getstatic 208	com/tencent/mm/R$f:HintTextSize	I
    //   260: invokestatic 205	com/tencent/mm/cd/a:br	(Landroid/content/Context;I)I
    //   263: i2f
    //   264: putfield 89	com/tencent/mm/ui/conversation/l:aeaZ	F
    //   267: aload_0
    //   268: aload_1
    //   269: getstatic 211	com/tencent/mm/R$f:SmallestTextSize	I
    //   272: invokestatic 205	com/tencent/mm/cd/a:br	(Landroid/content/Context;I)I
    //   275: i2f
    //   276: putfield 91	com/tencent/mm/ui/conversation/l:aeba	F
    //   279: invokestatic 215	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
    //   282: pop
    //   283: invokestatic 221	com/tencent/mm/model/c:bzG	()Lcom/tencent/mm/storage/by;
    //   286: aload_0
    //   287: invokeinterface 227 2 0
    //   292: ldc 66
    //   294: invokestatic 230	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   297: return
    //   298: aload_1
    //   299: invokestatic 233	com/tencent/mm/cd/a:mp	(Landroid/content/Context;)Z
    //   302: ifeq +34 -> 336
    //   305: aload_0
    //   306: aload_1
    //   307: invokevirtual 180	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   310: getstatic 236	com/tencent/mm/R$f:ConversationTimeBiggerWidth	I
    //   313: invokevirtual 191	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   316: putfield 193	com/tencent/mm/ui/conversation/l:afmT	I
    //   319: aload_0
    //   320: aload_1
    //   321: invokevirtual 180	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   324: getstatic 196	com/tencent/mm/R$f:ConversationTimeSmallWidth	I
    //   327: invokevirtual 191	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   330: putfield 198	com/tencent/mm/ui/conversation/l:afmS	I
    //   333: goto -90 -> 243
    //   336: aload_0
    //   337: aload_1
    //   338: invokevirtual 180	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   341: getstatic 239	com/tencent/mm/R$f:ConversationTimeBigWidth	I
    //   344: invokevirtual 191	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   347: putfield 193	com/tencent/mm/ui/conversation/l:afmT	I
    //   350: aload_0
    //   351: aload_1
    //   352: invokevirtual 180	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   355: getstatic 242	com/tencent/mm/R$f:ConversationTimeSmallerWidth	I
    //   358: invokevirtual 191	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   361: putfield 198	com/tencent/mm/ui/conversation/l:afmS	I
    //   364: goto -121 -> 243
    //   367: astore_2
    //   368: goto -249 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	371	0	this	l
    //   0	371	1	paramContext	Context
    //   0	371	2	paramString	String
    //   0	371	3	parama	com.tencent.mm.ui.x.a
    // Exception table:
    //   from	to	target	type
    //   107	119	367	finally
  }
  
  public static bb a(bb parambb, Cursor paramCursor)
  {
    AppMethodBeat.i(257003);
    bb localbb = parambb;
    if (parambb == null) {
      localbb = new bb();
    }
    localbb.BF("");
    localbb.BG("");
    localbb.convertFrom(paramCursor);
    AppMethodBeat.o(257003);
    return localbb;
  }
  
  private CharSequence b(bb parambb, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(38535);
    if ((!Util.isNullOrNil(parambb.field_editingMsg)) && ((parambb.field_atCount <= 0) || (parambb.field_unReadCount <= 0)))
    {
      localObject1 = new SpannableStringBuilder(this.context.getString(R.l.gNc));
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(-5569532), 0, ((SpannableStringBuilder)localObject1).length(), 33);
      ((SpannableStringBuilder)localObject1).append(" ").append(com.tencent.mm.pluginsdk.ui.span.p.d(this.context, parambb.field_editingMsg, paramInt));
      AppMethodBeat.o(38535);
      return localObject1;
    }
    Object localObject1 = parambb.field_digest;
    if ((localObject1 != null) && (((String)localObject1).startsWith("<img src=\"original_label.png\"/>  ")))
    {
      parambb = new SpannableString(com.tencent.mm.pluginsdk.ui.span.p.e(this.context, (CharSequence)localObject1, paramInt));
      AppMethodBeat.o(38535);
      return parambb;
    }
    String str1;
    if ((t(parambb) == 47) || (t(parambb) == 1048625))
    {
      localObject1 = bAr(parambb.field_digest);
      str1 = "";
      if (localObject1 != null)
      {
        parambb = "[" + (String)localObject1 + "]";
        AppMethodBeat.o(38535);
        return parambb;
      }
      localObject1 = str1;
      if (parambb.field_digest != null)
      {
        localObject1 = str1;
        if (parambb.field_digest.contains(":"))
        {
          str1 = parambb.field_digest.substring(0, parambb.field_digest.indexOf(":"));
          String str2 = bAr(parambb.field_digest.substring(parambb.field_digest.indexOf(":") + 1).replace(" ", ""));
          localObject1 = str1;
          if (str2 != null)
          {
            parambb = "[" + str2 + "]";
            if (Util.isNullOrNil(str1))
            {
              AppMethodBeat.o(38535);
              return parambb;
            }
            parambb = str1 + ": " + parambb;
            AppMethodBeat.o(38535);
            return parambb;
          }
        }
      }
      str1 = this.context.getString(R.l.app_emoji);
      if (Util.isNullOrNil((String)localObject1))
      {
        localObject1 = str1;
        parambb.BF((String)localObject1);
      }
    }
    else
    {
      if (Util.isNullOrNil(parambb.field_digest)) {
        break label633;
      }
      if (Util.isNullOrNil(parambb.field_digestUser)) {
        break label622;
      }
      if ((parambb.field_isSend != 0) || (!au.bwE(parambb.field_username))) {
        break label610;
      }
      localObject1 = aa.aV(parambb.field_digestUser, parambb.field_username);
    }
    for (;;)
    {
      label610:
      label622:
      try
      {
        localObject1 = String.format(parambb.field_digest, new Object[] { localObject1 });
        str1 = ((String)localObject1).replace('\n', ' ');
        if ((parambb.field_atCount <= 0) || (parambb.field_unReadCount <= 0)) {
          break label661;
        }
        parambb = new SpannableStringBuilder(this.context.getString(R.l.gMY));
        parambb.setSpan(new ForegroundColorSpan(-5569532), 0, parambb.length(), 33);
        parambb.append(" ").append(com.tencent.mm.pluginsdk.ui.span.p.d(this.context, str1, paramInt));
        AppMethodBeat.o(38535);
        return parambb;
      }
      catch (Exception localException) {}
      localObject1 = (String)localObject1 + ": " + str1;
      break;
      localObject1 = aa.getDisplayName(parambb.field_digestUser);
      continue;
      localObject1 = parambb.field_digest;
      continue;
      label633:
      localObject2 = com.tencent.mm.booter.notification.a.h.a(parambb.field_isSend, parambb.field_username, parambb.field_content, t(parambb), this.context);
    }
    label661:
    Object localObject2 = str1;
    if (paramBoolean)
    {
      localObject2 = str1;
      if (parambb.field_unReadCount > 1) {
        localObject2 = this.context.getString(R.l.gNb, new Object[] { Integer.valueOf(parambb.field_unReadCount), str1 });
      }
    }
    parambb = com.tencent.mm.pluginsdk.ui.span.p.d(this.context, (CharSequence)localObject2, paramInt);
    AppMethodBeat.o(38535);
    return parambb;
  }
  
  private static String bAr(String paramString)
  {
    AppMethodBeat.i(38536);
    if ((paramString != null) && (paramString.length() == 32))
    {
      paramString = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoi(paramString);
      AppMethodBeat.o(38536);
      return paramString;
    }
    AppMethodBeat.o(38536);
    return null;
  }
  
  private void fHY()
  {
    AppMethodBeat.i(38538);
    if (this.aebd == null)
    {
      AppMethodBeat.o(38538);
      return;
    }
    Iterator localIterator = this.aebd.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).afna = null;
    }
    AppMethodBeat.o(38538);
  }
  
  private void jzT()
  {
    AppMethodBeat.i(38542);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38527);
        if (!bh.baz())
        {
          l.c(l.this).stopTimer();
          Log.e("MicroMsg.EnterpriseConversationAdapter", "dkpno handleDataChange acc has not ready");
          AppMethodBeat.o(38527);
          return;
        }
        long l = Util.nowMilliSecond();
        l.d(l.this);
        l = Util.milliSecondsToNow(l) * 3L;
        Log.d("MicroMsg.EnterpriseConversationAdapter", "dkpno handleDataChange guest:%d old:%d needNotify:%b", new Object[] { Long.valueOf(l), Long.valueOf(l.afmV), Boolean.valueOf(l.a(l.this)) });
        l.Au((l + l.afmV) / 2L);
        l.e(l.this);
        l.c(l.this).startTimer(l.afmV);
        AppMethodBeat.o(38527);
      }
    });
    AppMethodBeat.o(38542);
  }
  
  private CharSequence q(bb parambb)
  {
    AppMethodBeat.i(38537);
    if (parambb.field_status == 1)
    {
      parambb = this.context.getString(R.l.gNp);
      AppMethodBeat.o(38537);
      return parambb;
    }
    if (parambb.field_conversationTime == 9223372036854775807L)
    {
      AppMethodBeat.o(38537);
      return "";
    }
    parambb = f.d(this.context, parambb.field_conversationTime, true);
    AppMethodBeat.o(38537);
    return parambb;
  }
  
  private static int t(bb parambb)
  {
    int j = 1;
    AppMethodBeat.i(38534);
    parambb = parambb.field_msgType;
    int i = j;
    if (parambb != null)
    {
      i = j;
      if (parambb.length() <= 0) {}
    }
    try
    {
      i = Integer.valueOf(parambb).intValue();
      AppMethodBeat.o(38534);
      return i;
    }
    catch (NumberFormatException parambb)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  public final Cursor Fv()
  {
    AppMethodBeat.i(257107);
    Cursor localCursor = super.Fv();
    AppMethodBeat.o(257107);
    return localCursor;
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.vzh = paramf;
  }
  
  /* Error */
  public final void aNy()
  {
    // Byte code:
    //   0: ldc_w 557
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 560	com/tencent/mm/ui/conversation/l:fSd	()V
    //   10: new 562	java/util/LinkedList
    //   13: dup
    //   14: invokespecial 563	java/util/LinkedList:<init>	()V
    //   17: astore_1
    //   18: aload_1
    //   19: aload_0
    //   20: getfield 128	com/tencent/mm/ui/conversation/l:hUQ	Ljava/lang/String;
    //   23: invokestatic 569	com/tencent/mm/an/g:MG	(Ljava/lang/String;)Ljava/util/List;
    //   26: invokevirtual 573	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
    //   29: pop
    //   30: aload_0
    //   31: getfield 142	com/tencent/mm/ui/conversation/l:afoT	Ljava/lang/String;
    //   34: invokestatic 275	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   37: ifeq +52 -> 89
    //   40: invokestatic 215	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
    //   43: pop
    //   44: aload_0
    //   45: invokestatic 221	com/tencent/mm/model/c:bzG	()Lcom/tencent/mm/storage/by;
    //   48: iconst_1
    //   49: aload_1
    //   50: aload_0
    //   51: getfield 128	com/tencent/mm/ui/conversation/l:hUQ	Ljava/lang/String;
    //   54: invokeinterface 576 4 0
    //   59: invokevirtual 579	com/tencent/mm/ui/conversation/l:w	(Landroid/database/Cursor;)V
    //   62: aload_0
    //   63: getfield 583	com/tencent/mm/ui/conversation/l:adDx	Lcom/tencent/mm/ui/x$a;
    //   66: ifnull +12 -> 78
    //   69: aload_0
    //   70: getfield 583	com/tencent/mm/ui/conversation/l:adDx	Lcom/tencent/mm/ui/x$a;
    //   73: invokeinterface 588 1 0
    //   78: aload_0
    //   79: invokespecial 591	com/tencent/mm/ui/x:notifyDataSetChanged	()V
    //   82: ldc_w 557
    //   85: invokestatic 230	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: return
    //   89: aload_1
    //   90: aload_0
    //   91: getfield 142	com/tencent/mm/ui/conversation/l:afoT	Ljava/lang/String;
    //   94: invokevirtual 594	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   97: pop
    //   98: invokestatic 215	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
    //   101: pop
    //   102: aload_0
    //   103: invokestatic 221	com/tencent/mm/model/c:bzG	()Lcom/tencent/mm/storage/by;
    //   106: iconst_1
    //   107: aload_1
    //   108: aload_0
    //   109: getfield 128	com/tencent/mm/ui/conversation/l:hUQ	Ljava/lang/String;
    //   112: invokeinterface 576 4 0
    //   117: invokevirtual 579	com/tencent/mm/ui/conversation/l:w	(Landroid/database/Cursor;)V
    //   120: goto -58 -> 62
    //   123: astore_2
    //   124: goto -94 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	l
    //   17	91	1	localLinkedList	java.util.LinkedList
    //   123	1	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   18	30	123	finally
  }
  
  public final void aNz()
  {
    AppMethodBeat.i(38531);
    aNy();
    AppMethodBeat.o(38531);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(38533);
    bb localbb = (bb)getItem(paramInt);
    String str = localbb.field_username;
    paramViewGroup = null;
    if (paramView != null) {
      paramViewGroup = (b)paramView.getTag();
    }
    if ((paramView == null) || (paramViewGroup == null))
    {
      paramViewGroup = new b();
      if (com.tencent.mm.cd.a.mp(this.context))
      {
        paramView = View.inflate(this.context, R.i.giF, null);
        paramViewGroup.lBC = ((ImageView)paramView.findViewById(R.h.avatar_iv));
        paramViewGroup.afoW = ((NoMeasuredTextView)paramView.findViewById(R.h.nickname_tv));
        paramViewGroup.afoW.setTextSize(0, this.aeaW);
        paramViewGroup.afoW.setTextColor(this.afoU[3]);
        paramViewGroup.afoW.setShouldEllipsize(true);
        paramViewGroup.afoX = ((NoMeasuredTextView)paramView.findViewById(R.h.update_time_tv));
        paramViewGroup.afoX.setTextSize(0, this.aeba);
        paramViewGroup.afoX.setTextColor(this.afoU[4]);
        paramViewGroup.afoX.setShouldEllipsize(false);
        paramViewGroup.afoX.setGravity(5);
        paramViewGroup.afoY = ((NoMeasuredTextView)paramView.findViewById(R.h.last_msg_tv));
        paramViewGroup.afoY.setTextSize(0, this.aeaZ);
        paramViewGroup.afoY.setTextColor(this.afoU[0]);
        paramViewGroup.afoY.setShouldEllipsize(true);
        paramViewGroup.afoZ = ((TextView)paramView.findViewById(R.h.tipcnt_tv));
        paramViewGroup.afoZ.setBackgroundResource(v.nH(this.context));
        paramViewGroup.aebm = ((ImageView)paramView.findViewById(R.h.fKm));
        paramViewGroup.aebo = paramView.findViewById(R.h.fsw);
        paramView.findViewById(R.h.fYY).setVisibility(8);
        paramView.findViewById(R.h.fNi).setVisibility(8);
        paramView.setTag(paramViewGroup);
      }
    }
    for (;;)
    {
      a locala = (a)this.aebd.get(str);
      bh.bCz();
      Object localObject = c.bzA().JE(str);
      label382:
      boolean bool;
      if (locala == null)
      {
        locala = new a((byte)0);
        if (localObject != null)
        {
          locala.afnd = ((int)((com.tencent.mm.contact.d)localObject).maN);
          if (localObject == null) {
            break label1093;
          }
          bool = true;
          label390:
          locala.afnj = bool;
          if ((localObject == null) || (!((au)localObject).aMW())) {
            break label1099;
          }
          bool = true;
          label413:
          locala.afnl = bool;
          if ((localObject == null) || (!((au)localObject).aGe())) {
            break label1105;
          }
          bool = true;
          label436:
          locala.afng = bool;
          if (localbb.field_unReadCount <= 0) {
            break label1111;
          }
          bool = true;
          label454:
          locala.Snr = bool;
          locala.viewType = 0;
          if ((t(localbb) == 34) && (localbb.field_isSend == 0) && (!Util.isNullOrNil(localbb.field_content)) && (!new com.tencent.mm.modelvoice.p(localbb.field_content).paW)) {
            locala.viewType = 1;
          }
          locala.nickName = com.tencent.mm.pluginsdk.ui.span.p.b(this.context, aa.a((au)localObject, str, false), paramViewGroup.afoW.getTextSize());
          locala.afna = q(localbb);
          paramInt = (int)paramViewGroup.afoY.getTextSize();
          if ((!locala.afng) || (!locala.Snr)) {
            break label1117;
          }
          bool = true;
          label586:
          locala.afnb = b(localbb, paramInt, bool);
          locala.afnm = localbb.field_attrflag;
          switch (localbb.field_status)
          {
          case 3: 
          case 4: 
          default: 
            paramInt = -1;
            label654:
            locala.afnc = paramInt;
            bh.bCz();
            locala.aebg = c.bzG().k(localbb);
            locala.afnh = LocaleUtil.isChineseAppLang();
            this.aebd.put(str, locala);
          }
        }
      }
      for (;;)
      {
        if (locala.afna == null) {
          locala.afna = q(localbb);
        }
        if ((locala.afng) && (locala.Snr))
        {
          paramViewGroup.afoY.setTextColor(this.afoU[0]);
          label747:
          com.tencent.mm.booter.notification.a.h.qr(paramViewGroup.afoY.getWidth());
          com.tencent.mm.booter.notification.a.h.qs((int)paramViewGroup.afoY.getTextSize());
          com.tencent.mm.booter.notification.a.h.c(paramViewGroup.afoY.getPaint());
          if (locala.afnc == -1) {
            break label1167;
          }
          paramViewGroup.afoY.setCompoundLeftDrawablesWithIntrinsicBounds(locala.afnc);
          paramViewGroup.afoY.setDrawLeftDrawable(true);
          label807:
          paramViewGroup.afoY.setText(locala.afnb);
          paramViewGroup.afoW.setDrawRightDrawable(false);
          paramViewGroup.afoW.setText(locala.nickName);
          localObject = paramViewGroup.afoX.getLayoutParams();
          if (locala.afna.length() < 9) {
            break label1178;
          }
          if (((ViewGroup.LayoutParams)localObject).width != this.afmT)
          {
            ((ViewGroup.LayoutParams)localObject).width = this.afmT;
            paramViewGroup.afoX.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
          label893:
          paramViewGroup.afoX.setText(locala.afna);
          if (!locala.afng) {
            break label1211;
          }
          paramViewGroup.aebm.setVisibility(0);
          label921:
          a.b.g(paramViewGroup.lBC, str);
          paramViewGroup.afoZ.setVisibility(4);
          paramViewGroup.aebo.setVisibility(4);
          if ((locala.afnj) && (locala.afnd != 0))
          {
            paramInt = localbb.field_unReadCount;
            if (!locala.afng) {
              break label1228;
            }
            paramViewGroup = paramViewGroup.aebo;
            if (paramInt <= 0) {
              break label1223;
            }
            paramInt = 0;
            label987:
            paramViewGroup.setVisibility(paramInt);
          }
          label992:
          if ((!locala.aebg) || (localbb.field_conversationTime == -1L)) {
            break label1305;
          }
          paramView.findViewById(R.h.fDC).setBackgroundResource(R.g.comm_item_highlight_selector);
        }
        for (;;)
        {
          a.a.jlv().a(paramView, String.valueOf(locala.nickName), localbb.field_unReadCount, String.valueOf(locala.afna), String.valueOf(locala.afnb));
          AppMethodBeat.o(38533);
          return paramView;
          paramView = View.inflate(this.context, R.i.giE, null);
          break;
          locala.afnd = -1;
          break label382;
          label1093:
          bool = false;
          break label390;
          label1099:
          bool = false;
          break label413;
          label1105:
          bool = false;
          break label436;
          label1111:
          bool = false;
          break label454;
          label1117:
          bool = false;
          break label586;
          paramInt = -1;
          break label654;
          paramInt = R.k.msg_state_sending;
          break label654;
          paramInt = -1;
          break label654;
          paramInt = R.k.msg_state_failed;
          break label654;
          paramViewGroup.afoY.setTextColor(this.afoU[locala.viewType]);
          break label747;
          label1167:
          paramViewGroup.afoY.setDrawLeftDrawable(false);
          break label807;
          label1178:
          if (((ViewGroup.LayoutParams)localObject).width == this.afmS) {
            break label893;
          }
          ((ViewGroup.LayoutParams)localObject).width = this.afmS;
          paramViewGroup.afoX.setLayoutParams((ViewGroup.LayoutParams)localObject);
          break label893;
          label1211:
          paramViewGroup.aebm.setVisibility(8);
          break label921;
          label1223:
          paramInt = 4;
          break label987;
          label1228:
          if (paramInt > 99)
          {
            paramViewGroup.afoZ.setText("");
            paramViewGroup.afoZ.setBackgroundResource(R.k.badge_count_more);
            paramViewGroup.afoZ.setVisibility(0);
            break label992;
          }
          if (paramInt <= 0) {
            break label992;
          }
          paramViewGroup.afoZ.setText(String.valueOf(paramInt));
          paramViewGroup.afoZ.setBackgroundResource(v.bC(this.context, paramInt));
          paramViewGroup.afoZ.setVisibility(0);
          break label992;
          label1305:
          paramView.findViewById(R.h.fDC).setBackgroundResource(R.g.comm_list_item_selector);
        }
      }
    }
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(38539);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      Log.e("MicroMsg.EnterpriseConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
      AppMethodBeat.o(38539);
      return;
    }
    onNotifyChange((String)paramObject, null);
    AppMethodBeat.o(38539);
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(38540);
    Log.i("MicroMsg.EnterpriseConversationAdapter", "dkpno onNotifyChange mIsFront:%b mChangedBackground:%b event:%s", new Object[] { Boolean.valueOf(this.xhA), Boolean.valueOf(this.aebe), paramString });
    if ((!Util.isNullOrNil(paramString)) && (this.aebd != null)) {
      this.aebd.remove(paramString);
    }
    if (this.xhA)
    {
      Log.d("MicroMsg.EnterpriseConversationAdapter", "dkpno postTryNotify needNotify:%b timerStopped:%b", new Object[] { Boolean.valueOf(this.afmW), Boolean.valueOf(this.afmX.stopped()) });
      this.afmW = true;
      if (this.afmX.stopped()) {
        jzT();
      }
      AppMethodBeat.o(38540);
      return;
    }
    this.aebe = true;
    AppMethodBeat.o(38540);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(38529);
    if (this.vzi != null) {
      this.vzi.fSm();
    }
    this.xhA = false;
    AppMethodBeat.o(38529);
  }
  
  public final void onResume()
  {
    int i = 1;
    AppMethodBeat.i(38530);
    this.xhA = true;
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    localObject = e.a("MM/dd", (Time)localObject).toString();
    if (!this.afmQ.equals(localObject)) {}
    for (;;)
    {
      this.afmQ = ((String)localObject);
      if (i != 0) {
        fHY();
      }
      if (this.aebe)
      {
        super.onNotifyChange(null, null);
        this.aebe = false;
      }
      AppMethodBeat.o(38530);
      return;
      i = 0;
    }
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.vzg = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.vzf = paramg;
  }
  
  final class a
  {
    public boolean Snr;
    public boolean aebg;
    public CharSequence afna;
    public CharSequence afnb;
    public int afnc;
    public int afnd;
    public boolean afng;
    public boolean afnh;
    public boolean afnj;
    public boolean afnl;
    public int afnm;
    public CharSequence nickName;
    public int viewType;
    
    private a() {}
  }
  
  public static final class b
  {
    public ImageView aebm;
    public View aebo;
    public NoMeasuredTextView afoW;
    public NoMeasuredTextView afoX;
    public NoMeasuredTextView afoY;
    public TextView afoZ;
    public ImageView lBC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.l
 * JD-Core Version:    0.7.0.1
 */