package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class dw
{
  private Context a = null;
  
  public dw(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public final void a(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramInt != 101) {
      cy.c("com strategy unmatch key: %d", new Object[] { Integer.valueOf(paramInt) });
    }
    cm localcm;
    Object localObject1;
    int i;
    for (;;)
    {
      return;
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
      {
        localcm = ck.a(this.a).e();
        if (localcm == null)
        {
          cy.c("imposible! common strategy null!", new Object[0]);
          return;
        }
        try
        {
          localObject1 = new cw();
          ((cw)localObject1).a(new da(paramArrayOfByte));
          if (localcm == null)
          {
            i = 0;
            if (i == 0) {
              continue;
            }
            if (paramBoolean)
            {
              cy.e("update common strategy should save ", new Object[0]);
              localObject1 = this.a;
              if (paramArrayOfByte != null)
              {
                localObject2 = new cq();
                ((cq)localObject2).a(paramInt);
                ((cq)localObject2).a(paramArrayOfByte);
                e.a((Context)localObject1, (cq)localObject2);
              }
            }
            cy.e("com strategy changed notify! ", new Object[0]);
            paramArrayOfByte = ck.a(this.a);
            paramArrayOfByte.a(localcm);
            if (!paramBoolean) {
              continue;
            }
            paramArrayOfByte.b();
          }
        }
        catch (Throwable paramArrayOfByte)
        {
          cy.a(paramArrayOfByte);
          cy.d("error to common strategy!", new Object[0]);
          return;
        }
      }
    }
    int k = 0;
    if (!((cw)localObject1).c.equals(localcm.b()))
    {
      cy.b("strategy url changed to: %s", new Object[] { ((cw)localObject1).c });
      k = 1;
      localcm.a(((cw)localObject1).c);
    }
    if (((cw)localObject1).b != localcm.c())
    {
      cy.b("QueryPeriod changed to: %d", new Object[] { Integer.valueOf(((cw)localObject1).b) });
      k = 1;
      localcm.a(((cw)localObject1).b);
    }
    Object localObject2 = ((cw)localObject1).a;
    label306:
    Object localObject3;
    int m;
    label350:
    int j;
    label383:
    boolean bool;
    label454:
    label723:
    label759:
    int n;
    if (localcm == null)
    {
      i = 0;
      break label1142;
      localObject1 = ((cw)localObject1).d;
      if (localcm == null)
      {
        i = 0;
        break label1153;
      }
    }
    else
    {
      i = 0;
      if (localObject2 != null)
      {
        localObject3 = localcm.e();
        if (localObject3 == null) {
          break label1142;
        }
        m = 0;
        i = 0;
        j = i;
        if (m >= ((SparseArray)localObject3).size()) {
          break label1138;
        }
        cm.a locala = (cm.a)((SparseArray)localObject3).valueAt(m);
        Iterator localIterator = ((ArrayList)localObject2).iterator();
        if (!localIterator.hasNext()) {
          break label1177;
        }
        cx localcx = (cx)localIterator.next();
        j = i;
        if (localcx.a != locala.e()) {
          break label1164;
        }
        cy.a("server module strategy mid: %d", new Object[] { Byte.valueOf(localcx.a) });
        if (localcx.b != 1) {
          break label1171;
        }
        bool = true;
        if (locala.a() != bool)
        {
          cy.b("mid: %d , isUsable changed: %b ", new Object[] { Byte.valueOf(localcx.a), Boolean.valueOf(bool) });
          i = 1;
          locala.a(bool);
        }
        j = i;
        if (!locala.b().equals(localcx.c))
        {
          cy.b("mid: %d , url changed: %s", new Object[] { Byte.valueOf(localcx.a), localcx.c });
          j = 1;
          locala.a(localcx.c);
        }
        if (localcx.a != 1)
        {
          i = j;
          if (localcx.a != 2) {}
        }
        else
        {
          if ((locala.c() == null) || (localcx.d == null)) {
            break label836;
          }
          i = j;
          if (!locala.c().equals(localcx.d))
          {
            cy.b("mid: %d , detail changed...", new Object[] { Byte.valueOf(localcx.a) });
            i = 1;
            locala.a(localcx.d);
            ck.a(this.a).a(localcx.a, localcx.d);
          }
        }
        label676:
        j = i;
        if (localcx.a != 1) {
          break label1164;
        }
        if ((locala.d() != null) && (localcx.e != null))
        {
          if (!locala.d().equals(localcx.e))
          {
            cy.b("mid: %d , PreventEventCode changed...", new Object[] { Byte.valueOf(localcx.a) });
            i = 1;
            locala.a(e.a(localcx.e));
          }
          if ((locala.f() == null) || (localcx.f == null)) {
            break label935;
          }
          j = i;
          if (locala.f().equals(localcx.f)) {
            break label1164;
          }
        }
        for (;;)
        {
          cy.b("mid: %d , SampleEventSet changed...", new Object[] { Byte.valueOf(localcx.a) });
          j = 1;
          locala.b(e.a(localcx.f));
          break label1164;
          label836:
          i = j;
          if (localcx.d == null) {
            break label676;
          }
          i = j;
          if (locala.c() != null) {
            break label676;
          }
          cy.b("mid: %d , detail changed...", new Object[] { Byte.valueOf(localcx.a) });
          i = 1;
          locala.a(localcx.d);
          ck.a(this.a).a(localcx.a, localcx.d);
          break label676;
          if (locala.d() != null) {
            break label723;
          }
          if (localcx.e == null) {
            break label759;
          }
          break label723;
          label935:
          if (locala.f() == null) {
            if (localcx.f == null) {
              break;
            }
          }
        }
      }
      localObject2 = localcm.e();
      if (localObject2 == null) {
        break label1142;
      }
      n = ((SparseArray)localObject2).size();
      m = 0;
      i = 0;
    }
    for (;;)
    {
      j = i;
      if (m < n)
      {
        localObject3 = (cm.a)((SparseArray)localObject2).valueAt(m);
        if (!((cm.a)localObject3).a()) {
          break label1186;
        }
        cy.b("mid: %d , server not response strategy, sdk local close it!", new Object[] { Integer.valueOf(((cm.a)localObject3).e()) });
        i = 1;
        ((cm.a)localObject3).a(false);
        break label1186;
        k = 0;
        if ((localObject1 != null) && (localcm.d() != null))
        {
          i = k;
          if (!((Map)localObject1).equals(localcm.d()))
          {
            localcm.a((Map)localObject1);
            i = 1;
          }
        }
        else
        {
          i = k;
          if (localObject1 != null)
          {
            i = k;
            if (localcm.d() == null)
            {
              localcm.a((Map)localObject1);
              i = 1;
            }
          }
        }
      }
      label1138:
      label1142:
      while (i == 0)
      {
        i = j;
        break;
        do
        {
          j = k;
          break;
          i = j;
        } while (i == 0);
        j = 1;
        break label306;
      }
      label1153:
      i = 1;
      break;
      label1164:
      i = j;
      break label383;
      label1171:
      bool = false;
      break label454;
      label1177:
      m += 1;
      break label350;
      label1186:
      m += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.dw
 * JD-Core Version:    0.7.0.1
 */