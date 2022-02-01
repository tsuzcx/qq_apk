package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fcz
  extends com.tencent.mm.bx.a
{
  public LinkedList<aku> abCo;
  public LinkedList<aku> abCp;
  public String absI;
  
  public fcz()
  {
    AppMethodBeat.i(258971);
    this.abCo = new LinkedList();
    this.abCp = new LinkedList();
    AppMethodBeat.o(258971);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258978);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.absI != null) {
        paramVarArgs.g(1, this.absI);
      }
      paramVarArgs.e(2, 8, this.abCo);
      paramVarArgs.e(3, 8, this.abCp);
      AppMethodBeat.o(258978);
      return 0;
    }
    if (paramInt == 1) {
      if (this.absI == null) {
        break label450;
      }
    }
    label450:
    for (paramInt = i.a.a.b.b.a.h(1, this.absI) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.abCo);
      int j = i.a.a.a.c(3, 8, this.abCp);
      AppMethodBeat.o(258978);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abCo.clear();
        this.abCp.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258978);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fcz localfcz = (fcz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        aku localaku;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258978);
          return -1;
        case 1: 
          localfcz.absI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258978);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localaku = new aku();
            if ((localObject != null) && (localObject.length > 0)) {
              localaku.parseFrom((byte[])localObject);
            }
            localfcz.abCo.add(localaku);
            paramInt += 1;
          }
          AppMethodBeat.o(258978);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localaku = new aku();
          if ((localObject != null) && (localObject.length > 0)) {
            localaku.parseFrom((byte[])localObject);
          }
          localfcz.abCp.add(localaku);
          paramInt += 1;
        }
        AppMethodBeat.o(258978);
        return 0;
      }
      AppMethodBeat.o(258978);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fcz
 * JD-Core Version:    0.7.0.1
 */