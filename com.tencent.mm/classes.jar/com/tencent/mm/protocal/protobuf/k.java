package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  extends com.tencent.mm.bx.a
{
  public String Csi;
  public String Csj;
  public String Csw;
  public String Csy;
  public String Csz;
  public long dEb;
  public int role;
  public int state;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91322);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Csi != null) {
        paramVarArgs.d(1, this.Csi);
      }
      if (this.title != null) {
        paramVarArgs.d(2, this.title);
      }
      paramVarArgs.aG(3, this.dEb);
      if (this.Csw != null) {
        paramVarArgs.d(5, this.Csw);
      }
      paramVarArgs.aR(10, this.state);
      paramVarArgs.aR(11, this.role);
      if (this.Csy != null) {
        paramVarArgs.d(12, this.Csy);
      }
      if (this.Csj != null) {
        paramVarArgs.d(13, this.Csj);
      }
      if (this.Csz != null) {
        paramVarArgs.d(14, this.Csz);
      }
      AppMethodBeat.o(91322);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Csi == null) {
        break label674;
      }
    }
    label674:
    for (paramInt = f.a.a.b.b.a.e(1, this.Csi) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.title);
      }
      i += f.a.a.b.b.a.q(3, this.dEb);
      paramInt = i;
      if (this.Csw != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Csw);
      }
      i = paramInt + f.a.a.b.b.a.bA(10, this.state) + f.a.a.b.b.a.bA(11, this.role);
      paramInt = i;
      if (this.Csy != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.Csy);
      }
      i = paramInt;
      if (this.Csj != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.Csj);
      }
      paramInt = i;
      if (this.Csz != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.Csz);
      }
      AppMethodBeat.o(91322);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91322);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        k localk = (k)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 4: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        default: 
          AppMethodBeat.o(91322);
          return -1;
        case 1: 
          localk.Csi = locala.KhF.readString();
          AppMethodBeat.o(91322);
          return 0;
        case 2: 
          localk.title = locala.KhF.readString();
          AppMethodBeat.o(91322);
          return 0;
        case 3: 
          localk.dEb = locala.KhF.xT();
          AppMethodBeat.o(91322);
          return 0;
        case 5: 
          localk.Csw = locala.KhF.readString();
          AppMethodBeat.o(91322);
          return 0;
        case 10: 
          localk.state = locala.KhF.xS();
          AppMethodBeat.o(91322);
          return 0;
        case 11: 
          localk.role = locala.KhF.xS();
          AppMethodBeat.o(91322);
          return 0;
        case 12: 
          localk.Csy = locala.KhF.readString();
          AppMethodBeat.o(91322);
          return 0;
        case 13: 
          localk.Csj = locala.KhF.readString();
          AppMethodBeat.o(91322);
          return 0;
        }
        localk.Csz = locala.KhF.readString();
        AppMethodBeat.o(91322);
        return 0;
      }
      AppMethodBeat.o(91322);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.k
 * JD-Core Version:    0.7.0.1
 */