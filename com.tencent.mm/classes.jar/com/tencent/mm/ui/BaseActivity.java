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
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class BaseActivity
  extends AppCompatActivity
{
  private TextView FGF;
  private View FGG;
  private View FGH;
  private int FGI = 0;
  private WeImageView FGJ;
  private WeImageView FGK;
  private TextView FGL;
  private MenuItem FGM;
  private MenuItem FGN;
  private int FGO;
  private int FGP;
  private c FGQ;
  private a FGR = a.FHa;
  private boolean FGS = false;
  private int FGT;
  private int FGU;
  private LinkedList<b> FGV = new LinkedList();
  private View actionbarView;
  private int bAg = this.FGT;
  private ImageView lEt;
  private TextView lWE;
  private ActionBar mActionBar;
  private Context mContext;
  private int theme;
  
  private void a(final MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, int paramInt, a parama)
  {
    if (this.mActionBar == null) {
      return;
    }
    if (paramOnMenuItemClickListener == null)
    {
      this.mActionBar.setDisplayHomeAsUpEnabled(false);
      this.FGR = parama;
      if (paramInt != 0) {
        this.FGO = paramInt;
      }
      if (this.FGR == a.FHc) {
        this.FGO = 0;
      }
      if (this.FGR != a.FHa) {
        break label141;
      }
      this.FGO = 2131230842;
    }
    for (;;)
    {
      if ((this.lEt != null) && (this.FGO != 0))
      {
        ePi();
        this.lEt.setImageResource(this.FGO);
      }
      ePm();
      return;
      this.mActionBar.setDisplayHomeAsUpEnabled(false);
      if (this.FGH == null) {
        break;
      }
      this.FGH.setVisibility(0);
      this.FGH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(159087);
          paramOnMenuItemClickListener.onMenuItemClick(null);
          AppMethodBeat.o(159087);
        }
      });
      break;
      label141:
      if (this.FGR == a.FHb) {
        this.FGO = 2131230844;
      }
    }
  }
  
  private void ePi()
  {
    if (this.lEt == null) {
      return;
    }
    this.lEt.setVisibility(0);
  }
  
  private void ePj()
  {
    View localView;
    int i;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localView = getWindow().getDecorView();
      i = localView.getSystemUiVisibility();
      if (!this.FGS) {
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
  
  private void ePk()
  {
    if (this.FGQ == c.FHl) {
      if (this.FGL != null) {}
    }
    for (;;)
    {
      return;
      if (this.FGS)
      {
        this.FGL.setTextColor(this.mContext.getResources().getColorStateList(2131101185));
        return;
      }
      this.FGL.setTextColor(this.mContext.getResources().getColorStateList(2131100024));
      return;
      if (this.FGQ == c.FHn) {
        this.FGP = 2131230841;
      }
      while ((this.FGJ != null) && (this.FGP != 0))
      {
        this.FGJ.setImageResource(this.FGP);
        if (!this.FGS) {
          break label166;
        }
        this.FGJ.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        return;
        if (this.FGQ == c.FHo) {
          this.FGP = 2131230845;
        } else if (this.FGQ == c.FHp) {
          this.FGP = 2131230846;
        }
      }
    }
    label166:
    this.FGJ.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
  }
  
  private void ePl()
  {
    if (this.FGK == null) {
      return;
    }
    if (this.FGS)
    {
      this.FGK.setImageResource(2131230854);
      return;
    }
    this.FGK.setImageResource(2131230846);
  }
  
  private void ePm()
  {
    if (this.FGS)
    {
      this.lEt.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      return;
    }
    this.lEt.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
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
    if (this.lWE == null) {
      return;
    }
    if (this.FGS)
    {
      this.lWE.setTextColor(this.mContext.getResources().getColor(2131099886));
      return;
    }
    this.lWE.setTextColor(this.mContext.getResources().getColor(2131099885));
  }
  
  public final void a(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramOnMenuItemClickListener, 2131689492, a.FGZ);
  }
  
  public final void a(String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, c paramc)
  {
    b localb = new b();
    localb.FHe = 0;
    localb.FHf = 0;
    localb.text = paramString;
    localb.ioW = paramOnMenuItemClickListener;
    localb.qhH = null;
    localb.FHj = paramc;
    if ((localb.FHf == 2131230845) && ((paramString == null) || (paramString.length() <= 0))) {
      localb.text = getString(2131755127);
    }
    int j = localb.FHe;
    int i = 0;
    for (;;)
    {
      if (i < this.FGV.size())
      {
        if (((b)this.FGV.get(i)).FHe == j)
        {
          an.d("BaseActivity", "match menu, id ：" + j + ", remove it", new Object[0]);
          this.FGV.remove(i);
        }
      }
      else
      {
        this.FGV.add(localb);
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
        this.mActionBar.fM();
        this.mActionBar.setDisplayHomeAsUpEnabled(false);
        this.mActionBar.fL();
        this.mActionBar.fN();
        paramBundle = LayoutInflater.from(this).inflate(2131492926, null);
        this.mActionBar.setCustomView(paramBundle);
        if (this.FGI == 0) {
          this.FGI = ao.aD(this.mContext, 2130968653);
        }
        this.FGS = am.XC(this.FGI);
        this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.FGI));
        this.lWE = ((TextView)findViewById(16908308));
        this.FGF = ((TextView)findViewById(16908309));
        this.FGG = findViewById(2131305937);
        this.FGH = findViewById(2131296416);
        this.lEt = ((ImageView)findViewById(2131296417));
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(159086);
            BaseActivity.this.finish();
            AppMethodBeat.o(159086);
            return true;
          }
        });
      }
      this.FGT = ao.ap(this.mContext, 2131165252);
      this.FGU = ao.ap(this.mContext, 2131165559);
      if (Build.VERSION.SDK_INT >= 21)
      {
        if (this.FGI == 0) {
          this.FGI = ao.aD(this.mContext, 2130968653);
        }
        paramBundle = getWindow();
        paramBundle.clearFlags(201326592);
        paramBundle.addFlags(-2147483648);
        paramBundle.setStatusBarColor(this.FGI);
        ePj();
      }
      return;
      this.theme = 2131821548;
      continue;
      this.theme = 2131821547;
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    an.d("BaseActivity", "on create option menu, menuCache size:%d", new Object[] { Integer.valueOf(this.FGV.size()) });
    if ((this.mActionBar == null) || (this.FGV.size() == 0)) {
      an.w("BaseActivity", "error, mActionBar is null or cache size:%d", new Object[] { Integer.valueOf(this.FGV.size()) });
    }
    for (int i = 0; i != 0; i = 1)
    {
      return true;
      Iterator localIterator = this.FGV.iterator();
      while (localIterator.hasNext())
      {
        final b localb = (b)localIterator.next();
        if (localb.FHe != 16908332)
        {
          Object localObject;
          if (localb.FHj == c.FHp)
          {
            this.FGM = paramMenu.add(0, localb.FHe, 0, localb.text);
            localObject = new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(159088);
                BaseActivity.a(BaseActivity.a(BaseActivity.this), localb);
                AppMethodBeat.o(159088);
              }
            };
            if (localb.FHi == null) {
              localb.FHi = View.inflate(this.mContext, 2131492920, null);
            }
            this.FGK = ((WeImageView)localb.FHi.findViewById(2131296376));
            this.FGK.setVisibility(0);
            ePl();
            this.FGK.setOnClickListener((View.OnClickListener)localObject);
            this.FGK.setEnabled(localb.enable);
            this.FGM.setActionView(localb.FHi);
            this.FGM.setEnabled(localb.enable);
            this.FGM.setVisible(localb.visible);
          }
          else
          {
            this.FGN = paramMenu.add(0, localb.FHe, 0, localb.text);
            localObject = new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(159089);
                BaseActivity.a(BaseActivity.b(BaseActivity.this), localb);
                AppMethodBeat.o(159089);
              }
            };
            View.OnLongClickListener local5 = new View.OnLongClickListener()
            {
              public final boolean onLongClick(View paramAnonymousView)
              {
                AppMethodBeat.i(159090);
                boolean bool = BaseActivity.a(paramAnonymousView, localb);
                AppMethodBeat.o(159090);
                return bool;
              }
            };
            this.FGQ = localb.FHj;
            if ((localb.FHj == c.FHm) || (localb.FHj == c.FHl))
            {
              if (localb.FHg == null) {
                localb.FHg = View.inflate(this.mContext, 2131492920, null);
              }
              this.FGL = ((TextView)localb.FHg.findViewById(2131296377));
              this.FGL.setVisibility(0);
              this.FGL.setText(localb.text);
              if (localb.FHj == c.FHm)
              {
                this.FGL.setTextColor(this.mContext.getResources().getColorStateList(2131100038));
                label454:
                this.FGL.setOnClickListener((View.OnClickListener)localObject);
                this.FGL.setOnLongClickListener(local5);
                this.FGL.setEnabled(localb.enable);
                this.FGN.setActionView(localb.FHg);
              }
            }
            for (;;)
            {
              this.FGN.setEnabled(localb.enable);
              this.FGN.setVisible(localb.visible);
              if (this.FGN == null) {
                break;
              }
              this.FGN.setShowAsAction(2);
              break;
              ePk();
              break label454;
              if (localb.FHf != 0) {
                this.FGP = localb.FHf;
              }
              if (localb.FHj == c.FHq) {
                this.FGP = 0;
              }
              if (localb.FHh == null) {
                localb.FHh = View.inflate(this.mContext, 2131492920, null);
              }
              this.FGJ = ((WeImageView)localb.FHh.findViewById(2131296376));
              ePk();
              if (this.FGP != 0)
              {
                this.FGJ.setVisibility(0);
                this.FGJ.setOnClickListener((View.OnClickListener)localObject);
                this.FGJ.setOnLongClickListener(local5);
                this.FGJ.setEnabled(localb.enable);
                this.FGN.setActionView(localb.FHh);
              }
            }
          }
        }
      }
      if (this.FGM != null) {
        this.FGM.setShowAsAction(2);
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
    if (this.FGV.isEmpty()) {
      return;
    }
    this.FGV.clear();
    supportInvalidateOptionsMenu();
  }
  
  public final void setActionBarColor(int paramInt)
  {
    if (this.mActionBar == null) {
      return;
    }
    this.FGI = paramInt;
    this.FGS = am.XC(this.FGI);
    this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.FGI));
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(this.FGI);
    }
    ePj();
    ePm();
    ePk();
    updateTitle();
    if (this.FGF != null)
    {
      if (!this.FGS) {
        break label116;
      }
      this.FGF.setTextColor(this.mContext.getResources().getColor(2131099883));
    }
    for (;;)
    {
      ePl();
      return;
      label116:
      this.FGF.setTextColor(this.mContext.getResources().getColor(2131099882));
    }
  }
  
  public final void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramOnMenuItemClickListener, 0, a.FHa);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if ((this.mActionBar == null) || (this.lWE == null)) {
      return;
    }
    this.lWE.setText(paramCharSequence.toString());
    updateTitle();
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(159094);
      FGZ = new a("CUSTOM", 0);
      FHa = new a("BACK", 1);
      FHb = new a("CLOSE", 2);
      FHc = new a("NONE", 3);
      FHd = new a[] { FGZ, FHa, FHb, FHc };
      AppMethodBeat.o(159094);
    }
    
    private a() {}
  }
  
  public static final class b
  {
    int FHe = -1;
    int FHf;
    View FHg;
    View FHh;
    View FHi;
    BaseActivity.c FHj = BaseActivity.c.FHk;
    boolean enable = true;
    MenuItem.OnMenuItemClickListener ioW;
    View.OnLongClickListener qhH;
    String text;
    boolean visible = true;
  }
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(159097);
      FHk = new c("CUSTOM", 0);
      FHl = new c("TEXT", 1);
      FHm = new c("GREEN_TEXT", 2);
      FHn = new c("ADD", 3);
      FHo = new c("MORE", 4);
      FHp = new c("SEARCH", 5);
      FHq = new c("NONE", 6);
      FHr = new c[] { FHk, FHl, FHm, FHn, FHo, FHp, FHq };
      AppMethodBeat.o(159097);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.BaseActivity
 * JD-Core Version:    0.7.0.1
 */