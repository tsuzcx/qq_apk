package android.support.v4.app;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.b.a;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;

final class af
{
  private static final int[] dz = { 0, 3, 0, 1, 5, 4, 7, 6, 9, 8 };
  
  private static ag a(ag paramag, SparseArray<ag> paramSparseArray, int paramInt)
  {
    ag localag = paramag;
    if (paramag == null)
    {
      localag = new ag();
      paramSparseArray.put(paramInt, localag);
    }
    return localag;
  }
  
  private static a<String, String> a(int paramInt1, ArrayList<d> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt2, int paramInt3)
  {
    a locala = new a();
    paramInt3 -= 1;
    while (paramInt3 >= paramInt2)
    {
      Object localObject = (d)paramArrayList.get(paramInt3);
      if (((d)localObject).c(paramInt1))
      {
        boolean bool = ((Boolean)paramArrayList1.get(paramInt3)).booleanValue();
        if (((d)localObject).ah != null)
        {
          int j = ((d)localObject).ah.size();
          ArrayList localArrayList1;
          ArrayList localArrayList2;
          int i;
          label95:
          String str1;
          if (bool)
          {
            localArrayList1 = ((d)localObject).ah;
            localArrayList2 = ((d)localObject).ai;
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
            localArrayList2 = ((d)localObject).ah;
            localArrayList1 = ((d)localObject).ai;
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
  
  private static a<String, View> a(a<String, String> parama, Object paramObject, ag paramag)
  {
    if ((parama.isEmpty()) || (paramObject == null))
    {
      parama.clear();
      return null;
    }
    Object localObject = paramag.dU;
    a locala = new a();
    ah.a(locala, ((Fragment)localObject).bo);
    paramObject = paramag.dW;
    int i;
    if (paramag.dV)
    {
      paramag = ((Fragment)localObject).K();
      paramObject = paramObject.ai;
      locala.retainAll(paramObject);
      if (paramag == null) {
        break label177;
      }
      i = paramObject.size() - 1;
      label83:
      if (i < 0) {
        break label187;
      }
      localObject = (String)paramObject.get(i);
      paramag = (View)locala.get(localObject);
      if (paramag != null) {
        break label140;
      }
      parama.remove(localObject);
    }
    for (;;)
    {
      i -= 1;
      break label83;
      paramag = ((Fragment)localObject).L();
      paramObject = paramObject.ah;
      break;
      label140:
      if (!((String)localObject).equals(android.support.v4.view.r.q(paramag)))
      {
        localObject = (String)parama.remove(localObject);
        parama.put(android.support.v4.view.r.q(paramag), localObject);
      }
    }
    label177:
    parama.retainAll(locala.keySet());
    label187:
    return locala;
  }
  
  private static View a(a<String, View> parama, ag paramag, Object paramObject, boolean paramBoolean)
  {
    paramag = paramag.dT;
    if ((paramObject != null) && (parama != null) && (paramag.ah != null) && (!paramag.ah.isEmpty()))
    {
      if (paramBoolean) {}
      for (paramag = (String)paramag.ah.get(0);; paramag = (String)paramag.ai.get(0)) {
        return (View)parama.get(paramag);
      }
    }
    return null;
  }
  
  private static Object a(Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean)
  {
    if ((paramFragment1 == null) || (paramFragment2 == null)) {
      return null;
    }
    if (paramBoolean) {
      if (paramFragment2.bv == null) {
        paramFragment1 = null;
      }
    }
    for (;;)
    {
      paramFragment1 = ah.a(paramFragment1);
      if (paramFragment1 == null) {
        break;
      }
      paramFragment2 = new TransitionSet();
      paramFragment2.addTransition((Transition)paramFragment1);
      return paramFragment2;
      paramFragment1 = paramFragment2;
      if (k.f(paramFragment2.bv) != Fragment.aI) {
        paramFragment1 = k.f(paramFragment2.bv);
      } else {
        paramFragment1 = paramFragment1.z();
      }
    }
  }
  
  private static Object a(Object paramObject1, Object paramObject2, Object paramObject3, Fragment paramFragment, boolean paramBoolean)
  {
    if ((paramObject1 != null) && (paramObject2 != null) && (paramFragment != null)) {
      if (paramBoolean) {
        if ((paramFragment.bv == null) || (k.h(paramFragment.bv) == null)) {
          paramBoolean = true;
        }
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        paramFragment = new TransitionSet();
        if (paramObject2 != null) {
          paramFragment.addTransition((Transition)paramObject2);
        }
        if (paramObject1 != null) {
          paramFragment.addTransition((Transition)paramObject1);
        }
        if (paramObject3 != null) {
          paramFragment.addTransition((Transition)paramObject3);
        }
        return paramFragment;
        paramBoolean = k.h(paramFragment.bv).booleanValue();
        continue;
        if ((paramFragment.bv == null) || (k.g(paramFragment.bv) == null)) {
          paramBoolean = true;
        } else {
          paramBoolean = k.g(paramFragment.bv).booleanValue();
        }
      }
      else
      {
        paramObject2 = (Transition)paramObject2;
        paramObject1 = (Transition)paramObject1;
        paramObject3 = (Transition)paramObject3;
        if ((paramObject2 != null) && (paramObject1 != null)) {
          paramObject1 = new TransitionSet().addTransition(paramObject2).addTransition(paramObject1).setOrdering(1);
        }
        for (;;)
        {
          if (paramObject3 != null)
          {
            paramObject2 = new TransitionSet();
            if (paramObject1 != null) {
              paramObject2.addTransition(paramObject1);
            }
            paramObject2.addTransition(paramObject3);
            return paramObject2;
            if (paramObject2 != null)
            {
              paramObject1 = paramObject2;
              continue;
            }
            if (paramObject1 == null) {}
          }
          else
          {
            return paramObject1;
          }
          paramObject1 = null;
        }
        paramBoolean = true;
      }
    }
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
  
  private static ArrayList<View> a(Object paramObject, Fragment paramFragment, ArrayList<View> paramArrayList, View paramView)
  {
    Object localObject = null;
    if (paramObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramFragment = paramFragment.bo;
      if (paramFragment != null) {
        ah.a(localArrayList, paramFragment);
      }
      if (paramArrayList != null) {
        localArrayList.removeAll(paramArrayList);
      }
      localObject = localArrayList;
      if (!localArrayList.isEmpty())
      {
        localArrayList.add(paramView);
        ah.a(paramObject, localArrayList);
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
      paramFragment1 = paramFragment2.K();
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
      paramFragment1 = paramFragment1.K();
      break;
      label85:
      i = parama.size();
    }
  }
  
  private static void a(d paramd, e parame, SparseArray<ag> paramSparseArray, boolean paramBoolean1, boolean paramBoolean2)
  {
    Fragment localFragment = parame.am;
    if (localFragment == null) {}
    int n;
    do
    {
      return;
      n = localFragment.be;
    } while (n == 0);
    int i;
    label38:
    int j;
    int k;
    boolean bool;
    if (paramBoolean1)
    {
      i = dz[parame.al];
      switch (i)
      {
      case 2: 
      default: 
        i = 0;
        j = 0;
        k = 0;
        bool = false;
        parame = (ag)paramSparseArray.get(n);
        if (bool)
        {
          parame = a(parame, paramSparseArray, n);
          parame.dR = localFragment;
          parame.dS = paramBoolean1;
          parame.dT = paramd;
        }
        break;
      }
    }
    for (;;)
    {
      if ((!paramBoolean2) && (i != 0))
      {
        if ((parame != null) && (parame.dU == localFragment)) {
          parame.dU = null;
        }
        t localt = paramd.R;
        if ((localFragment.aJ <= 0) && (localt.cy > 0) && (!paramd.aj))
        {
          localt.g(localFragment);
          localt.a(localFragment, 1, 0, 0, false);
        }
      }
      if ((j != 0) && ((parame == null) || (parame.dU == null)))
      {
        parame = a(parame, paramSparseArray, n);
        parame.dU = localFragment;
        parame.dV = paramBoolean1;
        parame.dW = paramd;
      }
      for (paramd = parame; (!paramBoolean2) && (k != 0) && (paramd != null) && (paramd.dR == localFragment); paramd = parame)
      {
        paramd.dR = null;
        return;
        i = parame.al;
        break label38;
        if (paramBoolean2) {
          if ((localFragment.bx) && (!localFragment.bg) && (localFragment.aR)) {
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
          bool = localFragment.bg;
        }
        if (paramBoolean2) {
          bool = localFragment.bw;
        }
        for (;;)
        {
          i = 1;
          j = 0;
          k = 0;
          break;
          if ((!localFragment.aR) && (!localFragment.bg)) {
            bool = true;
          } else {
            bool = false;
          }
        }
        if (paramBoolean2) {
          if ((localFragment.bx) && (localFragment.aR) && (localFragment.bg)) {
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
          if ((localFragment.aR) && (!localFragment.bg)) {
            i = 1;
          } else {
            i = 0;
          }
        }
        if (paramBoolean2) {
          if ((!localFragment.aR) && (localFragment.bo != null) && (localFragment.bo.getVisibility() == 0) && (localFragment.by >= 0.0F)) {
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
          if ((localFragment.aR) && (!localFragment.bg)) {
            i = 1;
          } else {
            i = 0;
          }
        }
      }
    }
  }
  
  private static void a(d paramd, SparseArray<ag> paramSparseArray, boolean paramBoolean)
  {
    int j = paramd.S.size();
    int i = 0;
    while (i < j)
    {
      a(paramd, (e)paramd.S.get(i), paramSparseArray, false, paramBoolean);
      i += 1;
    }
  }
  
  static void a(t paramt, ArrayList<d> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramt.cy <= 0) {}
    SparseArray localSparseArray;
    final Object localObject1;
    do
    {
      do
      {
        return;
      } while (Build.VERSION.SDK_INT < 21);
      localSparseArray = new SparseArray();
      i = paramInt1;
      if (i < paramInt2)
      {
        localObject1 = (d)paramArrayList.get(i);
        if (((Boolean)paramArrayList1.get(i)).booleanValue()) {
          b((d)localObject1, localSparseArray, paramBoolean);
        }
        for (;;)
        {
          i += 1;
          break;
          a((d)localObject1, localSparseArray, paramBoolean);
        }
      }
    } while (localSparseArray.size() == 0);
    final View localView = new View(paramt.aZ.mContext);
    int j = localSparseArray.size();
    int i = 0;
    label125:
    int k;
    a locala1;
    Object localObject5;
    if (i < j)
    {
      k = localSparseArray.keyAt(i);
      locala1 = a(k, paramArrayList, paramArrayList1, paramInt1, paramInt2);
      localObject5 = (ag)localSparseArray.valueAt(i);
      if (!paramBoolean) {
        break label804;
      }
      if (!paramt.cz.onHasView()) {
        break label1320;
      }
    }
    label524:
    label542:
    label804:
    label1318:
    label1320:
    for (ViewGroup localViewGroup = (ViewGroup)paramt.cz.onFindViewById(k);; localViewGroup = null)
    {
      final Fragment localFragment1;
      Object localObject10;
      final boolean bool1;
      final boolean bool2;
      Object localObject6;
      final Object localObject7;
      Object localObject8;
      Object localObject9;
      final Fragment localFragment2;
      final Fragment localFragment3;
      final Object localObject2;
      Object localObject3;
      Object localObject4;
      if (localViewGroup != null)
      {
        localFragment1 = ((ag)localObject5).dR;
        localObject10 = ((ag)localObject5).dU;
        bool1 = ((ag)localObject5).dS;
        bool2 = ((ag)localObject5).dV;
        localObject6 = new ArrayList();
        localObject7 = new ArrayList();
        localObject8 = i(localFragment1, bool1);
        localObject9 = j((Fragment)localObject10, bool2);
        localFragment2 = ((ag)localObject5).dR;
        localFragment3 = ((ag)localObject5).dU;
        if (localFragment2 != null) {
          localFragment2.bo.setVisibility(0);
        }
        if ((localFragment2 != null) && (localFragment3 != null)) {
          break label524;
        }
        localObject1 = null;
        if ((localObject8 != null) || (localObject1 != null) || (localObject9 != null))
        {
          localObject2 = a(localObject9, (Fragment)localObject10, (ArrayList)localObject7, localView);
          localObject3 = a(localObject8, localFragment1, (ArrayList)localObject6, localView);
          a((ArrayList)localObject3, 4);
          localObject4 = a(localObject8, localObject9, localObject1, localFragment1, bool1);
          if (localObject4 != null)
          {
            if ((localObject10 != null) && (localObject9 != null) && (((Fragment)localObject10).aR) && (((Fragment)localObject10).bg) && (((Fragment)localObject10).bx))
            {
              ((Fragment)localObject10).c(true);
              localObject5 = ((Fragment)localObject10).bo;
              ((Transition)localObject9).addListener(new ah.2((View)localObject5, (ArrayList)localObject2));
              bs.a(((Fragment)localObject10).bn, new Runnable()
              {
                public final void run()
                {
                  af.a(af.this);
                }
              });
            }
            localObject5 = ah.b((ArrayList)localObject6);
            ah.a(localObject4, localObject8, (ArrayList)localObject3, localObject9, (ArrayList)localObject2, localObject1, (ArrayList)localObject6);
            ah.a(localViewGroup, localObject4);
            ah.a(localViewGroup, (ArrayList)localObject7, (ArrayList)localObject6, (ArrayList)localObject5, locala1);
            a((ArrayList)localObject3, 0);
            ah.a(localObject1, (ArrayList)localObject7, (ArrayList)localObject6);
          }
        }
      }
      for (;;)
      {
        i += 1;
        break label125;
        break;
        bool2 = ((ag)localObject5).dS;
        final a locala2;
        if (locala1.isEmpty())
        {
          localObject1 = null;
          localObject3 = a(locala1, localObject1, (ag)localObject5);
          locala2 = b(locala1, localObject1, (ag)localObject5);
          if (!locala1.isEmpty()) {
            break label638;
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
          if ((localObject8 != null) || (localObject9 != null) || (localObject1 != null)) {
            break label665;
          }
          localObject1 = null;
          break;
          localObject1 = a(localFragment2, localFragment3, bool2);
          break label542;
          label638:
          a((ArrayList)localObject7, (a)localObject3, locala1.keySet());
          a((ArrayList)localObject6, locala2, locala1.values());
        }
        a(localFragment2, localFragment3, bool2, (a)localObject3);
        if (localObject1 != null)
        {
          ((ArrayList)localObject6).add(localView);
          ah.a(localObject1, localView, (ArrayList)localObject7);
          a(localObject1, localObject9, (a)localObject3, ((ag)localObject5).dV, ((ag)localObject5).dW);
          localObject4 = new Rect();
          localObject5 = a(locala2, (ag)localObject5, localObject8, bool2);
          localObject2 = localObject5;
          localObject3 = localObject4;
          if (localObject5 != null)
          {
            ah.a(localObject8, (Rect)localObject4);
            localObject3 = localObject4;
          }
        }
        for (localObject2 = localObject5;; localObject2 = null)
        {
          bs.a(localViewGroup, new Runnable()
          {
            public final void run()
            {
              af.b(af.this, localFragment3, bool2, locala2);
              if (this.dK != null) {
                ah.a(this.dK, this.dL);
              }
            }
          });
          break;
          localObject3 = null;
        }
        if (paramt.cz.onHasView()) {}
        for (localViewGroup = (ViewGroup)paramt.cz.onFindViewById(k);; localViewGroup = null)
        {
          if (localViewGroup == null) {
            break label1318;
          }
          localObject6 = ((ag)localObject5).dR;
          localObject9 = ((ag)localObject5).dU;
          bool1 = ((ag)localObject5).dS;
          bool2 = ((ag)localObject5).dV;
          localObject7 = i((Fragment)localObject6, bool1);
          localObject3 = j((Fragment)localObject9, bool2);
          localObject10 = new ArrayList();
          localObject8 = new ArrayList();
          localFragment1 = ((ag)localObject5).dR;
          localFragment2 = ((ag)localObject5).dU;
          if ((localFragment1 == null) || (localFragment2 == null))
          {
            localObject1 = null;
            if ((localObject7 == null) && (localObject1 == null) && (localObject3 == null)) {
              break label1306;
            }
            localObject4 = a(localObject3, (Fragment)localObject9, (ArrayList)localObject10, localView);
            if (localObject4 != null)
            {
              localObject2 = localObject3;
              if (!((ArrayList)localObject4).isEmpty()) {}
            }
            else
            {
              localObject2 = null;
            }
            if (localObject7 != null) {
              ((Transition)localObject7).addTarget(localView);
            }
            localObject3 = a(localObject7, localObject2, localObject1, (Fragment)localObject6, ((ag)localObject5).dS);
            if (localObject3 == null) {
              break;
            }
            localObject5 = new ArrayList();
            ah.a(localObject3, localObject7, (ArrayList)localObject5, localObject2, (ArrayList)localObject4, localObject1, (ArrayList)localObject8);
            bs.a(localViewGroup, new Runnable()
            {
              public final void run()
              {
                Object localObject;
                if (af.this != null)
                {
                  localObject = af.this;
                  View localView = localView;
                  if (localObject != null) {
                    ((Transition)localObject).removeTarget(localView);
                  }
                  localObject = af.b(af.this, this.dD, this.dE, localView);
                  this.dF.addAll((Collection)localObject);
                }
                if (this.dA != null)
                {
                  if (localObject2 != null)
                  {
                    localObject = new ArrayList();
                    ((ArrayList)localObject).add(localView);
                    ah.b(localObject2, this.dA, (ArrayList)localObject);
                  }
                  this.dA.clear();
                  this.dA.add(localView);
                }
              }
            });
            bs.a(localViewGroup, new ah.4((ArrayList)localObject8, locala1));
            ah.a(localViewGroup, localObject3);
            bs.a(localViewGroup, new ah.7((ArrayList)localObject8, locala1));
            break;
          }
          bool1 = ((ag)localObject5).dS;
          if (locala1.isEmpty())
          {
            localObject1 = null;
            label1126:
            localObject2 = a(locala1, localObject1, (ag)localObject5);
            if (!locala1.isEmpty()) {
              break label1183;
            }
            localObject1 = null;
          }
          for (;;)
          {
            if ((localObject7 != null) || (localObject3 != null) || (localObject1 != null)) {
              break label1197;
            }
            localObject1 = null;
            break;
            localObject1 = a(localFragment1, localFragment2, bool1);
            break label1126;
            ((ArrayList)localObject10).addAll(((a)localObject2).values());
          }
          label1197:
          a(localFragment1, localFragment2, bool1, (a)localObject2);
          if (localObject1 != null)
          {
            localObject4 = new Rect();
            ah.a(localObject1, localView, (ArrayList)localObject10);
            a(localObject1, localObject3, (a)localObject2, ((ag)localObject5).dV, ((ag)localObject5).dW);
            localObject2 = localObject4;
            if (localObject7 != null) {
              ah.a(localObject7, (Rect)localObject4);
            }
          }
          for (localObject2 = localObject4;; localObject2 = null)
          {
            bs.a(localViewGroup, new Runnable()
            {
              public final void run()
              {
                Object localObject = af.c(af.this, localObject1, this.dO);
                if (localObject != null)
                {
                  this.dE.addAll(((a)localObject).values());
                  this.dE.add(localView);
                }
                af.b(localFragment1, localFragment2, bool1, (a)localObject);
                if (localObject1 != null)
                {
                  ah.a(localObject1, this.dP, this.dE);
                  localObject = af.b((a)localObject, this.dO, localObject7, bool1);
                  if (localObject != null) {
                    ah.a((View)localObject, this.dQ);
                  }
                }
              }
            });
            break label924;
            break;
          }
        }
      }
    }
  }
  
  private static void a(Object paramObject1, Object paramObject2, a<String, View> parama, boolean paramBoolean, d paramd)
  {
    if ((paramd.ah != null) && (!paramd.ah.isEmpty())) {
      if (!paramBoolean) {
        break label62;
      }
    }
    label62:
    for (paramd = (String)paramd.ai.get(0);; paramd = (String)paramd.ah.get(0))
    {
      parama = (View)parama.get(paramd);
      ah.a(paramObject1, parama);
      if (paramObject2 != null) {
        ah.a(paramObject2, parama);
      }
      return;
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
      if (paramCollection.contains(android.support.v4.view.r.q(localView))) {
        paramArrayList.add(localView);
      }
      i -= 1;
    }
  }
  
  private static a<String, View> b(a<String, String> parama, Object paramObject, ag paramag)
  {
    Object localObject = paramag.dR;
    View localView = ((Fragment)localObject).bo;
    if ((parama.isEmpty()) || (paramObject == null) || (localView == null))
    {
      parama.clear();
      return null;
    }
    a locala = new a();
    ah.a(locala, localView);
    paramObject = paramag.dT;
    if (paramag.dS)
    {
      paramag = ((Fragment)localObject).L();
      paramObject = paramObject.ah;
      if (paramObject != null) {
        locala.retainAll(paramObject);
      }
      if (paramag == null) {
        break label202;
      }
      i = paramObject.size() - 1;
      label96:
      if (i < 0) {
        break label242;
      }
      localObject = (String)paramObject.get(i);
      paramag = (View)locala.get(localObject);
      if (paramag != null) {
        break label163;
      }
      paramag = a(parama, (String)localObject);
      if (paramag != null) {
        parama.remove(paramag);
      }
    }
    for (;;)
    {
      i -= 1;
      break label96;
      paramag = ((Fragment)localObject).K();
      paramObject = paramObject.ai;
      break;
      label163:
      if (!((String)localObject).equals(android.support.v4.view.r.q(paramag)))
      {
        localObject = a(parama, (String)localObject);
        if (localObject != null) {
          parama.put(localObject, android.support.v4.view.r.q(paramag));
        }
      }
    }
    label202:
    int i = parama.size() - 1;
    while (i >= 0)
    {
      if (!locala.containsKey((String)parama.valueAt(i))) {
        parama.removeAt(i);
      }
      i -= 1;
    }
    label242:
    return locala;
  }
  
  private static void b(d paramd, SparseArray<ag> paramSparseArray, boolean paramBoolean)
  {
    if (!paramd.R.cz.onHasView()) {}
    for (;;)
    {
      return;
      int i = paramd.S.size() - 1;
      while (i >= 0)
      {
        a(paramd, (e)paramd.S.get(i), paramSparseArray, true, paramBoolean);
        i -= 1;
      }
    }
  }
  
  private static Object i(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject = null;
    if (paramFragment == null) {
      return null;
    }
    if (paramBoolean) {
      if (paramFragment.bv == null) {
        paramFragment = localObject;
      }
    }
    for (;;)
    {
      return ah.a(paramFragment);
      if (k.d(paramFragment.bv) == Fragment.aI)
      {
        paramFragment = paramFragment.y();
      }
      else
      {
        paramFragment = k.d(paramFragment.bv);
        continue;
        paramFragment = paramFragment.x();
      }
    }
  }
  
  private static Object j(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject = null;
    if (paramFragment == null) {
      return null;
    }
    if (paramBoolean) {
      if (paramFragment.bv == null) {
        paramFragment = localObject;
      }
    }
    for (;;)
    {
      return ah.a(paramFragment);
      if (k.b(paramFragment.bv) == Fragment.aI)
      {
        paramFragment = paramFragment.x();
      }
      else
      {
        paramFragment = k.b(paramFragment.bv);
        continue;
        paramFragment = paramFragment.y();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.af
 * JD-Core Version:    0.7.0.1
 */