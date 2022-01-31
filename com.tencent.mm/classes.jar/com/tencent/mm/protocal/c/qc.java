package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class qc
  extends blm
{
  public String kWm;
  public String kWn;
  public int ndf;
  public int ndm;
  public long ndp;
  public int pyo;
  public String sNM;
  public cds sNN;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.sNM != null) {
        paramVarArgs.d(2, this.sNM);
      }
      paramVarArgs.gB(3, this.ndf);
      paramVarArgs.gB(4, this.ndm);
      if (this.sNN != null)
      {
        paramVarArgs.gD(5, this.sNN.btq());
        this.sNN.a(paramVarArgs);
      }
      paramVarArgs.Y(6, this.ndp);
      paramVarArgs.gB(7, this.pyo);
      if (this.kWn != null) {
        paramVarArgs.d(8, this.kWn);
      }
      if (this.kWm != null) {
        paramVarArgs.d(9, this.kWm);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label743;
      }
    }
    label743:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sNM != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.sNM);
      }
      i = i + d.a.a.a.gy(3, this.ndf) + d.a.a.a.gy(4, this.ndm);
      paramInt = i;
      if (this.sNN != null) {
        paramInt = i + d.a.a.a.gA(5, this.sNN.btq());
      }
      i = paramInt + d.a.a.a.X(6, this.ndp) + d.a.a.a.gy(7, this.pyo);
      paramInt = i;
      if (this.kWn != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.kWn);
      }
      i = paramInt;
      if (this.kWm != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.kWm);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        qc localqc = (qc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
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
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localqc.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localqc.sNM = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localqc.ndf = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localqc.ndm = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cds();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cds)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localqc.sNN = ((cds)localObject1);
            paramInt += 1;
          }
        case 6: 
          localqc.ndp = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 7: 
          localqc.pyo = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localqc.kWn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localqc.kWm = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.qc
 * JD-Core Version:    0.7.0.1
 */