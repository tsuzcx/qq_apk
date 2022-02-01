package com.tencent.mm.plugin.textstatus.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.plugin.textstatus.a.a.c;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.plugin.textstatus.proto.ae;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bb;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/util/IStatusIconHelper;", "", "()V", "getClusterDesByInfo", "", "topicInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "sameTopicSize", "", "name", "type", "getCoverAgendaIconId", "getCoverAgendaIconIdForReport", "getCustomStatusName", "getDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lkotlin/collections/ArrayList;", "getDrawable", "Landroid/graphics/drawable/Drawable;", "bitmap", "Landroid/graphics/Bitmap;", "isUseOriginal", "", "iconType", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconType;", "iconColor", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconColor;", "getIconSpan", "Landroid/text/style/ImageSpan;", "attachView", "Landroid/view/View;", "id", "iconScene", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;", "size", "item", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "getName", "getNameByInfo", "getResVersion", "", "getTextStatusSpanSync", "textView", "Landroid/widget/TextView;", "userName", "handleIconConfigResult", "", "rsp", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetIconConfigResp;", "isIconValidForSet", "onCreate", "onDestroy", "refreshTextStatusSpan", "", "username", "displayName", "textSize", "refreshTextStatusSpanWithDesc", "reqNewestIconConfig", "isClientVersionChange", "(Ljava/lang/Boolean;)V", "setBigIcon", "iv", "Landroid/widget/ImageView;", "iconId", "setCoverAgendaClickTime", "clickTime", "setCoverAgendaIconId", "setCustomStatusName", "setIcon", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
{
  public static final a.a TAJ = new a.a((byte)0);
  
  public static Drawable a(Bitmap paramBitmap, boolean paramBoolean, a.c paramc, com.tencent.mm.plugin.textstatus.a.a.a parama)
  {
    s.u(paramc, "iconType");
    s.u(parama, "iconColor");
    paramBitmap = (Drawable)new BitmapDrawable(paramBitmap);
    if (paramBoolean) {
      return paramBitmap;
    }
    int i;
    if (b.$EnumSwitchMapping$0[paramc.ordinal()] == 1)
    {
      switch (b.avl[parama.ordinal()])
      {
      default: 
        i = MMApplicationContext.getResources().getColor(com.tencent.mm.plugin.textstatus.a.b.UN_Link);
      }
      for (;;)
      {
        int j = Color.alpha(i);
        if (j != 0) {
          paramBitmap.setAlpha(j);
        }
        paramBitmap = bb.e(paramBitmap, i & 0xFFFFFF | 0xFF000000);
        s.s(paramBitmap, "{\n                val co…solidColor)\n            }");
        return paramBitmap;
        i = -1;
        continue;
        i = MMApplicationContext.getResources().getColor(com.tencent.mm.plugin.textstatus.a.b.Brand);
        continue;
        i = MMApplicationContext.getResources().getColor(com.tencent.mm.plugin.textstatus.a.b.ORANGE);
        continue;
        i = MMApplicationContext.getResources().getColor(com.tencent.mm.plugin.textstatus.a.b.FG_0);
        continue;
        i = MMApplicationContext.getResources().getColor(com.tencent.mm.plugin.textstatus.a.b.FG_2);
        continue;
        i = MMApplicationContext.getResources().getColor(com.tencent.mm.plugin.textstatus.a.b.FG_3);
        continue;
        i = MMApplicationContext.getResources().getColor(com.tencent.mm.plugin.textstatus.a.b.BW_0_Alpha_0_2);
      }
    }
    switch (b.avl[parama.ordinal()])
    {
    default: 
      i = MMApplicationContext.getResources().getColor(com.tencent.mm.plugin.textstatus.a.b.White);
    }
    for (;;)
    {
      paramBitmap = bb.e(paramBitmap, i);
      s.s(paramBitmap, "{\n                val co…ble, color)\n            }");
      return paramBitmap;
      i = MMApplicationContext.getResources().getColor(com.tencent.mm.plugin.textstatus.a.b.FG_1);
      continue;
      i = MMApplicationContext.getResources().getColor(com.tencent.mm.plugin.textstatus.a.b.normal_text_color);
    }
  }
  
  public static CharSequence a(View paramView, String paramString, CharSequence paramCharSequence, int paramInt, a.c paramc, com.tencent.mm.plugin.textstatus.a.a.b paramb)
  {
    s.u(paramc, "iconType");
    s.u(paramb, "iconScene");
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (n.bp((CharSequence)localObject)))
    {
      i = 1;
      if (i == 0) {
        if ((paramCharSequence != null) && (paramCharSequence.length() != 0)) {
          break label70;
        }
      }
    }
    label70:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label76;
      }
      return null;
      i = 0;
      break;
    }
    label76:
    int k = 0;
    localObject = f.TjQ;
    com.tencent.mm.plugin.textstatus.h.f.b localb = f.bdN(paramString);
    localObject = new SpannableStringBuilder(paramCharSequence);
    if (paramCharSequence == null) {}
    for (i = 0;; i = paramCharSequence.length())
    {
      paramString = (j[])((SpannableStringBuilder)localObject).getSpans(0, i, j.class);
      s.s(paramString, "imgSpans");
      int j = 0;
      int m = paramString.length;
      for (i = k; j < m; i = 1)
      {
        paramCharSequence = paramString[j];
        j += 1;
        ((SpannableStringBuilder)localObject).removeSpan(paramCharSequence);
      }
    }
    if (localb != null) {
      if (localb.hHF())
      {
        paramString = com.tencent.mm.plugin.textstatus.a.a.a.Thw;
        paramView = b.hKh().a(paramView, localb.field_IconID, paramc, paramString, paramb, paramInt, localb);
        if (!n.a((CharSequence)localObject, ' ')) {
          ((SpannableStringBuilder)localObject).append(' ');
        }
        ((SpannableStringBuilder)localObject).setSpan(paramView, ((SpannableStringBuilder)localObject).length() - 1, ((SpannableStringBuilder)localObject).length(), 34);
      }
    }
    for (paramInt = 1;; paramInt = i)
    {
      if (paramInt != 0)
      {
        return (CharSequence)localObject;
        paramString = com.tencent.mm.plugin.textstatus.a.a.a.Thr;
        break;
      }
      return null;
    }
  }
  
  /* Error */
  public static CharSequence b(View paramView, String paramString, CharSequence paramCharSequence, int paramInt, a.c paramc, com.tencent.mm.plugin.textstatus.a.a.b paramb)
  {
    // Byte code:
    //   0: aload 4
    //   2: ldc 101
    //   4: invokestatic 107	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   7: aload 5
    //   9: ldc 202
    //   11: invokestatic 107	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: aload_1
    //   15: checkcast 204	java/lang/CharSequence
    //   18: astore 7
    //   20: aload 7
    //   22: ifnull +11 -> 33
    //   25: aload 7
    //   27: invokestatic 210	kotlin/n/n:bp	(Ljava/lang/CharSequence;)Z
    //   30: ifeq +34 -> 64
    //   33: iconst_1
    //   34: istore 6
    //   36: iload 6
    //   38: ifne +24 -> 62
    //   41: aload_2
    //   42: ifnull +12 -> 54
    //   45: aload_2
    //   46: invokeinterface 213 1 0
    //   51: ifne +19 -> 70
    //   54: iconst_1
    //   55: istore 6
    //   57: iload 6
    //   59: ifeq +17 -> 76
    //   62: aconst_null
    //   63: areturn
    //   64: iconst_0
    //   65: istore 6
    //   67: goto -31 -> 36
    //   70: iconst_0
    //   71: istore 6
    //   73: goto -16 -> 57
    //   76: iconst_0
    //   77: istore 6
    //   79: getstatic 219	com/tencent/mm/plugin/textstatus/b/f:TjQ	Lcom/tencent/mm/plugin/textstatus/b/f;
    //   82: astore_2
    //   83: aload_1
    //   84: invokestatic 223	com/tencent/mm/plugin/textstatus/b/f:bdN	(Ljava/lang/String;)Lcom/tencent/mm/plugin/textstatus/h/f/b;
    //   87: astore 8
    //   89: new 225	android/text/SpannableStringBuilder
    //   92: dup
    //   93: invokespecial 303	android/text/SpannableStringBuilder:<init>	()V
    //   96: astore_2
    //   97: aload 8
    //   99: ifnull +172 -> 271
    //   102: invokestatic 258	com/tencent/mm/plugin/textstatus/util/b:hKh	()Lcom/tencent/mm/plugin/textstatus/util/a;
    //   105: aload 8
    //   107: invokestatic 306	com/tencent/mm/plugin/textstatus/h/f/b:b	(Lcom/tencent/mm/plugin/textstatus/h/f/b;)Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;
    //   110: invokevirtual 310	com/tencent/mm/plugin/textstatus/util/a:f	(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;)Ljava/lang/String;
    //   113: astore 7
    //   115: aload 8
    //   117: invokevirtual 248	com/tencent/mm/plugin/textstatus/h/f/b:hHF	()Z
    //   120: ifeq +161 -> 281
    //   123: getstatic 252	com/tencent/mm/plugin/textstatus/a/a$a:Thw	Lcom/tencent/mm/plugin/textstatus/a/a$a;
    //   126: astore_1
    //   127: invokestatic 258	com/tencent/mm/plugin/textstatus/util/b:hKh	()Lcom/tencent/mm/plugin/textstatus/util/a;
    //   130: aload_0
    //   131: aload 8
    //   133: getfield 262	com/tencent/mm/plugin/textstatus/h/f/b:field_IconID	Ljava/lang/String;
    //   136: aload 4
    //   138: aload_1
    //   139: aload 5
    //   141: iload_3
    //   142: aload 8
    //   144: invokevirtual 265	com/tencent/mm/plugin/textstatus/util/a:a	(Landroid/view/View;Ljava/lang/String;Lcom/tencent/mm/plugin/textstatus/a/a$c;Lcom/tencent/mm/plugin/textstatus/a/a$a;Lcom/tencent/mm/plugin/textstatus/a/a$b;ILcom/tencent/mm/plugin/textstatus/h/f/b;)Landroid/text/style/ImageSpan;
    //   147: astore_0
    //   148: aload_2
    //   149: checkcast 204	java/lang/CharSequence
    //   152: sipush 8199
    //   155: invokestatic 268	kotlin/n/n:a	(Ljava/lang/CharSequence;C)Z
    //   158: ifne +11 -> 169
    //   161: aload_2
    //   162: sipush 8199
    //   165: invokevirtual 272	android/text/SpannableStringBuilder:append	(C)Landroid/text/SpannableStringBuilder;
    //   168: pop
    //   169: aload_2
    //   170: aload 7
    //   172: checkcast 204	java/lang/CharSequence
    //   175: invokevirtual 313	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    //   178: pop
    //   179: aload_2
    //   180: aload_0
    //   181: iconst_0
    //   182: aload_2
    //   183: invokevirtual 273	android/text/SpannableStringBuilder:length	()I
    //   186: aload 7
    //   188: invokevirtual 316	java/lang/String:length	()I
    //   191: isub
    //   192: bipush 34
    //   194: invokevirtual 277	android/text/SpannableStringBuilder:setSpan	(Ljava/lang/Object;III)V
    //   197: getstatic 322	com/tencent/mm/plugin/textstatus/util/g:TBm	Lcom/tencent/mm/plugin/textstatus/util/g;
    //   200: astore_0
    //   201: invokestatic 326	com/tencent/mm/plugin/textstatus/util/g:hKu	()Lcom/tencent/mm/plugin/textstatus/proto/ar;
    //   204: aload 8
    //   206: getfield 262	com/tencent/mm/plugin/textstatus/h/f/b:field_IconID	Ljava/lang/String;
    //   209: invokestatic 331	com/tencent/mm/plugin/textstatus/util/h:a	(Lcom/tencent/mm/plugin/textstatus/proto/ar;Ljava/lang/String;)Lcom/tencent/mm/plugin/textstatus/proto/ap;
    //   212: astore_0
    //   213: aload_0
    //   214: ifnonnull +74 -> 288
    //   217: aconst_null
    //   218: astore_0
    //   219: aload 8
    //   221: invokevirtual 248	com/tencent/mm/plugin/textstatus/h/f/b:hHF	()Z
    //   224: ifeq +72 -> 296
    //   227: invokestatic 335	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   230: invokevirtual 338	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   233: getstatic 189	com/tencent/mm/plugin/textstatus/a$b:BW_0_Alpha_0_2	I
    //   236: invokevirtual 149	android/content/res/Resources:getColor	(I)I
    //   239: istore_3
    //   240: aload_2
    //   241: new 340	android/text/style/ForegroundColorSpan
    //   244: dup
    //   245: iload_3
    //   246: invokespecial 342	android/text/style/ForegroundColorSpan:<init>	(I)V
    //   249: aload_2
    //   250: invokevirtual 273	android/text/SpannableStringBuilder:length	()I
    //   253: aload 7
    //   255: invokevirtual 316	java/lang/String:length	()I
    //   258: isub
    //   259: aload_2
    //   260: invokevirtual 273	android/text/SpannableStringBuilder:length	()I
    //   263: bipush 34
    //   265: invokevirtual 277	android/text/SpannableStringBuilder:setSpan	(Ljava/lang/Object;III)V
    //   268: iconst_1
    //   269: istore 6
    //   271: iload 6
    //   273: ifeq +103 -> 376
    //   276: aload_2
    //   277: checkcast 204	java/lang/CharSequence
    //   280: areturn
    //   281: getstatic 280	com/tencent/mm/plugin/textstatus/a/a$a:Thr	Lcom/tencent/mm/plugin/textstatus/a/a$a;
    //   284: astore_1
    //   285: goto -158 -> 127
    //   288: aload_0
    //   289: invokestatic 345	com/tencent/mm/plugin/textstatus/util/h:a	(Lcom/tencent/mm/plugin/textstatus/proto/ap;)Lcom/tencent/mm/plugin/textstatus/proto/aq;
    //   292: astore_0
    //   293: goto -74 -> 219
    //   296: aload_0
    //   297: ifnull +28 -> 325
    //   300: aload_0
    //   301: invokestatic 348	com/tencent/mm/plugin/textstatus/util/h:a	(Lcom/tencent/mm/plugin/textstatus/proto/aq;)Z
    //   304: iconst_1
    //   305: if_icmpne +20 -> 325
    //   308: iconst_1
    //   309: istore_3
    //   310: iload_3
    //   311: ifeq +49 -> 360
    //   314: aload_0
    //   315: getfield 353	com/tencent/mm/plugin/textstatus/proto/aq:TpS	Ljava/lang/String;
    //   318: invokestatic 357	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   321: istore_3
    //   322: goto -82 -> 240
    //   325: iconst_0
    //   326: istore_3
    //   327: goto -17 -> 310
    //   330: astore_0
    //   331: ldc_w 359
    //   334: ldc_w 361
    //   337: aload_0
    //   338: invokestatic 365	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   341: invokestatic 371	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   344: invokestatic 335	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   347: invokevirtual 338	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   350: getstatic 143	com/tencent/mm/plugin/textstatus/a$b:UN_Link	I
    //   353: invokevirtual 149	android/content/res/Resources:getColor	(I)I
    //   356: istore_3
    //   357: goto -117 -> 240
    //   360: invokestatic 335	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   363: invokevirtual 338	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   366: getstatic 143	com/tencent/mm/plugin/textstatus/a$b:UN_Link	I
    //   369: invokevirtual 149	android/content/res/Resources:getColor	(I)I
    //   372: istore_3
    //   373: goto -133 -> 240
    //   376: aconst_null
    //   377: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	378	0	paramView	View
    //   0	378	1	paramString	String
    //   0	378	2	paramCharSequence	CharSequence
    //   0	378	3	paramInt	int
    //   0	378	4	paramc	a.c
    //   0	378	5	paramb	com.tencent.mm.plugin.textstatus.a.a.b
    //   34	238	6	i	int
    //   18	236	7	localObject	Object
    //   87	133	8	localb	com.tencent.mm.plugin.textstatus.h.f.b
    // Exception table:
    //   from	to	target	type
    //   314	322	330	finally
  }
  
  public abstract void G(Boolean paramBoolean);
  
  public abstract ImageSpan a(View paramView, String paramString, a.c paramc, com.tencent.mm.plugin.textstatus.a.a.a parama, com.tencent.mm.plugin.textstatus.a.a.b paramb, int paramInt, com.tencent.mm.plugin.textstatus.h.f.b paramb1);
  
  public abstract String a(TextStatusTopicInfo paramTextStatusTopicInfo, int paramInt1, String paramString, int paramInt2);
  
  public abstract void a(ImageView paramImageView, String paramString, a.c paramc, com.tencent.mm.plugin.textstatus.a.a.a parama);
  
  public abstract void a(ImageView paramImageView, String paramString, a.c paramc, com.tencent.mm.plugin.textstatus.a.a.a parama, com.tencent.mm.plugin.textstatus.h.f.b paramb);
  
  public abstract void a(ae paramae);
  
  public abstract boolean beh(String paramString);
  
  public abstract String bei(String paramString);
  
  public abstract void bej(String paramString);
  
  public abstract String f(TextStatusTopicInfo paramTextStatusTopicInfo);
  
  public abstract ArrayList<com.tencent.mm.view.recyclerview.a> getDataList();
  
  public abstract long getResVersion();
  
  public abstract String hKe();
  
  public abstract String hKf();
  
  public void onCreate()
  {
    b.hKi().alive();
    b.hKj().alive();
  }
  
  public void onDestroy()
  {
    b.hKi().dead();
    b.hKj().dead();
  }
  
  public abstract void wn(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.util.a
 * JD-Core Version:    0.7.0.1
 */