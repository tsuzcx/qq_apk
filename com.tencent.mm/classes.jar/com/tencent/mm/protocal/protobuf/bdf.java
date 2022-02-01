package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bdf
  extends dpc
{
  public LinkedList<FinderContact> LDz;
  public LinkedList<FinderContact> LKE;
  public SKBuiltinBuffer_t LMX;
  public abo LNc;
  public int LNd;
  public apb LNe;
  public int continueFlag;
  public LinkedList<apf> sKS;
  
  public bdf()
  {
    AppMethodBeat.i(169062);
    this.LDz = new LinkedList();
    this.LKE = new LinkedList();
    this.sKS = new LinkedList();
    AppMethodBeat.o(169062);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169063);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.LNc != null)
      {
        paramVarArgs.ni(2, this.LNc.computeSize());
        this.LNc.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.continueFlag);
      if (this.LMX != null)
      {
        paramVarArgs.ni(4, this.LMX.computeSize());
        this.LMX.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.LDz);
      paramVarArgs.e(6, 8, this.LKE);
      paramVarArgs.e(7, 8, this.sKS);
      paramVarArgs.aM(8, this.LNd);
      if (this.LNe != null)
      {
        paramVarArgs.ni(9, this.LNe.computeSize());
        this.LNe.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169063);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1282;
      }
    }
    label1282:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LNc != null) {
        i = paramInt + g.a.a.a.nh(2, this.LNc.computeSize());
      }
      i += g.a.a.b.b.a.bu(3, this.continueFlag);
      paramInt = i;
      if (this.LMX != null) {
        paramInt = i + g.a.a.a.nh(4, this.LMX.computeSize());
      }
      i = paramInt + g.a.a.a.c(5, 8, this.LDz) + g.a.a.a.c(6, 8, this.LKE) + g.a.a.a.c(7, 8, this.sKS) + g.a.a.b.b.a.bu(8, this.LNd);
      paramInt = i;
      if (this.LNe != null) {
        paramInt = i + g.a.a.a.nh(9, this.LNe.computeSize());
      }
      AppMethodBeat.o(169063);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LDz.clear();
        this.LKE.clear();
        this.sKS.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(169063);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bdf localbdf = (bdf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169063);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbdf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new abo();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((abo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbdf.LNc = ((abo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        case 3: 
          localbdf.continueFlag = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169063);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbdf.LMX = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbdf.LDz.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbdf.LKE.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new apf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((apf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbdf.sKS.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        case 8: 
          localbdf.LNd = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169063);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new apb();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((apb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbdf.LNe = ((apb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169063);
        return 0;
      }
      AppMethodBeat.o(169063);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdf
 * JD-Core Version:    0.7.0.1
 */