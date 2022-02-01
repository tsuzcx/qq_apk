package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ast
  extends com.tencent.mm.bx.a
{
  public int VHu;
  public String ZCW;
  public String ZCX;
  public asu field_area_info;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72475);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.VHu);
      if (this.field_area_info != null)
      {
        paramVarArgs.qD(2, this.field_area_info.computeSize());
        this.field_area_info.writeFields(paramVarArgs);
      }
      if (this.ZCW != null) {
        paramVarArgs.g(3, this.ZCW);
      }
      if (this.ZCX != null) {
        paramVarArgs.g(4, this.ZCX);
      }
      AppMethodBeat.o(72475);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.VHu) + 0;
      paramInt = i;
      if (this.field_area_info != null) {
        paramInt = i + i.a.a.a.qC(2, this.field_area_info.computeSize());
      }
      i = paramInt;
      if (this.ZCW != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZCW);
      }
      paramInt = i;
      if (this.ZCX != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZCX);
      }
      AppMethodBeat.o(72475);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(72475);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      ast localast = (ast)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(72475);
        return -1;
      case 1: 
        localast.VHu = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(72475);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          asu localasu = new asu();
          if ((localObject != null) && (localObject.length > 0)) {
            localasu.parseFrom((byte[])localObject);
          }
          localast.field_area_info = localasu;
          paramInt += 1;
        }
        AppMethodBeat.o(72475);
        return 0;
      case 3: 
        localast.ZCW = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(72475);
        return 0;
      }
      localast.ZCX = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(72475);
      return 0;
    }
    AppMethodBeat.o(72475);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ast
 * JD-Core Version:    0.7.0.1
 */