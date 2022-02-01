package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ede
  extends com.tencent.mm.bx.a
{
  public fmp YCT;
  public fmp YCU;
  public LinkedList<wj> ZLJ;
  public dbk abix;
  public dtv abiy;
  
  public ede()
  {
    AppMethodBeat.i(91613);
    this.ZLJ = new LinkedList();
    AppMethodBeat.o(91613);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91614);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abix != null)
      {
        paramVarArgs.qD(1, this.abix.computeSize());
        this.abix.writeFields(paramVarArgs);
      }
      if (this.YCT != null)
      {
        paramVarArgs.qD(2, this.YCT.computeSize());
        this.YCT.writeFields(paramVarArgs);
      }
      if (this.YCU != null)
      {
        paramVarArgs.qD(3, this.YCU.computeSize());
        this.YCU.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.ZLJ);
      if (this.abiy != null)
      {
        paramVarArgs.qD(5, this.abiy.computeSize());
        this.abiy.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91614);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abix == null) {
        break label800;
      }
    }
    label800:
    for (int i = i.a.a.a.qC(1, this.abix.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YCT != null) {
        paramInt = i + i.a.a.a.qC(2, this.YCT.computeSize());
      }
      i = paramInt;
      if (this.YCU != null) {
        i = paramInt + i.a.a.a.qC(3, this.YCU.computeSize());
      }
      i += i.a.a.a.c(4, 8, this.ZLJ);
      paramInt = i;
      if (this.abiy != null) {
        paramInt = i + i.a.a.a.qC(5, this.abiy.computeSize());
      }
      AppMethodBeat.o(91614);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZLJ.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91614);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ede localede = (ede)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91614);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dbk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dbk)localObject2).parseFrom((byte[])localObject1);
            }
            localede.abix = ((dbk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91614);
          return 0;
        case 2: 
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
            localede.YCT = ((fmp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91614);
          return 0;
        case 3: 
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
            localede.YCU = ((fmp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91614);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new wj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((wj)localObject2).parseFrom((byte[])localObject1);
            }
            localede.ZLJ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91614);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dtv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dtv)localObject2).parseFrom((byte[])localObject1);
          }
          localede.abiy = ((dtv)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91614);
        return 0;
      }
      AppMethodBeat.o(91614);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ede
 * JD-Core Version:    0.7.0.1
 */