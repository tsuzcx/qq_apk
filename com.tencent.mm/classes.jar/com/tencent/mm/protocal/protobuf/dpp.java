package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dpp
  extends dyy
{
  public int DPO;
  public String DPP;
  public int DQd;
  public int Svu;
  public long Svv;
  public int TWA;
  public int TWx;
  public int TWz;
  public int vht;
  public String vhu;
  
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
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.Svu);
      paramVarArgs.bm(4, this.Svv);
      paramVarArgs.aY(5, this.TWz);
      paramVarArgs.aY(6, this.TWx);
      paramVarArgs.aY(7, this.DQd);
      paramVarArgs.aY(8, this.TWA);
      paramVarArgs.aY(9, this.vht);
      if (this.vhu != null) {
        paramVarArgs.f(10, this.vhu);
      }
      paramVarArgs.aY(11, this.DPO);
      if (this.DPP != null) {
        paramVarArgs.f(12, this.DPP);
      }
      AppMethodBeat.o(32391);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label833;
      }
    }
    label833:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(3, this.Svu) + g.a.a.b.b.a.p(4, this.Svv) + g.a.a.b.b.a.bM(5, this.TWz) + g.a.a.b.b.a.bM(6, this.TWx) + g.a.a.b.b.a.bM(7, this.DQd) + g.a.a.b.b.a.bM(8, this.TWA) + g.a.a.b.b.a.bM(9, this.vht);
      paramInt = i;
      if (this.vhu != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.vhu);
      }
      i = paramInt + g.a.a.b.b.a.bM(11, this.DPO);
      paramInt = i;
      if (this.DPP != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.DPP);
      }
      AppMethodBeat.o(32391);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
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
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dpp localdpp = (dpp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        default: 
          AppMethodBeat.o(32391);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jh localjh = new jh();
            if ((localObject != null) && (localObject.length > 0)) {
              localjh.parseFrom((byte[])localObject);
            }
            localdpp.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(32391);
          return 0;
        case 3: 
          localdpp.Svu = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32391);
          return 0;
        case 4: 
          localdpp.Svv = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(32391);
          return 0;
        case 5: 
          localdpp.TWz = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32391);
          return 0;
        case 6: 
          localdpp.TWx = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32391);
          return 0;
        case 7: 
          localdpp.DQd = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32391);
          return 0;
        case 8: 
          localdpp.TWA = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32391);
          return 0;
        case 9: 
          localdpp.vht = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32391);
          return 0;
        case 10: 
          localdpp.vhu = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32391);
          return 0;
        case 11: 
          localdpp.DPO = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32391);
          return 0;
        }
        localdpp.DPP = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(32391);
        return 0;
      }
      AppMethodBeat.o(32391);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpp
 * JD-Core Version:    0.7.0.1
 */