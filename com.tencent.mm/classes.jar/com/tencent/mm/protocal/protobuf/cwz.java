package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cwz
  extends com.tencent.mm.bx.a
{
  public int Eox;
  public dlh Eoy;
  public int Epd;
  public int Epe;
  public int Epf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115855);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Eoy == null)
      {
        paramVarArgs = new b("Not all required fields were included: Addr");
        AppMethodBeat.o(115855);
        throw paramVarArgs;
      }
      if (this.Eoy != null)
      {
        paramVarArgs.kX(1, this.Eoy.computeSize());
        this.Eoy.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Eox);
      paramVarArgs.aR(3, this.Epd);
      paramVarArgs.aR(4, this.Epe);
      paramVarArgs.aR(5, this.Epf);
      AppMethodBeat.o(115855);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Eoy == null) {
        break label542;
      }
    }
    label542:
    for (paramInt = f.a.a.a.kW(1, this.Eoy.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.Eox);
      int j = f.a.a.b.b.a.bA(3, this.Epd);
      int k = f.a.a.b.b.a.bA(4, this.Epe);
      int m = f.a.a.b.b.a.bA(5, this.Epf);
      AppMethodBeat.o(115855);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Eoy == null)
        {
          paramVarArgs = new b("Not all required fields were included: Addr");
          AppMethodBeat.o(115855);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115855);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cwz localcwz = (cwz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115855);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dlh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dlh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcwz.Eoy = ((dlh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115855);
          return 0;
        case 2: 
          localcwz.Eox = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115855);
          return 0;
        case 3: 
          localcwz.Epd = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115855);
          return 0;
        case 4: 
          localcwz.Epe = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115855);
          return 0;
        }
        localcwz.Epf = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(115855);
        return 0;
      }
      AppMethodBeat.o(115855);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwz
 * JD-Core Version:    0.7.0.1
 */