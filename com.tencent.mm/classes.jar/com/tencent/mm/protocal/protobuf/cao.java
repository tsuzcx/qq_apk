package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cao
  extends dyl
{
  public String TiR;
  public String TiS;
  public int rWt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91504);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.TiR != null) {
        paramVarArgs.f(2, this.TiR);
      }
      paramVarArgs.aY(3, this.rWt);
      if (this.TiS != null) {
        paramVarArgs.f(4, this.TiS);
      }
      AppMethodBeat.o(91504);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label452;
      }
    }
    label452:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TiR != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.TiR);
      }
      i += g.a.a.b.b.a.bM(3, this.rWt);
      paramInt = i;
      if (this.TiS != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TiS);
      }
      AppMethodBeat.o(91504);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91504);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cao localcao = (cao)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91504);
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
            localcao.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(91504);
          return 0;
        case 2: 
          localcao.TiR = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91504);
          return 0;
        case 3: 
          localcao.rWt = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91504);
          return 0;
        }
        localcao.TiS = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91504);
        return 0;
      }
      AppMethodBeat.o(91504);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cao
 * JD-Core Version:    0.7.0.1
 */