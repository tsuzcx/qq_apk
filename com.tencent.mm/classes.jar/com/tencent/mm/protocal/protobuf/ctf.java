package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ctf
  extends cwj
{
  public String CPZ;
  public boolean HEl;
  public boolean HEm;
  public String HEn;
  public String HEo;
  public String HEp;
  public String HEq;
  public int Hyx;
  public int oGt;
  public String oGu;
  public int status;
  public String uVs;
  public String wSp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91666);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91666);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.oGt);
      if (this.oGu != null) {
        paramVarArgs.d(3, this.oGu);
      }
      paramVarArgs.bC(4, this.HEl);
      paramVarArgs.bC(5, this.HEm);
      paramVarArgs.aS(6, this.status);
      if (this.HEn != null) {
        paramVarArgs.d(7, this.HEn);
      }
      if (this.HEo != null) {
        paramVarArgs.d(8, this.HEo);
      }
      paramVarArgs.aS(9, this.Hyx);
      if (this.uVs != null) {
        paramVarArgs.d(10, this.uVs);
      }
      if (this.wSp != null) {
        paramVarArgs.d(11, this.wSp);
      }
      if (this.HEp != null) {
        paramVarArgs.d(12, this.HEp);
      }
      if (this.HEq != null) {
        paramVarArgs.d(13, this.HEq);
      }
      if (this.CPZ != null) {
        paramVarArgs.d(100, this.CPZ);
      }
      AppMethodBeat.o(91666);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1118;
      }
    }
    label1118:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.oGt);
      paramInt = i;
      if (this.oGu != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oGu);
      }
      i = paramInt + f.a.a.b.b.a.amF(4) + f.a.a.b.b.a.amF(5) + f.a.a.b.b.a.bz(6, this.status);
      paramInt = i;
      if (this.HEn != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HEn);
      }
      i = paramInt;
      if (this.HEo != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.HEo);
      }
      i += f.a.a.b.b.a.bz(9, this.Hyx);
      paramInt = i;
      if (this.uVs != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.uVs);
      }
      i = paramInt;
      if (this.wSp != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.wSp);
      }
      paramInt = i;
      if (this.HEp != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.HEp);
      }
      i = paramInt;
      if (this.HEq != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.HEq);
      }
      paramInt = i;
      if (this.CPZ != null) {
        paramInt = i + f.a.a.b.b.a.e(100, this.CPZ);
      }
      AppMethodBeat.o(91666);
      return paramInt;
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
          AppMethodBeat.o(91666);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91666);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ctf localctf = (ctf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91666);
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
            localctf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91666);
          return 0;
        case 2: 
          localctf.oGt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91666);
          return 0;
        case 3: 
          localctf.oGu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 4: 
          localctf.HEl = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(91666);
          return 0;
        case 5: 
          localctf.HEm = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(91666);
          return 0;
        case 6: 
          localctf.status = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91666);
          return 0;
        case 7: 
          localctf.HEn = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 8: 
          localctf.HEo = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 9: 
          localctf.Hyx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91666);
          return 0;
        case 10: 
          localctf.uVs = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 11: 
          localctf.wSp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 12: 
          localctf.HEp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 13: 
          localctf.HEq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91666);
          return 0;
        }
        localctf.CPZ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91666);
        return 0;
      }
      AppMethodBeat.o(91666);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctf
 * JD-Core Version:    0.7.0.1
 */