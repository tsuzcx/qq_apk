package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ezb
  extends com.tencent.mm.bx.a
{
  public LinkedList<eag> abAf;
  public LinkedList<fya> abAg;
  public String hJW;
  
  public ezb()
  {
    AppMethodBeat.i(122536);
    this.hJW = "";
    this.abAf = new LinkedList();
    this.abAg = new LinkedList();
    AppMethodBeat.o(122536);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122537);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hJW != null) {
        paramVarArgs.g(1, this.hJW);
      }
      paramVarArgs.e(2, 8, this.abAf);
      paramVarArgs.e(3, 8, this.abAg);
      AppMethodBeat.o(122537);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hJW == null) {
        break label450;
      }
    }
    label450:
    for (paramInt = i.a.a.b.b.a.h(1, this.hJW) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.abAf);
      int j = i.a.a.a.c(3, 8, this.abAg);
      AppMethodBeat.o(122537);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abAf.clear();
        this.abAg.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(122537);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ezb localezb = (ezb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122537);
          return -1;
        case 1: 
          localezb.hJW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(122537);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eag();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eag)localObject2).parseFrom((byte[])localObject1);
            }
            localezb.abAf.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(122537);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fya();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fya)localObject2).parseFrom((byte[])localObject1);
          }
          localezb.abAg.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(122537);
        return 0;
      }
      AppMethodBeat.o(122537);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezb
 * JD-Core Version:    0.7.0.1
 */