package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dlk
  extends cld
{
  public int CCF;
  public LinkedList<dlh> CCG;
  public int DdZ;
  public long Dea;
  public int EBA;
  public int EBB;
  public int EBC;
  public int EBc;
  public dmv EBd;
  public int EBe;
  public int EBf;
  public int EBg;
  public int EBh;
  public SKBuiltinBuffer_t EBi;
  public int EBn;
  public LinkedList<dmx> EBo;
  public int EBp;
  public int EBq;
  public int EBr;
  public int EBs;
  public int EBt;
  public int EBu;
  public int EBv;
  public int EBw;
  public int EBx;
  public int EBy;
  public int EBz;
  
  public dlk()
  {
    AppMethodBeat.i(115865);
    this.CCG = new LinkedList();
    this.EBo = new LinkedList();
    AppMethodBeat.o(115865);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115866);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115866);
        throw paramVarArgs;
      }
      if (this.EBd == null)
      {
        paramVarArgs = new b("Not all required fields were included: RelayData");
        AppMethodBeat.o(115866);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.CCF);
      paramVarArgs.e(3, 8, this.CCG);
      paramVarArgs.aR(4, this.DdZ);
      paramVarArgs.aG(5, this.Dea);
      paramVarArgs.aR(6, this.EBc);
      if (this.EBd != null)
      {
        paramVarArgs.kX(7, this.EBd.computeSize());
        this.EBd.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.EBn);
      paramVarArgs.e(9, 8, this.EBo);
      paramVarArgs.aR(10, this.EBp);
      paramVarArgs.aR(11, this.EBq);
      paramVarArgs.aR(12, this.EBr);
      paramVarArgs.aR(13, this.EBs);
      paramVarArgs.aR(14, this.EBt);
      paramVarArgs.aR(15, this.EBu);
      paramVarArgs.aR(16, this.EBe);
      paramVarArgs.aR(17, this.EBv);
      paramVarArgs.aR(18, this.EBw);
      paramVarArgs.aR(19, this.EBf);
      paramVarArgs.aR(20, this.EBx);
      paramVarArgs.aR(21, this.EBy);
      paramVarArgs.aR(22, this.EBz);
      paramVarArgs.aR(23, this.EBA);
      paramVarArgs.aR(24, this.EBg);
      paramVarArgs.aR(25, this.EBh);
      paramVarArgs.aR(26, this.EBB);
      paramVarArgs.aR(27, this.EBC);
      if (this.EBi != null)
      {
        paramVarArgs.kX(28, this.EBi.computeSize());
        this.EBi.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115866);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2006;
      }
    }
    label2006:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.CCF) + f.a.a.a.c(3, 8, this.CCG) + f.a.a.b.b.a.bA(4, this.DdZ) + f.a.a.b.b.a.q(5, this.Dea) + f.a.a.b.b.a.bA(6, this.EBc);
      paramInt = i;
      if (this.EBd != null) {
        paramInt = i + f.a.a.a.kW(7, this.EBd.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(8, this.EBn) + f.a.a.a.c(9, 8, this.EBo) + f.a.a.b.b.a.bA(10, this.EBp) + f.a.a.b.b.a.bA(11, this.EBq) + f.a.a.b.b.a.bA(12, this.EBr) + f.a.a.b.b.a.bA(13, this.EBs) + f.a.a.b.b.a.bA(14, this.EBt) + f.a.a.b.b.a.bA(15, this.EBu) + f.a.a.b.b.a.bA(16, this.EBe) + f.a.a.b.b.a.bA(17, this.EBv) + f.a.a.b.b.a.bA(18, this.EBw) + f.a.a.b.b.a.bA(19, this.EBf) + f.a.a.b.b.a.bA(20, this.EBx) + f.a.a.b.b.a.bA(21, this.EBy) + f.a.a.b.b.a.bA(22, this.EBz) + f.a.a.b.b.a.bA(23, this.EBA) + f.a.a.b.b.a.bA(24, this.EBg) + f.a.a.b.b.a.bA(25, this.EBh) + f.a.a.b.b.a.bA(26, this.EBB) + f.a.a.b.b.a.bA(27, this.EBC);
      paramInt = i;
      if (this.EBi != null) {
        paramInt = i + f.a.a.a.kW(28, this.EBi.computeSize());
      }
      AppMethodBeat.o(115866);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CCG.clear();
        this.EBo.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(115866);
          throw paramVarArgs;
        }
        if (this.EBd == null)
        {
          paramVarArgs = new b("Not all required fields were included: RelayData");
          AppMethodBeat.o(115866);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115866);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dlk localdlk = (dlk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115866);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115866);
          return 0;
        case 2: 
          localdlk.CCF = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115866);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dlh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dlh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlk.CCG.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115866);
          return 0;
        case 4: 
          localdlk.DdZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115866);
          return 0;
        case 5: 
          localdlk.Dea = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(115866);
          return 0;
        case 6: 
          localdlk.EBc = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115866);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dmv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dmv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlk.EBd = ((dmv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115866);
          return 0;
        case 8: 
          localdlk.EBn = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115866);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dmx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dmx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlk.EBo.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115866);
          return 0;
        case 10: 
          localdlk.EBp = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115866);
          return 0;
        case 11: 
          localdlk.EBq = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115866);
          return 0;
        case 12: 
          localdlk.EBr = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115866);
          return 0;
        case 13: 
          localdlk.EBs = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115866);
          return 0;
        case 14: 
          localdlk.EBt = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115866);
          return 0;
        case 15: 
          localdlk.EBu = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115866);
          return 0;
        case 16: 
          localdlk.EBe = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115866);
          return 0;
        case 17: 
          localdlk.EBv = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115866);
          return 0;
        case 18: 
          localdlk.EBw = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115866);
          return 0;
        case 19: 
          localdlk.EBf = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115866);
          return 0;
        case 20: 
          localdlk.EBx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115866);
          return 0;
        case 21: 
          localdlk.EBy = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115866);
          return 0;
        case 22: 
          localdlk.EBz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115866);
          return 0;
        case 23: 
          localdlk.EBA = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115866);
          return 0;
        case 24: 
          localdlk.EBg = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115866);
          return 0;
        case 25: 
          localdlk.EBh = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115866);
          return 0;
        case 26: 
          localdlk.EBB = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115866);
          return 0;
        case 27: 
          localdlk.EBC = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115866);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdlk.EBi = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115866);
        return 0;
      }
      AppMethodBeat.o(115866);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlk
 * JD-Core Version:    0.7.0.1
 */