package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class alk
  extends com.tencent.mm.bw.a
{
  public int Dqm;
  public String GDC;
  public String GDD;
  public all field_area_info;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72475);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Dqm);
      if (this.field_area_info != null)
      {
        paramVarArgs.lJ(2, this.field_area_info.computeSize());
        this.field_area_info.writeFields(paramVarArgs);
      }
      if (this.GDC != null) {
        paramVarArgs.d(3, this.GDC);
      }
      if (this.GDD != null) {
        paramVarArgs.d(4, this.GDD);
      }
      AppMethodBeat.o(72475);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Dqm) + 0;
      paramInt = i;
      if (this.field_area_info != null) {
        paramInt = i + f.a.a.a.lI(2, this.field_area_info.computeSize());
      }
      i = paramInt;
      if (this.GDC != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GDC);
      }
      paramInt = i;
      if (this.GDD != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GDD);
      }
      AppMethodBeat.o(72475);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(72475);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      alk localalk = (alk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(72475);
        return -1;
      case 1: 
        localalk.Dqm = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(72475);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new all();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((all)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localalk.field_area_info = ((all)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72475);
        return 0;
      case 3: 
        localalk.GDC = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(72475);
        return 0;
      }
      localalk.GDD = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(72475);
      return 0;
    }
    AppMethodBeat.o(72475);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alk
 * JD-Core Version:    0.7.0.1
 */