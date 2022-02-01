package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bws
  extends com.tencent.mm.bw.a
{
  public LinkedList<ud> GOH;
  public String HjA;
  public boolean HjB;
  public ih HjC;
  public String HjD;
  public boolean HjE;
  public int HjF;
  public String HjG;
  public int HjH;
  public doa HjI;
  
  public bws()
  {
    AppMethodBeat.i(91533);
    this.GOH = new LinkedList();
    AppMethodBeat.o(91533);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91534);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HjA != null) {
        paramVarArgs.d(1, this.HjA);
      }
      paramVarArgs.e(2, 8, this.GOH);
      paramVarArgs.bC(3, this.HjB);
      if (this.HjC != null)
      {
        paramVarArgs.lJ(4, this.HjC.computeSize());
        this.HjC.writeFields(paramVarArgs);
      }
      if (this.HjD != null) {
        paramVarArgs.d(5, this.HjD);
      }
      paramVarArgs.bC(6, this.HjE);
      paramVarArgs.aS(7, this.HjF);
      if (this.HjG != null) {
        paramVarArgs.d(8, this.HjG);
      }
      paramVarArgs.aS(9, this.HjH);
      if (this.HjI != null)
      {
        paramVarArgs.lJ(10, this.HjI.computeSize());
        this.HjI.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91534);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HjA == null) {
        break label958;
      }
    }
    label958:
    for (paramInt = f.a.a.b.b.a.e(1, this.HjA) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.GOH) + f.a.a.b.b.a.amF(3);
      paramInt = i;
      if (this.HjC != null) {
        paramInt = i + f.a.a.a.lI(4, this.HjC.computeSize());
      }
      i = paramInt;
      if (this.HjD != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HjD);
      }
      i = i + f.a.a.b.b.a.amF(6) + f.a.a.b.b.a.bz(7, this.HjF);
      paramInt = i;
      if (this.HjG != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.HjG);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.HjH);
      paramInt = i;
      if (this.HjI != null) {
        paramInt = i + f.a.a.a.lI(10, this.HjI.computeSize());
      }
      AppMethodBeat.o(91534);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GOH.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91534);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bws localbws = (bws)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91534);
          return -1;
        case 1: 
          localbws.HjA = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91534);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ud();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ud)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbws.GOH.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91534);
          return 0;
        case 3: 
          localbws.HjB = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(91534);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ih();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ih)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbws.HjC = ((ih)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91534);
          return 0;
        case 5: 
          localbws.HjD = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91534);
          return 0;
        case 6: 
          localbws.HjE = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(91534);
          return 0;
        case 7: 
          localbws.HjF = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91534);
          return 0;
        case 8: 
          localbws.HjG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91534);
          return 0;
        case 9: 
          localbws.HjH = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91534);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new doa();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((doa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbws.HjI = ((doa)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91534);
        return 0;
      }
      AppMethodBeat.o(91534);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bws
 * JD-Core Version:    0.7.0.1
 */