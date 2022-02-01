package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class blo
  extends com.tencent.mm.bw.a
{
  public String DXX;
  public String Etm;
  public crm Fbd;
  public int Fbe;
  public String ncR;
  public int pAs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155423);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fbd == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(155423);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.pAs);
      if (this.Fbd != null)
      {
        paramVarArgs.ln(2, this.Fbd.computeSize());
        this.Fbd.writeFields(paramVarArgs);
      }
      if (this.DXX != null) {
        paramVarArgs.d(3, this.DXX);
      }
      if (this.Etm != null) {
        paramVarArgs.d(4, this.Etm);
      }
      if (this.ncR != null) {
        paramVarArgs.d(5, this.ncR);
      }
      paramVarArgs.aR(6, this.Fbe);
      AppMethodBeat.o(155423);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.pAs) + 0;
      paramInt = i;
      if (this.Fbd != null) {
        paramInt = i + f.a.a.a.lm(2, this.Fbd.computeSize());
      }
      i = paramInt;
      if (this.DXX != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DXX);
      }
      paramInt = i;
      if (this.Etm != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Etm);
      }
      i = paramInt;
      if (this.ncR != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ncR);
      }
      paramInt = f.a.a.b.b.a.bx(6, this.Fbe);
      AppMethodBeat.o(155423);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.Fbd == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(155423);
        throw paramVarArgs;
      }
      AppMethodBeat.o(155423);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      blo localblo = (blo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(155423);
        return -1;
      case 1: 
        localblo.pAs = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(155423);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localblo.Fbd = ((crm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155423);
        return 0;
      case 3: 
        localblo.DXX = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(155423);
        return 0;
      case 4: 
        localblo.Etm = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(155423);
        return 0;
      case 5: 
        localblo.ncR = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(155423);
        return 0;
      }
      localblo.Fbe = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(155423);
      return 0;
    }
    AppMethodBeat.o(155423);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blo
 * JD-Core Version:    0.7.0.1
 */