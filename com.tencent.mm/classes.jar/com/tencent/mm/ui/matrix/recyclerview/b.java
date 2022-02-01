package com.tencent.mm.ui.matrix.recyclerview;

import android.support.v7.widget.RecyclerView.w;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
  extends a<b>
{
  private JSONArray gCI;
  private JSONObject gCJ;
  public View.OnLongClickListener rIu;
  
  public b(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(38921);
    this.gCI = paramJSONArray;
    if (this.gCI == null)
    {
      paramJSONArray = new IllegalArgumentException("jsonArray can not be null.");
      AppMethodBeat.o(38921);
      throw paramJSONArray;
    }
    AppMethodBeat.o(38921);
  }
  
  private void a(Object paramObject, JsonItemView paramJsonItemView, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(38924);
    paramJsonItemView.ao(new SpannableStringBuilder(c.afy(paramInt)));
    b(paramObject, paramJsonItemView, paramBoolean, paramInt);
    AppMethodBeat.o(38924);
  }
  
  private void a(String paramString, Object paramObject, JsonItemView paramJsonItemView, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(38923);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(c.afy(paramInt));
    localSpannableStringBuilder.append("\"").append(paramString).append("\"").append(":");
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(KYd), 0, localSpannableStringBuilder.length() - 1, 33);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(KYj), localSpannableStringBuilder.length() - 1, localSpannableStringBuilder.length(), 33);
    paramJsonItemView.ao(localSpannableStringBuilder);
    b(paramObject, paramJsonItemView, paramBoolean, paramInt);
    AppMethodBeat.o(38923);
  }
  
  private void b(Object paramObject, JsonItemView paramJsonItemView, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(38925);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((paramObject instanceof Number))
    {
      localSpannableStringBuilder.append(paramObject.toString());
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(KYf), 0, localSpannableStringBuilder.length(), 33);
    }
    for (;;)
    {
      if (paramBoolean) {
        localSpannableStringBuilder.append(",");
      }
      paramJsonItemView.ap(localSpannableStringBuilder);
      AppMethodBeat.o(38925);
      return;
      if ((paramObject instanceof Boolean))
      {
        localSpannableStringBuilder.append(paramObject.toString());
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(KYg), 0, localSpannableStringBuilder.length(), 33);
      }
      else if ((paramObject instanceof JSONObject))
      {
        paramJsonItemView.yK(true);
        localSpannableStringBuilder.append("Object{...}");
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(KYj), 0, localSpannableStringBuilder.length(), 33);
        paramJsonItemView.setIconClickListener(new a(paramObject, paramJsonItemView, paramBoolean, paramInt + 1));
      }
      else if ((paramObject instanceof JSONArray))
      {
        paramJsonItemView.yK(true);
        localSpannableStringBuilder.append("Array[").append(String.valueOf(((JSONArray)paramObject).length())).append("]");
        int i = localSpannableStringBuilder.length();
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(KYj), 0, 6, 33);
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(KYf), 6, i - 1, 33);
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(KYj), i - 1, i, 33);
        paramJsonItemView.setIconClickListener(new a(paramObject, paramJsonItemView, paramBoolean, paramInt + 1));
      }
      else if (paramObject != null)
      {
        paramJsonItemView.fOg();
        localSpannableStringBuilder.append("\"").append(paramObject.toString()).append("\"");
        if (c.aYG(paramObject.toString()))
        {
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(KYe), 0, 1, 33);
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(KYh), 1, localSpannableStringBuilder.length() - 1, 33);
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(KYe), localSpannableStringBuilder.length() - 1, localSpannableStringBuilder.length(), 33);
        }
        else
        {
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(KYe), 0, localSpannableStringBuilder.length(), 33);
        }
      }
      else if ((localSpannableStringBuilder.length() == 0) || (paramObject == null))
      {
        paramJsonItemView.fOg();
        localSpannableStringBuilder.append("null");
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(KYi), 0, localSpannableStringBuilder.length(), 33);
      }
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(38922);
    int i;
    if (this.gCJ != null)
    {
      if (this.gCJ.names() != null)
      {
        i = this.gCJ.names().length();
        AppMethodBeat.o(38922);
        return i + 2;
      }
      AppMethodBeat.o(38922);
      return 2;
    }
    if (this.gCI != null)
    {
      i = this.gCI.length();
      AppMethodBeat.o(38922);
      return i + 2;
    }
    AppMethodBeat.o(38922);
    return 0;
  }
  
  final class a
    implements View.OnClickListener
  {
    private JsonItemView KYt;
    private boolean KYu;
    private int KYv;
    private boolean KYw;
    private boolean KYx;
    private Object value;
    
    a(Object paramObject, JsonItemView paramJsonItemView, boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(38917);
      this.KYw = true;
      this.value = paramObject;
      this.KYt = paramJsonItemView;
      this.KYu = paramBoolean;
      this.KYv = paramInt;
      if ((paramObject != null) && ((paramObject instanceof JSONArray))) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.KYx = paramBoolean;
        AppMethodBeat.o(38917);
        return;
      }
    }
    
    public final void onClick(View paramView)
    {
      boolean bool2 = true;
      AppMethodBeat.i(38918);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/matrix/recyclerview/JsonViewerAdapter$JsonItemClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
      label115:
      int i;
      if (this.KYt.getChildCount() == 1)
      {
        this.KYw = false;
        this.KYt.yK(false);
        this.KYt.setTag(this.KYt.getRightText());
        localObject1 = this.KYt;
        if (this.KYx)
        {
          paramView = "[";
          ((JsonItemView)localObject1).ap(paramView);
          if (!this.KYx) {
            break label231;
          }
          paramView = (JSONArray)this.value;
          i = 0;
          label117:
          if ((paramView == null) || (i >= paramView.length())) {
            break label320;
          }
          localObject1 = new JsonItemView(this.KYt.getContext());
          ((JsonItemView)localObject1).setTextSize(a.KYk);
          ((JsonItemView)localObject1).setRightColor(a.KYj);
          localObject2 = paramView.opt(i);
          if (!this.KYx) {
            break label251;
          }
          localObject3 = b.this;
          if (i >= paramView.length() - 1) {
            break label245;
          }
        }
        label231:
        label245:
        for (bool1 = true;; bool1 = false)
        {
          b.a((b)localObject3, localObject2, (JsonItemView)localObject1, bool1, this.KYv);
          this.KYt.gW((View)localObject1);
          i += 1;
          break label117;
          paramView = "{";
          break;
          paramView = ((JSONObject)this.value).names();
          break label115;
        }
        label251:
        Object localObject3 = b.this;
        String str = (String)localObject2;
        Object localObject2 = ((JSONObject)this.value).opt((String)localObject2);
        if (i < paramView.length() - 1) {}
        for (bool1 = true;; bool1 = false)
        {
          b.a((b)localObject3, str, localObject2, (JsonItemView)localObject1, bool1, this.KYv);
          break;
        }
        label320:
        localObject1 = new JsonItemView(this.KYt.getContext());
        ((JsonItemView)localObject1).setTextSize(a.KYk);
        ((JsonItemView)localObject1).setRightColor(a.KYj);
        localObject2 = new StringBuilder(c.afy(this.KYv - 1));
        if (this.KYx)
        {
          paramView = "]";
          localObject3 = ((StringBuilder)localObject2).append(paramView);
          if (!this.KYu) {
            break label459;
          }
        }
        label459:
        for (paramView = ",";; paramView = "")
        {
          ((StringBuilder)localObject3).append(paramView);
          ((JsonItemView)localObject1).ap((CharSequence)localObject2);
          this.KYt.gW((View)localObject1);
          this.KYt.requestLayout();
          this.KYt.invalidate();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/matrix/recyclerview/JsonViewerAdapter$JsonItemClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38918);
          return;
          paramView = "}";
          break;
        }
      }
      paramView = this.KYt.getRightText();
      this.KYt.ap((CharSequence)this.KYt.getTag());
      this.KYt.setTag(paramView);
      paramView = this.KYt;
      if (!this.KYw)
      {
        bool1 = true;
        paramView.yK(bool1);
        i = 1;
        label521:
        if (i >= this.KYt.getChildCount()) {
          break label574;
        }
        paramView = this.KYt.getChildAt(i);
        if (!this.KYw) {
          break label568;
        }
      }
      label568:
      for (int j = 0;; j = 8)
      {
        paramView.setVisibility(j);
        i += 1;
        break label521;
        bool1 = false;
        break;
      }
      label574:
      if (!this.KYw) {}
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.KYw = bool1;
        break;
      }
    }
  }
  
  final class b
    extends RecyclerView.w
  {
    JsonItemView KYt;
    
    b(final JsonItemView paramJsonItemView)
    {
      super();
      AppMethodBeat.i(38920);
      ax(false);
      this.KYt = paramJsonItemView;
      paramJsonItemView.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38919);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/matrix/recyclerview/JsonViewerAdapter$JsonItemViewHolder$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
          if (b.a(b.this) != null) {}
          try
          {
            paramJsonItemView.setTag(b.b(b.this).get(b.b.this.lN() - 1));
            label76:
            boolean bool = b.a(b.this).onLongClick(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/matrix/recyclerview/JsonViewerAdapter$JsonItemViewHolder$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(38919);
            return bool;
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/matrix/recyclerview/JsonViewerAdapter$JsonItemViewHolder$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(38919);
            return false;
          }
          catch (Exception localException)
          {
            break label76;
          }
        }
      });
      AppMethodBeat.o(38920);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.matrix.recyclerview.b
 * JD-Core Version:    0.7.0.1
 */