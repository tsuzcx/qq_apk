package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cfe
  extends esc
{
  public LinkedList<dax> aaoP;
  public int ytv;
  public String ytw;
  
  public cfe()
  {
    AppMethodBeat.i(82404);
    this.aaoP = new LinkedList();
    AppMethodBeat.o(82404);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82405);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82405);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.ytv);
      if (this.ytw != null) {
        paramVarArgs.g(3, this.ytw);
      }
      paramVarArgs.e(4, 8, this.aaoP);
      AppMethodBeat.o(82405);
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
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.ytv);
      paramInt = i;
      if (this.ytw != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ytw);
      }
      i = i.a.a.a.c(4, 8, this.aaoP);
      AppMethodBeat.o(82405);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaoP.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(82405);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82405);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cfe localcfe = (cfe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82405);
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
            localcfe.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(82405);
          return 0;
        case 2: 
          localcfe.ytv = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(82405);
          return 0;
        case 3: 
          localcfe.ytw = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(82405);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dax();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dax)localObject2).parseFrom((byte[])localObject1);
          }
          localcfe.aaoP.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(82405);
        return 0;
      }
      AppMethodBeat.o(82405);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfe
 * JD-Core Version:    0.7.0.1
 */