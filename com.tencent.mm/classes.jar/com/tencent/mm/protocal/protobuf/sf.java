package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class sf
  extends com.tencent.mm.cd.a
{
  public String RIf;
  public String SbE;
  public b SbF;
  public sg SbG;
  public se SbH;
  public sh SbI;
  public sd SbJ;
  public String cli_msg_id;
  public String from_username;
  public int msg_type;
  public String sWA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(247690);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.msg_type);
      if (this.from_username != null) {
        paramVarArgs.f(2, this.from_username);
      }
      if (this.sWA != null) {
        paramVarArgs.f(3, this.sWA);
      }
      if (this.cli_msg_id != null) {
        paramVarArgs.f(4, this.cli_msg_id);
      }
      if (this.SbE != null) {
        paramVarArgs.f(5, this.SbE);
      }
      if (this.SbF != null) {
        paramVarArgs.c(6, this.SbF);
      }
      if (this.RIf != null) {
        paramVarArgs.f(7, this.RIf);
      }
      if (this.SbG != null)
      {
        paramVarArgs.oE(101, this.SbG.computeSize());
        this.SbG.writeFields(paramVarArgs);
      }
      if (this.SbH != null)
      {
        paramVarArgs.oE(102, this.SbH.computeSize());
        this.SbH.writeFields(paramVarArgs);
      }
      if (this.SbI != null)
      {
        paramVarArgs.oE(103, this.SbI.computeSize());
        this.SbI.writeFields(paramVarArgs);
      }
      if (this.SbJ != null)
      {
        paramVarArgs.oE(107, this.SbJ.computeSize());
        this.SbJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(247690);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.msg_type) + 0;
      paramInt = i;
      if (this.from_username != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.from_username);
      }
      i = paramInt;
      if (this.sWA != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.sWA);
      }
      paramInt = i;
      if (this.cli_msg_id != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.cli_msg_id);
      }
      i = paramInt;
      if (this.SbE != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.SbE);
      }
      paramInt = i;
      if (this.SbF != null) {
        paramInt = i + g.a.a.b.b.a.b(6, this.SbF);
      }
      i = paramInt;
      if (this.RIf != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.RIf);
      }
      paramInt = i;
      if (this.SbG != null) {
        paramInt = i + g.a.a.a.oD(101, this.SbG.computeSize());
      }
      i = paramInt;
      if (this.SbH != null) {
        i = paramInt + g.a.a.a.oD(102, this.SbH.computeSize());
      }
      paramInt = i;
      if (this.SbI != null) {
        paramInt = i + g.a.a.a.oD(103, this.SbI.computeSize());
      }
      i = paramInt;
      if (this.SbJ != null) {
        i = paramInt + g.a.a.a.oD(107, this.SbJ.computeSize());
      }
      AppMethodBeat.o(247690);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(247690);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      sf localsf = (sf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(247690);
        return -1;
      case 1: 
        localsf.msg_type = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(247690);
        return 0;
      case 2: 
        localsf.from_username = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(247690);
        return 0;
      case 3: 
        localsf.sWA = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(247690);
        return 0;
      case 4: 
        localsf.cli_msg_id = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(247690);
        return 0;
      case 5: 
        localsf.SbE = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(247690);
        return 0;
      case 6: 
        localsf.SbF = ((g.a.a.a.a)localObject1).abFh.iUw();
        AppMethodBeat.o(247690);
        return 0;
      case 7: 
        localsf.RIf = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(247690);
        return 0;
      case 101: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new sg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((sg)localObject2).parseFrom((byte[])localObject1);
          }
          localsf.SbG = ((sg)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(247690);
        return 0;
      case 102: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new se();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((se)localObject2).parseFrom((byte[])localObject1);
          }
          localsf.SbH = ((se)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(247690);
        return 0;
      case 103: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new sh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((sh)localObject2).parseFrom((byte[])localObject1);
          }
          localsf.SbI = ((sh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(247690);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new sd();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((sd)localObject2).parseFrom((byte[])localObject1);
        }
        localsf.SbJ = ((sd)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(247690);
      return 0;
    }
    AppMethodBeat.o(247690);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sf
 * JD-Core Version:    0.7.0.1
 */