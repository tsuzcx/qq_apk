package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class awx
  extends cqk
{
  public String Bxu;
  public int DOD;
  public String EOI;
  public String EOJ;
  public String EOK;
  public String EOL;
  public bnm EOM;
  public com.tencent.mm.bw.b EON;
  public String EOO;
  public int EOP;
  public String EOQ;
  public int EOR;
  public String bIO;
  public String djj;
  public int oVw;
  public int ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(108144);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(108144);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ret);
      if (this.bIO != null) {
        paramVarArgs.d(3, this.bIO);
      }
      paramVarArgs.aR(4, this.DOD);
      if (this.djj != null) {
        paramVarArgs.d(5, this.djj);
      }
      if (this.EOJ != null) {
        paramVarArgs.d(6, this.EOJ);
      }
      if (this.Bxu != null) {
        paramVarArgs.d(7, this.Bxu);
      }
      if (this.EOK != null) {
        paramVarArgs.d(8, this.EOK);
      }
      if (this.EOL != null) {
        paramVarArgs.d(9, this.EOL);
      }
      if (this.EOM != null)
      {
        paramVarArgs.ln(10, this.EOM.computeSize());
        this.EOM.writeFields(paramVarArgs);
      }
      if (this.EON != null) {
        paramVarArgs.c(11, this.EON);
      }
      paramVarArgs.aR(12, this.oVw);
      if (this.EOI != null) {
        paramVarArgs.d(13, this.EOI);
      }
      if (this.EOO != null) {
        paramVarArgs.d(14, this.EOO);
      }
      paramVarArgs.aR(15, this.EOP);
      if (this.EOQ != null) {
        paramVarArgs.d(17, this.EOQ);
      }
      paramVarArgs.aR(18, this.EOR);
      AppMethodBeat.o(108144);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1362;
      }
    }
    label1362:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.ret);
      paramInt = i;
      if (this.bIO != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.bIO);
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.DOD);
      paramInt = i;
      if (this.djj != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.djj);
      }
      i = paramInt;
      if (this.EOJ != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.EOJ);
      }
      paramInt = i;
      if (this.Bxu != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Bxu);
      }
      i = paramInt;
      if (this.EOK != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.EOK);
      }
      paramInt = i;
      if (this.EOL != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.EOL);
      }
      i = paramInt;
      if (this.EOM != null) {
        i = paramInt + f.a.a.a.lm(10, this.EOM.computeSize());
      }
      paramInt = i;
      if (this.EON != null) {
        paramInt = i + f.a.a.b.b.a.b(11, this.EON);
      }
      i = paramInt + f.a.a.b.b.a.bx(12, this.oVw);
      paramInt = i;
      if (this.EOI != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.EOI);
      }
      i = paramInt;
      if (this.EOO != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.EOO);
      }
      i += f.a.a.b.b.a.bx(15, this.EOP);
      paramInt = i;
      if (this.EOQ != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.EOQ);
      }
      i = f.a.a.b.b.a.bx(18, this.EOR);
      AppMethodBeat.o(108144);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(108144);
          throw paramVarArgs;
        }
        AppMethodBeat.o(108144);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        awx localawx = (awx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 16: 
        default: 
          AppMethodBeat.o(108144);
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
            localawx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(108144);
          return 0;
        case 2: 
          localawx.ret = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(108144);
          return 0;
        case 3: 
          localawx.bIO = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(108144);
          return 0;
        case 4: 
          localawx.DOD = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(108144);
          return 0;
        case 5: 
          localawx.djj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(108144);
          return 0;
        case 6: 
          localawx.EOJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(108144);
          return 0;
        case 7: 
          localawx.Bxu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(108144);
          return 0;
        case 8: 
          localawx.EOK = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(108144);
          return 0;
        case 9: 
          localawx.EOL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(108144);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bnm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bnm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localawx.EOM = ((bnm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(108144);
          return 0;
        case 11: 
          localawx.EON = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(108144);
          return 0;
        case 12: 
          localawx.oVw = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(108144);
          return 0;
        case 13: 
          localawx.EOI = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(108144);
          return 0;
        case 14: 
          localawx.EOO = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(108144);
          return 0;
        case 15: 
          localawx.EOP = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(108144);
          return 0;
        case 17: 
          localawx.EOQ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(108144);
          return 0;
        }
        localawx.EOR = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(108144);
        return 0;
      }
      AppMethodBeat.o(108144);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awx
 * JD-Core Version:    0.7.0.1
 */