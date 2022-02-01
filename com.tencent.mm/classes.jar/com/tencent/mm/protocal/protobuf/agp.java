package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class agp
  extends com.tencent.mm.bx.a
{
  public eje ZpM;
  public eje ZpN;
  public int ZpO;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259443);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.wording != null) {
        paramVarArgs.g(1, this.wording);
      }
      if (this.ZpM != null)
      {
        paramVarArgs.qD(2, this.ZpM.computeSize());
        this.ZpM.writeFields(paramVarArgs);
      }
      if (this.ZpN != null)
      {
        paramVarArgs.qD(3, this.ZpN.computeSize());
        this.ZpN.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.ZpO);
      AppMethodBeat.o(259443);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wording == null) {
        break label522;
      }
    }
    label522:
    for (int i = i.a.a.b.b.a.h(1, this.wording) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZpM != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZpM.computeSize());
      }
      i = paramInt;
      if (this.ZpN != null) {
        i = paramInt + i.a.a.a.qC(3, this.ZpN.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.ZpO);
      AppMethodBeat.o(259443);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259443);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        agp localagp = (agp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        eje localeje;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259443);
          return -1;
        case 1: 
          localagp.wording = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259443);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localeje = new eje();
            if ((localObject != null) && (localObject.length > 0)) {
              localeje.parseFrom((byte[])localObject);
            }
            localagp.ZpM = localeje;
            paramInt += 1;
          }
          AppMethodBeat.o(259443);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localeje = new eje();
            if ((localObject != null) && (localObject.length > 0)) {
              localeje.parseFrom((byte[])localObject);
            }
            localagp.ZpN = localeje;
            paramInt += 1;
          }
          AppMethodBeat.o(259443);
          return 0;
        }
        localagp.ZpO = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259443);
        return 0;
      }
      AppMethodBeat.o(259443);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agp
 * JD-Core Version:    0.7.0.1
 */