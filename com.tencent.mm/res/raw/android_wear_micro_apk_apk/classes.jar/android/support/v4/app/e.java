package android.support.v4.app;

import android.util.Log;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

final class e
  extends ag
  implements ab
{
  final u bA;
  ArrayList<f> bB = new ArrayList();
  int bC;
  int bD;
  int bE;
  int bF;
  int bG;
  int bH;
  boolean bI;
  boolean bJ = true;
  boolean bK;
  int bL = -1;
  int bM;
  CharSequence bN;
  int bO;
  CharSequence bP;
  ArrayList<String> bQ;
  ArrayList<String> bR;
  boolean bS = false;
  ArrayList<Runnable> bT;
  String mName;
  
  public e(u paramu)
  {
    this.bA = paramu;
  }
  
  private int b(boolean paramBoolean)
  {
    if (this.bK) {
      throw new IllegalStateException("commit already called");
    }
    if (u.DEBUG)
    {
      Log.v("FragmentManager", "Commit: ".concat(String.valueOf(this)));
      PrintWriter localPrintWriter = new PrintWriter(new android.support.v4.b.e("FragmentManager"));
      a("  ", localPrintWriter);
      localPrintWriter.close();
    }
    this.bK = true;
    if (this.bI) {}
    for (this.bL = this.bA.a(this);; this.bL = -1)
    {
      this.bA.a(this, paramBoolean);
      return this.bL;
    }
  }
  
  private void b(int paramInt, Fragment paramFragment, String paramString)
  {
    Class localClass = paramFragment.getClass();
    int i = localClass.getModifiers();
    if ((localClass.isAnonymousClass()) || (!Modifier.isPublic(i)) || ((localClass.isMemberClass()) && (!Modifier.isStatic(i)))) {
      throw new IllegalStateException("Fragment " + localClass.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
    }
    paramFragment.cI = this.bA;
    if (paramString != null)
    {
      if ((paramFragment.cQ != null) && (!paramString.equals(paramFragment.cQ))) {
        throw new IllegalStateException("Can't change tag of fragment " + paramFragment + ": was " + paramFragment.cQ + " now " + paramString);
      }
      paramFragment.cQ = paramString;
    }
    if (paramInt != 0)
    {
      if (paramInt == -1) {
        throw new IllegalArgumentException("Can't add fragment " + paramFragment + " with tag " + paramString + " to container view with no id");
      }
      if ((paramFragment.cO != 0) && (paramFragment.cO != paramInt)) {
        throw new IllegalStateException("Can't change container ID of fragment " + paramFragment + ": was " + paramFragment.cO + " now " + paramInt);
      }
      paramFragment.cO = paramInt;
      paramFragment.cP = paramInt;
    }
    a(new f(1, paramFragment));
  }
  
  private static boolean b(f paramf)
  {
    paramf = paramf.bV;
    return (paramf != null) && (paramf.cB) && (paramf.cZ != null) && (!paramf.cS) && (!paramf.cR) && (paramf.E());
  }
  
  public final void C()
  {
    if (this.bT != null)
    {
      int j = this.bT.size();
      int i = 0;
      while (i < j)
      {
        ((Runnable)this.bT.get(i)).run();
        i += 1;
      }
      this.bT = null;
    }
  }
  
  final void D()
  {
    int j = this.bB.size();
    int i = 0;
    if (i < j)
    {
      f localf = (f)this.bB.get(i);
      Fragment localFragment = localf.bV;
      if (localFragment != null) {
        localFragment.a(this.bG, this.bH);
      }
      switch (localf.bU)
      {
      case 2: 
      default: 
        throw new IllegalArgumentException("Unknown cmd: " + localf.bU);
      case 1: 
        localFragment.n(localf.bW);
        this.bA.a(localFragment, false);
      }
      for (;;)
      {
        if ((!this.bS) && (localf.bU != 1) && (localFragment != null)) {
          this.bA.f(localFragment);
        }
        i += 1;
        break;
        localFragment.n(localf.bX);
        this.bA.h(localFragment);
        continue;
        localFragment.n(localf.bX);
        u.i(localFragment);
        continue;
        localFragment.n(localf.bW);
        u.j(localFragment);
        continue;
        localFragment.n(localf.bX);
        this.bA.k(localFragment);
        continue;
        localFragment.n(localf.bW);
        this.bA.l(localFragment);
        continue;
        this.bA.n(localFragment);
        continue;
        this.bA.n(null);
      }
    }
    if (!this.bS) {
      this.bA.b(this.bA.eh, true);
    }
  }
  
  final boolean E()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.bB.size())
      {
        if (b((f)this.bB.get(i))) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  final Fragment a(ArrayList<Fragment> paramArrayList, Fragment paramFragment)
  {
    int j = 0;
    Fragment localFragment1 = paramFragment;
    f localf;
    int i;
    Fragment localFragment2;
    int m;
    int k;
    label218:
    Fragment localFragment3;
    if (j < this.bB.size())
    {
      localf = (f)this.bB.get(j);
      i = j;
      paramFragment = localFragment1;
      switch (localf.bU)
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
          paramArrayList.add(localf.bV);
          i = j;
          paramFragment = localFragment1;
          continue;
          paramArrayList.remove(localf.bV);
          i = j;
          paramFragment = localFragment1;
          if (localf.bV == localFragment1)
          {
            this.bB.add(j, new f(9, localf.bV));
            i = j + 1;
            paramFragment = null;
          }
        }
      case 2: 
        localFragment2 = localf.bV;
        int n = localFragment2.cP;
        m = 0;
        k = paramArrayList.size() - 1;
        i = j;
        paramFragment = localFragment1;
        j = m;
        if (k >= 0)
        {
          localFragment3 = (Fragment)paramArrayList.get(k);
          if (localFragment3.cP != n) {
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
        this.bB.add(i, new f(9, localFragment3));
        m = i + 1;
        localFragment1 = null;
      }
      paramFragment = new f(3, localFragment3);
      paramFragment.bW = localf.bW;
      paramFragment.bY = localf.bY;
      paramFragment.bX = localf.bX;
      paramFragment.bZ = localf.bZ;
      this.bB.add(m, paramFragment);
      paramArrayList.remove(localFragment3);
      i = m + 1;
      paramFragment = localFragment1;
      continue;
      if (j != 0)
      {
        this.bB.remove(i);
        i -= 1;
        break;
      }
      localf.bU = 1;
      paramArrayList.add(localFragment2);
      break;
      this.bB.add(j, new f(9, localFragment1));
      i = j + 1;
      paramFragment = localf.bV;
      break;
      return localFragment1;
    }
  }
  
  public final ag a(int paramInt, Fragment paramFragment, String paramString)
  {
    b(paramInt, paramFragment, paramString);
    return this;
  }
  
  public final ag a(Fragment paramFragment)
  {
    a(new f(3, paramFragment));
    return this;
  }
  
  public final ag a(Fragment paramFragment, String paramString)
  {
    b(0, paramFragment, paramString);
    return this;
  }
  
  final void a(f paramf)
  {
    this.bB.add(paramf);
    paramf.bW = this.bC;
    paramf.bX = this.bD;
    paramf.bY = this.bE;
    paramf.bZ = this.bF;
  }
  
  final void a(n paramn)
  {
    int i = 0;
    while (i < this.bB.size())
    {
      f localf = (f)this.bB.get(i);
      if (b(localf)) {
        localf.bV.b(paramn);
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
      paramPrintWriter.print(this.bL);
      paramPrintWriter.print(" mCommitted=");
      paramPrintWriter.println(this.bK);
      if (this.bG != 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mTransition=#");
        paramPrintWriter.print(Integer.toHexString(this.bG));
        paramPrintWriter.print(" mTransitionStyle=#");
        paramPrintWriter.println(Integer.toHexString(this.bH));
      }
      if ((this.bC != 0) || (this.bD != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.bC));
        paramPrintWriter.print(" mExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.bD));
      }
      if ((this.bE != 0) || (this.bF != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mPopEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.bE));
        paramPrintWriter.print(" mPopExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.bF));
      }
      if ((this.bM != 0) || (this.bN != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.bM));
        paramPrintWriter.print(" mBreadCrumbTitleText=");
        paramPrintWriter.println(this.bN);
      }
      if ((this.bO != 0) || (this.bP != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbShortTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.bO));
        paramPrintWriter.print(" mBreadCrumbShortTitleText=");
        paramPrintWriter.println(this.bP);
      }
    }
    if (!this.bB.isEmpty())
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Operations:");
      new StringBuilder().append(paramString).append("    ");
      int j = this.bB.size();
      int i = 0;
      if (i < j)
      {
        f localf = (f)this.bB.get(i);
        String str;
        switch (localf.bU)
        {
        default: 
          str = "cmd=" + localf.bU;
        }
        for (;;)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  Op #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.print(str);
          paramPrintWriter.print(" ");
          paramPrintWriter.println(localf.bV);
          if (paramBoolean)
          {
            if ((localf.bW != 0) || (localf.bX != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("enterAnim=#");
              paramPrintWriter.print(Integer.toHexString(localf.bW));
              paramPrintWriter.print(" exitAnim=#");
              paramPrintWriter.println(Integer.toHexString(localf.bX));
            }
            if ((localf.bY != 0) || (localf.bZ != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("popEnterAnim=#");
              paramPrintWriter.print(Integer.toHexString(localf.bY));
              paramPrintWriter.print(" popExitAnim=#");
              paramPrintWriter.println(Integer.toHexString(localf.bZ));
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
  
  final boolean a(ArrayList<e> paramArrayList, int paramInt1, int paramInt2)
  {
    if (paramInt2 == paramInt1) {
      return false;
    }
    int i1 = this.bB.size();
    int j = -1;
    int k = 0;
    int i;
    if (k < i1)
    {
      Object localObject = (f)this.bB.get(k);
      if (((f)localObject).bV != null)
      {
        i = ((f)localObject).bV.cP;
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
        localObject = (e)paramArrayList.get(j);
        int i2 = ((e)localObject).bB.size();
        int m = 0;
        for (;;)
        {
          if (m >= i2) {
            break label176;
          }
          f localf = (f)((e)localObject).bB.get(m);
          if (localf.bV != null) {}
          for (int n = localf.bV.cP;; n = 0)
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
  
  public final boolean a(ArrayList<e> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    if (u.DEBUG) {
      Log.v("FragmentManager", "Run: ".concat(String.valueOf(this)));
    }
    paramArrayList.add(this);
    paramArrayList1.add(Boolean.FALSE);
    if (this.bI)
    {
      paramArrayList = this.bA;
      if (paramArrayList.eb == null) {
        paramArrayList.eb = new ArrayList();
      }
      paramArrayList.eb.add(this);
    }
    return true;
  }
  
  final Fragment b(ArrayList<Fragment> paramArrayList, Fragment paramFragment)
  {
    int i = 0;
    Fragment localFragment = paramFragment;
    if (i < this.bB.size())
    {
      f localf = (f)this.bB.get(i);
      paramFragment = localFragment;
      switch (localf.bU)
      {
      default: 
        paramFragment = localFragment;
      }
      for (;;)
      {
        i += 1;
        localFragment = paramFragment;
        break;
        paramArrayList.remove(localf.bV);
        paramFragment = localFragment;
        continue;
        paramArrayList.add(localf.bV);
        paramFragment = localFragment;
        continue;
        paramFragment = localf.bV;
        continue;
        paramFragment = null;
      }
    }
    return localFragment;
  }
  
  public final ag b(Fragment paramFragment)
  {
    a(new f(6, paramFragment));
    return this;
  }
  
  public final ag c(Fragment paramFragment)
  {
    a(new f(7, paramFragment));
    return this;
  }
  
  final void c(boolean paramBoolean)
  {
    int i = this.bB.size() - 1;
    if (i >= 0)
    {
      f localf = (f)this.bB.get(i);
      Fragment localFragment = localf.bV;
      if (localFragment != null) {
        localFragment.a(u.s(this.bG), this.bH);
      }
      switch (localf.bU)
      {
      case 2: 
      default: 
        throw new IllegalArgumentException("Unknown cmd: " + localf.bU);
      case 1: 
        localFragment.n(localf.bZ);
        this.bA.h(localFragment);
      }
      for (;;)
      {
        if ((!this.bS) && (localf.bU != 3) && (localFragment != null)) {
          this.bA.f(localFragment);
        }
        i -= 1;
        break;
        localFragment.n(localf.bY);
        this.bA.a(localFragment, false);
        continue;
        localFragment.n(localf.bY);
        u.j(localFragment);
        continue;
        localFragment.n(localf.bZ);
        u.i(localFragment);
        continue;
        localFragment.n(localf.bY);
        this.bA.l(localFragment);
        continue;
        localFragment.n(localf.bZ);
        this.bA.k(localFragment);
        continue;
        this.bA.n(null);
        continue;
        this.bA.n(localFragment);
      }
    }
    if ((!this.bS) && (paramBoolean)) {
      this.bA.b(this.bA.eh, true);
    }
  }
  
  public final int commit()
  {
    return b(false);
  }
  
  public final int commitAllowingStateLoss()
  {
    return b(true);
  }
  
  final void k(int paramInt)
  {
    if (!this.bI) {}
    for (;;)
    {
      return;
      if (u.DEBUG) {
        Log.v("FragmentManager", "Bump nesting in " + this + " by " + paramInt);
      }
      int j = this.bB.size();
      int i = 0;
      while (i < j)
      {
        f localf = (f)this.bB.get(i);
        if (localf.bV != null)
        {
          Fragment localFragment = localf.bV;
          localFragment.cH += paramInt;
          if (u.DEBUG) {
            Log.v("FragmentManager", "Bump nesting of " + localf.bV + " to " + localf.bV.cH);
          }
        }
        i += 1;
      }
    }
  }
  
  final boolean l(int paramInt)
  {
    int k = this.bB.size();
    int i = 0;
    while (i < k)
    {
      f localf = (f)this.bB.get(i);
      if (localf.bV != null) {}
      for (int j = localf.bV.cP; (j != 0) && (j == paramInt); j = 0) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("BackStackEntry{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    if (this.bL >= 0)
    {
      localStringBuilder.append(" #");
      localStringBuilder.append(this.bL);
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
 * Qualified Name:     android.support.v4.app.e
 * JD-Core Version:    0.7.0.1
 */