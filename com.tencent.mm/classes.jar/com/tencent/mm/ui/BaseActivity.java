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
import com.tencent.mm.cr.a.b;
import com.tencent.mm.cr.a.c;
import com.tencent.mm.cr.a.d;
import com.tencent.mm.cr.a.e;
import com.tencent.mm.cr.a.f;
import com.tencent.mm.cr.a.g;
import com.tencent.mm.cr.a.i;
import com.tencent.mm.cr.a.j;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class BaseActivity
  extends AppCompatActivity
{
  private int PQJ = 0;
  private TextView VQK;
  private View VQL;
  private View VQM;
  private WeImageView VQN;
  private TextView VQO;
  private MenuItem VQP;
  private MenuItem VQQ;
  private int VQR;
  private int VQS;
  private BaseActivity.c VQT;
  private BaseActivity.a VQU = BaseActivity.a.VRd;
  private boolean VQV = false;
  private int VQW;
  private int VQX;
  private LinkedList<b> VQY = new LinkedList();
  private View actionbarView;
  private int bsc = this.VQW;
  private ActionBar mActionBar;
  private Context mContext;
  private TextView mLH;
  private ImageView raL;
  private int theme;
  private WeImageView zoq;
  
  private void a(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, int paramInt, BaseActivity.a parama)
  {
    if (this.mActionBar == null) {
      return;
    }
    if (paramOnMenuItemClickListener == null)
    {
      this.mActionBar.s(false);
      this.VQU = parama;
      if (paramInt != 0) {
        this.VQR = paramInt;
      }
      if (this.VQU == BaseActivity.a.VRf) {
        this.VQR = 0;
      }
      if (this.VQU != BaseActivity.a.VRd) {
        break label142;
      }
      this.VQR = a.e.actionbar_icon_dark_back;
    }
    for (;;)
    {
      if ((this.raL != null) && (this.VQR != 0))
      {
        hFr();
        this.raL.setImageResource(this.VQR);
      }
      hFv();
      return;
      this.mActionBar.s(false);
      if (this.VQM == null) {
        break;
      }
      this.VQM.setVisibility(0);
      this.VQM.setOnClickListener(new BaseActivity.2(this, paramOnMenuItemClickListener));
      break;
      label142:
      if (this.VQU == BaseActivity.a.VRe) {
        this.VQR = a.e.actionbar_icon_dark_close;
      }
    }
  }
  
  private void a(String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, BaseActivity.c paramc)
  {
    b localb = new b();
    localb.VRh = 0;
    localb.VRi = 0;
    localb.text = paramString;
    localb.naX = paramOnMenuItemClickListener;
    localb.wOt = null;
    localb.VRm = paramc;
    if ((localb.VRi == a.e.actionbar_icon_dark_more) && ((paramString == null) || (paramString.length() <= 0))) {
      localb.text = getString(a.i.actionbar_more);
    }
    int j = localb.VRh;
    int i = 0;
    for (;;)
    {
      if (i < this.VQY.size())
      {
        if (((b)this.VQY.get(i)).VRh == j)
        {
          av.d("BaseActivity", "match menu, id ：" + j + ", remove it", new Object[0]);
          this.VQY.remove(i);
        }
      }
      else
      {
        this.VQY.add(localb);
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
  
  private void hFr()
  {
    if (this.raL == null) {
      return;
    }
    this.raL.setVisibility(0);
  }
  
  private void hFs()
  {
    View localView;
    int i;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localView = getWindow().getDecorView();
      i = localView.getSystemUiVisibility();
      if (!this.VQV) {
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
  
  private void hFt()
  {
    if (this.VQT == BaseActivity.c.VRo) {
      if (this.VQO != null) {}
    }
    for (;;)
    {
      return;
      if (this.VQV)
      {
        this.VQO.setTextColor(this.mContext.getResources().getColorStateList(a.c.white_text_color_selector));
        return;
      }
      this.VQO.setTextColor(this.mContext.getResources().getColorStateList(a.c.black_text_color_selector));
      return;
      if (this.VQT == BaseActivity.c.VRq) {
        this.VQS = a.e.actionbar_icon_dark_add;
      }
      while ((this.VQN != null) && (this.VQS != 0))
      {
        this.VQN.setImageResource(this.VQS);
        if (!this.VQV) {
          break label171;
        }
        this.VQN.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        return;
        if (this.VQT == BaseActivity.c.VRr) {
          this.VQS = a.e.actionbar_icon_dark_more;
        } else if (this.VQT == BaseActivity.c.VRs) {
          this.VQS = a.e.actionbar_icon_dark_search;
        }
      }
    }
    label171:
    this.VQN.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
  }
  
  private void hFu()
  {
    if (this.zoq == null) {
      return;
    }
    if (this.VQV)
    {
      this.zoq.setImageResource(a.e.actionbar_icon_light_search);
      return;
    }
    this.zoq.setImageResource(a.e.actionbar_icon_dark_search);
  }
  
  private void hFv()
  {
    if (this.VQV)
    {
      this.raL.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      return;
    }
    this.raL.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
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
    if (this.mLH == null) {
      return;
    }
    if (this.VQV)
    {
      this.mLH.setTextColor(this.mContext.getResources().getColor(a.c.actionbar_title_light_color));
      return;
    }
    this.mLH.setTextColor(this.mContext.getResources().getColor(a.c.actionbar_title_color));
  }
  
  public final void a(int paramInt, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramOnMenuItemClickListener, paramInt, BaseActivity.a.VRc);
  }
  
  public final void a(BaseActivity.c paramc, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a("", paramOnMenuItemClickListener, paramc);
  }
  
  public final void a(String paramString, BaseActivity.c paramc, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
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
        this.mActionBar.t(false);
        this.mActionBar.s(false);
        this.mActionBar.r(false);
        this.mActionBar.u(true);
        paramBundle = LayoutInflater.from(this).inflate(a.g.actionbar_title, null);
        this.mActionBar.setCustomView(paramBundle);
        if (this.PQJ == 0) {
          this.PQJ = aw.bg(this.mContext, a.b.app_actionbar_color);
        }
        this.VQV = au.auk(this.PQJ);
        this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.PQJ));
        this.mLH = ((TextView)findViewById(16908308));
        this.VQK = ((TextView)findViewById(16908309));
        this.VQL = findViewById(a.f.title_ll);
        this.VQM = findViewById(a.f.actionbar_up_indicator);
        this.raL = ((ImageView)findViewById(a.f.actionbar_up_indicator_btn));
        setBackBtn(new BaseActivity.1(this));
      }
      this.VQW = aw.aZ(this.mContext, a.d.DefaultActionbarHeightPort);
      this.VQX = aw.aZ(this.mContext, a.d.SmallActionbarHeight);
      if (Build.VERSION.SDK_INT >= 21)
      {
        if (this.PQJ == 0) {
          this.PQJ = aw.bg(this.mContext, a.b.app_actionbar_color);
        }
        paramBundle = getWindow();
        paramBundle.clearFlags(201326592);
        paramBundle.addFlags(-2147483648);
        paramBundle.setStatusBarColor(this.PQJ);
        hFs();
      }
      return;
      this.theme = a.j.WeUITheme_Green;
      continue;
      this.theme = a.j.WeUITheme_Black;
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    av.d("BaseActivity", "on create option menu, menuCache size:%d", new Object[] { Integer.valueOf(this.VQY.size()) });
    if ((this.mActionBar == null) || (this.VQY.size() == 0)) {
      av.w("BaseActivity", "error, mActionBar is null or cache size:%d", new Object[] { Integer.valueOf(this.VQY.size()) });
    }
    for (int i = 0; i != 0; i = 1)
    {
      return true;
      Iterator localIterator = this.VQY.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb.VRh != 16908332)
        {
          Object localObject;
          if (localb.VRm == BaseActivity.c.VRs)
          {
            this.VQP = paramMenu.add(0, localb.VRh, 0, localb.text);
            localObject = new BaseActivity.3(this, localb);
            if (localb.VRl == null) {
              localb.VRl = View.inflate(this.mContext, a.g.action_option_view, null);
            }
            this.zoq = ((WeImageView)localb.VRl.findViewById(a.f.action_option_icon));
            this.zoq.setVisibility(0);
            hFu();
            this.zoq.setOnClickListener((View.OnClickListener)localObject);
            this.zoq.setEnabled(localb.enable);
            this.VQP.setActionView(localb.VRl);
            this.VQP.setEnabled(localb.enable);
            this.VQP.setVisible(localb.visible);
          }
          else
          {
            this.VQQ = paramMenu.add(0, localb.VRh, 0, localb.text);
            localObject = new BaseActivity.4(this, localb);
            BaseActivity.5 local5 = new BaseActivity.5(this, localb);
            this.VQT = localb.VRm;
            if ((localb.VRm == BaseActivity.c.VRp) || (localb.VRm == BaseActivity.c.VRo))
            {
              if (localb.VRj == null) {
                localb.VRj = View.inflate(this.mContext, a.g.action_option_view, null);
              }
              this.VQO = ((TextView)localb.VRj.findViewById(a.f.action_option_text));
              this.VQO.setVisibility(0);
              this.VQO.setText(localb.text);
              if (localb.VRm == BaseActivity.c.VRp)
              {
                this.VQO.setTextColor(this.mContext.getResources().getColorStateList(a.c.brand_text_color_selector));
                label452:
                this.VQO.setOnClickListener((View.OnClickListener)localObject);
                this.VQO.setOnLongClickListener(local5);
                this.VQO.setEnabled(localb.enable);
                this.VQQ.setActionView(localb.VRj);
              }
            }
            for (;;)
            {
              this.VQQ.setEnabled(localb.enable);
              this.VQQ.setVisible(localb.visible);
              if (this.VQQ == null) {
                break;
              }
              this.VQQ.setShowAsAction(2);
              break;
              hFt();
              break label452;
              if (localb.VRi != 0) {
                this.VQS = localb.VRi;
              }
              if (localb.VRm == BaseActivity.c.VRt) {
                this.VQS = 0;
              }
              if (localb.VRk == null) {
                localb.VRk = View.inflate(this.mContext, a.g.action_option_view, null);
              }
              this.VQN = ((WeImageView)localb.VRk.findViewById(a.f.action_option_icon));
              hFt();
              if (this.VQS != 0)
              {
                this.VQN.setVisibility(0);
                this.VQN.setOnClickListener((View.OnClickListener)localObject);
                this.VQN.setOnLongClickListener(local5);
                this.VQN.setEnabled(localb.enable);
                this.VQQ.setActionView(localb.VRk);
              }
            }
          }
        }
      }
      if (this.VQP != null) {
        this.VQP.setShowAsAction(2);
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
    if (this.VQY.isEmpty()) {
      return;
    }
    this.VQY.clear();
    supportInvalidateOptionsMenu();
  }
  
  public final void setActionBarColor(int paramInt)
  {
    if (this.mActionBar == null) {
      return;
    }
    this.PQJ = paramInt;
    this.VQV = au.auk(this.PQJ);
    this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.PQJ));
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(this.PQJ);
    }
    hFs();
    hFv();
    hFt();
    updateTitle();
    if (this.VQK != null)
    {
      if (!this.VQV) {
        break label116;
      }
      this.VQK.setTextColor(this.mContext.getResources().getColor(a.c.actionbar_subtitle_light_color));
    }
    for (;;)
    {
      hFu();
      return;
      label116:
      this.VQK.setTextColor(this.mContext.getResources().getColor(a.c.actionbar_subtitle_color));
    }
  }
  
  public final void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramOnMenuItemClickListener, 0, BaseActivity.a.VRd);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if ((this.mActionBar == null) || (this.mLH == null)) {
      return;
    }
    this.mLH.setText(paramCharSequence.toString());
    updateTitle();
  }
  
  public static final class b
  {
    int VRh = -1;
    int VRi;
    View VRj;
    View VRk;
    View VRl;
    BaseActivity.c VRm = BaseActivity.c.VRn;
    boolean enable = true;
    MenuItem.OnMenuItemClickListener naX;
    String text;
    boolean visible = true;
    View.OnLongClickListener wOt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.BaseActivity
 * JD-Core Version:    0.7.0.1
 */