package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class aky
  extends esc
{
  public int NkN;
  public int NkO;
  public int NkP;
  public gol NkQ;
  public String UserName;
  public String oOI;
  public String oOL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(9591);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(9591);
        throw paramVarArgs;
      }
      if (this.NkQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(9591);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.oOI != null) {
        paramVarArgs.g(2, this.oOI);
      }
      if (this.oOL != null) {
        paramVarArgs.g(3, this.oOL);
      }
      if (this.UserName != null) {
        paramVarArgs.g(4, this.UserName);
      }
      paramVarArgs.bS(5, this.NkN);
      paramVarArgs.bS(6, this.NkO);
      paramVarArgs.bS(7, this.NkP);
      if (this.NkQ != null)
      {
        paramVarArgs.qD(8, this.NkQ.computeSize());
        this.NkQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(9591);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label844;
      }
    }
    label844:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oOI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.oOI);
      }
      i = paramInt;
      if (this.oOL != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.oOL);
      }
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.UserName);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.NkN) + i.a.a.b.b.a.cJ(6, this.NkO) + i.a.a.b.b.a.cJ(7, this.NkP);
      paramInt = i;
      if (this.NkQ != null) {
        paramInt = i + i.a.a.a.qC(8, this.NkQ.computeSize());
      }
      AppMethodBeat.o(9591);
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
          AppMethodBeat.o(9591);
          throw paramVarArgs;
        }
        if (this.NkQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(9591);
          throw paramVarArgs;
        }
        AppMethodBeat.o(9591);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        aky localaky = (aky)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(9591);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localaky.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(9591);
          return 0;
        case 2: 
          localaky.oOI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(9591);
          return 0;
        case 3: 
          localaky.oOL = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(9591);
          return 0;
        case 4: 
          localaky.UserName = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(9591);
          return 0;
        case 5: 
          localaky.NkN = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(9591);
          return 0;
        case 6: 
          localaky.NkO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(9591);
          return 0;
        case 7: 
          localaky.NkP = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(9591);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gol();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gol)localObject2).dg((byte[])localObject1);
          }
          localaky.NkQ = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(9591);
        return 0;
      }
      AppMethodBeat.o(9591);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aky
 * JD-Core Version:    0.7.0.1
 */