package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ezt
  extends erp
{
  public String YRQ;
  public int abAB;
  public int abAC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124553);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YRQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: brand_user_name");
        AppMethodBeat.o(124553);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YRQ != null) {
        paramVarArgs.g(2, this.YRQ);
      }
      paramVarArgs.bS(3, this.abAB);
      paramVarArgs.bS(4, this.abAC);
      AppMethodBeat.o(124553);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label484;
      }
    }
    label484:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YRQ != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.YRQ);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.abAB);
      int j = i.a.a.b.b.a.cJ(4, this.abAC);
      AppMethodBeat.o(124553);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YRQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: brand_user_name");
          AppMethodBeat.o(124553);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124553);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ezt localezt = (ezt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124553);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localezt.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(124553);
          return 0;
        case 2: 
          localezt.YRQ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124553);
          return 0;
        case 3: 
          localezt.abAB = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124553);
          return 0;
        }
        localezt.abAC = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(124553);
        return 0;
      }
      AppMethodBeat.o(124553);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezt
 * JD-Core Version:    0.7.0.1
 */