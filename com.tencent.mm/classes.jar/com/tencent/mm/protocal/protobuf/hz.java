package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class hz
  extends com.tencent.mm.bw.a
{
  public ia KLV;
  public hx KLW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133148);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KLV == null)
      {
        paramVarArgs = new b("Not all required fields were included: RsaReqData");
        AppMethodBeat.o(133148);
        throw paramVarArgs;
      }
      if (this.KLW == null)
      {
        paramVarArgs = new b("Not all required fields were included: AesReqData");
        AppMethodBeat.o(133148);
        throw paramVarArgs;
      }
      if (this.KLV != null)
      {
        paramVarArgs.ni(1, this.KLV.computeSize());
        this.KLV.writeFields(paramVarArgs);
      }
      if (this.KLW != null)
      {
        paramVarArgs.ni(2, this.KLW.computeSize());
        this.KLW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133148);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KLV == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = g.a.a.a.nh(1, this.KLV.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KLW != null) {
        i = paramInt + g.a.a.a.nh(2, this.KLW.computeSize());
      }
      AppMethodBeat.o(133148);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.KLV == null)
        {
          paramVarArgs = new b("Not all required fields were included: RsaReqData");
          AppMethodBeat.o(133148);
          throw paramVarArgs;
        }
        if (this.KLW == null)
        {
          paramVarArgs = new b("Not all required fields were included: AesReqData");
          AppMethodBeat.o(133148);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133148);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        hz localhz = (hz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133148);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ia();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ia)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localhz.KLV = ((ia)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133148);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new hx();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((hx)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localhz.KLW = ((hx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133148);
        return 0;
      }
      AppMethodBeat.o(133148);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hz
 * JD-Core Version:    0.7.0.1
 */