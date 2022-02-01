package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ftc
  extends esc
{
  public int NkN;
  public int NkO;
  public String aaWa;
  public String nUv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90778);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(90778);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.NkO);
      paramVarArgs.bS(3, this.NkN);
      if (this.nUv != null) {
        paramVarArgs.g(4, this.nUv);
      }
      if (this.aaWa != null) {
        paramVarArgs.g(5, this.aaWa);
      }
      AppMethodBeat.o(90778);
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
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.NkO) + i.a.a.b.b.a.cJ(3, this.NkN);
      paramInt = i;
      if (this.nUv != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.nUv);
      }
      i = paramInt;
      if (this.aaWa != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aaWa);
      }
      AppMethodBeat.o(90778);
      return i;
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
          AppMethodBeat.o(90778);
          throw paramVarArgs;
        }
        AppMethodBeat.o(90778);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ftc localftc = (ftc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(90778);
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
            localftc.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(90778);
          return 0;
        case 2: 
          localftc.NkO = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(90778);
          return 0;
        case 3: 
          localftc.NkN = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(90778);
          return 0;
        case 4: 
          localftc.nUv = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(90778);
          return 0;
        }
        localftc.aaWa = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(90778);
        return 0;
      }
      AppMethodBeat.o(90778);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ftc
 * JD-Core Version:    0.7.0.1
 */