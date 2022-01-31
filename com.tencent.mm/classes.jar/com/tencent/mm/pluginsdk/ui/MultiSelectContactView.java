package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.HashSet;

public class MultiSelectContactView
  extends LinearLayout
{
  private LayoutInflater exe;
  private View kgr;
  private int padding;
  private RecyclerView vRa;
  private ArrayList<String> vRb;
  private HashSet<String> vRc;
  private Animation vRd;
  private int vRe;
  private MultiSelectContactView.c vRf;
  private MultiSelectContactView.d vRg;
  private MultiSelectContactView.e vRh;
  int vRi;
  boolean vRj;
  MMEditText vRk;
  ImageView vRl;
  
  public MultiSelectContactView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(105165);
    this.vRb = new ArrayList();
    this.vRe = 0;
    this.padding = 0;
    this.vRi = getResources().getDimensionPixelSize(2131427546);
    this.vRj = false;
    this.padding = getResources().getDimensionPixelSize(2131427496);
    this.exe = LayoutInflater.from(paramContext);
    this.exe.inflate(2130970332, this, true);
    this.vRa = ((RecyclerView)findViewById(2131826464));
    getContext();
    paramAttributeSet = new LinearLayoutManager();
    paramAttributeSet.setOrientation(0);
    this.vRa.setLayoutManager(paramAttributeSet);
    this.vRa.setAdapter(new MultiSelectContactView.a(this));
    this.vRc = new HashSet();
    this.vRd = AnimationUtils.loadAnimation(paramContext, 2131034181);
    this.kgr = findViewById(2131821003);
    setBackgroundColor(-201326593);
    setOnClickListener(new MultiSelectContactView.1(this));
    AppMethodBeat.o(105165);
  }
  
  private void cb(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(146178);
    if ((paramBoolean) && (this.vRf != null)) {
      this.vRf.wK(paramString);
    }
    int i = this.vRb.indexOf(paramString);
    if ((i >= 0) && (i < this.vRb.size()))
    {
      this.vRc.remove(this.vRb.remove(i));
      this.vRa.getAdapter().bT(i);
    }
    dni();
    dnh();
    AppMethodBeat.o(146178);
  }
  
  private void dng()
  {
    AppMethodBeat.i(105171);
    if (this.vRa.getChildCount() == 1)
    {
      AppMethodBeat.o(105171);
      return;
    }
    View localView = this.vRa.getChildAt(this.vRa.getChildCount() - 2);
    if (this.vRj)
    {
      if (localView == null)
      {
        AppMethodBeat.o(105171);
        return;
      }
      this.vRj = false;
      localView.findViewById(2131827529).setVisibility(8);
    }
    AppMethodBeat.o(105171);
  }
  
  private void dnh()
  {
    AppMethodBeat.i(146177);
    int i = Math.max(this.vRi * 2, this.vRa.getWidth() - (this.vRb.size() + 1) * this.vRi);
    if (getInputText().getWidth() != i) {
      getInputText().setWidth(i);
    }
    AppMethodBeat.o(146177);
  }
  
  private void dni()
  {
    AppMethodBeat.i(105176);
    View localView = getSearchIcon();
    if (this.vRa.getAdapter().getItemCount() <= 1) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(105176);
      return;
    }
  }
  
  public final void ama(String paramString)
  {
    AppMethodBeat.i(105169);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(105169);
      return;
    }
    dng();
    if (this.vRc.contains(paramString))
    {
      cb(paramString, false);
      AppMethodBeat.o(105169);
      return;
    }
    amc(paramString);
    AppMethodBeat.o(105169);
  }
  
  public final void amb(String paramString)
  {
    AppMethodBeat.i(105170);
    if (paramString != null)
    {
      cb(paramString, false);
      AppMethodBeat.o(105170);
      return;
    }
    AppMethodBeat.o(105170);
  }
  
  public final void amc(String paramString)
  {
    AppMethodBeat.i(146176);
    this.vRc.add(paramString);
    this.vRb.add(paramString);
    int i = this.vRa.getAdapter().getItemCount();
    this.vRa.getAdapter().bS(i - 2);
    this.vRa.bJ(i - 1);
    dni();
    dnh();
    AppMethodBeat.o(146176);
  }
  
  public void clearFocus()
  {
    AppMethodBeat.i(105168);
    getInputText().clearFocus();
    dng();
    AppMethodBeat.o(105168);
  }
  
  public final void g(HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(146175);
    this.vRb.clear();
    this.vRc.clear();
    this.vRb.addAll(paramHashSet);
    this.vRc.addAll(paramHashSet);
    this.vRa.getAdapter().ajb.notifyChanged();
    int i = this.vRa.getAdapter().getItemCount();
    this.vRa.bJ(i - 1);
    dni();
    dnh();
    AppMethodBeat.o(146175);
  }
  
  public EditText getInputText()
  {
    return this.vRk;
  }
  
  public String getSearchContent()
  {
    AppMethodBeat.i(105177);
    String str = getInputText().getText().toString();
    AppMethodBeat.o(105177);
    return str;
  }
  
  public b getSearchHolder()
  {
    AppMethodBeat.i(146179);
    b localb = (b)this.vRa.k(this.vRa.getAdapter().getItemCount() - 1, false);
    AppMethodBeat.o(146179);
    return localb;
  }
  
  public View getSearchIcon()
  {
    return this.vRl;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(146174);
    super.onAttachedToWindow();
    AppMethodBeat.o(146174);
  }
  
  public void setOnContactDeselectListener(MultiSelectContactView.c paramc)
  {
    this.vRf = paramc;
  }
  
  public void setOnSearchTextChangeListener(MultiSelectContactView.d paramd)
  {
    this.vRg = paramd;
  }
  
  public void setOnSearchTextFouceChangeListener(MultiSelectContactView.e parame)
  {
    this.vRh = parame;
  }
  
  final class b
    extends RecyclerView.v
  {
    ImageView ehv;
    
    public b(View paramView, int paramInt)
    {
      super();
      AppMethodBeat.i(146173);
      if (paramInt != 1)
      {
        this.ehv = ((ImageView)paramView.findViewById(2131823820));
        paramInt = MultiSelectContactView.this.vRi;
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramInt, paramInt);
        localLayoutParams.rightMargin = MultiSelectContactView.this.getResources().getDimensionPixelSize(2131427496);
        paramView.setLayoutParams(localLayoutParams);
        paramView.setOnClickListener(new MultiSelectContactView.b.1(this, MultiSelectContactView.this));
        AppMethodBeat.o(146173);
        return;
      }
      MultiSelectContactView.this.vRl = ((ImageView)paramView.findViewById(2131823363));
      MultiSelectContactView.this.vRk = ((MMEditText)paramView.findViewById(2131823364));
      MultiSelectContactView.this.vRk.setWidth(MultiSelectContactView.this.getResources().getDisplayMetrics().widthPixels - MultiSelectContactView.this.vRi * 2);
      c.d(MultiSelectContactView.this.vRk).QS(100).a(null);
      MultiSelectContactView.this.vRk.addTextChangedListener(new MultiSelectContactView.b.2(this, MultiSelectContactView.this));
      MultiSelectContactView.this.vRk.setOnKeyListener(new MultiSelectContactView.b.3(this, MultiSelectContactView.this));
      MultiSelectContactView.this.vRk.clearFocus();
      MultiSelectContactView.this.vRk.setOnFocusChangeListener(new MultiSelectContactView.b.4(this, MultiSelectContactView.this));
      MultiSelectContactView.this.vRk.post(new MultiSelectContactView.b.5(this, MultiSelectContactView.this));
      AppMethodBeat.o(146173);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.MultiSelectContactView
 * JD-Core Version:    0.7.0.1
 */