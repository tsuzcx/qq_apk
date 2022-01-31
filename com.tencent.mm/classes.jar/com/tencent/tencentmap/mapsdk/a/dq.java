package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Set;

public final class dq
  extends Observable
  implements cj, co, cp
{
  private static dq a = null;
  private dk b = null;
  private dm c = null;
  private dm d = null;
  private boolean e = true;
  private boolean f = false;
  private Context g;
  private dx h;
  private boolean i;
  private int j = 0;
  private List<dj> k = null;
  private Object l = new Object();
  private g m = null;
  
  private dq(Context paramContext, dx paramdx, dr paramdr)
  {
    if (paramContext == null)
    {
      cy.c(" the context is null! init UserActionRecord failed!", new Object[0]);
      this.g = null;
      return;
    }
    Context localContext = paramContext.getApplicationContext();
    if (localContext != null) {}
    for (this.g = localContext;; this.g = paramContext)
    {
      if (c.m() == null) {
        c.a(this.g);
      }
      if (this.k == null) {
        this.k = Collections.synchronizedList(new ArrayList(5));
      }
      this.h = paramdx;
      if (paramdx != null) {
        paramdx.a(paramdr);
      }
      paramdr = ck.a(this.g);
      paramdr.a(this);
      paramdr.a(this);
      paramdr.a(this);
      paramdr.a(0, paramdx);
      paramdr.a(1, paramdx);
      this.b = new dk();
      this.c = new dg(paramContext);
      this.d = new dp(paramContext);
      this.e = true;
      new d().a(this.g);
      this.m = new g();
      return;
    }
  }
  
  public static dq a(Context paramContext, dx paramdx, dr paramdr)
  {
    try
    {
      if (a == null)
      {
        cy.e(" create ua instance ", new Object[0]);
        a = new dq(paramContext, paramdx, paramdr);
      }
      cy.e(" return ua instance ", new Object[0]);
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public static dx a(Context paramContext, boolean paramBoolean)
  {
    try
    {
      paramContext = dy.a(paramContext, paramBoolean);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  private void a(int paramInt)
  {
    try
    {
      this.j = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean a(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    cy.e(" onUA: %s,%b,%d,%d,%b,%b", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3) });
    dq localdq = d();
    if ((localdq != null) && (!localdq.m()))
    {
      localdq.k.add(new dj(paramString, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2));
      return true;
    }
    if (!i()) {
      return false;
    }
    if (localdq.b.a(paramString))
    {
      cy.c("onUserAction return false, because eventName:[%s] is not allowed in server strategy!", new Object[] { paramString });
      return false;
    }
    dm localdm;
    if ((!paramBoolean1) || ((paramBoolean1) && (localdq.b.b(paramString)))) {
      if (paramBoolean2) {
        localdm = localdq.k();
      }
    }
    while (localdm != null)
    {
      paramString = e.a(localdq.g, paramString, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean3);
      if (paramString == null)
      {
        cy.c("createdRecordBean bean is null, return false!", new Object[0]);
        return false;
        localdm = localdq.j();
      }
      else
      {
        return localdm.a(paramString);
        cy.c("onUserAction return false, because eventName:[%s] is sampled by svr rate!", new Object[] { paramString });
        return false;
      }
    }
    return false;
  }
  
  public static boolean a(boolean paramBoolean)
  {
    dq localdq = d();
    if (localdq == null) {
      cy.c(" ua module not ready!", new Object[0]);
    }
    while (!i()) {
      return false;
    }
    return localdq.b(paramBoolean);
  }
  
  private void c(boolean paramBoolean)
  {
    try
    {
      if (paramBoolean != e())
      {
        dm localdm = j();
        if (localdm != null) {
          localdm.a(paramBoolean);
        }
        localdm = k();
        if (localdm != null) {
          localdm.a(paramBoolean);
        }
        this.i = paramBoolean;
      }
      return;
    }
    finally {}
  }
  
  public static dq d()
  {
    try
    {
      dq localdq = a;
      return localdq;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static boolean i()
  {
    boolean bool1 = false;
    dq localdq = d();
    if (localdq == null) {
      cy.d("isModuleAble:not init ua", new Object[0]);
    }
    do
    {
      boolean bool2;
      do
      {
        return bool1;
        bool2 = localdq.e();
        bool1 = bool2;
      } while (!bool2);
      bool1 = bool2;
    } while (!localdq.l());
    return localdq.m();
  }
  
  private dm j()
  {
    try
    {
      dm localdm = this.c;
      return localdm;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private dm k()
  {
    try
    {
      dm localdm = this.d;
      return localdm;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean l()
  {
    try
    {
      boolean bool = this.e;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean m()
  {
    try
    {
      boolean bool = this.f;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void n()
  {
    try
    {
      this.f = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void o()
  {
    try
    {
      if ((this.k != null) && (this.k.size() > 0))
      {
        Iterator localIterator = this.k.iterator();
        while (localIterator.hasNext())
        {
          dj localdj = (dj)localIterator.next();
          a(localdj.a, localdj.b, localdj.c, localdj.d, localdj.e, localdj.f, false);
        }
        this.k.clear();
      }
    }
    finally {}
  }
  
  private void p()
  {
    try
    {
      if ((!e()) && (!this.b.f())) {
        return;
      }
      Object localObject = ck.a(this.g);
      if (localObject != null)
      {
        localObject = ((ck)localObject).e().b(1);
        if (localObject != null)
        {
          localObject = ((cm.a)localObject).b();
          if ((localObject != null) && (!"".equals(((String)localObject).trim())))
          {
            new dl(this.g).b();
            return;
          }
        }
      }
    }
    catch (Exception localException)
    {
      cy.c(" startHeart failed! " + localException.getMessage(), new Object[0]);
    }
  }
  
  private void q()
  {
    if (this.b.i()) {
      if (!"".equals(a.b(this.g, "LAUEVE_DENGTA", "")))
      {
        cy.a("AppLaunchedEvent has been uploaded!", new Object[0]);
        return;
      }
    }
    for (int n = 1;; n = 0)
    {
      if (e.a(this.g) == null)
      {
        cy.c(" DeviceInfo == null?,return", new Object[0]);
        return;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("A33", e.g(this.g));
      localHashMap.put("A63", "Y");
      if (a.b(this.g))
      {
        localHashMap.put("A21", "Y");
        label131:
        if (!ck.a(this.g).g()) {
          break label317;
        }
        localHashMap.put("A45", "Y");
        label158:
        if (!a.g(this.g)) {
          break label334;
        }
        localHashMap.put("A66", "F");
        label182:
        localHashMap.put("A68", a.h(this.g));
        if (!a.b) {
          break label351;
        }
      }
      label317:
      label334:
      label351:
      for (String str = "Y";; str = "N")
      {
        localHashMap.put("A85", str);
        localHashMap.put("A9", e.d());
        localHashMap.put("A14", e.e());
        boolean bool = a("rqd_applaunched", true, 0L, 0L, localHashMap, true, false);
        if ((n == 0) || (!bool)) {
          break;
        }
        a.a(this.g, "LAUEVE_DENGTA", e.g());
        return;
        localHashMap.put("A21", "N");
        break label131;
        localHashMap.put("A45", "N");
        break label158;
        localHashMap.put("A66", "B");
        break label182;
      }
    }
  }
  
  public final void a()
  {
    a(h() + 1);
  }
  
  public final void a(cm paramcm)
  {
    if (paramcm != null)
    {
      paramcm = paramcm.b(1);
      if (paramcm != null)
      {
        boolean bool = paramcm.a();
        if (e() != bool)
        {
          cy.f("UAR onCommonStrategyChange setUsable:%b ", new Object[] { Boolean.valueOf(bool) });
          c(bool);
        }
      }
    }
  }
  
  public final void a(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() > 0) && (this.b != null)) {
      this.b.a(paramMap);
    }
  }
  
  public final void b()
  {
    n();
    for (;;)
    {
      try
      {
        localObject = ck.a(this.g).e();
        if (localObject != null) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        Set localSet;
        cy.a(localThrowable);
        cy.d(" common query end error %s", new Object[] { localThrowable.toString() });
        continue;
        int n = -1;
        continue;
        n = 0;
        continue;
        cy.b("event module is disable", new Object[0]);
        continue;
        if (n <= 0) {
          continue;
        }
        n = 1;
        continue;
      }
      o();
      if (h() < 2)
      {
        localObject = dy.a(this.g);
        if ((((dy)localObject).a()) && (((dy)localObject).b()))
        {
          p();
          q();
          if (this.b.j())
          {
            this.m.setChanged();
            this.m.notifyObservers(this.g);
          }
        }
      }
      return;
      localObject = ((cm)localObject).b(1);
      if ((localObject != null) && (this.b != null))
      {
        localSet = ((cm.a)localObject).d();
        if ((localSet != null) && (localSet.size() > 0)) {
          this.b.a(localSet);
        }
        localSet = ((cm.a)localObject).f();
        if ((localSet != null) && (localSet.size() > 0)) {
          this.b.b(localSet);
        }
      }
      if ((!e()) || (localObject == null)) {
        continue;
      }
      if (!e()) {
        continue;
      }
      n = e.j(this.g);
      continue;
      if (n != 0)
      {
        cy.e(" asyn up module %d", new Object[] { Integer.valueOf(1) });
        b.a().a(new dq.1(this));
      }
    }
  }
  
  public final boolean b(boolean paramBoolean)
  {
    for (;;)
    {
      synchronized (this.l)
      {
        if (e())
        {
          n = e.j(this.g);
          if (n > 0) {
            try
            {
              if (this.h != null)
              {
                dh localdh = new dh(this.g);
                localdh.a(paramBoolean);
                this.h.a(localdh);
              }
              return true;
            }
            catch (Throwable localThrowable)
            {
              cy.c(" up common error: %s", new Object[] { localThrowable.toString() });
              cy.a(localThrowable);
            }
          }
          return false;
        }
      }
      int n = -1;
    }
  }
  
  public final void c()
  {
    Context localContext = this.g;
    cy.a(" RecordDAO.deleteRecords() start", new Object[0]);
    cy.e(" ua first clean :%d", new Object[] { Integer.valueOf(cg.a(localContext, new int[] { 1 })) });
    cy.e(" ua remove strategy :%d", new Object[] { Integer.valueOf(e.i(this.g)) });
  }
  
  public final boolean e()
  {
    try
    {
      boolean bool = this.i;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final dx f()
  {
    return this.h;
  }
  
  public final dk g()
  {
    return this.b;
  }
  
  public final int h()
  {
    try
    {
      int n = this.j;
      return n;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.dq
 * JD-Core Version:    0.7.0.1
 */