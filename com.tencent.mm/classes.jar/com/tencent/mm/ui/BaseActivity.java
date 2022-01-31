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
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class BaseActivity
  extends AppCompatActivity
{
  private View actionbarView;
  private int bcg = this.yUe;
  private TextView jaZ;
  private TextView jhF;
  private ImageView ksT;
  private ActionBar mActionBar;
  private Context mContext;
  private boolean qGO = false;
  private int theme;
  private View yTS;
  private View yTT;
  private int yTU = 0;
  private ImageButton yTV;
  private ImageButton yTW;
  private TextView yTX;
  private MenuItem yTY;
  private MenuItem yTZ;
  private int yUa;
  private int yUb;
  private BaseActivity.c yUc;
  private BaseActivity.a yUd = BaseActivity.a.yUk;
  private int yUe;
  private int yUf;
  LinkedList<BaseActivity.b> yUg = new LinkedList();
  
  private void a(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, BaseActivity.a parama)
  {
    if (this.mActionBar == null) {
      return;
    }
    if (paramOnMenuItemClickListener == null)
    {
      this.mActionBar.setDisplayHomeAsUpEnabled(false);
      this.yUd = parama;
      if (this.yUd == BaseActivity.a.yUm) {
        this.yUa = 0;
      }
      if (this.yUd != BaseActivity.a.yUk) {
        break label132;
      }
      this.yUa = 2130837617;
    }
    for (;;)
    {
      if ((this.ksT != null) && (this.yUa != 0))
      {
        dAM();
        this.ksT.setImageResource(this.yUa);
      }
      dAO();
      return;
      this.mActionBar.setDisplayHomeAsUpEnabled(false);
      if (this.yTT == null) {
        break;
      }
      this.yTT.setVisibility(0);
      this.yTT.setOnClickListener(new BaseActivity.2(this, paramOnMenuItemClickListener));
      break;
      label132:
      if (this.yUd == BaseActivity.a.yUl) {
        this.yUa = 2130837619;
      }
    }
  }
  
  private void dAM()
  {
    if (this.ksT == null) {
      return;
    }
    this.ksT.setVisibility(0);
  }
  
  private void dAN()
  {
    if (this.yUc == BaseActivity.c.yUv) {
      if (this.yTX != null) {}
    }
    for (;;)
    {
      return;
      if (this.qGO)
      {
        this.yTX.setTextColor(this.mContext.getResources().getColorStateList(2131690799));
        return;
      }
      this.yTX.setTextColor(this.mContext.getResources().getColorStateList(2131690741));
      return;
      if (this.yUc == BaseActivity.c.yUx) {
        this.yUb = 2130837616;
      }
      while ((this.yTV != null) && (this.yUb != 0))
      {
        this.yTV.setImageResource(this.yUb);
        if (!this.qGO) {
          break label166;
        }
        this.yTV.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        return;
        if (this.yUc == BaseActivity.c.yUy) {
          this.yUb = 2130837620;
        } else if (this.yUc == BaseActivity.c.yUz) {
          this.yUb = 2130837621;
        }
      }
    }
    label166:
    this.yTV.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
  }
  
  private void dAO()
  {
    if (this.qGO)
    {
      this.ksT.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      return;
    }
    this.ksT.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    int i = getApplicationContext().getSharedPreferences("SETTING_COLOR", 0).getInt("APP_THEME_COLOR", -16777216);
    switch (i)
    {
    default: 
      setTheme(i);
      setContentView(2130970058);
      this.mContext = this;
      this.mActionBar = getSupportActionBar();
      if (this.mActionBar != null)
      {
        this.mActionBar.setLogo(new ColorDrawable(getResources().getColor(17170445)));
        this.mActionBar.eu();
        this.mActionBar.setDisplayHomeAsUpEnabled(false);
        this.mActionBar.et();
        this.mActionBar.ev();
        paramBundle = LayoutInflater.from(this).inflate(2130968618, null);
        this.mActionBar.setCustomView(paramBundle);
        if (this.yTU == 0) {
          this.yTU = al.hX(this.mContext);
        }
        this.qGO = aj.Ow(this.yTU);
        this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.yTU));
        this.jhF = ((TextView)findViewById(16908308));
        this.jaZ = ((TextView)findViewById(16908309));
        this.yTS = findViewById(2131820997);
        this.yTT = findViewById(2131820988);
        this.ksT = ((ImageView)findViewById(2131820989));
        setBackBtn(new BaseActivity.1(this));
      }
      this.yUe = al.ap(this.mContext, 2131427559);
      this.yUf = al.ap(this.mContext, 2131427845);
      if (Build.VERSION.SDK_INT >= 21)
      {
        if (this.yTU == 0) {
          this.yTU = al.hX(this.mContext);
        }
        paramBundle = getWindow();
        paramBundle.clearFlags(201326592);
        paramBundle.addFlags(-2147483648);
        paramBundle.setStatusBarColor(this.yTU);
        if (Build.VERSION.SDK_INT >= 23)
        {
          paramBundle = getWindow().getDecorView();
          i = paramBundle.getSystemUiVisibility();
          if (!this.qGO) {
            break label419;
          }
          i &= 0xFFFFDFFF;
        }
      }
      break;
    }
    for (;;)
    {
      paramBundle.setSystemUiVisibility(i);
      return;
      this.theme = 2131493751;
      break;
      this.theme = 2131493750;
      break;
      label419:
      i |= 0x2000;
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    ak.d("BaseActivity", "on create option menu, menuCache size:%d", new Object[] { Integer.valueOf(this.yUg.size()) });
    if ((this.mActionBar == null) || (this.yUg.size() == 0)) {
      ak.w("BaseActivity", "error, mActionBar is null or cache size:%d", new Object[] { Integer.valueOf(this.yUg.size()) });
    }
    for (int i = 0; i != 0; i = 1)
    {
      return true;
      Iterator localIterator = this.yUg.iterator();
      while (localIterator.hasNext())
      {
        BaseActivity.b localb = (BaseActivity.b)localIterator.next();
        if (localb.yUo != 16908332)
        {
          if (localb.yUt == BaseActivity.c.yUz)
          {
            this.yTY = paramMenu.add(0, localb.yUo, 0, localb.text);
            localObject = new BaseActivity.3(this, localb);
            if (localb.yUs == null) {
              localb.yUs = View.inflate(this.mContext, 2130968612, null);
            }
            this.yTW = ((ImageButton)localb.yUs.findViewById(2131820976));
            this.yTW.setVisibility(0);
            if (this.yTW != null)
            {
              if (!this.qGO) {
                break label304;
              }
              this.yTW.setImageResource(2130837628);
            }
            for (;;)
            {
              this.yTW.setOnClickListener((View.OnClickListener)localObject);
              this.yTW.setEnabled(localb.enable);
              this.yTY.setActionView(localb.yUs);
              this.yTY.setEnabled(localb.enable);
              this.yTY.setVisible(localb.arf);
              break;
              label304:
              this.yTW.setImageResource(2130837621);
            }
          }
          this.yTZ = paramMenu.add(0, localb.yUo, 0, localb.text);
          Object localObject = new BaseActivity.4(this, localb);
          BaseActivity.5 local5 = new BaseActivity.5(this, localb);
          this.yUc = localb.yUt;
          if ((localb.yUt == BaseActivity.c.yUw) || (localb.yUt == BaseActivity.c.yUv))
          {
            if (localb.yUq == null) {
              localb.yUq = View.inflate(this.mContext, 2130968612, null);
            }
            this.yTX = ((TextView)localb.yUq.findViewById(2131820974));
            this.yTX.setVisibility(0);
            this.yTX.setText(localb.text);
            if (localb.yUt == BaseActivity.c.yUw)
            {
              this.yTX.setTextColor(this.mContext.getResources().getColorStateList(2131690742));
              label486:
              this.yTX.setOnClickListener((View.OnClickListener)localObject);
              this.yTX.setOnLongClickListener(local5);
              this.yTX.setEnabled(localb.enable);
              this.yTZ.setActionView(localb.yUq);
            }
          }
          for (;;)
          {
            this.yTZ.setEnabled(localb.enable);
            this.yTZ.setVisible(localb.arf);
            if (this.yTZ == null) {
              break;
            }
            this.yTZ.setShowAsAction(2);
            break;
            dAN();
            break label486;
            if (localb.yUp != 0) {
              this.yUb = localb.yUp;
            }
            if (localb.yUt == BaseActivity.c.yUA) {
              this.yUb = 0;
            }
            if (localb.yUr == null) {
              localb.yUr = View.inflate(this.mContext, 2130968612, null);
            }
            this.yTV = ((ImageButton)localb.yUr.findViewById(2131820976));
            dAN();
            if (this.yUb != 0)
            {
              this.yTV.setVisibility(0);
              this.yTV.setOnClickListener((View.OnClickListener)localObject);
              this.yTV.setOnLongClickListener(local5);
              this.yTV.setEnabled(localb.enable);
              this.yTZ.setActionView(localb.yUr);
            }
          }
        }
      }
      if (this.yTY != null) {
        this.yTY.setShowAsAction(2);
      }
    }
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    a(paramOnMenuItemClickListener, BaseActivity.a.yUk);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if ((this.mActionBar == null) || (this.jhF == null)) {}
    do
    {
      return;
      this.jhF.setText(paramCharSequence.toString());
    } while (this.jhF == null);
    if (this.qGO)
    {
      this.jhF.setTextColor(this.mContext.getResources().getColor(2131689653));
      return;
    }
    this.jhF.setTextColor(this.mContext.getResources().getColor(2131689652));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.BaseActivity
 * JD-Core Version:    0.7.0.1
 */