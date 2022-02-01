package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cdx
  extends cld
{
  public LinkedList<bty> DRk;
  public String DRl;
  public LinkedList<btv> DRp;
  public boolean DZZ;
  public String dlB;
  public String gIw;
  public boolean jEE;
  public int jEF;
  public int jEG;
  public String jEH;
  public String jEI;
  
  public cdx()
  {
    AppMethodBeat.i(82468);
    this.DRk = new LinkedList();
    this.DRp = new LinkedList();
    AppMethodBeat.o(82468);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82469);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82469);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bg(2, this.DZZ);
      paramVarArgs.e(3, 8, this.DRk);
      if (this.dlB != null) {
        paramVarArgs.d(4, this.dlB);
      }
      if (this.gIw != null) {
        paramVarArgs.d(5, this.gIw);
      }
      if (this.DRl != null) {
        paramVarArgs.d(6, this.DRl);
      }
      paramVarArgs.e(7, 8, this.DRp);
      paramVarArgs.bg(8, this.jEE);
      paramVarArgs.aR(9, this.jEF);
      paramVarArgs.aR(10, this.jEG);
      if (this.jEH != null) {
        paramVarArgs.d(11, this.jEH);
      }
      if (this.jEI != null) {
        paramVarArgs.d(12, this.jEI);
      }
      AppMethodBeat.o(82469);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1118;
      }
    }
    label1118:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (f.a.a.b.b.a.fY(2) + 1) + f.a.a.a.c(3, 8, this.DRk);
      paramInt = i;
      if (this.dlB != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dlB);
      }
      i = paramInt;
      if (this.gIw != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.gIw);
      }
      paramInt = i;
      if (this.DRl != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DRl);
      }
      i = paramInt + f.a.a.a.c(7, 8, this.DRp) + (f.a.a.b.b.a.fY(8) + 1) + f.a.a.b.b.a.bA(9, this.jEF) + f.a.a.b.b.a.bA(10, this.jEG);
      paramInt = i;
      if (this.jEH != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.jEH);
      }
      i = paramInt;
      if (this.jEI != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.jEI);
      }
      AppMethodBeat.o(82469);
      return i;
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
          AppMethodBeat.o(82469);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82469);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cdx localcdx = (cdx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82469);
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
            localcdx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82469);
          return 0;
        case 2: 
          localcdx.DZZ = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(82469);
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
            localcdx.DRk.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82469);
          return 0;
        case 4: 
          localcdx.dlB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82469);
          return 0;
        case 5: 
          localcdx.gIw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82469);
          return 0;
        case 6: 
          localcdx.DRl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82469);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new btv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((btv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdx.DRp.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82469);
          return 0;
        case 8: 
          localcdx.jEE = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(82469);
          return 0;
        case 9: 
          localcdx.jEF = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(82469);
          return 0;
        case 10: 
          localcdx.jEG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(82469);
          return 0;
        case 11: 
          localcdx.jEH = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82469);
          return 0;
        }
        localcdx.jEI = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(82469);
        return 0;
      }
      AppMethodBeat.o(82469);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdx
 * JD-Core Version:    0.7.0.1
 */