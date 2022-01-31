package android.support.v4.app;

import android.os.Build.VERSION;
import android.util.Log;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

final class d
  extends ae
  implements z
{
  static final boolean Q;
  final t R;
  ArrayList<e> S = new ArrayList();
  int T;
  int U;
  int V;
  int W;
  int X;
  int Y;
  boolean Z;
  boolean aa = true;
  boolean ab;
  int ac = -1;
  int ad;
  CharSequence ae;
  int af;
  CharSequence ag;
  ArrayList<String> ah;
  ArrayList<String> ai;
  boolean aj = false;
  ArrayList<Runnable> ak;
  String mName;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (boolean bool = true;; bool = false)
    {
      Q = bool;
      return;
    }
  }
  
  public d(t paramt)
  {
    this.R = paramt;
  }
  
  private int a(boolean paramBoolean)
  {
    if (this.ab) {
      throw new IllegalStateException("commit already called");
    }
    if (t.DEBUG)
    {
      Log.v("FragmentManager", "Commit: " + this);
      PrintWriter localPrintWriter = new PrintWriter(new android.support.v4.b.e("FragmentManager"));
      a("  ", localPrintWriter);
      localPrintWriter.close();
    }
    this.ab = true;
    if (this.Z) {}
    for (this.ac = this.R.a(this);; this.ac = -1)
    {
      this.R.a(this, paramBoolean);
      return this.ac;
    }
  }
  
  private void b(int paramInt, Fragment paramFragment, String paramString)
  {
    Class localClass = paramFragment.getClass();
    int i = localClass.getModifiers();
    if ((localClass.isAnonymousClass()) || (!Modifier.isPublic(i)) || ((localClass.isMemberClass()) && (!Modifier.isStatic(i)))) {
      throw new IllegalStateException("Fragment " + localClass.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
    }
    paramFragment.aY = this.R;
    if (paramString != null)
    {
      if ((paramFragment.bf != null) && (!paramString.equals(paramFragment.bf))) {
        throw new IllegalStateException("Can't change tag of fragment " + paramFragment + ": was " + paramFragment.bf + " now " + paramString);
      }
      paramFragment.bf = paramString;
    }
    if (paramInt != 0)
    {
      if (paramInt == -1) {
        throw new IllegalArgumentException("Can't add fragment " + paramFragment + " with tag " + paramString + " to container view with no id");
      }
      if ((paramFragment.bd != 0) && (paramFragment.bd != paramInt)) {
        throw new IllegalStateException("Can't change container ID of fragment " + paramFragment + ": was " + paramFragment.bd + " now " + paramInt);
      }
      paramFragment.bd = paramInt;
      paramFragment.be = paramInt;
    }
    a(new e(1, paramFragment));
  }
  
  private static boolean b(e parame)
  {
    parame = parame.am;
    return (parame != null) && (parame.aR) && (parame.bo != null) && (!parame.bh) && (!parame.bg) && (parame.k());
  }
  
  final Fragment a(ArrayList<Fragment> paramArrayList, Fragment paramFragment)
  {
    int j = 0;
    Fragment localFragment1 = paramFragment;
    e locale;
    int i;
    Fragment localFragment2;
    int m;
    int k;
    label218:
    Fragment localFragment3;
    if (j < this.S.size())
    {
      locale = (e)this.S.get(j);
      i = j;
      paramFragment = localFragment1;
      switch (locale.al)
      {
      default: 
        paramFragment = localFragment1;
        i = j;
      case 4: 
      case 5: 
      case 1: 
      case 7: 
      case 3: 
      case 6: 
        for (;;)
        {
          j = i + 1;
          localFragment1 = paramFragment;
          break;
          paramArrayList.add(locale.am);
          i = j;
          paramFragment = localFragment1;
          continue;
          paramArrayList.remove(locale.am);
          i = j;
          paramFragment = localFragment1;
          if (locale.am == localFragment1)
          {
            this.S.add(j, new e(9, locale.am));
            i = j + 1;
            paramFragment = null;
          }
        }
      case 2: 
        localFragment2 = locale.am;
        int n = localFragment2.be;
        m = 0;
        k = paramArrayList.size() - 1;
        i = j;
        paramFragment = localFragment1;
        j = m;
        if (k >= 0)
        {
          localFragment3 = (Fragment)paramArrayList.get(k);
          if (localFragment3.be != n) {
            break label451;
          }
          if (localFragment3 == localFragment2) {
            j = 1;
          }
        }
        break;
      }
    }
    label451:
    for (;;)
    {
      k -= 1;
      break label218;
      m = i;
      localFragment1 = paramFragment;
      if (localFragment3 == paramFragment)
      {
        this.S.add(i, new e(9, localFragment3));
        m = i + 1;
        localFragment1 = null;
      }
      paramFragment = new e(3, localFragment3);
      paramFragment.an = locale.an;
      paramFragment.ap = locale.ap;
      paramFragment.ao = locale.ao;
      paramFragment.aq = locale.aq;
      this.S.add(m, paramFragment);
      paramArrayList.remove(localFragment3);
      i = m + 1;
      paramFragment = localFragment1;
      continue;
      if (j != 0)
      {
        this.S.remove(i);
        i -= 1;
        break;
      }
      locale.al = 1;
      paramArrayList.add(localFragment2);
      break;
      this.S.add(j, new e(9, localFragment1));
      i = j + 1;
      paramFragment = locale.am;
      break;
      return localFragment1;
    }
  }
  
  public final ae a(int paramInt, Fragment paramFragment, String paramString)
  {
    b(paramInt, paramFragment, paramString);
    return this;
  }
  
  public final ae a(Fragment paramFragment)
  {
    a(new e(3, paramFragment));
    return this;
  }
  
  public final ae a(Fragment paramFragment, String paramString)
  {
    b(0, paramFragment, paramString);
    return this;
  }
  
  final void a(e parame)
  {
    this.S.add(parame);
    parame.an = this.T;
    parame.ao = this.U;
    parame.ap = this.V;
    parame.aq = this.W;
  }
  
  final void a(m paramm)
  {
    int i = 0;
    while (i < this.S.size())
    {
      e locale = (e)this.S.get(i);
      if (b(locale)) {
        locale.am.b(paramm);
      }
      i += 1;
    }
  }
  
  public final void a(String paramString, PrintWriter paramPrintWriter)
  {
    a(paramString, paramPrintWriter, true);
  }
  
  public final void a(String paramString, PrintWriter paramPrintWriter, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mName=");
      paramPrintWriter.print(this.mName);
      paramPrintWriter.print(" mIndex=");
      paramPrintWriter.print(this.ac);
      paramPrintWriter.print(" mCommitted=");
      paramPrintWriter.println(this.ab);
      if (this.X != 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mTransition=#");
        paramPrintWriter.print(Integer.toHexString(this.X));
        paramPrintWriter.print(" mTransitionStyle=#");
        paramPrintWriter.println(Integer.toHexString(this.Y));
      }
      if ((this.T != 0) || (this.U != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.T));
        paramPrintWriter.print(" mExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.U));
      }
      if ((this.V != 0) || (this.W != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mPopEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.V));
        paramPrintWriter.print(" mPopExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.W));
      }
      if ((this.ad != 0) || (this.ae != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.ad));
        paramPrintWriter.print(" mBreadCrumbTitleText=");
        paramPrintWriter.println(this.ae);
      }
      if ((this.af != 0) || (this.ag != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbShortTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.af));
        paramPrintWriter.print(" mBreadCrumbShortTitleText=");
        paramPrintWriter.println(this.ag);
      }
    }
    if (!this.S.isEmpty())
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Operations:");
      new StringBuilder().append(paramString).append("    ");
      int j = this.S.size();
      int i = 0;
      if (i < j)
      {
        e locale = (e)this.S.get(i);
        String str;
        switch (locale.al)
        {
        default: 
          str = "cmd=" + locale.al;
        }
        for (;;)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  Op #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.print(str);
          paramPrintWriter.print(" ");
          paramPrintWriter.println(locale.am);
          if (paramBoolean)
          {
            if ((locale.an != 0) || (locale.ao != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("enterAnim=#");
              paramPrintWriter.print(Integer.toHexString(locale.an));
              paramPrintWriter.print(" exitAnim=#");
              paramPrintWriter.println(Integer.toHexString(locale.ao));
            }
            if ((locale.ap != 0) || (locale.aq != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("popEnterAnim=#");
              paramPrintWriter.print(Integer.toHexString(locale.ap));
              paramPrintWriter.print(" popExitAnim=#");
              paramPrintWriter.println(Integer.toHexString(locale.aq));
            }
          }
          i += 1;
          break;
          str = "NULL";
          continue;
          str = "ADD";
          continue;
          str = "REPLACE";
          continue;
          str = "REMOVE";
          continue;
          str = "HIDE";
          continue;
          str = "SHOW";
          continue;
          str = "DETACH";
          continue;
          str = "ATTACH";
          continue;
          str = "SET_PRIMARY_NAV";
          continue;
          str = "UNSET_PRIMARY_NAV";
        }
      }
    }
  }
  
  final boolean a(ArrayList<d> paramArrayList, int paramInt1, int paramInt2)
  {
    if (paramInt2 == paramInt1) {
      return false;
    }
    int i1 = this.S.size();
    int j = -1;
    int k = 0;
    int i;
    if (k < i1)
    {
      Object localObject = (e)this.S.get(k);
      if (((e)localObject).am != null)
      {
        i = ((e)localObject).am.be;
        if ((i == 0) || (i == j)) {
          break label200;
        }
        j = paramInt1;
      }
      for (;;)
      {
        if (j >= paramInt2) {
          break label185;
        }
        localObject = (d)paramArrayList.get(j);
        int i2 = ((d)localObject).S.size();
        int m = 0;
        for (;;)
        {
          if (m >= i2) {
            break label176;
          }
          e locale = (e)((d)localObject).S.get(m);
          if (locale.am != null) {}
          for (int n = locale.am.be;; n = 0)
          {
            if (n != i) {
              break label167;
            }
            return true;
            i = 0;
            break;
          }
          label167:
          m += 1;
        }
        label176:
        j += 1;
      }
    }
    for (;;)
    {
      label185:
      k += 1;
      j = i;
      break;
      return false;
      label200:
      i = j;
    }
  }
  
  public final boolean a(ArrayList<d> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    if (t.DEBUG) {
      Log.v("FragmentManager", "Run: " + this);
    }
    paramArrayList.add(this);
    paramArrayList1.add(Boolean.valueOf(false));
    if (this.Z)
    {
      paramArrayList = this.R;
      if (paramArrayList.cs == null) {
        paramArrayList.cs = new ArrayList();
      }
      paramArrayList.cs.add(this);
    }
    return true;
  }
  
  final Fragment b(ArrayList<Fragment> paramArrayList, Fragment paramFragment)
  {
    int i = 0;
    Fragment localFragment = paramFragment;
    if (i < this.S.size())
    {
      e locale = (e)this.S.get(i);
      paramFragment = localFragment;
      switch (locale.al)
      {
      default: 
        paramFragment = localFragment;
      }
      for (;;)
      {
        i += 1;
        localFragment = paramFragment;
        break;
        paramArrayList.remove(locale.am);
        paramFragment = localFragment;
        continue;
        paramArrayList.add(locale.am);
        paramFragment = localFragment;
        continue;
        paramFragment = locale.am;
        continue;
        paramFragment = null;
      }
    }
    return localFragment;
  }
  
  public final ae b(Fragment paramFragment)
  {
    a(new e(6, paramFragment));
    return this;
  }
  
  final void b(int paramInt)
  {
    if (!this.Z) {}
    for (;;)
    {
      return;
      if (t.DEBUG) {
        Log.v("FragmentManager", "Bump nesting in " + this + " by " + paramInt);
      }
      int j = this.S.size();
      int i = 0;
      while (i < j)
      {
        e locale = (e)this.S.get(i);
        if (locale.am != null)
        {
          Fragment localFragment = locale.am;
          localFragment.aX += paramInt;
          if (t.DEBUG) {
            Log.v("FragmentManager", "Bump nesting of " + locale.am + " to " + locale.am.aX);
          }
        }
        i += 1;
      }
    }
  }
  
  final void b(boolean paramBoolean)
  {
    int i = this.S.size() - 1;
    if (i >= 0)
    {
      e locale = (e)this.S.get(i);
      Fragment localFragment = locale.am;
      if (localFragment != null) {
        localFragment.a(t.j(this.X), this.Y);
      }
      switch (locale.al)
      {
      case 2: 
      default: 
        throw new IllegalArgumentException("Unknown cmd: " + locale.al);
      case 1: 
        localFragment.e(locale.aq);
        this.R.h(localFragment);
      }
      for (;;)
      {
        if ((!this.aj) && (locale.al != 3) && (localFragment != null)) {
          this.R.f(localFragment);
        }
        i -= 1;
        break;
        localFragment.e(locale.ap);
        this.R.a(localFragment, false);
        continue;
        localFragment.e(locale.ap);
        t.j(localFragment);
        continue;
        localFragment.e(locale.aq);
        t.i(localFragment);
        continue;
        localFragment.e(locale.ap);
        this.R.l(localFragment);
        continue;
        localFragment.e(locale.aq);
        this.R.k(localFragment);
        continue;
        this.R.n(null);
        continue;
        this.R.n(localFragment);
      }
    }
    if ((!this.aj) && (paramBoolean)) {
      this.R.a(this.R.cy, true);
    }
  }
  
  public final ae c(Fragment paramFragment)
  {
    a(new e(7, paramFragment));
    return this;
  }
  
  final boolean c(int paramInt)
  {
    int k = this.S.size();
    int i = 0;
    while (i < k)
    {
      e locale = (e)this.S.get(i);
      if (locale.am != null) {}
      for (int j = locale.am.be; (j != 0) && (j == paramInt); j = 0) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public final int commit()
  {
    return a(false);
  }
  
  public final int commitAllowingStateLoss()
  {
    return a(true);
  }
  
  public final void i()
  {
    if (this.ak != null)
    {
      int j = this.ak.size();
      int i = 0;
      while (i < j)
      {
        ((Runnable)this.ak.get(i)).run();
        i += 1;
      }
      this.ak = null;
    }
  }
  
  final void j()
  {
    int j = this.S.size();
    int i = 0;
    if (i < j)
    {
      e locale = (e)this.S.get(i);
      Fragment localFragment = locale.am;
      if (localFragment != null) {
        localFragment.a(this.X, this.Y);
      }
      switch (locale.al)
      {
      case 2: 
      default: 
        throw new IllegalArgumentException("Unknown cmd: " + locale.al);
      case 1: 
        localFragment.e(locale.an);
        this.R.a(localFragment, false);
      }
      for (;;)
      {
        if ((!this.aj) && (locale.al != 1) && (localFragment != null)) {
          this.R.f(localFragment);
        }
        i += 1;
        break;
        localFragment.e(locale.ao);
        this.R.h(localFragment);
        continue;
        localFragment.e(locale.ao);
        t.i(localFragment);
        continue;
        localFragment.e(locale.an);
        t.j(localFragment);
        continue;
        localFragment.e(locale.ao);
        this.R.k(localFragment);
        continue;
        localFragment.e(locale.an);
        this.R.l(localFragment);
        continue;
        this.R.n(localFragment);
        continue;
        this.R.n(null);
      }
    }
    if (!this.aj) {
      this.R.a(this.R.cy, true);
    }
  }
  
  final boolean k()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.S.size())
      {
        if (b((e)this.S.get(i))) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("BackStackEntry{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    if (this.ac >= 0)
    {
      localStringBuilder.append(" #");
      localStringBuilder.append(this.ac);
    }
    if (this.mName != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(this.mName);
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.d
 * JD-Core Version:    0.7.0.1
 */