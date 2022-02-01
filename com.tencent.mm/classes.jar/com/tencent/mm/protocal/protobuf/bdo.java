package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bdo
  extends cwj
{
  public String Dcj;
  public boolean GST;
  public boolean GSU;
  public String GSV;
  public String GSW;
  public int GSX;
  public String GSY;
  public int GSZ;
  public String dJc;
  public String hCp;
  public String hDr;
  public String oEo;
  public String oEp;
  public String oEq;
  public int oEs;
  public String oFG;
  public String title;
  public int zcC;
  public String zcD;
  public String zcE;
  public String zcF;
  public String zcH;
  public boolean zcI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32248);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32248);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bC(2, this.GST);
      paramVarArgs.bC(3, this.GSU);
      if (this.GSV != null) {
        paramVarArgs.d(4, this.GSV);
      }
      if (this.GSW != null) {
        paramVarArgs.d(5, this.GSW);
      }
      paramVarArgs.aS(6, this.GSX);
      if (this.GSY != null) {
        paramVarArgs.d(7, this.GSY);
      }
      paramVarArgs.aS(8, this.GSZ);
      if (this.oEo != null) {
        paramVarArgs.d(9, this.oEo);
      }
      if (this.dJc != null) {
        paramVarArgs.d(10, this.dJc);
      }
      if (this.title != null) {
        paramVarArgs.d(11, this.title);
      }
      if (this.oEp != null) {
        paramVarArgs.d(12, this.oEp);
      }
      if (this.oEq != null) {
        paramVarArgs.d(13, this.oEq);
      }
      if (this.oFG != null) {
        paramVarArgs.d(14, this.oFG);
      }
      if (this.hCp != null) {
        paramVarArgs.d(15, this.hCp);
      }
      if (this.hDr != null) {
        paramVarArgs.d(16, this.hDr);
      }
      paramVarArgs.aS(17, this.zcC);
      if (this.zcD != null) {
        paramVarArgs.d(18, this.zcD);
      }
      if (this.zcE != null) {
        paramVarArgs.d(19, this.zcE);
      }
      if (this.zcF != null) {
        paramVarArgs.d(20, this.zcF);
      }
      paramVarArgs.aS(21, this.oEs);
      if (this.zcH != null) {
        paramVarArgs.d(22, this.zcH);
      }
      if (this.Dcj != null) {
        paramVarArgs.d(23, this.Dcj);
      }
      paramVarArgs.bC(24, this.zcI);
      AppMethodBeat.o(32248);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1684;
      }
    }
    label1684:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.amF(2) + f.a.a.b.b.a.amF(3);
      paramInt = i;
      if (this.GSV != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GSV);
      }
      i = paramInt;
      if (this.GSW != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GSW);
      }
      i += f.a.a.b.b.a.bz(6, this.GSX);
      paramInt = i;
      if (this.GSY != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GSY);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.GSZ);
      paramInt = i;
      if (this.oEo != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.oEo);
      }
      i = paramInt;
      if (this.dJc != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.dJc);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.title);
      }
      i = paramInt;
      if (this.oEp != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.oEp);
      }
      paramInt = i;
      if (this.oEq != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.oEq);
      }
      i = paramInt;
      if (this.oFG != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.oFG);
      }
      paramInt = i;
      if (this.hCp != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.hCp);
      }
      i = paramInt;
      if (this.hDr != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.hDr);
      }
      i += f.a.a.b.b.a.bz(17, this.zcC);
      paramInt = i;
      if (this.zcD != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.zcD);
      }
      i = paramInt;
      if (this.zcE != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.zcE);
      }
      paramInt = i;
      if (this.zcF != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.zcF);
      }
      i = paramInt + f.a.a.b.b.a.bz(21, this.oEs);
      paramInt = i;
      if (this.zcH != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.zcH);
      }
      i = paramInt;
      if (this.Dcj != null) {
        i = paramInt + f.a.a.b.b.a.e(23, this.Dcj);
      }
      paramInt = f.a.a.b.b.a.amF(24);
      AppMethodBeat.o(32248);
      return i + paramInt;
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
          AppMethodBeat.o(32248);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32248);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bdo localbdo = (bdo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32248);
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
            localbdo.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32248);
          return 0;
        case 2: 
          localbdo.GST = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(32248);
          return 0;
        case 3: 
          localbdo.GSU = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(32248);
          return 0;
        case 4: 
          localbdo.GSV = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 5: 
          localbdo.GSW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 6: 
          localbdo.GSX = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32248);
          return 0;
        case 7: 
          localbdo.GSY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 8: 
          localbdo.GSZ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32248);
          return 0;
        case 9: 
          localbdo.oEo = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 10: 
          localbdo.dJc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 11: 
          localbdo.title = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 12: 
          localbdo.oEp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 13: 
          localbdo.oEq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 14: 
          localbdo.oFG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 15: 
          localbdo.hCp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 16: 
          localbdo.hDr = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 17: 
          localbdo.zcC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32248);
          return 0;
        case 18: 
          localbdo.zcD = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 19: 
          localbdo.zcE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 20: 
          localbdo.zcF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 21: 
          localbdo.oEs = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32248);
          return 0;
        case 22: 
          localbdo.zcH = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32248);
          return 0;
        case 23: 
          localbdo.Dcj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32248);
          return 0;
        }
        localbdo.zcI = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(32248);
        return 0;
      }
      AppMethodBeat.o(32248);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdo
 * JD-Core Version:    0.7.0.1
 */