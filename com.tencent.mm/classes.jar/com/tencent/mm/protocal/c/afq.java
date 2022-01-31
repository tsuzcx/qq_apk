package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class afq
  extends bly
{
  public int ino;
  public String inp;
  public String person_id;
  public String sMC;
  public String tdA;
  public float tdB;
  public String tdC;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.ino);
      if (this.inp != null) {
        paramVarArgs.d(3, this.inp);
      }
      if (this.person_id != null) {
        paramVarArgs.d(4, this.person_id);
      }
      if (this.tdA != null) {
        paramVarArgs.d(5, this.tdA);
      }
      paramVarArgs.m(6, this.tdB);
      if (this.sMC != null) {
        paramVarArgs.d(7, this.sMC);
      }
      if (this.tdC != null) {
        paramVarArgs.d(8, this.tdC);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label662;
      }
    }
    label662:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.ino);
      paramInt = i;
      if (this.inp != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.inp);
      }
      i = paramInt;
      if (this.person_id != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.person_id);
      }
      paramInt = i;
      if (this.tdA != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.tdA);
      }
      i = paramInt + (d.a.a.b.b.a.dQ(6) + 4);
      paramInt = i;
      if (this.sMC != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.sMC);
      }
      i = paramInt;
      if (this.tdC != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.tdC);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx != null) {
          break;
        }
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        afq localafq = (afq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localafq.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localafq.ino = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localafq.inp = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localafq.person_id = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localafq.tdA = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localafq.tdB = ((d.a.a.a.a)localObject1).xpH.readFloat();
          return 0;
        case 7: 
          localafq.sMC = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localafq.tdC = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.afq
 * JD-Core Version:    0.7.0.1
 */