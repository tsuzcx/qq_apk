package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bkj
  extends com.tencent.mm.bw.a
{
  public String DUJ;
  public String EhA;
  public String Md5;
  public String Name;
  public String Type;
  public String Url;
  public int ndD;
  
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
      paramVarArgs.aR(3, this.ndD);
      if (this.Md5 != null) {
        paramVarArgs.d(4, this.Md5);
      }
      if (this.DUJ != null) {
        paramVarArgs.d(5, this.DUJ);
      }
      if (this.EhA != null) {
        paramVarArgs.d(6, this.EhA);
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
      i += f.a.a.b.b.a.bx(3, this.ndD);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Md5);
      }
      i = paramInt;
      if (this.DUJ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DUJ);
      }
      paramInt = i;
      if (this.EhA != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EhA);
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
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32323);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bkj localbkj = (bkj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32323);
          return -1;
        case 1: 
          localbkj.Type = locala.LVo.readString();
          AppMethodBeat.o(32323);
          return 0;
        case 2: 
          localbkj.Name = locala.LVo.readString();
          AppMethodBeat.o(32323);
          return 0;
        case 3: 
          localbkj.ndD = locala.LVo.xF();
          AppMethodBeat.o(32323);
          return 0;
        case 4: 
          localbkj.Md5 = locala.LVo.readString();
          AppMethodBeat.o(32323);
          return 0;
        case 5: 
          localbkj.DUJ = locala.LVo.readString();
          AppMethodBeat.o(32323);
          return 0;
        case 6: 
          localbkj.EhA = locala.LVo.readString();
          AppMethodBeat.o(32323);
          return 0;
        }
        localbkj.Url = locala.LVo.readString();
        AppMethodBeat.o(32323);
        return 0;
      }
      AppMethodBeat.o(32323);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkj
 * JD-Core Version:    0.7.0.1
 */