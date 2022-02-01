package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class art
  extends dyy
{
  public FinderObject SFf;
  public String SFg;
  public aze SFh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(229611);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.SFf != null)
      {
        paramVarArgs.oE(2, this.SFf.computeSize());
        this.SFf.writeFields(paramVarArgs);
      }
      if (this.SFg != null) {
        paramVarArgs.f(3, this.SFg);
      }
      if (this.SFh != null)
      {
        paramVarArgs.oE(4, this.SFh.computeSize());
        this.SFh.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(229611);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label612;
      }
    }
    label612:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SFf != null) {
        paramInt = i + g.a.a.a.oD(2, this.SFf.computeSize());
      }
      i = paramInt;
      if (this.SFg != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SFg);
      }
      paramInt = i;
      if (this.SFh != null) {
        paramInt = i + g.a.a.a.oD(4, this.SFh.computeSize());
      }
      AppMethodBeat.o(229611);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(229611);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        art localart = (art)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(229611);
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
            localart.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229611);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localart.SFf = ((FinderObject)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229611);
          return 0;
        case 3: 
          localart.SFg = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(229611);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aze();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aze)localObject2).parseFrom((byte[])localObject1);
          }
          localart.SFh = ((aze)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(229611);
        return 0;
      }
      AppMethodBeat.o(229611);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.art
 * JD-Core Version:    0.7.0.1
 */