package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eng
  extends com.tencent.mm.bx.a
{
  public amn abrK;
  public String abrL;
  public String abrM;
  public int emoji_from;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104830);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abrK != null)
      {
        paramVarArgs.qD(1, this.abrK.computeSize());
        this.abrK.writeFields(paramVarArgs);
      }
      if (this.abrL != null) {
        paramVarArgs.g(2, this.abrL);
      }
      paramVarArgs.bS(3, this.type);
      if (this.abrM != null) {
        paramVarArgs.g(4, this.abrM);
      }
      paramVarArgs.bS(5, this.emoji_from);
      AppMethodBeat.o(104830);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abrK == null) {
        break label492;
      }
    }
    label492:
    for (paramInt = i.a.a.a.qC(1, this.abrK.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abrL != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abrL);
      }
      i += i.a.a.b.b.a.cJ(3, this.type);
      paramInt = i;
      if (this.abrM != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abrM);
      }
      i = i.a.a.b.b.a.cJ(5, this.emoji_from);
      AppMethodBeat.o(104830);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(104830);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eng localeng = (eng)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104830);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            amn localamn = new amn();
            if ((localObject != null) && (localObject.length > 0)) {
              localamn.parseFrom((byte[])localObject);
            }
            localeng.abrK = localamn;
            paramInt += 1;
          }
          AppMethodBeat.o(104830);
          return 0;
        case 2: 
          localeng.abrL = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(104830);
          return 0;
        case 3: 
          localeng.type = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(104830);
          return 0;
        case 4: 
          localeng.abrM = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(104830);
          return 0;
        }
        localeng.emoji_from = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(104830);
        return 0;
      }
      AppMethodBeat.o(104830);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eng
 * JD-Core Version:    0.7.0.1
 */