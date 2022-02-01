package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gp
  extends com.tencent.mm.bw.a
{
  public String DTv;
  public dod DTw;
  public String DTx;
  public String scope;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147757);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.scope != null) {
        paramVarArgs.d(1, this.scope);
      }
      if (this.DTv != null) {
        paramVarArgs.d(2, this.DTv);
      }
      paramVarArgs.aR(3, this.state);
      if (this.DTw != null)
      {
        paramVarArgs.ln(4, this.DTw.computeSize());
        this.DTw.writeFields(paramVarArgs);
      }
      if (this.DTx != null) {
        paramVarArgs.d(5, this.DTx);
      }
      AppMethodBeat.o(147757);
      return 0;
    }
    if (paramInt == 1) {
      if (this.scope == null) {
        break label534;
      }
    }
    label534:
    for (paramInt = f.a.a.b.b.a.e(1, this.scope) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DTv != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DTv);
      }
      i += f.a.a.b.b.a.bx(3, this.state);
      paramInt = i;
      if (this.DTw != null) {
        paramInt = i + f.a.a.a.lm(4, this.DTw.computeSize());
      }
      i = paramInt;
      if (this.DTx != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DTx);
      }
      AppMethodBeat.o(147757);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(147757);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        gp localgp = (gp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147757);
          return -1;
        case 1: 
          localgp.scope = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(147757);
          return 0;
        case 2: 
          localgp.DTv = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(147757);
          return 0;
        case 3: 
          localgp.state = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(147757);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dod();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dod)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localgp.DTw = ((dod)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147757);
          return 0;
        }
        localgp.DTx = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(147757);
        return 0;
      }
      AppMethodBeat.o(147757);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gp
 * JD-Core Version:    0.7.0.1
 */