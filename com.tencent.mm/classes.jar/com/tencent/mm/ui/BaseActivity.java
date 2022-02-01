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
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.b;
import com.tencent.mm.ck.a.c;
import com.tencent.mm.ck.a.d;
import com.tencent.mm.ck.a.e;
import com.tencent.mm.ck.a.f;
import com.tencent.mm.ck.a.g;
import com.tencent.mm.ck.a.i;
import com.tencent.mm.ck.a.j;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class BaseActivity
  extends AppCompatActivity
{
  private WeImageView EqX;
  private int WHg = 0;
  private View actionbarView;
  private TextView aduS;
  private View aduT;
  private View aduU;
  private WeImageView aduV;
  private TextView aduW;
  private MenuItem aduX;
  private MenuItem aduY;
  private int aduZ;
  private int adva;
  private c advb;
  private BaseActivity.a advc = BaseActivity.a.advl;
  private boolean advd = false;
  private int adve;
  private int advf;
  private LinkedList<b> advg = new LinkedList();
  private int dlE = this.adve;
  private ActionBar mActionBar;
  private Context mContext;
  private TextView pIp;
  private int theme;
  private ImageView ugB;
  
  private void a(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, int paramInt, BaseActivity.a parama)
  {
    if (this.mActionBar == null) {
      return;
    }
    if (paramOnMenuItemClickListener == null)
    {
      this.mActionBar.w(false);
      this.advc = parama;
      if (paramInt != 0) {
        this.aduZ = paramInt;
      }
      if (this.advc == BaseActivity.a.advn) {
        this.aduZ = 0;
      }
      if (this.advc != BaseActivity.a.advl) {
        break label142;
      }
      this.aduZ = a.e.actionbar_icon_dark_back;
    }
    for (;;)
    {
      if ((this.ugB != null) && (this.aduZ != 0))
      {
        jhE();
        this.ugB.setImageResource(this.aduZ);
      }
      jhI();
      return;
      this.mActionBar.w(false);
      if (this.aduU == null) {
        break;
      }
      this.aduU.setVisibility(0);
      this.aduU.setOnClickListener(new BaseActivity.2(this, paramOnMenuItemClickListener));
      break;
      label142:
      if (this.advc == BaseActivity.a.advm) {
        this.aduZ = a.e.actionbar_icon_dark_close;
      }
    }
  }
  
  private void a(String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, c paramc)
  {
    b localb = new b();
    localb.advp = 0;
    localb.advq = 0;
    localb.text = paramString;
    localb.pYf = paramOnMenuItemClickListener;
    localb.AkV = null;
    localb.advu = paramc;
    if ((localb.advq == a.e.actionbar_icon_dark_more) && ((paramString == null) || (paramString.length() <= 0))) {
      localb.text = getString(a.i.actionbar_more);
    }
    int j = localb.advp;
    int i = 0;
    for (;;)
    {
      if (i < this.advg.size())
      {
        if (((b)this.advg.get(i)).advp == j)
        {
          bc.d("BaseActivity", "match menu, id ：" + j + ", remove it", new Object[0]);
          this.advg.remove(i);
        }
      }
      else
      {
        this.advg.add(localb);
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
  
  private void aMl()
  {
    if (this.pIp == null) {
      return;
    }
    if (this.advd)
    {
      this.pIp.setTextColor(this.mContext.getResources().getColor(a.c.actionbar_title_light_color));
      return;
    }
    this.pIp.setTextColor(this.mContext.getResources().getColor(a.c.actionbar_title_color));
  }
  
  private void jhE()
  {
    if (this.ugB == null) {
      return;
    }
    this.ugB.setVisibility(0);
  }
  
  private void jhF()
  {
    View localView;
    int i;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localView = getWindow().getDecorView();
      i = localView.getSystemUiVisibility();
      if (!this.advd) {
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
  
  private void jhG()
  {
    if (this.advb == c.advw) {
      if (this.aduW != null) {}
    }
    for (;;)
    {
      return;
      if (this.advd)
      {
        this.aduW.setTextColor(this.mContext.getResources().getColorStateList(a.c.white_text_color_selector));
        return;
      }
      this.aduW.setTextColor(this.mContext.getResources().getColorStateList(a.c.black_text_color_selector));
      return;
      if (this.advb == c.advy) {
        this.adva = a.e.actionbar_icon_dark_add;
      }
      while ((this.aduV != null) && (this.adva != 0))
      {
        this.aduV.setImageResource(this.adva);
        if (!this.advd) {
          break label171;
        }
        this.aduV.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        return;
        if (this.advb == c.advz) {
          this.adva = a.e.actionbar_icon_dark_more;
        } else if (this.advb == c.advA) {
          this.adva = a.e.actionbar_icon_dark_search;
        }
      }
    }
    label171:
    this.aduV.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
  }
  
  private void jhH()
  {
    if (this.EqX == null) {
      return;
    }
    if (this.advd)
    {
      this.EqX.setImageResource(a.e.actionbar_icon_light_search);
      return;
    }
    this.EqX.setImageResource(a.e.actionbar_icon_dark_search);
  }
  
  private void jhI()
  {
    if (this.advd)
    {
      this.ugB.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      return;
    }
    this.ugB.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
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
  
  public final void a(int paramInt, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramOnMenuItemClickListener, paramInt, BaseActivity.a.advk);
  }
  
  public final void a(c paramc, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a("", paramOnMenuItemClickListener, paramc);
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
        this.mActionBar.x(false);
        this.mActionBar.w(false);
        this.mActionBar.v(false);
        this.mActionBar.y(true);
        paramBundle = LayoutInflater.from(this).inflate(a.g.actionbar_title, null);
        this.mActionBar.setCustomView(paramBundle);
        if (this.WHg == 0) {
          this.WHg = bd.bz(this.mContext, a.b.app_actionbar_color);
        }
        this.advd = bb.aAF(this.WHg);
        this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.WHg));
        this.pIp = ((TextView)findViewById(16908308));
        this.aduS = ((TextView)findViewById(16908309));
        this.aduT = findViewById(a.f.title_ll);
        this.aduU = findViewById(a.f.actionbar_up_indicator);
        this.ugB = ((ImageView)findViewById(a.f.actionbar_up_indicator_btn));
        setBackBtn(new BaseActivity.1(this));
      }
      this.adve = bd.bs(this.mContext, a.d.DefaultActionbarHeightPort);
      this.advf = bd.bs(this.mContext, a.d.SmallActionbarHeight);
      if (Build.VERSION.SDK_INT >= 21)
      {
        if (this.WHg == 0) {
          this.WHg = bd.bz(this.mContext, a.b.app_actionbar_color);
        }
        paramBundle = getWindow();
        paramBundle.clearFlags(201326592);
        paramBundle.addFlags(-2147483648);
        paramBundle.setStatusBarColor(this.WHg);
        jhF();
      }
      return;
      this.theme = a.j.WeUITheme_Green;
      continue;
      this.theme = a.j.WeUITheme_Black;
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    bc.d("BaseActivity", "on create option menu, menuCache size:%d", new Object[] { Integer.valueOf(this.advg.size()) });
    if ((this.mActionBar == null) || (this.advg.size() == 0)) {
      bc.w("BaseActivity", "error, mActionBar is null or cache size:%d", new Object[] { Integer.valueOf(this.advg.size()) });
    }
    for (int i = 0; i != 0; i = 1)
    {
      return true;
      Iterator localIterator = this.advg.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb.advp != 16908332)
        {
          Object localObject;
          if (localb.advu == c.advA)
          {
            this.aduX = paramMenu.add(0, localb.advp, 0, localb.text);
            localObject = new BaseActivity.3(this, localb);
            if (localb.advt == null) {
              localb.advt = View.inflate(this.mContext, a.g.action_option_view, null);
            }
            this.EqX = ((WeImageView)localb.advt.findViewById(a.f.action_option_icon));
            this.EqX.setVisibility(0);
            jhH();
            this.EqX.setOnClickListener((View.OnClickListener)localObject);
            this.EqX.setEnabled(localb.enable);
            this.aduX.setActionView(localb.advt);
            this.aduX.setEnabled(localb.enable);
            this.aduX.setVisible(localb.visible);
          }
          else
          {
            this.aduY = paramMenu.add(0, localb.advp, 0, localb.text);
            localObject = new BaseActivity.4(this, localb);
            BaseActivity.5 local5 = new BaseActivity.5(this, localb);
            this.advb = localb.advu;
            if ((localb.advu == c.advx) || (localb.advu == c.advw))
            {
              if (localb.advr == null) {
                localb.advr = View.inflate(this.mContext, a.g.action_option_view, null);
              }
              this.aduW = ((TextView)localb.advr.findViewById(a.f.action_option_text));
              this.aduW.setVisibility(0);
              this.aduW.setText(localb.text);
              if (localb.advu == c.advx)
              {
                this.aduW.setTextColor(this.mContext.getResources().getColorStateList(a.c.brand_text_color_selector));
                label452:
                this.aduW.setOnClickListener((View.OnClickListener)localObject);
                this.aduW.setOnLongClickListener(local5);
                this.aduW.setEnabled(localb.enable);
                this.aduY.setActionView(localb.advr);
              }
            }
            for (;;)
            {
              this.aduY.setEnabled(localb.enable);
              this.aduY.setVisible(localb.visible);
              if (this.aduY == null) {
                break;
              }
              this.aduY.setShowAsAction(2);
              break;
              jhG();
              break label452;
              if (localb.advq != 0) {
                this.adva = localb.advq;
              }
              if (localb.advu == c.advB) {
                this.adva = 0;
              }
              if (localb.advs == null) {
                localb.advs = View.inflate(this.mContext, a.g.action_option_view, null);
              }
              this.aduV = ((WeImageView)localb.advs.findViewById(a.f.action_option_icon));
              jhG();
              if (this.adva != 0)
              {
                this.aduV.setVisibility(0);
                this.aduV.setOnClickListener((View.OnClickListener)localObject);
                this.aduV.setOnLongClickListener(local5);
                this.aduV.setEnabled(localb.enable);
                this.aduY.setActionView(localb.advs);
              }
            }
          }
        }
      }
      if (this.aduX != null) {
        this.aduX.setShowAsAction(2);
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
    if (this.advg.isEmpty()) {
      return;
    }
    this.advg.clear();
    supportInvalidateOptionsMenu();
  }
  
  public final void setActionBarColor(int paramInt)
  {
    if (this.mActionBar == null) {
      return;
    }
    this.WHg = paramInt;
    this.advd = bb.aAF(this.WHg);
    this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.WHg));
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(this.WHg);
    }
    jhF();
    jhI();
    jhG();
    aMl();
    if (this.aduS != null)
    {
      if (!this.advd) {
        break label116;
      }
      this.aduS.setTextColor(this.mContext.getResources().getColor(a.c.actionbar_subtitle_light_color));
    }
    for (;;)
    {
      jhH();
      return;
      label116:
      this.aduS.setTextColor(this.mContext.getResources().getColor(a.c.actionbar_subtitle_color));
    }
  }
  
  public final void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramOnMenuItemClickListener, 0, BaseActivity.a.advl);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if ((this.mActionBar == null) || (this.pIp == null)) {
      return;
    }
    this.pIp.setText(paramCharSequence.toString());
    aMl();
  }
  
  public static final class b
  {
    View.OnLongClickListener AkV;
    int advp = -1;
    int advq;
    View advr;
    View advs;
    View advt;
    BaseActivity.c advu = BaseActivity.c.advv;
    boolean enable = true;
    MenuItem.OnMenuItemClickListener pYf;
    String text;
    boolean visible = true;
  }
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(159097);
      advv = new c("CUSTOM", 0);
      advw = new c("TEXT", 1);
      advx = new c("GREEN_TEXT", 2);
      advy = new c("ADD", 3);
      advz = new c("MORE", 4);
      advA = new c("SEARCH", 5);
      advB = new c("NONE", 6);
      advC = new c[] { advv, advw, advx, advy, advz, advA, advB };
      AppMethodBeat.o(159097);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.BaseActivity
 * JD-Core Version:    0.7.0.1
 */