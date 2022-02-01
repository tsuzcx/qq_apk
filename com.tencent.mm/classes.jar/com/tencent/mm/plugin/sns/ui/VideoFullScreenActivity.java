package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;

public class VideoFullScreenActivity
  extends AppCompatActivity
{
  private int hyp;
  private boolean isWaiting;
  private boolean kQm;
  private int kvn;
  private int kvo;
  private RelativeLayout qiM;
  private String wWv;
  private SightVideoFullScreenView xMs;
  private LongVideoFullScreenView xMt;
  private boolean xbZ;
  private int xdt;
  private String xor;
  private int xos;
  private int xot;
  private String xou;
  private int xov;
  
  public void finish()
  {
    AppMethodBeat.i(187776);
    Intent localIntent = null;
    for (;;)
    {
      try
      {
        if (this.hyp != 0) {
          continue;
        }
        localIntent = this.xMs.dAf();
        setResult(SnsAdNativeLandingPagesUI.xul, localIntent);
      }
      catch (Throwable localThrowable)
      {
        ad.e("NonFullOrFullVideoType", localThrowable.toString());
        continue;
      }
      super.finish();
      AppMethodBeat.o(187776);
      return;
      if (this.hyp == 1) {
        localIntent = this.xMt.dzo();
      }
    }
  }
  
  /* Error */
  public void onCreate(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc 87
    //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: aload_1
    //   7: invokespecial 89	android/support/v7/app/AppCompatActivity:onCreate	(Landroid/os/Bundle;)V
    //   10: aload_0
    //   11: invokestatic 95	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/al:aC	(Landroid/app/Activity;)V
    //   14: aload_0
    //   15: ldc 96
    //   17: invokevirtual 99	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:setContentView	(I)V
    //   20: aload_0
    //   21: aload_0
    //   22: invokevirtual 102	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   25: ldc 104
    //   27: iconst_0
    //   28: invokevirtual 110	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   31: putfield 43	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:hyp	I
    //   34: aload_0
    //   35: aload_0
    //   36: invokevirtual 102	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   39: ldc 112
    //   41: invokevirtual 116	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   44: putfield 118	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:xor	Ljava/lang/String;
    //   47: aload_0
    //   48: aload_0
    //   49: invokevirtual 102	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   52: ldc 120
    //   54: iconst_0
    //   55: invokevirtual 110	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   58: putfield 122	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:xos	I
    //   61: aload_0
    //   62: aload_0
    //   63: invokevirtual 102	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   66: ldc 124
    //   68: iconst_0
    //   69: invokevirtual 110	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   72: putfield 126	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:xot	I
    //   75: aload_0
    //   76: aload_0
    //   77: invokevirtual 102	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   80: ldc 128
    //   82: iconst_0
    //   83: invokevirtual 132	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   86: putfield 134	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:xbZ	Z
    //   89: aload_0
    //   90: aload_0
    //   91: invokevirtual 102	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   94: ldc 136
    //   96: iconst_0
    //   97: invokevirtual 132	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   100: putfield 138	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:kQm	Z
    //   103: aload_0
    //   104: aload_0
    //   105: invokevirtual 102	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   108: ldc 140
    //   110: invokevirtual 116	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   113: putfield 142	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:wWv	Ljava/lang/String;
    //   116: aload_0
    //   117: aload_0
    //   118: invokevirtual 102	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   121: ldc 144
    //   123: invokevirtual 116	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   126: putfield 146	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:xou	Ljava/lang/String;
    //   129: aload_0
    //   130: aload_0
    //   131: invokevirtual 102	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   134: ldc 148
    //   136: iconst_0
    //   137: invokevirtual 132	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   140: putfield 150	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:isWaiting	Z
    //   143: aload_0
    //   144: aload_0
    //   145: invokevirtual 102	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   148: ldc 152
    //   150: iconst_0
    //   151: invokevirtual 110	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   154: putfield 154	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:xdt	I
    //   157: aload_0
    //   158: aload_0
    //   159: invokevirtual 102	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getIntent	()Landroid/content/Intent;
    //   162: ldc 156
    //   164: iconst_0
    //   165: invokevirtual 110	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   168: putfield 158	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:xov	I
    //   171: ldc 74
    //   173: new 160	java/lang/StringBuilder
    //   176: dup
    //   177: ldc 162
    //   179: invokespecial 165	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   182: aload_0
    //   183: getfield 43	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:hyp	I
    //   186: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   189: ldc 171
    //   191: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload_0
    //   195: getfield 118	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:xor	Ljava/lang/String;
    //   198: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: ldc 176
    //   203: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload_0
    //   207: getfield 122	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:xos	I
    //   210: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   213: ldc 178
    //   215: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload_0
    //   219: getfield 126	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:xot	I
    //   222: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   225: ldc 180
    //   227: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: aload_0
    //   231: getfield 134	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:xbZ	Z
    //   234: invokevirtual 183	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   237: ldc 185
    //   239: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload_0
    //   243: getfield 138	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:kQm	Z
    //   246: invokevirtual 183	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   249: ldc 187
    //   251: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: aload_0
    //   255: getfield 146	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:xou	Ljava/lang/String;
    //   258: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: ldc 189
    //   263: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload_0
    //   267: getfield 150	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:isWaiting	Z
    //   270: invokevirtual 183	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   273: ldc 191
    //   275: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload_0
    //   279: getfield 154	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:xdt	I
    //   282: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   285: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokestatic 194	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   291: aload_0
    //   292: invokestatic 198	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/al:fU	(Landroid/content/Context;)[I
    //   295: astore_1
    //   296: aload_0
    //   297: aload_1
    //   298: iconst_0
    //   299: iaload
    //   300: putfield 200	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:kvn	I
    //   303: aload_0
    //   304: aload_1
    //   305: iconst_1
    //   306: iaload
    //   307: putfield 202	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:kvo	I
    //   310: aload_0
    //   311: invokestatic 208	com/tencent/mm/ui/ai:aF	(Landroid/content/Context;)Z
    //   314: ifeq +632 -> 946
    //   317: aload_0
    //   318: invokevirtual 212	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getResources	()Landroid/content/res/Resources;
    //   321: invokevirtual 218	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   324: getfield 223	android/content/res/Configuration:orientation	I
    //   327: iconst_1
    //   328: if_icmpne +618 -> 946
    //   331: aload_0
    //   332: aload_0
    //   333: getfield 202	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:kvo	I
    //   336: aload_0
    //   337: invokestatic 227	com/tencent/mm/ui/ai:aE	(Landroid/content/Context;)I
    //   340: isub
    //   341: putfield 202	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:kvo	I
    //   344: ldc 74
    //   346: new 160	java/lang/StringBuilder
    //   349: dup
    //   350: ldc 229
    //   352: invokespecial 165	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   355: aload_0
    //   356: getfield 202	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:kvo	I
    //   359: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   362: ldc 231
    //   364: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload_0
    //   368: getfield 200	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:kvn	I
    //   371: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   374: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 194	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   380: aload_0
    //   381: getfield 43	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:hyp	I
    //   384: ifne +767 -> 1151
    //   387: aload_0
    //   388: aload_0
    //   389: ldc 232
    //   391: invokevirtual 236	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:findViewById	(I)Landroid/view/View;
    //   394: checkcast 238	android/widget/RelativeLayout
    //   397: putfield 240	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:qiM	Landroid/widget/RelativeLayout;
    //   400: aload_0
    //   401: new 47	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView
    //   404: dup
    //   405: aload_0
    //   406: invokespecial 243	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:<init>	(Landroid/content/Context;)V
    //   409: putfield 45	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:xMs	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;
    //   412: aload_0
    //   413: getfield 240	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:qiM	Landroid/widget/RelativeLayout;
    //   416: aload_0
    //   417: getfield 45	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:xMs	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;
    //   420: invokevirtual 247	android/widget/RelativeLayout:addView	(Landroid/view/View;)V
    //   423: aload_0
    //   424: getfield 45	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:xMs	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;
    //   427: astore_1
    //   428: aload_0
    //   429: getfield 200	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:kvn	I
    //   432: istore_2
    //   433: aload_0
    //   434: getfield 202	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:kvo	I
    //   437: istore_3
    //   438: iload_3
    //   439: iload_2
    //   440: if_icmplt +556 -> 996
    //   443: aload_1
    //   444: iload_2
    //   445: putfield 248	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:kvn	I
    //   448: aload_1
    //   449: iload_3
    //   450: putfield 249	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:kvo	I
    //   453: aload_1
    //   454: aload_1
    //   455: getfield 253	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:mContext	Landroid/content/Context;
    //   458: bipush 32
    //   460: invokestatic 259	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
    //   463: putfield 262	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:length	I
    //   466: aload_0
    //   467: getfield 45	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:xMs	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;
    //   470: astore_1
    //   471: aload_0
    //   472: getfield 43	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:hyp	I
    //   475: istore_2
    //   476: aload_0
    //   477: getfield 118	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:xor	Ljava/lang/String;
    //   480: astore 10
    //   482: aload_0
    //   483: getfield 122	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:xos	I
    //   486: istore_3
    //   487: aload_0
    //   488: getfield 126	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:xot	I
    //   491: istore 4
    //   493: aload_0
    //   494: getfield 134	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:xbZ	Z
    //   497: istore 7
    //   499: aload_0
    //   500: getfield 138	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:kQm	Z
    //   503: istore 8
    //   505: aload_0
    //   506: getfield 142	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:wWv	Ljava/lang/String;
    //   509: astore 11
    //   511: aload_0
    //   512: getfield 146	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:xou	Ljava/lang/String;
    //   515: astore 12
    //   517: aload_1
    //   518: iconst_1
    //   519: putfield 265	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:csX	Z
    //   522: aload_1
    //   523: iconst_1
    //   524: putfield 268	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:isFirst	Z
    //   527: aload_1
    //   528: iload_2
    //   529: putfield 269	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:hyp	I
    //   532: aload_1
    //   533: aload 10
    //   535: putfield 270	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:xor	Ljava/lang/String;
    //   538: aload_1
    //   539: iload_3
    //   540: putfield 271	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:xos	I
    //   543: aload_1
    //   544: iload 4
    //   546: putfield 272	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:xot	I
    //   549: aload_1
    //   550: iload 7
    //   552: putfield 273	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:xbZ	Z
    //   555: aload_1
    //   556: iload 8
    //   558: putfield 274	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:kQm	Z
    //   561: aload_1
    //   562: aload 11
    //   564: putfield 275	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:wWv	Ljava/lang/String;
    //   567: aload_1
    //   568: aload 12
    //   570: putfield 276	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:xou	Ljava/lang/String;
    //   573: aload_0
    //   574: getfield 45	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:xMs	Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;
    //   577: astore_1
    //   578: aload_1
    //   579: aload_1
    //   580: getfield 253	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:mContext	Landroid/content/Context;
    //   583: invokestatic 282	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   586: ldc_w 283
    //   589: aload_1
    //   590: iconst_1
    //   591: invokevirtual 287	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   594: putfield 291	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:contentView	Landroid/view/View;
    //   597: aload_1
    //   598: aload_1
    //   599: getfield 291	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:contentView	Landroid/view/View;
    //   602: ldc_w 292
    //   605: invokevirtual 295	android/view/View:findViewById	(I)Landroid/view/View;
    //   608: checkcast 297	android/widget/FrameLayout
    //   611: putfield 301	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:xon	Landroid/widget/FrameLayout;
    //   614: aload_1
    //   615: aload_1
    //   616: getfield 291	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:contentView	Landroid/view/View;
    //   619: ldc_w 302
    //   622: invokevirtual 295	android/view/View:findViewById	(I)Landroid/view/View;
    //   625: putfield 305	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:xoo	Landroid/view/View;
    //   628: aload_1
    //   629: aload_1
    //   630: getfield 291	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:contentView	Landroid/view/View;
    //   633: ldc_w 306
    //   636: invokevirtual 295	android/view/View:findViewById	(I)Landroid/view/View;
    //   639: putfield 309	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:xop	Landroid/view/View;
    //   642: aload_1
    //   643: aload_1
    //   644: getfield 291	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:contentView	Landroid/view/View;
    //   647: ldc_w 310
    //   650: invokevirtual 295	android/view/View:findViewById	(I)Landroid/view/View;
    //   653: checkcast 312	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar
    //   656: putfield 316	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:xbQ	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   659: aload_1
    //   660: new 318	com/tencent/mm/plugin/sns/ui/OfflineVideoView
    //   663: dup
    //   664: aload_1
    //   665: getfield 253	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:mContext	Landroid/content/Context;
    //   668: invokespecial 319	com/tencent/mm/plugin/sns/ui/OfflineVideoView:<init>	(Landroid/content/Context;)V
    //   671: putfield 323	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:xsi	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   674: aload_1
    //   675: getfield 323	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:xsi	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   678: iconst_1
    //   679: invokevirtual 327	com/tencent/mm/plugin/sns/ui/OfflineVideoView:setClickable	(Z)V
    //   682: aload_1
    //   683: getfield 323	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:xsi	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   686: aload_1
    //   687: invokevirtual 331	com/tencent/mm/plugin/sns/ui/OfflineVideoView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   690: aload_1
    //   691: getfield 301	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:xon	Landroid/widget/FrameLayout;
    //   694: aload_1
    //   695: getfield 323	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:xsi	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   698: invokevirtual 332	android/widget/FrameLayout:addView	(Landroid/view/View;)V
    //   701: aload_1
    //   702: getfield 316	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:xbQ	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   705: iconst_0
    //   706: invokevirtual 335	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setVisibility	(I)V
    //   709: aload_1
    //   710: getfield 316	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:xbQ	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   713: aload_1
    //   714: getfield 339	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:xcn	Landroid/view/View$OnClickListener;
    //   717: invokevirtual 343	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setOnPlayButtonClickListener	(Landroid/view/View$OnClickListener;)V
    //   720: aload_1
    //   721: getfield 316	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:xbQ	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   724: aload_1
    //   725: getfield 347	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:qmw	Lcom/tencent/mm/plugin/sight/decode/ui/b;
    //   728: invokevirtual 351	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setIplaySeekCallback	(Lcom/tencent/mm/plugin/sight/decode/ui/b;)V
    //   731: aload_1
    //   732: aload_1
    //   733: ldc_w 352
    //   736: invokevirtual 353	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:findViewById	(I)Landroid/view/View;
    //   739: checkcast 355	android/widget/ImageView
    //   742: putfield 359	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:xcQ	Landroid/widget/ImageView;
    //   745: aload_1
    //   746: getfield 359	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:xcQ	Landroid/widget/ImageView;
    //   749: iconst_0
    //   750: invokevirtual 360	android/widget/ImageView:setVisibility	(I)V
    //   753: aload_1
    //   754: getfield 359	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:xcQ	Landroid/widget/ImageView;
    //   757: aload_1
    //   758: invokevirtual 363	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   761: aload_1
    //   762: aload_1
    //   763: ldc_w 364
    //   766: invokevirtual 353	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:findViewById	(I)Landroid/view/View;
    //   769: checkcast 355	android/widget/ImageView
    //   772: putfield 367	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:xbR	Landroid/widget/ImageView;
    //   775: aload_1
    //   776: getfield 367	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:xbR	Landroid/widget/ImageView;
    //   779: iconst_0
    //   780: invokevirtual 360	android/widget/ImageView:setVisibility	(I)V
    //   783: aload_1
    //   784: getfield 367	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:xbR	Landroid/widget/ImageView;
    //   787: aload_1
    //   788: invokevirtual 363	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   791: aload_1
    //   792: aload_1
    //   793: getfield 291	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:contentView	Landroid/view/View;
    //   796: ldc_w 368
    //   799: invokevirtual 295	android/view/View:findViewById	(I)Landroid/view/View;
    //   802: putfield 371	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:xcR	Landroid/view/View;
    //   805: aload_1
    //   806: getfield 371	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:xcR	Landroid/view/View;
    //   809: bipush 8
    //   811: invokevirtual 372	android/view/View:setVisibility	(I)V
    //   814: aload_1
    //   815: getfield 253	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:mContext	Landroid/content/Context;
    //   818: invokevirtual 375	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   821: invokevirtual 218	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   824: getfield 223	android/content/res/Configuration:orientation	I
    //   827: iconst_2
    //   828: if_icmpne +225 -> 1053
    //   831: ldc_w 377
    //   834: ldc_w 379
    //   837: invokestatic 194	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   840: aload_1
    //   841: invokevirtual 382	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:dzk	()V
    //   844: aload_1
    //   845: getfield 316	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:xbQ	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   848: invokevirtual 386	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:getVideoTotalTime	()I
    //   851: aload_1
    //   852: getfield 272	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:xot	I
    //   855: sipush 1000
    //   858: idiv
    //   859: if_icmpeq +18 -> 877
    //   862: aload_1
    //   863: getfield 316	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:xbQ	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   866: aload_1
    //   867: getfield 272	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:xot	I
    //   870: sipush 1000
    //   873: idiv
    //   874: invokevirtual 389	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setVideoTotalTime	(I)V
    //   877: aload_1
    //   878: getfield 316	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:xbQ	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   881: aload_1
    //   882: getfield 271	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:xos	I
    //   885: sipush 1000
    //   888: idiv
    //   889: invokevirtual 392	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:seek	(I)V
    //   892: aload_1
    //   893: aload_1
    //   894: getfield 274	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:kQm	Z
    //   897: invokevirtual 395	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:qb	(Z)V
    //   900: aload_1
    //   901: getfield 323	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:xsi	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   904: new 397	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView$2
    //   907: dup
    //   908: aload_1
    //   909: invokespecial 400	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView$2:<init>	(Lcom/tencent/mm/plugin/sns/ui/SightVideoFullScreenView;)V
    //   912: invokevirtual 404	com/tencent/mm/plugin/sns/ui/OfflineVideoView:setVideoCallback	(Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView$a;)V
    //   915: aload_1
    //   916: getfield 323	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:xsi	Lcom/tencent/mm/plugin/sns/ui/OfflineVideoView;
    //   919: invokevirtual 407	com/tencent/mm/plugin/sns/ui/OfflineVideoView:ckc	()V
    //   922: aload_1
    //   923: iconst_1
    //   924: invokevirtual 410	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:setFocus	(Z)V
    //   927: ldc 87
    //   929: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   932: return
    //   933: astore_1
    //   934: ldc 74
    //   936: aload_1
    //   937: invokevirtual 78	java/lang/Throwable:toString	()Ljava/lang/String;
    //   940: invokestatic 84	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   943: goto -652 -> 291
    //   946: aload_0
    //   947: invokestatic 208	com/tencent/mm/ui/ai:aF	(Landroid/content/Context;)Z
    //   950: ifeq -606 -> 344
    //   953: aload_0
    //   954: invokevirtual 212	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:getResources	()Landroid/content/res/Resources;
    //   957: invokevirtual 218	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   960: getfield 223	android/content/res/Configuration:orientation	I
    //   963: iconst_2
    //   964: if_icmpne -620 -> 344
    //   967: aload_0
    //   968: aload_0
    //   969: getfield 200	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:kvn	I
    //   972: aload_0
    //   973: invokestatic 227	com/tencent/mm/ui/ai:aE	(Landroid/content/Context;)I
    //   976: isub
    //   977: putfield 200	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:kvn	I
    //   980: goto -636 -> 344
    //   983: astore_1
    //   984: ldc 74
    //   986: aload_1
    //   987: invokevirtual 78	java/lang/Throwable:toString	()Ljava/lang/String;
    //   990: invokestatic 84	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   993: goto -613 -> 380
    //   996: aload_1
    //   997: iload_2
    //   998: putfield 249	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:kvo	I
    //   1001: aload_1
    //   1002: iload_3
    //   1003: putfield 248	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:kvn	I
    //   1006: goto -553 -> 453
    //   1009: astore_1
    //   1010: ldc_w 377
    //   1013: aload_1
    //   1014: invokevirtual 78	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1017: invokestatic 84	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1020: goto -554 -> 466
    //   1023: astore_1
    //   1024: ldc 74
    //   1026: aload_1
    //   1027: invokevirtual 78	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1030: invokestatic 84	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1033: ldc 87
    //   1035: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1038: return
    //   1039: astore_1
    //   1040: ldc_w 377
    //   1043: aload_1
    //   1044: invokevirtual 78	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1047: invokestatic 84	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1050: goto -477 -> 573
    //   1053: aload_1
    //   1054: getfield 253	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:mContext	Landroid/content/Context;
    //   1057: invokevirtual 375	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1060: invokevirtual 218	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   1063: getfield 223	android/content/res/Configuration:orientation	I
    //   1066: iconst_1
    //   1067: if_icmpne -223 -> 844
    //   1070: ldc_w 377
    //   1073: ldc_w 412
    //   1076: invokestatic 194	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1079: aload_1
    //   1080: invokevirtual 415	com/tencent/mm/plugin/sns/ui/SightVideoFullScreenView:dzl	()V
    //   1083: goto -239 -> 844
    //   1086: astore 10
    //   1088: ldc_w 377
    //   1091: aload 10
    //   1093: invokevirtual 78	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1096: invokestatic 84	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1099: goto -255 -> 844
    //   1102: astore_1
    //   1103: ldc_w 377
    //   1106: aload_1
    //   1107: invokevirtual 78	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1110: invokestatic 84	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1113: ldc 87
    //   1115: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1118: return
    //   1119: astore 10
    //   1121: ldc_w 377
    //   1124: aload 10
    //   1126: invokevirtual 78	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1129: invokestatic 84	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1132: goto -232 -> 900
    //   1135: astore 10
    //   1137: ldc_w 377
    //   1140: aload 10
    //   1142: invokevirtual 78	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1145: invokestatic 84	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1148: goto -233 -> 915
    //   1151: aload_0
    //   1152: getfield 43	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:hyp	I
    //   1155: iconst_1
    //   1156: if_icmpne +617 -> 1773
    //   1159: aload_0
    //   1160: aload_0
    //   1161: ldc 232
    //   1163: invokevirtual 236	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:findViewById	(I)Landroid/view/View;
    //   1166: checkcast 238	android/widget/RelativeLayout
    //   1169: putfield 240	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:qiM	Landroid/widget/RelativeLayout;
    //   1172: aload_0
    //   1173: new 69	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView
    //   1176: dup
    //   1177: aload_0
    //   1178: invokespecial 416	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:<init>	(Landroid/content/Context;)V
    //   1181: putfield 67	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:xMt	Lcom/tencent/mm/plugin/sns/ui/LongVideoFullScreenView;
    //   1184: aload_0
    //   1185: getfield 240	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:qiM	Landroid/widget/RelativeLayout;
    //   1188: aload_0
    //   1189: getfield 67	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:xMt	Lcom/tencent/mm/plugin/sns/ui/LongVideoFullScreenView;
    //   1192: invokevirtual 247	android/widget/RelativeLayout:addView	(Landroid/view/View;)V
    //   1195: aload_0
    //   1196: getfield 67	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:xMt	Lcom/tencent/mm/plugin/sns/ui/LongVideoFullScreenView;
    //   1199: astore_1
    //   1200: aload_0
    //   1201: getfield 200	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:kvn	I
    //   1204: istore_2
    //   1205: aload_0
    //   1206: getfield 202	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:kvo	I
    //   1209: istore_3
    //   1210: iload_3
    //   1211: iload_2
    //   1212: if_icmplt +567 -> 1779
    //   1215: aload_1
    //   1216: iload_2
    //   1217: putfield 417	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:kvn	I
    //   1220: aload_1
    //   1221: iload_3
    //   1222: putfield 418	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:kvo	I
    //   1225: aload_1
    //   1226: aload_1
    //   1227: getfield 419	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:mContext	Landroid/content/Context;
    //   1230: bipush 32
    //   1232: invokestatic 259	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
    //   1235: putfield 420	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:length	I
    //   1238: aload_0
    //   1239: getfield 67	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:xMt	Lcom/tencent/mm/plugin/sns/ui/LongVideoFullScreenView;
    //   1242: astore_1
    //   1243: aload_0
    //   1244: getfield 43	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:hyp	I
    //   1247: istore_2
    //   1248: aload_0
    //   1249: getfield 118	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:xor	Ljava/lang/String;
    //   1252: astore 10
    //   1254: aload_0
    //   1255: getfield 122	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:xos	I
    //   1258: istore_3
    //   1259: aload_0
    //   1260: getfield 126	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:xot	I
    //   1263: istore 4
    //   1265: aload_0
    //   1266: getfield 134	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:xbZ	Z
    //   1269: istore 7
    //   1271: aload_0
    //   1272: getfield 138	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:kQm	Z
    //   1275: istore 8
    //   1277: aload_0
    //   1278: getfield 142	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:wWv	Ljava/lang/String;
    //   1281: astore 11
    //   1283: aload_0
    //   1284: getfield 146	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:xou	Ljava/lang/String;
    //   1287: astore 12
    //   1289: aload_0
    //   1290: getfield 150	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:isWaiting	Z
    //   1293: istore 9
    //   1295: aload_0
    //   1296: getfield 154	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:xdt	I
    //   1299: istore 5
    //   1301: aload_0
    //   1302: getfield 158	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:xov	I
    //   1305: istore 6
    //   1307: aload_1
    //   1308: iconst_1
    //   1309: putfield 423	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:ggj	Z
    //   1312: aload_1
    //   1313: iconst_1
    //   1314: putfield 424	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:isFirst	Z
    //   1317: aload_1
    //   1318: iload_2
    //   1319: putfield 425	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:hyp	I
    //   1322: aload_1
    //   1323: aload 10
    //   1325: putfield 426	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:xor	Ljava/lang/String;
    //   1328: aload_1
    //   1329: iload_3
    //   1330: putfield 427	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:xos	I
    //   1333: aload_1
    //   1334: iload 4
    //   1336: putfield 428	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:xot	I
    //   1339: aload_1
    //   1340: iload 7
    //   1342: putfield 429	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:xbZ	Z
    //   1345: aload_1
    //   1346: iload 8
    //   1348: putfield 430	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:kQm	Z
    //   1351: aload_1
    //   1352: aload 11
    //   1354: putfield 431	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:wWv	Ljava/lang/String;
    //   1357: aload_1
    //   1358: aload 12
    //   1360: putfield 432	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:xou	Ljava/lang/String;
    //   1363: aload_1
    //   1364: iload 9
    //   1366: putfield 433	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:isWaiting	Z
    //   1369: aload_1
    //   1370: iload 5
    //   1372: putfield 434	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:xdt	I
    //   1375: aload_1
    //   1376: iload 6
    //   1378: putfield 435	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:xov	I
    //   1381: aload_0
    //   1382: getfield 67	com/tencent/mm/plugin/sns/ui/VideoFullScreenActivity:xMt	Lcom/tencent/mm/plugin/sns/ui/LongVideoFullScreenView;
    //   1385: astore_1
    //   1386: aload_1
    //   1387: aload_1
    //   1388: getfield 419	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:mContext	Landroid/content/Context;
    //   1391: invokestatic 282	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   1394: ldc_w 436
    //   1397: aload_1
    //   1398: iconst_1
    //   1399: invokevirtual 287	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   1402: putfield 437	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:contentView	Landroid/view/View;
    //   1405: aload_1
    //   1406: aload_1
    //   1407: getfield 437	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:contentView	Landroid/view/View;
    //   1410: ldc_w 292
    //   1413: invokevirtual 295	android/view/View:findViewById	(I)Landroid/view/View;
    //   1416: checkcast 297	android/widget/FrameLayout
    //   1419: putfield 438	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:xon	Landroid/widget/FrameLayout;
    //   1422: aload_1
    //   1423: new 440	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper
    //   1426: dup
    //   1427: aload_1
    //   1428: getfield 419	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:mContext	Landroid/content/Context;
    //   1431: invokespecial 441	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:<init>	(Landroid/content/Context;)V
    //   1434: putfield 445	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:xoq	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1437: aload_1
    //   1438: getfield 438	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:xon	Landroid/widget/FrameLayout;
    //   1441: aload_1
    //   1442: getfield 445	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:xoq	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1445: invokevirtual 332	android/widget/FrameLayout:addView	(Landroid/view/View;)V
    //   1448: aload_1
    //   1449: getfield 445	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:xoq	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1452: aload_1
    //   1453: invokevirtual 449	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setIMMVideoViewCallback	(Lcom/tencent/mm/pluginsdk/ui/h$b;)V
    //   1456: aload_1
    //   1457: getfield 445	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:xoq	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1460: iconst_1
    //   1461: invokevirtual 452	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setFullScreen	(Z)V
    //   1464: aload_1
    //   1465: getfield 445	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:xoq	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1468: iconst_0
    //   1469: aload_1
    //   1470: getfield 432	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:xou	Ljava/lang/String;
    //   1473: iconst_0
    //   1474: invokevirtual 456	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:c	(ZLjava/lang/String;I)V
    //   1477: aload_1
    //   1478: getfield 445	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:xoq	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1481: iconst_1
    //   1482: invokevirtual 457	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setClickable	(Z)V
    //   1485: aload_1
    //   1486: getfield 445	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:xoq	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1489: aload_1
    //   1490: invokevirtual 458	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   1493: aload_1
    //   1494: getfield 445	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:xoq	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1497: iconst_1
    //   1498: invokevirtual 461	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setLoop	(Z)V
    //   1501: aload_1
    //   1502: getfield 445	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:xoq	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1505: aload_1
    //   1506: invokevirtual 465	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setLoopCompletionCallback	(Lcom/tencent/mm/pluginsdk/ui/h$d;)V
    //   1509: aload_1
    //   1510: aload_1
    //   1511: getfield 437	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:contentView	Landroid/view/View;
    //   1514: ldc_w 302
    //   1517: invokevirtual 295	android/view/View:findViewById	(I)Landroid/view/View;
    //   1520: putfield 466	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:xoo	Landroid/view/View;
    //   1523: aload_1
    //   1524: aload_1
    //   1525: getfield 437	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:contentView	Landroid/view/View;
    //   1528: ldc_w 306
    //   1531: invokevirtual 295	android/view/View:findViewById	(I)Landroid/view/View;
    //   1534: putfield 467	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:xop	Landroid/view/View;
    //   1537: aload_1
    //   1538: aload_1
    //   1539: getfield 437	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:contentView	Landroid/view/View;
    //   1542: ldc_w 310
    //   1545: invokevirtual 295	android/view/View:findViewById	(I)Landroid/view/View;
    //   1548: checkcast 312	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar
    //   1551: putfield 468	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:xbQ	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1554: aload_1
    //   1555: getfield 468	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:xbQ	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1558: iconst_0
    //   1559: invokevirtual 335	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setVisibility	(I)V
    //   1562: aload_1
    //   1563: getfield 468	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:xbQ	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1566: aload_1
    //   1567: getfield 469	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:xcn	Landroid/view/View$OnClickListener;
    //   1570: invokevirtual 343	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setOnPlayButtonClickListener	(Landroid/view/View$OnClickListener;)V
    //   1573: aload_1
    //   1574: getfield 468	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:xbQ	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1577: aload_1
    //   1578: getfield 470	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:qmw	Lcom/tencent/mm/plugin/sight/decode/ui/b;
    //   1581: invokevirtual 351	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setIplaySeekCallback	(Lcom/tencent/mm/plugin/sight/decode/ui/b;)V
    //   1584: aload_1
    //   1585: aload_1
    //   1586: ldc_w 352
    //   1589: invokevirtual 471	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:findViewById	(I)Landroid/view/View;
    //   1592: checkcast 355	android/widget/ImageView
    //   1595: putfield 472	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:xcQ	Landroid/widget/ImageView;
    //   1598: aload_1
    //   1599: getfield 472	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:xcQ	Landroid/widget/ImageView;
    //   1602: iconst_0
    //   1603: invokevirtual 360	android/widget/ImageView:setVisibility	(I)V
    //   1606: aload_1
    //   1607: getfield 472	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:xcQ	Landroid/widget/ImageView;
    //   1610: aload_1
    //   1611: invokevirtual 363	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1614: aload_1
    //   1615: aload_1
    //   1616: ldc_w 364
    //   1619: invokevirtual 471	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:findViewById	(I)Landroid/view/View;
    //   1622: checkcast 355	android/widget/ImageView
    //   1625: putfield 473	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:xbR	Landroid/widget/ImageView;
    //   1628: aload_1
    //   1629: getfield 473	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:xbR	Landroid/widget/ImageView;
    //   1632: iconst_0
    //   1633: invokevirtual 360	android/widget/ImageView:setVisibility	(I)V
    //   1636: aload_1
    //   1637: getfield 473	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:xbR	Landroid/widget/ImageView;
    //   1640: aload_1
    //   1641: invokevirtual 363	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1644: aload_1
    //   1645: aload_1
    //   1646: getfield 437	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:contentView	Landroid/view/View;
    //   1649: ldc_w 368
    //   1652: invokevirtual 295	android/view/View:findViewById	(I)Landroid/view/View;
    //   1655: putfield 474	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:xcR	Landroid/view/View;
    //   1658: aload_1
    //   1659: getfield 474	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:xcR	Landroid/view/View;
    //   1662: bipush 8
    //   1664: invokevirtual 372	android/view/View:setVisibility	(I)V
    //   1667: aload_1
    //   1668: getfield 468	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:xbQ	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1671: invokevirtual 478	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:getParent	()Landroid/view/ViewParent;
    //   1674: astore 10
    //   1676: aload 10
    //   1678: instanceof 480
    //   1681: ifeq +15 -> 1696
    //   1684: aload 10
    //   1686: checkcast 480	android/view/ViewGroup
    //   1689: aload_1
    //   1690: getfield 468	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:xbQ	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1693: invokevirtual 483	android/view/ViewGroup:removeView	(Landroid/view/View;)V
    //   1696: aload_1
    //   1697: getfield 445	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:xoq	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1700: aload_1
    //   1701: getfield 468	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:xbQ	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1704: invokevirtual 487	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setVideoFooterView	(Lcom/tencent/mm/pluginsdk/ui/g;)V
    //   1707: aload_1
    //   1708: getfield 419	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:mContext	Landroid/content/Context;
    //   1711: invokevirtual 375	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1714: invokevirtual 218	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   1717: getfield 223	android/content/res/Configuration:orientation	I
    //   1720: iconst_2
    //   1721: if_icmpne +132 -> 1853
    //   1724: ldc_w 489
    //   1727: ldc_w 379
    //   1730: invokestatic 194	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1733: aload_1
    //   1734: invokevirtual 490	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:dzk	()V
    //   1737: aload_1
    //   1738: getfield 429	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:xbZ	Z
    //   1741: ifeq +161 -> 1902
    //   1744: aload_1
    //   1745: invokevirtual 493	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:dvw	()V
    //   1748: aload_1
    //   1749: invokevirtual 496	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:bOu	()V
    //   1752: aload_1
    //   1753: iconst_1
    //   1754: invokevirtual 497	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:setFocus	(Z)V
    //   1757: ldc 87
    //   1759: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1762: return
    //   1763: astore_1
    //   1764: ldc 74
    //   1766: aload_1
    //   1767: invokevirtual 78	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1770: invokestatic 84	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1773: ldc 87
    //   1775: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1778: return
    //   1779: aload_1
    //   1780: iload_2
    //   1781: putfield 418	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:kvo	I
    //   1784: aload_1
    //   1785: iload_3
    //   1786: putfield 417	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:kvn	I
    //   1789: goto -564 -> 1225
    //   1792: astore_1
    //   1793: ldc_w 489
    //   1796: aload_1
    //   1797: invokevirtual 78	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1800: invokestatic 84	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1803: goto -565 -> 1238
    //   1806: astore_1
    //   1807: ldc_w 489
    //   1810: aload_1
    //   1811: invokevirtual 78	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1814: invokestatic 84	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1817: goto -436 -> 1381
    //   1820: astore 10
    //   1822: ldc_w 489
    //   1825: aload 10
    //   1827: invokevirtual 78	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1830: invokestatic 84	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1833: goto -324 -> 1509
    //   1836: astore_1
    //   1837: ldc_w 489
    //   1840: aload_1
    //   1841: invokevirtual 78	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1844: invokestatic 84	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1847: ldc 87
    //   1849: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1852: return
    //   1853: aload_1
    //   1854: getfield 419	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:mContext	Landroid/content/Context;
    //   1857: invokevirtual 375	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1860: invokevirtual 218	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   1863: getfield 223	android/content/res/Configuration:orientation	I
    //   1866: iconst_1
    //   1867: if_icmpne -130 -> 1737
    //   1870: ldc_w 489
    //   1873: ldc_w 412
    //   1876: invokestatic 194	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1879: aload_1
    //   1880: invokevirtual 498	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:dzl	()V
    //   1883: goto -146 -> 1737
    //   1886: astore 10
    //   1888: ldc_w 489
    //   1891: aload 10
    //   1893: invokevirtual 78	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1896: invokestatic 84	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1899: goto -162 -> 1737
    //   1902: aload_1
    //   1903: invokevirtual 501	com/tencent/mm/plugin/sns/ui/LongVideoFullScreenView:dvC	()V
    //   1906: goto -158 -> 1748
    //   1909: astore 10
    //   1911: ldc_w 489
    //   1914: aload 10
    //   1916: invokevirtual 78	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1919: invokestatic 84	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1922: goto -170 -> 1752
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1925	0	this	VideoFullScreenActivity
    //   0	1925	1	paramBundle	android.os.Bundle
    //   432	1349	2	i	int
    //   437	1349	3	j	int
    //   491	844	4	k	int
    //   1299	72	5	m	int
    //   1305	72	6	n	int
    //   497	844	7	bool1	boolean
    //   503	844	8	bool2	boolean
    //   1293	72	9	bool3	boolean
    //   480	54	10	str1	String
    //   1086	6	10	localThrowable1	Throwable
    //   1119	6	10	localThrowable2	Throwable
    //   1135	6	10	localThrowable3	Throwable
    //   1252	433	10	localObject	java.lang.Object
    //   1820	6	10	localThrowable4	Throwable
    //   1886	6	10	localThrowable5	Throwable
    //   1909	6	10	localThrowable6	Throwable
    //   509	844	11	str2	String
    //   515	844	12	str3	String
    // Exception table:
    //   from	to	target	type
    //   20	291	933	java/lang/Throwable
    //   291	344	983	java/lang/Throwable
    //   344	380	983	java/lang/Throwable
    //   946	980	983	java/lang/Throwable
    //   443	453	1009	java/lang/Throwable
    //   453	466	1009	java/lang/Throwable
    //   996	1006	1009	java/lang/Throwable
    //   387	438	1023	java/lang/Throwable
    //   466	517	1023	java/lang/Throwable
    //   573	578	1023	java/lang/Throwable
    //   927	932	1023	java/lang/Throwable
    //   1010	1020	1023	java/lang/Throwable
    //   1040	1050	1023	java/lang/Throwable
    //   1103	1113	1023	java/lang/Throwable
    //   517	573	1039	java/lang/Throwable
    //   578	844	1086	java/lang/Throwable
    //   1053	1083	1086	java/lang/Throwable
    //   915	927	1102	java/lang/Throwable
    //   1088	1099	1102	java/lang/Throwable
    //   1121	1132	1102	java/lang/Throwable
    //   1137	1148	1102	java/lang/Throwable
    //   844	877	1119	java/lang/Throwable
    //   877	900	1119	java/lang/Throwable
    //   900	915	1135	java/lang/Throwable
    //   1159	1210	1763	java/lang/Throwable
    //   1238	1307	1763	java/lang/Throwable
    //   1381	1386	1763	java/lang/Throwable
    //   1757	1762	1763	java/lang/Throwable
    //   1793	1803	1763	java/lang/Throwable
    //   1807	1817	1763	java/lang/Throwable
    //   1837	1847	1763	java/lang/Throwable
    //   1215	1225	1792	java/lang/Throwable
    //   1225	1238	1792	java/lang/Throwable
    //   1779	1789	1792	java/lang/Throwable
    //   1307	1381	1806	java/lang/Throwable
    //   1386	1509	1820	java/lang/Throwable
    //   1752	1757	1836	java/lang/Throwable
    //   1822	1833	1836	java/lang/Throwable
    //   1888	1899	1836	java/lang/Throwable
    //   1911	1922	1836	java/lang/Throwable
    //   1509	1696	1886	java/lang/Throwable
    //   1696	1737	1886	java/lang/Throwable
    //   1853	1883	1886	java/lang/Throwable
    //   1737	1748	1909	java/lang/Throwable
    //   1748	1752	1909	java/lang/Throwable
    //   1902	1906	1909	java/lang/Throwable
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(187775);
    for (;;)
    {
      try
      {
        if (this.hyp != 0) {
          continue;
        }
        localSightVideoFullScreenView = this.xMs;
      }
      catch (Throwable localThrowable2)
      {
        SightVideoFullScreenView localSightVideoFullScreenView;
        ad.e("NonFullOrFullVideoType", localThrowable2.toString());
        continue;
        if (this.hyp != 1) {
          continue;
        }
        LongVideoFullScreenView localLongVideoFullScreenView = this.xMt;
        try
        {
          aq.az(localLongVideoFullScreenView.xbV);
          aq.az(localLongVideoFullScreenView.xcT);
          localLongVideoFullScreenView.xoq.onUIDestroy();
        }
        catch (Throwable localThrowable3)
        {
          ad.e("LongVideoFullScreenView", localThrowable3.toString());
        }
        continue;
      }
      try
      {
        aq.az(localSightVideoFullScreenView.xbV);
        aq.az(localSightVideoFullScreenView.xcT);
        localSightVideoFullScreenView.xsi.onDestroy();
        super.onDestroy();
        AppMethodBeat.o(187775);
        return;
      }
      catch (Throwable localThrowable1)
      {
        ad.e("SightVideoFullScreenView", localThrowable1.toString());
      }
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(187773);
    super.onPause();
    try
    {
      if (this.hyp == 0)
      {
        SightVideoFullScreenView localSightVideoFullScreenView = this.xMs;
        try
        {
          localSightVideoFullScreenView.wVd = false;
          aq.az(localSightVideoFullScreenView.xbV);
          aq.az(localSightVideoFullScreenView.xcT);
          AppMethodBeat.o(187773);
          return;
        }
        catch (Throwable localThrowable1)
        {
          ad.e("SightVideoFullScreenView", localThrowable1.toString());
          AppMethodBeat.o(187773);
          return;
        }
      }
      if (this.hyp != 1) {
        break label133;
      }
    }
    catch (Throwable localThrowable2)
    {
      ad.e("NonFullOrFullVideoType", localThrowable2.toString());
      AppMethodBeat.o(187773);
      return;
    }
    LongVideoFullScreenView localLongVideoFullScreenView = this.xMt;
    try
    {
      localLongVideoFullScreenView.wVd = false;
      aq.az(localLongVideoFullScreenView.xbV);
      aq.az(localLongVideoFullScreenView.xcT);
      AppMethodBeat.o(187773);
      return;
    }
    catch (Throwable localThrowable3)
    {
      ad.e("LongVideoFullScreenView", localThrowable3.toString());
    }
    label133:
    AppMethodBeat.o(187773);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(187772);
    super.onResume();
    try
    {
      if (this.hyp == 0)
      {
        this.xMs.wVd = true;
        AppMethodBeat.o(187772);
        return;
      }
      if (this.hyp == 1) {
        this.xMt.wVd = true;
      }
      AppMethodBeat.o(187772);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("NonFullOrFullVideoType", localThrowable.toString());
      AppMethodBeat.o(187772);
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(187771);
    super.onStart();
    try
    {
      if (this.hyp == 0)
      {
        SightVideoFullScreenView localSightVideoFullScreenView = this.xMs;
        try
        {
          if ((!localSightVideoFullScreenView.isFirst) && (!localSightVideoFullScreenView.xsi.isPlaying()) && (localSightVideoFullScreenView.xoy))
          {
            localSightVideoFullScreenView.dAd();
            localSightVideoFullScreenView.xoy = false;
          }
          localSightVideoFullScreenView.isFirst = false;
          AppMethodBeat.o(187771);
          return;
        }
        catch (Throwable localThrowable1)
        {
          ad.e("SightVideoFullScreenView", localThrowable1.toString());
          AppMethodBeat.o(187771);
          return;
        }
      }
      if (this.hyp != 1) {
        break label171;
      }
    }
    catch (Throwable localThrowable2)
    {
      ad.e("NonFullOrFullVideoType", localThrowable2.toString());
      AppMethodBeat.o(187771);
      return;
    }
    LongVideoFullScreenView localLongVideoFullScreenView = this.xMt;
    try
    {
      if ((!localLongVideoFullScreenView.isFirst) && (!localLongVideoFullScreenView.xoq.isPlaying()) && (localLongVideoFullScreenView.xoy))
      {
        localLongVideoFullScreenView.bOu();
        localLongVideoFullScreenView.xoy = false;
      }
      localLongVideoFullScreenView.isFirst = false;
      AppMethodBeat.o(187771);
      return;
    }
    catch (Throwable localThrowable3)
    {
      ad.e("LongVideoFullScreenView", localThrowable3.toString());
    }
    label171:
    AppMethodBeat.o(187771);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(187774);
    super.onStop();
    try
    {
      if (this.hyp == 0)
      {
        SightVideoFullScreenView localSightVideoFullScreenView = this.xMs;
        try
        {
          localSightVideoFullScreenView.isFirst = false;
          if (localSightVideoFullScreenView.xsi.isPlaying())
          {
            localSightVideoFullScreenView.dAe();
            localSightVideoFullScreenView.xoy = true;
          }
          AppMethodBeat.o(187774);
          return;
        }
        catch (Throwable localThrowable1)
        {
          ad.e("SightVideoFullScreenView", localThrowable1.toString());
          AppMethodBeat.o(187774);
          return;
        }
      }
      if (this.hyp != 1) {
        break label143;
      }
    }
    catch (Throwable localThrowable2)
    {
      ad.e("NonFullOrFullVideoType", localThrowable2.toString());
      AppMethodBeat.o(187774);
      return;
    }
    LongVideoFullScreenView localLongVideoFullScreenView = this.xMt;
    try
    {
      localLongVideoFullScreenView.isFirst = false;
      if (localLongVideoFullScreenView.xoq.isPlaying())
      {
        localLongVideoFullScreenView.ckd();
        localLongVideoFullScreenView.xoy = true;
      }
      AppMethodBeat.o(187774);
      return;
    }
    catch (Throwable localThrowable3)
    {
      ad.e("LongVideoFullScreenView", localThrowable3.toString());
    }
    label143:
    AppMethodBeat.o(187774);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.VideoFullScreenActivity
 * JD-Core Version:    0.7.0.1
 */