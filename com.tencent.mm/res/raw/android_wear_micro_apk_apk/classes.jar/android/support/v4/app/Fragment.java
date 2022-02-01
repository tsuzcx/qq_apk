package android.support.v4.app;

import android.animation.Animator;
import android.app.Activity;
import android.arch.lifecycle.f;
import android.arch.lifecycle.i;
import android.arch.lifecycle.j;
import android.arch.lifecycle.x;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.b.d;
import android.support.v4.b.r;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Fragment
  implements i, ComponentCallbacks, View.OnCreateContextMenuListener
{
  private static final r<String, Class<?>> cq = new r();
  static final Object cr = new Object();
  int bL = -1;
  int cA;
  boolean cB;
  boolean cC;
  boolean cD;
  boolean cE;
  boolean cF;
  boolean cG;
  int cH;
  u cI;
  s cJ;
  u cK;
  ae cL;
  x cM;
  Fragment cN;
  int cO;
  int cP;
  String cQ;
  boolean cR;
  boolean cS;
  boolean cT;
  boolean cU;
  boolean cV;
  boolean cW = true;
  boolean cX;
  ViewGroup cY;
  View cZ;
  int cs = 0;
  Bundle ct;
  SparseArray<Parcelable> cu;
  Boolean cv;
  String cw;
  Bundle cx;
  Fragment cy;
  int cz = -1;
  View da;
  boolean db;
  boolean dc = true;
  LoaderManagerImpl dd;
  l de;
  boolean df;
  boolean dg;
  float dh;
  LayoutInflater di;
  boolean dj;
  j dk = new j(this);
  
  private void Q()
  {
    n localn = null;
    if (this.de == null) {}
    for (;;)
    {
      if (localn != null) {
        localn.ag();
      }
      return;
      this.de.dC = false;
      localn = this.de.dD;
      this.de.dD = null;
    }
  }
  
  private void R()
  {
    if (this.cJ == null) {
      throw new IllegalStateException("Fragment has not been attached yet.");
    }
    this.cK = new u();
    this.cK.a(this.cJ, new q()
    {
      public final Fragment a(Context paramAnonymousContext, String paramAnonymousString, Bundle paramAnonymousBundle)
      {
        return Fragment.this.cJ.a(paramAnonymousContext, paramAnonymousString, paramAnonymousBundle);
      }
      
      public final View onFindViewById(int paramAnonymousInt)
      {
        if (Fragment.this.cZ == null) {
          throw new IllegalStateException("Fragment does not have a view");
        }
        return Fragment.this.cZ.findViewById(paramAnonymousInt);
      }
      
      public final boolean onHasView()
      {
        return Fragment.this.cZ != null;
      }
    }, this);
  }
  
  private l W()
  {
    if (this.de == null) {
      this.de = new l();
    }
    return this.de;
  }
  
  public static Fragment a(Context paramContext, String paramString, Bundle paramBundle)
  {
    bool = false;
    try
    {
      Class localClass2 = (Class)cq.get(paramString);
      Class localClass1 = localClass2;
      if (localClass2 == null)
      {
        localClass1 = paramContext.getClassLoader().loadClass(paramString);
        cq.put(paramString, localClass1);
      }
      paramContext = (Fragment)localClass1.getConstructor(new Class[0]).newInstance(new Object[0]);
      if (paramBundle == null) {
        break label153;
      }
      paramBundle.setClassLoader(paramContext.getClass().getClassLoader());
      if (paramContext.bL < 0) {
        break label148;
      }
      if (paramContext.cI != null) {
        break label137;
      }
    }
    catch (ClassNotFoundException paramContext)
    {
      for (;;)
      {
        throw new m("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an empty constructor that is public", paramContext);
        bool = paramContext.cI.isStateSaved();
      }
      paramContext.cx = paramBundle;
      return paramContext;
    }
    catch (InstantiationException paramContext)
    {
      throw new m("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an empty constructor that is public", paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      throw new m("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an empty constructor that is public", paramContext);
    }
    catch (NoSuchMethodException paramContext)
    {
      throw new m("Unable to instantiate fragment " + paramString + ": could not find Fragment constructor", paramContext);
    }
    catch (InvocationTargetException paramContext)
    {
      throw new m("Unable to instantiate fragment " + paramString + ": calling Fragment constructor caused an exception", paramContext);
    }
    if (bool) {
      throw new IllegalStateException("Fragment already active and state has been saved");
    }
  }
  
  static boolean a(Context paramContext, String paramString)
  {
    try
    {
      Class localClass2 = (Class)cq.get(paramString);
      Class localClass1 = localClass2;
      if (localClass2 == null)
      {
        localClass1 = paramContext.getClassLoader().loadClass(paramString);
        cq.put(paramString, localClass1);
      }
      boolean bool = Fragment.class.isAssignableFrom(localClass1);
      return bool;
    }
    catch (ClassNotFoundException paramContext) {}
    return false;
  }
  
  final boolean E()
  {
    if (this.de == null) {
      return false;
    }
    return this.de.dC;
  }
  
  final boolean H()
  {
    return this.cH > 0;
  }
  
  public final FragmentActivity I()
  {
    if (this.cJ == null) {
      return null;
    }
    return (FragmentActivity)this.cJ.getActivity();
  }
  
  public final void J()
  {
    this.cX = true;
    if (this.cJ == null) {}
    for (Activity localActivity = null;; localActivity = this.cJ.getActivity())
    {
      if (localActivity != null)
      {
        this.cX = false;
        this.cX = true;
      }
      return;
    }
  }
  
  public final Object K()
  {
    if (this.de == null) {
      return null;
    }
    return l.a(this.de);
  }
  
  public final Object L()
  {
    if (this.de == null) {
      return null;
    }
    if (l.b(this.de) == cr) {
      return K();
    }
    return l.b(this.de);
  }
  
  public final Object M()
  {
    if (this.de == null) {
      return null;
    }
    return l.c(this.de);
  }
  
  public final Object N()
  {
    if (this.de == null) {
      return null;
    }
    if (l.d(this.de) == cr) {
      return M();
    }
    return l.d(this.de);
  }
  
  public final Object O()
  {
    if (this.de == null) {
      return null;
    }
    return l.e(this.de);
  }
  
  public final Object P()
  {
    if (this.de == null) {
      return null;
    }
    if (l.f(this.de) == cr) {
      return O();
    }
    return l.f(this.de);
  }
  
  final View S()
  {
    if (this.cK != null) {
      this.cK.noteStateNotSaved();
    }
    this.cG = true;
    return null;
  }
  
  final void T()
  {
    if (this.cK != null)
    {
      this.cK.noteStateNotSaved();
      this.cK.execPendingActions();
    }
    this.cs = 4;
    this.cX = false;
    onStart();
    if (!this.cX) {
      throw new bc("Fragment " + this + " did not call through to super.onStart()");
    }
    if (this.cK != null) {
      this.cK.dispatchStart();
    }
    this.dk.a(f.ON_START);
  }
  
  final void U()
  {
    if (this.cK != null)
    {
      this.cK.noteStateNotSaved();
      this.cK.execPendingActions();
    }
    this.cs = 5;
    this.cX = false;
    this.cX = true;
    if (!this.cX) {
      throw new bc("Fragment " + this + " did not call through to super.onResume()");
    }
    if (this.cK != null)
    {
      this.cK.dispatchResume();
      this.cK.execPendingActions();
    }
    this.dk.a(f.ON_RESUME);
  }
  
  final void V()
  {
    onLowMemory();
    if (this.cK != null) {
      this.cK.dispatchLowMemory();
    }
  }
  
  final int X()
  {
    if (this.de == null) {
      return 0;
    }
    return this.de.dp;
  }
  
  final int Y()
  {
    if (this.de == null) {
      return 0;
    }
    return this.de.dq;
  }
  
  final int Z()
  {
    if (this.de == null) {
      return 0;
    }
    return this.de.dr;
  }
  
  final Fragment a(String paramString)
  {
    if (paramString.equals(this.cw)) {
      return this;
    }
    if (this.cK != null) {
      return this.cK.a(paramString);
    }
    return null;
  }
  
  final LayoutInflater a(Bundle paramBundle)
  {
    this.di = onGetLayoutInflater(paramBundle);
    return this.di;
  }
  
  final void a(int paramInt1, int paramInt2)
  {
    if ((this.de == null) && (paramInt1 == 0) && (paramInt2 == 0)) {
      return;
    }
    W();
    this.de.dq = paramInt1;
    this.de.dr = paramInt2;
  }
  
  final void a(int paramInt, Fragment paramFragment)
  {
    this.bL = paramInt;
    if (paramFragment != null)
    {
      this.cw = (paramFragment.cw + ":" + this.bL);
      return;
    }
    this.cw = ("android:fragment:" + this.bL);
  }
  
  final void a(Animator paramAnimator)
  {
    W().dn = paramAnimator;
  }
  
  final void a(Configuration paramConfiguration)
  {
    onConfigurationChanged(paramConfiguration);
    if (this.cK != null) {
      this.cK.dispatchConfigurationChanged(paramConfiguration);
    }
  }
  
  final boolean a(Menu paramMenu)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    if (!this.cR)
    {
      boolean bool1 = bool3;
      if (this.cV)
      {
        bool1 = bool3;
        if (this.cW) {
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (this.cK != null) {
        bool2 = bool1 | this.cK.dispatchPrepareOptionsMenu(paramMenu);
      }
    }
    return bool2;
  }
  
  final boolean a(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    if (!this.cR)
    {
      boolean bool1 = bool3;
      if (this.cV)
      {
        bool1 = bool3;
        if (this.cW) {
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (this.cK != null) {
        bool2 = bool1 | this.cK.dispatchCreateOptionsMenu(paramMenu, paramMenuInflater);
      }
    }
    return bool2;
  }
  
  final boolean a(MenuItem paramMenuItem)
  {
    return (!this.cR) && (this.cK != null) && (this.cK.dispatchOptionsItemSelected(paramMenuItem));
  }
  
  final bb aa()
  {
    if (this.de == null) {
      return null;
    }
    return this.de.dA;
  }
  
  final bb ab()
  {
    if (this.de == null) {
      return null;
    }
    return this.de.dB;
  }
  
  final View ac()
  {
    if (this.de == null) {
      return null;
    }
    return this.de.dm;
  }
  
  final Animator ad()
  {
    if (this.de == null) {
      return null;
    }
    return this.de.dn;
  }
  
  final int ae()
  {
    if (this.de == null) {
      return 0;
    }
    return this.de.jdField_do;
  }
  
  final boolean af()
  {
    if (this.de == null) {
      return false;
    }
    return this.de.dE;
  }
  
  final void b(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getParcelable("android:support:fragments");
      if (paramBundle != null)
      {
        if (this.cK == null) {
          R();
        }
        this.cK.a(paramBundle, this.cL);
        this.cL = null;
        this.cK.dispatchCreate();
      }
    }
  }
  
  final void b(n paramn)
  {
    W();
    if (paramn == this.de.dD) {}
    do
    {
      return;
      if ((paramn != null) && (this.de.dD != null)) {
        throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on ".concat(String.valueOf(this)));
      }
      if (this.de.dC) {
        this.de.dD = paramn;
      }
    } while (paramn == null);
    paramn.startListening();
  }
  
  final void b(Menu paramMenu)
  {
    if ((!this.cR) && (this.cK != null)) {
      this.cK.dispatchOptionsMenuClosed(paramMenu);
    }
  }
  
  final void b(View paramView)
  {
    W().dm = paramView;
  }
  
  final boolean b(MenuItem paramMenuItem)
  {
    return (!this.cR) && (this.cK != null) && (this.cK.dispatchContextItemSelected(paramMenuItem));
  }
  
  final void c(Bundle paramBundle)
  {
    if (this.cK != null) {
      this.cK.noteStateNotSaved();
    }
    this.cs = 1;
    this.cX = false;
    onCreate(paramBundle);
    this.dj = true;
    if (!this.cX) {
      throw new bc("Fragment " + this + " did not call through to super.onCreate()");
    }
    this.dk.a(f.ON_CREATE);
  }
  
  final void d(Bundle paramBundle)
  {
    if (this.cK != null) {
      this.cK.noteStateNotSaved();
    }
    this.cs = 2;
    this.cX = false;
    onActivityCreated(paramBundle);
    if (!this.cX) {
      throw new bc("Fragment " + this + " did not call through to super.onActivityCreated()");
    }
    if (this.cK != null) {
      this.cK.dispatchActivityCreated();
    }
  }
  
  final void d(boolean paramBoolean)
  {
    if (this.cK != null) {
      this.cK.dispatchMultiWindowModeChanged(paramBoolean);
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mFragmentId=#");
    paramPrintWriter.print(Integer.toHexString(this.cO));
    paramPrintWriter.print(" mContainerId=#");
    paramPrintWriter.print(Integer.toHexString(this.cP));
    paramPrintWriter.print(" mTag=");
    paramPrintWriter.println(this.cQ);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mState=");
    paramPrintWriter.print(this.cs);
    paramPrintWriter.print(" mIndex=");
    paramPrintWriter.print(this.bL);
    paramPrintWriter.print(" mWho=");
    paramPrintWriter.print(this.cw);
    paramPrintWriter.print(" mBackStackNesting=");
    paramPrintWriter.println(this.cH);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mAdded=");
    paramPrintWriter.print(this.cB);
    paramPrintWriter.print(" mRemoving=");
    paramPrintWriter.print(this.cC);
    paramPrintWriter.print(" mFromLayout=");
    paramPrintWriter.print(this.cD);
    paramPrintWriter.print(" mInLayout=");
    paramPrintWriter.println(this.cE);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mHidden=");
    paramPrintWriter.print(this.cR);
    paramPrintWriter.print(" mDetached=");
    paramPrintWriter.print(this.cS);
    paramPrintWriter.print(" mMenuVisible=");
    paramPrintWriter.print(this.cW);
    paramPrintWriter.print(" mHasMenu=");
    paramPrintWriter.println(this.cV);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mRetainInstance=");
    paramPrintWriter.print(this.cT);
    paramPrintWriter.print(" mRetaining=");
    paramPrintWriter.print(this.cU);
    paramPrintWriter.print(" mUserVisibleHint=");
    paramPrintWriter.println(this.dc);
    if (this.cI != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mFragmentManager=");
      paramPrintWriter.println(this.cI);
    }
    if (this.cJ != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mHost=");
      paramPrintWriter.println(this.cJ);
    }
    if (this.cN != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mParentFragment=");
      paramPrintWriter.println(this.cN);
    }
    if (this.cx != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mArguments=");
      paramPrintWriter.println(this.cx);
    }
    if (this.ct != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedFragmentState=");
      paramPrintWriter.println(this.ct);
    }
    if (this.cu != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedViewState=");
      paramPrintWriter.println(this.cu);
    }
    if (this.cy != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mTarget=");
      paramPrintWriter.print(this.cy);
      paramPrintWriter.print(" mTargetRequestCode=");
      paramPrintWriter.println(this.cA);
    }
    if (X() != 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mNextAnim=");
      paramPrintWriter.println(X());
    }
    if (this.cY != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mContainer=");
      paramPrintWriter.println(this.cY);
    }
    if (this.cZ != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mView=");
      paramPrintWriter.println(this.cZ);
    }
    if (this.da != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mInnerView=");
      paramPrintWriter.println(this.cZ);
    }
    if (ac() != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAnimatingAway=");
      paramPrintWriter.println(ac());
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStateAfterAnimating=");
      paramPrintWriter.println(ae());
    }
    if (this.dd != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Loader Manager:");
      this.dd.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    if (this.cK != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Child " + this.cK + ":");
      this.cK.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  final void e(boolean paramBoolean)
  {
    if (this.cK != null) {
      this.cK.dispatchPictureInPictureModeChanged(paramBoolean);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  final void f(boolean paramBoolean)
  {
    W().dE = paramBoolean;
  }
  
  public final boolean getAllowEnterTransitionOverlap()
  {
    if ((this.de == null) || (l.g(this.de) == null)) {
      return true;
    }
    return l.g(this.de).booleanValue();
  }
  
  public final boolean getAllowReturnTransitionOverlap()
  {
    if ((this.de == null) || (l.h(this.de) == null)) {
      return true;
    }
    return l.h(this.de).booleanValue();
  }
  
  public final android.arch.lifecycle.e h()
  {
    return this.dk;
  }
  
  public final int hashCode()
  {
    return super.hashCode();
  }
  
  public final boolean isRemoving()
  {
    return this.cC;
  }
  
  final void n(int paramInt)
  {
    if ((this.de == null) && (paramInt == 0)) {
      return;
    }
    W().dp = paramInt;
  }
  
  final void noteStateNotSaved()
  {
    if (this.cK != null) {
      this.cK.noteStateNotSaved();
    }
  }
  
  final void o(int paramInt)
  {
    W().jdField_do = paramInt;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    this.cX = true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onAttach(Context paramContext)
  {
    this.cX = true;
    if (this.cJ == null) {}
    for (paramContext = null;; paramContext = this.cJ.getActivity())
    {
      if (paramContext != null)
      {
        this.cX = false;
        this.cX = true;
      }
      return;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.cX = true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 1;
    this.cX = true;
    b(paramBundle);
    if (this.cK != null) {
      if (this.cK.eh <= 0) {
        break label41;
      }
    }
    for (;;)
    {
      if (i == 0) {
        this.cK.dispatchCreate();
      }
      return;
      label41:
      i = 0;
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    I().onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }
  
  public void onDestroy()
  {
    this.cX = true;
    if ((this.cM != null) && (!this.cJ.cI.en)) {
      this.cM.clear();
    }
  }
  
  public void onDestroyView()
  {
    this.cX = true;
  }
  
  public void onDetach()
  {
    this.cX = true;
  }
  
  public LayoutInflater onGetLayoutInflater(Bundle paramBundle)
  {
    if (this.cJ == null) {
      throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }
    paramBundle = this.cJ.onGetLayoutInflater();
    if (this.cK == null)
    {
      R();
      if (this.cs < 5) {
        break label62;
      }
      this.cK.dispatchResume();
    }
    for (;;)
    {
      android.support.v4.view.e.b(paramBundle, this.cK);
      return paramBundle;
      label62:
      if (this.cs >= 4) {
        this.cK.dispatchStart();
      } else if (this.cs >= 2) {
        this.cK.dispatchActivityCreated();
      } else if (this.cs > 0) {
        this.cK.dispatchCreate();
      }
    }
  }
  
  public void onLowMemory()
  {
    this.cX = true;
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onStart()
  {
    this.cX = true;
  }
  
  public void onStop()
  {
    this.cX = true;
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if (this.cJ == null) {
      throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }
    this.cJ.a(this, paramIntent, paramInt, null);
  }
  
  public final void startPostponedEnterTransition()
  {
    if ((this.cI == null) || (this.cI.cJ == null))
    {
      W().dC = false;
      return;
    }
    if (Looper.myLooper() != this.cI.cJ.getHandler().getLooper())
    {
      this.cI.cJ.getHandler().postAtFrontOfQueue(new Runnable()
      {
        public final void run()
        {
          Fragment.d(Fragment.this);
        }
      });
      return;
    }
    Q();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    d.a(this, localStringBuilder);
    if (this.bL >= 0)
    {
      localStringBuilder.append(" #");
      localStringBuilder.append(this.bL);
    }
    if (this.cO != 0)
    {
      localStringBuilder.append(" id=0x");
      localStringBuilder.append(Integer.toHexString(this.cO));
    }
    if (this.cQ != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(this.cQ);
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.Fragment
 * JD-Core Version:    0.7.0.1
 */