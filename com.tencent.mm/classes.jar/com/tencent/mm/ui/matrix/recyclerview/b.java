package com.tencent.mm.ui.matrix.recyclerview;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
  extends a<b>
{
  public View.OnLongClickListener AkV;
  private JSONArray mBs;
  private JSONObject mBt;
  
  public b(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(38921);
    this.mBs = paramJSONArray;
    if (this.mBs == null)
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
    paramJsonItemView.aX(new SpannableStringBuilder(c.aEa(paramInt)));
    b(paramObject, paramJsonItemView, paramBoolean, paramInt);
    AppMethodBeat.o(38924);
  }
  
  private void a(String paramString, Object paramObject, JsonItemView paramJsonItemView, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(38923);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(c.aEa(paramInt));
    localSpannableStringBuilder.append("\"").append(paramString).append("\"").append(":");
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(afxL), 0, localSpannableStringBuilder.length() - 1, 33);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(afxR), localSpannableStringBuilder.length() - 1, localSpannableStringBuilder.length(), 33);
    paramJsonItemView.aX(localSpannableStringBuilder);
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
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(afxN), 0, localSpannableStringBuilder.length(), 33);
    }
    for (;;)
    {
      if (paramBoolean) {
        localSpannableStringBuilder.append(",");
      }
      paramJsonItemView.aY(localSpannableStringBuilder);
      AppMethodBeat.o(38925);
      return;
      if ((paramObject instanceof Boolean))
      {
        localSpannableStringBuilder.append(paramObject.toString());
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(afxO), 0, localSpannableStringBuilder.length(), 33);
      }
      else if ((paramObject instanceof JSONObject))
      {
        paramJsonItemView.MQ(true);
        localSpannableStringBuilder.append("Object{...}");
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(afxR), 0, localSpannableStringBuilder.length(), 33);
        paramJsonItemView.setIconClickListener(new a(paramObject, paramJsonItemView, paramBoolean, paramInt + 1));
      }
      else if ((paramObject instanceof JSONArray))
      {
        paramJsonItemView.MQ(true);
        localSpannableStringBuilder.append("Array[").append(String.valueOf(((JSONArray)paramObject).length())).append("]");
        int i = localSpannableStringBuilder.length();
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(afxR), 0, 6, 33);
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(afxN), 6, i - 1, 33);
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(afxR), i - 1, i, 33);
        paramJsonItemView.setIconClickListener(new a(paramObject, paramJsonItemView, paramBoolean, paramInt + 1));
      }
      else if (paramObject != null)
      {
        paramJsonItemView.jBL();
        localSpannableStringBuilder.append("\"").append(paramObject.toString()).append("\"");
        if (c.bCj(paramObject.toString()))
        {
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(afxM), 0, 1, 33);
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(afxP), 1, localSpannableStringBuilder.length() - 1, 33);
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(afxM), localSpannableStringBuilder.length() - 1, localSpannableStringBuilder.length(), 33);
        }
        else
        {
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(afxM), 0, localSpannableStringBuilder.length(), 33);
        }
      }
      else if ((localSpannableStringBuilder.length() == 0) || (paramObject == null))
      {
        paramJsonItemView.jBL();
        localSpannableStringBuilder.append("null");
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(afxQ), 0, localSpannableStringBuilder.length(), 33);
      }
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(38922);
    int i;
    if (this.mBt != null)
    {
      if (this.mBt.names() != null)
      {
        i = this.mBt.names().length();
        AppMethodBeat.o(38922);
        return i + 2;
      }
      AppMethodBeat.o(38922);
      return 2;
    }
    if (this.mBs != null)
    {
      i = this.mBs.length();
      AppMethodBeat.o(38922);
      return i + 2;
    }
    AppMethodBeat.o(38922);
    return 0;
  }
  
  final class a
    implements View.OnClickListener
  {
    private JsonItemView afyb;
    private boolean afyc;
    private int afyd;
    private boolean afye;
    private boolean afyf;
    private Object value;
    
    a(Object paramObject, JsonItemView paramJsonItemView, boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(38917);
      this.afye = true;
      this.value = paramObject;
      this.afyb = paramJsonItemView;
      this.afyc = paramBoolean;
      this.afyd = paramInt;
      if ((paramObject != null) && ((paramObject instanceof JSONArray))) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.afyf = paramBoolean;
        AppMethodBeat.o(38917);
        return;
      }
    }
    
    public final void onClick(View paramView)
    {
      boolean bool2 = true;
      AppMethodBeat.i(38918);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/matrix/recyclerview/JsonViewerAdapter$JsonItemClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
      label115:
      int i;
      if (this.afyb.getChildCount() == 1)
      {
        this.afye = false;
        this.afyb.MQ(false);
        this.afyb.setTag(this.afyb.getRightText());
        localObject1 = this.afyb;
        if (this.afyf)
        {
          paramView = "[";
          ((JsonItemView)localObject1).aY(paramView);
          if (!this.afyf) {
            break label231;
          }
          paramView = (JSONArray)this.value;
          i = 0;
          label117:
          if ((paramView == null) || (i >= paramView.length())) {
            break label320;
          }
          localObject1 = new JsonItemView(this.afyb.getContext());
          ((JsonItemView)localObject1).setTextSize(a.afxS);
          ((JsonItemView)localObject1).setRightColor(a.afxR);
          localObject2 = paramView.opt(i);
          if (!this.afyf) {
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
          b.a((b)localObject3, localObject2, (JsonItemView)localObject1, bool1, this.afyd);
          this.afyb.lY((View)localObject1);
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
          b.a((b)localObject3, str, localObject2, (JsonItemView)localObject1, bool1, this.afyd);
          break;
        }
        label320:
        localObject1 = new JsonItemView(this.afyb.getContext());
        ((JsonItemView)localObject1).setTextSize(a.afxS);
        ((JsonItemView)localObject1).setRightColor(a.afxR);
        localObject2 = new StringBuilder(c.aEa(this.afyd - 1));
        if (this.afyf)
        {
          paramView = "]";
          localObject3 = ((StringBuilder)localObject2).append(paramView);
          if (!this.afyc) {
            break label459;
          }
        }
        label459:
        for (paramView = ",";; paramView = "")
        {
          ((StringBuilder)localObject3).append(paramView);
          ((JsonItemView)localObject1).aY((CharSequence)localObject2);
          this.afyb.lY((View)localObject1);
          this.afyb.requestLayout();
          this.afyb.invalidate();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/matrix/recyclerview/JsonViewerAdapter$JsonItemClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38918);
          return;
          paramView = "}";
          break;
        }
      }
      paramView = this.afyb.getRightText();
      this.afyb.aY((CharSequence)this.afyb.getTag());
      this.afyb.setTag(paramView);
      paramView = this.afyb;
      if (!this.afye)
      {
        bool1 = true;
        paramView.MQ(bool1);
        i = 1;
        label521:
        if (i >= this.afyb.getChildCount()) {
          break label574;
        }
        paramView = this.afyb.getChildAt(i);
        if (!this.afye) {
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
      if (!this.afye) {}
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.afye = bool1;
        break;
      }
    }
  }
  
  final class b
    extends RecyclerView.v
  {
    JsonItemView afyb;
    
    b(final JsonItemView paramJsonItemView)
    {
      super();
      AppMethodBeat.i(38920);
      bg(false);
      this.afyb = paramJsonItemView;
      paramJsonItemView.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38919);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/matrix/recyclerview/JsonViewerAdapter$JsonItemViewHolder$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
          if (b.a(b.this) != null) {}
          try
          {
            paramJsonItemView.setTag(b.b(b.this).get(b.b.this.KJ() - 1));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.matrix.recyclerview.b
 * JD-Core Version:    0.7.0.1
 */