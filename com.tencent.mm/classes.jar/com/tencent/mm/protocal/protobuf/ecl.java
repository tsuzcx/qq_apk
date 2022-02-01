package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ecl
  extends com.tencent.mm.bx.a
{
  public LinkedList<eck> UeP;
  public String title;
  
  public ecl()
  {
    AppMethodBeat.i(72543);
    this.UeP = new LinkedList();
    AppMethodBeat.o(72543);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72544);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      paramVarArgs.e(2, 8, this.UeP);
      AppMethodBeat.o(72544);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label332;
      }
    }
    label332:
    for (paramInt = i.a.a.b.b.a.h(1, this.title) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.UeP);
      AppMethodBeat.o(72544);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UeP.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72544);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ecl localecl = (ecl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72544);
          return -1;
        case 1: 
          localecl.title = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72544);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          eck localeck = new eck();
          if ((localObject != null) && (localObject.length > 0)) {
            localeck.parseFrom((byte[])localObject);
          }
          localecl.UeP.add(localeck);
          paramInt += 1;
        }
        AppMethodBeat.o(72544);
        return 0;
      }
      AppMethodBeat.o(72544);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecl
 * JD-Core Version:    0.7.0.1
 */