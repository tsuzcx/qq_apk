package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cki
  extends erp
{
  public String YIU;
  public String aasF;
  public String aasG;
  public tb aasH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114787);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aasF == null)
      {
        paramVarArgs = new b("Not all required fields were included: FunctionMsgID");
        AppMethodBeat.o(114787);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.aasF != null) {
        paramVarArgs.g(2, this.aasF);
      }
      if (this.aasG != null) {
        paramVarArgs.g(3, this.aasG);
      }
      if (this.YIU != null) {
        paramVarArgs.g(4, this.YIU);
      }
      if (this.aasH != null)
      {
        paramVarArgs.qD(5, this.aasH.computeSize());
        this.aasH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114787);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label646;
      }
    }
    label646:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aasF != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aasF);
      }
      i = paramInt;
      if (this.aasG != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aasG);
      }
      paramInt = i;
      if (this.YIU != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YIU);
      }
      i = paramInt;
      if (this.aasH != null) {
        i = paramInt + i.a.a.a.qC(5, this.aasH.computeSize());
      }
      AppMethodBeat.o(114787);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.aasF == null)
        {
          paramVarArgs = new b("Not all required fields were included: FunctionMsgID");
          AppMethodBeat.o(114787);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114787);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cki localcki = (cki)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114787);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localcki.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114787);
          return 0;
        case 2: 
          localcki.aasF = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(114787);
          return 0;
        case 3: 
          localcki.aasG = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(114787);
          return 0;
        case 4: 
          localcki.YIU = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(114787);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new tb();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((tb)localObject2).parseFrom((byte[])localObject1);
          }
          localcki.aasH = ((tb)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(114787);
        return 0;
      }
      AppMethodBeat.o(114787);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cki
 * JD-Core Version:    0.7.0.1
 */