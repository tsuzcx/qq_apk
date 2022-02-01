package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bmd
  extends com.tencent.mm.bx.a
{
  public bgh Ddj;
  public long ZUT;
  public int ZUU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259029);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Ddj != null)
      {
        paramVarArgs.qD(1, this.Ddj.computeSize());
        this.Ddj.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.ZUT);
      paramVarArgs.bS(3, this.ZUU);
      AppMethodBeat.o(259029);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ddj == null) {
        break label376;
      }
    }
    label376:
    for (paramInt = i.a.a.a.qC(1, this.Ddj.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.q(2, this.ZUT);
      int j = i.a.a.b.b.a.cJ(3, this.ZUU);
      AppMethodBeat.o(259029);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259029);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bmd localbmd = (bmd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259029);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            bgh localbgh = new bgh();
            if ((localObject != null) && (localObject.length > 0)) {
              localbgh.parseFrom((byte[])localObject);
            }
            localbmd.Ddj = localbgh;
            paramInt += 1;
          }
          AppMethodBeat.o(259029);
          return 0;
        case 2: 
          localbmd.ZUT = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(259029);
          return 0;
        }
        localbmd.ZUU = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259029);
        return 0;
      }
      AppMethodBeat.o(259029);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmd
 * JD-Core Version:    0.7.0.1
 */