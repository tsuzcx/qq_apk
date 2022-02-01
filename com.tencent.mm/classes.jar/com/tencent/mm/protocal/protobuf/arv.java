package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class arv
  extends com.tencent.mm.bx.a
{
  public String DrT;
  public sq DrZ;
  public String Dsa;
  public boolean Dsb;
  public int Dsc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114024);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DrZ != null)
      {
        paramVarArgs.kX(1, this.DrZ.computeSize());
        this.DrZ.writeFields(paramVarArgs);
      }
      if (this.DrT != null) {
        paramVarArgs.d(2, this.DrT);
      }
      if (this.Dsa != null) {
        paramVarArgs.d(3, this.Dsa);
      }
      paramVarArgs.bg(4, this.Dsb);
      paramVarArgs.aR(5, this.Dsc);
      AppMethodBeat.o(114024);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DrZ == null) {
        break label518;
      }
    }
    label518:
    for (int i = f.a.a.a.kW(1, this.DrZ.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DrT != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DrT);
      }
      i = paramInt;
      if (this.Dsa != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Dsa);
      }
      paramInt = f.a.a.b.b.a.fY(4);
      int j = f.a.a.b.b.a.bA(5, this.Dsc);
      AppMethodBeat.o(114024);
      return i + (paramInt + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(114024);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        arv localarv = (arv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114024);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((sq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarv.DrZ = ((sq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114024);
          return 0;
        case 2: 
          localarv.DrT = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114024);
          return 0;
        case 3: 
          localarv.Dsa = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114024);
          return 0;
        case 4: 
          localarv.Dsb = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(114024);
          return 0;
        }
        localarv.Dsc = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(114024);
        return 0;
      }
      AppMethodBeat.o(114024);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arv
 * JD-Core Version:    0.7.0.1
 */