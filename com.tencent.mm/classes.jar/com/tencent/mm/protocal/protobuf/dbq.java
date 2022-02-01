package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dbq
  extends com.tencent.mm.bw.a
{
  public fbl MGA;
  public fbe MGB;
  public fbi MGz;
  public String xJD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110851);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xJD == null)
      {
        paramVarArgs = new b("Not all required fields were included: PkgId");
        AppMethodBeat.o(110851);
        throw paramVarArgs;
      }
      if (this.xJD != null) {
        paramVarArgs.e(1, this.xJD);
      }
      if (this.MGz != null)
      {
        paramVarArgs.ni(2, this.MGz.computeSize());
        this.MGz.writeFields(paramVarArgs);
      }
      if (this.MGA != null)
      {
        paramVarArgs.ni(3, this.MGA.computeSize());
        this.MGA.writeFields(paramVarArgs);
      }
      if (this.MGB != null)
      {
        paramVarArgs.ni(4, this.MGB.computeSize());
        this.MGB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110851);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xJD == null) {
        break label726;
      }
    }
    label726:
    for (int i = g.a.a.b.b.a.f(1, this.xJD) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MGz != null) {
        paramInt = i + g.a.a.a.nh(2, this.MGz.computeSize());
      }
      i = paramInt;
      if (this.MGA != null) {
        i = paramInt + g.a.a.a.nh(3, this.MGA.computeSize());
      }
      paramInt = i;
      if (this.MGB != null) {
        paramInt = i + g.a.a.a.nh(4, this.MGB.computeSize());
      }
      AppMethodBeat.o(110851);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.xJD == null)
        {
          paramVarArgs = new b("Not all required fields were included: PkgId");
          AppMethodBeat.o(110851);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110851);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dbq localdbq = (dbq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110851);
          return -1;
        case 1: 
          localdbq.xJD = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(110851);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fbi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fbi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdbq.MGz = ((fbi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110851);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fbl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fbl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdbq.MGA = ((fbl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110851);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new fbe();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((fbe)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdbq.MGB = ((fbe)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110851);
        return 0;
      }
      AppMethodBeat.o(110851);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbq
 * JD-Core Version:    0.7.0.1
 */