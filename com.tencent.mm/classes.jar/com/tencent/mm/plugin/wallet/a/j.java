package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.bw.a
{
  public double CYE;
  public LinkedList<t> CYG;
  public double CYL;
  public double CYM;
  public int CYN;
  public String CYO;
  public String CYP;
  public b CYU;
  public String CYV;
  public double CYW;
  public LinkedList<f> CYX;
  
  public j()
  {
    AppMethodBeat.i(91296);
    this.CYX = new LinkedList();
    this.CYG = new LinkedList();
    AppMethodBeat.o(91296);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91297);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CYV != null) {
        paramVarArgs.d(1, this.CYV);
      }
      paramVarArgs.e(2, this.CYW);
      paramVarArgs.e(3, this.CYE);
      paramVarArgs.e(4, 8, this.CYX);
      paramVarArgs.e(5, 8, this.CYG);
      paramVarArgs.e(6, this.CYL);
      paramVarArgs.e(7, this.CYM);
      paramVarArgs.aS(8, this.CYN);
      if (this.CYO != null) {
        paramVarArgs.d(9, this.CYO);
      }
      if (this.CYP != null) {
        paramVarArgs.d(10, this.CYP);
      }
      if (this.CYU != null) {
        paramVarArgs.c(11, this.CYU);
      }
      AppMethodBeat.o(91297);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CYV == null) {
        break label894;
      }
    }
    label894:
    for (paramInt = f.a.a.b.b.a.e(1, this.CYV) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.amD(2) + f.a.a.b.b.a.amD(3) + f.a.a.a.c(4, 8, this.CYX) + f.a.a.a.c(5, 8, this.CYG) + f.a.a.b.b.a.amD(6) + f.a.a.b.b.a.amD(7) + f.a.a.b.b.a.bz(8, this.CYN);
      paramInt = i;
      if (this.CYO != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.CYO);
      }
      i = paramInt;
      if (this.CYP != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.CYP);
      }
      paramInt = i;
      if (this.CYU != null) {
        paramInt = i + f.a.a.b.b.a.b(11, this.CYU);
      }
      AppMethodBeat.o(91297);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CYX.clear();
        this.CYG.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91297);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        j localj = (j)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91297);
          return -1;
        case 1: 
          localj.CYV = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91297);
          return 0;
        case 2: 
          localj.CYW = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
          AppMethodBeat.o(91297);
          return 0;
        case 3: 
          localj.CYE = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
          AppMethodBeat.o(91297);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new f();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localj.CYX.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91297);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localj.CYG.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91297);
          return 0;
        case 6: 
          localj.CYL = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
          AppMethodBeat.o(91297);
          return 0;
        case 7: 
          localj.CYM = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
          AppMethodBeat.o(91297);
          return 0;
        case 8: 
          localj.CYN = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91297);
          return 0;
        case 9: 
          localj.CYO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91297);
          return 0;
        case 10: 
          localj.CYP = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91297);
          return 0;
        }
        localj.CYU = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(91297);
        return 0;
      }
      AppMethodBeat.o(91297);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.j
 * JD-Core Version:    0.7.0.1
 */