package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cut
  extends dyy
{
  public int TCx;
  public String Tkw;
  public String Tky;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117879);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Tkw == null)
      {
        paramVarArgs = new b("Not all required fields were included: Json");
        AppMethodBeat.o(117879);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Tkw != null) {
        paramVarArgs.f(2, this.Tkw);
      }
      paramVarArgs.aY(3, this.TCx);
      if (this.Tky != null) {
        paramVarArgs.f(4, this.Tky);
      }
      AppMethodBeat.o(117879);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label500;
      }
    }
    label500:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Tkw != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.Tkw);
      }
      i += g.a.a.b.b.a.bM(3, this.TCx);
      paramInt = i;
      if (this.Tky != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Tky);
      }
      AppMethodBeat.o(117879);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Tkw == null)
        {
          paramVarArgs = new b("Not all required fields were included: Json");
          AppMethodBeat.o(117879);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117879);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cut localcut = (cut)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117879);
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
            localcut.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(117879);
          return 0;
        case 2: 
          localcut.Tkw = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(117879);
          return 0;
        case 3: 
          localcut.TCx = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(117879);
          return 0;
        }
        localcut.Tky = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(117879);
        return 0;
      }
      AppMethodBeat.o(117879);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cut
 * JD-Core Version:    0.7.0.1
 */