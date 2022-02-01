package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class zw
  extends com.tencent.mm.bx.a
{
  public String FYW;
  public String FYX;
  public LinkedList<bza> FYY;
  
  public zw()
  {
    AppMethodBeat.i(116467);
    this.FYY = new LinkedList();
    AppMethodBeat.o(116467);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116468);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FYW != null) {
        paramVarArgs.d(1, this.FYW);
      }
      if (this.FYX != null) {
        paramVarArgs.d(2, this.FYX);
      }
      paramVarArgs.e(3, 8, this.FYY);
      AppMethodBeat.o(116468);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FYW == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = f.a.a.b.b.a.e(1, this.FYW) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FYX != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FYX);
      }
      paramInt = f.a.a.a.c(3, 8, this.FYY);
      AppMethodBeat.o(116468);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FYY.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(116468);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        zw localzw = (zw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116468);
          return -1;
        case 1: 
          localzw.FYW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(116468);
          return 0;
        case 2: 
          localzw.FYX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(116468);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bza();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bza)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localzw.FYY.add(localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zw
 * JD-Core Version:    0.7.0.1
 */