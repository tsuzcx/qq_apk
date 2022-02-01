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
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.tools.b.c;
import java.util.ArrayList;

public class SearchViewNotRealTimeHelper
  extends LinearLayout
  implements e
{
  private View afDg;
  private ImageButton afDi;
  private ActionBarSearchView.a afDo;
  public Button afKP;
  private a afKQ;
  private EditText dzv;
  
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
    af.mU(getContext()).inflate(a.h.actionbar_searchview_with_searchbtn, this, true);
    this.dzv = ((EditText)findViewById(a.g.edittext));
    this.afDi = ((ImageButton)findViewById(a.g.status_btn));
    this.afDg = findViewById(a.g.ab_back_container);
    this.afKP = ((Button)findViewById(a.g.button));
    this.afKP.setEnabled(false);
    this.dzv.addTextChangedListener(new TextWatcher()
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
    this.dzv.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(143258);
        if ((3 == paramAnonymousInt) && (SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this) != null))
        {
          boolean bool = SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this).SN(SearchViewNotRealTimeHelper.this.getSearchContent());
          AppMethodBeat.o(143258);
          return bool;
        }
        AppMethodBeat.o(143258);
        return false;
      }
    });
    c.i(this.dzv).aEg(100).a(null);
    this.afDi.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(143259);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/ui/tools/SearchViewNotRealTimeHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        SearchViewNotRealTimeHelper.d(SearchViewNotRealTimeHelper.this).setText("");
        if (SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this) != null) {
          SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this).dcD();
        }
        a.a(this, "com/tencent/mm/ui/tools/SearchViewNotRealTimeHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(143259);
      }
    });
    this.afDg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(143260);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/ui/tools/SearchViewNotRealTimeHelper$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        Log.v("MicroMsg.SearchViewNotRealTimeHelper", "home btn click");
        if (SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this) != null) {
          SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this);
        }
        if (SearchViewNotRealTimeHelper.e(SearchViewNotRealTimeHelper.this) != null) {
          SearchViewNotRealTimeHelper.e(SearchViewNotRealTimeHelper.this).jCN();
        }
        a.a(this, "com/tencent/mm/ui/tools/SearchViewNotRealTimeHelper$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(143260);
      }
    });
    this.afKP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(143261);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/ui/tools/SearchViewNotRealTimeHelper$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this) != null) {
          SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this).aiU(SearchViewNotRealTimeHelper.this.getSearchContent());
        }
        a.a(this, "com/tencent/mm/ui/tools/SearchViewNotRealTimeHelper$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(143261);
      }
    });
    AppMethodBeat.o(143264);
  }
  
  public final void MV(boolean paramBoolean) {}
  
  public final void MW(boolean paramBoolean)
  {
    AppMethodBeat.i(143272);
    this.dzv.setText("");
    AppMethodBeat.o(143272);
  }
  
  public String getSearchContent()
  {
    AppMethodBeat.i(143274);
    Object localObject = this.dzv.getEditableText();
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
  
  public boolean hasFocus()
  {
    return false;
  }
  
  public final void jCK()
  {
    AppMethodBeat.i(143273);
    this.dzv.clearFocus();
    AppMethodBeat.o(143273);
  }
  
  public final boolean jCL()
  {
    return false;
  }
  
  public final boolean jCM()
  {
    return false;
  }
  
  public void setAutoMatchKeywords(boolean paramBoolean) {}
  
  public void setBackClickCallback(ActionBarSearchView.a parama)
  {
    this.afDo = parama;
  }
  
  public void setCallBack(ActionBarSearchView.b paramb) {}
  
  public void setCallBack(a parama)
  {
    this.afKQ = parama;
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
    AppMethodBeat.i(251246);
    if (this.dzv != null) {
      this.dzv.getInputExtras(true).putInt("wechat_scene", paramInt);
    }
    AppMethodBeat.o(251246);
  }
  
  public void setKeywords(ArrayList<String> paramArrayList) {}
  
  public void setNotRealCallBack(a parama)
  {
    this.afKQ = parama;
  }
  
  public void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener) {}
  
  public void setSearchBtnText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(143265);
    this.afKP.setText(paramCharSequence);
    AppMethodBeat.o(143265);
  }
  
  public void setSearchColor(int paramInt)
  {
    AppMethodBeat.i(143267);
    this.dzv.setTextColor(paramInt);
    AppMethodBeat.o(143267);
  }
  
  public void setSearchContent(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(143266);
    this.dzv.setText("");
    this.dzv.append(paramCharSequence);
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
    this.dzv.setHint(paramCharSequence);
    AppMethodBeat.o(143268);
  }
  
  public void setSearchHintColor(int paramInt)
  {
    AppMethodBeat.i(143269);
    this.dzv.setHintTextColor(paramInt);
    AppMethodBeat.o(143269);
  }
  
  public void setSearchIcon(int paramInt)
  {
    AppMethodBeat.i(143270);
    this.dzv.setCompoundDrawablesWithIntrinsicBounds(paramInt, 0, 0, 0);
    AppMethodBeat.o(143270);
  }
  
  public void setSearchTipIcon(int paramInt) {}
  
  public void setSelectedTag(String paramString) {}
  
  public void setShowBackIcon(boolean paramBoolean)
  {
    AppMethodBeat.i(143271);
    if (this.afDg != null)
    {
      if (paramBoolean)
      {
        this.afDg.setVisibility(0);
        AppMethodBeat.o(143271);
        return;
      }
      this.afDg.setVisibility(8);
    }
    AppMethodBeat.o(143271);
  }
  
  public void setStatusBtnEnabled(boolean paramBoolean) {}
  
  public static abstract interface a
  {
    public abstract boolean SN(String paramString);
    
    public abstract void aiU(String paramString);
    
    public abstract void dcD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper
 * JD-Core Version:    0.7.0.1
 */