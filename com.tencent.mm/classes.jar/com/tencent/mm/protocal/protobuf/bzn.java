package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bzn
  extends dyy
{
  public ew Tio;
  public az Tip;
  public LinkedList<fmp> Tiq;
  
  public bzn()
  {
    AppMethodBeat.i(152584);
    this.Tiq = new LinkedList();
    AppMethodBeat.o(152584);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152585);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Tio != null)
      {
        paramVarArgs.oE(2, this.Tio.computeSize());
        this.Tio.writeFields(paramVarArgs);
      }
      if (this.Tip != null)
      {
        paramVarArgs.oE(3, this.Tip.computeSize());
        this.Tip.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.Tiq);
      AppMethodBeat.o(152585);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label670;
      }
    }
    label670:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Tio != null) {
        paramInt = i + g.a.a.a.oD(2, this.Tio.computeSize());
      }
      i = paramInt;
      if (this.Tip != null) {
        i = paramInt + g.a.a.a.oD(3, this.Tip.computeSize());
      }
      paramInt = g.a.a.a.c(4, 8, this.Tiq);
      AppMethodBeat.o(152585);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Tiq.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152585);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bzn localbzn = (bzn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152585);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localbzn.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152585);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ew();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ew)localObject2).parseFrom((byte[])localObject1);
            }
            localbzn.Tio = ((ew)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152585);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new az();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((az)localObject2).parseFrom((byte[])localObject1);
            }
            localbzn.Tip = ((az)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152585);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fmp();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fmp)localObject2).parseFrom((byte[])localObject1);
          }
          localbzn.Tiq.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(152585);
        return 0;
      }
      AppMethodBeat.o(152585);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzn
 * JD-Core Version:    0.7.0.1
 */