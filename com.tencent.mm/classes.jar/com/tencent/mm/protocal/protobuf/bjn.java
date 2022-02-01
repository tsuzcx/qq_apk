package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bjn
  extends cvp
{
  public int GDT;
  public String GDU;
  public int GDV;
  public String GDW;
  public int GDX;
  public LinkedList<cwt> GDY;
  public String GDZ;
  public int GEa;
  public String GEb;
  public int GEc;
  public SKBuiltinBuffer_t GEd;
  
  public bjn()
  {
    AppMethodBeat.i(152605);
    this.GDY = new LinkedList();
    AppMethodBeat.o(152605);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152606);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152606);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GDT);
      if (this.GDU != null) {
        paramVarArgs.d(3, this.GDU);
      }
      paramVarArgs.aS(4, this.GDV);
      if (this.GDW != null) {
        paramVarArgs.d(5, this.GDW);
      }
      paramVarArgs.aS(6, this.GDX);
      paramVarArgs.e(7, 8, this.GDY);
      if (this.GDZ != null) {
        paramVarArgs.d(8, this.GDZ);
      }
      paramVarArgs.aS(9, this.GEa);
      if (this.GEb != null) {
        paramVarArgs.d(10, this.GEb);
      }
      paramVarArgs.aS(11, this.GEc);
      if (this.GEd != null)
      {
        paramVarArgs.lC(12, this.GEd.computeSize());
        this.GEd.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152606);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1126;
      }
    }
    label1126:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GDT);
      paramInt = i;
      if (this.GDU != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GDU);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.GDV);
      paramInt = i;
      if (this.GDW != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GDW);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.GDX) + f.a.a.a.c(7, 8, this.GDY);
      paramInt = i;
      if (this.GDZ != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GDZ);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.GEa);
      paramInt = i;
      if (this.GEb != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.GEb);
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.GEc);
      paramInt = i;
      if (this.GEd != null) {
        paramInt = i + f.a.a.a.lB(12, this.GEd.computeSize());
      }
      AppMethodBeat.o(152606);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GDY.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152606);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152606);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bjn localbjn = (bjn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152606);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbjn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152606);
          return 0;
        case 2: 
          localbjn.GDT = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152606);
          return 0;
        case 3: 
          localbjn.GDU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152606);
          return 0;
        case 4: 
          localbjn.GDV = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152606);
          return 0;
        case 5: 
          localbjn.GDW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152606);
          return 0;
        case 6: 
          localbjn.GDX = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152606);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbjn.GDY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152606);
          return 0;
        case 8: 
          localbjn.GDZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152606);
          return 0;
        case 9: 
          localbjn.GEa = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152606);
          return 0;
        case 10: 
          localbjn.GEb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152606);
          return 0;
        case 11: 
          localbjn.GEc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152606);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbjn.GEd = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152606);
        return 0;
      }
      AppMethodBeat.o(152606);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjn
 * JD-Core Version:    0.7.0.1
 */