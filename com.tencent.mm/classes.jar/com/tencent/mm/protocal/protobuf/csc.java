package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class csc
  extends com.tencent.mm.bw.a
{
  public String MwX;
  public axy MwY;
  public String Mxj;
  public String Mxk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(256716);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MwX != null) {
        paramVarArgs.e(1, this.MwX);
      }
      if (this.Mxj != null) {
        paramVarArgs.e(2, this.Mxj);
      }
      if (this.Mxk != null) {
        paramVarArgs.e(3, this.Mxk);
      }
      if (this.MwY != null)
      {
        paramVarArgs.ni(4, this.MwY.computeSize());
        this.MwY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(256716);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MwX == null) {
        break label490;
      }
    }
    label490:
    for (int i = g.a.a.b.b.a.f(1, this.MwX) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Mxj != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Mxj);
      }
      i = paramInt;
      if (this.Mxk != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Mxk);
      }
      paramInt = i;
      if (this.MwY != null) {
        paramInt = i + g.a.a.a.nh(4, this.MwY.computeSize());
      }
      AppMethodBeat.o(256716);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(256716);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        csc localcsc = (csc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(256716);
          return -1;
        case 1: 
          localcsc.MwX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256716);
          return 0;
        case 2: 
          localcsc.Mxj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256716);
          return 0;
        case 3: 
          localcsc.Mxk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256716);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new axy();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((axy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcsc.MwY = ((axy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(256716);
        return 0;
      }
      AppMethodBeat.o(256716);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csc
 * JD-Core Version:    0.7.0.1
 */