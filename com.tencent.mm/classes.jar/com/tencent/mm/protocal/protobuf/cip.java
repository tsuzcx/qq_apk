package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cip
  extends com.tencent.mm.cd.a
{
  public com.tencent.mm.cd.b Tps;
  public int Tpt;
  public LinkedList<cir> Tpu;
  public LinkedList<Integer> Tpv;
  
  public cip()
  {
    AppMethodBeat.i(115842);
    this.Tpu = new LinkedList();
    this.Tpv = new LinkedList();
    AppMethodBeat.o(115842);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115843);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Tps == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: RawBuf");
        AppMethodBeat.o(115843);
        throw paramVarArgs;
      }
      if (this.Tps != null) {
        paramVarArgs.c(1, this.Tps);
      }
      paramVarArgs.aY(2, this.Tpt);
      paramVarArgs.e(3, 8, this.Tpu);
      paramVarArgs.e(4, 2, this.Tpv);
      AppMethodBeat.o(115843);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Tps == null) {
        break label491;
      }
    }
    label491:
    for (paramInt = g.a.a.b.b.a.b(1, this.Tps) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.Tpt);
      int j = g.a.a.a.c(3, 8, this.Tpu);
      int k = g.a.a.a.c(4, 2, this.Tpv);
      AppMethodBeat.o(115843);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Tpu.clear();
        this.Tpv.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Tps == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: RawBuf");
          AppMethodBeat.o(115843);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115843);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cip localcip = (cip)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115843);
          return -1;
        case 1: 
          localcip.Tps = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(115843);
          return 0;
        case 2: 
          localcip.Tpt = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(115843);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            cir localcir = new cir();
            if ((localObject != null) && (localObject.length > 0)) {
              localcir.parseFrom((byte[])localObject);
            }
            localcip.Tpu.add(localcir);
            paramInt += 1;
          }
          AppMethodBeat.o(115843);
          return 0;
        }
        localcip.Tpv.add(Integer.valueOf(((g.a.a.a.a)localObject).abFh.AK()));
        AppMethodBeat.o(115843);
        return 0;
      }
      AppMethodBeat.o(115843);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cip
 * JD-Core Version:    0.7.0.1
 */