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
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;

public class r
{
  boolean Htj;
  public boolean Htk;
  private boolean Htl;
  private boolean Htm;
  boolean Htn;
  public d Hto;
  public b Htp;
  private SearchViewNotRealTimeHelper.a Htq;
  private boolean Htr;
  private ArrayList<String> Hts;
  private boolean Htt;
  public int Htu;
  private int Htv;
  a Htw;
  final String TAG;
  ap gAC;
  MenuItem qeS;
  
  public r()
  {
    AppMethodBeat.i(143240);
    this.Htj = false;
    this.Htk = false;
    this.Htl = false;
    this.Htm = true;
    this.Htn = true;
    this.qeS = null;
    this.gAC = new ap(Looper.getMainLooper());
    this.Hto = null;
    this.Htr = true;
    this.Htu = 2131755726;
    this.Htv = 0;
    this.Htr = true;
    this.Htj = false;
    this.TAG = ("MicroMsg.SearchViewHelper-" + String.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(143240);
  }
  
  public r(byte paramByte)
  {
    AppMethodBeat.i(143241);
    this.Htj = false;
    this.Htk = false;
    this.Htl = false;
    this.Htm = true;
    this.Htn = true;
    this.qeS = null;
    this.gAC = new ap(Looper.getMainLooper());
    this.Hto = null;
    this.Htr = true;
    this.Htu = 2131755726;
    this.Htv = 0;
    this.Htr = true;
    this.Htj = true;
    this.TAG = ("MicroMsg.SearchViewHelper-" + String.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(143241);
  }
  
  private void b(final Activity paramActivity, Menu paramMenu)
  {
    AppMethodBeat.i(143249);
    if ((this.Htm) && ((this.Htk) || (this.Htl)))
    {
      this.Htl = false;
      if ((paramActivity instanceof MMActivity)) {
        ((MMActivity)paramActivity).setActionbarColor(ao.aD(paramActivity, 2130968577));
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
      this.gAC.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143237);
          if (r.this.qeS == null)
          {
            ad.w(r.this.TAG, "on post expand search menu, but item is null");
            AppMethodBeat.o(143237);
            return;
          }
          ad.i(r.this.TAG, "try to expand action view, searchViewExpand %B", new Object[] { Boolean.valueOf(r.this.Htk) });
          if (r.this.Htj) {
            if (!r.this.Htk) {
              r.this.qeS.expandActionView();
            }
          }
          for (;;)
          {
            final View localView = r.this.qeS.getActionView();
            if ((localView != null) && (r.this.Htk))
            {
              localView.findViewById(2131299306).requestFocus();
              if (r.this.Htn) {
                r.this.gAC.postDelayed(new Runnable()
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
            if (r.this.Htw != null) {
              r.this.Htw.fdX();
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
    ad.v(this.TAG, "on prepare options menu, searchViewExpand %B, triggerExpand %B, canExpand %B", new Object[] { Boolean.valueOf(this.Htk), Boolean.valueOf(this.Htl), Boolean.valueOf(this.Htm) });
    if (paramActivity == null)
    {
      ad.w(this.TAG, "on hanle status fail, activity is null");
      AppMethodBeat.o(143248);
      return;
    }
    this.qeS = paramMenu.findItem(2131302248);
    if (this.qeS == null)
    {
      ad.w(this.TAG, "can not find search menu, error");
      AppMethodBeat.o(143248);
      return;
    }
    this.qeS.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
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
    if (this.Hto == null)
    {
      if (this.Htr)
      {
        this.Hto = new ActionBarSearchView(paramFragmentActivity);
        this.Hto.setAutoMatchKeywords(this.Htt);
        this.Hto.setKeywords(this.Hts);
      }
    }
    else
    {
      this.Hto.setCallBack(new ActionBarSearchView.b()
      {
        public final void aBF(String paramAnonymousString)
        {
          AppMethodBeat.i(143225);
          if (!r.this.Htk)
          {
            ad.v(r.this.TAG, "onSearchTextChange %s, but not in searching", new Object[] { paramAnonymousString });
            AppMethodBeat.o(143225);
            return;
          }
          if (r.this.Htp != null) {
            r.this.Htp.BY(paramAnonymousString);
          }
          AppMethodBeat.o(143225);
        }
        
        public final void aIl()
        {
          AppMethodBeat.i(143226);
          if (r.this.Htp != null) {
            r.this.Htp.aIl();
          }
          AppMethodBeat.o(143226);
        }
        
        public final void fdA()
        {
          AppMethodBeat.i(143223);
          if (!r.this.Htk)
          {
            ad.v(r.this.TAG, "onVoiceSearchRequired, but not in searching");
            AppMethodBeat.o(143223);
            return;
          }
          r.this.aEg();
          AppMethodBeat.o(143223);
        }
        
        public final void fdz()
        {
          AppMethodBeat.i(143224);
          if (r.this.Htp != null) {
            r.this.Htp.aIm();
          }
          AppMethodBeat.o(143224);
        }
      });
      this.Hto.wE(aEf());
      this.Hto.setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(143230);
          if ((3 == paramAnonymousInt) && (r.this.Htp != null))
          {
            boolean bool = r.this.Htp.BX(r.this.getSearchContent());
            AppMethodBeat.o(143230);
            return bool;
          }
          AppMethodBeat.o(143230);
          return false;
        }
      });
      if (this.Htv != 0) {
        this.Hto.setSearchTipIcon(this.Htv);
      }
      this.qeS = paramMenu.add(0, 2131302248, 0, this.Htu);
      this.qeS.setEnabled(this.Htm);
      this.qeS.setIcon(am.i(paramFragmentActivity, 2131689494, paramFragmentActivity.getResources().getColor(2131099732)));
      this.qeS.setActionView((View)this.Hto);
      if (!this.Htj) {
        break label322;
      }
      this.qeS.setShowAsAction(9);
      label246:
      if (!this.Htj) {
        break label335;
      }
      h.a(this.qeS, new h.a()
      {
        public final boolean eV()
        {
          AppMethodBeat.i(143231);
          r.this.a(paramFragmentActivity, false, paramMenu);
          AppMethodBeat.o(143231);
          return true;
        }
        
        public final boolean eW()
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
      this.Hto.setBackClickCallback(new ActionBarSearchView.a()
      {
        public final void fdy()
        {
          AppMethodBeat.i(143235);
          if (r.this.Htj)
          {
            if (r.this.qeS != null)
            {
              r.this.qeS.collapseActionView();
              AppMethodBeat.o(143235);
            }
          }
          else if (r.this.Htw != null) {
            r.this.Htw.collapseActionView();
          }
          AppMethodBeat.o(143235);
        }
      });
      AppMethodBeat.o(143247);
      return;
      this.Hto = new SearchViewNotRealTimeHelper(paramFragmentActivity);
      this.Hto.setNotRealCallBack(this.Htq);
      break;
      label322:
      this.qeS.setShowAsAction(2);
      break label246;
      label335:
      this.Htw = new a()
      {
        public final void collapseActionView()
        {
          AppMethodBeat.i(143234);
          r.this.b(paramFragmentActivity, true, paramMenu);
          AppMethodBeat.o(143234);
        }
        
        public final void fdX()
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
    ad.d(this.TAG, "doNewExpand, searchViewExpand " + this.Htk);
    if (!this.Htk)
    {
      this.Htk = true;
      b(paramFragmentActivity, paramMenu);
      this.gAC.post(new Runnable()
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
      if (this.Htp != null) {
        this.Htp.aIk();
      }
    }
    AppMethodBeat.o(143255);
  }
  
  protected boolean aEf()
  {
    return false;
  }
  
  protected void aEg() {}
  
  public final void b(final FragmentActivity paramFragmentActivity, final boolean paramBoolean, Menu paramMenu)
  {
    AppMethodBeat.i(143256);
    ad.d(this.TAG, "doNewCollapse, searchViewExpand " + this.Htk);
    if (this.Htk)
    {
      this.Htk = false;
      c(paramMenu);
      if (this.Hto != null) {
        this.Hto.wF(false);
      }
      this.gAC.post(new Runnable()
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
      if (this.Htp != null) {
        this.gAC.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(143228);
            if (r.this.Htp != null) {
              r.this.Htp.aIj();
            }
            AppMethodBeat.o(143228);
          }
        });
      }
    }
    this.gAC.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143229);
        if (r.this.qeS == null)
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
        Object localObject1 = r.this.qeS.getActionView();
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
    if (this.Hto != null) {
      this.Hto.fdv();
    }
    AppMethodBeat.o(143245);
  }
  
  public final void fdW()
  {
    AppMethodBeat.i(143252);
    ad.d(this.TAG, "do collapse");
    if ((this.Htk) && (this.qeS != null))
    {
      if (this.Htj)
      {
        this.qeS.collapseActionView();
        AppMethodBeat.o(143252);
        return;
      }
      if (this.Htw != null) {
        this.Htw.collapseActionView();
      }
    }
    AppMethodBeat.o(143252);
  }
  
  public final boolean fdw()
  {
    AppMethodBeat.i(143253);
    if (this.Hto != null)
    {
      boolean bool = this.Hto.fdw();
      AppMethodBeat.o(143253);
      return bool;
    }
    AppMethodBeat.o(143253);
    return false;
  }
  
  public final boolean fdx()
  {
    AppMethodBeat.i(143254);
    if (this.Hto != null)
    {
      boolean bool = this.Hto.fdx();
      AppMethodBeat.o(143254);
      return bool;
    }
    AppMethodBeat.o(143254);
    return false;
  }
  
  public final String getSearchContent()
  {
    AppMethodBeat.i(143242);
    if (this.Hto != null)
    {
      String str = this.Hto.getSearchContent();
      AppMethodBeat.o(143242);
      return str;
    }
    AppMethodBeat.o(143242);
    return "";
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(143250);
    ad.v(this.TAG, "on key down, key code %d, expand %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.Htk) });
    if ((4 == paramInt) && (this.Htk))
    {
      fdW();
      AppMethodBeat.o(143250);
      return true;
    }
    AppMethodBeat.o(143250);
    return false;
  }
  
  public final void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(143244);
    if (this.Hto == null)
    {
      AppMethodBeat.o(143244);
      return;
    }
    this.Hto.setHint(paramCharSequence);
    AppMethodBeat.o(143244);
  }
  
  public void setSearchContent(String paramString)
  {
    AppMethodBeat.i(143243);
    if (this.Hto == null)
    {
      AppMethodBeat.o(143243);
      return;
    }
    this.Hto.setSearchContent(paramString);
    AppMethodBeat.o(143243);
  }
  
  public final void wH(boolean paramBoolean)
  {
    boolean bool1 = false;
    AppMethodBeat.i(143251);
    String str = this.TAG;
    boolean bool2 = this.Htk;
    if (this.qeS == null) {
      bool1 = true;
    }
    ad.d(str, "do expand, expanded[%B], search menu item null[%B]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    if (this.Htk)
    {
      AppMethodBeat.o(143251);
      return;
    }
    if (!this.Htm)
    {
      ad.w(this.TAG, "can not expand now");
      AppMethodBeat.o(143251);
      return;
    }
    this.Htn = paramBoolean;
    if (this.qeS != null)
    {
      this.gAC.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143238);
          if (r.this.qeS == null)
          {
            ad.w(r.this.TAG, "post do expand search menu, but search menu item is null");
            AppMethodBeat.o(143238);
            return;
          }
          if (r.this.Htj)
          {
            r.this.qeS.expandActionView();
            AppMethodBeat.o(143238);
            return;
          }
          if (r.this.Htw != null) {
            r.this.Htw.fdX();
          }
          AppMethodBeat.o(143238);
        }
      });
      AppMethodBeat.o(143251);
      return;
    }
    this.Htl = true;
    AppMethodBeat.o(143251);
  }
  
  public static abstract interface a
  {
    public abstract void collapseActionView();
    
    public abstract void fdX();
  }
  
  public static abstract interface b
  {
    public abstract boolean BX(String paramString);
    
    public abstract void BY(String paramString);
    
    public abstract void aIj();
    
    public abstract void aIk();
    
    public abstract void aIl();
    
    public abstract void aIm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.r
 * JD-Core Version:    0.7.0.1
 */