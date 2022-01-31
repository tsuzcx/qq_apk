package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;
import android.transition.Transition.TransitionListener;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class ah
{
  public static Object a(Object paramObject)
  {
    Transition localTransition = null;
    if (paramObject != null) {
      localTransition = ((Transition)paramObject).clone();
    }
    return localTransition;
  }
  
  public static void a(View paramView, Rect paramRect)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    paramRect.set(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getWidth(), arrayOfInt[1] + paramView.getHeight());
  }
  
  public static void a(View paramView, final ArrayList<View> paramArrayList1, final ArrayList<View> paramArrayList2, final ArrayList<String> paramArrayList, Map<String, String> paramMap)
  {
    int k = paramArrayList2.size();
    final ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < k)
    {
      Object localObject = (View)paramArrayList1.get(i);
      String str = ((View)localObject).getTransitionName();
      localArrayList.add(str);
      int j;
      if (str != null)
      {
        ((View)localObject).setTransitionName(null);
        localObject = (String)paramMap.get(str);
        j = 0;
      }
      for (;;)
      {
        if (j < k)
        {
          if (((String)localObject).equals(paramArrayList.get(j))) {
            ((View)paramArrayList2.get(j)).setTransitionName(str);
          }
        }
        else
        {
          i += 1;
          break;
        }
        j += 1;
      }
    }
    bs.a(paramView, new Runnable()
    {
      public final void run()
      {
        int i = 0;
        while (i < this.dY)
        {
          ((View)paramArrayList2.get(i)).setTransitionName((String)paramArrayList.get(i));
          ((View)paramArrayList1.get(i)).setTransitionName((String)localArrayList.get(i));
          i += 1;
        }
      }
    });
  }
  
  public static void a(ViewGroup paramViewGroup, Object paramObject)
  {
    TransitionManager.beginDelayedTransition(paramViewGroup, (Transition)paramObject);
  }
  
  public static void a(Object paramObject, Rect paramRect)
  {
    if (paramObject != null) {
      ((Transition)paramObject).setEpicenterCallback(new Transition.EpicenterCallback()
      {
        public final Rect onGetEpicenter(Transition paramAnonymousTransition)
        {
          if ((ah.this == null) || (ah.this.isEmpty())) {
            return null;
          }
          return ah.this;
        }
      });
    }
  }
  
  public static void a(Object paramObject, View paramView)
  {
    if (paramView != null)
    {
      paramObject = (Transition)paramObject;
      Rect localRect = new Rect();
      a(paramView, localRect);
      paramObject.setEpicenterCallback(new Transition.EpicenterCallback()
      {
        public final Rect onGetEpicenter(Transition paramAnonymousTransition)
        {
          return ah.this;
        }
      });
    }
  }
  
  public static void a(Object paramObject, View paramView, ArrayList<View> paramArrayList)
  {
    paramObject = (TransitionSet)paramObject;
    List localList = paramObject.getTargets();
    localList.clear();
    int n = paramArrayList.size();
    int i = 0;
    while (i < n)
    {
      Object localObject = (View)paramArrayList.get(i);
      int m = localList.size();
      if (!a(localList, (View)localObject, m))
      {
        localList.add(localObject);
        int j = m;
        while (j < localList.size())
        {
          localObject = (View)localList.get(j);
          if ((localObject instanceof ViewGroup))
          {
            localObject = (ViewGroup)localObject;
            int i1 = ((ViewGroup)localObject).getChildCount();
            int k = 0;
            while (k < i1)
            {
              View localView = ((ViewGroup)localObject).getChildAt(k);
              if (!a(localList, localView, m)) {
                localList.add(localView);
              }
              k += 1;
            }
          }
          j += 1;
        }
      }
      i += 1;
    }
    localList.add(paramView);
    paramArrayList.add(paramView);
    a(paramObject, paramArrayList);
  }
  
  public static void a(Object paramObject1, Object paramObject2, final ArrayList<View> paramArrayList1, final Object paramObject3, final ArrayList<View> paramArrayList2, final Object paramObject4, final ArrayList<View> paramArrayList3)
  {
    ((Transition)paramObject1).addListener(new Transition.TransitionListener()
    {
      public final void onTransitionCancel(Transition paramAnonymousTransition) {}
      
      public final void onTransitionEnd(Transition paramAnonymousTransition) {}
      
      public final void onTransitionPause(Transition paramAnonymousTransition) {}
      
      public final void onTransitionResume(Transition paramAnonymousTransition) {}
      
      public final void onTransitionStart(Transition paramAnonymousTransition)
      {
        if (ah.this != null) {
          ah.b(ah.this, paramArrayList1, null);
        }
        if (paramObject3 != null) {
          ah.b(paramObject3, paramArrayList2, null);
        }
        if (paramObject4 != null) {
          ah.b(paramObject4, paramArrayList3, null);
        }
      }
    });
  }
  
  public static void a(Object paramObject, ArrayList<View> paramArrayList)
  {
    int i = 0;
    paramObject = (Transition)paramObject;
    if (paramObject == null) {}
    for (;;)
    {
      return;
      int j;
      if ((paramObject instanceof TransitionSet))
      {
        paramObject = (TransitionSet)paramObject;
        j = paramObject.getTransitionCount();
        while (i < j)
        {
          a(paramObject.getTransitionAt(i), paramArrayList);
          i += 1;
        }
      }
      else if ((!a(paramObject)) && (a(paramObject.getTargets())))
      {
        j = paramArrayList.size();
        i = 0;
        while (i < j)
        {
          paramObject.addTarget((View)paramArrayList.get(i));
          i += 1;
        }
      }
    }
  }
  
  public static void a(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2)
  {
    paramObject = (TransitionSet)paramObject;
    if (paramObject != null)
    {
      paramObject.getTargets().clear();
      paramObject.getTargets().addAll(paramArrayList2);
      b(paramObject, paramArrayList1, paramArrayList2);
    }
  }
  
  public static void a(ArrayList<View> paramArrayList, View paramView)
  {
    if (paramView.getVisibility() == 0)
    {
      if (!(paramView instanceof ViewGroup)) {
        break label61;
      }
      paramView = (ViewGroup)paramView;
      if (!paramView.isTransitionGroup()) {
        break label33;
      }
      paramArrayList.add(paramView);
    }
    for (;;)
    {
      return;
      label33:
      int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        a(paramArrayList, paramView.getChildAt(i));
        i += 1;
      }
    }
    label61:
    paramArrayList.add(paramView);
  }
  
  public static void a(Map<String, View> paramMap, View paramView)
  {
    if (paramView.getVisibility() == 0)
    {
      String str = paramView.getTransitionName();
      if (str != null) {
        paramMap.put(str, paramView);
      }
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int j = paramView.getChildCount();
        int i = 0;
        while (i < j)
        {
          a(paramMap, paramView.getChildAt(i));
          i += 1;
        }
      }
    }
  }
  
  private static boolean a(Transition paramTransition)
  {
    return (!a(paramTransition.getTargetIds())) || (!a(paramTransition.getTargetNames())) || (!a(paramTransition.getTargetTypes()));
  }
  
  private static boolean a(List paramList)
  {
    return (paramList == null) || (paramList.isEmpty());
  }
  
  private static boolean a(List<View> paramList, View paramView, int paramInt)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < paramInt)
      {
        if (paramList.get(i) == paramView) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static ArrayList<String> b(ArrayList<View> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)paramArrayList.get(i);
      localArrayList.add(localView.getTransitionName());
      localView.setTransitionName(null);
      i += 1;
    }
    return localArrayList;
  }
  
  public static void b(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2)
  {
    int i = 0;
    paramObject = (Transition)paramObject;
    int j;
    if ((paramObject instanceof TransitionSet))
    {
      paramObject = (TransitionSet)paramObject;
      j = paramObject.getTransitionCount();
      while (i < j)
      {
        b(paramObject.getTransitionAt(i), paramArrayList1, paramArrayList2);
        i += 1;
      }
    }
    if (!a(paramObject))
    {
      List localList = paramObject.getTargets();
      if ((localList != null) && (localList.size() == paramArrayList1.size()) && (localList.containsAll(paramArrayList1)))
      {
        if (paramArrayList2 == null) {}
        for (i = 0;; i = paramArrayList2.size())
        {
          j = 0;
          while (j < i)
          {
            paramObject.addTarget((View)paramArrayList2.get(j));
            j += 1;
          }
        }
        i = paramArrayList1.size() - 1;
        while (i >= 0)
        {
          paramObject.removeTarget((View)paramArrayList1.get(i));
          i -= 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.ah
 * JD-Core Version:    0.7.0.1
 */