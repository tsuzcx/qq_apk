package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ccp
  extends cvp
{
  public rx FED;
  public rx FEE;
  public rx FEF;
  public bor FEc;
  public pv FEd;
  public ccc FEe;
  public String FqI;
  public String Fsg;
  public int Fsj;
  public String Fsm;
  public String Fsn;
  public int Fso;
  public String Fsp;
  public String Fzb;
  public deh Fze;
  public int Fzj;
  public String GDw;
  public SKBuiltinBuffer_t GDz;
  public String GWE;
  public int GWF;
  public String GWG;
  public int GWH;
  public cku GWI;
  public int GWJ;
  public String GWK;
  public String GWL;
  public czc GWM;
  public int nDG;
  public String nDo;
  public int qdX;
  public String qdZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133185);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(133185);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.qdX);
      if (this.FqI != null) {
        paramVarArgs.d(3, this.FqI);
      }
      if (this.Fsm != null) {
        paramVarArgs.d(4, this.Fsm);
      }
      if (this.Fsn != null) {
        paramVarArgs.d(5, this.Fsn);
      }
      if (this.GWE != null) {
        paramVarArgs.d(6, this.GWE);
      }
      if (this.Fsg != null) {
        paramVarArgs.d(7, this.Fsg);
      }
      paramVarArgs.aS(8, this.Fso);
      paramVarArgs.aS(9, this.GWF);
      if (this.GWG != null) {
        paramVarArgs.d(10, this.GWG);
      }
      if (this.FEd != null)
      {
        paramVarArgs.lC(14, this.FEd.computeSize());
        this.FEd.writeFields(paramVarArgs);
      }
      if (this.Fsp != null) {
        paramVarArgs.d(15, this.Fsp);
      }
      if (this.nDo != null) {
        paramVarArgs.d(16, this.nDo);
      }
      paramVarArgs.aS(17, this.nDG);
      if (this.FEe != null)
      {
        paramVarArgs.lC(18, this.FEe.computeSize());
        this.FEe.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(19, this.GWH);
      paramVarArgs.aS(20, this.Fsj);
      if (this.Fzb != null) {
        paramVarArgs.d(21, this.Fzb);
      }
      if (this.GWI != null)
      {
        paramVarArgs.lC(22, this.GWI.computeSize());
        this.GWI.writeFields(paramVarArgs);
      }
      if (this.qdZ != null) {
        paramVarArgs.d(23, this.qdZ);
      }
      paramVarArgs.aS(24, this.GWJ);
      if (this.FEc != null)
      {
        paramVarArgs.lC(25, this.FEc.computeSize());
        this.FEc.writeFields(paramVarArgs);
      }
      if (this.GWK != null) {
        paramVarArgs.d(26, this.GWK);
      }
      if (this.FED != null)
      {
        paramVarArgs.lC(27, this.FED.computeSize());
        this.FED.writeFields(paramVarArgs);
      }
      if (this.GWL != null) {
        paramVarArgs.d(28, this.GWL);
      }
      if (this.GDw != null) {
        paramVarArgs.d(29, this.GDw);
      }
      if (this.GDz != null)
      {
        paramVarArgs.lC(30, this.GDz.computeSize());
        this.GDz.writeFields(paramVarArgs);
      }
      if (this.Fze != null)
      {
        paramVarArgs.lC(31, this.Fze.computeSize());
        this.Fze.writeFields(paramVarArgs);
      }
      if (this.FEE != null)
      {
        paramVarArgs.lC(32, this.FEE.computeSize());
        this.FEE.writeFields(paramVarArgs);
      }
      if (this.FEF != null)
      {
        paramVarArgs.lC(33, this.FEF.computeSize());
        this.FEF.writeFields(paramVarArgs);
      }
      if (this.GWM != null)
      {
        paramVarArgs.lC(34, this.GWM.computeSize());
        this.GWM.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(35, this.Fzj);
      AppMethodBeat.o(133185);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label3094;
      }
    }
    label3094:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.qdX);
      paramInt = i;
      if (this.FqI != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FqI);
      }
      i = paramInt;
      if (this.Fsm != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Fsm);
      }
      paramInt = i;
      if (this.Fsn != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Fsn);
      }
      i = paramInt;
      if (this.GWE != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.GWE);
      }
      paramInt = i;
      if (this.Fsg != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Fsg);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.Fso) + f.a.a.b.b.a.bz(9, this.GWF);
      paramInt = i;
      if (this.GWG != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.GWG);
      }
      i = paramInt;
      if (this.FEd != null) {
        i = paramInt + f.a.a.a.lB(14, this.FEd.computeSize());
      }
      paramInt = i;
      if (this.Fsp != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.Fsp);
      }
      i = paramInt;
      if (this.nDo != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.nDo);
      }
      i += f.a.a.b.b.a.bz(17, this.nDG);
      paramInt = i;
      if (this.FEe != null) {
        paramInt = i + f.a.a.a.lB(18, this.FEe.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(19, this.GWH) + f.a.a.b.b.a.bz(20, this.Fsj);
      paramInt = i;
      if (this.Fzb != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.Fzb);
      }
      i = paramInt;
      if (this.GWI != null) {
        i = paramInt + f.a.a.a.lB(22, this.GWI.computeSize());
      }
      paramInt = i;
      if (this.qdZ != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.qdZ);
      }
      i = paramInt + f.a.a.b.b.a.bz(24, this.GWJ);
      paramInt = i;
      if (this.FEc != null) {
        paramInt = i + f.a.a.a.lB(25, this.FEc.computeSize());
      }
      i = paramInt;
      if (this.GWK != null) {
        i = paramInt + f.a.a.b.b.a.e(26, this.GWK);
      }
      paramInt = i;
      if (this.FED != null) {
        paramInt = i + f.a.a.a.lB(27, this.FED.computeSize());
      }
      i = paramInt;
      if (this.GWL != null) {
        i = paramInt + f.a.a.b.b.a.e(28, this.GWL);
      }
      paramInt = i;
      if (this.GDw != null) {
        paramInt = i + f.a.a.b.b.a.e(29, this.GDw);
      }
      i = paramInt;
      if (this.GDz != null) {
        i = paramInt + f.a.a.a.lB(30, this.GDz.computeSize());
      }
      paramInt = i;
      if (this.Fze != null) {
        paramInt = i + f.a.a.a.lB(31, this.Fze.computeSize());
      }
      i = paramInt;
      if (this.FEE != null) {
        i = paramInt + f.a.a.a.lB(32, this.FEE.computeSize());
      }
      paramInt = i;
      if (this.FEF != null) {
        paramInt = i + f.a.a.a.lB(33, this.FEF.computeSize());
      }
      i = paramInt;
      if (this.GWM != null) {
        i = paramInt + f.a.a.a.lB(34, this.GWM.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(35, this.Fzj);
      AppMethodBeat.o(133185);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(133185);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133185);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ccp localccp = (ccp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 11: 
        case 12: 
        case 13: 
        default: 
          AppMethodBeat.o(133185);
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
            localccp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 2: 
          localccp.qdX = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133185);
          return 0;
        case 3: 
          localccp.FqI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 4: 
          localccp.Fsm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 5: 
          localccp.Fsn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 6: 
          localccp.GWE = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 7: 
          localccp.Fsg = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 8: 
          localccp.Fso = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133185);
          return 0;
        case 9: 
          localccp.GWF = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133185);
          return 0;
        case 10: 
          localccp.GWG = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localccp.FEd = ((pv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 15: 
          localccp.Fsp = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 16: 
          localccp.nDo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 17: 
          localccp.nDG = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133185);
          return 0;
        case 18: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localccp.FEe = ((ccc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 19: 
          localccp.GWH = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133185);
          return 0;
        case 20: 
          localccp.Fsj = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133185);
          return 0;
        case 21: 
          localccp.Fzb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cku();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cku)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localccp.GWI = ((cku)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 23: 
          localccp.qdZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 24: 
          localccp.GWJ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133185);
          return 0;
        case 25: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bor();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bor)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localccp.FEc = ((bor)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 26: 
          localccp.GWK = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 27: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localccp.FED = ((rx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 28: 
          localccp.GWL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 29: 
          localccp.GDw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 30: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localccp.GDz = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 31: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new deh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((deh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localccp.Fze = ((deh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 32: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localccp.FEE = ((rx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 33: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localccp.FEF = ((rx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 34: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new czc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((czc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localccp.GWM = ((czc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        }
        localccp.Fzj = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(133185);
        return 0;
      }
      AppMethodBeat.o(133185);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccp
 * JD-Core Version:    0.7.0.1
 */