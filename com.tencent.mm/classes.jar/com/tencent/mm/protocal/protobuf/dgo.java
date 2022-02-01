package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dgo
  extends com.tencent.mm.bx.a
{
  public String IJD;
  public LinkedList<gji> YIB;
  public int vgN;
  
  public dgo()
  {
    AppMethodBeat.i(257870);
    this.YIB = new LinkedList();
    AppMethodBeat.o(257870);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257874);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IJD != null) {
        paramVarArgs.g(1, this.IJD);
      }
      paramVarArgs.bS(2, this.vgN);
      paramVarArgs.e(3, 8, this.YIB);
      AppMethodBeat.o(257874);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IJD == null) {
        break label380;
      }
    }
    label380:
    for (paramInt = i.a.a.b.b.a.h(1, this.IJD) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.vgN);
      int j = i.a.a.a.c(3, 8, this.YIB);
      AppMethodBeat.o(257874);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YIB.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257874);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dgo localdgo = (dgo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257874);
          return -1;
        case 1: 
          localdgo.IJD = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257874);
          return 0;
        case 2: 
          localdgo.vgN = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257874);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          gji localgji = new gji();
          if ((localObject != null) && (localObject.length > 0)) {
            localgji.parseFrom((byte[])localObject);
          }
          localdgo.YIB.add(localgji);
          paramInt += 1;
        }
        AppMethodBeat.o(257874);
        return 0;
      }
      AppMethodBeat.o(257874);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgo
 * JD-Core Version:    0.7.0.1
 */