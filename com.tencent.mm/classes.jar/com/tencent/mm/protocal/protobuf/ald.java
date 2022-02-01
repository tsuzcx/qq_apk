package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ald
  extends dyl
{
  public int CPw;
  public String SvI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56245);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.SvI != null) {
        paramVarArgs.f(2, this.SvI);
      }
      paramVarArgs.aY(3, this.CPw);
      AppMethodBeat.o(56245);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label392;
      }
    }
    label392:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SvI != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.SvI);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.CPw);
      AppMethodBeat.o(56245);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(56245);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ald localald = (ald)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56245);
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
            localald.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(56245);
          return 0;
        case 2: 
          localald.SvI = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(56245);
          return 0;
        }
        localald.CPw = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(56245);
        return 0;
      }
      AppMethodBeat.o(56245);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ald
 * JD-Core Version:    0.7.0.1
 */