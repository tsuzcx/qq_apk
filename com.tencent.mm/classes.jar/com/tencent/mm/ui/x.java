package com.tencent.mm.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.AudioManager;
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
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.h.a.ko;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.tools.n;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.SwipeBackLayout.a;
import java.util.Locale;

public abstract class x
  extends i
  implements View.OnAttachStateChangeListener, com.tencent.mm.ui.h.a
{
  protected static final int DEFAULT_TOAST_TIME = 3000;
  public static final String FLAG_OVERRIDE_ENTER_ANIMATION = "MMActivity.OverrideEnterAnimation";
  public static final String FLAG_OVERRIDE_EXIT_ANIMATION = "MMActivity.OverrideExitAnimation";
  private static final String TAG = "MicroMsg.MMFragment";
  private static final String TAG2 = "MicroMsg.INIT";
  String className;
  public s mController = new s()
  {
    protected final String bdI()
    {
      return x.this.getIdentityString();
    }
    
    protected final boolean czg()
    {
      return false;
    }
    
    protected final void dealContentView(View paramAnonymousView)
    {
      x.this.dealContentView(paramAnonymousView);
    }
    
    protected final String getClassName()
    {
      return x.this.getClass().getName();
    }
    
    protected final int getLayoutId()
    {
      return x.this.getLayoutId();
    }
    
    protected final View getLayoutView()
    {
      return x.this.getLayoutView();
    }
    
    public final boolean noActionBar()
    {
      return x.this.noActionBar();
    }
    
    protected final void onCreateBeforeSetContentView()
    {
      x.this.onCreateBeforeSetContentView();
    }
    
    public final void onKeyboardStateChanged()
    {
      x.this.onKeyboardStateChanged();
    }
  };
  private boolean mCurVisible = false;
  private com.tencent.mm.ui.h.a mListener;
  protected AppCompatActivity mParent;
  private x mParentFragment;
  private boolean mParentVisible = false;
  private SwipeBackLayout mSwipeBackLayout;
  
  public x() {}
  
  public x(boolean paramBoolean)
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
      y.i("MicroMsg.MMFragment", "[filterAndNotifyVisibility] visible = %s parent = %s, super = %s, hint = %s name:%s", new Object[] { Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool1), Boolean.valueOf(bool2), getClass().getName() });
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
  
  private void initSwipeBack()
  {
    View localView = getContentView();
    ViewGroup localViewGroup = (ViewGroup)localView.getParent();
    if (localViewGroup != null)
    {
      this.mSwipeBackLayout = ((SwipeBackLayout)LayoutInflater.from(thisActivity()).inflate(a.h.swipeback_layout, localViewGroup, false));
      localViewGroup.removeView(localView);
      localViewGroup.addView(this.mSwipeBackLayout);
    }
    for (;;)
    {
      this.mSwipeBackLayout.addView(localView);
      this.mSwipeBackLayout.setContentView(localView);
      this.mSwipeBackLayout.nR(true);
      this.mSwipeBackLayout.setSwipeGestureDelegate(new SwipeBackLayout.a()
      {
        public final void onCancel()
        {
          x.this.onCancelDrag();
        }
        
        public final void onDrag()
        {
          x.this.onDragBegin();
        }
        
        public final void onSwipeBack()
        {
          x.this.onSwipeBack();
        }
      });
      return;
      this.mSwipeBackLayout = ((SwipeBackLayout)LayoutInflater.from(thisActivity()).inflate(a.h.swipeback_layout, null));
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
  
  public void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mController.addIconOptionMenu(paramInt1, paramInt2, paramOnMenuItemClickListener);
  }
  
  public void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    this.mController.addIconOptionMenu(paramInt1, paramInt2, paramOnMenuItemClickListener, paramOnLongClickListener);
  }
  
  public void addIconOptionMenu(int paramInt1, String paramString, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mController.addIconOptionMenu(paramInt1, paramString, paramInt2, paramOnMenuItemClickListener);
  }
  
  public void addSearchMenu(boolean paramBoolean, n paramn)
  {
    this.mController.addSearchMenu(paramBoolean, paramn);
  }
  
  public void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mController.addTextOptionMenu(paramInt, paramString, paramOnMenuItemClickListener);
  }
  
  public void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    this.mController.a(paramInt, 0, paramString, false, paramOnMenuItemClickListener, paramOnLongClickListener, s.b.uNw);
  }
  
  public void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener, s.b paramb)
  {
    this.mController.addTextOptionMenu(paramInt, paramString, paramOnMenuItemClickListener, paramOnLongClickListener, paramb);
  }
  
  public boolean callBackMenu()
  {
    return this.mController.callBackMenu();
  }
  
  public void dealContentView(View paramView) {}
  
  public void enableBackMenu(boolean paramBoolean)
  {
    this.mController.enableBackMenu(paramBoolean);
  }
  
  public void enableOptionMenu(int paramInt, boolean paramBoolean)
  {
    this.mController.c(false, paramInt, paramBoolean);
  }
  
  public void enableOptionMenu(boolean paramBoolean)
  {
    this.mController.c(true, -1, paramBoolean);
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
    s locals = this.mController;
    if (paramBoolean)
    {
      locals.uMN.getWindow().setFlags(1024, 1024);
      return;
    }
    locals.uMN.getWindow().clearFlags(1024);
  }
  
  public View getBodyView()
  {
    return this.mController.uMz;
  }
  
  public final View getContentView()
  {
    return this.mController.contentView;
  }
  
  public final Activity getContext()
  {
    return this.mController.uMN;
  }
  
  public s getController()
  {
    return this.mController;
  }
  
  public int getForceOrientation()
  {
    return s.getForceOrientation();
  }
  
  public String getIdentityString()
  {
    return "";
  }
  
  public boolean getLandscapeMode()
  {
    return this.mController.getLandscapeMode();
  }
  
  public abstract int getLayoutId();
  
  public View getLayoutView()
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
    return this.mController.eJZ.getStreamMaxVolume(paramInt);
  }
  
  public int getStreamVolume(int paramInt)
  {
    return this.mController.eJZ.getStreamVolume(paramInt);
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
    return this.mController.uMD;
  }
  
  public boolean isSupportCustomActionBar()
  {
    return isSupportNavigationSwipeBack();
  }
  
  public final boolean isSupportNavigationSwipeBack()
  {
    if ((d.gF(19)) && (com.tencent.mm.compatible.i.a.zD())) {
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
    return this.mController.uNh;
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
    if ((paramContext != null) && ((paramContext instanceof x)))
    {
      this.mParentFragment = ((x)paramContext);
      this.mParentFragment.setOnVisibilityChangedListener(this);
    }
    filterAndNotifyVisibility(true);
  }
  
  public void onCancelDrag() {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mController.a(thisActivity().getBaseContext(), (AppCompatActivity)thisActivity());
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
    return getContentView();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mController.onDestroy();
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
    ai.be(2, this.className);
    super.onPause();
    this.mController.onPause();
    y.v("MicroMsg.INIT", "KEVIN MMActivity onPause:" + (System.currentTimeMillis() - l));
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
    ai.be(1, this.className);
    super.onResume();
    y.v("MicroMsg.INIT", "KEVIN MMActivity super..onResume " + (System.currentTimeMillis() - l));
    this.mController.onResume();
    y.v("MicroMsg.INIT", "KEVIN MMActivity onResume :" + (System.currentTimeMillis() - l));
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
    if (isSupportNavigationSwipeBack()) {
      initSwipeBack();
    }
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
    Object localObject = getArguments();
    int i = j;
    if (localObject != null)
    {
      i = j;
      if (((Bundle)localObject).containsKey(getClass().getName())) {
        i = ((Bundle)localObject).getInt(getClass().getName());
      }
    }
    y.i("MicroMsg.MMFragment", "[onVisibilityChanged] visible:%s name:%s id:%s", new Object[] { Boolean.valueOf(paramBoolean), getClass().getName(), Integer.valueOf(i) });
    localObject = new ko();
    ((ko)localObject).bTF.name = getClass().getName();
    ((ko)localObject).bTF.id = i;
    ((ko)localObject).bTF.aoL = paramBoolean;
    com.tencent.mm.sdk.b.a.udP.m((b)localObject);
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
    s locals = this.mController;
    if (locals.uMC == null) {
      locals.uMC = ((FrameLayout)locals.contentView.findViewById(a.g.mm_content_fl));
    }
    if (locals.uMA != null) {
      locals.uMC.removeView(locals.uMA);
    }
    locals.uMC.removeView(locals.uMz);
    locals.uMz = ((LayoutInflater)locals.mContext.getSystemService("layout_inflater")).inflate(paramInt, null);
    locals.uMC.addView(locals.uMz, 0, new FrameLayout.LayoutParams(-1, -1));
    if (locals.uMA != null)
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, BackwardSupportUtil.b.b(locals.mContext, 47.0F));
      locals.uMC.addView(locals.uMA, locals.uMC.getChildCount(), localLayoutParams);
    }
    locals.uMC.invalidate();
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
  
  public void setOnVisibilityChangedListener(com.tencent.mm.ui.h.a parama)
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
    s locals = this.mController;
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      locals.uMM = bool;
      locals.czA();
      return;
    }
  }
  
  public void setTitleVisibility(int paramInt)
  {
    this.mController.setTitleVisibility(paramInt);
  }
  
  @Deprecated
  public void setToTop(View.OnClickListener paramOnClickListener) {}
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    y.i("MicroMsg.MMFragment", "[setUserVisibleHint] isVisibleToUser:%s name:%s", new Object[] { Boolean.valueOf(paramBoolean), getClass().getName() });
    super.setUserVisibleHint(paramBoolean);
    filterAndNotifyVisibility(paramBoolean);
  }
  
  public void showHomeBtn(boolean paramBoolean)
  {
    this.mController.showHomeBtn(paramBoolean);
  }
  
  public void showOptionMenu(int paramInt, boolean paramBoolean)
  {
    this.mController.d(false, paramInt, paramBoolean);
  }
  
  public void showOptionMenu(boolean paramBoolean)
  {
    this.mController.d(true, -1, paramBoolean);
  }
  
  public void showTitleView()
  {
    this.mController.showTitleView();
  }
  
  public void showVKB()
  {
    this.mController.showVKB();
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
    if (this.mController.uMN != null) {
      return this.mController.uMN;
    }
    return super.getActivity();
  }
  
  public Resources thisResources()
  {
    FragmentActivity localFragmentActivity = super.getActivity();
    if (localFragmentActivity == null) {
      return ae.getContext().getResources();
    }
    return localFragmentActivity.getResources();
  }
  
  public void updateDescription(String paramString)
  {
    this.mController.updateDescription(paramString);
  }
  
  public void updateOptionMenuIcon(int paramInt1, int paramInt2)
  {
    s locals = this.mController;
    s.a locala = locals.FU(paramInt1);
    if ((locala != null) && (locala.uHe != paramInt2))
    {
      locala.uHe = paramInt2;
      locals.supportInvalidateOptionsMenu();
    }
  }
  
  public void updateOptionMenuListener(int paramInt, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    this.mController.updateOptionMenuListener(paramInt, paramOnMenuItemClickListener, paramOnLongClickListener);
  }
  
  public void updateOptionMenuText(int paramInt, String paramString)
  {
    this.mController.updateOptionMenuText(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.x
 * JD-Core Version:    0.7.0.1
 */