package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bvd
  extends esc
{
  public b ACg;
  public LinkedList<fkm> aacE;
  
  public bvd()
  {
    AppMethodBeat.i(258914);
    this.aacE = new LinkedList();
    AppMethodBeat.o(258914);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258918);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.aacE);
      if (this.ACg != null) {
        paramVarArgs.d(3, this.ACg);
      }
      AppMethodBeat.o(258918);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.aacE);
      paramInt = i;
      if (this.ACg != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.ACg);
      }
      AppMethodBeat.o(258918);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aacE.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258918);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bvd localbvd = (bvd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258918);
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
            localbvd.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258918);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fkm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fkm)localObject2).parseFrom((byte[])localObject1);
            }
            localbvd.aacE.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258918);
          return 0;
        }
        localbvd.ACg = ((i.a.a.a.a)localObject1).ajGk.kFX();
        AppMethodBeat.o(258918);
        return 0;
      }
      AppMethodBeat.o(258918);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvd
 * JD-Core Version:    0.7.0.1
 */