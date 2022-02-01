package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class nt
  extends com.tencent.mm.bw.a
{
  public String EdG;
  public int EdH;
  public String EdI;
  public int EdJ;
  public LinkedList<lv> EdK;
  
  public nt()
  {
    AppMethodBeat.i(152509);
    this.EdK = new LinkedList();
    AppMethodBeat.o(152509);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152510);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EdG != null) {
        paramVarArgs.d(1, this.EdG);
      }
      paramVarArgs.aR(2, this.EdH);
      if (this.EdI != null) {
        paramVarArgs.d(3, this.EdI);
      }
      paramVarArgs.aR(4, this.EdJ);
      paramVarArgs.e(5, 8, this.EdK);
      AppMethodBeat.o(152510);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EdG == null) {
        break label506;
      }
    }
    label506:
    for (paramInt = f.a.a.b.b.a.e(1, this.EdG) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.EdH);
      paramInt = i;
      if (this.EdI != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.EdI);
      }
      i = f.a.a.b.b.a.bx(4, this.EdJ);
      int j = f.a.a.a.c(5, 8, this.EdK);
      AppMethodBeat.o(152510);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EdK.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(152510);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        nt localnt = (nt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152510);
          return -1;
        case 1: 
          localnt.EdG = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152510);
          return 0;
        case 2: 
          localnt.EdH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152510);
          return 0;
        case 3: 
          localnt.EdI = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152510);
          return 0;
        case 4: 
          localnt.EdJ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152510);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new lv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((lv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localnt.EdK.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152510);
        return 0;
      }
      AppMethodBeat.o(152510);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nt
 * JD-Core Version:    0.7.0.1
 */