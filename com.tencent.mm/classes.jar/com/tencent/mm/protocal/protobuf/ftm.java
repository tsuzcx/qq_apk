package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ftm
  extends esc
{
  public int NkN;
  public int NkO;
  public String ZhO;
  public String ZhP;
  public String abRE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152718);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152718);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.NkN);
      paramVarArgs.bS(3, this.NkO);
      if (this.abRE != null) {
        paramVarArgs.g(4, this.abRE);
      }
      if (this.ZhO != null) {
        paramVarArgs.g(5, this.ZhO);
      }
      if (this.ZhP != null) {
        paramVarArgs.g(6, this.ZhP);
      }
      AppMethodBeat.o(152718);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label600;
      }
    }
    label600:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.NkN) + i.a.a.b.b.a.cJ(3, this.NkO);
      paramInt = i;
      if (this.abRE != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abRE);
      }
      i = paramInt;
      if (this.ZhO != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ZhO);
      }
      paramInt = i;
      if (this.ZhP != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ZhP);
      }
      AppMethodBeat.o(152718);
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
          AppMethodBeat.o(152718);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152718);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ftm localftm = (ftm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152718);
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
            localftm.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(152718);
          return 0;
        case 2: 
          localftm.NkN = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(152718);
          return 0;
        case 3: 
          localftm.NkO = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(152718);
          return 0;
        case 4: 
          localftm.abRE = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152718);
          return 0;
        case 5: 
          localftm.ZhO = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152718);
          return 0;
        }
        localftm.ZhP = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(152718);
        return 0;
      }
      AppMethodBeat.o(152718);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ftm
 * JD-Core Version:    0.7.0.1
 */