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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/FontSelectorView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "configList", "Ljava/util/ArrayList;", "Lorg/json/JSONObject;", "Lkotlin/collections/ArrayList;", "fontSelectCallback", "Lkotlin/Function1;", "", "", "getFontSelectCallback", "()Lkotlin/jvm/functions/Function1;", "setFontSelectCallback", "(Lkotlin/jvm/functions/Function1;)V", "fontSelectViewList", "Landroid/view/View;", "initFontResource", "initFontSelectView", "onFontSelect", "index", "selectFontViewState", "setSelectFont", "font", "Companion", "plugin-recordvideo_release"})
public final class FontSelectorView
  extends LinearLayout
{
  private static final String TAG = "MicroMsg.FontSelectorView";
  public static final a ygN;
  private final ArrayList<View> ygK;
  private ArrayList<JSONObject> ygL;
  private d.g.a.b<? super String, z> ygM;
  
  static
  {
    AppMethodBeat.i(207121);
    ygN = new a((byte)0);
    TAG = "MicroMsg.FontSelectorView";
    AppMethodBeat.o(207121);
  }
  
  public FontSelectorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FontSelectorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(207120);
    this.ygK = new ArrayList();
    this.ygL = new ArrayList();
    setOrientation(0);
    setGravity(16);
    dLE();
    AppMethodBeat.o(207120);
  }
  
  private final void OA(int paramInt)
  {
    AppMethodBeat.i(207118);
    Object localObject1 = (Iterable)this.ygK;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      int j = i + 1;
      if (i < 0) {
        j.gkd();
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
    AppMethodBeat.o(207118);
  }
  
  private final void dLE()
  {
    AppMethodBeat.i(207116);
    if (e.xXw.xXi)
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("name", com.tencent.mm.cb.a.az(getContext(), 2131767054));
      ((JSONObject)localObject).put("key", "default");
      ((JSONObject)localObject).put("path", "default");
      this.ygL.add(localObject);
      localObject = e.xXw.dKp();
      if (localObject != null)
      {
        int i = 0;
        int j = ((JSONArray)localObject).length();
        while (i < j)
        {
          this.ygL.add(((JSONArray)localObject).optJSONObject(i));
          i += 1;
        }
      }
      dLF();
    }
    AppMethodBeat.o(207116);
  }
  
  private final void dLF()
  {
    AppMethodBeat.i(207117);
    try
    {
      Iterator localIterator = ((Iterable)this.ygL).iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        Object localObject1 = localIterator.next();
        if (i < 0) {
          j.gkd();
        }
        localObject1 = (JSONObject)localObject1;
        TextView localTextView = new TextView(getContext());
        Object localObject3 = ((JSONObject)localObject1).optString("name");
        if (TextUtils.isEmpty((CharSequence)((JSONObject)localObject1).optString("path")))
        {
          localObject1 = "";
          label87:
          localTextView.setText((CharSequence)localObject3);
          if (!o.fB((String)localObject1)) {
            break label373;
          }
          localTextView.setTypeface(Typeface.createFromFile((String)localObject1));
        }
        for (;;)
        {
          localTextView.setBackground(getContext().getDrawable(2131235054));
          localObject1 = getContext();
          p.g(localObject1, "context");
          localTextView.setTextColor(((Context)localObject1).getResources().getColor(2131099684));
          localObject1 = getContext();
          p.g(localObject1, "context");
          localTextView.setTextSize(0, ((Context)localObject1).getResources().getDimensionPixelSize(2131165289));
          localObject1 = new LinearLayout.LayoutParams(-2, -2);
          localObject3 = getContext();
          p.g(localObject3, "context");
          ((LinearLayout.LayoutParams)localObject1).width = ((Context)localObject3).getResources().getDimensionPixelSize(2131165301);
          ((LinearLayout.LayoutParams)localObject1).height = com.tencent.mm.cb.a.fromDPToPix(getContext(), 30);
          if (i != this.ygL.size() - 1)
          {
            localObject3 = getContext();
            p.g(localObject3, "context");
            ((LinearLayout.LayoutParams)localObject1).setMarginEnd(((Context)localObject3).getResources().getDimensionPixelSize(2131165294));
          }
          localTextView.setGravity(17);
          addView((View)localTextView, (ViewGroup.LayoutParams)localObject1);
          this.ygK.add(localTextView);
          localTextView.setTag(Integer.valueOf(i));
          localTextView.setOnClickListener((View.OnClickListener)new b(this));
          i += 1;
          break;
          localObject1 = e.xXw.dKm() + ((JSONObject)localObject1).optString("path");
          break label87;
          label373:
          localTextView.setTypeface(Typeface.DEFAULT);
        }
      }
      localObject2 = this.ygK.get(0);
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace(TAG, (Throwable)localException, "parse font error", new Object[0]);
      AppMethodBeat.o(207117);
      return;
    }
    Object localObject2;
    p.g(localObject2, "fontSelectViewList[0]");
    ((View)localObject2).setBackground(getContext().getDrawable(2131235055));
    AppMethodBeat.o(207117);
  }
  
  public final d.g.a.b<String, z> getFontSelectCallback()
  {
    return this.ygM;
  }
  
  public final void setFontSelectCallback(d.g.a.b<? super String, z> paramb)
  {
    this.ygM = paramb;
  }
  
  public final void setSelectFont(String paramString)
  {
    AppMethodBeat.i(207119);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      OA(0);
      AppMethodBeat.o(207119);
      return;
    }
    Iterator localIterator = ((Iterable)this.ygL).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      int j = i + 1;
      if (i < 0) {
        j.gkd();
      }
      Object localObject2 = (JSONObject)localObject1;
      if (paramString != null)
      {
        localObject1 = (CharSequence)paramString;
        localObject2 = ((JSONObject)localObject2).optString("path");
        p.g(localObject2, "jsonObject.optString(\"path\")");
        if (n.a((CharSequence)localObject1, (CharSequence)localObject2, false) == true) {
          OA(i);
        }
        i = j;
      }
      else
      {
        i = j;
      }
    }
    AppMethodBeat.o(207119);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/FontSelectorView$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/recordvideo/ui/editor/view/FontSelectorView$initFontSelectView$1$1"})
  static final class b
    implements View.OnClickListener
  {
    b(FontSelectorView paramFontSelectorView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(207115);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/view/FontSelectorView$initFontSelectView$$inlined$forEachIndexed$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      localObject = this.ygO;
      p.g(paramView, "it");
      paramView = paramView.getTag();
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(207115);
        throw paramView;
      }
      FontSelectorView.a((FontSelectorView)localObject, ((Integer)paramView).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/view/FontSelectorView$initFontSelectView$$inlined$forEachIndexed$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(207115);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.view.FontSelectorView
 * JD-Core Version:    0.7.0.1
 */