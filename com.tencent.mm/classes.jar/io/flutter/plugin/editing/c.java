package io.flutter.plugin.editing;

import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.b;
import io.flutter.embedding.engine.b.m.d;
import java.util.ArrayList;
import java.util.Iterator;

final class c
  extends SpannableStringBuilder
{
  private int aave;
  private int aavf;
  private ArrayList<a> aavg;
  private String aavh;
  private String aavi;
  private int aavj;
  private int aavk;
  private int aavl;
  private int aavm;
  private BaseInputConnection aavn;
  private ArrayList<a> mListeners;
  
  public c(m.d paramd, View paramView)
  {
    AppMethodBeat.i(253928);
    this.aave = 0;
    this.aavf = 0;
    this.mListeners = new ArrayList();
    this.aavg = new ArrayList();
    if (paramd != null) {
      a(paramd);
    }
    this.aavn = new BaseInputConnection(paramView, this)
    {
      public final Editable getEditable()
      {
        return jdField_this;
      }
    };
    AppMethodBeat.o(253928);
  }
  
  private void a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(253942);
    this.aavf += 1;
    parama.Je(paramBoolean);
    this.aavf -= 1;
    AppMethodBeat.o(253942);
  }
  
  private void on(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(253933);
    if ((paramInt1 < 0) || (paramInt1 >= paramInt2))
    {
      BaseInputConnection.removeComposingSpans(this);
      AppMethodBeat.o(253933);
      return;
    }
    this.aavn.setComposingRegion(paramInt1, paramInt2);
    AppMethodBeat.o(253933);
  }
  
  private void q(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(253943);
    if ((paramBoolean1) || (paramBoolean2) || (paramBoolean3))
    {
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext()) {
        a((a)localIterator.next(), paramBoolean1);
      }
    }
    AppMethodBeat.o(253943);
  }
  
  public final void a(m.d paramd)
  {
    AppMethodBeat.i(253935);
    ian();
    replace(0, length(), paramd.text);
    if (paramd.aauj >= 0) {
      Selection.setSelection(this, paramd.aauj, paramd.aauk);
    }
    for (;;)
    {
      on(paramd.aaul, paramd.aaum);
      iao();
      AppMethodBeat.o(253935);
      return;
      Selection.removeSelection(this);
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(253937);
    if (this.aavf > 0)
    {
      new StringBuilder("adding a listener ").append(parama.toString()).append(" in a listener callback");
      b.iAh();
    }
    if (this.aave > 0)
    {
      b.iAf();
      this.aavg.add(parama);
      AppMethodBeat.o(253937);
      return;
    }
    this.mListeners.add(parama);
    AppMethodBeat.o(253937);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(253939);
    if (this.aavf > 0)
    {
      new StringBuilder("removing a listener ").append(parama.toString()).append(" in a listener callback");
      b.iAh();
    }
    this.mListeners.remove(parama);
    if (this.aave > 0) {
      this.aavg.remove(parama);
    }
    AppMethodBeat.o(253939);
  }
  
  public final void ian()
  {
    AppMethodBeat.i(253930);
    this.aave += 1;
    if (this.aavf > 0) {
      b.iAh();
    }
    if ((this.aave == 1) && (!this.mListeners.isEmpty()))
    {
      this.aavi = toString();
      this.aavj = Selection.getSelectionStart(this);
      this.aavk = Selection.getSelectionEnd(this);
      this.aavl = BaseInputConnection.getComposingSpanStart(this);
      this.aavm = BaseInputConnection.getComposingSpanEnd(this);
    }
    AppMethodBeat.o(253930);
  }
  
  public final void iao()
  {
    boolean bool3 = false;
    AppMethodBeat.i(253931);
    if (this.aave == 0)
    {
      b.iAh();
      AppMethodBeat.o(253931);
      return;
    }
    boolean bool1;
    if (this.aave == 1)
    {
      Iterator localIterator = this.aavg.iterator();
      while (localIterator.hasNext()) {
        a((a)localIterator.next(), true);
      }
      if (!this.mListeners.isEmpty())
      {
        new StringBuilder("didFinishBatchEdit with ").append(String.valueOf(this.mListeners.size())).append(" listener(s)");
        b.iAd();
        if (toString().equals(this.aavi)) {
          break label215;
        }
        bool1 = true;
        if ((this.aavj == Selection.getSelectionStart(this)) && (this.aavk == Selection.getSelectionEnd(this))) {
          break label220;
        }
      }
    }
    label215:
    label220:
    for (boolean bool2 = true;; bool2 = false)
    {
      if ((this.aavl != BaseInputConnection.getComposingSpanStart(this)) || (this.aavm != BaseInputConnection.getComposingSpanEnd(this))) {
        bool3 = true;
      }
      q(bool1, bool2, bool3);
      this.mListeners.addAll(this.aavg);
      this.aavg.clear();
      this.aave -= 1;
      AppMethodBeat.o(253931);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final SpannableStringBuilder replace(int paramInt1, int paramInt2, CharSequence paramCharSequence, int paramInt3, int paramInt4)
  {
    boolean bool4 = false;
    AppMethodBeat.i(253941);
    if (this.aavf > 0) {
      b.iAh();
    }
    boolean bool2;
    if (paramInt2 - paramInt1 != paramInt4 - paramInt3)
    {
      bool2 = true;
      i = 0;
      label35:
      if ((i >= paramInt2 - paramInt1) || (bool2)) {
        break label101;
      }
      if (charAt(paramInt1 + i) == paramCharSequence.charAt(paramInt3 + i)) {
        break label95;
      }
    }
    label95:
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 |= bool1;
      i += 1;
      break label35;
      bool2 = false;
      break;
    }
    label101:
    if (bool2) {
      this.aavh = null;
    }
    int i = Selection.getSelectionStart(this);
    int j = Selection.getSelectionEnd(this);
    int k = BaseInputConnection.getComposingSpanStart(this);
    int m = BaseInputConnection.getComposingSpanEnd(this);
    paramCharSequence = super.replace(paramInt1, paramInt2, paramCharSequence, paramInt3, paramInt4);
    if (this.aave > 0)
    {
      AppMethodBeat.o(253941);
      return paramCharSequence;
    }
    if ((Selection.getSelectionStart(this) != i) || (Selection.getSelectionEnd(this) != j)) {}
    for (boolean bool3 = true;; bool3 = false)
    {
      if ((BaseInputConnection.getComposingSpanStart(this) != k) || (BaseInputConnection.getComposingSpanEnd(this) != m)) {
        bool4 = true;
      }
      q(bool2, bool3, bool4);
      AppMethodBeat.o(253941);
      return paramCharSequence;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(253945);
    if (this.aavh != null)
    {
      str = this.aavh;
      AppMethodBeat.o(253945);
      return str;
    }
    String str = super.toString();
    this.aavh = str;
    AppMethodBeat.o(253945);
    return str;
  }
  
  static abstract interface a
  {
    public abstract void Je(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.plugin.editing.c
 * JD-Core Version:    0.7.0.1
 */