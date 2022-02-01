package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aed
  extends com.tencent.mm.cd.a
{
  public dqj SqL;
  public dqj SqM;
  public int SqN;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(250194);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.wording != null) {
        paramVarArgs.f(1, this.wording);
      }
      if (this.SqL != null)
      {
        paramVarArgs.oE(2, this.SqL.computeSize());
        this.SqL.writeFields(paramVarArgs);
      }
      if (this.SqM != null)
      {
        paramVarArgs.oE(3, this.SqM.computeSize());
        this.SqM.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(4, this.SqN);
      AppMethodBeat.o(250194);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wording == null) {
        break label526;
      }
    }
    label526:
    for (int i = g.a.a.b.b.a.g(1, this.wording) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SqL != null) {
        paramInt = i + g.a.a.a.oD(2, this.SqL.computeSize());
      }
      i = paramInt;
      if (this.SqM != null) {
        i = paramInt + g.a.a.a.oD(3, this.SqM.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(4, this.SqN);
      AppMethodBeat.o(250194);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(250194);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        aed localaed = (aed)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        dqj localdqj;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(250194);
          return -1;
        case 1: 
          localaed.wording = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(250194);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localdqj = new dqj();
            if ((localObject != null) && (localObject.length > 0)) {
              localdqj.parseFrom((byte[])localObject);
            }
            localaed.SqL = localdqj;
            paramInt += 1;
          }
          AppMethodBeat.o(250194);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localdqj = new dqj();
            if ((localObject != null) && (localObject.length > 0)) {
              localdqj.parseFrom((byte[])localObject);
            }
            localaed.SqM = localdqj;
            paramInt += 1;
          }
          AppMethodBeat.o(250194);
          return 0;
        }
        localaed.SqN = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(250194);
        return 0;
      }
      AppMethodBeat.o(250194);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aed
 * JD-Core Version:    0.7.0.1
 */