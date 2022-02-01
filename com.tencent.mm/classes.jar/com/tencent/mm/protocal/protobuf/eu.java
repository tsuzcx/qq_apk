package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eu
  extends com.tencent.mm.bx.a
{
  public dfc VXQ;
  public dfc VXR;
  public int YGL;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168752);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.wording != null) {
        paramVarArgs.g(1, this.wording);
      }
      if (this.VXQ != null)
      {
        paramVarArgs.qD(2, this.VXQ.computeSize());
        this.VXQ.writeFields(paramVarArgs);
      }
      if (this.VXR != null)
      {
        paramVarArgs.qD(3, this.VXR.computeSize());
        this.VXR.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.YGL);
      AppMethodBeat.o(168752);
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
      if (this.VXQ != null) {
        paramInt = i + i.a.a.a.qC(2, this.VXQ.computeSize());
      }
      i = paramInt;
      if (this.VXR != null) {
        i = paramInt + i.a.a.a.qC(3, this.VXR.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.YGL);
      AppMethodBeat.o(168752);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(168752);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eu localeu = (eu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        dfc localdfc;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168752);
          return -1;
        case 1: 
          localeu.wording = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(168752);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localdfc = new dfc();
            if ((localObject != null) && (localObject.length > 0)) {
              localdfc.parseFrom((byte[])localObject);
            }
            localeu.VXQ = localdfc;
            paramInt += 1;
          }
          AppMethodBeat.o(168752);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localdfc = new dfc();
            if ((localObject != null) && (localObject.length > 0)) {
              localdfc.parseFrom((byte[])localObject);
            }
            localeu.VXR = localdfc;
            paramInt += 1;
          }
          AppMethodBeat.o(168752);
          return 0;
        }
        localeu.YGL = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(168752);
        return 0;
      }
      AppMethodBeat.o(168752);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eu
 * JD-Core Version:    0.7.0.1
 */