package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class afa
  extends com.tencent.mm.bw.a
{
  public int Exv;
  public int count;
  public String djj;
  public String lRr;
  public String lRs;
  public String lRt;
  public String lRu;
  public int lRv;
  public String lRw;
  public int position;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50085);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      paramVarArgs.aR(2, this.count);
      if (this.lRr != null) {
        paramVarArgs.d(3, this.lRr);
      }
      if (this.lRs != null) {
        paramVarArgs.d(4, this.lRs);
      }
      paramVarArgs.aR(5, this.Exv);
      if (this.djj != null) {
        paramVarArgs.d(6, this.djj);
      }
      if (this.lRt != null) {
        paramVarArgs.d(7, this.lRt);
      }
      if (this.lRu != null) {
        paramVarArgs.d(8, this.lRu);
      }
      paramVarArgs.aR(9, this.lRv);
      if (this.lRw != null) {
        paramVarArgs.d(10, this.lRw);
      }
      paramVarArgs.aR(11, this.position);
      AppMethodBeat.o(50085);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label762;
      }
    }
    label762:
    for (paramInt = f.a.a.b.b.a.e(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.count);
      paramInt = i;
      if (this.lRr != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.lRr);
      }
      i = paramInt;
      if (this.lRs != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.lRs);
      }
      i += f.a.a.b.b.a.bx(5, this.Exv);
      paramInt = i;
      if (this.djj != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.djj);
      }
      i = paramInt;
      if (this.lRt != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.lRt);
      }
      paramInt = i;
      if (this.lRu != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.lRu);
      }
      i = paramInt + f.a.a.b.b.a.bx(9, this.lRv);
      paramInt = i;
      if (this.lRw != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.lRw);
      }
      i = f.a.a.b.b.a.bx(11, this.position);
      AppMethodBeat.o(50085);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(50085);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        afa localafa = (afa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50085);
          return -1;
        case 1: 
          localafa.username = locala.LVo.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 2: 
          localafa.count = locala.LVo.xF();
          AppMethodBeat.o(50085);
          return 0;
        case 3: 
          localafa.lRr = locala.LVo.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 4: 
          localafa.lRs = locala.LVo.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 5: 
          localafa.Exv = locala.LVo.xF();
          AppMethodBeat.o(50085);
          return 0;
        case 6: 
          localafa.djj = locala.LVo.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 7: 
          localafa.lRt = locala.LVo.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 8: 
          localafa.lRu = locala.LVo.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 9: 
          localafa.lRv = locala.LVo.xF();
          AppMethodBeat.o(50085);
          return 0;
        case 10: 
          localafa.lRw = locala.LVo.readString();
          AppMethodBeat.o(50085);
          return 0;
        }
        localafa.position = locala.LVo.xF();
        AppMethodBeat.o(50085);
        return 0;
      }
      AppMethodBeat.o(50085);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afa
 * JD-Core Version:    0.7.0.1
 */