package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ddq
  extends cwj
{
  public String dJc;
  public String hCp;
  public String hDr;
  public String oEo;
  public String oEp;
  public String oEq;
  public int oEs;
  public String oFG;
  public int oGc;
  public String title;
  public int zcC;
  public String zcD;
  public String zcE;
  public String zcF;
  public String zcG;
  public String zcH;
  public boolean zcI;
  public int zcz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32439);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32439);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.oGc);
      if (this.oEo != null) {
        paramVarArgs.d(3, this.oEo);
      }
      if (this.dJc != null) {
        paramVarArgs.d(4, this.dJc);
      }
      if (this.title != null) {
        paramVarArgs.d(5, this.title);
      }
      if (this.oEp != null) {
        paramVarArgs.d(6, this.oEp);
      }
      if (this.oEq != null) {
        paramVarArgs.d(7, this.oEq);
      }
      if (this.oFG != null) {
        paramVarArgs.d(8, this.oFG);
      }
      if (this.hCp != null) {
        paramVarArgs.d(9, this.hCp);
      }
      if (this.hDr != null) {
        paramVarArgs.d(10, this.hDr);
      }
      paramVarArgs.aS(11, this.zcz);
      paramVarArgs.aS(12, this.zcC);
      if (this.zcD != null) {
        paramVarArgs.d(13, this.zcD);
      }
      if (this.zcE != null) {
        paramVarArgs.d(14, this.zcE);
      }
      if (this.zcF != null) {
        paramVarArgs.d(19, this.zcF);
      }
      if (this.zcG != null) {
        paramVarArgs.d(21, this.zcG);
      }
      paramVarArgs.aS(22, this.oEs);
      if (this.zcH != null) {
        paramVarArgs.d(23, this.zcH);
      }
      paramVarArgs.bC(24, this.zcI);
      AppMethodBeat.o(32439);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1427;
      }
    }
    label1427:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.oGc);
      paramInt = i;
      if (this.oEo != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oEo);
      }
      i = paramInt;
      if (this.dJc != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.dJc);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.title);
      }
      i = paramInt;
      if (this.oEp != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.oEp);
      }
      paramInt = i;
      if (this.oEq != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.oEq);
      }
      i = paramInt;
      if (this.oFG != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.oFG);
      }
      paramInt = i;
      if (this.hCp != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.hCp);
      }
      i = paramInt;
      if (this.hDr != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.hDr);
      }
      i = i + f.a.a.b.b.a.bz(11, this.zcz) + f.a.a.b.b.a.bz(12, this.zcC);
      paramInt = i;
      if (this.zcD != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.zcD);
      }
      i = paramInt;
      if (this.zcE != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.zcE);
      }
      paramInt = i;
      if (this.zcF != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.zcF);
      }
      i = paramInt;
      if (this.zcG != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.zcG);
      }
      i += f.a.a.b.b.a.bz(22, this.oEs);
      paramInt = i;
      if (this.zcH != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.zcH);
      }
      i = f.a.a.b.b.a.amF(24);
      AppMethodBeat.o(32439);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32439);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32439);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ddq localddq = (ddq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        case 20: 
        default: 
          AppMethodBeat.o(32439);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32439);
          return 0;
        case 2: 
          localddq.oGc = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32439);
          return 0;
        case 3: 
          localddq.oEo = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 4: 
          localddq.dJc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 5: 
          localddq.title = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 6: 
          localddq.oEp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 7: 
          localddq.oEq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 8: 
          localddq.oFG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 9: 
          localddq.hCp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 10: 
          localddq.hDr = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 11: 
          localddq.zcz = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32439);
          return 0;
        case 12: 
          localddq.zcC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32439);
          return 0;
        case 13: 
          localddq.zcD = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 14: 
          localddq.zcE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 19: 
          localddq.zcF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 21: 
          localddq.zcG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 22: 
          localddq.oEs = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32439);
          return 0;
        case 23: 
          localddq.zcH = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32439);
          return 0;
        }
        localddq.zcI = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(32439);
        return 0;
      }
      AppMethodBeat.o(32439);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddq
 * JD-Core Version:    0.7.0.1
 */