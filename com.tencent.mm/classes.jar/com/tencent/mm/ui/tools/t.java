package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.j;
import com.tencent.mm.ah.a.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.vendor.Huawei;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.w;
import java.util.ArrayList;

public class t
{
  private final String TAG;
  public boolean XUf;
  public boolean XUg;
  private boolean XUh;
  private boolean XUi;
  private boolean XUj;
  public e XUk;
  public b XUl;
  private SearchViewNotRealTimeHelper.a XUm;
  private boolean XUn;
  private ArrayList<String> XUo;
  private boolean XUp;
  public int XUq;
  private int XUr;
  public boolean XUs;
  private boolean XUt;
  public w XUu;
  public a XUv;
  private MMHandler knk;
  private MenuItem wLB;
  public boolean xUe;
  
  public t()
  {
    AppMethodBeat.i(143240);
    this.XUf = false;
    this.XUg = false;
    this.XUh = false;
    this.XUi = true;
    this.XUj = true;
    this.wLB = null;
    this.knk = new MMHandler(Looper.getMainLooper());
    this.XUk = null;
    this.XUn = true;
    this.XUq = a.k.app_empty_string;
    this.XUr = 0;
    this.xUe = false;
    this.XUs = false;
    this.XUt = true;
    this.XUn = true;
    this.XUf = false;
    this.TAG = ("MicroMsg.SearchViewHelper-" + String.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(143240);
  }
  
  public t(byte paramByte)
  {
    AppMethodBeat.i(143241);
    this.XUf = false;
    this.XUg = false;
    this.XUh = false;
    this.XUi = true;
    this.XUj = true;
    this.wLB = null;
    this.knk = new MMHandler(Looper.getMainLooper());
    this.XUk = null;
    this.XUn = true;
    this.XUq = a.k.app_empty_string;
    this.XUr = 0;
    this.xUe = false;
    this.XUs = false;
    this.XUt = true;
    this.XUn = true;
    this.XUf = true;
    this.TAG = ("MicroMsg.SearchViewHelper-" + String.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(143241);
  }
  
  private void b(final Activity paramActivity, Menu paramMenu)
  {
    AppMethodBeat.i(143249);
    if ((this.XUi) && ((this.XUg) || (this.XUh)))
    {
      this.XUh = false;
      if ((paramActivity instanceof MMActivity))
      {
        if (!this.xUe) {
          break label116;
        }
        ((MMActivity)paramActivity).setActionbarColor(paramActivity.getResources().getColor(a.d.Dark_0));
      }
      while (paramMenu != null)
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
        label116:
        ((MMActivity)paramActivity).setActionbarColor(paramActivity.getResources().getColor(a.d.BG_0));
      }
      this.knk.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143237);
          if (t.e(t.this) == null)
          {
            Log.w(t.b(t.this), "on post expand search menu, but item is null");
            AppMethodBeat.o(143237);
            return;
          }
          Log.i(t.b(t.this), "try to expand action view, searchViewExpand %B", new Object[] { Boolean.valueOf(t.a(t.this)) });
          if (t.d(t.this)) {
            if (t.f(t.this) != null) {
              t.f(t.this).hYB();
            }
          }
          for (;;)
          {
            final View localView = t.e(t.this).getActionView();
            if ((localView != null) && (t.a(t.this)))
            {
              localView.findViewById(a.g.edittext).requestFocus();
              if (t.this.hYA()) {
                t.g(t.this).postDelayed(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(143236);
                    ((InputMethodManager)t.10.this.val$activity.getSystemService("input_method")).showSoftInput(localView.findViewById(a.g.edittext), 0);
                    AppMethodBeat.o(143236);
                  }
                }, 128L);
              }
            }
            AppMethodBeat.o(143237);
            return;
            if (t.f(t.this) != null) {
              t.f(t.this).hYB();
            }
          }
        }
      }, 128L);
    }
    AppMethodBeat.o(143249);
  }
  
  public final void He(boolean paramBoolean)
  {
    boolean bool1 = false;
    AppMethodBeat.i(143251);
    String str = this.TAG;
    boolean bool2 = this.XUg;
    if (this.wLB == null) {
      bool1 = true;
    }
    Log.d(str, "do expand, expanded[%B], search menu item null[%B]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    if (this.XUg)
    {
      AppMethodBeat.o(143251);
      return;
    }
    if (!this.XUi)
    {
      Log.w(this.TAG, "can not expand now");
      AppMethodBeat.o(143251);
      return;
    }
    this.XUj = paramBoolean;
    if (this.wLB != null)
    {
      this.knk.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143238);
          if (t.e(t.this) == null)
          {
            Log.w(t.b(t.this), "post do expand search menu, but search menu item is null");
            AppMethodBeat.o(143238);
            return;
          }
          if (t.d(t.this))
          {
            if (t.f(t.this) != null)
            {
              t.f(t.this).hYB();
              AppMethodBeat.o(143238);
            }
          }
          else if (t.f(t.this) != null) {
            t.f(t.this).hYB();
          }
          AppMethodBeat.o(143238);
        }
      });
      AppMethodBeat.o(143251);
      return;
    }
    this.XUh = true;
    AppMethodBeat.o(143251);
  }
  
  public final Menu a(Menu paramMenu, Activity paramActivity)
  {
    AppMethodBeat.i(199911);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!(paramMenu instanceof o))
    {
      if (this.XUu != null)
      {
        Log.i(this.TAG, "getCurrentMenu, mActivityController.");
        localObject1 = this.XUu.hHG();
      }
    }
    else
    {
      if (localObject1 == null) {
        break label103;
      }
      Log.i(this.TAG, "getCurrentMenu, localmenu size = %s.", new Object[] { Integer.valueOf(((o)localObject1).size()) });
      paramMenu = (Menu)localObject1;
    }
    for (;;)
    {
      AppMethodBeat.o(199911);
      return paramMenu;
      localObject1 = localObject2;
      if (!(paramActivity instanceof MMActivity)) {
        break;
      }
      localObject1 = ((MMActivity)paramActivity).getMenu();
      break;
      label103:
      Log.i(this.TAG, "getCurrentMenu, localmenu is null.");
    }
  }
  
  public void a(Activity paramActivity, Menu paramMenu)
  {
    AppMethodBeat.i(143248);
    Log.v(this.TAG, "on prepare options menu, searchViewExpand %B, triggerExpand %B, canExpand %B", new Object[] { Boolean.valueOf(this.XUg), Boolean.valueOf(this.XUh), Boolean.valueOf(this.XUi) });
    if (paramActivity == null)
    {
      Log.w(this.TAG, "on hanle status fail, activity is null");
      AppMethodBeat.o(143248);
      return;
    }
    paramMenu = a(paramMenu, paramActivity);
    if (this.wLB == null)
    {
      Log.w(this.TAG, "can not find search menu, error");
      AppMethodBeat.o(143248);
      return;
    }
    this.wLB.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
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
    AppMethodBeat.i(199901);
    Log.v(this.TAG, "on create options menu");
    if (paramFragmentActivity == null)
    {
      Log.w(this.TAG, "on add search menu, activity is null");
      AppMethodBeat.o(199901);
      return;
    }
    if (this.XUk == null)
    {
      if (this.XUn)
      {
        this.XUk = new ActionBarSearchView(paramFragmentActivity);
        if (this.xUe) {
          ((ActionBarSearchView)this.XUk).hjE();
        }
        this.XUk.setAutoMatchKeywords(this.XUp);
        this.XUk.setKeywords(this.XUo);
      }
    }
    else
    {
      this.XUk.setCallBack(new ActionBarSearchView.b()
      {
        public final void bqU(String paramAnonymousString)
        {
          AppMethodBeat.i(143225);
          if (!t.a(t.this))
          {
            Log.v(t.b(t.this), "onSearchTextChange %s, but not in searching", new Object[] { paramAnonymousString });
            AppMethodBeat.o(143225);
            return;
          }
          if (t.c(t.this) != null) {
            t.c(t.this).aau(paramAnonymousString);
          }
          AppMethodBeat.o(143225);
        }
        
        public final void bxJ()
        {
          AppMethodBeat.i(143226);
          if (t.c(t.this) != null) {
            t.c(t.this).bxJ();
          }
          AppMethodBeat.o(143226);
        }
        
        public final void hYe()
        {
          AppMethodBeat.i(143224);
          if (t.c(t.this) != null) {
            t.c(t.this).bxK();
          }
          AppMethodBeat.o(143224);
        }
        
        public final void hYf()
        {
          AppMethodBeat.i(143223);
          if (!t.a(t.this))
          {
            Log.v(t.b(t.this), "onVoiceSearchRequired, but not in searching");
            AppMethodBeat.o(143223);
            return;
          }
          t.this.bsj();
          AppMethodBeat.o(143223);
        }
      });
      this.XUk.Ha(bsi());
      this.XUk.setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(143230);
          if ((3 == paramAnonymousInt) && (t.c(t.this) != null))
          {
            boolean bool = t.c(t.this).aat(t.this.getSearchContent());
            AppMethodBeat.o(143230);
            return bool;
          }
          AppMethodBeat.o(143230);
          return false;
        }
      });
      if (this.XUr != 0) {
        this.XUk.setSearchTipIcon(this.XUr);
      }
      this.wLB = paramMenu.add(0, a.g.menu_search, 0, this.XUq);
      this.wLB.setEnabled(this.XUi);
      if (!this.XUs)
      {
        if (!this.xUe) {
          break label355;
        }
        this.wLB.setIcon(au.o(paramFragmentActivity, a.j.actionbar_icon_dark_search, paramFragmentActivity.getResources().getColor(a.d.BW_100_Alpha_0_8)));
      }
      label247:
      this.wLB.setActionView((View)this.XUk);
      if (!this.XUf) {
        break label385;
      }
      this.wLB.setShowAsAction(9);
      label282:
      if (!this.XUf) {
        break label398;
      }
    }
    label385:
    label398:
    for (this.XUv = new a()
        {
          public final void dG()
          {
            AppMethodBeat.i(203443);
            t.this.c(paramFragmentActivity, t.this.a(paramMenu, paramFragmentActivity));
            AppMethodBeat.o(203443);
          }
          
          public final void hYB()
          {
            AppMethodBeat.i(203441);
            t.this.b(paramFragmentActivity, t.this.a(paramMenu, paramFragmentActivity));
            AppMethodBeat.o(203441);
          }
        };; this.XUv = new a()
        {
          public final void dG()
          {
            AppMethodBeat.i(143234);
            t.this.c(paramFragmentActivity, t.this.a(paramMenu, paramFragmentActivity));
            AppMethodBeat.o(143234);
          }
          
          public final void hYB()
          {
            AppMethodBeat.i(143233);
            t.this.b(paramFragmentActivity, t.this.a(paramMenu, paramFragmentActivity));
            AppMethodBeat.o(143233);
          }
        })
    {
      this.XUk.setBackClickCallback(new ActionBarSearchView.a()
      {
        public final void hYd()
        {
          AppMethodBeat.i(143235);
          if ((!t.d(t.this)) || (t.e(t.this) != null)) {}
          try
          {
            if ((Huawei.ifHUAWEI()) && (ar.hIO()))
            {
              ViewGroup localViewGroup = (ViewGroup)t.e(t.this).getActionView().getParent();
              if (localViewGroup != null) {
                localViewGroup.removeView(localViewGroup.findViewById(a.g.custom_action_bar_content));
              }
            }
          }
          catch (Exception localException)
          {
            label71:
            break label71;
          }
          if (t.f(t.this) != null)
          {
            t.f(t.this).dG();
            AppMethodBeat.o(143235);
            return;
            if (t.f(t.this) != null) {
              t.f(t.this).dG();
            }
          }
          AppMethodBeat.o(143235);
        }
      });
      AppMethodBeat.o(199901);
      return;
      this.XUk = new SearchViewNotRealTimeHelper(paramFragmentActivity);
      this.XUk.setNotRealCallBack(this.XUm);
      break;
      label355:
      this.wLB.setIcon(au.o(paramFragmentActivity, a.j.actionbar_icon_dark_search, paramFragmentActivity.getResources().getColor(a.d.FG_0)));
      break label247;
      this.wLB.setShowAsAction(2);
      break label282;
    }
  }
  
  public final void a(b paramb)
  {
    this.XUl = paramb;
  }
  
  public final void b(final FragmentActivity paramFragmentActivity, Menu paramMenu)
  {
    AppMethodBeat.i(199933);
    Log.d(this.TAG, "doNewExpand, searchViewExpand " + this.XUg);
    if (!this.XUg)
    {
      this.XUg = true;
      b(paramFragmentActivity, paramMenu);
      this.knk.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143239);
          if ((paramFragmentActivity == null) || (paramFragmentActivity.isFinishing()))
          {
            Log.w(t.b(t.this), "want to expand search view, but activity status error");
            AppMethodBeat.o(143239);
            return;
          }
          if (this.XUy) {
            paramFragmentActivity.supportInvalidateOptionsMenu();
          }
          AppMethodBeat.o(143239);
        }
      });
      if (this.XUl != null) {
        this.XUl.bxI();
      }
    }
    AppMethodBeat.o(199933);
  }
  
  protected boolean bsi()
  {
    return false;
  }
  
  protected void bsj() {}
  
  protected void c(Menu paramMenu)
  {
    AppMethodBeat.i(143246);
    if (paramMenu != null)
    {
      int i = 0;
      while (i < paramMenu.size())
      {
        MenuItem localMenuItem = paramMenu.getItem(i);
        if (localMenuItem.getItemId() != a.g.menu_search) {
          localMenuItem.setVisible(true);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(143246);
  }
  
  public final void c(final FragmentActivity paramFragmentActivity, Menu paramMenu)
  {
    AppMethodBeat.i(199945);
    Log.d(this.TAG, "doNewCollapse, searchViewExpand " + this.XUg);
    if (this.XUg) {
      this.XUg = false;
    }
    try
    {
      if ((Huawei.ifHUAWEI()) && (ar.hIO()) && (this.wLB != null))
      {
        ViewGroup localViewGroup = (ViewGroup)this.wLB.getActionView().getParent();
        if (localViewGroup != null) {
          localViewGroup.removeView(localViewGroup.findViewById(a.g.custom_action_bar_content));
        }
      }
    }
    catch (Exception localException)
    {
      label95:
      break label95;
    }
    c(paramMenu);
    if (this.XUk != null) {
      this.XUk.Hb(false);
    }
    this.knk.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143227);
        if ((paramFragmentActivity == null) || (paramFragmentActivity.isFinishing()))
        {
          Log.w(t.b(t.this), "want to collapse search view, but activity status error");
          AppMethodBeat.o(143227);
          return;
        }
        if (this.XUy) {
          paramFragmentActivity.supportInvalidateOptionsMenu();
        }
        AppMethodBeat.o(143227);
      }
    });
    if (this.XUl != null) {
      this.knk.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143228);
          if (t.c(t.this) != null) {
            t.c(t.this).bxH();
          }
          AppMethodBeat.o(143228);
        }
      });
    }
    this.knk.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143229);
        if (t.e(t.this) == null)
        {
          Log.w(t.b(t.this), "want to collapse search view, but search menu item is null");
          AppMethodBeat.o(143229);
          return;
        }
        if ((paramFragmentActivity != null) && (!paramFragmentActivity.isFinishing())) {
          t.f(paramFragmentActivity);
        }
        View localView = t.e(t.this).getActionView();
        if (localView != null)
        {
          localView = localView.findViewById(a.g.edittext);
          if (localView != null) {
            localView.clearFocus();
          }
        }
        AppMethodBeat.o(143229);
      }
    });
    AppMethodBeat.o(199945);
  }
  
  public final void clearFocus()
  {
    AppMethodBeat.i(143245);
    if (this.XUk != null) {
      this.XUk.hYa();
    }
    AppMethodBeat.o(143245);
  }
  
  public final String getSearchContent()
  {
    AppMethodBeat.i(143242);
    if (this.XUk != null)
    {
      String str = this.XUk.getSearchContent();
      AppMethodBeat.o(143242);
      return str;
    }
    AppMethodBeat.o(143242);
    return "";
  }
  
  public final void hVb()
  {
    AppMethodBeat.i(143252);
    Log.d(this.TAG, "do collapse");
    if ((!this.XUg) || (this.wLB == null) || (this.XUf)) {}
    try
    {
      ViewGroup localViewGroup = (ViewGroup)this.wLB.getActionView().getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(localViewGroup.findViewById(a.g.custom_action_bar_content));
      }
    }
    catch (Exception localException)
    {
      label68:
      break label68;
    }
    if (this.XUv != null)
    {
      this.XUv.dG();
      AppMethodBeat.o(143252);
      return;
      if (this.XUv != null) {
        this.XUv.dG();
      }
    }
    AppMethodBeat.o(143252);
  }
  
  protected boolean hYA()
  {
    return this.XUj;
  }
  
  public final boolean hYb()
  {
    AppMethodBeat.i(143253);
    if (this.XUk != null)
    {
      boolean bool = this.XUk.hYb();
      AppMethodBeat.o(143253);
      return bool;
    }
    AppMethodBeat.o(143253);
    return false;
  }
  
  public final boolean hYc()
  {
    AppMethodBeat.i(143254);
    if (this.XUk != null)
    {
      boolean bool = this.XUk.hYc();
      AppMethodBeat.o(143254);
      return bool;
    }
    AppMethodBeat.o(143254);
    return false;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(143250);
    Log.v(this.TAG, "on key down, key code %d, expand %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.XUg) });
    if ((4 == paramInt) && (this.XUg))
    {
      hVb();
      AppMethodBeat.o(143250);
      return true;
    }
    AppMethodBeat.o(143250);
    return false;
  }
  
  public final void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(143244);
    if (this.XUk == null)
    {
      AppMethodBeat.o(143244);
      return;
    }
    this.XUk.setHint(paramCharSequence);
    AppMethodBeat.o(143244);
  }
  
  public void setSearchContent(String paramString)
  {
    AppMethodBeat.i(143243);
    if (this.XUk == null)
    {
      AppMethodBeat.o(143243);
      return;
    }
    this.XUk.setSearchContent(paramString);
    AppMethodBeat.o(143243);
  }
  
  public static abstract interface a
  {
    public abstract void dG();
    
    public abstract void hYB();
  }
  
  public static abstract interface b
  {
    public abstract boolean aat(String paramString);
    
    public abstract void aau(String paramString);
    
    public abstract void bxH();
    
    public abstract void bxI();
    
    public abstract void bxJ();
    
    public abstract void bxK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.t
 * JD-Core Version:    0.7.0.1
 */