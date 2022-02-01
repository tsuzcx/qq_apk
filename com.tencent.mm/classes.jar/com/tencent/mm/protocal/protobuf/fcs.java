package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fcs
  extends com.tencent.mm.bx.a
{
  public String abCi;
  public alm abCj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259049);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abCi != null) {
        paramVarArgs.g(1, this.abCi);
      }
      if (this.abCj != null)
      {
        paramVarArgs.qD(2, this.abCj.computeSize());
        this.abCj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259049);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abCi == null) {
        break label344;
      }
    }
    label344:
    for (paramInt = i.a.a.b.b.a.h(1, this.abCi) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abCj != null) {
        i = paramInt + i.a.a.a.qC(2, this.abCj.computeSize());
      }
      AppMethodBeat.o(259049);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259049);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fcs localfcs = (fcs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259049);
          return -1;
        case 1: 
          localfcs.abCi = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259049);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          alm localalm = new alm();
          if ((localObject != null) && (localObject.length > 0)) {
            localalm.parseFrom((byte[])localObject);
          }
          localfcs.abCj = localalm;
          paramInt += 1;
        }
        AppMethodBeat.o(259049);
        return 0;
      }
      AppMethodBeat.o(259049);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fcs
 * JD-Core Version:    0.7.0.1
 */