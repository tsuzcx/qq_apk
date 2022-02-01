package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class abu
  extends esc
{
  public LinkedList<String> Zkp;
  public int Zkq;
  
  public abu()
  {
    AppMethodBeat.i(152520);
    this.Zkp = new LinkedList();
    AppMethodBeat.o(152520);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152521);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152521);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.Zkp);
      paramVarArgs.bS(3, this.Zkq);
      AppMethodBeat.o(152521);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label440;
      }
    }
    label440:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 1, this.Zkp);
      int j = i.a.a.b.b.a.cJ(3, this.Zkq);
      AppMethodBeat.o(152521);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Zkp.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152521);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152521);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        abu localabu = (abu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152521);
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
            localabu.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(152521);
          return 0;
        case 2: 
          localabu.Zkp.add(((i.a.a.a.a)localObject).ajGk.readString());
          AppMethodBeat.o(152521);
          return 0;
        }
        localabu.Zkq = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(152521);
        return 0;
      }
      AppMethodBeat.o(152521);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abu
 * JD-Core Version:    0.7.0.1
 */