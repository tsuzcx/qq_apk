package com.tencent.mm.plugin.textstatus.k;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.plugin.textstatus.a.a.a;
import com.tencent.mm.plugin.textstatus.a.a.b;
import com.tencent.mm.plugin.textstatus.a.a.c;
import com.tencent.mm.plugin.textstatus.b.b;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.au;
import java.util.ArrayList;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/util/IStatusIconHelper;", "", "()V", "getCustomStatusName", "", "getDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lkotlin/collections/ArrayList;", "getDrawable", "Landroid/graphics/drawable/Drawable;", "bitmap", "Landroid/graphics/Bitmap;", "isUseOriginal", "", "iconType", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconType;", "iconColor", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconColor;", "getIconSpan", "Landroid/text/style/ImageSpan;", "attachView", "Landroid/view/View;", "id", "iconScene", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;", "size", "", "item", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "getName", "getNameByInfo", "topicInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "getResVersion", "", "getTextStatusSpanSync", "textView", "Landroid/widget/TextView;", "userName", "handleIconConfigResult", "", "rsp", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetIconConfigResp;", "isIconValidForSet", "onCreate", "onDestroy", "refreshTextStatusSpan", "", "username", "displayName", "textSize", "reqNewestIconConfig", "setCustomStatusName", "name", "setIcon", "iv", "Landroid/widget/ImageView;", "iconId", "plugin-textstatus_release"})
public abstract class a
{
  public static Drawable a(Bitmap paramBitmap, boolean paramBoolean, a.c paramc, a.a parama)
  {
    kotlin.g.b.p.k(paramc, "iconType");
    kotlin.g.b.p.k(parama, "iconColor");
    paramBitmap = (Drawable)new BitmapDrawable(paramBitmap);
    if (paramBoolean) {
      return paramBitmap;
    }
    switch (b.tKM[paramc.ordinal()])
    {
    default: 
      switch (b.jLJ[parama.ordinal()])
      {
      }
      break;
    }
    for (int i = MMApplicationContext.getResources().getColor(b.b.White);; i = MMApplicationContext.getResources().getColor(b.b.FG_1))
    {
      paramBitmap = au.e(paramBitmap, i);
      kotlin.g.b.p.j(paramBitmap, "WeUIColorHelper.getColorDrawable(drawable, color)");
      return paramBitmap;
      switch (b.$EnumSwitchMapping$0[parama.ordinal()])
      {
      default: 
        i = MMApplicationContext.getResources().getColor(b.b.UN_Link);
      }
      for (;;)
      {
        int j = Color.alpha(i);
        if (j != 0) {
          paramBitmap.setAlpha(j);
        }
        paramBitmap = au.e(paramBitmap, i);
        kotlin.g.b.p.j(paramBitmap, "WeUIColorHelper.getColorDrawable(drawable, color)");
        return paramBitmap;
        i = -1;
        continue;
        i = MMApplicationContext.getResources().getColor(b.b.BW_0_Alpha_0_2);
      }
    }
  }
  
  public static CharSequence a(View paramView, String paramString, CharSequence paramCharSequence, int paramInt, a.c paramc, a.b paramb)
  {
    kotlin.g.b.p.k(paramc, "iconType");
    kotlin.g.b.p.k(paramb, "iconScene");
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (n.ba((CharSequence)localObject)))
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
    i = 0;
    localObject = f.MAm;
    com.tencent.mm.plugin.textstatus.g.e.a locala = f.bep(paramString);
    localObject = new SpannableStringBuilder(paramCharSequence);
    if (paramCharSequence != null) {}
    for (paramString = Integer.valueOf(paramCharSequence.length());; paramString = null)
    {
      paramString = (k[])((SpannableStringBuilder)localObject).getSpans(0, paramString.intValue(), k.class);
      int k = paramString.length;
      int j = 0;
      while (j < k)
      {
        ((SpannableStringBuilder)localObject).removeSpan(paramString[j]);
        i = 1;
        j += 1;
      }
    }
    if (locala != null) {
      if (locala.glZ())
      {
        paramString = a.a.Mzw;
        paramView = c.gnz().a(paramView, locala.field_IconID, paramc, paramString, paramb, paramInt, locala);
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
        paramString = a.a.Mzt;
        break;
      }
      return null;
    }
  }
  
  public abstract ImageSpan a(View paramView, String paramString, a.c paramc, a.a parama, a.b paramb, int paramInt, com.tencent.mm.plugin.textstatus.g.e.a parama1);
  
  public abstract void a(ImageView paramImageView, String paramString, a.c paramc, a.a parama, com.tencent.mm.plugin.textstatus.g.e.a parama1);
  
  public abstract void a(com.tencent.mm.plugin.textstatus.proto.p paramp);
  
  public abstract boolean beI(String paramString);
  
  public abstract String beJ(String paramString);
  
  public abstract String d(TextStatusTopicInfo paramTextStatusTopicInfo);
  
  public abstract ArrayList<com.tencent.mm.view.recyclerview.a> getDataList();
  
  public abstract long getResVersion();
  
  public abstract void gnx();
  
  public void onCreate()
  {
    c.gnA().alive();
    c.gnB().alive();
  }
  
  public void onDestroy()
  {
    c.gnA().dead();
    c.gnB().dead();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.k.a
 * JD-Core Version:    0.7.0.1
 */