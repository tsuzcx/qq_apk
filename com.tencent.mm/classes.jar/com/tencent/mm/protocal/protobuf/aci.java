package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aci
  extends cld
{
  public int CJI;
  public int CLA;
  public int CNt;
  public String CyF;
  public int DcP;
  public int hno;
  public SKBuiltinBuffer_t uKT;
  public int uKX;
  public long uKZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148653);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uKT == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(148653);
        throw paramVarArgs;
      }
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(148653);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.uKX);
      paramVarArgs.aR(2, this.CNt);
      paramVarArgs.aR(3, this.CJI);
      paramVarArgs.aR(5, this.CLA);
      if (this.CyF != null) {
        paramVarArgs.d(6, this.CyF);
      }
      if (this.uKT != null)
      {
        paramVarArgs.kX(7, this.uKT.computeSize());
        this.uKT.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.hno);
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(9, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(10, this.DcP);
      paramVarArgs.aG(11, this.uKZ);
      AppMethodBeat.o(148653);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.uKX) + 0 + f.a.a.b.b.a.bA(2, this.CNt) + f.a.a.b.b.a.bA(3, this.CJI) + f.a.a.b.b.a.bA(5, this.CLA);
      paramInt = i;
      if (this.CyF != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CyF);
      }
      i = paramInt;
      if (this.uKT != null) {
        i = paramInt + f.a.a.a.kW(7, this.uKT.computeSize());
      }
      i += f.a.a.b.b.a.bA(8, this.hno);
      paramInt = i;
      if (this.BaseResponse != null) {
        paramInt = i + f.a.a.a.kW(9, this.BaseResponse.computeSize());
      }
      i = f.a.a.b.b.a.bA(10, this.DcP);
      int j = f.a.a.b.b.a.q(11, this.uKZ);
      AppMethodBeat.o(148653);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.uKT == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(148653);
        throw paramVarArgs;
      }
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(148653);
        throw paramVarArgs;
      }
      AppMethodBeat.o(148653);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      aci localaci = (aci)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      case 4: 
      default: 
        AppMethodBeat.o(148653);
        return -1;
      case 1: 
        localaci.uKX = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(148653);
        return 0;
      case 2: 
        localaci.CNt = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(148653);
        return 0;
      case 3: 
        localaci.CJI = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(148653);
        return 0;
      case 5: 
        localaci.CLA = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(148653);
        return 0;
      case 6: 
        localaci.CyF = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(148653);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaci.uKT = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(148653);
        return 0;
      case 8: 
        localaci.hno = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(148653);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new BaseResponse();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaci.BaseResponse = ((BaseResponse)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(148653);
        return 0;
      case 10: 
        localaci.DcP = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(148653);
        return 0;
      }
      localaci.uKZ = ((f.a.a.a.a)localObject1).KhF.xT();
      AppMethodBeat.o(148653);
      return 0;
    }
    AppMethodBeat.o(148653);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aci
 * JD-Core Version:    0.7.0.1
 */