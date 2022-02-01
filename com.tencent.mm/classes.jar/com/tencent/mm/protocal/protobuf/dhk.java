package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class dhk
  extends com.tencent.mm.bw.a
{
  public String DSy;
  public String hhs;
  public int weight;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124569);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DSy != null) {
        paramVarArgs.d(1, this.DSy);
      }
      if (this.hhs != null) {
        paramVarArgs.d(2, this.hhs);
      }
      paramVarArgs.aR(3, this.weight);
      AppMethodBeat.o(124569);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DSy == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.DSy) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hhs != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hhs);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.weight);
      AppMethodBeat.o(124569);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(124569);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dhk localdhk = (dhk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124569);
          return -1;
        case 1: 
          localdhk.DSy = locala.LVo.readString();
          AppMethodBeat.o(124569);
          return 0;
        case 2: 
          localdhk.hhs = locala.LVo.readString();
          AppMethodBeat.o(124569);
          return 0;
        }
        localdhk.weight = locala.LVo.xF();
        AppMethodBeat.o(124569);
        return 0;
      }
      AppMethodBeat.o(124569);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhk
 * JD-Core Version:    0.7.0.1
 */