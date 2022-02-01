package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ciw
  extends com.tencent.mm.bx.a
{
  public bjt Een;
  public bjt Eeo;
  public String doh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72578);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.doh != null) {
        paramVarArgs.d(1, this.doh);
      }
      if (this.Een != null)
      {
        paramVarArgs.kX(2, this.Een.computeSize());
        this.Een.writeFields(paramVarArgs);
      }
      if (this.Eeo != null)
      {
        paramVarArgs.kX(3, this.Eeo.computeSize());
        this.Eeo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72578);
      return 0;
    }
    if (paramInt == 1) {
      if (this.doh == null) {
        break label526;
      }
    }
    label526:
    for (int i = f.a.a.b.b.a.e(1, this.doh) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Een != null) {
        paramInt = i + f.a.a.a.kW(2, this.Een.computeSize());
      }
      i = paramInt;
      if (this.Eeo != null) {
        i = paramInt + f.a.a.a.kW(3, this.Eeo.computeSize());
      }
      AppMethodBeat.o(72578);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72578);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ciw localciw = (ciw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72578);
          return -1;
        case 1: 
          localciw.doh = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72578);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bjt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bjt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localciw.Een = ((bjt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72578);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bjt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bjt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localciw.Eeo = ((bjt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72578);
        return 0;
      }
      AppMethodBeat.o(72578);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ciw
 * JD-Core Version:    0.7.0.1
 */