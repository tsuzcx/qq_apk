package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cpg
  extends esc
{
  public int YYp;
  public int aavW;
  public int vgN;
  public LinkedList<dzx> vgO;
  public int vhJ;
  
  public cpg()
  {
    AppMethodBeat.i(152590);
    this.vgO = new LinkedList();
    AppMethodBeat.o(152590);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152591);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152591);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.vgN);
      paramVarArgs.e(3, 8, this.vgO);
      paramVarArgs.bS(4, this.YYp);
      paramVarArgs.bS(5, this.aavW);
      paramVarArgs.bS(6, this.vhJ);
      AppMethodBeat.o(152591);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label638;
      }
    }
    label638:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.vgN);
      int j = i.a.a.a.c(3, 8, this.vgO);
      int k = i.a.a.b.b.a.cJ(4, this.YYp);
      int m = i.a.a.b.b.a.cJ(5, this.aavW);
      int n = i.a.a.b.b.a.cJ(6, this.vhJ);
      AppMethodBeat.o(152591);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.vgO.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152591);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152591);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cpg localcpg = (cpg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152591);
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
            localcpg.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152591);
          return 0;
        case 2: 
          localcpg.vgN = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152591);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dzx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dzx)localObject2).parseFrom((byte[])localObject1);
            }
            localcpg.vgO.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152591);
          return 0;
        case 4: 
          localcpg.YYp = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152591);
          return 0;
        case 5: 
          localcpg.aavW = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152591);
          return 0;
        }
        localcpg.vhJ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(152591);
        return 0;
      }
      AppMethodBeat.o(152591);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpg
 * JD-Core Version:    0.7.0.1
 */