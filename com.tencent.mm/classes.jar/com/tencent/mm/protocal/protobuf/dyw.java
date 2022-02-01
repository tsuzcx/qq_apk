package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class dyw
  extends erp
{
  public String abdB;
  public b abdC;
  public String appid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91565);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.appid != null) {
        paramVarArgs.g(2, this.appid);
      }
      if (this.abdB != null) {
        paramVarArgs.g(3, this.abdB);
      }
      if (this.abdC != null) {
        paramVarArgs.d(4, this.abdC);
      }
      AppMethodBeat.o(91565);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label464;
      }
    }
    label464:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.appid);
      }
      i = paramInt;
      if (this.abdB != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abdB);
      }
      paramInt = i;
      if (this.abdC != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.abdC);
      }
      AppMethodBeat.o(91565);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91565);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dyw localdyw = (dyw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91565);
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
            localdyw.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(91565);
          return 0;
        case 2: 
          localdyw.appid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91565);
          return 0;
        case 3: 
          localdyw.abdB = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91565);
          return 0;
        }
        localdyw.abdC = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(91565);
        return 0;
      }
      AppMethodBeat.o(91565);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyw
 * JD-Core Version:    0.7.0.1
 */