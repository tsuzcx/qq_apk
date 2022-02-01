package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cog
  extends esc
{
  public int YFu;
  public int aavt;
  public LinkedList<dwj> aavu;
  public String aavv;
  public int aavw;
  
  public cog()
  {
    AppMethodBeat.i(32254);
    this.aavu = new LinkedList();
    AppMethodBeat.o(32254);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32255);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32255);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.aavt);
      paramVarArgs.e(3, 8, this.aavu);
      if (this.aavv != null) {
        paramVarArgs.g(4, this.aavv);
      }
      paramVarArgs.bS(5, this.YFu);
      paramVarArgs.bS(6, this.aavw);
      AppMethodBeat.o(32255);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label662;
      }
    }
    label662:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.aavt) + i.a.a.a.c(3, 8, this.aavu);
      paramInt = i;
      if (this.aavv != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aavv);
      }
      i = i.a.a.b.b.a.cJ(5, this.YFu);
      int j = i.a.a.b.b.a.cJ(6, this.aavw);
      AppMethodBeat.o(32255);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aavu.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32255);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32255);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cog localcog = (cog)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32255);
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
            localcog.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32255);
          return 0;
        case 2: 
          localcog.aavt = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32255);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dwj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dwj)localObject2).parseFrom((byte[])localObject1);
            }
            localcog.aavu.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32255);
          return 0;
        case 4: 
          localcog.aavv = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32255);
          return 0;
        case 5: 
          localcog.YFu = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32255);
          return 0;
        }
        localcog.aavw = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(32255);
        return 0;
      }
      AppMethodBeat.o(32255);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cog
 * JD-Core Version:    0.7.0.1
 */