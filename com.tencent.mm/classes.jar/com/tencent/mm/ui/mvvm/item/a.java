package com.tencent.mm.ui.mvvm.item;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.TextAppearanceSpan;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.ui.o;
import com.tencent.mm.plugin.selectcontact.a.b;
import com.tencent.mm.plugin.selectcontact.a.c;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.recyclerview.f;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/mvvm/item/SelectContactItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/ui/mvvm/item/SelectContactLiveItem;", "()V", "findTagString", "", "tags", "", "ftsQuery", "Lcom/tencent/mm/plugin/fts/api/model/FTSQuery;", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "toEmoji", "Landroid/text/SpannableString;", "context", "Landroid/content/Context;", "origin", "sizeInPx", "Companion", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends f<b>
{
  public static final a.a afAL;
  
  static
  {
    AppMethodBeat.i(250573);
    afAL = new a.a((byte)0);
    AppMethodBeat.o(250573);
  }
  
  private static String a(List<String> paramList, com.tencent.mm.plugin.fts.a.a.j paramj)
  {
    AppMethodBeat.i(250550);
    StringBuffer localStringBuffer = new StringBuffer();
    paramj = paramj.Htg;
    s.s(paramj, "ftsQuery.phrases");
    int j = paramj.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Object localObject1 = paramj[i];
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Object localObject2 = d.aEh(str);
          s.s(localObject2, "preProcessTag");
          localObject2 = (CharSequence)localObject2;
          s.s(localObject1, "keyword");
          if (n.i((CharSequence)localObject2, (CharSequence)localObject1))
          {
            localStringBuffer.append(str);
            localStringBuffer.append(",");
          }
        }
      }
      localStringBuffer.trimToSize();
      if (((CharSequence)localStringBuffer).length() == 0) {}
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(250550);
        return "";
      }
      paramList = localStringBuffer.substring(0, localStringBuffer.length() - 1);
      AppMethodBeat.o(250550);
      return paramList;
      i += 1;
    }
  }
  
  private static final void a(TextView paramTextView, String paramString, Context paramContext, ah.f paramf)
  {
    AppMethodBeat.i(250565);
    s.u(paramf, "$nickname");
    try
    {
      localObject = paramTextView.getParent();
      if (localObject == null)
      {
        paramTextView = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(250565);
        throw paramTextView;
      }
    }
    catch (Exception paramTextView)
    {
      Log.e("MicroMsg.Mvvm.SelectContactItemConvert", "fillingViewItem Exception:%s %s", new Object[] { paramTextView.getClass().getSimpleName(), paramTextView.getMessage() });
      AppMethodBeat.o(250565);
      return;
    }
    int i = ((ViewGroup)localObject).getMeasuredWidth();
    if (i == 0)
    {
      AppMethodBeat.o(250565);
      return;
    }
    paramString = s.X("@", paramString);
    int j = com.tencent.mm.cd.a.br(paramContext, a.c.DescTextSize);
    Object localObject = new TextView(paramContext);
    ((TextView)localObject).getPaint().setTextSize(j);
    float f = ((TextView)localObject).getPaint().measureText(s.X(" ", paramString));
    ((TextView)localObject).getPaint().setTextSize(paramTextView.getTextSize());
    if (f >= i * 0.6D)
    {
      paramf = TextUtils.ellipsize((CharSequence)paramf.aqH, ((TextView)localObject).getPaint(), (float)(i * 0.4D), TextUtils.TruncateAt.END);
      s.s(paramf, "ellipsize(nickname, text…TextUtils.TruncateAt.END)");
      f = ((TextView)localObject).getPaint().measureText(paramf.toString());
      ((TextView)localObject).getPaint().setTextSize(j);
      paramString = TextUtils.ellipsize((CharSequence)paramString, ((TextView)localObject).getPaint(), i - f - 20.0F, TextUtils.TruncateAt.END);
      s.s(paramString, "ellipsize(openIMWording,…TextUtils.TruncateAt.END)");
    }
    for (;;)
    {
      localObject = p.b(paramContext, (CharSequence)(paramf + ' ' + paramString));
      paramContext = com.tencent.mm.cd.a.l(paramContext, a.b.openim_desc_text_color);
      ((SpannableString)localObject).setSpan(new TextAppearanceSpan(null, 0, j, paramContext, paramContext), paramf.length() + 1, paramf.length() + 1 + paramString.length(), 33);
      ((SpannableString)localObject).setSpan(new com.tencent.mm.cg.a(j), paramf.length() + 1, paramf.length() + 1 + paramString.length(), 33);
      o.a((CharSequence)localObject, paramTextView);
      AppMethodBeat.o(250565);
      return;
      paramf = TextUtils.ellipsize((CharSequence)paramf.aqH, ((TextView)localObject).getPaint(), i - f, TextUtils.TruncateAt.END);
      s.s(paramf, "ellipsize(nickname, text…TextUtils.TruncateAt.END)");
      paramString = (CharSequence)paramString;
    }
  }
  
  private static SpannableString o(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(250540);
    paramContext = p.d(paramContext, (CharSequence)paramString, paramInt);
    AppMethodBeat.o(250540);
    return paramContext;
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.j paramj, int paramInt)
  {
    AppMethodBeat.i(250590);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(250590);
  }
  
  public final int getLayoutId()
  {
    AppMethodBeat.i(250588);
    if (com.tencent.mm.cd.a.mp(MMApplicationContext.getContext()))
    {
      i = a.f.mvvm_select_ui_listcontactitem_large;
      AppMethodBeat.o(250588);
      return i;
    }
    int i = a.f.mvvm_select_ui_listcontactitem;
    AppMethodBeat.o(250588);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.mvvm.item.a
 * JD-Core Version:    0.7.0.1
 */