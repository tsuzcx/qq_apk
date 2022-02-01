package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
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
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.f.b.a.je;
import com.tencent.mm.f.b.a.jq;
import com.tencent.mm.f.b.a.kc;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.protocal.protobuf.dit;
import com.tencent.mm.protocal.protobuf.diu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.ai;
import com.tencent.mm.ui.chatting.d.b.r;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.util.g;
import java.util.LinkedList;

public final class ag
  extends c
{
  private a Xhs;
  
  /* Error */
  private void a(com.tencent.mm.ui.chatting.e.a parama, diu paramdiu, MMNeat7extView paramMMNeat7extView)
  {
    // Byte code:
    //   0: ldc 26
    //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 38	com/tencent/mm/model/z:bcZ	()Ljava/lang/String;
    //   8: astore 9
    //   10: ldc 40
    //   12: invokestatic 46	com/tencent/mm/kernel/h:ag	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   15: checkcast 40	com/tencent/mm/plugin/patmsg/PluginPatMsg
    //   18: invokevirtual 50	com/tencent/mm/plugin/patmsg/PluginPatMsg:isNickClickable	()Z
    //   21: istore 6
    //   23: ldc 52
    //   25: ldc 54
    //   27: iconst_3
    //   28: anewarray 56	java/lang/Object
    //   31: dup
    //   32: iconst_0
    //   33: aload_2
    //   34: getfield 62	com/tencent/mm/protocal/protobuf/diu:lqH	Ljava/lang/String;
    //   37: aastore
    //   38: dup
    //   39: iconst_1
    //   40: aload_2
    //   41: getfield 66	com/tencent/mm/protocal/protobuf/diu:createTime	J
    //   44: invokestatic 72	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   47: aastore
    //   48: dup
    //   49: iconst_2
    //   50: aload_2
    //   51: getfield 76	com/tencent/mm/protocal/protobuf/diu:TQl	I
    //   54: invokestatic 81	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   57: aastore
    //   58: invokestatic 87	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: ldc 40
    //   63: invokestatic 46	com/tencent/mm/kernel/h:ag	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   66: checkcast 40	com/tencent/mm/plugin/patmsg/PluginPatMsg
    //   69: aload_2
    //   70: getfield 62	com/tencent/mm/protocal/protobuf/diu:lqH	Ljava/lang/String;
    //   73: aload_1
    //   74: invokevirtual 92	com/tencent/mm/ui/chatting/e/a:getTalkerUserName	()Ljava/lang/String;
    //   77: invokevirtual 96	com/tencent/mm/plugin/patmsg/PluginPatMsg:parseDisplayTemplate	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/plugin/patmsg/a/f;
    //   80: astore 10
    //   82: new 98	android/text/SpannableString
    //   85: dup
    //   86: aload 10
    //   88: getfield 103	com/tencent/mm/plugin/patmsg/a/f:result	Ljava/lang/String;
    //   91: invokespecial 106	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   94: astore 8
    //   96: aload_2
    //   97: getfield 109	com/tencent/mm/protocal/protobuf/diu:TQk	Ljava/lang/String;
    //   100: aload 9
    //   102: invokevirtual 115	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   105: istore 7
    //   107: invokestatic 121	com/tencent/mm/be/w:bnV	()Lcom/tencent/mm/be/b;
    //   110: aload_1
    //   111: invokevirtual 92	com/tencent/mm/ui/chatting/e/a:getTalkerUserName	()Ljava/lang/String;
    //   114: invokevirtual 127	com/tencent/mm/be/b:WM	(Ljava/lang/String;)Lcom/tencent/mm/be/a;
    //   117: astore 9
    //   119: invokestatic 133	com/tencent/mm/model/bh:beI	()Lcom/tencent/mm/model/c;
    //   122: pop
    //   123: invokestatic 139	com/tencent/mm/model/c:aHp	()Lcom/tencent/mm/storage/ao;
    //   126: sipush 12311
    //   129: bipush 254
    //   131: invokestatic 81	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   134: invokevirtual 145	com/tencent/mm/storage/ao:b	(ILjava/lang/Object;)Ljava/lang/Object;
    //   137: checkcast 78	java/lang/Integer
    //   140: invokevirtual 149	java/lang/Integer:intValue	()I
    //   143: istore 5
    //   145: aload_1
    //   146: getfield 153	com/tencent/mm/ui/chatting/e/a:WQv	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   149: invokevirtual 159	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getMMResources	()Landroid/content/res/Resources;
    //   152: getstatic 164	com/tencent/mm/R$e:FG_1	I
    //   155: invokevirtual 170	android/content/res/Resources:getColor	(I)I
    //   158: istore 4
    //   160: aload 9
    //   162: ifnull +593 -> 755
    //   165: aload 9
    //   167: getfield 175	com/tencent/mm/be/a:lXh	I
    //   170: bipush 254
    //   172: if_icmpne +6 -> 178
    //   175: goto +580 -> 755
    //   178: aload_3
    //   179: aload_1
    //   180: getfield 153	com/tencent/mm/ui/chatting/e/a:WQv	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   183: invokevirtual 179	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getContext	()Landroid/app/Activity;
    //   186: invokevirtual 184	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   189: getstatic 187	com/tencent/mm/R$e:FG_0	I
    //   192: invokevirtual 170	android/content/res/Resources:getColor	(I)I
    //   195: invokevirtual 192	com/tencent/mm/ui/widget/MMNeat7extView:setTextColor	(I)V
    //   198: aload_3
    //   199: aload_1
    //   200: getfield 153	com/tencent/mm/ui/chatting/e/a:WQv	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   203: invokevirtual 179	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getContext	()Landroid/app/Activity;
    //   206: invokevirtual 184	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   209: getstatic 197	com/tencent/mm/R$g:dnc	I
    //   212: invokevirtual 201	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   215: invokevirtual 205	com/tencent/mm/ui/widget/MMNeat7extView:setBackground	(Landroid/graphics/drawable/Drawable;)V
    //   218: aload_1
    //   219: getfield 153	com/tencent/mm/ui/chatting/e/a:WQv	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   222: invokevirtual 159	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getMMResources	()Landroid/content/res/Resources;
    //   225: getstatic 187	com/tencent/mm/R$e:FG_0	I
    //   228: invokevirtual 170	android/content/res/Resources:getColor	(I)I
    //   231: istore 4
    //   233: iload 7
    //   235: ifeq +25 -> 260
    //   238: aload 8
    //   240: new 207	com/tencent/mm/ui/base/span/BoldForegroundColorSpan
    //   243: dup
    //   244: iload 4
    //   246: invokespecial 209	com/tencent/mm/ui/base/span/BoldForegroundColorSpan:<init>	(I)V
    //   249: iconst_0
    //   250: aload 8
    //   252: invokevirtual 212	android/text/SpannableString:length	()I
    //   255: bipush 17
    //   257: invokevirtual 216	android/text/SpannableString:setSpan	(Ljava/lang/Object;III)V
    //   260: aload_1
    //   261: getfield 153	com/tencent/mm/ui/chatting/e/a:WQv	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   264: invokevirtual 179	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getContext	()Landroid/app/Activity;
    //   267: aload 8
    //   269: aload_3
    //   270: invokevirtual 220	com/tencent/mm/ui/widget/MMNeat7extView:getTextSize	()F
    //   273: invokestatic 225	com/tencent/mm/pluginsdk/ui/span/l:d	(Landroid/content/Context;Ljava/lang/CharSequence;F)Landroid/text/SpannableString;
    //   276: astore 9
    //   278: aload 9
    //   280: astore 8
    //   282: aload 8
    //   284: astore 9
    //   286: iload 6
    //   288: ifeq +250 -> 538
    //   291: aload 8
    //   293: astore 9
    //   295: aload 10
    //   297: getfield 229	com/tencent/mm/plugin/patmsg/a/f:GKx	Ljava/util/List;
    //   300: invokeinterface 234 1 0
    //   305: aload 10
    //   307: getfield 237	com/tencent/mm/plugin/patmsg/a/f:lFX	Ljava/util/List;
    //   310: invokeinterface 234 1 0
    //   315: if_icmpne +223 -> 538
    //   318: aload 8
    //   320: astore 9
    //   322: aload 10
    //   324: getfield 237	com/tencent/mm/plugin/patmsg/a/f:lFX	Ljava/util/List;
    //   327: invokeinterface 240 1 0
    //   332: ifne +206 -> 538
    //   335: iconst_0
    //   336: istore 4
    //   338: aload 8
    //   340: astore 9
    //   342: iload 4
    //   344: aload 10
    //   346: getfield 237	com/tencent/mm/plugin/patmsg/a/f:lFX	Ljava/util/List;
    //   349: invokeinterface 234 1 0
    //   354: if_icmpge +184 -> 538
    //   357: aload 10
    //   359: getfield 229	com/tencent/mm/plugin/patmsg/a/f:GKx	Ljava/util/List;
    //   362: iload 4
    //   364: invokeinterface 244 2 0
    //   369: checkcast 246	android/util/Pair
    //   372: astore 9
    //   374: ldc 52
    //   376: ldc 248
    //   378: iconst_2
    //   379: anewarray 56	java/lang/Object
    //   382: dup
    //   383: iconst_0
    //   384: aload 9
    //   386: getfield 252	android/util/Pair:first	Ljava/lang/Object;
    //   389: aastore
    //   390: dup
    //   391: iconst_1
    //   392: aload 9
    //   394: getfield 255	android/util/Pair:second	Ljava/lang/Object;
    //   397: aastore
    //   398: invokestatic 87	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   401: new 257	com/tencent/mm/ui/chatting/viewitems/ag$6
    //   404: dup
    //   405: aload_0
    //   406: aload_1
    //   407: invokespecial 260	com/tencent/mm/ui/chatting/viewitems/ag$6:<init>	(Lcom/tencent/mm/ui/chatting/viewitems/ag;Lcom/tencent/mm/ui/chatting/e/a;)V
    //   410: astore 11
    //   412: aload 11
    //   414: aload 10
    //   416: getfield 237	com/tencent/mm/plugin/patmsg/a/f:lFX	Ljava/util/List;
    //   419: iload 4
    //   421: invokeinterface 244 2 0
    //   426: invokevirtual 266	com/tencent/mm/pluginsdk/ui/span/p:setTag	(Ljava/lang/Object;)V
    //   429: aload 8
    //   431: aload 11
    //   433: aload 9
    //   435: getfield 252	android/util/Pair:first	Ljava/lang/Object;
    //   438: checkcast 78	java/lang/Integer
    //   441: invokevirtual 149	java/lang/Integer:intValue	()I
    //   444: aload 9
    //   446: getfield 255	android/util/Pair:second	Ljava/lang/Object;
    //   449: checkcast 78	java/lang/Integer
    //   452: invokevirtual 149	java/lang/Integer:intValue	()I
    //   455: bipush 17
    //   457: invokevirtual 216	android/text/SpannableString:setSpan	(Ljava/lang/Object;III)V
    //   460: iload 4
    //   462: iconst_1
    //   463: iadd
    //   464: istore 4
    //   466: goto -128 -> 338
    //   469: aload_3
    //   470: aload_1
    //   471: getfield 153	com/tencent/mm/ui/chatting/e/a:WQv	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   474: invokevirtual 179	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getContext	()Landroid/app/Activity;
    //   477: invokevirtual 184	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   480: getstatic 269	com/tencent/mm/R$e:FG_2	I
    //   483: invokevirtual 170	android/content/res/Resources:getColor	(I)I
    //   486: invokevirtual 192	com/tencent/mm/ui/widget/MMNeat7extView:setTextColor	(I)V
    //   489: aload_3
    //   490: aload_1
    //   491: getfield 153	com/tencent/mm/ui/chatting/e/a:WQv	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   494: invokevirtual 179	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getContext	()Landroid/app/Activity;
    //   497: invokevirtual 184	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   500: getstatic 272	com/tencent/mm/R$g:dnb	I
    //   503: invokevirtual 201	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   506: invokevirtual 205	com/tencent/mm/ui/widget/MMNeat7extView:setBackground	(Landroid/graphics/drawable/Drawable;)V
    //   509: goto -276 -> 233
    //   512: astore 9
    //   514: aload 8
    //   516: astore_1
    //   517: aload 9
    //   519: astore 8
    //   521: ldc 52
    //   523: aload 8
    //   525: ldc_w 274
    //   528: iconst_0
    //   529: anewarray 56	java/lang/Object
    //   532: invokestatic 278	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   535: aload_1
    //   536: astore 9
    //   538: iload 7
    //   540: ifeq +188 -> 728
    //   543: invokestatic 282	com/tencent/mm/kernel/h:aHG	()Lcom/tencent/mm/kernel/f;
    //   546: invokevirtual 285	com/tencent/mm/kernel/f:aHp	()Lcom/tencent/mm/storage/ao;
    //   549: getstatic 291	com/tencent/mm/storage/ar$a:VDu	Lcom/tencent/mm/storage/ar$a;
    //   552: ldc_w 274
    //   555: invokevirtual 294	com/tencent/mm/storage/ao:a	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/String;)Ljava/lang/String;
    //   558: pop
    //   559: aload_2
    //   560: getfield 297	com/tencent/mm/protocal/protobuf/diu:TQm	I
    //   563: iconst_1
    //   564: if_icmpne +164 -> 728
    //   567: aload_3
    //   568: invokevirtual 300	com/tencent/mm/ui/widget/MMNeat7extView:getContext	()Landroid/content/Context;
    //   571: getstatic 305	com/tencent/mm/R$k:icons_filled_pencil	I
    //   574: aload_3
    //   575: invokevirtual 300	com/tencent/mm/ui/widget/MMNeat7extView:getContext	()Landroid/content/Context;
    //   578: getstatic 308	com/tencent/mm/R$e:link_color	I
    //   581: invokestatic 314	com/tencent/mm/ci/a:w	(Landroid/content/Context;I)I
    //   584: invokestatic 320	com/tencent/mm/ui/au:o	(Landroid/content/Context;II)Landroid/graphics/drawable/Drawable;
    //   587: astore_1
    //   588: aload_1
    //   589: iconst_0
    //   590: iconst_0
    //   591: aload_1
    //   592: invokevirtual 325	android/graphics/drawable/Drawable:getIntrinsicWidth	()I
    //   595: iconst_2
    //   596: imul
    //   597: iconst_3
    //   598: idiv
    //   599: aload_1
    //   600: invokevirtual 328	android/graphics/drawable/Drawable:getIntrinsicHeight	()I
    //   603: iconst_2
    //   604: imul
    //   605: iconst_3
    //   606: idiv
    //   607: invokevirtual 332	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   610: new 334	com/tencent/mm/ui/widget/a
    //   613: dup
    //   614: aload_1
    //   615: iconst_1
    //   616: invokespecial 337	com/tencent/mm/ui/widget/a:<init>	(Landroid/graphics/drawable/Drawable;I)V
    //   619: astore_1
    //   620: new 339	android/text/SpannableStringBuilder
    //   623: dup
    //   624: aload 9
    //   626: invokespecial 340	android/text/SpannableStringBuilder:<init>	(Ljava/lang/CharSequence;)V
    //   629: astore_2
    //   630: new 98	android/text/SpannableString
    //   633: dup
    //   634: aload_3
    //   635: invokevirtual 300	com/tencent/mm/ui/widget/MMNeat7extView:getContext	()Landroid/content/Context;
    //   638: getstatic 345	com/tencent/mm/R$l:pat_change_suffix_tip_icon	I
    //   641: invokevirtual 351	android/content/Context:getString	(I)Ljava/lang/String;
    //   644: invokespecial 106	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   647: astore 8
    //   649: aload 8
    //   651: aload_1
    //   652: iconst_2
    //   653: iconst_3
    //   654: bipush 17
    //   656: invokevirtual 216	android/text/SpannableString:setSpan	(Ljava/lang/Object;III)V
    //   659: aload_2
    //   660: aload 8
    //   662: invokevirtual 355	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    //   665: pop
    //   666: aload_3
    //   667: invokevirtual 300	com/tencent/mm/ui/widget/MMNeat7extView:getContext	()Landroid/content/Context;
    //   670: getstatic 358	com/tencent/mm/R$l:pat_change_suffix_tip_wording	I
    //   673: invokevirtual 351	android/content/Context:getString	(I)Ljava/lang/String;
    //   676: iconst_2
    //   677: anewarray 56	java/lang/Object
    //   680: dup
    //   681: iconst_0
    //   682: ldc_w 360
    //   685: aastore
    //   686: dup
    //   687: iconst_1
    //   688: ldc_w 362
    //   691: aastore
    //   692: invokestatic 366	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   695: astore_1
    //   696: aload_2
    //   697: aload_3
    //   698: invokevirtual 300	com/tencent/mm/ui/widget/MMNeat7extView:getContext	()Landroid/content/Context;
    //   701: aload_1
    //   702: aload_3
    //   703: invokevirtual 220	com/tencent/mm/ui/widget/MMNeat7extView:getTextSize	()F
    //   706: f2i
    //   707: invokestatic 369	com/tencent/mm/pluginsdk/ui/span/l:b	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/text/SpannableString;
    //   710: invokevirtual 355	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    //   713: pop
    //   714: aload_3
    //   715: aload_2
    //   716: getstatic 375	android/widget/TextView$BufferType:SPANNABLE	Landroid/widget/TextView$BufferType;
    //   719: invokevirtual 378	com/tencent/mm/ui/widget/MMNeat7extView:a	(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V
    //   722: ldc 26
    //   724: invokestatic 380	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   727: return
    //   728: aload_3
    //   729: aload 9
    //   731: getstatic 375	android/widget/TextView$BufferType:SPANNABLE	Landroid/widget/TextView$BufferType;
    //   734: invokevirtual 378	com/tencent/mm/ui/widget/MMNeat7extView:a	(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V
    //   737: ldc 26
    //   739: invokestatic 380	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   742: return
    //   743: astore 9
    //   745: aload 8
    //   747: astore_1
    //   748: aload 9
    //   750: astore 8
    //   752: goto -231 -> 521
    //   755: aload 9
    //   757: ifnonnull -288 -> 469
    //   760: iload 5
    //   762: bipush 254
    //   764: if_icmpeq -295 -> 469
    //   767: goto -589 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	770	0	this	ag
    //   0	770	1	parama	com.tencent.mm.ui.chatting.e.a
    //   0	770	2	paramdiu	diu
    //   0	770	3	paramMMNeat7extView	MMNeat7extView
    //   158	307	4	i	int
    //   143	622	5	j	int
    //   21	266	6	bool1	boolean
    //   105	434	7	bool2	boolean
    //   94	657	8	localObject1	Object
    //   8	437	9	localObject2	Object
    //   512	6	9	localException1	java.lang.Exception
    //   536	194	9	locala	com.tencent.mm.ui.chatting.e.a
    //   743	13	9	localException2	java.lang.Exception
    //   80	335	10	localf	com.tencent.mm.plugin.patmsg.a.f
    //   410	22	11	local6	ag.6
    // Exception table:
    //   from	to	target	type
    //   107	160	512	java/lang/Exception
    //   165	175	512	java/lang/Exception
    //   178	233	512	java/lang/Exception
    //   238	260	512	java/lang/Exception
    //   260	278	512	java/lang/Exception
    //   469	509	512	java/lang/Exception
    //   295	318	743	java/lang/Exception
    //   322	335	743	java/lang/Exception
    //   342	460	743	java/lang/Exception
  }
  
  private void a(final com.tencent.mm.ui.chatting.e.a parama, ca paramca, dit paramdit, int paramInt)
  {
    AppMethodBeat.i(290340);
    Log.i("MicroMsg.ChattingItemAppMsgPat", "fll msg view contains record %d , show %d", new Object[] { Integer.valueOf(paramdit.Ezu.size()), Integer.valueOf(paramInt) });
    this.Xhs.CYP.removeAllViews();
    Activity localActivity = parama.WQv.getContext();
    int i = 0;
    while (i < paramInt)
    {
      MMNeat7extView localMMNeat7extView = new MMNeat7extView(localActivity);
      localMMNeat7extView.setTextSize(0, localActivity.getResources().getDimensionPixelSize(R.f.HintTextSize));
      localMMNeat7extView.setPadding(localActivity.getResources().getDimensionPixelSize(R.f.LittlePadding), localActivity.getResources().getDimensionPixelSize(R.f.LittlePadding), localActivity.getResources().getDimensionPixelSize(R.f.LittlePadding), localActivity.getResources().getDimensionPixelSize(R.f.LittlePadding));
      localMMNeat7extView.setTextGravity(1);
      localMMNeat7extView.setClickable(true);
      a(parama, (diu)paramdit.Ezu.get(i), localMMNeat7extView);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.width = -2;
      localLayoutParams.height = -2;
      if (parama.hRi())
      {
        localLayoutParams.topMargin = localActivity.getResources().getDimensionPixelSize(R.f.LittlePadding);
        localLayoutParams.bottomMargin = localActivity.getResources().getDimensionPixelSize(R.f.LittlePadding);
      }
      localLayoutParams.gravity = 1;
      this.Xhs.CYP.addView(localMMNeat7extView, localLayoutParams);
      localMMNeat7extView.setTag(new by(paramca, parama.hRi(), 0, "", '\000'));
      localMMNeat7extView.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(216728);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgPat$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          if (((PluginPatMsg)h.ag(PluginPatMsg.class)).isRevokePatMsgEnable())
          {
            localObject = (by)paramAnonymousView.getTag();
            if ((localObject != null) && (((by)localObject).fNz != null))
            {
              int i = ((ViewGroup)paramAnonymousView.getParent()).indexOfChild(paramAnonymousView);
              Log.i("MicroMsg.ChattingItemAppMsgPat", "long click msg %d, index %d", new Object[] { Long.valueOf(((by)localObject).fNz.field_msgId), Integer.valueOf(i) });
              paramAnonymousView = g.bBr(((by)localObject).fNz.field_content);
              if (i < paramAnonymousView.Ezu.size())
              {
                paramAnonymousView = (diu)paramAnonymousView.Ezu.get(i);
                if (z.bcZ().equals(paramAnonymousView.fLi))
                {
                  if (cm.bfD() - paramAnonymousView.createTime <= 120000L) {
                    ag.a(ag.this, parama, Pair.create(Long.valueOf(((by)localObject).fNz.field_msgId), Long.valueOf(paramAnonymousView.createTime)));
                  }
                  for (;;)
                  {
                    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgPat$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(216728);
                    return true;
                    Log.w("MicroMsg.ChattingItemAppMsgPat", "expire revoke time %d", new Object[] { Long.valueOf(paramAnonymousView.createTime) });
                  }
                }
              }
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgPat$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(216728);
          return false;
        }
      });
      i += 1;
    }
    AppMethodBeat.o(290340);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(290336);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new aq(paramLayoutInflater, R.i.ecw);
      ((View)localObject).setTag(new a().ik((View)localObject));
    }
    AppMethodBeat.o(290336);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, ca paramca, final String paramString)
  {
    AppMethodBeat.i(290339);
    Log.i("MicroMsg.ChattingItemAppMsgPat", "fill item %d, msgId %d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramca.field_msgId) });
    this.Xhs = ((a)parama);
    String str = paramca.field_content;
    parama = ((com.tencent.mm.plugin.patmsg.a.b)h.ae(com.tencent.mm.plugin.patmsg.a.b.class)).aUf(str);
    int i = parama.Ezu.size();
    int k = ((com.tencent.mm.plugin.patmsg.a.b)h.ae(com.tencent.mm.plugin.patmsg.a.b.class)).OX(paramca.field_msgId);
    ((r)parama1.bC(r.class)).a(paramca, i, k);
    Log.i("MicroMsg.ChattingItemAppMsgPat", "content:%s, talker:%s, recordNum:%d", new Object[] { Util.secPrint(str), parama.iRq, Integer.valueOf(i) });
    if (i > 0)
    {
      paramString = ((n)h.ae(n.class)).eSe().aOH(paramString);
      if ((i < 5) || (paramString.field_msgId == paramca.field_msgId)) {
        break label392;
      }
    }
    for (;;)
    {
      paramString = (ai)parama1.bC(ai.class);
      boolean bool;
      label272:
      int j;
      if ((paramString != null) && (paramString.VD(paramca.field_msgId)))
      {
        bool = true;
        Log.i("MicroMsg.ChattingItemAppMsgPat", "need fold %s, hasExpanded %s", new Object[] { Boolean.valueOf(k), Boolean.valueOf(bool) });
        if (bool) {
          break label362;
        }
        paramInt = 1;
        j = paramInt & k;
        if (j == 0) {
          break label367;
        }
      }
      label362:
      label367:
      for (paramInt = 3;; paramInt = i)
      {
        a(parama1, paramca, parama, paramInt);
        this.Xhs.Xhv.setTag(Long.valueOf(paramca.field_msgId));
        if (j == 0) {
          break label373;
        }
        this.Xhs.Xhv.setVisibility(0);
        this.Xhs.Xhv.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(203297);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgPat$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof Long)))
            {
              localObject = ((n)h.ae(n.class)).eSe().Oq(((Long)paramAnonymousView.getTag()).longValue());
              if (paramString != null) {
                paramString.VE(((et)localObject).field_msgId);
              }
              paramAnonymousView.setVisibility(8);
              paramAnonymousView = ((com.tencent.mm.plugin.patmsg.a.b)h.ae(com.tencent.mm.plugin.patmsg.a.b.class)).aUf(((et)localObject).field_content);
              ag.a(ag.this, parama1, (ca)localObject, paramAnonymousView, paramAnonymousView.Ezu.size());
              localObject = new je();
              ((je)localObject).gKO = ((je)localObject).z("ChatUsername", parama1.getTalkerUserName(), true);
              ((je)localObject).gqd = ((je)localObject).z("Username", parama1.WEE, true);
              ((je)localObject).gKP = paramAnonymousView.Ezu.size();
              if (!ab.PP(parama1.getTalkerUserName())) {
                break label240;
              }
            }
            label240:
            for (((je)localObject).ggl = 2;; ((je)localObject).ggl = 1)
            {
              ((je)localObject).bpa();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgPat$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(203297);
              return;
            }
          }
        });
        AppMethodBeat.o(290339);
        return;
        bool = false;
        break;
        paramInt = 0;
        break label272;
      }
      label373:
      this.Xhs.Xhv.setVisibility(8);
      AppMethodBeat.o(290339);
      return;
      label392:
      k = 0;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    return false;
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return (paramInt == 889192497) || (paramInt == 922746929);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean hTD()
  {
    return false;
  }
  
  final boolean hTF()
  {
    return false;
  }
  
  public static final class a
    extends c.a
  {
    public LinearLayout CYP;
    public TextView Xhv;
    
    public final View getMainContainerView()
    {
      return null;
    }
    
    public final a ik(View paramView)
    {
      AppMethodBeat.i(286676);
      super.create(paramView);
      this.CYP = ((LinearLayout)paramView.findViewById(R.h.dQW));
      this.Xhv = ((TextView)paramView.findViewById(R.h.dHC));
      this.maskView = paramView.findViewById(R.h.dyD);
      AppMethodBeat.o(286676);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ag
 * JD-Core Version:    0.7.0.1
 */