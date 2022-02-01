package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class xf
  extends com.tencent.mm.bx.a
{
  public String CZa;
  public String CZb;
  public LinkedList<bpu> CZc;
  
  public xf()
  {
    AppMethodBeat.i(116467);
    this.CZc = new LinkedList();
    AppMethodBeat.o(116467);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116468);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CZa != null) {
        paramVarArgs.d(1, this.CZa);
      }
      if (this.CZb != null) {
        paramVarArgs.d(2, this.CZb);
      }
      paramVarArgs.e(3, 8, this.CZc);
      AppMethodBeat.o(116468);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CZa == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = f.a.a.b.b.a.e(1, this.CZa) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CZb != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.CZb);
      }
      paramInt = f.a.a.a.c(3, 8, this.CZc);
      AppMethodBeat.o(116468);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CZc.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(116468);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        xf localxf = (xf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116468);
          return -1;
        case 1: 
          localxf.CZa = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(116468);
          return 0;
        case 2: 
          localxf.CZb = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(116468);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bpu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bpu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localxf.CZc.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(116468);
        return 0;
      }
      AppMethodBeat.o(116468);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xf
 * JD-Core Version:    0.7.0.1
 */