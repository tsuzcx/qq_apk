package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ckc
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public String HdF;
  public String HdG;
  public int Hdr;
  public String uiR;
  public String wDA;
  public String wDo;
  public String wDq;
  public String wDr;
  public int wDs;
  public String wDt;
  public int wDu;
  public int wDv;
  public String wDx;
  public String wDy;
  public String wDz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91612);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.wDo != null) {
        paramVarArgs.d(1, this.wDo);
      }
      paramVarArgs.aS(2, this.Hdr);
      if (this.wDq != null) {
        paramVarArgs.d(3, this.wDq);
      }
      paramVarArgs.aS(4, this.CreateTime);
      if (this.wDr != null) {
        paramVarArgs.d(5, this.wDr);
      }
      paramVarArgs.aS(6, this.wDs);
      if (this.wDt != null) {
        paramVarArgs.d(7, this.wDt);
      }
      paramVarArgs.aS(8, this.wDu);
      paramVarArgs.aS(9, this.wDv);
      if (this.uiR != null) {
        paramVarArgs.d(11, this.uiR);
      }
      if (this.wDx != null) {
        paramVarArgs.d(12, this.wDx);
      }
      if (this.wDy != null) {
        paramVarArgs.d(13, this.wDy);
      }
      if (this.wDz != null) {
        paramVarArgs.d(14, this.wDz);
      }
      if (this.wDA != null) {
        paramVarArgs.d(15, this.wDA);
      }
      if (this.HdF != null) {
        paramVarArgs.d(18, this.HdF);
      }
      if (this.HdG != null) {
        paramVarArgs.d(19, this.HdG);
      }
      AppMethodBeat.o(91612);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wDo == null) {
        break label1066;
      }
    }
    label1066:
    for (paramInt = f.a.a.b.b.a.e(1, this.wDo) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Hdr);
      paramInt = i;
      if (this.wDq != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.wDq);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.CreateTime);
      paramInt = i;
      if (this.wDr != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.wDr);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.wDs);
      paramInt = i;
      if (this.wDt != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.wDt);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.wDu) + f.a.a.b.b.a.bz(9, this.wDv);
      paramInt = i;
      if (this.uiR != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.uiR);
      }
      i = paramInt;
      if (this.wDx != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.wDx);
      }
      paramInt = i;
      if (this.wDy != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.wDy);
      }
      i = paramInt;
      if (this.wDz != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.wDz);
      }
      paramInt = i;
      if (this.wDA != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.wDA);
      }
      i = paramInt;
      if (this.HdF != null) {
        i = paramInt + f.a.a.b.b.a.e(18, this.HdF);
      }
      paramInt = i;
      if (this.HdG != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.HdG);
      }
      AppMethodBeat.o(91612);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91612);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ckc localckc = (ckc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 10: 
        case 16: 
        case 17: 
        default: 
          AppMethodBeat.o(91612);
          return -1;
        case 1: 
          localckc.wDo = locala.NPN.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 2: 
          localckc.Hdr = locala.NPN.zc();
          AppMethodBeat.o(91612);
          return 0;
        case 3: 
          localckc.wDq = locala.NPN.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 4: 
          localckc.CreateTime = locala.NPN.zc();
          AppMethodBeat.o(91612);
          return 0;
        case 5: 
          localckc.wDr = locala.NPN.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 6: 
          localckc.wDs = locala.NPN.zc();
          AppMethodBeat.o(91612);
          return 0;
        case 7: 
          localckc.wDt = locala.NPN.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 8: 
          localckc.wDu = locala.NPN.zc();
          AppMethodBeat.o(91612);
          return 0;
        case 9: 
          localckc.wDv = locala.NPN.zc();
          AppMethodBeat.o(91612);
          return 0;
        case 11: 
          localckc.uiR = locala.NPN.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 12: 
          localckc.wDx = locala.NPN.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 13: 
          localckc.wDy = locala.NPN.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 14: 
          localckc.wDz = locala.NPN.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 15: 
          localckc.wDA = locala.NPN.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 18: 
          localckc.HdF = locala.NPN.readString();
          AppMethodBeat.o(91612);
          return 0;
        }
        localckc.HdG = locala.NPN.readString();
        AppMethodBeat.o(91612);
        return 0;
      }
      AppMethodBeat.o(91612);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckc
 * JD-Core Version:    0.7.0.1
 */