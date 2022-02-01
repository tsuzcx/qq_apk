package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class vs
  extends com.tencent.mm.bx.a
{
  public String ZbR;
  public String ZbS;
  public String ZbT;
  public int ZbU;
  public wg ZbV;
  public int ZbW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113950);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZbR != null) {
        paramVarArgs.g(1, this.ZbR);
      }
      if (this.ZbS != null) {
        paramVarArgs.g(2, this.ZbS);
      }
      if (this.ZbT != null) {
        paramVarArgs.g(3, this.ZbT);
      }
      paramVarArgs.bS(4, this.ZbU);
      if (this.ZbV != null)
      {
        paramVarArgs.qD(5, this.ZbV.computeSize());
        this.ZbV.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(6, this.ZbW);
      AppMethodBeat.o(113950);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZbR == null) {
        break label556;
      }
    }
    label556:
    for (int i = i.a.a.b.b.a.h(1, this.ZbR) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZbS != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZbS);
      }
      i = paramInt;
      if (this.ZbT != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZbT);
      }
      i += i.a.a.b.b.a.cJ(4, this.ZbU);
      paramInt = i;
      if (this.ZbV != null) {
        paramInt = i + i.a.a.a.qC(5, this.ZbV.computeSize());
      }
      i = i.a.a.b.b.a.cJ(6, this.ZbW);
      AppMethodBeat.o(113950);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(113950);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        vs localvs = (vs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113950);
          return -1;
        case 1: 
          localvs.ZbR = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(113950);
          return 0;
        case 2: 
          localvs.ZbS = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(113950);
          return 0;
        case 3: 
          localvs.ZbT = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(113950);
          return 0;
        case 4: 
          localvs.ZbU = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(113950);
          return 0;
        case 5: 
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
            localvs.ZbV = localwg;
            paramInt += 1;
          }
          AppMethodBeat.o(113950);
          return 0;
        }
        localvs.ZbW = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(113950);
        return 0;
      }
      AppMethodBeat.o(113950);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vs
 * JD-Core Version:    0.7.0.1
 */