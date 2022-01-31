package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class aom
  extends com.tencent.mm.bv.a
{
  public com.tencent.mm.bv.b tkd;
  public int tke;
  public LinkedList<aoo> tkf = new LinkedList();
  public LinkedList<Integer> tkg = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tkd == null) {
        throw new d.a.a.b("Not all required fields were included: RawBuf");
      }
      if (this.tkd != null) {
        paramVarArgs.b(1, this.tkd);
      }
      paramVarArgs.gB(2, this.tke);
      paramVarArgs.d(3, 8, this.tkf);
      paramVarArgs.d(4, 2, this.tkg);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tkd == null) {
        break label434;
      }
    }
    label434:
    for (paramInt = d.a.a.a.a(1, this.tkd) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.tke) + d.a.a.a.c(3, 8, this.tkf) + d.a.a.a.c(4, 2, this.tkg);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tkf.clear();
        this.tkg.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tkd != null) {
          break;
        }
        throw new d.a.a.b("Not all required fields were included: RawBuf");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        aom localaom = (aom)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localaom.tkd = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        case 2: 
          localaom.tke = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          int i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aoo();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((aoo)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localaom.tkf.add(localObject1);
            paramInt += 1;
          }
        }
        localaom.tkg.add(Integer.valueOf(((d.a.a.a.a)localObject1).xpH.oD()));
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aom
 * JD-Core Version:    0.7.0.1
 */