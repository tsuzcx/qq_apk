package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dpv
  extends com.tencent.mm.bx.a
{
  public dxf aaWx;
  public String pss;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152628);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.pss != null) {
        paramVarArgs.g(1, this.pss);
      }
      if (this.aaWx != null)
      {
        paramVarArgs.qD(2, this.aaWx.computeSize());
        this.aaWx.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152628);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pss == null) {
        break label344;
      }
    }
    label344:
    for (paramInt = i.a.a.b.b.a.h(1, this.pss) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aaWx != null) {
        i = paramInt + i.a.a.a.qC(2, this.aaWx.computeSize());
      }
      AppMethodBeat.o(152628);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152628);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dpv localdpv = (dpv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152628);
          return -1;
        case 1: 
          localdpv.pss = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152628);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dxf localdxf = new dxf();
          if ((localObject != null) && (localObject.length > 0)) {
            localdxf.parseFrom((byte[])localObject);
          }
          localdpv.aaWx = localdxf;
          paramInt += 1;
        }
        AppMethodBeat.o(152628);
        return 0;
      }
      AppMethodBeat.o(152628);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpv
 * JD-Core Version:    0.7.0.1
 */