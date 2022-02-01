package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class clf
  extends esc
{
  public String IcC;
  public String aati;
  public String aatj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32242);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32242);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aati != null) {
        paramVarArgs.g(2, this.aati);
      }
      if (this.aatj != null) {
        paramVarArgs.g(3, this.aatj);
      }
      if (this.IcC != null) {
        paramVarArgs.g(4, this.IcC);
      }
      AppMethodBeat.o(32242);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label526;
      }
    }
    label526:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aati != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aati);
      }
      i = paramInt;
      if (this.aatj != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aatj);
      }
      paramInt = i;
      if (this.IcC != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IcC);
      }
      AppMethodBeat.o(32242);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32242);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32242);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        clf localclf = (clf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32242);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kd localkd = new kd();
            if ((localObject != null) && (localObject.length > 0)) {
              localkd.parseFrom((byte[])localObject);
            }
            localclf.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(32242);
          return 0;
        case 2: 
          localclf.aati = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32242);
          return 0;
        case 3: 
          localclf.aatj = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32242);
          return 0;
        }
        localclf.IcC = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(32242);
        return 0;
      }
      AppMethodBeat.o(32242);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clf
 * JD-Core Version:    0.7.0.1
 */