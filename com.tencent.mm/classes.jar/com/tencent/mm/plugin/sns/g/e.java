package com.tencent.mm.plugin.sns.g;

import com.tencent.mm.protocal.c.bsy;
import d.a.a.b;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bv.a
{
  public bsy opL;
  public String owY;
  public int owZ;
  public String oxa;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.owY == null) {
        throw new b("Not all required fields were included: clientID");
      }
      if (this.opL == null) {
        throw new b("Not all required fields were included: actionGroup");
      }
      if (this.owY != null) {
        paramVarArgs.d(1, this.owY);
      }
      if (this.opL != null)
      {
        paramVarArgs.gD(2, this.opL.btq());
        this.opL.a(paramVarArgs);
      }
      paramVarArgs.gB(3, this.owZ);
      if (this.oxa != null) {
        paramVarArgs.d(4, this.oxa);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.owY == null) {
        break label490;
      }
    }
    label490:
    for (paramInt = d.a.a.b.b.a.e(1, this.owY) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.opL != null) {
        i = paramInt + d.a.a.a.gA(2, this.opL.btq());
      }
      i += d.a.a.a.gy(3, this.owZ);
      paramInt = i;
      if (this.oxa != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.oxa);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.owY == null) {
          throw new b("Not all required fields were included: clientID");
        }
        if (this.opL != null) {
          break;
        }
        throw new b("Not all required fields were included: actionGroup");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        e locale = (e)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          locale.owY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bsy();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bsy)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            locale.opL = ((bsy)localObject1);
            paramInt += 1;
          }
        case 3: 
          locale.owZ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        locale.oxa = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.g.e
 * JD-Core Version:    0.7.0.1
 */