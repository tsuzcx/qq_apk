package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class apa
  extends com.tencent.mm.cd.a
{
  public int ORA;
  public String SCe;
  public String SCf;
  public apb field_area_info;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72475);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.ORA);
      if (this.field_area_info != null)
      {
        paramVarArgs.oE(2, this.field_area_info.computeSize());
        this.field_area_info.writeFields(paramVarArgs);
      }
      if (this.SCe != null) {
        paramVarArgs.f(3, this.SCe);
      }
      if (this.SCf != null) {
        paramVarArgs.f(4, this.SCf);
      }
      AppMethodBeat.o(72475);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.ORA) + 0;
      paramInt = i;
      if (this.field_area_info != null) {
        paramInt = i + g.a.a.a.oD(2, this.field_area_info.computeSize());
      }
      i = paramInt;
      if (this.SCe != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SCe);
      }
      paramInt = i;
      if (this.SCf != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SCf);
      }
      AppMethodBeat.o(72475);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(72475);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      apa localapa = (apa)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(72475);
        return -1;
      case 1: 
        localapa.ORA = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(72475);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          apb localapb = new apb();
          if ((localObject != null) && (localObject.length > 0)) {
            localapb.parseFrom((byte[])localObject);
          }
          localapa.field_area_info = localapb;
          paramInt += 1;
        }
        AppMethodBeat.o(72475);
        return 0;
      case 3: 
        localapa.SCe = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(72475);
        return 0;
      }
      localapa.SCf = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(72475);
      return 0;
    }
    AppMethodBeat.o(72475);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apa
 * JD-Core Version:    0.7.0.1
 */