package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bum
  extends com.tencent.mm.bx.a
{
  public String aabE;
  public LinkedList<bxi> aace;
  
  public bum()
  {
    AppMethodBeat.i(259216);
    this.aace = new LinkedList();
    AppMethodBeat.o(259216);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259219);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aabE != null) {
        paramVarArgs.g(1, this.aabE);
      }
      paramVarArgs.e(2, 8, this.aace);
      AppMethodBeat.o(259219);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aabE == null) {
        break label332;
      }
    }
    label332:
    for (paramInt = i.a.a.b.b.a.h(1, this.aabE) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.aace);
      AppMethodBeat.o(259219);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aace.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259219);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bum localbum = (bum)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259219);
          return -1;
        case 1: 
          localbum.aabE = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259219);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bxi localbxi = new bxi();
          if ((localObject != null) && (localObject.length > 0)) {
            localbxi.parseFrom((byte[])localObject);
          }
          localbum.aace.add(localbxi);
          paramInt += 1;
        }
        AppMethodBeat.o(259219);
        return 0;
      }
      AppMethodBeat.o(259219);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bum
 * JD-Core Version:    0.7.0.1
 */