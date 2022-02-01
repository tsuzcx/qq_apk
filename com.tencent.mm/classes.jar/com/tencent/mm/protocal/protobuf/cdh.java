package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdh
  extends com.tencent.mm.bx.a
{
  public clc GXu;
  public double GXv;
  public String text;
  public LinkedList<Double> wMz;
  
  public cdh()
  {
    AppMethodBeat.i(118410);
    this.wMz = new LinkedList();
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
      if (this.GXu != null)
      {
        paramVarArgs.lC(2, this.GXu.computeSize());
        this.GXu.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, this.GXv);
      paramVarArgs.e(4, 4, this.wMz);
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
      if (this.GXu != null) {
        i = paramInt + f.a.a.a.lB(2, this.GXu.computeSize());
      }
      paramInt = f.a.a.b.b.a.alT(3);
      int j = f.a.a.a.c(4, 4, this.wMz);
      AppMethodBeat.o(118411);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wMz.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(118411);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cdh localcdh = (cdh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118411);
          return -1;
        case 1: 
          localcdh.text = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(118411);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new clc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((clc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdh.GXu = ((clc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118411);
          return 0;
        case 3: 
          localcdh.GXv = Double.longBitsToDouble(((f.a.a.a.a)localObject1).NPN.grA());
          AppMethodBeat.o(118411);
          return 0;
        }
        localcdh.wMz.add(Double.valueOf(Double.longBitsToDouble(((f.a.a.a.a)localObject1).NPN.grA())));
        AppMethodBeat.o(118411);
        return 0;
      }
      AppMethodBeat.o(118411);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdh
 * JD-Core Version:    0.7.0.1
 */