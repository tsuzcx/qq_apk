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
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.vendor.Huawei;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import java.util.ArrayList;

public class s
{
  boolean Qwc;
  public boolean Qwd;
  private boolean Qwe;
  private boolean Qwf;
  private boolean Qwg;
  public d Qwh;
  public b Qwi;
  private SearchViewNotRealTimeHelper.a Qwj;
  private boolean Qwk;
  private ArrayList<String> Qwl;
  private boolean Qwm;
  public int Qwn;
  private int Qwo;
  a Qwp;
  final String TAG;
  MMHandler hAk;
  MenuItem tfn;
  
  public s()
  {
    AppMethodBeat.i(143240);
    this.Qwc = false;
    this.Qwd = false;
    this.Qwe = false;
    this.Qwf = true;
    this.Qwg = true;
    this.tfn = null;
    this.hAk = new MMHandler(Looper.getMainLooper());
    this.Qwh = null;
    this.Qwk = true;
    this.Qwn = 2131755797;
    this.Qwo = 0;
    this.Qwk = true;
    this.Qwc = false;
    this.TAG = ("MicroMsg.SearchViewHelper-" + String.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(143240);
  }
  
  public s(byte paramByte)
  {
    AppMethodBeat.i(143241);
    this.Qwc = false;
    this.Qwd = false;
    this.Qwe = false;
    this.Qwf = true;
    this.Qwg = true;
    this.tfn = null;
    this.hAk = new MMHandler(Looper.getMainLooper());
    this.Qwh = null;
    this.Qwk = true;
    this.Qwn = 2131755797;
    this.Qwo = 0;
    this.Qwk = true;
    this.Qwc = true;
    this.TAG = ("MicroMsg.SearchViewHelper-" + String.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(143241);
  }
  
  private void b(final Activity paramActivity, Menu paramMenu)
  {
    AppMethodBeat.i(143249);
    if ((this.Qwf) && ((this.Qwd) || (this.Qwe)))
    {
      this.Qwe = false;
      if ((paramActivity instanceof MMActivity)) {
        ((MMActivity)paramActivity).setActionbarColor(paramActivity.getResources().getColor(2131099648));
      }
      if (paramMenu != null)
      {
        int i = 0;
        while (i < paramMenu.size())
        {
          MenuItem localMenuItem = paramMenu.getItem(i);
          if (localMenuItem.getItemId() != 2131304628) {
            localMenuItem.setVisible(false);
          }
          i += 1;
        }
      }
      this.hAk.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143237);
          if (s.this.tfn == null)
          {
            Log.w(s.this.TAG, "on post expand search menu, but item is null");
            AppMethodBeat.o(143237);
            return;
          }
          Log.i(s.this.TAG, "try to expand action view, searchViewExpand %B", new Object[] { Boolean.valueOf(s.this.Qwd) });
          if (s.this.Qwc) {
            if (!s.this.Qwd) {
              s.this.tfn.expandActionView();
            }
          }
          for (;;)
          {
            final View localView = s.this.tfn.getActionView();
            if ((localView != null) && (s.this.Qwd))
            {
              localView.findViewById(2131299910).requestFocus();
              if (s.this.gXO()) {
                s.this.hAk.postDelayed(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(143236);
                    ((InputMethodManager)s.10.this.val$activity.getSystemService("input_method")).showSoftInput(localView.findViewById(2131299910), 0);
                    AppMethodBeat.o(143236);
                  }
                }, 128L);
              }
            }
            AppMethodBeat.o(143237);
            return;
            if (s.this.Qwp != null) {
              s.this.Qwp.gXQ();
            }
          }
        }
      }, 128L);
    }
    AppMethodBeat.o(143249);
  }
  
  public final void CK(boolean paramBoolean)
  {
    boolean bool1 = false;
    AppMethodBeat.i(143251);
    String str = this.TAG;
    boolean bool2 = this.Qwd;
    if (this.tfn == null) {
      bool1 = true;
    }
    Log.d(str, "do expand, expanded[%B], search menu item null[%B]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    if (this.Qwd)
    {
      AppMethodBeat.o(143251);
      return;
    }
    if (!this.Qwf)
    {
      Log.w(this.TAG, "can not expand now");
      AppMethodBeat.o(143251);
      return;
    }
    this.Qwg = paramBoolean;
    if (this.tfn != null)
    {
      this.hAk.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143238);
          if (s.this.tfn == null)
          {
            Log.w(s.this.TAG, "post do expand search menu, but search menu item is null");
            AppMethodBeat.o(143238);
            return;
          }
          if (s.this.Qwc)
          {
            s.this.tfn.expandActionView();
            AppMethodBeat.o(143238);
            return;
          }
          if (s.this.Qwp != null) {
            s.this.Qwp.gXQ();
          }
          AppMethodBeat.o(143238);
        }
      });
      AppMethodBeat.o(143251);
      return;
    }
    this.Qwe = true;
    AppMethodBeat.o(143251);
  }
  
  public void a(Activity paramActivity, Menu paramMenu)
  {
    AppMethodBeat.i(143248);
    Log.v(this.TAG, "on prepare options menu, searchViewExpand %B, triggerExpand %B, canExpand %B", new Object[] { Boolean.valueOf(this.Qwd), Boolean.valueOf(this.Qwe), Boolean.valueOf(this.Qwf) });
    if (paramActivity == null)
    {
      Log.w(this.TAG, "on hanle status fail, activity is null");
      AppMethodBeat.o(143248);
      return;
    }
    this.tfn = paramMenu.findItem(2131304628);
    if (this.tfn == null)
    {
      Log.w(this.TAG, "can not find search menu, error");
      AppMethodBeat.o(143248);
      return;
    }
    this.tfn.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
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
    Log.v(this.TAG, "on create options menu");
    if (paramFragmentActivity == null)
    {
      Log.w(this.TAG, "on add search menu, activity is null");
      AppMethodBeat.o(143247);
      return;
    }
    if (this.Qwh == null)
    {
      if (this.Qwk)
      {
        this.Qwh = new ActionBarSearchView(paramFragmentActivity);
        this.Qwh.setAutoMatchKeywords(this.Qwm);
        this.Qwh.setKeywords(this.Qwl);
      }
    }
    else
    {
      this.Qwh.setCallBack(new ActionBarSearchView.b()
      {
        public final void bey(String paramAnonymousString)
        {
          AppMethodBeat.i(143225);
          if (!s.this.Qwd)
          {
            Log.v(s.this.TAG, "onSearchTextChange %s, but not in searching", new Object[] { paramAnonymousString });
            AppMethodBeat.o(143225);
            return;
          }
          if (s.this.Qwi != null) {
            s.this.Qwi.SO(paramAnonymousString);
          }
          AppMethodBeat.o(143225);
        }
        
        public final void bnA()
        {
          AppMethodBeat.i(143226);
          if (s.this.Qwi != null) {
            s.this.Qwi.bnA();
          }
          AppMethodBeat.o(143226);
        }
        
        public final void gXs()
        {
          AppMethodBeat.i(143224);
          if (s.this.Qwi != null) {
            s.this.Qwi.bnB();
          }
          AppMethodBeat.o(143224);
        }
        
        public final void gXt()
        {
          AppMethodBeat.i(143223);
          if (!s.this.Qwd)
          {
            Log.v(s.this.TAG, "onVoiceSearchRequired, but not in searching");
            AppMethodBeat.o(143223);
            return;
          }
          s.this.biL();
          AppMethodBeat.o(143223);
        }
      });
      this.Qwh.CG(biK());
      this.Qwh.setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(143230);
          if ((3 == paramAnonymousInt) && (s.this.Qwi != null))
          {
            boolean bool = s.this.Qwi.SN(s.this.getSearchContent());
            AppMethodBeat.o(143230);
            return bool;
          }
          AppMethodBeat.o(143230);
          return false;
        }
      });
      if (this.Qwo != 0) {
        this.Qwh.setSearchTipIcon(this.Qwo);
      }
      this.tfn = paramMenu.add(0, 2131304628, 0, this.Qwn);
      this.tfn.setEnabled(this.Qwf);
      this.tfn.setIcon(ar.m(paramFragmentActivity, 2131689496, paramFragmentActivity.getResources().getColor(2131099746)));
      this.tfn.setActionView((View)this.Qwh);
      if (!this.Qwc) {
        break label322;
      }
      this.tfn.setShowAsAction(9);
      label246:
      if (!this.Qwc) {
        break label335;
      }
      h.a(this.tfn, new h.a()
      {
        public final boolean fA()
        {
          AppMethodBeat.i(143231);
          s.this.a(paramFragmentActivity, false, paramMenu);
          AppMethodBeat.o(143231);
          return true;
        }
        
        public final boolean fB()
        {
          AppMethodBeat.i(143232);
          s.this.b(paramFragmentActivity, false, paramMenu);
          AppMethodBeat.o(143232);
          return true;
        }
      });
    }
    for (;;)
    {
      this.Qwh.setBackClickCallback(new ActionBarSearchView.a()
      {
        public final void gXr()
        {
          AppMethodBeat.i(143235);
          if ((!s.this.Qwc) || (s.this.tfn != null)) {}
          try
          {
            if ((Huawei.ifHUAWEI()) && (ao.gJN()))
            {
              ViewGroup localViewGroup = (ViewGroup)s.this.tfn.getActionView().getParent();
              if (localViewGroup != null) {
                localViewGroup.removeView(localViewGroup.findViewById(2131299380));
              }
            }
          }
          catch (Exception localException)
          {
            label70:
            break label70;
          }
          s.this.tfn.collapseActionView();
          AppMethodBeat.o(143235);
          return;
          if (s.this.Qwp != null) {
            s.this.Qwp.collapseActionView();
          }
          AppMethodBeat.o(143235);
        }
      });
      AppMethodBeat.o(143247);
      return;
      this.Qwh = new SearchViewNotRealTimeHelper(paramFragmentActivity);
      this.Qwh.setNotRealCallBack(this.Qwj);
      break;
      label322:
      this.tfn.setShowAsAction(2);
      break label246;
      label335:
      this.Qwp = new a()
      {
        public final void collapseActionView()
        {
          AppMethodBeat.i(143234);
          s.this.b(paramFragmentActivity, true, paramMenu);
          AppMethodBeat.o(143234);
        }
        
        public final void gXQ()
        {
          AppMethodBeat.i(143233);
          s.this.a(paramFragmentActivity, true, paramMenu);
          AppMethodBeat.o(143233);
        }
      };
    }
  }
  
  public final void a(final FragmentActivity paramFragmentActivity, final boolean paramBoolean, Menu paramMenu)
  {
    AppMethodBeat.i(143255);
    Log.d(this.TAG, "doNewExpand, searchViewExpand " + this.Qwd);
    if (!this.Qwd)
    {
      this.Qwd = true;
      b(paramFragmentActivity, paramMenu);
      this.hAk.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143239);
          if ((paramFragmentActivity == null) || (paramFragmentActivity.isFinishing()))
          {
            Log.w(s.this.TAG, "want to expand search view, but activity status error");
            AppMethodBeat.o(143239);
            return;
          }
          if (paramBoolean) {
            paramFragmentActivity.supportInvalidateOptionsMenu();
          }
          AppMethodBeat.o(143239);
        }
      });
      if (this.Qwi != null) {
        this.Qwi.bnz();
      }
    }
    AppMethodBeat.o(143255);
  }
  
  public final void a(b paramb)
  {
    this.Qwi = paramb;
  }
  
  public final void b(final FragmentActivity paramFragmentActivity, final boolean paramBoolean, Menu paramMenu)
  {
    AppMethodBeat.i(143256);
    Log.d(this.TAG, "doNewCollapse, searchViewExpand " + this.Qwd);
    if (this.Qwd) {
      this.Qwd = false;
    }
    try
    {
      if ((Huawei.ifHUAWEI()) && (ao.gJN()) && (this.tfn != null))
      {
        ViewGroup localViewGroup = (ViewGroup)this.tfn.getActionView().getParent();
        if (localViewGroup != null) {
          localViewGroup.removeView(localViewGroup.findViewById(2131299380));
        }
      }
    }
    catch (Exception localException)
    {
      label99:
      break label99;
    }
    c(paramMenu);
    if (this.Qwh != null) {
      this.Qwh.CH(false);
    }
    this.hAk.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143227);
        if ((paramFragmentActivity == null) || (paramFragmentActivity.isFinishing()))
        {
          Log.w(s.this.TAG, "want to collapse search view, but activity status error");
          AppMethodBeat.o(143227);
          return;
        }
        if (paramBoolean) {
          paramFragmentActivity.supportInvalidateOptionsMenu();
        }
        AppMethodBeat.o(143227);
      }
    });
    if (this.Qwi != null) {
      this.hAk.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143228);
          if (s.this.Qwi != null) {
            s.this.Qwi.bny();
          }
          AppMethodBeat.o(143228);
        }
      });
    }
    this.hAk.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143229);
        if (s.this.tfn == null)
        {
          Log.w(s.this.TAG, "want to collapse search view, but search menu item is null");
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
        Object localObject1 = s.this.tfn.getActionView();
        if (localObject1 != null)
        {
          localObject1 = ((View)localObject1).findViewById(2131299910);
          if (localObject1 != null) {
            ((View)localObject1).clearFocus();
          }
        }
        AppMethodBeat.o(143229);
      }
    });
    AppMethodBeat.o(143256);
  }
  
  protected boolean biK()
  {
    return false;
  }
  
  protected void biL() {}
  
  protected void c(Menu paramMenu)
  {
    AppMethodBeat.i(143246);
    if (paramMenu != null)
    {
      int i = 0;
      while (i < paramMenu.size())
      {
        MenuItem localMenuItem = paramMenu.getItem(i);
        if (localMenuItem.getItemId() != 2131304628) {
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
    if (this.Qwh != null) {
      this.Qwh.gXo();
    }
    AppMethodBeat.o(143245);
  }
  
  protected boolean gXO()
  {
    return this.Qwg;
  }
  
  public final void gXP()
  {
    AppMethodBeat.i(143252);
    Log.d(this.TAG, "do collapse");
    if ((!this.Qwd) || (this.tfn == null) || (this.Qwc)) {}
    try
    {
      ViewGroup localViewGroup = (ViewGroup)this.tfn.getActionView().getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(localViewGroup.findViewById(2131299380));
      }
    }
    catch (Exception localException)
    {
      label68:
      break label68;
    }
    this.tfn.collapseActionView();
    AppMethodBeat.o(143252);
    return;
    if (this.Qwp != null) {
      this.Qwp.collapseActionView();
    }
    AppMethodBeat.o(143252);
  }
  
  public final boolean gXp()
  {
    AppMethodBeat.i(143253);
    if (this.Qwh != null)
    {
      boolean bool = this.Qwh.gXp();
      AppMethodBeat.o(143253);
      return bool;
    }
    AppMethodBeat.o(143253);
    return false;
  }
  
  public final boolean gXq()
  {
    AppMethodBeat.i(143254);
    if (this.Qwh != null)
    {
      boolean bool = this.Qwh.gXq();
      AppMethodBeat.o(143254);
      return bool;
    }
    AppMethodBeat.o(143254);
    return false;
  }
  
  public final String getSearchContent()
  {
    AppMethodBeat.i(143242);
    if (this.Qwh != null)
    {
      String str = this.Qwh.getSearchContent();
      AppMethodBeat.o(143242);
      return str;
    }
    AppMethodBeat.o(143242);
    return "";
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(143250);
    Log.v(this.TAG, "on key down, key code %d, expand %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.Qwd) });
    if ((4 == paramInt) && (this.Qwd))
    {
      gXP();
      AppMethodBeat.o(143250);
      return true;
    }
    AppMethodBeat.o(143250);
    return false;
  }
  
  public final void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(143244);
    if (this.Qwh == null)
    {
      AppMethodBeat.o(143244);
      return;
    }
    this.Qwh.setHint(paramCharSequence);
    AppMethodBeat.o(143244);
  }
  
  public void setSearchContent(String paramString)
  {
    AppMethodBeat.i(143243);
    if (this.Qwh == null)
    {
      AppMethodBeat.o(143243);
      return;
    }
    this.Qwh.setSearchContent(paramString);
    AppMethodBeat.o(143243);
  }
  
  public static abstract interface a
  {
    public abstract void collapseActionView();
    
    public abstract void gXQ();
  }
  
  public static abstract interface b
  {
    public abstract boolean SN(String paramString);
    
    public abstract void SO(String paramString);
    
    public abstract void bnA();
    
    public abstract void bnB();
    
    public abstract void bny();
    
    public abstract void bnz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.s
 * JD-Core Version:    0.7.0.1
 */