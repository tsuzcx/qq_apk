package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cew
  extends esc
{
  public LinkedList<ji> aaoI;
  public agt aaoJ;
  public int ytv;
  public String ytw;
  
  public cew()
  {
    AppMethodBeat.i(91480);
    this.aaoI = new LinkedList();
    AppMethodBeat.o(91480);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91481);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91481);
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
      paramVarArgs.e(4, 8, this.aaoI);
      if (this.aaoJ != null)
      {
        paramVarArgs.qD(5, this.aaoJ.computeSize());
        this.aaoJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91481);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label688;
      }
    }
    label688:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.ytv);
      paramInt = i;
      if (this.ytw != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ytw);
      }
      i = paramInt + i.a.a.a.c(4, 8, this.aaoI);
      paramInt = i;
      if (this.aaoJ != null) {
        paramInt = i + i.a.a.a.qC(5, this.aaoJ.computeSize());
      }
      AppMethodBeat.o(91481);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaoI.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91481);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91481);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cew localcew = (cew)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91481);
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
            localcew.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91481);
          return 0;
        case 2: 
          localcew.ytv = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91481);
          return 0;
        case 3: 
          localcew.ytw = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91481);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ji();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ji)localObject2).parseFrom((byte[])localObject1);
            }
            localcew.aaoI.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91481);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new agt();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((agt)localObject2).parseFrom((byte[])localObject1);
          }
          localcew.aaoJ = ((agt)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91481);
        return 0;
      }
      AppMethodBeat.o(91481);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cew
 * JD-Core Version:    0.7.0.1
 */