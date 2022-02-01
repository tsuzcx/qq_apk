package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class BaseActivity
  extends AppCompatActivity
{
  private int DPG = 0;
  private TextView ITe;
  private View ITf;
  private View ITg;
  private WeImageView ITh;
  private WeImageView ITi;
  private TextView ITj;
  private MenuItem ITk;
  private MenuItem ITl;
  private int ITm;
  private int ITn;
  private c ITo;
  private BaseActivity.a ITp = BaseActivity.a.ITy;
  private boolean ITq = false;
  private int ITr;
  private int ITs;
  private LinkedList<b> ITt = new LinkedList();
  private View actionbarView;
  private int bIc = this.ITr;
  private ActionBar mActionBar;
  private Context mContext;
  private ImageView mGO;
  private TextView mZo;
  private int theme;
  
  private void a(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, int paramInt, BaseActivity.a parama)
  {
    if (this.mActionBar == null) {
      return;
    }
    if (paramOnMenuItemClickListener == null)
    {
      this.mActionBar.setDisplayHomeAsUpEnabled(false);
      this.ITp = parama;
      if (paramInt != 0) {
        this.ITm = paramInt;
      }
      if (this.ITp == BaseActivity.a.ITA) {
        this.ITm = 0;
      }
      if (this.ITp != BaseActivity.a.ITy) {
        break label141;
      }
      this.ITm = 2131230842;
    }
    for (;;)
    {
      if ((this.mGO != null) && (this.ITm != 0))
      {
        fuU();
        this.mGO.setImageResource(this.ITm);
      }
      fuY();
      return;
      this.mActionBar.setDisplayHomeAsUpEnabled(false);
      if (this.ITg == null) {
        break;
      }
      this.ITg.setVisibility(0);
      this.ITg.setOnClickListener(new BaseActivity.2(this, paramOnMenuItemClickListener));
      break;
      label141:
      if (this.ITp == BaseActivity.a.ITz) {
        this.ITm = 2131230844;
      }
    }
  }
  
  private void fuU()
  {
    if (this.mGO == null) {
      return;
    }
    this.mGO.setVisibility(0);
  }
  
  private void fuV()
  {
    View localView;
    int i;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localView = getWindow().getDecorView();
      i = localView.getSystemUiVisibility();
      if (!this.ITq) {
        break label40;
      }
      i &= 0xFFFFDFFF;
    }
    for (;;)
    {
      localView.setSystemUiVisibility(i);
      return;
      label40:
      i |= 0x2000;
    }
  }
  
  private void fuW()
  {
    if (this.ITo == c.ITJ) {
      if (this.ITj != null) {}
    }
    for (;;)
    {
      return;
      if (this.ITq)
      {
        this.ITj.setTextColor(this.mContext.getResources().getColorStateList(2131101185));
        return;
      }
      this.ITj.setTextColor(this.mContext.getResources().getColorStateList(2131100024));
      return;
      if (this.ITo == c.ITL) {
        this.ITn = 2131230841;
      }
      while ((this.ITh != null) && (this.ITn != 0))
      {
        this.ITh.setImageResource(this.ITn);
        if (!this.ITq) {
          break label166;
        }
        this.ITh.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        return;
        if (this.ITo == c.ITM) {
          this.ITn = 2131230845;
        } else if (this.ITo == c.ITN) {
          this.ITn = 2131230846;
        }
      }
    }
    label166:
    this.ITh.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
  }
  
  private void fuX()
  {
    if (this.ITi == null) {
      return;
    }
    if (this.ITq)
    {
      this.ITi.setImageResource(2131230854);
      return;
    }
    this.ITi.setImageResource(2131230846);
  }
  
  private void fuY()
  {
    if (this.ITq)
    {
      this.mGO.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      return;
    }
    this.mGO.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
  }
  
  public static void showVKB(Activity paramActivity)
  {
    if (paramActivity == null) {}
    InputMethodManager localInputMethodManager;
    do
    {
      do
      {
        return;
        localInputMethodManager = (InputMethodManager)paramActivity.getSystemService("input_method");
      } while (localInputMethodManager == null);
      paramActivity = paramActivity.getCurrentFocus();
    } while ((paramActivity == null) || (paramActivity.getWindowToken() == null));
    localInputMethodManager.toggleSoftInput(0, 2);
  }
  
  private void updateTitle()
  {
    if (this.mZo == null) {
      return;
    }
    if (this.ITq)
    {
      this.mZo.setTextColor(this.mContext.getResources().getColor(2131099886));
      return;
    }
    this.mZo.setTextColor(this.mContext.getResources().getColor(2131099885));
  }
  
  public final void a(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramOnMenuItemClickListener, 2131689492, BaseActivity.a.ITx);
  }
  
  public final void a(String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, c paramc)
  {
    b localb = new b();
    localb.ITC = 0;
    localb.ITD = 0;
    localb.text = paramString;
    localb.jil = paramOnMenuItemClickListener;
    localb.rAj = null;
    localb.ITH = paramc;
    if ((localb.ITD == 2131230845) && ((paramString == null) || (paramString.length() <= 0))) {
      localb.text = getString(2131755127);
    }
    int j = localb.ITC;
    int i = 0;
    for (;;)
    {
      if (i < this.ITt.size())
      {
        if (((b)this.ITt.get(i)).ITC == j)
        {
          ap.d("BaseActivity", "match menu, id ：" + j + ", remove it", new Object[0]);
          this.ITt.remove(i);
        }
      }
      else
      {
        this.ITt.add(localb);
        new Handler().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(159091);
            BaseActivity.this.supportInvalidateOptionsMenu();
            AppMethodBeat.o(159091);
          }
        }, 200L);
        return;
      }
      i += 1;
    }
  }
  
  public final void a(String paramString, c paramc, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramString, paramOnMenuItemClickListener, paramc);
  }
  
  protected abstract int getLayoutId();
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    int i = getApplicationContext().getSharedPreferences("SETTING_COLOR", 0).getInt("APP_THEME_COLOR", -16777216);
    switch (i)
    {
    }
    for (;;)
    {
      setTheme(i);
      setContentView(getLayoutId());
      this.mContext = this;
      this.mActionBar = getSupportActionBar();
      if (this.mActionBar != null)
      {
        this.mActionBar.setLogo(new ColorDrawable(getResources().getColor(17170445)));
        this.mActionBar.gm();
        this.mActionBar.setDisplayHomeAsUpEnabled(false);
        this.mActionBar.gl();
        this.mActionBar.gn();
        paramBundle = LayoutInflater.from(this).inflate(2131492926, null);
        this.mActionBar.setCustomView(paramBundle);
        if (this.DPG == 0) {
          this.DPG = aq.aN(this.mContext, 2130968653);
        }
        this.ITq = ao.abX(this.DPG);
        this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.DPG));
        this.mZo = ((TextView)findViewById(16908308));
        this.ITe = ((TextView)findViewById(16908309));
        this.ITf = findViewById(2131305937);
        this.ITg = findViewById(2131296416);
        this.mGO = ((ImageView)findViewById(2131296417));
        setBackBtn(new BaseActivity.1(this));
      }
      this.ITr = aq.ay(this.mContext, 2131165252);
      this.ITs = aq.ay(this.mContext, 2131165559);
      if (Build.VERSION.SDK_INT >= 21)
      {
        if (this.DPG == 0) {
          this.DPG = aq.aN(this.mContext, 2130968653);
        }
        paramBundle = getWindow();
        paramBundle.clearFlags(201326592);
        paramBundle.addFlags(-2147483648);
        paramBundle.setStatusBarColor(this.DPG);
        fuV();
      }
      return;
      this.theme = 2131821548;
      continue;
      this.theme = 2131821547;
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    ap.d("BaseActivity", "on create option menu, menuCache size:%d", new Object[] { Integer.valueOf(this.ITt.size()) });
    if ((this.mActionBar == null) || (this.ITt.size() == 0)) {
      ap.w("BaseActivity", "error, mActionBar is null or cache size:%d", new Object[] { Integer.valueOf(this.ITt.size()) });
    }
    for (int i = 0; i != 0; i = 1)
    {
      return true;
      Iterator localIterator = this.ITt.iterator();
      while (localIterator.hasNext())
      {
        final b localb = (b)localIterator.next();
        if (localb.ITC != 16908332)
        {
          Object localObject;
          if (localb.ITH == c.ITN)
          {
            this.ITk = paramMenu.add(0, localb.ITC, 0, localb.text);
            localObject = new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(159088);
                b localb = new b();
                localb.bd(paramAnonymousView);
                a.b("com/tencent/mm/ui/BaseActivity$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                BaseActivity.a(BaseActivity.a(BaseActivity.this), localb);
                a.a(this, "com/tencent/mm/ui/BaseActivity$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(159088);
              }
            };
            if (localb.ITG == null) {
              localb.ITG = View.inflate(this.mContext, 2131492920, null);
            }
            this.ITi = ((WeImageView)localb.ITG.findViewById(2131296376));
            this.ITi.setVisibility(0);
            fuX();
            this.ITi.setOnClickListener((View.OnClickListener)localObject);
            this.ITi.setEnabled(localb.enable);
            this.ITk.setActionView(localb.ITG);
            this.ITk.setEnabled(localb.enable);
            this.ITk.setVisible(localb.visible);
          }
          else
          {
            this.ITl = paramMenu.add(0, localb.ITC, 0, localb.text);
            localObject = new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(159089);
                b localb = new b();
                localb.bd(paramAnonymousView);
                a.b("com/tencent/mm/ui/BaseActivity$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                BaseActivity.a(BaseActivity.b(BaseActivity.this), localb);
                a.a(this, "com/tencent/mm/ui/BaseActivity$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(159089);
              }
            };
            View.OnLongClickListener local5 = new View.OnLongClickListener()
            {
              public final boolean onLongClick(View paramAnonymousView)
              {
                AppMethodBeat.i(159090);
                b localb = new b();
                localb.bd(paramAnonymousView);
                a.b("com/tencent/mm/ui/BaseActivity$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
                boolean bool = BaseActivity.a(paramAnonymousView, localb);
                a.a(bool, this, "com/tencent/mm/ui/BaseActivity$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(159090);
                return bool;
              }
            };
            this.ITo = localb.ITH;
            if ((localb.ITH == c.ITK) || (localb.ITH == c.ITJ))
            {
              if (localb.ITE == null) {
                localb.ITE = View.inflate(this.mContext, 2131492920, null);
              }
              this.ITj = ((TextView)localb.ITE.findViewById(2131296377));
              this.ITj.setVisibility(0);
              this.ITj.setText(localb.text);
              if (localb.ITH == c.ITK)
              {
                this.ITj.setTextColor(this.mContext.getResources().getColorStateList(2131100038));
                label454:
                this.ITj.setOnClickListener((View.OnClickListener)localObject);
                this.ITj.setOnLongClickListener(local5);
                this.ITj.setEnabled(localb.enable);
                this.ITl.setActionView(localb.ITE);
              }
            }
            for (;;)
            {
              this.ITl.setEnabled(localb.enable);
              this.ITl.setVisible(localb.visible);
              if (this.ITl == null) {
                break;
              }
              this.ITl.setShowAsAction(2);
              break;
              fuW();
              break label454;
              if (localb.ITD != 0) {
                this.ITn = localb.ITD;
              }
              if (localb.ITH == c.ITO) {
                this.ITn = 0;
              }
              if (localb.ITF == null) {
                localb.ITF = View.inflate(this.mContext, 2131492920, null);
              }
              this.ITh = ((WeImageView)localb.ITF.findViewById(2131296376));
              fuW();
              if (this.ITn != 0)
              {
                this.ITh.setVisibility(0);
                this.ITh.setOnClickListener((View.OnClickListener)localObject);
                this.ITh.setOnLongClickListener(local5);
                this.ITh.setEnabled(localb.enable);
                this.ITl.setActionView(localb.ITF);
              }
            }
          }
        }
      }
      if (this.ITk != null) {
        this.ITk.setShowAsAction(2);
      }
    }
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void removeAllOptionMenu()
  {
    if (this.ITt.isEmpty()) {
      return;
    }
    this.ITt.clear();
    supportInvalidateOptionsMenu();
  }
  
  public final void setActionBarColor(int paramInt)
  {
    if (this.mActionBar == null) {
      return;
    }
    this.DPG = paramInt;
    this.ITq = ao.abX(this.DPG);
    this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.DPG));
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(this.DPG);
    }
    fuV();
    fuY();
    fuW();
    updateTitle();
    if (this.ITe != null)
    {
      if (!this.ITq) {
        break label116;
      }
      this.ITe.setTextColor(this.mContext.getResources().getColor(2131099883));
    }
    for (;;)
    {
      fuX();
      return;
      label116:
      this.ITe.setTextColor(this.mContext.getResources().getColor(2131099882));
    }
  }
  
  public final void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramOnMenuItemClickListener, 0, BaseActivity.a.ITy);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if ((this.mActionBar == null) || (this.mZo == null)) {
      return;
    }
    this.mZo.setText(paramCharSequence.toString());
    updateTitle();
  }
  
  public static final class b
  {
    int ITC = -1;
    int ITD;
    View ITE;
    View ITF;
    View ITG;
    BaseActivity.c ITH = BaseActivity.c.ITI;
    boolean enable = true;
    MenuItem.OnMenuItemClickListener jil;
    View.OnLongClickListener rAj;
    String text;
    boolean visible = true;
  }
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(159097);
      ITI = new c("CUSTOM", 0);
      ITJ = new c("TEXT", 1);
      ITK = new c("GREEN_TEXT", 2);
      ITL = new c("ADD", 3);
      ITM = new c("MORE", 4);
      ITN = new c("SEARCH", 5);
      ITO = new c("NONE", 6);
      ITP = new c[] { ITI, ITJ, ITK, ITL, ITM, ITN, ITO };
      AppMethodBeat.o(159097);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.BaseActivity
 * JD-Core Version:    0.7.0.1
 */