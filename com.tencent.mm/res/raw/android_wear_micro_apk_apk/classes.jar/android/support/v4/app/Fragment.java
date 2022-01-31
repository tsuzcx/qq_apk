package android.support.v4.app;

import android.animation.Animator;
import android.app.Activity;
import android.arch.lifecycle.b;
import android.arch.lifecycle.c;
import android.arch.lifecycle.f;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.b.d;
import android.support.v4.b.q;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Fragment
  implements android.arch.lifecycle.e, ComponentCallbacks, View.OnCreateContextMenuListener
{
  private static final q<String, Class<?>> aH = new q();
  static final Object aI = new Object();
  int aJ = 0;
  Bundle aK;
  SparseArray<Parcelable> aL;
  String aM;
  Bundle aN;
  Fragment aO;
  int aP = -1;
  int aQ;
  boolean aR;
  boolean aS;
  boolean aT;
  boolean aU;
  boolean aV;
  boolean aW;
  int aX;
  t aY;
  r aZ;
  int ac = -1;
  boolean bA;
  f bB = new f(this);
  t ba;
  ac bb;
  Fragment bc;
  int bd;
  int be;
  String bf;
  boolean bg;
  boolean bh;
  boolean bi;
  boolean bj;
  boolean bk;
  boolean bl = true;
  boolean bm;
  ViewGroup bn;
  View bo;
  View bp;
  boolean bq;
  boolean br = true;
  ak bs;
  boolean bt;
  boolean bu;
  k bv;
  boolean bw;
  boolean bx;
  float by;
  LayoutInflater bz;
  
  private void A()
  {
    m localm = null;
    if (this.bv == null) {}
    for (;;)
    {
      if (localm != null) {
        localm.Q();
      }
      return;
      this.bv.bT = false;
      localm = this.bv.bU;
      this.bv.bU = null;
    }
  }
  
  private void B()
  {
    if (this.aZ == null) {
      throw new IllegalStateException("Fragment has not been attached yet.");
    }
    this.ba = new t();
    this.ba.a(this.aZ, new p()
    {
      public final Fragment a(Context paramAnonymousContext, String paramAnonymousString, Bundle paramAnonymousBundle)
      {
        return Fragment.this.aZ.a(paramAnonymousContext, paramAnonymousString, paramAnonymousBundle);
      }
      
      public final View onFindViewById(int paramAnonymousInt)
      {
        if (Fragment.this.bo == null) {
          throw new IllegalStateException("Fragment does not have a view");
        }
        return Fragment.this.bo.findViewById(paramAnonymousInt);
      }
      
      public final boolean onHasView()
      {
        return Fragment.this.bo != null;
      }
    }, this);
  }
  
  private k G()
  {
    if (this.bv == null) {
      this.bv = new k();
    }
    return this.bv;
  }
  
  public static Fragment a(Context paramContext, String paramString, Bundle paramBundle)
  {
    bool = false;
    try
    {
      Class localClass2 = (Class)aH.get(paramString);
      Class localClass1 = localClass2;
      if (localClass2 == null)
      {
        localClass1 = paramContext.getClassLoader().loadClass(paramString);
        aH.put(paramString, localClass1);
      }
      paramContext = (Fragment)localClass1.getConstructor(new Class[0]).newInstance(new Object[0]);
      if (paramBundle == null) {
        break label153;
      }
      paramBundle.setClassLoader(paramContext.getClass().getClassLoader());
      if (paramContext.ac < 0) {
        break label148;
      }
      if (paramContext.aY != null) {
        break label137;
      }
    }
    catch (ClassNotFoundException paramContext)
    {
      for (;;)
      {
        throw new l("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an empty constructor that is public", paramContext);
        bool = paramContext.aY.cE;
      }
      paramContext.aN = paramBundle;
      return paramContext;
    }
    catch (InstantiationException paramContext)
    {
      throw new l("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an empty constructor that is public", paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      throw new l("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an empty constructor that is public", paramContext);
    }
    catch (NoSuchMethodException paramContext)
    {
      throw new l("Unable to instantiate fragment " + paramString + ": could not find Fragment constructor", paramContext);
    }
    catch (InvocationTargetException paramContext)
    {
      throw new l("Unable to instantiate fragment " + paramString + ": calling Fragment constructor caused an exception", paramContext);
    }
    if (bool) {
      throw new IllegalStateException("Fragment already active and state has been saved");
    }
  }
  
  static boolean a(Context paramContext, String paramString)
  {
    try
    {
      Class localClass2 = (Class)aH.get(paramString);
      Class localClass1 = localClass2;
      if (localClass2 == null)
      {
        localClass1 = paramContext.getClassLoader().loadClass(paramString);
        aH.put(paramString, localClass1);
      }
      boolean bool = Fragment.class.isAssignableFrom(localClass1);
      return bool;
    }
    catch (ClassNotFoundException paramContext) {}
    return false;
  }
  
  public static void onDestroyOptionsMenu() {}
  
  public static void q() {}
  
  public static void r() {}
  
  public static void t() {}
  
  public static Animation u()
  {
    return null;
  }
  
  public static Animator v()
  {
    return null;
  }
  
  public static void w() {}
  
  final View C()
  {
    if (this.ba != null) {
      this.ba.noteStateNotSaved();
    }
    this.aW = true;
    return null;
  }
  
  final void D()
  {
    if (this.ba != null)
    {
      this.ba.noteStateNotSaved();
      this.ba.execPendingActions();
    }
    this.aJ = 4;
    this.bm = false;
    onStart();
    if (!this.bm) {
      throw new ce("Fragment " + this + " did not call through to super.onStart()");
    }
    if (this.ba != null) {
      this.ba.dispatchStart();
    }
    if (this.bs != null) {
      this.bs.aw();
    }
    this.bB.a(c.ON_START);
  }
  
  final void E()
  {
    if (this.ba != null)
    {
      this.ba.noteStateNotSaved();
      this.ba.execPendingActions();
    }
    this.aJ = 5;
    this.bm = false;
    this.bm = true;
    if (!this.bm) {
      throw new ce("Fragment " + this + " did not call through to super.onResume()");
    }
    if (this.ba != null)
    {
      this.ba.dispatchResume();
      this.ba.execPendingActions();
    }
    this.bB.a(c.ON_RESUME);
  }
  
  final void F()
  {
    if (this.ba != null) {
      this.ba.W();
    }
    this.aJ = 2;
    if (this.bt)
    {
      this.bt = false;
      if (!this.bu)
      {
        this.bu = true;
        this.bs = this.aZ.a(this.aM, this.bt);
      }
      if (this.bs != null)
      {
        if (!this.aZ.Y()) {
          break label87;
        }
        this.bs.au();
      }
    }
    return;
    label87:
    this.bs.at();
  }
  
  final int H()
  {
    if (this.bv == null) {
      return 0;
    }
    return this.bv.bG;
  }
  
  final int I()
  {
    if (this.bv == null) {
      return 0;
    }
    return this.bv.bH;
  }
  
  final int J()
  {
    if (this.bv == null) {
      return 0;
    }
    return this.bv.bI;
  }
  
  final cd K()
  {
    if (this.bv == null) {
      return null;
    }
    return this.bv.bR;
  }
  
  final cd L()
  {
    if (this.bv == null) {
      return null;
    }
    return this.bv.bS;
  }
  
  final View M()
  {
    if (this.bv == null) {
      return null;
    }
    return this.bv.bD;
  }
  
  final Animator N()
  {
    if (this.bv == null) {
      return null;
    }
    return this.bv.bE;
  }
  
  final int O()
  {
    if (this.bv == null) {
      return 0;
    }
    return this.bv.bF;
  }
  
  final boolean P()
  {
    if (this.bv == null) {
      return false;
    }
    return this.bv.bV;
  }
  
  final LayoutInflater a(Bundle paramBundle)
  {
    this.bz = onGetLayoutInflater(paramBundle);
    return this.bz;
  }
  
  final void a(int paramInt1, int paramInt2)
  {
    if ((this.bv == null) && (paramInt1 == 0) && (paramInt2 == 0)) {
      return;
    }
    G();
    this.bv.bH = paramInt1;
    this.bv.bI = paramInt2;
  }
  
  final void a(int paramInt, Fragment paramFragment)
  {
    this.ac = paramInt;
    if (paramFragment != null)
    {
      this.aM = (paramFragment.aM + ":" + this.ac);
      return;
    }
    this.aM = ("android:fragment:" + this.ac);
  }
  
  final void a(Animator paramAnimator)
  {
    G().bE = paramAnimator;
  }
  
  final void a(View paramView)
  {
    G().bD = paramView;
  }
  
  final void b(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getParcelable("android:support:fragments");
      if (paramBundle != null)
      {
        if (this.ba == null) {
          B();
        }
        this.ba.a(paramBundle, this.bb);
        this.bb = null;
        this.ba.dispatchCreate();
      }
    }
  }
  
  final void b(m paramm)
  {
    G();
    if (paramm == this.bv.bU) {}
    do
    {
      return;
      if ((paramm != null) && (this.bv.bU != null)) {
        throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
      }
      if (this.bv.bT) {
        this.bv.bU = paramm;
      }
    } while (paramm == null);
    paramm.startListening();
  }
  
  final void c(Bundle paramBundle)
  {
    if (this.ba != null) {
      this.ba.noteStateNotSaved();
    }
    this.aJ = 1;
    this.bm = false;
    onCreate(paramBundle);
    this.bA = true;
    if (!this.bm) {
      throw new ce("Fragment " + this + " did not call through to super.onCreate()");
    }
    this.bB.a(c.ON_CREATE);
  }
  
  final void c(boolean paramBoolean)
  {
    G().bV = paramBoolean;
  }
  
  public final b d()
  {
    return this.bB;
  }
  
  final void d(Bundle paramBundle)
  {
    if (this.ba != null) {
      this.ba.noteStateNotSaved();
    }
    this.aJ = 2;
    this.bm = false;
    onActivityCreated(paramBundle);
    if (!this.bm) {
      throw new ce("Fragment " + this + " did not call through to super.onActivityCreated()");
    }
    if (this.ba != null) {
      this.ba.dispatchActivityCreated();
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mFragmentId=#");
    paramPrintWriter.print(Integer.toHexString(this.bd));
    paramPrintWriter.print(" mContainerId=#");
    paramPrintWriter.print(Integer.toHexString(this.be));
    paramPrintWriter.print(" mTag=");
    paramPrintWriter.println(this.bf);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mState=");
    paramPrintWriter.print(this.aJ);
    paramPrintWriter.print(" mIndex=");
    paramPrintWriter.print(this.ac);
    paramPrintWriter.print(" mWho=");
    paramPrintWriter.print(this.aM);
    paramPrintWriter.print(" mBackStackNesting=");
    paramPrintWriter.println(this.aX);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mAdded=");
    paramPrintWriter.print(this.aR);
    paramPrintWriter.print(" mRemoving=");
    paramPrintWriter.print(this.aS);
    paramPrintWriter.print(" mFromLayout=");
    paramPrintWriter.print(this.aT);
    paramPrintWriter.print(" mInLayout=");
    paramPrintWriter.println(this.aU);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mHidden=");
    paramPrintWriter.print(this.bg);
    paramPrintWriter.print(" mDetached=");
    paramPrintWriter.print(this.bh);
    paramPrintWriter.print(" mMenuVisible=");
    paramPrintWriter.print(this.bl);
    paramPrintWriter.print(" mHasMenu=");
    paramPrintWriter.println(this.bk);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mRetainInstance=");
    paramPrintWriter.print(this.bi);
    paramPrintWriter.print(" mRetaining=");
    paramPrintWriter.print(this.bj);
    paramPrintWriter.print(" mUserVisibleHint=");
    paramPrintWriter.println(this.br);
    if (this.aY != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mFragmentManager=");
      paramPrintWriter.println(this.aY);
    }
    if (this.aZ != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mHost=");
      paramPrintWriter.println(this.aZ);
    }
    if (this.bc != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mParentFragment=");
      paramPrintWriter.println(this.bc);
    }
    if (this.aN != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mArguments=");
      paramPrintWriter.println(this.aN);
    }
    if (this.aK != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedFragmentState=");
      paramPrintWriter.println(this.aK);
    }
    if (this.aL != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedViewState=");
      paramPrintWriter.println(this.aL);
    }
    if (this.aO != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mTarget=");
      paramPrintWriter.print(this.aO);
      paramPrintWriter.print(" mTargetRequestCode=");
      paramPrintWriter.println(this.aQ);
    }
    if (H() != 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mNextAnim=");
      paramPrintWriter.println(H());
    }
    if (this.bn != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mContainer=");
      paramPrintWriter.println(this.bn);
    }
    if (this.bo != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mView=");
      paramPrintWriter.println(this.bo);
    }
    if (this.bp != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mInnerView=");
      paramPrintWriter.println(this.bo);
    }
    if (M() != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAnimatingAway=");
      paramPrintWriter.println(M());
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStateAfterAnimating=");
      paramPrintWriter.println(O());
    }
    if (this.bs != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Loader Manager:");
      this.bs.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    if (this.ba != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Child " + this.ba + ":");
      this.ba.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  final void e(int paramInt)
  {
    if ((this.bv == null) && (paramInt == 0)) {
      return;
    }
    G().bG = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  final void f(int paramInt)
  {
    G().bF = paramInt;
  }
  
  public final int hashCode()
  {
    return super.hashCode();
  }
  
  public final boolean isRemoving()
  {
    return this.aS;
  }
  
  final boolean k()
  {
    if (this.bv == null) {
      return false;
    }
    return this.bv.bT;
  }
  
  final boolean n()
  {
    return this.aX > 0;
  }
  
  public final FragmentActivity o()
  {
    if (this.aZ == null) {
      return null;
    }
    return (FragmentActivity)this.aZ.getActivity();
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    this.bm = true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onAttach(Context paramContext)
  {
    this.bm = true;
    if (this.aZ == null) {}
    for (paramContext = null;; paramContext = this.aZ.getActivity())
    {
      if (paramContext != null)
      {
        this.bm = false;
        this.bm = true;
      }
      return;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.bm = true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 1;
    this.bm = true;
    b(paramBundle);
    if (this.ba != null) {
      if (this.ba.cy <= 0) {
        break label41;
      }
    }
    for (;;)
    {
      if (i == 0) {
        this.ba.dispatchCreate();
      }
      return;
      label41:
      i = 0;
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    o().onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }
  
  public void onDestroy()
  {
    this.bm = true;
    if (!this.bu)
    {
      this.bu = true;
      this.bs = this.aZ.a(this.aM, this.bt);
    }
    if (this.bs != null) {
      this.bs.ax();
    }
  }
  
  public void onDestroyView()
  {
    this.bm = true;
  }
  
  public void onDetach()
  {
    this.bm = true;
  }
  
  public LayoutInflater onGetLayoutInflater(Bundle paramBundle)
  {
    if (this.aZ == null) {
      throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }
    paramBundle = this.aZ.onGetLayoutInflater();
    p();
    android.support.v4.view.e.b(paramBundle, this.ba);
    return paramBundle;
  }
  
  public void onLowMemory()
  {
    this.bm = true;
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onStart()
  {
    this.bm = true;
    if (!this.bt)
    {
      this.bt = true;
      if (this.bu) {
        break label49;
      }
      this.bu = true;
      this.bs = this.aZ.a(this.aM, this.bt);
    }
    label49:
    while (this.bs == null) {
      return;
    }
    this.bs.as();
  }
  
  public void onStop()
  {
    this.bm = true;
  }
  
  public final s p()
  {
    if (this.ba == null)
    {
      B();
      if (this.aJ < 5) {
        break label31;
      }
      this.ba.dispatchResume();
    }
    for (;;)
    {
      return this.ba;
      label31:
      if (this.aJ >= 4) {
        this.ba.dispatchStart();
      } else if (this.aJ >= 2) {
        this.ba.dispatchActivityCreated();
      } else if (this.aJ > 0) {
        this.ba.dispatchCreate();
      }
    }
  }
  
  public final void s()
  {
    this.bm = true;
    if (this.aZ == null) {}
    for (Activity localActivity = null;; localActivity = this.aZ.getActivity())
    {
      if (localActivity != null)
      {
        this.bm = false;
        this.bm = true;
      }
      return;
    }
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if (this.aZ == null) {
      throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }
    this.aZ.a(this, paramIntent, paramInt, null);
  }
  
  public final void startPostponedEnterTransition()
  {
    if ((this.aY == null) || (this.aY.aZ == null))
    {
      G().bT = false;
      return;
    }
    if (Looper.myLooper() != this.aY.aZ.getHandler().getLooper())
    {
      this.aY.aZ.getHandler().postAtFrontOfQueue(new Runnable()
      {
        public final void run()
        {
          Fragment.d(Fragment.this);
        }
      });
      return;
    }
    A();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    d.a(this, localStringBuilder);
    if (this.ac >= 0)
    {
      localStringBuilder.append(" #");
      localStringBuilder.append(this.ac);
    }
    if (this.bd != 0)
    {
      localStringBuilder.append(" id=0x");
      localStringBuilder.append(Integer.toHexString(this.bd));
    }
    if (this.bf != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(this.bf);
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public final Object x()
  {
    if (this.bv == null) {
      return null;
    }
    return k.a(this.bv);
  }
  
  public final Object y()
  {
    if (this.bv == null) {
      return null;
    }
    return k.c(this.bv);
  }
  
  public final Object z()
  {
    if (this.bv == null) {
      return null;
    }
    return k.e(this.bv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.Fragment
 * JD-Core Version:    0.7.0.1
 */