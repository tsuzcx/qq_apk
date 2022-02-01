package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dta
  extends cvw
{
  public int FOQ;
  public String HYL;
  public String MD5;
  public String ikm;
  public String nIJ;
  public int nJA;
  public int xsB;
  public int xsC;
  public int xsD;
  public SKBuiltinBuffer_t xsE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32484);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.xsE == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(32484);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ikm != null) {
        paramVarArgs.d(2, this.ikm);
      }
      paramVarArgs.aS(3, this.FOQ);
      if (this.HYL != null) {
        paramVarArgs.d(4, this.HYL);
      }
      if (this.nIJ != null) {
        paramVarArgs.d(5, this.nIJ);
      }
      paramVarArgs.aS(6, this.xsB);
      paramVarArgs.aS(7, this.xsC);
      paramVarArgs.aS(8, this.xsD);
      if (this.xsE != null)
      {
        paramVarArgs.lJ(9, this.xsE.computeSize());
        this.xsE.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(10, this.nJA);
      if (this.MD5 != null) {
        paramVarArgs.d(11, this.MD5);
      }
      AppMethodBeat.o(32484);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label999;
      }
    }
    label999:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ikm != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ikm);
      }
      i += f.a.a.b.b.a.bz(3, this.FOQ);
      paramInt = i;
      if (this.HYL != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HYL);
      }
      i = paramInt;
      if (this.nIJ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.nIJ);
      }
      i = i + f.a.a.b.b.a.bz(6, this.xsB) + f.a.a.b.b.a.bz(7, this.xsC) + f.a.a.b.b.a.bz(8, this.xsD);
      paramInt = i;
      if (this.xsE != null) {
        paramInt = i + f.a.a.a.lI(9, this.xsE.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(10, this.nJA);
      paramInt = i;
      if (this.MD5 != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.MD5);
      }
      AppMethodBeat.o(32484);
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
          AppMethodBeat.o(32484);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32484);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dta localdta = (dta)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32484);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdta.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32484);
          return 0;
        case 2: 
          localdta.ikm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32484);
          return 0;
        case 3: 
          localdta.FOQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32484);
          return 0;
        case 4: 
          localdta.HYL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32484);
          return 0;
        case 5: 
          localdta.nIJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32484);
          return 0;
        case 6: 
          localdta.xsB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32484);
          return 0;
        case 7: 
          localdta.xsC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32484);
          return 0;
        case 8: 
          localdta.xsD = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32484);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdta.xsE = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32484);
          return 0;
        case 10: 
          localdta.nJA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32484);
          return 0;
        }
        localdta.MD5 = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32484);
        return 0;
      }
      AppMethodBeat.o(32484);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dta
 * JD-Core Version:    0.7.0.1
 */