package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class afb
  extends cvc
{
  public int FMu;
  public cha Gdi;
  public int Gdj;
  public int nEf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152536);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gdi == null)
      {
        paramVarArgs = new b("Not all required fields were included: Package");
        AppMethodBeat.o(152536);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Gdi != null)
      {
        paramVarArgs.lC(2, this.Gdi.computeSize());
        this.Gdi.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.FMu);
      paramVarArgs.aS(4, this.Gdj);
      paramVarArgs.aS(5, this.nEf);
      AppMethodBeat.o(152536);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Gdi != null) {
        i = paramInt + f.a.a.a.lB(2, this.Gdi.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(3, this.FMu);
      int j = f.a.a.b.b.a.bz(4, this.Gdj);
      int k = f.a.a.b.b.a.bz(5, this.nEf);
      AppMethodBeat.o(152536);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.Gdi == null)
        {
          paramVarArgs = new b("Not all required fields were included: Package");
          AppMethodBeat.o(152536);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152536);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        afb localafb = (afb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152536);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localafb.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152536);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cha();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cha)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localafb.Gdi = ((cha)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152536);
          return 0;
        case 3: 
          localafb.FMu = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152536);
          return 0;
        case 4: 
          localafb.Gdj = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152536);
          return 0;
        }
        localafb.nEf = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(152536);
        return 0;
      }
      AppMethodBeat.o(152536);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afb
 * JD-Core Version:    0.7.0.1
 */