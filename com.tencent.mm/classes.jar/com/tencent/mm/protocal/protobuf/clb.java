package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class clb
  extends com.tencent.mm.bw.a
{
  public String Gqq;
  public boolean Hxs;
  public boolean Hxt;
  public String bxJ;
  public String dAs;
  public String moI;
  public String moJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123634);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dAs != null) {
        paramVarArgs.d(1, this.dAs);
      }
      if (this.Gqq != null) {
        paramVarArgs.d(2, this.Gqq);
      }
      paramVarArgs.bC(3, this.Hxs);
      paramVarArgs.bC(4, this.Hxt);
      if (this.moI != null) {
        paramVarArgs.d(5, this.moI);
      }
      if (this.bxJ != null) {
        paramVarArgs.d(6, this.bxJ);
      }
      if (this.moJ != null) {
        paramVarArgs.d(7, this.moJ);
      }
      AppMethodBeat.o(123634);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dAs == null) {
        break label538;
      }
    }
    label538:
    for (paramInt = f.a.a.b.b.a.e(1, this.dAs) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Gqq != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Gqq);
      }
      i = i + f.a.a.b.b.a.amF(3) + f.a.a.b.b.a.amF(4);
      paramInt = i;
      if (this.moI != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.moI);
      }
      i = paramInt;
      if (this.bxJ != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.bxJ);
      }
      paramInt = i;
      if (this.moJ != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.moJ);
      }
      AppMethodBeat.o(123634);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(123634);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        clb localclb = (clb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123634);
          return -1;
        case 1: 
          localclb.dAs = locala.OmT.readString();
          AppMethodBeat.o(123634);
          return 0;
        case 2: 
          localclb.Gqq = locala.OmT.readString();
          AppMethodBeat.o(123634);
          return 0;
        case 3: 
          localclb.Hxs = locala.OmT.gvY();
          AppMethodBeat.o(123634);
          return 0;
        case 4: 
          localclb.Hxt = locala.OmT.gvY();
          AppMethodBeat.o(123634);
          return 0;
        case 5: 
          localclb.moI = locala.OmT.readString();
          AppMethodBeat.o(123634);
          return 0;
        case 6: 
          localclb.bxJ = locala.OmT.readString();
          AppMethodBeat.o(123634);
          return 0;
        }
        localclb.moJ = locala.OmT.readString();
        AppMethodBeat.o(123634);
        return 0;
      }
      AppMethodBeat.o(123634);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clb
 * JD-Core Version:    0.7.0.1
 */