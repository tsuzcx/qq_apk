package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class btz
  extends com.tencent.mm.bx.a
{
  public cbd DRt;
  public double DRu;
  public String text;
  public LinkedList<Double> uwA;
  
  public btz()
  {
    AppMethodBeat.i(118410);
    this.uwA = new LinkedList();
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
      if (this.DRt != null)
      {
        paramVarArgs.kX(2, this.DRt.computeSize());
        this.DRt.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, this.DRu);
      paramVarArgs.e(4, 4, this.uwA);
      AppMethodBeat.o(118411);
      return 0;
    }
    if (paramInt == 1) {
      if (this.text == null) {
        break label483;
      }
    }
    label483:
    for (paramInt = f.a.a.b.b.a.e(1, this.text) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DRt != null) {
        i = paramInt + f.a.a.a.kW(2, this.DRt.computeSize());
      }
      paramInt = f.a.a.b.b.a.fY(3);
      int j = f.a.a.a.c(4, 4, this.uwA);
      AppMethodBeat.o(118411);
      return i + (paramInt + 8) + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.uwA.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(118411);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        btz localbtz = (btz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118411);
          return -1;
        case 1: 
          localbtz.text = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(118411);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cbd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cbd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtz.DRt = ((cbd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118411);
          return 0;
        case 3: 
          localbtz.DRu = Double.longBitsToDouble(((f.a.a.a.a)localObject1).KhF.fHy());
          AppMethodBeat.o(118411);
          return 0;
        }
        localbtz.uwA.add(Double.valueOf(Double.longBitsToDouble(((f.a.a.a.a)localObject1).KhF.fHy())));
        AppMethodBeat.o(118411);
        return 0;
      }
      AppMethodBeat.o(118411);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btz
 * JD-Core Version:    0.7.0.1
 */