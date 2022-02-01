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
  private JSONArray gbL;
  private JSONObject gbM;
  public View.OnLongClickListener qhH;
  
  public b(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(38921);
    this.gbL = paramJSONArray;
    if (this.gbL == null)
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
    paramJsonItemView.ao(new SpannableStringBuilder(c.aae(paramInt)));
    b(paramObject, paramJsonItemView, paramBoolean, paramInt);
    AppMethodBeat.o(38924);
  }
  
  private void a(String paramString, Object paramObject, JsonItemView paramJsonItemView, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(38923);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(c.aae(paramInt));
    localSpannableStringBuilder.append("\"").append(paramString).append("\"").append(":");
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Hkj), 0, localSpannableStringBuilder.length() - 1, 33);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Hkp), localSpannableStringBuilder.length() - 1, localSpannableStringBuilder.length(), 33);
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
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Hkl), 0, localSpannableStringBuilder.length(), 33);
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
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Hkm), 0, localSpannableStringBuilder.length(), 33);
      }
      else if ((paramObject instanceof JSONObject))
      {
        paramJsonItemView.wC(true);
        localSpannableStringBuilder.append("Object{...}");
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Hkp), 0, localSpannableStringBuilder.length(), 33);
        paramJsonItemView.setIconClickListener(new a(paramObject, paramJsonItemView, paramBoolean, paramInt + 1));
      }
      else if ((paramObject instanceof JSONArray))
      {
        paramJsonItemView.wC(true);
        localSpannableStringBuilder.append("Array[").append(String.valueOf(((JSONArray)paramObject).length())).append("]");
        int i = localSpannableStringBuilder.length();
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Hkp), 0, 6, 33);
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Hkl), 6, i - 1, 33);
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Hkp), i - 1, i, 33);
        paramJsonItemView.setIconClickListener(new a(paramObject, paramJsonItemView, paramBoolean, paramInt + 1));
      }
      else if (paramObject != null)
      {
        paramJsonItemView.fdg();
        localSpannableStringBuilder.append("\"").append(paramObject.toString()).append("\"");
        if (c.aLF(paramObject.toString()))
        {
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Hkk), 0, 1, 33);
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Hkn), 1, localSpannableStringBuilder.length() - 1, 33);
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Hkk), localSpannableStringBuilder.length() - 1, localSpannableStringBuilder.length(), 33);
        }
        else
        {
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Hkk), 0, localSpannableStringBuilder.length(), 33);
        }
      }
      else if ((localSpannableStringBuilder.length() == 0) || (paramObject == null))
      {
        paramJsonItemView.fdg();
        localSpannableStringBuilder.append("null");
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Hko), 0, localSpannableStringBuilder.length(), 33);
      }
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(38922);
    int i;
    if (this.gbM != null)
    {
      if (this.gbM.names() != null)
      {
        i = this.gbM.names().length();
        AppMethodBeat.o(38922);
        return i + 2;
      }
      AppMethodBeat.o(38922);
      return 2;
    }
    if (this.gbL != null)
    {
      i = this.gbL.length();
      AppMethodBeat.o(38922);
      return i + 2;
    }
    AppMethodBeat.o(38922);
    return 0;
  }
  
  final class a
    implements View.OnClickListener
  {
    private boolean HkA;
    private int HkB;
    private boolean HkC;
    private boolean HkD;
    private JsonItemView Hkz;
    private Object value;
    
    a(Object paramObject, JsonItemView paramJsonItemView, boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(38917);
      this.HkC = true;
      this.value = paramObject;
      this.Hkz = paramJsonItemView;
      this.HkA = paramBoolean;
      this.HkB = paramInt;
      if ((paramObject != null) && ((paramObject instanceof JSONArray))) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.HkD = paramBoolean;
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
      if (this.Hkz.getChildCount() == 1)
      {
        this.HkC = false;
        this.Hkz.wC(false);
        this.Hkz.setTag(this.Hkz.getRightText());
        JsonItemView localJsonItemView = this.Hkz;
        if (this.HkD)
        {
          paramView = "[";
          localJsonItemView.ap(paramView);
          if (!this.HkD) {
            break label199;
          }
          paramView = (JSONArray)this.value;
          i = 0;
          label85:
          if ((paramView == null) || (i >= paramView.length())) {
            break label288;
          }
          localJsonItemView = new JsonItemView(this.Hkz.getContext());
          localJsonItemView.setTextSize(a.Hkq);
          localJsonItemView.setRightColor(a.Hkp);
          localObject1 = paramView.opt(i);
          if (!this.HkD) {
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
          b.a((b)localObject2, localObject1, localJsonItemView, bool1, this.HkB);
          this.Hkz.gm(localJsonItemView);
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
          b.a((b)localObject2, str, localObject1, localJsonItemView, bool1, this.HkB);
          break;
        }
        label288:
        localJsonItemView = new JsonItemView(this.Hkz.getContext());
        localJsonItemView.setTextSize(a.Hkq);
        localJsonItemView.setRightColor(a.Hkp);
        localObject1 = new StringBuilder(c.aae(this.HkB - 1));
        if (this.HkD)
        {
          paramView = "]";
          localObject2 = ((StringBuilder)localObject1).append(paramView);
          if (!this.HkA) {
            break label415;
          }
        }
        label415:
        for (paramView = ",";; paramView = "")
        {
          ((StringBuilder)localObject2).append(paramView);
          localJsonItemView.ap((CharSequence)localObject1);
          this.Hkz.gm(localJsonItemView);
          this.Hkz.requestLayout();
          this.Hkz.invalidate();
          AppMethodBeat.o(38918);
          return;
          paramView = "}";
          break;
        }
      }
      paramView = this.Hkz.getRightText();
      this.Hkz.ap((CharSequence)this.Hkz.getTag());
      this.Hkz.setTag(paramView);
      paramView = this.Hkz;
      if (!this.HkC)
      {
        bool1 = true;
        paramView.wC(bool1);
        i = 1;
        label477:
        if (i >= this.Hkz.getChildCount()) {
          break label530;
        }
        paramView = this.Hkz.getChildAt(i);
        if (!this.HkC) {
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
      if (!this.HkC) {}
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.HkC = bool1;
        AppMethodBeat.o(38918);
        return;
      }
    }
  }
  
  final class b
    extends RecyclerView.v
  {
    JsonItemView Hkz;
    
    b(final JsonItemView paramJsonItemView)
    {
      super();
      AppMethodBeat.i(38920);
      ax(false);
      this.Hkz = paramJsonItemView;
      paramJsonItemView.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38919);
          if (b.a(b.this) != null) {}
          try
          {
            paramJsonItemView.setTag(b.b(b.this).get(b.b.this.ln() - 1));
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