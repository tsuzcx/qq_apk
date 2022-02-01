package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.g.l;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.al;

public final class b
{
  boolean Flq;
  l PYh;
  private com.tencent.mm.plugin.sns.ui.listener.c QBf;
  private FrameLayout QBg;
  AbsoluteLayout QBh;
  protected Animation QBi;
  protected Animation QBj;
  boolean QBk;
  private com.tencent.mm.plugin.sns.i.b QZY;
  private com.tencent.mm.plugin.sns.ad.timeline.feedback.c QZZ;
  TextView Raa;
  ListView Rab;
  View Rac;
  private Context mContext;
  private int vpn;
  
  public b(Context paramContext, com.tencent.mm.plugin.sns.ui.listener.c paramc, FrameLayout paramFrameLayout, com.tencent.mm.plugin.sns.i.b paramb)
  {
    AppMethodBeat.i(97689);
    this.QBh = null;
    this.QBk = false;
    this.Flq = false;
    this.vpn = -1;
    this.mContext = paramContext;
    this.QZY = paramb;
    this.QBf = paramc;
    this.QBg = paramFrameLayout;
    this.QBi = new ScaleAnimation(1.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.QBi = AnimationUtils.loadAnimation(paramContext, com.tencent.mm.plugin.sns.b.a.dropdown_down);
    this.QBj = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.0F, 1, 1.0F, 1, 0.0F);
    this.QBj = AnimationUtils.loadAnimation(paramContext, com.tencent.mm.plugin.sns.b.a.dropdown_up);
    this.QZZ = com.tencent.mm.plugin.sns.ad.timeline.feedback.c.a(paramContext, paramc);
    AppMethodBeat.o(97689);
  }
  
  public final boolean hib()
  {
    AppMethodBeat.i(97691);
    if ((this.QZY != null) && (al.hgt().hie())) {
      this.QZY.hib();
    }
    if (this.QBh != null)
    {
      this.QBg.removeView(this.QBh);
      this.QBh = null;
      AppMethodBeat.o(97691);
      return true;
    }
    this.QBk = false;
    this.Rab = null;
    this.Rac = null;
    AppMethodBeat.o(97691);
    return false;
  }
  
