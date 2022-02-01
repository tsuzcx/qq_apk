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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.z;
import java.util.ArrayList;

public class SearchViewNotRealTimeHelper
  extends LinearLayout
  implements d
{
  private View KDl;
  private ImageButton KDn;
  private ActionBarSearchView.a KDs;
  public Button KLd;
  private a KLe;
  private EditText vr;
  
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
    z.jO(getContext()).inflate(2131492925, this, true);
    this.vr = ((EditText)findViewById(2131299306));
    this.KDn = ((ImageButton)findViewById(2131305196));
    this.KDl = findViewById(2131296304);
    this.KLd = ((Button)findViewById(2131297631));
    this.KLd.setEnabled(false);
    this.vr.addTextChangedListener(new TextWatcher()
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
    this.vr.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(143258);
        if ((3 == paramAnonymousInt) && (SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this) != null))
        {
          boolean bool = SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this).Jp(SearchViewNotRealTimeHelper.this.getSearchContent());
          AppMethodBeat.o(143258);
          return bool;
        }
        AppMethodBeat.o(143258);
        return false;
      }
    });
    c.d(this.vr).aeU(100).a(null);
    this.KDn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(143259);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/ui/tools/SearchViewNotRealTimeHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        SearchViewNotRealTimeHelper.d(SearchViewNotRealTimeHelper.this).setText("");
        if (SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this) != null) {
          SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this).bOe();
        }
        a.a(this, "com/tencent/mm/ui/tools/SearchViewNotRealTimeHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(143259);
      }
    });
    this.KDl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(143260);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/ui/tools/SearchViewNotRealTimeHelper$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.v("MicroMsg.SearchViewNotRealTimeHelper", "home btn click");
        if (SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this) != null) {
          SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this);
        }
        if (SearchViewNotRealTimeHelper.e(SearchViewNotRealTimeHelper.this) != null) {
          SearchViewNotRealTimeHelper.e(SearchViewNotRealTimeHelper.this).fKh();
        }
        a.a(this, "com/tencent/mm/ui/tools/SearchViewNotRealTimeHelper$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(143260);
      }
    });
    this.KLd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(143261);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/ui/tools/SearchViewNotRealTimeHelper$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this) != null) {
          SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this).Xe(SearchViewNotRealTimeHelper.this.getSearchContent());
        }
        a.a(this, "com/tencent/mm/ui/tools/SearchViewNotRealTimeHelper$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(143261);
      }
    });
    AppMethodBeat.o(143264);
  }
  
  public final void fKe()
  {
    AppMethodBeat.i(143273);
    this.vr.clearFocus();
    AppMethodBeat.o(143273);
  }
  
  public final boolean fKf()
  {
    return false;
  }
  
  public final boolean fKg()
  {
    return false;
  }
  
  public String getSearchContent()
  {
    AppMethodBeat.i(143274);
    Object localObject = this.vr.getEditableText();
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
  
  public void setAutoMatchKeywords(boolean paramBoolean) {}
  
  public void setBackClickCallback(ActionBarSearchView.a parama)
  {
    this.KDs = parama;
  }
  
  public void setCallBack(ActionBarSearchView.b paramb) {}
  
  public void setCallBack(a parama)
  {
    this.KLe = parama;
  }
  
  public void setEditTextEnabled(boolean paramBoolean) {}
  
  public void setFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener) {}
  
  public void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(143276);
    setSearchHint(paramCharSequence);
    AppMethodBeat.o(143276);
  }
  
  public void setKeywords(ArrayList<String> paramArrayList) {}
  
  public void setNotRealCallBack(a parama)
  {
    this.KLe = parama;
  }
  
  public void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener) {}
  
  public void setSearchBtnText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(143265);
    this.KLd.setText(paramCharSequence);
    AppMethodBeat.o(143265);
  }
  
  public void setSearchColor(int paramInt)
  {
    AppMethodBeat.i(143267);
    this.vr.setTextColor(paramInt);
    AppMethodBeat.o(143267);
  }
  
  public void setSearchContent(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(143266);
    this.vr.setText("");
    this.vr.append(paramCharSequence);
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
    this.vr.setHint(paramCharSequence);
    AppMethodBeat.o(143268);
  }
  
  public void setSearchHintColor(int paramInt)
  {
    AppMethodBeat.i(143269);
    this.vr.setHintTextColor(paramInt);
    AppMethodBeat.o(143269);
  }
  
  public void setSearchIcon(int paramInt)
  {
    AppMethodBeat.i(143270);
    this.vr.setCompoundDrawablesWithIntrinsicBounds(paramInt, 0, 0, 0);
    AppMethodBeat.o(143270);
  }
  
  public void setSearchTipIcon(int paramInt) {}
  
  public void setSelectedTag(String paramString) {}
  
  public void setShowBackIcon(boolean paramBoolean)
  {
    AppMethodBeat.i(143271);
    if (this.KDl != null)
    {
      if (paramBoolean)
      {
        this.KDl.setVisibility(0);
        AppMethodBeat.o(143271);
        return;
      }
      this.KDl.setVisibility(8);
    }
    AppMethodBeat.o(143271);
  }
  
  public void setStatusBtnEnabled(boolean paramBoolean) {}
  
  public final void yA(boolean paramBoolean)
  {
    AppMethodBeat.i(143272);
    this.vr.setText("");
    AppMethodBeat.o(143272);
  }
  
  public final void yz(boolean paramBoolean) {}
  
  public static abstract interface a
  {
    public abstract boolean Jp(String paramString);
    
    public abstract void Xe(String paramString);
    
    public abstract void bOe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper
 * JD-Core Version:    0.7.0.1
 */