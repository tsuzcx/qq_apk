package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class duk
  extends cwj
{
  public int CreateTime;
  public String FOR;
  public int GaC;
  public int Gdb;
  public int GeT;
  public int Ghl;
  public int GvZ;
  public int ijY;
  public String uvF;
  public String uvG;
  public int xri;
  public long xrk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148662);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(148662);
        throw paramVarArgs;
      }
      if (this.uvG != null) {
        paramVarArgs.d(1, this.uvG);
      }
      if (this.uvF != null) {
        paramVarArgs.d(2, this.uvF);
      }
      paramVarArgs.aS(3, this.GeT);
      paramVarArgs.aS(4, this.GaC);
      paramVarArgs.aS(5, this.CreateTime);
      if (this.FOR != null) {
        paramVarArgs.d(6, this.FOR);
      }
      paramVarArgs.aS(7, this.xri);
      paramVarArgs.aS(8, this.Gdb);
      paramVarArgs.aS(9, this.ijY);
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(10, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(11, this.GvZ);
      paramVarArgs.aZ(12, this.xrk);
      paramVarArgs.aS(13, this.Ghl);
      AppMethodBeat.o(148662);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uvG == null) {
        break label946;
      }
    }
    label946:
    for (paramInt = f.a.a.b.b.a.e(1, this.uvG) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.uvF != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.uvF);
      }
      i = i + f.a.a.b.b.a.bz(3, this.GeT) + f.a.a.b.b.a.bz(4, this.GaC) + f.a.a.b.b.a.bz(5, this.CreateTime);
      paramInt = i;
      if (this.FOR != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FOR);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.xri) + f.a.a.b.b.a.bz(8, this.Gdb) + f.a.a.b.b.a.bz(9, this.ijY);
      paramInt = i;
      if (this.BaseResponse != null) {
        paramInt = i + f.a.a.a.lI(10, this.BaseResponse.computeSize());
      }
      i = f.a.a.b.b.a.bz(11, this.GvZ);
      int j = f.a.a.b.b.a.p(12, this.xrk);
      int k = f.a.a.b.b.a.bz(13, this.Ghl);
      AppMethodBeat.o(148662);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(148662);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148662);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        duk localduk = (duk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148662);
          return -1;
        case 1: 
          localduk.uvG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(148662);
          return 0;
        case 2: 
          localduk.uvF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(148662);
          return 0;
        case 3: 
          localduk.GeT = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148662);
          return 0;
        case 4: 
          localduk.GaC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148662);
          return 0;
        case 5: 
          localduk.CreateTime = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148662);
          return 0;
        case 6: 
          localduk.FOR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(148662);
          return 0;
        case 7: 
          localduk.xri = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148662);
          return 0;
        case 8: 
          localduk.Gdb = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148662);
          return 0;
        case 9: 
          localduk.ijY = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148662);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localduk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148662);
          return 0;
        case 11: 
          localduk.GvZ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148662);
          return 0;
        case 12: 
          localduk.xrk = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(148662);
          return 0;
        }
        localduk.Ghl = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(148662);
        return 0;
      }
      AppMethodBeat.o(148662);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duk
 * JD-Core Version:    0.7.0.1
 */