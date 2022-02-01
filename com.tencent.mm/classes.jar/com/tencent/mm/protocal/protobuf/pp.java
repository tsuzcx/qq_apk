package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class pp
  extends esc
{
  public String ProductID;
  public LinkedList<String> YTe;
  
  public pp()
  {
    AppMethodBeat.i(124429);
    this.YTe = new LinkedList();
    AppMethodBeat.o(124429);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124430);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124430);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ProductID != null) {
        paramVarArgs.g(3, this.ProductID);
      }
      paramVarArgs.e(4, 1, this.YTe);
      AppMethodBeat.o(124430);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label456;
      }
    }
    label456:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ProductID != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ProductID);
      }
      paramInt = i.a.a.a.c(4, 1, this.YTe);
      AppMethodBeat.o(124430);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YTe.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(124430);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124430);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        pp localpp = (pp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        default: 
          AppMethodBeat.o(124430);
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
            localpp.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(124430);
          return 0;
        case 3: 
          localpp.ProductID = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124430);
          return 0;
        }
        localpp.YTe.add(((i.a.a.a.a)localObject).ajGk.readString());
        AppMethodBeat.o(124430);
        return 0;
      }
      AppMethodBeat.o(124430);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pp
 * JD-Core Version:    0.7.0.1
 */