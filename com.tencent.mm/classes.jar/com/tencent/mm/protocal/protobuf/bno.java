package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bno
  extends com.tencent.mm.bw.a
{
  public boolean Fdo;
  public cnk Fdp;
  public String dlQ;
  public String title;
  public String unW;
  public String unX;
  public int vjP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91528);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.vjP);
      paramVarArgs.bl(2, this.Fdo);
      if (this.dlQ != null) {
        paramVarArgs.d(3, this.dlQ);
      }
      if (this.unW != null) {
        paramVarArgs.d(4, this.unW);
      }
      if (this.unX != null) {
        paramVarArgs.d(5, this.unX);
      }
      if (this.Fdp != null)
      {
        paramVarArgs.ln(6, this.Fdp.computeSize());
        this.Fdp.writeFields(paramVarArgs);
      }
      if (this.title != null) {
        paramVarArgs.d(7, this.title);
      }
      AppMethodBeat.o(91528);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.vjP) + 0 + (f.a.a.b.b.a.fK(2) + 1);
      paramInt = i;
      if (this.dlQ != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dlQ);
      }
      i = paramInt;
      if (this.unW != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.unW);
      }
      paramInt = i;
      if (this.unX != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.unX);
      }
      i = paramInt;
      if (this.Fdp != null) {
        i = paramInt + f.a.a.a.lm(6, this.Fdp.computeSize());
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.title);
      }
      AppMethodBeat.o(91528);
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
      AppMethodBeat.o(91528);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bno localbno = (bno)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91528);
        return -1;
      case 1: 
        localbno.vjP = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91528);
        return 0;
      case 2: 
        localbno.Fdo = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(91528);
        return 0;
      case 3: 
        localbno.dlQ = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91528);
        return 0;
      case 4: 
        localbno.unW = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91528);
        return 0;
      case 5: 
        localbno.unX = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91528);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cnk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cnk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbno.Fdp = ((cnk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91528);
        return 0;
      }
      localbno.title = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(91528);
      return 0;
    }
    AppMethodBeat.o(91528);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bno
 * JD-Core Version:    0.7.0.1
 */