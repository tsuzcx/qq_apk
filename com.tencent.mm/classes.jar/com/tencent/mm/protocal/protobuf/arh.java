package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class arh
  extends com.tencent.mm.bw.a
{
  public String EKp;
  public String EKq;
  public b EKr;
  public int fZz;
  public String tlT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(192711);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.tlT != null) {
        paramVarArgs.d(1, this.tlT);
      }
      if (this.EKp != null) {
        paramVarArgs.d(2, this.EKp);
      }
      if (this.EKq != null) {
        paramVarArgs.d(3, this.EKq);
      }
      paramVarArgs.aR(4, this.fZz);
      if (this.EKr != null) {
        paramVarArgs.c(5, this.EKr);
      }
      AppMethodBeat.o(192711);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tlT == null) {
        break label438;
      }
    }
    label438:
    for (int i = f.a.a.b.b.a.e(1, this.tlT) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EKp != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EKp);
      }
      i = paramInt;
      if (this.EKq != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EKq);
      }
      i += f.a.a.b.b.a.bx(4, this.fZz);
      paramInt = i;
      if (this.EKr != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.EKr);
      }
      AppMethodBeat.o(192711);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(192711);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        arh localarh = (arh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(192711);
          return -1;
        case 1: 
          localarh.tlT = locala.LVo.readString();
          AppMethodBeat.o(192711);
          return 0;
        case 2: 
          localarh.EKp = locala.LVo.readString();
          AppMethodBeat.o(192711);
          return 0;
        case 3: 
          localarh.EKq = locala.LVo.readString();
          AppMethodBeat.o(192711);
          return 0;
        case 4: 
          localarh.fZz = locala.LVo.xF();
          AppMethodBeat.o(192711);
          return 0;
        }
        localarh.EKr = locala.LVo.gfk();
        AppMethodBeat.o(192711);
        return 0;
      }
      AppMethodBeat.o(192711);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arh
 * JD-Core Version:    0.7.0.1
 */