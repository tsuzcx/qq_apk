package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fic
  extends esc
{
  public gol abIR;
  public int abIS;
  public LinkedList<fia> abIT;
  public int abIU;
  
  public fic()
  {
    AppMethodBeat.i(118436);
    this.abIT = new LinkedList();
    AppMethodBeat.o(118436);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118437);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(118437);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.abIS);
      paramVarArgs.e(3, 8, this.abIT);
      paramVarArgs.bS(4, this.abIU);
      if (this.abIR != null)
      {
        paramVarArgs.qD(5, this.abIR.computeSize());
        this.abIR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(118437);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label668;
      }
    }
    label668:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.abIS) + i.a.a.a.c(3, 8, this.abIT) + i.a.a.b.b.a.cJ(4, this.abIU);
      paramInt = i;
      if (this.abIR != null) {
        paramInt = i + i.a.a.a.qC(5, this.abIR.computeSize());
      }
      AppMethodBeat.o(118437);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abIT.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(118437);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118437);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fic localfic = (fic)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118437);
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
            localfic.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(118437);
          return 0;
        case 2: 
          localfic.abIS = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(118437);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fia();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fia)localObject2).parseFrom((byte[])localObject1);
            }
            localfic.abIT.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(118437);
          return 0;
        case 4: 
          localfic.abIU = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(118437);
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
          localfic.abIR = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(118437);
        return 0;
      }
      AppMethodBeat.o(118437);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fic
 * JD-Core Version:    0.7.0.1
 */