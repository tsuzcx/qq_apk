package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dfv
  extends dpc
{
  public int LsZ;
  public long Lta;
  public int MKD;
  public int MKF;
  public int MKG;
  public int rBL;
  public String rBM;
  public int ypM;
  public String ypN;
  public int yqb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32391);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32391);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.LsZ);
      paramVarArgs.bb(4, this.Lta);
      paramVarArgs.aM(5, this.MKF);
      paramVarArgs.aM(6, this.MKD);
      paramVarArgs.aM(7, this.yqb);
      paramVarArgs.aM(8, this.MKG);
      paramVarArgs.aM(9, this.rBL);
      if (this.rBM != null) {
        paramVarArgs.e(10, this.rBM);
      }
      paramVarArgs.aM(11, this.ypM);
      if (this.ypN != null) {
        paramVarArgs.e(12, this.ypN);
      }
      AppMethodBeat.o(32391);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label855;
      }
    }
    label855:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(3, this.LsZ) + g.a.a.b.b.a.r(4, this.Lta) + g.a.a.b.b.a.bu(5, this.MKF) + g.a.a.b.b.a.bu(6, this.MKD) + g.a.a.b.b.a.bu(7, this.yqb) + g.a.a.b.b.a.bu(8, this.MKG) + g.a.a.b.b.a.bu(9, this.rBL);
      paramInt = i;
      if (this.rBM != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.rBM);
      }
      i = paramInt + g.a.a.b.b.a.bu(11, this.ypM);
      paramInt = i;
      if (this.ypN != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.ypN);
      }
      AppMethodBeat.o(32391);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32391);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32391);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dfv localdfv = (dfv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        default: 
          AppMethodBeat.o(32391);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdfv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32391);
          return 0;
        case 3: 
          localdfv.LsZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32391);
          return 0;
        case 4: 
          localdfv.Lta = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(32391);
          return 0;
        case 5: 
          localdfv.MKF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32391);
          return 0;
        case 6: 
          localdfv.MKD = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32391);
          return 0;
        case 7: 
          localdfv.yqb = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32391);
          return 0;
        case 8: 
          localdfv.MKG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32391);
          return 0;
        case 9: 
          localdfv.rBL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32391);
          return 0;
        case 10: 
          localdfv.rBM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32391);
          return 0;
        case 11: 
          localdfv.ypM = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32391);
          return 0;
        }
        localdfv.ypN = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32391);
        return 0;
      }
      AppMethodBeat.o(32391);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfv
 * JD-Core Version:    0.7.0.1
 */