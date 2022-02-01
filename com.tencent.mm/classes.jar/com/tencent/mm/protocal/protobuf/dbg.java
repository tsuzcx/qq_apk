package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class dbg
  extends dyy
{
  public b GdC;
  public String TIm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231822);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GdC != null) {
        paramVarArgs.c(2, this.GdC);
      }
      if (this.TIm != null) {
        paramVarArgs.f(3, this.TIm);
      }
      AppMethodBeat.o(231822);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label408;
      }
    }
    label408:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GdC != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.GdC);
      }
      i = paramInt;
      if (this.TIm != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TIm);
      }
      AppMethodBeat.o(231822);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(231822);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dbg localdbg = (dbg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(231822);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jh localjh = new jh();
            if ((localObject != null) && (localObject.length > 0)) {
              localjh.parseFrom((byte[])localObject);
            }
            localdbg.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(231822);
          return 0;
        case 2: 
          localdbg.GdC = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(231822);
          return 0;
        }
        localdbg.TIm = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(231822);
        return 0;
      }
      AppMethodBeat.o(231822);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbg
 * JD-Core Version:    0.7.0.1
 */