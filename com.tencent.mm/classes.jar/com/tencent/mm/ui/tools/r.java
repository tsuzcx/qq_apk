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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;

public class r
{
  boolean Lhe;
  public boolean Lhf;
  private boolean Lhg;
  private boolean Lhh;
  boolean Lhi;
  public d Lhj;
  public b Lhk;
  private SearchViewNotRealTimeHelper.a Lhl;
  private boolean Lhm;
  private ArrayList<String> Lhn;
  private boolean Lho;
  public int Lhp;
  private int Lhq;
  a Lhr;
  final String TAG;
  aq gKO;
  MenuItem rFH;
  
  public r()
  {
    AppMethodBeat.i(143240);
    this.Lhe = false;
    this.Lhf = false;
    this.Lhg = false;
    this.Lhh = true;
    this.Lhi = true;
    this.rFH = null;
    this.gKO = new aq(Looper.getMainLooper());
    this.Lhj = null;
    this.Lhm = true;
    this.Lhp = 2131755726;
    this.Lhq = 0;
    this.Lhm = true;
    this.Lhe = false;
    this.TAG = ("MicroMsg.SearchViewHelper-" + String.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(143240);
  }
  
  public r(byte paramByte)
  {
    AppMethodBeat.i(143241);
    this.Lhe = false;
    this.Lhf = false;
    this.Lhg = false;
    this.Lhh = true;
    this.Lhi = true;
    this.rFH = null;
    this.gKO = new aq(Looper.getMainLooper());
    this.Lhj = null;
    this.Lhm = true;
    this.Lhp = 2131755726;
    this.Lhq = 0;
    this.Lhm = true;
    this.Lhe = true;
    this.TAG = ("MicroMsg.SearchViewHelper-" + String.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(143241);
  }
  
  private void b(final Activity paramActivity, Menu paramMenu)
  {
    AppMethodBeat.i(143249);
    if ((this.Lhh) && ((this.Lhf) || (this.Lhg)))
    {
      this.Lhg = false;
      if ((paramActivity instanceof MMActivity)) {
        ((MMActivity)paramActivity).setActionbarColor(paramActivity.getResources().getColor(2131099648));
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
      this.gKO.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143237);
          if (r.this.rFH == null)
          {
            ae.w(r.this.TAG, "on post expand search menu, but item is null");
            AppMethodBeat.o(143237);
            return;
          }
          ae.i(r.this.TAG, "try to expand action view, searchViewExpand %B", new Object[] { Boolean.valueOf(r.this.Lhf) });
          if (r.this.Lhe) {
            if (!r.this.Lhf) {
              r.this.rFH.expandActionView();
            }
          }
          for (;;)
          {
            final View localView = r.this.rFH.getActionView();
            if ((localView != null) && (r.this.Lhf))
            {
              localView.findViewById(2131299306).requestFocus();
              if (r.this.Lhi) {
                r.this.gKO.postDelayed(new Runnable()
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
            if (r.this.Lhr != null) {
              r.this.Lhr.fOW();
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
    ae.v(this.TAG, "on prepare options menu, searchViewExpand %B, triggerExpand %B, canExpand %B", new Object[] { Boolean.valueOf(this.Lhf), Boolean.valueOf(this.Lhg), Boolean.valueOf(this.Lhh) });
    if (paramActivity == null)
    {
      ae.w(this.TAG, "on hanle status fail, activity is null");
      AppMethodBeat.o(143248);
      return;
    }
    this.rFH = paramMenu.findItem(2131302248);
    if (this.rFH == null)
    {
      ae.w(this.TAG, "can not find search menu, error");
      AppMethodBeat.o(143248);
      return;
    }
    this.rFH.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
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
    ae.v(this.TAG, "on create options menu");
    if (paramFragmentActivity == null)
    {
      ae.w(this.TAG, "on add search menu, activity is null");
      AppMethodBeat.o(143247);
      return;
    }
    if (this.Lhj == null)
    {
      if (this.Lhm)
      {
        this.Lhj = new ActionBarSearchView(paramFragmentActivity);
        this.Lhj.setAutoMatchKeywords(this.Lho);
        this.Lhj.setKeywords(this.Lhn);
      }
    }
    else
    {
      this.Lhj.setCallBack(new ActionBarSearchView.b()
      {
        public final void aNW(String paramAnonymousString)
        {
          AppMethodBeat.i(143225);
          if (!r.this.Lhf)
          {
            ae.v(r.this.TAG, "onSearchTextChange %s, but not in searching", new Object[] { paramAnonymousString });
            AppMethodBeat.o(143225);
            return;
          }
          if (r.this.Lhk != null) {
            r.this.Lhk.JP(paramAnonymousString);
          }
          AppMethodBeat.o(143225);
        }
        
        public final void aSN()
        {
          AppMethodBeat.i(143226);
          if (r.this.Lhk != null) {
            r.this.Lhk.aSN();
          }
          AppMethodBeat.o(143226);
        }
        
        public final void fOA()
        {
          AppMethodBeat.i(143223);
          if (!r.this.Lhf)
          {
            ae.v(r.this.TAG, "onVoiceSearchRequired, but not in searching");
            AppMethodBeat.o(143223);
            return;
          }
          r.this.aOE();
          AppMethodBeat.o(143223);
        }
        
        public final void fOz()
        {
          AppMethodBeat.i(143224);
          if (r.this.Lhk != null) {
            r.this.Lhk.aSO();
          }
          AppMethodBeat.o(143224);
        }
      });
      this.Lhj.yM(aOD());
      this.Lhj.setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(143230);
          if ((3 == paramAnonymousInt) && (r.this.Lhk != null))
          {
            boolean bool = r.this.Lhk.JO(r.this.getSearchContent());
            AppMethodBeat.o(143230);
            return bool;
          }
          AppMethodBeat.o(143230);
          return false;
        }
      });
      if (this.Lhq != 0) {
        this.Lhj.setSearchTipIcon(this.Lhq);
      }
      this.rFH = paramMenu.add(0, 2131302248, 0, this.Lhp);
      this.rFH.setEnabled(this.Lhh);
      this.rFH.setIcon(ao.k(paramFragmentActivity, 2131689494, paramFragmentActivity.getResources().getColor(2131099732)));
      this.rFH.setActionView((View)this.Lhj);
      if (!this.Lhe) {
        break label322;
      }
      this.rFH.setShowAsAction(9);
      label246:
      if (!this.Lhe) {
        break label335;
      }
      h.a(this.rFH, new h.a()
      {
        public final boolean fu()
        {
          AppMethodBeat.i(143231);
          r.this.a(paramFragmentActivity, false, paramMenu);
          AppMethodBeat.o(143231);
          return true;
        }
        
        public final boolean fv()
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
      this.Lhj.setBackClickCallback(new ActionBarSearchView.a()
      {
        public final void fOy()
        {
          AppMethodBeat.i(143235);
          if (r.this.Lhe)
          {
            if (r.this.rFH != null)
            {
              r.this.rFH.collapseActionView();
              AppMethodBeat.o(143235);
            }
          }
          else if (r.this.Lhr != null) {
            r.this.Lhr.collapseActionView();
          }
          AppMethodBeat.o(143235);
        }
      });
      AppMethodBeat.o(143247);
      return;
      this.Lhj = new SearchViewNotRealTimeHelper(paramFragmentActivity);
      this.Lhj.setNotRealCallBack(this.Lhl);
      break;
      label322:
      this.rFH.setShowAsAction(2);
      break label246;
      label335:
      this.Lhr = new a()
      {
        public final void collapseActionView()
        {
          AppMethodBeat.i(143234);
          r.this.b(paramFragmentActivity, true, paramMenu);
          AppMethodBeat.o(143234);
        }
        
        public final void fOW()
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
    ae.d(this.TAG, "doNewExpand, searchViewExpand " + this.Lhf);
    if (!this.Lhf)
    {
      this.Lhf = true;
      b(paramFragmentActivity, paramMenu);
      this.gKO.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143239);
          if ((paramFragmentActivity == null) || (paramFragmentActivity.isFinishing()))
          {
            ae.w(r.this.TAG, "want to expand search view, but activity status error");
            AppMethodBeat.o(143239);
            return;
          }
          if (paramBoolean) {
            paramFragmentActivity.supportInvalidateOptionsMenu();
          }
          AppMethodBeat.o(143239);
        }
      });
      if (this.Lhk != null) {
        this.Lhk.aSM();
      }
    }
    AppMethodBeat.o(143255);
  }
  
  public final void a(b paramb)
  {
    this.Lhk = paramb;
  }
  
  protected boolean aOD()
  {
    return false;
  }
  
  protected void aOE() {}
  
  public final void b(final FragmentActivity paramFragmentActivity, final boolean paramBoolean, Menu paramMenu)
  {
    AppMethodBeat.i(143256);
    ae.d(this.TAG, "doNewCollapse, searchViewExpand " + this.Lhf);
    if (this.Lhf)
    {
      this.Lhf = false;
      c(paramMenu);
      if (this.Lhj != null) {
        this.Lhj.yN(false);
      }
      this.gKO.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143227);
          if ((paramFragmentActivity == null) || (paramFragmentActivity.isFinishing()))
          {
            ae.w(r.this.TAG, "want to collapse search view, but activity status error");
            AppMethodBeat.o(143227);
            return;
          }
          if (paramBoolean) {
            paramFragmentActivity.supportInvalidateOptionsMenu();
          }
          AppMethodBeat.o(143227);
        }
      });
      if (this.Lhk != null) {
        this.gKO.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(143228);
            if (r.this.Lhk != null) {
              r.this.Lhk.aSL();
            }
            AppMethodBeat.o(143228);
          }
        });
      }
    }
    this.gKO.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143229);
        if (r.this.rFH == null)
        {
          ae.w(r.this.TAG, "want to collapse search view, but search menu item is null");
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
        Object localObject1 = r.this.rFH.getActionView();
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
    if (this.Lhj != null) {
      this.Lhj.fOv();
    }
    AppMethodBeat.o(143245);
  }
  
  public final void fOV()
  {
    AppMethodBeat.i(143252);
    ae.d(this.TAG, "do collapse");
    if ((this.Lhf) && (this.rFH != null))
    {
      if (this.Lhe)
      {
        this.rFH.collapseActionView();
        AppMethodBeat.o(143252);
        return;
      }
      if (this.Lhr != null) {
        this.Lhr.collapseActionView();
      }
    }
    AppMethodBeat.o(143252);
  }
  
  public final boolean fOw()
  {
    AppMethodBeat.i(143253);
    if (this.Lhj != null)
    {
      boolean bool = this.Lhj.fOw();
      AppMethodBeat.o(143253);
      return bool;
    }
    AppMethodBeat.o(143253);
    return false;
  }
  
  public final boolean fOx()
  {
    AppMethodBeat.i(143254);
    if (this.Lhj != null)
    {
      boolean bool = this.Lhj.fOx();
      AppMethodBeat.o(143254);
      return bool;
    }
    AppMethodBeat.o(143254);
    return false;
  }
  
  public final String getSearchContent()
  {
    AppMethodBeat.i(143242);
    if (this.Lhj != null)
    {
      String str = this.Lhj.getSearchContent();
      AppMethodBeat.o(143242);
      return str;
    }
    AppMethodBeat.o(143242);
    return "";
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(143250);
    ae.v(this.TAG, "on key down, key code %d, expand %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.Lhf) });
    if ((4 == paramInt) && (this.Lhf))
    {
      fOV();
      AppMethodBeat.o(143250);
      return true;
    }
    AppMethodBeat.o(143250);
    return false;
  }
  
  public final void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(143244);
    if (this.Lhj == null)
    {
      AppMethodBeat.o(143244);
      return;
    }
    this.Lhj.setHint(paramCharSequence);
    AppMethodBeat.o(143244);
  }
  
  public void setSearchContent(String paramString)
  {
    AppMethodBeat.i(143243);
    if (this.Lhj == null)
    {
      AppMethodBeat.o(143243);
      return;
    }
    this.Lhj.setSearchContent(paramString);
    AppMethodBeat.o(143243);
  }
  
  public final void yP(boolean paramBoolean)
  {
    boolean bool1 = false;
    AppMethodBeat.i(143251);
    String str = this.TAG;
    boolean bool2 = this.Lhf;
    if (this.rFH == null) {
      bool1 = true;
    }
    ae.d(str, "do expand, expanded[%B], search menu item null[%B]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    if (this.Lhf)
    {
      AppMethodBeat.o(143251);
      return;
    }
    if (!this.Lhh)
    {
      ae.w(this.TAG, "can not expand now");
      AppMethodBeat.o(143251);
      return;
    }
    this.Lhi = paramBoolean;
    if (this.rFH != null)
    {
      this.gKO.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143238);
          if (r.this.rFH == null)
          {
            ae.w(r.this.TAG, "post do expand search menu, but search menu item is null");
            AppMethodBeat.o(143238);
            return;
          }
          if (r.this.Lhe)
          {
            r.this.rFH.expandActionView();
            AppMethodBeat.o(143238);
            return;
          }
          if (r.this.Lhr != null) {
            r.this.Lhr.fOW();
          }
          AppMethodBeat.o(143238);
        }
      });
      AppMethodBeat.o(143251);
      return;
    }
    this.Lhg = true;
    AppMethodBeat.o(143251);
  }
  
  public static abstract interface a
  {
    public abstract void collapseActionView();
    
    public abstract void fOW();
  }
  
  public static abstract interface b
  {
    public abstract boolean JO(String paramString);
    
    public abstract void JP(String paramString);
    
    public abstract void aSL();
    
    public abstract void aSM();
    
    public abstract void aSN();
    
    public abstract void aSO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.r
 * JD-Core Version:    0.7.0.1
 */