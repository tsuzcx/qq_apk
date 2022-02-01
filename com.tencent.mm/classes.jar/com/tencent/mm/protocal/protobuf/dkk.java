package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dkk
  extends dpc
{
  public com.tencent.mm.bw.b MBC;
  public int MBD;
  public int MBE;
  public String MBJ;
  public String MBK;
  public String MBL;
  public int MBM;
  public String MBO;
  public String pWf;
  public int yPI;
  public int yPJ;
  public String yPK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91662);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91662);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.MBD);
      if (this.yPK != null) {
        paramVarArgs.e(3, this.yPK);
      }
      if (this.MBK != null) {
        paramVarArgs.e(4, this.MBK);
      }
      if (this.MBL != null) {
        paramVarArgs.e(5, this.MBL);
      }
      if (this.MBC != null) {
        paramVarArgs.c(6, this.MBC);
      }
      paramVarArgs.aM(7, this.MBE);
      paramVarArgs.aM(8, this.yPI);
      paramVarArgs.aM(9, this.MBM);
      paramVarArgs.aM(10, this.yPJ);
      if (this.pWf != null) {
        paramVarArgs.e(11, this.pWf);
      }
      if (this.MBO != null) {
        paramVarArgs.e(12, this.MBO);
      }
      if (this.MBJ != null) {
        paramVarArgs.e(13, this.MBJ);
      }
      AppMethodBeat.o(91662);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1010;
      }
    }
    label1010:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.MBD);
      paramInt = i;
      if (this.yPK != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.yPK);
      }
      i = paramInt;
      if (this.MBK != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.MBK);
      }
      paramInt = i;
      if (this.MBL != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.MBL);
      }
      i = paramInt;
      if (this.MBC != null) {
        i = paramInt + g.a.a.b.b.a.b(6, this.MBC);
      }
      i = i + g.a.a.b.b.a.bu(7, this.MBE) + g.a.a.b.b.a.bu(8, this.yPI) + g.a.a.b.b.a.bu(9, this.MBM) + g.a.a.b.b.a.bu(10, this.yPJ);
      paramInt = i;
      if (this.pWf != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.pWf);
      }
      i = paramInt;
      if (this.MBO != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.MBO);
      }
      paramInt = i;
      if (this.MBJ != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.MBJ);
      }
      AppMethodBeat.o(91662);
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
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91662);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91662);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dkk localdkk = (dkk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91662);
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
            localdkk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91662);
          return 0;
        case 2: 
          localdkk.MBD = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91662);
          return 0;
        case 3: 
          localdkk.yPK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91662);
          return 0;
        case 4: 
          localdkk.MBK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91662);
          return 0;
        case 5: 
          localdkk.MBL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91662);
          return 0;
        case 6: 
          localdkk.MBC = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(91662);
          return 0;
        case 7: 
          localdkk.MBE = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91662);
          return 0;
        case 8: 
          localdkk.yPI = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91662);
          return 0;
        case 9: 
          localdkk.MBM = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91662);
          return 0;
        case 10: 
          localdkk.yPJ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91662);
          return 0;
        case 11: 
          localdkk.pWf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91662);
          return 0;
        case 12: 
          localdkk.MBO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91662);
          return 0;
        }
        localdkk.MBJ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91662);
        return 0;
      }
      AppMethodBeat.o(91662);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkk
 * JD-Core Version:    0.7.0.1
 */