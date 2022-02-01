package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class axo
  extends ckq
{
  public double CJD;
  public double CJE;
  public String Dop;
  public SKBuiltinBuffer_t Dva;
  public int Dvc;
  public double Dwu;
  public double Dwv;
  public int OpCode;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56249);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Dva == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buff");
        AppMethodBeat.o(56249);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Scene);
      paramVarArgs.aR(3, this.OpCode);
      if (this.Dop != null) {
        paramVarArgs.d(4, this.Dop);
      }
      if (this.Dva != null)
      {
        paramVarArgs.kX(5, this.Dva.computeSize());
        this.Dva.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, this.CJD);
      paramVarArgs.e(7, this.CJE);
      paramVarArgs.e(8, this.Dwu);
      paramVarArgs.e(9, this.Dwv);
      paramVarArgs.aR(10, this.Dvc);
      AppMethodBeat.o(56249);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label906;
      }
    }
    label906:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.Scene) + f.a.a.b.b.a.bA(3, this.OpCode);
      paramInt = i;
      if (this.Dop != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Dop);
      }
      i = paramInt;
      if (this.Dva != null) {
        i = paramInt + f.a.a.a.kW(5, this.Dva.computeSize());
      }
      paramInt = f.a.a.b.b.a.fY(6);
      int j = f.a.a.b.b.a.fY(7);
      int k = f.a.a.b.b.a.fY(8);
      int m = f.a.a.b.b.a.fY(9);
      int n = f.a.a.b.b.a.bA(10, this.Dvc);
      AppMethodBeat.o(56249);
      return i + (paramInt + 8) + (j + 8) + (k + 8) + (m + 8) + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Dva == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buff");
          AppMethodBeat.o(56249);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56249);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        axo localaxo = (axo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56249);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaxo.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56249);
          return 0;
        case 2: 
          localaxo.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(56249);
          return 0;
        case 3: 
          localaxo.OpCode = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(56249);
          return 0;
        case 4: 
          localaxo.Dop = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(56249);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaxo.Dva = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56249);
          return 0;
        case 6: 
          localaxo.CJD = Double.longBitsToDouble(((f.a.a.a.a)localObject1).KhF.fHy());
          AppMethodBeat.o(56249);
          return 0;
        case 7: 
          localaxo.CJE = Double.longBitsToDouble(((f.a.a.a.a)localObject1).KhF.fHy());
          AppMethodBeat.o(56249);
          return 0;
        case 8: 
          localaxo.Dwu = Double.longBitsToDouble(((f.a.a.a.a)localObject1).KhF.fHy());
          AppMethodBeat.o(56249);
          return 0;
        case 9: 
          localaxo.Dwv = Double.longBitsToDouble(((f.a.a.a.a)localObject1).KhF.fHy());
          AppMethodBeat.o(56249);
          return 0;
        }
        localaxo.Dvc = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(56249);
        return 0;
      }
      AppMethodBeat.o(56249);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axo
 * JD-Core Version:    0.7.0.1
 */