package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cpu
  extends esc
{
  public String OQR;
  public int Zhu;
  public String aawp;
  public int block;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116455);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(116455);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.OQR != null) {
        paramVarArgs.g(2, this.OQR);
      }
      paramVarArgs.bS(3, this.block);
      if (this.aawp != null) {
        paramVarArgs.g(4, this.aawp);
      }
      paramVarArgs.bS(5, this.Zhu);
      AppMethodBeat.o(116455);
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
      int i = paramInt;
      if (this.OQR != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.OQR);
      }
      i += i.a.a.b.b.a.cJ(3, this.block);
      paramInt = i;
      if (this.aawp != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aawp);
      }
      i = i.a.a.b.b.a.cJ(5, this.Zhu);
      AppMethodBeat.o(116455);
      return paramInt + i;
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
          AppMethodBeat.o(116455);
          throw paramVarArgs;
        }
        AppMethodBeat.o(116455);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cpu localcpu = (cpu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116455);
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
            localcpu.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(116455);
          return 0;
        case 2: 
          localcpu.OQR = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(116455);
          return 0;
        case 3: 
          localcpu.block = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(116455);
          return 0;
        case 4: 
          localcpu.aawp = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(116455);
          return 0;
        }
        localcpu.Zhu = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(116455);
        return 0;
      }
      AppMethodBeat.o(116455);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpu
 * JD-Core Version:    0.7.0.1
 */