  public final boolean hls()
  {
    AppMethodBeat.i(97692);
    final int k = this.Raa.getHeight();
    this.Raa.setVisibility(8);
    int i = 0;
    Object localObject = null;
    final int j = 0;
    while (i < this.Rab.getAdapter().getCount())
    {
      localObject = this.Rab.getAdapter().getView(i, (View)localObject, null);
      ((View)localObject).measure(this.Rac.getWidth(), -2);
      j += ((View)localObject).getMeasuredHeight();
      i += 1;
    }
    ((RelativeLayout.LayoutParams)this.Rab.getLayoutParams()).bottomMargin = (k - j);
    this.Rab.setVisibility(0);
    localObject = new Animation()
    {
      protected final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        AppMethodBeat.i(97688);
        paramAnonymousTransformation = (RelativeLayout.LayoutParams)b.this.Rab.getLayoutParams();
        if (paramAnonymousFloat == 1.0F) {}
        for (int i = 0;; i = (int)((k - j) * (1.0F - paramAnonymousFloat)))
        {
          paramAnonymousTransformation.bottomMargin = i;
          b.this.Rab.requestLayout();
          AppMethodBeat.o(97688);
          return;
        }
      }
      
      public final boolean willChangeBounds()
      {
        return true;
      }
    };
    ((Animation)localObject).setDuration(250L);
    this.Rab.startAnimation((Animation)localObject);
    AppMethodBeat.o(97692);
    return true;
  }
  
  /* Error */
  public final boolean jy(final View paramView)
  {
    // Byte code:
    //   0: ldc_w 321
    //   3: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 253	com/tencent/mm/plugin/sns/model/al:hgt	()Lcom/tencent/mm/plugin/sns/i/g;
    //   9: invokevirtual 258	com/tencent/mm/plugin/sns/i/g:hie	()Z
    //   12: ifeq +60 -> 72
    //   15: aload_0
    //   16: getfield 67	com/tencent/mm/plugin/sns/ui/b:QZY	Lcom/tencent/mm/plugin/sns/i/b;
    //   19: ifnull +53 -> 72
    //   22: aload_0
    //   23: getfield 67	com/tencent/mm/plugin/sns/ui/b:QZY	Lcom/tencent/mm/plugin/sns/i/b;
    //   26: aload_1
    //   27: invokevirtual 325	com/tencent/mm/plugin/sns/i/b:jv	(Landroid/view/View;)I
    //   30: istore_2
    //   31: iload_2
    //   32: ifeq +8 -> 40
    //   35: iload_2
    //   36: iconst_1
    //   37: if_icmpne +11 -> 48
    //   40: ldc_w 321
    //   43: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: iconst_1
    //   47: ireturn
    //   48: ldc_w 327
    //   51: ldc_w 329
    //   54: invokestatic 334	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: aload_0
    //   58: getfield 59	com/tencent/mm/plugin/sns/ui/b:QBk	Z
    //   61: ifeq +87 -> 148
    //   64: ldc_w 321
    //   67: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: iconst_0
    //   71: ireturn
    //   72: aload_1
    //   73: invokevirtual 113	android/view/View:getTag	()Ljava/lang/Object;
    //   76: astore 6
    //   78: aload 6
    //   80: instanceof 115
    //   83: ifeq -26 -> 57
    //   86: invokestatic 338	com/tencent/mm/plugin/sns/model/al:hgB	()Lcom/tencent/mm/plugin/sns/storage/w;
    //   89: aload 6
    //   91: checkcast 115	com/tencent/mm/plugin/sns/data/e
    //   94: getfield 341	com/tencent/mm/plugin/sns/data/e:hES	Ljava/lang/String;
    //   97: invokevirtual 347	com/tencent/mm/plugin/sns/storage/w:aZL	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   100: astore 6
    //   102: aload 6
    //   104: iconst_0
    //   105: aload_1
    //   106: aload_0
    //   107: getfield 349	com/tencent/mm/plugin/sns/ui/b:PYh	Lcom/tencent/mm/plugin/sns/ad/g/l;
    //   110: invokestatic 354	com/tencent/mm/plugin/sns/ad/timeline/feedback/a/b:a	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;ZLandroid/view/View;Lcom/tencent/mm/plugin/sns/ad/g/l;)Lcom/tencent/mm/plugin/sns/ad/j/j$a;
    //   113: invokestatic 359	com/tencent/mm/plugin/sns/ad/j/j:a	(Lcom/tencent/mm/plugin/sns/ad/j/j$a;)V
    //   116: aload_0
    //   117: getfield 101	com/tencent/mm/plugin/sns/ui/b:QZZ	Lcom/tencent/mm/plugin/sns/ad/timeline/feedback/c;
    //   120: ifnull -63 -> 57
    //   123: aload_0
    //   124: getfield 101	com/tencent/mm/plugin/sns/ui/b:QZZ	Lcom/tencent/mm/plugin/sns/ad/timeline/feedback/c;
    //   127: aload_1
    //   128: aload 6
    //   130: invokevirtual 362	com/tencent/mm/plugin/sns/ad/timeline/feedback/c:a	(Landroid/view/View;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)Z
    //   133: istore 5
    //   135: iload 5
    //   137: ifeq -80 -> 57
    //   140: ldc_w 321
    //   143: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: iconst_1
    //   147: ireturn
    //   148: aload_0
    //   149: getfield 57	com/tencent/mm/plugin/sns/ui/b:QBh	Landroid/widget/AbsoluteLayout;
    //   152: ifnull +75 -> 227
    //   155: aload_0
    //   156: getfield 57	com/tencent/mm/plugin/sns/ui/b:QBh	Landroid/widget/AbsoluteLayout;
    //   159: invokevirtual 365	android/widget/AbsoluteLayout:getTag	()Ljava/lang/Object;
    //   162: instanceof 14
    //   165: ifeq +54 -> 219
    //   168: aload_0
    //   169: getfield 57	com/tencent/mm/plugin/sns/ui/b:QBh	Landroid/widget/AbsoluteLayout;
    //   172: invokevirtual 365	android/widget/AbsoluteLayout:getTag	()Ljava/lang/Object;
    //   175: checkcast 14	com/tencent/mm/plugin/sns/ui/b$a
    //   178: getfield 368	com/tencent/mm/plugin/sns/ui/b$a:MdP	Landroid/view/View;
    //   181: astore_1
    //   182: aload_0
    //   183: iconst_1
    //   184: putfield 59	com/tencent/mm/plugin/sns/ui/b:QBk	Z
    //   187: aload_1
    //   188: aload_0
    //   189: getfield 91	com/tencent/mm/plugin/sns/ui/b:QBj	Landroid/view/animation/Animation;
    //   192: invokevirtual 131	android/view/View:startAnimation	(Landroid/view/animation/Animation;)V
    //   195: aload_0
    //   196: getfield 91	com/tencent/mm/plugin/sns/ui/b:QBj	Landroid/view/animation/Animation;
    //   199: new 10	com/tencent/mm/plugin/sns/ui/b$3
    //   202: dup
    //   203: aload_0
    //   204: aload_1
    //   205: invokespecial 371	com/tencent/mm/plugin/sns/ui/b$3:<init>	(Lcom/tencent/mm/plugin/sns/ui/b;Landroid/view/View;)V
    //   208: invokevirtual 127	android/view/animation/Animation:setAnimationListener	(Landroid/view/animation/Animation$AnimationListener;)V
    //   211: ldc_w 321
    //   214: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   217: iconst_0
    //   218: ireturn
    //   219: aload_0
    //   220: invokevirtual 372	com/tencent/mm/plugin/sns/ui/b:hib	()Z
    //   223: pop
    //   224: goto -13 -> 211
    //   227: aload_1
    //   228: invokevirtual 113	android/view/View:getTag	()Ljava/lang/Object;
    //   231: ifnull +13 -> 244
    //   234: aload_1
    //   235: invokevirtual 113	android/view/View:getTag	()Ljava/lang/Object;
    //   238: instanceof 115
    //   241: ifne +11 -> 252
    //   244: ldc_w 321
    //   247: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   250: iconst_0
    //   251: ireturn
    //   252: aload_1
    //   253: invokevirtual 113	android/view/View:getTag	()Ljava/lang/Object;
    //   256: checkcast 115	com/tencent/mm/plugin/sns/data/e
    //   259: astore 9
    //   261: aload 9
    //   263: getfield 341	com/tencent/mm/plugin/sns/data/e:hES	Ljava/lang/String;
    //   266: astore 8
    //   268: aload_0
    //   269: new 364	android/widget/AbsoluteLayout
    //   272: dup
    //   273: aload_0
    //   274: getfield 65	com/tencent/mm/plugin/sns/ui/b:mContext	Landroid/content/Context;
    //   277: invokespecial 375	android/widget/AbsoluteLayout:<init>	(Landroid/content/Context;)V
    //   280: putfield 57	com/tencent/mm/plugin/sns/ui/b:QBh	Landroid/widget/AbsoluteLayout;
    //   283: aload_0
    //   284: getfield 57	com/tencent/mm/plugin/sns/ui/b:QBh	Landroid/widget/AbsoluteLayout;
    //   287: getstatic 378	com/tencent/mm/plugin/sns/b$f:address	I
    //   290: invokevirtual 381	android/widget/AbsoluteLayout:setId	(I)V
    //   293: new 383	android/widget/FrameLayout$LayoutParams
    //   296: dup
    //   297: iconst_m1
    //   298: iconst_m1
    //   299: invokespecial 385	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   302: pop
    //   303: aload_0
    //   304: getfield 71	com/tencent/mm/plugin/sns/ui/b:QBg	Landroid/widget/FrameLayout;
    //   307: aload_0
    //   308: getfield 57	com/tencent/mm/plugin/sns/ui/b:QBh	Landroid/widget/AbsoluteLayout;
    //   311: invokevirtual 388	android/widget/FrameLayout:addView	(Landroid/view/View;)V
    //   314: aload_0
    //   315: getfield 65	com/tencent/mm/plugin/sns/ui/b:mContext	Landroid/content/Context;
    //   318: ldc_w 389
    //   321: invokestatic 395	com/tencent/mm/sdk/platformtools/BackwardSupportUtil$BitmapFactory:fromDPToPix	(Landroid/content/Context;F)I
    //   324: istore_3
    //   325: aload_0
    //   326: getfield 65	com/tencent/mm/plugin/sns/ui/b:mContext	Landroid/content/Context;
    //   329: ldc_w 396
    //   332: invokestatic 395	com/tencent/mm/sdk/platformtools/BackwardSupportUtil$BitmapFactory:fromDPToPix	(Landroid/content/Context;F)I
    //   335: istore 4
    //   337: aload_0
    //   338: getfield 65	com/tencent/mm/plugin/sns/ui/b:mContext	Landroid/content/Context;
    //   341: ldc_w 397
    //   344: invokestatic 395	com/tencent/mm/sdk/platformtools/BackwardSupportUtil$BitmapFactory:fromDPToPix	(Landroid/content/Context;F)I
    //   347: pop
    //   348: aload_0
    //   349: getfield 65	com/tencent/mm/plugin/sns/ui/b:mContext	Landroid/content/Context;
    //   352: invokestatic 403	com/tencent/mm/ui/af:mU	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   355: getstatic 408	com/tencent/mm/plugin/sns/b$g:ad_unlike_content	I
    //   358: aconst_null
    //   359: invokevirtual 414	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   362: astore 7
    //   364: aload 7
    //   366: getstatic 417	com/tencent/mm/plugin/sns/b$f:ad_unlike_tip	I
    //   369: invokevirtual 140	android/view/View:findViewById	(I)Landroid/view/View;
    //   372: checkcast 142	android/widget/TextView
    //   375: astore 10
    //   377: invokestatic 168	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   380: invokestatic 174	com/tencent/mm/sdk/platformtools/LocaleUtil:getCurrentLanguage	(Landroid/content/Context;)Ljava/lang/String;
    //   383: astore 6
    //   385: aload 9
    //   387: getfield 152	com/tencent/mm/plugin/sns/data/e:QmD	Lcom/tencent/mm/plugin/sns/ui/bu;
    //   390: getfield 158	com/tencent/mm/plugin/sns/ui/bu:RFh	Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   393: astore 11
    //   395: aload 11
    //   397: ifnull +41 -> 438
    //   400: ldc 176
    //   402: aload 6
    //   404: invokevirtual 182	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   407: ifeq +247 -> 654
    //   410: aload 11
    //   412: getfield 422	com/tencent/mm/plugin/sns/storage/ADXml:expandInsideTitle_cn	Ljava/lang/String;
    //   415: astore 6
    //   417: aload 6
    //   419: invokestatic 194	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   422: ifne +16 -> 438
    //   425: aload 10
    //   427: aload 6
    //   429: invokevirtual 198	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   432: aload 10
    //   434: iconst_1
    //   435: invokevirtual 226	android/widget/TextView:setClickable	(Z)V
    //   438: new 424	android/graphics/Rect
    //   441: dup
    //   442: invokespecial 425	android/graphics/Rect:<init>	()V
    //   445: pop
    //   446: aload_0
    //   447: getfield 65	com/tencent/mm/plugin/sns/ui/b:mContext	Landroid/content/Context;
    //   450: invokestatic 431	com/tencent/mm/pluginsdk/h:lm	(Landroid/content/Context;)I
    //   453: istore_2
    //   454: aload 9
    //   456: getfield 152	com/tencent/mm/plugin/sns/data/e:QmD	Lcom/tencent/mm/plugin/sns/ui/bu;
    //   459: invokevirtual 435	com/tencent/mm/plugin/sns/ui/bu:hqD	()[I
    //   462: astore 6
    //   464: ldc_w 327
    //   467: new 437	java/lang/StringBuilder
    //   470: dup
    //   471: ldc_w 439
    //   474: invokespecial 442	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   477: aload 6
    //   479: iconst_0
    //   480: iaload
    //   481: invokevirtual 446	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   484: ldc_w 448
    //   487: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: aload 6
    //   492: iconst_1
    //   493: iaload
    //   494: invokevirtual 446	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   497: ldc_w 453
    //   500: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: iload_2
    //   504: invokevirtual 446	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   507: invokevirtual 457	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   510: invokestatic 460	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   513: aload_0
    //   514: aload_0
    //   515: getfield 65	com/tencent/mm/plugin/sns/ui/b:mContext	Landroid/content/Context;
    //   518: invokestatic 465	com/tencent/mm/ui/aw:getStatusBarHeight	(Landroid/content/Context;)I
    //   521: putfield 63	com/tencent/mm/plugin/sns/ui/b:vpn	I
    //   524: aload_0
    //   525: getfield 61	com/tencent/mm/plugin/sns/ui/b:Flq	Z
    //   528: ifeq +166 -> 694
    //   531: aload_0
    //   532: getfield 65	com/tencent/mm/plugin/sns/ui/b:mContext	Landroid/content/Context;
    //   535: iconst_2
    //   536: invokestatic 470	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
    //   539: istore_2
    //   540: aload_0
    //   541: iconst_0
    //   542: putfield 63	com/tencent/mm/plugin/sns/ui/b:vpn	I
    //   545: new 472	android/widget/AbsoluteLayout$LayoutParams
    //   548: dup
    //   549: bipush 254
    //   551: bipush 254
    //   553: aload 6
    //   555: iconst_0
    //   556: iaload
    //   557: iload_3
    //   558: isub
    //   559: aload 6
    //   561: iconst_1
    //   562: iaload
    //   563: aload_0
    //   564: getfield 63	com/tencent/mm/plugin/sns/ui/b:vpn	I
    //   567: isub
    //   568: iload_2
    //   569: isub
    //   570: iload 4
    //   572: iadd
    //   573: invokespecial 475	android/widget/AbsoluteLayout$LayoutParams:<init>	(IIII)V
    //   576: astore 6
    //   578: new 14	com/tencent/mm/plugin/sns/ui/b$a
    //   581: dup
    //   582: aload_0
    //   583: aload 8
    //   585: aload 7
    //   587: invokespecial 478	com/tencent/mm/plugin/sns/ui/b$a:<init>	(Lcom/tencent/mm/plugin/sns/ui/b;Ljava/lang/String;Landroid/view/View;)V
    //   590: astore 8
    //   592: aload_0
    //   593: getfield 57	com/tencent/mm/plugin/sns/ui/b:QBh	Landroid/widget/AbsoluteLayout;
    //   596: aload 8
    //   598: invokevirtual 479	android/widget/AbsoluteLayout:setTag	(Ljava/lang/Object;)V
    //   601: aload_0
    //   602: getfield 57	com/tencent/mm/plugin/sns/ui/b:QBh	Landroid/widget/AbsoluteLayout;
    //   605: aload 7
    //   607: aload 6
    //   609: invokevirtual 482	android/widget/AbsoluteLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   612: aload 7
    //   614: bipush 8
    //   616: invokevirtual 118	android/view/View:setVisibility	(I)V
    //   619: aload_0
    //   620: iconst_1
    //   621: putfield 59	com/tencent/mm/plugin/sns/ui/b:QBk	Z
    //   624: new 484	com/tencent/mm/sdk/platformtools/MMHandler
    //   627: dup
    //   628: invokespecial 485	com/tencent/mm/sdk/platformtools/MMHandler:<init>	()V
    //   631: new 6	com/tencent/mm/plugin/sns/ui/b$1
    //   634: dup
    //   635: aload_0
    //   636: aload_1
    //   637: aload 7
    //   639: invokespecial 487	com/tencent/mm/plugin/sns/ui/b$1:<init>	(Lcom/tencent/mm/plugin/sns/ui/b;Landroid/view/View;Landroid/view/View;)V
    //   642: invokevirtual 491	com/tencent/mm/sdk/platformtools/MMHandler:post	(Ljava/lang/Runnable;)Z
    //   645: pop
    //   646: ldc_w 321
    //   649: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   652: iconst_1
    //   653: ireturn
    //   654: ldc 230
    //   656: aload 6
    //   658: invokevirtual 182	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   661: ifne +13 -> 674
    //   664: ldc 232
    //   666: aload 6
    //   668: invokevirtual 182	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   671: ifeq +13 -> 684
    //   674: aload 11
    //   676: getfield 494	com/tencent/mm/plugin/sns/storage/ADXml:expandInsideTitle_tw	Ljava/lang/String;
    //   679: astore 6
    //   681: goto -264 -> 417
    //   684: aload 11
    //   686: getfield 497	com/tencent/mm/plugin/sns/storage/ADXml:expandInsideTitle_en	Ljava/lang/String;
    //   689: astore 6
    //   691: goto -274 -> 417
    //   694: aload_0
    //   695: getfield 65	com/tencent/mm/plugin/sns/ui/b:mContext	Landroid/content/Context;
    //   698: iconst_2
    //   699: invokestatic 470	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
    //   702: iload_2
    //   703: iadd
    //   704: istore_2
    //   705: goto -160 -> 545
    //   708: astore 6
    //   710: goto -653 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	713	0	this	b
    //   0	713	1	paramView	View
    //   30	675	2	i	int
    //   324	235	3	j	int
    //   335	238	4	k	int
    //   133	3	5	bool	boolean
    //   76	614	6	localObject1	Object
    //   708	1	6	localObject2	Object
    //   362	276	7	localView	View
    //   266	331	8	localObject3	Object
    //   259	196	9	locale	com.tencent.mm.plugin.sns.data.e
    //   375	58	10	localTextView	TextView
    //   393	292	11	localADXml	com.tencent.mm.plugin.sns.storage.ADXml
    // Exception table:
    //   from	to	target	type
    //   72	135	708	finally
  }
  
  final class a
  {
    View MdP = null;
    String QBA;
    
    public a(String paramString, View paramView)
    {
      this.QBA = paramString;
      this.MdP = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b
 * JD-Core Version:    0.7.0.1
 */