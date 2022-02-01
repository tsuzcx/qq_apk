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
  private JSONArray ggr;
  private JSONObject ggs;
  public View.OnLongClickListener qQj;
  
  public b(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(38921);
    this.ggr = paramJSONArray;
    if (this.ggr == null)
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
    paramJsonItemView.ap(new SpannableStringBuilder(c.acr(paramInt)));
    b(paramObject, paramJsonItemView, paramBoolean, paramInt);
    AppMethodBeat.o(38924);
  }
  
  private void a(String paramString, Object paramObject, JsonItemView paramJsonItemView, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(38923);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(c.acr(paramInt));
    localSpannableStringBuilder.append("\"").append(paramString).append("\"").append(":");
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(IKC), 0, localSpannableStringBuilder.length() - 1, 33);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(IKI), localSpannableStringBuilder.length() - 1, localSpannableStringBuilder.length(), 33);
    paramJsonItemView.ap(localSpannableStringBuilder);
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
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(IKE), 0, localSpannableStringBuilder.length(), 33);
    }
    for (;;)
    {
      if (paramBoolean) {
        localSpannableStringBuilder.append(",");
      }
      paramJsonItemView.aq(localSpannableStringBuilder);
      AppMethodBeat.o(38925);
      return;
      if ((paramObject instanceof Boolean))
      {
        localSpannableStringBuilder.append(paramObject.toString());
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(IKF), 0, localSpannableStringBuilder.length(), 33);
      }
      else if ((paramObject instanceof JSONObject))
      {
        paramJsonItemView.xJ(true);
        localSpannableStringBuilder.append("Object{...}");
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(IKI), 0, localSpannableStringBuilder.length(), 33);
        paramJsonItemView.setIconClickListener(new a(paramObject, paramJsonItemView, paramBoolean, paramInt + 1));
      }
      else if ((paramObject instanceof JSONArray))
      {
        paramJsonItemView.xJ(true);
        localSpannableStringBuilder.append("Array[").append(String.valueOf(((JSONArray)paramObject).length())).append("]");
        int i = localSpannableStringBuilder.length();
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(IKI), 0, 6, 33);
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(IKE), 6, i - 1, 33);
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(IKI), i - 1, i, 33);
        paramJsonItemView.setIconClickListener(new a(paramObject, paramJsonItemView, paramBoolean, paramInt + 1));
      }
      else if (paramObject != null)
      {
        paramJsonItemView.ftb();
        localSpannableStringBuilder.append("\"").append(paramObject.toString()).append("\"");
        if (c.aRh(paramObject.toString()))
        {
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(IKD), 0, 1, 33);
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(IKG), 1, localSpannableStringBuilder.length() - 1, 33);
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(IKD), localSpannableStringBuilder.length() - 1, localSpannableStringBuilder.length(), 33);
        }
        else
        {
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(IKD), 0, localSpannableStringBuilder.length(), 33);
        }
      }
      else if ((localSpannableStringBuilder.length() == 0) || (paramObject == null))
      {
        paramJsonItemView.ftb();
        localSpannableStringBuilder.append("null");
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(IKH), 0, localSpannableStringBuilder.length(), 33);
      }
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(38922);
    int i;
    if (this.ggs != null)
    {
      if (this.ggs.names() != null)
      {
        i = this.ggs.names().length();
        AppMethodBeat.o(38922);
        return i + 2;
      }
      AppMethodBeat.o(38922);
      return 2;
    }
    if (this.ggr != null)
    {
      i = this.ggr.length();
      AppMethodBeat.o(38922);
      return i + 2;
    }
    AppMethodBeat.o(38922);
    return 0;
  }
  
  final class a
    implements View.OnClickListener
  {
    private JsonItemView IKS;
    private boolean IKT;
    private int IKU;
    private boolean IKV;
    private boolean IKW;
    private Object value;
    
    a(Object paramObject, JsonItemView paramJsonItemView, boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(38917);
      this.IKV = true;
      this.value = paramObject;
      this.IKS = paramJsonItemView;
      this.IKT = paramBoolean;
      this.IKU = paramInt;
      if ((paramObject != null) && ((paramObject instanceof JSONArray))) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.IKW = paramBoolean;
        AppMethodBeat.o(38917);
        return;
      }
    }
    
    public final void onClick(View paramView)
    {
      boolean bool2 = true;
      AppMethodBeat.i(38918);
      label83:
      int i;
      if (this.IKS.getChildCount() == 1)
      {
        this.IKV = false;
        this.IKS.xJ(false);
        this.IKS.setTag(this.IKS.getRightText());
        JsonItemView localJsonItemView = this.IKS;
        if (this.IKW)
        {
          paramView = "[";
          localJsonItemView.aq(paramView);
          if (!this.IKW) {
            break label199;
          }
          paramView = (JSONArray)this.value;
          i = 0;
          label85:
          if ((paramView == null) || (i >= paramView.length())) {
            break label288;
          }
          localJsonItemView = new JsonItemView(this.IKS.getContext());
          localJsonItemView.setTextSize(a.IKJ);
          localJsonItemView.setRightColor(a.IKI);
          localObject1 = paramView.opt(i);
          if (!this.IKW) {
            break label219;
          }
          localObject2 = b.this;
          if (i >= paramView.length() - 1) {
            break label213;
          }
        }
        label199:
        label213:
        for (bool1 = true;; bool1 = false)
        {
          b.a((b)localObject2, localObject1, localJsonItemView, bool1, this.IKU);
          this.IKS.gA(localJsonItemView);
          i += 1;
          break label85;
          paramView = "{";
          break;
          paramView = ((JSONObject)this.value).names();
          break label83;
        }
        label219:
        Object localObject2 = b.this;
        String str = (String)localObject1;
        Object localObject1 = ((JSONObject)this.value).opt((String)localObject1);
        if (i < paramView.length() - 1) {}
        for (bool1 = true;; bool1 = false)
        {
          b.a((b)localObject2, str, localObject1, localJsonItemView, bool1, this.IKU);
          break;
        }
        label288:
        localJsonItemView = new JsonItemView(this.IKS.getContext());
        localJsonItemView.setTextSize(a.IKJ);
        localJsonItemView.setRightColor(a.IKI);
        localObject1 = new StringBuilder(c.acr(this.IKU - 1));
        if (this.IKW)
        {
          paramView = "]";
          localObject2 = ((StringBuilder)localObject1).append(paramView);
          if (!this.IKT) {
            break label415;
          }
        }
        label415:
        for (paramView = ",";; paramView = "")
        {
          ((StringBuilder)localObject2).append(paramView);
          localJsonItemView.aq((CharSequence)localObject1);
          this.IKS.gA(localJsonItemView);
          this.IKS.requestLayout();
          this.IKS.invalidate();
          AppMethodBeat.o(38918);
          return;
          paramView = "}";
          break;
        }
      }
      paramView = this.IKS.getRightText();
      this.IKS.aq((CharSequence)this.IKS.getTag());
      this.IKS.setTag(paramView);
      paramView = this.IKS;
      if (!this.IKV)
      {
        bool1 = true;
        paramView.xJ(bool1);
        i = 1;
        label477:
        if (i >= this.IKS.getChildCount()) {
          break label530;
        }
        paramView = this.IKS.getChildAt(i);
        if (!this.IKV) {
          break label524;
        }
      }
      label524:
      for (int j = 0;; j = 8)
      {
        paramView.setVisibility(j);
        i += 1;
        break label477;
        bool1 = false;
        break;
      }
      label530:
      if (!this.IKV) {}
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.IKV = bool1;
        AppMethodBeat.o(38918);
        return;
      }
    }
  }
  
  final class b
    extends RecyclerView.w
  {
    JsonItemView IKS;
    
    b(final JsonItemView paramJsonItemView)
    {
      super();
      AppMethodBeat.i(38920);
      ax(false);
      this.IKS = paramJsonItemView;
      paramJsonItemView.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38919);
          if (b.a(b.this) != null) {}
          try
          {
            paramJsonItemView.setTag(b.b(b.this).get(b.b.this.lv() - 1));
            label47:
            boolean bool = b.a(b.this).onLongClick(paramAnonymousView);
            AppMethodBeat.o(38919);
            return bool;
            AppMethodBeat.o(38919);
            return false;
          }
          catch (Exception localException)
          {
            break label47;
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