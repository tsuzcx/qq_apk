package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ik
  extends com.tencent.mm.bx.a
{
  public String CPf;
  public String FBn;
  public String FBo;
  public String FBp;
  public String FBq;
  public String dkR;
  public String uJF;
  public String wBI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91355);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FBn != null) {
        paramVarArgs.d(1, this.FBn);
      }
      if (this.CPf != null) {
        paramVarArgs.d(2, this.CPf);
      }
      if (this.dkR != null) {
        paramVarArgs.d(3, this.dkR);
      }
      if (this.wBI != null) {
        paramVarArgs.d(4, this.wBI);
      }
      if (this.uJF != null) {
        paramVarArgs.d(5, this.uJF);
      }
      if (this.FBo != null) {
        paramVarArgs.d(6, this.FBo);
      }
      if (this.FBp != null) {
        paramVarArgs.d(7, this.FBp);
      }
      if (this.FBq != null) {
        paramVarArgs.d(8, this.FBq);
      }
      AppMethodBeat.o(91355);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FBn == null) {
        break label642;
      }
    }
    label642:
    for (int i = f.a.a.b.b.a.e(1, this.FBn) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CPf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CPf);
      }
      i = paramInt;
      if (this.dkR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dkR);
      }
      paramInt = i;
      if (this.wBI != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.wBI);
      }
      i = paramInt;
      if (this.uJF != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.uJF);
      }
      paramInt = i;
      if (this.FBo != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FBo);
      }
      i = paramInt;
      if (this.FBp != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FBp);
      }
      paramInt = i;
      if (this.FBq != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FBq);
      }
      AppMethodBeat.o(91355);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91355);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ik localik = (ik)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91355);
          return -1;
        case 1: 
          localik.FBn = locala.NPN.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 2: 
          localik.CPf = locala.NPN.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 3: 
          localik.dkR = locala.NPN.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 4: 
          localik.wBI = locala.NPN.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 5: 
          localik.uJF = locala.NPN.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 6: 
          localik.FBo = locala.NPN.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 7: 
          localik.FBp = locala.NPN.readString();
          AppMethodBeat.o(91355);
          return 0;
        }
        localik.FBq = locala.NPN.readString();
        AppMethodBeat.o(91355);
        return 0;
      }
      AppMethodBeat.o(91355);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ik
 * JD-Core Version:    0.7.0.1
 */