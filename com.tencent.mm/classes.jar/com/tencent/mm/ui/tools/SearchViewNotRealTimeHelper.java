package com.tencent.mm.ui.tools;

import android.content.Context;
import android.os.Bundle;
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
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.tools.b.c;
import java.util.ArrayList;

public class SearchViewNotRealTimeHelper
  extends LinearLayout
  implements e
{
  private View XMT;
  private ImageButton XMV;
  private ActionBarSearchView.a XNa;
  public Button XUA;
  private a XUB;
  private EditText bGw;
  
  public SearchViewNotRealTimeHelper(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(143263);
    init();
    AppMethodBeat.o(143263);
  }
  
  public SearchViewNotRealTimeHelper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143262);
    init();
    AppMethodBeat.o(143262);
  }
  
  private void init()
  {
    AppMethodBeat.i(143264);
    ad.kS(getContext()).inflate(a.h.actionbar_searchview_with_searchbtn, this, true);
    this.bGw = ((EditText)findViewById(a.g.edittext));
    this.XMV = ((ImageButton)findViewById(a.g.status_btn));
    this.XMT = findViewById(a.g.ab_back_container);
    this.XUA = ((Button)findViewById(a.g.button));
    this.XUA.setEnabled(false);
    this.bGw.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(143257);
        if ((paramAnonymousEditable == null) || (paramAnonymousEditable.length() <= 0))
        {
          SearchViewNotRealTimeHelper.a(SearchViewNotRealTimeHelper.this).setVisibility(8);
          SearchViewNotRealTimeHelper.b(SearchViewNotRealTimeHelper.this).setEnabled(false);
          AppMethodBeat.o(143257);
          return;
        }
        SearchViewNotRealTimeHelper.a(SearchViewNotRealTimeHelper.this).setVisibility(0);
        SearchViewNotRealTimeHelper.b(SearchViewNotRealTimeHelper.this).setEnabled(true);
        AppMethodBeat.o(143257);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.bGw.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(143258);
        if ((3 == paramAnonymousInt) && (SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this) != null))
        {
          boolean bool = SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this).aat(SearchViewNotRealTimeHelper.this.getSearchContent());
          AppMethodBeat.o(143258);
          return bool;
        }
        AppMethodBeat.o(143258);
        return false;
      }
    });
    c.i(this.bGw).axx(100).a(null);
    this.XMV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(143259);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/ui/tools/SearchViewNotRealTimeHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        SearchViewNotRealTimeHelper.d(SearchViewNotRealTimeHelper.this).setText("");
        if (SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this) != null) {
          SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this).czL();
        }
        a.a(this, "com/tencent/mm/ui/tools/SearchViewNotRealTimeHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(143259);
      }
    });
    this.XMT.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(143260);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/ui/tools/SearchViewNotRealTimeHelper$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.v("MicroMsg.SearchViewNotRealTimeHelper", "home btn click");
        if (SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this) != null) {
          SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this);
        }
        if (SearchViewNotRealTimeHelper.e(SearchViewNotRealTimeHelper.this) != null) {
          SearchViewNotRealTimeHelper.e(SearchViewNotRealTimeHelper.this).hYd();
        }
        a.a(this, "com/tencent/mm/ui/tools/SearchViewNotRealTimeHelper$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(143260);
      }
    });
    this.XUA.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(143261);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/ui/tools/SearchViewNotRealTimeHelper$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this) != null) {
          SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this).apz(SearchViewNotRealTimeHelper.this.getSearchContent());
        }
        a.a(this, "com/tencent/mm/ui/tools/SearchViewNotRealTimeHelper$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(143261);
      }
    });
    AppMethodBeat.o(143264);
  }
  
  public final void Ha(boolean paramBoolean) {}
  
  public final void Hb(boolean paramBoolean)
  {
    AppMethodBeat.i(143272);
    this.bGw.setText("");
    AppMethodBeat.o(143272);
  }
  
  public String getSearchContent()
  {
    AppMethodBeat.i(143274);
    Object localObject = this.bGw.getEditableText();
    if (localObject == null)
    {
      AppMethodBeat.o(143274);
      return "";
    }
    localObject = localObject.toString();
    AppMethodBeat.o(143274);
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
  
  public final void hYa()
  {
    AppMethodBeat.i(143273);
    this.bGw.clearFocus();
    AppMethodBeat.o(143273);
  }
  
  public final boolean hYb()
  {
    return false;
  }
  
  public final boolean hYc()
  {
    return false;
  }
  
  public boolean hasFocus()
  {
    return false;
  }
  
  public void setAutoMatchKeywords(boolean paramBoolean) {}
  
  public void setBackClickCallback(ActionBarSearchView.a parama)
  {
    this.XNa = parama;
  }
  
  public void setCallBack(ActionBarSearchView.b paramb) {}
  
  public void setCallBack(a parama)
  {
    this.XUB = parama;
  }
  
  public void setEditTextEnabled(boolean paramBoolean) {}
  
  public void setFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener) {}
  
  public void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(143276);
    setSearchHint(paramCharSequence);
    AppMethodBeat.o(143276);
  }
  
  public void setImeScene(int paramInt)
  {
    AppMethodBeat.i(192336);
    if (this.bGw != null) {
      this.bGw.getInputExtras(true).putInt("wechat_scene", paramInt);
    }
    AppMethodBeat.o(192336);
  }
  
  public void setKeywords(ArrayList<String> paramArrayList) {}
  
  public void setNotRealCallBack(a parama)
  {
    this.XUB = parama;
  }
  
  public void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener) {}
  
  public void setSearchBtnText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(143265);
    this.XUA.setText(paramCharSequence);
    AppMethodBeat.o(143265);
  }
  
  public void setSearchColor(int paramInt)
  {
    AppMethodBeat.i(143267);
    this.bGw.setTextColor(paramInt);
    AppMethodBeat.o(143267);
  }
  
  public void setSearchContent(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(143266);
    this.bGw.setText("");
    this.bGw.append(paramCharSequence);
    AppMethodBeat.o(143266);
  }
  
  public void setSearchContent(String paramString)
  {
    AppMethodBeat.i(143275);
    setSearchContent(paramString);
    AppMethodBeat.o(143275);
  }
  
  public void setSearchHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(143268);
    this.bGw.setHint(paramCharSequence);
    AppMethodBeat.o(143268);
  }
  
  public void setSearchHintColor(int paramInt)
  {
    AppMethodBeat.i(143269);
    this.bGw.setHintTextColor(paramInt);
    AppMethodBeat.o(143269);
  }
  
  public void setSearchIcon(int paramInt)
  {
    AppMethodBeat.i(143270);
    this.bGw.setCompoundDrawablesWithIntrinsicBounds(paramInt, 0, 0, 0);
    AppMethodBeat.o(143270);
  }
  
  public void setSearchTipIcon(int paramInt) {}
  
  public void setSelectedTag(String paramString) {}
  
  public void setShowBackIcon(boolean paramBoolean)
  {
    AppMethodBeat.i(143271);
    if (this.XMT != null)
    {
      if (paramBoolean)
      {
        this.XMT.setVisibility(0);
        AppMethodBeat.o(143271);
        return;
      }
      this.XMT.setVisibility(8);
    }
    AppMethodBeat.o(143271);
  }
  
  public void setStatusBtnEnabled(boolean paramBoolean) {}
  
  public static abstract interface a
  {
    public abstract boolean aat(String paramString);
    
    public abstract void apz(String paramString);
    
    public abstract void czL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper
 * JD-Core Version:    0.7.0.1
 */