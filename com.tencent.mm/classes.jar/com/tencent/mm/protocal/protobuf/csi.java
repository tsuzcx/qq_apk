package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class csi
  extends cwj
{
  public com.tencent.mm.bw.b HsG;
  public int HsH;
  public int HsI;
  public String HsN;
  public String HsO;
  public String HsP;
  public int HsQ;
  public String HsS;
  public String oIr;
  public int vvu;
  public int vvv;
  public String vvw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91662);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91662);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.HsH);
      if (this.vvw != null) {
        paramVarArgs.d(3, this.vvw);
      }
      if (this.HsO != null) {
        paramVarArgs.d(4, this.HsO);
      }
      if (this.HsP != null) {
        paramVarArgs.d(5, this.HsP);
      }
      if (this.HsG != null) {
        paramVarArgs.c(6, this.HsG);
      }
      paramVarArgs.aS(7, this.HsI);
      paramVarArgs.aS(8, this.vvu);
      paramVarArgs.aS(9, this.HsQ);
      paramVarArgs.aS(10, this.vvv);
      if (this.oIr != null) {
        paramVarArgs.d(11, this.oIr);
      }
      if (this.HsS != null) {
        paramVarArgs.d(12, this.HsS);
      }
      if (this.HsN != null) {
        paramVarArgs.d(13, this.HsN);
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
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HsH);
      paramInt = i;
      if (this.vvw != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.vvw);
      }
      i = paramInt;
      if (this.HsO != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.HsO);
      }
      paramInt = i;
      if (this.HsP != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HsP);
      }
      i = paramInt;
      if (this.HsG != null) {
        i = paramInt + f.a.a.b.b.a.b(6, this.HsG);
      }
      i = i + f.a.a.b.b.a.bz(7, this.HsI) + f.a.a.b.b.a.bz(8, this.vvu) + f.a.a.b.b.a.bz(9, this.HsQ) + f.a.a.b.b.a.bz(10, this.vvv);
      paramInt = i;
      if (this.oIr != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.oIr);
      }
      i = paramInt;
      if (this.HsS != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.HsS);
      }
      paramInt = i;
      if (this.HsN != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.HsN);
      }
      AppMethodBeat.o(91662);
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
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91662);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91662);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        csi localcsi = (csi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91662);
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
            localcsi.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91662);
          return 0;
        case 2: 
          localcsi.HsH = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91662);
          return 0;
        case 3: 
          localcsi.vvw = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91662);
          return 0;
        case 4: 
          localcsi.HsO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91662);
          return 0;
        case 5: 
          localcsi.HsP = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91662);
          return 0;
        case 6: 
          localcsi.HsG = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(91662);
          return 0;
        case 7: 
          localcsi.HsI = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91662);
          return 0;
        case 8: 
          localcsi.vvu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91662);
          return 0;
        case 9: 
          localcsi.HsQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91662);
          return 0;
        case 10: 
          localcsi.vvv = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91662);
          return 0;
        case 11: 
          localcsi.oIr = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91662);
          return 0;
        case 12: 
          localcsi.HsS = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91662);
          return 0;
        }
        localcsi.HsN = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91662);
        return 0;
      }
      AppMethodBeat.o(91662);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csi
 * JD-Core Version:    0.7.0.1
 */