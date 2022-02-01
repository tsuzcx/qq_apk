package com.tencent.mm.ui.chatting.component;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelpackage.b;
import com.tencent.mm.modelpackage.t;
import com.tencent.mm.modelpackage.u;
import com.tencent.mm.pluginsdk.ui.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.d;
import java.util.HashMap;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=d.class)
public class g
  extends a
  implements d
{
  private static HashMap<String, f> aeqd;
  private ImageView Aov;
  private f Nwa;
  private Bitmap aepZ;
  private ImageView aeqa;
  private boolean aeqb;
  private final MStorage.IOnStorageChange aeqc;
  
  static
  {
    AppMethodBeat.i(35176);
    aeqd = new HashMap();
    AppMethodBeat.o(35176);
  }
  
  public g()
  {
    AppMethodBeat.i(35167);
    this.aeqb = true;
    this.aeqc = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(35166);
        Log.d("MicroMsg.ChattingUI.ChattingBackgroundComponent", "onBGChange event:%s", new Object[] { paramAnonymousString });
        if ((paramAnonymousString != null) && ((paramAnonymousString.equals(g.this.hlc.getTalkerUserName())) || (paramAnonymousString.equals("*")))) {
          g.this.ixx();
        }
        AppMethodBeat.o(35166);
      }
    };
    this.Nwa = null;
    AppMethodBeat.o(35167);
  }
  
  private boolean de(Context paramContext, String paramString)
  {
    AppMethodBeat.i(35172);
    if (aeqd.containsKey(paramString))
    {
      this.Nwa = ((f)aeqd.get(paramString));
      AppMethodBeat.o(35172);
      return true;
    }
    try
    {
      paramContext = Util.convertStreamToString(paramContext.getAssets().open(paramString));
      if (!Util.isNullOrNil(paramContext))
      {
        this.Nwa = new f(paramContext, this.hlc.aezO.getContext());
        aeqd.put(paramString, this.Nwa);
      }
      AppMethodBeat.o(35172);
      return true;
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.ChattingUI.ChattingBackgroundComponent", paramContext, "", new Object[0]);
      AppMethodBeat.o(35172);
    }
    return false;
  }
  
  private int iCa()
  {
    AppMethodBeat.i(35170);
    int i = this.hlc.aezO.getMMResources().getColor(R.e.default_background_color);
    AppMethodBeat.o(35170);
    return i;
  }
  
  private void jrw()
  {
    AppMethodBeat.i(35169);
    if ((this.aepZ != null) && (!this.aepZ.isRecycled()))
    {
      Log.i("MicroMsg.ChattingUI.ChattingBackgroundComponent", "recycle bitmap:%s", new Object[] { this.aepZ.toString() });
      this.aepZ.recycle();
    }
    if (this.aeqa != null) {
      this.aeqa.setImageBitmap(null);
    }
    if (this.Aov != null) {
      this.Aov.setVisibility(8);
    }
    AppMethodBeat.o(35169);
  }
  
  private void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(35171);
    jrw();
    if (this.aeqa == null)
    {
      View localView = this.hlc.findViewById(R.h.chatting_bg_ll);
      if (localView != null) {
        localView.setBackgroundColor(paramInt);
      }
      AppMethodBeat.o(35171);
      return;
    }
    this.aeqa.setImageDrawable(new ColorDrawable(paramInt));
    AppMethodBeat.o(35171);
  }
  
  /* Error */
  public final void ixx()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: ldc 211
    //   4: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 97	com/tencent/mm/ui/chatting/component/g:hlc	Lcom/tencent/mm/ui/chatting/d/a;
    //   11: ldc 213
    //   13: invokevirtual 217	com/tencent/mm/ui/chatting/d/a:cm	(Ljava/lang/Class;)Lcom/tencent/mm/ui/chatting/component/aj;
    //   16: checkcast 213	com/tencent/mm/ui/chatting/component/api/ap
    //   19: invokeinterface 220 1 0
    //   24: ifeq +73 -> 97
    //   27: aconst_null
    //   28: astore 4
    //   30: aload 4
    //   32: ifnonnull +83 -> 115
    //   35: invokestatic 226	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
    //   38: pop
    //   39: invokestatic 232	com/tencent/mm/model/c:ban	()Lcom/tencent/mm/storage/aq;
    //   42: sipush 12311
    //   45: bipush 254
    //   47: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   50: invokevirtual 244	com/tencent/mm/storage/aq:d	(ILjava/lang/Object;)Ljava/lang/Object;
    //   53: checkcast 234	java/lang/Integer
    //   56: invokevirtual 247	java/lang/Integer:intValue	()I
    //   59: istore_1
    //   60: iload_1
    //   61: bipush 254
    //   63: if_icmpne +61 -> 124
    //   66: aload_0
    //   67: aload_0
    //   68: invokespecial 249	com/tencent/mm/ui/chatting/component/g:iCa	()I
    //   71: invokespecial 250	com/tencent/mm/ui/chatting/component/g:setBackgroundColor	(I)V
    //   74: aload_0
    //   75: aload_0
    //   76: getfield 97	com/tencent/mm/ui/chatting/component/g:hlc	Lcom/tencent/mm/ui/chatting/d/a;
    //   79: getfield 103	com/tencent/mm/ui/chatting/d/a:aezO	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   82: invokevirtual 109	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getContext	()Landroid/app/Activity;
    //   85: ldc 252
    //   87: invokespecial 254	com/tencent/mm/ui/chatting/component/g:de	(Landroid/content/Context;Ljava/lang/String;)Z
    //   90: pop
    //   91: ldc 211
    //   93: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: return
    //   97: invokestatic 260	com/tencent/mm/modelpackage/u:bLI	()Lcom/tencent/mm/modelpackage/b;
    //   100: aload_0
    //   101: getfield 97	com/tencent/mm/ui/chatting/component/g:hlc	Lcom/tencent/mm/ui/chatting/d/a;
    //   104: invokevirtual 263	com/tencent/mm/ui/chatting/d/a:getTalkerUserName	()Ljava/lang/String;
    //   107: invokevirtual 269	com/tencent/mm/modelpackage/b:OM	(Ljava/lang/String;)Lcom/tencent/mm/modelpackage/a;
    //   110: astore 4
    //   112: goto -82 -> 30
    //   115: aload 4
    //   117: getfield 274	com/tencent/mm/modelpackage/a:oQj	I
    //   120: istore_1
    //   121: goto -61 -> 60
    //   124: invokestatic 278	com/tencent/mm/modelpackage/u:bLH	()Lcom/tencent/mm/modelpackage/t;
    //   127: pop
    //   128: aload_0
    //   129: getfield 97	com/tencent/mm/ui/chatting/component/g:hlc	Lcom/tencent/mm/ui/chatting/d/a;
    //   132: getfield 103	com/tencent/mm/ui/chatting/d/a:aezO	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   135: invokevirtual 109	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getContext	()Landroid/app/Activity;
    //   138: invokestatic 284	com/tencent/mm/modelpackage/t:dT	(Landroid/content/Context;)I
    //   141: istore_3
    //   142: iload_3
    //   143: tableswitch	default:+21 -> 164, 1:+156->299, 2:+156->299
    //   165: iconst_1
    //   166: putfield 49	com/tencent/mm/ui/chatting/component/g:aeqb	Z
    //   169: iload_1
    //   170: ifne +291 -> 461
    //   173: iload_3
    //   174: tableswitch	default:+30 -> 204, 1:+133->307, 2:+133->307, 3:+133->307, 4:+133->307
    //   205: istore_1
    //   206: iload_1
    //   207: iconst_m1
    //   208: if_icmpeq +85 -> 293
    //   211: aload_0
    //   212: invokespecial 186	com/tencent/mm/ui/chatting/component/g:jrw	()V
    //   215: aload_0
    //   216: aload_0
    //   217: getfield 97	com/tencent/mm/ui/chatting/component/g:hlc	Lcom/tencent/mm/ui/chatting/d/a;
    //   220: getfield 103	com/tencent/mm/ui/chatting/d/a:aezO	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   223: invokevirtual 135	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getMMResources	()Landroid/content/res/Resources;
    //   226: iload_1
    //   227: invokestatic 290	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   230: putfield 151	com/tencent/mm/ui/chatting/component/g:aepZ	Landroid/graphics/Bitmap;
    //   233: aload_0
    //   234: getfield 151	com/tencent/mm/ui/chatting/component/g:aepZ	Landroid/graphics/Bitmap;
    //   237: ifnonnull +122 -> 359
    //   240: ldc 118
    //   242: ldc_w 292
    //   245: iload_1
    //   246: invokestatic 297	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   249: invokevirtual 301	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   252: invokestatic 305	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   255: aload_0
    //   256: aload_0
    //   257: getfield 97	com/tencent/mm/ui/chatting/component/g:hlc	Lcom/tencent/mm/ui/chatting/d/a;
    //   260: getfield 103	com/tencent/mm/ui/chatting/d/a:aezO	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   263: invokevirtual 135	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getMMResources	()Landroid/content/res/Resources;
    //   266: getstatic 308	com/tencent/mm/R$e:chatting_bg_purecolor	I
    //   269: invokevirtual 147	android/content/res/Resources:getColor	(I)I
    //   272: invokespecial 250	com/tencent/mm/ui/chatting/component/g:setBackgroundColor	(I)V
    //   275: aload_0
    //   276: aload_0
    //   277: getfield 97	com/tencent/mm/ui/chatting/component/g:hlc	Lcom/tencent/mm/ui/chatting/d/a;
    //   280: getfield 103	com/tencent/mm/ui/chatting/d/a:aezO	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   283: invokevirtual 109	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getContext	()Landroid/app/Activity;
    //   286: ldc_w 310
    //   289: invokespecial 254	com/tencent/mm/ui/chatting/component/g:de	(Landroid/content/Context;Ljava/lang/String;)Z
    //   292: pop
    //   293: ldc 211
    //   295: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   298: return
    //   299: aload_0
    //   300: iconst_0
    //   301: putfield 49	com/tencent/mm/ui/chatting/component/g:aeqb	Z
    //   304: goto -135 -> 169
    //   307: getstatic 315	com/tencent/mm/R$g:chatting_bg_default	I
    //   310: istore_1
    //   311: goto -105 -> 206
    //   314: astore 4
    //   316: ldc_w 317
    //   319: aload 4
    //   321: ldc_w 319
    //   324: iconst_0
    //   325: anewarray 122	java/lang/Object
    //   328: invokestatic 128	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   331: new 210	java/lang/IncompatibleClassChangeError
    //   334: dup
    //   335: ldc_w 319
    //   338: invokespecial 322	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   341: aload 4
    //   343: invokevirtual 326	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   346: checkcast 210	java/lang/IncompatibleClassChangeError
    //   349: astore 4
    //   351: ldc 211
    //   353: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   356: aload 4
    //   358: athrow
    //   359: aload_0
    //   360: getfield 171	com/tencent/mm/ui/chatting/component/g:aeqa	Landroid/widget/ImageView;
    //   363: ifnonnull +20 -> 383
    //   366: aload_0
    //   367: aload_0
    //   368: getfield 97	com/tencent/mm/ui/chatting/component/g:hlc	Lcom/tencent/mm/ui/chatting/d/a;
    //   371: getstatic 329	com/tencent/mm/R$h:fxq	I
    //   374: invokevirtual 195	com/tencent/mm/ui/chatting/d/a:findViewById	(I)Landroid/view/View;
    //   377: checkcast 173	android/widget/ImageView
    //   380: putfield 171	com/tencent/mm/ui/chatting/component/g:aeqa	Landroid/widget/ImageView;
    //   383: aload_0
    //   384: getfield 179	com/tencent/mm/ui/chatting/component/g:Aov	Landroid/widget/ImageView;
    //   387: ifnonnull +20 -> 407
    //   390: aload_0
    //   391: aload_0
    //   392: getfield 97	com/tencent/mm/ui/chatting/component/g:hlc	Lcom/tencent/mm/ui/chatting/d/a;
    //   395: getstatic 332	com/tencent/mm/R$h:ftw	I
    //   398: invokevirtual 195	com/tencent/mm/ui/chatting/d/a:findViewById	(I)Landroid/view/View;
    //   401: checkcast 173	android/widget/ImageView
    //   404: putfield 179	com/tencent/mm/ui/chatting/component/g:Aov	Landroid/widget/ImageView;
    //   407: aload_0
    //   408: getfield 171	com/tencent/mm/ui/chatting/component/g:aeqa	Landroid/widget/ImageView;
    //   411: ifnull +14 -> 425
    //   414: aload_0
    //   415: getfield 171	com/tencent/mm/ui/chatting/component/g:aeqa	Landroid/widget/ImageView;
    //   418: aload_0
    //   419: getfield 151	com/tencent/mm/ui/chatting/component/g:aepZ	Landroid/graphics/Bitmap;
    //   422: invokevirtual 177	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   425: aload_0
    //   426: getfield 179	com/tencent/mm/ui/chatting/component/g:Aov	Landroid/widget/ImageView;
    //   429: ifnull -154 -> 275
    //   432: aload_0
    //   433: getfield 179	com/tencent/mm/ui/chatting/component/g:Aov	Landroid/widget/ImageView;
    //   436: astore 4
    //   438: invokestatic 337	com/tencent/mm/ui/aw:isDarkMode	()Z
    //   441: ifeq +14 -> 455
    //   444: iconst_0
    //   445: istore_1
    //   446: aload 4
    //   448: iload_1
    //   449: invokevirtual 182	android/widget/ImageView:setVisibility	(I)V
    //   452: goto -177 -> 275
    //   455: bipush 8
    //   457: istore_1
    //   458: goto -12 -> 446
    //   461: invokestatic 278	com/tencent/mm/modelpackage/u:bLH	()Lcom/tencent/mm/modelpackage/t;
    //   464: astore 5
    //   466: iload_1
    //   467: ifle +230 -> 697
    //   470: aload_0
    //   471: aload_0
    //   472: getfield 97	com/tencent/mm/ui/chatting/component/g:hlc	Lcom/tencent/mm/ui/chatting/d/a;
    //   475: getfield 103	com/tencent/mm/ui/chatting/d/a:aezO	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   478: invokevirtual 109	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getContext	()Landroid/app/Activity;
    //   481: ldc_w 339
    //   484: invokespecial 254	com/tencent/mm/ui/chatting/component/g:de	(Landroid/content/Context;Ljava/lang/String;)Z
    //   487: pop
    //   488: iload_3
    //   489: tableswitch	default:+31 -> 520, 1:+84->573, 2:+115->604, 3:+146->635, 4:+177->666
    //   521: astore 4
    //   523: aload_0
    //   524: invokespecial 186	com/tencent/mm/ui/chatting/component/g:jrw	()V
    //   527: aload_0
    //   528: aload 4
    //   530: invokestatic 345	com/tencent/mm/platformtools/r:Sg	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   533: putfield 151	com/tencent/mm/ui/chatting/component/g:aepZ	Landroid/graphics/Bitmap;
    //   536: aload_0
    //   537: getfield 151	com/tencent/mm/ui/chatting/component/g:aepZ	Landroid/graphics/Bitmap;
    //   540: ifnonnull +208 -> 748
    //   543: ldc 118
    //   545: ldc_w 347
    //   548: aload 4
    //   550: invokestatic 350	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   553: invokevirtual 301	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   556: invokestatic 305	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   559: aload_0
    //   560: aload_0
    //   561: invokespecial 249	com/tencent/mm/ui/chatting/component/g:iCa	()I
    //   564: invokespecial 250	com/tencent/mm/ui/chatting/component/g:setBackgroundColor	(I)V
    //   567: ldc 211
    //   569: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   572: return
    //   573: new 352	java/lang/StringBuilder
    //   576: dup
    //   577: invokespecial 353	java/lang/StringBuilder:<init>	()V
    //   580: aload 5
    //   582: iload_1
    //   583: iconst_1
    //   584: invokevirtual 357	com/tencent/mm/modelpackage/t:eL	(II)Ljava/lang/String;
    //   587: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: ldc_w 363
    //   593: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: invokevirtual 364	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   599: astore 4
    //   601: goto -78 -> 523
    //   604: new 352	java/lang/StringBuilder
    //   607: dup
    //   608: invokespecial 353	java/lang/StringBuilder:<init>	()V
    //   611: aload 5
    //   613: iload_1
    //   614: iconst_1
    //   615: invokevirtual 357	com/tencent/mm/modelpackage/t:eL	(II)Ljava/lang/String;
    //   618: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: ldc_w 366
    //   624: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: invokevirtual 364	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   630: astore 4
    //   632: goto -109 -> 523
    //   635: new 352	java/lang/StringBuilder
    //   638: dup
    //   639: invokespecial 353	java/lang/StringBuilder:<init>	()V
    //   642: aload 5
    //   644: iload_1
    //   645: iconst_1
    //   646: invokevirtual 357	com/tencent/mm/modelpackage/t:eL	(II)Ljava/lang/String;
    //   649: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: ldc_w 368
    //   655: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: invokevirtual 364	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   661: astore 4
    //   663: goto -140 -> 523
    //   666: new 352	java/lang/StringBuilder
    //   669: dup
    //   670: invokespecial 353	java/lang/StringBuilder:<init>	()V
    //   673: aload 5
    //   675: iload_1
    //   676: iconst_1
    //   677: invokevirtual 357	com/tencent/mm/modelpackage/t:eL	(II)Ljava/lang/String;
    //   680: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: ldc_w 370
    //   686: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: invokevirtual 364	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   692: astore 4
    //   694: goto -171 -> 523
    //   697: aload_0
    //   698: aload_0
    //   699: getfield 97	com/tencent/mm/ui/chatting/component/g:hlc	Lcom/tencent/mm/ui/chatting/d/a;
    //   702: getfield 103	com/tencent/mm/ui/chatting/d/a:aezO	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   705: invokevirtual 109	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getContext	()Landroid/app/Activity;
    //   708: ldc_w 339
    //   711: invokespecial 254	com/tencent/mm/ui/chatting/component/g:de	(Landroid/content/Context;Ljava/lang/String;)Z
    //   714: pop
    //   715: aload 4
    //   717: ifnonnull +15 -> 732
    //   720: ldc_w 372
    //   723: iload_3
    //   724: invokestatic 376	com/tencent/mm/modelpackage/t:aV	(Ljava/lang/String;I)Ljava/lang/String;
    //   727: astore 4
    //   729: goto -206 -> 523
    //   732: aload_0
    //   733: getfield 97	com/tencent/mm/ui/chatting/component/g:hlc	Lcom/tencent/mm/ui/chatting/d/a;
    //   736: invokevirtual 263	com/tencent/mm/ui/chatting/d/a:getTalkerUserName	()Ljava/lang/String;
    //   739: iload_3
    //   740: invokestatic 376	com/tencent/mm/modelpackage/t:aV	(Ljava/lang/String;I)Ljava/lang/String;
    //   743: astore 4
    //   745: goto -222 -> 523
    //   748: aload_0
    //   749: getfield 171	com/tencent/mm/ui/chatting/component/g:aeqa	Landroid/widget/ImageView;
    //   752: ifnonnull +20 -> 772
    //   755: aload_0
    //   756: aload_0
    //   757: getfield 97	com/tencent/mm/ui/chatting/component/g:hlc	Lcom/tencent/mm/ui/chatting/d/a;
    //   760: getstatic 329	com/tencent/mm/R$h:fxq	I
    //   763: invokevirtual 195	com/tencent/mm/ui/chatting/d/a:findViewById	(I)Landroid/view/View;
    //   766: checkcast 173	android/widget/ImageView
    //   769: putfield 171	com/tencent/mm/ui/chatting/component/g:aeqa	Landroid/widget/ImageView;
    //   772: aload_0
    //   773: getfield 179	com/tencent/mm/ui/chatting/component/g:Aov	Landroid/widget/ImageView;
    //   776: ifnonnull +20 -> 796
    //   779: aload_0
    //   780: aload_0
    //   781: getfield 97	com/tencent/mm/ui/chatting/component/g:hlc	Lcom/tencent/mm/ui/chatting/d/a;
    //   784: getstatic 332	com/tencent/mm/R$h:ftw	I
    //   787: invokevirtual 195	com/tencent/mm/ui/chatting/d/a:findViewById	(I)Landroid/view/View;
    //   790: checkcast 173	android/widget/ImageView
    //   793: putfield 179	com/tencent/mm/ui/chatting/component/g:Aov	Landroid/widget/ImageView;
    //   796: aload_0
    //   797: getfield 171	com/tencent/mm/ui/chatting/component/g:aeqa	Landroid/widget/ImageView;
    //   800: ifnull +14 -> 814
    //   803: aload_0
    //   804: getfield 171	com/tencent/mm/ui/chatting/component/g:aeqa	Landroid/widget/ImageView;
    //   807: aload_0
    //   808: getfield 151	com/tencent/mm/ui/chatting/component/g:aepZ	Landroid/graphics/Bitmap;
    //   811: invokevirtual 177	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   814: aload_0
    //   815: getfield 179	com/tencent/mm/ui/chatting/component/g:Aov	Landroid/widget/ImageView;
    //   818: ifnull +23 -> 841
    //   821: aload_0
    //   822: getfield 179	com/tencent/mm/ui/chatting/component/g:Aov	Landroid/widget/ImageView;
    //   825: astore 4
    //   827: invokestatic 337	com/tencent/mm/ui/aw:isDarkMode	()Z
    //   830: ifeq +17 -> 847
    //   833: iload_2
    //   834: istore_1
    //   835: aload 4
    //   837: iload_1
    //   838: invokevirtual 182	android/widget/ImageView:setVisibility	(I)V
    //   841: ldc 211
    //   843: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   846: return
    //   847: bipush 8
    //   849: istore_1
    //   850: goto -15 -> 835
    //   853: astore 4
    //   855: goto -622 -> 233
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	858	0	this	g
    //   59	791	1	i	int
    //   1	833	2	j	int
    //   141	599	3	k	int
    //   28	88	4	locala	com.tencent.mm.modelpackage.a
    //   314	28	4	localIncompatibleClassChangeError	java.lang.IncompatibleClassChangeError
    //   349	487	4	localObject1	Object
    //   853	1	4	localObject2	Object
    //   464	210	5	localt	t
    // Exception table:
    //   from	to	target	type
    //   215	233	314	java/lang/IncompatibleClassChangeError
    //   215	233	853	finally
  }
  
  public final void jjf() {}
  
  public final void jjg()
  {
    AppMethodBeat.i(35173);
    Log.i("MicroMsg.ChattingUI.ChattingBackgroundComponent", "[onChattingEnterAnimStart]");
    ixx();
    AppMethodBeat.o(35173);
  }
  
  public final void jjh()
  {
    AppMethodBeat.i(35174);
    u.bLI().add(this.aeqc);
    u.bLH().add(this.aeqc);
    AppMethodBeat.o(35174);
  }
  
  public final void jji() {}
  
  public final void jjj() {}
  
  public final void jjl()
  {
    AppMethodBeat.i(35175);
    Log.i("MicroMsg.ChattingUI.ChattingBackgroundComponent", "[onChattingExitAnimEnd]");
    if (bh.baz())
    {
      u.bLI().remove(this.aeqc);
      u.bLH().remove(this.aeqc);
    }
    jrw();
    AppMethodBeat.o(35175);
  }
  
  public final f jrx()
  {
    return this.Nwa;
  }
  
  public final boolean jry()
  {
    AppMethodBeat.i(256105);
    com.tencent.mm.modelpackage.a locala = u.bLI().OM(this.hlc.getTalkerUserName());
    if ((locala == null) || (locala.oQj == -2))
    {
      AppMethodBeat.o(256105);
      return false;
    }
    AppMethodBeat.o(256105);
    return true;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(256113);
    super.onConfigurationChanged(paramConfiguration);
    if ((paramConfiguration.orientation == 1) && (!this.aeqb))
    {
      ixx();
      AppMethodBeat.o(256113);
      return;
    }
    if ((paramConfiguration.orientation == 2) && (this.aeqb)) {
      ixx();
    }
    AppMethodBeat.o(256113);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.g
 * JD-Core Version:    0.7.0.1
 */