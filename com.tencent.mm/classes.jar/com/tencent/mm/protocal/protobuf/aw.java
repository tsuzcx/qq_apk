package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aw
  extends com.tencent.mm.bx.a
{
  public int Fsf;
  public String Fsg;
  public String Fsh;
  public int Fsi;
  public int Fsj;
  public String Fsk;
  public int Fsl;
  public String Fsm;
  public String Fsn;
  public int Fso;
  public String Fsp;
  public String jdh;
  public int nDG;
  public String nDo;
  public String nEt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133142);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nDo != null) {
        paramVarArgs.d(1, this.nDo);
      }
      if (this.nEt != null) {
        paramVarArgs.d(2, this.nEt);
      }
      paramVarArgs.aS(3, this.Fsf);
      if (this.Fsg != null) {
        paramVarArgs.d(4, this.Fsg);
      }
      if (this.Fsh != null) {
        paramVarArgs.d(5, this.Fsh);
      }
      if (this.jdh != null) {
        paramVarArgs.d(6, this.jdh);
      }
      paramVarArgs.aS(8, this.nDG);
      paramVarArgs.aS(9, this.Fsi);
      paramVarArgs.aS(10, this.Fsj);
      if (this.Fsk != null) {
        paramVarArgs.d(11, this.Fsk);
      }
      paramVarArgs.aS(12, this.Fsl);
      if (this.Fsm != null) {
        paramVarArgs.d(13, this.Fsm);
      }
      if (this.Fsn != null) {
        paramVarArgs.d(14, this.Fsn);
      }
      paramVarArgs.aS(15, this.Fso);
      if (this.Fsp != null) {
        paramVarArgs.d(16, this.Fsp);
      }
      AppMethodBeat.o(133142);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nDo == null) {
        break label978;
      }
    }
    label978:
    for (paramInt = f.a.a.b.b.a.e(1, this.nDo) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nEt != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nEt);
      }
      i += f.a.a.b.b.a.bz(3, this.Fsf);
      paramInt = i;
      if (this.Fsg != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Fsg);
      }
      i = paramInt;
      if (this.Fsh != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Fsh);
      }
      paramInt = i;
      if (this.jdh != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.jdh);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.nDG) + f.a.a.b.b.a.bz(9, this.Fsi) + f.a.a.b.b.a.bz(10, this.Fsj);
      paramInt = i;
      if (this.Fsk != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Fsk);
      }
      i = paramInt + f.a.a.b.b.a.bz(12, this.Fsl);
      paramInt = i;
      if (this.Fsm != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.Fsm);
      }
      i = paramInt;
      if (this.Fsn != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.Fsn);
      }
      i += f.a.a.b.b.a.bz(15, this.Fso);
      paramInt = i;
      if (this.Fsp != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.Fsp);
      }
      AppMethodBeat.o(133142);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(133142);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aw localaw = (aw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 7: 
        default: 
          AppMethodBeat.o(133142);
          return -1;
        case 1: 
          localaw.nDo = locala.NPN.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 2: 
          localaw.nEt = locala.NPN.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 3: 
          localaw.Fsf = locala.NPN.zc();
          AppMethodBeat.o(133142);
          return 0;
        case 4: 
          localaw.Fsg = locala.NPN.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 5: 
          localaw.Fsh = locala.NPN.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 6: 
          localaw.jdh = locala.NPN.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 8: 
          localaw.nDG = locala.NPN.zc();
          AppMethodBeat.o(133142);
          return 0;
        case 9: 
          localaw.Fsi = locala.NPN.zc();
          AppMethodBeat.o(133142);
          return 0;
        case 10: 
          localaw.Fsj = locala.NPN.zc();
          AppMethodBeat.o(133142);
          return 0;
        case 11: 
          localaw.Fsk = locala.NPN.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 12: 
          localaw.Fsl = locala.NPN.zc();
          AppMethodBeat.o(133142);
          return 0;
        case 13: 
          localaw.Fsm = locala.NPN.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 14: 
          localaw.Fsn = locala.NPN.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 15: 
          localaw.Fso = locala.NPN.zc();
          AppMethodBeat.o(133142);
          return 0;
        }
        localaw.Fsp = locala.NPN.readString();
        AppMethodBeat.o(133142);
        return 0;
      }
      AppMethodBeat.o(133142);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aw
 * JD-Core Version:    0.7.0.1
 */