package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bil
  extends esc
{
  public bgq ZMY;
  public LinkedList<ccb> ZRA;
  public int ZRB;
  
  public bil()
  {
    AppMethodBeat.i(257472);
    this.ZRA = new LinkedList();
    AppMethodBeat.o(257472);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257478);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.ZRA);
      if (this.ZMY != null)
      {
        paramVarArgs.qD(3, this.ZMY.computeSize());
        this.ZMY.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.ZRB);
      AppMethodBeat.o(257478);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label580;
      }
    }
    label580:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.ZRA);
      paramInt = i;
      if (this.ZMY != null) {
        paramInt = i + i.a.a.a.qC(3, this.ZMY.computeSize());
      }
      i = i.a.a.b.b.a.cJ(4, this.ZRB);
      AppMethodBeat.o(257478);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZRA.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257478);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bil localbil = (bil)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257478);
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
            localbil.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257478);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ccb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ccb)localObject2).parseFrom((byte[])localObject1);
            }
            localbil.ZRA.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257478);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bgq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bgq)localObject2).parseFrom((byte[])localObject1);
            }
            localbil.ZMY = ((bgq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257478);
          return 0;
        }
        localbil.ZRB = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257478);
        return 0;
      }
      AppMethodBeat.o(257478);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bil
 * JD-Core Version:    0.7.0.1
 */