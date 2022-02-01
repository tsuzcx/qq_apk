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
  private int IUs = 0;
  private TextView OxG;
  private View OxH;
  private View OxI;
  private WeImageView OxJ;
  private WeImageView OxK;
  private TextView OxL;
  private MenuItem OxM;
  private MenuItem OxN;
  private int OxO;
  private int OxP;
  private c OxQ;
  private a OxR = a.Oya;
  private boolean OxS = false;
  private int OxT;
  private int OxU;
  private LinkedList<b> OxV = new LinkedList();
  private View actionbarView;
  private int bIs = this.OxT;
  private TextView jUu;
  private ActionBar mActionBar;
  private Context mContext;
  private ImageView nZa;
  private int theme;
  
  private void a(final MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, int paramInt, a parama)
  {
    if (this.mActionBar == null) {
      return;
    }
    if (paramOnMenuItemClickListener == null)
    {
      this.mActionBar.setDisplayHomeAsUpEnabled(false);
      this.OxR = parama;
      if (paramInt != 0) {
        this.OxO = paramInt;
      }
      if (this.OxR == a.Oyc) {
        this.OxO = 0;
      }
      if (this.OxR != a.Oya) {
        break label141;
      }
      this.OxO = 2131230855;
    }
    for (;;)
    {
      if ((this.nZa != null) && (this.OxO != 0))
      {
        gGJ();
        this.nZa.setImageResource(this.OxO);
      }
      gGN();
      return;
      this.mActionBar.setDisplayHomeAsUpEnabled(false);
      if (this.OxI == null) {
        break;
      }
      this.OxI.setVisibility(0);
      this.OxI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(159087);
          b localb = new b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/ui/BaseActivity$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramOnMenuItemClickListener.onMenuItemClick(null);
          a.a(this, "com/tencent/mm/ui/BaseActivity$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(159087);
        }
      });
      break;
      label141:
      if (this.OxR == a.Oyb) {
        this.OxO = 2131230857;
      }
    }
  }
  
  private void gGJ()
  {
    if (this.nZa == null) {
      return;
    }
    this.nZa.setVisibility(0);
  }
  
  private void gGK()
  {
    View localView;
    int i;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localView = getWindow().getDecorView();
      i = localView.getSystemUiVisibility();
      if (!this.OxS) {
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
  
  private void gGL()
  {
    if (this.OxQ == c.Oyl) {
      if (this.OxL != null) {}
    }
    for (;;)
    {
      return;
      if (this.OxS)
      {
        this.OxL.setTextColor(this.mContext.getResources().getColorStateList(2131101430));
        return;
      }
      this.OxL.setTextColor(this.mContext.getResources().getColorStateList(2131100050));
      return;
      if (this.OxQ == c.Oyn) {
        this.OxP = 2131230854;
      }
      while ((this.OxJ != null) && (this.OxP != 0))
      {
        this.OxJ.setImageResource(this.OxP);
        if (!this.OxS) {
          break label166;
        }
        this.OxJ.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        return;
        if (this.OxQ == c.Oyo) {
          this.OxP = 2131230858;
        } else if (this.OxQ == c.Oyp) {
          this.OxP = 2131230859;
        }
      }
    }
    label166:
    this.OxJ.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
  }
  
  private void gGM()
  {
    if (this.OxK == null) {
      return;
    }
    if (this.OxS)
    {
      this.OxK.setImageResource(2131230867);
      return;
    }
    this.OxK.setImageResource(2131230859);
  }
  
  private void gGN()
  {
    if (this.OxS)
    {
      this.nZa.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      return;
    }
    this.nZa.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
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
    if (this.jUu == null) {
      return;
    }
    if (this.OxS)
    {
      this.jUu.setTextColor(this.mContext.getResources().getColor(2131099904));
      return;
    }
    this.jUu.setTextColor(this.mContext.getResources().getColor(2131099903));
  }
  
  public final void a(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramOnMenuItemClickListener, 2131689494, a.OxZ);
  }
  
  public final void a(String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, c paramc)
  {
    b localb = new b();
    localb.Oye = 0;
    localb.Oyf = 0;
    localb.text = paramString;
    localb.kjh = paramOnMenuItemClickListener;
    localb.tib = null;
    localb.Oyj = paramc;
    if ((localb.Oyf == 2131230858) && ((paramString == null) || (paramString.length() <= 0))) {
      localb.text = getString(2131755145);
    }
    int j = localb.Oye;
    int i = 0;
    for (;;)
    {
      if (i < this.OxV.size())
      {
        if (((b)this.OxV.get(i)).Oye == j)
        {
          as.d("BaseActivity", "match menu, id ：" + j + ", remove it", new Object[0]);
          this.OxV.remove(i);
        }
      }
      else
      {
        this.OxV.add(localb);
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
        this.mActionBar.gt();
        this.mActionBar.setDisplayHomeAsUpEnabled(false);
        this.mActionBar.gs();
        this.mActionBar.gu();
        paramBundle = LayoutInflater.from(this).inflate(2131492945, null);
        this.mActionBar.setCustomView(paramBundle);
        if (this.IUs == 0) {
          this.IUs = at.aO(this.mContext, 2130968655);
        }
        this.OxS = ar.aln(this.IUs);
        this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.IUs));
        this.jUu = ((TextView)findViewById(16908308));
        this.OxG = ((TextView)findViewById(16908309));
        this.OxH = findViewById(2131309235);
        this.OxI = findViewById(2131296448);
        this.nZa = ((ImageView)findViewById(2131296449));
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
      this.OxT = at.aH(this.mContext, 2131165256);
      this.OxU = at.aH(this.mContext, 2131165577);
      if (Build.VERSION.SDK_INT >= 21)
      {
        if (this.IUs == 0) {
          this.IUs = at.aO(this.mContext, 2130968655);
        }
        paramBundle = getWindow();
        paramBundle.clearFlags(201326592);
        paramBundle.addFlags(-2147483648);
        paramBundle.setStatusBarColor(this.IUs);
        gGK();
      }
      return;
      this.theme = 2131821596;
      continue;
      this.theme = 2131821595;
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    as.d("BaseActivity", "on create option menu, menuCache size:%d", new Object[] { Integer.valueOf(this.OxV.size()) });
    if ((this.mActionBar == null) || (this.OxV.size() == 0)) {
      as.w("BaseActivity", "error, mActionBar is null or cache size:%d", new Object[] { Integer.valueOf(this.OxV.size()) });
    }
    for (int i = 0; i != 0; i = 1)
    {
      return true;
      Iterator localIterator = this.OxV.iterator();
      while (localIterator.hasNext())
      {
        final b localb = (b)localIterator.next();
        if (localb.Oye != 16908332)
        {
          Object localObject;
          if (localb.Oyj == c.Oyp)
          {
            this.OxM = paramMenu.add(0, localb.Oye, 0, localb.text);
            localObject = new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(159088);
                b localb = new b();
                localb.bm(paramAnonymousView);
                a.b("com/tencent/mm/ui/BaseActivity$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                BaseActivity.a(BaseActivity.a(BaseActivity.this), localb);
                a.a(this, "com/tencent/mm/ui/BaseActivity$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(159088);
              }
            };
            if (localb.Oyi == null) {
              localb.Oyi = View.inflate(this.mContext, 2131492938, null);
            }
            this.OxK = ((WeImageView)localb.Oyi.findViewById(2131296401));
            this.OxK.setVisibility(0);
            gGM();
            this.OxK.setOnClickListener((View.OnClickListener)localObject);
            this.OxK.setEnabled(localb.enable);
            this.OxM.setActionView(localb.Oyi);
            this.OxM.setEnabled(localb.enable);
            this.OxM.setVisible(localb.visible);
          }
          else
          {
            this.OxN = paramMenu.add(0, localb.Oye, 0, localb.text);
            localObject = new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(159089);
                b localb = new b();
                localb.bm(paramAnonymousView);
                a.b("com/tencent/mm/ui/BaseActivity$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
                localb.bm(paramAnonymousView);
                a.b("com/tencent/mm/ui/BaseActivity$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
                boolean bool = BaseActivity.a(paramAnonymousView, localb);
                a.a(bool, this, "com/tencent/mm/ui/BaseActivity$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(159090);
                return bool;
              }
            };
            this.OxQ = localb.Oyj;
            if ((localb.Oyj == c.Oym) || (localb.Oyj == c.Oyl))
            {
              if (localb.Oyg == null) {
                localb.Oyg = View.inflate(this.mContext, 2131492938, null);
              }
              this.OxL = ((TextView)localb.Oyg.findViewById(2131296402));
              this.OxL.setVisibility(0);
              this.OxL.setText(localb.text);
              if (localb.Oyj == c.Oym)
              {
                this.OxL.setTextColor(this.mContext.getResources().getColorStateList(2131100066));
                label454:
                this.OxL.setOnClickListener((View.OnClickListener)localObject);
                this.OxL.setOnLongClickListener(local5);
                this.OxL.setEnabled(localb.enable);
                this.OxN.setActionView(localb.Oyg);
              }
            }
            for (;;)
            {
              this.OxN.setEnabled(localb.enable);
              this.OxN.setVisible(localb.visible);
              if (this.OxN == null) {
                break;
              }
              this.OxN.setShowAsAction(2);
              break;
              gGL();
              break label454;
              if (localb.Oyf != 0) {
                this.OxP = localb.Oyf;
              }
              if (localb.Oyj == c.Oyq) {
                this.OxP = 0;
              }
              if (localb.Oyh == null) {
                localb.Oyh = View.inflate(this.mContext, 2131492938, null);
              }
              this.OxJ = ((WeImageView)localb.Oyh.findViewById(2131296401));
              gGL();
              if (this.OxP != 0)
              {
                this.OxJ.setVisibility(0);
                this.OxJ.setOnClickListener((View.OnClickListener)localObject);
                this.OxJ.setOnLongClickListener(local5);
                this.OxJ.setEnabled(localb.enable);
                this.OxN.setActionView(localb.Oyh);
              }
            }
          }
        }
      }
      if (this.OxM != null) {
        this.OxM.setShowAsAction(2);
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
    if (this.OxV.isEmpty()) {
      return;
    }
    this.OxV.clear();
    supportInvalidateOptionsMenu();
  }
  
  public final void setActionBarColor(int paramInt)
  {
    if (this.mActionBar == null) {
      return;
    }
    this.IUs = paramInt;
    this.OxS = ar.aln(this.IUs);
    this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.IUs));
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(this.IUs);
    }
    gGK();
    gGN();
    gGL();
    updateTitle();
    if (this.OxG != null)
    {
      if (!this.OxS) {
        break label116;
      }
      this.OxG.setTextColor(this.mContext.getResources().getColor(2131099901));
    }
    for (;;)
    {
      gGM();
      return;
      label116:
      this.OxG.setTextColor(this.mContext.getResources().getColor(2131099900));
    }
  }
  
  public final void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramOnMenuItemClickListener, 0, a.Oya);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if ((this.mActionBar == null) || (this.jUu == null)) {
      return;
    }
    this.jUu.setText(paramCharSequence.toString());
    updateTitle();
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(159094);
      OxZ = new a("CUSTOM", 0);
      Oya = new a("BACK", 1);
      Oyb = new a("CLOSE", 2);
      Oyc = new a("NONE", 3);
      Oyd = new a[] { OxZ, Oya, Oyb, Oyc };
      AppMethodBeat.o(159094);
    }
    
    private a() {}
  }
  
  public static final class b
  {
    int Oye = -1;
    int Oyf;
    View Oyg;
    View Oyh;
    View Oyi;
    BaseActivity.c Oyj = BaseActivity.c.Oyk;
    boolean enable = true;
    MenuItem.OnMenuItemClickListener kjh;
    String text;
    View.OnLongClickListener tib;
    boolean visible = true;
  }
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(159097);
      Oyk = new c("CUSTOM", 0);
      Oyl = new c("TEXT", 1);
      Oym = new c("GREEN_TEXT", 2);
      Oyn = new c("ADD", 3);
      Oyo = new c("MORE", 4);
      Oyp = new c("SEARCH", 5);
      Oyq = new c("NONE", 6);
      Oyr = new c[] { Oyk, Oyl, Oym, Oyn, Oyo, Oyp, Oyq };
      AppMethodBeat.o(159097);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.BaseActivity
 * JD-Core Version:    0.7.0.1
 */