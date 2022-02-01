package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class blr
  extends cvp
{
  public String FBR;
  public String FMf;
  public efu FWe;
  public String GFT;
  public int GFU;
  public String GFV;
  public LinkedList<cbz> GFW;
  public int GFX;
  public String GFY;
  public String GFZ;
  public int GGa;
  public String GGb;
  public int GGc;
  public int GGd;
  public cbz GGe;
  public String dxD;
  public int nuE;
  
  public blr()
  {
    AppMethodBeat.i(123591);
    this.GFW = new LinkedList();
    AppMethodBeat.o(123591);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123592);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123592);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FWe != null)
      {
        paramVarArgs.lC(2, this.FWe.computeSize());
        this.FWe.writeFields(paramVarArgs);
      }
      if (this.GFT != null) {
        paramVarArgs.d(3, this.GFT);
      }
      paramVarArgs.aS(4, this.GFU);
      paramVarArgs.aS(5, this.nuE);
      if (this.GFV != null) {
        paramVarArgs.d(6, this.GFV);
      }
      paramVarArgs.e(7, 8, this.GFW);
      paramVarArgs.aS(8, this.GFX);
      if (this.GFY != null) {
        paramVarArgs.d(9, this.GFY);
      }
      if (this.GFZ != null) {
        paramVarArgs.d(10, this.GFZ);
      }
      paramVarArgs.aS(11, this.GGa);
      if (this.dxD != null) {
        paramVarArgs.d(12, this.dxD);
      }
      if (this.FBR != null) {
        paramVarArgs.d(13, this.FBR);
      }
      if (this.FMf != null) {
        paramVarArgs.d(14, this.FMf);
      }
      if (this.GGb != null) {
        paramVarArgs.d(15, this.GGb);
      }
      paramVarArgs.aS(16, this.GGc);
      paramVarArgs.aS(17, this.GGd);
      if (this.GGe != null)
      {
        paramVarArgs.lC(18, this.GGe.computeSize());
        this.GGe.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123592);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1570;
      }
    }
    label1570:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FWe != null) {
        paramInt = i + f.a.a.a.lB(2, this.FWe.computeSize());
      }
      i = paramInt;
      if (this.GFT != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GFT);
      }
      i = i + f.a.a.b.b.a.bz(4, this.GFU) + f.a.a.b.b.a.bz(5, this.nuE);
      paramInt = i;
      if (this.GFV != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GFV);
      }
      i = paramInt + f.a.a.a.c(7, 8, this.GFW) + f.a.a.b.b.a.bz(8, this.GFX);
      paramInt = i;
      if (this.GFY != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GFY);
      }
      i = paramInt;
      if (this.GFZ != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.GFZ);
      }
      i += f.a.a.b.b.a.bz(11, this.GGa);
      paramInt = i;
      if (this.dxD != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.dxD);
      }
      i = paramInt;
      if (this.FBR != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.FBR);
      }
      paramInt = i;
      if (this.FMf != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.FMf);
      }
      i = paramInt;
      if (this.GGb != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.GGb);
      }
      i = i + f.a.a.b.b.a.bz(16, this.GGc) + f.a.a.b.b.a.bz(17, this.GGd);
      paramInt = i;
      if (this.GGe != null) {
        paramInt = i + f.a.a.a.lB(18, this.GGe.computeSize());
      }
      AppMethodBeat.o(123592);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GFW.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123592);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123592);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        blr localblr = (blr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123592);
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
            localblr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123592);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new efu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((efu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localblr.FWe = ((efu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123592);
          return 0;
        case 3: 
          localblr.GFT = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 4: 
          localblr.GFU = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123592);
          return 0;
        case 5: 
          localblr.nuE = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123592);
          return 0;
        case 6: 
          localblr.GFV = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cbz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cbz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localblr.GFW.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123592);
          return 0;
        case 8: 
          localblr.GFX = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123592);
          return 0;
        case 9: 
          localblr.GFY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 10: 
          localblr.GFZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 11: 
          localblr.GGa = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123592);
          return 0;
        case 12: 
          localblr.dxD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 13: 
          localblr.FBR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 14: 
          localblr.FMf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 15: 
          localblr.GGb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 16: 
          localblr.GGc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123592);
          return 0;
        case 17: 
          localblr.GGd = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123592);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cbz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cbz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localblr.GGe = ((cbz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123592);
        return 0;
      }
      AppMethodBeat.o(123592);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blr
 * JD-Core Version:    0.7.0.1
 */