package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class amk
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public int Ctq;
  public String Cxu;
  public String Cxw;
  public String Dnv;
  public int Dnw;
  public int Dnx;
  public int Dny;
  public String gKr;
  public String mAQ;
  public String sed;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149139);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Cxu != null) {
        paramVarArgs.d(1, this.Cxu);
      }
      paramVarArgs.aR(2, this.Ctq);
      paramVarArgs.aR(3, this.CreateTime);
      if (this.Cxw != null) {
        paramVarArgs.d(4, this.Cxw);
      }
      if (this.sed != null) {
        paramVarArgs.d(5, this.sed);
      }
      if (this.Dnv != null) {
        paramVarArgs.d(6, this.Dnv);
      }
      if (this.mAQ != null) {
        paramVarArgs.d(7, this.mAQ);
      }
      paramVarArgs.aR(8, this.Dnw);
      if (this.gKr != null) {
        paramVarArgs.d(9, this.gKr);
      }
      paramVarArgs.aR(10, this.Dnx);
      paramVarArgs.aR(11, this.Dny);
      AppMethodBeat.o(149139);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Cxu == null) {
        break label746;
      }
    }
    label746:
    for (paramInt = f.a.a.b.b.a.e(1, this.Cxu) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.Ctq) + f.a.a.b.b.a.bA(3, this.CreateTime);
      paramInt = i;
      if (this.Cxw != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Cxw);
      }
      i = paramInt;
      if (this.sed != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.sed);
      }
      paramInt = i;
      if (this.Dnv != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Dnv);
      }
      i = paramInt;
      if (this.mAQ != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.mAQ);
      }
      i += f.a.a.b.b.a.bA(8, this.Dnw);
      paramInt = i;
      if (this.gKr != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.gKr);
      }
      i = f.a.a.b.b.a.bA(10, this.Dnx);
      int j = f.a.a.b.b.a.bA(11, this.Dny);
      AppMethodBeat.o(149139);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(149139);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        amk localamk = (amk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(149139);
          return -1;
        case 1: 
          localamk.Cxu = locala.KhF.readString();
          AppMethodBeat.o(149139);
          return 0;
        case 2: 
          localamk.Ctq = locala.KhF.xS();
          AppMethodBeat.o(149139);
          return 0;
        case 3: 
          localamk.CreateTime = locala.KhF.xS();
          AppMethodBeat.o(149139);
          return 0;
        case 4: 
          localamk.Cxw = locala.KhF.readString();
          AppMethodBeat.o(149139);
          return 0;
        case 5: 
          localamk.sed = locala.KhF.readString();
          AppMethodBeat.o(149139);
          return 0;
        case 6: 
          localamk.Dnv = locala.KhF.readString();
          AppMethodBeat.o(149139);
          return 0;
        case 7: 
          localamk.mAQ = locala.KhF.readString();
          AppMethodBeat.o(149139);
          return 0;
        case 8: 
          localamk.Dnw = locala.KhF.xS();
          AppMethodBeat.o(149139);
          return 0;
        case 9: 
          localamk.gKr = locala.KhF.readString();
          AppMethodBeat.o(149139);
          return 0;
        case 10: 
          localamk.Dnx = locala.KhF.xS();
          AppMethodBeat.o(149139);
          return 0;
        }
        localamk.Dny = locala.KhF.xS();
        AppMethodBeat.o(149139);
        return 0;
      }
      AppMethodBeat.o(149139);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amk
 * JD-Core Version:    0.7.0.1
 */