package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ceb
  extends com.tencent.mm.bw.a
{
  public clw HqU;
  public double HqV;
  public String text;
  public LinkedList<Double> xcn;
  
  public ceb()
  {
    AppMethodBeat.i(118410);
    this.xcn = new LinkedList();
    AppMethodBeat.o(118410);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118411);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.text != null) {
        paramVarArgs.d(1, this.text);
      }
      if (this.HqU != null)
      {
        paramVarArgs.lJ(2, this.HqU.computeSize());
        this.HqU.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, this.HqV);
      paramVarArgs.e(4, 4, this.xcn);
      AppMethodBeat.o(118411);
      return 0;
    }
    if (paramInt == 1) {
      if (this.text == null) {
        break label479;
      }
    }
    label479:
    for (paramInt = f.a.a.b.b.a.e(1, this.text) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HqU != null) {
        i = paramInt + f.a.a.a.lI(2, this.HqU.computeSize());
      }
      paramInt = f.a.a.b.b.a.amD(3);
      int j = f.a.a.a.c(4, 4, this.xcn);
      AppMethodBeat.o(118411);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xcn.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(118411);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ceb localceb = (ceb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118411);
          return -1;
        case 1: 
          localceb.text = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(118411);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new clw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((clw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localceb.HqU = ((clw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118411);
          return 0;
        case 3: 
          localceb.HqV = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
          AppMethodBeat.o(118411);
          return 0;
        }
        localceb.xcn.add(Double.valueOf(Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc())));
        AppMethodBeat.o(118411);
        return 0;
      }
      AppMethodBeat.o(118411);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ceb
 * JD-Core Version:    0.7.0.1
 */