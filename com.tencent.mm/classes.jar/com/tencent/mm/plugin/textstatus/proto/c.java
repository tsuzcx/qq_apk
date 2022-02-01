package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.jh;
import java.util.LinkedList;

public final class c
  extends dyy
{
  public String MEL;
  public String MEN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(243589);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.MEN != null) {
        paramVarArgs.f(2, this.MEN);
      }
      if (this.MEL != null) {
        paramVarArgs.f(5, this.MEL);
      }
      AppMethodBeat.o(243589);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label416;
      }
    }
    label416:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MEN != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.MEN);
      }
      i = paramInt;
      if (this.MEL != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.MEL);
      }
      AppMethodBeat.o(243589);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(243589);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        c localc = (c)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 3: 
        case 4: 
        default: 
          AppMethodBeat.o(243589);
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
            localc.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(243589);
          return 0;
        case 2: 
          localc.MEN = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(243589);
          return 0;
        }
        localc.MEL = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(243589);
        return 0;
      }
      AppMethodBeat.o(243589);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.c
 * JD-Core Version:    0.7.0.1
 */