package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fhs
  extends esc
{
  public int Njs;
  public long Njv;
  public int abIA;
  public LinkedList<zc> abIB;
  
  public fhs()
  {
    AppMethodBeat.i(152699);
    this.abIB = new LinkedList();
    AppMethodBeat.o(152699);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152700);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152700);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.Njs);
      paramVarArgs.bv(3, this.Njv);
      paramVarArgs.bS(4, this.abIA);
      paramVarArgs.e(5, 8, this.abIB);
      AppMethodBeat.o(152700);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label590;
      }
    }
    label590:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.Njs);
      int j = i.a.a.b.b.a.q(3, this.Njv);
      int k = i.a.a.b.b.a.cJ(4, this.abIA);
      int m = i.a.a.a.c(5, 8, this.abIB);
      AppMethodBeat.o(152700);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abIB.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152700);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152700);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fhs localfhs = (fhs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152700);
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
            localfhs.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152700);
          return 0;
        case 2: 
          localfhs.Njs = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152700);
          return 0;
        case 3: 
          localfhs.Njv = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(152700);
          return 0;
        case 4: 
          localfhs.abIA = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152700);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new zc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((zc)localObject2).parseFrom((byte[])localObject1);
          }
          localfhs.abIB.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(152700);
        return 0;
      }
      AppMethodBeat.o(152700);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fhs
 * JD-Core Version:    0.7.0.1
 */