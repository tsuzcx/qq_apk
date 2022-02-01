package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cja
  extends esc
{
  public gol YGV;
  public int aarw;
  public LinkedList<cix> aarx;
  
  public cja()
  {
    AppMethodBeat.i(104797);
    this.aarx = new LinkedList();
    AppMethodBeat.o(104797);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104798);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104798);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.aarw);
      paramVarArgs.e(3, 8, this.aarx);
      if (this.YGV != null)
      {
        paramVarArgs.qD(4, this.YGV.computeSize());
        this.YGV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(104798);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label628;
      }
    }
    label628:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.aarw) + i.a.a.a.c(3, 8, this.aarx);
      paramInt = i;
      if (this.YGV != null) {
        paramInt = i + i.a.a.a.qC(4, this.YGV.computeSize());
      }
      AppMethodBeat.o(104798);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aarx.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104798);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104798);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cja localcja = (cja)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104798);
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
            localcja.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104798);
          return 0;
        case 2: 
          localcja.aarw = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(104798);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cix();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cix)localObject2).parseFrom((byte[])localObject1);
            }
            localcja.aarx.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104798);
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
          localcja.YGV = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(104798);
        return 0;
      }
      AppMethodBeat.o(104798);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cja
 * JD-Core Version:    0.7.0.1
 */