package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dc
  extends esc
{
  public String MRj;
  public LinkedList<dof> YFm;
  public int lyF;
  
  public dc()
  {
    AppMethodBeat.i(101792);
    this.YFm = new LinkedList();
    AppMethodBeat.o(101792);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101793);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(101793);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.lyF);
      paramVarArgs.e(3, 8, this.YFm);
      if (this.MRj != null) {
        paramVarArgs.g(4, this.MRj);
      }
      AppMethodBeat.o(101793);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.lyF) + i.a.a.a.c(3, 8, this.YFm);
      paramInt = i;
      if (this.MRj != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.MRj);
      }
      AppMethodBeat.o(101793);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YFm.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(101793);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101793);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dc localdc = (dc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101793);
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
            localdc.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101793);
          return 0;
        case 2: 
          localdc.lyF = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(101793);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dof();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dof)localObject2).parseFrom((byte[])localObject1);
            }
            localdc.YFm.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101793);
          return 0;
        }
        localdc.MRj = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(101793);
        return 0;
      }
      AppMethodBeat.o(101793);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dc
 * JD-Core Version:    0.7.0.1
 */