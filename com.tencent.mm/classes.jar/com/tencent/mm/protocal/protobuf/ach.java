package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ach
  extends ckq
{
  public int CJI;
  public int CNt;
  public String Cxb;
  public String CyF;
  public long DcO;
  public int uKX;
  public long uKZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148652);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.uKX);
      paramVarArgs.aR(2, this.CNt);
      paramVarArgs.aR(3, this.CJI);
      if (this.CyF != null) {
        paramVarArgs.d(4, this.CyF);
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(5, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(6, this.uKZ);
      if (this.Cxb != null) {
        paramVarArgs.d(7, this.Cxb);
      }
      paramVarArgs.aG(8, this.DcO);
      AppMethodBeat.o(148652);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.uKX) + 0 + f.a.a.b.b.a.bA(2, this.CNt) + f.a.a.b.b.a.bA(3, this.CJI);
      paramInt = i;
      if (this.CyF != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CyF);
      }
      i = paramInt;
      if (this.BaseRequest != null) {
        i = paramInt + f.a.a.a.kW(5, this.BaseRequest.computeSize());
      }
      i += f.a.a.b.b.a.q(6, this.uKZ);
      paramInt = i;
      if (this.Cxb != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Cxb);
      }
      i = f.a.a.b.b.a.q(8, this.DcO);
      AppMethodBeat.o(148652);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(148652);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ach localach = (ach)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(148652);
        return -1;
      case 1: 
        localach.uKX = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(148652);
        return 0;
      case 2: 
        localach.CNt = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(148652);
        return 0;
      case 3: 
        localach.CJI = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(148652);
        return 0;
      case 4: 
        localach.CyF = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(148652);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ip();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localach.BaseRequest = ((ip)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(148652);
        return 0;
      case 6: 
        localach.uKZ = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(148652);
        return 0;
      case 7: 
        localach.Cxb = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(148652);
        return 0;
      }
      localach.DcO = ((f.a.a.a.a)localObject1).KhF.xT();
      AppMethodBeat.o(148652);
      return 0;
    }
    AppMethodBeat.o(148652);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ach
 * JD-Core Version:    0.7.0.1
 */