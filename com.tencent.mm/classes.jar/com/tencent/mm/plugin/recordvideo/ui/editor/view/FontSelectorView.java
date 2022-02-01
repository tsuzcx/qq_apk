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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import d.a.j;
import d.g.b.p;
import d.l;
import d.n.n;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/FontSelectorView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "configList", "Ljava/util/ArrayList;", "Lorg/json/JSONObject;", "Lkotlin/collections/ArrayList;", "fontSelectCallback", "Lkotlin/Function1;", "", "", "getFontSelectCallback", "()Lkotlin/jvm/functions/Function1;", "setFontSelectCallback", "(Lkotlin/jvm/functions/Function1;)V", "fontSelectViewList", "Landroid/view/View;", "initFontResource", "initFontSelectView", "onFontSelect", "index", "selectFontViewState", "setSelectFont", "font", "Companion", "plugin-recordvideo_release"})
public final class FontSelectorView
  extends LinearLayout
{
  private static final String TAG = "MicroMsg.FontSelectorView";
  public static final a xQU;
  private final ArrayList<View> xQR;
  private ArrayList<JSONObject> xQS;
  private d.g.a.b<? super String, z> xQT;
  
  static
  {
    AppMethodBeat.i(200863);
    xQU = new a((byte)0);
    TAG = "MicroMsg.FontSelectorView";
    AppMethodBeat.o(200863);
  }
  
  public FontSelectorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FontSelectorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(200862);
    this.xQR = new ArrayList();
    this.xQS = new ArrayList();
    setOrientation(0);
    setGravity(16);
    dIn();
    AppMethodBeat.o(200862);
  }
  
  private final void NU(int paramInt)
  {
    AppMethodBeat.i(200860);
    Object localObject1 = (Iterable)this.xQR;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      int j = i + 1;
      if (i < 0) {
        j.gfB();
      }
      localObject2 = (View)localObject2;
      if (i == paramInt)
      {
        ((View)localObject2).setBackground(getContext().getDrawable(2131235055));
        i = j;
      }
      else
      {
        ((View)localObject2).setBackground(getContext().getDrawable(2131235054));
        i = j;
      }
    }
    AppMethodBeat.o(200860);
  }
  
  private final void dIn()
  {
    AppMethodBeat.i(200858);
    if (e.xHB.xHn)
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("name", com.tencent.mm.cc.a.az(getContext(), 2131767054));
      ((JSONObject)localObject).put("key", "");
      ((JSONObject)localObject).put("path", "");
      this.xQS.add(localObject);
      localObject = e.xHB.dGY();
      if (localObject != null)
      {
        int i = 0;
        int j = ((JSONArray)localObject).length();
        while (i < j)
        {
          this.xQS.add(((JSONArray)localObject).optJSONObject(i));
          i += 1;
        }
      }
      dIo();
    }
    AppMethodBeat.o(200858);
  }
  
  private final void dIo()
  {
    AppMethodBeat.i(200859);
    try
    {
      Iterator localIterator = ((Iterable)this.xQS).iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        localObject1 = localIterator.next();
        if (i < 0) {
          j.gfB();
        }
        localObject1 = (JSONObject)localObject1;
        TextView localTextView = new TextView(getContext());
        Object localObject2 = ((JSONObject)localObject1).optString("name");
        if (TextUtils.isEmpty((CharSequence)((JSONObject)localObject1).optString("path"))) {}
        for (localObject1 = "";; localObject1 = e.xHB.dGV() + ((JSONObject)localObject1).optString("path"))
        {
          localTextView.setText((CharSequence)localObject2);
          if (i.fv((String)localObject1)) {
            localTextView.setTypeface(Typeface.createFromFile((String)localObject1));
          }
          localTextView.setBackground(getContext().getDrawable(2131235054));
          localObject1 = getContext();
          p.g(localObject1, "context");
          localTextView.setTextColor(((Context)localObject1).getResources().getColor(2131099684));
          localObject1 = getContext();
          p.g(localObject1, "context");
          localTextView.setTextSize(0, ((Context)localObject1).getResources().getDimensionPixelSize(2131165289));
          localObject1 = new LinearLayout.LayoutParams(-2, -2);
          localObject2 = getContext();
          p.g(localObject2, "context");
          ((LinearLayout.LayoutParams)localObject1).width = ((Context)localObject2).getResources().getDimensionPixelSize(2131165301);
          ((LinearLayout.LayoutParams)localObject1).height = com.tencent.mm.cc.a.fromDPToPix(getContext(), 30);
          if (i != this.xQS.size() - 1)
          {
            localObject2 = getContext();
            p.g(localObject2, "context");
            ((LinearLayout.LayoutParams)localObject1).setMarginEnd(((Context)localObject2).getResources().getDimensionPixelSize(2131165294));
          }
          localTextView.setGravity(17);
          addView((View)localTextView, (ViewGroup.LayoutParams)localObject1);
          this.xQR.add(localTextView);
          localTextView.setTag(Integer.valueOf(i));
          localTextView.setOnClickListener((View.OnClickListener)new b(this));
          i += 1;
          break;
        }
      }
      Object localObject1 = this.xQR.get(0);
      p.g(localObject1, "fontSelectViewList[0]");
      ((View)localObject1).setBackground(getContext().getDrawable(2131235055));
      AppMethodBeat.o(200859);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace(TAG, (Throwable)localException, "parse font error", new Object[0]);
      AppMethodBeat.o(200859);
    }
  }
  
  public final d.g.a.b<String, z> getFontSelectCallback()
  {
    return this.xQT;
  }
  
  public final void setFontSelectCallback(d.g.a.b<? super String, z> paramb)
  {
    this.xQT = paramb;
  }
  
  public final void setSelectFont(String paramString)
  {
    AppMethodBeat.i(200861);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      NU(0);
      AppMethodBeat.o(200861);
      return;
    }
    Iterator localIterator = ((Iterable)this.xQS).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      int j = i + 1;
      if (i < 0) {
        j.gfB();
      }
      Object localObject2 = (JSONObject)localObject1;
      if (paramString != null)
      {
        localObject1 = (CharSequence)paramString;
        localObject2 = ((JSONObject)localObject2).optString("path");
        p.g(localObject2, "jsonObject.optString(\"path\")");
        if (n.a((CharSequence)localObject1, (CharSequence)localObject2, false) == true) {
          NU(i);
        }
        i = j;
      }
      else
      {
        i = j;
      }
    }
    AppMethodBeat.o(200861);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/FontSelectorView$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/recordvideo/ui/editor/view/FontSelectorView$initFontSelectView$1$1"})
  static final class b
    implements View.OnClickListener
  {
    b(FontSelectorView paramFontSelectorView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(200857);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/view/FontSelectorView$initFontSelectView$$inlined$forEachIndexed$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      localObject = this.xQV;
      p.g(paramView, "it");
      paramView = paramView.getTag();
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(200857);
        throw paramView;
      }
      FontSelectorView.a((FontSelectorView)localObject, ((Integer)paramView).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/view/FontSelectorView$initFontSelectView$$inlined$forEachIndexed$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(200857);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.view.FontSelectorView
 * JD-Core Version:    0.7.0.1
 */