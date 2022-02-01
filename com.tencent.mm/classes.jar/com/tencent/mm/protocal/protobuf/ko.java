package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ko
  extends ckq
{
  public String Ahs;
  public String CFs;
  public String CFt;
  public String CFu;
  public int dsB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72422);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CFs != null) {
        paramVarArgs.d(2, this.CFs);
      }
      if (this.CFt != null) {
        paramVarArgs.d(3, this.CFt);
      }
      if (this.Ahs != null) {
        paramVarArgs.d(4, this.Ahs);
      }
      if (this.CFu != null) {
        paramVarArgs.d(5, this.CFu);
      }
      paramVarArgs.aR(7, this.dsB);
      AppMethodBeat.o(72422);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label602;
      }
    }
    label602:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CFs != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CFs);
      }
      i = paramInt;
      if (this.CFt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CFt);
      }
      paramInt = i;
      if (this.Ahs != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Ahs);
      }
      i = paramInt;
      if (this.CFu != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CFu);
      }
      paramInt = f.a.a.b.b.a.bA(7, this.dsB);
      AppMethodBeat.o(72422);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72422);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ko localko = (ko)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 6: 
        default: 
          AppMethodBeat.o(72422);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localko.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72422);
          return 0;
        case 2: 
          localko.CFs = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72422);
          return 0;
        case 3: 
          localko.CFt = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72422);
          return 0;
        case 4: 
          localko.Ahs = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72422);
          return 0;
        case 5: 
          localko.CFu = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72422);
          return 0;
        }
        localko.dsB = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(72422);
        return 0;
      }
      AppMethodBeat.o(72422);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ko
 * JD-Core Version:    0.7.0.1
 */