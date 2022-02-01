package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dek
  extends cqk
{
  public int FNX;
  public int FNY;
  public def FNl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118470);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(118470);
        throw paramVarArgs;
      }
      if (this.FNl == null)
      {
        paramVarArgs = new b("Not all required fields were included: StoryObject");
        AppMethodBeat.o(118470);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FNl != null)
      {
        paramVarArgs.ln(2, this.FNl.computeSize());
        this.FNl.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.FNX);
      paramVarArgs.aR(4, this.FNY);
      AppMethodBeat.o(118470);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FNl != null) {
        i = paramInt + f.a.a.a.lm(2, this.FNl.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(3, this.FNX);
      int j = f.a.a.b.b.a.bx(4, this.FNY);
      AppMethodBeat.o(118470);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(118470);
          throw paramVarArgs;
        }
        if (this.FNl == null)
        {
          paramVarArgs = new b("Not all required fields were included: StoryObject");
          AppMethodBeat.o(118470);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118470);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dek localdek = (dek)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118470);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdek.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118470);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new def();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((def)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdek.FNl = ((def)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118470);
          return 0;
        case 3: 
          localdek.FNX = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(118470);
          return 0;
        }
        localdek.FNY = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(118470);
        return 0;
      }
      AppMethodBeat.o(118470);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dek
 * JD-Core Version:    0.7.0.1
 */