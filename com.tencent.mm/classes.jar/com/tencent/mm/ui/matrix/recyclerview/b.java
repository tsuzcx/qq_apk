package com.tencent.mm.ui.matrix.recyclerview;

import android.support.v7.widget.RecyclerView.v;
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
  private JSONArray hpw;
  private JSONObject hpx;
  public View.OnLongClickListener tib;
  
  public b(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(38921);
    this.hpw = paramJSONArray;
    if (this.hpw == null)
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
    paramJsonItemView.au(new SpannableStringBuilder(c.aol(paramInt)));
    b(paramObject, paramJsonItemView, paramBoolean, paramInt);
    AppMethodBeat.o(38924);
  }
  
  private void a(String paramString, Object paramObject, JsonItemView paramJsonItemView, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(38923);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(c.aol(paramInt));
    localSpannableStringBuilder.append("\"").append(paramString).append("\"").append(":");
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(QmX), 0, localSpannableStringBuilder.length() - 1, 33);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Qnd), localSpannableStringBuilder.length() - 1, localSpannableStringBuilder.length(), 33);
    paramJsonItemView.au(localSpannableStringBuilder);
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
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(QmZ), 0, localSpannableStringBuilder.length(), 33);
    }
    for (;;)
    {
      if (paramBoolean) {
        localSpannableStringBuilder.append(",");
      }
      paramJsonItemView.av(localSpannableStringBuilder);
      AppMethodBeat.o(38925);
      return;
      if ((paramObject instanceof Boolean))
      {
        localSpannableStringBuilder.append(paramObject.toString());
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Qna), 0, localSpannableStringBuilder.length(), 33);
      }
      else if ((paramObject instanceof JSONObject))
      {
        paramJsonItemView.CE(true);
        localSpannableStringBuilder.append("Object{...}");
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Qnd), 0, localSpannableStringBuilder.length(), 33);
        paramJsonItemView.setIconClickListener(new a(paramObject, paramJsonItemView, paramBoolean, paramInt + 1));
      }
      else if ((paramObject instanceof JSONArray))
      {
        paramJsonItemView.CE(true);
        localSpannableStringBuilder.append("Array[").append(String.valueOf(((JSONArray)paramObject).length())).append("]");
        int i = localSpannableStringBuilder.length();
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Qnd), 0, 6, 33);
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(QmZ), 6, i - 1, 33);
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Qnd), i - 1, i, 33);
        paramJsonItemView.setIconClickListener(new a(paramObject, paramJsonItemView, paramBoolean, paramInt + 1));
      }
      else if (paramObject != null)
      {
        paramJsonItemView.gWY();
        localSpannableStringBuilder.append("\"").append(paramObject.toString()).append("\"");
        if (c.bnL(paramObject.toString()))
        {
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(QmY), 0, 1, 33);
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Qnb), 1, localSpannableStringBuilder.length() - 1, 33);
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(QmY), localSpannableStringBuilder.length() - 1, localSpannableStringBuilder.length(), 33);
        }
        else
        {
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(QmY), 0, localSpannableStringBuilder.length(), 33);
        }
      }
      else if ((localSpannableStringBuilder.length() == 0) || (paramObject == null))
      {
        paramJsonItemView.gWY();
        localSpannableStringBuilder.append("null");
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Qnc), 0, localSpannableStringBuilder.length(), 33);
      }
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(38922);
    int i;
    if (this.hpx != null)
    {
      if (this.hpx.names() != null)
      {
        i = this.hpx.names().length();
        AppMethodBeat.o(38922);
        return i + 2;
      }
      AppMethodBeat.o(38922);
      return 2;
    }
    if (this.hpw != null)
    {
      i = this.hpw.length();
      AppMethodBeat.o(38922);
      return i + 2;
    }
    AppMethodBeat.o(38922);
    return 0;
  }
  
  final class a
    implements View.OnClickListener
  {
    private JsonItemView Qnn;
    private boolean Qno;
    private int Qnp;
    private boolean Qnq;
    private boolean Qnr;
    private Object value;
    
    a(Object paramObject, JsonItemView paramJsonItemView, boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(38917);
      this.Qnq = true;
      this.value = paramObject;
      this.Qnn = paramJsonItemView;
      this.Qno = paramBoolean;
      this.Qnp = paramInt;
      if ((paramObject != null) && ((paramObject instanceof JSONArray))) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.Qnr = paramBoolean;
        AppMethodBeat.o(38917);
        return;
      }
    }
    
    public final void onClick(View paramView)
    {
      boolean bool2 = true;
      AppMethodBeat.i(38918);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/matrix/recyclerview/JsonViewerAdapter$JsonItemClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      label115:
      int i;
      if (this.Qnn.getChildCount() == 1)
      {
        this.Qnq = false;
        this.Qnn.CE(false);
        this.Qnn.setTag(this.Qnn.getRightText());
        localObject1 = this.Qnn;
        if (this.Qnr)
        {
          paramView = "[";
          ((JsonItemView)localObject1).av(paramView);
          if (!this.Qnr) {
            break label231;
          }
          paramView = (JSONArray)this.value;
          i = 0;
          label117:
          if ((paramView == null) || (i >= paramView.length())) {
            break label320;
          }
          localObject1 = new JsonItemView(this.Qnn.getContext());
          ((JsonItemView)localObject1).setTextSize(a.Qne);
          ((JsonItemView)localObject1).setRightColor(a.Qnd);
          localObject2 = paramView.opt(i);
          if (!this.Qnr) {
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
          b.a((b)localObject3, localObject2, (JsonItemView)localObject1, bool1, this.Qnp);
          this.Qnn.hm((View)localObject1);
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
          b.a((b)localObject3, str, localObject2, (JsonItemView)localObject1, bool1, this.Qnp);
          break;
        }
        label320:
        localObject1 = new JsonItemView(this.Qnn.getContext());
        ((JsonItemView)localObject1).setTextSize(a.Qne);
        ((JsonItemView)localObject1).setRightColor(a.Qnd);
        localObject2 = new StringBuilder(c.aol(this.Qnp - 1));
        if (this.Qnr)
        {
          paramView = "]";
          localObject3 = ((StringBuilder)localObject2).append(paramView);
          if (!this.Qno) {
            break label459;
          }
        }
        label459:
        for (paramView = ",";; paramView = "")
        {
          ((StringBuilder)localObject3).append(paramView);
          ((JsonItemView)localObject1).av((CharSequence)localObject2);
          this.Qnn.hm((View)localObject1);
          this.Qnn.requestLayout();
          this.Qnn.invalidate();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/matrix/recyclerview/JsonViewerAdapter$JsonItemClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38918);
          return;
          paramView = "}";
          break;
        }
      }
      paramView = this.Qnn.getRightText();
      this.Qnn.av((CharSequence)this.Qnn.getTag());
      this.Qnn.setTag(paramView);
      paramView = this.Qnn;
      if (!this.Qnq)
      {
        bool1 = true;
        paramView.CE(bool1);
        i = 1;
        label521:
        if (i >= this.Qnn.getChildCount()) {
          break label574;
        }
        paramView = this.Qnn.getChildAt(i);
        if (!this.Qnq) {
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
      if (!this.Qnq) {}
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.Qnq = bool1;
        break;
      }
    }
  }
  
  final class b
    extends RecyclerView.v
  {
    JsonItemView Qnn;
    
    b(final JsonItemView paramJsonItemView)
    {
      super();
      AppMethodBeat.i(38920);
      av(false);
      this.Qnn = paramJsonItemView;
      paramJsonItemView.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38919);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/matrix/recyclerview/JsonViewerAdapter$JsonItemViewHolder$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
          if (b.a(b.this) != null) {}
          try
          {
            paramJsonItemView.setTag(b.b(b.this).get(b.b.this.lR() - 1));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.matrix.recyclerview.b
 * JD-Core Version:    0.7.0.1
 */