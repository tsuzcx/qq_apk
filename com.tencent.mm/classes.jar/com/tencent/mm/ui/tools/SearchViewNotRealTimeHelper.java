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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.tools.b.c;
import java.util.ArrayList;

public class SearchViewNotRealTimeHelper
  extends LinearLayout
  implements d
{
  private View QoG;
  private ImageButton QoI;
  private ActionBarSearchView.a QoN;
  public Button Qwv;
  private a Qww;
  private EditText vy;
  
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
    aa.jQ(getContext()).inflate(2131492944, this, true);
    this.vy = ((EditText)findViewById(2131299910));
    this.QoI = ((ImageButton)findViewById(2131308392));
    this.QoG = findViewById(2131296317);
    this.Qwv = ((Button)findViewById(2131297893));
    this.Qwv.setEnabled(false);
    this.vy.addTextChangedListener(new TextWatcher()
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
    this.vy.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
    c.f(this.vy).aoq(100).a(null);
    this.QoI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(143259);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/ui/tools/SearchViewNotRealTimeHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        SearchViewNotRealTimeHelper.d(SearchViewNotRealTimeHelper.this).setText("");
        if (SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this) != null) {
          SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this).cmh();
        }
        a.a(this, "com/tencent/mm/ui/tools/SearchViewNotRealTimeHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(143259);
      }
    });
    this.QoG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(143260);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/ui/tools/SearchViewNotRealTimeHelper$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.v("MicroMsg.SearchViewNotRealTimeHelper", "home btn click");
        if (SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this) != null) {
          SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this);
        }
        if (SearchViewNotRealTimeHelper.e(SearchViewNotRealTimeHelper.this) != null) {
          SearchViewNotRealTimeHelper.e(SearchViewNotRealTimeHelper.this).gXr();
        }
        a.a(this, "com/tencent/mm/ui/tools/SearchViewNotRealTimeHelper$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(143260);
      }
    });
    this.Qwv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(143261);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/ui/tools/SearchViewNotRealTimeHelper$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this) != null) {
          SearchViewNotRealTimeHelper.c(SearchViewNotRealTimeHelper.this).ahN(SearchViewNotRealTimeHelper.this.getSearchContent());
        }
        a.a(this, "com/tencent/mm/ui/tools/SearchViewNotRealTimeHelper$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(143261);
      }
    });
    AppMethodBeat.o(143264);
  }
  
  public final void CG(boolean paramBoolean) {}
  
  public final void CH(boolean paramBoolean)
  {
    AppMethodBeat.i(143272);
    this.vy.setText("");
    AppMethodBeat.o(143272);
  }
  
  public final void gXo()
  {
    AppMethodBeat.i(143273);
    this.vy.clearFocus();
    AppMethodBeat.o(143273);
  }
  
  public final boolean gXp()
  {
    return false;
  }
  
  public final boolean gXq()
  {
    return false;
  }
  
  public String getSearchContent()
  {
    AppMethodBeat.i(143274);
    Object localObject = this.vy.getEditableText();
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
    this.QoN = parama;
  }
  
  public void setCallBack(ActionBarSearchView.b paramb) {}
  
  public void setCallBack(a parama)
  {
    this.Qww = parama;
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
    this.Qww = parama;
  }
  
  public void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener) {}
  
  public void setSearchBtnText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(143265);
    this.Qwv.setText(paramCharSequence);
    AppMethodBeat.o(143265);
  }
  
  public void setSearchColor(int paramInt)
  {
    AppMethodBeat.i(143267);
    this.vy.setTextColor(paramInt);
    AppMethodBeat.o(143267);
  }
  
  public void setSearchContent(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(143266);
    this.vy.setText("");
    this.vy.append(paramCharSequence);
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
    this.vy.setHint(paramCharSequence);
    AppMethodBeat.o(143268);
  }
  
  public void setSearchHintColor(int paramInt)
  {
    AppMethodBeat.i(143269);
    this.vy.setHintTextColor(paramInt);
    AppMethodBeat.o(143269);
  }
  
  public void setSearchIcon(int paramInt)
  {
    AppMethodBeat.i(143270);
    this.vy.setCompoundDrawablesWithIntrinsicBounds(paramInt, 0, 0, 0);
    AppMethodBeat.o(143270);
  }
  
  public void setSearchTipIcon(int paramInt) {}
  
  public void setSelectedTag(String paramString) {}
  
  public void setShowBackIcon(boolean paramBoolean)
  {
    AppMethodBeat.i(143271);
    if (this.QoG != null)
    {
      if (paramBoolean)
      {
        this.QoG.setVisibility(0);
        AppMethodBeat.o(143271);
        return;
      }
      this.QoG.setVisibility(8);
    }
    AppMethodBeat.o(143271);
  }
  
  public void setStatusBtnEnabled(boolean paramBoolean) {}
  
  public static abstract interface a
  {
    public abstract boolean SN(String paramString);
    
    public abstract void ahN(String paramString);
    
    public abstract void cmh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper
 * JD-Core Version:    0.7.0.1
 */