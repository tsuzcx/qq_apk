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
import com.tencent.mm.plugin.recordvideo.b.b;
import com.tencent.mm.plugin.recordvideo.b.c;
import com.tencent.mm.plugin.recordvideo.b.d;
import com.tencent.mm.plugin.recordvideo.b.h;
import com.tencent.mm.plugin.recordvideo.res.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/FontSelectorView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "configList", "Ljava/util/ArrayList;", "Lorg/json/JSONObject;", "Lkotlin/collections/ArrayList;", "fontSelectCallback", "Lkotlin/Function1;", "", "", "getFontSelectCallback", "()Lkotlin/jvm/functions/Function1;", "setFontSelectCallback", "(Lkotlin/jvm/functions/Function1;)V", "fontSelectViewList", "Landroid/view/View;", "initFontResource", "initFontSelectView", "onFontSelect", "index", "selectFontViewState", "setSelectFont", "font", "Companion", "plugin-recordvideo_release"})
public final class FontSelectorView
  extends LinearLayout
{
  public static final a IeA;
  private static final String TAG = "MicroMsg.FontSelectorView";
  private final ArrayList<View> Iex;
  private ArrayList<JSONObject> Iey;
  private b<? super String, x> Iez;
  
  static
  {
    AppMethodBeat.i(223652);
    IeA = new a((byte)0);
    TAG = "MicroMsg.FontSelectorView";
    AppMethodBeat.o(223652);
  }
  
  public FontSelectorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FontSelectorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(223648);
    this.Iex = new ArrayList();
    this.Iey = new ArrayList();
    setOrientation(0);
    setGravity(16);
    fzn();
    AppMethodBeat.o(223648);
  }
  
  private final void acJ(int paramInt)
  {
    AppMethodBeat.i(223634);
    Object localObject1 = (Iterable)this.Iex;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      int j = i + 1;
      if (i < 0) {
        j.iBO();
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
    AppMethodBeat.o(223634);
  }
  
  private final void fzn()
  {
    AppMethodBeat.i(223621);
    if (e.HVb.HUN)
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("name", com.tencent.mm.ci.a.ba(getContext(), b.h.font_select_default));
      ((JSONObject)localObject).put("key", "default");
      ((JSONObject)localObject).put("path", "default");
      this.Iey.add(localObject);
      localObject = e.HVb.fxG();
      if (localObject != null)
      {
        int i = 0;
        int j = ((JSONArray)localObject).length();
        while (i < j)
        {
          this.Iey.add(((JSONArray)localObject).optJSONObject(i));
          i += 1;
        }
      }
      fzo();
    }
    AppMethodBeat.o(223621);
  }
  
  private final void fzo()
  {
    AppMethodBeat.i(223632);
    try
    {
      Iterator localIterator = ((Iterable)this.Iey).iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        Object localObject1 = localIterator.next();
        if (i < 0) {
          j.iBO();
        }
        localObject1 = (JSONObject)localObject1;
        TextView localTextView = new TextView(getContext());
        Object localObject3 = ((JSONObject)localObject1).optString("name");
        if (TextUtils.isEmpty((CharSequence)((JSONObject)localObject1).optString("path")))
        {
          localObject1 = "";
          label88:
          localTextView.setText((CharSequence)localObject3);
          if (!u.agG((String)localObject1)) {
            break label375;
          }
          localTextView.setTypeface(Typeface.createFromFile((String)localObject1));
        }
        for (;;)
        {
          localTextView.setBackground(getContext().getDrawable(b.d.font_select_background_disable));
          localObject1 = getContext();
          p.j(localObject1, "context");
          localTextView.setTextColor(((Context)localObject1).getResources().getColor(b.b.BW_BG_100));
          localObject1 = getContext();
          p.j(localObject1, "context");
          localTextView.setTextSize(0, ((Context)localObject1).getResources().getDimensionPixelSize(b.c.Edge_2A));
          localObject1 = new LinearLayout.LayoutParams(-2, -2);
          localObject3 = getContext();
          p.j(localObject3, "context");
          ((LinearLayout.LayoutParams)localObject1).width = ((Context)localObject3).getResources().getDimensionPixelSize(b.c.Edge_8A);
          ((LinearLayout.LayoutParams)localObject1).height = com.tencent.mm.ci.a.fromDPToPix(getContext(), 30);
          if (i != this.Iey.size() - 1)
          {
            localObject3 = getContext();
            p.j(localObject3, "context");
            ((LinearLayout.LayoutParams)localObject1).setMarginEnd(((Context)localObject3).getResources().getDimensionPixelSize(b.c.Edge_4A));
          }
          localTextView.setGravity(17);
          addView((View)localTextView, (ViewGroup.LayoutParams)localObject1);
          this.Iex.add(localTextView);
          localTextView.setTag(Integer.valueOf(i));
          localTextView.setOnClickListener((View.OnClickListener)new FontSelectorView.b(this));
          i += 1;
          break;
          localObject1 = e.HVb.fxD() + ((JSONObject)localObject1).optString("path");
          break label88;
          label375:
          localTextView.setTypeface(Typeface.DEFAULT);
        }
      }
      localObject2 = this.Iex.get(0);
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(TAG, (Throwable)localException, "parse font error", new Object[0]);
      AppMethodBeat.o(223632);
      return;
    }
    Object localObject2;
    p.j(localObject2, "fontSelectViewList[0]");
    ((View)localObject2).setBackground(getContext().getDrawable(b.d.font_select_background_enable));
    AppMethodBeat.o(223632);
  }
  
  public final b<String, x> getFontSelectCallback()
  {
    return this.Iez;
  }
  
  public final void setFontSelectCallback(b<? super String, x> paramb)
  {
    this.Iez = paramb;
  }
  
  public final void setSelectFont(String paramString)
  {
    AppMethodBeat.i(223641);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      acJ(0);
      AppMethodBeat.o(223641);
      return;
    }
    Iterator localIterator = ((Iterable)this.Iey).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      int j = i + 1;
      if (i < 0) {
        j.iBO();
      }
      Object localObject2 = (JSONObject)localObject1;
      if (paramString != null)
      {
        localObject1 = (CharSequence)paramString;
        localObject2 = ((JSONObject)localObject2).optString("path");
        p.j(localObject2, "jsonObject.optString(\"path\")");
        if (n.a((CharSequence)localObject1, (CharSequence)localObject2, false) == true) {
          acJ(i);
        }
        i = j;
      }
      else
      {
        i = j;
      }
    }
    AppMethodBeat.o(223641);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/FontSelectorView$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.view.FontSelectorView
 * JD-Core Version:    0.7.0.1
 */