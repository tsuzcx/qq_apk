package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cyh
  extends com.tencent.mm.bw.a
{
  public String FHA;
  public String FHB;
  public int FHC;
  public String FHD;
  public String FHy;
  public String FHz;
  public String content;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153299);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.content != null) {
        paramVarArgs.d(1, this.content);
      }
      if (this.FHy != null) {
        paramVarArgs.d(2, this.FHy);
      }
      if (this.FHz != null) {
        paramVarArgs.d(3, this.FHz);
      }
      if (this.FHA != null) {
        paramVarArgs.d(4, this.FHA);
      }
      if (this.FHB != null) {
        paramVarArgs.d(5, this.FHB);
      }
      paramVarArgs.aR(6, this.FHC);
      paramVarArgs.aR(7, this.state);
      if (this.FHD != null) {
        paramVarArgs.d(8, this.FHD);
      }
      AppMethodBeat.o(153299);
      return 0;
    }
    if (paramInt == 1) {
      if (this.content == null) {
        break label606;
      }
    }
    label606:
    for (int i = f.a.a.b.b.a.e(1, this.content) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FHy != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FHy);
      }
      i = paramInt;
      if (this.FHz != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FHz);
      }
      paramInt = i;
      if (this.FHA != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FHA);
      }
      i = paramInt;
      if (this.FHB != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FHB);
      }
      i = i + f.a.a.b.b.a.bx(6, this.FHC) + f.a.a.b.b.a.bx(7, this.state);
      paramInt = i;
      if (this.FHD != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FHD);
      }
      AppMethodBeat.o(153299);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(153299);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cyh localcyh = (cyh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153299);
          return -1;
        case 1: 
          localcyh.content = locala.LVo.readString();
          AppMethodBeat.o(153299);
          return 0;
        case 2: 
          localcyh.FHy = locala.LVo.readString();
          AppMethodBeat.o(153299);
          return 0;
        case 3: 
          localcyh.FHz = locala.LVo.readString();
          AppMethodBeat.o(153299);
          return 0;
        case 4: 
          localcyh.FHA = locala.LVo.readString();
          AppMethodBeat.o(153299);
          return 0;
        case 5: 
          localcyh.FHB = locala.LVo.readString();
          AppMethodBeat.o(153299);
          return 0;
        case 6: 
          localcyh.FHC = locala.LVo.xF();
          AppMethodBeat.o(153299);
          return 0;
        case 7: 
          localcyh.state = locala.LVo.xF();
          AppMethodBeat.o(153299);
          return 0;
        }
        localcyh.FHD = locala.LVo.readString();
        AppMethodBeat.o(153299);
        return 0;
      }
      AppMethodBeat.o(153299);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyh
 * JD-Core Version:    0.7.0.1
 */