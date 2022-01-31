package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.IBinder;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.f;
import android.support.v4.view.f.d;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.ac.a.d;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.j;
import com.tencent.mm.ac.a.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

public class n
{
  final String TAG;
  ah dPi = new ah(Looper.getMainLooper());
  MenuItem kcI = null;
  boolean wek = false;
  public boolean wel = false;
  private boolean wem = false;
  private boolean wen = true;
  boolean weo = true;
  public d wep = null;
  public b weq;
  private SearchViewNotRealTimeHelper.a wer;
  private boolean wes = true;
  private ArrayList<String> wet;
  private boolean weu;
  public int wev = a.k.app_empty_string;
  private int wew = 0;
  a wex;
  
  public n()
  {
    this.wek = false;
    this.TAG = ("MicroMsg.SearchViewHelper-" + String.valueOf(System.currentTimeMillis()));
  }
  
  public n(byte paramByte)
  {
    this.wek = true;
    this.TAG = ("MicroMsg.SearchViewHelper-" + String.valueOf(System.currentTimeMillis()));
  }
  
  private void b(final Activity paramActivity, Menu paramMenu)
  {
    if ((this.wen) && ((this.wel) || (this.wem)))
    {
      this.wem = false;
      if ((paramActivity instanceof MMActivity)) {
        ((MMActivity)paramActivity).ta(ae.getContext().getResources().getColor(a.d.normal_actionbar_color));
      }
      if (paramMenu != null)
      {
        int i = 0;
        while (i < paramMenu.size())
        {
          MenuItem localMenuItem = paramMenu.getItem(i);
          if (localMenuItem.getItemId() != a.g.menu_search) {
            localMenuItem.setVisible(false);
          }
          i += 1;
        }
      }
      this.dPi.postDelayed(new Runnable()
      {
        public final void run()
        {
          if (n.this.kcI == null)
          {
            y.w(n.this.TAG, "on post expand search menu, but item is null");
            return;
          }
          y.i(n.this.TAG, "try to expand action view, searchViewExpand %B", new Object[] { Boolean.valueOf(n.this.wel) });
          if (n.this.wek) {
            if (!n.this.wel) {
              f.b(n.this.kcI);
            }
          }
          for (;;)
          {
            final View localView = f.a(n.this.kcI);
            if ((localView == null) || (!n.this.wel)) {
              break;
            }
            localView.findViewById(a.g.edittext).requestFocus();
            if (!n.this.weo) {
              break;
            }
            n.this.dPi.postDelayed(new Runnable()
            {
              public final void run()
              {
                ((InputMethodManager)n.10.this.val$activity.getSystemService("input_method")).showSoftInput(localView.findViewById(a.g.edittext), 0);
              }
            }, 128L);
            return;
            if (n.this.wex != null) {
              n.this.wex.cJh();
            }
          }
        }
      }, 128L);
    }
  }
  
  public boolean TM()
  {
    return false;
  }
  
  public void TN() {}
  
  public void TO() {}
  
