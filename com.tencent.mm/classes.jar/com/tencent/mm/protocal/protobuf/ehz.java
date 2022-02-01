package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ehz
  extends com.tencent.mm.bw.a
{
  public String HLO;
  public doi IlA;
  public boolean Ilg;
  public boolean Ili;
  public boolean Ilj;
  public String Ily;
  public deo Ilz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153317);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ily != null) {
        paramVarArgs.d(1, this.Ily);
      }
      if (this.HLO != null) {
        paramVarArgs.d(2, this.HLO);
      }
      if (this.Ilz != null)
      {
        paramVarArgs.lJ(3, this.Ilz.computeSize());
        this.Ilz.writeFields(paramVarArgs);
      }
      paramVarArgs.bC(4, this.Ilg);
      paramVarArgs.bC(5, this.Ili);
      if (this.IlA != null)
      {
        paramVarArgs.lJ(6, this.IlA.computeSize());
        this.IlA.writeFields(paramVarArgs);
      }
      paramVarArgs.bC(7, this.Ilj);
      AppMethodBeat.o(153317);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ily == null) {
        break label706;
      }
    }
    label706:
    for (int i = f.a.a.b.b.a.e(1, this.Ily) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HLO != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HLO);
      }
      i = paramInt;
      if (this.Ilz != null) {
        i = paramInt + f.a.a.a.lI(3, this.Ilz.computeSize());
      }
      i = i + f.a.a.b.b.a.amF(4) + f.a.a.b.b.a.amF(5);
      paramInt = i;
      if (this.IlA != null) {
        paramInt = i + f.a.a.a.lI(6, this.IlA.computeSize());
      }
      i = f.a.a.b.b.a.amF(7);
      AppMethodBeat.o(153317);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(153317);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ehz localehz = (ehz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153317);
          return -1;
        case 1: 
          localehz.Ily = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153317);
          return 0;
        case 2: 
          localehz.HLO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153317);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new deo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((deo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localehz.Ilz = ((deo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153317);
          return 0;
        case 4: 
          localehz.Ilg = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(153317);
          return 0;
        case 5: 
          localehz.Ili = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(153317);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new doi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((doi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localehz.IlA = ((doi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153317);
          return 0;
        }
        localehz.Ilj = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(153317);
        return 0;
      }
      AppMethodBeat.o(153317);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehz
 * JD-Core Version:    0.7.0.1
 */