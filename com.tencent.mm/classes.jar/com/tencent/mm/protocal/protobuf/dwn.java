package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class dwn
  extends com.tencent.mm.bw.a
{
  public String HKh;
  public int IbI;
  public String IbJ;
  public String IbK;
  public int IbL;
  public String IbM;
  public int IbN;
  public int IbO;
  public String IbP;
  public String dwb;
  public int gxu;
  public String hCp;
  public String title;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176157);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.dwb != null) {
        paramVarArgs.d(2, this.dwb);
      }
      paramVarArgs.aS(3, this.version);
      if (this.hCp != null) {
        paramVarArgs.d(4, this.hCp);
      }
      paramVarArgs.aS(5, this.IbI);
      if (this.IbJ != null) {
        paramVarArgs.d(6, this.IbJ);
      }
      if (this.IbK != null) {
        paramVarArgs.d(7, this.IbK);
      }
      paramVarArgs.aS(8, this.IbL);
      if (this.IbM != null) {
        paramVarArgs.d(9, this.IbM);
      }
      paramVarArgs.aS(10, this.gxu);
      paramVarArgs.aS(11, this.IbN);
      paramVarArgs.aS(12, this.IbO);
      if (this.IbP != null) {
        paramVarArgs.d(13, this.IbP);
      }
      if (this.HKh != null) {
        paramVarArgs.d(14, this.HKh);
      }
      AppMethodBeat.o(176157);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label914;
      }
    }
    label914:
    for (paramInt = f.a.a.b.b.a.e(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dwb != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dwb);
      }
      i += f.a.a.b.b.a.bz(3, this.version);
      paramInt = i;
      if (this.hCp != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hCp);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.IbI);
      paramInt = i;
      if (this.IbJ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.IbJ);
      }
      i = paramInt;
      if (this.IbK != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.IbK);
      }
      i += f.a.a.b.b.a.bz(8, this.IbL);
      paramInt = i;
      if (this.IbM != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.IbM);
      }
      i = paramInt + f.a.a.b.b.a.bz(10, this.gxu) + f.a.a.b.b.a.bz(11, this.IbN) + f.a.a.b.b.a.bz(12, this.IbO);
      paramInt = i;
      if (this.IbP != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.IbP);
      }
      i = paramInt;
      if (this.HKh != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.HKh);
      }
      AppMethodBeat.o(176157);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(176157);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dwn localdwn = (dwn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(176157);
          return -1;
        case 1: 
          localdwn.title = locala.OmT.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 2: 
          localdwn.dwb = locala.OmT.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 3: 
          localdwn.version = locala.OmT.zc();
          AppMethodBeat.o(176157);
          return 0;
        case 4: 
          localdwn.hCp = locala.OmT.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 5: 
          localdwn.IbI = locala.OmT.zc();
          AppMethodBeat.o(176157);
          return 0;
        case 6: 
          localdwn.IbJ = locala.OmT.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 7: 
          localdwn.IbK = locala.OmT.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 8: 
          localdwn.IbL = locala.OmT.zc();
          AppMethodBeat.o(176157);
          return 0;
        case 9: 
          localdwn.IbM = locala.OmT.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 10: 
          localdwn.gxu = locala.OmT.zc();
          AppMethodBeat.o(176157);
          return 0;
        case 11: 
          localdwn.IbN = locala.OmT.zc();
          AppMethodBeat.o(176157);
          return 0;
        case 12: 
          localdwn.IbO = locala.OmT.zc();
          AppMethodBeat.o(176157);
          return 0;
        case 13: 
          localdwn.IbP = locala.OmT.readString();
          AppMethodBeat.o(176157);
          return 0;
        }
        localdwn.HKh = locala.OmT.readString();
        AppMethodBeat.o(176157);
        return 0;
      }
      AppMethodBeat.o(176157);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwn
 * JD-Core Version:    0.7.0.1
 */