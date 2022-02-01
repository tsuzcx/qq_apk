package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cpm
  extends esc
{
  public LinkedList<ebr> aajI;
  public com.tencent.mm.bx.b aawh;
  public com.tencent.mm.bx.b aawi;
  
  public cpm()
  {
    AppMethodBeat.i(91500);
    this.aajI = new LinkedList();
    AppMethodBeat.o(91500);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91501);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91501);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.aajI);
      if (this.aawh != null) {
        paramVarArgs.d(3, this.aawh);
      }
      if (this.aawi != null) {
        paramVarArgs.d(4, this.aawi);
      }
      AppMethodBeat.o(91501);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label574;
      }
    }
    label574:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.aajI);
      paramInt = i;
      if (this.aawh != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.aawh);
      }
      i = paramInt;
      if (this.aawi != null) {
        i = paramInt + i.a.a.b.b.a.c(4, this.aawi);
      }
      AppMethodBeat.o(91501);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aajI.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91501);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91501);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cpm localcpm = (cpm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91501);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localcpm.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91501);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ebr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ebr)localObject2).parseFrom((byte[])localObject1);
            }
            localcpm.aajI.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91501);
          return 0;
        case 3: 
          localcpm.aawh = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(91501);
          return 0;
        }
        localcpm.aawi = ((i.a.a.a.a)localObject1).ajGk.kFX();
        AppMethodBeat.o(91501);
        return 0;
      }
      AppMethodBeat.o(91501);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpm
 * JD-Core Version:    0.7.0.1
 */