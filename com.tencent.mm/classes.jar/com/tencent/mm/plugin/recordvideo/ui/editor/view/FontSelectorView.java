package com.tencent.mm.plugin.recordvideo.ui.editor.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.res.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/FontSelectorView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "configList", "Ljava/util/ArrayList;", "Lorg/json/JSONObject;", "Lkotlin/collections/ArrayList;", "fontSelectCallback", "Lkotlin/Function1;", "", "", "getFontSelectCallback", "()Lkotlin/jvm/functions/Function1;", "setFontSelectCallback", "(Lkotlin/jvm/functions/Function1;)V", "fontSelectViewList", "Landroid/view/View;", "initFontResource", "initFontSelectView", "onFontSelect", "index", "selectFontViewState", "setSelectFont", "font", "Companion", "plugin-recordvideo_release"})
public final class FontSelectorView
  extends LinearLayout
{
  public static final a ChK;
  private static final String TAG = "MicroMsg.FontSelectorView";
  private final ArrayList<View> ChH;
  private ArrayList<JSONObject> ChI;
  private kotlin.g.a.b<? super String, x> ChJ;
  
  static
  {
    AppMethodBeat.i(237962);
    ChK = new a((byte)0);
    TAG = "MicroMsg.FontSelectorView";
    AppMethodBeat.o(237962);
  }
  
  public FontSelectorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FontSelectorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(237961);
    this.ChH = new ArrayList();
    this.ChI = new ArrayList();
    setOrientation(0);
    setGravity(16);
    eMC();
    AppMethodBeat.o(237961);
  }
  
  private final void VV(int paramInt)
  {
    AppMethodBeat.i(237959);
    Object localObject1 = (Iterable)this.ChH;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      int j = i + 1;
      if (i < 0) {
        j.hxH();
      }
      localObject2 = (View)localObject2;
      if (i == paramInt)
      {
        ((View)localObject2).setBackground(getContext().getDrawable(2131232804));
        i = j;
      }
      else
      {
        ((View)localObject2).setBackground(getContext().getDrawable(2131232803));
        i = j;
      }
    }
    AppMethodBeat.o(237959);
  }
  
  private final void eMC()
  {
    AppMethodBeat.i(237957);
    if (e.BYn.BXZ)
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("name", com.tencent.mm.cb.a.aI(getContext(), 2131760904));
      ((JSONObject)localObject).put("key", "default");
      ((JSONObject)localObject).put("path", "default");
      this.ChI.add(localObject);
      localObject = e.BYn.eLn();
      if (localObject != null)
      {
        int i = 0;
        int j = ((JSONArray)localObject).length();
        while (i < j)
        {
          this.ChI.add(((JSONArray)localObject).optJSONObject(i));
          i += 1;
        }
      }
      eMD();
    }
    AppMethodBeat.o(237957);
  }
  
  private final void eMD()
  {
    AppMethodBeat.i(237958);
    try
    {
      Iterator localIterator = ((Iterable)this.ChI).iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        Object localObject1 = localIterator.next();
        if (i < 0) {
          j.hxH();
        }
        localObject1 = (JSONObject)localObject1;
        TextView localTextView = new TextView(getContext());
        Object localObject3 = ((JSONObject)localObject1).optString("name");
        if (TextUtils.isEmpty((CharSequence)((JSONObject)localObject1).optString("path")))
        {
          localObject1 = "";
          label87:
          localTextView.setText((CharSequence)localObject3);
          if (!s.YS((String)localObject1)) {
            break label373;
          }
          localTextView.setTypeface(Typeface.createFromFile((String)localObject1));
        }
        for (;;)
        {
          localTextView.setBackground(getContext().getDrawable(2131232803));
          localObject1 = getContext();
          p.g(localObject1, "context");
          localTextView.setTextColor(((Context)localObject1).getResources().getColor(2131099694));
          localObject1 = getContext();
          p.g(localObject1, "context");
          localTextView.setTextSize(0, ((Context)localObject1).getResources().getDimensionPixelSize(2131165296));
          localObject1 = new LinearLayout.LayoutParams(-2, -2);
          localObject3 = getContext();
          p.g(localObject3, "context");
          ((LinearLayout.LayoutParams)localObject1).width = ((Context)localObject3).getResources().getDimensionPixelSize(2131165312);
          ((LinearLayout.LayoutParams)localObject1).height = com.tencent.mm.cb.a.fromDPToPix(getContext(), 30);
          if (i != this.ChI.size() - 1)
          {
            localObject3 = getContext();
            p.g(localObject3, "context");
            ((LinearLayout.LayoutParams)localObject1).setMarginEnd(((Context)localObject3).getResources().getDimensionPixelSize(2131165303));
          }
          localTextView.setGravity(17);
          addView((View)localTextView, (ViewGroup.LayoutParams)localObject1);
          this.ChH.add(localTextView);
          localTextView.setTag(Integer.valueOf(i));
          localTextView.setOnClickListener((View.OnClickListener)new b(this));
          i += 1;
          break;
          localObject1 = e.BYn.eLk() + ((JSONObject)localObject1).optString("path");
          break label87;
          label373:
          localTextView.setTypeface(Typeface.DEFAULT);
        }
      }
      localObject2 = this.ChH.get(0);
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(TAG, (Throwable)localException, "parse font error", new Object[0]);
      AppMethodBeat.o(237958);
      return;
    }
    Object localObject2;
    p.g(localObject2, "fontSelectViewList[0]");
    ((View)localObject2).setBackground(getContext().getDrawable(2131232804));
    AppMethodBeat.o(237958);
  }
  
  public final kotlin.g.a.b<String, x> getFontSelectCallback()
  {
    return this.ChJ;
  }
  
  public final void setFontSelectCallback(kotlin.g.a.b<? super String, x> paramb)
  {
    this.ChJ = paramb;
  }
  
  public final void setSelectFont(String paramString)
  {
    AppMethodBeat.i(237960);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      VV(0);
      AppMethodBeat.o(237960);
      return;
    }
    Iterator localIterator = ((Iterable)this.ChI).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      int j = i + 1;
      if (i < 0) {
        j.hxH();
      }
      Object localObject2 = (JSONObject)localObject1;
      if (paramString != null)
      {
        localObject1 = (CharSequence)paramString;
        localObject2 = ((JSONObject)localObject2).optString("path");
        p.g(localObject2, "jsonObject.optString(\"path\")");
        if (n.a((CharSequence)localObject1, (CharSequence)localObject2, false) == true) {
          VV(i);
        }
        i = j;
      }
      else
      {
        i = j;
      }
    }
    AppMethodBeat.o(237960);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/FontSelectorView$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/recordvideo/ui/editor/view/FontSelectorView$initFontSelectView$1$1"})
  static final class b
    implements View.OnClickListener
  {
    b(FontSelectorView paramFontSelectorView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(237956);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/view/FontSelectorView$initFontSelectView$$inlined$forEachIndexed$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      localObject = this.ChL;
      p.g(paramView, "it");
      paramView = paramView.getTag();
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(237956);
        throw paramView;
      }
      FontSelectorView.a((FontSelectorView)localObject, ((Integer)paramView).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/view/FontSelectorView$initFontSelectView$$inlined$forEachIndexed$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(237956);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.view.FontSelectorView
 * JD-Core Version:    0.7.0.1
 */