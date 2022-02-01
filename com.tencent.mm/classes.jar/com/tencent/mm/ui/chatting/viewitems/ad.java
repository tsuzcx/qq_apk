package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gz;
import com.tencent.mm.g.b.a.hk;
import com.tencent.mm.g.b.a.hu;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.protocal.protobuf.czg;
import com.tencent.mm.protocal.protobuf.czh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.ah;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.util.e;
import java.util.LinkedList;

public final class ad
  extends c
{
  private a PLy;
  
  /* Error */
  private void a(final com.tencent.mm.ui.chatting.e.a parama, czh paramczh, MMNeat7extView paramMMNeat7extView)
  {
    // Byte code:
    //   0: ldc 30
    //   2: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 42	com/tencent/mm/model/z:aTY	()Ljava/lang/String;
    //   8: astore 9
    //   10: ldc 44
    //   12: invokestatic 50	com/tencent/mm/kernel/g:ah	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   15: checkcast 44	com/tencent/mm/plugin/patmsg/PluginPatMsg
    //   18: invokevirtual 54	com/tencent/mm/plugin/patmsg/PluginPatMsg:isNickClickable	()Z
    //   21: istore 6
    //   23: ldc 56
    //   25: ldc 58
    //   27: iconst_3
    //   28: anewarray 60	java/lang/Object
    //   31: dup
    //   32: iconst_0
    //   33: aload_2
    //   34: getfield 66	com/tencent/mm/protocal/protobuf/czh:iBd	Ljava/lang/String;
    //   37: aastore
    //   38: dup
    //   39: iconst_1
    //   40: aload_2
    //   41: getfield 70	com/tencent/mm/protocal/protobuf/czh:createTime	J
    //   44: invokestatic 76	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   47: aastore
    //   48: dup
    //   49: iconst_2
    //   50: aload_2
    //   51: getfield 80	com/tencent/mm/protocal/protobuf/czh:MEB	I
    //   54: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   57: aastore
    //   58: invokestatic 91	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: ldc 44
    //   63: invokestatic 50	com/tencent/mm/kernel/g:ah	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   66: checkcast 44	com/tencent/mm/plugin/patmsg/PluginPatMsg
    //   69: aload_2
    //   70: getfield 66	com/tencent/mm/protocal/protobuf/czh:iBd	Ljava/lang/String;
    //   73: aload_1
    //   74: invokevirtual 96	com/tencent/mm/ui/chatting/e/a:getTalkerUserName	()Ljava/lang/String;
    //   77: invokevirtual 100	com/tencent/mm/plugin/patmsg/PluginPatMsg:parseDisplayTemplate	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/plugin/patmsg/a/f;
    //   80: astore 10
    //   82: new 102	android/text/SpannableString
    //   85: dup
    //   86: aload 10
    //   88: getfield 107	com/tencent/mm/plugin/patmsg/a/f:result	Ljava/lang/String;
    //   91: invokespecial 110	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   94: astore 8
    //   96: aload_2
    //   97: getfield 113	com/tencent/mm/protocal/protobuf/czh:MEA	Ljava/lang/String;
    //   100: aload 9
    //   102: invokevirtual 119	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   105: istore 7
    //   107: invokestatic 125	com/tencent/mm/bb/v:bew	()Lcom/tencent/mm/bb/b;
    //   110: aload_1
    //   111: invokevirtual 96	com/tencent/mm/ui/chatting/e/a:getTalkerUserName	()Ljava/lang/String;
    //   114: invokevirtual 131	com/tencent/mm/bb/b:Pp	(Ljava/lang/String;)Lcom/tencent/mm/bb/a;
    //   117: astore 9
    //   119: invokestatic 137	com/tencent/mm/model/bg:aVF	()Lcom/tencent/mm/model/c;
    //   122: pop
    //   123: invokestatic 143	com/tencent/mm/model/c:azQ	()Lcom/tencent/mm/storage/ao;
    //   126: sipush 12311
    //   129: bipush 254
    //   131: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   134: invokevirtual 149	com/tencent/mm/storage/ao:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   137: checkcast 82	java/lang/Integer
    //   140: invokevirtual 153	java/lang/Integer:intValue	()I
    //   143: istore 5
    //   145: aload_1
    //   146: getfield 157	com/tencent/mm/ui/chatting/e/a:Pwc	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   149: invokevirtual 163	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getMMResources	()Landroid/content/res/Resources;
    //   152: ldc 164
    //   154: invokevirtual 170	android/content/res/Resources:getColor	(I)I
    //   157: istore 4
    //   159: aload 9
    //   161: ifnull +589 -> 750
    //   164: aload 9
    //   166: getfield 175	com/tencent/mm/bb/a:jgE	I
    //   169: bipush 254
    //   171: if_icmpne +6 -> 177
    //   174: goto +576 -> 750
    //   177: aload_3
    //   178: aload_1
    //   179: getfield 157	com/tencent/mm/ui/chatting/e/a:Pwc	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   182: invokevirtual 179	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getContext	()Landroid/app/Activity;
    //   185: invokevirtual 184	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   188: ldc 185
    //   190: invokevirtual 170	android/content/res/Resources:getColor	(I)I
    //   193: invokevirtual 190	com/tencent/mm/ui/widget/MMNeat7extView:setTextColor	(I)V
    //   196: aload_3
    //   197: aload_1
    //   198: getfield 157	com/tencent/mm/ui/chatting/e/a:Pwc	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   201: invokevirtual 179	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getContext	()Landroid/app/Activity;
    //   204: invokevirtual 184	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   207: ldc 191
    //   209: invokevirtual 195	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   212: invokevirtual 199	com/tencent/mm/ui/widget/MMNeat7extView:setBackground	(Landroid/graphics/drawable/Drawable;)V
    //   215: aload_1
    //   216: getfield 157	com/tencent/mm/ui/chatting/e/a:Pwc	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   219: invokevirtual 163	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getMMResources	()Landroid/content/res/Resources;
    //   222: ldc 185
    //   224: invokevirtual 170	android/content/res/Resources:getColor	(I)I
    //   227: istore 4
    //   229: iload 7
    //   231: ifeq +25 -> 256
    //   234: aload 8
    //   236: new 201	com/tencent/mm/ui/base/span/BoldForegroundColorSpan
    //   239: dup
    //   240: iload 4
    //   242: invokespecial 203	com/tencent/mm/ui/base/span/BoldForegroundColorSpan:<init>	(I)V
    //   245: iconst_0
    //   246: aload 8
    //   248: invokevirtual 206	android/text/SpannableString:length	()I
    //   251: bipush 17
    //   253: invokevirtual 210	android/text/SpannableString:setSpan	(Ljava/lang/Object;III)V
    //   256: aload_1
    //   257: getfield 157	com/tencent/mm/ui/chatting/e/a:Pwc	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   260: invokevirtual 179	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getContext	()Landroid/app/Activity;
    //   263: aload 8
    //   265: aload_3
    //   266: invokevirtual 214	com/tencent/mm/ui/widget/MMNeat7extView:getTextSize	()F
    //   269: invokestatic 219	com/tencent/mm/pluginsdk/ui/span/l:d	(Landroid/content/Context;Ljava/lang/CharSequence;F)Landroid/text/SpannableString;
    //   272: astore 9
    //   274: aload 9
    //   276: astore 8
    //   278: aload 8
    //   280: astore 9
    //   282: iload 6
    //   284: ifeq +250 -> 534
    //   287: aload 8
    //   289: astore 9
    //   291: aload 10
    //   293: getfield 223	com/tencent/mm/plugin/patmsg/a/f:ARm	Ljava/util/List;
    //   296: invokeinterface 228 1 0
    //   301: aload 10
    //   303: getfield 231	com/tencent/mm/plugin/patmsg/a/f:iPH	Ljava/util/List;
    //   306: invokeinterface 228 1 0
    //   311: if_icmpne +223 -> 534
    //   314: aload 8
    //   316: astore 9
    //   318: aload 10
    //   320: getfield 231	com/tencent/mm/plugin/patmsg/a/f:iPH	Ljava/util/List;
    //   323: invokeinterface 234 1 0
    //   328: ifne +206 -> 534
    //   331: iconst_0
    //   332: istore 4
    //   334: aload 8
    //   336: astore 9
    //   338: iload 4
    //   340: aload 10
    //   342: getfield 231	com/tencent/mm/plugin/patmsg/a/f:iPH	Ljava/util/List;
    //   345: invokeinterface 228 1 0
    //   350: if_icmpge +184 -> 534
    //   353: aload 10
    //   355: getfield 223	com/tencent/mm/plugin/patmsg/a/f:ARm	Ljava/util/List;
    //   358: iload 4
    //   360: invokeinterface 237 2 0
    //   365: checkcast 239	android/util/Pair
    //   368: astore 9
    //   370: ldc 56
    //   372: ldc 241
    //   374: iconst_2
    //   375: anewarray 60	java/lang/Object
    //   378: dup
    //   379: iconst_0
    //   380: aload 9
    //   382: getfield 245	android/util/Pair:first	Ljava/lang/Object;
    //   385: aastore
    //   386: dup
    //   387: iconst_1
    //   388: aload 9
    //   390: getfield 248	android/util/Pair:second	Ljava/lang/Object;
    //   393: aastore
    //   394: invokestatic 91	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   397: new 16	com/tencent/mm/ui/chatting/viewitems/ad$6
    //   400: dup
    //   401: aload_0
    //   402: aload_1
    //   403: invokespecial 251	com/tencent/mm/ui/chatting/viewitems/ad$6:<init>	(Lcom/tencent/mm/ui/chatting/viewitems/ad;Lcom/tencent/mm/ui/chatting/e/a;)V
    //   406: astore 11
    //   408: aload 11
    //   410: aload 10
    //   412: getfield 231	com/tencent/mm/plugin/patmsg/a/f:iPH	Ljava/util/List;
    //   415: iload 4
    //   417: invokeinterface 237 2 0
    //   422: invokevirtual 257	com/tencent/mm/pluginsdk/ui/span/p:setTag	(Ljava/lang/Object;)V
    //   425: aload 8
    //   427: aload 11
    //   429: aload 9
    //   431: getfield 245	android/util/Pair:first	Ljava/lang/Object;
    //   434: checkcast 82	java/lang/Integer
    //   437: invokevirtual 153	java/lang/Integer:intValue	()I
    //   440: aload 9
    //   442: getfield 248	android/util/Pair:second	Ljava/lang/Object;
    //   445: checkcast 82	java/lang/Integer
    //   448: invokevirtual 153	java/lang/Integer:intValue	()I
    //   451: bipush 17
    //   453: invokevirtual 210	android/text/SpannableString:setSpan	(Ljava/lang/Object;III)V
    //   456: iload 4
    //   458: iconst_1
    //   459: iadd
    //   460: istore 4
    //   462: goto -128 -> 334
    //   465: aload_3
    //   466: aload_1
    //   467: getfield 157	com/tencent/mm/ui/chatting/e/a:Pwc	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   470: invokevirtual 179	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getContext	()Landroid/app/Activity;
    //   473: invokevirtual 184	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   476: ldc_w 258
    //   479: invokevirtual 170	android/content/res/Resources:getColor	(I)I
    //   482: invokevirtual 190	com/tencent/mm/ui/widget/MMNeat7extView:setTextColor	(I)V
    //   485: aload_3
    //   486: aload_1
    //   487: getfield 157	com/tencent/mm/ui/chatting/e/a:Pwc	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   490: invokevirtual 179	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getContext	()Landroid/app/Activity;
    //   493: invokevirtual 184	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   496: ldc_w 259
    //   499: invokevirtual 195	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   502: invokevirtual 199	com/tencent/mm/ui/widget/MMNeat7extView:setBackground	(Landroid/graphics/drawable/Drawable;)V
    //   505: goto -276 -> 229
    //   508: astore 9
    //   510: aload 8
    //   512: astore_1
    //   513: aload 9
    //   515: astore 8
    //   517: ldc 56
    //   519: aload 8
    //   521: ldc_w 261
    //   524: iconst_0
    //   525: anewarray 60	java/lang/Object
    //   528: invokestatic 265	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   531: aload_1
    //   532: astore 9
    //   534: iload 7
    //   536: ifeq +187 -> 723
    //   539: invokestatic 269	com/tencent/mm/kernel/g:aAh	()Lcom/tencent/mm/kernel/e;
    //   542: invokevirtual 272	com/tencent/mm/kernel/e:azQ	()Lcom/tencent/mm/storage/ao;
    //   545: getstatic 278	com/tencent/mm/storage/ar$a:Oob	Lcom/tencent/mm/storage/ar$a;
    //   548: ldc_w 261
    //   551: invokevirtual 281	com/tencent/mm/storage/ao:a	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/String;)Ljava/lang/String;
    //   554: pop
    //   555: aload_2
    //   556: getfield 284	com/tencent/mm/protocal/protobuf/czh:MEC	I
    //   559: iconst_1
    //   560: if_icmpne +163 -> 723
    //   563: aload_3
    //   564: invokevirtual 287	com/tencent/mm/ui/widget/MMNeat7extView:getContext	()Landroid/content/Context;
    //   567: ldc_w 288
    //   570: aload_3
    //   571: invokevirtual 287	com/tencent/mm/ui/widget/MMNeat7extView:getContext	()Landroid/content/Context;
    //   574: ldc_w 289
    //   577: invokestatic 295	com/tencent/mm/cb/a:n	(Landroid/content/Context;I)I
    //   580: invokestatic 301	com/tencent/mm/ui/ar:m	(Landroid/content/Context;II)Landroid/graphics/drawable/Drawable;
    //   583: astore_1
    //   584: aload_1
    //   585: iconst_0
    //   586: iconst_0
    //   587: aload_1
    //   588: invokevirtual 306	android/graphics/drawable/Drawable:getIntrinsicWidth	()I
    //   591: iconst_2
    //   592: imul
    //   593: iconst_3
    //   594: idiv
    //   595: aload_1
    //   596: invokevirtual 309	android/graphics/drawable/Drawable:getIntrinsicHeight	()I
    //   599: iconst_2
    //   600: imul
    //   601: iconst_3
    //   602: idiv
    //   603: invokevirtual 313	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   606: new 315	com/tencent/mm/ui/widget/a
    //   609: dup
    //   610: aload_1
    //   611: invokespecial 317	com/tencent/mm/ui/widget/a:<init>	(Landroid/graphics/drawable/Drawable;)V
    //   614: astore_1
    //   615: new 319	android/text/SpannableStringBuilder
    //   618: dup
    //   619: aload 9
    //   621: invokespecial 320	android/text/SpannableStringBuilder:<init>	(Ljava/lang/CharSequence;)V
    //   624: astore_2
    //   625: new 102	android/text/SpannableString
    //   628: dup
    //   629: aload_3
    //   630: invokevirtual 287	com/tencent/mm/ui/widget/MMNeat7extView:getContext	()Landroid/content/Context;
    //   633: ldc_w 321
    //   636: invokevirtual 327	android/content/Context:getString	(I)Ljava/lang/String;
    //   639: invokespecial 110	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   642: astore 8
    //   644: aload 8
    //   646: aload_1
    //   647: iconst_2
    //   648: iconst_3
    //   649: bipush 17
    //   651: invokevirtual 210	android/text/SpannableString:setSpan	(Ljava/lang/Object;III)V
    //   654: aload_2
    //   655: aload 8
    //   657: invokevirtual 331	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    //   660: pop
    //   661: aload_3
    //   662: invokevirtual 287	com/tencent/mm/ui/widget/MMNeat7extView:getContext	()Landroid/content/Context;
    //   665: ldc_w 332
    //   668: invokevirtual 327	android/content/Context:getString	(I)Ljava/lang/String;
    //   671: iconst_2
    //   672: anewarray 60	java/lang/Object
    //   675: dup
    //   676: iconst_0
    //   677: ldc_w 334
    //   680: aastore
    //   681: dup
    //   682: iconst_1
    //   683: ldc_w 336
    //   686: aastore
    //   687: invokestatic 340	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   690: astore_1
    //   691: aload_2
    //   692: aload_3
    //   693: invokevirtual 287	com/tencent/mm/ui/widget/MMNeat7extView:getContext	()Landroid/content/Context;
    //   696: aload_1
    //   697: aload_3
    //   698: invokevirtual 214	com/tencent/mm/ui/widget/MMNeat7extView:getTextSize	()F
    //   701: f2i
    //   702: invokestatic 344	com/tencent/mm/pluginsdk/ui/span/l:c	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/text/SpannableString;
    //   705: invokevirtual 331	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    //   708: pop
    //   709: aload_3
    //   710: aload_2
    //   711: getstatic 350	android/widget/TextView$BufferType:SPANNABLE	Landroid/widget/TextView$BufferType;
    //   714: invokevirtual 353	com/tencent/mm/ui/widget/MMNeat7extView:a	(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V
    //   717: ldc 30
    //   719: invokestatic 356	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   722: return
    //   723: aload_3
    //   724: aload 9
    //   726: getstatic 350	android/widget/TextView$BufferType:SPANNABLE	Landroid/widget/TextView$BufferType;
    //   729: invokevirtual 353	com/tencent/mm/ui/widget/MMNeat7extView:a	(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V
    //   732: ldc 30
    //   734: invokestatic 356	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   737: return
    //   738: astore 9
    //   740: aload 8
    //   742: astore_1
    //   743: aload 9
    //   745: astore 8
    //   747: goto -230 -> 517
    //   750: aload 9
    //   752: ifnonnull -287 -> 465
    //   755: iload 5
    //   757: bipush 254
    //   759: if_icmpeq -294 -> 465
    //   762: goto -585 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	765	0	this	ad
    //   0	765	1	parama	com.tencent.mm.ui.chatting.e.a
    //   0	765	2	paramczh	czh
    //   0	765	3	paramMMNeat7extView	MMNeat7extView
    //   157	304	4	i	int
    //   143	617	5	j	int
    //   21	262	6	bool1	boolean
    //   105	430	7	bool2	boolean
    //   94	652	8	localObject1	Object
    //   8	433	9	localObject2	Object
    //   508	6	9	localException1	java.lang.Exception
    //   532	193	9	locala	com.tencent.mm.ui.chatting.e.a
    //   738	13	9	localException2	java.lang.Exception
    //   80	331	10	localf	com.tencent.mm.plugin.patmsg.a.f
    //   406	22	11	local6	6
    // Exception table:
    //   from	to	target	type
    //   107	159	508	java/lang/Exception
    //   164	174	508	java/lang/Exception
    //   177	229	508	java/lang/Exception
    //   234	256	508	java/lang/Exception
    //   256	274	508	java/lang/Exception
    //   465	505	508	java/lang/Exception
    //   291	314	738	java/lang/Exception
    //   318	331	738	java/lang/Exception
    //   338	456	738	java/lang/Exception
  }
  
  private void a(final com.tencent.mm.ui.chatting.e.a parama, ca paramca, czg paramczg, int paramInt)
  {
    AppMethodBeat.i(233787);
    Log.i("MicroMsg.ChattingItemAppMsgPat", "fll msg view contains record %d , show %d", new Object[] { Integer.valueOf(paramczg.yVw.size()), Integer.valueOf(paramInt) });
    this.PLy.xUE.removeAllViews();
    Activity localActivity = parama.Pwc.getContext();
    int i = 0;
    while (i < paramInt)
    {
      MMNeat7extView localMMNeat7extView = new MMNeat7extView(localActivity);
      localMMNeat7extView.setTextSize(0, localActivity.getResources().getDimensionPixelSize(2131165482));
      localMMNeat7extView.setPadding(localActivity.getResources().getDimensionPixelSize(2131165508), localActivity.getResources().getDimensionPixelSize(2131165508), localActivity.getResources().getDimensionPixelSize(2131165508), localActivity.getResources().getDimensionPixelSize(2131165508));
      localMMNeat7extView.setTextGravity(1);
      localMMNeat7extView.setClickable(true);
      a(parama, (czh)paramczg.yVw.get(i), localMMNeat7extView);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.width = -2;
      localLayoutParams.height = -2;
      if (parama.gRM())
      {
        localLayoutParams.topMargin = localActivity.getResources().getDimensionPixelSize(2131165508);
        localLayoutParams.bottomMargin = localActivity.getResources().getDimensionPixelSize(2131165508);
      }
      localLayoutParams.gravity = 1;
      this.PLy.xUE.addView(localMMNeat7extView, localLayoutParams);
      localMMNeat7extView.setTag(new bq(paramca, parama.gRM(), 0, "", '\000'));
      localMMNeat7extView.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(233779);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgPat$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          if (((PluginPatMsg)g.ah(PluginPatMsg.class)).isRevokePatMsgEnable())
          {
            localObject = (bq)paramAnonymousView.getTag();
            if ((localObject != null) && (((bq)localObject).dTX != null))
            {
              int i = ((ViewGroup)paramAnonymousView.getParent()).indexOfChild(paramAnonymousView);
              Log.i("MicroMsg.ChattingItemAppMsgPat", "long click msg %d, index %d", new Object[] { Long.valueOf(((bq)localObject).dTX.field_msgId), Integer.valueOf(i) });
              paramAnonymousView = e.boC(((bq)localObject).dTX.field_content);
              if (i < paramAnonymousView.yVw.size())
              {
                paramAnonymousView = (czh)paramAnonymousView.yVw.get(i);
                if (z.aTY().equals(paramAnonymousView.dRL))
                {
                  if (cl.aWz() - paramAnonymousView.createTime <= 120000L) {
                    ad.a(ad.this, parama, Pair.create(Long.valueOf(((bq)localObject).dTX.field_msgId), Long.valueOf(paramAnonymousView.createTime)));
                  }
                  for (;;)
                  {
                    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgPat$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(233779);
                    return true;
                    Log.w("MicroMsg.ChattingItemAppMsgPat", "expire revoke time %d", new Object[] { Long.valueOf(paramAnonymousView.createTime) });
                  }
                }
              }
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgPat$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(233779);
          return false;
        }
      });
      i += 1;
    }
    AppMethodBeat.o(233787);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(233785);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new an(paramLayoutInflater, 2131493505);
      ((View)localObject).setTag(new a().gY((View)localObject));
    }
    AppMethodBeat.o(233785);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, ca paramca, final String paramString)
  {
    AppMethodBeat.i(233786);
    Log.i("MicroMsg.ChattingItemAppMsgPat", "fill item %d, msgId %d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramca.field_msgId) });
    this.PLy = ((a)parama);
    String str = paramca.field_content;
    parama = ((com.tencent.mm.plugin.patmsg.a.b)g.af(com.tencent.mm.plugin.patmsg.a.b.class)).aJJ(str);
    int i = parama.yVw.size();
    Log.i("MicroMsg.ChattingItemAppMsgPat", "content:%s, talker:%s, recordNum:%d", new Object[] { str, parama.gnh, Integer.valueOf(i) });
    if (i > 0)
    {
      paramString = ((l)g.af(l.class)).eiy().aEx(paramString);
      if ((i < 5) || (paramString.field_msgId == paramca.field_msgId)) {
        break label368;
      }
    }
    label338:
    label343:
    label349:
    label368:
    for (int k = ((com.tencent.mm.plugin.patmsg.a.b)g.af(com.tencent.mm.plugin.patmsg.a.b.class)).HD(paramca.field_msgId);; k = 0)
    {
      paramString = (ah)parama1.bh(ah.class);
      boolean bool;
      label248:
      int j;
      if ((paramString != null) && (paramString.Nv(paramca.field_msgId)))
      {
        bool = true;
        Log.i("MicroMsg.ChattingItemAppMsgPat", "need fold %s, hasExpanded %s", new Object[] { Boolean.valueOf(k), Boolean.valueOf(bool) });
        if (bool) {
          break label338;
        }
        paramInt = 1;
        j = paramInt & k;
        if (j == 0) {
          break label343;
        }
      }
      for (paramInt = 3;; paramInt = i)
      {
        a(parama1, paramca, parama, paramInt);
        this.PLy.PLB.setTag(Long.valueOf(paramca.field_msgId));
        if (j == 0) {
          break label349;
        }
        this.PLy.PLB.setVisibility(0);
        this.PLy.PLB.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(233778);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgPat$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
            if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof Long)))
            {
              localObject = ((l)g.af(l.class)).eiy().Hb(((Long)paramAnonymousView.getTag()).longValue());
              if (paramString != null) {
                paramString.Nw(((eo)localObject).field_msgId);
              }
              paramAnonymousView.setVisibility(8);
              paramAnonymousView = ((com.tencent.mm.plugin.patmsg.a.b)g.af(com.tencent.mm.plugin.patmsg.a.b.class)).aJJ(((eo)localObject).field_content);
              ad.a(ad.this, parama1, (ca)localObject, paramAnonymousView, paramAnonymousView.yVw.size());
              localObject = new gz();
              ((gz)localObject).eLk = ((gz)localObject).x("ChatUsername", parama1.getTalkerUserName(), true);
              ((gz)localObject).etW = ((gz)localObject).x("Username", parama1.PkU, true);
              ((gz)localObject).eLl = paramAnonymousView.yVw.size();
              if (!ab.Ix(parama1.getTalkerUserName())) {
                break label240;
              }
            }
            label240:
            for (((gz)localObject).enq = 2;; ((gz)localObject).enq = 1)
            {
              ((gz)localObject).bfK();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgPat$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(233778);
              return;
            }
          }
        });
        AppMethodBeat.o(233786);
        return;
        bool = false;
        break;
        paramInt = 0;
        break label248;
      }
      this.PLy.PLB.setVisibility(8);
      AppMethodBeat.o(233786);
      return;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean a(m paramm, View paramView, ca paramca)
  {
    return false;
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (paramInt == 889192497) || (paramInt == 922746929);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean gTT()
  {
    return false;
  }
  
  final boolean gTV()
  {
    return false;
  }
  
  public static final class a
    extends c.a
  {
    public TextView PLB;
    public LinearLayout xUE;
    
    public final a gY(View paramView)
    {
      AppMethodBeat.i(233784);
      super.create(paramView);
      this.xUE = ((LinearLayout)paramView.findViewById(2131305792));
      this.PLB = ((TextView)paramView.findViewById(2131301628));
      this.maskView = paramView.findViewById(2131298508);
      AppMethodBeat.o(233784);
      return this;
    }
    
    public final View getMainContainerView()
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ad
 * JD-Core Version:    0.7.0.1
 */