package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ang
  extends com.tencent.mm.bx.a
{
  public String Md5;
  public int vgN;
  public LinkedList<dgn> vgO;
  
  public ang()
  {
    AppMethodBeat.i(104773);
    this.vgO = new LinkedList();
    AppMethodBeat.o(104773);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104774);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Md5 != null) {
        paramVarArgs.g(1, this.Md5);
      }
      paramVarArgs.bS(2, this.vgN);
      paramVarArgs.e(3, 8, this.vgO);
      AppMethodBeat.o(104774);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Md5 == null) {
        break label380;
      }
    }
    label380:
    for (paramInt = i.a.a.b.b.a.h(1, this.Md5) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.vgN);
      int j = i.a.a.a.c(3, 8, this.vgO);
      AppMethodBeat.o(104774);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.vgO.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(104774);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ang localang = (ang)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104774);
          return -1;
        case 1: 
          localang.Md5 = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(104774);
          return 0;
        case 2: 
          localang.vgN = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(104774);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dgn localdgn = new dgn();
          if ((localObject != null) && (localObject.length > 0)) {
            localdgn.parseFrom((byte[])localObject);
          }
          localang.vgO.add(localdgn);
          paramInt += 1;
        }
        AppMethodBeat.o(104774);
        return 0;
      }
      AppMethodBeat.o(104774);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ang
 * JD-Core Version:    0.7.0.1
 */