package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gmg
  extends com.tencent.mm.bx.a
{
  public String acht;
  public LinkedList<gmf> achu;
  
  public gmg()
  {
    AppMethodBeat.i(153332);
    this.achu = new LinkedList();
    AppMethodBeat.o(153332);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153333);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.acht != null) {
        paramVarArgs.g(1, this.acht);
      }
      paramVarArgs.e(2, 8, this.achu);
      AppMethodBeat.o(153333);
      return 0;
    }
    if (paramInt == 1) {
      if (this.acht == null) {
        break label332;
      }
    }
    label332:
    for (paramInt = i.a.a.b.b.a.h(1, this.acht) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.achu);
      AppMethodBeat.o(153333);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.achu.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(153333);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gmg localgmg = (gmg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153333);
          return -1;
        case 1: 
          localgmg.acht = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(153333);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          gmf localgmf = new gmf();
          if ((localObject != null) && (localObject.length > 0)) {
            localgmf.parseFrom((byte[])localObject);
          }
          localgmg.achu.add(localgmf);
          paramInt += 1;
        }
        AppMethodBeat.o(153333);
        return 0;
      }
      AppMethodBeat.o(153333);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gmg
 * JD-Core Version:    0.7.0.1
 */