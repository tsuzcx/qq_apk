package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dsz
  extends dpc
{
  public LinkedList<fei> KKx;
  public boolean LYI;
  public int MJT;
  public int MRg;
  public fdz MVd;
  public int MVe;
  public com.tencent.mm.bw.b MVf;
  public String MVg;
  public String Title;
  public int oTY;
  public int oTz;
  public int oUv;
  public int rBL;
  
  public dsz()
  {
    AppMethodBeat.i(117922);
    this.KKx = new LinkedList();
    AppMethodBeat.o(117922);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117923);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(117923);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.oTY);
      paramVarArgs.aM(3, this.oUv);
      paramVarArgs.aM(4, this.MJT);
      paramVarArgs.aM(5, this.oTz);
      if (this.Title != null) {
        paramVarArgs.e(6, this.Title);
      }
      if (this.MVd != null)
      {
        paramVarArgs.ni(7, this.MVd.computeSize());
        this.MVd.writeFields(paramVarArgs);
      }
      paramVarArgs.e(8, 8, this.KKx);
      paramVarArgs.aM(9, this.MRg);
      paramVarArgs.aM(10, this.MVe);
      paramVarArgs.cc(11, this.LYI);
      if (this.MVf != null) {
        paramVarArgs.c(12, this.MVf);
      }
      paramVarArgs.aM(13, this.rBL);
      if (this.MVg != null) {
        paramVarArgs.e(14, this.MVg);
      }
      AppMethodBeat.o(117923);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1190;
      }
    }
    label1190:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.oTY) + g.a.a.b.b.a.bu(3, this.oUv) + g.a.a.b.b.a.bu(4, this.MJT) + g.a.a.b.b.a.bu(5, this.oTz);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Title);
      }
      i = paramInt;
      if (this.MVd != null) {
        i = paramInt + g.a.a.a.nh(7, this.MVd.computeSize());
      }
      i = i + g.a.a.a.c(8, 8, this.KKx) + g.a.a.b.b.a.bu(9, this.MRg) + g.a.a.b.b.a.bu(10, this.MVe) + (g.a.a.b.b.a.fS(11) + 1);
      paramInt = i;
      if (this.MVf != null) {
        paramInt = i + g.a.a.b.b.a.b(12, this.MVf);
      }
      i = paramInt + g.a.a.b.b.a.bu(13, this.rBL);
      paramInt = i;
      if (this.MVg != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.MVg);
      }
      AppMethodBeat.o(117923);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KKx.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(117923);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117923);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dsz localdsz = (dsz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117923);
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
            localdsz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117923);
          return 0;
        case 2: 
          localdsz.oTY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117923);
          return 0;
        case 3: 
          localdsz.oUv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117923);
          return 0;
        case 4: 
          localdsz.MJT = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117923);
          return 0;
        case 5: 
          localdsz.oTz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117923);
          return 0;
        case 6: 
          localdsz.Title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117923);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fdz();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fdz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdsz.MVd = ((fdz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117923);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fei();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fei)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdsz.KKx.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117923);
          return 0;
        case 9: 
          localdsz.MRg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117923);
          return 0;
        case 10: 
          localdsz.MVe = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117923);
          return 0;
        case 11: 
          localdsz.LYI = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(117923);
          return 0;
        case 12: 
          localdsz.MVf = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(117923);
          return 0;
        case 13: 
          localdsz.rBL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117923);
          return 0;
        }
        localdsz.MVg = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(117923);
        return 0;
      }
      AppMethodBeat.o(117923);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsz
 * JD-Core Version:    0.7.0.1
 */