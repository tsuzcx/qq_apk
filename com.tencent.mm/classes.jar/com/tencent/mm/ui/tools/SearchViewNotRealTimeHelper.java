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
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.ui.tools.a.c;
import java.util.ArrayList;

public class SearchViewNotRealTimeHelper
  extends LinearLayout
  implements d
{
  private EditText kEp;
  private View vXE;
  private ImageButton vXG;
  private ActionBarSearchView.a vXL;
  public Button weC;
  private a weD;
  
  public SearchViewNotRealTimeHelper(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public SearchViewNotRealTimeHelper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void init()
  {
    com.tencent.mm.ui.y.gt(getContext()).inflate(a.h.actionbar_searchview_with_searchbtn, this, true);
    this.kEp = ((EditText)findViewById(a.g.edittext));
    this.vXG = ((ImageButton)findViewById(a.g.status_btn));
    this.vXE = findViewById(a.g.ab_back_container);
    this.weC = ((Button)findViewById(a.g.button));
    this.weC.setEnabled(false);
    this.kEp.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        if ((paramAnonymousEditable == null) || (paramAnonymousEditable.length() <= 0))
        {
          SearchViewNotRealTimeHelper.a(SearchViewNotRealTimeHelper.this).setVisibility(8);
          SearchViewNotRealTimeHelper.b(SearchViewNotRealTimeHelper.this).setEnabled(false);
          return;
        }
        SearchViewNotRealTimeHelper.a(SearchViewNotRealTimeHelper.this).setVisibility(0);
        SearchViewNotRealTimeHelper.b(SearchViewNotRealTimeHelper.this).setEnabled(true);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.kEp.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((3 == paramAnonymousInt) && (SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this) != null)) {
          return SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this).pB(SearchViewNotRealTimeHelper.this.getSearchContent());
        }
        return false;
      }
    });
    c.d(this.kEp).Ig(100).a(null);
    this.vXG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        SearchViewNotRealTimeHelper.d(SearchViewNotRealTimeHelper.this).setText("");
        if (SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this) != null) {
          SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this).axG();
        }
      }
    });
    this.vXE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        com.tencent.mm.sdk.platformtools.y.v("MicroMsg.SearchViewNotRealTimeHelper", "home btn click");
        if (SearchViewNotRealTimeHelper.e(SearchViewNotRealTimeHelper.this) != null) {
          SearchViewNotRealTimeHelper.e(SearchViewNotRealTimeHelper.this).beS();
        }
      }
    });
    this.weC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        if (SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this) != null) {
          SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this).xR(SearchViewNotRealTimeHelper.this.getSearchContent());
        }
      }
    });
  }
  
  public final void cIJ()
  {
    this.kEp.clearFocus();
  }
  
  public final boolean cIK()
  {
    return false;
  }
  
  public final boolean cIL()
  {
    return false;
  }
  
  public final void fF(int paramInt1, int paramInt2) {}
  
  public String getSearchContent()
  {
    Editable localEditable = this.kEp.getEditableText();
    if (localEditable == null) {
      return "";
    }
    return localEditable.toString();
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
  
  public final void nH(boolean paramBoolean) {}
  
  public final void nI(boolean paramBoolean)
  {
    this.kEp.setText("");
  }
  
  public void setAutoMatchKeywords(boolean paramBoolean) {}
  
  public void setBackClickCallback(ActionBarSearchView.a parama)
  {
    this.vXL = parama;
  }
  
  public void setCallBack(ActionBarSearchView.b paramb) {}
  
  public void setCallBack(a parama)
  {
    this.weD = parama;
  }
  
  public void setEditTextEnabled(boolean paramBoolean) {}
  
  public void setFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener) {}
  
  public void setHint(CharSequence paramCharSequence)
  {
    setSearchHint(paramCharSequence);
  }
  
  public void setKeywords(ArrayList<String> paramArrayList) {}
  
  public void setNotRealCallBack(a parama)
  {
    this.weD = parama;
  }
  
  public void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener) {}
  
  public void setSearchBtnText(CharSequence paramCharSequence)
  {
    this.weC.setText(paramCharSequence);
  }
  
  public void setSearchColor(int paramInt)
  {
    this.kEp.setTextColor(paramInt);
  }
  
  public void setSearchContent(CharSequence paramCharSequence)
  {
    this.kEp.setText("");
    this.kEp.append(paramCharSequence);
  }
  
  public void setSearchContent(String paramString)
  {
    setSearchContent(paramString);
  }
  
  public void setSearchHint(CharSequence paramCharSequence)
  {
    this.kEp.setHint(paramCharSequence);
  }
  
  public void setSearchHintColor(int paramInt)
  {
    this.kEp.setHintTextColor(paramInt);
  }
  
  public void setSearchIcon(int paramInt)
  {
    this.kEp.setCompoundDrawablesWithIntrinsicBounds(paramInt, 0, 0, 0);
  }
  
  public void setSearchTipIcon(int paramInt) {}
  
  public void setSelectedTag(String paramString) {}
  
  public void setShowBackIcon(boolean paramBoolean)
  {
    if (this.vXE != null)
    {
      if (paramBoolean) {
        this.vXE.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.vXE.setVisibility(8);
  }
  
  public void setStatusBtnEnabled(boolean paramBoolean) {}
  
  public static abstract interface a
  {
    public abstract void axG();
    
    public abstract boolean pB(String paramString);
    
    public abstract void xR(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper
 * JD-Core Version:    0.7.0.1
 */