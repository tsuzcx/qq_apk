package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.k;
import com.tencent.mm.cb.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.List;
import java.util.Map;

final class AppGrid$a
  extends BaseAdapter
{
  List<f> ePL;
  private int sdH;
  private int sdI;
  private Map<String, f> sdJ = null;
  
  public AppGrid$a(Context paramContext, List<f> paramList, Map<String, f> paramMap)
  {
    this.ePL = paramMap;
    Object localObject;
    this.sdJ = localObject;
    this.sdH = BackwardSupportUtil.b.b(paramList, 56.0F);
    this.sdI = BackwardSupportUtil.b.b(paramList, 53.299999F);
  }
  
  private void a(AppGrid.a.a parama, String paramString1, String paramString2)
  {
    Object localObject2 = null;
    if (this.sdJ == null)
    {
      y.w("MicroMsg.AppGrid", "func[attachHarcodeServiceApp] harcodeServiceAppInfoMap null");
      return;
    }
    f localf = (f)this.sdJ.get(paramString1);
    if (localf == null)
    {
      y.w("MicroMsg.AppGrid", "func[attachHarcodeServiceApp] info null");
      return;
    }
    au.Hx();
    if (c.isSDCardAvailable()) {
      if (!localf.ckN()) {
        break label765;
      }
    }
    label103:
    label630:
    label765:
    for (paramString1 = g.b(localf.field_appId, 4, a.getDensity(AppGrid.h(this.sdG)));; paramString1 = null)
    {
      Object localObject1;
      if (paramString1 != null)
      {
        parama.hic.setBackgroundDrawable(new BitmapDrawable(paramString1));
        if (bk.bl(paramString2)) {
          break label649;
        }
        TextView localTextView = parama.kYV;
        paramString1 = AppGrid.h(this.sdG);
        localObject1 = paramString2;
        if (paramString1 != null)
        {
          if (localf != null) {
            break label465;
          }
          localObject1 = paramString2;
        }
        localTextView.setText((CharSequence)localObject1);
      }
      for (;;)
      {
        if ((localf.ckN()) && (localf.ckO()))
        {
          if (AppGrid.i(this.sdG) == null) {
            AppGrid.a(this.sdG, AppGrid.h(this.sdG).getSharedPreferences(ae.cqR(), 0));
          }
          if (AppGrid.i(this.sdG).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + localf.field_appId, true)) {
            parama.sdK.setVisibility(0);
          }
        }
        if (!f.rUa.equals(localf.field_appId)) {
          break label672;
        }
        au.Hx();
        i = ((Integer)c.Dz().get(ac.a.usE, Integer.valueOf(0))).intValue();
        if (i <= 1) {
          break;
        }
        au.Hx();
        if (bk.G(((String)c.Dz().get(ac.a.uuH, "")).split(";")).contains(String.valueOf(i))) {
          break;
        }
        parama.sdK.setVisibility(0);
        return;
        if (f.rUa.equals(localf.field_appId))
        {
          parama.hic.setImageResource(R.g.panel_icon_transfer);
          break label103;
        }
        if (f.rUc.equals(localf.field_appId))
        {
          parama.hic.setImageResource(R.g.panel_icon_luckymoney);
          break label103;
        }
        if (f.rUb.equals(localf.field_appId))
        {
          parama.hic.setImageResource(R.g.panel_icon_card);
          break label103;
        }
        if (f.rUd.equals(localf.field_appId))
        {
          parama.hic.setImageResource(R.k.panel_icon_aa);
          break label103;
        }
        parama.hic.setImageResource(R.g.app_panel_icon_unknowed);
        break label103;
        parama.hic.setImageResource(R.g.sharemore_nosdcard_icon);
        break label103;
        String str = g.eR(paramString1);
        localObject1 = localObject2;
        if (str.equalsIgnoreCase("zh_CN")) {
          localObject1 = localf.field_appName;
        }
        if (str.equalsIgnoreCase("en"))
        {
          if (bk.bl(localf.field_appName_en)) {
            localObject1 = localf.field_appName;
          }
        }
        else if (!str.equalsIgnoreCase("zh_TW"))
        {
          paramString1 = (String)localObject1;
          if (!str.equalsIgnoreCase("zh_HK")) {}
        }
        else
        {
          if (str.equalsIgnoreCase("zh_HK"))
          {
            if (!bk.bl(localf.field_appName_hk)) {
              break label630;
            }
            localObject1 = localf.field_appName_tw;
          }
          paramString1 = (String)localObject1;
          if (bk.bl((String)localObject1)) {
            if (!bk.bl(localf.field_appName_tw)) {
              break label640;
            }
          }
        }
        for (paramString1 = localf.field_appName;; paramString1 = localf.field_appName_tw)
        {
          localObject1 = paramString2;
          if (bk.bl(paramString1)) {
            break;
          }
          localObject1 = paramString1;
          break;
          localObject1 = localf.field_appName_en;
          break label522;
          localObject1 = localf.field_appName_hk;
          break label576;
        }
        parama.kYV.setText(g.b(AppGrid.h(this.sdG), localf, null));
      }
      if (!f.rUc.equals(localf.field_appId)) {
        break;
      }
      au.Hx();
      int i = ((Integer)c.Dz().get(ac.a.usE, Integer.valueOf(0))).intValue();
      if (i <= 1) {
        break;
      }
      au.Hx();
      if (bk.G(((String)c.Dz().get(ac.a.uuI, "")).split(";")).contains(String.valueOf(i))) {
        break;
      }
      parama.sdK.setVisibility(0);
      return;
    }
  }
  
  public final int getCount()
  {
    if (AppGrid.a(this.sdG) == AppGrid.e(this.sdG) - 1) {
      return AppGrid.f(this.sdG) - AppGrid.a(this.sdG) * AppGrid.b(this.sdG);
    }
    return AppGrid.b(this.sdG);
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  /* Error */
  public final android.view.View getView(int paramInt, android.view.View paramView, android.view.ViewGroup paramViewGroup)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +367 -> 368
    //   4: new 9	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 332	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:<init>	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid$a;)V
    //   12: astore_3
    //   13: aload_0
    //   14: getfield 24	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:sdG	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
    //   17: invokestatic 90	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
    //   20: getstatic 337	com/tencent/mm/R$i:app_grid_item	I
    //   23: aconst_null
    //   24: invokestatic 343	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   27: astore 8
    //   29: aload_3
    //   30: aload 8
    //   32: getstatic 348	com/tencent/mm/R$h:app_grid_item_icon	I
    //   35: invokevirtual 352	android/view/View:findViewById	(I)Landroid/view/View;
    //   38: checkcast 112	android/widget/ImageView
    //   41: putfield 105	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hic	Landroid/widget/ImageView;
    //   44: aload_3
    //   45: aload 8
    //   47: getstatic 355	com/tencent/mm/R$h:app_grid_item_icon_mask	I
    //   50: invokevirtual 352	android/view/View:findViewById	(I)Landroid/view/View;
    //   53: putfield 359	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:nXU	Landroid/view/View;
    //   56: aload_3
    //   57: aload 8
    //   59: getstatic 362	com/tencent/mm/R$h:app_grid_item_name	I
    //   62: invokevirtual 352	android/view/View:findViewById	(I)Landroid/view/View;
    //   65: checkcast 128	android/widget/TextView
    //   68: putfield 126	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:kYV	Landroid/widget/TextView;
    //   71: aload_3
    //   72: aload 8
    //   74: getstatic 365	com/tencent/mm/R$h:app_grid_item_new_icon	I
    //   77: invokevirtual 352	android/view/View:findViewById	(I)Landroid/view/View;
    //   80: checkcast 128	android/widget/TextView
    //   83: putfield 177	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sdK	Landroid/widget/TextView;
    //   86: aload_3
    //   87: aload 8
    //   89: getstatic 368	com/tencent/mm/R$h:app_grid_item_red_icon	I
    //   92: invokevirtual 352	android/view/View:findViewById	(I)Landroid/view/View;
    //   95: putfield 371	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sdL	Landroid/view/View;
    //   98: aload 8
    //   100: aload_3
    //   101: invokevirtual 375	android/view/View:setTag	(Ljava/lang/Object;)V
    //   104: ldc 49
    //   106: new 156	java/lang/StringBuilder
    //   109: dup
    //   110: ldc_w 377
    //   113: invokespecial 161	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   116: iload_1
    //   117: invokevirtual 380	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   120: ldc_w 382
    //   123: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_0
    //   127: getfield 24	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:sdG	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
    //   130: invokestatic 309	com/tencent/mm/pluginsdk/ui/chat/AppGrid:a	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)I
    //   133: invokevirtual 380	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   136: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 385	com/tencent/mm/sdk/platformtools/y:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: aload_3
    //   143: getfield 126	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:kYV	Landroid/widget/TextView;
    //   146: iconst_0
    //   147: invokevirtual 181	android/widget/TextView:setVisibility	(I)V
    //   150: aload_3
    //   151: getfield 371	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sdL	Landroid/view/View;
    //   154: bipush 8
    //   156: invokevirtual 386	android/view/View:setVisibility	(I)V
    //   159: aload_3
    //   160: getfield 177	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sdK	Landroid/widget/TextView;
    //   163: bipush 8
    //   165: invokevirtual 181	android/widget/TextView:setVisibility	(I)V
    //   168: aload_3
    //   169: getfield 359	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:nXU	Landroid/view/View;
    //   172: iconst_0
    //   173: invokevirtual 386	android/view/View:setVisibility	(I)V
    //   176: aload_3
    //   177: getfield 105	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hic	Landroid/widget/ImageView;
    //   180: invokevirtual 390	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   183: astore_2
    //   184: aload_2
    //   185: aload_0
    //   186: getfield 40	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:sdH	I
    //   189: putfield 395	android/view/ViewGroup$LayoutParams:width	I
    //   192: aload_2
    //   193: aload_0
    //   194: getfield 40	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:sdH	I
    //   197: putfield 398	android/view/ViewGroup$LayoutParams:height	I
    //   200: aload_3
    //   201: getfield 105	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hic	Landroid/widget/ImageView;
    //   204: aload_2
    //   205: invokevirtual 402	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   208: aload_0
    //   209: getfield 24	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:sdG	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
    //   212: invokestatic 309	com/tencent/mm/pluginsdk/ui/chat/AppGrid:a	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)I
    //   215: aload_0
    //   216: getfield 24	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:sdG	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
    //   219: invokestatic 317	com/tencent/mm/pluginsdk/ui/chat/AppGrid:b	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)I
    //   222: imul
    //   223: iload_1
    //   224: iadd
    //   225: istore 4
    //   227: aload_0
    //   228: getfield 24	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:sdG	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
    //   231: invokestatic 406	com/tencent/mm/pluginsdk/ui/chat/AppGrid:c	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid$b;
    //   234: iload 4
    //   236: invokeinterface 412 2 0
    //   241: istore 5
    //   243: iload 4
    //   245: aload_0
    //   246: getfield 24	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:sdG	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
    //   249: invokestatic 415	com/tencent/mm/pluginsdk/ui/chat/AppGrid:g	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)I
    //   252: if_icmpge +1156 -> 1408
    //   255: iload 5
    //   257: tableswitch	default:+83 -> 340, 0:+392->649, 1:+320->577, 2:+622->879, 3:+979->1236, 4:+703->960, 5:+158->415, 6:+425->682, 7:+955->1212, 8:+931->1188, 9:+1106->1363, 10:+239->496, 11:+125->382, 12:+589->846, 13:+784->1041, 14:+507->764, 15:+1060->1317, 16:+1118->1375
    //   341: iload_1
    //   342: invokevirtual 323	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:zn	(I)Lcom/tencent/mm/pluginsdk/model/app/f;
    //   345: astore_2
    //   346: aload_2
    //   347: ifnull +18 -> 365
    //   350: aload_2
    //   351: invokestatic 419	com/tencent/mm/pluginsdk/model/app/g:j	(Lcom/tencent/mm/pluginsdk/model/app/f;)Z
    //   354: ifeq +11 -> 365
    //   357: aload_3
    //   358: getfield 177	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sdK	Landroid/widget/TextView;
    //   361: iconst_0
    //   362: invokevirtual 181	android/widget/TextView:setVisibility	(I)V
    //   365: aload 8
    //   367: areturn
    //   368: aload_2
    //   369: invokevirtual 423	android/view/View:getTag	()Ljava/lang/Object;
    //   372: checkcast 9	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a
    //   375: astore_3
    //   376: aload_2
    //   377: astore 8
    //   379: goto -275 -> 104
    //   382: aload_3
    //   383: getfield 105	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hic	Landroid/widget/ImageView;
    //   386: getstatic 426	com/tencent/mm/R$k:panel_icon_fav	I
    //   389: invokevirtual 246	android/widget/ImageView:setImageResource	(I)V
    //   392: aload_3
    //   393: getfield 126	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:kYV	Landroid/widget/TextView;
    //   396: aload_0
    //   397: getfield 24	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:sdG	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
    //   400: invokestatic 90	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
    //   403: getstatic 431	com/tencent/mm/R$l:app_field_favorite	I
    //   406: invokevirtual 434	android/content/Context:getString	(I)Ljava/lang/String;
    //   409: invokevirtual 132	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   412: goto -72 -> 340
    //   415: aload_3
    //   416: getfield 105	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hic	Landroid/widget/ImageView;
    //   419: getstatic 437	com/tencent/mm/R$k:panel_icon_wxtalk	I
    //   422: invokevirtual 246	android/widget/ImageView:setImageResource	(I)V
    //   425: aload_3
    //   426: getfield 126	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:kYV	Landroid/widget/TextView;
    //   429: aload_0
    //   430: getfield 24	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:sdG	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
    //   433: invokestatic 90	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
    //   436: getstatic 440	com/tencent/mm/R$l:app_field_talkroom	I
    //   439: invokevirtual 434	android/content/Context:getString	(I)Ljava/lang/String;
    //   442: invokevirtual 132	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   445: invokestatic 73	com/tencent/mm/model/au:Hx	()Lcom/tencent/mm/model/c;
    //   448: pop
    //   449: invokestatic 194	com/tencent/mm/model/c:Dz	()Lcom/tencent/mm/storage/z;
    //   452: bipush 67
    //   454: iconst_0
    //   455: invokestatic 445	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   458: invokevirtual 448	com/tencent/mm/storage/z:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   461: checkcast 442	java/lang/Boolean
    //   464: checkcast 442	java/lang/Boolean
    //   467: invokevirtual 451	java/lang/Boolean:booleanValue	()Z
    //   470: ifeq +14 -> 484
    //   473: aload_3
    //   474: getfield 177	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sdK	Landroid/widget/TextView;
    //   477: iconst_0
    //   478: invokevirtual 181	android/widget/TextView:setVisibility	(I)V
    //   481: goto -141 -> 340
    //   484: aload_3
    //   485: getfield 177	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sdK	Landroid/widget/TextView;
    //   488: bipush 8
    //   490: invokevirtual 181	android/widget/TextView:setVisibility	(I)V
    //   493: goto -153 -> 340
    //   496: aload_3
    //   497: getfield 105	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hic	Landroid/widget/ImageView;
    //   500: getstatic 454	com/tencent/mm/R$k:panel_icon_voiceinput	I
    //   503: invokevirtual 246	android/widget/ImageView:setImageResource	(I)V
    //   506: aload_3
    //   507: getfield 126	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:kYV	Landroid/widget/TextView;
    //   510: aload_0
    //   511: getfield 24	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:sdG	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
    //   514: invokestatic 90	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
    //   517: getstatic 457	com/tencent/mm/R$l:hardcode_plugin_voiceinput_nick	I
    //   520: invokevirtual 434	android/content/Context:getString	(I)Ljava/lang/String;
    //   523: invokevirtual 132	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   526: invokestatic 73	com/tencent/mm/model/au:Hx	()Lcom/tencent/mm/model/c;
    //   529: pop
    //   530: invokestatic 194	com/tencent/mm/model/c:Dz	()Lcom/tencent/mm/storage/z;
    //   533: bipush 73
    //   535: iconst_0
    //   536: invokestatic 445	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   539: invokevirtual 448	com/tencent/mm/storage/z:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   542: checkcast 442	java/lang/Boolean
    //   545: checkcast 442	java/lang/Boolean
    //   548: invokevirtual 451	java/lang/Boolean:booleanValue	()Z
    //   551: ifeq +14 -> 565
    //   554: aload_3
    //   555: getfield 177	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sdK	Landroid/widget/TextView;
    //   558: iconst_0
    //   559: invokevirtual 181	android/widget/TextView:setVisibility	(I)V
    //   562: goto -222 -> 340
    //   565: aload_3
    //   566: getfield 177	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sdK	Landroid/widget/TextView;
    //   569: bipush 8
    //   571: invokevirtual 181	android/widget/TextView:setVisibility	(I)V
    //   574: goto -234 -> 340
    //   577: getstatic 463	com/tencent/mm/platformtools/ae:eTJ	Z
    //   580: ifeq +36 -> 616
    //   583: aload_3
    //   584: getfield 105	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hic	Landroid/widget/ImageView;
    //   587: getstatic 466	com/tencent/mm/R$k:panel_icon_sights	I
    //   590: invokevirtual 246	android/widget/ImageView:setImageResource	(I)V
    //   593: aload_3
    //   594: getfield 126	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:kYV	Landroid/widget/TextView;
    //   597: aload_0
    //   598: getfield 24	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:sdG	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
    //   601: invokestatic 90	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
    //   604: getstatic 469	com/tencent/mm/R$l:app_field_sight	I
    //   607: invokevirtual 434	android/content/Context:getString	(I)Ljava/lang/String;
    //   610: invokevirtual 132	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   613: goto -273 -> 340
    //   616: aload_3
    //   617: getfield 105	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hic	Landroid/widget/ImageView;
    //   620: getstatic 472	com/tencent/mm/R$k:panel_icon_camera	I
    //   623: invokevirtual 246	android/widget/ImageView:setImageResource	(I)V
    //   626: aload_3
    //   627: getfield 126	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:kYV	Landroid/widget/TextView;
    //   630: aload_0
    //   631: getfield 24	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:sdG	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
    //   634: invokestatic 90	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
    //   637: getstatic 475	com/tencent/mm/R$l:app_field_mmsight	I
    //   640: invokevirtual 434	android/content/Context:getString	(I)Ljava/lang/String;
    //   643: invokevirtual 132	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   646: goto -306 -> 340
    //   649: aload_3
    //   650: getfield 105	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hic	Landroid/widget/ImageView;
    //   653: getstatic 478	com/tencent/mm/R$k:panel_icon_pic	I
    //   656: invokevirtual 246	android/widget/ImageView:setImageResource	(I)V
    //   659: aload_3
    //   660: getfield 126	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:kYV	Landroid/widget/TextView;
    //   663: aload_0
    //   664: getfield 24	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:sdG	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
    //   667: invokestatic 90	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
    //   670: getstatic 481	com/tencent/mm/R$l:app_field_new_pic	I
    //   673: invokevirtual 434	android/content/Context:getString	(I)Ljava/lang/String;
    //   676: invokevirtual 132	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   679: goto -339 -> 340
    //   682: aload_3
    //   683: getfield 105	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hic	Landroid/widget/ImageView;
    //   686: getstatic 484	com/tencent/mm/R$k:panel_icon_location	I
    //   689: invokevirtual 246	android/widget/ImageView:setImageResource	(I)V
    //   692: aload_3
    //   693: getfield 126	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:kYV	Landroid/widget/TextView;
    //   696: aload_0
    //   697: getfield 24	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:sdG	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
    //   700: invokestatic 90	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
    //   703: getstatic 487	com/tencent/mm/R$l:app_field_location	I
    //   706: invokevirtual 434	android/content/Context:getString	(I)Ljava/lang/String;
    //   709: invokevirtual 132	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   712: invokestatic 73	com/tencent/mm/model/au:Hx	()Lcom/tencent/mm/model/c;
    //   715: pop
    //   716: invokestatic 194	com/tencent/mm/model/c:Dz	()Lcom/tencent/mm/storage/z;
    //   719: ldc_w 488
    //   722: iconst_0
    //   723: invokestatic 445	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   726: invokevirtual 448	com/tencent/mm/storage/z:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   729: checkcast 442	java/lang/Boolean
    //   732: checkcast 442	java/lang/Boolean
    //   735: invokevirtual 451	java/lang/Boolean:booleanValue	()Z
    //   738: ifeq +14 -> 752
    //   741: aload_3
    //   742: getfield 371	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sdL	Landroid/view/View;
    //   745: iconst_0
    //   746: invokevirtual 386	android/view/View:setVisibility	(I)V
    //   749: goto -409 -> 340
    //   752: aload_3
    //   753: getfield 371	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sdL	Landroid/view/View;
    //   756: bipush 8
    //   758: invokevirtual 386	android/view/View:setVisibility	(I)V
    //   761: goto -421 -> 340
    //   764: aload_3
    //   765: getfield 105	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hic	Landroid/widget/ImageView;
    //   768: getstatic 491	com/tencent/mm/R$k:panel_icon_service	I
    //   771: invokevirtual 246	android/widget/ImageView:setImageResource	(I)V
    //   774: aload_3
    //   775: getfield 126	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:kYV	Landroid/widget/TextView;
    //   778: aload_0
    //   779: getfield 24	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:sdG	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
    //   782: invokestatic 90	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
    //   785: getstatic 494	com/tencent/mm/R$l:app_field_service	I
    //   788: invokevirtual 434	android/content/Context:getString	(I)Ljava/lang/String;
    //   791: invokevirtual 132	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   794: invokestatic 73	com/tencent/mm/model/au:Hx	()Lcom/tencent/mm/model/c;
    //   797: pop
    //   798: invokestatic 194	com/tencent/mm/model/c:Dz	()Lcom/tencent/mm/storage/z;
    //   801: ldc_w 495
    //   804: iconst_1
    //   805: invokestatic 445	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   808: invokevirtual 448	com/tencent/mm/storage/z:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   811: checkcast 442	java/lang/Boolean
    //   814: checkcast 442	java/lang/Boolean
    //   817: invokevirtual 451	java/lang/Boolean:booleanValue	()Z
    //   820: ifeq +14 -> 834
    //   823: aload_3
    //   824: getfield 371	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sdL	Landroid/view/View;
    //   827: iconst_0
    //   828: invokevirtual 386	android/view/View:setVisibility	(I)V
    //   831: goto -491 -> 340
    //   834: aload_3
    //   835: getfield 371	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sdL	Landroid/view/View;
    //   838: bipush 8
    //   840: invokevirtual 386	android/view/View:setVisibility	(I)V
    //   843: goto -503 -> 340
    //   846: aload_3
    //   847: getfield 105	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hic	Landroid/widget/ImageView;
    //   850: getstatic 498	com/tencent/mm/R$k:panel_icon_friendcard	I
    //   853: invokevirtual 246	android/widget/ImageView:setImageResource	(I)V
    //   856: aload_3
    //   857: getfield 126	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:kYV	Landroid/widget/TextView;
    //   860: aload_0
    //   861: getfield 24	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:sdG	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
    //   864: invokestatic 90	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
    //   867: getstatic 501	com/tencent/mm/R$l:app_field_card	I
    //   870: invokevirtual 434	android/content/Context:getString	(I)Ljava/lang/String;
    //   873: invokevirtual 132	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   876: goto -536 -> 340
    //   879: aload_3
    //   880: getfield 105	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hic	Landroid/widget/ImageView;
    //   883: getstatic 504	com/tencent/mm/R$k:app_panel_voice_icon	I
    //   886: invokevirtual 246	android/widget/ImageView:setImageResource	(I)V
    //   889: aload_3
    //   890: getfield 126	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:kYV	Landroid/widget/TextView;
    //   893: aload_0
    //   894: getfield 24	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:sdG	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
    //   897: invokestatic 90	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
    //   900: getstatic 507	com/tencent/mm/R$l:app_field_voip	I
    //   903: invokevirtual 434	android/content/Context:getString	(I)Ljava/lang/String;
    //   906: invokevirtual 132	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   909: invokestatic 73	com/tencent/mm/model/au:Hx	()Lcom/tencent/mm/model/c;
    //   912: pop
    //   913: invokestatic 194	com/tencent/mm/model/c:Dz	()Lcom/tencent/mm/storage/z;
    //   916: bipush 54
    //   918: iconst_0
    //   919: invokestatic 445	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   922: invokevirtual 448	com/tencent/mm/storage/z:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   925: checkcast 442	java/lang/Boolean
    //   928: checkcast 442	java/lang/Boolean
    //   931: invokevirtual 451	java/lang/Boolean:booleanValue	()Z
    //   934: ifeq +14 -> 948
    //   937: aload_3
    //   938: getfield 177	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sdK	Landroid/widget/TextView;
    //   941: iconst_0
    //   942: invokevirtual 181	android/widget/TextView:setVisibility	(I)V
    //   945: goto -605 -> 340
    //   948: aload_3
    //   949: getfield 177	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sdK	Landroid/widget/TextView;
    //   952: bipush 8
    //   954: invokevirtual 181	android/widget/TextView:setVisibility	(I)V
    //   957: goto -617 -> 340
    //   960: aload_3
    //   961: getfield 105	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hic	Landroid/widget/ImageView;
    //   964: getstatic 510	com/tencent/mm/R$k:panel_icon_voipvoice	I
    //   967: invokevirtual 246	android/widget/ImageView:setImageResource	(I)V
    //   970: aload_3
    //   971: getfield 126	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:kYV	Landroid/widget/TextView;
    //   974: aload_0
    //   975: getfield 24	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:sdG	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
    //   978: invokestatic 90	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
    //   981: getstatic 513	com/tencent/mm/R$l:app_field_voipaudio	I
    //   984: invokevirtual 434	android/content/Context:getString	(I)Ljava/lang/String;
    //   987: invokevirtual 132	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   990: invokestatic 73	com/tencent/mm/model/au:Hx	()Lcom/tencent/mm/model/c;
    //   993: pop
    //   994: invokestatic 194	com/tencent/mm/model/c:Dz	()Lcom/tencent/mm/storage/z;
    //   997: bipush 62
    //   999: iconst_0
    //   1000: invokestatic 445	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1003: invokevirtual 448	com/tencent/mm/storage/z:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   1006: checkcast 442	java/lang/Boolean
    //   1009: checkcast 442	java/lang/Boolean
    //   1012: invokevirtual 451	java/lang/Boolean:booleanValue	()Z
    //   1015: ifeq +14 -> 1029
    //   1018: aload_3
    //   1019: getfield 177	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sdK	Landroid/widget/TextView;
    //   1022: iconst_0
    //   1023: invokevirtual 181	android/widget/TextView:setVisibility	(I)V
    //   1026: goto -686 -> 340
    //   1029: aload_3
    //   1030: getfield 177	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sdK	Landroid/widget/TextView;
    //   1033: bipush 8
    //   1035: invokevirtual 181	android/widget/TextView:setVisibility	(I)V
    //   1038: goto -698 -> 340
    //   1041: aload_3
    //   1042: getfield 105	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hic	Landroid/widget/ImageView;
    //   1045: getstatic 516	com/tencent/mm/R$k:app_panel_emoticon_icon	I
    //   1048: invokevirtual 246	android/widget/ImageView:setImageResource	(I)V
    //   1051: aload_3
    //   1052: getfield 126	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:kYV	Landroid/widget/TextView;
    //   1055: aload_0
    //   1056: getfield 24	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:sdG	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
    //   1059: invokestatic 90	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
    //   1062: getstatic 519	com/tencent/mm/R$l:emoji_store_title	I
    //   1065: invokevirtual 434	android/content/Context:getString	(I)Ljava/lang/String;
    //   1068: invokevirtual 132	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1071: invokestatic 73	com/tencent/mm/model/au:Hx	()Lcom/tencent/mm/model/c;
    //   1074: pop
    //   1075: invokestatic 194	com/tencent/mm/model/c:Dz	()Lcom/tencent/mm/storage/z;
    //   1078: ldc_w 520
    //   1081: iconst_0
    //   1082: invokestatic 445	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1085: invokevirtual 448	com/tencent/mm/storage/z:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   1088: checkcast 442	java/lang/Boolean
    //   1091: checkcast 442	java/lang/Boolean
    //   1094: invokevirtual 451	java/lang/Boolean:booleanValue	()Z
    //   1097: istore 6
    //   1099: invokestatic 73	com/tencent/mm/model/au:Hx	()Lcom/tencent/mm/model/c;
    //   1102: pop
    //   1103: invokestatic 194	com/tencent/mm/model/c:Dz	()Lcom/tencent/mm/storage/z;
    //   1106: ldc_w 521
    //   1109: iconst_0
    //   1110: invokestatic 445	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1113: invokevirtual 448	com/tencent/mm/storage/z:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   1116: checkcast 442	java/lang/Boolean
    //   1119: checkcast 442	java/lang/Boolean
    //   1122: invokevirtual 451	java/lang/Boolean:booleanValue	()Z
    //   1125: istore 7
    //   1127: iload 6
    //   1129: ifne +8 -> 1137
    //   1132: iload 7
    //   1134: ifeq +42 -> 1176
    //   1137: aload_3
    //   1138: getfield 177	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sdK	Landroid/widget/TextView;
    //   1141: iconst_0
    //   1142: invokevirtual 181	android/widget/TextView:setVisibility	(I)V
    //   1145: iload 7
    //   1147: ifeq +16 -> 1163
    //   1150: aload_3
    //   1151: getfield 177	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sdK	Landroid/widget/TextView;
    //   1154: getstatic 524	com/tencent/mm/R$l:app_free	I
    //   1157: invokevirtual 526	android/widget/TextView:setText	(I)V
    //   1160: goto -820 -> 340
    //   1163: aload_3
    //   1164: getfield 177	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sdK	Landroid/widget/TextView;
    //   1167: getstatic 529	com/tencent/mm/R$l:app_new	I
    //   1170: invokevirtual 526	android/widget/TextView:setText	(I)V
    //   1173: goto -833 -> 340
    //   1176: aload_3
    //   1177: getfield 177	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sdK	Landroid/widget/TextView;
    //   1180: bipush 8
    //   1182: invokevirtual 181	android/widget/TextView:setVisibility	(I)V
    //   1185: goto -845 -> 340
    //   1188: aload_0
    //   1189: aload_3
    //   1190: getstatic 184	com/tencent/mm/pluginsdk/model/app/f:rUa	Ljava/lang/String;
    //   1193: aload_0
    //   1194: getfield 24	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:sdG	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
    //   1197: invokestatic 90	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
    //   1200: getstatic 532	com/tencent/mm/R$l:app_field_transfer	I
    //   1203: invokevirtual 434	android/content/Context:getString	(I)Ljava/lang/String;
    //   1206: invokespecial 534	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:a	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a;Ljava/lang/String;Ljava/lang/String;)V
    //   1209: goto -869 -> 340
    //   1212: aload_0
    //   1213: aload_3
    //   1214: getstatic 249	com/tencent/mm/pluginsdk/model/app/f:rUc	Ljava/lang/String;
    //   1217: aload_0
    //   1218: getfield 24	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:sdG	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
    //   1221: invokestatic 90	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
    //   1224: getstatic 537	com/tencent/mm/R$l:app_field_lucky_money	I
    //   1227: invokevirtual 434	android/content/Context:getString	(I)Ljava/lang/String;
    //   1230: invokespecial 534	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:a	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a;Ljava/lang/String;Ljava/lang/String;)V
    //   1233: goto -893 -> 340
    //   1236: aload_3
    //   1237: getfield 105	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hic	Landroid/widget/ImageView;
    //   1240: getstatic 540	com/tencent/mm/R$k:panel_icon_multitalk	I
    //   1243: invokevirtual 246	android/widget/ImageView:setImageResource	(I)V
    //   1246: aload_3
    //   1247: getfield 126	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:kYV	Landroid/widget/TextView;
    //   1250: aload_0
    //   1251: getfield 24	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:sdG	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
    //   1254: invokestatic 90	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
    //   1257: getstatic 513	com/tencent/mm/R$l:app_field_voipaudio	I
    //   1260: invokevirtual 434	android/content/Context:getString	(I)Ljava/lang/String;
    //   1263: invokevirtual 132	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1266: invokestatic 73	com/tencent/mm/model/au:Hx	()Lcom/tencent/mm/model/c;
    //   1269: pop
    //   1270: invokestatic 194	com/tencent/mm/model/c:Dz	()Lcom/tencent/mm/storage/z;
    //   1273: bipush 81
    //   1275: iconst_0
    //   1276: invokestatic 445	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1279: invokevirtual 448	com/tencent/mm/storage/z:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   1282: checkcast 442	java/lang/Boolean
    //   1285: checkcast 442	java/lang/Boolean
    //   1288: invokevirtual 451	java/lang/Boolean:booleanValue	()Z
    //   1291: ifeq +14 -> 1305
    //   1294: aload_3
    //   1295: getfield 177	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sdK	Landroid/widget/TextView;
    //   1298: iconst_0
    //   1299: invokevirtual 181	android/widget/TextView:setVisibility	(I)V
    //   1302: goto -962 -> 340
    //   1305: aload_3
    //   1306: getfield 177	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sdK	Landroid/widget/TextView;
    //   1309: bipush 8
    //   1311: invokevirtual 181	android/widget/TextView:setVisibility	(I)V
    //   1314: goto -974 -> 340
    //   1317: aload_3
    //   1318: getfield 105	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hic	Landroid/widget/ImageView;
    //   1321: getstatic 543	com/tencent/mm/R$k:panel_icon_enterprise	I
    //   1324: invokevirtual 246	android/widget/ImageView:setImageResource	(I)V
    //   1327: aload_3
    //   1328: getfield 126	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:kYV	Landroid/widget/TextView;
    //   1331: aload_0
    //   1332: getfield 24	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:sdG	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
    //   1335: invokestatic 90	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
    //   1338: getstatic 546	com/tencent/mm/R$l:app_field_enterprise_brand	I
    //   1341: invokevirtual 434	android/content/Context:getString	(I)Ljava/lang/String;
    //   1344: invokevirtual 132	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1347: aload_3
    //   1348: getfield 371	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sdL	Landroid/view/View;
    //   1351: bipush 8
    //   1353: invokevirtual 386	android/view/View:setVisibility	(I)V
    //   1356: goto -1016 -> 340
    //   1359: astore_2
    //   1360: goto -1020 -> 340
    //   1363: aload_0
    //   1364: aload_3
    //   1365: getstatic 261	com/tencent/mm/pluginsdk/model/app/f:rUd	Ljava/lang/String;
    //   1368: aconst_null
    //   1369: invokespecial 534	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:a	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a;Ljava/lang/String;Ljava/lang/String;)V
    //   1372: goto -1032 -> 340
    //   1375: aload_3
    //   1376: getfield 105	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hic	Landroid/widget/ImageView;
    //   1379: getstatic 549	com/tencent/mm/R$k:panel_icon_file_explorer	I
    //   1382: invokevirtual 246	android/widget/ImageView:setImageResource	(I)V
    //   1385: aload_3
    //   1386: getfield 126	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:kYV	Landroid/widget/TextView;
    //   1389: aload_0
    //   1390: getfield 24	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:sdG	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
    //   1393: invokestatic 90	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
    //   1396: getstatic 552	com/tencent/mm/R$l:app_field_file	I
    //   1399: invokevirtual 434	android/content/Context:getString	(I)Ljava/lang/String;
    //   1402: invokevirtual 132	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1405: goto -1065 -> 340
    //   1408: aload_2
    //   1409: aload_0
    //   1410: getfield 43	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:sdI	I
    //   1413: putfield 395	android/view/ViewGroup$LayoutParams:width	I
    //   1416: aload_2
    //   1417: aload_0
    //   1418: getfield 43	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:sdI	I
    //   1421: putfield 398	android/view/ViewGroup$LayoutParams:height	I
    //   1424: aload_3
    //   1425: getfield 105	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hic	Landroid/widget/ImageView;
    //   1428: aload_2
    //   1429: invokevirtual 402	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1432: aload_0
    //   1433: iload_1
    //   1434: invokevirtual 323	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:zn	(I)Lcom/tencent/mm/pluginsdk/model/app/f;
    //   1437: astore 9
    //   1439: aload 9
    //   1441: ifnull -1101 -> 340
    //   1444: invokestatic 73	com/tencent/mm/model/au:Hx	()Lcom/tencent/mm/model/c;
    //   1447: pop
    //   1448: invokestatic 79	com/tencent/mm/model/c:isSDCardAvailable	()Z
    //   1451: ifeq +341 -> 1792
    //   1454: aload 9
    //   1456: getfield 555	com/tencent/mm/pluginsdk/model/app/f:field_status	I
    //   1459: iconst_5
    //   1460: if_icmpne +157 -> 1617
    //   1463: aload 9
    //   1465: getfield 86	com/tencent/mm/pluginsdk/model/app/f:field_appId	Ljava/lang/String;
    //   1468: iconst_3
    //   1469: aload_0
    //   1470: getfield 24	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:sdG	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
    //   1473: invokestatic 90	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
    //   1476: invokestatic 96	com/tencent/mm/cb/a:getDensity	(Landroid/content/Context;)F
    //   1479: invokestatic 101	com/tencent/mm/pluginsdk/model/app/g:b	(Ljava/lang/String;IF)Landroid/graphics/Bitmap;
    //   1482: astore_2
    //   1483: aload_2
    //   1484: ifnull +187 -> 1671
    //   1487: aload_3
    //   1488: getfield 105	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hic	Landroid/widget/ImageView;
    //   1491: new 107	android/graphics/drawable/BitmapDrawable
    //   1494: dup
    //   1495: aload_2
    //   1496: invokespecial 110	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   1499: invokevirtual 116	android/widget/ImageView:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1502: aload_3
    //   1503: getfield 126	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:kYV	Landroid/widget/TextView;
    //   1506: aload_0
    //   1507: getfield 24	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:sdG	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
    //   1510: invokestatic 90	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
    //   1513: aload 9
    //   1515: aconst_null
    //   1516: invokestatic 302	com/tencent/mm/pluginsdk/model/app/g:b	(Landroid/content/Context;Lcom/tencent/mm/pluginsdk/model/app/f;Ljava/lang/String;)Ljava/lang/String;
    //   1519: invokevirtual 132	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1522: aload 9
    //   1524: invokevirtual 82	com/tencent/mm/pluginsdk/model/app/f:ckN	()Z
    //   1527: ifeq -1187 -> 340
    //   1530: aload 9
    //   1532: invokevirtual 135	com/tencent/mm/pluginsdk/model/app/f:ckO	()Z
    //   1535: ifeq -1195 -> 340
    //   1538: aload_0
    //   1539: getfield 24	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:sdG	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
    //   1542: invokestatic 139	com/tencent/mm/pluginsdk/ui/chat/AppGrid:i	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/SharedPreferences;
    //   1545: ifnonnull +25 -> 1570
    //   1548: aload_0
    //   1549: getfield 24	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:sdG	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
    //   1552: aload_0
    //   1553: getfield 24	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:sdG	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
    //   1556: invokestatic 90	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
    //   1559: invokestatic 145	com/tencent/mm/sdk/platformtools/ae:cqR	()Ljava/lang/String;
    //   1562: iconst_0
    //   1563: invokevirtual 151	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1566: invokestatic 154	com/tencent/mm/pluginsdk/ui/chat/AppGrid:a	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;Landroid/content/SharedPreferences;)Landroid/content/SharedPreferences;
    //   1569: pop
    //   1570: aload_0
    //   1571: getfield 24	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:sdG	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
    //   1574: invokestatic 139	com/tencent/mm/pluginsdk/ui/chat/AppGrid:i	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/SharedPreferences;
    //   1577: new 156	java/lang/StringBuilder
    //   1580: dup
    //   1581: ldc 158
    //   1583: invokespecial 161	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1586: aload 9
    //   1588: getfield 86	com/tencent/mm/pluginsdk/model/app/f:field_appId	Ljava/lang/String;
    //   1591: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1594: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1597: iconst_1
    //   1598: invokeinterface 174 3 0
    //   1603: ifeq -1263 -> 340
    //   1606: aload_3
    //   1607: getfield 177	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sdK	Landroid/widget/TextView;
    //   1610: iconst_0
    //   1611: invokevirtual 181	android/widget/TextView:setVisibility	(I)V
    //   1614: goto -1274 -> 340
    //   1617: aload 9
    //   1619: invokevirtual 82	com/tencent/mm/pluginsdk/model/app/f:ckN	()Z
    //   1622: ifeq +26 -> 1648
    //   1625: aload 9
    //   1627: getfield 86	com/tencent/mm/pluginsdk/model/app/f:field_appId	Ljava/lang/String;
    //   1630: iconst_4
    //   1631: aload_0
    //   1632: getfield 24	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:sdG	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
    //   1635: invokestatic 90	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
    //   1638: invokestatic 96	com/tencent/mm/cb/a:getDensity	(Landroid/content/Context;)F
    //   1641: invokestatic 101	com/tencent/mm/pluginsdk/model/app/g:b	(Ljava/lang/String;IF)Landroid/graphics/Bitmap;
    //   1644: astore_2
    //   1645: goto -162 -> 1483
    //   1648: aload 9
    //   1650: getfield 86	com/tencent/mm/pluginsdk/model/app/f:field_appId	Ljava/lang/String;
    //   1653: iconst_1
    //   1654: aload_0
    //   1655: getfield 24	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:sdG	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
    //   1658: invokestatic 90	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
    //   1661: invokestatic 96	com/tencent/mm/cb/a:getDensity	(Landroid/content/Context;)F
    //   1664: invokestatic 101	com/tencent/mm/pluginsdk/model/app/g:b	(Ljava/lang/String;IF)Landroid/graphics/Bitmap;
    //   1667: astore_2
    //   1668: goto -185 -> 1483
    //   1671: getstatic 184	com/tencent/mm/pluginsdk/model/app/f:rUa	Ljava/lang/String;
    //   1674: aload 9
    //   1676: getfield 86	com/tencent/mm/pluginsdk/model/app/f:field_appId	Ljava/lang/String;
    //   1679: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1682: ifeq +16 -> 1698
    //   1685: aload_3
    //   1686: getfield 105	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hic	Landroid/widget/ImageView;
    //   1689: getstatic 243	com/tencent/mm/R$g:panel_icon_transfer	I
    //   1692: invokevirtual 246	android/widget/ImageView:setImageResource	(I)V
    //   1695: goto -193 -> 1502
    //   1698: getstatic 249	com/tencent/mm/pluginsdk/model/app/f:rUc	Ljava/lang/String;
    //   1701: aload 9
    //   1703: getfield 86	com/tencent/mm/pluginsdk/model/app/f:field_appId	Ljava/lang/String;
    //   1706: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1709: ifeq +16 -> 1725
    //   1712: aload_3
    //   1713: getfield 105	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hic	Landroid/widget/ImageView;
    //   1716: getstatic 252	com/tencent/mm/R$g:panel_icon_luckymoney	I
    //   1719: invokevirtual 246	android/widget/ImageView:setImageResource	(I)V
    //   1722: goto -220 -> 1502
    //   1725: getstatic 255	com/tencent/mm/pluginsdk/model/app/f:rUb	Ljava/lang/String;
    //   1728: aload 9
    //   1730: getfield 86	com/tencent/mm/pluginsdk/model/app/f:field_appId	Ljava/lang/String;
    //   1733: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1736: ifeq +16 -> 1752
    //   1739: aload_3
    //   1740: getfield 105	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hic	Landroid/widget/ImageView;
    //   1743: getstatic 258	com/tencent/mm/R$g:panel_icon_card	I
    //   1746: invokevirtual 246	android/widget/ImageView:setImageResource	(I)V
    //   1749: goto -247 -> 1502
    //   1752: getstatic 261	com/tencent/mm/pluginsdk/model/app/f:rUd	Ljava/lang/String;
    //   1755: aload 9
    //   1757: getfield 86	com/tencent/mm/pluginsdk/model/app/f:field_appId	Ljava/lang/String;
    //   1760: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1763: ifeq +16 -> 1779
    //   1766: aload_3
    //   1767: getfield 105	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hic	Landroid/widget/ImageView;
    //   1770: getstatic 266	com/tencent/mm/R$k:panel_icon_aa	I
    //   1773: invokevirtual 246	android/widget/ImageView:setImageResource	(I)V
    //   1776: goto -274 -> 1502
    //   1779: aload_3
    //   1780: getfield 105	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hic	Landroid/widget/ImageView;
    //   1783: getstatic 269	com/tencent/mm/R$g:app_panel_icon_unknowed	I
    //   1786: invokevirtual 558	android/widget/ImageView:setBackgroundResource	(I)V
    //   1789: goto -287 -> 1502
    //   1792: aload_3
    //   1793: getfield 105	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hic	Landroid/widget/ImageView;
    //   1796: getstatic 272	com/tencent/mm/R$g:sharemore_nosdcard_icon	I
    //   1799: invokevirtual 558	android/widget/ImageView:setBackgroundResource	(I)V
    //   1802: goto -300 -> 1502
    //   1805: astore_2
    //   1806: goto -1466 -> 340
    //   1809: astore_2
    //   1810: goto -1470 -> 340
    //   1813: astore_2
    //   1814: goto -1474 -> 340
    //   1817: astore_2
    //   1818: goto -1478 -> 340
    //   1821: astore_2
    //   1822: goto -1482 -> 340
    //   1825: astore_2
    //   1826: goto -1486 -> 340
    //   1829: astore_2
    //   1830: goto -1490 -> 340
    //   1833: astore_2
    //   1834: goto -1494 -> 340
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1837	0	this	a
    //   0	1837	1	paramInt	int
    //   0	1837	2	paramView	android.view.View
    //   0	1837	3	paramViewGroup	android.view.ViewGroup
    //   225	28	4	i	int
    //   241	15	5	j	int
    //   1097	31	6	bool1	boolean
    //   1125	21	7	bool2	boolean
    //   27	351	8	localView	android.view.View
    //   1437	319	9	localf	f
    // Exception table:
    //   from	to	target	type
    //   1347	1356	1359	java/lang/Exception
    //   445	481	1805	java/lang/Exception
    //   484	493	1805	java/lang/Exception
    //   526	562	1809	java/lang/Exception
    //   565	574	1809	java/lang/Exception
    //   712	749	1813	java/lang/Exception
    //   752	761	1813	java/lang/Exception
    //   794	831	1817	java/lang/Exception
    //   834	843	1817	java/lang/Exception
    //   909	945	1821	java/lang/Exception
    //   948	957	1821	java/lang/Exception
    //   990	1026	1825	java/lang/Exception
    //   1029	1038	1825	java/lang/Exception
    //   1071	1127	1829	java/lang/Exception
    //   1137	1145	1829	java/lang/Exception
    //   1150	1160	1829	java/lang/Exception
    //   1163	1173	1829	java/lang/Exception
    //   1176	1185	1829	java/lang/Exception
    //   1266	1302	1833	java/lang/Exception
    //   1305	1314	1833	java/lang/Exception
  }
  
  public final f zn(int paramInt)
  {
    if (((paramInt < AppGrid.g(this.sdG)) && (AppGrid.a(this.sdG) == 0)) || (AppGrid.a(this.sdG) * AppGrid.b(this.sdG) + paramInt < AppGrid.g(this.sdG)) || (paramInt - AppGrid.g(this.sdG) + AppGrid.a(this.sdG) * AppGrid.b(this.sdG) >= this.ePL.size())) {
      return null;
    }
    paramInt = paramInt - AppGrid.g(this.sdG) + AppGrid.a(this.sdG) * AppGrid.b(this.sdG);
    y.v("MicroMsg.AppGrid", "get item db pos: %d", new Object[] { Integer.valueOf(paramInt) });
    return (f)this.ePL.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.AppGrid.a
 * JD-Core Version:    0.7.0.1
 */