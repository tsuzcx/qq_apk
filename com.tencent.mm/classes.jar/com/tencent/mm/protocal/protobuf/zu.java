package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class zu
  extends dyy
{
  public LinkedList<String> Smc;
  public int Smd;
  
  public zu()
  {
    AppMethodBeat.i(152520);
    this.Smc = new LinkedList();
    AppMethodBeat.o(152520);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152521);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152521);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.Smc);
      paramVarArgs.aY(3, this.Smd);
      AppMethodBeat.o(152521);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label440;
      }
    }
    label440:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 1, this.Smc);
      int j = g.a.a.b.b.a.bM(3, this.Smd);
      AppMethodBeat.o(152521);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Smc.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152521);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152521);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        zu localzu = (zu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152521);
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
            localzu.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(152521);
          return 0;
        case 2: 
          localzu.Smc.add(((g.a.a.a.a)localObject).abFh.readString());
          AppMethodBeat.o(152521);
          return 0;
        }
        localzu.Smd = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(152521);
        return 0;
      }
      AppMethodBeat.o(152521);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zu
 * JD-Core Version:    0.7.0.1
 */