package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class aql
  extends com.tencent.mm.bw.a
{
  public String DPS;
  public String EJo;
  public String EJv;
  public int Edq;
  public String fZx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42637);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.fZx == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppID");
        AppMethodBeat.o(42637);
        throw paramVarArgs;
      }
      if (this.EJv == null)
      {
        paramVarArgs = new b("Not all required fields were included: RecommendKey");
        AppMethodBeat.o(42637);
        throw paramVarArgs;
      }
      if (this.fZx != null) {
        paramVarArgs.d(1, this.fZx);
      }
      if (this.EJv != null) {
        paramVarArgs.d(2, this.EJv);
      }
      if (this.DPS != null) {
        paramVarArgs.d(3, this.DPS);
      }
      paramVarArgs.aR(4, this.Edq);
      if (this.EJo != null) {
        paramVarArgs.d(5, this.EJo);
      }
      AppMethodBeat.o(42637);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fZx == null) {
        break label534;
      }
    }
    label534:
    for (int i = f.a.a.b.b.a.e(1, this.fZx) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EJv != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EJv);
      }
      i = paramInt;
      if (this.DPS != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DPS);
      }
      i += f.a.a.b.b.a.bx(4, this.Edq);
      paramInt = i;
      if (this.EJo != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EJo);
      }
      AppMethodBeat.o(42637);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.fZx == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppID");
          AppMethodBeat.o(42637);
          throw paramVarArgs;
        }
        if (this.EJv == null)
        {
          paramVarArgs = new b("Not all required fields were included: RecommendKey");
          AppMethodBeat.o(42637);
          throw paramVarArgs;
        }
        AppMethodBeat.o(42637);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aql localaql = (aql)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(42637);
          return -1;
        case 1: 
          localaql.fZx = locala.LVo.readString();
          AppMethodBeat.o(42637);
          return 0;
        case 2: 
          localaql.EJv = locala.LVo.readString();
          AppMethodBeat.o(42637);
          return 0;
        case 3: 
          localaql.DPS = locala.LVo.readString();
          AppMethodBeat.o(42637);
          return 0;
        case 4: 
          localaql.Edq = locala.LVo.xF();
          AppMethodBeat.o(42637);
          return 0;
        }
        localaql.EJo = locala.LVo.readString();
        AppMethodBeat.o(42637);
        return 0;
      }
      AppMethodBeat.o(42637);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aql
 * JD-Core Version:    0.7.0.1
 */