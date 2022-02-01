package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class duj
  extends cvw
{
  public String FNL;
  public String FOR;
  public int GaC;
  public int Gdb;
  public int GeT;
  public String Ghk;
  public int GvZ;
  public int GwZ;
  public int HZY;
  public int HZZ;
  public int HlN;
  public int ijY;
  public String uvF;
  public String uvG;
  public int xri;
  public long xrk;
  public SKBuiltinBuffer_t xsE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148661);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.xsE == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(148661);
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
      if (this.FOR != null) {
        paramVarArgs.d(5, this.FOR);
      }
      paramVarArgs.aS(6, this.xri);
      paramVarArgs.aS(7, this.Gdb);
      if (this.xsE != null)
      {
        paramVarArgs.lJ(8, this.xsE.computeSize());
        this.xsE.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(9, this.ijY);
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(10, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(11, this.GvZ);
      if (this.FNL != null) {
        paramVarArgs.d(12, this.FNL);
      }
      paramVarArgs.aS(13, this.HlN);
      paramVarArgs.aS(14, this.HZY);
      paramVarArgs.aS(15, this.HZZ);
      paramVarArgs.aZ(16, this.xrk);
      paramVarArgs.aS(17, this.GwZ);
      if (this.Ghk != null) {
        paramVarArgs.d(19, this.Ghk);
      }
      AppMethodBeat.o(148661);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uvG == null) {
        break label1314;
      }
    }
    label1314:
    for (paramInt = f.a.a.b.b.a.e(1, this.uvG) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.uvF != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.uvF);
      }
      i = i + f.a.a.b.b.a.bz(3, this.GeT) + f.a.a.b.b.a.bz(4, this.GaC);
      paramInt = i;
      if (this.FOR != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FOR);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.xri) + f.a.a.b.b.a.bz(7, this.Gdb);
      paramInt = i;
      if (this.xsE != null) {
        paramInt = i + f.a.a.a.lI(8, this.xsE.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.ijY);
      paramInt = i;
      if (this.BaseRequest != null) {
        paramInt = i + f.a.a.a.lI(10, this.BaseRequest.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.GvZ);
      paramInt = i;
      if (this.FNL != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.FNL);
      }
      i = paramInt + f.a.a.b.b.a.bz(13, this.HlN) + f.a.a.b.b.a.bz(14, this.HZY) + f.a.a.b.b.a.bz(15, this.HZZ) + f.a.a.b.b.a.p(16, this.xrk) + f.a.a.b.b.a.bz(17, this.GwZ);
      paramInt = i;
      if (this.Ghk != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.Ghk);
      }
      AppMethodBeat.o(148661);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.xsE == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(148661);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148661);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        duj localduj = (duj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 18: 
        default: 
          AppMethodBeat.o(148661);
          return -1;
        case 1: 
          localduj.uvG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(148661);
          return 0;
        case 2: 
          localduj.uvF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(148661);
          return 0;
        case 3: 
          localduj.GeT = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148661);
          return 0;
        case 4: 
          localduj.GaC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148661);
          return 0;
        case 5: 
          localduj.FOR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(148661);
          return 0;
        case 6: 
          localduj.xri = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148661);
          return 0;
        case 7: 
          localduj.Gdb = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148661);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localduj.xsE = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148661);
          return 0;
        case 9: 
          localduj.ijY = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148661);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localduj.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148661);
          return 0;
        case 11: 
          localduj.GvZ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148661);
          return 0;
        case 12: 
          localduj.FNL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(148661);
          return 0;
        case 13: 
          localduj.HlN = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148661);
          return 0;
        case 14: 
          localduj.HZY = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148661);
          return 0;
        case 15: 
          localduj.HZZ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148661);
          return 0;
        case 16: 
          localduj.xrk = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(148661);
          return 0;
        case 17: 
          localduj.GwZ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148661);
          return 0;
        }
        localduj.Ghk = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(148661);
        return 0;
      }
      AppMethodBeat.o(148661);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duj
 * JD-Core Version:    0.7.0.1
 */