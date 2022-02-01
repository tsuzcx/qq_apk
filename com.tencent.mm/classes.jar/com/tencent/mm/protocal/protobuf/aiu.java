package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class aiu
  extends com.tencent.mm.bw.a
{
  public int EDA;
  public xb EDB;
  public int EDy;
  public b EDz;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168937);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EDy);
      paramVarArgs.aR(2, this.scene);
      if (this.EDz != null) {
        paramVarArgs.c(3, this.EDz);
      }
      paramVarArgs.aR(4, this.EDA);
      if (this.EDB != null)
      {
        paramVarArgs.ln(5, this.EDB.computeSize());
        this.EDB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168937);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.EDy) + 0 + f.a.a.b.b.a.bx(2, this.scene);
      paramInt = i;
      if (this.EDz != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.EDz);
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.EDA);
      paramInt = i;
      if (this.EDB != null) {
        paramInt = i + f.a.a.a.lm(5, this.EDB.computeSize());
      }
      AppMethodBeat.o(168937);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(168937);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      aiu localaiu = (aiu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(168937);
        return -1;
      case 1: 
        localaiu.EDy = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(168937);
        return 0;
      case 2: 
        localaiu.scene = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(168937);
        return 0;
      case 3: 
        localaiu.EDz = ((f.a.a.a.a)localObject1).LVo.gfk();
        AppMethodBeat.o(168937);
        return 0;
      case 4: 
        localaiu.EDA = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(168937);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new xb();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((xb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localaiu.EDB = ((xb)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(168937);
      return 0;
    }
    AppMethodBeat.o(168937);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aiu
 * JD-Core Version:    0.7.0.1
 */