package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class afr
  extends cwj
{
  public String FOR;
  public int GaC;
  public int Gdb;
  public int GeT;
  public int GvZ;
  public int ijY;
  public int xri;
  public long xrk;
  public SKBuiltinBuffer_t xsE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148653);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.xsE == null)
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
      paramVarArgs.aS(1, this.xri);
      paramVarArgs.aS(2, this.GeT);
      paramVarArgs.aS(3, this.GaC);
      paramVarArgs.aS(5, this.Gdb);
      if (this.FOR != null) {
        paramVarArgs.d(6, this.FOR);
      }
      if (this.xsE != null)
      {
        paramVarArgs.lJ(7, this.xsE.computeSize());
        this.xsE.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.ijY);
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(9, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(10, this.GvZ);
      paramVarArgs.aZ(11, this.xrk);
      AppMethodBeat.o(148653);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.xri) + 0 + f.a.a.b.b.a.bz(2, this.GeT) + f.a.a.b.b.a.bz(3, this.GaC) + f.a.a.b.b.a.bz(5, this.Gdb);
      paramInt = i;
      if (this.FOR != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FOR);
      }
      i = paramInt;
      if (this.xsE != null) {
        i = paramInt + f.a.a.a.lI(7, this.xsE.computeSize());
      }
      i += f.a.a.b.b.a.bz(8, this.ijY);
      paramInt = i;
      if (this.BaseResponse != null) {
        paramInt = i + f.a.a.a.lI(9, this.BaseResponse.computeSize());
      }
      i = f.a.a.b.b.a.bz(10, this.GvZ);
      int j = f.a.a.b.b.a.p(11, this.xrk);
      AppMethodBeat.o(148653);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.xsE == null)
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
      afr localafr = (afr)paramVarArgs[1];
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
        localafr.xri = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(148653);
        return 0;
      case 2: 
        localafr.GeT = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(148653);
        return 0;
      case 3: 
        localafr.GaC = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(148653);
        return 0;
      case 5: 
        localafr.Gdb = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(148653);
        return 0;
      case 6: 
        localafr.FOR = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(148653);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localafr.xsE = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(148653);
        return 0;
      case 8: 
        localafr.ijY = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(148653);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new BaseResponse();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localafr.BaseResponse = ((BaseResponse)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(148653);
        return 0;
      case 10: 
        localafr.GvZ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(148653);
        return 0;
      }
      localafr.xrk = ((f.a.a.a.a)localObject1).OmT.zd();
      AppMethodBeat.o(148653);
      return 0;
    }
    AppMethodBeat.o(148653);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afr
 * JD-Core Version:    0.7.0.1
 */