package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class abz
  extends com.tencent.mm.bx.a
{
  public clf CLb;
  public String DcA;
  public String DcB;
  public int DcC;
  public String DcD;
  public String mAQ;
  public String rZo;
  public int saK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117866);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CLb != null)
      {
        paramVarArgs.kX(1, this.CLb.computeSize());
        this.CLb.writeFields(paramVarArgs);
      }
      if (this.rZo != null) {
        paramVarArgs.d(2, this.rZo);
      }
      if (this.DcA != null) {
        paramVarArgs.d(3, this.DcA);
      }
      paramVarArgs.aR(4, this.saK);
      if (this.mAQ != null) {
        paramVarArgs.d(5, this.mAQ);
      }
      if (this.DcB != null) {
        paramVarArgs.d(6, this.DcB);
      }
      paramVarArgs.aR(7, this.DcC);
      if (this.DcD != null) {
        paramVarArgs.d(8, this.DcD);
      }
      AppMethodBeat.o(117866);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CLb == null) {
        break label706;
      }
    }
    label706:
    for (int i = f.a.a.a.kW(1, this.CLb.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.rZo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.rZo);
      }
      i = paramInt;
      if (this.DcA != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DcA);
      }
      i += f.a.a.b.b.a.bA(4, this.saK);
      paramInt = i;
      if (this.mAQ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.mAQ);
      }
      i = paramInt;
      if (this.DcB != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.DcB);
      }
      i += f.a.a.b.b.a.bA(7, this.DcC);
      paramInt = i;
      if (this.DcD != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DcD);
      }
      AppMethodBeat.o(117866);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(117866);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        abz localabz = (abz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117866);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new clf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((clf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localabz.CLb = ((clf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117866);
          return 0;
        case 2: 
          localabz.rZo = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117866);
          return 0;
        case 3: 
          localabz.DcA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117866);
          return 0;
        case 4: 
          localabz.saK = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117866);
          return 0;
        case 5: 
          localabz.mAQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117866);
          return 0;
        case 6: 
          localabz.DcB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117866);
          return 0;
        case 7: 
          localabz.DcC = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117866);
          return 0;
        }
        localabz.DcD = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(117866);
        return 0;
      }
      AppMethodBeat.o(117866);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abz
 * JD-Core Version:    0.7.0.1
 */