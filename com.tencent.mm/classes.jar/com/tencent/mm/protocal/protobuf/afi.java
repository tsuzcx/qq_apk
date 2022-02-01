package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class afi
  extends cvp
{
  public int FIg;
  public int FKC;
  public int FMu;
  public String Fwt;
  public int Gds;
  public int ihf;
  public int xbr;
  public long xbt;
  public SKBuiltinBuffer_t xcN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148653);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.xcN == null)
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
      paramVarArgs.aS(1, this.xbr);
      paramVarArgs.aS(2, this.FMu);
      paramVarArgs.aS(3, this.FIg);
      paramVarArgs.aS(5, this.FKC);
      if (this.Fwt != null) {
        paramVarArgs.d(6, this.Fwt);
      }
      if (this.xcN != null)
      {
        paramVarArgs.lC(7, this.xcN.computeSize());
        this.xcN.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.ihf);
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(9, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(10, this.Gds);
      paramVarArgs.aY(11, this.xbt);
      AppMethodBeat.o(148653);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.xbr) + 0 + f.a.a.b.b.a.bz(2, this.FMu) + f.a.a.b.b.a.bz(3, this.FIg) + f.a.a.b.b.a.bz(5, this.FKC);
      paramInt = i;
      if (this.Fwt != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Fwt);
      }
      i = paramInt;
      if (this.xcN != null) {
        i = paramInt + f.a.a.a.lB(7, this.xcN.computeSize());
      }
      i += f.a.a.b.b.a.bz(8, this.ihf);
      paramInt = i;
      if (this.BaseResponse != null) {
        paramInt = i + f.a.a.a.lB(9, this.BaseResponse.computeSize());
      }
      i = f.a.a.b.b.a.bz(10, this.Gds);
      int j = f.a.a.b.b.a.p(11, this.xbt);
      AppMethodBeat.o(148653);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.xcN == null)
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
      afi localafi = (afi)paramVarArgs[1];
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
        localafi.xbr = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(148653);
        return 0;
      case 2: 
        localafi.FMu = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(148653);
        return 0;
      case 3: 
        localafi.FIg = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(148653);
        return 0;
      case 5: 
        localafi.FKC = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(148653);
        return 0;
      case 6: 
        localafi.Fwt = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(148653);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localafi.xcN = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(148653);
        return 0;
      case 8: 
        localafi.ihf = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(148653);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new BaseResponse();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localafi.BaseResponse = ((BaseResponse)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(148653);
        return 0;
      case 10: 
        localafi.Gds = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(148653);
        return 0;
      }
      localafi.xbt = ((f.a.a.a.a)localObject1).NPN.zd();
      AppMethodBeat.o(148653);
      return 0;
    }
    AppMethodBeat.o(148653);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afi
 * JD-Core Version:    0.7.0.1
 */