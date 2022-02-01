package com.tencent.mm.ui.tools;

import android.app.Activity;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.am;
import java.util.ArrayList;

public class r
{
  boolean ITG;
  public boolean ITH;
  private boolean ITI;
  private boolean ITJ;
  boolean ITK;
  public d ITL;
  public b ITM;
  private SearchViewNotRealTimeHelper.a ITN;
  private boolean ITO;
  private ArrayList<String> ITP;
  private boolean ITQ;
  public int ITR;
  private int ITS;
  a ITT;
  final String TAG;
  com.tencent.mm.sdk.platformtools.ao gox;
  MenuItem qNu;
  
  public r()
  {
    AppMethodBeat.i(143240);
    this.ITG = false;
    this.ITH = false;
    this.ITI = false;
    this.ITJ = true;
    this.ITK = true;
    this.qNu = null;
    this.gox = new com.tencent.mm.sdk.platformtools.ao(Looper.getMainLooper());
    this.ITL = null;
    this.ITO = true;
    this.ITR = 2131755726;
    this.ITS = 0;
    this.ITO = true;
    this.ITG = false;
    this.TAG = ("MicroMsg.SearchViewHelper-" + String.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(143240);
  }
  
  public r(byte paramByte)
  {
    AppMethodBeat.i(143241);
    this.ITG = false;
    this.ITH = false;
    this.ITI = false;
    this.ITJ = true;
    this.ITK = true;
    this.qNu = null;
    this.gox = new com.tencent.mm.sdk.platformtools.ao(Looper.getMainLooper());
    this.ITL = null;
    this.ITO = true;
    this.ITR = 2131755726;
    this.ITS = 0;
    this.ITO = true;
    this.ITG = true;
    this.TAG = ("MicroMsg.SearchViewHelper-" + String.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(143241);
  }
  
  private void b(final Activity paramActivity, Menu paramMenu)
  {
    AppMethodBeat.i(143249);
    if ((this.ITJ) && ((this.ITH) || (this.ITI)))
    {
      this.ITI = false;
      if ((paramActivity instanceof MMActivity)) {
        ((MMActivity)paramActivity).setActionbarColor(com.tencent.mm.ui.ao.aJ(paramActivity, 2130968577));
      }
      if (paramMenu != null)
      {
        int i = 0;
        while (i < paramMenu.size())
        {
          MenuItem localMenuItem = paramMenu.getItem(i);
          if (localMenuItem.getItemId() != 2131302248) {
            localMenuItem.setVisible(false);
          }
          i += 1;
        }
      }
      this.gox.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143237);
          if (r.this.qNu == null)
          {
            ac.w(r.this.TAG, "on post expand search menu, but item is null");
            AppMethodBeat.o(143237);
            return;
          }
          ac.i(r.this.TAG, "try to expand action view, searchViewExpand %B", new Object[] { Boolean.valueOf(r.this.ITH) });
          if (r.this.ITG) {
            if (!r.this.ITH) {
              r.this.qNu.expandActionView();
            }
          }
          for (;;)
          {
            final View localView = r.this.qNu.getActionView();
            if ((localView != null) && (r.this.ITH))
            {
              localView.findViewById(2131299306).requestFocus();
              if (r.this.ITK) {
                r.this.gox.postDelayed(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(143236);
                    ((InputMethodManager)r.10.this.val$activity.getSystemService("input_method")).showSoftInput(localView.findViewById(2131299306), 0);
                    AppMethodBeat.o(143236);
                  }
                }, 128L);
              }
            }
            AppMethodBeat.o(143237);
            return;
            if (r.this.ITT != null) {
              r.this.ITT.ftS();
            }
          }
        }
      }, 128L);
    }
    AppMethodBeat.o(143249);
  }
  
  public void a(Activity paramActivity, Menu paramMenu)
  {
    AppMethodBeat.i(143248);
    ac.v(this.TAG, "on prepare options menu, searchViewExpand %B, triggerExpand %B, canExpand %B", new Object[] { Boolean.valueOf(this.ITH), Boolean.valueOf(this.ITI), Boolean.valueOf(this.ITJ) });
    if (paramActivity == null)
    {
      ac.w(this.TAG, "on hanle status fail, activity is null");
      AppMethodBeat.o(143248);
      return;
    }
    this.qNu = paramMenu.findItem(2131302248);
    if (this.qNu == null)
    {
      ac.w(this.TAG, "can not find search menu, error");
      AppMethodBeat.o(143248);
      return;
    }
    this.qNu.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        return false;
      }
    });
    b(paramActivity, paramMenu);
    AppMethodBeat.o(143248);
  }
  
  public void a(final FragmentActivity paramFragmentActivity, final Menu paramMenu)
  {
    AppMethodBeat.i(143247);
    ac.v(this.TAG, "on create options menu");
    if (paramFragmentActivity == null)
    {
      ac.w(this.TAG, "on add search menu, activity is null");
      AppMethodBeat.o(143247);
      return;
    }
    if (this.ITL == null)
    {
      if (this.ITO)
      {
        this.ITL = new ActionBarSearchView(paramFragmentActivity);
        this.ITL.setAutoMatchKeywords(this.ITQ);
        this.ITL.setKeywords(this.ITP);
      }
    }
    else
    {
      this.ITL.setCallBack(new ActionBarSearchView.b()
      {
        public final void aGX(String paramAnonymousString)
        {
          AppMethodBeat.i(143225);
          if (!r.this.ITH)
          {
            ac.v(r.this.TAG, "onSearchTextChange %s, but not in searching", new Object[] { paramAnonymousString });
            AppMethodBeat.o(143225);
            return;
          }
          if (r.this.ITM != null) {
            r.this.ITM.Gb(paramAnonymousString);
          }
          AppMethodBeat.o(143225);
        }
        
        public final void aPc()
        {
          AppMethodBeat.i(143226);
          if (r.this.ITM != null) {
            r.this.ITM.aPc();
          }
          AppMethodBeat.o(143226);
        }
        
        public final void ftu()
        {
          AppMethodBeat.i(143224);
          if (r.this.ITM != null) {
            r.this.ITM.aPd();
          }
          AppMethodBeat.o(143224);
        }
        
        public final void ftv()
        {
          AppMethodBeat.i(143223);
          if (!r.this.ITH)
          {
            ac.v(r.this.TAG, "onVoiceSearchRequired, but not in searching");
            AppMethodBeat.o(143223);
            return;
          }
          r.this.aKX();
          AppMethodBeat.o(143223);
        }
      });
      this.ITL.xL(aKW());
      this.ITL.setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(143230);
          if ((3 == paramAnonymousInt) && (r.this.ITM != null))
          {
            boolean bool = r.this.ITM.Ga(r.this.getSearchContent());
            AppMethodBeat.o(143230);
            return bool;
          }
          AppMethodBeat.o(143230);
          return false;
        }
      });
      if (this.ITS != 0) {
        this.ITL.setSearchTipIcon(this.ITS);
      }
      this.qNu = paramMenu.add(0, 2131302248, 0, this.ITR);
      this.qNu.setEnabled(this.ITJ);
      this.qNu.setIcon(am.k(paramFragmentActivity, 2131689494, paramFragmentActivity.getResources().getColor(2131099732)));
      this.qNu.setActionView((View)this.ITL);
      if (!this.ITG) {
        break label322;
      }
      this.qNu.setShowAsAction(9);
      label246:
      if (!this.ITG) {
        break label335;
      }
      h.a(this.qNu, new h.a()
      {
        public final boolean fd()
        {
          AppMethodBeat.i(143231);
          r.this.a(paramFragmentActivity, false, paramMenu);
          AppMethodBeat.o(143231);
          return true;
        }
        
        public final boolean fe()
        {
          AppMethodBeat.i(143232);
          r.this.b(paramFragmentActivity, false, paramMenu);
          AppMethodBeat.o(143232);
          return true;
        }
      });
    }
    for (;;)
    {
      this.ITL.setBackClickCallback(new ActionBarSearchView.a()
      {
        public final void ftt()
        {
          AppMethodBeat.i(143235);
          if (r.this.ITG)
          {
            if (r.this.qNu != null)
            {
              r.this.qNu.collapseActionView();
              AppMethodBeat.o(143235);
            }
          }
          else if (r.this.ITT != null) {
            r.this.ITT.collapseActionView();
          }
          AppMethodBeat.o(143235);
        }
      });
      AppMethodBeat.o(143247);
      return;
      this.ITL = new SearchViewNotRealTimeHelper(paramFragmentActivity);
      this.ITL.setNotRealCallBack(this.ITN);
      break;
      label322:
      this.qNu.setShowAsAction(2);
      break label246;
      label335:
      this.ITT = new a()
      {
        public final void collapseActionView()
        {
          AppMethodBeat.i(143234);
          r.this.b(paramFragmentActivity, true, paramMenu);
          AppMethodBeat.o(143234);
        }
        
        public final void ftS()
        {
          AppMethodBeat.i(143233);
          r.this.a(paramFragmentActivity, true, paramMenu);
          AppMethodBeat.o(143233);
        }
      };
    }
  }
  
  public final void a(final FragmentActivity paramFragmentActivity, final boolean paramBoolean, Menu paramMenu)
  {
    AppMethodBeat.i(143255);
    ac.d(this.TAG, "doNewExpand, searchViewExpand " + this.ITH);
    if (!this.ITH)
    {
      this.ITH = true;
      b(paramFragmentActivity, paramMenu);
      this.gox.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143239);
          if ((paramFragmentActivity == null) || (paramFragmentActivity.isFinishing()))
          {
            ac.w(r.this.TAG, "want to expand search view, but activity status error");
            AppMethodBeat.o(143239);
            return;
          }
          if (paramBoolean) {
            paramFragmentActivity.supportInvalidateOptionsMenu();
          }
          AppMethodBeat.o(143239);
        }
      });
      if (this.ITM != null) {
        this.ITM.aPb();
      }
    }
    AppMethodBeat.o(143255);
  }
  
  protected boolean aKW()
  {
    return false;
  }
  
  protected void aKX() {}
  
  public final void b(final FragmentActivity paramFragmentActivity, final boolean paramBoolean, Menu paramMenu)
  {
    AppMethodBeat.i(143256);
    ac.d(this.TAG, "doNewCollapse, searchViewExpand " + this.ITH);
    if (this.ITH)
    {
      this.ITH = false;
      c(paramMenu);
      if (this.ITL != null) {
        this.ITL.xM(false);
      }
      this.gox.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143227);
          if ((paramFragmentActivity == null) || (paramFragmentActivity.isFinishing()))
          {
            ac.w(r.this.TAG, "want to collapse search view, but activity status error");
            AppMethodBeat.o(143227);
            return;
          }
          if (paramBoolean) {
            paramFragmentActivity.supportInvalidateOptionsMenu();
          }
          AppMethodBeat.o(143227);
        }
      });
      if (this.ITM != null) {
        this.gox.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(143228);
            if (r.this.ITM != null) {
              r.this.ITM.aPa();
            }
            AppMethodBeat.o(143228);
          }
        });
      }
    }
    this.gox.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143229);
        if (r.this.qNu == null)
        {
          ac.w(r.this.TAG, "want to collapse search view, but search menu item is null");
          AppMethodBeat.o(143229);
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
        Object localObject1 = r.this.qNu.getActionView();
        if (localObject1 != null)
        {
          localObject1 = ((View)localObject1).findViewById(2131299306);
          if (localObject1 != null) {
            ((View)localObject1).clearFocus();
          }
        }
        AppMethodBeat.o(143229);
      }
    });
    AppMethodBeat.o(143256);
  }
  
  protected void c(Menu paramMenu)
  {
    AppMethodBeat.i(143246);
    if (paramMenu != null)
    {
      int i = 0;
      while (i < paramMenu.size())
      {
        MenuItem localMenuItem = paramMenu.getItem(i);
        if (localMenuItem.getItemId() != 2131302248) {
          localMenuItem.setVisible(true);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(143246);
  }
  
  public final void clearFocus()
  {
    AppMethodBeat.i(143245);
    if (this.ITL != null) {
      this.ITL.ftq();
    }
    AppMethodBeat.o(143245);
  }
  
  public final void ftR()
  {
    AppMethodBeat.i(143252);
    ac.d(this.TAG, "do collapse");
    if ((this.ITH) && (this.qNu != null))
    {
      if (this.ITG)
      {
        this.qNu.collapseActionView();
        AppMethodBeat.o(143252);
        return;
      }
      if (this.ITT != null) {
        this.ITT.collapseActionView();
      }
    }
    AppMethodBeat.o(143252);
  }
  
  public final boolean ftr()
  {
    AppMethodBeat.i(143253);
    if (this.ITL != null)
    {
      boolean bool = this.ITL.ftr();
      AppMethodBeat.o(143253);
      return bool;
    }
    AppMethodBeat.o(143253);
    return false;
  }
  
  public final boolean fts()
  {
    AppMethodBeat.i(143254);
    if (this.ITL != null)
    {
      boolean bool = this.ITL.fts();
      AppMethodBeat.o(143254);
      return bool;
    }
    AppMethodBeat.o(143254);
    return false;
  }
  
  public final String getSearchContent()
  {
    AppMethodBeat.i(143242);
    if (this.ITL != null)
    {
      String str = this.ITL.getSearchContent();
      AppMethodBeat.o(143242);
      return str;
    }
    AppMethodBeat.o(143242);
    return "";
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(143250);
    ac.v(this.TAG, "on key down, key code %d, expand %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.ITH) });
    if ((4 == paramInt) && (this.ITH))
    {
      ftR();
      AppMethodBeat.o(143250);
      return true;
    }
    AppMethodBeat.o(143250);
    return false;
  }
  
  public final void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(143244);
    if (this.ITL == null)
    {
      AppMethodBeat.o(143244);
      return;
    }
    this.ITL.setHint(paramCharSequence);
    AppMethodBeat.o(143244);
  }
  
  public void setSearchContent(String paramString)
  {
    AppMethodBeat.i(143243);
    if (this.ITL == null)
    {
      AppMethodBeat.o(143243);
      return;
    }
    this.ITL.setSearchContent(paramString);
    AppMethodBeat.o(143243);
  }
  
  public final void xO(boolean paramBoolean)
  {
    boolean bool1 = false;
    AppMethodBeat.i(143251);
    String str = this.TAG;
    boolean bool2 = this.ITH;
    if (this.qNu == null) {
      bool1 = true;
    }
    ac.d(str, "do expand, expanded[%B], search menu item null[%B]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    if (this.ITH)
    {
      AppMethodBeat.o(143251);
      return;
    }
    if (!this.ITJ)
    {
      ac.w(this.TAG, "can not expand now");
      AppMethodBeat.o(143251);
      return;
    }
    this.ITK = paramBoolean;
    if (this.qNu != null)
    {
      this.gox.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143238);
          if (r.this.qNu == null)
          {
            ac.w(r.this.TAG, "post do expand search menu, but search menu item is null");
            AppMethodBeat.o(143238);
            return;
          }
          if (r.this.ITG)
          {
            r.this.qNu.expandActionView();
            AppMethodBeat.o(143238);
            return;
          }
          if (r.this.ITT != null) {
            r.this.ITT.ftS();
          }
          AppMethodBeat.o(143238);
        }
      });
      AppMethodBeat.o(143251);
      return;
    }
    this.ITI = true;
    AppMethodBeat.o(143251);
  }
  
  public static abstract interface a
  {
    public abstract void collapseActionView();
    
    public abstract void ftS();
  }
  
  public static abstract interface b
  {
    public abstract boolean Ga(String paramString);
    
    public abstract void Gb(String paramString);
    
    public abstract void aPa();
    
    public abstract void aPb();
    
    public abstract void aPc();
    
    public abstract void aPd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.r
 * JD-Core Version:    0.7.0.1
 */