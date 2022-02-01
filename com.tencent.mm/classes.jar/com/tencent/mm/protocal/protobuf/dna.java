package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dna
  extends cld
{
  public int DZg;
  public int DdZ;
  public long Dea;
  public LinkedList<dlh> EBM;
  public int EDE;
  public LinkedList<dlh> EDF;
  public int EDG;
  public LinkedList<dlh> EDH;
  public int EDI;
  public int EDJ;
  public int EDK;
  public dmu EDL;
  
  public dna()
  {
    AppMethodBeat.i(115907);
    this.EDF = new LinkedList();
    this.EDH = new LinkedList();
    this.EBM = new LinkedList();
    AppMethodBeat.o(115907);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115908);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115908);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DdZ);
      paramVarArgs.aR(3, this.EDE);
      paramVarArgs.e(4, 8, this.EDF);
      paramVarArgs.aR(5, this.EDG);
      paramVarArgs.e(6, 8, this.EDH);
      paramVarArgs.aG(7, this.Dea);
      paramVarArgs.aR(8, this.DZg);
      paramVarArgs.aR(9, this.EDI);
      paramVarArgs.e(10, 8, this.EBM);
      paramVarArgs.aR(11, this.EDJ);
      paramVarArgs.aR(12, this.EDK);
      if (this.EDL != null)
      {
        paramVarArgs.kX(13, this.EDL.computeSize());
        this.EDL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115908);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1278;
      }
    }
    label1278:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.DdZ) + f.a.a.b.b.a.bA(3, this.EDE) + f.a.a.a.c(4, 8, this.EDF) + f.a.a.b.b.a.bA(5, this.EDG) + f.a.a.a.c(6, 8, this.EDH) + f.a.a.b.b.a.q(7, this.Dea) + f.a.a.b.b.a.bA(8, this.DZg) + f.a.a.b.b.a.bA(9, this.EDI) + f.a.a.a.c(10, 8, this.EBM) + f.a.a.b.b.a.bA(11, this.EDJ) + f.a.a.b.b.a.bA(12, this.EDK);
      paramInt = i;
      if (this.EDL != null) {
        paramInt = i + f.a.a.a.kW(13, this.EDL.computeSize());
      }
      AppMethodBeat.o(115908);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EDF.clear();
        this.EDH.clear();
        this.EBM.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(115908);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115908);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dna localdna = (dna)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115908);
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
            localdna.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115908);
          return 0;
        case 2: 
          localdna.DdZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115908);
          return 0;
        case 3: 
          localdna.EDE = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115908);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dlh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dlh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdna.EDF.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115908);
          return 0;
        case 5: 
          localdna.EDG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115908);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dlh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dlh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdna.EDH.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115908);
          return 0;
        case 7: 
          localdna.Dea = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(115908);
          return 0;
        case 8: 
          localdna.DZg = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115908);
          return 0;
        case 9: 
          localdna.EDI = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115908);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dlh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dlh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdna.EBM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115908);
          return 0;
        case 11: 
          localdna.EDJ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115908);
          return 0;
        case 12: 
          localdna.EDK = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115908);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dmu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dmu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdna.EDL = ((dmu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115908);
        return 0;
      }
      AppMethodBeat.o(115908);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dna
 * JD-Core Version:    0.7.0.1
 */