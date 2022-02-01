package com.tencent.mm.plugin.sns.ad.timeline.helper;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.ad.adxml.n;
import com.tencent.mm.plugin.sns.ad.timeline.a.a.c;
import com.tencent.mm.plugin.sns.ad.timeline.a.a.c.b;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;

public final class l
{
  private RoundedCornerFrameLayout QaG;
  private ImageView QaH;
  private ImageView QaI;
  private TextView QaJ;
  private n QaK;
  c QaL;
  private Context mContext;
  private View.OnClickListener mOnClickListener;
  private int xOq;
  
  public l(Context paramContext, int paramInt, com.tencent.mm.plugin.sns.ad.g.l paraml, RoundedCornerFrameLayout paramRoundedCornerFrameLayout, c.b paramb)
  {
    AppMethodBeat.i(311127);
    this.mOnClickListener = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(311154);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/sns/ad/timeline/helper/TimelineTagBtnHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        l.this.QaL.jg(paramAnonymousView);
        a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/helper/TimelineTagBtnHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(311154);
      }
    };
    this.mContext = paramContext;
    this.xOq = paramInt;
    this.QaG = paramRoundedCornerFrameLayout;
    this.QaH = ((ImageView)paramRoundedCornerFrameLayout.findViewById(b.f.sns_ad_tag_btn_img));
    this.QaI = ((ImageView)paramRoundedCornerFrameLayout.findViewById(b.f.sns_ad_tag_pic));
    this.QaJ = ((TextView)paramRoundedCornerFrameLayout.findViewById(b.f.sns_ad_tag_word));
    this.QaG.setOnClickListener(this.mOnClickListener);
    this.QaL = new c(this.mContext, this.xOq, paraml, null, paramb);
    AppMethodBeat.o(311127);
  }
  
  /* Error */
  public final void a(n paramn, com.tencent.mm.plugin.sns.storage.SnsInfo paramSnsInfo)
  {
    // Byte code:
    //   0: ldc 91
    //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: aload_1
    //   7: putfield 93	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaK	Lcom/tencent/mm/plugin/sns/ad/adxml/n;
    //   10: aload_0
    //   11: getfield 93	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaK	Lcom/tencent/mm/plugin/sns/ad/adxml/n;
    //   14: getfield 99	com/tencent/mm/plugin/sns/ad/adxml/n:clickActionInfo	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   17: ifnull +16 -> 33
    //   20: aload_0
    //   21: getfield 84	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaL	Lcom/tencent/mm/plugin/sns/ad/timeline/a/a/c;
    //   24: aload_1
    //   25: getfield 99	com/tencent/mm/plugin/sns/ad/adxml/n:clickActionInfo	Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;
    //   28: aload_2
    //   29: iconst_0
    //   30: invokevirtual 102	com/tencent/mm/plugin/sns/ad/timeline/a/a/c:a	(Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;I)V
    //   33: invokestatic 108	com/tencent/mm/ui/aw:isDarkMode	()Z
    //   36: ifeq +333 -> 369
    //   39: aload_0
    //   40: getfield 93	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaK	Lcom/tencent/mm/plugin/sns/ad/adxml/n;
    //   43: getfield 112	com/tencent/mm/plugin/sns/ad/adxml/n:PNc	Ljava/lang/String;
    //   46: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   49: ifne +297 -> 346
    //   52: aload_0
    //   53: getfield 93	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaK	Lcom/tencent/mm/plugin/sns/ad/adxml/n;
    //   56: getfield 112	com/tencent/mm/plugin/sns/ad/adxml/n:PNc	Ljava/lang/String;
    //   59: aload_0
    //   60: getfield 61	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaH	Landroid/widget/ImageView;
    //   63: invokestatic 123	com/tencent/mm/plugin/sns/ad/j/a:o	(Ljava/lang/String;Landroid/widget/ImageView;)V
    //   66: aload_0
    //   67: getfield 61	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaH	Landroid/widget/ImageView;
    //   70: iconst_0
    //   71: invokevirtual 126	android/widget/ImageView:setVisibility	(I)V
    //   74: aload_0
    //   75: getfield 93	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaK	Lcom/tencent/mm/plugin/sns/ad/adxml/n;
    //   78: getfield 129	com/tencent/mm/plugin/sns/ad/adxml/n:PNd	Ljava/lang/String;
    //   81: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   84: ifne +273 -> 357
    //   87: aload_0
    //   88: getfield 93	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaK	Lcom/tencent/mm/plugin/sns/ad/adxml/n;
    //   91: getfield 129	com/tencent/mm/plugin/sns/ad/adxml/n:PNd	Ljava/lang/String;
    //   94: aload_0
    //   95: getfield 66	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaI	Landroid/widget/ImageView;
    //   98: invokestatic 123	com/tencent/mm/plugin/sns/ad/j/a:o	(Ljava/lang/String;Landroid/widget/ImageView;)V
    //   101: aload_0
    //   102: getfield 66	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaI	Landroid/widget/ImageView;
    //   105: iconst_0
    //   106: invokevirtual 126	android/widget/ImageView:setVisibility	(I)V
    //   109: aload_0
    //   110: getfield 93	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaK	Lcom/tencent/mm/plugin/sns/ad/adxml/n;
    //   113: getfield 133	com/tencent/mm/plugin/sns/ad/adxml/n:PNg	F
    //   116: fstore_3
    //   117: aload_0
    //   118: getfield 93	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaK	Lcom/tencent/mm/plugin/sns/ad/adxml/n;
    //   121: getfield 136	com/tencent/mm/plugin/sns/ad/adxml/n:PNe	Ljava/lang/String;
    //   124: astore_1
    //   125: aload_0
    //   126: getfield 46	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaG	Lcom/tencent/mm/ui/widget/RoundedCornerFrameLayout;
    //   129: aload_0
    //   130: getfield 93	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaK	Lcom/tencent/mm/plugin/sns/ad/adxml/n;
    //   133: getfield 139	com/tencent/mm/plugin/sns/ad/adxml/n:dwJ	F
    //   136: invokevirtual 143	com/tencent/mm/ui/widget/RoundedCornerFrameLayout:setRadius	(F)V
    //   139: aload_0
    //   140: getfield 93	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaK	Lcom/tencent/mm/plugin/sns/ad/adxml/n;
    //   143: getfield 146	com/tencent/mm/plugin/sns/ad/adxml/n:title	Ljava/lang/String;
    //   146: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   149: ifne +354 -> 503
    //   152: aload_0
    //   153: getfield 73	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaJ	Landroid/widget/TextView;
    //   156: aload_0
    //   157: getfield 93	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaK	Lcom/tencent/mm/plugin/sns/ad/adxml/n;
    //   160: getfield 146	com/tencent/mm/plugin/sns/ad/adxml/n:title	Ljava/lang/String;
    //   163: invokevirtual 150	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   166: aload_0
    //   167: getfield 73	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaJ	Landroid/widget/TextView;
    //   170: fload_3
    //   171: invokevirtual 153	android/widget/TextView:setAlpha	(F)V
    //   174: aload_0
    //   175: getfield 42	com/tencent/mm/plugin/sns/ad/timeline/helper/l:mContext	Landroid/content/Context;
    //   178: getstatic 158	com/tencent/mm/plugin/sns/b$c:FG_2	I
    //   181: invokestatic 164	com/tencent/mm/cd/a:w	(Landroid/content/Context;I)I
    //   184: istore 5
    //   186: aload_1
    //   187: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   190: ifne +307 -> 497
    //   193: aload_1
    //   194: invokestatic 170	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   197: istore 4
    //   199: iload 4
    //   201: istore 5
    //   203: iconst_1
    //   204: istore 4
    //   206: aload_0
    //   207: getfield 73	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaJ	Landroid/widget/TextView;
    //   210: iload 5
    //   212: invokevirtual 173	android/widget/TextView:setTextColor	(I)V
    //   215: iload 4
    //   217: ifne +11 -> 228
    //   220: aload_0
    //   221: getfield 73	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaJ	Landroid/widget/TextView;
    //   224: fconst_1
    //   225: invokevirtual 153	android/widget/TextView:setAlpha	(F)V
    //   228: aload_0
    //   229: getfield 66	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaI	Landroid/widget/ImageView;
    //   232: invokevirtual 177	android/widget/ImageView:getVisibility	()I
    //   235: ifne +280 -> 515
    //   238: aload_0
    //   239: getfield 42	com/tencent/mm/plugin/sns/ad/timeline/helper/l:mContext	Landroid/content/Context;
    //   242: getstatic 182	com/tencent/mm/plugin/sns/b$d:sns_ad_tag_pic_wh	I
    //   245: invokestatic 185	com/tencent/mm/cd/a:br	(Landroid/content/Context;I)I
    //   248: aload_0
    //   249: getfield 42	com/tencent/mm/plugin/sns/ad/timeline/helper/l:mContext	Landroid/content/Context;
    //   252: getstatic 188	com/tencent/mm/plugin/sns/b$d:sns_ad_tag_pic_right_margin	I
    //   255: invokestatic 185	com/tencent/mm/cd/a:br	(Landroid/content/Context;I)I
    //   258: iadd
    //   259: istore 4
    //   261: aload_0
    //   262: getfield 73	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaJ	Landroid/widget/TextView;
    //   265: invokevirtual 192	android/widget/TextView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   268: checkcast 194	android/widget/LinearLayout$LayoutParams
    //   271: astore_1
    //   272: aload_1
    //   273: aload_0
    //   274: getfield 93	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaK	Lcom/tencent/mm/plugin/sns/ad/adxml/n;
    //   277: getfield 197	com/tencent/mm/plugin/sns/ad/adxml/n:layoutWidth	I
    //   280: iload 4
    //   282: isub
    //   283: putfield 200	android/widget/LinearLayout$LayoutParams:width	I
    //   286: aload_0
    //   287: getfield 73	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaJ	Landroid/widget/TextView;
    //   290: aload_1
    //   291: invokevirtual 204	android/widget/TextView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   294: aload_0
    //   295: getfield 73	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaJ	Landroid/widget/TextView;
    //   298: iconst_0
    //   299: invokevirtual 205	android/widget/TextView:setVisibility	(I)V
    //   302: aload_0
    //   303: getfield 61	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaH	Landroid/widget/ImageView;
    //   306: invokevirtual 206	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   309: astore_1
    //   310: aload_1
    //   311: aload_0
    //   312: getfield 93	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaK	Lcom/tencent/mm/plugin/sns/ad/adxml/n;
    //   315: getfield 197	com/tencent/mm/plugin/sns/ad/adxml/n:layoutWidth	I
    //   318: putfield 209	android/view/ViewGroup$LayoutParams:width	I
    //   321: aload_1
    //   322: aload_0
    //   323: getfield 93	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaK	Lcom/tencent/mm/plugin/sns/ad/adxml/n;
    //   326: getfield 212	com/tencent/mm/plugin/sns/ad/adxml/n:afd	I
    //   329: putfield 215	android/view/ViewGroup$LayoutParams:height	I
    //   332: aload_0
    //   333: getfield 61	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaH	Landroid/widget/ImageView;
    //   336: aload_1
    //   337: invokevirtual 216	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   340: ldc 91
    //   342: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   345: return
    //   346: aload_0
    //   347: getfield 61	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaH	Landroid/widget/ImageView;
    //   350: iconst_4
    //   351: invokevirtual 126	android/widget/ImageView:setVisibility	(I)V
    //   354: goto -280 -> 74
    //   357: aload_0
    //   358: getfield 66	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaI	Landroid/widget/ImageView;
    //   361: bipush 8
    //   363: invokevirtual 126	android/widget/ImageView:setVisibility	(I)V
    //   366: goto -257 -> 109
    //   369: aload_0
    //   370: getfield 93	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaK	Lcom/tencent/mm/plugin/sns/ad/adxml/n;
    //   373: getfield 219	com/tencent/mm/plugin/sns/ad/adxml/n:PNb	Ljava/lang/String;
    //   376: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   379: ifne +79 -> 458
    //   382: aload_0
    //   383: getfield 93	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaK	Lcom/tencent/mm/plugin/sns/ad/adxml/n;
    //   386: getfield 219	com/tencent/mm/plugin/sns/ad/adxml/n:PNb	Ljava/lang/String;
    //   389: aload_0
    //   390: getfield 61	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaH	Landroid/widget/ImageView;
    //   393: invokestatic 123	com/tencent/mm/plugin/sns/ad/j/a:o	(Ljava/lang/String;Landroid/widget/ImageView;)V
    //   396: aload_0
    //   397: getfield 61	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaH	Landroid/widget/ImageView;
    //   400: iconst_0
    //   401: invokevirtual 126	android/widget/ImageView:setVisibility	(I)V
    //   404: aload_0
    //   405: getfield 93	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaK	Lcom/tencent/mm/plugin/sns/ad/adxml/n;
    //   408: getfield 222	com/tencent/mm/plugin/sns/ad/adxml/n:iconUrl	Ljava/lang/String;
    //   411: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   414: ifne +55 -> 469
    //   417: aload_0
    //   418: getfield 93	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaK	Lcom/tencent/mm/plugin/sns/ad/adxml/n;
    //   421: getfield 222	com/tencent/mm/plugin/sns/ad/adxml/n:iconUrl	Ljava/lang/String;
    //   424: aload_0
    //   425: getfield 66	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaI	Landroid/widget/ImageView;
    //   428: invokestatic 123	com/tencent/mm/plugin/sns/ad/j/a:o	(Ljava/lang/String;Landroid/widget/ImageView;)V
    //   431: aload_0
    //   432: getfield 66	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaI	Landroid/widget/ImageView;
    //   435: iconst_0
    //   436: invokevirtual 126	android/widget/ImageView:setVisibility	(I)V
    //   439: aload_0
    //   440: getfield 93	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaK	Lcom/tencent/mm/plugin/sns/ad/adxml/n;
    //   443: getfield 225	com/tencent/mm/plugin/sns/ad/adxml/n:PNf	F
    //   446: fstore_3
    //   447: aload_0
    //   448: getfield 93	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaK	Lcom/tencent/mm/plugin/sns/ad/adxml/n;
    //   451: getfield 228	com/tencent/mm/plugin/sns/ad/adxml/n:nSx	Ljava/lang/String;
    //   454: astore_1
    //   455: goto -330 -> 125
    //   458: aload_0
    //   459: getfield 61	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaH	Landroid/widget/ImageView;
    //   462: iconst_4
    //   463: invokevirtual 126	android/widget/ImageView:setVisibility	(I)V
    //   466: goto -62 -> 404
    //   469: aload_0
    //   470: getfield 66	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaI	Landroid/widget/ImageView;
    //   473: bipush 8
    //   475: invokevirtual 126	android/widget/ImageView:setVisibility	(I)V
    //   478: goto -39 -> 439
    //   481: astore_1
    //   482: ldc 230
    //   484: ldc 232
    //   486: iconst_1
    //   487: anewarray 4	java/lang/Object
    //   490: dup
    //   491: iconst_0
    //   492: aload_1
    //   493: aastore
    //   494: invokestatic 238	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   497: iconst_0
    //   498: istore 4
    //   500: goto -294 -> 206
    //   503: aload_0
    //   504: getfield 73	com/tencent/mm/plugin/sns/ad/timeline/helper/l:QaJ	Landroid/widget/TextView;
    //   507: bipush 8
    //   509: invokevirtual 205	android/widget/TextView:setVisibility	(I)V
    //   512: goto -210 -> 302
    //   515: iconst_0
    //   516: istore 4
    //   518: goto -257 -> 261
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	521	0	this	l
    //   0	521	1	paramn	n
    //   0	521	2	paramSnsInfo	com.tencent.mm.plugin.sns.storage.SnsInfo
    //   116	331	3	f	float
    //   197	320	4	i	int
    //   184	27	5	j	int
    // Exception table:
    //   from	to	target	type
    //   193	199	481	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.helper.l
 * JD-Core Version:    0.7.0.1
 */