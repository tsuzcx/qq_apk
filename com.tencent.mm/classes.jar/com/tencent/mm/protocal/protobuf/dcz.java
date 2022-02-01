package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dcz
  extends com.tencent.mm.bx.a
{
  public String EuI;
  public String EuJ;
  public LinkedList<ahk> EuK;
  
  public dcz()
  {
    AppMethodBeat.i(153008);
    this.EuK = new LinkedList();
    AppMethodBeat.o(153008);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153009);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EuI != null) {
        paramVarArgs.d(1, this.EuI);
      }
      if (this.EuJ != null) {
        paramVarArgs.d(2, this.EuJ);
      }
      paramVarArgs.e(3, 8, this.EuK);
      AppMethodBeat.o(153009);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EuI == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = f.a.a.b.b.a.e(1, this.EuI) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EuJ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.EuJ);
      }
      paramInt = f.a.a.a.c(3, 8, this.EuK);
      AppMethodBeat.o(153009);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EuK.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(153009);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dcz localdcz = (dcz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153009);
          return -1;
        case 1: 
          localdcz.EuI = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153009);
          return 0;
        case 2: 
          localdcz.EuJ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153009);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ahk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ahk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdcz.EuK.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153009);
        return 0;
      }
      AppMethodBeat.o(153009);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcz
 * JD-Core Version:    0.7.0.1
 */