package com.tencent.mm.ui.tools;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.w;
import java.util.ArrayList;

public class SearchViewNotRealTimeHelper
  extends LinearLayout
  implements d
{
  private View ApR;
  private ImageButton ApT;
  private ActionBarSearchView.a ApY;
  public Button Axs;
  private a Axt;
  private EditText naN;
  
  public SearchViewNotRealTimeHelper(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(107794);
    init();
    AppMethodBeat.o(107794);
  }
  
  public SearchViewNotRealTimeHelper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(107793);
    init();
    AppMethodBeat.o(107793);
  }
  
  private void init()
  {
    AppMethodBeat.i(107795);
    w.hM(getContext()).inflate(2130968617, this, true);
    this.naN = ((EditText)findViewById(2131820995));
    this.ApT = ((ImageButton)findViewById(2131820996));
    this.ApR = findViewById(2131820992);
    this.Axs = ((Button)findViewById(2131820875));
    this.Axs.setEnabled(false);
    this.naN.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(107788);
        if ((paramAnonymousEditable == null) || (paramAnonymousEditable.length() <= 0))
        {
          SearchViewNotRealTimeHelper.a(SearchViewNotRealTimeHelper.this).setVisibility(8);
          SearchViewNotRealTimeHelper.b(SearchViewNotRealTimeHelper.this).setEnabled(false);
          AppMethodBeat.o(107788);
          return;
        }
        SearchViewNotRealTimeHelper.a(SearchViewNotRealTimeHelper.this).setVisibility(0);
        SearchViewNotRealTimeHelper.b(SearchViewNotRealTimeHelper.this).setEnabled(true);
        AppMethodBeat.o(107788);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.naN.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(107789);
        if ((3 == paramAnonymousInt) && (SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this) != null))
        {
          boolean bool = SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this).wR(SearchViewNotRealTimeHelper.this.getSearchContent());
          AppMethodBeat.o(107789);
          return bool;
        }
        AppMethodBeat.o(107789);
        return false;
      }
    });
    c.d(this.naN).QS(100).a(null);
    this.ApT.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107790);
        SearchViewNotRealTimeHelper.d(SearchViewNotRealTimeHelper.this).setText("");
        if (SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this) != null) {
          SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this).aWD();
        }
        AppMethodBeat.o(107790);
      }
    });
    this.ApR.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107791);
        ab.v("MicroMsg.SearchViewNotRealTimeHelper", "home btn click");
        if (SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this) != null) {
          SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this);
        }
        if (SearchViewNotRealTimeHelper.e(SearchViewNotRealTimeHelper.this) != null) {
          SearchViewNotRealTimeHelper.e(SearchViewNotRealTimeHelper.this).bMn();
        }
        AppMethodBeat.o(107791);
      }
    });
    this.Axs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107792);
        if (SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this) != null) {
          SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this).GL(SearchViewNotRealTimeHelper.this.getSearchContent());
        }
        AppMethodBeat.o(107792);
      }
    });
    AppMethodBeat.o(107795);
  }
  
  public final void dNx()
  {
    AppMethodBeat.i(107804);
    this.naN.clearFocus();
    AppMethodBeat.o(107804);
  }
  
  public final boolean dNy()
  {
    return false;
  }
  
  public final boolean dNz()
  {
    return false;
  }
  
  public String getSearchContent()
  {
    AppMethodBeat.i(107805);
    Object localObject = this.naN.getEditableText();
    if (localObject == null)
    {
      AppMethodBeat.o(107805);
      return "";
    }
    localObject = localObject.toString();
    AppMethodBeat.o(107805);
    return localObject;
  }
  
  public int getSelectionEnd()
  {
    return -1;
  }
  
  public int getSelectionStart()
  {
    return -1;
  }
  
  public boolean hasFocus()
  {
    return false;
  }
  
  public final void rr(boolean paramBoolean) {}
  
  public final void rs(boolean paramBoolean)
  {
    AppMethodBeat.i(107803);
    this.naN.setText("");
    AppMethodBeat.o(107803);
  }
  
  public void setAutoMatchKeywords(boolean paramBoolean) {}
  
  public void setBackClickCallback(ActionBarSearchView.a parama)
  {
    this.ApY = parama;
  }
  
  public void setCallBack(ActionBarSearchView.b paramb) {}
  
  public void setCallBack(a parama)
  {
    this.Axt = parama;
  }
  
  public void setEditTextEnabled(boolean paramBoolean) {}
  
  public void setFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener) {}
  
  public void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(107807);
    setSearchHint(paramCharSequence);
    AppMethodBeat.o(107807);
  }
  
  public void setKeywords(ArrayList<String> paramArrayList) {}
  
  public void setNotRealCallBack(a parama)
  {
    this.Axt = parama;
  }
  
  public void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener) {}
  
  public void setSearchBtnText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(107796);
    this.Axs.setText(paramCharSequence);
    AppMethodBeat.o(107796);
  }
  
  public void setSearchColor(int paramInt)
  {
    AppMethodBeat.i(107798);
    this.naN.setTextColor(paramInt);
    AppMethodBeat.o(107798);
  }
  
  public void setSearchContent(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(107797);
    this.naN.setText("");
    this.naN.append(paramCharSequence);
    AppMethodBeat.o(107797);
  }
  
  public void setSearchContent(String paramString)
  {
    AppMethodBeat.i(107806);
    setSearchContent(paramString);
    AppMethodBeat.o(107806);
  }
  
  public void setSearchHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(107799);
    this.naN.setHint(paramCharSequence);
    AppMethodBeat.o(107799);
  }
  
  public void setSearchHintColor(int paramInt)
  {
    AppMethodBeat.i(107800);
    this.naN.setHintTextColor(paramInt);
    AppMethodBeat.o(107800);
  }
  
  public void setSearchIcon(int paramInt)
  {
    AppMethodBeat.i(107801);
    this.naN.setCompoundDrawablesWithIntrinsicBounds(paramInt, 0, 0, 0);
    AppMethodBeat.o(107801);
  }
  
  public void setSearchTipIcon(int paramInt) {}
  
  public void setSelectedTag(String paramString) {}
  
  public void setShowBackIcon(boolean paramBoolean)
  {
    AppMethodBeat.i(107802);
    if (this.ApR != null)
    {
      if (paramBoolean)
      {
        this.ApR.setVisibility(0);
        AppMethodBeat.o(107802);
        return;
      }
      this.ApR.setVisibility(8);
    }
    AppMethodBeat.o(107802);
  }
  
  public void setStatusBtnEnabled(boolean paramBoolean) {}
  
  public static abstract interface a
  {
    public abstract void GL(String paramString);
    
    public abstract void aWD();
    
    public abstract boolean wR(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper
 * JD-Core Version:    0.7.0.1
 */