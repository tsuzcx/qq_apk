package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bat
  extends esc
{
  public int BeA;
  public b ZEQ;
  public LinkedList<FinderObject> ZIQ;
  public int ZLz;
  
  public bat()
  {
    AppMethodBeat.i(259987);
    this.ZIQ = new LinkedList();
    AppMethodBeat.o(259987);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259991);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.ZIQ);
      if (this.ZEQ != null) {
        paramVarArgs.d(3, this.ZEQ);
      }
      paramVarArgs.bS(4, this.BeA);
      paramVarArgs.bS(5, this.ZLz);
      AppMethodBeat.o(259991);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.ZIQ);
      paramInt = i;
      if (this.ZEQ != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.ZEQ);
      }
      i = i.a.a.b.b.a.cJ(4, this.BeA);
      int j = i.a.a.b.b.a.cJ(5, this.ZLz);
      AppMethodBeat.o(259991);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZIQ.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259991);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bat localbat = (bat)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259991);
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
            localbat.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259991);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localbat.ZIQ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259991);
          return 0;
        case 3: 
          localbat.ZEQ = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259991);
          return 0;
        case 4: 
          localbat.BeA = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259991);
          return 0;
        }
        localbat.ZLz = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259991);
        return 0;
      }
      AppMethodBeat.o(259991);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bat
 * JD-Core Version:    0.7.0.1
 */