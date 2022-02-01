package com.tencent.mm.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.g.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.i.a;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.SwipeBackLayout.a;
import java.util.LinkedList;
import java.util.Locale;

public abstract class MMFragment
  extends FragmentActivitySupport
  implements View.OnAttachStateChangeListener, a
{
  protected static final int DEFAULT_TOAST_TIME = 3000;
  public static final String FLAG_OVERRIDE_ENTER_ANIMATION = "MMActivity.OverrideEnterAnimation";
  public static final String FLAG_OVERRIDE_EXIT_ANIMATION = "MMActivity.OverrideExitAnimation";
  private static final String TAG = "MicroMsg.MMFragment";
  private static final String TAG2 = "MicroMsg.INIT";
  String className;
  protected s mController = new s()
  {
    protected final void dealContentView(View paramAnonymousView)
    {
      AppMethodBeat.i(141393);
      MMFragment.this.dealContentView(paramAnonymousView);
      AppMethodBeat.o(141393);
    }
    
    protected final boolean fromFullScreenActivity()
    {
      return false;
    }
    
    protected final String getClassName()
    {
      AppMethodBeat.i(141398);
      String str = MMFragment.this.getClass().getName();
      AppMethodBeat.o(141398);
      return str;
    }
    
    protected final String getIdentString()
    {
      AppMethodBeat.i(141394);
      String str = MMFragment.this.getIdentityString();
      AppMethodBeat.o(141394);
      return str;
    }
    
    protected final int getLayoutId()
    {
      AppMethodBeat.i(141392);
      int i = MMFragment.this.getLayoutId();
      AppMethodBeat.o(141392);
      return i;
    }
    
    protected final View getLayoutView()
    {
      AppMethodBeat.i(141395);
      View localView = MMFragment.this.getLayoutView();
      AppMethodBeat.o(141395);
      return localView;
    }
    
    public final boolean noActionBar()
    {
      AppMethodBeat.i(141399);
      boolean bool = MMFragment.this.noActionBar();
      AppMethodBeat.o(141399);
      return bool;
    }
    
    protected final void onCreateBeforeSetContentView()
    {
      AppMethodBeat.i(141397);
      MMFragment.this.onCreateBeforeSetContentView();
      AppMethodBeat.o(141397);
    }
    
    public final void onKeyboardStateChanged()
    {
      AppMethodBeat.i(141396);
      MMFragment.this.onKeyboardStateChanged();
      AppMethodBeat.o(141396);
    }
  };
  private boolean mCurVisible = false;
  private a mListener;
  protected AppCompatActivity mParent;
  private MMFragment mParentFragment;
  private boolean mParentVisible = false;
  private SwipeBackLayout mSwipeBackLayout;
  
  public MMFragment() {}
  
  public MMFragment(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  private void filterAndNotifyVisibility(boolean paramBoolean)
  {
    filterAndNotifyVisibility(paramBoolean, false);
  }
  
  private void filterAndNotifyVisibility(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1 == this.mCurVisible) {
      return;
    }
    label21:
    boolean bool1;
    boolean bool2;
    if (this.mParentFragment == null)
    {
      paramBoolean1 = this.mParentVisible;
      bool1 = super.isVisible();
      bool2 = getUserVisibleHint();
      if ((!paramBoolean1) || (!bool1) || (!bool2) || (paramBoolean2)) {
        break label134;
      }
    }
    label134:
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      ae.i("MicroMsg.MMFragment", "[filterAndNotifyVisibility] visible = %s parent = %s, super = %s, hint = %s name:%s", new Object[] { Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool1), Boolean.valueOf(bool2), getClass().getName() });
      if (paramBoolean2 == this.mCurVisible) {
        break;
      }
      this.mCurVisible = paramBoolean2;
      onVisibilityChanged(this.mCurVisible);
      return;
      paramBoolean1 = this.mParentFragment.isFragmentVisible();
      break label21;
    }
  }
  
  public static Locale initLanguage(Context paramContext)
  {
    return s.initLanguage(paramContext);
  }
  
  private View initSwipeBack()
  {
    View localView = getContentView();
    ViewGroup localViewGroup = (ViewGroup)localView.getParent();
    if (localViewGroup != null)
    {
      this.mSwipeBackLayout = ((SwipeBackLayout)LayoutInflater.from(thisActivity()).inflate(2131495736, localViewGroup, false));
      localViewGroup.removeView(localView);
      localViewGroup.addView(this.mSwipeBackLayout);
    }
    for (;;)
    {
      this.mSwipeBackLayout.addView(localView);
      this.mSwipeBackLayout.setContentView(localView);
      this.mSwipeBackLayout.yZ(true);
      this.mSwipeBackLayout.setSwipeGestureDelegate(new SwipeBackLayout.a()
      {
        public final void onCancel()
        {
          AppMethodBeat.i(141401);
          MMFragment.this.onCancelDrag();
          AppMethodBeat.o(141401);
        }
        
        public final void onDrag()
        {
          AppMethodBeat.i(141402);
          MMFragment.this.onDragBegin();
          AppMethodBeat.o(141402);
        }
        
        public final void onSwipeBack()
        {
          AppMethodBeat.i(141400);
          MMFragment.this.onSwipeBack();
          AppMethodBeat.o(141400);
        }
      });
      return this.mSwipeBackLayout;
      this.mSwipeBackLayout = ((SwipeBackLayout)LayoutInflater.from(thisActivity()).inflate(2131495736, null));
    }
  }
  
  public static void showVKB(Activity paramActivity)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)paramActivity.getSystemService("input_method");
    if (localInputMethodManager == null) {}
    do
    {
      return;
      paramActivity = paramActivity.getCurrentFocus();
    } while ((paramActivity == null) || (paramActivity.getWindowToken() == null));
    localInputMethodManager.toggleSoftInput(0, 2);
  }
  
  public void activateBroadcast(boolean paramBoolean)
  {
    this.mController.activateBroadcast(paramBoolean);
  }
  
  public void addDialog(Dialog paramDialog)
  {
    this.mController.addDialog(paramDialog);
  }
  
  public void addIconOptionMenu(int paramInt1, int paramInt2, int paramInt3, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mController.addIconOptionMenu(paramInt1, paramInt2, paramInt3, paramOnMenuItemClickListener);
  }
  
  public void addIconOptionMenu(int paramInt1, int paramInt2, int paramInt3, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    this.mController.addIconOptionMenu(paramInt1, paramInt2, paramInt3, paramOnMenuItemClickListener, paramOnLongClickListener);
  }
  
  public void addIconOptionMenu(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mController.addIconOptionMenu(paramInt1, paramInt2, paramInt3, paramBoolean, paramOnMenuItemClickListener);
  }
  
  public void addIconOptionMenu(int paramInt1, int paramInt2, Drawable paramDrawable, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mController.addIconOptionMenu(paramInt1, getString(paramInt2), paramDrawable, paramOnMenuItemClickListener);
  }
  
  public void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mController.addIconOptionMenu(paramInt1, paramInt2, paramOnMenuItemClickListener);
  }
  
  public void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, int paramInt3)
  {
    s locals = this.mController;
    s.b localb = s.b.Jwz;
    s.a locala = new s.a();
    locala.Jok = paramInt1;
    locala.Jwv = paramInt3;
    locala.Jol = paramInt2;
    locala.text = "";
    locala.jle = paramOnMenuItemClickListener;
    locala.rIu = null;
    locala.Jwx = localb;
    locala.Jwy = false;
    if ((locala.Jol == 2131233291) && (bu.isNullOrNil(""))) {
      locala.text = locals.mContext.getString(2131755815);
    }
    locals.aco(locala.Jok);
    locals.Job.add(locala);
    locals.supportInvalidateOptionsMenu();
  }
  
  public void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    this.mController.addIconOptionMenu(paramInt1, paramInt2, paramOnMenuItemClickListener, paramOnLongClickListener);
  }
  
  public void addIconOptionMenu(int paramInt1, String paramString, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mController.addIconOptionMenu(paramInt1, paramString, paramInt2, paramOnMenuItemClickListener);
  }
  
  public void addIconOptionMenu(int paramInt, String paramString, Drawable paramDrawable, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mController.addIconOptionMenu(paramInt, paramString, paramDrawable, paramOnMenuItemClickListener);
  }
  
  public void addSearchMenu(boolean paramBoolean, r paramr)
  {
    this.mController.addSearchMenu(paramBoolean, paramr);
  }
  
  public void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mController.addTextOptionMenu(paramInt, paramString, paramOnMenuItemClickListener);
  }
  
  public void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    this.mController.addTextOptionMenu(paramInt, paramString, paramOnMenuItemClickListener, paramOnLongClickListener);
  }
  
  public void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener, s.b paramb)
  {
    this.mController.addTextOptionMenu(paramInt, paramString, paramOnMenuItemClickListener, paramOnLongClickListener, paramb);
  }
  
  public boolean callBackMenu()
  {
    return this.mController.callBackMenu();
  }
  
  protected void dealContentView(View paramView) {}
  
  public void enableBackMenu(boolean paramBoolean)
  {
    this.mController.enableBackMenu(paramBoolean);
  }
  
  public void enableOptionMenu(int paramInt, boolean paramBoolean)
  {
    this.mController.b(false, paramInt, paramBoolean);
  }
  
  public void enableOptionMenu(boolean paramBoolean)
  {
    this.mController.b(true, -1, paramBoolean);
  }
  
  public s.a findMenuInfo(int paramInt)
  {
    return this.mController.acp(paramInt);
  }
  
  public void finish()
  {
    super.finish();
    int i = thisActivity().getIntent().getIntExtra("MMActivity.OverrideEnterAnimation", -1);
    int j = thisActivity().getIntent().getIntExtra("MMActivity.OverrideExitAnimation", -1);
    if (i != -1) {
      getContext().overridePendingTransition(i, j);
    }
  }
  
  public void fullScreenNoTitleBar(boolean paramBoolean)
  {
    this.mController.fullScreenNoTitleBar(paramBoolean);
  }
  
  public void fullScreenWithTitleBar(boolean paramBoolean)
  {
    this.mController.fullScreenWithTitleBar(paramBoolean);
  }
  
  public View getBodyView()
  {
    return this.mController.CbM;
  }
  
  public final View getContentView()
  {
    return this.mController.contentView;
  }
  
  public final Activity getContext()
  {
    return this.mController.JvK;
  }
  
  public s getController()
  {
    return this.mController;
  }
  
  protected int getForceOrientation()
  {
    return -1;
  }
  
  public String getIdentityString()
  {
    return "";
  }
  
  public boolean getLandscapeMode()
  {
    return this.mController.getLandscapeMode();
  }
  
  protected abstract int getLayoutId();
  
  protected View getLayoutView()
  {
    return null;
  }
  
  public Resources getMMResources()
  {
    return thisActivity().getResources();
  }
  
  public String getMMString(int paramInt)
  {
    return thisActivity().getString(paramInt);
  }
  
  public String getMMString(int paramInt, Object... paramVarArgs)
  {
    return thisActivity().getString(paramInt, paramVarArgs);
  }
  
  public CharSequence getMMTitle()
  {
    return this.mController.getMMTitle();
  }
  
  public int getStreamMaxVolume(int paramInt)
  {
    return this.mController.getStreamMaxVolume(paramInt);
  }
  
  public int getStreamVolume(int paramInt)
  {
    return this.mController.getStreamVolume(paramInt);
  }
  
  public SwipeBackLayout getSwipeBackLayout()
  {
    return this.mSwipeBackLayout;
  }
  
  public int getTitleLocation()
  {
    return this.mController.getTitleLocation();
  }
  
  public void hideTitleView()
  {
    this.mController.hideTitleView();
  }
  
  public boolean hideVKB()
  {
    return this.mController.hideVKB();
  }
  
  public boolean hideVKB(View paramView)
  {
    return this.mController.hideVKB(paramView);
  }
  
  public boolean interceptSupportInvalidateOptionsMenu()
  {
    if (this.mController.interceptSupportInvalidateOptionsMenu())
    {
      this.mController.supportInvalidateOptionsMenu();
      return true;
    }
    return false;
  }
  
  public boolean isFragmentVisible()
  {
    return this.mCurVisible;
  }
  
  public boolean isScreenEnable()
  {
    return this.mController.Jvy;
  }
  
  public boolean isSupportCustomActionBar()
  {
    return isSupportNavigationSwipeBack();
  }
  
  public final boolean isSupportNavigationSwipeBack()
  {
    if ((d.lA(19)) && (b.abm())) {
      return supportNavigationSwipeBack();
    }
    return false;
  }
  
  public boolean isTitleShowing()
  {
    return this.mController.isTitleShowing();
  }
  
  public int keyboardState()
  {
    return this.mController.Jwi;
  }
  
  public boolean needShowIdcError()
  {
    return true;
  }
  
  public boolean noActionBar()
  {
    return false;
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    paramContext = getParentFragment();
    if ((paramContext != null) && ((paramContext instanceof MMFragment)))
    {
      this.mParentFragment = ((MMFragment)paramContext);
      this.mParentFragment.setOnVisibilityChangedListener(this);
    }
    filterAndNotifyVisibility(true);
  }
  
  public void onCancelDrag() {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mController.a(thisActivity().getBaseContext(), (AppCompatActivity)thisActivity());
    this.mController.setNavigationbarColor(thisActivity().getResources().getColor(2131099649));
  }
  
  protected void onCreateBeforeSetContentView() {}
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    if (!this.mController.onCreateOptionsMenu(paramMenu)) {
      super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    setHasOptionsMenu(true);
    paramLayoutInflater = getContentView();
    if (isSupportNavigationSwipeBack()) {
      paramLayoutInflater = initSwipeBack();
    }
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mController.jR(getActivity());
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    getView().removeOnAttachStateChangeListener(this);
  }
  
  public void onDetach()
  {
    if (this.mParentFragment != null) {
      this.mParentFragment.setOnVisibilityChangedListener(null);
    }
    super.onDetach();
    filterAndNotifyVisibility(false);
    this.mParentFragment = null;
  }
  
  public void onDragBegin() {}
  
  public void onFragmentVisibilityChanged(boolean paramBoolean)
  {
    filterAndNotifyVisibility(paramBoolean);
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      filterAndNotifyVisibility(bool, paramBoolean);
      return;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.mController.onKeyDown(paramInt, paramKeyEvent)) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.mController.onKeyUp(paramInt, paramKeyEvent)) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onKeyboardStateChanged() {}
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    return this.mController.onOptionsItemSelected(paramMenuItem);
  }
  
  protected void onParentVisibilityChanged(boolean paramBoolean)
  {
    this.mParentVisible = paramBoolean;
    filterAndNotifyVisibility(paramBoolean);
  }
  
  public void onPause()
  {
    long l = System.currentTimeMillis();
    aj.cQ(2, this.className);
    super.onPause();
    this.mController.onPause();
    ae.v("MicroMsg.INIT", "KEVIN MMActivity onPause:" + (System.currentTimeMillis() - l));
    onParentVisibilityChanged(false);
  }
  
  public void onPrepareOptionsMenu(Menu paramMenu)
  {
    this.mController.onPrepareOptionsMenu(paramMenu);
    super.onPrepareOptionsMenu(paramMenu);
  }
  
  public void onResume()
  {
    long l = System.currentTimeMillis();
    aj.cQ(1, this.className);
    super.onResume();
    ae.v("MicroMsg.INIT", "KEVIN MMActivity super..onResume " + (System.currentTimeMillis() - l));
    this.mController.onResume();
    ae.v("MicroMsg.INIT", "KEVIN MMActivity onResume :" + (System.currentTimeMillis() - l));
    onParentVisibilityChanged(true);
  }
  
  public void onStart()
  {
    this.mController.onStart();
    super.onStart();
    onParentVisibilityChanged(true);
  }
  
  public void onStop()
  {
    super.onStop();
    onParentVisibilityChanged(false);
  }
  
  public void onSwipeBack() {}
  
  public void onViewAttachedToWindow(View paramView)
  {
    filterAndNotifyVisibility(true);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    getView().addOnAttachStateChangeListener(this);
  }
  
  public void onViewDetachedFromWindow(View paramView)
  {
    filterAndNotifyVisibility(false);
  }
  
  protected void onVisibilityChanged(boolean paramBoolean)
  {
    if (this.mListener != null) {
      this.mListener.onFragmentVisibilityChanged(paramBoolean);
    }
    int j = -1;
    Bundle localBundle = getArguments();
    int i = j;
    if (localBundle != null)
    {
      i = j;
      if (localBundle.containsKey(getClass().getName())) {
        i = localBundle.getInt(getClass().getName());
      }
    }
    ae.i("MicroMsg.MMFragment", "[onVisibilityChanged] visible:%s name:%s id:%s", new Object[] { Boolean.valueOf(paramBoolean), getClass().getName(), Integer.valueOf(i) });
  }
  
  public void removeAllOptionMenu()
  {
    this.mController.removeAllOptionMenu();
  }
  
  public boolean removeOptionMenu(int paramInt)
  {
    return this.mController.removeOptionMenu(paramInt);
  }
  
  public void setActivityController(s params)
  {
    if (params != null) {
      this.mController = params;
    }
  }
  
  public void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mController.setBackBtn(paramOnMenuItemClickListener, 0);
  }
  
  public void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, int paramInt)
  {
    this.mController.setBackBtn(paramOnMenuItemClickListener, paramInt);
  }
  
  public void setBackGroundColorResource(int paramInt)
  {
    this.mController.setBackGroundColorResource(paramInt);
  }
  
  protected final void setBodyView(int paramInt)
  {
    this.mController.setBodyView(paramInt);
  }
  
  public void setMMNormalView()
  {
    this.mController.setMMNormalView();
  }
  
  public void setMMSubTitle(int paramInt)
  {
    this.mController.setMMSubTitle(paramInt);
  }
  
  public void setMMSubTitle(String paramString)
  {
    this.mController.setMMSubTitle(paramString);
  }
  
  public void setMMSubTitleColor(int paramInt) {}
  
  public void setMMTitle(int paramInt)
  {
    this.mController.setMMTitle(paramInt);
  }
  
  public void setMMTitle(String paramString)
  {
    this.mController.setMMTitle(paramString);
  }
  
  public void setOnVisibilityChangedListener(a parama)
  {
    this.mListener = parama;
  }
  
  public void setParent(AppCompatActivity paramAppCompatActivity)
  {
    this.mParent = paramAppCompatActivity;
  }
  
  @Deprecated
  public void setRedDotVisibilty(int paramInt) {}
  
  public void setScreenEnable(boolean paramBoolean)
  {
    this.mController.setScreenEnable(paramBoolean);
  }
  
  public void setTitleBarDoubleClickListener(Runnable paramRunnable)
  {
    this.mController.setTitleBarDoubleClickListener(paramRunnable);
  }
  
  @Deprecated
  public void setTitleClickAction(GestureDetector.SimpleOnGestureListener paramSimpleOnGestureListener) {}
  
  public void setTitleLogo(int paramInt1, int paramInt2)
  {
    this.mController.setTitleLogo(paramInt1, paramInt2);
  }
  
  public void setTitleMuteIconVisibility(int paramInt)
  {
    this.mController.setTitleMuteIconVisibility(paramInt);
  }
  
  public void setTitlePhoneIconVisibility(int paramInt)
  {
    this.mController.setTitlePhoneIconVisibility(paramInt);
  }
  
  public void setTitleVisibility(int paramInt)
  {
    this.mController.setTitleVisibility(paramInt);
  }
  
  @Deprecated
  public void setToTop(View.OnClickListener paramOnClickListener) {}
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    ae.i("MicroMsg.MMFragment", "[setUserVisibleHint] isVisibleToUser:%s name:%s", new Object[] { Boolean.valueOf(paramBoolean), getClass().getName() });
    super.setUserVisibleHint(paramBoolean);
    filterAndNotifyVisibility(paramBoolean);
  }
  
  public void showHomeBtn(boolean paramBoolean)
  {
    this.mController.showHomeBtn(paramBoolean);
  }
  
  public void showOptionMenu(int paramInt, boolean paramBoolean)
  {
    this.mController.c(false, paramInt, paramBoolean);
  }
  
  public void showOptionMenu(boolean paramBoolean)
  {
    this.mController.c(true, -1, paramBoolean);
  }
  
  public void showTitleView()
  {
    this.mController.showTitleView();
  }
  
  public void showVKB()
  {
    s.showVKB(this.mController.JvK);
  }
  
  public void startActivity(Intent paramIntent)
  {
    startActivityReal(paramIntent);
  }
  
  public void startActivityReal(Intent paramIntent)
  {
    super.startActivity(paramIntent);
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return true;
  }
  
  public FragmentActivity thisActivity()
  {
    if (this.mController.JvK != null) {
      return this.mController.JvK;
    }
    return super.getActivity();
  }
  
  public Resources thisResources()
  {
    FragmentActivity localFragmentActivity = super.getActivity();
    if (localFragmentActivity == null) {
      return ak.getContext().getResources();
    }
    return localFragmentActivity.getResources();
  }
  
  public void updateDescription(String paramString)
  {
    this.mController.updateDescription(paramString);
  }
  
  public void updateOptionMenu(int paramInt1, int paramInt2, int paramInt3, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    updateOptionMenu(paramInt1, paramInt2, paramInt3, false, paramOnMenuItemClickListener);
  }
  
  public void updateOptionMenu(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    s locals = this.mController;
    locals.updateOptionMenuText(paramInt1, locals.JvK.getString(paramInt2));
    this.mController.updateOptionMenuIcon(paramInt1, paramInt3);
    this.mController.updateOptionMenuListener(paramInt1, paramOnMenuItemClickListener, null);
    this.mController.updateOptionMenuRedDot(paramInt1, paramBoolean);
    this.mController.a(this.mController.acp(paramInt1));
  }
  
  public void updateOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, int paramInt3)
  {
    this.mController.updateOptionMenuIcon(paramInt1, paramInt2);
    this.mController.updateOptionMenuListener(paramInt1, paramOnMenuItemClickListener, null);
    paramOnMenuItemClickListener = this.mController;
    s.a locala = paramOnMenuItemClickListener.acp(paramInt1);
    if ((locala != null) && (locala.Jol != paramInt2))
    {
      locala.Jol = paramInt2;
      locala.Jwv = paramInt3;
      paramOnMenuItemClickListener.supportInvalidateOptionsMenu();
    }
    this.mController.a(this.mController.acp(paramInt1));
  }
  
  public void updateOptionMenuIcon(int paramInt1, int paramInt2)
  {
    this.mController.updateOptionMenuIcon(paramInt1, paramInt2);
  }
  
  public void updateOptionMenuListener(int paramInt, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    this.mController.updateOptionMenuListener(paramInt, paramOnMenuItemClickListener, paramOnLongClickListener);
  }
  
  public void updateOptionMenuRedDot(int paramInt, boolean paramBoolean)
  {
    this.mController.updateOptionMenuRedDot(paramInt, paramBoolean);
  }
  
  public void updateOptionMenuText(int paramInt, String paramString)
  {
    this.mController.updateOptionMenuText(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.MMFragment
 * JD-Core Version:    0.7.0.1
 */