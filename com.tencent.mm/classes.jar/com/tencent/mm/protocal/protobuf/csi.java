package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class csi
  extends ckq
{
  public float COJ;
  public int CYi;
  public int CyE;
  public int Eke;
  public float Ekf;
  public float Ekg;
  public int hno;
  public SKBuiltinBuffer_t uKT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32448);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uKT == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(32448);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.uKT != null)
      {
        paramVarArgs.kX(2, this.uKT.computeSize());
        this.uKT.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.Eke);
      paramVarArgs.aR(4, this.hno);
      paramVarArgs.x(5, this.Ekf);
      paramVarArgs.aR(6, this.CYi);
      paramVarArgs.aR(7, this.CyE);
      paramVarArgs.x(8, this.Ekg);
      paramVarArgs.x(9, this.COJ);
      AppMethodBeat.o(32448);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label862;
      }
    }
    label862:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.uKT != null) {
        i = paramInt + f.a.a.a.kW(2, this.uKT.computeSize());
      }
      paramInt = f.a.a.b.b.a.bA(3, this.Eke);
      int j = f.a.a.b.b.a.bA(4, this.hno);
      int k = f.a.a.b.b.a.fY(5);
      int m = f.a.a.b.b.a.bA(6, this.CYi);
      int n = f.a.a.b.b.a.bA(7, this.CyE);
      int i1 = f.a.a.b.b.a.fY(8);
      int i2 = f.a.a.b.b.a.fY(9);
      AppMethodBeat.o(32448);
      return i + paramInt + j + (k + 4) + m + n + (i1 + 4) + (i2 + 4);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.uKT == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(32448);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32448);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        csi localcsi = (csi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32448);
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
            localcsi.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32448);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcsi.uKT = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32448);
          return 0;
        case 3: 
          localcsi.Eke = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32448);
          return 0;
        case 4: 
          localcsi.hno = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32448);
          return 0;
        case 5: 
          localcsi.Ekf = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(32448);
          return 0;
        case 6: 
          localcsi.CYi = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32448);
          return 0;
        case 7: 
          localcsi.CyE = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32448);
          return 0;
        case 8: 
          localcsi.Ekg = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(32448);
          return 0;
        }
        localcsi.COJ = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
        AppMethodBeat.o(32448);
        return 0;
      }
      AppMethodBeat.o(32448);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csi
 * JD-Core Version:    0.7.0.1
 */