package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class vx
  extends com.tencent.mm.bx.a
{
  public String ZcK;
  public int ZcL;
  public String ZcM;
  public wg ZcN;
  public String ZcO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113956);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZcK != null) {
        paramVarArgs.g(1, this.ZcK);
      }
      paramVarArgs.bS(2, this.ZcL);
      if (this.ZcM != null) {
        paramVarArgs.g(3, this.ZcM);
      }
      if (this.ZcN != null)
      {
        paramVarArgs.qD(4, this.ZcN.computeSize());
        this.ZcN.writeFields(paramVarArgs);
      }
      if (this.ZcO != null) {
        paramVarArgs.g(5, this.ZcO);
      }
      AppMethodBeat.o(113956);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZcK == null) {
        break label508;
      }
    }
    label508:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZcK) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.ZcL);
      paramInt = i;
      if (this.ZcM != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ZcM);
      }
      i = paramInt;
      if (this.ZcN != null) {
        i = paramInt + i.a.a.a.qC(4, this.ZcN.computeSize());
      }
      paramInt = i;
      if (this.ZcO != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ZcO);
      }
      AppMethodBeat.o(113956);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(113956);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        vx localvx = (vx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113956);
          return -1;
        case 1: 
          localvx.ZcK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(113956);
          return 0;
        case 2: 
          localvx.ZcL = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(113956);
          return 0;
        case 3: 
          localvx.ZcM = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(113956);
          return 0;
        case 4: 
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
            localvx.ZcN = localwg;
            paramInt += 1;
          }
          AppMethodBeat.o(113956);
          return 0;
        }
        localvx.ZcO = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(113956);
        return 0;
      }
      AppMethodBeat.o(113956);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vx
 * JD-Core Version:    0.7.0.1
 */