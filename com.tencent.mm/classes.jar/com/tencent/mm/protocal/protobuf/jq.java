package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class jq
  extends com.tencent.mm.bx.a
{
  public String YLE;
  public LinkedList<eok> YLU;
  public fcz YLV;
  
  public jq()
  {
    AppMethodBeat.i(91357);
    this.YLU = new LinkedList();
    AppMethodBeat.o(91357);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91358);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YLE != null) {
        paramVarArgs.g(1, this.YLE);
      }
      paramVarArgs.e(2, 8, this.YLU);
      if (this.YLV != null)
      {
        paramVarArgs.qD(3, this.YLV.computeSize());
        this.YLV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91358);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YLE == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = i.a.a.b.b.a.h(1, this.YLE) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.YLU);
      paramInt = i;
      if (this.YLV != null) {
        paramInt = i + i.a.a.a.qC(3, this.YLV.computeSize());
      }
      AppMethodBeat.o(91358);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YLU.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91358);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        jq localjq = (jq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91358);
          return -1;
        case 1: 
          localjq.YLE = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91358);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eok();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eok)localObject2).parseFrom((byte[])localObject1);
            }
            localjq.YLU.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91358);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fcz();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fcz)localObject2).parseFrom((byte[])localObject1);
          }
          localjq.YLV = ((fcz)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91358);
        return 0;
      }
      AppMethodBeat.o(91358);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jq
 * JD-Core Version:    0.7.0.1
 */