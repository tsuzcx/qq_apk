package android.support.v4.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.arch.lifecycle.c;
import android.arch.lifecycle.f;
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
import android.support.v4.b.e;
import android.support.v4.b.m;
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

final class t
  extends s
  implements LayoutInflater.Factory2
{
  static boolean DEBUG = false;
  static Field cC = null;
  static final Interpolator cQ = new DecelerateInterpolator(2.5F);
  static final Interpolator cR = new DecelerateInterpolator(1.5F);
  static final Interpolator cS = new AccelerateInterpolator(2.5F);
  static final Interpolator cT = new AccelerateInterpolator(1.5F);
  r aZ;
  Fragment cA;
  Fragment cB;
  boolean cD;
  boolean cE;
  boolean cF;
  String cG;
  boolean cH;
  ArrayList<d> cI;
  ArrayList<Boolean> cJ;
  ArrayList<Fragment> cK;
  Bundle cL = null;
  SparseArray<Parcelable> cM = null;
  ArrayList<ab> cN;
  ac cO;
  Runnable cP = new Runnable()
  {
    public final void run()
    {
      t.this.execPendingActions();
    }
  };
  ArrayList<z> cn;
  boolean co;
  int cp = 0;
  final ArrayList<Fragment> cq = new ArrayList();
  SparseArray<Fragment> cr;
  ArrayList<d> cs;
  ArrayList<Fragment> ct;
  ArrayList<d> cu;
  ArrayList<Integer> cv;
  ArrayList<Object> cw;
  private final CopyOnWriteArrayList<m<Object, Boolean>> cx = new CopyOnWriteArrayList();
  int cy = 0;
  p cz;
  
  private int a(ArrayList<d> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2, b<Fragment> paramb)
  {
    int j = paramInt2 - 1;
    int i = paramInt2;
    d locald;
    int k;
    if (j >= paramInt1)
    {
      locald = (d)paramArrayList.get(j);
      boolean bool = ((Boolean)paramArrayList1.get(j)).booleanValue();
      if ((locald.k()) && (!locald.a(paramArrayList, j + 1, paramInt2)))
      {
        k = 1;
        label67:
        if (k == 0) {
          break label191;
        }
        if (this.cN == null) {
          this.cN = new ArrayList();
        }
        ab localab = new ab(locald, bool);
        this.cN.add(localab);
        locald.a(localab);
        if (!bool) {
          break label179;
        }
        locald.j();
        label130:
        i -= 1;
        if (j != i)
        {
          paramArrayList.remove(j);
          paramArrayList.add(i, locald);
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
      locald.b(false);
      break label130;
      return i;
    }
  }
  
  private static w a(float paramFloat1, float paramFloat2)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat1, paramFloat2);
    localAlphaAnimation.setInterpolator(cR);
    localAlphaAnimation.setDuration(220L);
    return new w(localAlphaAnimation, (byte)0);
  }
  
  private static w a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    Object localObject = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setInterpolator(cQ);
    ((ScaleAnimation)localObject).setDuration(220L);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(paramFloat3, paramFloat4);
    ((AlphaAnimation)localObject).setInterpolator(cR);
    ((AlphaAnimation)localObject).setDuration(220L);
    localAnimationSet.addAnimation((Animation)localObject);
    return new w(localAnimationSet, (byte)0);
  }
  
  private w a(Fragment paramFragment, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    int j = paramFragment.H();
    Fragment.u();
    Fragment.v();
    if (j != 0)
    {
      boolean bool = "anim".equals(this.aZ.mContext.getResources().getResourceTypeName(j));
      if (bool) {}
      for (;;)
      {
        try
        {
          paramFragment = AnimationUtils.loadAnimation(this.aZ.mContext, j);
          if (paramFragment != null)
          {
            paramFragment = new w(paramFragment, (byte)0);
            return paramFragment;
          }
          i = 1;
          if (i != 0) {
            break label157;
          }
          try
          {
            paramFragment = AnimatorInflater.loadAnimator(this.aZ.mContext, j);
            if (paramFragment == null) {
              break label157;
            }
            paramFragment = new w(paramFragment, (byte)0);
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
      paramFragment = AnimationUtils.loadAnimation(this.aZ.mContext, j);
      if (paramFragment != null) {
        return new w(paramFragment, (byte)0);
      }
    }
    label157:
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
        if (this.aZ.onHasWindowAnimations()) {
          paramInt1 = this.aZ.onGetWindowAnimations();
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
      if (cC == null)
      {
        Field localField = Animation.class.getDeclaredField("mListener");
        cC = localField;
        localField.setAccessible(true);
      }
      paramAnimation = (Animation.AnimationListener)cC.get(paramAnimation);
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
  private void a(int paramInt, d paramd)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 328	android/support/v4/app/t:cu	Ljava/util/ArrayList;
    //   6: ifnonnull +14 -> 20
    //   9: aload_0
    //   10: new 105	java/util/ArrayList
    //   13: dup
    //   14: invokespecial 106	java/util/ArrayList:<init>	()V
    //   17: putfield 328	android/support/v4/app/t:cu	Ljava/util/ArrayList;
    //   20: aload_0
    //   21: getfield 328	android/support/v4/app/t:cu	Ljava/util/ArrayList;
    //   24: invokevirtual 331	java/util/ArrayList:size	()I
    //   27: istore 4
    //   29: iload 4
    //   31: istore_3
    //   32: iload_1
    //   33: iload 4
    //   35: if_icmpge +56 -> 91
    //   38: getstatic 77	android/support/v4/app/t:DEBUG	Z
    //   41: ifeq +37 -> 78
    //   44: ldc_w 315
    //   47: new 333	java/lang/StringBuilder
    //   50: dup
    //   51: ldc_w 335
    //   54: invokespecial 338	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   57: iload_1
    //   58: invokevirtual 342	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   61: ldc_w 344
    //   64: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_2
    //   68: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 357	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   77: pop
    //   78: aload_0
    //   79: getfield 328	android/support/v4/app/t:cu	Ljava/util/ArrayList;
    //   82: iload_1
    //   83: aload_2
    //   84: invokevirtual 361	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   87: pop
    //   88: aload_0
    //   89: monitorexit
    //   90: return
    //   91: iload_3
    //   92: iload_1
    //   93: if_icmpge +79 -> 172
    //   96: aload_0
    //   97: getfield 328	android/support/v4/app/t:cu	Ljava/util/ArrayList;
    //   100: aconst_null
    //   101: invokevirtual 155	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   104: pop
    //   105: aload_0
    //   106: getfield 363	android/support/v4/app/t:cv	Ljava/util/ArrayList;
    //   109: ifnonnull +14 -> 123
    //   112: aload_0
    //   113: new 105	java/util/ArrayList
    //   116: dup
    //   117: invokespecial 106	java/util/ArrayList:<init>	()V
    //   120: putfield 363	android/support/v4/app/t:cv	Ljava/util/ArrayList;
    //   123: getstatic 77	android/support/v4/app/t:DEBUG	Z
    //   126: ifeq +27 -> 153
    //   129: ldc_w 315
    //   132: new 333	java/lang/StringBuilder
    //   135: dup
    //   136: ldc_w 365
    //   139: invokespecial 338	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   142: iload_3
    //   143: invokevirtual 342	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   146: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 357	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   152: pop
    //   153: aload_0
    //   154: getfield 363	android/support/v4/app/t:cv	Ljava/util/ArrayList;
    //   157: iload_3
    //   158: invokestatic 371	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   161: invokevirtual 155	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   164: pop
    //   165: iload_3
    //   166: iconst_1
    //   167: iadd
    //   168: istore_3
    //   169: goto -78 -> 91
    //   172: getstatic 77	android/support/v4/app/t:DEBUG	Z
    //   175: ifeq +37 -> 212
    //   178: ldc_w 315
    //   181: new 333	java/lang/StringBuilder
    //   184: dup
    //   185: ldc_w 373
    //   188: invokespecial 338	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   191: iload_1
    //   192: invokevirtual 342	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   195: ldc_w 375
    //   198: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload_2
    //   202: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   205: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 357	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   211: pop
    //   212: aload_0
    //   213: getfield 328	android/support/v4/app/t:cu	Ljava/util/ArrayList;
    //   216: aload_2
    //   217: invokevirtual 155	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   220: pop
    //   221: goto -133 -> 88
    //   224: astore_2
    //   225: aload_0
    //   226: monitorexit
    //   227: aload_2
    //   228: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	t
    //   0	229	1	paramInt	int
    //   0	229	2	paramd	d
    //   31	138	3	i	int
    //   27	9	4	j	int
    // Exception table:
    //   from	to	target	type
    //   2	20	224	finally
    //   20	29	224	finally
    //   38	78	224	finally
    //   78	88	224	finally
    //   88	90	224	finally
    //   96	123	224	finally
    //   123	153	224	finally
    //   153	165	224	finally
    //   172	212	224	finally
    //   212	221	224	finally
    //   225	227	224	finally
  }
  
  private void a(Fragment paramFragment, Context paramContext, boolean paramBoolean)
  {
    if (this.cA != null)
    {
      t localt = this.cA.aY;
      if ((localt instanceof t)) {
        ((t)localt).a(paramFragment, paramContext, true);
      }
    }
    paramFragment = this.cx.iterator();
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
    if (this.cA != null)
    {
      t localt = this.cA.aY;
      if ((localt instanceof t)) {
        ((t)localt).a(paramFragment, paramBundle, true);
      }
    }
    paramFragment = this.cx.iterator();
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
    if (this.cA != null)
    {
      t localt = this.cA.aY;
      if ((localt instanceof t)) {
        ((t)localt).a(paramFragment, paramView, paramBundle, true);
      }
    }
    paramFragment = this.cx.iterator();
    while (paramFragment.hasNext())
    {
      paramView = (m)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)paramView.second).booleanValue();
      }
    }
  }
  
  private static void a(ac paramac)
  {
    if (paramac == null) {}
    for (;;)
    {
      return;
      Object localObject = paramac.getFragments();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Fragment)((Iterator)localObject).next()).bj = true;
        }
      }
      paramac = paramac.ap();
      if (paramac != null)
      {
        paramac = paramac.iterator();
        while (paramac.hasNext()) {
          a((ac)paramac.next());
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
      if (!localFragment.aR)
      {
        View localView = localFragment.bo;
        localFragment.by = localView.getAlpha();
        localView.setAlpha(0.0F);
      }
      i += 1;
    }
  }
  
  private static void a(View paramView, w paramw)
  {
    int j = 0;
    if ((paramView == null) || (paramw == null)) {
      return;
    }
    int i = j;
    if (paramView != null)
    {
      if (paramw != null) {
        break label50;
      }
      i = j;
    }
    label23:
    label50:
    boolean bool;
    while (i != 0)
    {
      if (paramw.dc == null) {
        break label183;
      }
      paramw.dc.addListener(new x(paramView));
      return;
      i = j;
      if (Build.VERSION.SDK_INT >= 19)
      {
        i = j;
        if (paramView.getLayerType() == 0)
        {
          i = j;
          if (android.support.v4.view.r.s(paramView))
          {
            if (!(paramw.db instanceof AlphaAnimation)) {
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
      if ((paramw.db instanceof AnimationSet))
      {
        localObject = ((AnimationSet)paramw.db).getAnimations();
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
        bool = b(paramw.dc);
      }
    }
    label183:
    Object localObject = a(paramw.db);
    paramView.setLayerType(2, null);
    paramw.db.setAnimationListener(new u(paramView, (Animation.AnimationListener)localObject));
  }
  
  private void a(RuntimeException paramRuntimeException)
  {
    Log.e("FragmentManager", paramRuntimeException.getMessage());
    Log.e("FragmentManager", "Activity state:");
    PrintWriter localPrintWriter = new PrintWriter(new e("FragmentManager"));
    if (this.aZ != null) {}
    for (;;)
    {
      try
      {
        this.aZ.a("  ", localPrintWriter, new String[0]);
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
  
  private void a(ArrayList<d> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2)
  {
    boolean bool = ((d)paramArrayList.get(paramInt1)).aj;
    Object localObject;
    int j;
    label55:
    d locald;
    if (this.cK == null)
    {
      this.cK = new ArrayList();
      this.cK.addAll(this.cq);
      localObject = this.cB;
      j = paramInt1;
      i = 0;
      if (j >= paramInt2) {
        break label158;
      }
      locald = (d)paramArrayList.get(j);
      if (((Boolean)paramArrayList1.get(j)).booleanValue()) {
        break label136;
      }
      localObject = locald.a(this.cK, (Fragment)localObject);
      label101:
      if ((i == 0) && (!locald.Z)) {
        break label152;
      }
    }
    label136:
    label152:
    for (int i = 1;; i = 0)
    {
      j += 1;
      break label55;
      this.cK.clear();
      break;
      localObject = locald.b(this.cK, (Fragment)localObject);
      break label101;
    }
    label158:
    this.cK.clear();
    if (!bool) {
      af.a(this, paramArrayList, paramArrayList1, paramInt1, paramInt2, false);
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
          af.a(this, paramArrayList, paramArrayList1, paramInt1, k, true);
          a(this.cy, true);
          j = paramInt1;
        }
      }
      while (j < paramInt2)
      {
        localObject = (d)paramArrayList.get(j);
        if ((((Boolean)paramArrayList1.get(j)).booleanValue()) && (((d)localObject).ac >= 0)) {
          paramInt1 = ((d)localObject).ac;
        }
        try
        {
          this.cu.set(paramInt1, null);
          if (this.cv == null) {
            this.cv = new ArrayList();
          }
          if (DEBUG) {
            Log.v("FragmentManager", "Freeing back stack index " + paramInt1);
          }
          this.cv.add(Integer.valueOf(paramInt1));
          ((d)localObject).ac = -1;
          ((d)localObject).i();
          j += 1;
        }
        finally {}
      }
      if (i != 0) {
        ai();
      }
      return;
      k = paramInt2;
    }
  }
  
  private boolean aa()
  {
    execPendingActions();
    ae();
    if (this.cB != null)
    {
      t localt = this.cB.ba;
      if ((localt != null) && (localt.popBackStackImmediate())) {
        return true;
      }
    }
    boolean bool = a(this.cI, this.cJ, null, -1, 0);
    if (bool) {
      this.co = true;
    }
    try
    {
      c(this.cI, this.cJ);
      af();
      ah();
      return bool;
    }
    finally
    {
      af();
    }
  }
  
  private void ab()
  {
    if (this.cr == null) {
      return;
    }
    int i = 0;
    label10:
    Fragment localFragment;
    if (i < this.cr.size())
    {
      localFragment = (Fragment)this.cr.valueAt(i);
      if ((localFragment != null) && (localFragment.bq))
      {
        if (!this.co) {
          break label63;
        }
        this.cH = true;
      }
    }
    for (;;)
    {
      i += 1;
      break label10;
      break;
      label63:
      localFragment.bq = false;
      a(localFragment, this.cy, 0, 0, false);
    }
  }
  
  private void ac()
  {
    if (this.cE) {
      throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }
    if (this.cG != null) {
      throw new IllegalStateException("Can not perform this action inside of " + this.cG);
    }
  }
  
  private void ad()
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
        if ((this.cN == null) || (this.cN.isEmpty())) {
          break label92;
        }
        i = 1;
        if ((this.cn == null) || (this.cn.size() != 1)) {
          break label97;
        }
      }
      finally {}
      this.aZ.getHandler().removeCallbacks(this.cP);
      this.aZ.getHandler().post(this.cP);
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
  
  private void ae()
  {
    if (this.co) {
      throw new IllegalStateException("FragmentManager is already executing transactions");
    }
    if (Looper.myLooper() != this.aZ.getHandler().getLooper()) {
      throw new IllegalStateException("Must be called from main thread of fragment host");
    }
    if (this.cI == null)
    {
      this.cI = new ArrayList();
      this.cJ = new ArrayList();
    }
    this.co = true;
    try
    {
      b(null, null);
      return;
    }
    finally
    {
      this.co = false;
    }
  }
  
  private void af()
  {
    this.co = false;
    this.cJ.clear();
    this.cI.clear();
  }
  
  private void ag()
  {
    if (this.cN != null) {
      while (!this.cN.isEmpty()) {
        ((ab)this.cN.remove(0)).an();
      }
    }
  }
  
  private void ah()
  {
    if (this.cH)
    {
      int i = 0;
      boolean bool2;
      for (boolean bool1 = false; i < this.cr.size(); bool1 = bool2)
      {
        Fragment localFragment = (Fragment)this.cr.valueAt(i);
        bool2 = bool1;
        if (localFragment != null)
        {
          bool2 = bool1;
          if (localFragment.bs != null) {
            bool2 = bool1 | localFragment.bs.aq();
          }
        }
        i += 1;
      }
      if (!bool1)
      {
        this.cH = false;
        ab();
      }
    }
  }
  
  private void ai()
  {
    if (this.cw != null)
    {
      int i = 0;
      while (i < this.cw.size())
      {
        this.cw.get(i);
        i += 1;
      }
    }
  }
  
  private void ak()
  {
    int i;
    Object localObject4;
    Object localObject3;
    if (this.cr != null)
    {
      i = 0;
      Object localObject1 = null;
      Object localObject2 = null;
      localObject4 = localObject1;
      localObject3 = localObject2;
      if (i >= this.cr.size()) {
        break label288;
      }
      Object localObject5 = (Fragment)this.cr.valueAt(i);
      if (localObject5 == null) {
        break label320;
      }
      localObject3 = localObject2;
      int j;
      if (((Fragment)localObject5).bi)
      {
        localObject4 = localObject2;
        if (localObject2 == null) {
          localObject4 = new ArrayList();
        }
        ((ArrayList)localObject4).add(localObject5);
        if (((Fragment)localObject5).aO == null) {
          break label229;
        }
        j = ((Fragment)localObject5).aO.ac;
        ((Fragment)localObject5).aP = j;
        localObject3 = localObject4;
        if (DEBUG)
        {
          Log.v("FragmentManager", "retainNonConfig: keeping retained " + localObject5);
          localObject3 = localObject4;
        }
      }
      if (((Fragment)localObject5).ba != null) {
        ((Fragment)localObject5).ba.ak();
      }
      for (localObject4 = ((Fragment)localObject5).ba.cO;; localObject4 = ((Fragment)localObject5).bb)
      {
        localObject2 = localObject1;
        if (localObject1 != null) {
          break label244;
        }
        localObject2 = localObject1;
        if (localObject4 == null) {
          break label244;
        }
        localObject1 = new ArrayList(this.cr.size());
        j = 0;
        for (;;)
        {
          localObject2 = localObject1;
          if (j >= i) {
            break;
          }
          ((ArrayList)localObject1).add(null);
          j += 1;
        }
        label229:
        j = -1;
        break;
      }
      label244:
      localObject5 = localObject2;
      localObject1 = localObject5;
      localObject2 = localObject3;
      if (localObject5 != null)
      {
        ((ArrayList)localObject5).add(localObject4);
        localObject2 = localObject3;
        localObject1 = localObject5;
      }
    }
    label288:
    label320:
    for (;;)
    {
      i += 1;
      break;
      localObject4 = null;
      localObject3 = null;
      if ((localObject3 == null) && (localObject4 == null))
      {
        this.cO = null;
        return;
      }
      this.cO = new ac(localObject3, (List)localObject4);
      return;
    }
  }
  
  private void al()
  {
    if (this.cr != null)
    {
      int i = this.cr.size() - 1;
      while (i >= 0)
      {
        if (this.cr.valueAt(i) == null) {
          this.cr.delete(this.cr.keyAt(i));
        }
        i -= 1;
      }
    }
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
      localFragment = (Fragment)this.cr.get(i);
      paramBundle = localFragment;
    } while (localFragment != null);
    a(new IllegalStateException("Fragment no longer exists for key " + paramString + ": index " + i));
    return localFragment;
  }
  
  private void b(Fragment paramFragment, Context paramContext, boolean paramBoolean)
  {
    if (this.cA != null)
    {
      t localt = this.cA.aY;
      if ((localt instanceof t)) {
        ((t)localt).b(paramFragment, paramContext, true);
      }
    }
    paramFragment = this.cx.iterator();
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
    if (this.cA != null)
    {
      t localt = this.cA.aY;
      if ((localt instanceof t)) {
        ((t)localt).b(paramFragment, paramBundle, true);
      }
    }
    paramFragment = this.cx.iterator();
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
    if (this.cA != null)
    {
      localObject = this.cA.aY;
      if ((localObject instanceof t)) {
        ((t)localObject).b(paramFragment, true);
      }
    }
    paramFragment = this.cx.iterator();
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
    if (this.cy <= 0) {}
    for (;;)
    {
      return;
      int j = Math.min(this.cy, 4);
      int k = this.cq.size();
      int i = 0;
      while (i < k)
      {
        Fragment localFragment = (Fragment)this.cq.get(i);
        if (localFragment.aJ < j)
        {
          a(localFragment, j, localFragment.H(), localFragment.I(), false);
          if ((localFragment.bo != null) && (!localFragment.bg) && (localFragment.bw)) {
            paramb.add(localFragment);
          }
        }
        i += 1;
      }
    }
  }
  
  private void b(ArrayList<d> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    int i;
    int j;
    label12:
    ab localab;
    int k;
    if (this.cN == null)
    {
      i = 0;
      j = 0;
      if (j >= i) {
        return;
      }
      localab = (ab)this.cN.get(j);
      if ((paramArrayList == null) || (ab.a(localab))) {
        break label101;
      }
      k = paramArrayList.indexOf(ab.b(localab));
      if ((k == -1) || (!((Boolean)paramArrayList1.get(k)).booleanValue())) {
        break label101;
      }
      localab.ao();
    }
    for (;;)
    {
      j += 1;
      break label12;
      i = this.cN.size();
      break;
      label101:
      int m;
      if (!localab.am())
      {
        m = j;
        k = i;
        if (paramArrayList != null)
        {
          m = j;
          k = i;
          if (!ab.b(localab).a(paramArrayList, 0, paramArrayList.size())) {}
        }
      }
      else
      {
        this.cN.remove(j);
        m = j - 1;
        k = i - 1;
        if ((paramArrayList != null) && (!ab.a(localab)))
        {
          i = paramArrayList.indexOf(ab.b(localab));
          if ((i != -1) && (((Boolean)paramArrayList1.get(i)).booleanValue()))
          {
            localab.ao();
            j = m;
            i = k;
            continue;
          }
        }
        localab.an();
      }
      j = m;
      i = k;
    }
  }
  
  private static void b(ArrayList<d> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2)
    {
      d locald = (d)paramArrayList.get(paramInt1);
      boolean bool;
      if (((Boolean)paramArrayList1.get(paramInt1)).booleanValue())
      {
        locald.b(-1);
        if (paramInt1 == paramInt2 - 1)
        {
          bool = true;
          label45:
          locald.b(bool);
        }
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        bool = false;
        break label45;
        locald.b(1);
        locald.j();
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
    if (this.cA != null)
    {
      t localt = this.cA.aY;
      if ((localt instanceof t)) {
        ((t)localt).c(paramFragment, paramBundle, true);
      }
    }
    paramFragment = this.cx.iterator();
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
    if (this.cA != null)
    {
      localObject = this.cA.aY;
      if ((localObject instanceof t)) {
        ((t)localObject).c(paramFragment, true);
      }
    }
    paramFragment = this.cx.iterator();
    while (paramFragment.hasNext())
    {
      localObject = (m)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)((m)localObject).second).booleanValue();
      }
    }
  }
  
  private void c(ArrayList<d> paramArrayList, ArrayList<Boolean> paramArrayList1)
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
      if (((d)paramArrayList.get(i)).aj) {
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
          if (((d)paramArrayList.get(k)).aj) {
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
    if (this.cA != null)
    {
      t localt = this.cA.aY;
      if ((localt instanceof t)) {
        ((t)localt).d(paramFragment, paramBundle, true);
      }
    }
    paramFragment = this.cx.iterator();
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
    if (this.cA != null)
    {
      localObject = this.cA.aY;
      if ((localObject instanceof t)) {
        ((t)localObject).d(paramFragment, true);
      }
    }
    paramFragment = this.cx.iterator();
    while (paramFragment.hasNext())
    {
      localObject = (m)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)((m)localObject).second).booleanValue();
      }
    }
  }
  
  private boolean d(ArrayList<d> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    try
    {
      if ((this.cn == null) || (this.cn.size() == 0)) {
        return false;
      }
      int j = this.cn.size();
      int i = 0;
      boolean bool = false;
      while (i < j)
      {
        bool |= ((z)this.cn.get(i)).a(paramArrayList, paramArrayList1);
        i += 1;
      }
      this.cn.clear();
      this.aZ.getHandler().removeCallbacks(this.cP);
      return bool;
    }
    finally {}
  }
  
  private void e(Fragment paramFragment)
  {
    a(paramFragment, this.cy, 0, 0, false);
  }
  
  private void e(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject;
    if (this.cA != null)
    {
      localObject = this.cA.aY;
      if ((localObject instanceof t)) {
        ((t)localObject).e(paramFragment, true);
      }
    }
    paramFragment = this.cx.iterator();
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
    if (this.cA != null)
    {
      localObject = this.cA.aY;
      if ((localObject instanceof t)) {
        ((t)localObject).f(paramFragment, true);
      }
    }
    paramFragment = this.cx.iterator();
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
    if (this.cA != null)
    {
      localObject = this.cA.aY;
      if ((localObject instanceof t)) {
        ((t)localObject).g(paramFragment, true);
      }
    }
    paramFragment = this.cx.iterator();
    while (paramFragment.hasNext())
    {
      localObject = (m)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)((m)localObject).second).booleanValue();
      }
    }
  }
  
  private Fragment h(int paramInt)
  {
    int i = this.cq.size() - 1;
    Object localObject;
    while (i >= 0)
    {
      localObject = (Fragment)this.cq.get(i);
      if ((localObject != null) && (((Fragment)localObject).bd == paramInt)) {
        return localObject;
      }
      i -= 1;
    }
    if (this.cr != null)
    {
      i = this.cr.size() - 1;
      for (;;)
      {
        if (i < 0) {
          break label105;
        }
        Fragment localFragment = (Fragment)this.cr.valueAt(i);
        if (localFragment != null)
        {
          localObject = localFragment;
          if (localFragment.bd == paramInt) {
            break;
          }
        }
        i -= 1;
      }
    }
    label105:
    return null;
  }
  
  private void h(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject;
    if (this.cA != null)
    {
      localObject = this.cA.aY;
      if ((localObject instanceof t)) {
        ((t)localObject).h(paramFragment, true);
      }
    }
    paramFragment = this.cx.iterator();
    while (paramFragment.hasNext())
    {
      localObject = (m)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)((m)localObject).second).booleanValue();
      }
    }
  }
  
  private void i(int paramInt)
  {
    try
    {
      this.co = true;
      a(paramInt, false);
      this.co = false;
      execPendingActions();
      return;
    }
    finally
    {
      this.co = false;
    }
  }
  
  public static void i(Fragment paramFragment)
  {
    boolean bool = true;
    if (DEBUG) {
      Log.v("FragmentManager", "hide: " + paramFragment);
    }
    if (!paramFragment.bg)
    {
      paramFragment.bg = true;
      if (paramFragment.bx) {
        break label57;
      }
    }
    for (;;)
    {
      paramFragment.bx = bool;
      return;
      label57:
      bool = false;
    }
  }
  
  public static int j(int paramInt)
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
  
  public static void j(Fragment paramFragment)
  {
    boolean bool = false;
    if (DEBUG) {
      Log.v("FragmentManager", "show: " + paramFragment);
    }
    if (paramFragment.bg)
    {
      paramFragment.bg = false;
      if (!paramFragment.bx) {
        bool = true;
      }
      paramFragment.bx = bool;
    }
  }
  
  private void m(Fragment paramFragment)
  {
    if (paramFragment.bp == null) {
      return;
    }
    if (this.cM == null) {
      this.cM = new SparseArray();
    }
    for (;;)
    {
      paramFragment.bp.saveHierarchyState(this.cM);
      if (this.cM.size() <= 0) {
        break;
      }
      paramFragment.aL = this.cM;
      this.cM = null;
      return;
      this.cM.clear();
    }
  }
  
  public final void W()
  {
    i(2);
  }
  
  public final ae Z()
  {
    return new d(this);
  }
  
  public final int a(d paramd)
  {
    try
    {
      if ((this.cv == null) || (this.cv.size() <= 0))
      {
        if (this.cu == null) {
          this.cu = new ArrayList();
        }
        i = this.cu.size();
        if (DEBUG) {
          Log.v("FragmentManager", "Setting back stack index " + i + " to " + paramd);
        }
        this.cu.add(paramd);
        return i;
      }
      int i = ((Integer)this.cv.remove(this.cv.size() - 1)).intValue();
      if (DEBUG) {
        Log.v("FragmentManager", "Adding back stack index " + i + " with " + paramd);
      }
      this.cu.set(i, paramd);
      return i;
    }
    finally {}
  }
  
  public final Fragment a(String paramString)
  {
    if ((this.cr != null) && (paramString != null))
    {
      int i = this.cr.size() - 1;
      while (i >= 0)
      {
        Fragment localFragment = (Fragment)this.cr.valueAt(i);
        if (localFragment != null)
        {
          if (paramString.equals(localFragment.aM)) {}
          while (localFragment != null)
          {
            return localFragment;
            if (localFragment.ba != null) {
              localFragment = localFragment.ba.a(paramString);
            } else {
              localFragment = null;
            }
          }
        }
        i -= 1;
      }
    }
    return null;
  }
  
  final void a(int paramInt, boolean paramBoolean)
  {
    if ((this.aZ == null) && (paramInt != 0)) {
      throw new IllegalStateException("No activity");
    }
    if ((!paramBoolean) && (paramInt == this.cy)) {}
    do
    {
      return;
      this.cy = paramInt;
    } while (this.cr == null);
    int j = this.cq.size();
    int i = 0;
    paramInt = 0;
    label60:
    Fragment localFragment;
    if (i < j)
    {
      localFragment = (Fragment)this.cq.get(i);
      f(localFragment);
      if (localFragment.bs == null) {
        break label248;
      }
      paramInt = localFragment.bs.aq() | paramInt;
    }
    label245:
    label248:
    for (;;)
    {
      i += 1;
      break label60;
      j = this.cr.size();
      i = 0;
      label122:
      if (i < j)
      {
        localFragment = (Fragment)this.cr.valueAt(i);
        if ((localFragment == null) || ((!localFragment.aS) && (!localFragment.bh)) || (localFragment.bw)) {
          break label245;
        }
        f(localFragment);
        if (localFragment.bs == null) {
          break label245;
        }
        paramInt = localFragment.bs.aq() | paramInt;
      }
      for (;;)
      {
        i += 1;
        break label122;
        if (paramInt == 0) {
          ab();
        }
        if ((!this.cD) || (this.aZ == null) || (this.cy != 5)) {
          break;
        }
        this.aZ.T();
        this.cD = false;
        return;
      }
    }
  }
  
  final void a(Parcelable arg1, ac paramac)
  {
    if (??? == null) {}
    FragmentManagerState localFragmentManagerState;
    do
    {
      return;
      localFragmentManagerState = (FragmentManagerState)???;
    } while (localFragmentManagerState.dl == null);
    Object localObject1;
    int i;
    int j;
    Object localObject2;
    Object localObject3;
    if (paramac != null)
    {
      localObject1 = paramac.getFragments();
      ??? = paramac.ap();
      if (localObject1 != null)
      {
        i = ((List)localObject1).size();
        j = 0;
      }
      for (;;)
      {
        if (j >= i) {
          break label299;
        }
        localObject2 = (Fragment)((List)localObject1).get(j);
        if (DEBUG) {
          Log.v("FragmentManager", "restoreAllState: re-attaching retained " + localObject2);
        }
        int k = 0;
        for (;;)
        {
          if ((k < localFragmentManagerState.dl.length) && (localFragmentManagerState.dl[k].ac != ((Fragment)localObject2).ac))
          {
            k += 1;
            continue;
            i = 0;
            break;
          }
        }
        if (k == localFragmentManagerState.dl.length) {
          a(new IllegalStateException("Could not find active fragment with index " + ((Fragment)localObject2).ac));
        }
        localObject3 = localFragmentManagerState.dl[k];
        ((FragmentState)localObject3).dq = ((Fragment)localObject2);
        ((Fragment)localObject2).aL = null;
        ((Fragment)localObject2).aX = 0;
        ((Fragment)localObject2).aU = false;
        ((Fragment)localObject2).aR = false;
        ((Fragment)localObject2).aO = null;
        if (((FragmentState)localObject3).aK != null)
        {
          ((FragmentState)localObject3).aK.setClassLoader(this.aZ.mContext.getClassLoader());
          ((Fragment)localObject2).aL = ((FragmentState)localObject3).aK.getSparseParcelableArray("android:view_state");
          ((Fragment)localObject2).aK = ((FragmentState)localObject3).aK;
        }
        j += 1;
      }
    }
    for (;;)
    {
      label299:
      this.cr = new SparseArray(localFragmentManagerState.dl.length);
      i = 0;
      if (i < localFragmentManagerState.dl.length)
      {
        localObject2 = localFragmentManagerState.dl[i];
        if (localObject2 != null) {
          if ((??? == null) || (i >= ???.size())) {
            break label1264;
          }
        }
      }
      label730:
      label1264:
      for (localObject1 = (ac)???.get(i);; localObject1 = null)
      {
        localObject3 = this.aZ;
        p localp = this.cz;
        Fragment localFragment = this.cA;
        Context localContext;
        if (((FragmentState)localObject2).dq == null)
        {
          localContext = ((r)localObject3).mContext;
          if (((FragmentState)localObject2).aN != null) {
            ((FragmentState)localObject2).aN.setClassLoader(localContext.getClassLoader());
          }
          if (localp == null) {
            break label730;
          }
        }
        for (((FragmentState)localObject2).dq = localp.a(localContext, ((FragmentState)localObject2).dp, ((FragmentState)localObject2).aN);; ((FragmentState)localObject2).dq = Fragment.a(localContext, ((FragmentState)localObject2).dp, ((FragmentState)localObject2).aN))
        {
          if (((FragmentState)localObject2).aK != null)
          {
            ((FragmentState)localObject2).aK.setClassLoader(localContext.getClassLoader());
            ((FragmentState)localObject2).dq.aK = ((FragmentState)localObject2).aK;
          }
          ((FragmentState)localObject2).dq.a(((FragmentState)localObject2).ac, localFragment);
          ((FragmentState)localObject2).dq.aT = ((FragmentState)localObject2).aT;
          ((FragmentState)localObject2).dq.aV = true;
          ((FragmentState)localObject2).dq.bd = ((FragmentState)localObject2).bd;
          ((FragmentState)localObject2).dq.be = ((FragmentState)localObject2).be;
          ((FragmentState)localObject2).dq.bf = ((FragmentState)localObject2).bf;
          ((FragmentState)localObject2).dq.bi = ((FragmentState)localObject2).bi;
          ((FragmentState)localObject2).dq.bh = ((FragmentState)localObject2).bh;
          ((FragmentState)localObject2).dq.bg = ((FragmentState)localObject2).bg;
          ((FragmentState)localObject2).dq.aY = ((r)localObject3).aY;
          if (DEBUG) {
            Log.v("FragmentManager", "Instantiated fragment " + ((FragmentState)localObject2).dq);
          }
          ((FragmentState)localObject2).dq.bb = ((ac)localObject1);
          localObject1 = ((FragmentState)localObject2).dq;
          if (DEBUG) {
            Log.v("FragmentManager", "restoreAllState: active #" + i + ": " + localObject1);
          }
          this.cr.put(((Fragment)localObject1).ac, localObject1);
          ((FragmentState)localObject2).dq = null;
          i += 1;
          break;
        }
        if (paramac != null)
        {
          ??? = paramac.getFragments();
          if (??? != null) {}
          for (i = ???.size();; i = 0)
          {
            j = 0;
            while (j < i)
            {
              paramac = (Fragment)???.get(j);
              if (paramac.aP >= 0)
              {
                paramac.aO = ((Fragment)this.cr.get(paramac.aP));
                if (paramac.aO == null) {
                  Log.w("FragmentManager", "Re-attaching retained fragment " + paramac + " target no longer exists: " + paramac.aP);
                }
              }
              j += 1;
            }
          }
        }
        this.cq.clear();
        if (localFragmentManagerState.dm != null)
        {
          i = 0;
          while (i < localFragmentManagerState.dm.length)
          {
            paramac = (Fragment)this.cr.get(localFragmentManagerState.dm[i]);
            if (paramac == null) {
              a(new IllegalStateException("No instantiated fragment for index #" + localFragmentManagerState.dm[i]));
            }
            paramac.aR = true;
            if (DEBUG) {
              Log.v("FragmentManager", "restoreAllState: added #" + i + ": " + paramac);
            }
            if (this.cq.contains(paramac)) {
              throw new IllegalStateException("Already added!");
            }
            synchronized (this.cq)
            {
              this.cq.add(paramac);
              i += 1;
            }
          }
        }
        if (localFragmentManagerState.dn != null)
        {
          this.cs = new ArrayList(localFragmentManagerState.dn.length);
          i = 0;
          while (i < localFragmentManagerState.dn.length)
          {
            ??? = localFragmentManagerState.dn[i].a(this);
            if (DEBUG)
            {
              Log.v("FragmentManager", "restoreAllState: back stack #" + i + " (index " + ???.ac + "): " + ???);
              paramac = new PrintWriter(new e("FragmentManager"));
              ???.a("  ", paramac, false);
              paramac.close();
            }
            this.cs.add(???);
            if (???.ac >= 0) {
              a(???.ac, ???);
            }
            i += 1;
          }
        }
        this.cs = null;
        if (localFragmentManagerState.jdField_do >= 0) {
          this.cB = ((Fragment)this.cr.get(localFragmentManagerState.jdField_do));
        }
        this.cp = localFragmentManagerState.cp;
        return;
      }
      ??? = null;
    }
  }
  
  final void a(final Fragment paramFragment, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int j;
    if (paramFragment.aR)
    {
      j = paramInt1;
      if (!paramFragment.bh) {}
    }
    else
    {
      j = paramInt1;
      if (paramInt1 > 1) {
        j = 1;
      }
    }
    int i = j;
    if (paramFragment.aS)
    {
      i = j;
      if (j > paramFragment.aJ)
      {
        if ((paramFragment.aJ != 0) || (!paramFragment.n())) {
          break label124;
        }
        i = 1;
      }
    }
    paramInt1 = i;
    if (paramFragment.bq)
    {
      paramInt1 = i;
      if (paramFragment.aJ < 4)
      {
        paramInt1 = i;
        if (i > 3) {
          paramInt1 = 3;
        }
      }
    }
    label124:
    Object localObject3;
    if (paramFragment.aJ <= paramInt1)
    {
      if ((paramFragment.aT) && (!paramFragment.aU)) {}
      do
      {
        return;
        i = paramFragment.aJ;
        break;
        if ((paramFragment.M() != null) || (paramFragment.N() != null))
        {
          paramFragment.a(null);
          paramFragment.a(null);
          a(paramFragment, paramFragment.O(), 0, 0, true);
        }
        paramInt3 = paramInt1;
        i = paramInt1;
        j = paramInt1;
        paramInt2 = paramInt1;
        switch (paramFragment.aJ)
        {
        default: 
          i = paramInt1;
        }
      } while (paramFragment.aJ == i);
      Log.w("FragmentManager", "moveToState: Fragment state for " + paramFragment + " not updated inline; expected state " + i + " found " + paramFragment.aJ);
      paramFragment.aJ = i;
      return;
      paramInt3 = paramInt1;
      Object localObject1;
      if (paramInt1 > 0)
      {
        if (DEBUG) {
          Log.v("FragmentManager", "moveto CREATED: " + paramFragment);
        }
        paramInt3 = paramInt1;
        if (paramFragment.aK != null)
        {
          paramFragment.aK.setClassLoader(this.aZ.mContext.getClassLoader());
          paramFragment.aL = paramFragment.aK.getSparseParcelableArray("android:view_state");
          paramFragment.aO = b(paramFragment.aK, "android:target_state");
          if (paramFragment.aO != null) {
            paramFragment.aQ = paramFragment.aK.getInt("android:target_req_state", 0);
          }
          paramFragment.br = paramFragment.aK.getBoolean("android:user_visible_hint", true);
          paramInt3 = paramInt1;
          if (!paramFragment.br)
          {
            paramFragment.bq = true;
            paramInt3 = paramInt1;
            if (paramInt1 > 3) {
              paramInt3 = 3;
            }
          }
        }
        paramFragment.aZ = this.aZ;
        paramFragment.bc = this.cA;
        if (this.cA != null) {}
        for (localObject1 = this.cA.ba;; localObject1 = this.aZ.aY)
        {
          paramFragment.aY = ((t)localObject1);
          if (paramFragment.aO == null) {
            break label587;
          }
          if (this.cr.get(paramFragment.aO.ac) == paramFragment.aO) {
            break;
          }
          throw new IllegalStateException("Fragment " + paramFragment + " declared target fragment " + paramFragment.aO + " that does not belong to this FragmentManager!");
        }
        if (paramFragment.aO.aJ <= 0) {
          a(paramFragment.aO, 1, 0, 0, true);
        }
        label587:
        a(paramFragment, this.aZ.mContext, false);
        paramFragment.bm = false;
        paramFragment.onAttach(this.aZ.mContext);
        if (!paramFragment.bm) {
          throw new ce("Fragment " + paramFragment + " did not call through to super.onAttach()");
        }
        if (paramFragment.bc != null)
        {
          localObject1 = paramFragment.bc;
          Fragment.t();
        }
        b(paramFragment, this.aZ.mContext, false);
        if (!paramFragment.bA)
        {
          a(paramFragment, paramFragment.aK, false);
          paramFragment.c(paramFragment.aK);
          b(paramFragment, paramFragment.aK, false);
          paramFragment.bj = false;
        }
      }
      else
      {
        if ((paramFragment.aT) && (!paramFragment.aW))
        {
          paramFragment.a(paramFragment.aK);
          localObject1 = paramFragment.aK;
          paramFragment.bo = paramFragment.C();
          if (paramFragment.bo == null) {
            break label1319;
          }
          paramFragment.bp = paramFragment.bo;
          paramFragment.bo.setSaveFromParentEnabled(false);
          if (paramFragment.bg) {
            paramFragment.bo.setVisibility(8);
          }
          localObject1 = paramFragment.bo;
          localObject1 = paramFragment.aK;
          Fragment.w();
          a(paramFragment, paramFragment.bo, paramFragment.aK, false);
        }
        label828:
        i = paramInt3;
        if (paramInt3 <= 1) {
          break label1372;
        }
        if (DEBUG) {
          Log.v("FragmentManager", "moveto ACTIVITY_CREATED: " + paramFragment);
        }
        if (!paramFragment.aT)
        {
          if (paramFragment.be == 0) {
            break label2811;
          }
          if (paramFragment.be == -1) {
            a(new IllegalArgumentException("Cannot create fragment " + paramFragment + " for a container view with no id"));
          }
          localObject3 = (ViewGroup)this.cz.onFindViewById(paramFragment.be);
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            localObject1 = localObject3;
            if (!paramFragment.aV)
            {
              try
              {
                if (paramFragment.aZ != null) {
                  break label1327;
                }
                throw new IllegalStateException("Fragment " + paramFragment + " not attached to Activity");
              }
              catch (Resources.NotFoundException localNotFoundException)
              {
                localObject2 = "unknown";
              }
              label1005:
              a(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(paramFragment.be) + " (" + (String)localObject2 + ") for fragment " + paramFragment));
            }
          }
        }
      }
    }
    label1195:
    label1327:
    label1363:
    label1372:
    label2805:
    label2811:
    for (Object localObject2 = localObject3;; localObject2 = null)
    {
      paramFragment.bn = ((ViewGroup)localObject2);
      paramFragment.a(paramFragment.aK);
      localObject3 = paramFragment.aK;
      paramFragment.bo = paramFragment.C();
      if (paramFragment.bo != null)
      {
        paramFragment.bp = paramFragment.bo;
        paramFragment.bo.setSaveFromParentEnabled(false);
        if (localObject2 != null) {
          ((ViewGroup)localObject2).addView(paramFragment.bo);
        }
        if (paramFragment.bg) {
          paramFragment.bo.setVisibility(8);
        }
        localObject2 = paramFragment.bo;
        localObject2 = paramFragment.aK;
        Fragment.w();
        a(paramFragment, paramFragment.bo, paramFragment.aK, false);
        if ((paramFragment.bo.getVisibility() == 0) && (paramFragment.bn != null))
        {
          paramBoolean = true;
          paramFragment.bw = paramBoolean;
        }
      }
      for (;;)
      {
        paramFragment.d(paramFragment.aK);
        c(paramFragment, paramFragment.aK, false);
        if (paramFragment.bo == null) {
          break label1363;
        }
        localObject2 = paramFragment.aK;
        if (paramFragment.aL != null)
        {
          paramFragment.bp.restoreHierarchyState(paramFragment.aL);
          paramFragment.aL = null;
        }
        paramFragment.bm = false;
        paramFragment.bm = true;
        if (paramFragment.bm) {
          break label1363;
        }
        throw new ce("Fragment " + paramFragment + " did not call through to super.onViewStateRestored()");
        paramFragment.b(paramFragment.aK);
        paramFragment.aJ = 1;
        break;
        paramFragment.bp = null;
        break label828;
        localObject2 = paramFragment.aZ.mContext.getResources().getResourceName(paramFragment.be);
        break label1005;
        paramBoolean = false;
        break label1195;
        paramFragment.bp = null;
      }
      paramFragment.aK = null;
      i = paramInt3;
      j = i;
      if (i > 2)
      {
        paramFragment.aJ = 3;
        j = i;
      }
      paramInt2 = j;
      if (j > 3)
      {
        if (DEBUG) {
          Log.v("FragmentManager", "moveto STARTED: " + paramFragment);
        }
        paramFragment.D();
        b(paramFragment, false);
        paramInt2 = j;
      }
      i = paramInt2;
      if (paramInt2 <= 4) {
        break;
      }
      if (DEBUG) {
        Log.v("FragmentManager", "moveto RESUMED: " + paramFragment);
      }
      paramFragment.E();
      c(paramFragment, false);
      paramFragment.aK = null;
      paramFragment.aL = null;
      i = paramInt2;
      break;
      i = paramInt1;
      if (paramFragment.aJ <= paramInt1) {
        break;
      }
      switch (paramFragment.aJ)
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
          if (this.cF)
          {
            if (paramFragment.M() == null) {
              break label2322;
            }
            localObject2 = paramFragment.M();
            paramFragment.a(null);
            ((View)localObject2).clearAnimation();
          }
          if ((paramFragment.M() == null) && (paramFragment.N() == null)) {
            break label2348;
          }
          paramFragment.f(paramInt1);
          i = 1;
          break;
          if (paramInt1 < 5)
          {
            if (DEBUG) {
              Log.v("FragmentManager", "movefrom RESUMED: " + paramFragment);
            }
            paramFragment.bB.a(c.ON_PAUSE);
            if (paramFragment.ba != null) {
              paramFragment.ba.i(4);
            }
            paramFragment.aJ = 4;
            paramFragment.bm = false;
            paramFragment.bm = true;
            if (!paramFragment.bm) {
              throw new ce("Fragment " + paramFragment + " did not call through to super.onPause()");
            }
            d(paramFragment, false);
          }
          if (paramInt1 < 4)
          {
            if (DEBUG) {
              Log.v("FragmentManager", "movefrom STARTED: " + paramFragment);
            }
            paramFragment.bB.a(c.ON_STOP);
            if (paramFragment.ba != null) {
              paramFragment.ba.dispatchStop();
            }
            paramFragment.aJ = 3;
            paramFragment.bm = false;
            paramFragment.onStop();
            if (!paramFragment.bm) {
              throw new ce("Fragment " + paramFragment + " did not call through to super.onStop()");
            }
            e(paramFragment, false);
          }
          if (paramInt1 < 3)
          {
            if (DEBUG) {
              Log.v("FragmentManager", "movefrom STOPPED: " + paramFragment);
            }
            paramFragment.F();
          }
        } while (paramInt1 >= 2);
        if (DEBUG) {
          Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: " + paramFragment);
        }
        if ((paramFragment.bo != null) && (this.aZ.S()) && (paramFragment.aL == null)) {
          m(paramFragment);
        }
        if (paramFragment.ba != null) {
          paramFragment.ba.i(1);
        }
        paramFragment.aJ = 1;
        paramFragment.bm = false;
        paramFragment.onDestroyView();
        if (!paramFragment.bm) {
          throw new ce("Fragment " + paramFragment + " did not call through to super.onDestroyView()");
        }
        if (paramFragment.bs != null) {
          paramFragment.bs.av();
        }
        paramFragment.aW = false;
        f(paramFragment, false);
        if ((paramFragment.bo != null) && (paramFragment.bn != null))
        {
          paramFragment.bo.clearAnimation();
          paramFragment.bn.endViewTransition(paramFragment.bo);
          if ((this.cy <= 0) || (this.cF) || (paramFragment.bo.getVisibility() != 0) || (paramFragment.by < 0.0F)) {
            break label2805;
          }
        }
        for (localObject2 = a(paramFragment, paramInt2, false, paramInt3);; localObject2 = null)
        {
          paramFragment.by = 0.0F;
          Object localObject4;
          if (localObject2 != null)
          {
            localObject3 = paramFragment.bo;
            paramFragment.f(paramInt1);
            if (((w)localObject2).db == null) {
              break label2244;
            }
            localObject4 = ((w)localObject2).db;
            paramFragment.a(paramFragment.bo);
            ((Animation)localObject4).setAnimationListener(new v(a((Animation)localObject4), paramFragment)
            {
              public final void onAnimationEnd(Animation paramAnonymousAnimation)
              {
                super.onAnimationEnd(paramAnonymousAnimation);
                if (paramFragment.M() != null)
                {
                  paramFragment.a(null);
                  t.this.a(paramFragment, paramFragment.O(), 0, 0, false);
                }
              }
            });
            a((View)localObject3, (w)localObject2);
            paramFragment.bo.startAnimation((Animation)localObject4);
          }
          for (;;)
          {
            paramFragment.bn.removeView(paramFragment.bo);
            paramFragment.bn = null;
            paramFragment.bo = null;
            paramFragment.bp = null;
            paramFragment.aU = false;
            break;
            localObject4 = ((w)localObject2).dc;
            paramFragment.a(((w)localObject2).dc);
            final ViewGroup localViewGroup = paramFragment.bn;
            if (localViewGroup != null) {
              localViewGroup.startViewTransition((View)localObject3);
            }
            ((Animator)localObject4).addListener(new AnimatorListenerAdapter()
            {
              public final void onAnimationEnd(Animator paramAnonymousAnimator)
              {
                if (localViewGroup != null) {
                  localViewGroup.endViewTransition(this.cX);
                }
                if (paramFragment.N() != null)
                {
                  paramFragment.a(null);
                  t.this.a(paramFragment, paramFragment.O(), 0, 0, false);
                }
              }
            });
            ((Animator)localObject4).setTarget(paramFragment.bo);
            a(paramFragment.bo, (w)localObject2);
            ((Animator)localObject4).start();
          }
          if (paramFragment.N() == null) {
            break label1599;
          }
          localObject2 = paramFragment.N();
          paramFragment.a(null);
          ((Animator)localObject2).cancel();
          break label1599;
          if (DEBUG) {
            Log.v("FragmentManager", "movefrom CREATED: " + paramFragment);
          }
          if (!paramFragment.bj)
          {
            paramFragment.bB.a(c.ON_DESTROY);
            if (paramFragment.ba != null) {
              paramFragment.ba.dispatchDestroy();
            }
            paramFragment.aJ = 0;
            paramFragment.bm = false;
            paramFragment.bA = false;
            paramFragment.onDestroy();
            if (!paramFragment.bm) {
              throw new ce("Fragment " + paramFragment + " did not call through to super.onDestroy()");
            }
            paramFragment.ba = null;
            g(paramFragment, false);
          }
          for (;;)
          {
            paramFragment.bm = false;
            paramFragment.onDetach();
            paramFragment.bz = null;
            if (paramFragment.bm) {
              break;
            }
            throw new ce("Fragment " + paramFragment + " did not call through to super.onDetach()");
            paramFragment.aJ = 0;
          }
          if (paramFragment.ba != null)
          {
            if (!paramFragment.bj) {
              throw new IllegalStateException("Child FragmentManager of " + paramFragment + " was not  destroyed and this fragment is not retaining instance");
            }
            paramFragment.ba.dispatchDestroy();
            paramFragment.ba = null;
          }
          h(paramFragment, false);
          i = paramInt1;
          if (paramBoolean) {
            break;
          }
          if (!paramFragment.bj)
          {
            i = paramInt1;
            if (paramFragment.ac < 0) {
              break;
            }
            if (DEBUG) {
              Log.v("FragmentManager", "Freeing fragment index " + paramFragment);
            }
            this.cr.put(paramFragment.ac, null);
            this.aZ.b(paramFragment.aM);
            paramFragment.ac = -1;
            paramFragment.aM = null;
            paramFragment.aR = false;
            paramFragment.aS = false;
            paramFragment.aT = false;
            paramFragment.aU = false;
            paramFragment.aV = false;
            paramFragment.aX = 0;
            paramFragment.aY = null;
            paramFragment.ba = null;
            paramFragment.aZ = null;
            paramFragment.bd = 0;
            paramFragment.be = 0;
            paramFragment.bf = null;
            paramFragment.bg = false;
            paramFragment.bh = false;
            paramFragment.bj = false;
            paramFragment.bs = null;
            paramFragment.bt = false;
            paramFragment.bu = false;
            i = paramInt1;
            break;
          }
          paramFragment.aZ = null;
          paramFragment.bc = null;
          paramFragment.aY = null;
          i = paramInt1;
          break;
        }
      }
    }
  }
  
  public final void a(Fragment paramFragment, boolean paramBoolean)
  {
    if (DEBUG) {
      Log.v("FragmentManager", "add: " + paramFragment);
    }
    g(paramFragment);
    if (!paramFragment.bh) {
      if (this.cq.contains(paramFragment)) {
        throw new IllegalStateException("Fragment already added: " + paramFragment);
      }
    }
    synchronized (this.cq)
    {
      this.cq.add(paramFragment);
      paramFragment.aR = true;
      paramFragment.aS = false;
      if (paramFragment.bo == null) {
        paramFragment.bx = false;
      }
      if ((paramFragment.bk) && (paramFragment.bl)) {
        this.cD = true;
      }
      if (paramBoolean) {
        e(paramFragment);
      }
      return;
    }
  }
  
  public final void a(r paramr, p paramp, Fragment paramFragment)
  {
    if (this.aZ != null) {
      throw new IllegalStateException("Already attached");
    }
    this.aZ = paramr;
    this.cz = paramp;
    this.cA = paramFragment;
  }
  
  public final void a(z paramz, boolean paramBoolean)
  {
    if (!paramBoolean) {
      ac();
    }
    try
    {
      if ((this.cF) || (this.aZ == null))
      {
        if (paramBoolean) {
          return;
        }
        throw new IllegalStateException("Activity has been destroyed");
      }
    }
    finally {}
    if (this.cn == null) {
      this.cn = new ArrayList();
    }
    this.cn.add(paramz);
    ad();
  }
  
  final boolean a(ArrayList<d> paramArrayList, ArrayList<Boolean> paramArrayList1, String paramString, int paramInt1, int paramInt2)
  {
    if (this.cs == null) {
      return false;
    }
    if ((paramString == null) && (paramInt1 < 0) && ((paramInt2 & 0x1) == 0))
    {
      paramInt1 = this.cs.size() - 1;
      if (paramInt1 < 0) {
        return false;
      }
      paramArrayList.add(this.cs.remove(paramInt1));
      paramArrayList1.add(Boolean.valueOf(true));
    }
    for (;;)
    {
      return true;
      int i = -1;
      if ((paramString != null) || (paramInt1 >= 0))
      {
        int j = this.cs.size() - 1;
        d locald;
        while (j >= 0)
        {
          locald = (d)this.cs.get(j);
          if (((paramString != null) && (paramString.equals(locald.mName))) || ((paramInt1 >= 0) && (paramInt1 == locald.ac))) {
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
            locald = (d)this.cs.get(paramInt2);
            if ((paramString == null) || (!paramString.equals(locald.mName)))
            {
              i = paramInt2;
              if (paramInt1 < 0) {
                break;
              }
              i = paramInt2;
              if (paramInt1 != locald.ac) {
                break;
              }
            }
            paramInt2 -= 1;
          }
        }
      }
      if (i == this.cs.size() - 1) {
        return false;
      }
      paramInt1 = this.cs.size() - 1;
      while (paramInt1 > i)
      {
        paramArrayList.add(this.cs.remove(paramInt1));
        paramArrayList1.add(Boolean.valueOf(true));
        paramInt1 -= 1;
      }
    }
  }
  
  final ac aj()
  {
    a(this.cO);
    return this.cO;
  }
  
  public final Fragment c(String paramString)
  {
    int i;
    Object localObject;
    if (paramString != null)
    {
      i = this.cq.size() - 1;
      while (i >= 0)
      {
        localObject = (Fragment)this.cq.get(i);
        if ((localObject != null) && (paramString.equals(((Fragment)localObject).bf))) {
          return localObject;
        }
        i -= 1;
      }
    }
    if ((this.cr != null) && (paramString != null))
    {
      i = this.cr.size() - 1;
      for (;;)
      {
        if (i < 0) {
          break label119;
        }
        Fragment localFragment = (Fragment)this.cr.valueAt(i);
        if (localFragment != null)
        {
          localObject = localFragment;
          if (paramString.equals(localFragment.bf)) {
            break;
          }
        }
        i -= 1;
      }
    }
    label119:
    return null;
  }
  
  public final void dispatchActivityCreated()
  {
    this.cE = false;
    i(2);
  }
  
  public final void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    int i = 0;
    while (i < this.cq.size())
    {
      Fragment localFragment = (Fragment)this.cq.get(i);
      if (localFragment != null)
      {
        localFragment.onConfigurationChanged(paramConfiguration);
        if (localFragment.ba != null) {
          localFragment.ba.dispatchConfigurationChanged(paramConfiguration);
        }
      }
      i += 1;
    }
  }
  
  public final boolean dispatchContextItemSelected(MenuItem paramMenuItem)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.cq.size())
      {
        Fragment localFragment = (Fragment)this.cq.get(i);
        if (localFragment == null) {
          break label83;
        }
        if ((localFragment.bg) || (localFragment.ba == null) || (!localFragment.ba.dispatchContextItemSelected(paramMenuItem))) {
          break label78;
        }
      }
      label78:
      for (int j = 1; j != 0; j = 0)
      {
        bool1 = true;
        return bool1;
      }
      label83:
      i += 1;
    }
  }
  
  public final void dispatchCreate()
  {
    this.cE = false;
    i(1);
  }
  
  public final boolean dispatchCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    int m = 0;
    Object localObject1 = null;
    int k = 0;
    boolean bool2 = false;
    Fragment localFragment;
    int i;
    if (k < this.cq.size())
    {
      localFragment = (Fragment)this.cq.get(k);
      if (localFragment == null) {
        break label207;
      }
      if (localFragment.bg) {
        break label215;
      }
      if ((!localFragment.bk) || (!localFragment.bl)) {
        break label210;
      }
      i = 1;
      label69:
      int j = i;
      if (localFragment.ba == null) {}
    }
    label207:
    label210:
    label215:
    for (boolean bool1 = i | localFragment.ba.dispatchCreateOptionsMenu(paramMenu, paramMenuInflater);; bool1 = false)
    {
      if (bool1)
      {
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList();
        }
        ((ArrayList)localObject2).add(localFragment);
        bool2 = true;
        localObject1 = localObject2;
      }
      for (;;)
      {
        k += 1;
        break;
        if (this.ct != null)
        {
          i = m;
          while (i < this.ct.size())
          {
            paramMenu = (Fragment)this.ct.get(i);
            if ((localObject1 == null) || (!localObject1.contains(paramMenu))) {
              Fragment.onDestroyOptionsMenu();
            }
            i += 1;
          }
        }
        this.ct = localObject1;
        return bool2;
      }
      i = 0;
      break label69;
    }
  }
  
  public final void dispatchDestroy()
  {
    this.cF = true;
    execPendingActions();
    i(0);
    this.aZ = null;
    this.cz = null;
    this.cA = null;
  }
  
  public final void dispatchLowMemory()
  {
    int i = 0;
    while (i < this.cq.size())
    {
      Fragment localFragment = (Fragment)this.cq.get(i);
      if (localFragment != null)
      {
        localFragment.onLowMemory();
        if (localFragment.ba != null) {
          localFragment.ba.dispatchLowMemory();
        }
      }
      i += 1;
    }
  }
  
  public final void dispatchMultiWindowModeChanged(boolean paramBoolean)
  {
    int i = this.cq.size() - 1;
    while (i >= 0)
    {
      Fragment localFragment = (Fragment)this.cq.get(i);
      if ((localFragment != null) && (localFragment.ba != null)) {
        localFragment.ba.dispatchMultiWindowModeChanged(paramBoolean);
      }
      i -= 1;
    }
  }
  
  public final boolean dispatchOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.cq.size())
      {
        Fragment localFragment = (Fragment)this.cq.get(i);
        if (localFragment == null) {
          break label83;
        }
        if ((localFragment.bg) || (localFragment.ba == null) || (!localFragment.ba.dispatchOptionsItemSelected(paramMenuItem))) {
          break label78;
        }
      }
      label78:
      for (int j = 1; j != 0; j = 0)
      {
        bool1 = true;
        return bool1;
      }
      label83:
      i += 1;
    }
  }
  
  public final void dispatchOptionsMenuClosed(Menu paramMenu)
  {
    int i = 0;
    while (i < this.cq.size())
    {
      Fragment localFragment = (Fragment)this.cq.get(i);
      if ((localFragment != null) && (!localFragment.bg) && (localFragment.ba != null)) {
        localFragment.ba.dispatchOptionsMenuClosed(paramMenu);
      }
      i += 1;
    }
  }
  
  public final void dispatchPause()
  {
    i(4);
  }
  
  public final void dispatchPictureInPictureModeChanged(boolean paramBoolean)
  {
    int i = this.cq.size() - 1;
    while (i >= 0)
    {
      Fragment localFragment = (Fragment)this.cq.get(i);
      if ((localFragment != null) && (localFragment.ba != null)) {
        localFragment.ba.dispatchPictureInPictureModeChanged(paramBoolean);
      }
      i -= 1;
    }
  }
  
  public final boolean dispatchPrepareOptionsMenu(Menu paramMenu)
  {
    int i = 0;
    boolean bool3 = false;
    Fragment localFragment;
    boolean bool4;
    boolean bool1;
    if (i < this.cq.size())
    {
      localFragment = (Fragment)this.cq.get(i);
      bool4 = bool3;
      if (localFragment != null)
      {
        if (localFragment.bg) {
          break label121;
        }
        if ((!localFragment.bk) || (!localFragment.bl)) {
          break label116;
        }
        bool1 = true;
        label67:
        bool2 = bool1;
        if (localFragment.ba == null) {}
      }
    }
    label116:
    label121:
    for (boolean bool2 = bool1 | localFragment.ba.dispatchPrepareOptionsMenu(paramMenu);; bool2 = false)
    {
      bool4 = bool3;
      if (bool2) {
        bool4 = true;
      }
      i += 1;
      bool3 = bool4;
      break;
      return bool3;
      bool1 = false;
      break label67;
    }
  }
  
  public final void dispatchResume()
  {
    this.cE = false;
    i(5);
  }
  
  public final void dispatchStart()
  {
    this.cE = false;
    i(4);
  }
  
  public final void dispatchStop()
  {
    this.cE = true;
    i(3);
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int j = 0;
    String str = paramString + "    ";
    int i;
    if (this.cr != null)
    {
      k = this.cr.size();
      if (k > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("Active Fragments in ");
        paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
        paramPrintWriter.println(":");
        i = 0;
        while (i < k)
        {
          Fragment localFragment = (Fragment)this.cr.valueAt(i);
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
    int k = this.cq.size();
    if (k > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Added Fragments:");
      i = 0;
      while (i < k)
      {
        paramFileDescriptor = (Fragment)this.cq.get(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(i);
        paramPrintWriter.print(": ");
        paramPrintWriter.println(paramFileDescriptor.toString());
        i += 1;
      }
    }
    if (this.ct != null)
    {
      k = this.ct.size();
      if (k > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Fragments Created Menus:");
        i = 0;
        while (i < k)
        {
          paramFileDescriptor = (Fragment)this.ct.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(paramFileDescriptor.toString());
          i += 1;
        }
      }
    }
    if (this.cs != null)
    {
      k = this.cs.size();
      if (k > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Back Stack:");
        i = 0;
        while (i < k)
        {
          paramFileDescriptor = (d)this.cs.get(i);
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
      if (this.cu != null)
      {
        k = this.cu.size();
        if (k > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Back Stack Indices:");
          i = 0;
          while (i < k)
          {
            paramFileDescriptor = (d)this.cu.get(i);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  #");
            paramPrintWriter.print(i);
            paramPrintWriter.print(": ");
            paramPrintWriter.println(paramFileDescriptor);
            i += 1;
          }
        }
      }
      if ((this.cv != null) && (this.cv.size() > 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mAvailBackStackIndices: ");
        paramPrintWriter.println(Arrays.toString(this.cv.toArray()));
      }
      if (this.cn != null)
      {
        k = this.cn.size();
        if (k > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Pending Actions:");
          i = j;
          while (i < k)
          {
            paramFileDescriptor = (z)this.cn.get(i);
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
    paramPrintWriter.println(this.aZ);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mContainer=");
    paramPrintWriter.println(this.cz);
    if (this.cA != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mParent=");
      paramPrintWriter.println(this.cA);
    }
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mCurState=");
    paramPrintWriter.print(this.cy);
    paramPrintWriter.print(" mStateSaved=");
    paramPrintWriter.print(this.cE);
    paramPrintWriter.print(" mDestroyed=");
    paramPrintWriter.println(this.cF);
    if (this.cD)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mNeedMenuInvalidate=");
      paramPrintWriter.println(this.cD);
    }
    if (this.cG != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mNoTransactionsBecause=");
      paramPrintWriter.println(this.cG);
    }
  }
  
  public final boolean execPendingActions()
  {
    ae();
    boolean bool = false;
    for (;;)
    {
      if (d(this.cI, this.cJ)) {
        this.co = true;
      }
      try
      {
        c(this.cI, this.cJ);
        af();
        bool = true;
      }
      finally
      {
        af();
      }
    }
    al();
    return bool;
  }
  
  public final boolean executePendingTransactions()
  {
    boolean bool = execPendingActions();
    ag();
    return bool;
  }
  
  final void f(final Fragment paramFragment)
  {
    if (paramFragment == null) {
      return;
    }
    int j = this.cy;
    int i = j;
    label32:
    Object localObject3;
    Object localObject1;
    label79:
    Object localObject2;
    label230:
    boolean bool;
    if (paramFragment.aS)
    {
      if (paramFragment.n()) {
        i = Math.min(j, 1);
      }
    }
    else
    {
      a(paramFragment, i, paramFragment.I(), paramFragment.J(), false);
      if (paramFragment.bo != null)
      {
        localObject3 = paramFragment.bn;
        localObject1 = paramFragment.bo;
        if ((localObject3 != null) && (localObject1 != null)) {
          break label384;
        }
        localObject1 = null;
        if (localObject1 != null)
        {
          localObject1 = ((Fragment)localObject1).bo;
          localObject2 = paramFragment.bn;
          i = ((ViewGroup)localObject2).indexOfChild((View)localObject1);
          j = ((ViewGroup)localObject2).indexOfChild(paramFragment.bo);
          if (j < i)
          {
            ((ViewGroup)localObject2).removeViewAt(j);
            ((ViewGroup)localObject2).addView(paramFragment.bo, i);
          }
        }
        if ((paramFragment.bw) && (paramFragment.bn != null))
        {
          if (paramFragment.by > 0.0F) {
            paramFragment.bo.setAlpha(paramFragment.by);
          }
          paramFragment.by = 0.0F;
          paramFragment.bw = false;
          localObject1 = a(paramFragment, paramFragment.I(), true, paramFragment.J());
          if (localObject1 != null)
          {
            a(paramFragment.bo, (w)localObject1);
            if (((w)localObject1).db == null) {
              break label447;
            }
            paramFragment.bo.startAnimation(((w)localObject1).db);
          }
        }
      }
      if (!paramFragment.bx) {
        break label468;
      }
      if (paramFragment.bo != null)
      {
        i = paramFragment.I();
        if (paramFragment.bg) {
          break label470;
        }
        bool = true;
        label259:
        localObject1 = a(paramFragment, i, bool, paramFragment.J());
        if ((localObject1 == null) || (((w)localObject1).dc == null)) {
          break label530;
        }
        ((w)localObject1).dc.setTarget(paramFragment.bo);
        if (!paramFragment.bg) {
          break label519;
        }
        if (!paramFragment.P()) {
          break label476;
        }
        paramFragment.c(false);
      }
    }
    for (;;)
    {
      a(paramFragment.bo, (w)localObject1);
      ((w)localObject1).dc.start();
      if ((paramFragment.aR) && (paramFragment.bk) && (paramFragment.bl)) {
        this.cD = true;
      }
      paramFragment.bx = false;
      bool = paramFragment.bg;
      Fragment.q();
      return;
      i = Math.min(j, 0);
      break label32;
      label384:
      i = this.cq.indexOf(paramFragment) - 1;
      for (;;)
      {
        if (i < 0) {
          break label441;
        }
        localObject2 = (Fragment)this.cq.get(i);
        if (((Fragment)localObject2).bn == localObject3)
        {
          localObject1 = localObject2;
          if (((Fragment)localObject2).bo != null) {
            break;
          }
        }
        i -= 1;
      }
      label441:
      localObject1 = null;
      break label79;
      label447:
      ((w)localObject1).dc.setTarget(paramFragment.bo);
      ((w)localObject1).dc.start();
      break label230;
      label468:
      break;
      label470:
      bool = false;
      break label259;
      label476:
      localObject2 = paramFragment.bn;
      localObject3 = paramFragment.bo;
      ((ViewGroup)localObject2).startViewTransition((View)localObject3);
      ((w)localObject1).dc.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          this.cW.endViewTransition(this.cY);
          paramAnonymousAnimator.removeListener(this);
          if (paramFragment.bo != null) {
            paramFragment.bo.setVisibility(8);
          }
        }
      });
      continue;
      label519:
      paramFragment.bo.setVisibility(0);
    }
    label530:
    if (localObject1 != null)
    {
      a(paramFragment.bo, (w)localObject1);
      paramFragment.bo.startAnimation(((w)localObject1).db);
      ((w)localObject1).db.start();
    }
    if ((paramFragment.bg) && (!paramFragment.P())) {}
    for (i = 8;; i = 0)
    {
      paramFragment.bo.setVisibility(i);
      if (!paramFragment.P()) {
        break;
      }
      paramFragment.c(false);
      break;
    }
  }
  
  public final void g(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("Bad id: " + paramInt);
    }
    a(new aa(this, paramInt, 1), false);
  }
  
  final void g(Fragment paramFragment)
  {
    if (paramFragment.ac >= 0) {}
    do
    {
      return;
      int i = this.cp;
      this.cp = (i + 1);
      paramFragment.a(i, this.cA);
      if (this.cr == null) {
        this.cr = new SparseArray();
      }
      this.cr.put(paramFragment.ac, paramFragment);
    } while (!DEBUG);
    Log.v("FragmentManager", "Allocated fragment index " + paramFragment);
  }
  
  public final List<Fragment> getFragments()
  {
    if (this.cq.isEmpty()) {
      return Collections.EMPTY_LIST;
    }
    synchronized (this.cq)
    {
      List localList = (List)this.cq.clone();
      return localList;
    }
  }
  
  public final void h(Fragment paramFragment)
  {
    if (DEBUG) {
      Log.v("FragmentManager", "remove: " + paramFragment + " nesting=" + paramFragment.aX);
    }
    int i;
    if (!paramFragment.n()) {
      i = 1;
    }
    for (;;)
    {
      if ((!paramFragment.bh) || (i != 0)) {}
      synchronized (this.cq)
      {
        this.cq.remove(paramFragment);
        if ((paramFragment.bk) && (paramFragment.bl)) {
          this.cD = true;
        }
        paramFragment.aR = false;
        paramFragment.aS = true;
        return;
        i = 0;
      }
    }
  }
  
  public final boolean isStateSaved()
  {
    return this.cE;
  }
  
  public final void k(Fragment paramFragment)
  {
    if (DEBUG) {
      Log.v("FragmentManager", "detach: " + paramFragment);
    }
    if (!paramFragment.bh)
    {
      paramFragment.bh = true;
      if (paramFragment.aR) {
        if (DEBUG) {
          Log.v("FragmentManager", "remove from detach: " + paramFragment);
        }
      }
    }
    synchronized (this.cq)
    {
      this.cq.remove(paramFragment);
      if ((paramFragment.bk) && (paramFragment.bl)) {
        this.cD = true;
      }
      paramFragment.aR = false;
      return;
    }
  }
  
  public final void l(Fragment paramFragment)
  {
    if (DEBUG) {
      Log.v("FragmentManager", "attach: " + paramFragment);
    }
    if (paramFragment.bh)
    {
      paramFragment.bh = false;
      if (!paramFragment.aR)
      {
        if (this.cq.contains(paramFragment)) {
          throw new IllegalStateException("Fragment already added: " + paramFragment);
        }
        if (DEBUG) {
          Log.v("FragmentManager", "add from attach: " + paramFragment);
        }
      }
    }
    synchronized (this.cq)
    {
      this.cq.add(paramFragment);
      paramFragment.aR = true;
      if ((paramFragment.bk) && (paramFragment.bl)) {
        this.cD = true;
      }
      return;
    }
  }
  
  public final void n(Fragment paramFragment)
  {
    if ((paramFragment != null) && ((this.cr.get(paramFragment.ac) != paramFragment) || ((paramFragment.aZ != null) && (paramFragment.aY != this)))) {
      throw new IllegalArgumentException("Fragment " + paramFragment + " is not an active fragment of FragmentManager " + this);
    }
    this.cB = paramFragment;
  }
  
  public final void noteStateNotSaved()
  {
    this.cO = null;
    this.cE = false;
    int j = this.cq.size();
    int i = 0;
    while (i < j)
    {
      Fragment localFragment = (Fragment)this.cq.get(i);
      if ((localFragment != null) && (localFragment.ba != null)) {
        localFragment.ba.noteStateNotSaved();
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
    paramString = paramContext.obtainStyledAttributes(paramAttributeSet, y.dd);
    if (str1 == null) {
      str1 = paramString.getString(0);
    }
    for (;;)
    {
      int k = paramString.getResourceId(1, -1);
      String str2 = paramString.getString(2);
      paramString.recycle();
      if (!Fragment.a(this.aZ.mContext, str1)) {
        return null;
      }
      if (paramView != null) {}
      for (int i = paramView.getId(); (i == -1) && (k == -1) && (str2 == null); i = 0) {
        throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str1);
      }
      int j;
      if (k != -1)
      {
        paramString = h(k);
        paramView = paramString;
        if (paramString == null)
        {
          paramView = paramString;
          if (str2 != null) {
            paramView = c(str2);
          }
        }
        paramString = paramView;
        if (paramView == null)
        {
          paramString = paramView;
          if (i != -1) {
            paramString = h(i);
          }
        }
        if (DEBUG) {
          Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(k) + " fname=" + str1 + " existing=" + paramString);
        }
        if (paramString != null) {
          break label419;
        }
        paramView = this.cz.a(paramContext, str1, null);
        paramView.aT = true;
        if (k == 0) {
          break label412;
        }
        j = k;
        label294:
        paramView.bd = j;
        paramView.be = i;
        paramView.bf = str2;
        paramView.aU = true;
        paramView.aY = this;
        paramView.aZ = this.aZ;
        paramString = paramView.aK;
        paramView.s();
        a(paramView, true);
        label345:
        if ((this.cy > 0) || (!paramView.aT)) {
          break label538;
        }
        a(paramView, 1, 0, 0, false);
      }
      for (;;)
      {
        if (paramView.bo != null) {
          break label546;
        }
        throw new IllegalStateException("Fragment " + str1 + " did not create a view.");
        paramString = null;
        break;
        label412:
        j = i;
        break label294;
        label419:
        if (paramString.aU) {
          throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(k) + ", tag " + str2 + ", or parent id 0x" + Integer.toHexString(i) + " with another fragment for " + str1);
        }
        paramString.aU = true;
        paramString.aZ = this.aZ;
        if (!paramString.bj)
        {
          paramView = paramString.aK;
          paramString.s();
        }
        paramView = paramString;
        break label345;
        label538:
        e(paramView);
      }
      label546:
      if (k != 0) {
        paramView.bo.setId(k);
      }
      if (paramView.bo.getTag() == null) {
        paramView.bo.setTag(str2);
      }
      return paramView.bo;
    }
  }
  
  public final View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return onCreateView(null, paramString, paramContext, paramAttributeSet);
  }
  
  public final boolean popBackStackImmediate()
  {
    ac();
    return aa();
  }
  
  final Parcelable saveAllState()
  {
    Object localObject3 = null;
    int k = 0;
    ag();
    label20:
    Object localObject1;
    Object localObject2;
    if (this.cr == null)
    {
      i = 0;
      j = 0;
      if (j >= i) {
        break label141;
      }
      localObject1 = (Fragment)this.cr.valueAt(j);
      if (localObject1 != null)
      {
        if (((Fragment)localObject1).M() == null) {
          break label122;
        }
        m = ((Fragment)localObject1).O();
        localObject2 = ((Fragment)localObject1).M();
        ((Fragment)localObject1).a(null);
        localObject4 = ((View)localObject2).getAnimation();
        if (localObject4 != null)
        {
          ((Animation)localObject4).cancel();
          ((View)localObject2).clearAnimation();
        }
        a((Fragment)localObject1, m, 0, 0, false);
      }
    }
    for (;;)
    {
      j += 1;
      break label20;
      i = this.cr.size();
      break;
      label122:
      if (((Fragment)localObject1).N() != null) {
        ((Fragment)localObject1).N().end();
      }
    }
    label141:
    execPendingActions();
    this.cE = true;
    this.cO = null;
    if ((this.cr == null) || (this.cr.size() <= 0)) {
      return null;
    }
    int m = this.cr.size();
    Object localObject4 = new FragmentState[m];
    int j = 0;
    int i = 0;
    label195:
    Fragment localFragment;
    FragmentState localFragmentState;
    if (j < m)
    {
      localFragment = (Fragment)this.cr.valueAt(j);
      if (localFragment == null) {
        break label1114;
      }
      if (localFragment.ac < 0) {
        a(new IllegalStateException("Failure saving state: active " + localFragment + " has cleared index: " + localFragment.ac));
      }
      localFragmentState = new FragmentState(localFragment);
      localObject4[j] = localFragmentState;
      if ((localFragment.aJ > 0) && (localFragmentState.aK == null))
      {
        if (this.cL == null) {
          this.cL = new Bundle();
        }
        localObject1 = this.cL;
        localFragment.onSaveInstanceState((Bundle)localObject1);
        if (localFragment.ba != null)
        {
          localObject2 = localFragment.ba.saveAllState();
          if (localObject2 != null) {
            ((Bundle)localObject1).putParcelable("android:support:fragments", (Parcelable)localObject2);
          }
        }
        d(localFragment, this.cL, false);
        if (this.cL.isEmpty()) {
          break label1117;
        }
        localObject2 = this.cL;
        this.cL = null;
      }
    }
    for (;;)
    {
      if (localFragment.bo != null) {
        m(localFragment);
      }
      localObject1 = localObject2;
      if (localFragment.aL != null)
      {
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new Bundle();
        }
        ((Bundle)localObject1).putSparseParcelableArray("android:view_state", localFragment.aL);
      }
      localObject2 = localObject1;
      if (!localFragment.br)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new Bundle();
        }
        ((Bundle)localObject2).putBoolean("android:user_visible_hint", localFragment.br);
      }
      localFragmentState.aK = ((Bundle)localObject2);
      if (localFragment.aO != null)
      {
        if (localFragment.aO.ac < 0) {
          a(new IllegalStateException("Failure saving state: " + localFragment + " has target not in fragment manager: " + localFragment.aO));
        }
        if (localFragmentState.aK == null) {
          localFragmentState.aK = new Bundle();
        }
        localObject1 = localFragmentState.aK;
        localObject2 = localFragment.aO;
        if (((Fragment)localObject2).ac < 0) {
          a(new IllegalStateException("Fragment " + localObject2 + " is not currently in the FragmentManager"));
        }
        ((Bundle)localObject1).putInt("android:target_state", ((Fragment)localObject2).ac);
        if (localFragment.aQ != 0) {
          localFragmentState.aK.putInt("android:target_req_state", localFragment.aQ);
        }
      }
      label682:
      if (DEBUG) {
        Log.v("FragmentManager", "Saved state of " + localFragment + ": " + localFragmentState.aK);
      }
      i = 1;
      label1114:
      for (;;)
      {
        j += 1;
        break label195;
        localFragmentState.aK = localFragment.aK;
        break label682;
        if (i == 0)
        {
          if (!DEBUG) {
            break;
          }
          Log.v("FragmentManager", "saveAllState: no fragments!");
          return null;
        }
        j = this.cq.size();
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
            localObject2[i] = ((Fragment)this.cq.get(i)).ac;
            if (localObject2[i] < 0) {
              a(new IllegalStateException("Failure saving state: active " + this.cq.get(i) + " has cleared index: " + localObject2[i]));
            }
            if (DEBUG) {
              Log.v("FragmentManager", "saveAllState: adding fragment #" + i + ": " + this.cq.get(i));
            }
            i += 1;
          }
        }
        localObject1 = null;
        localObject2 = localObject3;
        if (this.cs != null)
        {
          j = this.cs.size();
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
              localObject3[i] = new BackStackState((d)this.cs.get(i));
              if (DEBUG) {
                Log.v("FragmentManager", "saveAllState: adding back stack #" + i + ": " + this.cs.get(i));
              }
              i += 1;
            }
          }
        }
        localObject3 = new FragmentManagerState();
        ((FragmentManagerState)localObject3).dl = ((FragmentState[])localObject4);
        ((FragmentManagerState)localObject3).dm = ((int[])localObject1);
        ((FragmentManagerState)localObject3).dn = ((BackStackState[])localObject2);
        if (this.cB != null) {
          ((FragmentManagerState)localObject3).jdField_do = this.cB.ac;
        }
        ((FragmentManagerState)localObject3).cp = this.cp;
        ak();
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
    if (this.cA != null) {
      android.support.v4.b.d.a(this.cA, localStringBuilder);
    }
    for (;;)
    {
      localStringBuilder.append("}}");
      return localStringBuilder.toString();
      android.support.v4.b.d.a(this.aZ, localStringBuilder);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.t
 * JD-Core Version:    0.7.0.1
 */