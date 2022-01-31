package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bec
  extends com.tencent.mm.bv.a
{
  public auh wvw;
  public aui wvx;
  public int xtR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28553);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wvw == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDevice");
        AppMethodBeat.o(28553);
        throw paramVarArgs;
      }
      if (this.wvx == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDeviceAttr");
        AppMethodBeat.o(28553);
        throw paramVarArgs;
      }
      if (this.wvw != null)
      {
        paramVarArgs.iQ(1, this.wvw.computeSize());
        this.wvw.writeFields(paramVarArgs);
      }
      if (this.wvx != null)
      {
        paramVarArgs.iQ(2, this.wvx.computeSize());
        this.wvx.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.xtR);
      AppMethodBeat.o(28553);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wvw == null) {
        break label619;
      }
    }
    label619:
    for (paramInt = e.a.a.a.iP(1, this.wvw.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wvx != null) {
        i = paramInt + e.a.a.a.iP(2, this.wvx.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(3, this.xtR);
      AppMethodBeat.o(28553);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wvw == null)
        {
          paramVarArgs = new b("Not all required fields were included: HardDevice");
          AppMethodBeat.o(28553);
          throw paramVarArgs;
        }
        if (this.wvx == null)
        {
          paramVarArgs = new b("Not all required fields were included: HardDeviceAttr");
          AppMethodBeat.o(28553);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28553);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bec localbec = (bec)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28553);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new auh();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((auh)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbec.wvw = ((auh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28553);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aui();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aui)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbec.wvx = ((aui)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28553);
          return 0;
        }
        localbec.xtR = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28553);
        return 0;
      }
      AppMethodBeat.o(28553);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bec
 * JD-Core Version:    0.7.0.1
 */