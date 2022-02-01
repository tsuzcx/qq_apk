package android.support.v4.app;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.b.a;
import android.support.v4.view.r;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

final class ah
{
  private static final int[] fo = { 0, 3, 0, 1, 5, 4, 7, 6, 9, 8 };
  private static final ak fp;
  private static final ak fq;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (aj localaj = new aj();; localaj = null)
    {
      fp = localaj;
      fq = aG();
      return;
    }
  }
  
  private static ai a(ai paramai, SparseArray<ai> paramSparseArray, int paramInt)
  {
    ai localai = paramai;
    if (paramai == null)
    {
      localai = new ai();
      paramSparseArray.put(paramInt, localai);
    }
    return localai;
  }
  
  private static ak a(Fragment paramFragment1, Fragment paramFragment2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramFragment1 != null)
    {
      Object localObject = paramFragment1.M();
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      localObject = paramFragment1.L();
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      paramFragment1 = paramFragment1.P();
      if (paramFragment1 != null) {
        localArrayList.add(paramFragment1);
      }
    }
    if (paramFragment2 != null)
    {
      paramFragment1 = paramFragment2.K();
      if (paramFragment1 != null) {
        localArrayList.add(paramFragment1);
      }
      paramFragment1 = paramFragment2.N();
      if (paramFragment1 != null) {
        localArrayList.add(paramFragment1);
      }
      paramFragment1 = paramFragment2.O();
      if (paramFragment1 != null) {
        localArrayList.add(paramFragment1);
      }
    }
    if (localArrayList.isEmpty()) {}
    do
    {
      return null;
      if ((fp != null) && (a(fp, localArrayList))) {
        return fp;
      }
      if ((fq != null) && (a(fq, localArrayList))) {
        return fq;
      }
    } while ((fp == null) && (fq == null));
    throw new IllegalArgumentException("Invalid Transition types");
  }
  
  private static a<String, String> a(int paramInt1, ArrayList<e> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt2, int paramInt3)
  {
    a locala = new a();
    paramInt3 -= 1;
    while (paramInt3 >= paramInt2)
    {
      Object localObject = (e)paramArrayList.get(paramInt3);
      if (((e)localObject).l(paramInt1))
      {
        boolean bool = ((Boolean)paramArrayList1.get(paramInt3)).booleanValue();
        if (((e)localObject).bQ != null)
        {
          int j = ((e)localObject).bQ.size();
          ArrayList localArrayList1;
          ArrayList localArrayList2;
          int i;
          label95:
          String str1;
          if (bool)
          {
            localArrayList1 = ((e)localObject).bQ;
            localArrayList2 = ((e)localObject).bR;
            i = 0;
            if (i >= j) {
              break label192;
            }
            localObject = (String)localArrayList2.get(i);
            str1 = (String)localArrayList1.get(i);
            String str2 = (String)locala.remove(str1);
            if (str2 == null) {
              break label179;
            }
            locala.put(localObject, str2);
          }
          for (;;)
          {
            i += 1;
            break label95;
            localArrayList2 = ((e)localObject).bQ;
            localArrayList1 = ((e)localObject).bR;
            break;
            label179:
            locala.put(localObject, str1);
          }
        }
      }
      label192:
      paramInt3 -= 1;
    }
    return locala;
  }
  
  private static a<String, View> a(ak paramak, a<String, String> parama, Object paramObject, ai paramai)
  {
    if ((parama.isEmpty()) || (paramObject == null))
    {
      parama.clear();
      return null;
    }
    paramObject = paramai.fM;
    a locala = new a();
    paramak.a(locala, paramObject.cZ);
    paramak = paramai.fO;
    int i;
    if (paramai.fN)
    {
      paramObject = paramObject.aa();
      paramak = paramak.bR;
      locala.retainAll(paramak);
      if (paramObject == null) {
        break label172;
      }
      i = paramak.size() - 1;
      label82:
      if (i < 0) {
        break label182;
      }
      paramai = (String)paramak.get(i);
      paramObject = (View)locala.get(paramai);
      if (paramObject != null) {
        break label139;
      }
      parama.remove(paramai);
    }
    for (;;)
    {
      i -= 1;
      break label82;
      paramObject = paramObject.ab();
      paramak = paramak.bQ;
      break;
      label139:
      if (!paramai.equals(r.r(paramObject)))
      {
        paramai = (String)parama.remove(paramai);
        parama.put(r.r(paramObject), paramai);
      }
    }
    label172:
    parama.retainAll(locala.keySet());
    label182:
    return locala;
  }
  
  private static View a(a<String, View> parama, ai paramai, Object paramObject, boolean paramBoolean)
  {
    paramai = paramai.fL;
    if ((paramObject != null) && (parama != null) && (paramai.bQ != null) && (!paramai.bQ.isEmpty()))
    {
      if (paramBoolean) {}
      for (paramai = (String)paramai.bQ.get(0);; paramai = (String)paramai.bR.get(0)) {
        return (View)parama.get(paramai);
      }
    }
    return null;
  }
  
  private static Object a(ak paramak, Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean)
  {
    if ((paramFragment1 == null) || (paramFragment2 == null)) {
      return null;
    }
    if (paramBoolean) {}
    for (paramFragment1 = paramFragment2.P();; paramFragment1 = paramFragment1.O()) {
      return paramak.g(paramak.f(paramFragment1));
    }
  }
  
  private static Object a(ak paramak, Fragment paramFragment, boolean paramBoolean)
  {
    if (paramFragment == null) {
      return null;
    }
    if (paramBoolean) {}
    for (paramFragment = paramFragment.N();; paramFragment = paramFragment.K()) {
      return paramak.f(paramFragment);
    }
  }
  
  private static Object a(ak paramak, Object paramObject1, Object paramObject2, Object paramObject3, Fragment paramFragment, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramObject1 != null)
    {
      bool1 = bool2;
      if (paramObject2 != null)
      {
        bool1 = bool2;
        if (paramFragment != null) {
          if (!paramBoolean) {
            break label53;
          }
        }
      }
    }
    label53:
    for (bool1 = paramFragment.getAllowReturnTransitionOverlap(); bool1; bool1 = paramFragment.getAllowEnterTransitionOverlap()) {
      return paramak.a(paramObject2, paramObject1, paramObject3);
    }
    return paramak.b(paramObject2, paramObject1, paramObject3);
  }
  
  private static String a(a<String, String> parama, String paramString)
  {
    int j = parama.size();
    int i = 0;
    while (i < j)
    {
      if (paramString.equals(parama.valueAt(i))) {
        return (String)parama.keyAt(i);
      }
      i += 1;
    }
    return null;
  }
  
  private static ArrayList<View> a(ak paramak, Object paramObject, Fragment paramFragment, ArrayList<View> paramArrayList, View paramView)
  {
    Object localObject = null;
    if (paramObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramFragment = paramFragment.cZ;
      if (paramFragment != null) {
        paramak.a(localArrayList, paramFragment);
      }
      if (paramArrayList != null) {
        localArrayList.removeAll(paramArrayList);
      }
      localObject = localArrayList;
      if (!localArrayList.isEmpty())
      {
        localArrayList.add(paramView);
        paramak.a(paramObject, localArrayList);
        localObject = localArrayList;
      }
    }
    return localObject;
  }
  
  private static void a(Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean, a<String, View> parama)
  {
    int j = 0;
    int i;
    if (paramBoolean)
    {
      paramFragment1 = paramFragment2.aa();
      if (paramFragment1 == null) {
        return;
      }
      paramFragment1 = new ArrayList();
      paramFragment2 = new ArrayList();
      if (parama != null) {
        break label85;
      }
      i = 0;
    }
    for (;;)
    {
      if (j >= i) {
        return;
      }
      paramFragment2.add(parama.keyAt(j));
      paramFragment1.add(parama.valueAt(j));
      j += 1;
      continue;
      paramFragment1 = paramFragment1.aa();
      break;
      label85:
      i = parama.size();
    }
  }
  
  private static void a(ak paramak, Object paramObject1, Object paramObject2, a<String, View> parama, boolean paramBoolean, e parame)
  {
    if ((parame.bQ != null) && (!parame.bQ.isEmpty())) {
      if (!paramBoolean) {
        break label65;
      }
    }
    label65:
    for (parame = (String)parame.bR.get(0);; parame = (String)parame.bQ.get(0))
    {
      parama = (View)parama.get(parame);
      paramak.a(paramObject1, parama);
      if (paramObject2 != null) {
        paramak.a(paramObject2, parama);
      }
      return;
    }
  }
  
  private static void a(e parame, f paramf, SparseArray<ai> paramSparseArray, boolean paramBoolean1, boolean paramBoolean2)
  {
    Fragment localFragment = paramf.bV;
    if (localFragment == null) {}
    int n;
    do
    {
      return;
      n = localFragment.cP;
    } while (n == 0);
    int i;
    label38:
    int j;
    int k;
    boolean bool;
    if (paramBoolean1)
    {
      i = fo[paramf.bU];
      switch (i)
      {
      case 2: 
      default: 
        i = 0;
        j = 0;
        k = 0;
        bool = false;
        paramf = (ai)paramSparseArray.get(n);
        if (bool)
        {
          paramf = a(paramf, paramSparseArray, n);
          paramf.fJ = localFragment;
          paramf.fK = paramBoolean1;
          paramf.fL = parame;
        }
        break;
      }
    }
    for (;;)
    {
      if ((!paramBoolean2) && (i != 0))
      {
        if ((paramf != null) && (paramf.fM == localFragment)) {
          paramf.fM = null;
        }
        u localu = parame.bA;
        if ((localFragment.cs <= 0) && (localu.eh > 0) && (!parame.bS))
        {
          localu.g(localFragment);
          localu.a(localFragment, 1, 0, 0, false);
        }
      }
      if ((j != 0) && ((paramf == null) || (paramf.fM == null)))
      {
        paramf = a(paramf, paramSparseArray, n);
        paramf.fM = localFragment;
        paramf.fN = paramBoolean1;
        paramf.fO = parame;
      }
      for (parame = paramf; (!paramBoolean2) && (k != 0) && (parame != null) && (parame.fJ == localFragment); parame = paramf)
      {
        parame.fJ = null;
        return;
        i = paramf.bU;
        break label38;
        if (paramBoolean2) {
          if ((localFragment.dg) && (!localFragment.cR) && (localFragment.cB)) {
            bool = true;
          }
        }
        for (;;)
        {
          i = 1;
          j = 0;
          k = 0;
          break;
          bool = false;
          continue;
          bool = localFragment.cR;
        }
        if (paramBoolean2) {
          bool = localFragment.df;
        }
        for (;;)
        {
          i = 1;
          j = 0;
          k = 0;
          break;
          if ((!localFragment.cB) && (!localFragment.cR)) {
            bool = true;
          } else {
            bool = false;
          }
        }
        if (paramBoolean2) {
          if ((localFragment.dg) && (localFragment.cB) && (localFragment.cR)) {
            i = 1;
          }
        }
        int m;
        for (;;)
        {
          m = 0;
          j = i;
          k = 1;
          bool = false;
          i = m;
          break;
          i = 0;
          continue;
          if ((localFragment.cB) && (!localFragment.cR)) {
            i = 1;
          } else {
            i = 0;
          }
        }
        if (paramBoolean2) {
          if ((!localFragment.cB) && (localFragment.cZ != null) && (localFragment.cZ.getVisibility() == 0) && (localFragment.dh >= 0.0F)) {
            i = 1;
          }
        }
        for (;;)
        {
          m = 0;
          j = i;
          k = 1;
          bool = false;
          i = m;
          break;
          i = 0;
          continue;
          if ((localFragment.cB) && (!localFragment.cR)) {
            i = 1;
          } else {
            i = 0;
          }
        }
      }
    }
  }
  
  private static void a(e parame, SparseArray<ai> paramSparseArray, boolean paramBoolean)
  {
    int j = parame.bB.size();
    int i = 0;
    while (i < j)
    {
      a(parame, (f)parame.bB.get(i), paramSparseArray, false, paramBoolean);
      i += 1;
    }
  }
  
  static void a(u paramu, ArrayList<e> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramu.eh <= 0) {}
    SparseArray localSparseArray;
    final Object localObject1;
    do
    {
      return;
      localSparseArray = new SparseArray();
      i = paramInt1;
      if (i < paramInt2)
      {
        localObject1 = (e)paramArrayList.get(i);
        if (((Boolean)paramArrayList1.get(i)).booleanValue()) {
          b((e)localObject1, localSparseArray, paramBoolean);
        }
        for (;;)
        {
          i += 1;
          break;
          a((e)localObject1, localSparseArray, paramBoolean);
        }
      }
    } while (localSparseArray.size() == 0);
    final View localView = new View(paramu.cJ.mContext);
    int j = localSparseArray.size();
    int i = 0;
    label117:
    int k;
    final a locala1;
    Object localObject5;
    if (i < j)
    {
      k = localSparseArray.keyAt(i);
      locala1 = a(k, paramArrayList, paramArrayList1, paramInt1, paramInt2);
      localObject5 = (ai)localSparseArray.valueAt(i);
      if (!paramBoolean) {
        break label829;
      }
      if (!paramu.ei.onHasView()) {
        break label1385;
      }
    }
    label535:
    label553:
    label682:
    label829:
    label967:
    label1233:
    label1247:
    label1383:
    label1385:
    for (ViewGroup localViewGroup = (ViewGroup)paramu.ei.onFindViewById(k);; localViewGroup = null)
    {
      final Fragment localFragment1;
      Object localObject11;
      Object localObject6;
      final boolean bool1;
      final boolean bool2;
      Object localObject7;
      final Object localObject8;
      Object localObject9;
      Object localObject10;
      final Fragment localFragment2;
      final Fragment localFragment3;
      final Object localObject2;
      Object localObject3;
      Object localObject4;
      if (localViewGroup != null)
      {
        localFragment1 = ((ai)localObject5).fJ;
        localObject11 = ((ai)localObject5).fM;
        localObject6 = a((Fragment)localObject11, localFragment1);
        if (localObject6 != null)
        {
          bool1 = ((ai)localObject5).fK;
          bool2 = ((ai)localObject5).fN;
          localObject7 = new ArrayList();
          localObject8 = new ArrayList();
          localObject9 = a((ak)localObject6, localFragment1, bool1);
          localObject10 = b((ak)localObject6, (Fragment)localObject11, bool2);
          localFragment2 = ((ai)localObject5).fJ;
          localFragment3 = ((ai)localObject5).fM;
          if (localFragment2 != null) {
            localFragment2.cZ.setVisibility(0);
          }
          if ((localFragment2 != null) && (localFragment3 != null)) {
            break label535;
          }
          localObject1 = null;
          if ((localObject9 != null) || (localObject1 != null) || (localObject10 != null))
          {
            localObject2 = a((ak)localObject6, localObject10, (Fragment)localObject11, (ArrayList)localObject8, localView);
            localObject3 = a((ak)localObject6, localObject9, localFragment1, (ArrayList)localObject7, localView);
            a((ArrayList)localObject3, 4);
            localObject4 = a((ak)localObject6, localObject9, localObject10, localObject1, localFragment1, bool1);
            if (localObject4 != null)
            {
              if ((localObject11 != null) && (localObject10 != null) && (((Fragment)localObject11).cB) && (((Fragment)localObject11).cR) && (((Fragment)localObject11).dg))
              {
                ((Fragment)localObject11).f(true);
                ((ak)localObject6).b(localObject10, ((Fragment)localObject11).cZ, (ArrayList)localObject2);
                az.a(((Fragment)localObject11).cY, new Runnable()
                {
                  public final void run()
                  {
                    ah.a(ah.this);
                  }
                });
              }
              localObject5 = ak.b((ArrayList)localObject7);
              ((ak)localObject6).a(localObject4, localObject9, (ArrayList)localObject3, localObject10, (ArrayList)localObject2, localObject1, (ArrayList)localObject7);
              ((ak)localObject6).a(localViewGroup, localObject4);
              ((ak)localObject6).a(localViewGroup, (ArrayList)localObject8, (ArrayList)localObject7, (ArrayList)localObject5, locala1);
              a((ArrayList)localObject3, 0);
              ((ak)localObject6).a(localObject1, (ArrayList)localObject8, (ArrayList)localObject7);
            }
          }
        }
      }
      for (;;)
      {
        i += 1;
        break label117;
        break;
        bool2 = ((ai)localObject5).fK;
        final a locala2;
        if (locala1.isEmpty())
        {
          localObject1 = null;
          localObject3 = a((ak)localObject6, locala1, localObject1, (ai)localObject5);
          locala2 = b((ak)localObject6, locala1, localObject1, (ai)localObject5);
          if (!locala1.isEmpty()) {
            break label655;
          }
          localObject2 = null;
          if (localObject3 != null) {
            ((a)localObject3).clear();
          }
          localObject1 = localObject2;
          if (locala2 != null)
          {
            locala2.clear();
            localObject1 = localObject2;
          }
        }
        for (;;)
        {
          if ((localObject9 != null) || (localObject10 != null) || (localObject1 != null)) {
            break label682;
          }
          localObject1 = null;
          break;
          localObject1 = a((ak)localObject6, localFragment2, localFragment3, bool2);
          break label553;
          a((ArrayList)localObject8, (a)localObject3, locala1.keySet());
          a((ArrayList)localObject7, locala2, locala1.values());
        }
        a(localFragment2, localFragment3, bool2, (a)localObject3);
        if (localObject1 != null)
        {
          ((ArrayList)localObject7).add(localView);
          ((ak)localObject6).a(localObject1, localView, (ArrayList)localObject8);
          a((ak)localObject6, localObject1, localObject10, (a)localObject3, ((ai)localObject5).fN, ((ai)localObject5).fO);
          localObject4 = new Rect();
          localObject5 = a(locala2, (ai)localObject5, localObject9, bool2);
          localObject2 = localObject5;
          localObject3 = localObject4;
          if (localObject5 != null)
          {
            ((ak)localObject6).a(localObject9, (Rect)localObject4);
            localObject3 = localObject4;
          }
        }
        for (localObject2 = localObject5;; localObject2 = null)
        {
          az.a(localViewGroup, new Runnable()
          {
            public final void run()
            {
              ah.b(ah.this, localFragment3, bool2, locala2);
              if (this.fC != null) {
                ak.a(this.fC, this.fD);
              }
            }
          });
          break;
          localObject3 = null;
        }
        if (paramu.ei.onHasView()) {}
        for (localViewGroup = (ViewGroup)paramu.ei.onFindViewById(k);; localViewGroup = null)
        {
          if (localViewGroup == null) {
            break label1383;
          }
          localObject6 = ((ai)localObject5).fJ;
          localObject10 = ((ai)localObject5).fM;
          localObject7 = a((Fragment)localObject10, (Fragment)localObject6);
          if (localObject7 == null) {
            break;
          }
          bool1 = ((ai)localObject5).fK;
          bool2 = ((ai)localObject5).fN;
          localObject8 = a((ak)localObject7, (Fragment)localObject6, bool1);
          localObject3 = b((ak)localObject7, (Fragment)localObject10, bool2);
          localObject11 = new ArrayList();
          localObject9 = new ArrayList();
          localFragment1 = ((ai)localObject5).fJ;
          localFragment2 = ((ai)localObject5).fM;
          if ((localFragment1 == null) || (localFragment2 == null))
          {
            localObject1 = null;
            if ((localObject8 == null) && (localObject1 == null) && (localObject3 == null)) {
              break label1364;
            }
            localObject4 = a((ak)localObject7, localObject3, (Fragment)localObject10, (ArrayList)localObject11, localView);
            if ((localObject4 != null) && (!((ArrayList)localObject4).isEmpty())) {
              break label1372;
            }
          }
          for (localObject2 = null;; localObject2 = localObject3)
          {
            ((ak)localObject7).b(localObject8, localView);
            localObject3 = a((ak)localObject7, localObject8, localObject2, localObject1, (Fragment)localObject6, ((ai)localObject5).fK);
            if (localObject3 == null) {
              break;
            }
            localObject5 = new ArrayList();
            ((ak)localObject7).a(localObject3, localObject8, (ArrayList)localObject5, localObject2, (ArrayList)localObject4, localObject1, (ArrayList)localObject9);
            az.a(localViewGroup, new Runnable()
            {
              public final void run()
              {
                ArrayList localArrayList;
                if (ah.this != null)
                {
                  this.ft.c(ah.this, localView);
                  localArrayList = ah.b(this.ft, ah.this, this.fv, this.fw, localView);
                  this.fx.addAll(localArrayList);
                }
                if (this.fr != null)
                {
                  if (localObject2 != null)
                  {
                    localArrayList = new ArrayList();
                    localArrayList.add(localView);
                    this.ft.b(localObject2, this.fr, localArrayList);
                  }
                  this.fr.clear();
                  this.fr.add(localView);
                }
              }
            });
            az.a(localViewGroup, new ak.2((ak)localObject7, (ArrayList)localObject9, locala1));
            ((ak)localObject7).a(localViewGroup, localObject3);
            az.a(localViewGroup, new ak.3((ak)localObject7, (ArrayList)localObject9, locala1));
            break;
            bool1 = ((ai)localObject5).fK;
            if (locala1.isEmpty())
            {
              localObject1 = null;
              localObject2 = a((ak)localObject7, locala1, localObject1, (ai)localObject5);
              if (!locala1.isEmpty()) {
                break label1233;
              }
              localObject1 = null;
            }
            for (;;)
            {
              if ((localObject8 != null) || (localObject3 != null) || (localObject1 != null)) {
                break label1247;
              }
              localObject1 = null;
              break;
              localObject1 = a((ak)localObject7, localFragment1, localFragment2, bool1);
              break label1172;
              ((ArrayList)localObject11).addAll(((a)localObject2).values());
            }
            a(localFragment1, localFragment2, bool1, (a)localObject2);
            if (localObject1 != null)
            {
              localObject4 = new Rect();
              ((ak)localObject7).a(localObject1, localView, (ArrayList)localObject11);
              a((ak)localObject7, localObject1, localObject3, (a)localObject2, ((ai)localObject5).fN, ((ai)localObject5).fO);
              localObject2 = localObject4;
              if (localObject8 != null) {
                ((ak)localObject7).a(localObject8, (Rect)localObject4);
              }
            }
            for (localObject2 = localObject4;; localObject2 = null)
            {
              az.a(localViewGroup, new Runnable()
              {
                public final void run()
                {
                  Object localObject = ah.c(ah.this, locala1, localObject1, this.fG);
                  if (localObject != null)
                  {
                    this.fw.addAll(((a)localObject).values());
                    this.fw.add(localView);
                  }
                  ah.b(localFragment1, localFragment2, bool1, (a)localObject);
                  if (localObject1 != null)
                  {
                    ah.this.a(localObject1, this.fH, this.fw);
                    localObject = ah.b((a)localObject, this.fG, localObject8, bool1);
                    if (localObject != null) {
                      ak.a((View)localObject, this.fI);
                    }
                  }
                }
              });
              break label967;
              break;
            }
          }
        }
      }
    }
  }
  
  private static void a(ArrayList<View> paramArrayList, int paramInt)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
      int i = paramArrayList.size() - 1;
      while (i >= 0)
      {
        ((View)paramArrayList.get(i)).setVisibility(paramInt);
        i -= 1;
      }
    }
  }
  
  private static void a(ArrayList<View> paramArrayList, a<String, View> parama, Collection<String> paramCollection)
  {
    int i = parama.size() - 1;
    while (i >= 0)
    {
      View localView = (View)parama.valueAt(i);
      if (paramCollection.contains(r.r(localView))) {
        paramArrayList.add(localView);
      }
      i -= 1;
    }
  }
  
  private static boolean a(ak paramak, List<Object> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      if (!paramak.e(paramList.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private static ak aG()
  {
    try
    {
      ak localak = (ak)Class.forName("android.support.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return localak;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private static a<String, View> b(ak paramak, a<String, String> parama, Object paramObject, ai paramai)
  {
    Fragment localFragment = paramai.fJ;
    View localView = localFragment.cZ;
    if ((parama.isEmpty()) || (paramObject == null) || (localView == null))
    {
      parama.clear();
      return null;
    }
    a locala = new a();
    paramak.a(locala, localView);
    paramak = paramai.fL;
    if (paramai.fK)
    {
      paramObject = localFragment.ab();
      paramak = paramak.bQ;
      if (paramak != null)
      {
        locala.retainAll(paramak);
        locala.retainAll(parama.values());
      }
      if (paramObject == null) {
        break label210;
      }
      i = paramak.size() - 1;
      label108:
      if (i < 0) {
        break label256;
      }
      paramai = (String)paramak.get(i);
      paramObject = (View)locala.get(paramai);
      if (paramObject != null) {
        break label176;
      }
      paramObject = a(parama, paramai);
      if (paramObject != null) {
        parama.remove(paramObject);
      }
    }
    for (;;)
    {
      i -= 1;
      break label108;
      paramObject = localFragment.aa();
      paramak = paramak.bR;
      break;
      label176:
      if (!paramai.equals(r.r(paramObject)))
      {
        paramai = a(parama, paramai);
        if (paramai != null) {
          parama.put(paramai, r.r(paramObject));
        }
      }
    }
    label210:
    int i = parama.size() - 1;
    while (i >= 0)
    {
      if (!locala.containsKey((String)parama.valueAt(i))) {
        parama.removeAt(i);
      }
      i -= 1;
    }
    label256:
    return locala;
  }
  
  private static Object b(ak paramak, Fragment paramFragment, boolean paramBoolean)
  {
    if (paramFragment == null) {
      return null;
    }
    if (paramBoolean) {}
    for (paramFragment = paramFragment.L();; paramFragment = paramFragment.M()) {
      return paramak.f(paramFragment);
    }
  }
  
  private static void b(e parame, SparseArray<ai> paramSparseArray, boolean paramBoolean)
  {
    if (!parame.bA.ei.onHasView()) {}
    for (;;)
    {
      return;
      int i = parame.bB.size() - 1;
      while (i >= 0)
      {
        a(parame, (f)parame.bB.get(i), paramSparseArray, true, paramBoolean);
        i -= 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.ah
 * JD-Core Version:    0.7.0.1
 */