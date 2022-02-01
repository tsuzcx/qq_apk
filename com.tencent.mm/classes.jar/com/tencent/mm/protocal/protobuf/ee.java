package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ee
  extends com.tencent.mm.bw.a
{
  public int DQN;
  public String djj;
  public String hED;
  public String lRs;
  public String lRw;
  public int position;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50080);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.hED != null) {
        paramVarArgs.d(2, this.hED);
      }
      if (this.lRs != null) {
        paramVarArgs.d(3, this.lRs);
      }
      if (this.djj != null) {
        paramVarArgs.d(4, this.djj);
      }
      if (this.lRw != null) {
        paramVarArgs.d(5, this.lRw);
      }
      paramVarArgs.aR(6, this.position);
      paramVarArgs.aR(7, this.DQN);
      AppMethodBeat.o(50080);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label550;
      }
    }
    label550:
    for (int i = f.a.a.b.b.a.e(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hED != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hED);
      }
      i = paramInt;
      if (this.lRs != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.lRs);
      }
      paramInt = i;
      if (this.djj != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.djj);
      }
      i = paramInt;
      if (this.lRw != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.lRw);
      }
      paramInt = f.a.a.b.b.a.bx(6, this.position);
      int j = f.a.a.b.b.a.bx(7, this.DQN);
      AppMethodBeat.o(50080);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(50080);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ee localee = (ee)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50080);
          return -1;
        case 1: 
          localee.username = locala.LVo.readString();
          AppMethodBeat.o(50080);
          return 0;
        case 2: 
          localee.hED = locala.LVo.readString();
          AppMethodBeat.o(50080);
          return 0;
        case 3: 
          localee.lRs = locala.LVo.readString();
          AppMethodBeat.o(50080);
          return 0;
        case 4: 
          localee.djj = locala.LVo.readString();
          AppMethodBeat.o(50080);
          return 0;
        case 5: 
          localee.lRw = locala.LVo.readString();
          AppMethodBeat.o(50080);
          return 0;
        case 6: 
          localee.position = locala.LVo.xF();
          AppMethodBeat.o(50080);
          return 0;
        }
        localee.DQN = locala.LVo.xF();
        AppMethodBeat.o(50080);
        return 0;
      }
      AppMethodBeat.o(50080);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ee
 * JD-Core Version:    0.7.0.1
 */