package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class egi
  extends erp
{
  public int MFk;
  public LinkedList<etr> Zbf;
  public int ZvF;
  
  public egi()
  {
    AppMethodBeat.i(91626);
    this.Zbf = new LinkedList();
    AppMethodBeat.o(91626);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91627);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.MFk);
      paramVarArgs.e(3, 8, this.Zbf);
      paramVarArgs.bS(4, this.ZvF);
      AppMethodBeat.o(91627);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label498;
      }
    }
    label498:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.MFk);
      int j = i.a.a.a.c(3, 8, this.Zbf);
      int k = i.a.a.b.b.a.cJ(4, this.ZvF);
      AppMethodBeat.o(91627);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Zbf.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91627);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        egi localegi = (egi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91627);
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
            localegi.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91627);
          return 0;
        case 2: 
          localegi.MFk = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91627);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etr)localObject2).parseFrom((byte[])localObject1);
            }
            localegi.Zbf.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91627);
          return 0;
        }
        localegi.ZvF = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91627);
        return 0;
      }
      AppMethodBeat.o(91627);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egi
 * JD-Core Version:    0.7.0.1
 */