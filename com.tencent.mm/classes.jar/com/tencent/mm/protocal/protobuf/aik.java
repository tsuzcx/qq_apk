package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aik
  extends com.tencent.mm.bw.a
{
  public int Byo;
  public String EDi;
  public String EDj;
  public ail field_area_info;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72475);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Byo);
      if (this.field_area_info != null)
      {
        paramVarArgs.ln(2, this.field_area_info.computeSize());
        this.field_area_info.writeFields(paramVarArgs);
      }
      if (this.EDi != null) {
        paramVarArgs.d(3, this.EDi);
      }
      if (this.EDj != null) {
        paramVarArgs.d(4, this.EDj);
      }
      AppMethodBeat.o(72475);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.Byo) + 0;
      paramInt = i;
      if (this.field_area_info != null) {
        paramInt = i + f.a.a.a.lm(2, this.field_area_info.computeSize());
      }
      i = paramInt;
      if (this.EDi != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EDi);
      }
      paramInt = i;
      if (this.EDj != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EDj);
      }
      AppMethodBeat.o(72475);
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
      AppMethodBeat.o(72475);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      aik localaik = (aik)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(72475);
        return -1;
      case 1: 
        localaik.Byo = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(72475);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ail();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ail)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaik.field_area_info = ((ail)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72475);
        return 0;
      case 3: 
        localaik.EDi = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(72475);
        return 0;
      }
      localaik.EDj = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(72475);
      return 0;
    }
    AppMethodBeat.o(72475);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aik
 * JD-Core Version:    0.7.0.1
 */