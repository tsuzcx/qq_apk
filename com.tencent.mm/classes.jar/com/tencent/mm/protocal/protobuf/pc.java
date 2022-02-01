package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class pc
  extends dyl
{
  public int CPw;
  public long RPv;
  public String RTS;
  public b RXn;
  public int RXp;
  public int RXq;
  public int RXr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124443);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RTS != null) {
        paramVarArgs.f(2, this.RTS);
      }
      paramVarArgs.aY(3, this.RXp);
      if (this.RXn != null) {
        paramVarArgs.c(4, this.RXn);
      }
      paramVarArgs.aY(5, this.RXq);
      paramVarArgs.bm(6, this.RPv);
      paramVarArgs.aY(7, this.RXr);
      paramVarArgs.aY(8, this.CPw);
      AppMethodBeat.o(124443);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label640;
      }
    }
    label640:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RTS != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.RTS);
      }
      i += g.a.a.b.b.a.bM(3, this.RXp);
      paramInt = i;
      if (this.RXn != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.RXn);
      }
      i = g.a.a.b.b.a.bM(5, this.RXq);
      int j = g.a.a.b.b.a.p(6, this.RPv);
      int k = g.a.a.b.b.a.bM(7, this.RXr);
      int m = g.a.a.b.b.a.bM(8, this.CPw);
      AppMethodBeat.o(124443);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(124443);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        pc localpc = (pc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124443);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localpc.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(124443);
          return 0;
        case 2: 
          localpc.RTS = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124443);
          return 0;
        case 3: 
          localpc.RXp = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124443);
          return 0;
        case 4: 
          localpc.RXn = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(124443);
          return 0;
        case 5: 
          localpc.RXq = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124443);
          return 0;
        case 6: 
          localpc.RPv = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(124443);
          return 0;
        case 7: 
          localpc.RXr = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124443);
          return 0;
        }
        localpc.CPw = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(124443);
        return 0;
      }
      AppMethodBeat.o(124443);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pc
 * JD-Core Version:    0.7.0.1
 */