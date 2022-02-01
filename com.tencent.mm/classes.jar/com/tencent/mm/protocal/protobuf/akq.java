package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class akq
  extends dyl
{
  public int Cqs;
  public String RTS;
  public b SrO;
  public b Svz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124485);
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
      paramVarArgs.aY(3, this.Cqs);
      if (this.Svz != null) {
        paramVarArgs.c(4, this.Svz);
      }
      if (this.SrO != null) {
        paramVarArgs.c(5, this.SrO);
      }
      AppMethodBeat.o(124485);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label512;
      }
    }
    label512:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RTS != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.RTS);
      }
      i += g.a.a.b.b.a.bM(3, this.Cqs);
      paramInt = i;
      if (this.Svz != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.Svz);
      }
      i = paramInt;
      if (this.SrO != null) {
        i = paramInt + g.a.a.b.b.a.b(5, this.SrO);
      }
      AppMethodBeat.o(124485);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(124485);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        akq localakq = (akq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124485);
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
            localakq.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(124485);
          return 0;
        case 2: 
          localakq.RTS = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124485);
          return 0;
        case 3: 
          localakq.Cqs = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124485);
          return 0;
        case 4: 
          localakq.Svz = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(124485);
          return 0;
        }
        localakq.SrO = ((g.a.a.a.a)localObject).abFh.iUw();
        AppMethodBeat.o(124485);
        return 0;
      }
      AppMethodBeat.o(124485);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akq
 * JD-Core Version:    0.7.0.1
 */