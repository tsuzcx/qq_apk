package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cne
  extends cld
{
  public String CzB;
  public LinkedList<bty> DRk;
  public String DRl;
  public boolean DRm;
  public boolean DRn;
  public boolean DRo;
  public LinkedList<btv> DRp;
  public boolean DRq;
  public String EhO;
  public String gIw;
  public boolean jEE;
  public int jEF;
  public int jEG;
  public String jEH;
  public String jEI;
  
  public cne()
  {
    AppMethodBeat.i(82474);
    this.DRk = new LinkedList();
    this.DRp = new LinkedList();
    AppMethodBeat.o(82474);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82475);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82475);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.DRk);
      if (this.gIw != null) {
        paramVarArgs.d(4, this.gIw);
      }
      if (this.DRl != null) {
        paramVarArgs.d(5, this.DRl);
      }
      if (this.CzB != null) {
        paramVarArgs.d(6, this.CzB);
      }
      paramVarArgs.bg(8, this.DRm);
      paramVarArgs.bg(9, this.DRn);
      paramVarArgs.bg(10, this.DRo);
      paramVarArgs.e(11, 8, this.DRp);
      paramVarArgs.bg(12, this.DRq);
      paramVarArgs.bg(13, this.jEE);
      paramVarArgs.aR(14, this.jEF);
      paramVarArgs.aR(15, this.jEG);
      if (this.jEH != null) {
        paramVarArgs.d(16, this.jEH);
      }
      if (this.jEI != null) {
        paramVarArgs.d(17, this.jEI);
      }
      if (this.EhO != null) {
        paramVarArgs.d(21, this.EhO);
      }
      AppMethodBeat.o(82475);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1326;
      }
    }
    label1326:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(3, 8, this.DRk);
      paramInt = i;
      if (this.gIw != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.gIw);
      }
      i = paramInt;
      if (this.DRl != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DRl);
      }
      paramInt = i;
      if (this.CzB != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CzB);
      }
      i = paramInt + (f.a.a.b.b.a.fY(8) + 1) + (f.a.a.b.b.a.fY(9) + 1) + (f.a.a.b.b.a.fY(10) + 1) + f.a.a.a.c(11, 8, this.DRp) + (f.a.a.b.b.a.fY(12) + 1) + (f.a.a.b.b.a.fY(13) + 1) + f.a.a.b.b.a.bA(14, this.jEF) + f.a.a.b.b.a.bA(15, this.jEG);
      paramInt = i;
      if (this.jEH != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.jEH);
      }
      i = paramInt;
      if (this.jEI != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.jEI);
      }
      paramInt = i;
      if (this.EhO != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.EhO);
      }
      AppMethodBeat.o(82475);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DRk.clear();
        this.DRp.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(82475);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82475);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cne localcne = (cne)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 2: 
        case 7: 
        case 18: 
        case 19: 
        case 20: 
        default: 
          AppMethodBeat.o(82475);
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
            localcne.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82475);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bty();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bty)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcne.DRk.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82475);
          return 0;
        case 4: 
          localcne.gIw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82475);
          return 0;
        case 5: 
          localcne.DRl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82475);
          return 0;
        case 6: 
          localcne.CzB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82475);
          return 0;
        case 8: 
          localcne.DRm = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(82475);
          return 0;
        case 9: 
          localcne.DRn = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(82475);
          return 0;
        case 10: 
          localcne.DRo = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(82475);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new btv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((btv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcne.DRp.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82475);
          return 0;
        case 12: 
          localcne.DRq = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(82475);
          return 0;
        case 13: 
          localcne.jEE = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(82475);
          return 0;
        case 14: 
          localcne.jEF = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(82475);
          return 0;
        case 15: 
          localcne.jEG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(82475);
          return 0;
        case 16: 
          localcne.jEH = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82475);
          return 0;
        case 17: 
          localcne.jEI = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82475);
          return 0;
        }
        localcne.EhO = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(82475);
        return 0;
      }
      AppMethodBeat.o(82475);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cne
 * JD-Core Version:    0.7.0.1
 */