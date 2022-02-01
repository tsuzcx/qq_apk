package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dti
  extends com.tencent.mm.bx.a
{
  public dtf EIc;
  public String hnC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110859);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hnC == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(110859);
        throw paramVarArgs;
      }
      if (this.EIc == null)
      {
        paramVarArgs = new b("Not all required fields were included: PkgConfig");
        AppMethodBeat.o(110859);
        throw paramVarArgs;
      }
      if (this.hnC != null) {
        paramVarArgs.d(1, this.hnC);
      }
      if (this.EIc != null)
      {
        paramVarArgs.kX(2, this.EIc.computeSize());
        this.EIc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110859);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hnC == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = f.a.a.b.b.a.e(1, this.hnC) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EIc != null) {
        i = paramInt + f.a.a.a.kW(2, this.EIc.computeSize());
      }
      AppMethodBeat.o(110859);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.hnC == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppId");
          AppMethodBeat.o(110859);
          throw paramVarArgs;
        }
        if (this.EIc == null)
        {
          paramVarArgs = new b("Not all required fields were included: PkgConfig");
          AppMethodBeat.o(110859);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110859);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dti localdti = (dti)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110859);
          return -1;
        case 1: 
          localdti.hnC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(110859);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dtf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dtf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdti.EIc = ((dtf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110859);
        return 0;
      }
      AppMethodBeat.o(110859);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dti
 * JD-Core Version:    0.7.0.1
 */