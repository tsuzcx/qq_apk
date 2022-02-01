package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dny
  extends com.tencent.mm.bx.a
{
  public String CZV;
  public float CwG;
  public String EEr;
  public String EEs;
  public String EEt;
  public int EEu;
  public float EEv;
  public String EEw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147791);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EEr != null) {
        paramVarArgs.d(1, this.EEr);
      }
      if (this.CZV != null) {
        paramVarArgs.d(2, this.CZV);
      }
      if (this.EEs != null) {
        paramVarArgs.d(3, this.EEs);
      }
      if (this.EEt != null) {
        paramVarArgs.d(4, this.EEt);
      }
      paramVarArgs.aR(5, this.EEu);
      paramVarArgs.x(6, this.CwG);
      paramVarArgs.x(7, this.EEv);
      if (this.EEw != null) {
        paramVarArgs.d(8, this.EEw);
      }
      AppMethodBeat.o(147791);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EEr == null) {
        break label592;
      }
    }
    label592:
    for (int i = f.a.a.b.b.a.e(1, this.EEr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CZV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CZV);
      }
      i = paramInt;
      if (this.EEs != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EEs);
      }
      paramInt = i;
      if (this.EEt != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EEt);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.EEu) + (f.a.a.b.b.a.fY(6) + 4) + (f.a.a.b.b.a.fY(7) + 4);
      paramInt = i;
      if (this.EEw != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.EEw);
      }
      AppMethodBeat.o(147791);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(147791);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dny localdny = (dny)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147791);
          return -1;
        case 1: 
          localdny.EEr = locala.KhF.readString();
          AppMethodBeat.o(147791);
          return 0;
        case 2: 
          localdny.CZV = locala.KhF.readString();
          AppMethodBeat.o(147791);
          return 0;
        case 3: 
          localdny.EEs = locala.KhF.readString();
          AppMethodBeat.o(147791);
          return 0;
        case 4: 
          localdny.EEt = locala.KhF.readString();
          AppMethodBeat.o(147791);
          return 0;
        case 5: 
          localdny.EEu = locala.KhF.xS();
          AppMethodBeat.o(147791);
          return 0;
        case 6: 
          localdny.CwG = Float.intBitsToFloat(locala.KhF.fHx());
          AppMethodBeat.o(147791);
          return 0;
        case 7: 
          localdny.EEv = Float.intBitsToFloat(locala.KhF.fHx());
          AppMethodBeat.o(147791);
          return 0;
        }
        localdny.EEw = locala.KhF.readString();
        AppMethodBeat.o(147791);
        return 0;
      }
      AppMethodBeat.o(147791);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dny
 * JD-Core Version:    0.7.0.1
 */