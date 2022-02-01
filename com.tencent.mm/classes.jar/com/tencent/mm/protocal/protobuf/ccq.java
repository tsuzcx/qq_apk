package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ccq
  extends com.tencent.mm.bw.a
{
  public int DQN;
  public int Frb;
  public String djj;
  public String hED;
  public String lRr;
  public String lRs;
  public String lRw;
  public int position;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50096);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.lRr != null) {
        paramVarArgs.d(2, this.lRr);
      }
      if (this.hED != null) {
        paramVarArgs.d(3, this.hED);
      }
      if (this.lRs != null) {
        paramVarArgs.d(4, this.lRs);
      }
      if (this.djj != null) {
        paramVarArgs.d(5, this.djj);
      }
      if (this.lRw != null) {
        paramVarArgs.d(6, this.lRw);
      }
      paramVarArgs.aR(7, this.position);
      paramVarArgs.aR(8, this.Frb);
      paramVarArgs.aR(9, this.DQN);
      AppMethodBeat.o(50096);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label658;
      }
    }
    label658:
    for (int i = f.a.a.b.b.a.e(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lRr != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.lRr);
      }
      i = paramInt;
      if (this.hED != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hED);
      }
      paramInt = i;
      if (this.lRs != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.lRs);
      }
      i = paramInt;
      if (this.djj != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.djj);
      }
      paramInt = i;
      if (this.lRw != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.lRw);
      }
      i = f.a.a.b.b.a.bx(7, this.position);
      int j = f.a.a.b.b.a.bx(8, this.Frb);
      int k = f.a.a.b.b.a.bx(9, this.DQN);
      AppMethodBeat.o(50096);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(50096);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ccq localccq = (ccq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50096);
          return -1;
        case 1: 
          localccq.username = locala.LVo.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 2: 
          localccq.lRr = locala.LVo.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 3: 
          localccq.hED = locala.LVo.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 4: 
          localccq.lRs = locala.LVo.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 5: 
          localccq.djj = locala.LVo.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 6: 
          localccq.lRw = locala.LVo.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 7: 
          localccq.position = locala.LVo.xF();
          AppMethodBeat.o(50096);
          return 0;
        case 8: 
          localccq.Frb = locala.LVo.xF();
          AppMethodBeat.o(50096);
          return 0;
        }
        localccq.DQN = locala.LVo.xF();
        AppMethodBeat.o(50096);
        return 0;
      }
      AppMethodBeat.o(50096);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccq
 * JD-Core Version:    0.7.0.1
 */