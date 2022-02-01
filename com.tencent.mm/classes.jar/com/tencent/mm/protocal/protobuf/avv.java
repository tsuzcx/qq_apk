package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class avv
  extends ckq
{
  public float COI;
  public float COJ;
  public int Dvs;
  public int Dvt;
  public int Height;
  public int Width;
  public String oXs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56247);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.x(2, this.COI);
      paramVarArgs.x(3, this.COJ);
      paramVarArgs.aR(4, this.Width);
      paramVarArgs.aR(5, this.Height);
      if (this.oXs != null) {
        paramVarArgs.d(6, this.oXs);
      }
      paramVarArgs.aR(7, this.Dvs);
      paramVarArgs.aR(8, this.Dvt);
      AppMethodBeat.o(56247);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label640;
      }
    }
    label640:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (f.a.a.b.b.a.fY(2) + 4) + (f.a.a.b.b.a.fY(3) + 4) + f.a.a.b.b.a.bA(4, this.Width) + f.a.a.b.b.a.bA(5, this.Height);
      paramInt = i;
      if (this.oXs != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.oXs);
      }
      i = f.a.a.b.b.a.bA(7, this.Dvs);
      int j = f.a.a.b.b.a.bA(8, this.Dvt);
      AppMethodBeat.o(56247);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(56247);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        avv localavv = (avv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56247);
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
            localavv.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56247);
          return 0;
        case 2: 
          localavv.COI = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(56247);
          return 0;
        case 3: 
          localavv.COJ = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(56247);
          return 0;
        case 4: 
          localavv.Width = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(56247);
          return 0;
        case 5: 
          localavv.Height = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(56247);
          return 0;
        case 6: 
          localavv.oXs = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(56247);
          return 0;
        case 7: 
          localavv.Dvs = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(56247);
          return 0;
        }
        localavv.Dvt = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(56247);
        return 0;
      }
      AppMethodBeat.o(56247);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avv
 * JD-Core Version:    0.7.0.1
 */