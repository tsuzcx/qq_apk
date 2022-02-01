package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class wy
  extends com.tencent.mm.bw.a
{
  public int Erp;
  public int Erq;
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
    AppMethodBeat.i(50083);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.lRr != null) {
        paramVarArgs.d(2, this.lRr);
      }
      paramVarArgs.aR(3, this.Erp);
      paramVarArgs.aR(4, this.Erq);
      if (this.lRs != null) {
        paramVarArgs.d(5, this.lRs);
      }
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
      AppMethodBeat.o(50083);
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
      int i = paramInt;
      if (this.lRr != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.lRr);
      }
      i = i + f.a.a.b.b.a.bx(3, this.Erp) + f.a.a.b.b.a.bx(4, this.Erq);
      paramInt = i;
      if (this.lRs != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.lRs);
      }
      i = paramInt;
      if (this.djj != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.djj);
      }
      paramInt = i;
      if (this.lRt != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.lRt);
      }
      i = paramInt;
      if (this.lRu != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.lRu);
      }
      i += f.a.a.b.b.a.bx(9, this.lRv);
      paramInt = i;
      if (this.lRw != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.lRw);
      }
      i = f.a.a.b.b.a.bx(11, this.position);
      AppMethodBeat.o(50083);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(50083);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        wy localwy = (wy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50083);
          return -1;
        case 1: 
          localwy.username = locala.LVo.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 2: 
          localwy.lRr = locala.LVo.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 3: 
          localwy.Erp = locala.LVo.xF();
          AppMethodBeat.o(50083);
          return 0;
        case 4: 
          localwy.Erq = locala.LVo.xF();
          AppMethodBeat.o(50083);
          return 0;
        case 5: 
          localwy.lRs = locala.LVo.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 6: 
          localwy.djj = locala.LVo.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 7: 
          localwy.lRt = locala.LVo.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 8: 
          localwy.lRu = locala.LVo.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 9: 
          localwy.lRv = locala.LVo.xF();
          AppMethodBeat.o(50083);
          return 0;
        case 10: 
          localwy.lRw = locala.LVo.readString();
          AppMethodBeat.o(50083);
          return 0;
        }
        localwy.position = locala.LVo.xF();
        AppMethodBeat.o(50083);
        return 0;
      }
      AppMethodBeat.o(50083);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wy
 * JD-Core Version:    0.7.0.1
 */