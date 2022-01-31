package com.tencent.mm.plugin.normsg.b;

import android.os.IInterface;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

final class b$b$1
  extends b.e
{
  b$b$1(b.b paramb, IInterface paramIInterface, Integer paramInteger, View paramView)
  {
    super(paramb.mHC, paramIInterface);
  }
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    Object localObject = paramMethod.getName();
    if (b.bpg().equals(localObject))
    {
      localObject = new ArrayList();
      if (paramArrayOfObject[0] != null) {
        ((List)localObject).add((AccessibilityNodeInfo)paramArrayOfObject[0]);
      }
      b.a(this.mHJ.mHC, this.mHH.intValue(), this.mHI, (List)localObject);
      if (((List)localObject).isEmpty()) {
        paramArrayOfObject[0] = null;
      }
    }
    for (;;)
    {
      return super.invoke(paramObject, paramMethod, paramArrayOfObject);
      paramArrayOfObject[0] = ((List)localObject).get(0);
      continue;
      if (b.bph().equals(localObject))
      {
        List localList = (List)paramArrayOfObject[0];
        localObject = localList;
        if (localList == null) {
          localObject = new ArrayList();
        }
        b.a(this.mHJ.mHC, this.mHH.intValue(), this.mHI, (List)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.b.b.1
 * JD-Core Version:    0.7.0.1
 */