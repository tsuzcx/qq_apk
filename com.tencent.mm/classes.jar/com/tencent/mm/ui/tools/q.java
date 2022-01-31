package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.IBinder;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.h;
import android.support.v4.view.h.a;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

public class q
{
  boolean Axa;
  public boolean Axb;
  private boolean Axc;
  private boolean Axd;
  boolean Axe;
  public d Axf;
  public b Axg;
  private SearchViewNotRealTimeHelper.a Axh;
  private boolean Axi;
  private ArrayList<String> Axj;
  private boolean Axk;
  public int Axl;
  private int Axm;
  a Axn;
  final String TAG;
  ak faV;
  MenuItem mxt;
  
  public q()
  {
    AppMethodBeat.i(107772);
    this.Axa = false;
    this.Axb = false;
    this.Axc = false;
    this.Axd = true;
    this.Axe = true;
    this.mxt = null;
    this.faV = new ak(Looper.getMainLooper());
    this.Axf = null;
    this.Axi = true;
    this.Axl = 2131296919;
    this.Axm = 0;
    this.Axi = true;
    this.Axa = false;
    this.TAG = ("MicroMsg.SearchViewHelper-" + String.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(107772);
  }
  
  public q(byte paramByte)
  {
    AppMethodBeat.i(107773);
    this.Axa = false;
    this.Axb = false;
    this.Axc = false;
    this.Axd = true;
    this.Axe = true;
    this.mxt = null;
    this.faV = new ak(Looper.getMainLooper());
    this.Axf = null;
    this.Axi = true;
    this.Axl = 2131296919;
    this.Axm = 0;
    this.Axi = true;
    this.Axa = true;
    this.TAG = ("MicroMsg.SearchViewHelper-" + String.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(107773);
  }
  
  private void b(final Activity paramActivity, Menu paramMenu)
  {
    AppMethodBeat.i(107780);
    if ((this.Axd) && ((this.Axb) || (this.Axc)))
    {
      this.Axc = false;
      if ((paramActivity instanceof MMActivity)) {
        ((MMActivity)paramActivity).setActionbarColor(ah.getContext().getResources().getColor(2131690316));
      }
      if (paramMenu != null)
      {
        int i = 0;
        while (i < paramMenu.size())
        {
          MenuItem localMenuItem = paramMenu.getItem(i);
          if (localMenuItem.getItemId() != 2131820646) {
            localMenuItem.setVisible(false);
          }
          i += 1;
        }
      }
      this.faV.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107769);
          if (q.this.mxt == null)
          {
            ab.w(q.this.TAG, "on post expand search menu, but item is null");
            AppMethodBeat.o(107769);
            return;
          }
          ab.i(q.this.TAG, "try to expand action view, searchViewExpand %B", new Object[] { Boolean.valueOf(q.this.Axb) });
          if (q.this.Axa) {
            if (!q.this.Axb) {
              q.this.mxt.expandActionView();
            }
          }
          for (;;)
          {
            final View localView = q.this.mxt.getActionView();
            if ((localView != null) && (q.this.Axb))
            {
              localView.findViewById(2131820995).requestFocus();
              if (q.this.Axe) {
                q.this.faV.postDelayed(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(107768);
                    ((InputMethodManager)q.10.this.val$activity.getSystemService("input_method")).showSoftInput(localView.findViewById(2131820995), 0);
                    AppMethodBeat.o(107768);
                  }
                }, 128L);
              }
            }
            AppMethodBeat.o(107769);
            return;
            if (q.this.Axn != null) {
              q.this.Axn.dNW();
            }
          }
        }
      }, 128L);
    }
    AppMethodBeat.o(107780);
  }
  
  public void a(Activity paramActivity, Menu paramMenu)
  {
    AppMethodBeat.i(107779);
    ab.v(this.TAG, "on prepare options menu, searchViewExpand %B, triggerExpand %B, canExpand %B", new Object[] { Boolean.valueOf(this.Axb), Boolean.valueOf(this.Axc), Boolean.valueOf(this.Axd) });
    if (paramActivity == null)
    {
      ab.w(this.TAG, "on hanle status fail, activity is null");
      AppMethodBeat.o(107779);
      return;
    }
    this.mxt = paramMenu.findItem(2131820646);
    if (this.mxt == null)
    {
      ab.w(this.TAG, "can not find search menu, error");
      AppMethodBeat.o(107779);
      return;
    }
    this.mxt.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        return false;
      }
    });
    b(paramActivity, paramMenu);
    AppMethodBeat.o(107779);
  }
  
  public void a(final FragmentActivity paramFragmentActivity, Menu paramMenu)
  {
    AppMethodBeat.i(107778);
    ab.v(this.TAG, "on create options menu");
    if (paramFragmentActivity == null)
    {
      ab.w(this.TAG, "on add search menu, activity is null");
      AppMethodBeat.o(107778);
      return;
    }
    if (this.Axf == null)
    {
      if (this.Axi)
      {
        this.Axf = new ActionBarSearchView(paramFragmentActivity);
        this.Axf.setAutoMatchKeywords(this.Axk);
        this.Axf.setKeywords(this.Axj);
      }
    }
    else
    {
      this.Axf.setCallBack(new ActionBarSearchView.b()
      {
        public final void Sk(String paramAnonymousString)
        {
          AppMethodBeat.i(107757);
          if (!q.this.Axb)
          {
            ab.v(q.this.TAG, "onSearchTextChange %s, but not in searching", new Object[] { paramAnonymousString });
            AppMethodBeat.o(107757);
            return;
          }
          if (q.this.Axg != null) {
            q.this.Axg.wS(paramAnonymousString);
          }
          AppMethodBeat.o(107757);
        }
        
        public final void apP()
        {
          AppMethodBeat.i(107758);
          if (q.this.Axg != null) {
            q.this.Axg.apP();
          }
          AppMethodBeat.o(107758);
        }
        
        public final void bMl()
        {
          AppMethodBeat.i(107756);
          if (q.this.Axg != null) {
            q.this.Axg.apQ();
          }
          AppMethodBeat.o(107756);
        }
        
        public final void bMm()
        {
          AppMethodBeat.i(107755);
          if (!q.this.Axb)
          {
            ab.v(q.this.TAG, "onVoiceSearchRequired, but not in searching");
            AppMethodBeat.o(107755);
            return;
          }
          q.this.ana();
          AppMethodBeat.o(107755);
        }
      });
      this.Axf.rr(amZ());
      this.Axf.setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(107762);
          if ((3 == paramAnonymousInt) && (q.this.Axg != null))
          {
            boolean bool = q.this.Axg.wR(q.this.getSearchContent());
            AppMethodBeat.o(107762);
            return bool;
          }
          AppMethodBeat.o(107762);
          return false;
        }
      });
      if (this.Axm != 0) {
        this.Axf.setSearchTipIcon(this.Axm);
      }
      this.mxt = paramMenu.add(0, 2131820646, 0, this.Axl);
      this.mxt.setEnabled(this.Axd);
      this.mxt.setIcon(2131230741);
      this.mxt.setActionView((View)this.Axf);
      if (!this.Axa) {
        break label307;
      }
      this.mxt.setShowAsAction(9);
      label232:
      if (!this.Axa) {
        break label320;
      }
      h.a(this.mxt, new h.a()
      {
        public final boolean dD()
        {
          AppMethodBeat.i(107763);
          q.this.a(paramFragmentActivity, false);
          AppMethodBeat.o(107763);
          return true;
        }
        
        public final boolean dE()
        {
          AppMethodBeat.i(107764);
          q.this.b(paramFragmentActivity, false);
          AppMethodBeat.o(107764);
          return true;
        }
      });
    }
    for (;;)
    {
      this.Axf.setBackClickCallback(new ActionBarSearchView.a()
      {
        public final void bMn()
        {
          AppMethodBeat.i(107767);
          if (q.this.Axa)
          {
            if (q.this.mxt != null)
            {
              q.this.mxt.collapseActionView();
              AppMethodBeat.o(107767);
            }
          }
          else if (q.this.Axn != null) {
            q.this.Axn.collapseActionView();
          }
          AppMethodBeat.o(107767);
        }
      });
      AppMethodBeat.o(107778);
      return;
      this.Axf = new SearchViewNotRealTimeHelper(paramFragmentActivity);
      this.Axf.setNotRealCallBack(this.Axh);
      break;
      label307:
      this.mxt.setShowAsAction(2);
      break label232;
      label320:
      this.Axn = new a()
      {
        public final void collapseActionView()
        {
          AppMethodBeat.i(107766);
          q.this.b(paramFragmentActivity, true);
          AppMethodBeat.o(107766);
        }
        
        public final void dNW()
        {
          AppMethodBeat.i(107765);
          q.this.a(paramFragmentActivity, true);
          AppMethodBeat.o(107765);
        }
      };
    }
  }
  
  public final void a(final FragmentActivity paramFragmentActivity, final boolean paramBoolean)
  {
    AppMethodBeat.i(107786);
    ab.d(this.TAG, "doNewExpand, searchViewExpand " + this.Axb);
    if (!this.Axb)
    {
      this.Axb = true;
      b(paramFragmentActivity, null);
      this.faV.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107771);
          if ((paramFragmentActivity == null) || (paramFragmentActivity.isFinishing()))
          {
            ab.w(q.this.TAG, "want to expand search view, but activity status error");
            AppMethodBeat.o(107771);
            return;
          }
          if (paramBoolean) {
            paramFragmentActivity.supportInvalidateOptionsMenu();
          }
          AppMethodBeat.o(107771);
        }
      });
      if (this.Axg != null) {
        this.Axg.apO();
      }
    }
    AppMethodBeat.o(107786);
  }
  
  protected boolean amZ()
  {
    return false;
  }
  
  protected void ana() {}
  
  protected void anb() {}
  
  public final void b(final FragmentActivity paramFragmentActivity, final boolean paramBoolean)
  {
    AppMethodBeat.i(107787);
    ab.d(this.TAG, "doNewCollapse, searchViewExpand " + this.Axb);
    if (this.Axb)
    {
      this.Axb = false;
      anb();
      if (this.Axf != null) {
        this.Axf.rs(false);
      }
      this.faV.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107759);
          if ((paramFragmentActivity == null) || (paramFragmentActivity.isFinishing()))
          {
            ab.w(q.this.TAG, "want to collapse search view, but activity status error");
            AppMethodBeat.o(107759);
            return;
          }
          if (paramBoolean) {
            paramFragmentActivity.supportInvalidateOptionsMenu();
          }
          AppMethodBeat.o(107759);
        }
      });
      if (this.Axg != null) {
        this.faV.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107760);
            if (q.this.Axg != null) {
              q.this.Axg.apN();
            }
            AppMethodBeat.o(107760);
          }
        });
      }
    }
    this.faV.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107761);
        if (q.this.mxt == null)
        {
          ab.w(q.this.TAG, "want to collapse search view, but search menu item is null");
          AppMethodBeat.o(107761);
          return;
        }
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
        Object localObject1 = q.this.mxt.getActionView();
        if (localObject1 != null) {
          ((View)localObject1).findViewById(2131820995).clearFocus();
        }
        AppMethodBeat.o(107761);
      }
    });
    AppMethodBeat.o(107787);
  }
  
  public final void clearFocus()
  {
    AppMethodBeat.i(107777);
    if (this.Axf != null) {
      this.Axf.dNx();
    }
    AppMethodBeat.o(107777);
  }
  
  public final void dNV()
  {
    AppMethodBeat.i(107783);
    ab.d(this.TAG, "do collapse");
    if ((this.Axb) && (this.mxt != null))
    {
      if (this.Axa)
      {
        this.mxt.collapseActionView();
        AppMethodBeat.o(107783);
        return;
      }
      if (this.Axn != null) {
        this.Axn.collapseActionView();
      }
    }
    AppMethodBeat.o(107783);
  }
  
  public final boolean dNy()
  {
    AppMethodBeat.i(107784);
    if (this.Axf != null)
    {
      boolean bool = this.Axf.dNy();
      AppMethodBeat.o(107784);
      return bool;
    }
    AppMethodBeat.o(107784);
    return false;
  }
  
  public final boolean dNz()
  {
    AppMethodBeat.i(107785);
    if (this.Axf != null)
    {
      boolean bool = this.Axf.dNz();
      AppMethodBeat.o(107785);
      return bool;
    }
    AppMethodBeat.o(107785);
    return false;
  }
  
  public final String getSearchContent()
  {
    AppMethodBeat.i(107774);
    if (this.Axf != null)
    {
      String str = this.Axf.getSearchContent();
      AppMethodBeat.o(107774);
      return str;
    }
    AppMethodBeat.o(107774);
    return "";
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(107781);
    ab.v(this.TAG, "on key down, key code %d, expand %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.Axb) });
    if ((4 == paramInt) && (this.Axb))
    {
      dNV();
      AppMethodBeat.o(107781);
      return true;
    }
    AppMethodBeat.o(107781);
    return false;
  }
  
  public final void ru(boolean paramBoolean)
  {
    boolean bool1 = false;
    AppMethodBeat.i(107782);
    String str = this.TAG;
    boolean bool2 = this.Axb;
    if (this.mxt == null) {
      bool1 = true;
    }
    ab.d(str, "do expand, expanded[%B], search menu item null[%B]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    if (this.Axb)
    {
      AppMethodBeat.o(107782);
      return;
    }
    if (!this.Axd)
    {
      ab.w(this.TAG, "can not expand now");
      AppMethodBeat.o(107782);
      return;
    }
    this.Axe = paramBoolean;
    if (this.mxt != null)
    {
      this.faV.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107770);
          if (q.this.mxt == null)
          {
            ab.w(q.this.TAG, "post do expand search menu, but search menu item is null");
            AppMethodBeat.o(107770);
            return;
          }
          if (q.this.Axa)
          {
            q.this.mxt.expandActionView();
            AppMethodBeat.o(107770);
            return;
          }
          if (q.this.Axn != null) {
            q.this.Axn.dNW();
          }
          AppMethodBeat.o(107770);
        }
      });
      AppMethodBeat.o(107782);
      return;
    }
    this.Axc = true;
    AppMethodBeat.o(107782);
  }
  
  public final void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(107776);
    if (this.Axf == null)
    {
      AppMethodBeat.o(107776);
      return;
    }
    this.Axf.setHint(paramCharSequence);
    AppMethodBeat.o(107776);
  }
  
  public void setSearchContent(String paramString)
  {
    AppMethodBeat.i(107775);
    if (this.Axf == null)
    {
      AppMethodBeat.o(107775);
      return;
    }
    this.Axf.setSearchContent(paramString);
    AppMethodBeat.o(107775);
  }
  
  public static abstract interface a
  {
    public abstract void collapseActionView();
    
    public abstract void dNW();
  }
  
  public static abstract interface b
  {
    public abstract void apN();
    
    public abstract void apO();
    
    public abstract void apP();
    
    public abstract void apQ();
    
    public abstract boolean wR(String paramString);
    
    public abstract void wS(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.q
 * JD-Core Version:    0.7.0.1
 */