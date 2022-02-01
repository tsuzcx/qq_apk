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
  private TextView HfN;
  private View HfO;
  private View HfP;
  private int HfQ = 0;
  private WeImageView HfR;
  private WeImageView HfS;
  private TextView HfT;
  private MenuItem HfU;
  private MenuItem HfV;
  private int HfW;
  private int HfX;
  private c HfY;
  private BaseActivity.a HfZ = BaseActivity.a.Hgi;
  private boolean Hga = false;
  private int Hgb;
  private int Hgc;
  private LinkedList<b> Hgd = new LinkedList();
  private View actionbarView;
  private int bxO = this.Hgb;
  private ActionBar mActionBar;
  private Context mContext;
  private ImageView mgn;
  private TextView myG;
  private int theme;
  
  private void a(final MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, int paramInt, BaseActivity.a parama)
  {
    if (this.mActionBar == null) {
      return;
    }
    if (paramOnMenuItemClickListener == null)
    {
      this.mActionBar.setDisplayHomeAsUpEnabled(false);
      this.HfZ = parama;
      if (paramInt != 0) {
        this.HfW = paramInt;
      }
      if (this.HfZ == BaseActivity.a.Hgk) {
        this.HfW = 0;
      }
      if (this.HfZ != BaseActivity.a.Hgi) {
        break label141;
      }
      this.HfW = 2131230842;
    }
    for (;;)
    {
      if ((this.mgn != null) && (this.HfW != 0))
      {
        feM();
        this.mgn.setImageResource(this.HfW);
      }
      feQ();
      return;
      this.mActionBar.setDisplayHomeAsUpEnabled(false);
      if (this.HfP == null) {
        break;
      }
      this.HfP.setVisibility(0);
      this.HfP.setOnClickListener(new View.OnClickListener()
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
      if (this.HfZ == BaseActivity.a.Hgj) {
        this.HfW = 2131230844;
      }
    }
  }
  
  private void feM()
  {
    if (this.mgn == null) {
      return;
    }
    this.mgn.setVisibility(0);
  }
  
  private void feN()
  {
    View localView;
    int i;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localView = getWindow().getDecorView();
      i = localView.getSystemUiVisibility();
      if (!this.Hga) {
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
  
  private void feO()
  {
    if (this.HfY == c.Hgt) {
      if (this.HfT != null) {}
    }
    for (;;)
    {
      return;
      if (this.Hga)
      {
        this.HfT.setTextColor(this.mContext.getResources().getColorStateList(2131101185));
        return;
      }
      this.HfT.setTextColor(this.mContext.getResources().getColorStateList(2131100024));
      return;
      if (this.HfY == c.Hgv) {
        this.HfX = 2131230841;
      }
      while ((this.HfR != null) && (this.HfX != 0))
      {
        this.HfR.setImageResource(this.HfX);
        if (!this.Hga) {
          break label166;
        }
        this.HfR.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        return;
        if (this.HfY == c.Hgw) {
          this.HfX = 2131230845;
        } else if (this.HfY == c.Hgx) {
          this.HfX = 2131230846;
        }
      }
    }
    label166:
    this.HfR.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
  }
  
  private void feP()
  {
    if (this.HfS == null) {
      return;
    }
    if (this.Hga)
    {
      this.HfS.setImageResource(2131230854);
      return;
    }
    this.HfS.setImageResource(2131230846);
  }
  
  private void feQ()
  {
    if (this.Hga)
    {
      this.mgn.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      return;
    }
    this.mgn.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
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
    if (this.myG == null) {
      return;
    }
    if (this.Hga)
    {
      this.myG.setTextColor(this.mContext.getResources().getColor(2131099886));
      return;
    }
    this.myG.setTextColor(this.mContext.getResources().getColor(2131099885));
  }
  
  public final void a(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramOnMenuItemClickListener, 2131689492, BaseActivity.a.Hgh);
  }
  
  public final void a(String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, c paramc)
  {
    b localb = new b();
    localb.Hgm = 0;
    localb.Hgn = 0;
    localb.text = paramString;
    localb.iPc = paramOnMenuItemClickListener;
    localb.qQj = null;
    localb.Hgr = paramc;
    if ((localb.Hgn == 2131230845) && ((paramString == null) || (paramString.length() <= 0))) {
      localb.text = getString(2131755127);
    }
    int j = localb.Hgm;
    int i = 0;
    for (;;)
    {
      if (i < this.Hgd.size())
      {
        if (((b)this.Hgd.get(i)).Hgm == j)
        {
          an.d("BaseActivity", "match menu, id ：" + j + ", remove it", new Object[0]);
          this.Hgd.remove(i);
        }
      }
      else
      {
        this.Hgd.add(localb);
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
        this.mActionBar.fU();
        this.mActionBar.setDisplayHomeAsUpEnabled(false);
        this.mActionBar.fT();
        this.mActionBar.fV();
        paramBundle = LayoutInflater.from(this).inflate(2131492926, null);
        this.mActionBar.setCustomView(paramBundle);
        if (this.HfQ == 0) {
          this.HfQ = ao.aJ(this.mContext, 2130968653);
        }
        this.Hga = am.ZN(this.HfQ);
        this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.HfQ));
        this.myG = ((TextView)findViewById(16908308));
        this.HfN = ((TextView)findViewById(16908309));
        this.HfO = findViewById(2131305937);
        this.HfP = findViewById(2131296416);
        this.mgn = ((ImageView)findViewById(2131296417));
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
      this.Hgb = ao.av(this.mContext, 2131165252);
      this.Hgc = ao.av(this.mContext, 2131165559);
      if (Build.VERSION.SDK_INT >= 21)
      {
        if (this.HfQ == 0) {
          this.HfQ = ao.aJ(this.mContext, 2130968653);
        }
        paramBundle = getWindow();
        paramBundle.clearFlags(201326592);
        paramBundle.addFlags(-2147483648);
        paramBundle.setStatusBarColor(this.HfQ);
        feN();
      }
      return;
      this.theme = 2131821548;
      continue;
      this.theme = 2131821547;
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    an.d("BaseActivity", "on create option menu, menuCache size:%d", new Object[] { Integer.valueOf(this.Hgd.size()) });
    if ((this.mActionBar == null) || (this.Hgd.size() == 0)) {
      an.w("BaseActivity", "error, mActionBar is null or cache size:%d", new Object[] { Integer.valueOf(this.Hgd.size()) });
    }
    for (int i = 0; i != 0; i = 1)
    {
      return true;
      Iterator localIterator = this.Hgd.iterator();
      while (localIterator.hasNext())
      {
        final b localb = (b)localIterator.next();
        if (localb.Hgm != 16908332)
        {
          Object localObject;
          if (localb.Hgr == c.Hgx)
          {
            this.HfU = paramMenu.add(0, localb.Hgm, 0, localb.text);
            localObject = new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(159088);
                BaseActivity.a(BaseActivity.a(BaseActivity.this), localb);
                AppMethodBeat.o(159088);
              }
            };
            if (localb.Hgq == null) {
              localb.Hgq = View.inflate(this.mContext, 2131492920, null);
            }
            this.HfS = ((WeImageView)localb.Hgq.findViewById(2131296376));
            this.HfS.setVisibility(0);
            feP();
            this.HfS.setOnClickListener((View.OnClickListener)localObject);
            this.HfS.setEnabled(localb.enable);
            this.HfU.setActionView(localb.Hgq);
            this.HfU.setEnabled(localb.enable);
            this.HfU.setVisible(localb.visible);
          }
          else
          {
            this.HfV = paramMenu.add(0, localb.Hgm, 0, localb.text);
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
            this.HfY = localb.Hgr;
            if ((localb.Hgr == c.Hgu) || (localb.Hgr == c.Hgt))
            {
              if (localb.Hgo == null) {
                localb.Hgo = View.inflate(this.mContext, 2131492920, null);
              }
              this.HfT = ((TextView)localb.Hgo.findViewById(2131296377));
              this.HfT.setVisibility(0);
              this.HfT.setText(localb.text);
              if (localb.Hgr == c.Hgu)
              {
                this.HfT.setTextColor(this.mContext.getResources().getColorStateList(2131100038));
                label454:
                this.HfT.setOnClickListener((View.OnClickListener)localObject);
                this.HfT.setOnLongClickListener(local5);
                this.HfT.setEnabled(localb.enable);
                this.HfV.setActionView(localb.Hgo);
              }
            }
            for (;;)
            {
              this.HfV.setEnabled(localb.enable);
              this.HfV.setVisible(localb.visible);
              if (this.HfV == null) {
                break;
              }
              this.HfV.setShowAsAction(2);
              break;
              feO();
              break label454;
              if (localb.Hgn != 0) {
                this.HfX = localb.Hgn;
              }
              if (localb.Hgr == c.Hgy) {
                this.HfX = 0;
              }
              if (localb.Hgp == null) {
                localb.Hgp = View.inflate(this.mContext, 2131492920, null);
              }
              this.HfR = ((WeImageView)localb.Hgp.findViewById(2131296376));
              feO();
              if (this.HfX != 0)
              {
                this.HfR.setVisibility(0);
                this.HfR.setOnClickListener((View.OnClickListener)localObject);
                this.HfR.setOnLongClickListener(local5);
                this.HfR.setEnabled(localb.enable);
                this.HfV.setActionView(localb.Hgp);
              }
            }
          }
        }
      }
      if (this.HfU != null) {
        this.HfU.setShowAsAction(2);
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
    if (this.Hgd.isEmpty()) {
      return;
    }
    this.Hgd.clear();
    supportInvalidateOptionsMenu();
  }
  
  public final void setActionBarColor(int paramInt)
  {
    if (this.mActionBar == null) {
      return;
    }
    this.HfQ = paramInt;
    this.Hga = am.ZN(this.HfQ);
    this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.HfQ));
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(this.HfQ);
    }
    feN();
    feQ();
    feO();
    updateTitle();
    if (this.HfN != null)
    {
      if (!this.Hga) {
        break label116;
      }
      this.HfN.setTextColor(this.mContext.getResources().getColor(2131099883));
    }
    for (;;)
    {
      feP();
      return;
      label116:
      this.HfN.setTextColor(this.mContext.getResources().getColor(2131099882));
    }
  }
  
  public final void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramOnMenuItemClickListener, 0, BaseActivity.a.Hgi);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if ((this.mActionBar == null) || (this.myG == null)) {
      return;
    }
    this.myG.setText(paramCharSequence.toString());
    updateTitle();
  }
  
  public static final class b
  {
    int Hgm = -1;
    int Hgn;
    View Hgo;
    View Hgp;
    View Hgq;
    BaseActivity.c Hgr = BaseActivity.c.Hgs;
    boolean enable = true;
    MenuItem.OnMenuItemClickListener iPc;
    View.OnLongClickListener qQj;
    String text;
    boolean visible = true;
  }
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(159097);
      Hgs = new c("CUSTOM", 0);
      Hgt = new c("TEXT", 1);
      Hgu = new c("GREEN_TEXT", 2);
      Hgv = new c("ADD", 3);
      Hgw = new c("MORE", 4);
      Hgx = new c("SEARCH", 5);
      Hgy = new c("NONE", 6);
      Hgz = new c[] { Hgs, Hgt, Hgu, Hgv, Hgw, Hgx, Hgy };
      AppMethodBeat.o(159097);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.BaseActivity
 * JD-Core Version:    0.7.0.1
 */