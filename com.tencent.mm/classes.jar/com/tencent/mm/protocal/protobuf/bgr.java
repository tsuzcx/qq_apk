package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bgr
  extends com.tencent.mm.bx.a
{
  public String CCm;
  public String COP;
  public String Md5;
  public String Name;
  public String Type;
  public String Url;
  public int mBC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32323);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Type != null) {
        paramVarArgs.d(1, this.Type);
      }
      if (this.Name != null) {
        paramVarArgs.d(2, this.Name);
      }
      paramVarArgs.aR(3, this.mBC);
      if (this.Md5 != null) {
        paramVarArgs.d(4, this.Md5);
      }
      if (this.CCm != null) {
        paramVarArgs.d(5, this.CCm);
      }
      if (this.COP != null) {
        paramVarArgs.d(6, this.COP);
      }
      if (this.Url != null) {
        paramVarArgs.d(7, this.Url);
      }
      AppMethodBeat.o(32323);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Type == null) {
        break label575;
      }
    }
    label575:
    for (paramInt = f.a.a.b.b.a.e(1, this.Type) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Name != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Name);
      }
      i += f.a.a.b.b.a.bA(3, this.mBC);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Md5);
      }
      i = paramInt;
      if (this.CCm != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CCm);
      }
      paramInt = i;
      if (this.COP != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.COP);
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Url);
      }
      AppMethodBeat.o(32323);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32323);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bgr localbgr = (bgr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32323);
          return -1;
        case 1: 
          localbgr.Type = locala.KhF.readString();
          AppMethodBeat.o(32323);
          return 0;
        case 2: 
          localbgr.Name = locala.KhF.readString();
          AppMethodBeat.o(32323);
          return 0;
        case 3: 
          localbgr.mBC = locala.KhF.xS();
          AppMethodBeat.o(32323);
          return 0;
        case 4: 
          localbgr.Md5 = locala.KhF.readString();
          AppMethodBeat.o(32323);
          return 0;
        case 5: 
          localbgr.CCm = locala.KhF.readString();
          AppMethodBeat.o(32323);
          return 0;
        case 6: 
          localbgr.COP = locala.KhF.readString();
          AppMethodBeat.o(32323);
          return 0;
        }
        localbgr.Url = locala.KhF.readString();
        AppMethodBeat.o(32323);
        return 0;
      }
      AppMethodBeat.o(32323);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgr
 * JD-Core Version:    0.7.0.1
 */