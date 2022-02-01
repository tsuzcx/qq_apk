package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class rd
  extends com.tencent.mm.bx.a
{
  public String YVX;
  public int YVY;
  public String YVZ;
  public int YWa;
  public LinkedList<oa> YWb;
  
  public rd()
  {
    AppMethodBeat.i(152509);
    this.YWb = new LinkedList();
    AppMethodBeat.o(152509);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152510);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YVX != null) {
        paramVarArgs.g(1, this.YVX);
      }
      paramVarArgs.bS(2, this.YVY);
      if (this.YVZ != null) {
        paramVarArgs.g(3, this.YVZ);
      }
      paramVarArgs.bS(4, this.YWa);
      paramVarArgs.e(5, 8, this.YWb);
      AppMethodBeat.o(152510);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YVX == null) {
        break label484;
      }
    }
    label484:
    for (paramInt = i.a.a.b.b.a.h(1, this.YVX) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YVY);
      paramInt = i;
      if (this.YVZ != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.YVZ);
      }
      i = i.a.a.b.b.a.cJ(4, this.YWa);
      int j = i.a.a.a.c(5, 8, this.YWb);
      AppMethodBeat.o(152510);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YWb.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152510);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        rd localrd = (rd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152510);
          return -1;
        case 1: 
          localrd.YVX = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152510);
          return 0;
        case 2: 
          localrd.YVY = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(152510);
          return 0;
        case 3: 
          localrd.YVZ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152510);
          return 0;
        case 4: 
          localrd.YWa = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(152510);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          oa localoa = new oa();
          if ((localObject != null) && (localObject.length > 0)) {
            localoa.parseFrom((byte[])localObject);
          }
          localrd.YWb.add(localoa);
          paramInt += 1;
        }
        AppMethodBeat.o(152510);
        return 0;
      }
      AppMethodBeat.o(152510);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rd
 * JD-Core Version:    0.7.0.1
 */