package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.bw.a
{
  public double HEA;
  public int HEB;
  public String HEC;
  public String HED;
  public b HEI;
  public String HEJ;
  public double HEK;
  public LinkedList<f> HEL;
  public double HEs;
  public LinkedList<t> HEu;
  public double HEz;
  
  public j()
  {
    AppMethodBeat.i(91296);
    this.HEL = new LinkedList();
    this.HEu = new LinkedList();
    AppMethodBeat.o(91296);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91297);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.HEJ != null) {
        paramVarArgs.e(1, this.HEJ);
      }
      paramVarArgs.e(2, this.HEK);
      paramVarArgs.e(3, this.HEs);
      paramVarArgs.e(4, 8, this.HEL);
      paramVarArgs.e(5, 8, this.HEu);
      paramVarArgs.e(6, this.HEz);
      paramVarArgs.e(7, this.HEA);
      paramVarArgs.aM(8, this.HEB);
      if (this.HEC != null) {
        paramVarArgs.e(9, this.HEC);
      }
      if (this.HED != null) {
        paramVarArgs.e(10, this.HED);
      }
      if (this.HEI != null) {
        paramVarArgs.c(11, this.HEI);
      }
      AppMethodBeat.o(91297);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HEJ == null) {
        break label906;
      }
    }
    label906:
    for (paramInt = g.a.a.b.b.a.f(1, this.HEJ) + 0;; paramInt = 0)
    {
      int i = paramInt + (g.a.a.b.b.a.fS(2) + 8) + (g.a.a.b.b.a.fS(3) + 8) + g.a.a.a.c(4, 8, this.HEL) + g.a.a.a.c(5, 8, this.HEu) + (g.a.a.b.b.a.fS(6) + 8) + (g.a.a.b.b.a.fS(7) + 8) + g.a.a.b.b.a.bu(8, this.HEB);
      paramInt = i;
      if (this.HEC != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.HEC);
      }
      i = paramInt;
      if (this.HED != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.HED);
      }
      paramInt = i;
      if (this.HEI != null) {
        paramInt = i + g.a.a.b.b.a.b(11, this.HEI);
      }
      AppMethodBeat.o(91297);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HEL.clear();
        this.HEu.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91297);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
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
          localj.HEJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91297);
          return 0;
        case 2: 
          localj.HEK = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
          AppMethodBeat.o(91297);
          return 0;
        case 3: 
          localj.HEs = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
          AppMethodBeat.o(91297);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new f();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localj.HEL.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91297);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localj.HEu.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91297);
          return 0;
        case 6: 
          localj.HEz = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
          AppMethodBeat.o(91297);
          return 0;
        case 7: 
          localj.HEA = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
          AppMethodBeat.o(91297);
          return 0;
        case 8: 
          localj.HEB = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91297);
          return 0;
        case 9: 
          localj.HEC = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91297);
          return 0;
        case 10: 
          localj.HED = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91297);
          return 0;
        }
        localj.HEI = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(91297);
        return 0;
      }
      AppMethodBeat.o(91297);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.j
 * JD-Core Version:    0.7.0.1
 */