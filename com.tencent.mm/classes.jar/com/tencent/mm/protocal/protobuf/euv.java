package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class euv
  extends esc
{
  public String ZhF;
  public String abxD;
  public String abxE;
  public String abxF;
  public com.tencent.mm.bx.b abxG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82472);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82472);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ZhF != null) {
        paramVarArgs.g(3, this.ZhF);
      }
      if (this.abxD != null) {
        paramVarArgs.g(4, this.abxD);
      }
      if (this.abxE != null) {
        paramVarArgs.g(5, this.abxE);
      }
      if (this.abxF != null) {
        paramVarArgs.g(6, this.abxF);
      }
      if (this.abxG != null) {
        paramVarArgs.d(7, this.abxG);
      }
      AppMethodBeat.o(82472);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label640;
      }
    }
    label640:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZhF != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ZhF);
      }
      i = paramInt;
      if (this.abxD != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.abxD);
      }
      paramInt = i;
      if (this.abxE != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.abxE);
      }
      i = paramInt;
      if (this.abxF != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.abxF);
      }
      paramInt = i;
      if (this.abxG != null) {
        paramInt = i + i.a.a.b.b.a.c(7, this.abxG);
      }
      AppMethodBeat.o(82472);
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
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(82472);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82472);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        euv localeuv = (euv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        default: 
          AppMethodBeat.o(82472);
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
            localeuv.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(82472);
          return 0;
        case 3: 
          localeuv.ZhF = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82472);
          return 0;
        case 4: 
          localeuv.abxD = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82472);
          return 0;
        case 5: 
          localeuv.abxE = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82472);
          return 0;
        case 6: 
          localeuv.abxF = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82472);
          return 0;
        }
        localeuv.abxG = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(82472);
        return 0;
      }
      AppMethodBeat.o(82472);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.euv
 * JD-Core Version:    0.7.0.1
 */