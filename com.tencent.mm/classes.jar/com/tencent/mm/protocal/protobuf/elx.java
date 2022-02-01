package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class elx
  extends dop
{
  public String McL;
  public String rCp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32479);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.McL != null) {
        paramVarArgs.e(2, this.McL);
      }
      if (this.rCp != null) {
        paramVarArgs.e(3, this.rCp);
      }
      AppMethodBeat.o(32479);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label439;
      }
    }
    label439:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.McL != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.McL);
      }
      i = paramInt;
      if (this.rCp != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.rCp);
      }
      AppMethodBeat.o(32479);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32479);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        elx localelx = (elx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32479);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localelx.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32479);
          return 0;
        case 2: 
          localelx.McL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32479);
          return 0;
        }
        localelx.rCp = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32479);
        return 0;
      }
      AppMethodBeat.o(32479);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.elx
 * JD-Core Version:    0.7.0.1
 */