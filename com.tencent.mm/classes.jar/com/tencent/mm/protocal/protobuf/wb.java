package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class wb
  extends com.tencent.mm.bx.a
{
  public String ZcR;
  public String ZcS;
  public String ZcT;
  public int ZcU;
  public String ZcV;
  public wg ZcW;
  public String ZcX;
  public int ZcY;
  public int ZcZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113959);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZcR != null) {
        paramVarArgs.g(1, this.ZcR);
      }
      if (this.ZcS != null) {
        paramVarArgs.g(2, this.ZcS);
      }
      if (this.ZcT != null) {
        paramVarArgs.g(3, this.ZcT);
      }
      paramVarArgs.bS(4, this.ZcU);
      if (this.ZcV != null) {
        paramVarArgs.g(5, this.ZcV);
      }
      if (this.ZcW != null)
      {
        paramVarArgs.qD(6, this.ZcW.computeSize());
        this.ZcW.writeFields(paramVarArgs);
      }
      if (this.ZcX != null) {
        paramVarArgs.g(7, this.ZcX);
      }
      paramVarArgs.bS(8, this.ZcY);
      paramVarArgs.bS(9, this.ZcZ);
      AppMethodBeat.o(113959);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZcR == null) {
        break label728;
      }
    }
    label728:
    for (int i = i.a.a.b.b.a.h(1, this.ZcR) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZcS != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZcS);
      }
      i = paramInt;
      if (this.ZcT != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZcT);
      }
      i += i.a.a.b.b.a.cJ(4, this.ZcU);
      paramInt = i;
      if (this.ZcV != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ZcV);
      }
      i = paramInt;
      if (this.ZcW != null) {
        i = paramInt + i.a.a.a.qC(6, this.ZcW.computeSize());
      }
      paramInt = i;
      if (this.ZcX != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.ZcX);
      }
      i = i.a.a.b.b.a.cJ(8, this.ZcY);
      int j = i.a.a.b.b.a.cJ(9, this.ZcZ);
      AppMethodBeat.o(113959);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(113959);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        wb localwb = (wb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113959);
          return -1;
        case 1: 
          localwb.ZcR = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(113959);
          return 0;
        case 2: 
          localwb.ZcS = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(113959);
          return 0;
        case 3: 
          localwb.ZcT = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(113959);
          return 0;
        case 4: 
          localwb.ZcU = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(113959);
          return 0;
        case 5: 
          localwb.ZcV = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(113959);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            wg localwg = new wg();
            if ((localObject != null) && (localObject.length > 0)) {
              localwg.parseFrom((byte[])localObject);
            }
            localwb.ZcW = localwg;
            paramInt += 1;
          }
          AppMethodBeat.o(113959);
          return 0;
        case 7: 
          localwb.ZcX = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(113959);
          return 0;
        case 8: 
          localwb.ZcY = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(113959);
          return 0;
        }
        localwb.ZcZ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(113959);
        return 0;
      }
      AppMethodBeat.o(113959);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wb
 * JD-Core Version:    0.7.0.1
 */