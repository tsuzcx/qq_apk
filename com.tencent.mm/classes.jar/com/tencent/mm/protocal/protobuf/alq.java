package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class alq
  extends esc
{
  public boolean Kmt;
  public String ZsJ;
  public LinkedList<alr> ZsK;
  public LinkedList<String> ZsL;
  
  public alq()
  {
    AppMethodBeat.i(257899);
    this.ZsK = new LinkedList();
    this.ZsL = new LinkedList();
    AppMethodBeat.o(257899);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257904);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.ZsK);
      paramVarArgs.e(3, 1, this.ZsL);
      paramVarArgs.di(4, this.Kmt);
      if (this.ZsJ != null) {
        paramVarArgs.g(5, this.ZsJ);
      }
      AppMethodBeat.o(257904);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label558;
      }
    }
    label558:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.ZsK) + i.a.a.a.c(3, 1, this.ZsL) + (i.a.a.b.b.a.ko(4) + 1);
      paramInt = i;
      if (this.ZsJ != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ZsJ);
      }
      AppMethodBeat.o(257904);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZsK.clear();
        this.ZsL.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257904);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        alq localalq = (alq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257904);
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
            localalq.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257904);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new alr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((alr)localObject2).parseFrom((byte[])localObject1);
            }
            localalq.ZsK.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257904);
          return 0;
        case 3: 
          localalq.ZsL.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(257904);
          return 0;
        case 4: 
          localalq.Kmt = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(257904);
          return 0;
        }
        localalq.ZsJ = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(257904);
        return 0;
      }
      AppMethodBeat.o(257904);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alq
 * JD-Core Version:    0.7.0.1
 */