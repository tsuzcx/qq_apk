package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class blu
  extends com.tencent.mm.bv.a
{
  public String kSC;
  public int ndo;
  public String sRE;
  public com.tencent.mm.bv.b sRj;
  public int tFr;
  public int tFs;
  public LinkedList<bsg> tFt = new LinkedList();
  public String tFu;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sRE == null) {
        throw new d.a.a.b("Not all required fields were included: MD5");
      }
      if (this.kSC == null) {
        throw new d.a.a.b("Not all required fields were included: Url");
      }
      if (this.tFu == null) {
        throw new d.a.a.b("Not all required fields were included: OriginalMD5");
      }
      if (this.sRE != null) {
        paramVarArgs.d(1, this.sRE);
      }
      paramVarArgs.gB(2, this.tFr);
      if (this.kSC != null) {
        paramVarArgs.d(3, this.kSC);
      }
      paramVarArgs.gB(4, this.tFs);
      paramVarArgs.d(5, 8, this.tFt);
      if (this.sRj != null) {
        paramVarArgs.b(6, this.sRj);
      }
      if (this.tFu != null) {
        paramVarArgs.d(7, this.tFu);
      }
      paramVarArgs.gB(8, this.ndo);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sRE == null) {
        break label695;
      }
    }
    label695:
    for (paramInt = d.a.a.b.b.a.e(1, this.sRE) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.tFr);
      paramInt = i;
      if (this.kSC != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.kSC);
      }
      i = paramInt + d.a.a.a.gy(4, this.tFs) + d.a.a.a.c(5, 8, this.tFt);
      paramInt = i;
      if (this.sRj != null) {
        paramInt = i + d.a.a.a.a(6, this.sRj);
      }
      i = paramInt;
      if (this.tFu != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.tFu);
      }
      return i + d.a.a.a.gy(8, this.ndo);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tFt.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.sRE == null) {
          throw new d.a.a.b("Not all required fields were included: MD5");
        }
        if (this.kSC == null) {
          throw new d.a.a.b("Not all required fields were included: Url");
        }
        if (this.tFu != null) {
          break;
        }
        throw new d.a.a.b("Not all required fields were included: OriginalMD5");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        blu localblu = (blu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localblu.sRE = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localblu.tFr = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localblu.kSC = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localblu.tFs = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bsg();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bsg)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localblu.tFt.add(localObject1);
            paramInt += 1;
          }
        case 6: 
          localblu.sRj = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        case 7: 
          localblu.tFu = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localblu.ndo = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.blu
 * JD-Core Version:    0.7.0.1
 */