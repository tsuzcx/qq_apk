package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ccg
  extends com.tencent.mm.bx.a
{
  public String FRw;
  public int GVY;
  public int GVZ;
  public String Gdh;
  public String dDH;
  public String desc;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91555);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      if (this.Gdh != null) {
        paramVarArgs.d(3, this.Gdh);
      }
      paramVarArgs.aS(4, this.GVY);
      paramVarArgs.aS(5, this.GVZ);
      if (this.FRw != null) {
        paramVarArgs.d(6, this.FRw);
      }
      if (this.dDH != null) {
        paramVarArgs.d(7, this.dDH);
      }
      AppMethodBeat.o(91555);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label546;
      }
    }
    label546:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.desc);
      }
      i = paramInt;
      if (this.Gdh != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gdh);
      }
      i = i + f.a.a.b.b.a.bz(4, this.GVY) + f.a.a.b.b.a.bz(5, this.GVZ);
      paramInt = i;
      if (this.FRw != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FRw);
      }
      i = paramInt;
      if (this.dDH != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.dDH);
      }
      AppMethodBeat.o(91555);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91555);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ccg localccg = (ccg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91555);
          return -1;
        case 1: 
          localccg.title = locala.NPN.readString();
          AppMethodBeat.o(91555);
          return 0;
        case 2: 
          localccg.desc = locala.NPN.readString();
          AppMethodBeat.o(91555);
          return 0;
        case 3: 
          localccg.Gdh = locala.NPN.readString();
          AppMethodBeat.o(91555);
          return 0;
        case 4: 
          localccg.GVY = locala.NPN.zc();
          AppMethodBeat.o(91555);
          return 0;
        case 5: 
          localccg.GVZ = locala.NPN.zc();
          AppMethodBeat.o(91555);
          return 0;
        case 6: 
          localccg.FRw = locala.NPN.readString();
          AppMethodBeat.o(91555);
          return 0;
        }
        localccg.dDH = locala.NPN.readString();
        AppMethodBeat.o(91555);
        return 0;
      }
      AppMethodBeat.o(91555);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccg
 * JD-Core Version:    0.7.0.1
 */