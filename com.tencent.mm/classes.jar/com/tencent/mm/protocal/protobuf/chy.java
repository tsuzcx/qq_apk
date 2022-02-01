package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class chy
  extends cqk
{
  public LinkedList<chq> DVd;
  public int Exf;
  public long Exg;
  public long FvT;
  public int Fwc;
  public int Fwd;
  public LinkedList<chq> Fwe;
  public String Fwf;
  public com.tencent.mm.bw.b Fwg;
  public int Fwh;
  public int tIL;
  public String tIM;
  public int tIQ;
  public int tIW;
  public int tIX;
  public int tIY;
  public com.tencent.mm.bw.b tIZ;
  public int tJb;
  public int tJe;
  
  public chy()
  {
    AppMethodBeat.i(32379);
    this.DVd = new LinkedList();
    this.Fwe = new LinkedList();
    AppMethodBeat.o(32379);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32380);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32380);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Exf);
      paramVarArgs.aO(3, this.Exg);
      paramVarArgs.aR(4, this.Fwc);
      paramVarArgs.e(5, 8, this.DVd);
      paramVarArgs.aR(6, this.Fwd);
      paramVarArgs.aR(7, this.tIW);
      paramVarArgs.aR(8, this.tIX);
      paramVarArgs.aO(9, this.FvT);
      paramVarArgs.aR(10, this.tIY);
      if (this.tIZ != null) {
        paramVarArgs.c(11, this.tIZ);
      }
      paramVarArgs.aR(12, this.tIQ);
      paramVarArgs.aR(13, this.tIL);
      if (this.tIM != null) {
        paramVarArgs.d(14, this.tIM);
      }
      paramVarArgs.aR(15, this.tJb);
      paramVarArgs.e(16, 8, this.Fwe);
      paramVarArgs.aR(17, this.tJe);
      if (this.Fwf != null) {
        paramVarArgs.d(18, this.Fwf);
      }
      if (this.Fwg != null) {
        paramVarArgs.c(19, this.Fwg);
      }
      paramVarArgs.aR(20, this.Fwh);
      AppMethodBeat.o(32380);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1488;
      }
    }
    label1488:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.Exf) + f.a.a.b.b.a.p(3, this.Exg) + f.a.a.b.b.a.bx(4, this.Fwc) + f.a.a.a.c(5, 8, this.DVd) + f.a.a.b.b.a.bx(6, this.Fwd) + f.a.a.b.b.a.bx(7, this.tIW) + f.a.a.b.b.a.bx(8, this.tIX) + f.a.a.b.b.a.p(9, this.FvT) + f.a.a.b.b.a.bx(10, this.tIY);
      paramInt = i;
      if (this.tIZ != null) {
        paramInt = i + f.a.a.b.b.a.b(11, this.tIZ);
      }
      i = paramInt + f.a.a.b.b.a.bx(12, this.tIQ) + f.a.a.b.b.a.bx(13, this.tIL);
      paramInt = i;
      if (this.tIM != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.tIM);
      }
      i = paramInt + f.a.a.b.b.a.bx(15, this.tJb) + f.a.a.a.c(16, 8, this.Fwe) + f.a.a.b.b.a.bx(17, this.tJe);
      paramInt = i;
      if (this.Fwf != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.Fwf);
      }
      i = paramInt;
      if (this.Fwg != null) {
        i = paramInt + f.a.a.b.b.a.b(19, this.Fwg);
      }
      paramInt = f.a.a.b.b.a.bx(20, this.Fwh);
      AppMethodBeat.o(32380);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DVd.clear();
        this.Fwe.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32380);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32380);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        chy localchy = (chy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32380);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localchy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32380);
          return 0;
        case 2: 
          localchy.Exf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32380);
          return 0;
        case 3: 
          localchy.Exg = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(32380);
          return 0;
        case 4: 
          localchy.Fwc = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32380);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localchy.DVd.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32380);
          return 0;
        case 6: 
          localchy.Fwd = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32380);
          return 0;
        case 7: 
          localchy.tIW = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32380);
          return 0;
        case 8: 
          localchy.tIX = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32380);
          return 0;
        case 9: 
          localchy.FvT = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(32380);
          return 0;
        case 10: 
          localchy.tIY = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32380);
          return 0;
        case 11: 
          localchy.tIZ = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(32380);
          return 0;
        case 12: 
          localchy.tIQ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32380);
          return 0;
        case 13: 
          localchy.tIL = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32380);
          return 0;
        case 14: 
          localchy.tIM = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32380);
          return 0;
        case 15: 
          localchy.tJb = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32380);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localchy.Fwe.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32380);
          return 0;
        case 17: 
          localchy.tJe = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32380);
          return 0;
        case 18: 
          localchy.Fwf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32380);
          return 0;
        case 19: 
          localchy.Fwg = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(32380);
          return 0;
        }
        localchy.Fwh = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32380);
        return 0;
      }
      AppMethodBeat.o(32380);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chy
 * JD-Core Version:    0.7.0.1
 */