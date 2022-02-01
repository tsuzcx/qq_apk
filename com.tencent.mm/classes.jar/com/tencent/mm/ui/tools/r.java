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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;

public class r
{
  boolean KKK;
  public boolean KKL;
  private boolean KKM;
  private boolean KKN;
  boolean KKO;
  public d KKP;
  public b KKQ;
  private SearchViewNotRealTimeHelper.a KKR;
  private boolean KKS;
  private ArrayList<String> KKT;
  private boolean KKU;
  public int KKV;
  private int KKW;
  a KKX;
  final String TAG;
  ap gIf;
  MenuItem rxw;
  
  public r()
  {
    AppMethodBeat.i(143240);
    this.KKK = false;
    this.KKL = false;
    this.KKM = false;
    this.KKN = true;
    this.KKO = true;
    this.rxw = null;
    this.gIf = new ap(Looper.getMainLooper());
    this.KKP = null;
    this.KKS = true;
    this.KKV = 2131755726;
    this.KKW = 0;
    this.KKS = true;
    this.KKK = false;
    this.TAG = ("MicroMsg.SearchViewHelper-" + String.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(143240);
  }
  
  public r(byte paramByte)
  {
    AppMethodBeat.i(143241);
    this.KKK = false;
    this.KKL = false;
    this.KKM = false;
    this.KKN = true;
    this.KKO = true;
    this.rxw = null;
    this.gIf = new ap(Looper.getMainLooper());
    this.KKP = null;
    this.KKS = true;
    this.KKV = 2131755726;
    this.KKW = 0;
    this.KKS = true;
    this.KKK = true;
    this.TAG = ("MicroMsg.SearchViewHelper-" + String.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(143241);
  }
  
  private void b(final Activity paramActivity, Menu paramMenu)
  {
    AppMethodBeat.i(143249);
    if ((this.KKN) && ((this.KKL) || (this.KKM)))
    {
      this.KKM = false;
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
      this.gIf.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143237);
          if (r.this.rxw == null)
          {
            ad.w(r.this.TAG, "on post expand search menu, but item is null");
            AppMethodBeat.o(143237);
            return;
          }
          ad.i(r.this.TAG, "try to expand action view, searchViewExpand %B", new Object[] { Boolean.valueOf(r.this.KKL) });
          if (r.this.KKK) {
            if (!r.this.KKL) {
              r.this.rxw.expandActionView();
            }
          }
          for (;;)
          {
            final View localView = r.this.rxw.getActionView();
            if ((localView != null) && (r.this.KKL))
            {
              localView.findViewById(2131299306).requestFocus();
              if (r.this.KKO) {
                r.this.gIf.postDelayed(new Runnable()
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
            if (r.this.KKX != null) {
              r.this.KKX.fKF();
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
    ad.v(this.TAG, "on prepare options menu, searchViewExpand %B, triggerExpand %B, canExpand %B", new Object[] { Boolean.valueOf(this.KKL), Boolean.valueOf(this.KKM), Boolean.valueOf(this.KKN) });
    if (paramActivity == null)
    {
      ad.w(this.TAG, "on hanle status fail, activity is null");
      AppMethodBeat.o(143248);
      return;
    }
    this.rxw = paramMenu.findItem(2131302248);
    if (this.rxw == null)
    {
      ad.w(this.TAG, "can not find search menu, error");
      AppMethodBeat.o(143248);
      return;
    }
    this.rxw.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
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
    ad.v(this.TAG, "on create options menu");
    if (paramFragmentActivity == null)
    {
      ad.w(this.TAG, "on add search menu, activity is null");
      AppMethodBeat.o(143247);
      return;
    }
    if (this.KKP == null)
    {
      if (this.KKS)
      {
        this.KKP = new ActionBarSearchView(paramFragmentActivity);
        this.KKP.setAutoMatchKeywords(this.KKU);
        this.KKP.setKeywords(this.KKT);
      }
    }
    else
    {
      this.KKP.setCallBack(new ActionBarSearchView.b()
      {
        public final void aMA(String paramAnonymousString)
        {
          AppMethodBeat.i(143225);
          if (!r.this.KKL)
          {
            ad.v(r.this.TAG, "onSearchTextChange %s, but not in searching", new Object[] { paramAnonymousString });
            AppMethodBeat.o(143225);
            return;
          }
          if (r.this.KKQ != null) {
            r.this.KKQ.Jq(paramAnonymousString);
          }
          AppMethodBeat.o(143225);
        }
        
        public final void aSo()
        {
          AppMethodBeat.i(143226);
          if (r.this.KKQ != null) {
            r.this.KKQ.aSo();
          }
          AppMethodBeat.o(143226);
        }
        
        public final void fKi()
        {
          AppMethodBeat.i(143224);
          if (r.this.KKQ != null) {
            r.this.KKQ.aSp();
          }
          AppMethodBeat.o(143224);
        }
        
        public final void fKj()
        {
          AppMethodBeat.i(143223);
          if (!r.this.KKL)
          {
            ad.v(r.this.TAG, "onVoiceSearchRequired, but not in searching");
            AppMethodBeat.o(143223);
            return;
          }
          r.this.aOg();
          AppMethodBeat.o(143223);
        }
      });
      this.KKP.yz(aOf());
      this.KKP.setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(143230);
          if ((3 == paramAnonymousInt) && (r.this.KKQ != null))
          {
            boolean bool = r.this.KKQ.Jp(r.this.getSearchContent());
            AppMethodBeat.o(143230);
            return bool;
          }
          AppMethodBeat.o(143230);
          return false;
        }
      });
      if (this.KKW != 0) {
        this.KKP.setSearchTipIcon(this.KKW);
      }
      this.rxw = paramMenu.add(0, 2131302248, 0, this.KKV);
      this.rxw.setEnabled(this.KKN);
      this.rxw.setIcon(ao.k(paramFragmentActivity, 2131689494, paramFragmentActivity.getResources().getColor(2131099732)));
      this.rxw.setActionView((View)this.KKP);
      if (!this.KKK) {
        break label322;
      }
      this.rxw.setShowAsAction(9);
      label246:
      if (!this.KKK) {
        break label335;
      }
      h.a(this.rxw, new h.a()
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
      this.KKP.setBackClickCallback(new ActionBarSearchView.a()
      {
        public final void fKh()
        {
          AppMethodBeat.i(143235);
          if (r.this.KKK)
          {
            if (r.this.rxw != null)
            {
              r.this.rxw.collapseActionView();
              AppMethodBeat.o(143235);
            }
          }
          else if (r.this.KKX != null) {
            r.this.KKX.collapseActionView();
          }
          AppMethodBeat.o(143235);
        }
      });
      AppMethodBeat.o(143247);
      return;
      this.KKP = new SearchViewNotRealTimeHelper(paramFragmentActivity);
      this.KKP.setNotRealCallBack(this.KKR);
      break;
      label322:
      this.rxw.setShowAsAction(2);
      break label246;
      label335:
      this.KKX = new a()
      {
        public final void collapseActionView()
        {
          AppMethodBeat.i(143234);
          r.this.b(paramFragmentActivity, true, paramMenu);
          AppMethodBeat.o(143234);
        }
        
        public final void fKF()
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
    ad.d(this.TAG, "doNewExpand, searchViewExpand " + this.KKL);
    if (!this.KKL)
    {
      this.KKL = true;
      b(paramFragmentActivity, paramMenu);
      this.gIf.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143239);
          if ((paramFragmentActivity == null) || (paramFragmentActivity.isFinishing()))
          {
            ad.w(r.this.TAG, "want to expand search view, but activity status error");
            AppMethodBeat.o(143239);
            return;
          }
          if (paramBoolean) {
            paramFragmentActivity.supportInvalidateOptionsMenu();
          }
          AppMethodBeat.o(143239);
        }
      });
      if (this.KKQ != null) {
        this.KKQ.aSn();
      }
    }
    AppMethodBeat.o(143255);
  }
  
  public final void a(b paramb)
  {
    this.KKQ = paramb;
  }
  
  protected boolean aOf()
  {
    return false;
  }
  
  protected void aOg() {}
  
  public final void b(final FragmentActivity paramFragmentActivity, final boolean paramBoolean, Menu paramMenu)
  {
    AppMethodBeat.i(143256);
    ad.d(this.TAG, "doNewCollapse, searchViewExpand " + this.KKL);
    if (this.KKL)
    {
      this.KKL = false;
      c(paramMenu);
      if (this.KKP != null) {
        this.KKP.yA(false);
      }
      this.gIf.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143227);
          if ((paramFragmentActivity == null) || (paramFragmentActivity.isFinishing()))
          {
            ad.w(r.this.TAG, "want to collapse search view, but activity status error");
            AppMethodBeat.o(143227);
            return;
          }
          if (paramBoolean) {
            paramFragmentActivity.supportInvalidateOptionsMenu();
          }
          AppMethodBeat.o(143227);
        }
      });
      if (this.KKQ != null) {
        this.gIf.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(143228);
            if (r.this.KKQ != null) {
              r.this.KKQ.aSm();
            }
            AppMethodBeat.o(143228);
          }
        });
      }
    }
    this.gIf.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143229);
        if (r.this.rxw == null)
        {
          ad.w(r.this.TAG, "want to collapse search view, but search menu item is null");
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
        Object localObject1 = r.this.rxw.getActionView();
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
    if (this.KKP != null) {
      this.KKP.fKe();
    }
    AppMethodBeat.o(143245);
  }
  
  public final void fKE()
  {
    AppMethodBeat.i(143252);
    ad.d(this.TAG, "do collapse");
    if ((this.KKL) && (this.rxw != null))
    {
      if (this.KKK)
      {
        this.rxw.collapseActionView();
        AppMethodBeat.o(143252);
        return;
      }
      if (this.KKX != null) {
        this.KKX.collapseActionView();
      }
    }
    AppMethodBeat.o(143252);
  }
  
  public final boolean fKf()
  {
    AppMethodBeat.i(143253);
    if (this.KKP != null)
    {
      boolean bool = this.KKP.fKf();
      AppMethodBeat.o(143253);
      return bool;
    }
    AppMethodBeat.o(143253);
    return false;
  }
  
  public final boolean fKg()
  {
    AppMethodBeat.i(143254);
    if (this.KKP != null)
    {
      boolean bool = this.KKP.fKg();
      AppMethodBeat.o(143254);
      return bool;
    }
    AppMethodBeat.o(143254);
    return false;
  }
  
  public final String getSearchContent()
  {
    AppMethodBeat.i(143242);
    if (this.KKP != null)
    {
      String str = this.KKP.getSearchContent();
      AppMethodBeat.o(143242);
      return str;
    }
    AppMethodBeat.o(143242);
    return "";
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(143250);
    ad.v(this.TAG, "on key down, key code %d, expand %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.KKL) });
    if ((4 == paramInt) && (this.KKL))
    {
      fKE();
      AppMethodBeat.o(143250);
      return true;
    }
    AppMethodBeat.o(143250);
    return false;
  }
  
  public final void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(143244);
    if (this.KKP == null)
    {
      AppMethodBeat.o(143244);
      return;
    }
    this.KKP.setHint(paramCharSequence);
    AppMethodBeat.o(143244);
  }
  
  public void setSearchContent(String paramString)
  {
    AppMethodBeat.i(143243);
    if (this.KKP == null)
    {
      AppMethodBeat.o(143243);
      return;
    }
    this.KKP.setSearchContent(paramString);
    AppMethodBeat.o(143243);
  }
  
  public final void yC(boolean paramBoolean)
  {
    boolean bool1 = false;
    AppMethodBeat.i(143251);
    String str = this.TAG;
    boolean bool2 = this.KKL;
    if (this.rxw == null) {
      bool1 = true;
    }
    ad.d(str, "do expand, expanded[%B], search menu item null[%B]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    if (this.KKL)
    {
      AppMethodBeat.o(143251);
      return;
    }
    if (!this.KKN)
    {
      ad.w(this.TAG, "can not expand now");
      AppMethodBeat.o(143251);
      return;
    }
    this.KKO = paramBoolean;
    if (this.rxw != null)
    {
      this.gIf.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143238);
          if (r.this.rxw == null)
          {
            ad.w(r.this.TAG, "post do expand search menu, but search menu item is null");
            AppMethodBeat.o(143238);
            return;
          }
          if (r.this.KKK)
          {
            r.this.rxw.expandActionView();
            AppMethodBeat.o(143238);
            return;
          }
          if (r.this.KKX != null) {
            r.this.KKX.fKF();
          }
          AppMethodBeat.o(143238);
        }
      });
      AppMethodBeat.o(143251);
      return;
    }
    this.KKM = true;
    AppMethodBeat.o(143251);
  }
  
  public static abstract interface a
  {
    public abstract void collapseActionView();
    
    public abstract void fKF();
  }
  
  public static abstract interface b
  {
    public abstract boolean Jp(String paramString);
    
    public abstract void Jq(String paramString);
    
    public abstract void aSm();
    
    public abstract void aSn();
    
    public abstract void aSo();
    
    public abstract void aSp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.r
 * JD-Core Version:    0.7.0.1
 */