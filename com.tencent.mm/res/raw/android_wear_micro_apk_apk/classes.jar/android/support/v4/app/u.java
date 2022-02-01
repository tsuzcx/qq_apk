package android.support.v4.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.arch.lifecycle.f;
import android.arch.lifecycle.j;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.b.b;
import android.support.v4.b.d;
import android.support.v4.b.m;
import android.support.v4.view.r;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class u
  extends t
  implements LayoutInflater.Factory2
{
  static boolean DEBUG = false;
  static final Interpolator eA = new DecelerateInterpolator(1.5F);
  static final Interpolator eB = new AccelerateInterpolator(2.5F);
  static final Interpolator eC = new AccelerateInterpolator(1.5F);
  static Field el = null;
  static final Interpolator ez = new DecelerateInterpolator(2.5F);
  s cJ;
  boolean dL;
  ArrayList<ab> dW;
  boolean dX;
  int dY = 0;
  final ArrayList<Fragment> dZ = new ArrayList();
  SparseArray<Fragment> ea;
  ArrayList<e> eb;
  ArrayList<Fragment> ec;
  ArrayList<e> ed;
  ArrayList<Integer> ee;
  ArrayList<Object> ef;
  private final CopyOnWriteArrayList<m<Object, Boolean>> eg = new CopyOnWriteArrayList();
  int eh = 0;
  q ei;
  Fragment ej;
  Fragment ek;
  boolean em;
  boolean en;
  boolean eo;
  String ep;
  boolean eq;
  ArrayList<e> er;
  ArrayList<Boolean> es;
  ArrayList<Fragment> et;
  Bundle eu = null;
  SparseArray<Parcelable> ev = null;
  ArrayList<ad> ew;
  ae ex;
  Runnable ey = new Runnable()
  {
    public final void run()
    {
      u.this.execPendingActions();
    }
  };
  
  private int a(ArrayList<e> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2, b<Fragment> paramb)
  {
    int j = paramInt2 - 1;
    int i = paramInt2;
    e locale;
    int k;
    if (j >= paramInt1)
    {
      locale = (e)paramArrayList.get(j);
      boolean bool = ((Boolean)paramArrayList1.get(j)).booleanValue();
      if ((locale.E()) && (!locale.a(paramArrayList, j + 1, paramInt2)))
      {
        k = 1;
        label67:
        if (k == 0) {
          break label191;
        }
        if (this.ew == null) {
          this.ew = new ArrayList();
        }
        ad localad = new ad(locale, bool);
        this.ew.add(localad);
        locale.a(localad);
        if (!bool) {
          break label179;
        }
        locale.D();
        label130:
        i -= 1;
        if (j != i)
        {
          paramArrayList.remove(j);
          paramArrayList.add(i, locale);
        }
        b(paramb);
      }
    }
    label179:
    label191:
    for (;;)
    {
      j -= 1;
      break;
      k = 0;
      break label67;
      locale.c(false);
      break label130;
      return i;
    }
  }
  
  private static x a(float paramFloat1, float paramFloat2)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat1, paramFloat2);
    localAlphaAnimation.setInterpolator(eA);
    localAlphaAnimation.setDuration(220L);
    return new x(localAlphaAnimation, (byte)0);
  }
  
  private static x a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    Object localObject = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setInterpolator(ez);
    ((ScaleAnimation)localObject).setDuration(220L);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(paramFloat3, paramFloat4);
    ((AlphaAnimation)localObject).setInterpolator(eA);
    ((AlphaAnimation)localObject).setDuration(220L);
    localAnimationSet.addAnimation((Animation)localObject);
    return new x(localAnimationSet, (byte)0);
  }
  
  private x a(Fragment paramFragment, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    int j = paramFragment.X();
    if (j != 0)
    {
      boolean bool = "anim".equals(this.cJ.mContext.getResources().getResourceTypeName(j));
      if (bool) {}
      for (;;)
      {
        try
        {
          paramFragment = AnimationUtils.loadAnimation(this.cJ.mContext, j);
          if (paramFragment != null)
          {
            paramFragment = new x(paramFragment, (byte)0);
            return paramFragment;
          }
          i = 1;
          if (i != 0) {
            break label149;
          }
          try
          {
            paramFragment = AnimatorInflater.loadAnimator(this.cJ.mContext, j);
            if (paramFragment == null) {
              break label149;
            }
            paramFragment = new x(paramFragment, (byte)0);
            return paramFragment;
          }
          catch (RuntimeException paramFragment)
          {
            if (!bool) {
              break;
            }
          }
          throw paramFragment;
        }
        catch (Resources.NotFoundException paramFragment)
        {
          throw paramFragment;
        }
        catch (RuntimeException paramFragment) {}
        i = 0;
      }
      paramFragment = AnimationUtils.loadAnimation(this.cJ.mContext, j);
      if (paramFragment != null) {
        return new x(paramFragment, (byte)0);
      }
    }
    label149:
    if (paramInt1 == 0) {
      return null;
    }
    int i = -1;
    switch (paramInt1)
    {
    default: 
      paramInt1 = i;
    }
    while (paramInt1 < 0)
    {
      return null;
      if (paramBoolean)
      {
        paramInt1 = 1;
      }
      else
      {
        paramInt1 = 2;
        continue;
        if (paramBoolean)
        {
          paramInt1 = 3;
        }
        else
        {
          paramInt1 = 4;
          continue;
          if (paramBoolean) {
            paramInt1 = 5;
          } else {
            paramInt1 = 6;
          }
        }
      }
    }
    switch (paramInt1)
    {
    default: 
      paramInt1 = paramInt2;
      if (paramInt2 == 0)
      {
        paramInt1 = paramInt2;
        if (this.cJ.onHasWindowAnimations()) {
          paramInt1 = this.cJ.onGetWindowAnimations();
        }
      }
      if (paramInt1 == 0) {
        return null;
      }
      break;
    case 1: 
      return a(1.125F, 1.0F, 0.0F, 1.0F);
    case 2: 
      return a(1.0F, 0.975F, 1.0F, 0.0F);
    case 3: 
      return a(0.975F, 1.0F, 0.0F, 1.0F);
    case 4: 
      return a(1.0F, 1.075F, 1.0F, 0.0F);
    case 5: 
      return a(0.0F, 1.0F);
    case 6: 
      return a(1.0F, 0.0F);
    }
    return null;
  }
  
  private static Animation.AnimationListener a(Animation paramAnimation)
  {
    try
    {
      if (el == null)
      {
        Field localField = Animation.class.getDeclaredField("mListener");
        el = localField;
        localField.setAccessible(true);
      }
      paramAnimation = (Animation.AnimationListener)el.get(paramAnimation);
      return paramAnimation;
    }
    catch (NoSuchFieldException paramAnimation)
    {
      Log.e("FragmentManager", "No field with the name mListener is found in Animation class", paramAnimation);
      return null;
    }
    catch (IllegalAccessException paramAnimation)
    {
      Log.e("FragmentManager", "Cannot access Animation's mListener field", paramAnimation);
    }
    return null;
  }
  
  /* Error */
  private void a(int paramInt, e parame)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 324	android/support/v4/app/u:ed	Ljava/util/ArrayList;
    //   6: ifnonnull +14 -> 20
    //   9: aload_0
    //   10: new 108	java/util/ArrayList
    //   13: dup
    //   14: invokespecial 109	java/util/ArrayList:<init>	()V
    //   17: putfield 324	android/support/v4/app/u:ed	Ljava/util/ArrayList;
    //   20: aload_0
    //   21: getfield 324	android/support/v4/app/u:ed	Ljava/util/ArrayList;
    //   24: invokevirtual 327	java/util/ArrayList:size	()I
    //   27: istore 4
    //   29: iload 4
    //   31: istore_3
    //   32: iload_1
    //   33: iload 4
    //   35: if_icmpge +56 -> 91
    //   38: getstatic 80	android/support/v4/app/u:DEBUG	Z
    //   41: ifeq +37 -> 78
    //   44: ldc_w 311
    //   47: new 329	java/lang/StringBuilder
    //   50: dup
    //   51: ldc_w 331
    //   54: invokespecial 334	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   57: iload_1
    //   58: invokevirtual 338	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   61: ldc_w 340
    //   64: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_2
    //   68: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 350	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 354	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   77: pop
    //   78: aload_0
    //   79: getfield 324	android/support/v4/app/u:ed	Ljava/util/ArrayList;
    //   82: iload_1
    //   83: aload_2
    //   84: invokevirtual 358	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   87: pop
    //   88: aload_0
    //   89: monitorexit
    //   90: return
    //   91: iload_3
    //   92: iload_1
    //   93: if_icmpge +72 -> 165
    //   96: aload_0
    //   97: getfield 324	android/support/v4/app/u:ed	Ljava/util/ArrayList;
    //   100: aconst_null
    //   101: invokevirtual 158	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   104: pop
    //   105: aload_0
    //   106: getfield 360	android/support/v4/app/u:ee	Ljava/util/ArrayList;
    //   109: ifnonnull +14 -> 123
    //   112: aload_0
    //   113: new 108	java/util/ArrayList
    //   116: dup
    //   117: invokespecial 109	java/util/ArrayList:<init>	()V
    //   120: putfield 360	android/support/v4/app/u:ee	Ljava/util/ArrayList;
    //   123: getstatic 80	android/support/v4/app/u:DEBUG	Z
    //   126: ifeq +20 -> 146
    //   129: ldc_w 311
    //   132: ldc_w 362
    //   135: iload_3
    //   136: invokestatic 365	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   139: invokevirtual 369	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   142: invokestatic 354	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   145: pop
    //   146: aload_0
    //   147: getfield 360	android/support/v4/app/u:ee	Ljava/util/ArrayList;
    //   150: iload_3
    //   151: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   154: invokevirtual 158	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   157: pop
    //   158: iload_3
    //   159: iconst_1
    //   160: iadd
    //   161: istore_3
    //   162: goto -71 -> 91
    //   165: getstatic 80	android/support/v4/app/u:DEBUG	Z
    //   168: ifeq +37 -> 205
    //   171: ldc_w 311
    //   174: new 329	java/lang/StringBuilder
    //   177: dup
    //   178: ldc_w 376
    //   181: invokespecial 334	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   184: iload_1
    //   185: invokevirtual 338	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   188: ldc_w 378
    //   191: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload_2
    //   195: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 350	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 354	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   204: pop
    //   205: aload_0
    //   206: getfield 324	android/support/v4/app/u:ed	Ljava/util/ArrayList;
    //   209: aload_2
    //   210: invokevirtual 158	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   213: pop
    //   214: goto -126 -> 88
    //   217: astore_2
    //   218: aload_0
    //   219: monitorexit
    //   220: aload_2
    //   221: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	this	u
    //   0	222	1	paramInt	int
    //   0	222	2	parame	e
    //   31	131	3	i	int
    //   27	9	4	j	int
    // Exception table:
    //   from	to	target	type
    //   2	20	217	finally
    //   20	29	217	finally
    //   38	78	217	finally
    //   78	88	217	finally
    //   88	90	217	finally
    //   96	123	217	finally
    //   123	146	217	finally
    //   146	158	217	finally
    //   165	205	217	finally
    //   205	214	217	finally
    //   218	220	217	finally
  }
  
  private void a(Fragment paramFragment, Context paramContext, boolean paramBoolean)
  {
    if (this.ej != null)
    {
      u localu = this.ej.cI;
      if ((localu instanceof u)) {
        ((u)localu).a(paramFragment, paramContext, true);
      }
    }
    paramFragment = this.eg.iterator();
    while (paramFragment.hasNext())
    {
      paramContext = (m)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)paramContext.second).booleanValue();
      }
    }
  }
  
  private void a(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean)
  {
    if (this.ej != null)
    {
      u localu = this.ej.cI;
      if ((localu instanceof u)) {
        ((u)localu).a(paramFragment, paramBundle, true);
      }
    }
    paramFragment = this.eg.iterator();
    while (paramFragment.hasNext())
    {
      paramBundle = (m)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)paramBundle.second).booleanValue();
      }
    }
  }
  
  private void a(Fragment paramFragment, View paramView, Bundle paramBundle, boolean paramBoolean)
  {
    if (this.ej != null)
    {
      u localu = this.ej.cI;
      if ((localu instanceof u)) {
        ((u)localu).a(paramFragment, paramView, paramBundle, true);
      }
    }
    paramFragment = this.eg.iterator();
    while (paramFragment.hasNext())
    {
      paramView = (m)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)paramView.second).booleanValue();
      }
    }
  }
  
  private static void a(ae paramae)
  {
    if (paramae == null) {}
    for (;;)
    {
      return;
      Object localObject = paramae.getFragments();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Fragment)((Iterator)localObject).next()).cU = true;
        }
      }
      paramae = paramae.aE();
      if (paramae != null)
      {
        paramae = paramae.iterator();
        while (paramae.hasNext()) {
          a((ae)paramae.next());
        }
      }
    }
  }
  
  private static void a(b<Fragment> paramb)
  {
    int j = paramb.size();
    int i = 0;
    while (i < j)
    {
      Fragment localFragment = (Fragment)paramb.valueAt(i);
      if (!localFragment.cB)
      {
        View localView = localFragment.cZ;
        localFragment.dh = localView.getAlpha();
        localView.setAlpha(0.0F);
      }
      i += 1;
    }
  }
  
  private static void a(View paramView, x paramx)
  {
    int j = 0;
    if ((paramView == null) || (paramx == null)) {
      return;
    }
    int i = j;
    if (paramView != null)
    {
      if (paramx != null) {
        break label50;
      }
      i = j;
    }
    label23:
    label50:
    boolean bool;
    while (i != 0)
    {
      if (paramx.eM == null) {
        break label183;
      }
      paramx.eM.addListener(new y(paramView));
      return;
      i = j;
      if (Build.VERSION.SDK_INT >= 19)
      {
        i = j;
        if (paramView.getLayerType() == 0)
        {
          i = j;
          if (r.u(paramView))
          {
            if (!(paramx.eL instanceof AlphaAnimation)) {
              break label103;
            }
            bool = true;
          }
        }
      }
    }
    label165:
    for (;;)
    {
      i = j;
      if (!bool) {
        break label23;
      }
      i = 1;
      break label23;
      break;
      label103:
      if ((paramx.eL instanceof AnimationSet))
      {
        localObject = ((AnimationSet)paramx.eL).getAnimations();
        i = 0;
        for (;;)
        {
          if (i >= ((List)localObject).size()) {
            break label165;
          }
          if ((((List)localObject).get(i) instanceof AlphaAnimation))
          {
            bool = true;
            break;
          }
          i += 1;
        }
        bool = false;
      }
      else
      {
        bool = b(paramx.eM);
      }
    }
    label183:
    Object localObject = a(paramx.eL);
    paramView.setLayerType(2, null);
    paramx.eL.setAnimationListener(new v(paramView, (Animation.AnimationListener)localObject));
  }
  
  private void a(RuntimeException paramRuntimeException)
  {
    Log.e("FragmentManager", paramRuntimeException.getMessage());
    Log.e("FragmentManager", "Activity state:");
    PrintWriter localPrintWriter = new PrintWriter(new android.support.v4.b.e("FragmentManager"));
    if (this.cJ != null) {}
    for (;;)
    {
      try
      {
        this.cJ.a("  ", localPrintWriter, new String[0]);
        throw paramRuntimeException;
      }
      catch (Exception localException1)
      {
        Log.e("FragmentManager", "Failed dumping state", localException1);
        continue;
      }
      try
      {
        dump("  ", null, localException1, new String[0]);
      }
      catch (Exception localException2)
      {
        Log.e("FragmentManager", "Failed dumping state", localException2);
      }
    }
  }
  
  private void a(ArrayList<e> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2)
  {
    boolean bool = ((e)paramArrayList.get(paramInt1)).bS;
    Object localObject;
    int j;
    label55:
    e locale;
    if (this.et == null)
    {
      this.et = new ArrayList();
      this.et.addAll(this.dZ);
      localObject = this.ek;
      j = paramInt1;
      i = 0;
      if (j >= paramInt2) {
        break label158;
      }
      locale = (e)paramArrayList.get(j);
      if (((Boolean)paramArrayList1.get(j)).booleanValue()) {
        break label136;
      }
      localObject = locale.a(this.et, (Fragment)localObject);
      label101:
      if ((i == 0) && (!locale.bI)) {
        break label152;
      }
    }
    label136:
    label152:
    for (int i = 1;; i = 0)
    {
      j += 1;
      break label55;
      this.et.clear();
      break;
      localObject = locale.b(this.et, (Fragment)localObject);
      break label101;
    }
    label158:
    this.et.clear();
    if (!bool) {
      ah.a(this, paramArrayList, paramArrayList1, paramInt1, paramInt2, false);
    }
    b(paramArrayList, paramArrayList1, paramInt1, paramInt2);
    int k;
    if (bool)
    {
      localObject = new b();
      b((b)localObject);
      k = a(paramArrayList, paramArrayList1, paramInt1, paramInt2, (b)localObject);
      a((b)localObject);
    }
    for (;;)
    {
      j = paramInt1;
      if (k != paramInt1)
      {
        j = paramInt1;
        if (bool)
        {
          ah.a(this, paramArrayList, paramArrayList1, paramInt1, k, true);
          b(this.eh, true);
          j = paramInt1;
        }
      }
      while (j < paramInt2)
      {
        localObject = (e)paramArrayList.get(j);
        if ((((Boolean)paramArrayList1.get(j)).booleanValue()) && (((e)localObject).bL >= 0)) {
          paramInt1 = ((e)localObject).bL;
        }
        try
        {
          this.ed.set(paramInt1, null);
          if (this.ee == null) {
            this.ee = new ArrayList();
          }
          if (DEBUG) {
            Log.v("FragmentManager", "Freeing back stack index ".concat(String.valueOf(paramInt1)));
          }
          this.ee.add(Integer.valueOf(paramInt1));
          ((e)localObject).bL = -1;
          ((e)localObject).C();
          j += 1;
        }
        finally {}
      }
      if (i != 0) {
        ax();
      }
      return;
      k = paramInt2;
    }
  }
  
  private void aA()
  {
    if (this.ea != null)
    {
      int i = this.ea.size() - 1;
      while (i >= 0)
      {
        if (this.ea.valueAt(i) == null) {
          this.ea.delete(this.ea.keyAt(i));
        }
        i -= 1;
      }
    }
  }
  
  private boolean ap()
  {
    execPendingActions();
    at();
    if (this.ek != null)
    {
      u localu = this.ek.cK;
      if ((localu != null) && (localu.popBackStackImmediate())) {
        return true;
      }
    }
    boolean bool = a(this.er, this.es, null, -1, 0);
    if (bool) {
      this.dX = true;
    }
    try
    {
      c(this.er, this.es);
      au();
      aw();
      return bool;
    }
    finally
    {
      au();
    }
  }
  
  private void aq()
  {
    if (this.ea == null) {
      return;
    }
    int i = 0;
    label10:
    Fragment localFragment;
    if (i < this.ea.size())
    {
      localFragment = (Fragment)this.ea.valueAt(i);
      if ((localFragment != null) && (localFragment.db))
      {
        if (!this.dX) {
          break label63;
        }
        this.eq = true;
      }
    }
    for (;;)
    {
      i += 1;
      break label10;
      break;
      label63:
      localFragment.db = false;
      a(localFragment, this.eh, 0, 0, false);
    }
  }
  
  private void ar()
  {
    if (isStateSaved()) {
      throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }
    if (this.ep != null) {
      throw new IllegalStateException("Can not perform this action inside of " + this.ep);
    }
  }
  
  private void as()
  {
    int j = 1;
    label44:
    label73:
    label92:
    label97:
    label100:
    for (;;)
    {
      int i;
      try
      {
        if ((this.ew == null) || (this.ew.isEmpty())) {
          break label92;
        }
        i = 1;
        if ((this.dW == null) || (this.dW.size() != 1)) {
          break label97;
        }
      }
      finally {}
      this.cJ.getHandler().removeCallbacks(this.ey);
      this.cJ.getHandler().post(this.ey);
      return;
      for (;;)
      {
        if (i != 0) {
          break label100;
        }
        if (j == 0) {
          break label73;
        }
        break label44;
        i = 0;
        break;
        j = 0;
      }
    }
  }
  
  private void at()
  {
    if (this.dX) {
      throw new IllegalStateException("FragmentManager is already executing transactions");
    }
    if (this.cJ == null) {
      throw new IllegalStateException("Fragment host has been destroyed");
    }
    if (Looper.myLooper() != this.cJ.getHandler().getLooper()) {
      throw new IllegalStateException("Must be called from main thread of fragment host");
    }
    if (this.er == null)
    {
      this.er = new ArrayList();
      this.es = new ArrayList();
    }
    this.dX = true;
    try
    {
      b(null, null);
      return;
    }
    finally
    {
      this.dX = false;
    }
  }
  
  private void au()
  {
    this.dX = false;
    this.es.clear();
    this.er.clear();
  }
  
  private void av()
  {
    if (this.ew != null) {
      while (!this.ew.isEmpty()) {
        ((ad)this.ew.remove(0)).aC();
      }
    }
  }
  
  private void aw()
  {
    if (this.eq)
    {
      this.eq = false;
      aq();
    }
  }
  
  private void ax()
  {
    if (this.ef != null)
    {
      int i = 0;
      while (i < this.ef.size())
      {
        this.ef.get(i);
        i += 1;
      }
    }
  }
  
  private void az()
  {
    if (this.ea != null)
    {
      int i = 0;
      Object localObject1 = null;
      Object localObject3 = null;
      Object localObject7;
      for (Object localObject2 = null;; localObject2 = localObject7)
      {
        localObject6 = localObject1;
        localObject5 = localObject3;
        localObject4 = localObject2;
        if (i >= this.ea.size()) {
          break;
        }
        Fragment localFragment = (Fragment)this.ea.valueAt(i);
        localObject5 = localObject1;
        localObject6 = localObject3;
        localObject7 = localObject2;
        if (localFragment != null)
        {
          localObject4 = localObject2;
          int j;
          if (localFragment.cT)
          {
            localObject5 = localObject2;
            if (localObject2 == null) {
              localObject5 = new ArrayList();
            }
            ((ArrayList)localObject5).add(localFragment);
            if (localFragment.cy == null) {
              break label246;
            }
            j = localFragment.cy.bL;
            localFragment.cz = j;
            localObject4 = localObject5;
            if (DEBUG)
            {
              Log.v("FragmentManager", "retainNonConfig: keeping retained ".concat(String.valueOf(localFragment)));
              localObject4 = localObject5;
            }
          }
          if (localFragment.cK != null) {
            localFragment.cK.az();
          }
          for (localObject5 = localFragment.cK.ex;; localObject5 = localFragment.cL)
          {
            localObject2 = localObject3;
            if (localObject3 != null) {
              break label261;
            }
            localObject2 = localObject3;
            if (localObject5 == null) {
              break label261;
            }
            localObject3 = new ArrayList(this.ea.size());
            j = 0;
            for (;;)
            {
              localObject2 = localObject3;
              if (j >= i) {
                break;
              }
              ((ArrayList)localObject3).add(null);
              j += 1;
            }
            label246:
            j = -1;
            break;
          }
          label261:
          if (localObject2 != null) {
            localObject2.add(localObject5);
          }
          localObject3 = localObject1;
          if (localObject1 == null)
          {
            localObject3 = localObject1;
            if (localFragment.cM != null)
            {
              localObject1 = new ArrayList(this.ea.size());
              j = 0;
              for (;;)
              {
                localObject3 = localObject1;
                if (j >= i) {
                  break;
                }
                ((ArrayList)localObject1).add(null);
                j += 1;
              }
            }
          }
          localObject5 = localObject3;
          localObject6 = localObject2;
          localObject7 = localObject4;
          if (localObject3 != null)
          {
            ((ArrayList)localObject3).add(localFragment.cM);
            localObject7 = localObject4;
            localObject6 = localObject2;
            localObject5 = localObject3;
          }
        }
        i += 1;
        localObject1 = localObject5;
        localObject3 = localObject6;
      }
    }
    Object localObject6 = null;
    Object localObject5 = null;
    Object localObject4 = null;
    if ((localObject4 == null) && (localObject5 == null) && (localObject6 == null))
    {
      this.ex = null;
      return;
    }
    this.ex = new ae(localObject4, (List)localObject5, localObject6);
  }
  
  private Fragment b(Bundle paramBundle, String paramString)
  {
    int i = paramBundle.getInt(paramString, -1);
    if (i == -1) {
      paramBundle = null;
    }
    Fragment localFragment;
    do
    {
      return paramBundle;
      localFragment = (Fragment)this.ea.get(i);
      paramBundle = localFragment;
    } while (localFragment != null);
    a(new IllegalStateException("Fragment no longer exists for key " + paramString + ": index " + i));
    return localFragment;
  }
  
  private void b(Fragment paramFragment, Context paramContext, boolean paramBoolean)
  {
    if (this.ej != null)
    {
      u localu = this.ej.cI;
      if ((localu instanceof u)) {
        ((u)localu).b(paramFragment, paramContext, true);
      }
    }
    paramFragment = this.eg.iterator();
    while (paramFragment.hasNext())
    {
      paramContext = (m)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)paramContext.second).booleanValue();
      }
    }
  }
  
  private void b(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean)
  {
    if (this.ej != null)
    {
      u localu = this.ej.cI;
      if ((localu instanceof u)) {
        ((u)localu).b(paramFragment, paramBundle, true);
      }
    }
    paramFragment = this.eg.iterator();
    while (paramFragment.hasNext())
    {
      paramBundle = (m)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)paramBundle.second).booleanValue();
      }
    }
  }
  
  private void b(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject;
    if (this.ej != null)
    {
      localObject = this.ej.cI;
      if ((localObject instanceof u)) {
        ((u)localObject).b(paramFragment, true);
      }
    }
    paramFragment = this.eg.iterator();
    while (paramFragment.hasNext())
    {
      localObject = (m)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)((m)localObject).second).booleanValue();
      }
    }
  }
  
  private void b(b<Fragment> paramb)
  {
    if (this.eh <= 0) {}
    for (;;)
    {
      return;
      int j = Math.min(this.eh, 4);
      int k = this.dZ.size();
      int i = 0;
      while (i < k)
      {
        Fragment localFragment = (Fragment)this.dZ.get(i);
        if (localFragment.cs < j)
        {
          a(localFragment, j, localFragment.X(), localFragment.Y(), false);
          if ((localFragment.cZ != null) && (!localFragment.cR) && (localFragment.df)) {
            paramb.add(localFragment);
          }
        }
        i += 1;
      }
    }
  }
  
  private void b(ArrayList<e> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    int i;
    int j;
    label12:
    ad localad;
    int k;
    if (this.ew == null)
    {
      i = 0;
      j = 0;
      if (j >= i) {
        return;
      }
      localad = (ad)this.ew.get(j);
      if ((paramArrayList == null) || (ad.a(localad))) {
        break label101;
      }
      k = paramArrayList.indexOf(ad.b(localad));
      if ((k == -1) || (!((Boolean)paramArrayList1.get(k)).booleanValue())) {
        break label101;
      }
      localad.aD();
    }
    for (;;)
    {
      j += 1;
      break label12;
      i = this.ew.size();
      break;
      label101:
      int m;
      if (!localad.aB())
      {
        m = j;
        k = i;
        if (paramArrayList != null)
        {
          m = j;
          k = i;
          if (!ad.b(localad).a(paramArrayList, 0, paramArrayList.size())) {}
        }
      }
      else
      {
        this.ew.remove(j);
        m = j - 1;
        k = i - 1;
        if ((paramArrayList != null) && (!ad.a(localad)))
        {
          i = paramArrayList.indexOf(ad.b(localad));
          if ((i != -1) && (((Boolean)paramArrayList1.get(i)).booleanValue()))
          {
            localad.aD();
            j = m;
            i = k;
            continue;
          }
        }
        localad.aC();
      }
      j = m;
      i = k;
    }
  }
  
  private static void b(ArrayList<e> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2)
    {
      e locale = (e)paramArrayList.get(paramInt1);
      boolean bool;
      if (((Boolean)paramArrayList1.get(paramInt1)).booleanValue())
      {
        locale.k(-1);
        if (paramInt1 == paramInt2 - 1)
        {
          bool = true;
          label45:
          locale.c(bool);
        }
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        bool = false;
        break label45;
        locale.k(1);
        locale.D();
      }
    }
  }
  
  private static boolean b(Animator paramAnimator)
  {
    if (paramAnimator == null) {}
    for (;;)
    {
      return false;
      int i;
      if ((paramAnimator instanceof ValueAnimator))
      {
        paramAnimator = ((ValueAnimator)paramAnimator).getValues();
        i = 0;
        while (i < paramAnimator.length)
        {
          if ("alpha".equals(paramAnimator[i].getPropertyName())) {
            return true;
          }
          i += 1;
        }
      }
      else if ((paramAnimator instanceof AnimatorSet))
      {
        paramAnimator = ((AnimatorSet)paramAnimator).getChildAnimations();
        i = 0;
        while (i < paramAnimator.size())
        {
          if (b((Animator)paramAnimator.get(i))) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  private void c(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean)
  {
    if (this.ej != null)
    {
      u localu = this.ej.cI;
      if ((localu instanceof u)) {
        ((u)localu).c(paramFragment, paramBundle, true);
      }
    }
    paramFragment = this.eg.iterator();
    while (paramFragment.hasNext())
    {
      paramBundle = (m)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)paramBundle.second).booleanValue();
      }
    }
  }
  
  private void c(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject;
    if (this.ej != null)
    {
      localObject = this.ej.cI;
      if ((localObject instanceof u)) {
        ((u)localObject).c(paramFragment, true);
      }
    }
    paramFragment = this.eg.iterator();
    while (paramFragment.hasNext())
    {
      localObject = (m)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)((m)localObject).second).booleanValue();
      }
    }
  }
  
  private void c(ArrayList<e> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return;
    }
    if ((paramArrayList1 == null) || (paramArrayList.size() != paramArrayList1.size())) {
      throw new IllegalStateException("Internal error with the back stack records");
    }
    b(paramArrayList, paramArrayList1);
    int m = paramArrayList.size();
    int i = 0;
    int j = 0;
    label55:
    int k;
    if (i < m)
    {
      if (((e)paramArrayList.get(i)).bS) {
        break label222;
      }
      if (j != i) {
        a(paramArrayList, paramArrayList1, j, i);
      }
      k = i + 1;
      j = k;
      if (((Boolean)paramArrayList1.get(i)).booleanValue()) {
        for (;;)
        {
          j = k;
          if (k >= m) {
            break;
          }
          j = k;
          if (!((Boolean)paramArrayList1.get(k)).booleanValue()) {
            break;
          }
          j = k;
          if (((e)paramArrayList.get(k)).bS) {
            break;
          }
          k += 1;
        }
      }
      a(paramArrayList, paramArrayList1, i, j);
      k = j - 1;
    }
    for (i = j;; i = j)
    {
      k += 1;
      j = i;
      i = k;
      break label55;
      if (j == m) {
        break;
      }
      a(paramArrayList, paramArrayList1, j, m);
      return;
      label222:
      k = i;
    }
  }
  
  private void d(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean)
  {
    if (this.ej != null)
    {
      u localu = this.ej.cI;
      if ((localu instanceof u)) {
        ((u)localu).d(paramFragment, paramBundle, true);
      }
    }
    paramFragment = this.eg.iterator();
    while (paramFragment.hasNext())
    {
      paramBundle = (m)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)paramBundle.second).booleanValue();
      }
    }
  }
  
  private void d(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject;
    if (this.ej != null)
    {
      localObject = this.ej.cI;
      if ((localObject instanceof u)) {
        ((u)localObject).d(paramFragment, true);
      }
    }
    paramFragment = this.eg.iterator();
    while (paramFragment.hasNext())
    {
      localObject = (m)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)((m)localObject).second).booleanValue();
      }
    }
  }
  
  private boolean d(ArrayList<e> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    try
    {
      if ((this.dW == null) || (this.dW.size() == 0)) {
        return false;
      }
      int j = this.dW.size();
      int i = 0;
      boolean bool = false;
      while (i < j)
      {
        bool |= ((ab)this.dW.get(i)).a(paramArrayList, paramArrayList1);
        i += 1;
      }
      this.dW.clear();
      this.cJ.getHandler().removeCallbacks(this.ey);
      return bool;
    }
    finally {}
  }
  
  private void e(Fragment paramFragment)
  {
    a(paramFragment, this.eh, 0, 0, false);
  }
  
  private void e(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject;
    if (this.ej != null)
    {
      localObject = this.ej.cI;
      if ((localObject instanceof u)) {
        ((u)localObject).e(paramFragment, true);
      }
    }
    paramFragment = this.eg.iterator();
    while (paramFragment.hasNext())
    {
      localObject = (m)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)((m)localObject).second).booleanValue();
      }
    }
  }
  
  private void f(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject;
    if (this.ej != null)
    {
      localObject = this.ej.cI;
      if ((localObject instanceof u)) {
        ((u)localObject).f(paramFragment, true);
      }
    }
    paramFragment = this.eg.iterator();
    while (paramFragment.hasNext())
    {
      localObject = (m)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)((m)localObject).second).booleanValue();
      }
    }
  }
  
  private void g(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject;
    if (this.ej != null)
    {
      localObject = this.ej.cI;
      if ((localObject instanceof u)) {
        ((u)localObject).g(paramFragment, true);
      }
    }
    paramFragment = this.eg.iterator();
    while (paramFragment.hasNext())
    {
      localObject = (m)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)((m)localObject).second).booleanValue();
      }
    }
  }
  
  private void h(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject;
    if (this.ej != null)
    {
      localObject = this.ej.cI;
      if ((localObject instanceof u)) {
        ((u)localObject).h(paramFragment, true);
      }
    }
    paramFragment = this.eg.iterator();
    while (paramFragment.hasNext())
    {
      localObject = (m)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)((m)localObject).second).booleanValue();
      }
    }
  }
  
  public static void i(Fragment paramFragment)
  {
    boolean bool = true;
    if (DEBUG) {
      Log.v("FragmentManager", "hide: ".concat(String.valueOf(paramFragment)));
    }
    if (!paramFragment.cR)
    {
      paramFragment.cR = true;
      if (paramFragment.dg) {
        break label50;
      }
    }
    for (;;)
    {
      paramFragment.dg = bool;
      return;
      label50:
      bool = false;
    }
  }
  
  public static void j(Fragment paramFragment)
  {
    boolean bool = false;
    if (DEBUG) {
      Log.v("FragmentManager", "show: ".concat(String.valueOf(paramFragment)));
    }
    if (paramFragment.cR)
    {
      paramFragment.cR = false;
      if (!paramFragment.dg) {
        bool = true;
      }
      paramFragment.dg = bool;
    }
  }
  
  private void m(Fragment paramFragment)
  {
    if (paramFragment.da == null) {
      return;
    }
    if (this.ev == null) {
      this.ev = new SparseArray();
    }
    for (;;)
    {
      paramFragment.da.saveHierarchyState(this.ev);
      if (this.ev.size() <= 0) {
        break;
      }
      paramFragment.cu = this.ev;
      this.ev = null;
      return;
      this.ev.clear();
    }
  }
  
  private Fragment q(int paramInt)
  {
    int i = this.dZ.size() - 1;
    Object localObject;
    while (i >= 0)
    {
      localObject = (Fragment)this.dZ.get(i);
      if ((localObject != null) && (((Fragment)localObject).cO == paramInt)) {
        return localObject;
      }
      i -= 1;
    }
    if (this.ea != null)
    {
      i = this.ea.size() - 1;
      for (;;)
      {
        if (i < 0) {
          break label105;
        }
        Fragment localFragment = (Fragment)this.ea.valueAt(i);
        if (localFragment != null)
        {
          localObject = localFragment;
          if (localFragment.cO == paramInt) {
            break;
          }
        }
        i -= 1;
      }
    }
    label105:
    return null;
  }
  
  private void r(int paramInt)
  {
    try
    {
      this.dX = true;
      b(paramInt, false);
      this.dX = false;
      execPendingActions();
      return;
    }
    finally
    {
      this.dX = false;
    }
  }
  
  public static int s(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 4097: 
      return 8194;
    case 8194: 
      return 4097;
    }
    return 4099;
  }
  
  public final int a(e parame)
  {
    try
    {
      if ((this.ee == null) || (this.ee.size() <= 0))
      {
        if (this.ed == null) {
          this.ed = new ArrayList();
        }
        i = this.ed.size();
        if (DEBUG) {
          Log.v("FragmentManager", "Setting back stack index " + i + " to " + parame);
        }
        this.ed.add(parame);
        return i;
      }
      int i = ((Integer)this.ee.remove(this.ee.size() - 1)).intValue();
      if (DEBUG) {
        Log.v("FragmentManager", "Adding back stack index " + i + " with " + parame);
      }
      this.ed.set(i, parame);
      return i;
    }
    finally {}
  }
  
  public final Fragment a(String paramString)
  {
    if ((this.ea != null) && (paramString != null))
    {
      int i = this.ea.size() - 1;
      while (i >= 0)
      {
        Fragment localFragment = (Fragment)this.ea.valueAt(i);
        if (localFragment != null)
        {
          localFragment = localFragment.a(paramString);
          if (localFragment != null) {
            return localFragment;
          }
        }
        i -= 1;
      }
    }
    return null;
  }
  
  final void a(Parcelable arg1, ae paramae)
  {
    if (??? == null) {}
    FragmentManagerState localFragmentManagerState;
    do
    {
      return;
      localFragmentManagerState = (FragmentManagerState)???;
    } while (localFragmentManagerState.fa == null);
    List localList = null;
    Object localObject1;
    int i;
    int j;
    Object localObject2;
    Object localObject3;
    if (paramae != null)
    {
      localObject1 = paramae.getFragments();
      localList = paramae.aE();
      ??? = paramae.aF();
      if (localObject1 != null)
      {
        i = ((List)localObject1).size();
        j = 0;
      }
      for (;;)
      {
        if (j >= i) {
          break label301;
        }
        localObject2 = (Fragment)((List)localObject1).get(j);
        if (DEBUG) {
          Log.v("FragmentManager", "restoreAllState: re-attaching retained ".concat(String.valueOf(localObject2)));
        }
        int k = 0;
        for (;;)
        {
          if ((k < localFragmentManagerState.fa.length) && (localFragmentManagerState.fa[k].bL != ((Fragment)localObject2).bL))
          {
            k += 1;
            continue;
            i = 0;
            break;
          }
        }
        if (k == localFragmentManagerState.fa.length) {
          a(new IllegalStateException("Could not find active fragment with index " + ((Fragment)localObject2).bL));
        }
        localObject3 = localFragmentManagerState.fa[k];
        ((FragmentState)localObject3).ff = ((Fragment)localObject2);
        ((Fragment)localObject2).cu = null;
        ((Fragment)localObject2).cH = 0;
        ((Fragment)localObject2).cE = false;
        ((Fragment)localObject2).cB = false;
        ((Fragment)localObject2).cy = null;
        if (((FragmentState)localObject3).ct != null)
        {
          ((FragmentState)localObject3).ct.setClassLoader(this.cJ.mContext.getClassLoader());
          ((Fragment)localObject2).cu = ((FragmentState)localObject3).ct.getSparseParcelableArray("android:view_state");
          ((Fragment)localObject2).ct = ((FragmentState)localObject3).ct;
        }
        j += 1;
      }
    }
    for (;;)
    {
      label301:
      this.ea = new SparseArray(localFragmentManagerState.fa.length);
      i = 0;
      FragmentState localFragmentState;
      if (i < localFragmentManagerState.fa.length)
      {
        localFragmentState = localFragmentManagerState.fa[i];
        if (localFragmentState != null) {
          if ((localList == null) || (i >= localList.size())) {
            break label1316;
          }
        }
      }
      label782:
      label1316:
      for (localObject1 = (ae)localList.get(i);; localObject1 = null)
      {
        localObject3 = null;
        localObject2 = localObject3;
        if (??? != null)
        {
          localObject2 = localObject3;
          if (i < ???.size()) {
            localObject2 = (android.arch.lifecycle.x)???.get(i);
          }
        }
        localObject3 = this.cJ;
        q localq = this.ei;
        Fragment localFragment = this.ej;
        Context localContext;
        if (localFragmentState.ff == null)
        {
          localContext = ((s)localObject3).mContext;
          if (localFragmentState.cx != null) {
            localFragmentState.cx.setClassLoader(localContext.getClassLoader());
          }
          if (localq == null) {
            break label782;
          }
        }
        for (localFragmentState.ff = localq.a(localContext, localFragmentState.fe, localFragmentState.cx);; localFragmentState.ff = Fragment.a(localContext, localFragmentState.fe, localFragmentState.cx))
        {
          if (localFragmentState.ct != null)
          {
            localFragmentState.ct.setClassLoader(localContext.getClassLoader());
            localFragmentState.ff.ct = localFragmentState.ct;
          }
          localFragmentState.ff.a(localFragmentState.bL, localFragment);
          localFragmentState.ff.cD = localFragmentState.cD;
          localFragmentState.ff.cF = true;
          localFragmentState.ff.cO = localFragmentState.cO;
          localFragmentState.ff.cP = localFragmentState.cP;
          localFragmentState.ff.cQ = localFragmentState.cQ;
          localFragmentState.ff.cT = localFragmentState.cT;
          localFragmentState.ff.cS = localFragmentState.cS;
          localFragmentState.ff.cR = localFragmentState.cR;
          localFragmentState.ff.cI = ((s)localObject3).cI;
          if (DEBUG) {
            Log.v("FragmentManager", "Instantiated fragment " + localFragmentState.ff);
          }
          localFragmentState.ff.cL = ((ae)localObject1);
          localFragmentState.ff.cM = ((android.arch.lifecycle.x)localObject2);
          localObject1 = localFragmentState.ff;
          if (DEBUG) {
            Log.v("FragmentManager", "restoreAllState: active #" + i + ": " + localObject1);
          }
          this.ea.put(((Fragment)localObject1).bL, localObject1);
          localFragmentState.ff = null;
          i += 1;
          break;
        }
        if (paramae != null)
        {
          ??? = paramae.getFragments();
          if (??? != null) {}
          for (i = ???.size();; i = 0)
          {
            j = 0;
            while (j < i)
            {
              paramae = (Fragment)???.get(j);
              if (paramae.cz >= 0)
              {
                paramae.cy = ((Fragment)this.ea.get(paramae.cz));
                if (paramae.cy == null) {
                  Log.w("FragmentManager", "Re-attaching retained fragment " + paramae + " target no longer exists: " + paramae.cz);
                }
              }
              j += 1;
            }
          }
        }
        this.dZ.clear();
        if (localFragmentManagerState.fb != null)
        {
          i = 0;
          while (i < localFragmentManagerState.fb.length)
          {
            paramae = (Fragment)this.ea.get(localFragmentManagerState.fb[i]);
            if (paramae == null) {
              a(new IllegalStateException("No instantiated fragment for index #" + localFragmentManagerState.fb[i]));
            }
            paramae.cB = true;
            if (DEBUG) {
              Log.v("FragmentManager", "restoreAllState: added #" + i + ": " + paramae);
            }
            if (this.dZ.contains(paramae)) {
              throw new IllegalStateException("Already added!");
            }
            synchronized (this.dZ)
            {
              this.dZ.add(paramae);
              i += 1;
            }
          }
        }
        if (localFragmentManagerState.fc != null)
        {
          this.eb = new ArrayList(localFragmentManagerState.fc.length);
          i = 0;
          while (i < localFragmentManagerState.fc.length)
          {
            ??? = localFragmentManagerState.fc[i].a(this);
            if (DEBUG)
            {
              Log.v("FragmentManager", "restoreAllState: back stack #" + i + " (index " + ???.bL + "): " + ???);
              paramae = new PrintWriter(new android.support.v4.b.e("FragmentManager"));
              ???.a("  ", paramae, false);
              paramae.close();
            }
            this.eb.add(???);
            if (???.bL >= 0) {
              a(???.bL, ???);
            }
            i += 1;
          }
        }
        this.eb = null;
        if (localFragmentManagerState.fd >= 0) {
          this.ek = ((Fragment)this.ea.get(localFragmentManagerState.fd));
        }
        this.dY = localFragmentManagerState.dY;
        return;
      }
      ??? = null;
    }
  }
  
  final void a(final Fragment paramFragment, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int j;
    if (paramFragment.cB)
    {
      j = paramInt1;
      if (!paramFragment.cS) {}
    }
    else
    {
      j = paramInt1;
      if (paramInt1 > 1) {
        j = 1;
      }
    }
    int i = j;
    if (paramFragment.cC)
    {
      i = j;
      if (j > paramFragment.cs)
      {
        if ((paramFragment.cs != 0) || (!paramFragment.H())) {
          break label124;
        }
        i = 1;
      }
    }
    paramInt1 = i;
    if (paramFragment.db)
    {
      paramInt1 = i;
      if (paramFragment.cs < 4)
      {
        paramInt1 = i;
        if (i > 3) {
          paramInt1 = 3;
        }
      }
    }
    label124:
    Object localObject3;
    if (paramFragment.cs <= paramInt1)
    {
      if ((paramFragment.cD) && (!paramFragment.cE)) {}
      do
      {
        return;
        i = paramFragment.cs;
        break;
        if ((paramFragment.ac() != null) || (paramFragment.ad() != null))
        {
          paramFragment.b(null);
          paramFragment.a(null);
          a(paramFragment, paramFragment.ae(), 0, 0, true);
        }
        paramInt3 = paramInt1;
        i = paramInt1;
        j = paramInt1;
        paramInt2 = paramInt1;
        switch (paramFragment.cs)
        {
        default: 
          i = paramInt1;
        }
      } while (paramFragment.cs == i);
      Log.w("FragmentManager", "moveToState: Fragment state for " + paramFragment + " not updated inline; expected state " + i + " found " + paramFragment.cs);
      paramFragment.cs = i;
      return;
      paramInt3 = paramInt1;
      Object localObject1;
      if (paramInt1 > 0)
      {
        if (DEBUG) {
          Log.v("FragmentManager", "moveto CREATED: ".concat(String.valueOf(paramFragment)));
        }
        paramInt3 = paramInt1;
        if (paramFragment.ct != null)
        {
          paramFragment.ct.setClassLoader(this.cJ.mContext.getClassLoader());
          paramFragment.cu = paramFragment.ct.getSparseParcelableArray("android:view_state");
          paramFragment.cy = b(paramFragment.ct, "android:target_state");
          if (paramFragment.cy != null) {
            paramFragment.cA = paramFragment.ct.getInt("android:target_req_state", 0);
          }
          if (paramFragment.cv == null) {
            break label554;
          }
          paramFragment.dc = paramFragment.cv.booleanValue();
          paramFragment.cv = null;
          paramInt3 = paramInt1;
          if (!paramFragment.dc)
          {
            paramFragment.db = true;
            paramInt3 = paramInt1;
            if (paramInt1 > 3) {
              paramInt3 = 3;
            }
          }
        }
        paramFragment.cJ = this.cJ;
        paramFragment.cN = this.ej;
        if (this.ej != null) {}
        for (localObject1 = this.ej.cK;; localObject1 = this.cJ.cI)
        {
          paramFragment.cI = ((u)localObject1);
          if (paramFragment.cy == null) {
            break label606;
          }
          if (this.ea.get(paramFragment.cy.bL) == paramFragment.cy) {
            break label584;
          }
          throw new IllegalStateException("Fragment " + paramFragment + " declared target fragment " + paramFragment.cy + " that does not belong to this FragmentManager!");
          label554:
          paramFragment.dc = paramFragment.ct.getBoolean("android:user_visible_hint", true);
          break;
        }
        label584:
        if (paramFragment.cy.cs <= 0) {
          a(paramFragment.cy, 1, 0, 0, true);
        }
        label606:
        a(paramFragment, this.cJ.mContext, false);
        paramFragment.cX = false;
        paramFragment.onAttach(this.cJ.mContext);
        if (!paramFragment.cX) {
          throw new bc("Fragment " + paramFragment + " did not call through to super.onAttach()");
        }
        b(paramFragment, this.cJ.mContext, false);
        if (!paramFragment.dj)
        {
          a(paramFragment, paramFragment.ct, false);
          paramFragment.c(paramFragment.ct);
          b(paramFragment, paramFragment.ct, false);
          paramFragment.cU = false;
        }
      }
      else
      {
        if ((paramFragment.cD) && (!paramFragment.cG))
        {
          paramFragment.a(paramFragment.ct);
          paramFragment.cZ = paramFragment.S();
          if (paramFragment.cZ == null) {
            break label1275;
          }
          paramFragment.da = paramFragment.cZ;
          paramFragment.cZ.setSaveFromParentEnabled(false);
          if (paramFragment.cR) {
            paramFragment.cZ.setVisibility(8);
          }
          a(paramFragment, paramFragment.cZ, paramFragment.ct, false);
        }
        label810:
        i = paramInt3;
        if (paramInt3 <= 1) {
          break label1335;
        }
        if (DEBUG) {
          Log.v("FragmentManager", "moveto ACTIVITY_CREATED: ".concat(String.valueOf(paramFragment)));
        }
        if (!paramFragment.cD)
        {
          if (paramFragment.cP == 0) {
            break label2715;
          }
          if (paramFragment.cP == -1) {
            a(new IllegalArgumentException("Cannot create fragment " + paramFragment + " for a container view with no id"));
          }
          localObject3 = (ViewGroup)this.ei.onFindViewById(paramFragment.cP);
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            localObject1 = localObject3;
            if (!paramFragment.cF)
            {
              try
              {
                if (paramFragment.cJ != null) {
                  break label1283;
                }
                localObject1 = null;
                label945:
                if (localObject1 != null) {
                  break label1295;
                }
                throw new IllegalStateException("Fragment " + paramFragment + " not attached to a context.");
              }
              catch (Resources.NotFoundException localNotFoundException)
              {
                localObject2 = "unknown";
              }
              label988:
              a(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(paramFragment.cP) + " (" + (String)localObject2 + ") for fragment " + paramFragment));
            }
          }
        }
      }
    }
    label1157:
    label1295:
    label2709:
    label2715:
    for (Object localObject2 = localObject3;; localObject2 = null)
    {
      paramFragment.cY = ((ViewGroup)localObject2);
      paramFragment.a(paramFragment.ct);
      paramFragment.cZ = paramFragment.S();
      if (paramFragment.cZ != null)
      {
        paramFragment.da = paramFragment.cZ;
        paramFragment.cZ.setSaveFromParentEnabled(false);
        if (localObject2 != null) {
          ((ViewGroup)localObject2).addView(paramFragment.cZ);
        }
        if (paramFragment.cR) {
          paramFragment.cZ.setVisibility(8);
        }
        a(paramFragment, paramFragment.cZ, paramFragment.ct, false);
        if ((paramFragment.cZ.getVisibility() == 0) && (paramFragment.cY != null))
        {
          paramBoolean = true;
          paramFragment.df = paramBoolean;
        }
      }
      for (;;)
      {
        paramFragment.d(paramFragment.ct);
        c(paramFragment, paramFragment.ct, false);
        if (paramFragment.cZ == null) {
          break label1326;
        }
        if (paramFragment.cu != null)
        {
          paramFragment.da.restoreHierarchyState(paramFragment.cu);
          paramFragment.cu = null;
        }
        paramFragment.cX = false;
        paramFragment.cX = true;
        if (paramFragment.cX) {
          break label1326;
        }
        throw new bc("Fragment " + paramFragment + " did not call through to super.onViewStateRestored()");
        paramFragment.b(paramFragment.ct);
        paramFragment.cs = 1;
        break;
        label1275:
        paramFragment.da = null;
        break label810;
        localObject2 = paramFragment.cJ.mContext;
        break label945;
        localObject2 = ((Context)localObject2).getResources().getResourceName(paramFragment.cP);
        break label988;
        paramBoolean = false;
        break label1157;
        paramFragment.da = null;
      }
      label1326:
      paramFragment.ct = null;
      i = paramInt3;
      label1335:
      j = i;
      if (i > 2)
      {
        paramFragment.cs = 3;
        j = i;
      }
      paramInt2 = j;
      if (j > 3)
      {
        if (DEBUG) {
          Log.v("FragmentManager", "moveto STARTED: ".concat(String.valueOf(paramFragment)));
        }
        paramFragment.T();
        b(paramFragment, false);
        paramInt2 = j;
      }
      i = paramInt2;
      if (paramInt2 <= 4) {
        break;
      }
      if (DEBUG) {
        Log.v("FragmentManager", "moveto RESUMED: ".concat(String.valueOf(paramFragment)));
      }
      paramFragment.U();
      c(paramFragment, false);
      paramFragment.ct = null;
      paramFragment.cu = null;
      i = paramInt2;
      break;
      i = paramInt1;
      if (paramFragment.cs <= paramInt1) {
        break;
      }
      switch (paramFragment.cs)
      {
      default: 
        i = paramInt1;
        break;
      case 1: 
      case 5: 
      case 4: 
      case 3: 
      case 2: 
        do
        {
          i = paramInt1;
          if (paramInt1 > 0) {
            break;
          }
          if (this.eo)
          {
            if (paramFragment.ac() == null) {
              break label2266;
            }
            localObject2 = paramFragment.ac();
            paramFragment.b(null);
            ((View)localObject2).clearAnimation();
          }
          if ((paramFragment.ac() == null) && (paramFragment.ad() == null)) {
            break label2292;
          }
          paramFragment.o(paramInt1);
          i = 1;
          break;
          if (paramInt1 < 5)
          {
            if (DEBUG) {
              Log.v("FragmentManager", "movefrom RESUMED: ".concat(String.valueOf(paramFragment)));
            }
            paramFragment.dk.a(f.ON_PAUSE);
            if (paramFragment.cK != null) {
              paramFragment.cK.r(4);
            }
            paramFragment.cs = 4;
            paramFragment.cX = false;
            paramFragment.cX = true;
            if (!paramFragment.cX) {
              throw new bc("Fragment " + paramFragment + " did not call through to super.onPause()");
            }
            d(paramFragment, false);
          }
          if (paramInt1 < 4)
          {
            if (DEBUG) {
              Log.v("FragmentManager", "movefrom STARTED: ".concat(String.valueOf(paramFragment)));
            }
            paramFragment.dk.a(f.ON_STOP);
            if (paramFragment.cK != null) {
              paramFragment.cK.dispatchStop();
            }
            paramFragment.cs = 3;
            paramFragment.cX = false;
            paramFragment.onStop();
            if (!paramFragment.cX) {
              throw new bc("Fragment " + paramFragment + " did not call through to super.onStop()");
            }
            e(paramFragment, false);
          }
          if (paramInt1 < 3)
          {
            if (DEBUG) {
              Log.v("FragmentManager", "movefrom STOPPED: ".concat(String.valueOf(paramFragment)));
            }
            if (paramFragment.cK != null) {
              paramFragment.cK.r(2);
            }
            paramFragment.cs = 2;
          }
        } while (paramInt1 >= 2);
        if (DEBUG) {
          Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: ".concat(String.valueOf(paramFragment)));
        }
        if ((paramFragment.cZ != null) && (this.cJ.aj()) && (paramFragment.cu == null)) {
          m(paramFragment);
        }
        if (paramFragment.cK != null) {
          paramFragment.cK.r(1);
        }
        paramFragment.cs = 1;
        paramFragment.cX = false;
        paramFragment.onDestroyView();
        if (!paramFragment.cX) {
          throw new bc("Fragment " + paramFragment + " did not call through to super.onDestroyView()");
        }
        if (paramFragment.dd != null) {
          paramFragment.dd.aH();
        }
        paramFragment.cG = false;
        f(paramFragment, false);
        if ((paramFragment.cZ != null) && (paramFragment.cY != null))
        {
          paramFragment.cY.endViewTransition(paramFragment.cZ);
          paramFragment.cZ.clearAnimation();
          if ((this.eh <= 0) || (this.eo) || (paramFragment.cZ.getVisibility() != 0) || (paramFragment.dh < 0.0F)) {
            break label2709;
          }
        }
        for (localObject2 = a(paramFragment, paramInt2, false, paramInt3);; localObject2 = null)
        {
          paramFragment.dh = 0.0F;
          final ViewGroup localViewGroup;
          Object localObject4;
          if (localObject2 != null)
          {
            localObject3 = paramFragment.cZ;
            localViewGroup = paramFragment.cY;
            localViewGroup.startViewTransition((View)localObject3);
            paramFragment.o(paramInt1);
            if (((x)localObject2).eL == null) {
              break label2206;
            }
            localObject4 = new z(((x)localObject2).eL, localViewGroup, (View)localObject3);
            paramFragment.b(paramFragment.cZ);
            ((Animation)localObject4).setAnimationListener(new w(a((Animation)localObject4), localViewGroup)
            {
              public final void onAnimationEnd(Animation paramAnonymousAnimation)
              {
                super.onAnimationEnd(paramAnonymousAnimation);
                localViewGroup.post(new Runnable()
                {
                  public final void run()
                  {
                    if (u.2.this.eF.ac() != null)
                    {
                      u.2.this.eF.b(null);
                      u.this.a(u.2.this.eF, u.2.this.eF.ae(), 0, 0, false);
                    }
                  }
                });
              }
            });
            a((View)localObject3, (x)localObject2);
            paramFragment.cZ.startAnimation((Animation)localObject4);
          }
          for (;;)
          {
            paramFragment.cY.removeView(paramFragment.cZ);
            paramFragment.cY = null;
            paramFragment.cZ = null;
            paramFragment.da = null;
            paramFragment.cE = false;
            break;
            label2206:
            localObject4 = ((x)localObject2).eM;
            paramFragment.a(((x)localObject2).eM);
            ((Animator)localObject4).addListener(new AnimatorListenerAdapter()
            {
              public final void onAnimationEnd(Animator paramAnonymousAnimator)
              {
                localViewGroup.endViewTransition(this.eH);
                paramAnonymousAnimator = paramFragment.ad();
                paramFragment.a(null);
                if ((paramAnonymousAnimator != null) && (localViewGroup.indexOfChild(this.eH) < 0)) {
                  u.this.a(paramFragment, paramFragment.ae(), 0, 0, false);
                }
              }
            });
            ((Animator)localObject4).setTarget(paramFragment.cZ);
            a(paramFragment.cZ, (x)localObject2);
            ((Animator)localObject4).start();
          }
          label2266:
          if (paramFragment.ad() == null) {
            break label1547;
          }
          localObject2 = paramFragment.ad();
          paramFragment.a(null);
          ((Animator)localObject2).cancel();
          break label1547;
          label2292:
          if (DEBUG) {
            Log.v("FragmentManager", "movefrom CREATED: ".concat(String.valueOf(paramFragment)));
          }
          if (!paramFragment.cU)
          {
            paramFragment.dk.a(f.ON_DESTROY);
            if (paramFragment.cK != null) {
              paramFragment.cK.dispatchDestroy();
            }
            paramFragment.cs = 0;
            paramFragment.cX = false;
            paramFragment.dj = false;
            paramFragment.onDestroy();
            if (!paramFragment.cX) {
              throw new bc("Fragment " + paramFragment + " did not call through to super.onDestroy()");
            }
            paramFragment.cK = null;
            g(paramFragment, false);
          }
          for (;;)
          {
            paramFragment.cX = false;
            paramFragment.onDetach();
            paramFragment.di = null;
            if (paramFragment.cX) {
              break;
            }
            throw new bc("Fragment " + paramFragment + " did not call through to super.onDetach()");
            paramFragment.cs = 0;
          }
          if (paramFragment.cK != null)
          {
            if (!paramFragment.cU) {
              throw new IllegalStateException("Child FragmentManager of " + paramFragment + " was not  destroyed and this fragment is not retaining instance");
            }
            paramFragment.cK.dispatchDestroy();
            paramFragment.cK = null;
          }
          h(paramFragment, false);
          i = paramInt1;
          if (paramBoolean) {
            break;
          }
          if (!paramFragment.cU)
          {
            i = paramInt1;
            if (paramFragment.bL < 0) {
              break;
            }
            if (DEBUG) {
              Log.v("FragmentManager", "Freeing fragment index ".concat(String.valueOf(paramFragment)));
            }
            this.ea.put(paramFragment.bL, null);
            paramFragment.bL = -1;
            paramFragment.cw = null;
            paramFragment.cB = false;
            paramFragment.cC = false;
            paramFragment.cD = false;
            paramFragment.cE = false;
            paramFragment.cF = false;
            paramFragment.cH = 0;
            paramFragment.cI = null;
            paramFragment.cK = null;
            paramFragment.cJ = null;
            paramFragment.cO = 0;
            paramFragment.cP = 0;
            paramFragment.cQ = null;
            paramFragment.cR = false;
            paramFragment.cS = false;
            paramFragment.cU = false;
            i = paramInt1;
            break;
          }
          paramFragment.cJ = null;
          paramFragment.cN = null;
          paramFragment.cI = null;
          i = paramInt1;
          break;
        }
      }
    }
  }
  
  public final void a(Fragment paramFragment, boolean paramBoolean)
  {
    if (DEBUG) {
      Log.v("FragmentManager", "add: ".concat(String.valueOf(paramFragment)));
    }
    g(paramFragment);
    if (!paramFragment.cS) {
      if (this.dZ.contains(paramFragment)) {
        throw new IllegalStateException("Fragment already added: ".concat(String.valueOf(paramFragment)));
      }
    }
    synchronized (this.dZ)
    {
      this.dZ.add(paramFragment);
      paramFragment.cB = true;
      paramFragment.cC = false;
      if (paramFragment.cZ == null) {
        paramFragment.dg = false;
      }
      if ((paramFragment.cV) && (paramFragment.cW)) {
        this.em = true;
      }
      if (paramBoolean) {
        e(paramFragment);
      }
      return;
    }
  }
  
  public final void a(ab paramab, boolean paramBoolean)
  {
    if (!paramBoolean) {
      ar();
    }
    try
    {
      if ((this.eo) || (this.cJ == null))
      {
        if (paramBoolean) {
          return;
        }
        throw new IllegalStateException("Activity has been destroyed");
      }
    }
    finally {}
    if (this.dW == null) {
      this.dW = new ArrayList();
    }
    this.dW.add(paramab);
    as();
  }
  
  public final void a(s params, q paramq, Fragment paramFragment)
  {
    if (this.cJ != null) {
      throw new IllegalStateException("Already attached");
    }
    this.cJ = params;
    this.ei = paramq;
    this.ej = paramFragment;
  }
  
  final boolean a(ArrayList<e> paramArrayList, ArrayList<Boolean> paramArrayList1, String paramString, int paramInt1, int paramInt2)
  {
    if (this.eb == null) {
      return false;
    }
    if ((paramString == null) && (paramInt1 < 0) && ((paramInt2 & 0x1) == 0))
    {
      paramInt1 = this.eb.size() - 1;
      if (paramInt1 < 0) {
        return false;
      }
      paramArrayList.add(this.eb.remove(paramInt1));
      paramArrayList1.add(Boolean.TRUE);
    }
    for (;;)
    {
      return true;
      int i = -1;
      if ((paramString != null) || (paramInt1 >= 0))
      {
        int j = this.eb.size() - 1;
        e locale;
        while (j >= 0)
        {
          locale = (e)this.eb.get(j);
          if (((paramString != null) && (paramString.equals(locale.mName))) || ((paramInt1 >= 0) && (paramInt1 == locale.bL))) {
            break;
          }
          j -= 1;
        }
        if (j < 0) {
          return false;
        }
        i = j;
        if ((paramInt2 & 0x1) != 0)
        {
          paramInt2 = j - 1;
          for (;;)
          {
            i = paramInt2;
            if (paramInt2 < 0) {
              break;
            }
            locale = (e)this.eb.get(paramInt2);
            if ((paramString == null) || (!paramString.equals(locale.mName)))
            {
              i = paramInt2;
              if (paramInt1 < 0) {
                break;
              }
              i = paramInt2;
              if (paramInt1 != locale.bL) {
                break;
              }
            }
            paramInt2 -= 1;
          }
        }
      }
      if (i == this.eb.size() - 1) {
        return false;
      }
      paramInt1 = this.eb.size() - 1;
      while (paramInt1 > i)
      {
        paramArrayList.add(this.eb.remove(paramInt1));
        paramArrayList1.add(Boolean.TRUE);
        paramInt1 -= 1;
      }
    }
  }
  
  public final void an()
  {
    r(2);
  }
  
  public final ag ao()
  {
    return new e(this);
  }
  
  final ae ay()
  {
    a(this.ex);
    return this.ex;
  }
  
  public final Fragment b(String paramString)
  {
    int i;
    Object localObject;
    if (paramString != null)
    {
      i = this.dZ.size() - 1;
      while (i >= 0)
      {
        localObject = (Fragment)this.dZ.get(i);
        if ((localObject != null) && (paramString.equals(((Fragment)localObject).cQ))) {
          return localObject;
        }
        i -= 1;
      }
    }
    if ((this.ea != null) && (paramString != null))
    {
      i = this.ea.size() - 1;
      for (;;)
      {
        if (i < 0) {
          break label119;
        }
        Fragment localFragment = (Fragment)this.ea.valueAt(i);
        if (localFragment != null)
        {
          localObject = localFragment;
          if (paramString.equals(localFragment.cQ)) {
            break;
          }
        }
        i -= 1;
      }
    }
    label119:
    return null;
  }
  
  final void b(int paramInt, boolean paramBoolean)
  {
    if ((this.cJ == null) && (paramInt != 0)) {
      throw new IllegalStateException("No activity");
    }
    if ((!paramBoolean) && (paramInt == this.eh)) {}
    do
    {
      do
      {
        return;
        this.eh = paramInt;
      } while (this.ea == null);
      int i = this.dZ.size();
      paramInt = 0;
      while (paramInt < i)
      {
        f((Fragment)this.dZ.get(paramInt));
        paramInt += 1;
      }
      i = this.ea.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Fragment localFragment = (Fragment)this.ea.valueAt(paramInt);
        if ((localFragment != null) && ((localFragment.cC) || (localFragment.cS)) && (!localFragment.df)) {
          f(localFragment);
        }
        paramInt += 1;
      }
      aq();
    } while ((!this.em) || (this.cJ == null) || (this.eh != 5));
    this.cJ.ak();
    this.em = false;
  }
  
  public final void dispatchActivityCreated()
  {
    this.en = false;
    this.dL = false;
    r(2);
  }
  
  public final void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    int i = 0;
    while (i < this.dZ.size())
    {
      Fragment localFragment = (Fragment)this.dZ.get(i);
      if (localFragment != null) {
        localFragment.a(paramConfiguration);
      }
      i += 1;
    }
  }
  
  public final boolean dispatchContextItemSelected(MenuItem paramMenuItem)
  {
    if (this.eh <= 0) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.dZ.size())
      {
        Fragment localFragment = (Fragment)this.dZ.get(i);
        if ((localFragment != null) && (localFragment.b(paramMenuItem))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public final void dispatchCreate()
  {
    this.en = false;
    this.dL = false;
    r(1);
  }
  
  public final boolean dispatchCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    int j = 0;
    if (this.eh <= 0) {
      return false;
    }
    Object localObject1 = null;
    int i = 0;
    boolean bool1 = false;
    while (i < this.dZ.size())
    {
      Fragment localFragment = (Fragment)this.dZ.get(i);
      Object localObject2 = localObject1;
      boolean bool2 = bool1;
      if (localFragment != null)
      {
        localObject2 = localObject1;
        bool2 = bool1;
        if (localFragment.a(paramMenu, paramMenuInflater))
        {
          bool2 = true;
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new ArrayList();
          }
          ((ArrayList)localObject2).add(localFragment);
        }
      }
      i += 1;
      bool1 = bool2;
      localObject1 = localObject2;
    }
    if (this.ec != null)
    {
      i = j;
      while (i < this.ec.size())
      {
        paramMenu = (Fragment)this.ec.get(i);
        if (localObject1 != null) {
          localObject1.contains(paramMenu);
        }
        i += 1;
      }
    }
    this.ec = localObject1;
    return bool1;
  }
  
  public final void dispatchDestroy()
  {
    this.eo = true;
    execPendingActions();
    r(0);
    this.cJ = null;
    this.ei = null;
    this.ej = null;
  }
  
  public final void dispatchLowMemory()
  {
    int i = 0;
    while (i < this.dZ.size())
    {
      Fragment localFragment = (Fragment)this.dZ.get(i);
      if (localFragment != null) {
        localFragment.V();
      }
      i += 1;
    }
  }
  
  public final void dispatchMultiWindowModeChanged(boolean paramBoolean)
  {
    int i = this.dZ.size() - 1;
    while (i >= 0)
    {
      Fragment localFragment = (Fragment)this.dZ.get(i);
      if (localFragment != null) {
        localFragment.d(paramBoolean);
      }
      i -= 1;
    }
  }
  
  public final boolean dispatchOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (this.eh <= 0) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.dZ.size())
      {
        Fragment localFragment = (Fragment)this.dZ.get(i);
        if ((localFragment != null) && (localFragment.a(paramMenuItem))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public final void dispatchOptionsMenuClosed(Menu paramMenu)
  {
    if (this.eh <= 0) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.dZ.size())
      {
        Fragment localFragment = (Fragment)this.dZ.get(i);
        if (localFragment != null) {
          localFragment.b(paramMenu);
        }
        i += 1;
      }
    }
  }
  
  public final void dispatchPause()
  {
    r(4);
  }
  
  public final void dispatchPictureInPictureModeChanged(boolean paramBoolean)
  {
    int i = this.dZ.size() - 1;
    while (i >= 0)
    {
      Fragment localFragment = (Fragment)this.dZ.get(i);
      if (localFragment != null) {
        localFragment.e(paramBoolean);
      }
      i -= 1;
    }
  }
  
  public final boolean dispatchPrepareOptionsMenu(Menu paramMenu)
  {
    if (this.eh <= 0) {
      return false;
    }
    int i = 0;
    boolean bool2;
    for (boolean bool1 = false; i < this.dZ.size(); bool1 = bool2)
    {
      Fragment localFragment = (Fragment)this.dZ.get(i);
      bool2 = bool1;
      if (localFragment != null)
      {
        bool2 = bool1;
        if (localFragment.a(paramMenu)) {
          bool2 = true;
        }
      }
      i += 1;
    }
    return bool1;
  }
  
  public final void dispatchResume()
  {
    this.en = false;
    this.dL = false;
    r(5);
  }
  
  public final void dispatchStart()
  {
    this.en = false;
    this.dL = false;
    r(4);
  }
  
  public final void dispatchStop()
  {
    this.dL = true;
    r(3);
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int j = 0;
    String str = paramString + "    ";
    int i;
    if (this.ea != null)
    {
      k = this.ea.size();
      if (k > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("Active Fragments in ");
        paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
        paramPrintWriter.println(":");
        i = 0;
        while (i < k)
        {
          Fragment localFragment = (Fragment)this.ea.valueAt(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(localFragment);
          if (localFragment != null) {
            localFragment.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
          }
          i += 1;
        }
      }
    }
    int k = this.dZ.size();
    if (k > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Added Fragments:");
      i = 0;
      while (i < k)
      {
        paramFileDescriptor = (Fragment)this.dZ.get(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(i);
        paramPrintWriter.print(": ");
        paramPrintWriter.println(paramFileDescriptor.toString());
        i += 1;
      }
    }
    if (this.ec != null)
    {
      k = this.ec.size();
      if (k > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Fragments Created Menus:");
        i = 0;
        while (i < k)
        {
          paramFileDescriptor = (Fragment)this.ec.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(paramFileDescriptor.toString());
          i += 1;
        }
      }
    }
    if (this.eb != null)
    {
      k = this.eb.size();
      if (k > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Back Stack:");
        i = 0;
        while (i < k)
        {
          paramFileDescriptor = (e)this.eb.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(paramFileDescriptor.toString());
          paramFileDescriptor.a(str, paramPrintWriter);
          i += 1;
        }
      }
    }
    try
    {
      if (this.ed != null)
      {
        k = this.ed.size();
        if (k > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Back Stack Indices:");
          i = 0;
          while (i < k)
          {
            paramFileDescriptor = (e)this.ed.get(i);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  #");
            paramPrintWriter.print(i);
            paramPrintWriter.print(": ");
            paramPrintWriter.println(paramFileDescriptor);
            i += 1;
          }
        }
      }
      if ((this.ee != null) && (this.ee.size() > 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mAvailBackStackIndices: ");
        paramPrintWriter.println(Arrays.toString(this.ee.toArray()));
      }
      if (this.dW != null)
      {
        k = this.dW.size();
        if (k > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Pending Actions:");
          i = j;
          while (i < k)
          {
            paramFileDescriptor = (ab)this.dW.get(i);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  #");
            paramPrintWriter.print(i);
            paramPrintWriter.print(": ");
            paramPrintWriter.println(paramFileDescriptor);
            i += 1;
          }
        }
      }
      paramPrintWriter.print(paramString);
    }
    finally {}
    paramPrintWriter.println("FragmentManager misc state:");
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mHost=");
    paramPrintWriter.println(this.cJ);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mContainer=");
    paramPrintWriter.println(this.ei);
    if (this.ej != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mParent=");
      paramPrintWriter.println(this.ej);
    }
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mCurState=");
    paramPrintWriter.print(this.eh);
    paramPrintWriter.print(" mStateSaved=");
    paramPrintWriter.print(this.en);
    paramPrintWriter.print(" mStopped=");
    paramPrintWriter.print(this.dL);
    paramPrintWriter.print(" mDestroyed=");
    paramPrintWriter.println(this.eo);
    if (this.em)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mNeedMenuInvalidate=");
      paramPrintWriter.println(this.em);
    }
    if (this.ep != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mNoTransactionsBecause=");
      paramPrintWriter.println(this.ep);
    }
  }
  
  public final boolean execPendingActions()
  {
    at();
    boolean bool = false;
    for (;;)
    {
      if (d(this.er, this.es)) {
        this.dX = true;
      }
      try
      {
        c(this.er, this.es);
        au();
        bool = true;
      }
      finally
      {
        au();
      }
    }
    aA();
    return bool;
  }
  
  public final boolean executePendingTransactions()
  {
    boolean bool = execPendingActions();
    av();
    return bool;
  }
  
  final void f(final Fragment paramFragment)
  {
    if (paramFragment == null) {
      return;
    }
    int j = this.eh;
    int i = j;
    label32:
    Object localObject3;
    Object localObject1;
    label79:
    Object localObject2;
    label230:
    boolean bool;
    if (paramFragment.cC)
    {
      if (paramFragment.H()) {
        i = Math.min(j, 1);
      }
    }
    else
    {
      a(paramFragment, i, paramFragment.Y(), paramFragment.Z(), false);
      if (paramFragment.cZ != null)
      {
        localObject3 = paramFragment.cY;
        localObject1 = paramFragment.cZ;
        if ((localObject3 != null) && (localObject1 != null)) {
          break label375;
        }
        localObject1 = null;
        if (localObject1 != null)
        {
          localObject1 = ((Fragment)localObject1).cZ;
          localObject2 = paramFragment.cY;
          i = ((ViewGroup)localObject2).indexOfChild((View)localObject1);
          j = ((ViewGroup)localObject2).indexOfChild(paramFragment.cZ);
          if (j < i)
          {
            ((ViewGroup)localObject2).removeViewAt(j);
            ((ViewGroup)localObject2).addView(paramFragment.cZ, i);
          }
        }
        if ((paramFragment.df) && (paramFragment.cY != null))
        {
          if (paramFragment.dh > 0.0F) {
            paramFragment.cZ.setAlpha(paramFragment.dh);
          }
          paramFragment.dh = 0.0F;
          paramFragment.df = false;
          localObject1 = a(paramFragment, paramFragment.Y(), true, paramFragment.Z());
          if (localObject1 != null)
          {
            a(paramFragment.cZ, (x)localObject1);
            if (((x)localObject1).eL == null) {
              break label438;
            }
            paramFragment.cZ.startAnimation(((x)localObject1).eL);
          }
        }
      }
      if (!paramFragment.dg) {
        break label459;
      }
      if (paramFragment.cZ != null)
      {
        i = paramFragment.Y();
        if (paramFragment.cR) {
          break label461;
        }
        bool = true;
        label259:
        localObject1 = a(paramFragment, i, bool, paramFragment.Z());
        if ((localObject1 == null) || (((x)localObject1).eM == null)) {
          break label521;
        }
        ((x)localObject1).eM.setTarget(paramFragment.cZ);
        if (!paramFragment.cR) {
          break label510;
        }
        if (!paramFragment.af()) {
          break label467;
        }
        paramFragment.f(false);
      }
    }
    for (;;)
    {
      a(paramFragment.cZ, (x)localObject1);
      ((x)localObject1).eM.start();
      if ((paramFragment.cB) && (paramFragment.cV) && (paramFragment.cW)) {
        this.em = true;
      }
      paramFragment.dg = false;
      return;
      i = Math.min(j, 0);
      break label32;
      label375:
      i = this.dZ.indexOf(paramFragment) - 1;
      for (;;)
      {
        if (i < 0) {
          break label432;
        }
        localObject2 = (Fragment)this.dZ.get(i);
        if (((Fragment)localObject2).cY == localObject3)
        {
          localObject1 = localObject2;
          if (((Fragment)localObject2).cZ != null) {
            break;
          }
        }
        i -= 1;
      }
      label432:
      localObject1 = null;
      break label79;
      label438:
      ((x)localObject1).eM.setTarget(paramFragment.cZ);
      ((x)localObject1).eM.start();
      break label230;
      label459:
      break;
      label461:
      bool = false;
      break label259;
      label467:
      localObject2 = paramFragment.cY;
      localObject3 = paramFragment.cZ;
      ((ViewGroup)localObject2).startViewTransition((View)localObject3);
      ((x)localObject1).eM.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          this.eE.endViewTransition(this.eI);
          paramAnonymousAnimator.removeListener(this);
          if (paramFragment.cZ != null) {
            paramFragment.cZ.setVisibility(8);
          }
        }
      });
      continue;
      label510:
      paramFragment.cZ.setVisibility(0);
    }
    label521:
    if (localObject1 != null)
    {
      a(paramFragment.cZ, (x)localObject1);
      paramFragment.cZ.startAnimation(((x)localObject1).eL);
      ((x)localObject1).eL.start();
    }
    if ((paramFragment.cR) && (!paramFragment.af())) {}
    for (i = 8;; i = 0)
    {
      paramFragment.cZ.setVisibility(i);
      if (!paramFragment.af()) {
        break;
      }
      paramFragment.f(false);
      break;
    }
  }
  
  final void g(Fragment paramFragment)
  {
    if (paramFragment.bL >= 0) {}
    do
    {
      return;
      int i = this.dY;
      this.dY = (i + 1);
      paramFragment.a(i, this.ej);
      if (this.ea == null) {
        this.ea = new SparseArray();
      }
      this.ea.put(paramFragment.bL, paramFragment);
    } while (!DEBUG);
    Log.v("FragmentManager", "Allocated fragment index ".concat(String.valueOf(paramFragment)));
  }
  
  public final List<Fragment> getFragments()
  {
    if (this.dZ.isEmpty()) {
      return Collections.EMPTY_LIST;
    }
    synchronized (this.dZ)
    {
      List localList = (List)this.dZ.clone();
      return localList;
    }
  }
  
  public final void h(Fragment paramFragment)
  {
    if (DEBUG) {
      Log.v("FragmentManager", "remove: " + paramFragment + " nesting=" + paramFragment.cH);
    }
    int i;
    if (!paramFragment.H()) {
      i = 1;
    }
    for (;;)
    {
      if ((!paramFragment.cS) || (i != 0)) {}
      synchronized (this.dZ)
      {
        this.dZ.remove(paramFragment);
        if ((paramFragment.cV) && (paramFragment.cW)) {
          this.em = true;
        }
        paramFragment.cB = false;
        paramFragment.cC = true;
        return;
        i = 0;
      }
    }
  }
  
  public final boolean isStateSaved()
  {
    return (this.en) || (this.dL);
  }
  
  public final void k(Fragment paramFragment)
  {
    if (DEBUG) {
      Log.v("FragmentManager", "detach: ".concat(String.valueOf(paramFragment)));
    }
    if (!paramFragment.cS)
    {
      paramFragment.cS = true;
      if (paramFragment.cB) {
        if (DEBUG) {
          Log.v("FragmentManager", "remove from detach: ".concat(String.valueOf(paramFragment)));
        }
      }
    }
    synchronized (this.dZ)
    {
      this.dZ.remove(paramFragment);
      if ((paramFragment.cV) && (paramFragment.cW)) {
        this.em = true;
      }
      paramFragment.cB = false;
      return;
    }
  }
  
  public final void l(Fragment paramFragment)
  {
    if (DEBUG) {
      Log.v("FragmentManager", "attach: ".concat(String.valueOf(paramFragment)));
    }
    if (paramFragment.cS)
    {
      paramFragment.cS = false;
      if (!paramFragment.cB)
      {
        if (this.dZ.contains(paramFragment)) {
          throw new IllegalStateException("Fragment already added: ".concat(String.valueOf(paramFragment)));
        }
        if (DEBUG) {
          Log.v("FragmentManager", "add from attach: ".concat(String.valueOf(paramFragment)));
        }
      }
    }
    synchronized (this.dZ)
    {
      this.dZ.add(paramFragment);
      paramFragment.cB = true;
      if ((paramFragment.cV) && (paramFragment.cW)) {
        this.em = true;
      }
      return;
    }
  }
  
  public final void n(Fragment paramFragment)
  {
    if ((paramFragment != null) && ((this.ea.get(paramFragment.bL) != paramFragment) || ((paramFragment.cJ != null) && (paramFragment.cI != this)))) {
      throw new IllegalArgumentException("Fragment " + paramFragment + " is not an active fragment of FragmentManager " + this);
    }
    this.ek = paramFragment;
  }
  
  public final void noteStateNotSaved()
  {
    this.ex = null;
    this.en = false;
    this.dL = false;
    int j = this.dZ.size();
    int i = 0;
    while (i < j)
    {
      Fragment localFragment = (Fragment)this.dZ.get(i);
      if (localFragment != null) {
        localFragment.noteStateNotSaved();
      }
      i += 1;
    }
  }
  
  public final View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if (!"fragment".equals(paramString)) {
      return null;
    }
    String str1 = paramAttributeSet.getAttributeValue(null, "class");
    paramString = paramContext.obtainStyledAttributes(paramAttributeSet, aa.eR);
    if (str1 == null) {
      str1 = paramString.getString(0);
    }
    for (;;)
    {
      int k = paramString.getResourceId(1, -1);
      String str2 = paramString.getString(2);
      paramString.recycle();
      if (!Fragment.a(this.cJ.mContext, str1)) {
        return null;
      }
      if (paramView != null) {}
      for (int i = paramView.getId(); (i == -1) && (k == -1) && (str2 == null); i = 0) {
        throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str1);
      }
      int j;
      if (k != -1)
      {
        paramString = q(k);
        paramView = paramString;
        if (paramString == null)
        {
          paramView = paramString;
          if (str2 != null) {
            paramView = b(str2);
          }
        }
        paramString = paramView;
        if (paramView == null)
        {
          paramString = paramView;
          if (i != -1) {
            paramString = q(i);
          }
        }
        if (DEBUG) {
          Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(k) + " fname=" + str1 + " existing=" + paramString);
        }
        if (paramString != null) {
          break label414;
        }
        paramView = this.ei.a(paramContext, str1, null);
        paramView.cD = true;
        if (k == 0) {
          break label407;
        }
        j = k;
        label294:
        paramView.cO = j;
        paramView.cP = i;
        paramView.cQ = str2;
        paramView.cE = true;
        paramView.cI = this;
        paramView.cJ = this.cJ;
        paramView.J();
        a(paramView, true);
        label340:
        if ((this.eh > 0) || (!paramView.cD)) {
          break label528;
        }
        a(paramView, 1, 0, 0, false);
      }
      for (;;)
      {
        if (paramView.cZ != null) {
          break label536;
        }
        throw new IllegalStateException("Fragment " + str1 + " did not create a view.");
        paramString = null;
        break;
        label407:
        j = i;
        break label294;
        label414:
        if (paramString.cE) {
          throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(k) + ", tag " + str2 + ", or parent id 0x" + Integer.toHexString(i) + " with another fragment for " + str1);
        }
        paramString.cE = true;
        paramString.cJ = this.cJ;
        if (!paramString.cU) {
          paramString.J();
        }
        paramView = paramString;
        break label340;
        label528:
        e(paramView);
      }
      label536:
      if (k != 0) {
        paramView.cZ.setId(k);
      }
      if (paramView.cZ.getTag() == null) {
        paramView.cZ.setTag(str2);
      }
      return paramView.cZ;
    }
  }
  
  public final View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return onCreateView(null, paramString, paramContext, paramAttributeSet);
  }
  
  public final void p(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("Bad id: ".concat(String.valueOf(paramInt)));
    }
    a(new ac(this, paramInt, 1), false);
  }
  
  public final boolean popBackStackImmediate()
  {
    ar();
    return ap();
  }
  
  final Parcelable saveAllState()
  {
    Object localObject3 = null;
    int k = 0;
    av();
    label20:
    Object localObject1;
    Object localObject2;
    if (this.ea == null)
    {
      i = 0;
      j = 0;
      if (j >= i) {
        break label141;
      }
      localObject1 = (Fragment)this.ea.valueAt(j);
      if (localObject1 != null)
      {
        if (((Fragment)localObject1).ac() == null) {
          break label122;
        }
        m = ((Fragment)localObject1).ae();
        localObject2 = ((Fragment)localObject1).ac();
        localObject4 = ((View)localObject2).getAnimation();
        if (localObject4 != null)
        {
          ((Animation)localObject4).cancel();
          ((View)localObject2).clearAnimation();
        }
        ((Fragment)localObject1).b(null);
        a((Fragment)localObject1, m, 0, 0, false);
      }
    }
    for (;;)
    {
      j += 1;
      break label20;
      i = this.ea.size();
      break;
      label122:
      if (((Fragment)localObject1).ad() != null) {
        ((Fragment)localObject1).ad().end();
      }
    }
    label141:
    execPendingActions();
    this.en = true;
    this.ex = null;
    if ((this.ea == null) || (this.ea.size() <= 0)) {
      return null;
    }
    int m = this.ea.size();
    Object localObject4 = new FragmentState[m];
    int j = 0;
    int i = 0;
    label195:
    Fragment localFragment;
    FragmentState localFragmentState;
    if (j < m)
    {
      localFragment = (Fragment)this.ea.valueAt(j);
      if (localFragment == null) {
        break label1114;
      }
      if (localFragment.bL < 0) {
        a(new IllegalStateException("Failure saving state: active " + localFragment + " has cleared index: " + localFragment.bL));
      }
      localFragmentState = new FragmentState(localFragment);
      localObject4[j] = localFragmentState;
      if ((localFragment.cs > 0) && (localFragmentState.ct == null))
      {
        if (this.eu == null) {
          this.eu = new Bundle();
        }
        localObject1 = this.eu;
        localFragment.onSaveInstanceState((Bundle)localObject1);
        if (localFragment.cK != null)
        {
          localObject2 = localFragment.cK.saveAllState();
          if (localObject2 != null) {
            ((Bundle)localObject1).putParcelable("android:support:fragments", (Parcelable)localObject2);
          }
        }
        d(localFragment, this.eu, false);
        if (this.eu.isEmpty()) {
          break label1117;
        }
        localObject2 = this.eu;
        this.eu = null;
      }
    }
    for (;;)
    {
      if (localFragment.cZ != null) {
        m(localFragment);
      }
      localObject1 = localObject2;
      if (localFragment.cu != null)
      {
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new Bundle();
        }
        ((Bundle)localObject1).putSparseParcelableArray("android:view_state", localFragment.cu);
      }
      localObject2 = localObject1;
      if (!localFragment.dc)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new Bundle();
        }
        ((Bundle)localObject2).putBoolean("android:user_visible_hint", localFragment.dc);
      }
      localFragmentState.ct = ((Bundle)localObject2);
      if (localFragment.cy != null)
      {
        if (localFragment.cy.bL < 0) {
          a(new IllegalStateException("Failure saving state: " + localFragment + " has target not in fragment manager: " + localFragment.cy));
        }
        if (localFragmentState.ct == null) {
          localFragmentState.ct = new Bundle();
        }
        localObject1 = localFragmentState.ct;
        localObject2 = localFragment.cy;
        if (((Fragment)localObject2).bL < 0) {
          a(new IllegalStateException("Fragment " + localObject2 + " is not currently in the FragmentManager"));
        }
        ((Bundle)localObject1).putInt("android:target_state", ((Fragment)localObject2).bL);
        if (localFragment.cA != 0) {
          localFragmentState.ct.putInt("android:target_req_state", localFragment.cA);
        }
      }
      label682:
      if (DEBUG) {
        Log.v("FragmentManager", "Saved state of " + localFragment + ": " + localFragmentState.ct);
      }
      i = 1;
      label1114:
      for (;;)
      {
        j += 1;
        break label195;
        localFragmentState.ct = localFragment.ct;
        break label682;
        if (i == 0)
        {
          if (!DEBUG) {
            break;
          }
          Log.v("FragmentManager", "saveAllState: no fragments!");
          return null;
        }
        j = this.dZ.size();
        if (j > 0)
        {
          localObject2 = new int[j];
          i = 0;
          for (;;)
          {
            localObject1 = localObject2;
            if (i >= j) {
              break;
            }
            localObject2[i] = ((Fragment)this.dZ.get(i)).bL;
            if (localObject2[i] < 0) {
              a(new IllegalStateException("Failure saving state: active " + this.dZ.get(i) + " has cleared index: " + localObject2[i]));
            }
            if (DEBUG) {
              Log.v("FragmentManager", "saveAllState: adding fragment #" + i + ": " + this.dZ.get(i));
            }
            i += 1;
          }
        }
        localObject1 = null;
        localObject2 = localObject3;
        if (this.eb != null)
        {
          j = this.eb.size();
          localObject2 = localObject3;
          if (j > 0)
          {
            localObject3 = new BackStackState[j];
            i = k;
            for (;;)
            {
              localObject2 = localObject3;
              if (i >= j) {
                break;
              }
              localObject3[i] = new BackStackState((e)this.eb.get(i));
              if (DEBUG) {
                Log.v("FragmentManager", "saveAllState: adding back stack #" + i + ": " + this.eb.get(i));
              }
              i += 1;
            }
          }
        }
        localObject3 = new FragmentManagerState();
        ((FragmentManagerState)localObject3).fa = ((FragmentState[])localObject4);
        ((FragmentManagerState)localObject3).fb = ((int[])localObject1);
        ((FragmentManagerState)localObject3).fc = ((BackStackState[])localObject2);
        if (this.ek != null) {
          ((FragmentManagerState)localObject3).fd = this.ek.bL;
        }
        ((FragmentManagerState)localObject3).dY = this.dY;
        az();
        return localObject3;
      }
      label1117:
      localObject2 = null;
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("FragmentManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    if (this.ej != null) {
      d.a(this.ej, localStringBuilder);
    }
    for (;;)
    {
      localStringBuilder.append("}}");
      return localStringBuilder.toString();
      d.a(this.cJ, localStringBuilder);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.u
 * JD-Core Version:    0.7.0.1
 */