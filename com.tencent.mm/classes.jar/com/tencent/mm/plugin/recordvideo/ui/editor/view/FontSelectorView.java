package com.tencent.mm.plugin.recordvideo.ui.editor.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.b.b;
import com.tencent.mm.plugin.recordvideo.b.c;
import com.tencent.mm.plugin.recordvideo.b.d;
import com.tencent.mm.plugin.recordvideo.b.h;
import com.tencent.mm.plugin.recordvideo.res.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/FontSelectorView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "configList", "Ljava/util/ArrayList;", "Lorg/json/JSONObject;", "Lkotlin/collections/ArrayList;", "fontSelectCallback", "Lkotlin/Function1;", "", "", "getFontSelectCallback", "()Lkotlin/jvm/functions/Function1;", "setFontSelectCallback", "(Lkotlin/jvm/functions/Function1;)V", "fontSelectViewList", "Landroid/view/View;", "initFontResource", "initFontSelectView", "onFontSelect", "index", "selectFontViewState", "setSelectFont", "font", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FontSelectorView
  extends LinearLayout
{
  public static final FontSelectorView.a OaX;
  private static final String TAG;
  private final ArrayList<View> OaY;
  private ArrayList<JSONObject> OaZ;
  private kotlin.g.a.b<? super String, ah> Oba;
  
  static
  {
    AppMethodBeat.i(280101);
    OaX = new FontSelectorView.a((byte)0);
    TAG = "MicroMsg.FontSelectorView";
    AppMethodBeat.o(280101);
  }
  
  public FontSelectorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FontSelectorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(280019);
    this.OaY = new ArrayList();
    this.OaZ = new ArrayList();
    setOrientation(0);
    setGravity(16);
    gKZ();
    AppMethodBeat.o(280019);
  }
  
  private static final void a(FontSelectorView paramFontSelectorView, View paramView)
  {
    AppMethodBeat.i(280092);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFontSelectorView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/ui/editor/view/FontSelectorView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFontSelectorView, "this$0");
    paramView = paramView.getTag();
    if (paramView == null)
    {
      paramFontSelectorView = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(280092);
      throw paramFontSelectorView;
    }
    paramFontSelectorView.aha(((Integer)paramView).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/recordvideo/ui/editor/view/FontSelectorView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(280092);
  }
  
  private final void aha(int paramInt)
  {
    AppMethodBeat.i(280058);
    ahb(paramInt);
    kotlin.g.a.b localb = this.Oba;
    if (localb != null) {
      localb.invoke(s.X(e.NRR.gJs(), ((JSONObject)this.OaZ.get(paramInt)).optString("path")));
    }
    AppMethodBeat.o(280058);
  }
  
  private final void ahb(int paramInt)
  {
    AppMethodBeat.i(280073);
    Object localObject1 = (Iterable)this.OaY;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      int j = i + 1;
      if (i < 0) {
        p.kkW();
      }
      localObject2 = (View)localObject2;
      if (i == paramInt)
      {
        ((View)localObject2).setBackground(getContext().getDrawable(b.d.font_select_background_enable));
        i = j;
      }
      else
      {
        ((View)localObject2).setBackground(getContext().getDrawable(b.d.font_select_background_disable));
        i = j;
      }
    }
    AppMethodBeat.o(280073);
  }
  
  private final void gKZ()
  {
    AppMethodBeat.i(280034);
    Object localObject;
    int i;
    int k;
    if (e.NRR.NRG)
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("name", com.tencent.mm.cd.a.bt(getContext(), b.h.font_select_default));
      ((JSONObject)localObject).put("key", "default");
      ((JSONObject)localObject).put("path", "default");
      this.OaZ.add(localObject);
      localObject = e.NRR.gJv();
      if (localObject != null)
      {
        i = 0;
        k = ((JSONArray)localObject).length();
        if (k <= 0) {}
      }
    }
    for (;;)
    {
      int j = i + 1;
      this.OaZ.add(((JSONArray)localObject).optJSONObject(i));
      if (j >= k)
      {
        gLa();
        AppMethodBeat.o(280034);
        return;
      }
      i = j;
    }
  }
  
  private final void gLa()
  {
    AppMethodBeat.i(280049);
    try
    {
      Iterator localIterator = ((Iterable)this.OaZ).iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        Object localObject1 = localIterator.next();
        if (i < 0) {
          p.kkW();
        }
        localObject1 = (JSONObject)localObject1;
        TextView localTextView = new TextView(getContext());
        String str = ((JSONObject)localObject1).optString("name");
        if (TextUtils.isEmpty((CharSequence)((JSONObject)localObject1).optString("path")))
        {
          localObject1 = "";
          label90:
          localTextView.setText((CharSequence)str);
          Object localObject2 = am.aixg;
          localObject2 = com.tencent.mm.cd.a.bt(getContext(), b.h.aging_font_button);
          s.s(localObject2, "getString(context, R.string.aging_font_button)");
          str = String.format((String)localObject2, Arrays.copyOf(new Object[] { str }, 1));
          s.s(str, "java.lang.String.format(format, *args)");
          localTextView.setContentDescription((CharSequence)str);
          if (!y.ZC((String)localObject1)) {
            break label382;
          }
          localTextView.setTypeface(Typeface.createFromFile((String)localObject1));
        }
        for (;;)
        {
          localTextView.setBackground(getContext().getDrawable(b.d.font_select_background_disable));
          localTextView.setTextColor(getContext().getResources().getColor(b.b.BW_BG_100));
          localTextView.setTextSize(0, getContext().getResources().getDimensionPixelSize(b.c.Edge_2A));
          localObject1 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject1).width = getContext().getResources().getDimensionPixelSize(b.c.Edge_8A);
          ((LinearLayout.LayoutParams)localObject1).height = com.tencent.mm.cd.a.fromDPToPix(getContext(), 30);
          if (i != this.OaZ.size() - 1) {
            ((LinearLayout.LayoutParams)localObject1).setMarginEnd(getContext().getResources().getDimensionPixelSize(b.c.Edge_4A));
          }
          localTextView.setGravity(17);
          addView((View)localTextView, (ViewGroup.LayoutParams)localObject1);
          this.OaY.add(localTextView);
          localTextView.setTag(Integer.valueOf(i));
          localTextView.setOnClickListener(new FontSelectorView..ExternalSyntheticLambda0(this));
          i += 1;
          break;
          localObject1 = s.X(e.NRR.gJs(), ((JSONObject)localObject1).optString("path"));
          break label90;
          label382:
          localTextView.setTypeface(Typeface.DEFAULT);
        }
      }
      ((View)this.OaY.get(0)).setBackground(getContext().getDrawable(b.d.font_select_background_enable));
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(TAG, (Throwable)localException, "parse font error", new Object[0]);
      AppMethodBeat.o(280049);
      return;
    }
    AppMethodBeat.o(280049);
  }
  
  public final kotlin.g.a.b<String, ah> getFontSelectCallback()
  {
    return this.Oba;
  }
  
  public final void setFontSelectCallback(kotlin.g.a.b<? super String, ah> paramb)
  {
    this.Oba = paramb;
  }
  
  public final void setSelectFont(String paramString)
  {
    AppMethodBeat.i(280131);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      ahb(0);
      AppMethodBeat.o(280131);
      return;
    }
    Iterator localIterator = ((Iterable)this.OaZ).iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      if (i < 0) {
        p.kkW();
      }
      Object localObject2 = (JSONObject)localObject1;
      if (paramString != null)
      {
        localObject1 = (CharSequence)paramString;
        localObject2 = ((JSONObject)localObject2).optString("path");
        s.s(localObject2, "jsonObject.optString(\"path\")");
        if (n.a((CharSequence)localObject1, (CharSequence)localObject2, false) != true) {}
      }
      for (int j = 1;; j = 0)
      {
        if (j != 0) {
          ahb(i);
        }
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(280131);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.view.FontSelectorView
 * JD-Core Version:    0.7.0.1
 */