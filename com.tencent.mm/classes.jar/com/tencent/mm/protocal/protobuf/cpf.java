package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cpf
  extends erp
{
  public int YFu;
  public int vgN;
  public LinkedList<dzx> vgO;
  public int vhJ;
  
  public cpf()
  {
    AppMethodBeat.i(152588);
    this.vgO = new LinkedList();
    AppMethodBeat.o(152588);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152589);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.vgN);
      paramVarArgs.e(3, 8, this.vgO);
      paramVarArgs.bS(4, this.vhJ);
      paramVarArgs.bS(5, this.YFu);
      AppMethodBeat.o(152589);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label542;
      }
    }
    label542:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.vgN);
      int j = i.a.a.a.c(3, 8, this.vgO);
      int k = i.a.a.b.b.a.cJ(4, this.vhJ);
      int m = i.a.a.b.b.a.cJ(5, this.YFu);
      AppMethodBeat.o(152589);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.vgO.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152589);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cpf localcpf = (cpf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152589);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localcpf.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152589);
          return 0;
        case 2: 
          localcpf.vgN = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152589);
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
            localcpf.vgO.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152589);
          return 0;
        case 4: 
          localcpf.vhJ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152589);
          return 0;
        }
        localcpf.YFu = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(152589);
        return 0;
      }
      AppMethodBeat.o(152589);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpf
 * JD-Core Version:    0.7.0.1
 */