package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ebm
  extends com.tencent.mm.bw.a
{
  public LinkedList<eaz> IgR;
  public ear Iha;
  public int Ihb;
  
  public ebm()
  {
    AppMethodBeat.i(147806);
    this.IgR = new LinkedList();
    AppMethodBeat.o(147806);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147807);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Iha == null)
      {
        paramVarArgs = new b("Not all required fields were included: base_request");
        AppMethodBeat.o(147807);
        throw paramVarArgs;
      }
      if (this.Iha != null)
      {
        paramVarArgs.lJ(1, this.Iha.computeSize());
        this.Iha.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.IgR);
      paramVarArgs.aS(3, this.Ihb);
      AppMethodBeat.o(147807);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Iha == null) {
        break label546;
      }
    }
    label546:
    for (paramInt = f.a.a.a.lI(1, this.Iha.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.IgR);
      int j = f.a.a.b.b.a.bz(3, this.Ihb);
      AppMethodBeat.o(147807);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.IgR.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.Iha == null)
        {
          paramVarArgs = new b("Not all required fields were included: base_request");
          AppMethodBeat.o(147807);
          throw paramVarArgs;
        }
        AppMethodBeat.o(147807);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ebm localebm = (ebm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147807);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ear();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ear)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localebm.Iha = ((ear)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147807);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eaz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eaz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localebm.IgR.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147807);
          return 0;
        }
        localebm.Ihb = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(147807);
        return 0;
      }
      AppMethodBeat.o(147807);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebm
 * JD-Core Version:    0.7.0.1
 */