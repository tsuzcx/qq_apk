package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cxz
  extends com.tencent.mm.bx.a
{
  public fmp YCT;
  public LinkedList<fcx> YCW;
  public String YMe;
  
  public cxz()
  {
    AppMethodBeat.i(91514);
    this.YCW = new LinkedList();
    AppMethodBeat.o(91514);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91515);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YCT != null)
      {
        paramVarArgs.qD(1, this.YCT.computeSize());
        this.YCT.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.YCW);
      if (this.YMe != null) {
        paramVarArgs.g(3, this.YMe);
      }
      AppMethodBeat.o(91515);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YCT == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = i.a.a.a.qC(1, this.YCT.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.YCW);
      paramInt = i;
      if (this.YMe != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.YMe);
      }
      AppMethodBeat.o(91515);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YCW.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91515);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cxz localcxz = (cxz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91515);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fmp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fmp)localObject2).parseFrom((byte[])localObject1);
            }
            localcxz.YCT = ((fmp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91515);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fcx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fcx)localObject2).parseFrom((byte[])localObject1);
            }
            localcxz.YCW.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91515);
          return 0;
        }
        localcxz.YMe = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91515);
        return 0;
      }
      AppMethodBeat.o(91515);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxz
 * JD-Core Version:    0.7.0.1
 */