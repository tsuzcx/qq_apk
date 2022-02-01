package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ckx
  extends com.tencent.mm.bw.a
{
  public String Hxh;
  public String Hxi;
  public String Hxj;
  public String Hxk;
  public boolean Hxl;
  public String Hxm;
  public String dlT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72547);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hxh != null) {
        paramVarArgs.d(1, this.Hxh);
      }
      if (this.Hxi != null) {
        paramVarArgs.d(2, this.Hxi);
      }
      if (this.dlT != null) {
        paramVarArgs.d(3, this.dlT);
      }
      if (this.Hxj != null) {
        paramVarArgs.d(4, this.Hxj);
      }
      if (this.Hxk != null) {
        paramVarArgs.d(5, this.Hxk);
      }
      paramVarArgs.bC(6, this.Hxl);
      if (this.Hxm != null) {
        paramVarArgs.d(7, this.Hxm);
      }
      AppMethodBeat.o(72547);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hxh == null) {
        break label558;
      }
    }
    label558:
    for (int i = f.a.a.b.b.a.e(1, this.Hxh) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hxi != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Hxi);
      }
      i = paramInt;
      if (this.dlT != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dlT);
      }
      paramInt = i;
      if (this.Hxj != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Hxj);
      }
      i = paramInt;
      if (this.Hxk != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Hxk);
      }
      i += f.a.a.b.b.a.amF(6);
      paramInt = i;
      if (this.Hxm != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Hxm);
      }
      AppMethodBeat.o(72547);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72547);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ckx localckx = (ckx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72547);
          return -1;
        case 1: 
          localckx.Hxh = locala.OmT.readString();
          AppMethodBeat.o(72547);
          return 0;
        case 2: 
          localckx.Hxi = locala.OmT.readString();
          AppMethodBeat.o(72547);
          return 0;
        case 3: 
          localckx.dlT = locala.OmT.readString();
          AppMethodBeat.o(72547);
          return 0;
        case 4: 
          localckx.Hxj = locala.OmT.readString();
          AppMethodBeat.o(72547);
          return 0;
        case 5: 
          localckx.Hxk = locala.OmT.readString();
          AppMethodBeat.o(72547);
          return 0;
        case 6: 
          localckx.Hxl = locala.OmT.gvY();
          AppMethodBeat.o(72547);
          return 0;
        }
        localckx.Hxm = locala.OmT.readString();
        AppMethodBeat.o(72547);
        return 0;
      }
      AppMethodBeat.o(72547);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckx
 * JD-Core Version:    0.7.0.1
 */