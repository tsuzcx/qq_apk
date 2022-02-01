package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ecb
  extends esc
{
  public String IGI;
  public int abhx;
  public int ytv;
  public String ytw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91586);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91586);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.ytv);
      if (this.ytw != null) {
        paramVarArgs.g(3, this.ytw);
      }
      if (this.IGI != null) {
        paramVarArgs.g(4, this.IGI);
      }
      paramVarArgs.bS(5, this.abhx);
      AppMethodBeat.o(91586);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label540;
      }
    }
    label540:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.ytv);
      paramInt = i;
      if (this.ytw != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ytw);
      }
      i = paramInt;
      if (this.IGI != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.IGI);
      }
      paramInt = i.a.a.b.b.a.cJ(5, this.abhx);
      AppMethodBeat.o(91586);
      return i + paramInt;
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
          AppMethodBeat.o(91586);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91586);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ecb localecb = (ecb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91586);
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
            localecb.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(91586);
          return 0;
        case 2: 
          localecb.ytv = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91586);
          return 0;
        case 3: 
          localecb.ytw = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91586);
          return 0;
        case 4: 
          localecb.IGI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91586);
          return 0;
        }
        localecb.abhx = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(91586);
        return 0;
      }
      AppMethodBeat.o(91586);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecb
 * JD-Core Version:    0.7.0.1
 */