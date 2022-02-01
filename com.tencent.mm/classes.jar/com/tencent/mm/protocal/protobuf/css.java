package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class css
  extends com.tencent.mm.bx.a
{
  public String EgH;
  public String Ekw;
  public int Height;
  public String MD5;
  public int Width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32452);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.MD5 != null) {
        paramVarArgs.d(1, this.MD5);
      }
      paramVarArgs.aR(2, this.Width);
      paramVarArgs.aR(3, this.Height);
      if (this.EgH != null) {
        paramVarArgs.d(4, this.EgH);
      }
      if (this.Ekw != null) {
        paramVarArgs.d(5, this.Ekw);
      }
      AppMethodBeat.o(32452);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MD5 == null) {
        break label433;
      }
    }
    label433:
    for (paramInt = f.a.a.b.b.a.e(1, this.MD5) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.Width) + f.a.a.b.b.a.bA(3, this.Height);
      paramInt = i;
      if (this.EgH != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EgH);
      }
      i = paramInt;
      if (this.Ekw != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Ekw);
      }
      AppMethodBeat.o(32452);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32452);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        css localcss = (css)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32452);
          return -1;
        case 1: 
          localcss.MD5 = locala.KhF.readString();
          AppMethodBeat.o(32452);
          return 0;
        case 2: 
          localcss.Width = locala.KhF.xS();
          AppMethodBeat.o(32452);
          return 0;
        case 3: 
          localcss.Height = locala.KhF.xS();
          AppMethodBeat.o(32452);
          return 0;
        case 4: 
          localcss.EgH = locala.KhF.readString();
          AppMethodBeat.o(32452);
          return 0;
        }
        localcss.Ekw = locala.KhF.readString();
        AppMethodBeat.o(32452);
        return 0;
      }
      AppMethodBeat.o(32452);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.css
 * JD-Core Version:    0.7.0.1
 */