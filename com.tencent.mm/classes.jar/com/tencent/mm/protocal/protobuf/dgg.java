package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dgg
  extends esc
{
  public int ZwC;
  public LinkedList<dgc> aaLx;
  public int aaLy;
  
  public dgg()
  {
    AppMethodBeat.i(257990);
    this.aaLx = new LinkedList();
    AppMethodBeat.o(257990);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257996);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.aaLx);
      paramVarArgs.bS(3, this.aaLy);
      paramVarArgs.bS(4, this.ZwC);
      AppMethodBeat.o(257996);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label498;
      }
    }
    label498:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.aaLx);
      int j = i.a.a.b.b.a.cJ(3, this.aaLy);
      int k = i.a.a.b.b.a.cJ(4, this.ZwC);
      AppMethodBeat.o(257996);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaLx.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257996);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dgg localdgg = (dgg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257996);
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
            localdgg.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257996);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dgc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dgc)localObject2).parseFrom((byte[])localObject1);
            }
            localdgg.aaLx.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257996);
          return 0;
        case 3: 
          localdgg.aaLy = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257996);
          return 0;
        }
        localdgg.ZwC = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257996);
        return 0;
      }
      AppMethodBeat.o(257996);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgg
 * JD-Core Version:    0.7.0.1
 */