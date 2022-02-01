package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class esa
  extends dop
{
  public String NoW;
  public esc Npm;
  public b Npr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(239537);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.NoW != null) {
        paramVarArgs.e(2, this.NoW);
      }
      if (this.Npr != null) {
        paramVarArgs.c(3, this.Npr);
      }
      if (this.Npm != null)
      {
        paramVarArgs.ni(4, this.Npm.computeSize());
        this.Npm.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(239537);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label586;
      }
    }
    label586:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.NoW != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.NoW);
      }
      i = paramInt;
      if (this.Npr != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.Npr);
      }
      paramInt = i;
      if (this.Npm != null) {
        paramInt = i + g.a.a.a.nh(4, this.Npm.computeSize());
      }
      AppMethodBeat.o(239537);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(239537);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        esa localesa = (esa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(239537);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localesa.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(239537);
          return 0;
        case 2: 
          localesa.NoW = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(239537);
          return 0;
        case 3: 
          localesa.Npr = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(239537);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new esc();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((esc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localesa.Npm = ((esc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(239537);
        return 0;
      }
      AppMethodBeat.o(239537);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.esa
 * JD-Core Version:    0.7.0.1
 */