package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cjx
  extends esc
{
  public String VHM;
  public int aasw;
  public String aasx;
  public String aasy;
  public String aasz;
  public String wuA;
  public int wuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258396);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(258396);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.wuz);
      if (this.wuA != null) {
        paramVarArgs.g(3, this.wuA);
      }
      paramVarArgs.bS(4, this.aasw);
      if (this.aasx != null) {
        paramVarArgs.g(5, this.aasx);
      }
      if (this.VHM != null) {
        paramVarArgs.g(6, this.VHM);
      }
      if (this.aasy != null) {
        paramVarArgs.g(7, this.aasy);
      }
      if (this.aasz != null) {
        paramVarArgs.g(8, this.aasz);
      }
      AppMethodBeat.o(258396);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label728;
      }
    }
    label728:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.aasw);
      paramInt = i;
      if (this.aasx != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aasx);
      }
      i = paramInt;
      if (this.VHM != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.VHM);
      }
      paramInt = i;
      if (this.aasy != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.aasy);
      }
      i = paramInt;
      if (this.aasz != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.aasz);
      }
      AppMethodBeat.o(258396);
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
          AppMethodBeat.o(258396);
          throw paramVarArgs;
        }
        AppMethodBeat.o(258396);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cjx localcjx = (cjx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258396);
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
            localcjx.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(258396);
          return 0;
        case 2: 
          localcjx.wuz = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258396);
          return 0;
        case 3: 
          localcjx.wuA = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258396);
          return 0;
        case 4: 
          localcjx.aasw = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258396);
          return 0;
        case 5: 
          localcjx.aasx = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258396);
          return 0;
        case 6: 
          localcjx.VHM = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258396);
          return 0;
        case 7: 
          localcjx.aasy = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258396);
          return 0;
        }
        localcjx.aasz = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258396);
        return 0;
      }
      AppMethodBeat.o(258396);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjx
 * JD-Core Version:    0.7.0.1
 */