  public void a(Activity paramActivity, Menu paramMenu)
  {
    y.v(this.TAG, "on prepare options menu, searchViewExpand %B, triggerExpand %B, canExpand %B", new Object[] { Boolean.valueOf(this.wel), Boolean.valueOf(this.wem), Boolean.valueOf(this.wen) });
    if (paramActivity == null)
    {
      y.w(this.TAG, "on hanle status fail, activity is null");
      return;
    }
    this.kcI = paramMenu.findItem(a.g.menu_search);
    if (this.kcI == null)
    {
      y.w(this.TAG, "can not find search menu, error");
      return;
    }
    this.kcI.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        return false;
      }
    });
    b(paramActivity, paramMenu);
  }
  
  public final void a(final FragmentActivity paramFragmentActivity, Menu paramMenu)
  {
    y.v(this.TAG, "on create options menu");
    if (paramFragmentActivity == null)
    {
      y.w(this.TAG, "on add search menu, activity is null");
      return;
    }
    if (this.wep == null)
    {
      if (this.wes)
      {
        this.wep = new ActionBarSearchView(paramFragmentActivity);
        this.wep.setAutoMatchKeywords(this.weu);
        this.wep.setKeywords(this.wet);
      }
    }
    else
    {
      this.wep.setCallBack(new ActionBarSearchView.b()
      {
        public final void GH(String paramAnonymousString)
        {
          if (!n.this.wel) {
            y.v(n.this.TAG, "onSearchTextChange %s, but not in searching", new Object[] { paramAnonymousString });
          }
          while (n.this.weq == null) {
            return;
          }
          n.this.weq.pC(paramAnonymousString);
        }
        
        public final void Wn()
        {
          if (n.this.weq != null) {
            n.this.weq.Wn();
          }
        }
        
        public final void beQ()
        {
          if (n.this.weq != null) {
            n.this.weq.Wo();
          }
        }
        
        public final void beR()
        {
          if (!n.this.wel)
          {
            y.v(n.this.TAG, "onVoiceSearchRequired, but not in searching");
            return;
          }
          n.this.TN();
        }
      });
      this.wep.nH(TM());
      this.wep.setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          if ((3 == paramAnonymousInt) && (n.this.weq != null)) {
            return n.this.weq.pB(n.this.getSearchContent());
          }
          return false;
        }
      });
      if (this.wew != 0) {
        this.wep.setSearchTipIcon(this.wew);
      }
      this.kcI = paramMenu.add(0, a.g.menu_search, 0, this.wev);
      this.kcI.setEnabled(this.wen);
      int i = a.j.actionbar_icon_dark_search;
      if (ae.getContext().getSharedPreferences(ae.cqR() + "_redesign", 4).getBoolean("dark_actionbar", false)) {
        i = a.j.actionbar_icon_light_search;
      }
      this.kcI.setIcon(i);
      f.a(this.kcI, (View)this.wep);
      if (!this.wek) {
        break label336;
      }
      f.a(this.kcI, 9);
      label266:
      if (!this.wek) {
        break label347;
      }
      f.a(this.kcI, new f.d()
      {
        public final boolean dh()
        {
          n.this.a(paramFragmentActivity, false);
          return true;
        }
        
        public final boolean di()
        {
          n.this.b(paramFragmentActivity, false);
          return true;
        }
      });
    }
    for (;;)
    {
      this.wep.setBackClickCallback(new ActionBarSearchView.a()
      {
        public final void beS()
        {
          if (n.this.wek) {
            if (n.this.kcI != null) {
              f.c(n.this.kcI);
            }
          }
          while (n.this.wex == null) {
            return;
          }
          n.this.wex.collapseActionView();
        }
      });
      return;
      this.wep = new SearchViewNotRealTimeHelper(paramFragmentActivity);
      this.wep.setNotRealCallBack(this.wer);
      break;
      label336:
      f.a(this.kcI, 2);
      break label266;
      label347:
      this.wex = new a()
      {
        public final void cJh()
        {
          n.this.a(paramFragmentActivity, true);
        }
        
        public final void collapseActionView()
        {
          n.this.b(paramFragmentActivity, true);
        }
      };
    }
  }
  
  public final void a(final FragmentActivity paramFragmentActivity, final boolean paramBoolean)
  {
    y.d(this.TAG, "doNewExpand, searchViewExpand " + this.wel);
    if (!this.wel)
    {
      this.wel = true;
      b(paramFragmentActivity, null);
      this.dPi.post(new Runnable()
      {
        public final void run()
        {
          if ((paramFragmentActivity == null) || (paramFragmentActivity.isFinishing())) {
            y.w(n.this.TAG, "want to expand search view, but activity status error");
          }
          while (!paramBoolean) {
            return;
          }
          paramFragmentActivity.supportInvalidateOptionsMenu();
        }
      });
      if (this.weq != null) {
        this.weq.Wm();
      }
    }
  }
  
  public final void b(final FragmentActivity paramFragmentActivity, final boolean paramBoolean)
  {
    y.d(this.TAG, "doNewCollapse, searchViewExpand " + this.wel);
    if (this.wel)
    {
      this.wel = false;
      TO();
      if (this.wep != null) {
        this.wep.nI(false);
      }
      this.dPi.post(new Runnable()
      {
        public final void run()
        {
          if ((paramFragmentActivity == null) || (paramFragmentActivity.isFinishing())) {
            y.w(n.this.TAG, "want to collapse search view, but activity status error");
          }
          while (!paramBoolean) {
            return;
          }
          paramFragmentActivity.supportInvalidateOptionsMenu();
        }
      });
      if (this.weq != null) {
        this.dPi.post(new Runnable()
        {
          public final void run()
          {
            if (n.this.weq != null) {
              n.this.weq.Wl();
            }
          }
        });
      }
    }
    this.dPi.post(new Runnable()
    {
      public final void run()
      {
        if (n.this.kcI == null) {
          y.w(n.this.TAG, "want to collapse search view, but search menu item is null");
        }
        Object localObject1;
        do
        {
          return;
          if ((paramFragmentActivity != null) && (!paramFragmentActivity.isFinishing()))
          {
            Object localObject2 = paramFragmentActivity;
            localObject1 = (InputMethodManager)((FragmentActivity)localObject2).getSystemService("input_method");
            if (localObject1 != null)
            {
              localObject2 = ((FragmentActivity)localObject2).getCurrentFocus();
              if (localObject2 != null)
              {
                localObject2 = ((View)localObject2).getWindowToken();
                if (localObject2 != null) {
                  ((InputMethodManager)localObject1).hideSoftInputFromWindow((IBinder)localObject2, 0);
                }
              }
            }
          }
          localObject1 = f.a(n.this.kcI);
        } while (localObject1 == null);
        ((View)localObject1).findViewById(a.g.edittext).clearFocus();
      }
    });
  }
  
  public final boolean cIK()
  {
    if (this.wep != null) {
      return this.wep.cIK();
    }
    return false;
  }
  
  public final boolean cIL()
  {
    if (this.wep != null) {
      return this.wep.cIL();
    }
    return false;
  }
  
  public final void cJg()
  {
    y.d(this.TAG, "do collapse");
    if ((this.wel) && (this.kcI != null))
    {
      if (!this.wek) {
        break label40;
      }
      f.c(this.kcI);
    }
    label40:
    while (this.wex == null) {
      return;
    }
    this.wex.collapseActionView();
  }
  
  public final void clearFocus()
  {
    if (this.wep != null) {
      this.wep.cIJ();
    }
  }
  
  public final String getSearchContent()
  {
    if (this.wep != null) {
      return this.wep.getSearchContent();
    }
    return "";
  }
  
  public final void nK(boolean paramBoolean)
  {
    boolean bool1 = false;
    String str = this.TAG;
    boolean bool2 = this.wel;
    if (this.kcI == null) {
      bool1 = true;
    }
    y.d(str, "do expand, expanded[%B], search menu item null[%B]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    if (this.wel) {
      return;
    }
    if (!this.wen)
    {
      y.w(this.TAG, "can not expand now");
      return;
    }
    this.weo = paramBoolean;
    if (this.kcI != null)
    {
      this.dPi.post(new Runnable()
      {
        public final void run()
        {
          if (n.this.kcI == null) {
            y.w(n.this.TAG, "post do expand search menu, but search menu item is null");
          }
          do
          {
            return;
            if (n.this.wek)
            {
              f.b(n.this.kcI);
              return;
            }
          } while (n.this.wex == null);
          n.this.wex.cJh();
        }
      });
      return;
    }
    this.wem = true;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    y.v(this.TAG, "on key down, key code %d, expand %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.wel) });
    if ((4 == paramInt) && (this.wel))
    {
      cJg();
      return true;
    }
    return false;
  }
  
  public final void setHint(CharSequence paramCharSequence)
  {
    if (this.wep == null) {
      return;
    }
    this.wep.setHint(paramCharSequence);
  }
  
  public final void setSearchContent(String paramString)
  {
    if (this.wep == null) {
      return;
    }
    this.wep.setSearchContent(paramString);
  }
  
  public static abstract interface a
  {
    public abstract void cJh();
    
    public abstract void collapseActionView();
  }
  
  public static abstract interface b
  {
    public abstract void Wl();
    
    public abstract void Wm();
    
    public abstract void Wn();
    
    public abstract void Wo();
    
    public abstract boolean pB(String paramString);
    
    public abstract void pC(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.n
 * JD-Core Version:    0.7.0.1
 */