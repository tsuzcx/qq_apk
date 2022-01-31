package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.f;
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
import com.tencent.mm.ci.a.c;
import com.tencent.mm.ci.a.e;
import com.tencent.mm.ci.a.f;
import com.tencent.mm.ci.a.g;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class BaseActivity
  extends AppCompatActivity
{
  private TextView how;
  private TextView hrg;
  private ImageView irM;
  private ActionBar mActionBar;
  private Context mContext;
  private boolean nST = false;
  private View uGK;
  private int uGL = 0;
  private ImageButton uGM;
  private ImageButton uGN;
  private TextView uGO;
  private MenuItem uGP;
  private MenuItem uGQ;
  private int uGR;
  private int uGS;
  private BaseActivity.c uGT;
  private BaseActivity.a uGU = BaseActivity.a.uGZ;
  LinkedList<BaseActivity.b> uGV = new LinkedList();
  
  private void cxR()
  {
    if (this.uGT == BaseActivity.c.uHk) {
      if (this.uGO != null) {}
    }
    for (;;)
    {
      return;
      if (this.nST)
      {
        this.uGO.setTextColor(this.mContext.getResources().getColorStateList(a.c.white_text_color_selector));
        return;
      }
      this.uGO.setTextColor(this.mContext.getResources().getColorStateList(a.c.black_text_color_selector));
      return;
      if (this.uGT == BaseActivity.c.uHm) {
        this.uGS = a.e.actionbar_icon_dark_add;
      }
      while ((this.uGM != null) && (this.uGS != 0))
      {
        this.uGM.setImageResource(this.uGS);
        if (!this.nST) {
          break label171;
        }
        this.uGM.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        return;
        if (this.uGT == BaseActivity.c.uHn) {
          this.uGS = a.e.actionbar_icon_dark_more;
        } else if (this.uGT == BaseActivity.c.uHo) {
          this.uGS = a.e.actionbar_icon_dark_search;
        }
      }
    }
    label171:
    this.uGM.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
  }
  
  protected abstract int getLayoutId();
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(getLayoutId());
    this.mContext = this;
    this.mActionBar = getSupportActionBar();
    if (this.mActionBar != null)
    {
      this.mActionBar.setLogo(new ColorDrawable(getResources().getColor(17170445)));
      this.mActionBar.dZ();
      this.mActionBar.setDisplayHomeAsUpEnabled(false);
      this.mActionBar.dY();
      this.mActionBar.ea();
      paramBundle = LayoutInflater.from(this).inflate(a.g.actionbar_title, null);
      this.mActionBar.setCustomView(paramBundle);
      if (this.uGL == 0) {
        this.uGL = this.mContext.getResources().getColor(a.c.normal_actionbar_color);
      }
      this.nST = an.Gf(this.uGL);
      this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.uGL));
      this.hrg = ((TextView)findViewById(16908308));
      this.how = ((TextView)findViewById(16908309));
      this.uGK = findViewById(a.f.actionbar_up_indicator);
      this.irM = ((ImageView)findViewById(a.f.actionbar_up_indicator_btn));
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          BaseActivity.this.finish();
          return true;
        }
      });
    }
    int i;
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (this.uGL == 0) {
        this.uGL = this.mContext.getResources().getColor(a.c.normal_actionbar_color);
      }
      paramBundle = getWindow();
      paramBundle.clearFlags(201326592);
      paramBundle.addFlags(-2147483648);
      paramBundle.setStatusBarColor(an.n(this.mContext.getResources().getColor(a.c.statusbar_fg_color), this.uGL));
      if (Build.VERSION.SDK_INT >= 23)
      {
        paramBundle = getWindow().getDecorView();
        i = paramBundle.getSystemUiVisibility();
        if (!this.nST) {
          break label337;
        }
        i &= 0xFFFFDFFF;
      }
    }
    for (;;)
    {
      paramBundle.setSystemUiVisibility(i);
      return;
      label337:
      i |= 0x2000;
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    ao.s("on create option menu, menuCache size:%d", new Object[] { Integer.valueOf(this.uGV.size()) });
    if ((this.mActionBar == null) || (this.uGV.size() == 0)) {
      ao.u("error, mActionBar is null or cache size:%d", new Object[] { Integer.valueOf(this.uGV.size()) });
    }
    for (int i = 0; i != 0; i = 1)
    {
      return true;
      Iterator localIterator = this.uGV.iterator();
      while (localIterator.hasNext())
      {
        BaseActivity.b localb = (BaseActivity.b)localIterator.next();
        if (localb.uHd != 16908332)
        {
          if (localb.uHi == BaseActivity.c.uHo)
          {
            this.uGP = paramMenu.add(0, localb.uHd, 0, localb.text);
            localObject = new BaseActivity.3(this, localb);
            if (localb.uHh == null) {
              localb.uHh = View.inflate(this.mContext, a.g.action_option_view, null);
            }
            this.uGN = ((ImageButton)localb.uHh.findViewById(a.f.action_option_icon));
            this.uGN.setVisibility(0);
            if (this.uGN != null)
            {
              if (!this.nST) {
                break label296;
              }
              this.uGN.setImageResource(a.e.actionbar_icon_light_search);
            }
            for (;;)
            {
              this.uGN.setOnClickListener((View.OnClickListener)localObject);
              this.uGN.setEnabled(localb.bIU);
              f.a(this.uGP, localb.uHh);
              this.uGP.setEnabled(localb.bIU);
              this.uGP.setVisible(localb.aoL);
              break;
              label296:
              this.uGN.setImageResource(a.e.actionbar_icon_dark_search);
            }
          }
          this.uGQ = paramMenu.add(0, localb.uHd, 0, localb.text);
          Object localObject = new BaseActivity.4(this, localb);
          BaseActivity.5 local5 = new BaseActivity.5(this, localb);
          this.uGT = localb.uHi;
          if ((localb.uHi == BaseActivity.c.uHl) || (localb.uHi == BaseActivity.c.uHk))
          {
            if (localb.uHf == null) {
              localb.uHf = View.inflate(this.mContext, a.g.action_option_view, null);
            }
            this.uGO = ((TextView)localb.uHf.findViewById(a.f.action_option_text));
            this.uGO.setVisibility(0);
            this.uGO.setText(localb.text);
            if (localb.uHi == BaseActivity.c.uHl)
            {
              this.uGO.setTextColor(this.mContext.getResources().getColorStateList(a.c.green_text_color_selector));
              label479:
              this.uGO.setOnClickListener((View.OnClickListener)localObject);
              this.uGO.setOnLongClickListener(local5);
              this.uGO.setEnabled(localb.bIU);
              f.a(this.uGQ, localb.uHf);
            }
          }
          for (;;)
          {
            this.uGQ.setEnabled(localb.bIU);
            this.uGQ.setVisible(localb.aoL);
            if (this.uGQ == null) {
              break;
            }
            f.a(this.uGQ, 2);
            break;
            cxR();
            break label479;
            if (localb.uHe != 0) {
              this.uGS = localb.uHe;
            }
            if (localb.uHi == BaseActivity.c.uHp) {
              this.uGS = 0;
            }
            if (localb.uHg == null) {
              localb.uHg = View.inflate(this.mContext, a.g.action_option_view, null);
            }
            this.uGM = ((ImageButton)localb.uHg.findViewById(a.f.action_option_icon));
            cxR();
            if (this.uGS != 0)
            {
              this.uGM.setVisibility(0);
              this.uGM.setOnClickListener((View.OnClickListener)localObject);
              this.uGM.setOnLongClickListener(local5);
              this.uGM.setEnabled(localb.bIU);
              f.a(this.uGQ, localb.uHg);
            }
          }
        }
      }
      if (this.uGP != null) {
        f.a(this.uGP, 2);
      }
    }
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public final void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    BaseActivity.a locala = BaseActivity.a.uGZ;
    if (this.mActionBar != null)
    {
      this.mActionBar.setDisplayHomeAsUpEnabled(false);
      if (this.uGK != null)
      {
        this.uGK.setVisibility(0);
        this.uGK.setOnClickListener(new BaseActivity.2(this, paramOnMenuItemClickListener));
      }
      this.uGU = locala;
      if (this.uGU == BaseActivity.a.uHb) {
        this.uGR = 0;
      }
      if (this.uGU != BaseActivity.a.uGZ) {
        break label128;
      }
      this.uGR = a.e.actionbar_icon_dark_back;
    }
    for (;;)
    {
      if ((this.irM != null) && (this.uGR != 0))
      {
        if (this.irM != null) {
          this.irM.setVisibility(0);
        }
        this.irM.setImageResource(this.uGR);
      }
      return;
      label128:
      if (this.uGU == BaseActivity.a.uHa) {
        this.uGR = a.e.actionbar_icon_dark_close;
      }
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if ((this.mActionBar == null) || (this.hrg == null)) {}
    do
    {
      return;
      this.hrg.setText(paramCharSequence.toString());
    } while (this.hrg == null);
    if (this.nST)
    {
      this.hrg.setTextColor(this.mContext.getResources().getColor(a.c.actionbar_title_light_color));
      return;
    }
    this.hrg.setTextColor(this.mContext.getResources().getColor(a.c.actionbar_title_color));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.BaseActivity
 * JD-Core Version:    0.7.0.1
 */