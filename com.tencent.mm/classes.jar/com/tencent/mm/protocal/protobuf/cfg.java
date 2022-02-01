package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cfg
  extends esc
{
  public dbb aaoS;
  public String aaoT;
  public daw aaoU;
  public int result;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82408);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82408);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aaoS != null)
      {
        paramVarArgs.qD(2, this.aaoS.computeSize());
        this.aaoS.writeFields(paramVarArgs);
      }
      if (this.aaoT != null) {
        paramVarArgs.g(3, this.aaoT);
      }
      if (this.aaoU != null)
      {
        paramVarArgs.qD(4, this.aaoU.computeSize());
        this.aaoU.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.result);
      AppMethodBeat.o(82408);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label700;
      }
    }
    label700:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaoS != null) {
        paramInt = i + i.a.a.a.qC(2, this.aaoS.computeSize());
      }
      i = paramInt;
      if (this.aaoT != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaoT);
      }
      paramInt = i;
      if (this.aaoU != null) {
        paramInt = i + i.a.a.a.qC(4, this.aaoU.computeSize());
      }
      i = i.a.a.b.b.a.cJ(5, this.result);
      AppMethodBeat.o(82408);
      return paramInt + i;
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
          AppMethodBeat.o(82408);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82408);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cfg localcfg = (cfg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82408);
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
            localcfg.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(82408);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dbb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dbb)localObject2).parseFrom((byte[])localObject1);
            }
            localcfg.aaoS = ((dbb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(82408);
          return 0;
        case 3: 
          localcfg.aaoT = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(82408);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new daw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((daw)localObject2).parseFrom((byte[])localObject1);
            }
            localcfg.aaoU = ((daw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(82408);
          return 0;
        }
        localcfg.result = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(82408);
        return 0;
      }
      AppMethodBeat.o(82408);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfg
 * JD-Core Version:    0.7.0.1
 */