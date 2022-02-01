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
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.y;
import java.util.ArrayList;

public class s
{
  private MenuItem AhZ;
  public boolean Bva;
  private final String TAG;
  private SearchViewNotRealTimeHelper.a afKA;
  private boolean afKB;
  private ArrayList<String> afKC;
  private boolean afKD;
  public int afKE;
  private int afKF;
  public boolean afKG;
  private boolean afKH;
  public s.b afKI;
  public y afKJ;
  public a afKK;
  public boolean afKt;
  public boolean afKu;
  private boolean afKv;
  private boolean afKw;
  private boolean afKx;
  public e afKy;
  public c afKz;
  private MMHandler mRi;
  
  public s()
  {
    AppMethodBeat.i(143240);
    this.afKt = false;
    this.afKu = false;
    this.afKv = false;
    this.afKw = true;
    this.afKx = true;
    this.AhZ = null;
    this.mRi = new MMHandler(Looper.getMainLooper());
    this.afKy = null;
    this.afKB = true;
    this.afKE = a.k.app_empty_string;
    this.afKF = 0;
    this.Bva = false;
    this.afKG = false;
    this.afKH = true;
    this.afKB = true;
    this.afKt = false;
    this.TAG = ("MicroMsg.SearchViewHelper-" + String.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(143240);
  }
  
  public s(boolean paramBoolean)
  {
    AppMethodBeat.i(251070);
    this.afKt = false;
    this.afKu = false;
    this.afKv = false;
    this.afKw = true;
    this.afKx = true;
    this.AhZ = null;
    this.mRi = new MMHandler(Looper.getMainLooper());
    this.afKy = null;
    this.afKB = true;
    this.afKE = a.k.app_empty_string;
    this.afKF = 0;
    this.Bva = false;
    this.afKG = false;
    this.afKH = true;
    this.afKB = true;
    this.afKt = paramBoolean;
    this.TAG = ("MicroMsg.SearchViewHelper-" + String.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(251070);
  }
  
  private void b(final Activity paramActivity, Menu paramMenu)
  {
    AppMethodBeat.i(143249);
    if ((this.afKw) && ((this.afKu) || (this.afKv)))
    {
      this.afKv = false;
      if ((paramActivity instanceof MMActivity))
      {
        if (!this.Bva) {
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
      this.mRi.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143237);
          if (s.e(s.this) == null)
          {
            Log.w(s.b(s.this), "on post expand search menu, but item is null");
            AppMethodBeat.o(143237);
            return;
          }
          Log.i(s.b(s.this), "try to expand action view, searchViewExpand %B", new Object[] { Boolean.valueOf(s.a(s.this)) });
          if (s.d(s.this)) {
            if (s.f(s.this) != null) {
              s.f(s.this).jDk();
            }
          }
          for (;;)
          {
            final View localView = s.e(s.this).getActionView();
            if ((localView != null) && (s.a(s.this)))
            {
              localView.findViewById(a.g.edittext).requestFocus();
              if (s.this.jDj()) {
                s.g(s.this).postDelayed(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(143236);
                    ((InputMethodManager)s.10.this.val$activity.getSystemService("input_method")).showSoftInput(localView.findViewById(a.g.edittext), 0);
                    AppMethodBeat.o(143236);
                  }
                }, 128L);
              }
            }
            AppMethodBeat.o(143237);
            return;
            if (s.f(s.this) != null) {
              s.f(s.this).jDk();
            }
          }
        }
      }, 128L);
    }
    AppMethodBeat.o(143249);
  }
  
  public final void MY(boolean paramBoolean)
  {
    boolean bool1 = false;
    AppMethodBeat.i(143251);
    String str = this.TAG;
    boolean bool2 = this.afKu;
    if (this.AhZ == null) {
      bool1 = true;
    }
    Log.d(str, "do expand, expanded[%B], search menu item null[%B]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    if (this.afKu)
    {
      AppMethodBeat.o(143251);
      return;
    }
    if (!this.afKw)
    {
      Log.w(this.TAG, "can not expand now");
      AppMethodBeat.o(143251);
      return;
    }
    this.afKx = paramBoolean;
    if (this.AhZ != null)
    {
      this.mRi.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143238);
          if (s.e(s.this) == null)
          {
            Log.w(s.b(s.this), "post do expand search menu, but search menu item is null");
            AppMethodBeat.o(143238);
            return;
          }
          if (s.d(s.this))
          {
            if (s.f(s.this) != null)
            {
              s.f(s.this).jDk();
              AppMethodBeat.o(143238);
            }
          }
          else if (s.f(s.this) != null) {
            s.f(s.this).jDk();
          }
          AppMethodBeat.o(143238);
        }
      });
      AppMethodBeat.o(143251);
      return;
    }
    this.afKv = true;
    AppMethodBeat.o(143251);
  }
  
  public final Menu a(Menu paramMenu, Activity paramActivity)
  {
    AppMethodBeat.i(251096);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!(paramMenu instanceof com.tencent.mm.ui.base.s))
    {
      if (this.afKJ != null)
      {
        Log.i(this.TAG, "getCurrentMenu, mActivityController.");
        localObject1 = this.afKJ.jjQ();
      }
    }
    else
    {
      if (localObject1 == null) {
        break label103;
      }
      Log.i(this.TAG, "getCurrentMenu, localmenu size = %s.", new Object[] { Integer.valueOf(((com.tencent.mm.ui.base.s)localObject1).size()) });
      paramMenu = (Menu)localObject1;
    }
    for (;;)
    {
      AppMethodBeat.o(251096);
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
    Log.v(this.TAG, "on prepare options menu, searchViewExpand %B, triggerExpand %B, canExpand %B", new Object[] { Boolean.valueOf(this.afKu), Boolean.valueOf(this.afKv), Boolean.valueOf(this.afKw) });
    if (paramActivity == null)
    {
      Log.w(this.TAG, "on hanle status fail, activity is null");
      AppMethodBeat.o(143248);
      return;
    }
    paramMenu = a(paramMenu, paramActivity);
    if (this.AhZ == null)
    {
      Log.w(this.TAG, "can not find search menu, error");
      AppMethodBeat.o(143248);
      return;
    }
    this.AhZ.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
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
    AppMethodBeat.i(251092);
    Log.v(this.TAG, "on create options menu");
    if (paramFragmentActivity == null)
    {
      Log.w(this.TAG, "on add search menu, activity is null");
      AppMethodBeat.o(251092);
      return;
    }
    if (this.afKy == null)
    {
      if (this.afKB)
      {
        this.afKy = new ActionBarSearchView(paramFragmentActivity);
        if (this.Bva) {
          ((ActionBarSearchView)this.afKy).iKw();
        }
        this.afKy.setAutoMatchKeywords(this.afKD);
        this.afKy.setKeywords(this.afKC);
      }
    }
    else
    {
      this.afKy.setCallBack(new ActionBarSearchView.b()
      {
        public final void bWy()
        {
          AppMethodBeat.i(143226);
          if (s.c(s.this) != null) {
            s.c(s.this).bWy();
          }
          AppMethodBeat.o(143226);
        }
        
        public final void bqJ(String paramAnonymousString)
        {
          AppMethodBeat.i(143225);
          if (!s.a(s.this))
          {
            Log.v(s.b(s.this), "onSearchTextChange %s, but not in searching", new Object[] { paramAnonymousString });
            AppMethodBeat.o(143225);
            return;
          }
          if (s.c(s.this) != null) {
            s.c(s.this).SO(paramAnonymousString);
          }
          AppMethodBeat.o(143225);
        }
        
        public final void jCO()
        {
          AppMethodBeat.i(143224);
          if (s.c(s.this) != null) {
            s.c(s.this).bWz();
          }
          AppMethodBeat.o(143224);
        }
        
        public final void jCP()
        {
          AppMethodBeat.i(143223);
          if (!s.a(s.this))
          {
            Log.v(s.b(s.this), "onVoiceSearchRequired, but not in searching");
            AppMethodBeat.o(143223);
            return;
          }
          s.this.bPP();
          AppMethodBeat.o(143223);
        }
      });
      this.afKy.MV(bPO());
      this.afKy.setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(143230);
          if ((3 == paramAnonymousInt) && (s.c(s.this) != null))
          {
            boolean bool = s.c(s.this).SN(s.this.getSearchContent());
            AppMethodBeat.o(143230);
            return bool;
          }
          AppMethodBeat.o(143230);
          return false;
        }
      });
      if (this.afKF != 0) {
        this.afKy.setSearchTipIcon(this.afKF);
      }
      this.AhZ = paramMenu.add(0, a.g.menu_search, 0, this.afKE);
      this.AhZ.setEnabled(this.afKw);
      if (!this.afKG)
      {
        if (!this.Bva) {
          break label355;
        }
        this.AhZ.setIcon(bb.m(paramFragmentActivity, a.j.actionbar_icon_dark_search, paramFragmentActivity.getResources().getColor(a.d.BW_100_Alpha_0_8)));
      }
      label247:
      this.AhZ.setActionView((View)this.afKy);
      if (!this.afKt) {
        break label385;
      }
      this.AhZ.setShowAsAction(9);
      label282:
      if (!this.afKt) {
        break label398;
      }
    }
    label385:
    label398:
    for (this.afKK = new a()
        {
          public final void eF()
          {
            AppMethodBeat.i(251033);
            s.this.c(paramFragmentActivity, s.this.a(paramMenu, paramFragmentActivity));
            AppMethodBeat.o(251033);
          }
          
          public final void jDk()
          {
            AppMethodBeat.i(251031);
            s.this.b(paramFragmentActivity, s.this.a(paramMenu, paramFragmentActivity));
            AppMethodBeat.o(251031);
          }
        };; this.afKK = new a()
        {
          public final void eF()
          {
            AppMethodBeat.i(143234);
            s.this.c(paramFragmentActivity, s.this.a(paramMenu, paramFragmentActivity));
            AppMethodBeat.o(143234);
          }
          
          public final void jDk()
          {
            AppMethodBeat.i(143233);
            s.this.b(paramFragmentActivity, s.this.a(paramMenu, paramFragmentActivity));
            AppMethodBeat.o(143233);
          }
        })
    {
      this.afKy.setBackClickCallback(new ActionBarSearchView.a()
      {
        public final void jCN()
        {
          AppMethodBeat.i(143235);
          if ((!s.d(s.this)) || (s.e(s.this) != null)) {}
          try
          {
            if ((Huawei.ifHUAWEI()) && (aw.jlc()))
            {
              ViewGroup localViewGroup = (ViewGroup)s.e(s.this).getActionView().getParent();
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
          if (s.f(s.this) != null)
          {
            s.f(s.this).eF();
            AppMethodBeat.o(143235);
            return;
            if (s.f(s.this) != null) {
              s.f(s.this).eF();
            }
          }
          AppMethodBeat.o(143235);
        }
      });
      AppMethodBeat.o(251092);
      return;
      this.afKy = new SearchViewNotRealTimeHelper(paramFragmentActivity);
      this.afKy.setNotRealCallBack(this.afKA);
      break;
      label355:
      this.AhZ.setIcon(bb.m(paramFragmentActivity, a.j.actionbar_icon_dark_search, paramFragmentActivity.getResources().getColor(a.d.FG_0)));
      break label247;
      this.AhZ.setShowAsAction(2);
      break label282;
    }
  }
  
  public final void b(final FragmentActivity paramFragmentActivity, Menu paramMenu)
  {
    AppMethodBeat.i(251103);
    Log.d(this.TAG, "doNewExpand, searchViewExpand " + this.afKu);
    if (!this.afKu)
    {
      this.afKu = true;
      b(paramFragmentActivity, paramMenu);
      this.mRi.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143239);
          if ((paramFragmentActivity == null) || (paramFragmentActivity.isFinishing()))
          {
            Log.w(s.b(s.this), "want to expand search view, but activity status error");
            AppMethodBeat.o(143239);
            return;
          }
          if (this.afKN) {
            paramFragmentActivity.supportInvalidateOptionsMenu();
          }
          AppMethodBeat.o(143239);
        }
      });
      if (this.afKz != null) {
        this.afKz.bWx();
      }
    }
    AppMethodBeat.o(251103);
  }
  
  protected boolean bPO()
  {
    return false;
  }
  
  protected void bPP() {}
  
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
    AppMethodBeat.i(251109);
    Log.d(this.TAG, "doNewCollapse, searchViewExpand " + this.afKu);
    if (this.afKu) {
      this.afKu = false;
    }
    try
    {
      if ((Huawei.ifHUAWEI()) && (aw.jlc()) && (this.AhZ != null))
      {
        ViewGroup localViewGroup = (ViewGroup)this.AhZ.getActionView().getParent();
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
    if (this.afKI != null) {
      this.afKI.fTI();
    }
    if (this.afKy != null) {
      this.afKy.MW(false);
    }
    this.mRi.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143227);
        if ((paramFragmentActivity == null) || (paramFragmentActivity.isFinishing()))
        {
          Log.w(s.b(s.this), "want to collapse search view, but activity status error");
          AppMethodBeat.o(143227);
          return;
        }
        if (this.afKN) {
          paramFragmentActivity.supportInvalidateOptionsMenu();
        }
        AppMethodBeat.o(143227);
      }
    });
    if (this.afKz != null) {
      this.mRi.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143228);
          if (s.c(s.this) != null) {
            s.c(s.this).bWw();
          }
          AppMethodBeat.o(143228);
        }
      });
    }
    this.mRi.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143229);
        if (s.e(s.this) == null)
        {
          Log.w(s.b(s.this), "want to collapse search view, but search menu item is null");
          AppMethodBeat.o(143229);
          return;
        }
        if ((paramFragmentActivity != null) && (!paramFragmentActivity.isFinishing())) {
          s.f(paramFragmentActivity);
        }
        View localView = s.e(s.this).getActionView();
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
    AppMethodBeat.o(251109);
  }
  
  public final void clearFocus()
  {
    AppMethodBeat.i(143245);
    if (this.afKy != null) {
      this.afKy.jCK();
    }
    AppMethodBeat.o(143245);
  }
  
  public final String getSearchContent()
  {
    AppMethodBeat.i(143242);
    if (this.afKy != null)
    {
      String str = this.afKy.getSearchContent();
      AppMethodBeat.o(143242);
      return str;
    }
    AppMethodBeat.o(143242);
    return "";
  }
  
  public final boolean jCL()
  {
    AppMethodBeat.i(143253);
    if (this.afKy != null)
    {
      boolean bool = this.afKy.jCL();
      AppMethodBeat.o(143253);
      return bool;
    }
    AppMethodBeat.o(143253);
    return false;
  }
  
  public final boolean jCM()
  {
    AppMethodBeat.i(143254);
    if (this.afKy != null)
    {
      boolean bool = this.afKy.jCM();
      AppMethodBeat.o(143254);
      return bool;
    }
    AppMethodBeat.o(143254);
    return false;
  }
  
  protected boolean jDj()
  {
    return this.afKx;
  }
  
  public final void jyO()
  {
    AppMethodBeat.i(143252);
    Log.d(this.TAG, "do collapse");
    if ((!this.afKu) || (this.AhZ == null) || (this.afKt)) {}
    try
    {
      ViewGroup localViewGroup = (ViewGroup)this.AhZ.getActionView().getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(localViewGroup.findViewById(a.g.custom_action_bar_content));
      }
    }
    catch (Exception localException)
    {
      label68:
      break label68;
    }
    if (this.afKK != null)
    {
      this.afKK.eF();
      AppMethodBeat.o(143252);
      return;
      if (this.afKK != null) {
        this.afKK.eF();
      }
    }
    AppMethodBeat.o(143252);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(143250);
    Log.v(this.TAG, "on key down, key code %d, expand %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.afKu) });
    if ((4 == paramInt) && (this.afKu))
    {
      jyO();
      AppMethodBeat.o(143250);
      return true;
    }
    AppMethodBeat.o(143250);
    return false;
  }
  
  public final void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(143244);
    if (this.afKy == null)
    {
      AppMethodBeat.o(143244);
      return;
    }
    this.afKy.setHint(paramCharSequence);
    AppMethodBeat.o(143244);
  }
  
  public void setSearchContent(String paramString)
  {
    AppMethodBeat.i(143243);
    if (this.afKy == null)
    {
      AppMethodBeat.o(143243);
      return;
    }
    this.afKy.setSearchContent(paramString);
    AppMethodBeat.o(143243);
  }
  
  public static abstract interface a
  {
    public abstract void eF();
    
    public abstract void jDk();
  }
  
  public static abstract interface c
  {
    public abstract boolean SN(String paramString);
    
    public abstract void SO(String paramString);
    
    public abstract void bWw();
    
    public abstract void bWx();
    
    public abstract void bWy();
    
    public abstract void bWz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.tools.s
 * JD-Core Version:    0.7.0.1
 */