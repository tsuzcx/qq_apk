package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aex
  extends com.tencent.mm.cd.a
{
  public cvn Srn;
  public duz Sro;
  public duz Srp;
  public duz Srq;
  public duz Srr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(255076);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Srn != null)
      {
        paramVarArgs.oE(1, this.Srn.computeSize());
        this.Srn.writeFields(paramVarArgs);
      }
      if (this.Sro != null)
      {
        paramVarArgs.oE(2, this.Sro.computeSize());
        this.Sro.writeFields(paramVarArgs);
      }
      if (this.Srp != null)
      {
        paramVarArgs.oE(3, this.Srp.computeSize());
        this.Srp.writeFields(paramVarArgs);
      }
      if (this.Srq != null)
      {
        paramVarArgs.oE(4, this.Srq.computeSize());
        this.Srq.writeFields(paramVarArgs);
      }
      if (this.Srr != null)
      {
        paramVarArgs.oE(5, this.Srr.computeSize());
        this.Srr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(255076);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Srn == null) {
        break label816;
      }
    }
    label816:
    for (int i = g.a.a.a.oD(1, this.Srn.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Sro != null) {
        paramInt = i + g.a.a.a.oD(2, this.Sro.computeSize());
      }
      i = paramInt;
      if (this.Srp != null) {
        i = paramInt + g.a.a.a.oD(3, this.Srp.computeSize());
      }
      paramInt = i;
      if (this.Srq != null) {
        paramInt = i + g.a.a.a.oD(4, this.Srq.computeSize());
      }
      i = paramInt;
      if (this.Srr != null) {
        i = paramInt + g.a.a.a.oD(5, this.Srr.computeSize());
      }
      AppMethodBeat.o(255076);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(255076);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aex localaex = (aex)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(255076);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cvn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cvn)localObject2).parseFrom((byte[])localObject1);
            }
            localaex.Srn = ((cvn)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(255076);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new duz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((duz)localObject2).parseFrom((byte[])localObject1);
            }
            localaex.Sro = ((duz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(255076);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new duz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((duz)localObject2).parseFrom((byte[])localObject1);
            }
            localaex.Srp = ((duz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(255076);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new duz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((duz)localObject2).parseFrom((byte[])localObject1);
            }
            localaex.Srq = ((duz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(255076);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new duz();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((duz)localObject2).parseFrom((byte[])localObject1);
          }
          localaex.Srr = ((duz)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(255076);
        return 0;
      }
      AppMethodBeat.o(255076);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aex
 * JD-Core Version:    0.7.0.1
 */