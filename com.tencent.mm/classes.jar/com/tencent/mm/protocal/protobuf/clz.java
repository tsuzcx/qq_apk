package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class clz
  extends esc
{
  public int aaiK;
  public String aaiL;
  public String aaiM;
  public int aaiN;
  public String aaiO;
  public String aatR;
  public String aatS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91490);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91490);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aatR != null) {
        paramVarArgs.g(2, this.aatR);
      }
      paramVarArgs.bS(3, this.aaiK);
      if (this.aaiL != null) {
        paramVarArgs.g(4, this.aaiL);
      }
      if (this.aaiM != null) {
        paramVarArgs.g(5, this.aaiM);
      }
      paramVarArgs.bS(6, this.aaiN);
      if (this.aaiO != null) {
        paramVarArgs.g(7, this.aaiO);
      }
      if (this.aatS != null) {
        paramVarArgs.g(8, this.aatS);
      }
      AppMethodBeat.o(91490);
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
      int i = paramInt;
      if (this.aatR != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.aatR);
      }
      i += i.a.a.b.b.a.cJ(3, this.aaiK);
      paramInt = i;
      if (this.aaiL != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaiL);
      }
      i = paramInt;
      if (this.aaiM != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aaiM);
      }
      i += i.a.a.b.b.a.cJ(6, this.aaiN);
      paramInt = i;
      if (this.aaiO != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.aaiO);
      }
      i = paramInt;
      if (this.aatS != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.aatS);
      }
      AppMethodBeat.o(91490);
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
          AppMethodBeat.o(91490);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91490);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        clz localclz = (clz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91490);
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
            localclz.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(91490);
          return 0;
        case 2: 
          localclz.aatR = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91490);
          return 0;
        case 3: 
          localclz.aaiK = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91490);
          return 0;
        case 4: 
          localclz.aaiL = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91490);
          return 0;
        case 5: 
          localclz.aaiM = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91490);
          return 0;
        case 6: 
          localclz.aaiN = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91490);
          return 0;
        case 7: 
          localclz.aaiO = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91490);
          return 0;
        }
        localclz.aatS = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91490);
        return 0;
      }
      AppMethodBeat.o(91490);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clz
 * JD-Core Version:    0.7.0.1
 */