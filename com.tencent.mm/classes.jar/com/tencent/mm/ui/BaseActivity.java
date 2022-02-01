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
  private int EhG = 0;
  private TextView JnM;
  private View JnN;
  private View JnO;
  private WeImageView JnP;
  private WeImageView JnQ;
  private TextView JnR;
  private MenuItem JnS;
  private MenuItem JnT;
  private int JnU;
  private int JnV;
  private c JnW;
  private BaseActivity.a JnX = BaseActivity.a.Jog;
  private boolean JnY = false;
  private int JnZ;
  private int Joa;
  private LinkedList<b> Job = new LinkedList();
  private View actionbarView;
  private int bIc = this.JnZ;
  private ActionBar mActionBar;
  private Context mContext;
  private ImageView mLS;
  private TextView jdField_new;
  private int theme;
  
  private void a(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, int paramInt, BaseActivity.a parama)
  {
    if (this.mActionBar == null) {
      return;
    }
    if (paramOnMenuItemClickListener == null)
    {
      this.mActionBar.setDisplayHomeAsUpEnabled(false);
      this.JnX = parama;
      if (paramInt != 0) {
        this.JnU = paramInt;
      }
      if (this.JnX == BaseActivity.a.Joi) {
        this.JnU = 0;
      }
      if (this.JnX != BaseActivity.a.Jog) {
        break label141;
      }
      this.JnU = 2131230842;
    }
    for (;;)
    {
      if ((this.mLS != null) && (this.JnU != 0))
      {
        fyV();
        this.mLS.setImageResource(this.JnU);
      }
      fyZ();
      return;
      this.mActionBar.setDisplayHomeAsUpEnabled(false);
      if (this.JnO == null) {
        break;
      }
      this.JnO.setVisibility(0);
      this.JnO.setOnClickListener(new BaseActivity.2(this, paramOnMenuItemClickListener));
      break;
      label141:
      if (this.JnX == BaseActivity.a.Joh) {
        this.JnU = 2131230844;
      }
    }
  }
  
  private void fyV()
  {
    if (this.mLS == null) {
      return;
    }
    this.mLS.setVisibility(0);
  }
  
  private void fyW()
  {
    View localView;
    int i;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localView = getWindow().getDecorView();
      i = localView.getSystemUiVisibility();
      if (!this.JnY) {
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
  
  private void fyX()
  {
    if (this.JnW == c.Jor) {
      if (this.JnR != null) {}
    }
    for (;;)
    {
      return;
      if (this.JnY)
      {
        this.JnR.setTextColor(this.mContext.getResources().getColorStateList(2131101185));
        return;
      }
      this.JnR.setTextColor(this.mContext.getResources().getColorStateList(2131100024));
      return;
      if (this.JnW == c.Jot) {
        this.JnV = 2131230841;
      }
      while ((this.JnP != null) && (this.JnV != 0))
      {
        this.JnP.setImageResource(this.JnV);
        if (!this.JnY) {
          break label166;
        }
        this.JnP.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        return;
        if (this.JnW == c.Jou) {
          this.JnV = 2131230845;
        } else if (this.JnW == c.Jov) {
          this.JnV = 2131230846;
        }
      }
    }
    label166:
    this.JnP.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
  }
  
  private void fyY()
  {
    if (this.JnQ == null) {
      return;
    }
    if (this.JnY)
    {
      this.JnQ.setImageResource(2131230854);
      return;
    }
    this.JnQ.setImageResource(2131230846);
  }
  
  private void fyZ()
  {
    if (this.JnY)
    {
      this.mLS.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      return;
    }
    this.mLS.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
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
    if (this.jdField_new == null) {
      return;
    }
    if (this.JnY)
    {
      this.jdField_new.setTextColor(this.mContext.getResources().getColor(2131099886));
      return;
    }
    this.jdField_new.setTextColor(this.mContext.getResources().getColor(2131099885));
  }
  
  public final void a(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramOnMenuItemClickListener, 2131689492, BaseActivity.a.Jof);
  }
  
  public final void a(String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, c paramc)
  {
    b localb = new b();
    localb.Jok = 0;
    localb.Jol = 0;
    localb.text = paramString;
    localb.jle = paramOnMenuItemClickListener;
    localb.rIu = null;
    localb.Jop = paramc;
    if ((localb.Jol == 2131230845) && ((paramString == null) || (paramString.length() <= 0))) {
      localb.text = getString(2131755127);
    }
    int j = localb.Jok;
    int i = 0;
    for (;;)
    {
      if (i < this.Job.size())
      {
        if (((b)this.Job.get(i)).Jok == j)
        {
          ap.d("BaseActivity", "match menu, id ：" + j + ", remove it", new Object[0]);
          this.Job.remove(i);
        }
      }
      else
      {
        this.Job.add(localb);
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
        if (this.EhG == 0) {
          this.EhG = aq.aN(this.mContext, 2130968653);
        }
        this.JnY = ao.acF(this.EhG);
        this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.EhG));
        this.jdField_new = ((TextView)findViewById(16908308));
        this.JnM = ((TextView)findViewById(16908309));
        this.JnN = findViewById(2131305937);
        this.JnO = findViewById(2131296416);
        this.mLS = ((ImageView)findViewById(2131296417));
        setBackBtn(new BaseActivity.1(this));
      }
      this.JnZ = aq.ay(this.mContext, 2131165252);
      this.Joa = aq.ay(this.mContext, 2131165559);
      if (Build.VERSION.SDK_INT >= 21)
      {
        if (this.EhG == 0) {
          this.EhG = aq.aN(this.mContext, 2130968653);
        }
        paramBundle = getWindow();
        paramBundle.clearFlags(201326592);
        paramBundle.addFlags(-2147483648);
        paramBundle.setStatusBarColor(this.EhG);
        fyW();
      }
      return;
      this.theme = 2131821548;
      continue;
      this.theme = 2131821547;
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    ap.d("BaseActivity", "on create option menu, menuCache size:%d", new Object[] { Integer.valueOf(this.Job.size()) });
    if ((this.mActionBar == null) || (this.Job.size() == 0)) {
      ap.w("BaseActivity", "error, mActionBar is null or cache size:%d", new Object[] { Integer.valueOf(this.Job.size()) });
    }
    for (int i = 0; i != 0; i = 1)
    {
      return true;
      Iterator localIterator = this.Job.iterator();
      while (localIterator.hasNext())
      {
        final b localb = (b)localIterator.next();
        if (localb.Jok != 16908332)
        {
          Object localObject;
          if (localb.Jop == c.Jov)
          {
            this.JnS = paramMenu.add(0, localb.Jok, 0, localb.text);
            localObject = new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(159088);
                b localb = new b();
                localb.bd(paramAnonymousView);
                a.b("com/tencent/mm/ui/BaseActivity$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                BaseActivity.a(BaseActivity.a(BaseActivity.this), localb);
                a.a(this, "com/tencent/mm/ui/BaseActivity$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(159088);
              }
            };
            if (localb.Joo == null) {
              localb.Joo = View.inflate(this.mContext, 2131492920, null);
            }
            this.JnQ = ((WeImageView)localb.Joo.findViewById(2131296376));
            this.JnQ.setVisibility(0);
            fyY();
            this.JnQ.setOnClickListener((View.OnClickListener)localObject);
            this.JnQ.setEnabled(localb.enable);
            this.JnS.setActionView(localb.Joo);
            this.JnS.setEnabled(localb.enable);
            this.JnS.setVisible(localb.visible);
          }
          else
          {
            this.JnT = paramMenu.add(0, localb.Jok, 0, localb.text);
            localObject = new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(159089);
                b localb = new b();
                localb.bd(paramAnonymousView);
                a.b("com/tencent/mm/ui/BaseActivity$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
                a.b("com/tencent/mm/ui/BaseActivity$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
                boolean bool = BaseActivity.a(paramAnonymousView, localb);
                a.a(bool, this, "com/tencent/mm/ui/BaseActivity$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(159090);
                return bool;
              }
            };
            this.JnW = localb.Jop;
            if ((localb.Jop == c.Jos) || (localb.Jop == c.Jor))
            {
              if (localb.Jom == null) {
                localb.Jom = View.inflate(this.mContext, 2131492920, null);
              }
              this.JnR = ((TextView)localb.Jom.findViewById(2131296377));
              this.JnR.setVisibility(0);
              this.JnR.setText(localb.text);
              if (localb.Jop == c.Jos)
              {
                this.JnR.setTextColor(this.mContext.getResources().getColorStateList(2131100038));
                label454:
                this.JnR.setOnClickListener((View.OnClickListener)localObject);
                this.JnR.setOnLongClickListener(local5);
                this.JnR.setEnabled(localb.enable);
                this.JnT.setActionView(localb.Jom);
              }
            }
            for (;;)
            {
              this.JnT.setEnabled(localb.enable);
              this.JnT.setVisible(localb.visible);
              if (this.JnT == null) {
                break;
              }
              this.JnT.setShowAsAction(2);
              break;
              fyX();
              break label454;
              if (localb.Jol != 0) {
                this.JnV = localb.Jol;
              }
              if (localb.Jop == c.Jow) {
                this.JnV = 0;
              }
              if (localb.Jon == null) {
                localb.Jon = View.inflate(this.mContext, 2131492920, null);
              }
              this.JnP = ((WeImageView)localb.Jon.findViewById(2131296376));
              fyX();
              if (this.JnV != 0)
              {
                this.JnP.setVisibility(0);
                this.JnP.setOnClickListener((View.OnClickListener)localObject);
                this.JnP.setOnLongClickListener(local5);
                this.JnP.setEnabled(localb.enable);
                this.JnT.setActionView(localb.Jon);
              }
            }
          }
        }
      }
      if (this.JnS != null) {
        this.JnS.setShowAsAction(2);
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
    if (this.Job.isEmpty()) {
      return;
    }
    this.Job.clear();
    supportInvalidateOptionsMenu();
  }
  
  public final void setActionBarColor(int paramInt)
  {
    if (this.mActionBar == null) {
      return;
    }
    this.EhG = paramInt;
    this.JnY = ao.acF(this.EhG);
    this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.EhG));
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(this.EhG);
    }
    fyW();
    fyZ();
    fyX();
    updateTitle();
    if (this.JnM != null)
    {
      if (!this.JnY) {
        break label116;
      }
      this.JnM.setTextColor(this.mContext.getResources().getColor(2131099883));
    }
    for (;;)
    {
      fyY();
      return;
      label116:
      this.JnM.setTextColor(this.mContext.getResources().getColor(2131099882));
    }
  }
  
  public final void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramOnMenuItemClickListener, 0, BaseActivity.a.Jog);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if ((this.mActionBar == null) || (this.jdField_new == null)) {
      return;
    }
    this.jdField_new.setText(paramCharSequence.toString());
    updateTitle();
  }
  
  public static final class b
  {
    int Jok = -1;
    int Jol;
    View Jom;
    View Jon;
    View Joo;
    BaseActivity.c Jop = BaseActivity.c.Joq;
    boolean enable = true;
    MenuItem.OnMenuItemClickListener jle;
    View.OnLongClickListener rIu;
    String text;
    boolean visible = true;
  }
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(159097);
      Joq = new c("CUSTOM", 0);
      Jor = new c("TEXT", 1);
      Jos = new c("GREEN_TEXT", 2);
      Jot = new c("ADD", 3);
      Jou = new c("MORE", 4);
      Jov = new c("SEARCH", 5);
      Jow = new c("NONE", 6);
      Jox = new c[] { Joq, Jor, Jos, Jot, Jou, Jov, Jow };
      AppMethodBeat.o(159097);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.BaseActivity
 * JD-Core Version:    0.7.0.1
 */