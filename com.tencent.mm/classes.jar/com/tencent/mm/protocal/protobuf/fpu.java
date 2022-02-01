package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fpu
  extends com.tencent.mm.cd.a
{
  public LinkedList<Integer> UAz;
  public String UNI;
  public int UNJ;
  public int UNK;
  public fpn UNq;
  
  public fpu()
  {
    AppMethodBeat.i(153345);
    this.UAz = new LinkedList();
    AppMethodBeat.o(153345);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153346);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UNq != null)
      {
        paramVarArgs.oE(1, this.UNq.computeSize());
        this.UNq.writeFields(paramVarArgs);
      }
      if (this.UNI != null) {
        paramVarArgs.f(2, this.UNI);
      }
      paramVarArgs.e(3, 2, this.UAz);
      paramVarArgs.aY(4, this.UNJ);
      paramVarArgs.aY(5, this.UNK);
      AppMethodBeat.o(153346);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UNq == null) {
        break label503;
      }
    }
    label503:
    for (paramInt = g.a.a.a.oD(1, this.UNq.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UNI != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.UNI);
      }
      paramInt = g.a.a.a.c(3, 2, this.UAz);
      int j = g.a.a.b.b.a.bM(4, this.UNJ);
      int k = g.a.a.b.b.a.bM(5, this.UNK);
      AppMethodBeat.o(153346);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UAz.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(153346);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fpu localfpu = (fpu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153346);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            fpn localfpn = new fpn();
            if ((localObject != null) && (localObject.length > 0)) {
              localfpn.parseFrom((byte[])localObject);
            }
            localfpu.UNq = localfpn;
            paramInt += 1;
          }
          AppMethodBeat.o(153346);
          return 0;
        case 2: 
          localfpu.UNI = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(153346);
          return 0;
        case 3: 
          localfpu.UAz.add(Integer.valueOf(((g.a.a.a.a)localObject).abFh.AK()));
          AppMethodBeat.o(153346);
          return 0;
        case 4: 
          localfpu.UNJ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(153346);
          return 0;
        }
        localfpu.UNK = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(153346);
        return 0;
      }
      AppMethodBeat.o(153346);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fpu
 * JD-Core Version:    0.7.0.1
 */