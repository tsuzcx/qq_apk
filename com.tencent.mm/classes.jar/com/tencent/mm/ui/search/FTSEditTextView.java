package com.tencent.mm.ui.search;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ah.a.k;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.tools.g.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FTSEditTextView
  extends LinearLayout
{
  private TextView TOk;
  private TextView TOl;
  private TextView TPt;
  private View Xcf;
  protected boolean Xcn;
  private View afBX;
  private boolean afBY;
  private boolean afBZ;
  private boolean afCa;
  private boolean afCb;
  protected View afCc;
  private FTSEditTextView.a afCd;
  private View.OnClickListener afCe;
  private c afCf;
  public final ArrayList<b> afCg;
  private FTSEditTextView.d afCh;
  public EditText dzv;
  private String hint;
  public WeImageView mpe;
  private ImageButton mpf;
  private View mpg;
  private String mph;
  protected View.OnFocusChangeListener mpk;
  private List<FTSSearchView.c> xtu;
  
  public FTSEditTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164183);
    this.afBY = true;
    this.afBZ = false;
    this.afCa = false;
    this.afCb = false;
    this.Xcn = true;
    this.mph = "";
    this.afCe = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(250026);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/search/FTSEditTextView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        int i = -1;
        if (paramAnonymousView.getId() == a.g.tag_1) {
          i = 0;
        }
        for (;;)
        {
          if ((FTSEditTextView.i(FTSEditTextView.this) != null) && (i >= 0))
          {
            paramAnonymousView = FTSEditTextView.i(FTSEditTextView.this);
            FTSEditTextView.b(FTSEditTextView.this).get(i);
            paramAnonymousView.eeU();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/search/FTSEditTextView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(250026);
          return;
          if (paramAnonymousView.getId() == a.g.tag_2) {
            i = 1;
          } else if (paramAnonymousView.getId() == a.g.tag_3) {
            i = 2;
          }
        }
      }
    };
    this.afCg = new ArrayList();
    this.afCh = FTSEditTextView.d.afCj;
    this.mpk = new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(250017);
        if (FTSEditTextView.i(FTSEditTextView.this) != null) {
          FTSEditTextView.i(FTSEditTextView.this).fq(paramAnonymousBoolean);
        }
        AppMethodBeat.o(250017);
      }
    };
    init();
    AppMethodBeat.o(164183);
  }
  
  public FTSEditTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164184);
    this.afBY = true;
    this.afBZ = false;
    this.afCa = false;
    this.afCb = false;
    this.Xcn = true;
    this.mph = "";
    this.afCe = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(250026);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/search/FTSEditTextView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        int i = -1;
        if (paramAnonymousView.getId() == a.g.tag_1) {
          i = 0;
        }
        for (;;)
        {
          if ((FTSEditTextView.i(FTSEditTextView.this) != null) && (i >= 0))
          {
            paramAnonymousView = FTSEditTextView.i(FTSEditTextView.this);
            FTSEditTextView.b(FTSEditTextView.this).get(i);
            paramAnonymousView.eeU();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/search/FTSEditTextView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(250026);
          return;
          if (paramAnonymousView.getId() == a.g.tag_2) {
            i = 1;
          } else if (paramAnonymousView.getId() == a.g.tag_3) {
            i = 2;
          }
        }
      }
    };
    this.afCg = new ArrayList();
    this.afCh = FTSEditTextView.d.afCj;
    this.mpk = new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(250017);
        if (FTSEditTextView.i(FTSEditTextView.this) != null) {
          FTSEditTextView.i(FTSEditTextView.this).fq(paramAnonymousBoolean);
        }
        AppMethodBeat.o(250017);
      }
    };
    init();
    AppMethodBeat.o(164184);
  }
  
  private void a(String paramString, List<FTSSearchView.c> paramList, FTSEditTextView.d paramd)
  {
    AppMethodBeat.i(164191);
    a(paramString, paramList, paramd, false);
    AppMethodBeat.o(164191);
  }
  
  private void a(String paramString, List<FTSSearchView.c> paramList, FTSEditTextView.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(250025);
    String str = Util.nullAs(paramString, "").trim();
    paramString = str;
    if (str.length() > getLimitInputLength()) {
      paramString = str.substring(0, getLimitInputLength()).replace("\n", " ");
    }
    this.xtu.clear();
    if (paramList != null) {
      this.xtu.addAll(paramList);
    }
    Log.i("MicroMsg.FTS.FTSEditTextView", "setText: %s %d", new Object[] { paramString, Integer.valueOf(this.xtu.size()) });
    this.afCh = FTSEditTextView.d.afCl;
    this.dzv.setText(paramString);
    if (paramBoolean)
    {
      Selection.setSelection(this.dzv.getText(), 0);
      this.dzv.clearFocus();
    }
    for (;;)
    {
      jCv();
      this.afCh = paramd;
      AppMethodBeat.o(250025);
      return;
      Selection.setSelection(this.dzv.getText(), this.dzv.getText().length());
    }
  }
  
  public static boolean jCA()
  {
    AppMethodBeat.i(250037);
    if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zvV, 0) == 0)
    {
      AppMethodBeat.o(250037);
      return true;
    }
    AppMethodBeat.o(250037);
    return false;
  }
  
  public static boolean jCB()
  {
    AppMethodBeat.i(250040);
    if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zvW, 1) == 1)
    {
      AppMethodBeat.o(250040);
      return true;
    }
    AppMethodBeat.o(250040);
    return false;
  }
  
  private void jCv()
  {
    AppMethodBeat.i(164195);
    Log.i("MicroMsg.FTS.FTSEditTextView", "updateTagView %s", new Object[] { Integer.valueOf(this.xtu.size()) });
    float f = com.tencent.mm.cd.a.br(getContext(), a.e.NormalTextSize);
    if (this.xtu.size() > 0)
    {
      this.TOk.setVisibility(0);
      this.TOk.setText(com.tencent.mm.ui.i.c.b.c(getContext(), ((FTSSearchView.c)this.xtu.get(0)).getTagName(), f));
      if (this.xtu.size() < 2) {
        break label225;
      }
      this.TOl.setVisibility(0);
      this.TOl.setText(com.tencent.mm.ui.i.c.b.c(getContext(), ((FTSSearchView.c)this.xtu.get(1)).getTagName(), f));
    }
    for (;;)
    {
      if (this.xtu.size() < 3) {
        break label237;
      }
      this.TPt.setVisibility(0);
      this.TPt.setText(com.tencent.mm.ui.i.c.b.c(getContext(), ((FTSSearchView.c)this.xtu.get(2)).getTagName(), f));
      AppMethodBeat.o(164195);
      return;
      this.TOk.setVisibility(8);
      break;
      label225:
      this.TOl.setVisibility(8);
    }
    label237:
    this.TPt.setVisibility(8);
    AppMethodBeat.o(164195);
  }
  
  public static boolean jCz()
  {
    AppMethodBeat.i(250033);
    if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zvU, 0) == 0)
    {
      AppMethodBeat.o(250033);
      return true;
    }
    AppMethodBeat.o(250033);
    return false;
  }
  
  public final void MT(boolean paramBoolean)
  {
    AppMethodBeat.i(250218);
    Log.i("MicroMsg.FTS.FTSEditTextView", "updateActionDonePos, getSosEditTextView().getSearchBarCancelTextContainer().getVisibility() = ".concat(String.valueOf(paramBoolean)));
    if (getSearchDone() != null)
    {
      if (paramBoolean)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)getSearchDone().getLayoutParams();
        localMarginLayoutParams.rightMargin = 0;
        getSearchDone().setLayoutParams(localMarginLayoutParams);
        AppMethodBeat.o(250218);
        return;
      }
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)getSearchDone().getLayoutParams();
      localMarginLayoutParams.rightMargin = ((int)getResources().getDimension(a.e.Edge_2A));
      getSearchDone().setLayoutParams(localMarginLayoutParams);
    }
    AppMethodBeat.o(250218);
  }
  
  public final void V(String paramString, List<FTSSearchView.c> paramList)
  {
    AppMethodBeat.i(164190);
    a(paramString, paramList, FTSEditTextView.d.afCj);
    AppMethodBeat.o(164190);
  }
  
  public final void aWS()
  {
    AppMethodBeat.i(164188);
    postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(250021);
        ((InputMethodManager)FTSEditTextView.this.getContext().getSystemService("input_method")).showSoftInput(FTSEditTextView.a(FTSEditTextView.this), 0);
        AppMethodBeat.o(250021);
      }
    }, 128L);
    AppMethodBeat.o(164188);
  }
  
  public final void aWT()
  {
    AppMethodBeat.i(164192);
    this.dzv.requestFocus();
    AppMethodBeat.o(164192);
  }
  
  public final void bCt(String paramString)
  {
    AppMethodBeat.i(250146);
    a(paramString, null, FTSEditTextView.d.afCj, true);
    AppMethodBeat.o(250146);
  }
  
  public ImageButton getClearBtn()
  {
    return this.mpf;
  }
  
  public EditText getEditText()
  {
    return this.dzv;
  }
  
  public int getHighlightColor()
  {
    AppMethodBeat.i(164189);
    int i = this.dzv.getHighlightColor();
    AppMethodBeat.o(164189);
    return i;
  }
  
  public View getIconMargin()
  {
    return this.afBX;
  }
  
  public WeImageView getIconView()
  {
    return this.mpe;
  }
  
  public String getInEditTextQuery()
  {
    AppMethodBeat.i(164196);
    String str = this.dzv.getText().toString().trim();
    AppMethodBeat.o(164196);
    return str;
  }
  
  protected int getLayoutById()
  {
    return a.h.fts_edittext_view;
  }
  
  protected int getLimitInputLength()
  {
    return 100;
  }
  
  public View getSearchDone()
  {
    return this.afCc;
  }
  
  public View getSearchInputBackground()
  {
    return this.Xcf;
  }
  
  public List<FTSSearchView.c> getTagList()
  {
    return this.xtu;
  }
  
  public View getTagPanel()
  {
    return this.mpg;
  }
  
  public FTSEditTextView.d getTextChangeStatus()
  {
    return this.afCh;
  }
  
  public String getTotalQuery()
  {
    AppMethodBeat.i(164197);
    Object localObject = new StringBuffer();
    Iterator localIterator = this.xtu.iterator();
    while (localIterator.hasNext())
    {
      ((StringBuffer)localObject).append(((FTSSearchView.c)localIterator.next()).getTagName());
      ((StringBuffer)localObject).append(" ");
    }
    ((StringBuffer)localObject).append(this.dzv.getText().toString());
    localObject = ((StringBuffer)localObject).toString().trim();
    AppMethodBeat.o(164197);
    return localObject;
  }
  
  public final void hideVKB()
  {
    AppMethodBeat.i(250138);
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.dzv.getWindowToken(), 0);
    AppMethodBeat.o(250138);
  }
  
  public final void iCF()
  {
    AppMethodBeat.i(164186);
    this.afCh = FTSEditTextView.d.afCk;
    if (this.afBY) {
      this.xtu.clear();
    }
    this.dzv.setText("");
    this.dzv.setHint(this.hint);
    this.mpf.setVisibility(8);
    jCv();
    this.afCh = FTSEditTextView.d.afCj;
    AppMethodBeat.o(164186);
  }
  
  protected void init()
  {
    AppMethodBeat.i(164185);
    this.Xcn = jCA();
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(getLayoutById(), this, true);
    this.mpg = findViewById(a.g.tag_panel);
    this.mpe = ((WeImageView)findViewById(a.g.icon));
    this.dzv = ((EditText)findViewById(a.g.edittext));
    this.mpf = ((ImageButton)findViewById(a.g.clear_btn));
    this.TOk = ((TextView)findViewById(a.g.tag_1));
    this.TOl = ((TextView)findViewById(a.g.tag_2));
    this.TPt = ((TextView)findViewById(a.g.tag_3));
    this.Xcf = findViewById(a.g.search_input_background);
    this.afBX = findViewById(a.g.icon_margin);
    this.afCc = findViewById(a.g.search_done);
    this.xtu = new ArrayList();
    this.dzv.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(164173);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.cH(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/search/FTSEditTextView$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.aYj());
        if ((paramAnonymousKeyEvent.getAction() == 0) && (67 == paramAnonymousInt))
        {
          paramAnonymousInt = FTSEditTextView.a(FTSEditTextView.this).getSelectionStart();
          int i = FTSEditTextView.a(FTSEditTextView.this).getSelectionEnd();
          if ((paramAnonymousInt == 0) && (i == 0) && (FTSEditTextView.b(FTSEditTextView.this).size() > 0) && (FTSEditTextView.c(FTSEditTextView.this)))
          {
            FTSEditTextView.b(FTSEditTextView.this).remove(FTSEditTextView.b(FTSEditTextView.this).size() - 1);
            FTSEditTextView.d(FTSEditTextView.this);
            FTSEditTextView.e(FTSEditTextView.this);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/search/FTSEditTextView$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(164173);
        return false;
      }
    });
    this.dzv.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(164174);
        paramAnonymousCharSequence = FTSEditTextView.this.getTotalQuery();
        if ((paramAnonymousCharSequence != FTSEditTextView.f(FTSEditTextView.this)) && (!paramAnonymousCharSequence.equals(FTSEditTextView.f(FTSEditTextView.this))))
        {
          FTSEditTextView.a(FTSEditTextView.this, paramAnonymousCharSequence);
          if (FTSEditTextView.g(FTSEditTextView.this))
          {
            AppMethodBeat.o(164174);
            return;
          }
          if (paramAnonymousCharSequence.length() <= 0) {
            break label94;
          }
          FTSEditTextView.h(FTSEditTextView.this).setVisibility(0);
        }
        for (;;)
        {
          FTSEditTextView.e(FTSEditTextView.this);
          AppMethodBeat.o(164174);
          return;
          label94:
          FTSEditTextView.h(FTSEditTextView.this).setVisibility(8);
        }
      }
    });
    this.dzv.setOnFocusChangeListener(this.mpk);
    this.dzv.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(164175);
        if ((3 == paramAnonymousInt) && (FTSEditTextView.i(FTSEditTextView.this) != null))
        {
          boolean bool = FTSEditTextView.i(FTSEditTextView.this).aWU();
          AppMethodBeat.o(164175);
          return bool;
        }
        AppMethodBeat.o(164175);
        return false;
      }
    });
    if (this.mpe != null)
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.mpe.getLayoutParams();
      localLayoutParams.width = ((int)(getResources().getDimension(a.e.Edge_2A) * com.tencent.mm.cd.a.getScaleSize(getContext())));
      localLayoutParams.height = ((int)(getResources().getDimension(a.e.Edge_2A) * com.tencent.mm.cd.a.getScaleSize(getContext())));
      this.mpe.setLayoutParams(localLayoutParams);
    }
    this.TOk.setOnClickListener(this.afCe);
    this.TOl.setOnClickListener(this.afCe);
    this.TPt.setOnClickListener(this.afCe);
    this.mpf.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(164176);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/search/FTSEditTextView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        FTSEditTextView.this.iCF();
        if (FTSEditTextView.i(FTSEditTextView.this) != null) {
          FTSEditTextView.i(FTSEditTextView.this).onClickClearTextBtn(paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/search/FTSEditTextView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(164176);
      }
    });
    com.tencent.mm.ui.tools.b.c.i(this.dzv).aEg(getLimitInputLength()).b(g.a.afIH).a(null);
    if ((aw.isDarkMode()) || (jCt())) {
      this.mpf.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    }
    this.mpf.setContentDescription(getResources().getString(a.k.half_so_dilaog_clear_condes));
    if (getSearchDone() != null) {
      getSearchDone().setOnClickListener(new FTSEditTextView.5(this));
    }
    AppMethodBeat.o(164185);
  }
  
  public final void jBL()
  {
    AppMethodBeat.i(164198);
    this.mpe.setVisibility(8);
    AppMethodBeat.o(164198);
  }
  
  protected boolean jCt()
  {
    return false;
  }
  
  public final void jCu()
  {
    AppMethodBeat.i(250158);
    this.dzv.setTextSize(1, 17.0F);
    AppMethodBeat.o(250158);
  }
  
  public final void jCw()
  {
    AppMethodBeat.i(164199);
    if (this.afCb)
    {
      this.mpe.setVisibility(8);
      AppMethodBeat.o(164199);
      return;
    }
    this.mpe.setVisibility(0);
    AppMethodBeat.o(164199);
  }
  
  public final void jCx()
  {
    AppMethodBeat.i(164200);
    if (this.afCa) {
      this.mpf.setVisibility(0);
    }
    for (;;)
    {
      Log.i("MicroMsg.FTS.FTSEditTextView", "hideClearBtn， forceEditToBeTextView = %s.", new Object[] { Util.getStack() });
      AppMethodBeat.o(164200);
      return;
      this.mpf.setVisibility(8);
    }
  }
  
  public final void jCy()
  {
    AppMethodBeat.i(164201);
    Log.i("MicroMsg.FTS.FTSEditTextView", "showClearBtn， forceEditToBeTextView = " + this.afBZ);
    if (this.afBZ)
    {
      this.mpf.setVisibility(8);
      AppMethodBeat.o(164201);
      return;
    }
    this.mpf.setVisibility(0);
    AppMethodBeat.o(164201);
  }
  
  public void setActionSearchDoneListener(FTSEditTextView.a parama)
  {
    this.afCd = parama;
  }
  
  public void setCanDeleteTag(boolean paramBoolean)
  {
    this.afBY = paramBoolean;
  }
  
  public void setClearBtnVisable(int paramInt)
  {
    AppMethodBeat.i(250165);
    this.mpf.setVisibility(paramInt);
    AppMethodBeat.o(250165);
  }
  
  public void setEditTextDrawableLeft(int paramInt)
  {
    AppMethodBeat.i(164187);
    if (paramInt == -1)
    {
      this.dzv.setCompoundDrawablesRelative(null, null, null, null);
      AppMethodBeat.o(164187);
      return;
    }
    Drawable localDrawable = getContext().getResources().getDrawable(paramInt);
    localDrawable.setBounds(0, 0, com.tencent.mm.cd.a.fromDPToPix(getContext(), 15), com.tencent.mm.cd.a.fromDPToPix(getContext(), 15));
    this.dzv.setCompoundDrawablesRelative(localDrawable, null, null, null);
    AppMethodBeat.o(164187);
  }
  
  public void setForceDisable(boolean paramBoolean)
  {
    this.afBZ = paramBoolean;
  }
  
  public void setForceHideSearchIconBtn(boolean paramBoolean)
  {
    this.afCb = paramBoolean;
  }
  
  public void setForceShowClearBtn(boolean paramBoolean)
  {
    this.afCa = paramBoolean;
  }
  
  public void setFtsEditTextListener(c paramc)
  {
    this.afCf = paramc;
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(164194);
    this.dzv.setHint(paramString);
    this.hint = paramString;
    AppMethodBeat.o(164194);
  }
  
  public void setHintColor(int paramInt)
  {
    AppMethodBeat.i(250148);
    this.dzv.setHintTextColor(paramInt);
    AppMethodBeat.o(250148);
  }
  
  public void setIconMarginVisable(int paramInt)
  {
    AppMethodBeat.i(250108);
    if (this.afBX != null) {
      this.afBX.setVisibility(paramInt);
    }
    AppMethodBeat.o(250108);
  }
  
  public void setSearchIconGone(int paramInt)
  {
    AppMethodBeat.i(250227);
    if (getSearchDone() != null) {
      getSearchDone().setVisibility(paramInt);
    }
    AppMethodBeat.o(250227);
  }
  
  public void setSearchIconVisable(int paramInt)
  {
    AppMethodBeat.i(250100);
    if (this.mpe != null) {
      this.mpe.setVisibility(paramInt);
    }
    AppMethodBeat.o(250100);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(250152);
    this.dzv.setTextColor(paramInt);
    AppMethodBeat.o(250152);
  }
  
  public final void showVKB()
  {
    AppMethodBeat.i(250134);
    ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput(this.dzv, 0);
    AppMethodBeat.o(250134);
  }
  
  public static abstract interface b
  {
    public abstract void onEditTextChange(String paramString1, String paramString2, List<FTSSearchView.c> paramList, FTSEditTextView.d paramd);
  }
  
  public static abstract interface c
    extends FTSEditTextView.b
  {
    public abstract boolean aWU();
    
    public abstract void eeU();
    
    public abstract void fq(boolean paramBoolean);
    
    public abstract void onClickClearTextBtn(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.search.FTSEditTextView
 * JD-Core Version:    0.7.0.1
 */