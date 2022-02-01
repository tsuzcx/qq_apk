package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bh
  extends com.tencent.mm.bw.a
{
  public String AZE;
  public String AZF;
  public String BGR;
  public int BGS;
  public String dlQ;
  public String drM;
  public String title;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91345);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.d(1, this.url);
      }
      if (this.dlQ != null) {
        paramVarArgs.d(2, this.dlQ);
      }
      if (this.drM != null) {
        paramVarArgs.d(3, this.drM);
      }
      if (this.BGR != null) {
        paramVarArgs.d(4, this.BGR);
      }
      if (this.title != null) {
        paramVarArgs.d(5, this.title);
      }
      if (this.AZE != null) {
        paramVarArgs.d(6, this.AZE);
      }
      if (this.AZF != null) {
        paramVarArgs.d(7, this.AZF);
      }
      paramVarArgs.aR(8, this.BGS);
      AppMethodBeat.o(91345);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label626;
      }
    }
    label626:
    for (int i = f.a.a.b.b.a.e(1, this.url) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dlQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dlQ);
      }
      i = paramInt;
      if (this.drM != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.drM);
      }
      paramInt = i;
      if (this.BGR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.BGR);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.title);
      }
      paramInt = i;
      if (this.AZE != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.AZE);
      }
      i = paramInt;
      if (this.AZF != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.AZF);
      }
      paramInt = f.a.a.b.b.a.bx(8, this.BGS);
      AppMethodBeat.o(91345);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91345);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bh localbh = (bh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91345);
          return -1;
        case 1: 
          localbh.url = locala.LVo.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 2: 
          localbh.dlQ = locala.LVo.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 3: 
          localbh.drM = locala.LVo.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 4: 
          localbh.BGR = locala.LVo.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 5: 
          localbh.title = locala.LVo.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 6: 
          localbh.AZE = locala.LVo.readString();
          AppMethodBeat.o(91345);
          return 0;
        case 7: 
          localbh.AZF = locala.LVo.readString();
          AppMethodBeat.o(91345);
          return 0;
        }
        localbh.BGS = locala.LVo.xF();
        AppMethodBeat.o(91345);
        return 0;
      }
      AppMethodBeat.o(91345);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bh
 * JD-Core Version:    0.7.0.1
 */