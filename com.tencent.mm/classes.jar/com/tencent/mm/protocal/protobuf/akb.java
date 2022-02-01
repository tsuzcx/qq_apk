package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class akb
  extends com.tencent.mm.bx.a
{
  public String DlP;
  public String DlQ;
  public String DlR;
  public String DlS;
  public int DlT;
  public String LxT;
  public String LxU;
  public String appName;
  public String itN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169017);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DlP != null) {
        paramVarArgs.d(1, this.DlP);
      }
      if (this.DlQ != null) {
        paramVarArgs.d(2, this.DlQ);
      }
      if (this.DlR != null) {
        paramVarArgs.d(3, this.DlR);
      }
      if (this.appName != null) {
        paramVarArgs.d(4, this.appName);
      }
      if (this.DlS != null) {
        paramVarArgs.d(5, this.DlS);
      }
      if (this.itN != null) {
        paramVarArgs.d(6, this.itN);
      }
      paramVarArgs.aR(7, this.DlT);
      if (this.LxT != null) {
        paramVarArgs.d(8, this.LxT);
      }
      if (this.LxU != null) {
        paramVarArgs.d(9, this.LxU);
      }
      AppMethodBeat.o(169017);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DlP == null) {
        break label686;
      }
    }
    label686:
    for (int i = f.a.a.b.b.a.e(1, this.DlP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DlQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DlQ);
      }
      i = paramInt;
      if (this.DlR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DlR);
      }
      paramInt = i;
      if (this.appName != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.appName);
      }
      i = paramInt;
      if (this.DlS != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DlS);
      }
      paramInt = i;
      if (this.itN != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.itN);
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.DlT);
      paramInt = i;
      if (this.LxT != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.LxT);
      }
      i = paramInt;
      if (this.LxU != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.LxU);
      }
      AppMethodBeat.o(169017);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(169017);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        akb localakb = (akb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(169017);
          return -1;
        case 1: 
          localakb.DlP = locala.KhF.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 2: 
          localakb.DlQ = locala.KhF.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 3: 
          localakb.DlR = locala.KhF.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 4: 
          localakb.appName = locala.KhF.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 5: 
          localakb.DlS = locala.KhF.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 6: 
          localakb.itN = locala.KhF.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 7: 
          localakb.DlT = locala.KhF.xS();
          AppMethodBeat.o(169017);
          return 0;
        case 8: 
          localakb.LxT = locala.KhF.readString();
          AppMethodBeat.o(169017);
          return 0;
        }
        localakb.LxU = locala.KhF.readString();
        AppMethodBeat.o(169017);
        return 0;
      }
      AppMethodBeat.o(169017);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akb
 * JD-Core Version:    0.7.0.1
 */