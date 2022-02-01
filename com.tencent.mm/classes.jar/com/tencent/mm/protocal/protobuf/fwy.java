package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fwy
  extends erp
{
  public String YOu;
  public fzf abUN;
  public int abtf;
  public int abth;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32494);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abUN == null)
      {
        paramVarArgs = new b("Not all required fields were included: Piece");
        AppMethodBeat.o(32494);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.abUN != null)
      {
        paramVarArgs.qD(2, this.abUN.computeSize());
        this.abUN.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.abtf);
      paramVarArgs.bS(4, this.abth);
      if (this.YOu != null) {
        paramVarArgs.g(5, this.YOu);
      }
      AppMethodBeat.o(32494);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label625;
      }
    }
    label625:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abUN != null) {
        i = paramInt + i.a.a.a.qC(2, this.abUN.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(3, this.abtf) + i.a.a.b.b.a.cJ(4, this.abth);
      paramInt = i;
      if (this.YOu != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YOu);
      }
      AppMethodBeat.o(32494);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.abUN == null)
        {
          paramVarArgs = new b("Not all required fields were included: Piece");
          AppMethodBeat.o(32494);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32494);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fwy localfwy = (fwy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32494);
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
            localfwy.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32494);
          return 0;
        case 2: 
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
            localfwy.abUN = ((fzf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32494);
          return 0;
        case 3: 
          localfwy.abtf = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32494);
          return 0;
        case 4: 
          localfwy.abth = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32494);
          return 0;
        }
        localfwy.YOu = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(32494);
        return 0;
      }
      AppMethodBeat.o(32494);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fwy
 * JD-Core Version:    0.7.0.1
 */