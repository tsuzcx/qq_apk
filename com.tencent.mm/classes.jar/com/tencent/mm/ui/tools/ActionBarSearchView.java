package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.ac.a.d;
import com.tencent.mm.ac.a.e;
import com.tencent.mm.ac.a.f;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.ac.a.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.ui.widget.AutoMatchKeywordEditText;
import com.tencent.mm.ui.widget.AutoMatchKeywordEditText.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ActionBarSearchView
  extends LinearLayout
  implements d
{
  private boolean nST = false;
  private TextWatcher sgm = new TextWatcher()
  {
    public final void afterTextChanged(Editable paramAnonymousEditable) {}
    
    public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      ActionBarSearchView.a(ActionBarSearchView.this);
      r localr = ActionBarSearchView.b(ActionBarSearchView.this);
      EditText localEditText;
      Object localObject;
      if (localr.wfu)
      {
        localEditText = (EditText)localr.wfs.get();
        if (localEditText != null) {}
      }
      else if (ActionBarSearchView.c(ActionBarSearchView.this) != null)
      {
        localObject = ActionBarSearchView.c(ActionBarSearchView.this);
        if (paramAnonymousCharSequence != null) {
          break label243;
        }
      }
      label243:
      for (paramAnonymousCharSequence = "";; paramAnonymousCharSequence = paramAnonymousCharSequence.toString())
      {
        ((ActionBarSearchView.b)localObject).GH(paramAnonymousCharSequence);
        return;
        if (((paramAnonymousCharSequence != null) && (paramAnonymousCharSequence.toString() != null) && (paramAnonymousCharSequence.toString().length() != 0)) || ((localr.hnV == null) || (localr.hnV.length() == 0) || ((localr.hnV != null) && (paramAnonymousCharSequence != null) && (localr.hnV.equals(paramAnonymousCharSequence.toString())))))
        {
          y.d("MicroMsg.WordsChecker", "text not change, new : %s, old : %s", new Object[] { paramAnonymousCharSequence, localr.hnV });
          break;
        }
        if (paramAnonymousCharSequence != null) {}
        for (localObject = paramAnonymousCharSequence.toString();; localObject = "")
        {
          localr.hnV = ((String)localObject);
          localr.wfr = r.k(localr.hnV, localr.wft);
          if (!r.a(localEditText, localr.wft)) {
            break;
          }
          y.d("MicroMsg.WordsChecker", "decorate text succ.");
          break;
        }
      }
    }
  };
  private View vXE;
  private ActionBarEditText vXF;
  private ImageButton vXG;
  private c vXH = c.vXS;
  private boolean vXI = false;
  private r vXJ;
  private b vXK;
  private a vXL;
  private View.OnFocusChangeListener vXM = new View.OnFocusChangeListener()
  {
    public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
    {
      y.v("MicroMsg.ActionBarSearchView", "on edittext focus changed, hasFocus %B", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
      if (ActionBarSearchView.d(ActionBarSearchView.this) != null) {
        ActionBarSearchView.d(ActionBarSearchView.this).onFocusChange(paramAnonymousView, paramAnonymousBoolean);
      }
    }
  };
  private View.OnFocusChangeListener vXN;
  private View.OnClickListener vXO = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      if (ActionBarSearchView.c.vXS == ActionBarSearchView.e(ActionBarSearchView.this))
      {
        y.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is clear");
        ActionBarSearchView.this.nI(true);
        if (ActionBarSearchView.c(ActionBarSearchView.this) != null) {
          ActionBarSearchView.c(ActionBarSearchView.this).Wn();
        }
      }
      do
      {
        return;
        y.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is voice search");
      } while (ActionBarSearchView.c(ActionBarSearchView.this) == null);
      ActionBarSearchView.c(ActionBarSearchView.this).beR();
    }
  };
  private View.OnClickListener vXP = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      if (ActionBarSearchView.f(ActionBarSearchView.this) != null) {
        ActionBarSearchView.f(ActionBarSearchView.this).beS();
      }
    }
  };
  
  public ActionBarSearchView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ActionBarSearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void cII()
  {
    if ((this.vXF.getEditableText() != null) && (!bk.bl(this.vXF.getEditableText().toString())))
    {
      fE(a.f.search_clear, getResources().getDimensionPixelSize(a.e.NormalIconSize));
      this.vXH = c.vXS;
      return;
    }
    if (this.vXI)
    {
      fE(a.f.voicesearch_enter_btn, getResources().getDimensionPixelSize(a.e.NormalIconSize));
      this.vXH = c.vXT;
      return;
    }
    fE(0, 0);
    this.vXH = c.vXS;
  }
  
  private void fE(int paramInt1, int paramInt2)
  {
    this.vXG.setImageResource(paramInt1);
    this.vXG.setBackgroundResource(0);
    if (paramInt1 == a.f.voicesearch_enter_btn) {
      this.vXG.setContentDescription(getContext().getString(a.k.voice_Input));
    }
    for (;;)
    {
      ViewGroup.LayoutParams localLayoutParams = this.vXG.getLayoutParams();
      localLayoutParams.width = paramInt2;
      this.vXG.setLayoutParams(localLayoutParams);
      return;
      this.vXG.setContentDescription(getContext().getString(a.k.clear_btn));
    }
  }
  
  private void init()
  {
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(a.h.actionbar_searchview, this, true);
    this.vXE = findViewById(a.g.ab_back_container);
    this.vXE.setOnClickListener(this.vXP);
    this.vXF = ((ActionBarEditText)findViewById(a.g.edittext));
    this.vXJ = new r(this.vXF);
    this.vXF.setSearchView(this);
    this.vXF.post(new Runnable()
    {
      public final void run()
      {
        ActionBarSearchView.g(ActionBarSearchView.this).setText("");
        if (ActionBarSearchView.c(ActionBarSearchView.this) != null) {
          ActionBarSearchView.c(ActionBarSearchView.this).beQ();
        }
      }
    });
    this.vXG = ((ImageButton)findViewById(a.g.status_btn));
    this.vXF.addTextChangedListener(this.sgm);
    this.vXF.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if (paramAnonymousInt == 67)
        {
          y.d("MicroMsg.ActionBarSearchView", "on back key click.");
          Object localObject = ActionBarSearchView.b(ActionBarSearchView.this);
          if (((r)localObject).wfu)
          {
            paramAnonymousView = (EditText)((r)localObject).wfs.get();
            if ((paramAnonymousView != null) && (((r)localObject).wfr != null)) {}
          }
          else
          {
            return false;
          }
          paramAnonymousKeyEvent = paramAnonymousView.getText();
          paramAnonymousInt = paramAnonymousView.getSelectionStart();
          if (paramAnonymousInt == paramAnonymousView.getSelectionEnd())
          {
            localObject = ((r)localObject).Ie(paramAnonymousInt);
            if ((localObject != null) && (((r.b)localObject).wfx))
            {
              paramAnonymousKeyEvent.delete(((r.b)localObject).start, ((r.b)localObject).start + ((r.b)localObject).length);
              paramAnonymousView.setTextKeepState(paramAnonymousKeyEvent);
              paramAnonymousView.setSelection(((r.b)localObject).start);
              return true;
            }
          }
          return false;
        }
        return false;
      }
    });
    this.vXF.setOnSelectionChangeListener(new AutoMatchKeywordEditText.a()
    {
      public final void b(EditText paramAnonymousEditText, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        y.d("MicroMsg.ActionBarSearchView", "start : %d, stop : %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        Object localObject = ActionBarSearchView.b(ActionBarSearchView.this);
        EditText localEditText;
        if (((r)localObject).wfu)
        {
          localEditText = (EditText)((r)localObject).wfs.get();
          if ((localEditText != null) && (paramAnonymousEditText == localEditText)) {
            break label67;
          }
        }
        label67:
        do
        {
          int i;
          do
          {
            do
            {
              return;
              paramAnonymousEditText = localEditText.getText();
              paramAnonymousInt2 = localEditText.getSelectionStart();
              i = localEditText.getSelectionEnd();
            } while ((paramAnonymousInt2 < 0) || (i < paramAnonymousInt2));
            if (paramAnonymousInt2 != i) {
              break;
            }
            localObject = ((r)localObject).Ie(paramAnonymousInt2);
          } while ((localObject == null) || (!((r.b)localObject).wfx));
          localEditText.setTextKeepState(paramAnonymousEditText);
          paramAnonymousInt1 = ((r.b)localObject).start;
          localEditText.setSelection(((r.b)localObject).length + paramAnonymousInt1);
          return;
          r.b localb = ((r)localObject).Ie(paramAnonymousInt2);
          paramAnonymousInt1 = paramAnonymousInt2;
          if (localb != null)
          {
            paramAnonymousInt1 = paramAnonymousInt2;
            if (localb.wfx) {
              paramAnonymousInt1 = localb.start + localb.length;
            }
          }
          if (paramAnonymousInt1 >= i)
          {
            localEditText.setTextKeepState(paramAnonymousEditText);
            localEditText.setSelection(paramAnonymousInt1);
            return;
          }
          localObject = ((r)localObject).Ie(i);
        } while ((localObject == null) || (!((r.b)localObject).wfx));
        paramAnonymousInt2 = ((r.b)localObject).start;
        localEditText.setTextKeepState(paramAnonymousEditText);
        localEditText.setSelection(paramAnonymousInt1, paramAnonymousInt2);
      }
    });
    this.vXF.setOnFocusChangeListener(this.vXM);
    c.d(this.vXF).Ig(100).a(null);
    this.vXG.setOnClickListener(this.vXO);
  }
  
  public final void cIJ()
  {
    this.vXF.clearFocus();
  }
  
  public final boolean cIK()
  {
    if (this.vXF != null) {
      return this.vXF.hasFocus();
    }
    return false;
  }
  
  public final boolean cIL()
  {
    if (this.vXF != null) {
      return this.vXF.requestFocus();
    }
    return false;
  }
  
  public final void fF(int paramInt1, int paramInt2)
  {
    if (this.vXF != null) {
      this.vXF.setSelection(paramInt1, paramInt2);
    }
  }
  
  public String getSearchContent()
  {
    if (this.vXF.getEditableText() != null) {
      return this.vXF.getEditableText().toString();
    }
    return "";
  }
  
  public int getSelectionEnd()
  {
    if (this.vXF != null) {
      return this.vXF.getSelectionEnd();
    }
    return -1;
  }
  
  public int getSelectionStart()
  {
    if (this.vXF != null) {
      return this.vXF.getSelectionStart();
    }
    return -1;
  }
  
  public final void nH(boolean paramBoolean)
  {
    this.vXI = paramBoolean;
    cII();
  }
  
  public final void nI(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.vXF.removeTextChangedListener(this.sgm);
      this.vXF.setText("");
      this.vXF.addTextChangedListener(this.sgm);
      return;
    }
    this.vXF.setText("");
  }
  
  public void setAutoMatchKeywords(boolean paramBoolean)
  {
    if (this.vXJ != null) {
      this.vXJ.wfu = paramBoolean;
    }
  }
  
  public void setBackClickCallback(a parama)
  {
    this.vXL = parama;
  }
  
  public void setCallBack(b paramb)
  {
    this.vXK = paramb;
  }
  
  public void setEditTextClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.vXF != null)
    {
      this.vXF.setFocusable(false);
      this.vXF.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setEditTextEnabled(boolean paramBoolean)
  {
    this.vXF.setEnabled(paramBoolean);
  }
  
  public void setFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.vXN = paramOnFocusChangeListener;
  }
  
  public void setHint(CharSequence paramCharSequence)
  {
    this.vXF.setHint(paramCharSequence);
  }
  
  public void setKeywords(ArrayList<String> paramArrayList)
  {
    if (this.vXJ != null)
    {
      r localr = this.vXJ;
      localr.wft = paramArrayList;
      if (localr.wfu)
      {
        paramArrayList = (EditText)localr.wfs.get();
        if (paramArrayList != null) {
          r.a(paramArrayList, localr.wft);
        }
      }
    }
  }
  
  public void setNotRealCallBack(SearchViewNotRealTimeHelper.a parama) {}
  
  public void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener)
  {
    this.vXF.setOnEditorActionListener(paramOnEditorActionListener);
  }
  
  public void setSearchContent(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.vXF.setText(str);
    this.vXF.setSelection(str.length());
  }
  
  public void setSearchTipIcon(int paramInt)
  {
    if (this.vXF != null) {
      this.vXF.setCompoundDrawables(ae.getResources().getDrawable(paramInt), null, null, null);
    }
  }
  
  public void setSelectedTag(String paramString)
  {
    if (this.vXF != null)
    {
      this.vXF.setCompoundDrawables(new d(this.vXF, paramString), null, null, null);
      this.vXF.setHint("");
    }
  }
  
  public void setStatusBtnEnabled(boolean paramBoolean)
  {
    this.vXG.setEnabled(paramBoolean);
  }
  
  public static class ActionBarEditText
    extends AutoMatchKeywordEditText
  {
    private ActionBarSearchView vXR;
    
    public ActionBarEditText(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public ActionBarEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
    }
    
    public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
    {
      y.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme");
      if (paramInt == 4)
      {
        KeyEvent.DispatcherState localDispatcherState;
        if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
        {
          y.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action down");
          localDispatcherState = getKeyDispatcherState();
          if (localDispatcherState != null) {
            localDispatcherState.startTracking(paramKeyEvent, this);
          }
          return true;
        }
        if (paramKeyEvent.getAction() == 1)
        {
          y.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action up");
          localDispatcherState = getKeyDispatcherState();
          if (localDispatcherState != null) {
            localDispatcherState.handleUpEvent(paramKeyEvent);
          }
          if ((paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled()))
          {
            y.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action up is tracking");
            this.vXR.clearFocus();
            paramKeyEvent = (InputMethodManager)getContext().getSystemService("input_method");
            if (paramKeyEvent != null) {
              paramKeyEvent.hideSoftInputFromWindow(getWindowToken(), 0);
            }
            return true;
          }
        }
      }
      return super.onKeyPreIme(paramInt, paramKeyEvent);
    }
    
    public void setSearchView(ActionBarSearchView paramActionBarSearchView)
    {
      this.vXR = paramActionBarSearchView;
    }
  }
  
  public static abstract interface a
  {
    public abstract void beS();
  }
  
  public static abstract interface b
  {
    public abstract void GH(String paramString);
    
    public abstract void Wn();
    
    public abstract void beQ();
    
    public abstract void beR();
  }
  
  private static enum c
  {
    private c() {}
  }
  
  final class d
    extends Drawable
  {
    private RectF fS;
    private String hnV;
    private Paint vXV;
    private int vXW = BackwardSupportUtil.b.b(ae.getContext(), 2.0F);
    private float vXX;
    private float vXY;
    
    d(EditText paramEditText, String paramString)
    {
      this.vXV = new Paint(paramEditText.getPaint());
      this.hnV = paramString;
      this.vXV.setColor(ae.getResources().getColor(a.d.green_text_color));
      this.vXX = this.vXV.measureText(this.hnV);
      this$1 = this.vXV.getFontMetrics();
      this.vXY = ((float)Math.ceil(ActionBarSearchView.this.bottom - ActionBarSearchView.this.top));
      float f = this.vXY;
      setBounds(0, 0, (int)(this.vXX + this.vXW * 2 + this.vXW * 2 + 2.0F), (int)f);
    }
    
    public final void draw(Canvas paramCanvas)
    {
      Paint.FontMetricsInt localFontMetricsInt = this.vXV.getFontMetricsInt();
      Rect localRect = getBounds();
      int i = localRect.right;
      i = localRect.left;
      float f = this.fS.right;
      f = this.fS.left;
      i = localRect.top;
      int j = (localRect.bottom - localRect.top - localFontMetricsInt.bottom + localFontMetricsInt.top) / 2;
      int k = localFontMetricsInt.top;
      paramCanvas.drawText(this.hnV, localRect.left + 2, i + j - k, this.vXV);
    }
    
    public final int getOpacity()
    {
      return -3;
    }
    
    public final void setAlpha(int paramInt) {}
    
    public final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
      Paint.FontMetrics localFontMetrics = this.vXV.getFontMetrics();
      float f1 = this.vXW + paramInt1;
      float f2 = paramInt2;
      this.fS = new RectF(f1, localFontMetrics.ascent - localFontMetrics.top + f2, paramInt3 - this.vXW, paramInt4);
      invalidateSelf();
    }
    
    public final void setColorFilter(ColorFilter paramColorFilter) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ActionBarSearchView
 * JD-Core Version:    0.7.0.1
 */