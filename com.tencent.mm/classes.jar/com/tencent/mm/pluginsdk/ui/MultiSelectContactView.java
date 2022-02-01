package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.v;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MultiSelectContactView
  extends LinearLayout
{
  private RecyclerView BVI;
  private HashSet<String> BVJ;
  private Animation BVK;
  private int BVL;
  private MultiSelectContactView.c BVM;
  private MultiSelectContactView.d BVN;
  private MultiSelectContactView.e BVO;
  int BVP;
  boolean BVQ;
  MMEditText BVR;
  ImageView BVS;
  private View frN;
  private LayoutInflater imq;
  private ArrayList<String> qHA;
  
  public MultiSelectContactView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(102785);
    this.qHA = new ArrayList();
    this.BVL = 0;
    this.BVP = getResources().getDimensionPixelSize(2131165239);
    this.BVQ = false;
    this.imq = LayoutInflater.from(paramContext);
    this.imq.inflate(2131494988, this, true);
    this.BVI = ((RecyclerView)findViewById(2131302625));
    getContext();
    paramAttributeSet = new LinearLayoutManager();
    paramAttributeSet.setOrientation(0);
    this.BVI.setLayoutManager(paramAttributeSet);
    this.BVI.setAdapter(new a());
    this.BVJ = new HashSet();
    this.BVK = AnimationUtils.loadAnimation(paramContext, 2130772047);
    this.frN = findViewById(2131304239);
    setBackgroundColor(ao.aD(getContext(), 2130968579));
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(102774);
        AppMethodBeat.o(102774);
      }
    });
    AppMethodBeat.o(102785);
  }
  
  private void co(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(102794);
    int i = this.qHA.indexOf(paramString);
    if ((i >= 0) && (i < this.qHA.size()))
    {
      this.BVJ.remove(this.qHA.remove(i));
      this.BVI.getAdapter().cm(i);
    }
    exC();
    exB();
    if ((paramBoolean) && (this.BVM != null)) {
      this.BVM.N(1, paramString);
    }
    AppMethodBeat.o(102794);
  }
  
  private void exA()
  {
    AppMethodBeat.i(102791);
    if (this.BVI.getChildCount() == 1)
    {
      AppMethodBeat.o(102791);
      return;
    }
    View localView = this.BVI.getChildAt(this.BVI.getChildCount() - 2);
    if (this.BVQ)
    {
      if (localView == null)
      {
        AppMethodBeat.o(102791);
        return;
      }
      this.BVQ = false;
      localView = localView.findViewById(2131302160);
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
    AppMethodBeat.o(102791);
  }
  
  private void exB()
  {
    AppMethodBeat.i(102793);
    int i = Math.max(this.BVP * 2, this.BVI.getWidth() - (this.qHA.size() + 1) * this.BVP);
    if ((getInputText() != null) && (getInputText().getWidth() != i)) {
      getInputText().setWidth(i);
    }
    AppMethodBeat.o(102793);
  }
  
  private void exC()
  {
    AppMethodBeat.i(102795);
    View localView;
    if (getSearchIcon() != null)
    {
      localView = getSearchIcon();
      if (this.BVI.getAdapter().getItemCount() > 1) {
        break label46;
      }
    }
    label46:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(102795);
      return;
    }
  }
  
  public final void aBC(String paramString)
  {
    AppMethodBeat.i(102789);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(102789);
      return;
    }
    exA();
    if (this.BVJ.contains(paramString))
    {
      co(paramString, false);
      AppMethodBeat.o(102789);
      return;
    }
    aBE(paramString);
    AppMethodBeat.o(102789);
  }
  
  public final void aBD(String paramString)
  {
    AppMethodBeat.i(102790);
    if (paramString != null)
    {
      co(paramString, false);
      AppMethodBeat.o(102790);
      return;
    }
    AppMethodBeat.o(102790);
  }
  
  public final void aBE(String paramString)
  {
    AppMethodBeat.i(102792);
    this.BVJ.add(paramString);
    this.qHA.add(paramString);
    int i = this.BVI.getAdapter().getItemCount();
    this.BVI.getAdapter().cl(i - 2);
    RecyclerView localRecyclerView = this.BVI;
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i - 1, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.adn(), "com/tencent/mm/pluginsdk/ui/MultiSelectContactView", "addContact", "(Ljava/lang/String;Z)V", "Undefined", "scrollToPosition", "(I)V");
    localRecyclerView.ca(((Integer)locala.lS(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/pluginsdk/ui/MultiSelectContactView", "addContact", "(Ljava/lang/String;Z)V", "Undefined", "scrollToPosition", "(I)V");
    exC();
    exB();
    if (this.BVM != null) {
      this.BVM.N(0, paramString);
    }
    AppMethodBeat.o(102792);
  }
  
  public void clearFocus()
  {
    AppMethodBeat.i(102787);
    getInputText().clearFocus();
    exA();
    AppMethodBeat.o(102787);
  }
  
  public final void gG(List<String> paramList)
  {
    AppMethodBeat.i(102788);
    this.qHA.clear();
    this.BVJ.clear();
    this.qHA.addAll(paramList);
    this.BVJ.addAll(paramList);
    this.BVI.getAdapter().aql.notifyChanged();
    int i = this.BVI.getAdapter().getItemCount();
    paramList = this.BVI;
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i - 1, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(paramList, locala.adn(), "com/tencent/mm/pluginsdk/ui/MultiSelectContactView", "multiSelectChanged", "(Ljava/util/List;)V", "Undefined", "scrollToPosition", "(I)V");
    paramList.ca(((Integer)locala.lS(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(paramList, "com/tencent/mm/pluginsdk/ui/MultiSelectContactView", "multiSelectChanged", "(Ljava/util/List;)V", "Undefined", "scrollToPosition", "(I)V");
    exC();
    exB();
    AppMethodBeat.o(102788);
  }
  
  public EditText getInputText()
  {
    return this.BVR;
  }
  
  public String getSearchContent()
  {
    AppMethodBeat.i(102796);
    String str = getInputText().getText().toString();
    AppMethodBeat.o(102796);
    return str;
  }
  
  public b getSearchHolder()
  {
    AppMethodBeat.i(102797);
    b localb = (b)this.BVI.j(this.BVI.getAdapter().getItemCount() - 1, false);
    AppMethodBeat.o(102797);
    return localb;
  }
  
  public View getSearchIcon()
  {
    return this.BVS;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(102786);
    super.onAttachedToWindow();
    AppMethodBeat.o(102786);
  }
  
  public void setHiddenSearchWord(String paramString) {}
  
  public void setOnContactDeselectListener(MultiSelectContactView.c paramc)
  {
    this.BVM = paramc;
  }
  
  public void setOnSearchTextChangeListener(MultiSelectContactView.d paramd)
  {
    this.BVN = paramd;
  }
  
  public void setOnSearchTextFouceChangeListener(MultiSelectContactView.e parame)
  {
    this.BVO = parame;
  }
  
  final class a
    extends RecyclerView.a<MultiSelectContactView.b>
  {
    a() {}
    
    public final int getItemCount()
    {
      AppMethodBeat.i(102776);
      int i = MultiSelectContactView.b(MultiSelectContactView.this).size();
      AppMethodBeat.o(102776);
      return i + 1;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(102775);
      if (paramInt == getItemCount() - 1)
      {
        AppMethodBeat.o(102775);
        return 1;
      }
      AppMethodBeat.o(102775);
      return 0;
    }
  }
  
  final class b
    extends RecyclerView.v
  {
    ImageView fuj;
    
    public b(View paramView, int paramInt)
    {
      super();
      AppMethodBeat.i(102784);
      if (paramInt != 1)
      {
        this.fuj = ((ImageView)paramView.findViewById(2131296996));
        paramInt = MultiSelectContactView.this.BVP;
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramInt, paramInt);
        localLayoutParams.rightMargin = MultiSelectContactView.this.getResources().getDimensionPixelSize(2131165187);
        paramView.setLayoutParams(localLayoutParams);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(102779);
            MultiSelectContactView.a(MultiSelectContactView.this, (String)paramAnonymousView.getTag());
            AppMethodBeat.o(102779);
          }
        });
        AppMethodBeat.o(102784);
        return;
      }
      MultiSelectContactView.this.BVS = ((ImageView)paramView.findViewById(2131302627));
      MultiSelectContactView.this.BVR = ((MMEditText)paramView.findViewById(2131302626));
      MultiSelectContactView.this.BVR.setWidth(MultiSelectContactView.this.getResources().getDisplayMetrics().widthPixels - MultiSelectContactView.this.BVP * 2);
      com.tencent.mm.ui.tools.b.c.d(MultiSelectContactView.this.BVR).aaj(100).a(null);
      MultiSelectContactView.this.BVR.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(102780);
          MultiSelectContactView.c(MultiSelectContactView.this);
          if (MultiSelectContactView.d(MultiSelectContactView.this) != null) {
            MultiSelectContactView.d(MultiSelectContactView.this).aBF(paramAnonymousCharSequence.toString());
          }
          AppMethodBeat.o(102780);
        }
      });
      MultiSelectContactView.this.BVR.setOnKeyListener(new View.OnKeyListener()
      {
        public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(102781);
          if ((paramAnonymousInt == 67) && (paramAnonymousKeyEvent.getAction() == 0) && (MultiSelectContactView.this.getInputText().getSelectionStart() == 0) && (MultiSelectContactView.this.getInputText().getSelectionEnd() == 0)) {
            MultiSelectContactView.e(MultiSelectContactView.this);
          }
          AppMethodBeat.o(102781);
          return false;
        }
      });
      MultiSelectContactView.this.BVR.clearFocus();
      MultiSelectContactView.this.BVR.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(102782);
          if (MultiSelectContactView.f(MultiSelectContactView.this) != null) {
            MultiSelectContactView.f(MultiSelectContactView.this).exD();
          }
          AppMethodBeat.o(102782);
        }
      });
      MultiSelectContactView.this.BVR.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(102783);
          MultiSelectContactView.g(MultiSelectContactView.this);
          AppMethodBeat.o(102783);
        }
      });
      AppMethodBeat.o(102784);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.MultiSelectContactView
 * JD-Core Version:    0.7.0.1
 */