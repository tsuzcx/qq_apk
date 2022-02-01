package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class eoz
  extends erp
{
  public int abtf;
  public fzf abtg;
  public int abth;
  public int vhI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32412);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abtg == null)
      {
        paramVarArgs = new b("Not all required fields were included: PieceData");
        AppMethodBeat.o(32412);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.vhI);
      paramVarArgs.bS(3, this.abtf);
      if (this.abtg != null)
      {
        paramVarArgs.qD(4, this.abtg.computeSize());
        this.abtg.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.abth);
      AppMethodBeat.o(32412);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label609;
      }
    }
    label609:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.vhI) + i.a.a.b.b.a.cJ(3, this.abtf);
      paramInt = i;
      if (this.abtg != null) {
        paramInt = i + i.a.a.a.qC(4, this.abtg.computeSize());
      }
      i = i.a.a.b.b.a.cJ(5, this.abth);
      AppMethodBeat.o(32412);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.abtg == null)
        {
          paramVarArgs = new b("Not all required fields were included: PieceData");
          AppMethodBeat.o(32412);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32412);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        eoz localeoz = (eoz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32412);
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
            localeoz.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32412);
          return 0;
        case 2: 
          localeoz.vhI = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32412);
          return 0;
        case 3: 
          localeoz.abtf = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32412);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fzf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fzf)localObject2).parseFrom((byte[])localObject1);
            }
            localeoz.abtg = ((fzf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32412);
          return 0;
        }
        localeoz.abth = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(32412);
        return 0;
      }
      AppMethodBeat.o(32412);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eoz
 * JD-Core Version:    0.7.0.1
 */