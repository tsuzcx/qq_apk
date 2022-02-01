package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class afr
  extends ckq
{
  public float COI;
  public float COJ;
  public String Ddo;
  public String DfD;
  public int DfE;
  public String DfF;
  public String DfG;
  public int DfH;
  public int OpCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32207);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.OpCode);
      if (this.DfD != null) {
        paramVarArgs.d(3, this.DfD);
      }
      paramVarArgs.x(4, this.COI);
      paramVarArgs.x(5, this.COJ);
      paramVarArgs.aR(6, this.DfE);
      if (this.DfF != null) {
        paramVarArgs.d(7, this.DfF);
      }
      if (this.DfG != null) {
        paramVarArgs.d(8, this.DfG);
      }
      paramVarArgs.aR(9, this.DfH);
      if (this.Ddo != null) {
        paramVarArgs.d(10, this.Ddo);
      }
      AppMethodBeat.o(32207);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label796;
      }
    }
    label796:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.OpCode);
      paramInt = i;
      if (this.DfD != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.DfD);
      }
      i = paramInt + (f.a.a.b.b.a.fY(4) + 4) + (f.a.a.b.b.a.fY(5) + 4) + f.a.a.b.b.a.bA(6, this.DfE);
      paramInt = i;
      if (this.DfF != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DfF);
      }
      i = paramInt;
      if (this.DfG != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.DfG);
      }
      i += f.a.a.b.b.a.bA(9, this.DfH);
      paramInt = i;
      if (this.Ddo != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Ddo);
      }
      AppMethodBeat.o(32207);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32207);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        afr localafr = (afr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32207);
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
            localafr.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32207);
          return 0;
        case 2: 
          localafr.OpCode = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32207);
          return 0;
        case 3: 
          localafr.DfD = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32207);
          return 0;
        case 4: 
          localafr.COI = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(32207);
          return 0;
        case 5: 
          localafr.COJ = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(32207);
          return 0;
        case 6: 
          localafr.DfE = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32207);
          return 0;
        case 7: 
          localafr.DfF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32207);
          return 0;
        case 8: 
          localafr.DfG = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32207);
          return 0;
        case 9: 
          localafr.DfH = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32207);
          return 0;
        }
        localafr.Ddo = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(32207);
        return 0;
      }
      AppMethodBeat.o(32207);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afr
 * JD-Core Version:    0.7.0.1
 */