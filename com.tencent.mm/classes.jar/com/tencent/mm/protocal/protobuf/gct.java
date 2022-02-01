package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gct
  extends com.tencent.mm.bx.a
{
  public gcp acaK;
  public gcf acaL;
  public String acaM;
  public String acaN;
  public String acaO;
  public int acaP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147809);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.acaK != null)
      {
        paramVarArgs.qD(1, this.acaK.computeSize());
        this.acaK.writeFields(paramVarArgs);
      }
      if (this.acaL != null)
      {
        paramVarArgs.qD(2, this.acaL.computeSize());
        this.acaL.writeFields(paramVarArgs);
      }
      if (this.acaM != null) {
        paramVarArgs.g(3, this.acaM);
      }
      if (this.acaN != null) {
        paramVarArgs.g(4, this.acaN);
      }
      if (this.acaO != null) {
        paramVarArgs.g(5, this.acaO);
      }
      paramVarArgs.bS(6, this.acaP);
      AppMethodBeat.o(147809);
      return 0;
    }
    if (paramInt == 1) {
      if (this.acaK == null) {
        break label642;
      }
    }
    label642:
    for (int i = i.a.a.a.qC(1, this.acaK.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.acaL != null) {
        paramInt = i + i.a.a.a.qC(2, this.acaL.computeSize());
      }
      i = paramInt;
      if (this.acaM != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.acaM);
      }
      paramInt = i;
      if (this.acaN != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.acaN);
      }
      i = paramInt;
      if (this.acaO != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.acaO);
      }
      paramInt = i.a.a.b.b.a.cJ(6, this.acaP);
      AppMethodBeat.o(147809);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(147809);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        gct localgct = (gct)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147809);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gcp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gcp)localObject2).parseFrom((byte[])localObject1);
            }
            localgct.acaK = ((gcp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(147809);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gcf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gcf)localObject2).parseFrom((byte[])localObject1);
            }
            localgct.acaL = ((gcf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(147809);
          return 0;
        case 3: 
          localgct.acaM = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(147809);
          return 0;
        case 4: 
          localgct.acaN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(147809);
          return 0;
        case 5: 
          localgct.acaO = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(147809);
          return 0;
        }
        localgct.acaP = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(147809);
        return 0;
      }
      AppMethodBeat.o(147809);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gct
 * JD-Core Version:    0.7.0.1
 */