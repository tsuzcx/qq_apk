package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class iq
  extends com.tencent.mm.cd.a
{
  public ddq ROr;
  public ddq ROs;
  public ddq ROt;
  public ddq ROu;
  public int ROv;
  public int ROw;
  public int ROx;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118406);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.type);
      if (this.ROr != null)
      {
        paramVarArgs.oE(2, this.ROr.computeSize());
        this.ROr.writeFields(paramVarArgs);
      }
      if (this.ROs != null)
      {
        paramVarArgs.oE(3, this.ROs.computeSize());
        this.ROs.writeFields(paramVarArgs);
      }
      if (this.ROt != null)
      {
        paramVarArgs.oE(4, this.ROt.computeSize());
        this.ROt.writeFields(paramVarArgs);
      }
      if (this.ROu != null)
      {
        paramVarArgs.oE(11, this.ROu.computeSize());
        this.ROu.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(100, this.ROv);
      paramVarArgs.aY(101, this.ROw);
      paramVarArgs.aY(102, this.ROx);
      AppMethodBeat.o(118406);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.type) + 0;
      paramInt = i;
      if (this.ROr != null) {
        paramInt = i + g.a.a.a.oD(2, this.ROr.computeSize());
      }
      i = paramInt;
      if (this.ROs != null) {
        i = paramInt + g.a.a.a.oD(3, this.ROs.computeSize());
      }
      paramInt = i;
      if (this.ROt != null) {
        paramInt = i + g.a.a.a.oD(4, this.ROt.computeSize());
      }
      i = paramInt;
      if (this.ROu != null) {
        i = paramInt + g.a.a.a.oD(11, this.ROu.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(100, this.ROv);
      int j = g.a.a.b.b.a.bM(101, this.ROw);
      int k = g.a.a.b.b.a.bM(102, this.ROx);
      AppMethodBeat.o(118406);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(118406);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      iq localiq = (iq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      ddq localddq;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118406);
        return -1;
      case 1: 
        localiq.type = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(118406);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localddq = new ddq();
          if ((localObject != null) && (localObject.length > 0)) {
            localddq.parseFrom((byte[])localObject);
          }
          localiq.ROr = localddq;
          paramInt += 1;
        }
        AppMethodBeat.o(118406);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localddq = new ddq();
          if ((localObject != null) && (localObject.length > 0)) {
            localddq.parseFrom((byte[])localObject);
          }
          localiq.ROs = localddq;
          paramInt += 1;
        }
        AppMethodBeat.o(118406);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localddq = new ddq();
          if ((localObject != null) && (localObject.length > 0)) {
            localddq.parseFrom((byte[])localObject);
          }
          localiq.ROt = localddq;
          paramInt += 1;
        }
        AppMethodBeat.o(118406);
        return 0;
      case 11: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localddq = new ddq();
          if ((localObject != null) && (localObject.length > 0)) {
            localddq.parseFrom((byte[])localObject);
          }
          localiq.ROu = localddq;
          paramInt += 1;
        }
        AppMethodBeat.o(118406);
        return 0;
      case 100: 
        localiq.ROv = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(118406);
        return 0;
      case 101: 
        localiq.ROw = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(118406);
        return 0;
      }
      localiq.ROx = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(118406);
      return 0;
    }
    AppMethodBeat.o(118406);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.iq
 * JD-Core Version:    0.7.0.1
 */