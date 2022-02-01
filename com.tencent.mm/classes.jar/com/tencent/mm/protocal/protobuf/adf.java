package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class adf
  extends com.tencent.mm.bx.a
{
  public int Cxm;
  public String DdN;
  public String DdO;
  public String DdP;
  public String DdQ;
  public String DdR;
  public int DdS;
  public int DdT;
  public String DdU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104780);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DdN == null)
      {
        paramVarArgs = new b("Not all required fields were included: BegWord");
        AppMethodBeat.o(104780);
        throw paramVarArgs;
      }
      if (this.DdO == null)
      {
        paramVarArgs = new b("Not all required fields were included: BegPicUrl");
        AppMethodBeat.o(104780);
        throw paramVarArgs;
      }
      if (this.DdP == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThanksPicUrl");
        AppMethodBeat.o(104780);
        throw paramVarArgs;
      }
      if (this.DdN != null) {
        paramVarArgs.d(1, this.DdN);
      }
      if (this.DdO != null) {
        paramVarArgs.d(2, this.DdO);
      }
      if (this.DdP != null) {
        paramVarArgs.d(3, this.DdP);
      }
      if (this.DdQ != null) {
        paramVarArgs.d(4, this.DdQ);
      }
      if (this.DdR != null) {
        paramVarArgs.d(5, this.DdR);
      }
      paramVarArgs.aR(6, this.DdS);
      paramVarArgs.aR(7, this.DdT);
      if (this.DdU != null) {
        paramVarArgs.d(8, this.DdU);
      }
      paramVarArgs.aR(9, this.Cxm);
      AppMethodBeat.o(104780);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DdN == null) {
        break label798;
      }
    }
    label798:
    for (int i = f.a.a.b.b.a.e(1, this.DdN) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DdO != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DdO);
      }
      i = paramInt;
      if (this.DdP != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DdP);
      }
      paramInt = i;
      if (this.DdQ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DdQ);
      }
      i = paramInt;
      if (this.DdR != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DdR);
      }
      i = i + f.a.a.b.b.a.bA(6, this.DdS) + f.a.a.b.b.a.bA(7, this.DdT);
      paramInt = i;
      if (this.DdU != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DdU);
      }
      i = f.a.a.b.b.a.bA(9, this.Cxm);
      AppMethodBeat.o(104780);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.DdN == null)
        {
          paramVarArgs = new b("Not all required fields were included: BegWord");
          AppMethodBeat.o(104780);
          throw paramVarArgs;
        }
        if (this.DdO == null)
        {
          paramVarArgs = new b("Not all required fields were included: BegPicUrl");
          AppMethodBeat.o(104780);
          throw paramVarArgs;
        }
        if (this.DdP == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThanksPicUrl");
          AppMethodBeat.o(104780);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104780);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        adf localadf = (adf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104780);
          return -1;
        case 1: 
          localadf.DdN = locala.KhF.readString();
          AppMethodBeat.o(104780);
          return 0;
        case 2: 
          localadf.DdO = locala.KhF.readString();
          AppMethodBeat.o(104780);
          return 0;
        case 3: 
          localadf.DdP = locala.KhF.readString();
          AppMethodBeat.o(104780);
          return 0;
        case 4: 
          localadf.DdQ = locala.KhF.readString();
          AppMethodBeat.o(104780);
          return 0;
        case 5: 
          localadf.DdR = locala.KhF.readString();
          AppMethodBeat.o(104780);
          return 0;
        case 6: 
          localadf.DdS = locala.KhF.xS();
          AppMethodBeat.o(104780);
          return 0;
        case 7: 
          localadf.DdT = locala.KhF.xS();
          AppMethodBeat.o(104780);
          return 0;
        case 8: 
          localadf.DdU = locala.KhF.readString();
          AppMethodBeat.o(104780);
          return 0;
        }
        localadf.Cxm = locala.KhF.xS();
        AppMethodBeat.o(104780);
        return 0;
      }
      AppMethodBeat.o(104780);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adf
 * JD-Core Version:    0.7.0.1
 */