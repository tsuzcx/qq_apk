package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cwo
  extends esc
{
  public LinkedList<gij> aaBG;
  public String aaBH;
  public int aaBI;
  public int aaBJ;
  public gih aaBK;
  
  public cwo()
  {
    AppMethodBeat.i(260034);
    this.aaBG = new LinkedList();
    AppMethodBeat.o(260034);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260041);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(260041);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.aaBG);
      if (this.aaBH != null) {
        paramVarArgs.g(3, this.aaBH);
      }
      paramVarArgs.bS(4, this.aaBI);
      paramVarArgs.bS(5, this.aaBJ);
      if (this.aaBK != null)
      {
        paramVarArgs.qD(6, this.aaBK.computeSize());
        this.aaBK.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(260041);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label732;
      }
    }
    label732:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.aaBG);
      paramInt = i;
      if (this.aaBH != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.aaBH);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.aaBI) + i.a.a.b.b.a.cJ(5, this.aaBJ);
      paramInt = i;
      if (this.aaBK != null) {
        paramInt = i + i.a.a.a.qC(6, this.aaBK.computeSize());
      }
      AppMethodBeat.o(260041);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaBG.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(260041);
          throw paramVarArgs;
        }
        AppMethodBeat.o(260041);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cwo localcwo = (cwo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260041);
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
            localcwo.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260041);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gij();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gij)localObject2).parseFrom((byte[])localObject1);
            }
            localcwo.aaBG.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260041);
          return 0;
        case 3: 
          localcwo.aaBH = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260041);
          return 0;
        case 4: 
          localcwo.aaBI = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(260041);
          return 0;
        case 5: 
          localcwo.aaBJ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(260041);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gih();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gih)localObject2).parseFrom((byte[])localObject1);
          }
          localcwo.aaBK = ((gih)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(260041);
        return 0;
      }
      AppMethodBeat.o(260041);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwo
 * JD-Core Version:    0.7.0.1
 */